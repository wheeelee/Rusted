package com.example.block;

import com.example.Rusted;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block CLEAN_CRYSTAL_BLOCK = registerBlock("clean_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block CLEAN_CRYSTAL_ORE = registerBlock("clean_crystal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,4),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block CLEAN_CRYSTAL_DEEPSLATE_ORE = registerBlock("clean_crystal_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,4),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block RUSTY_METAL_ORE = registerBlock("rusty_metal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,4),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Rusted.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Rusted.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Rusted.LOGGER.info("Registering Mod Blocks for " + Rusted.MOD_ID);
    }
}