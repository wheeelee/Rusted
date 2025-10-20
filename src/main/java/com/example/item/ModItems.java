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
    public static final Item CLEAN_CRYSTAL_SHOVEL =  registerItem("clean_crystal_shovel",
            new ShovelItem(ModToolMaterials.CLEAN_CRYSTAL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.CLEAN_CRYSTAL,1,-2.4f))));
    public static final Item CLEAN_CRYSTAL_AXE =  registerItem("clean_crystal_axe",
            new AxeItem(ModToolMaterials.CLEAN_CRYSTAL, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.CLEAN_CRYSTAL,2,-2.4f))));
    public static final Item CLEAN_CRYSTAL_HELMET = registerItem("clean_crystal_helmet",
            new ArmorItem(ModArmorMaterials.CLEAN_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item CLEAN_CRYSTAL_CHESTPLATE = registerItem("clean_crystal_chestplate",
            new ArmorItem(ModArmorMaterials.CLEAN_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item CLEAN_CRYSTAL_LEGGINGS = registerItem("clean_crystal_leggings",
            new ArmorItem(ModArmorMaterials.CLEAN_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item CLEAN_CRYSTAL_BOOTS = registerItem("clean_crystal_boots",
            new ArmorItem(ModArmorMaterials.CLEAN_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Rusted.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Rusted.LOGGER.info("Registering Mod Items for " + Rusted.MOD_ID);
    }
}
