package com.example.item;

import com.example.Rusted;
import com.example.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

    public static final ItemGroup RUSTED_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rusted.MOD_ID, "rusted"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CLEAN_CRYSTAL))
                    .displayName(Text.translatable("itemGroup.rusted"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CLEAN_CRYSTAL);
                        entries.add(ModBlocks.CLEAN_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.CLEAN_CRYSTAL_ORE);
                        entries.add(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE);
                        entries.add(ModItems.DIRTY_CRYSTAL);
                        entries.add(ModItems.RUSTY_METAL);
                        entries.add(ModItems.POLISHED_METAL);
                        entries.add(ModItems.CLEAN_CRYSTAL_SWORD);
                        entries.add(ModItems.CLEAN_CRYSTAL_PICKAXE);
                        entries.add(ModItems.CLEAN_CRYSTAL_SHOVEL);
                        entries.add(ModItems.CLEAN_CRYSTAL_AXE);

                        entries.add(ModItems.CLEAN_CRYSTAL_HELMET);
                        entries.add(ModItems.CLEAN_CRYSTAL_CHESTPLATE);
                        entries.add(ModItems.CLEAN_CRYSTAL_LEGGINGS);
                        entries.add(ModItems.CLEAN_CRYSTAL_BOOTS);
                        // entries.add(ModItems.RUSTED_INGOT);
                    })
                    .build());
    public static void registerItemGroups() {
        Rusted.LOGGER.info("Registering Item Groups for " + Rusted.MOD_ID);
    }
}
