package com.example.rusted.datagen;

import com.example.block.ModBlocks;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> CLEAN_CRYSTAL_SMELTS = List.of(ModBlocks.CLEAN_CRYSTAL_ORE,ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE);

        // Рецепты плавки/обжига
        offerSmelting(recipeExporter,CLEAN_CRYSTAL_SMELTS, RecipeCategory.MISC,ModItems.DIRTY_CRYSTAL,0.25f,200,"dirty_crystal");
        offerBlasting(recipeExporter,CLEAN_CRYSTAL_SMELTS, RecipeCategory.MISC,ModItems.DIRTY_CRYSTAL,0.25f,100,"dirty_crystal");

        // Рецепты компактирования (предмет <-> блок)
        offerReversibleCompactingRecipes(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModItems.CLEAN_CRYSTAL,RecipeCategory.DECORATIONS,ModBlocks.CLEAN_CRYSTAL_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL,9)
                .input(ModBlocks.CLEAN_CRYSTAL_BLOCK)
                .criterion(hasItem(ModBlocks.CLEAN_CRYSTAL_BLOCK),conditionsFromItem(ModBlocks.CLEAN_CRYSTAL_BLOCK))
                .offerTo(recipeExporter,"clean_crystal_from_block");
    }
}
