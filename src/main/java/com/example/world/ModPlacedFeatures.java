package com.example.world;

import com.example.Rusted;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> CLEAN_CRYSTAL_ORE_PLACED_KEY = registryKey("clean_crystal_ore_placed");
    public static final RegistryKey<PlacedFeature> RUSTY_METAL_ORE_PLACED_KEY = registryKey("rusty_metal_ore_placed");
    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CLEAN_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CLEAN_CRYSTAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(80))));
        register(context, RUSTY_METAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUSTY_METAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(80))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Rusted.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?,?>> configuration,
                                List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                  RegistryEntry<ConfiguredFeature<?,?>> configuraion,
                                                                                  PlacementModifier... modifiers) {
        register(context,key,configuraion,List.of(modifiers));
    }
}