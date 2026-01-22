package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustOozeKingEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RustOozeKingModel<T extends RustOozeKingEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer RUST_OOZE_KING = new EntityModelLayer(Identifier.of(Rusted.MOD_ID,"rust_ooze_king"),"main");
    private final ModelPart slime;
    private final ModelPart head;

	public RustOozeKingModel(ModelPart root) {
        this.slime = root.getChild("slime");
        this.head = this.slime.getChild("body").getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData slime = modelPartData.addChild("slime", ModelPartBuilder.create(), ModelTransform.pivot(0.2F, -17.9F, -3.0F));

        ModelPartData body = slime.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(-0.4676F, 5.8079F, 5.99F));

        ModelPartData block = body.addChild("block", ModelPartBuilder.create().uv(85, 14).mirrored().cuboid(-8.3222F, -8.5238F, -6.32F, 3.0F, 16.9F, 12.0F, new Dilation(0.0F)).mirrored(false)
                .uv(67, 30).cuboid(5.4778F, -8.5238F, -6.32F, 3.0F, 16.9F, 12.0F, new Dilation(0.0F)), ModelTransform.of(4.1898F, -24.0842F, -2.67F, 0.0002F, 0.0121F, 0.1916F));

        ModelPartData cube_r1 = block.addChild("cube_r1", ModelPartBuilder.create().uv(37, 0).mirrored().cuboid(-1.5F, -8.2F, -4.9F, 3.0F, 16.5F, 10.8F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0778F, 6.6762F, -0.32F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r2 = block.addChild("cube_r2", ModelPartBuilder.create().uv(53, 16).cuboid(-1.5F, -8.4F, -4.9F, 3.0F, 16.6F, 10.7F, new Dilation(0.0F)), ModelTransform.of(0.1778F, -6.6238F, -0.32F, 0.0F, 0.0F, -1.5708F));

        ModelPartData group2 = block.addChild("group2", ModelPartBuilder.create(), ModelTransform.pivot(-0.2613F, 0.0951F, 0.33F));

        ModelPartData cube_r3 = group2.addChild("cube_r3", ModelPartBuilder.create().uv(32, 0).cuboid(-0.55F, -6.5F, -0.55F, 1.1F, 13.0F, 1.1F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0895F, 0.2509F, -0.3002F));

        ModelPartData cube_r4 = group2.addChild("cube_r4", ModelPartBuilder.create().uv(32, 0).cuboid(-0.55F, -6.5F, -0.55F, 1.1F, 13.0F, 1.1F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, 0.0607F, 0.0627F, -1.2373F));

        ModelPartData cube_r5 = group2.addChild("cube_r5", ModelPartBuilder.create().uv(32, 0).cuboid(-0.1F, -13.6F, -1.0F, 1.1F, 13.6F, 1.1F, new Dilation(0.0F)), ModelTransform.of(-1.6608F, 7.0812F, 2.45F, 0.0698F, 0.0F, 0.2618F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.2676F, -9.3079F, -0.99F));

        ModelPartData cube_r6 = torso.addChild("cube_r6", ModelPartBuilder.create().uv(0, 71).cuboid(-11.2F, -2.8F, -7.3F, 19.9F, 6.3F, 13.8F, new Dilation(0.0F)), ModelTransform.of(1.4F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0873F));

        ModelPartData cube_r7 = torso.addChild("cube_r7", ModelPartBuilder.create().uv(10, 77).cuboid(-7.0F, -2.8F, -3.5F, 14.1F, 6.3F, 7.6F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.4F, 0.0F, 0.0349F, 0.0F, 0.0F));

        ModelPartData cube_r8 = torso.addChild("cube_r8", ModelPartBuilder.create().uv(3, 75).cuboid(-9.5F, -2.8F, -5.0F, 19.0F, 3.8F, 10.7F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.4F, 0.0F, 0.0349F, 0.0F, -0.0524F));

        ModelPartData sticks = torso.addChild("sticks", ModelPartBuilder.create(), ModelTransform.pivot(0.2F, 3.5F, -5.0F));

        ModelPartData cube_r9 = sticks.addChild("cube_r9", ModelPartBuilder.create().uv(32, 0).cuboid(-0.1F, -13.6F, -1.0F, 1.1F, 9.6F, 1.1F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1696F, -0.3553F, 0.0363F));

        ModelPartData cube_r10 = sticks.addChild("cube_r10", ModelPartBuilder.create().uv(32, 0).cuboid(-0.1F, -13.6F, -1.0F, 1.1F, 9.6F, 1.1F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -1.0F, 7.7F, 0.0697F, -0.003F, 0.3053F));

        ModelPartData cube_r11 = sticks.addChild("cube_r11", ModelPartBuilder.create().uv(32, 0).cuboid(-0.55F, -6.5F, -0.55F, 1.1F, 8.0F, 1.1F, new Dilation(0.0F)), ModelTransform.of(3.4608F, -5.8812F, 3.65F, 0.0895F, 0.2509F, -0.3002F));

        ModelPartData cube_r12 = sticks.addChild("cube_r12", ModelPartBuilder.create().uv(32, 0).cuboid(-0.55F, -6.5F, -0.55F, 1.1F, 9.0F, 1.1F, new Dilation(0.0F)), ModelTransform.of(6.9608F, -4.4812F, 6.45F, 2.7798F, -0.6827F, -2.7105F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(1, 4).cuboid(0.0654F, 1.5121F, -1.8511F, 1.4F, 1.4F, 1.4F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.3346F, -4.2879F, -1.6511F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(4.5426F, -23.6079F, -5.34F, 0.0002F, 0.0121F, 0.1916F));

        ModelPartData eyes = head.addChild("eyes", ModelPartBuilder.create().uv(0, 0).cuboid(1.6F, -1.25F, -1.25F, 2.5F, 2.5F, 2.5F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.1F, -1.25F, -1.25F, 2.5F, 2.5F, 2.5F, new Dilation(0.0F)), ModelTransform.pivot(-0.3346F, -0.9379F, -0.6011F));

        ModelPartData leftleg = slime.addChild("leftleg", ModelPartBuilder.create().uv(17, 76).cuboid(-2.0F, 16.0F, -5.8F, 6.0F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(4.8F, 9.9F, 4.8F));

        ModelPartData cube_r13 = leftleg.addChild("cube_r13", ModelPartBuilder.create().uv(17, 74).cuboid(-1.2F, -2.0F, -7.4F, 4.3F, 6.0F, 11.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 23.9F, -1.7F, 1.885F, 0.0F, 0.0F));

        ModelPartData group5 = leftleg.addChild("group5", ModelPartBuilder.create(), ModelTransform.pivot(-0.2F, 11.3F, 0.2F));

        ModelPartData cube_r14 = group5.addChild("cube_r14", ModelPartBuilder.create().uv(11, 68).cuboid(-0.8F, -2.6F, -3.4F, 3.5F, 8.5F, 4.6F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1396F, 0.0F, 0.0F));

        ModelPartData cube_r15 = group5.addChild("cube_r15", ModelPartBuilder.create().uv(40, 71).cuboid(-0.55F, -6.5F, -0.55F, 1.1F, 13.0F, 1.1F, new Dilation(0.0F)), ModelTransform.of(0.7608F, -4.2812F, -0.65F, -0.1636F, 0.2109F, -0.1212F));

        ModelPartData cube_r16 = group5.addChild("cube_r16", ModelPartBuilder.create().uv(5, 69).cuboid(-0.8F, -2.6F, -3.4F, 3.5F, 8.5F, 4.6F, new Dilation(0.0F)), ModelTransform.of(-0.9F, -10.8F, 1.4F, -0.0871F, -0.0061F, -0.0695F));

        ModelPartData group3 = leftleg.addChild("group3", ModelPartBuilder.create().uv(20, 78).cuboid(-1.9F, -2.0F, -6.2F, 5.8F, 2.0F, 7.2F, new Dilation(0.0F))
                .uv(10, 71).cuboid(-0.6F, -3.5F, 2.3F, 3.5F, 3.5F, 3.2F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 32.0F, 0.0F));

        ModelPartData rightleg = slime.addChild("rightleg", ModelPartBuilder.create().uv(17, 76).mirrored().cuboid(-4.0F, 18.0F, -7.3F, 6.0F, 6.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-5.2F, 7.9F, 6.3F));

        ModelPartData cube_r17 = rightleg.addChild("cube_r17", ModelPartBuilder.create().uv(17, 74).mirrored().cuboid(-3.1F, -2.0F, -7.4F, 4.3F, 6.0F, 11.4F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 25.9F, -3.2F, 1.885F, 0.0F, 0.0F));

        ModelPartData cube_r18 = rightleg.addChild("cube_r18", ModelPartBuilder.create().uv(8, 68).mirrored().cuboid(-2.7F, -12.5F, -3.4F, 3.5F, 18.4F, 4.6F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.4F, 13.3F, -1.3F, -0.1395F, 0.0049F, 0.0346F));

        ModelPartData group4 = rightleg.addChild("group4", ModelPartBuilder.create().uv(0, 85).mirrored().cuboid(-2.9F, -3.5F, 0.8F, 3.5F, 3.5F, 3.2F, new Dilation(0.0F)).mirrored(false)
                .uv(20, 78).mirrored().cuboid(-3.9F, -2.0F, -7.7F, 5.8F, 2.0F, 7.2F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 34.0F, 0.0F));

        ModelPartData rightarm = slime.addChild("rightarm", ModelPartBuilder.create(), ModelTransform.pivot(0.2694F, -16.7823F, 6.2485F));

        ModelPartData bort = rightarm.addChild("bort", ModelPartBuilder.create(), ModelTransform.pivot(-17.6694F, 3.2823F, 2.7515F));

        ModelPartData cube_r19 = bort.addChild("cube_r19", ModelPartBuilder.create().uv(9, 100).cuboid(-6.1F, -14.0F, -8.8F, 9.1F, 14.0F, 14.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.6F, 0.0F, -0.0349F, 0.0F, 0.0175F));

        ModelPartData cube_r20 = bort.addChild("cube_r20", ModelPartBuilder.create().uv(0, 91).cuboid(-9.0F, -14.0F, -13.0F, 14.0F, 14.0F, 23.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1047F));

        ModelPartData cube_r21 = bort.addChild("cube_r21", ModelPartBuilder.create().uv(20, 58).cuboid(-3.2F, 0.7F, -5.7F, 3.2F, 2.0F, 4.3F, new Dilation(0.0F)), ModelTransform.of(2.2F, -20.7F, 2.0F, 0.0F, 0.0F, 0.0873F));

        ModelPartData cube_r22 = bort.addChild("cube_r22", ModelPartBuilder.create().uv(41, 54).cuboid(-5.3F, -4.6F, -7.7F, 6.5F, 7.3F, 8.0F, new Dilation(0.0F))
                .uv(19, 54).cuboid(-4.3F, -2.0F, -6.7F, 4.5F, 4.7F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.2F, -16.7F, 2.0F, 0.0F, 0.0F, 0.0873F));

        ModelPartData cube_r23 = bort.addChild("cube_r23", ModelPartBuilder.create().uv(0, 50).cuboid(-6.1F, -2.0F, -9.7F, 7.1F, 2.0F, 12.4F, new Dilation(0.0F)), ModelTransform.of(2.2F, -12.7F, 2.0F, 0.0F, 0.0F, 0.0873F));

        ModelPartData otherhand = rightarm.addChild("otherhand", ModelPartBuilder.create(), ModelTransform.pivot(-20.0F, 16.0F, -1.0F));

        ModelPartData hand = otherhand.addChild("hand", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 15.0F, 1.0F));

        ModelPartData bod = hand.addChild("bod", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r24 = bod.addChild("cube_r24", ModelPartBuilder.create().uv(21, 102).cuboid(-4.55F, -1.9F, -6.4F, 9.1F, 3.8F, 12.8F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0558F, -0.042F, -0.697F));

        ModelPartData finger1 = hand.addChild("finger1", ModelPartBuilder.create(), ModelTransform.of(-1.5694F, 2.1823F, -4.9485F, -0.0698F, 0.0F, 0.0F));

        ModelPartData group = finger1.addChild("group", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 6.9F, 0.0F));

        ModelPartData cube_r25 = group.addChild("cube_r25", ModelPartBuilder.create().uv(49, 118).cuboid(-0.7F, -2.0F, -0.8F, 1.4F, 9.3F, 1.6F, new Dilation(0.0F)), ModelTransform.of(0.3F, 2.0F, 0.0F, 0.0F, 0.0F, -0.1571F));

        ModelPartData group6 = finger1.addChild("group6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r26 = group6.addChild("cube_r26", ModelPartBuilder.create().uv(44, 114).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 9.3F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));

        ModelPartData finger2 = hand.addChild("finger2", ModelPartBuilder.create(), ModelTransform.of(-1.5694F, 2.1823F, -2.0485F, -0.0524F, 0.0F, 0.0F));

        ModelPartData group7 = finger2.addChild("group7", ModelPartBuilder.create(), ModelTransform.pivot(-1.1F, 8.2F, 0.0F));

        ModelPartData cube_r27 = group7.addChild("cube_r27", ModelPartBuilder.create().uv(4, 117).cuboid(-1.0786F, -0.1978F, -0.8F, 1.6F, 10.5F, 1.5F, new Dilation(0.0F)), ModelTransform.of(0.1F, -0.1F, 0.0F, 0.0F, 0.0F, -0.2094F));

        ModelPartData group8 = finger2.addChild("group8", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r28 = group8.addChild("cube_r28", ModelPartBuilder.create().uv(1, 115).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 10.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));

        ModelPartData finger3 = hand.addChild("finger3", ModelPartBuilder.create(), ModelTransform.pivot(-1.5694F, 2.1823F, 0.9515F));

        ModelPartData group9 = finger3.addChild("group9", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 7.7F, 0.0F));

        ModelPartData cube_r29 = group9.addChild("cube_r29", ModelPartBuilder.create().uv(30, 95).cuboid(-0.806F, -0.0376F, -0.8F, 1.6F, 10.0F, 1.5F, new Dilation(0.0F)), ModelTransform.of(-0.2F, -0.1F, 0.0F, 0.0F, 0.0F, -0.2094F));

        ModelPartData group10 = finger3.addChild("group10", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r30 = group10.addChild("cube_r30", ModelPartBuilder.create().uv(27, 93).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));

        ModelPartData finger4 = hand.addChild("finger4", ModelPartBuilder.create(), ModelTransform.pivot(-1.5694F, 2.1823F, 3.9515F));

        ModelPartData group11 = finger4.addChild("group11", ModelPartBuilder.create(), ModelTransform.pivot(-0.6F, 5.2F, 0.0F));

        ModelPartData cube_r31 = group11.addChild("cube_r31", ModelPartBuilder.create().uv(44, 95).cuboid(-0.8F, -2.0F, -0.8F, 1.3F, 7.5F, 1.6F, new Dilation(0.0F)), ModelTransform.of(0.6F, 1.6F, 0.0F, 0.0F, 0.0F, -0.384F));

        ModelPartData group12 = finger4.addChild("group12", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r32 = group12.addChild("cube_r32", ModelPartBuilder.create().uv(41, 93).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 7.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));

        ModelPartData finger5 = hand.addChild("finger5", ModelPartBuilder.create(), ModelTransform.of(1.3306F, -1.0177F, -6.1485F, -1.0129F, -0.9359F, 0.959F));

        ModelPartData group13 = finger5.addChild("group13", ModelPartBuilder.create(), ModelTransform.pivot(-0.4F, 4.9F, 0.0F));

        ModelPartData cube_r33 = group13.addChild("cube_r33", ModelPartBuilder.create().uv(69, 119).cuboid(-0.9F, -2.0F, -0.9F, 1.3F, 7.5F, 1.8F, new Dilation(0.0F)), ModelTransform.of(0.4F, 1.7F, 0.0F, 0.0F, 0.0F, -0.4363F));

        ModelPartData group14 = finger5.addChild("group14", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r34 = group14.addChild("cube_r34", ModelPartBuilder.create().uv(66, 119).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 7.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));

        ModelPartData lokot = otherhand.addChild("lokot", ModelPartBuilder.create(), ModelTransform.pivot(3.3306F, 12.5823F, 2.6515F));

        ModelPartData cube_r35 = lokot.addChild("cube_r35", ModelPartBuilder.create().uv(15, 98).cuboid(-8.4F, -14.0F, -9.9F, 10.8F, 8.3F, 16.6F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0698F, -0.0012F, 0.0175F));

        ModelPartData predplech = lokot.addChild("predplech", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r36 = predplech.addChild("cube_r36", ModelPartBuilder.create().uv(13, 104).cuboid(-6.8F, -14.0F, -4.9F, 5.8F, 11.3F, 10.1F, new Dilation(0.0F)), ModelTransform.of(1.3F, 4.4F, -2.0F, -0.0698F, 0.0F, -0.0524F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        slime.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return slime;
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void setAngles(RustOozeKingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);
        this.updateAnimation(entity.idleAnimationState,RustOozeKingAnimations.idle,animationProgress,1f);
        if (limbDistance > 0.6F) {
            // RUN
            this.animateMovement(
                    RustOozeKingAnimations.run,
                    limbAngle,
                    limbDistance,
                    2.5F,
                    3.0F
            );
        } else {
            // WALK
            this.animateMovement(
                    RustOozeKingAnimations.walk,
                    limbAngle,
                    limbDistance,
                    2.0F,
                    2.5F
            );
        }
        this.updateAnimation(
                entity.rageAnimationState,
                RustOozeKingAnimations.attack,
                animationProgress,
                1.0F
        );
    }
}