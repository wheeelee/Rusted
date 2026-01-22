package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustOozeKingEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RustOozeKingRenderer extends MobEntityRenderer<RustOozeKingEntity,RustOozeKingModel<RustOozeKingEntity>>{
    public RustOozeKingRenderer(EntityRendererFactory.Context context) {
        super(context, new RustOozeKingModel<>(context.getPart(RustOozeKingModel.RUST_OOZE_KING)), 0.5f);
    }

    @Override
    public Identifier getTexture(RustOozeKingEntity entity) {
        return Identifier.of(Rusted.MOD_ID,"textures/entity/rust_ooze_king/rust_ooze_king.png");
    }
}