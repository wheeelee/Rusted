package com.example.rusted.datagen;

import com.example.Rusted;
import com.example.RustedDataGenerator;
import com.example.block.ModBlocks;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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
                .criterion("got_rusty_metal_ore",InventoryChangedCriterion.Conditions.items(ModBlocks.CLEAN_CRYSTAL_ORE))
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
    }
}
