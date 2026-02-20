package fr.stylobow.iyc.event;

import fr.stylobow.iyc.block.ModBlocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = "iyc", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorEvents {

    @SubscribeEvent
    public static void onBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) -> 0xFF8130, ModBlocks.ORANGE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0xFF44FF, ModBlocks.MAGENTA_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x30B0FF, ModBlocks.LIGHT_BLUE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0xFFE730, ModBlocks.YELLOW_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x2CFF2C, ModBlocks.LIME_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0xFE3BFF, ModBlocks.PINK_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x555555, ModBlocks.GRAY_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0xAAAAAA, ModBlocks.LIGHT_GRAY_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x00AAAA, ModBlocks.CYAN_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x8500AA, ModBlocks.PURPLE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x0000AA, ModBlocks.BLUE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x66360F, ModBlocks.BROWN_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x0A5200, ModBlocks.GREEN_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0xBA1818, ModBlocks.RED_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> 0x151515, ModBlocks.BLACK_IRON_BLOCK.get());
    }

    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> 0xFF8130, ModBlocks.ORANGE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0xFF44FF, ModBlocks.MAGENTA_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x30B0FF, ModBlocks.LIGHT_BLUE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0xFFE730, ModBlocks.YELLOW_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x2CFF2C, ModBlocks.LIME_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0xFE3BFF, ModBlocks.PINK_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x555555, ModBlocks.GRAY_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0xAAAAAA, ModBlocks.LIGHT_GRAY_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x00AAAA, ModBlocks.CYAN_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x8500AA, ModBlocks.PURPLE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x0000AA, ModBlocks.BLUE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x66360F, ModBlocks.BROWN_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x0A5200, ModBlocks.GREEN_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0xBA1818, ModBlocks.RED_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> 0x151515, ModBlocks.BLACK_IRON_BLOCK.get());
    }
}