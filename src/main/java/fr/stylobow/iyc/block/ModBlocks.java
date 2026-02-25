package fr.stylobow.iyc.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.stylobow.iyc.ImagineYourCraft;
import fr.stylobow.iyc.block.custom.IronLadderBlock;
import fr.stylobow.iyc.block.custom.RainbowBlock;
import fr.stylobow.iyc.event.ColorEvents;
import fr.stylobow.iyc.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    private static BlockBehaviour.Properties getIronBlockProperties() {
        return BlockBehaviour.Properties.of()
                .strength(5.0F)
                .explosionResistance(6.0F)
                .sound(SoundType.METAL);
    }

    public static final DeferredBlock<Block> IRON_LADDER = registerBlock("iron_ladder", () -> new IronLadderBlock(BlockBehaviour.Properties.of().noCollission().strength(2.0F).sound(SoundType.METAL).noOcclusion()));

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

    private static BlockBehaviour.Properties getColorLightProperties() {
        return BlockBehaviour.Properties.of()
                .strength(5.0F)
                .sound(SoundType.METAL)
                .lightLevel(state -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0)
                .requiresCorrectToolForDrops();
    }

    public static final DeferredBlock<Block> WHITE_LIGHT = registerBlock("white_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> ORANGE_LIGHT = registerBlock("orange_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> MAGENTA_LIGHT = registerBlock("magenta_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> LIGHT_BLUE_LIGHT = registerBlock("light_blue_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> YELLOW_LIGHT = registerBlock("yellow_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> LIME_LIGHT = registerBlock("lime_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> PINK_LIGHT = registerBlock("pink_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> GRAY_LIGHT = registerBlock("gray_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> LIGHT_GRAY_LIGHT = registerBlock("light_gray_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> CYAN_LIGHT = registerBlock("cyan_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> PURPLE_LIGHT = registerBlock("purple_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> BLUE_LIGHT = registerBlock("blue_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> BROWN_LIGHT = registerBlock("brown_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> GREEN_LIGHT = registerBlock("green_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> RED_LIGHT = registerBlock("red_light", () -> new RedstoneLampBlock(getColorLightProperties()));
    public static final DeferredBlock<Block> BLACK_LIGHT = registerBlock("black_light", () -> new RedstoneLampBlock(getColorLightProperties()));

    private static BlockBehaviour.Properties getRedstoneLampProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .lightLevel(state -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0);
    }

    public static final DeferredBlock<Block> WHITE_REDSTONE_LAMP = registerBlock("white_redstone_lamp", () -> new RedstoneLampBlock(getRedstoneLampProperties()));
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

    private static BlockBehaviour.Properties getSandProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.SAND)
                .strength(0.5F)
                .sound(SoundType.SAND);
    }

    public static final DeferredBlock<Block> WHITE_SAND = registerBlock("white_sand", () -> new ColoredSandBlock(ColorEvents.C_ORANGE, getSandProperties()));
    public static final DeferredBlock<Block> ORANGE_SAND = registerBlock("orange_sand", () -> new ColoredSandBlock(ColorEvents.C_ORANGE, getSandProperties()));
    public static final DeferredBlock<Block> MAGENTA_SAND = registerBlock("magenta_sand", () -> new ColoredSandBlock(ColorEvents.C_MAGENTA, getSandProperties()));
    public static final DeferredBlock<Block> LIGHT_BLUE_SAND = registerBlock("light_blue_sand", () -> new ColoredSandBlock(ColorEvents.C_LIGHT_BLUE, getSandProperties()));
    public static final DeferredBlock<Block> YELLOW_SAND = registerBlock("yellow_sand", () -> new ColoredSandBlock(ColorEvents.C_YELLOW, getSandProperties()));
    public static final DeferredBlock<Block> LIME_SAND = registerBlock("lime_sand", () -> new ColoredSandBlock(ColorEvents.C_LIME, getSandProperties()));
    public static final DeferredBlock<Block> PINK_SAND = registerBlock("pink_sand", () -> new ColoredSandBlock(ColorEvents.C_PINK, getSandProperties()));
    public static final DeferredBlock<Block> GRAY_SAND = registerBlock("gray_sand", () -> new ColoredSandBlock(ColorEvents.C_GRAY, getSandProperties()));
    public static final DeferredBlock<Block> LIGHT_GRAY_SAND = registerBlock("light_gray_sand", () -> new ColoredSandBlock(ColorEvents.C_LIGHT_GRAY, getSandProperties()));
    public static final DeferredBlock<Block> CYAN_SAND = registerBlock("cyan_sand", () -> new ColoredSandBlock(ColorEvents.C_CYAN, getSandProperties()));
    public static final DeferredBlock<Block> PURPLE_SAND = registerBlock("purple_sand", () -> new ColoredSandBlock(ColorEvents.C_PURPLE, getSandProperties()));
    public static final DeferredBlock<Block> BLUE_SAND = registerBlock("blue_sand", () -> new ColoredSandBlock(ColorEvents.C_BLUE, getSandProperties()));
    public static final DeferredBlock<Block> BROWN_SAND = registerBlock("brown_sand", () -> new ColoredSandBlock(ColorEvents.C_BROWN, getSandProperties()));
    public static final DeferredBlock<Block> GREEN_SAND = registerBlock("green_sand", () -> new ColoredSandBlock(ColorEvents.C_GREEN, getSandProperties()));
    public static final DeferredBlock<Block> RED_SAND = registerBlock("red_sand", () -> new ColoredSandBlock(ColorEvents.C_RED, getSandProperties()));
    public static final DeferredBlock<Block> BLACK_SAND = registerBlock("black_sand", () -> new ColoredSandBlock(ColorEvents.C_BLACK, getSandProperties()));

    public static final DeferredBlock<Block> WHITE_WOOL_SLAB = registerBlock("white_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> ORANGE_WOOL_SLAB = registerBlock("orange_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> MAGENTA_WOOL_SLAB = registerBlock("magenta_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> LIGHT_BLUE_WOOL_SLAB = registerBlock("light_blue_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> YELLOW_WOOL_SLAB = registerBlock("yellow_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> LIME_WOOL_SLAB = registerBlock("lime_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> PINK_WOOL_SLAB = registerBlock("pink_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> GRAY_WOOL_SLAB = registerBlock("gray_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> LIGHT_GRAY_WOOL_SLAB = registerBlock("light_gray_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> CYAN_WOOL_SLAB = registerBlock("cyan_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> PURPLE_WOOL_SLAB = registerBlock("purple_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> BLUE_WOOL_SLAB = registerBlock("blue_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> BROWN_WOOL_SLAB = registerBlock("brown_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> GREEN_WOOL_SLAB = registerBlock("green_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> RED_WOOL_SLAB = registerBlock("red_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));
    public static final DeferredBlock<Block> BLACK_WOOL_SLAB = registerBlock("black_wool_slab", () -> new SlabBlock(getWoolSlabProperties()));

    private static BlockBehaviour.Properties getWoolSlabProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.8F)
                .sound(SoundType.WOOL);
    }



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

    public static class ColoredSandBlock extends FallingBlock {

        public static final MapCodec<ColoredSandBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Codec.INT.fieldOf("dust_color").forGetter(block -> block.dustColor),
                        propertiesCodec()
                ).apply(instance, ColoredSandBlock::new)
        );

        private final int dustColor;

        public ColoredSandBlock(int dustColor, Properties properties) {
            super(properties);
            this.dustColor = dustColor;
        }

        @Override
        protected MapCodec<? extends FallingBlock> codec() {
            return CODEC;
        }

        @Override
        public int getDustColor(BlockState state, BlockGetter level, BlockPos pos) {
            return this.dustColor;
        }
    }
}
