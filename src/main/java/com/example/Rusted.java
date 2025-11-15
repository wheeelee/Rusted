package com.example;

import com.example.block.ModBlocks;
import com.example.entity.ModEntities;
import com.example.entity.custom.RustZombieEntity;
import com.example.item.ModItems;
import com.example.item.ModItemsGroups;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//УРА
public class Rusted implements ModInitializer {
	public static final String MOD_ID = "rusted";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemsGroups.registerItemGroups();
        ModEntities.registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.RUST_ZOMBIE, RustZombieEntity.createAttributes());
	}
}

