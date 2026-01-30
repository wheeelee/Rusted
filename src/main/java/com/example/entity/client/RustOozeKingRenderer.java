package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustOozeKingEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RustOozeKingRenderer extends MobEntityRenderer<RustOozeKingEntity,RustOozeKingModel<RustOozeKingEntity>>{
    public RustOozeKingRenderer(EntityRendererFactory.Context context) {
        super(context, new RustOozeKingModel<>(context.getPart(RustOozeKingModel.RUST_OOZE_KING)), 0.5f);
    }

    @Override
    public Identifier getTexture(RustOozeKingEntity entity) {
        return Identifier.of(Rusted.MOD_ID,"textures/entity/rust_ooze_king/rust_ooze_king.png");
    }
    @Override
    public void render(RustOozeKingEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}