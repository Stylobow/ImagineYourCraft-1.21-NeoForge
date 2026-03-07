package fr.stylobow.iyc;

import fr.stylobow.iyc.block.ModBlocks;
import fr.stylobow.iyc.block.entity.ChairRenderer;
import fr.stylobow.iyc.block.entity.ModBlockEntities;
import fr.stylobow.iyc.block.entity.ModEntities;
import fr.stylobow.iyc.config.ClientConfig;
import fr.stylobow.iyc.item.ModArmorMaterials;
import fr.stylobow.iyc.item.ModCreativeModeTabs;
import fr.stylobow.iyc.item.ModItems;
import fr.stylobow.iyc.sound.ModSounds;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(ImagineYourCraft.MOD_ID)
public class ImagineYourCraft {
    public static final String MOD_ID = "iyc";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ImagineYourCraft(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModEntities.ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    private void addCreative(BuildCreativeModeTabContentsEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = ImagineYourCraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    static class ClientModEvents {

        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {
            fr.stylobow.iyc.client.config.IYCConfig.load();
        }

        @SubscribeEvent
        static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.CHAIR_ENTITY.get(), ChairRenderer::new);
        }
    }
}