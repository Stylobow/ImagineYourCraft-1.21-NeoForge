package fr.stylobow.iyc.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.stylobow.iyc.client.model.HatModel;
import fr.stylobow.iyc.client.skin.CustomSkinManager;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class HatLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    private final HatModel<AbstractClientPlayer> hatModel;

    public HatLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent, EntityModelSet modelSet) {
        super(parent);
        this.hatModel = new HatModel<>(modelSet.bakeLayer(HatModel.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        ResourceLocation customHat = CustomSkinManager.getHatTexture(player.getUUID());

        if (customHat == null) {
            return;
        }

        poseStack.pushPose();

        this.getParentModel().getHead().translateAndRotate(poseStack);
        poseStack.translate(0.0f, -1.99f, 0.0f);

        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(customHat));
        this.hatModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        poseStack.popPose();
    }
}