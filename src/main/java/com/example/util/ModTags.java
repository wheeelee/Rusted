package com.example.util;

import com.example.Rusted;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Rusted.MOD_ID,name));
        }
        public static final TagKey<Block> NEEDS_CLEAN_CRYSTAL_TOOLS = createTag("needs_clean_crystal_tool");
        public static final TagKey<Block> INCORRECT_FOR_CLEAN_CRYSTAL_TOOLS = createTag("incorrect_for_clean_crystal_tool");
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Rusted.MOD_ID,name));
        }
    }
}
