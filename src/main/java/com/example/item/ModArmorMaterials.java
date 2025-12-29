package com.example.item;

import com.example.Rusted;
import net.minecraft.client.tutorial.TutorialManager;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> RUSTY_METAL_ARMOR_MATERIAL = registerArmorMaterial("rusty_metal",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 4);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 20,SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.RUSTY_METAL),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Rusted.MOD_ID, "rusty_metal"))), 0, 0));
    public static final RegistryEntry<ArmorMaterial> CLEAN_CRYSTAL_ARMOR_MATERIAL = registerArmorMaterial("clean_crystal",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 4);
            }), 37, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.CLEAN_CRYSTAL),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Rusted.MOD_ID, "clean_crystal"))), 0, 0));
    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Rusted.MOD_ID, name), material.get());
    }

}
