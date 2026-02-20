package fr.stylobow.iyc.block;

import fr.stylobow.iyc.ImagineYourCraft;
import fr.stylobow.iyc.block.custom.RainbowBlock;
import fr.stylobow.iyc.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ImagineYourCraft.MOD_ID);

    public static final DeferredBlock<Block> TOPAZE_BLOCK = registerBlock("topaze_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock<Block> TOPAZE_ORE = registerBlock("topaze_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_TOPAZE_ORE = registerBlock("deepslate_topaze_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.DEEPSLATE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(4.5F, 3.0F)
                            .sound(SoundType.DEEPSLATE)
            )
    );

    public static final DeferredBlock<Block> RUBIS_BLOCK = registerBlock("rubis_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock<Block> RUBIS_ORE = registerBlock("rubis_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_RUBIS_ORE = registerBlock("deepslate_rubis_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.DEEPSLATE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(4.5F, 3.0F)
                            .sound(SoundType.DEEPSLATE)
            )
    );

    public static final DeferredBlock<Block> SAPHIR_BLOCK = registerBlock("saphir_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock<Block> SAPHIR_ORE = registerBlock("saphir_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_SAPHIR_ORE = registerBlock("deepslate_saphir_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.DEEPSLATE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(4.5F, 3.0F)
                            .sound(SoundType.DEEPSLATE)
            )
    );

    public static final DeferredBlock<Block> RED_LIGHT = registerBlock("red_light",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of()
                    .strength(2.5F)
                    .sound(SoundType.METAL)
                    .lightLevel(state -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0)
                    .requiresCorrectToolForDrops()
            )
    );

    private static BlockBehaviour.Properties getIronBlockProperties() {
        return BlockBehaviour.Properties.of()
                .strength(5.0F)
                .explosionResistance(6.0F)
                .sound(SoundType.METAL);
    }

    public static final DeferredBlock<Block> ORANGE_IRON_BLOCK = registerBlock("orange_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> MAGENTA_IRON_BLOCK = registerBlock("magenta_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> LIGHT_BLUE_IRON_BLOCK = registerBlock("light_blue_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> YELLOW_IRON_BLOCK = registerBlock("yellow_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> LIME_IRON_BLOCK = registerBlock("lime_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> PINK_IRON_BLOCK = registerBlock("pink_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> GRAY_IRON_BLOCK = registerBlock("gray_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> LIGHT_GRAY_IRON_BLOCK = registerBlock("light_gray_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> CYAN_IRON_BLOCK = registerBlock("cyan_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> PURPLE_IRON_BLOCK = registerBlock("purple_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> BLUE_IRON_BLOCK = registerBlock("blue_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> BROWN_IRON_BLOCK = registerBlock("brown_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> GREEN_IRON_BLOCK = registerBlock("green_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> RED_IRON_BLOCK = registerBlock("red_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> BLACK_IRON_BLOCK = registerBlock("black_iron_block", () -> new Block(getIronBlockProperties()));
    public static final DeferredBlock<Block> RAINBOW_IRON_BLOCK = registerBlock("rainbow_iron_block",
            () -> new RainbowBlock(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion()
            )
    );

    private static BlockBehaviour.Properties getRedstoneLampProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .lightLevel(state -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0);
    }

    public static final DeferredBlock<Block> ORANGE_REDSTONE_LAMP = registerBlock("orange_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> MAGENTA_REDSTONE_LAMP = registerBlock("magenta_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> LIGHT_BLUE_REDSTONE_LAMP = registerBlock("light_blue_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> YELLOW_REDSTONE_LAMP = registerBlock("yellow_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> LIME_REDSTONE_LAMP = registerBlock("lime_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> PINK_REDSTONE_LAMP = registerBlock("pink_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> GRAY_REDSTONE_LAMP = registerBlock("gray_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> LIGHT_GRAY_REDSTONE_LAMP = registerBlock("light_gray_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> CYAN_REDSTONE_LAMP = registerBlock("cyan_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> PURPLE_REDSTONE_LAMP = registerBlock("purple_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> BLUE_REDSTONE_LAMP = registerBlock("blue_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> BROWN_REDSTONE_LAMP = registerBlock("brown_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> GREEN_REDSTONE_LAMP = registerBlock("green_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> RED_REDSTONE_LAMP = registerBlock("red_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
    public static final DeferredBlock<Block> BLACK_REDSTONE_LAMP = registerBlock("black_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
