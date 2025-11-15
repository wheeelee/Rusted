package com.example.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect RUSTY = new RustyEffect();

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT,
                Identifier.of("rusted:rusty"), RUSTY);
    }
}