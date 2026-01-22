package com.example.entity;

import com.example.Rusted;
import com.example.entity.custom.RustHoundEntity;
import com.example.entity.custom.RustOozeKingEntity;
import com.example.entity.custom.RustZombieEntity;
import com.example.entity.custom.RustyRobotEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RustZombieEntity> RUST_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Rusted.MOD_ID, "rust_zombie"),
            EntityType.Builder.create(RustZombieEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build());
    public static final EntityType<RustyRobotEntity> RUSTY_ROBOT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Rusted.MOD_ID,"rusty_robot"),
            EntityType.Builder.create(RustyRobotEntity::new,SpawnGroup.CREATURE)
                    .dimensions(1f,2.5f).build());
    public static final EntityType<RustOozeKingEntity> RUST_OOZE_KING = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Rusted.MOD_ID,"rust_ooze_king"),
            EntityType.Builder.create(RustOozeKingEntity::new,SpawnGroup.CREATURE)
                    .dimensions(1f,2.5f).build());
    public static final EntityType<RustHoundEntity> RUST_HOUND = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Rusted.MOD_ID,"rust_hound"),
            EntityType.Builder.create(RustHoundEntity::new,SpawnGroup.CREATURE)
                    .dimensions(1f,2.5f).build());
    public static void registerModEntities() {
        Rusted.LOGGER.info("Registering Mod Entities for " + Rusted.MOD_ID);
    }
}
