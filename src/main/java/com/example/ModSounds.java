package com.example;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    private ModSounds() {
    }

    public static final SoundEvent ACHIEVEMENTS_GAIN =
            registerSound("achievements_gain");
    public static final SoundEvent RUSTY_ROBOT_DEATH =
            registerSound("rusty_robot_death");
    public static final SoundEvent RUSTY_ROBOT_HIT =
            registerSound("rusty_robot_hit");


    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(Rusted.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void initialize() {
        Rusted.LOGGER.info("Registering " + Rusted.MOD_ID + " Sounds");
    }
}
