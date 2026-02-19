package fr.stylobow.iyc.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fr.stylobow.iyc.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.UUID;

public class FloatingItemLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    private static final UUID TARGET_UUID = UUID.fromString("ef3a9cb5-3544-4ba3-b0f5-2fe19d2363be");

    public FloatingItemLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {

        if (player.getUUID().equals(TARGET_UUID)) {

            poseStack.pushPose();

            float heightOffset = player.isCrouching() ? -1.0F : -1.3F;
            poseStack.translate(0.0F, heightOffset, 0.0F);

            poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

            float rotation = (ageInTicks + partialTick) * 4.0F;
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

            float scale = 0.6F;
            poseStack.scale(scale, scale, scale);

            ItemStack itemToRender = new ItemStack(Items.REDSTONE);

            Minecraft.getInstance().getItemRenderer().renderStatic(
                    itemToRender,
                    ItemDisplayContext.FIXED,
                    packedLight,
                    net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY,
                    poseStack,
                    buffer,
                    player.level(),
                    0
            );

            poseStack.popPose();
        }
    }
}