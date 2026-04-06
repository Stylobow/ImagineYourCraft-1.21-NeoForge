package fr.stylobow.iyc.network;

import net.minecraft.core.UUIDUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

// cosmeticType : 0 = Skin, 1 = Cape, 2 = Hat
public record SkinSyncPayload(UUID playerId, int cosmeticType, byte[] imageData) implements CustomPacketPayload {

    public static final Type<SkinSyncPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("iyc", "skin_sync"));

    public static final StreamCodec<FriendlyByteBuf, SkinSyncPayload> CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, SkinSyncPayload::playerId,
            ByteBufCodecs.INT, SkinSyncPayload::cosmeticType,
            ByteBufCodecs.BYTE_ARRAY, SkinSyncPayload::imageData,
            SkinSyncPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}