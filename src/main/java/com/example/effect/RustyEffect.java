package com.example.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;

public class RustyEffect extends StatusEffect {
    public RustyEffect() {
        super(StatusEffectCategory.HARMFUL, 0xA34929);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient() || !(entity instanceof PlayerEntity player)) {
            return false;
        }

        ItemStack mainHandStack = player.getMainHandStack();

        if (!mainHandStack.isEmpty() && mainHandStack.isDamageable()) {
            if (player.getWorld().getTime() % 40 == 0) {
                int damageAmount = amplifier + 1;

                int newDamage = mainHandStack.getDamage() + damageAmount;
                mainHandStack.setDamage(newDamage);

                // Проверяем, не сломался ли инструмент
                if (mainHandStack.getDamage() >= mainHandStack.getMaxDamage()) {
                    // Воспроизводим звук поломки
                    player.getWorld().playSound(null, player.getBlockPos(),
                            SoundEvents.ENTITY_ITEM_BREAK, player.getSoundCategory(), 1.0F, 1.0F);
                    // Удаляем сломанный инструмент
                    player.setStackInHand(player.getActiveHand(), ItemStack.EMPTY);
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Эффект будет применяться каждый тик (20 раз в секунду)
        return duration % 40 == 0;
    }
}