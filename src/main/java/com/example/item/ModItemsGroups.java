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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CLEAN_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.rusted"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CLEAN_CRYSTAL);
                    }).build());

    public static void registerItemGroups() {
        Rusted.LOGGER.info("Registering Item Groups for " + Rusted.MOD_ID);
    }
}
