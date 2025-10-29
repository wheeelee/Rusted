package com.example.rusted.datagen;

import com.example.block.ModBlocks;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider  extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CLEAN_CRYSTAL_BLOCK);
        //ЭТО ИЗ БЛОКА БУДЕТ ВЫПАДАТЬ БЛОК И ВСЁ

        addDrop(ModBlocks.CLEAN_CRYSTAL_ORE,multipleOreDrops(ModBlocks.CLEAN_CRYSTAL_ORE,ModItems.DIRTY_CRYSTAL,1,3));
        addDrop(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE,multipleOreDrops(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE,ModItems.DIRTY_CRYSTAL,1,3));
        addDrop(ModBlocks.RUSTY_METAL_ORE,multipleOreDrops(ModBlocks.RUSTY_METAL_ORE,ModItems.DIRTY_CRYSTAL,1,3));
        //Более удобное добавление свойств для блоков - выпадения и количество выпадаемых ресурсов
    }
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,this.applyExplosionDecay(drop,((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops,maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
