package com.example.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

// Импорт твоего кастомного эффекта
import com.example.effect.ModEffects;

public class RustyRobotEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState rageAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public RustyRobotEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private final ServerBossBar bossBar = new ServerBossBar(
            Text.literal("Rusty Robot"),
            BossBar.Color.BLUE,
            BossBar.Style.NOTCHED_10
    );

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(2, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new MeleeAttackGoal(this, 1.2D, true));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    private boolean raging = false;

    public boolean isRaging() {
        return raging;
    }

    public void setRaging(boolean raging) {
        this.raging = raging;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    // ==============================================
    // МЕТОД АТАКИ С НАЛОЖЕНИЕМ КАСТОМНОГО ЭФФЕКТА
    // ==============================================
    @Override
    public boolean tryAttack(Entity target) {
        // Наносим стандартный урон (используется атрибут GENERIC_ATTACK_DAMAGE)
        boolean success = super.tryAttack(target);

        if (success && target instanceof LivingEntity livingTarget) {
            int duration = 200;   // 10 секунд по умолчанию
            int amplifier = 0;    // уровень 1

            // В режиме ярости — эффект дольше и сильнее
            if (this.isRaging()) {
                duration = 400;   // 20 секунд
                amplifier = 1;    // уровень 2
            }

            // Ключевой момент: используем .builtInRegistryHolder() для совместимости
            livingTarget.addStatusEffect(new StatusEffectInstance(
                    Registries.STATUS_EFFECT.getEntry(ModEffects.RUSTY),
                    duration,
                    amplifier,
                    false,  // ambient — слабые частицы (как от маяка)
                    true,   // showParticles — показывать частицы эффекта
                    true    // showIcon — показывать иконку в инвентаре/HUD
            ));
        }

        return success;
    }
}