package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustyRobotEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RustyRobotRenderer extends MobEntityRenderer<RustyRobotEntity,RustyRobotModel<RustyRobotEntity>> {
    public RustyRobotRenderer(EntityRendererFactory.Context context) {
        super(context, new RustyRobotModel<>(context.getPart(RustyRobotModel.RUSTY_ROBOT)), 0.5f);
    }

    @Override
    public Identifier getTexture(RustyRobotEntity entity) {
        return Identifier.of(Rusted.MOD_ID,"textures/entity/rusty_robot/rusty_robot.png");
    }
}
