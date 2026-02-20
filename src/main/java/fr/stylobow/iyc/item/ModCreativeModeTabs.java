package fr.stylobow.iyc.item;

import fr.stylobow.iyc.ImagineYourCraft;
import fr.stylobow.iyc.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TAB =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ImagineYourCraft.MOD_ID);

    public static final Supplier<CreativeModeTab>  IYC_BLOCKS_TAB = CREATIVE_MODE_TAB.register("iyc_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RUBIS_BLOCK.asItem()))
                    .title(Component.translatable("creative.iyc.blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.RUBIS_BLOCK);
                        output.accept(ModBlocks.TOPAZE_BLOCK);
                        output.accept(ModBlocks.SAPHIR_BLOCK);
                        output.accept(ModBlocks.RUBIS_ORE);
                        output.accept(ModBlocks.TOPAZE_ORE);
                        output.accept(ModBlocks.SAPHIR_ORE);
                        output.accept(ModBlocks.DEEPSLATE_RUBIS_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TOPAZE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SAPHIR_ORE);
                    }).build());

    public static final Supplier<CreativeModeTab>  IYC_MATERIALS_TAB = CREATIVE_MODE_TAB.register("iyc_materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OBSIDIAN_INGOT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ImagineYourCraft.MOD_ID, "iyc_color_blocks_tab"))
                    .title(Component.translatable("creative.iyc.materials"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.OBSIDIAN_INGOT);
                        output.accept(ModItems.STEEL_STICK);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.RUBIS);
                        output.accept(ModItems.SAPHIR);
                        output.accept(ModItems.TOPAZE);
                        output.accept(ModItems.CHOPPE);
                        output.accept(ModItems.MAILLE);
                        output.accept(ModItems.LIGNITE);
                        output.accept(ModItems.HOPS);
                        output.accept(ModItems.STONE_STICK);
                        output.accept(ModItems.CAFEINE);
                        output.accept(ModItems.COLA);
                        output.accept(ModItems.CANETTE);
                        output.accept(ModItems.TAURINE);
                        output.accept(ModItems.EMPTY_GLASS);
                        output.accept(ModItems.RECORD_TAKE_BACK_NIGHT);
                        output.accept(ModItems.RECORD_ZOMBIES);
                        output.accept(ModItems.RECORD_CHUNKS);
                        output.accept(ModItems.RECORD_CREEP);
                        output.accept(ModItems.RECORD_NOFRAGAYS);
                        output.accept(ModItems.RECORD_SEAN_KEVIN);
                        output.accept(ModItems.RECORD_GIVE);
                        output.accept(ModItems.RECORD_PELLES);
                        output.accept(ModItems.RECORD_GEEK);
                        output.accept(ModItems.RECORD_ACTA);
                        output.accept(ModItems.RECORD_TOUCH);
                        output.accept(ModItems.RECORD_MC_STYLE);
                        output.accept(ModItems.SLATE_ITEM);
                        output.accept(ModItems.ADAMANTIUM_FRAGMENT);
                    }).build());

    public static final Supplier<CreativeModeTab>  IYC_COLOR_BLOCKS_TAB = CREATIVE_MODE_TAB.register("iyc_color_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LIGHT_BLUE_IRON_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ImagineYourCraft.MOD_ID, "iyc_blocks_tab"))
                    .title(Component.translatable("creative.iyc.color_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.RED_LIGHT);
                        output.accept(ModBlocks.ORANGE_IRON_BLOCK);
                        output.accept(ModBlocks.MAGENTA_IRON_BLOCK);
                        output.accept(ModBlocks.LIGHT_BLUE_IRON_BLOCK);
                        output.accept(ModBlocks.YELLOW_IRON_BLOCK);
                        output.accept(ModBlocks.LIME_IRON_BLOCK);
                        output.accept(ModBlocks.PINK_IRON_BLOCK);
                        output.accept(ModBlocks.GRAY_IRON_BLOCK);
                        output.accept(ModBlocks.LIGHT_GRAY_IRON_BLOCK);
                        output.accept(ModBlocks.CYAN_IRON_BLOCK);
                        output.accept(ModBlocks.PURPLE_IRON_BLOCK);
                        output.accept(ModBlocks.BLUE_IRON_BLOCK);
                        output.accept(ModBlocks.BROWN_IRON_BLOCK);
                        output.accept(ModBlocks.GREEN_IRON_BLOCK);
                        output.accept(ModBlocks.RED_IRON_BLOCK);
                        output.accept(ModBlocks.BLACK_IRON_BLOCK);
                        output.accept(ModBlocks.RAINBOW_IRON_BLOCK);
                        output.accept(ModBlocks.ORANGE_REDSTONE_LAMP);
                        output.accept(ModBlocks.MAGENTA_REDSTONE_LAMP);
                        output.accept(ModBlocks.LIGHT_BLUE_REDSTONE_LAMP);
                        output.accept(ModBlocks.YELLOW_REDSTONE_LAMP);
                        output.accept(ModBlocks.LIME_REDSTONE_LAMP);
                        output.accept(ModBlocks.PINK_REDSTONE_LAMP);
                        output.accept(ModBlocks.GRAY_REDSTONE_LAMP);
                        output.accept(ModBlocks.LIGHT_GRAY_REDSTONE_LAMP);
                        output.accept(ModBlocks.CYAN_REDSTONE_LAMP);
                        output.accept(ModBlocks.PURPLE_REDSTONE_LAMP);
                        output.accept(ModBlocks.BLUE_REDSTONE_LAMP);
                        output.accept(ModBlocks.BROWN_REDSTONE_LAMP);
                        output.accept(ModBlocks.GREEN_REDSTONE_LAMP);
                        output.accept(ModBlocks.RED_REDSTONE_LAMP);
                        output.accept(ModBlocks.BLACK_REDSTONE_LAMP);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
