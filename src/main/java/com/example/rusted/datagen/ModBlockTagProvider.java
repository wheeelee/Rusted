package com.example.rusted.datagen;

import com.example.block.ModBlocks;
import com.example.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CLEAN_CRYSTAL_BLOCK)
                .add(ModBlocks.CLEAN_CRYSTAL_ORE)
                .add(ModBlocks.RUSTY_METAL_ORE)
                .add(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CLEAN_CRYSTAL_ORE)
                .add(ModBlocks.RUSTY_METAL_ORE)
                .add(ModBlocks.CLEAN_CRYSTAL_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE);
        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_CLEAN_CRYSTAL_TOOLS);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_CLEAN_CRYSTAL_TOOLS)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
