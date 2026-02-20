package fr.stylobow.iyc.item;

import fr.stylobow.iyc.ImagineYourCraft;
import fr.stylobow.iyc.block.ModBlocks;
import fr.stylobow.iyc.item.custom.BaguetteVioletteItem;
import fr.stylobow.iyc.item.custom.ItemFoil;
import fr.stylobow.iyc.item.custom.TournevisItem;
import fr.stylobow.iyc.sound.ModSounds;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ImagineYourCraft.MOD_ID);

    public static final DeferredItem<Item> TOURNEVIS = ITEMS.register("tournevis",
            () -> new TournevisItem(new Item.Properties().stacksTo(1).durability(2000)));

    public static final DeferredItem<Item> BAGUETTE_BLEUE = ITEMS.register("baguette_bleue",
            () -> new Item(new Item.Properties().stacksTo(1).durability(2000)));
    public static final DeferredItem<Item> BAGUETTE_JAUNE = ITEMS.register("baguette_jaune",
            () -> new Item(new Item.Properties().stacksTo(1).durability(2000)));
    public static final DeferredItem<Item> BAGUETTE_ORANGE = ITEMS.register("baguette_orange",
            () -> new Item(new Item.Properties().stacksTo(1).durability(2000)));
    public static final DeferredItem<Item> BAGUETTE_ROUGE = ITEMS.register("baguette_rouge",
            () -> new Item(new Item.Properties().stacksTo(1).durability(2000)));
    public static final DeferredItem<Item> BAGUETTE_VERTE = ITEMS.register("baguette_verte",
            () -> new Item(new Item.Properties().stacksTo(1).durability(2000)));
    public static final DeferredItem<Item> BAGUETTE_VIOLETTE = ITEMS.register("baguette_violette",
            () -> new BaguetteVioletteItem(new Item.Properties().stacksTo(1).durability(2000)));

    public static final DeferredItem<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TOPAZE = ITEMS.register("topaze",
            () -> new ItemFoil(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> RUBIS = ITEMS.register("rubis",
            () -> new ItemFoil(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> SAPHIR = ITEMS.register("saphir",
            () -> new ItemFoil(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> ADAMANTIUM_FRAGMENT = ITEMS.register("adamantium_fragment",
            () -> new ItemFoil(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> STEEL_STICK = ITEMS.register("steel_stick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHOPPE = ITEMS.register("choppe",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MAILLE = ITEMS.register("maille",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGNITE = ITEMS.register("lignite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HOPS = ITEMS.register("hops",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STONE_STICK = ITEMS.register("stone_stick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CAFEINE = ITEMS.register("cafeine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COLA = ITEMS.register("cola",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CANETTE = ITEMS.register("canette",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TAURINE = ITEMS.register("taurine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EMPTY_GLASS = ITEMS.register("empty_glass",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SLATE_ITEM = ITEMS.register("slate_item",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RECORD_TAKE_BACK_NIGHT = ITEMS.register("take_back_night",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.TAKE_BACK_NIGHT_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_ZOMBIES = ITEMS.register("zombies",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.ZOMBIES_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_CHUNKS = ITEMS.register("chunks",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.CHUNKS_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_CREEP = ITEMS.register("creep",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.CREEP_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_NOFRAGAYS = ITEMS.register("nofragays",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.NOFRAGAYS_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_SEAN_KEVIN = ITEMS.register("sean_kevin",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.SEAN_KEVIN_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_GIVE = ITEMS.register("give",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GIVE_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_PELLES = ITEMS.register("pelles",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.PELLES_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_GEEK = ITEMS.register("geek",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GEEK_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_ACTA = ITEMS.register("acta",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.ACTA_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_TOUCH = ITEMS.register("touch",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.TOUCH_KEY).stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> RECORD_MC_STYLE = ITEMS.register("mc_style",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.MC_STYLE_KEY).stacksTo(1).rarity(Rarity.RARE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
