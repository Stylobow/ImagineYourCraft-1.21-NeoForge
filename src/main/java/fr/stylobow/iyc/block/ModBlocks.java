package fr.stylobow.iyc.block;

import fr.stylobow.iyc.ImagineYourCraft;
import fr.stylobow.iyc.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ImagineYourCraft.MOD_ID);

    public static final DeferredBlock TOPAZE_BLOCK = registerBlock("topaze_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock TOPAZE_ORE = registerBlock("topaze_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock DEEPSLATE_TOPAZE_ORE = registerBlock("deepslate_topaze_ore",
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

    public static final DeferredBlock RUBIS_BLOCK = registerBlock("rubis_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock RUBIS_ORE = registerBlock("rubis_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock DEEPSLATE_RUBIS_ORE = registerBlock("deepslate_rubis_ore",
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

    public static final DeferredBlock SAPHIR_BLOCK = registerBlock("saphir_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .explosionResistance(6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE))
    );
    public static final DeferredBlock SAPHIR_ORE = registerBlock("saphir_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );
    public static final DeferredBlock DEEPSLATE_SAPHIR_ORE = registerBlock("deepslate_saphir_ore",
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

    public static final DeferredBlock IRON_BLOCK = registerBlock("iron_block",
            () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3, 3.0F)
                            .sound(SoundType.METAL)
            )
    );


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
