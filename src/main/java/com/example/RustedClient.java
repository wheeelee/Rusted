package com.example;

import com.example.entity.ModEntities;
import com.example.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class RustedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(RustZombieModel.RUST_ZOMBIE, RustZombieModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RUST_ZOMBIE, RustZombieRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(RustyRobotModel.RUSTY_ROBOT,RustyRobotModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RUSTY_ROBOT,RustyRobotRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(RustHoundModel.RUST_HOUND,RustHoundModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RUST_HOUND,RustHoundRenderer::new);
    }
}
