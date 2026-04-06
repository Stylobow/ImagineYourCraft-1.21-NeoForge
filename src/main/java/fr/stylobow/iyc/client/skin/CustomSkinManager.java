package fr.stylobow.iyc.client.skin;

import com.mojang.blaze3d.platform.NativeImage;
import fr.stylobow.iyc.client.config.IYCConfig;
import fr.stylobow.iyc.network.SkinSyncPayload;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

@EventBusSubscriber(modid = "iyc", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class CustomSkinManager {

    private static final Map<UUID, ResourceLocation> playerSkins = new HashMap<>();
    private static final Map<UUID, ResourceLocation> playerCapes = new HashMap<>();
    private static final Map<UUID, ResourceLocation> playerHats = new HashMap<>();

    private static String loadedSkinPath = "";
    private static String loadedCapePath = "";
    private static String loadedHatPath = "";

    @SubscribeEvent
    public static void onPlayerLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {}
            Minecraft.getInstance().execute(() -> {
                loadedSkinPath = "";
                loadedCapePath = "";
                loadedHatPath = "";
                applySkin();
                applyCape();
                applyHat();
            });
        }).start();
    }

    public static void applySkin() {
        String path = IYCConfig.data.customSkinPath;
        if (path == null || path.isEmpty()) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.getConnection() == null) return;

        if (!path.equals(loadedSkinPath)) {
            try {
                File file = new File(path);
                if (!file.exists()) return;
                byte[] imageData = Files.readAllBytes(file.toPath());
                InputStream is = new ByteArrayInputStream(imageData);
                NativeImage image = NativeImage.read(is);
                is.close();

                int width = image.getWidth();
                int height = image.getHeight();
                if (!(width % 64 == 0) || !(height == width || height == width / 2)) {
                    image.close();
                    return;
                }

                DynamicTexture texture = new DynamicTexture(image);
                ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("iyc", "custom_skin_" + mc.player.getUUID() + "_" + System.currentTimeMillis());

                mc.execute(() -> {
                    mc.getTextureManager().register(rl, texture);
                    playerSkins.put(mc.player.getUUID(), rl);
                    loadedSkinPath = path;
                    refreshSpecificPlayer(mc, mc.player.getUUID());
                    PacketDistributor.sendToServer(new SkinSyncPayload(mc.player.getUUID(), 0, imageData));
                });
            } catch (Exception e) { e.printStackTrace(); }
        } else if (playerSkins.containsKey(mc.player.getUUID())) {
            mc.execute(() -> refreshSpecificPlayer(mc, mc.player.getUUID()));
        }
    }

    public static void applyCape() {
        String path = IYCConfig.data.customCapePath;
        if (path == null || path.isEmpty()) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.getConnection() == null) return;

        if (!path.equals(loadedCapePath)) {
            try {
                File file = new File(path);
                if (!file.exists()) return;
                byte[] imageData = Files.readAllBytes(file.toPath());
                InputStream is = new ByteArrayInputStream(imageData);
                NativeImage image = NativeImage.read(is);
                is.close();

                DynamicTexture texture = new DynamicTexture(image);
                ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("iyc", "custom_cape_" + mc.player.getUUID() + "_" + System.currentTimeMillis());

                mc.execute(() -> {
                    mc.getTextureManager().register(rl, texture);
                    playerCapes.put(mc.player.getUUID(), rl);
                    loadedCapePath = path;
                    refreshSpecificPlayer(mc, mc.player.getUUID());
                    PacketDistributor.sendToServer(new SkinSyncPayload(mc.player.getUUID(), 1, imageData));
                });
            } catch (Exception e) { e.printStackTrace(); }
        } else if (playerCapes.containsKey(mc.player.getUUID())) {
            mc.execute(() -> refreshSpecificPlayer(mc, mc.player.getUUID()));
        }
    }

    public static void applyHat() {
        String path = IYCConfig.data.customHatPath;
        if (path == null || path.isEmpty()) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.getConnection() == null) return;

        if (!path.equals(loadedHatPath)) {
            try {
                File file = new File(path);
                if (!file.exists()) return;
                byte[] imageData = Files.readAllBytes(file.toPath());
                InputStream is = new ByteArrayInputStream(imageData);
                NativeImage image = NativeImage.read(is);
                is.close();

                DynamicTexture texture = new DynamicTexture(image);
                ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("iyc", "custom_hat_" + mc.player.getUUID() + "_" + System.currentTimeMillis());

                mc.execute(() -> {
                    mc.getTextureManager().register(rl, texture);
                    playerHats.put(mc.player.getUUID(), rl);
                    loadedHatPath = path;
                    PacketDistributor.sendToServer(new SkinSyncPayload(mc.player.getUUID(), 2, imageData));
                });
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public static void resetSkin() {
        IYCConfig.data.customSkinPath = "";
        IYCConfig.save();
        loadedSkinPath = "";
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        playerSkins.remove(mc.player.getUUID());
        refreshSpecificPlayer(mc, mc.player.getUUID());
        PacketDistributor.sendToServer(new SkinSyncPayload(mc.player.getUUID(), 0, new byte[0]));
    }

    public static void resetCape() {
        IYCConfig.data.customCapePath = "";
        IYCConfig.save();
        loadedCapePath = "";
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        playerCapes.remove(mc.player.getUUID());
        refreshSpecificPlayer(mc, mc.player.getUUID());
        PacketDistributor.sendToServer(new SkinSyncPayload(mc.player.getUUID(), 1, new byte[0]));
    }

    public static void resetHat() {
        IYCConfig.data.customHatPath = "";
        IYCConfig.save();
        loadedHatPath = "";
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        playerHats.remove(mc.player.getUUID());
        PacketDistributor.sendToServer(new SkinSyncPayload(mc.player.getUUID(), 2, new byte[0]));
    }

    public static void receiveSkinPacket(UUID playerId, int cosmeticType, byte[] imageData) {
        Minecraft mc = Minecraft.getInstance();
        mc.execute(() -> {
            if (imageData.length == 0) {
                if (cosmeticType == 1) playerCapes.remove(playerId);
                else if (cosmeticType == 2) playerHats.remove(playerId);
                else playerSkins.remove(playerId);

                if (cosmeticType != 2) refreshSpecificPlayer(mc, playerId);
                return;
            }

            try {
                InputStream is = new ByteArrayInputStream(imageData);
                NativeImage image = NativeImage.read(is);
                is.close();

                DynamicTexture texture = new DynamicTexture(image);
                String typeStr = cosmeticType == 1 ? "cape" : (cosmeticType == 2 ? "hat" : "skin");
                ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("iyc", "custom_" + typeStr + "_" + playerId + "_" + System.currentTimeMillis());

                mc.getTextureManager().register(rl, texture);

                if (cosmeticType == 1) playerCapes.put(playerId, rl);
                else if (cosmeticType == 2) playerHats.put(playerId, rl);
                else playerSkins.put(playerId, rl);

                if (cosmeticType != 2) refreshSpecificPlayer(mc, playerId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void refreshSpecificPlayer(Minecraft mc, UUID playerId) {
        if (mc.getConnection() == null) return;
        PlayerInfo info = mc.getConnection().getPlayerInfo(playerId);
        if (info == null) return;

        try {
            PlayerSkin originalSkin = mc.getSkinManager().getInsecureSkin(info.getProfile());
            ResourceLocation finalSkin = playerSkins.getOrDefault(playerId, originalSkin.texture());
            ResourceLocation finalCape = playerCapes.getOrDefault(playerId, originalSkin.capeTexture());
            ResourceLocation finalElytra = playerCapes.getOrDefault(playerId, originalSkin.elytraTexture());

            PlayerSkin newSkin = new PlayerSkin(finalSkin, originalSkin.textureUrl(), finalCape, finalElytra, originalSkin.model(), originalSkin.secure());

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

    public static ResourceLocation getHatTexture(UUID playerId) {
        return playerHats.get(playerId);
    }
}