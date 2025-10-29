package com.example.world;

import com.example.Rusted;
import com.example.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> CLEAN_CRYSTAL_ORE_KEY = registerKey("clean_crystal_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldCleanCrystalOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.CLEAN_CRYSTAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,ModBlocks.CLEAN_CRYSTAL_DEEPSLATE_ORE.getDefaultState()));
        register(context,CLEAN_CRYSTAL_ORE_KEY,Feature.ORE, new OreFeatureConfig(overworldCleanCrystalOres,9));
    }
    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Rusted.MOD_ID,name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature,configuration));
    }
}
