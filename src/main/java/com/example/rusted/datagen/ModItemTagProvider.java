package com.example.rusted.datagen;

import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;
import net.minecraft.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider  extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.CLEAN_CRYSTAL_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CLEAN_CRYSTAL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.CLEAN_CRYSTAL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.CLEAN_CRYSTAL_AXE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CLEAN_CRYSTAL_HELMET)
                .add(ModItems.CLEAN_CRYSTAL_CHESTPLATE)
                .add(ModItems.CLEAN_CRYSTAL_LEGGINGS)
                .add(ModItems.CLEAN_CRYSTAL_BOOTS);
    }
}
