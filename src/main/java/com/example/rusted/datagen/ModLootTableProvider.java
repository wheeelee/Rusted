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
/**
 * Провайдер генерации лут-таблиц для блоков мода.
 * Наследуется от FabricBlockLootTableProvider, чтобы автоматически создавать лут-таблицы для блоков.
 */
public class ModLootTableProvider  extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    /**
     * Метод генерации лут-таблиц для блоков.
     * Вызывается Fabric при создании датагена.
     */
    @Override
    public void generate() {
        addDrop(ModBlocks.CLEAN_CRYSTAL_BLOCK);
        addDrop(ModBlocks.CLEAN_CRYSTAL_ORE,multipleOreDrops(ModBlocks.CLEAN_CRYSTAL_ORE,ModItems.DIRTY_CRYSTAL,1,3));
        addDrop(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE,multipleOreDrops(ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE,ModItems.DIRTY_CRYSTAL,1,3));
        addDrop(ModBlocks.RUSTY_METAL_ORE,multipleOreDrops(ModBlocks.RUSTY_METAL_ORE,ModItems.DIRTY_CRYSTAL,1,3));
    }
    /**
     * Создаёт LootTable.Builder для руд с возможностью выпадения нескольких предметов.
     * Применяет Silk Touch, Explosion Decay и Fortune.
     *
     * @param drop блок, который дропается
     * @param item предмет, который выпадает с блока
     * @param minDrops минимальное количество предметов
     * @param maxDrops максимальное количество предметов
     * @return LootTable.Builder с настройками выпадения
     */
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,this.applyExplosionDecay(drop,((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops,maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
