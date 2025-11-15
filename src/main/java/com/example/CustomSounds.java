package com.example;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class CustomSounds {
    private CustomSounds() {
    }

    public static final SoundEvent CHALLENGE_COMPLETED = registerSound("challenge_bass");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(Rusted.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void initialize() {
        Rusted.LOGGER.info("Registering " + Rusted.MOD_ID + " Sounds");
    }
}
