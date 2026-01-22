package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustHoundEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RustHoundRenderer extends MobEntityRenderer<RustHoundEntity, RustHoundModel<RustHoundEntity>> {
    public RustHoundRenderer(EntityRendererFactory.Context context) {
        super(context, new RustHoundModel<>(context.getPart(RustHoundModel.RUST_HOUND)), 0.75f);
    }

    @Override
    public Identifier getTexture(RustHoundEntity entity) {
        return Identifier.of(Rusted.MOD_ID, "textures/entity/rust_hound/hounddd.png");
    }

    @Override
    public void render(RustHoundEntity livingEntity, float f, float g, MatrixStack matrixStack,
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
