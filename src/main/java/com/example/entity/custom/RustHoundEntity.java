package com.example.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RustHoundEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState runAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;
    private int attackAnimationTimeout = 0;

    public RustHoundEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, true) {
            @Override
            public boolean canStart() {
                return super.canStart() && RustHoundEntity.this.canAttackTarget(this.mob.getTarget());
            }

            @Override
            public void start() {
                super.start();
                RustHoundEntity.this.triggerAttackAnimation();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.add(3, new PounceAtTargetGoal(this, 0.4F));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.00));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, SheepEntity.class, false));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, RabbitEntity.class, false));
        this.targetSelector.add(8, new ActiveTargetGoal<>(this, FoxEntity.class, false));
        this.targetSelector.add(9, new ActiveTargetGoal<>(this, AbstractSkeletonEntity.class, false));
        this.targetSelector.add(10, new ActiveTargetGoal<>(this, CreeperEntity.class, false));
        this.targetSelector.add(11, new ActiveTargetGoal<>(this, GhastEntity.class, false));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

    public boolean canAttackTarget(LivingEntity target) {
        if (target == null) return false;

        if (target instanceof AbstractHorseEntity && ((AbstractHorseEntity)target).isTame()) {
            return false;
        }
        return !(target instanceof TameableEntity) || !((TameableEntity) target).isTamed();
    }

    public float getTailAngle() {
        return 1.5393804F;
    }

    public void triggerAttackAnimation() {
        if (!this.getWorld().isClient()) return;

        this.attackAnimationState.start(this.age);
        this.attackAnimationTimeout = 15;
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (!(target instanceof LivingEntity)) {
            return false;
        }

        // Проверяем, можно ли атаковать эту цель
        if (!canAttackTarget((LivingEntity)target)) {
            return false;
        }

        boolean attacked = super.tryAttack(target);
        if (attacked) {
            this.playSound(SoundEvents.ENTITY_WOLF_GROWL, 1.0F, 1.0F);
            this.triggerAttackAnimation();
        }
        return attacked;
    }

    private void setupAnimationStates() {
        if (this.attackAnimationTimeout > 0) {
            this.attackAnimationTimeout--;
        } else {
            this.attackAnimationState.stop();
        }

        if (this.isAttacking() && this.getVelocity().horizontalLengthSquared() > 1.0E-6) {
            this.runAnimationState.startIfNotRunning(this.age);
            this.walkAnimationState.stop();
            this.idleAnimationState.stop();
        }
        else if (this.getVelocity().horizontalLengthSquared() > 1.0E-6) {
            this.walkAnimationState.startIfNotRunning(this.age);
            this.runAnimationState.stop();
            this.idleAnimationState.stop();
        }
        // Анимация простоя
        else {
            this.idleAnimationState.startIfNotRunning(this.age);
            this.walkAnimationState.stop();
            this.runAnimationState.stop();
        }

        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    // Переопределяем метод для определения, атакует ли моб
    @Override
    public boolean isAttacking() {
        return this.getTarget() != null && this.canAttackTarget(this.getTarget());
    }

    // Звуки
    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WOLF_GROWL; // Всегда агрессивное ворчание
    }

    protected SoundEvent getAngrySound() {
        return SoundEvents.ENTITY_WOLF_GROWL;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_WOLF_STEP;
    }

    // Отключаем размножение
    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public boolean canBeTamed() {
        return false;
    }

    public boolean canBeSaddled() {
        return false;
    }
}