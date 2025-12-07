package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustyRobotEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class RustyRobotModel<T extends RustyRobotEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer RUSTY_ROBOT = new EntityModelLayer(Identifier.of(Rusted.MOD_ID,"rusty_robot"),"main");
    private final ModelPart golem;
    private final ModelPart h_head;
    private final ModelPart hitbox;
    public RustyRobotModel(ModelPart root) {
        this.golem = root.getChild("golem");
        this.h_head = this.golem.getChild("h_head");
        this.hitbox = root.getChild("hitbox");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData golem = modelPartData.addChild("golem", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 10.0F, -2.0F));

        ModelPartData body = golem.addChild("body", ModelPartBuilder.create().uv(0, 54).cuboid(-5.0F, -7.0F, -3.0F, 12.0F, 7.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-9.0F, -21.0F, -4.0F, 20.0F, 14.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 41).cuboid(-7.0F, -24.0F, -3.0F, 16.0F, 3.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 26).cuboid(-8.0F, -27.0F, -4.0F, 18.0F, 3.0F, 12.0F, new Dilation(0.0F))
                .uv(60, 26).cuboid(-4.0F, -30.0F, -2.0F, 10.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Larm = golem.addChild("Larm", ModelPartBuilder.create().uv(72, 74).cuboid(2.0F, 13.0F, -2.0F, 3.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(64, 0).cuboid(0.0F, -1.0F, -4.0F, 6.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -18.0F, 2.0F));

        ModelPartData cube_r1 = Larm.addChild("cube_r1", ModelPartBuilder.create().uv(32, 85).cuboid(6.0F, -12.0F, -3.0F, 1.0F, 12.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -6.0F, 2.5F, 0.0F, 0.0F, 0.2182F));

        ModelPartData cube_r2 = Larm.addChild("cube_r2", ModelPartBuilder.create().uv(24, 85).cuboid(5.0F, -9.0F, -3.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData cube_r3 = Larm.addChild("cube_r3", ModelPartBuilder.create().uv(38, 71).cuboid(6.0F, -7.0F, 1.0F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, -5.0F, -5.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r4 = Larm.addChild("cube_r4", ModelPartBuilder.create().uv(16, 86).cuboid(5.0F, -7.0F, 1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 1.0F, -4.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r5 = Larm.addChild("cube_r5", ModelPartBuilder.create().uv(92, 7).cuboid(6.0F, -5.0F, -3.0F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, -6.0F, 6.5F, -0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r6 = Larm.addChild("cube_r6", ModelPartBuilder.create().uv(62, 81).cuboid(5.0F, -9.0F, -3.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 1.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData Rarm = golem.addChild("Rarm", ModelPartBuilder.create().uv(24, 71).cuboid(-5.0F, 13.0F, -2.0F, 3.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(44, 59).cuboid(-6.0F, -1.0F, -4.0F, 6.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, -18.0F, 2.0F));

        ModelPartData cube_r7 = Rarm.addChild("cube_r7", ModelPartBuilder.create().uv(92, 0).cuboid(-6.0F, -6.0F, -3.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.25F, -5.0F, 6.5F, -0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r8 = Rarm.addChild("cube_r8", ModelPartBuilder.create().uv(8, 86).cuboid(-7.0F, -9.0F, -3.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 3.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r9 = Rarm.addChild("cube_r9", ModelPartBuilder.create().uv(80, 88).cuboid(-6.0F, -10.0F, -3.0F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, -5.0F, 2.5F, 0.0F, 0.0F, -0.2182F));

        ModelPartData cube_r10 = Rarm.addChild("cube_r10", ModelPartBuilder.create().uv(0, 86).cuboid(-7.0F, -9.0F, -3.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.0F, 2.0F, 0.0F, 0.0F, -0.2182F));

        ModelPartData cube_r11 = Rarm.addChild("cube_r11", ModelPartBuilder.create().uv(88, 88).cuboid(-6.0F, -7.0F, 1.0F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.25F, -1.0F, -4.5F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r12 = Rarm.addChild("cube_r12", ModelPartBuilder.create().uv(86, 74).cuboid(-7.0F, -7.0F, 1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 3.0F, -4.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData Lleg = golem.addChild("Lleg", ModelPartBuilder.create().uv(0, 71).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 7.0F, 8.0F, new Dilation(0.0F))
                .uv(50, 81).cuboid(-1.0F, 7.0F, -2.0F, 2.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 0.0F, 2.0F));

        ModelPartData Rleg = golem.addChild("Rleg", ModelPartBuilder.create().uv(38, 81).cuboid(-1.0F, 7.0F, -2.0F, 2.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(72, 59).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 2.0F));

        ModelPartData h_head = golem.addChild("h_head", ModelPartBuilder.create().uv(60, 37).cuboid(-4.0F, -2.0F, -6.0F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(52, 41).cuboid(-6.0F, -5.0F, -5.0F, 12.0F, 8.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -33.0F, 2.0F));

        ModelPartData hitbox = modelPartData.addChild("hitbox", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(RustyRobotEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {

        // Сброс позы
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        // Ходьба
        animateMovement(RustyRobotAnimations.walking, limbSwing, limbSwingAmount, 2f, 2.5f);

        // Rage имеет приоритет над idle
        if (entity.isRaging()) {
            updateAnimation(entity.rageAnimationState, RustyRobotAnimations.rage, ageInTicks, 1f);
        } else {
            updateAnimation(entity.idleAnimationState, RustyRobotAnimations.idle, ageInTicks, 1f);
        }

        // Поворот головы всегда в конце
        setHeadAngles(netHeadYaw, headPitch);
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.h_head.yaw = headYaw * 0.017453292F;
        this.h_head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        golem.render(matrices, vertexConsumer, light, overlay, color);
        hitbox.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return golem;
    }
}
