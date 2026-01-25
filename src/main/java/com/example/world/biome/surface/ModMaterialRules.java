package com.example.world.biome.surface;

import com.example.block.ModBlocks;
import com.example.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule RUSTED_DIRT = makeStateRule(ModBlocks.RUSTED_DIRT);
    private static final MaterialRules.MaterialRule RUSTY_METAL_ORE = makeStateRule(ModBlocks.RUSTY_METAL_ORE);
    private static final MaterialRules.MaterialRule CLEAN_CRYSTAL_ORE = makeStateRule(ModBlocks.CLEAN_CRYSTAL_ORE);
    /**
     * Создаёт основной набор правил поверхностного строения биома.
     * Здесь мы задаём, какие блоки появляются в биоме, на какой высоте и при каких условиях.
     *
     * @return готовое MaterialRule для использования в SurfaceBuilder
     */
    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialRule rustySurface = MaterialRules.condition(
                isAtOrAboveWaterLevel,
                RUSTED_DIRT
        );

        return MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomes.RUSTY_DEADLANDS),
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, rustySurface)
                        )
                )
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}