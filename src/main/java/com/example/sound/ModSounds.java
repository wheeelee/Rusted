package com.example.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final String MOD_ID = "rusted";

    public static final SoundEvent ACHIEVEMENTS_GAIN =
            registerSoundEvent("achievements_gain");
    public static final SoundEvent RUSTY_ROBOT_DEATH =
            registerSoundEvent("rusty_robot_death");
    public static final SoundEvent RUSTY_ROBOT_HIT =
            registerSoundEvent("rusty_robot_hit");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void initialize() {
    }
}
