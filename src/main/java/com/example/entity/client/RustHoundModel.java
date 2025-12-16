package com.example.entity.client;

import com.example.Rusted;
import com.example.entity.custom.RustHoundEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class RustHoundModel<T extends RustHoundEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer RUST_HOUND = new EntityModelLayer(Identifier.of(Rusted.MOD_ID, "rust_hound"), "main");
    private final ModelPart rusthound;
    private final ModelPart fullhead;

    public RustHoundModel(ModelPart root) {
        this.rusthound = root.getChild("rusthound");
        this.fullhead = this.rusthound.getChild("fullhead");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData rusthound = modelPartData.addChild("rusthound", ModelPartBuilder.create(), ModelTransform.pivot(-0.3193F, 14.0256F, -0.8928F));

        ModelPartData torso = rusthound.addChild("torso", ModelPartBuilder.create().uv(1, 4).mirrored().cuboid(-4.0F, -7.0F, -10.0F, 8.0F, 7.0F, 6.5F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.3193F, 2.9744F, 2.8928F));

        ModelPartData rrleg = rusthound.addChild("rrleg", ModelPartBuilder.create().uv(11, 11).cuboid(-1.7F, -0.6667F, 0.0667F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F))
                .uv(13, 8).cuboid(-0.9F, 3.0833F, 1.3167F, 2.0F, 6.0F, 2.25F, new Dilation(0.0F))
                .uv(10, 9).cuboid(-0.9F, 9.0833F, 0.6167F, 2.0F, 1.0F, 2.75F, new Dilation(0.0F)), ModelTransform.pivot(-1.4807F, -0.109F, 7.5761F));

        ModelPartData rlleg = rusthound.addChild("rlleg", ModelPartBuilder.create().uv(7, 7).cuboid(-1.3F, -0.6667F, 0.0667F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F))
                .uv(9, 12).cuboid(-1.1F, 9.0833F, 0.6167F, 2.0F, 1.0F, 2.75F, new Dilation(0.0F))
                .uv(11, 8).cuboid(-1.1F, 3.0833F, 1.3167F, 2.0F, 6.0F, 2.25F, new Dilation(0.0F)), ModelTransform.pivot(2.1193F, -0.109F, 7.5761F));

        ModelPartData frleg = rusthound.addChild("frleg", ModelPartBuilder.create().uv(16, 28).cuboid(-1.0F, -0.75F, -1.3125F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
                .uv(9, 13).cuboid(-1.0F, 6.25F, -2.0625F, 2.0F, 1.0F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(-1.4307F, 2.7244F, -4.7947F));

        ModelPartData flleg = rusthound.addChild("flleg", ModelPartBuilder.create().uv(12, 11).cuboid(-1.0F, 6.25F, -2.0625F, 2.0F, 1.0F, 0.75F, new Dilation(0.0F))
                .uv(17, 28).cuboid(-1.0F, -0.75F, -1.3125F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0693F, 2.7244F, -4.7947F));

        ModelPartData fullhead = rusthound.addChild("fullhead", ModelPartBuilder.create(), ModelTransform.pivot(-2.4932F, -3.6506F, -8.9822F));

        ModelPartData ears = fullhead.addChild("ears", ModelPartBuilder.create(), ModelTransform.pivot(2.8125F, 0.0F, 0.0F));

        ModelPartData rightear = ears.addChild("rightear", ModelPartBuilder.create(), ModelTransform.pivot(-2.8125F, 0.0F, 0.0F));

        ModelPartData cube_r1 = rightear.addChild("cube_r1", ModelPartBuilder.create().uv(13, 14).cuboid(-0.375F, -0.4375F, -0.125F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(13, 14).cuboid(0.625F, 0.0625F, -0.625F, 2.5F, 1.75F, 0.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.6144F));

        ModelPartData leftear = ears.addChild("leftear", ModelPartBuilder.create(), ModelTransform.pivot(2.8125F, 0.0F, 0.0F));

        ModelPartData cube_r2 = leftear.addChild("cube_r2", ModelPartBuilder.create().uv(13, 14).cuboid(-2.625F, -0.4375F, -0.125F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(13, 14).cuboid(-3.125F, 0.0625F, -0.625F, 2.5F, 1.75F, 0.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.6144F));

        ModelPartData eyes = fullhead.addChild("eyes", ModelPartBuilder.create().uv(41, 21).cuboid(1.25F, -0.5F, -0.075F, 1.0F, 1.0F, 0.15F, new Dilation(0.0F))
                .uv(41, 20).mirrored().cuboid(-2.25F, -0.5F, -0.075F, 1.0F, 1.0F, 0.15F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.8125F, 1.125F, -3.15F));

        ModelPartData nose = fullhead.addChild("nose", ModelPartBuilder.create().uv(31, 31).cuboid(-2.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.8125F, 2.625F, -4.625F));

        ModelPartData fangs = nose.addChild("fangs", ModelPartBuilder.create().uv(3, 2).mirrored().cuboid(1.6F, -2.0F, 0.5F, 0.3F, 1.2F, 0.4F, new Dilation(0.0F)).mirrored(false)
                .uv(3, 2).cuboid(-0.5F, -2.0F, 0.5F, 0.3F, 1.2F, 0.4F, new Dilation(0.0F)), ModelTransform.pivot(-0.7F, 2.4F, -1.5F));

        ModelPartData jaw = fullhead.addChild("jaw", ModelPartBuilder.create().uv(15, 32).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.8125F, 3.625F, -3.125F));

        ModelPartData head = fullhead.addChild("head", ModelPartBuilder.create().uv(13, 18).cuboid(-3.0F, -3.0F, -2.5F, 6.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(2.8125F, 2.125F, -0.625F));

        ModelPartData eybrws = fullhead.addChild("eybrws", ModelPartBuilder.create(), ModelTransform.pivot(2.8125F, 0.175F, -3.225F));

        ModelPartData eybrwleft = eybrws.addChild("eybrwleft", ModelPartBuilder.create().uv(15, 17).cuboid(-1.2F, -0.45F, -0.1F, 2.4F, 0.9F, 0.2F, new Dilation(0.0F)), ModelTransform.pivot(1.8F, 0.0F, 0.0F));

        ModelPartData eybrwright = eybrws.addChild("eybrwright", ModelPartBuilder.create().uv(15, 17).mirrored().cuboid(-1.2F, -0.45F, -0.1F, 2.4F, 0.9F, 0.2F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.8F, 0.0F, 0.0F));

        ModelPartData tail = rusthound.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.3193F, -1.6021F, 10.0802F));

        ModelPartData cube_r3 = tail.addChild("cube_r3", ModelPartBuilder.create().uv(17, 10).cuboid(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, 2.25F, 1.4835F, 0.0F, 0.0F));

        ModelPartData hair = rusthound.addChild("hair", ModelPartBuilder.create(), ModelTransform.pivot(0.3193F, -3.2756F, -4.1072F));

        ModelPartData bone = hair.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0695F, 4.061F));

        ModelPartData cube_r4 = bone.addChild("cube_r4", ModelPartBuilder.create().uv(7, 5).cuboid(-1.0F, -2.0F, -2.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.9305F, 2.939F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r5 = bone.addChild("cube_r5", ModelPartBuilder.create().uv(3, 3).cuboid(-1.0F, -2.0F, -2.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -0.0695F, -4.061F, -0.1309F, 0.0F, 0.0F));

        ModelPartData bone2 = hair.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0695F, 4.061F));

        ModelPartData cube_r6 = bone2.addChild("cube_r6", ModelPartBuilder.create().uv(1, 4).cuboid(1.0F, -2.0F, -2.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.9305F, 2.939F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r7 = bone2.addChild("cube_r7", ModelPartBuilder.create().uv(3, 4).cuboid(1.0F, -2.0F, -2.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.0695F, -4.061F, -0.1309F, 0.0F, 0.0F));

        ModelPartData belly = rusthound.addChild("belly", ModelPartBuilder.create().uv(2, 7).cuboid(-3.0F, -2.875F, -2.75F, 6.0F, 5.75F, 5.5F, new Dilation(0.0F)), ModelTransform.pivot(0.3193F, -0.6506F, 2.1428F));

        ModelPartData popik = rusthound.addChild("popik", ModelPartBuilder.create().uv(1, 7).cuboid(-3.25F, -3.375F, -2.625F, 6.5F, 6.75F, 5.25F, new Dilation(0.0F)), ModelTransform.pivot(0.3193F, -0.4006F, 7.5178F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(RustHoundEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(RustHoundAnimations.ANIM_RUST_HOUND_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, RustHoundAnimations.ANIM_RUST_HOUND_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0f);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.fullhead.yaw = headYaw * 0.017453292F;
        this.fullhead.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        rusthound.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return rusthound;
    }
}
