package com.example.world;

import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModOrePlacement {
    /**
     * Создаёт стандартный набор PlacementModifiers для руды.
     *
     * @param countModifier  определяет, сколько раз фича (руда) может появиться
     * @param heightModifier ограничивает появление по высоте
     * @return список модификаторов размещения для передачи в Feature
     */
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    /**
     * Создаёт PlacementModifiers с конкретным количеством появлений руды.
     *
     * @param count        сколько раз фича будет попытана сгенерироваться
     * @param heightModifier ограничение по высоте
     * @return список модификаторов размещения
     */
    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(chance), heightModifier);
    }
}