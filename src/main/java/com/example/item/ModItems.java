package com.example.item;

import com.example.Rusted;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ModItems {

    public static final Item CLEAN_CRYSTAL = registerItem("clean_crystal",new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Rusted.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Rusted.LOGGER.info("Registering Mod Items for " + Rusted.MOD_ID);
    }
}
