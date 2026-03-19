package fr.stylobow.iyc.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.stylobow.iyc.ImagineYourCraft;
import fr.stylobow.iyc.block.custom.*;
import fr.stylobow.iyc.block.custom.BarrelBlock;
import fr.stylobow.iyc.event.ColorEvents;
import fr.stylobow.iyc.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.material.PushReaction;
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
                    .mapColor(MapColor.COLOR_RED)
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
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
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

    public static final DeferredBlock<Block> LIGNITE_BLOCK = registerBlock("lignite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock<Block> LIGNITE_ORE = registerBlock("lignite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );

    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock<Block> STEEL_ORE = registerBlock("steel_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );

    public static final DeferredBlock<Block> MASSIVE_OBSIDIAN_BLOCK = registerBlock("massive_obsidian_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );

    public static final DeferredBlock<Block> SLATE_BLOCK = registerBlock("slate_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock<Block> SLATE_ORE = registerBlock("slate_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_SLATE_ORE = registerBlock("deepslate_slate_ore",
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

    public static final DeferredBlock<Block> ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock<Block> ADAMANTIUM_ORE = registerBlock("adamantium_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_ADAMANTIUM_ORE = registerBlock("deepslate_adamantium_ore",
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

    private static BlockBehaviour.Properties getLanternProperties() {
        return BlockBehaviour.Properties.of()
                .strength(2f)
                .explosionResistance(3f)
                .ignitedByLava()
                .sound(SoundType.WOOD)
                .mapColor(MapColor.WOOD)
                .lightLevel(p_152686_ -> 15)
                .instrument(NoteBlockInstrument.BASS);
    }

    public static  final DeferredBlock<Block> OAK_LANTERN = registerBlock("oak_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> SPRUCE_LANTERN = registerBlock("spruce_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> BIRCH_LANTERN = registerBlock("birch_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> JUNGLE_LANTERN = registerBlock("jungle_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> ACACIA_LANTERN = registerBlock("acacia_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> DARK_OAK_LANTERN = registerBlock("dark_oak_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> MANGROVE_LANTERN = registerBlock("mangrove_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> CHERRY_LANTERN = registerBlock("cherry_lantern", ()-> new Block(getLanternProperties()));
    public static  final DeferredBlock<Block> BAMBOO_LANTERN = registerBlock("bamboo_lantern",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).lightLevel(p_152686_ -> 15)));
    public static  final DeferredBlock<Block> IRON_LANTERN = registerBlock("iron_lantern", ()-> new Block(getLanternProperties().mapColor(MapColor.COLOR_LIGHT_GRAY)));

    public static final DeferredBlock<Block> IRON_LADDER = registerBlock("iron_ladder", () -> new IronLadderBlock(BlockBehaviour.Properties.of().noCollission().strength(2.0F).sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> GLOWSTONE_FENCE = registerBlock("glowstone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)));

    public static final DeferredBlock<Block> LOG_FENCE = registerBlock("log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<Block> STONE_FENCE = registerBlock("stone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<Block> NETHERRACK_SLAB = registerBlock("netherrack_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> OAK_REVERSED_PLANKS_SLAB = registerBlock("oak_reversed_planks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> OBSIDIAN_SLAB = registerBlock("obsidian_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> OAK_LOG_SLAB = registerBlock("oak_log_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> GLOWSTONE_SLAB = registerBlock("glowstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)));
    public static final DeferredBlock<Block> SLATE_SLAB = registerBlock("slate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.SLATE_BLOCK.get())));

    public static final DeferredBlock<Block> JUMPBOX = registerBlock("jumpbox",
            () -> new JumpBoxBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava())
    );

    public static final DeferredBlock<Block> CHERRY_PLANKS = registerBlock("cherry_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
            ));

    public static final DeferredBlock<Block> CHERRY_LOG = registerBlock("cherry_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<Block> OAK_REVERSED_PLANKS = registerBlock("oak_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_REVERSED_PLANKS = registerBlock("spruce_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_REVERSED_PLANKS = registerBlock("birch_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_REVERSED_PLANKS = registerBlock("jungle_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_REVERSED_PLANKS = registerBlock("acacia_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_REVERSED_PLANKS = registerBlock("dark_oak_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_REVERSED_PLANKS = registerBlock("mangrove_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_REVERSED_PLANKS = registerBlock("cherry_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_REVERSED_PLANKS = registerBlock("bamboo_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_REVERSED_PLANKS = registerBlock("crimson_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_REVERSED_PLANKS = registerBlock("warped_reversed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final DeferredBlock<Block> COBBLESTONE_FIRE_CAMP = registerBlock("cobblestone_fire_camp",
            () -> new FireCampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).lightLevel(state -> 15)));
    public static final DeferredBlock<Block> SMOOTH_STONE_FIRE_CAMP = registerBlock("smooth_stone_fire_camp",
            () -> new FireCampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE).lightLevel(state -> 15)));
    public static final DeferredBlock<Block> BRICKS_FIRE_CAMP = registerBlock("bricks_fire_camp",
            () -> new FireCampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).lightLevel(state -> 15)));
    public static final DeferredBlock<Block> STONE_BRICK_FIRE_CAMP = registerBlock("stone_brick_fire_camp",
            () -> new FireCampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).lightLevel(state -> 15)));
    public static final DeferredBlock<Block> SANDSTONE_FIRE_CAMP = registerBlock("sandstone_fire_camp",
            () -> new FireCampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).lightLevel(state -> 15)));

    public static final DeferredBlock<Block> STONE_SLOPES = registerBlock("stone_slopes",
            () -> new StairBlock(Blocks.STONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SLATE_SLOPES = registerBlock("slate_slopes",
            () -> new StairBlock(ModBlocks.SLATE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.SLATE_BLOCK.get())));
    public static final DeferredBlock<Block> SANDSTONE_SLOPES = registerBlock("sandstone_slopes",
            () -> new StairBlock(Blocks.SANDSTONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> GLOWSTONE_SLOPES = registerBlock("glowstone_slopes",
            () -> new StairBlock(Blocks.GLOWSTONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)));
    public static final DeferredBlock<Block> GLASS_SLOPES = registerBlock("glass_slopes",
            () -> new StairBlock(Blocks.GLASS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_PLANKS_SLOPES = registerBlock("oak_planks_slopes",
            () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_SLOPES = registerBlock("spruce_planks_slopes",
            () -> new StairBlock(Blocks.SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_SLOPES = registerBlock("birch_planks_slopes",
            () -> new StairBlock(Blocks.BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_SLOPES = registerBlock("jungle_planks_slopes",
            () -> new StairBlock(Blocks.JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_SLOPES = registerBlock("acacia_planks_slopes",
            () -> new StairBlock(Blocks.ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_SLOPES = registerBlock("dark_oak_planks_slopes",
            () -> new StairBlock(Blocks.DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_SLOPES = registerBlock("mangrove_planks_slopes",
            () -> new StairBlock(Blocks.MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_PLANKS_SLOPES = registerBlock("cherry_planks_slopes",
            () -> new StairBlock(Blocks.CHERRY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_SLOPES = registerBlock("bamboo_planks_slopes",
            () -> new StairBlock(Blocks.BAMBOO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_SLOPES = registerBlock("crimson_planks_slopes",
            () -> new StairBlock(Blocks.CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_PLANKS_SLOPES = registerBlock("warped_planks_slopes",
            () -> new StairBlock(Blocks.WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_LOG_SLOPES = registerBlock("oak_log_slopes",
            () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_LOG_SLOPES = registerBlock("spruce_log_slopes",
            () -> new StairBlock(Blocks.SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_LOG_SLOPES = registerBlock("birch_log_slopes",
            () -> new StairBlock(Blocks.BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_LOG_SLOPES = registerBlock("jungle_log_slopes",
            () -> new StairBlock(Blocks.JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_LOG_SLOPES = registerBlock("acacia_log_slopes",
            () -> new StairBlock(Blocks.ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_LOG_SLOPES = registerBlock("dark_oak_log_slopes",
            () -> new StairBlock(Blocks.DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_LOG_SLOPES = registerBlock("mangrove_log_slopes",
            () -> new StairBlock(Blocks.MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_LOG_SLOPES = registerBlock("cherry_log_slopes",
            () -> new StairBlock(Blocks.CHERRY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_LOG_SLOPES = registerBlock("bamboo_log_slopes",
            () -> new StairBlock(Blocks.BAMBOO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_LOG_SLOPES = registerBlock("crimson_log_slopes",
            () -> new StairBlock(Blocks.CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_LOG_SLOPES = registerBlock("warped_log_slopes",
            () -> new StairBlock(Blocks.WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final DeferredBlock<Block> BARREL = registerBlock("barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).noOcclusion()));

    public static final DeferredBlock<Block> WHITE_IRON_FENCE = registerBlock("white_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> ORANGE_IRON_FENCE = registerBlock("orange_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> MAGENTA_IRON_FENCE = registerBlock("magenta_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> LIGHT_BLUE_IRON_FENCE = registerBlock("light_blue_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> YELLOW_IRON_FENCE = registerBlock("yellow_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> LIME_IRON_FENCE = registerBlock("lime_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> PINK_IRON_FENCE = registerBlock("pink_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> GRAY_IRON_FENCE = registerBlock("gray_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> LIGHT_GRAY_IRON_FENCE = registerBlock("light_gray_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> CYAN_IRON_FENCE = registerBlock("cyan_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> PURPLE_IRON_FENCE = registerBlock("purple_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> BLUE_IRON_FENCE = registerBlock("blue_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> BROWN_IRON_FENCE = registerBlock("brown_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> GREEN_IRON_FENCE = registerBlock("green_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> RED_IRON_FENCE = registerBlock("red_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> BLACK_IRON_FENCE = registerBlock("black_iron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final DeferredBlock<Block> HEART_EFFECT_GENERATOR = registerBlock("heart_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.HEART, 5));
    public static final DeferredBlock<Block> SMOKE_EFFECT_GENERATOR = registerBlock("smoke_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.SMOKE, 15));
    public static final DeferredBlock<Block> PORTAL_EFFECT_GENERATOR = registerBlock("portal_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.PORTAL, 15));
    public static final DeferredBlock<Block> EXPLOSION_EFFECT_GENERATOR = registerBlock("explosion_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.EXPLOSION, 1));
    public static final DeferredBlock<Block> CLOUD_EFFECT_GENERATOR = registerBlock("cloud_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.CLOUD, 15));
    public static final DeferredBlock<Block> LAVA_EFFECT_GENERATOR = registerBlock("lava_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.LAVA, 1));
    public static final DeferredBlock<Block> WATER_EFFECT_GENERATOR = registerBlock("water_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.SPLASH, 5));
    public static final DeferredBlock<Block> LARGE_SMOKE_EFFECT_GENERATOR = registerBlock("large_smoke_effect_generator",
            () -> new EffectGeneratorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), ParticleTypes.LARGE_SMOKE, 10));

    public static final DeferredBlock<Block> WHITE_CLOUD = registerBlock("white_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).noCollission().noOcclusion(), 1.0F, 1.0F, 1.0F));
    public static final DeferredBlock<Block> ORANGE_CLOUD = registerBlock("orange_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL).noCollission().noOcclusion(), 0.95F, 0.45F, 0.0F));
    public static final DeferredBlock<Block> MAGENTA_CLOUD = registerBlock("magenta_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL).noCollission().noOcclusion(), 0.75F, 0.17F, 0.58F));
    public static final DeferredBlock<Block> LIGHT_BLUE_CLOUD = registerBlock("light_blue_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL).noCollission().noOcclusion(), 0.22F, 0.69F, 0.87F));
    public static final DeferredBlock<Block> YELLOW_CLOUD = registerBlock("yellow_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL).noCollission().noOcclusion(), 0.97F, 0.79F, 0.17F));
    public static final DeferredBlock<Block> LIME_CLOUD = registerBlock("lime_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL).noCollission().noOcclusion(), 0.5F, 0.78F, 0.1F));
    public static final DeferredBlock<Block> PINK_CLOUD = registerBlock("pink_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL).noCollission().noOcclusion(), 0.95F, 0.55F, 0.67F));
    public static final DeferredBlock<Block> GRAY_CLOUD = registerBlock("gray_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL).noCollission().noOcclusion(), 0.27F, 0.31F, 0.33F));
    public static final DeferredBlock<Block> LIGHT_GRAY_CLOUD = registerBlock("light_gray_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL).noCollission().noOcclusion(), 0.61F, 0.63F, 0.61F));
    public static final DeferredBlock<Block> CYAN_CLOUD = registerBlock("cyan_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL).noCollission().noOcclusion(), 0.08F, 0.55F, 0.59F));
    public static final DeferredBlock<Block> PURPLE_CLOUD = registerBlock("purple_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL).noCollission().noOcclusion(), 0.53F, 0.12F, 0.69F));
    public static final DeferredBlock<Block> BLUE_CLOUD = registerBlock("blue_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL).noCollission().noOcclusion(), 0.22F, 0.17F, 0.71F));
    public static final DeferredBlock<Block> BROWN_CLOUD = registerBlock("brown_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL).noCollission().noOcclusion(), 0.51F, 0.32F, 0.2F));
    public static final DeferredBlock<Block> GREEN_CLOUD = registerBlock("green_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL).noCollission().noOcclusion(), 0.36F, 0.49F, 0.14F));
    public static final DeferredBlock<Block> RED_CLOUD = registerBlock("red_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL).noCollission().noOcclusion(), 0.69F, 0.18F, 0.18F));
    public static final DeferredBlock<Block> BLACK_CLOUD = registerBlock("black_cloud", () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL).noCollission().noOcclusion(), 0.11F, 0.11F, 0.12F));

    public static final DeferredBlock<Block> OAK_SHELF = registerBlock("oak_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_SHELF = registerBlock("spruce_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_SHELF = registerBlock("birch_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_SHELF = registerBlock("jungle_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_SHELF = registerBlock("acacia_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_SHELF = registerBlock("dark_oak_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_SHELF = registerBlock("mangrove_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_SHELF = registerBlock("cherry_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_SHELF = registerBlock("bamboo_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_SHELF = registerBlock("crimson_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_SHELF = registerBlock("warped_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STONE_SHELF = registerBlock("stone_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COBBLESTONE_SHELF = registerBlock("cobblestone_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BRICK_SHELF = registerBlock("stone_brick_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_SHELF = registerBlock("deepslate_brick_shelf",
            () -> new OakShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));

    public static final DeferredBlock<Block> OAK_CHAIR = registerBlock("oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_CHAIR = registerBlock("spruce_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_CHAIR = registerBlock("birch_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_CHAIR = registerBlock("jungle_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_CHAIR = registerBlock("acacia_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_CHAIR = registerBlock("dark_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_CHAIR = registerBlock("mangrove_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_CHAIR = registerBlock("cherry_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_CHAIR = registerBlock("bamboo_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_CHAIR = registerBlock("crimson_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_CHAIR = registerBlock("warped_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STONE_CHAIR = registerBlock("stone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COBBLESTONE_CHAIR = registerBlock("cobblestone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BRICK_CHAIR = registerBlock("stone_brick_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_CHAIR = registerBlock("deepslate_brick_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));

    public static final DeferredBlock<Block> OAK_STOOL = registerBlock("oak_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_STOOL = registerBlock("spruce_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_STOOL = registerBlock("birch_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_STOOL = registerBlock("jungle_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_STOOL = registerBlock("acacia_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_STOOL = registerBlock("dark_oak_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_STOOL = registerBlock("mangrove_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_STOOL = registerBlock("cherry_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_STOOL = registerBlock("bamboo_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_STOOL = registerBlock("crimson_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_STOOL = registerBlock("warped_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STONE_STOOL = registerBlock("stone_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COBBLESTONE_STOOL = registerBlock("cobblestone_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BRICK_STOOL = registerBlock("stone_brick_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_STOOL = registerBlock("deepslate_brick_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));

    public static final DeferredBlock<Block> OAK_HIGH_STOOL = registerBlock("oak_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_HIGH_STOOL = registerBlock("spruce_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_HIGH_STOOL = registerBlock("birch_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_HIGH_STOOL = registerBlock("jungle_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_HIGH_STOOL = registerBlock("acacia_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_HIGH_STOOL = registerBlock("dark_oak_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_HIGH_STOOL = registerBlock("mangrove_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_HIGH_STOOL = registerBlock("cherry_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_HIGH_STOOL = registerBlock("bamboo_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_HIGH_STOOL = registerBlock("crimson_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_HIGH_STOOL = registerBlock("warped_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STONE_HIGH_STOOL = registerBlock("stone_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COBBLESTONE_HIGH_STOOL = registerBlock("cobblestone_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BRICK_HIGH_STOOL = registerBlock("stone_brick_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_HIGH_STOOL = registerBlock("deepslate_brick_high_stool",
            () -> new HighStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));

    public static final DeferredBlock<Block> OAK_BENCH = registerBlock("oak_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_BENCH = registerBlock("spruce_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_BENCH = registerBlock("birch_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_BENCH = registerBlock("jungle_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_BENCH = registerBlock("acacia_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_BENCH = registerBlock("dark_oak_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_BENCH = registerBlock("mangrove_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_BENCH = registerBlock("cherry_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_BENCH = registerBlock("bamboo_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_BENCH = registerBlock("crimson_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_BENCH = registerBlock("warped_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BENCH = registerBlock("stone_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COBBLESTONE_BENCH = registerBlock("cobblestone_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BRICK_BENCH = registerBlock("stone_brick_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_BENCH = registerBlock("deepslate_brick_bench",
            () -> new BenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));

    public static final DeferredBlock<Block> OAK_TABLE = registerBlock("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_TABLE = registerBlock("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_TABLE = registerBlock("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_TABLE = registerBlock("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_TABLE = registerBlock("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_TABLE = registerBlock("mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_TABLE = registerBlock("cherry_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_TABLE = registerBlock("bamboo_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_TABLE = registerBlock("crimson_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_TABLE = registerBlock("warped_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STONE_TABLE = registerBlock("stone_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COBBLESTONE_TABLE = registerBlock("cobblestone_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BRICK_TABLE = registerBlock("stone_brick_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_TABLE = registerBlock("deepslate_brick_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));

    public static final DeferredBlock<Block> OAK_LITTLE_TABLE = registerBlock("oak_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_LITTLE_TABLE = registerBlock("spruce_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_LITTLE_TABLE = registerBlock("birch_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_LITTLE_TABLE = registerBlock("jungle_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_LITTLE_TABLE = registerBlock("acacia_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_LITTLE_TABLE = registerBlock("dark_oak_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_LITTLE_TABLE = registerBlock("mangrove_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_LITTLE_TABLE = registerBlock("cherry_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_LITTLE_TABLE = registerBlock("bamboo_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_LITTLE_TABLE = registerBlock("crimson_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_LITTLE_TABLE = registerBlock("warped_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STONE_LITTLE_TABLE = registerBlock("stone_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COBBLESTONE_LITTLE_TABLE = registerBlock("cobblestone_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
    public static final DeferredBlock<Block> STONE_BRICK_LITTLE_TABLE = registerBlock("stone_brick_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_LITTLE_TABLE = registerBlock("deepslate_brick_little_table",
            () -> new LittleTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));

    public static final DeferredBlock<Block> WHITE_WOOL_STAIRS = registerBlock("white_wool_stairs",
            () -> new StairBlock(Blocks.WHITE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> ORANGE_WOOL_STAIRS = registerBlock("orange_wool_stairs",
            () -> new StairBlock(Blocks.ORANGE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_WOOL_STAIRS = registerBlock("magenta_wool_stairs",
            () -> new StairBlock(Blocks.MAGENTA_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_WOOL_STAIRS = registerBlock("light_blue_wool_stairs",
            () -> new StairBlock(Blocks.LIGHT_BLUE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> YELLOW_WOOL_STAIRS = registerBlock("yellow_wool_stairs",
            () -> new StairBlock(Blocks.YELLOW_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> LIME_WOOL_STAIRS = registerBlock("lime_wool_stairs",
            () -> new StairBlock(Blocks.LIME_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> PINK_WOOL_STAIRS = registerBlock("pink_wool_stairs",
            () -> new StairBlock(Blocks.PINK_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> GRAY_WOOL_STAIRS = registerBlock("gray_wool_stairs",
            () -> new StairBlock(Blocks.GRAY_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_WOOL_STAIRS = registerBlock("light_gray_wool_stairs",
            () -> new StairBlock(Blocks.LIGHT_GRAY_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> CYAN_WOOL_STAIRS = registerBlock("cyan_wool_stairs",
            () -> new StairBlock(Blocks.CYAN_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> PURPLE_WOOL_STAIRS = registerBlock("purple_wool_stairs",
            () -> new StairBlock(Blocks.PURPLE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> BLUE_WOOL_STAIRS = registerBlock("blue_wool_stairs",
            () -> new StairBlock(Blocks.BLUE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> BROWN_WOOL_STAIRS = registerBlock("brown_wool_stairs",
            () -> new StairBlock(Blocks.BROWN_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> GREEN_WOOL_STAIRS = registerBlock("green_wool_stairs",
            () -> new StairBlock(Blocks.GREEN_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> RED_WOOL_STAIRS = registerBlock("red_wool_stairs",
            () -> new StairBlock(Blocks.RED_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> BLACK_WOOL_STAIRS = registerBlock("black_wool_stairs",
            () -> new StairBlock(Blocks.BLACK_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));

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
