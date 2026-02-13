package fr.stylobow.iyn.item;

import fr.stylobow.iyn.ImagineYourNight;
import fr.stylobow.iyn.block.ModBlocks;
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
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ImagineYourNight.MOD_ID);

    public static final Supplier<CreativeModeTab>  IYN_BLOCKS_TAB = CREATIVE_MODE_TAB.register("iyn_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TOPAZE_BLOCK.asItem()))
                    .title(Component.translatable("creative.iyn.blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.TOPAZE_BLOCK);
                        output.accept(ModBlocks.TOPAZE_ORE);
                    }).build());

    public static final Supplier<CreativeModeTab>  IYN_MATERIALS_TAB = CREATIVE_MODE_TAB.register("iyn_materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OBSIDIAN_INGOT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ImagineYourNight.MOD_ID, "iyn_blocks_tab"))
                    .title(Component.translatable("creative.iyn.materials"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.OBSIDIAN_INGOT);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
