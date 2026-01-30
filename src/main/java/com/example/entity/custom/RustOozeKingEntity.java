package com.example.entity.custom;

import com.example.effect.ModEffects;
import com.example.entity.ModEntities;
import com.example.item.ModItems;
import net.minecraft.block.Portal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.variant;

public class RustOozeKingEntity extends AnimalEntity {
    private UUID ownerUuid;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState rageAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public RustOozeKingEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    private final ServerBossBar bossBar = new ServerBossBar(
            Text.literal("Rust Ooze King"),
            BossBar.Color.BLUE,
            BossBar.Style.NOTCHED_10
    );
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        if (!this.isBaby()) {
            this.bossBar.addPlayer(player);
        }
    }
    public void setOwner(PlayerEntity player) {
        this.ownerUuid = player.getUuid();
    }

    @Nullable
    public PlayerEntity getOwner() {
        if (ownerUuid == null) return null;
        return this.getWorld().getPlayerByUuid(ownerUuid);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        if (!this.isBaby()) {
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }
    }
    @Override
    protected void initGoals() {
        // Движение и базовое поведение
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2D, true) {
            @Override
            public boolean canStart() {
                return !RustOozeKingEntity.this.isBaby() && super.canStart();
            }
        });

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true) {
            @Override
            public boolean canStart() {
                return !RustOozeKingEntity.this.isBaby() && super.canStart();
            }
        });
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,70)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.1)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,10)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,20);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }
    private boolean raging = false; // по умолчанию нет ярости

    public boolean isRaging() {
        return raging;
    }

    public void setRaging(boolean raging) {
        this.raging = raging;
    }
    @Override
    public void tick() {
        super.tick();

        if (this.isBaby()) {
            this.bossBar.clearPlayers();
        }
        if (this.isBaby()) {
            this.setBreedingAge(-24000);
        }
        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
        PlayerEntity owner = getOwner();

        if (owner != null && this.isBaby()) {
            if (this.age % 20 == 0) {
                this.getNavigation().startMovingTo(owner, 2);
            }
            Vec3d ownerPos = owner.getPos();
            this.getLookControl().lookAt(ownerPos.x, ownerPos.y + owner.getStandingEyeHeight(), ownerPos.z);
            this.getLookControl().lookAt(
                    owner.getX(),
                    owner.getY() + owner.getStandingEyeHeight(),
                    owner.getZ()
            );

            if (this.distanceTo(owner) < 5) {
                owner.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.REGENERATION,
                        40,
                        0,
                        true,
                        false
                ));
            }
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.MONSTER_TREAT);
    }
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        RustOozeKingEntity baby = ModEntities.RUST_OOZE_KING.create(world);
        baby.setBreedingAge(-24000);
        PlayerEntity player = this.getLovingPlayer();

        if (player != null) {
            baby.setOwner(player);
        }
        return baby;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_STEP;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }
    @Override
    public boolean tryAttack(Entity target) {
        if (this.isBaby()) return false;
        boolean success = super.tryAttack(target);

        if (success && target instanceof LivingEntity livingTarget) {
            int duration = 200;
            int amplifier = 0;

            if (this.isRaging()) {
                duration = 400;
                amplifier = 1;
            }

            livingTarget.addStatusEffect(new StatusEffectInstance(
                    Registries.STATUS_EFFECT.getEntry(ModEffects.RUSTY),
                    duration,
                    amplifier,
                    false,
                    true,
                    true
            ));
        }

        return success;
    }
}