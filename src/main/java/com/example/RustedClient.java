package com.example;

import com.example.item.ModItems;
import net.fabricmc.api.ClientModInitializer;

public class RustedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItems.registerModItems();
    }
}
