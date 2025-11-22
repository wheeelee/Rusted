package com.example.rusted.datagen;

import com.example.Rusted;
import com.example.RustedDataGenerator;
import com.example.block.ModBlocks;
import com.example.effect.ModEffects;
import com.example.effect.RustyEffect;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.ModStatus;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        final RegistryWrapper.Impl<Item> itemLookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.ITEM);
        AdvancementEntry EnterTheWorld = Advancement.Builder.create()
                .display(
                        ModItems.CLEAN_CRYSTAL,
                        Text.literal("Rusted"),
                        Text.literal("Начните путь очищения!"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.CHALLENGE,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .criterion("enter_the_world", TickCriterion.Conditions.createTick())
                // Give the advancement an id
                .build(consumer,Rusted.MOD_ID + ":enter_the_world");
        AdvancementEntry got_rusty_metal = Advancement.Builder.create()
                .parent(EnterTheWorld)
                .display(
                        ModBlocks.RUSTY_METAL_ORE,
                        Text.literal("Важные мелочи"),
                        Text.literal("Добыть руду окислившегося металла"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_rusty_metal_ore",InventoryChangedCriterion.Conditions.items(ModBlocks.RUSTY_METAL_ORE))
                .build(consumer, Rusted.MOD_ID + ":got_rusty_metal_ore");
        AdvancementEntry got_dirty_crystal = Advancement.Builder.create()
                .parent(EnterTheWorld)
                .display(
                        ModBlocks.CLEAN_CRYSTAL_ORE,
                        Text.literal("На пути"),
                        Text.literal("Добыть грязный кристалл из руды"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_dirty_crystal",InventoryChangedCriterion.Conditions.items(ModItems.DIRTY_CRYSTAL))
                .build(consumer, Rusted.MOD_ID + ":got_dirty_crystal");
        AdvancementEntry recycle_dirty_crystal = Advancement.Builder.create()
                .parent(got_dirty_crystal)
                .display(
                        ModItems.CLEAN_CRYSTAL,
                        Text.literal("Переработка полным ходом"),
                        Text.literal("Соединив уголь и грязный кристалл, вы получили его чистую версию, которая веет чистотой. Нужно провести ещё немного экспериментов"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("recycle_dirty_crystal",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL))
                .build(consumer, Rusted.MOD_ID + ":recycle_dirty_crystal");
        AdvancementEntry recycle_rusty_metal = Advancement.Builder.create()
                .parent(got_rusty_metal)
                .display(
                        ModItems.POLISHED_METAL,
                        Text.literal("Новый материал!"),
                        Text.literal("Этот металл блестит и сияет. Что же будет, если его соединить с кристаллом?"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("recycle_dirty_crystal",InventoryChangedCriterion.Conditions.items(ModItems.POLISHED_METAL))
                .build(consumer, Rusted.MOD_ID + ":recycle_rusty_metal");
        AdvancementEntry got_clean_instruments = Advancement.Builder.create()
                .parent(EnterTheWorld)
                .display(
                        ModItems.CLEAN_CRYSTAL_SWORD,
                        Text.literal("Лучшее средство"),
                        Text.literal("У вас получилось создать инструменты, способные противостоять ржавчине и не так быстро ломаться."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_clean_pickaxe",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_PICKAXE))
                .criterion("got_clean_axe",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_AXE))
                .criterion("got_clean_shovel",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_SHOVEL))
                .criterion("got_clean_sword",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_SWORD))
                .build(consumer, Rusted.MOD_ID + ":got_clean_instruments");
        AdvancementEntry got_clean_armor = Advancement.Builder.create()
                .parent(EnterTheWorld)
                .display(
                        ModItems.CLEAN_CRYSTAL_CHESTPLATE,
                        Text.literal("Надёжная защита"),
                        Text.literal("Вы смогли создать броню из друх новых материалов.Готовы ли вы?"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_clean_boots",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_BOOTS))
                .criterion("got_clean_chestplate",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_CHESTPLATE))
                .criterion("got_clean_leggings",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_LEGGINGS))
                .criterion("got_clean_helmet",InventoryChangedCriterion.Conditions.items(ModItems.CLEAN_CRYSTAL_HELMET))
                .build(consumer, Rusted.MOD_ID + ":got_clean_armor");
    }
}