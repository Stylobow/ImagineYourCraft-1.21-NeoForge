package fr.stylobow.iyc.network;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = "iyc", bus = EventBusSubscriber.Bus.MOD)
public class NetworkHandler {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("iyc");

        registrar.playBidirectional(
                SkinSyncPayload.TYPE,
                SkinSyncPayload.CODEC,
                (payload, context) -> {
                    if (context.flow().isServerbound()) {
                        context.enqueueWork(() -> {
                            ServerPlayer sender = (ServerPlayer) context.player();
                            PacketDistributor.sendToAllPlayers(new SkinSyncPayload(sender.getUUID(), payload.cosmeticType(), payload.imageData()));
                        });
                    }
                    else {
                        context.enqueueWork(() -> {
                            fr.stylobow.iyc.client.skin.CustomSkinManager.receiveSkinPacket(payload.playerId(), payload.cosmeticType(), payload.imageData());
                        });
                    }
                }
        );
    }
}