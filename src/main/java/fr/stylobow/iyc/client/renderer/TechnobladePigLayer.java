package fr.stylobow.iyc.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Pig;

public class TechnobladePigLayer extends RenderLayer<Pig, PigModel<Pig>> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("iyc", "textures/entity/technoblade_pig.png");

    public TechnobladePigLayer(RenderLayerParent<Pig, PigModel<Pig>> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Pig pig, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {

        if (pig.hasCustomName() && "Technoblade".equals(pig.getCustomName().getString())) {

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));

            poseStack.pushPose();

            poseStack.scale(1f, 1f, 1f);

            this.getParentModel().renderToBuffer(
                    poseStack,
                    vertexConsumer,
                    packedLight,
                    LivingEntityRenderer.getOverlayCoords(pig, 0.0F),
                    0xFFFFFFFF
            );

            poseStack.popPose();
        }
    }
}