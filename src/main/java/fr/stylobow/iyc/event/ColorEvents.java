package fr.stylobow.iyc.event;

import fr.stylobow.iyc.block.ModBlocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.awt.Color;

@EventBusSubscriber(modid = "iyc", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorEvents {

    public static final int C_WHITE      = 0xFFFFFF;
    public static final int C_ORANGE     = 0xFF8130;
    public static final int C_MAGENTA    = 0xFF44FF;
    public static final int C_LIGHT_BLUE = 0x30B0FF;
    public static final int C_YELLOW     = 0xFFE730;
    public static final int C_LIME       = 0x2CFF2C;
    public static final int C_PINK       = 0xFF69B4;
    public static final int C_GRAY       = 0x555555;
    public static final int C_LIGHT_GRAY = 0xAAAAAA;
    public static final int C_CYAN       = 0x00AAAA;
    public static final int C_PURPLE     = 0x850C99;
    public static final int C_BLUE       = 0x1111AA;
    public static final int C_BROWN      = 0x8A4B19;
    public static final int C_GREEN      = 0x216E16;
    public static final int C_RED        = 0xCC1515;
    public static final int C_BLACK      = 0x202020;

    @SubscribeEvent
    public static void onBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_LIME, ModBlocks.LIME_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_PINK, ModBlocks.PINK_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_GRAY, ModBlocks.GRAY_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_CYAN, ModBlocks.CYAN_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_BLUE, ModBlocks.BLUE_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_BROWN, ModBlocks.BROWN_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_GREEN, ModBlocks.GREEN_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_RED, ModBlocks.RED_IRON_BLOCK.get());
        event.register((state, level, pos, tintIndex) -> C_BLACK, ModBlocks.BLACK_IRON_BLOCK.get());

        event.register((state, level, pos, tintIndex) -> C_WHITE, ModBlocks.WHITE_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_LIME, ModBlocks.LIME_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_PINK, ModBlocks.PINK_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_GRAY, ModBlocks.GRAY_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_CYAN, ModBlocks.CYAN_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_BLUE, ModBlocks.BLUE_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_BROWN, ModBlocks.BROWN_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_GREEN, ModBlocks.GREEN_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_RED, ModBlocks.RED_LIGHT.get());
        event.register((state, level, pos, tintIndex) -> C_BLACK, ModBlocks.BLACK_LIGHT.get());

        event.register((state, level, pos, tintIndex) -> C_WHITE, ModBlocks.WHITE_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_LIME, ModBlocks.LIME_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_PINK, ModBlocks.PINK_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_GRAY, ModBlocks.GRAY_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_CYAN, ModBlocks.CYAN_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_BLUE, ModBlocks.BLUE_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_BROWN, ModBlocks.BROWN_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_GREEN, ModBlocks.GREEN_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_RED, ModBlocks.RED_REDSTONE_LAMP.get());
        event.register((state, level, pos, tintIndex) -> C_BLACK, ModBlocks.BLACK_REDSTONE_LAMP.get());

        event.register((state, level, pos, tintIndex) -> C_WHITE, ModBlocks.WHITE_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_LIME, ModBlocks.LIME_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_PINK, ModBlocks.PINK_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_GRAY, ModBlocks.GRAY_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_CYAN, ModBlocks.CYAN_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_BLUE, ModBlocks.BLUE_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_BROWN, ModBlocks.BROWN_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_GREEN, ModBlocks.GREEN_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_RED, ModBlocks.RED_SAND.get());
        event.register((state, level, pos, tintIndex) -> C_BLACK, ModBlocks.BLACK_SAND.get());
    }

    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_LIME, ModBlocks.LIME_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_PINK, ModBlocks.PINK_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_GRAY, ModBlocks.GRAY_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_CYAN, ModBlocks.CYAN_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_BLUE, ModBlocks.BLUE_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_BROWN, ModBlocks.BROWN_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_GREEN, ModBlocks.GREEN_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_RED, ModBlocks.RED_IRON_BLOCK.get());
        event.register((stack, tintIndex) -> C_BLACK, ModBlocks.BLACK_IRON_BLOCK.get());

        event.register((stack, tintIndex) -> C_WHITE, ModBlocks.WHITE_LIGHT.get());
        event.register((stack, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_LIGHT.get());
        event.register((stack, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_LIGHT.get());
        event.register((stack, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_LIGHT.get());
        event.register((stack, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_LIGHT.get());
        event.register((stack, tintIndex) -> C_LIME, ModBlocks.LIME_LIGHT.get());
        event.register((stack, tintIndex) -> C_PINK, ModBlocks.PINK_LIGHT.get());
        event.register((stack, tintIndex) -> C_GRAY, ModBlocks.GRAY_LIGHT.get());
        event.register((stack, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_LIGHT.get());
        event.register((stack, tintIndex) -> C_CYAN, ModBlocks.CYAN_LIGHT.get());
        event.register((stack, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_LIGHT.get());
        event.register((stack, tintIndex) -> C_BLUE, ModBlocks.BLUE_LIGHT.get());
        event.register((stack, tintIndex) -> C_BROWN, ModBlocks.BROWN_LIGHT.get());
        event.register((stack, tintIndex) -> C_GREEN, ModBlocks.GREEN_LIGHT.get());
        event.register((stack, tintIndex) -> C_RED, ModBlocks.RED_LIGHT.get());
        event.register((stack, tintIndex) -> C_BLACK, ModBlocks.BLACK_LIGHT.get());

        event.register((stack, tintIndex) -> C_WHITE, ModBlocks.WHITE_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_LIME, ModBlocks.LIME_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_PINK, ModBlocks.PINK_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_GRAY, ModBlocks.GRAY_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_CYAN, ModBlocks.CYAN_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_BLUE, ModBlocks.BLUE_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_BROWN, ModBlocks.BROWN_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_GREEN, ModBlocks.GREEN_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_RED, ModBlocks.RED_REDSTONE_LAMP.get());
        event.register((stack, tintIndex) -> C_BLACK, ModBlocks.BLACK_REDSTONE_LAMP.get());

        event.register((stack, tintIndex) -> C_WHITE, ModBlocks.WHITE_SAND.get());
        event.register((stack, tintIndex) -> C_ORANGE, ModBlocks.ORANGE_SAND.get());
        event.register((stack, tintIndex) -> C_MAGENTA, ModBlocks.MAGENTA_SAND.get());
        event.register((stack, tintIndex) -> C_LIGHT_BLUE, ModBlocks.LIGHT_BLUE_SAND.get());
        event.register((stack, tintIndex) -> C_YELLOW, ModBlocks.YELLOW_SAND.get());
        event.register((stack, tintIndex) -> C_LIME, ModBlocks.LIME_SAND.get());
        event.register((stack, tintIndex) -> C_PINK, ModBlocks.PINK_SAND.get());
        event.register((stack, tintIndex) -> C_GRAY, ModBlocks.GRAY_SAND.get());
        event.register((stack, tintIndex) -> C_LIGHT_GRAY, ModBlocks.LIGHT_GRAY_SAND.get());
        event.register((stack, tintIndex) -> C_CYAN, ModBlocks.CYAN_SAND.get());
        event.register((stack, tintIndex) -> C_PURPLE, ModBlocks.PURPLE_SAND.get());
        event.register((stack, tintIndex) -> C_BLUE, ModBlocks.BLUE_SAND.get());
        event.register((stack, tintIndex) -> C_BROWN, ModBlocks.BROWN_SAND.get());
        event.register((stack, tintIndex) -> C_GREEN, ModBlocks.GREEN_SAND.get());
        event.register((stack, tintIndex) -> C_RED, ModBlocks.RED_SAND.get());
        event.register((stack, tintIndex) -> C_BLACK, ModBlocks.BLACK_SAND.get());
        event.register((stack, tintIndex) -> {
            float hue = (System.currentTimeMillis() % 5000L) / 5000.0f;
            return Color.HSBtoRGB(hue, 0.8f, 0.8f);
        }, ModBlocks.RAINBOW_IRON_BLOCK.get());
    }
}