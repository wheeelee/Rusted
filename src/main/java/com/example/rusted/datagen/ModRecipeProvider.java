package com.example.rusted.datagen;

import com.example.block.ModBlocks;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL)
                .pattern("DC")
                .input('D',ModItems.DIRTY_CRYSTAL)
                .input('C', Items.COAL)
                .criterion(hasItem(ModItems.DIRTY_CRYSTAL),conditionsFromItem(ModItems.DIRTY_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_shaped_coal");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL)
                .pattern("DC")
                .input('D',ModItems.DIRTY_CRYSTAL)
                .input('C', Items.CHARCOAL)
                .criterion(hasItem(ModItems.DIRTY_CRYSTAL),conditionsFromItem(ModItems.DIRTY_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_shaped_charcoal");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.POLISHED_METAL)
                .pattern("PC")
                .input('P',ModItems.RUSTY_METAL)
                .input('C', Items.COAL)
                .criterion(hasItem(ModItems.RUSTY_METAL),conditionsFromItem(ModItems.RUSTY_METAL))
                .offerTo(recipeExporter,"polished_metal_shaped_coal");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.POLISHED_METAL)
                .pattern("PC")
                .input('P',ModItems.RUSTY_METAL)
                .input('C', Items.CHARCOAL)
                .criterion(hasItem(ModItems.RUSTY_METAL),conditionsFromItem(ModItems.RUSTY_METAL))
                .offerTo(recipeExporter,"polished_metal_shaped_charcoal");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_PICKAXE)
                .pattern("CPC")
                .pattern(" S ")
                .pattern(" S ")
                .input('P',ModItems.POLISHED_METAL)
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_pickaxe");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_SWORD)
                .pattern(" C ")
                .pattern(" P ")
                .pattern(" S ")
                .input('P',ModItems.POLISHED_METAL)
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_sword");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_SHOVEL)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_shovel");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_AXE)
                .pattern("PC ")
                .pattern("CS ")
                .pattern(" S ")
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('P',ModItems.POLISHED_METAL)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_axe");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_BOOTS)
                .pattern("   ")
                .pattern("C C")
                .pattern("P P")
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('P',ModItems.POLISHED_METAL)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_boots");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_LEGGINGS)
                .pattern("CCC")
                .pattern("P P")
                .pattern("P P")
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('P',ModItems.POLISHED_METAL)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_leggings");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_CHESTPLATE)
                .pattern("C C")
                .pattern("PPP")
                .pattern("PPP")
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('P',ModItems.POLISHED_METAL)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_chestplate");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CLEAN_CRYSTAL_HELMET)
                .pattern("CPC")
                .pattern("P P")
                .pattern("   ")
                .input('C', ModItems.CLEAN_CRYSTAL)
                .input('P',ModItems.POLISHED_METAL)
                .criterion(hasItem(ModItems.CLEAN_CRYSTAL),conditionsFromItem(ModItems.CLEAN_CRYSTAL))
                .offerTo(recipeExporter,"clean_crystal_helmet");
    }
}
