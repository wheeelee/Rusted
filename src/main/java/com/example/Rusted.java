    package com.example;

    import com.example.block.ModBlocks;
    import com.example.effect.ModEffects;
    import com.example.entity.ModEntities;
    import com.example.entity.custom.RustZombieEntity;
    import com.example.entity.custom.RustyRobotEntity;
    import com.example.item.ModItems;
    import com.example.item.ModItemsGroups;
    import com.example.sound.ModSounds;
    import net.fabricmc.api.ModInitializer;
    import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
    import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
    import net.minecraft.util.Identifier;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    public class    Rusted implements ModInitializer {
        public static final String MOD_ID = "rusted";
        public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

        @Override
        public void onInitialize() {
            ModEntities.registerModEntities();
            ModItems.registerModItems();
            ModBlocks.registerModBlocks();
            ModEffects.registerEffects();
            ModItemsGroups.registerItemGroups();
            ModSounds.initialize();
            FabricDefaultAttributeRegistry.register(ModEntities.RUST_ZOMBIE, RustZombieEntity.createAttributes());
            FabricDefaultAttributeRegistry.register(ModEntities.RUSTY_ROBOT, RustyRobotEntity.createAttributes());
            CustomPortalBuilder.beginPortal()
                    .frameBlock(ModBlocks.RUSTED_DIRT)
                    .lightWithItem(ModItems.CLEAN_CRYSTAL)
                    .destDimID(Identifier.of(Rusted.MOD_ID,"rusty_deadlands"))
                    .tintColor(0xc76efa)
                    .registerPortal();
        }

    }

