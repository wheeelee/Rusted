package com.example;

import com.example.block.ModBlocks;
import com.example.effect.ModEffects;
import com.example.item.ModItems;
import com.example.item.ModItemsGroups;
//import com.example.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
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
        ModEffects.registerEffects();
        //ModWorldGeneration.generateModWorldGen();
	}
}