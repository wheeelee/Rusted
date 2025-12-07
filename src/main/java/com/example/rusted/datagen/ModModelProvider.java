package com.example.rusted.datagen;

import com.example.block.ModBlocks;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLEAN_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLEAN_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUSTY_METAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUSTED_DIRT);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DIRTY_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUSTY_METAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLEAN_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLISHED_METAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLEAN_CRYSTAL_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLEAN_CRYSTAL_SWORD,Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLEAN_CRYSTAL_SHOVEL,Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLEAN_CRYSTAL_AXE,Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLEAN_CRYSTAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLEAN_CRYSTAL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLEAN_CRYSTAL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLEAN_CRYSTAL_BOOTS));
        itemModelGenerator.register(ModItems.RUST_ZOMBIE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.RUSTY_ROBOT_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")),Optional.empty()));
    }
}
