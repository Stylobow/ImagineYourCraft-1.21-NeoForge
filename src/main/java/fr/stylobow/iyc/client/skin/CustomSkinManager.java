package fr.stylobow.iyc.client.skin;

import com.mojang.blaze3d.platform.NativeImage;
import fr.stylobow.iyc.client.config.IYCConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.function.Supplier;

@EventBusSubscriber(modid = "iyc", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class CustomSkinManager {

    private static ResourceLocation customSkinLocation = null;
    private static String loadedPath = "";

    @SubscribeEvent
    public static void onPlayerLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {}
            Minecraft.getInstance().execute(CustomSkinManager::applySkin);
        }).start();
    }

    public static void applySkin() {
        String path = IYCConfig.data.customSkinPath;
        if (path == null || path.isEmpty()) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.getConnection() == null) return;

        if (!path.equals(loadedPath)) {
            try {
                File file = new File(path);
                if (!file.exists()) return;

                InputStream is = new FileInputStream(file);
                NativeImage image = NativeImage.read(is);
                is.close();

                int width = image.getWidth();
                int height = image.getHeight();

                boolean isValidWidth = (width % 64 == 0);
                boolean isValidHeight = (height == width || height == width / 2);

                if (!isValidWidth || !isValidHeight) {
                    image.close();
                    return;
                }

                DynamicTexture texture = new DynamicTexture(image);
                ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("iyc", "custom_skin_" + System.currentTimeMillis());

                mc.execute(() -> {
                    mc.getTextureManager().register(rl, texture);
                    customSkinLocation = rl;
                    loadedPath = path;
                    injectSkin(mc);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (customSkinLocation != null) {
            mc.execute(() -> injectSkin(mc));
        }
    }

    private static void injectSkin(Minecraft mc) {
        PlayerInfo info = mc.getConnection().getPlayerInfo(mc.player.getUUID());
        if (info == null) return;

        try {
            PlayerSkin oldSkin = info.getSkin();
            PlayerSkin newSkin = new PlayerSkin(
                    customSkinLocation,
                    oldSkin.textureUrl(),
                    oldSkin.capeTexture(),
                    oldSkin.elytraTexture(),
                    oldSkin.model(),
                    oldSkin.secure()
            );

            for (Field field : PlayerInfo.class.getDeclaredFields()) {
                if (field.getType() == Supplier.class) {
                    field.setAccessible(true);
                    field.set(info, (Supplier<PlayerSkin>) () -> newSkin);
                    break;
                } else if (field.getType() == PlayerSkin.class) {
                    field.setAccessible(true);
                    field.set(info, newSkin);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}