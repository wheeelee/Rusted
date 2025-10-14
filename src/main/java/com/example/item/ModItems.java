package com.example.item;

import com.example.Rusted;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.example.item.ModToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.text.Text;

public class ModItems {

    public static final Item CLEAN_CRYSTAL = registerItem("clean_crystal",new Item(new Item.Settings()));
    public static final Item DIRTY_CRYSTAL = registerItem("dirty_crystal",new Item(new Item.Settings()));
    public static final Item RUSTY_METAL = registerItem("rusty_metal",new Item(new Item.Settings()));
    public static final Item POLISHED_METAL = registerItem("polished_metal",new Item(new Item.Settings()));


    public static final Item CLEAN_CRYSTAL_SWORD =  registerItem("clean_crystal_sword",
            new SwordItem(ModToolMaterials.CLEAN_CRYSTAL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CLEAN_CRYSTAL,5,-2.4f))));
    public static final Item CLEAN_CRYSTAL_PICKAXE =  registerItem("clean_crystal_pickaxe",
            new PickaxeItem(ModToolMaterials.CLEAN_CRYSTAL, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.CLEAN_CRYSTAL,1,-3.0f))));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Rusted.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Rusted.LOGGER.info("Registering Mod Items for " + Rusted.MOD_ID);
    }
}
