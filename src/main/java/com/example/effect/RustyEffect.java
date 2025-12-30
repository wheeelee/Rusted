package com.example.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvents;

public class RustyEffect extends StatusEffect {

    public RustyEffect() {
        super(StatusEffectCategory.HARMFUL, 0xA34929);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient() && entity instanceof PlayerEntity player) {
            int baseDamage = amplifier + 1;

            // ====== ПОРЧА БРОНИ ======
            for (ItemStack armorStack : player.getArmorItems()) {
                int damageAmount = baseDamage; // броня ломается стандартно
                damageItem(player, armorStack, damageAmount);
            }

            // ====== ПОРЧА ВСЕГО ИНВЕНТАРЯ ======
            for (int i = 0; i < player.getInventory().size(); i++) {
                ItemStack stack = player.getInventory().getStack(i);
                int damageAmount = 0;

                if (stack.isDamageable()) {
                    if (isVanillaTool(stack)) {
                        damageAmount = baseDamage * 2; // ванильные инструменты ломаются быстрее
                    } else {
                        // модовые инструменты ломаются медленно, не больше 1/10 от maxDamage за тик
                        damageAmount = Math.max(1, stack.getMaxDamage() / 10);
                    }
                }

                damageItem(player, stack, damageAmount);
            }
        }

        return true; // всегда true, чтобы иконка эффекта отображалась
    }

    private void damageItem(PlayerEntity player, ItemStack stack, int damageAmount) {
        if (stack.isEmpty() || !stack.isDamageable() || damageAmount <= 0) return;

        stack.setDamage(stack.getDamage() + damageAmount);

        if (stack.getDamage() >= stack.getMaxDamage()) {
            player.getWorld().playSound(
                    null,
                    player.getBlockPos(),
                    SoundEvents.ENTITY_ITEM_BREAK,
                    player.getSoundCategory(),
                    1.0F,
                    1.0F
            );
            stack.setCount(0);
        }
    }

    private boolean isVanillaTool(ItemStack stack) {
        if (stack.isEmpty() || !stack.isDamageable()) return false;
        Item item = stack.getItem();
        Identifier id = Registries.ITEM.getId(item);
        if (id == null) return false;

        return id.getNamespace().equals("minecraft") &&
                (id.getPath().contains("pickaxe") ||
                        id.getPath().contains("axe") ||
                        id.getPath().contains("shovel") ||
                        id.getPath().contains("hoe") ||
                        id.getPath().contains("sword"));
    }

    private boolean isVanillaArmor(ItemStack stack) {
        if (stack.isEmpty() || !stack.isDamageable()) return false;
        Item item = stack.getItem();
        Identifier id = Registries.ITEM.getId(item);
        if (id == null) return false;

        return id.getNamespace().equals("minecraft") &&
                (id.getPath().contains("helmet") ||
                        id.getPath().contains("chestplate") ||
                        id.getPath().contains("leggings") ||
                        id.getPath().contains("boots"));
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // наносим урон только каждые 20 тиков = 1 секунда
        return duration % 20 == 0;
    }
}
