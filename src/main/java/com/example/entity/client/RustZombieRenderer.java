package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustZombieEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RustZombieRenderer extends MobEntityRenderer<RustZombieEntity, RustZombieModel<RustZombieEntity>> {
    public RustZombieRenderer(EntityRendererFactory.Context context) {
        super (context, new RustZombieModel<>(context.getPart(RustZombieModel.RUST_ZOMBIE)), 0.75f);
    }

    @Override
    public Identifier getTexture(RustZombieEntity entity) {
        return Identifier.of(Rusted.MOD_ID, "textures/entity/rust_zombie/rust_zombie.png");
    }

    @Override
    public void render(RustZombieEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        }
        else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
