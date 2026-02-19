package fr.stylobow.iyc.event;

import fr.stylobow.iyc.client.renderer.TechnobladePigLayer;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "iyc", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderEvents {

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        LivingEntityRenderer<Pig, PigModel<Pig>> pigRenderer = event.getRenderer(EntityType.PIG);

        if (pigRenderer != null) {
            pigRenderer.addLayer(new TechnobladePigLayer(pigRenderer));
        }
    }
}