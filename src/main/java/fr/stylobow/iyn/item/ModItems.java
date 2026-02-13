package fr.stylobow.iyn.item;

import fr.stylobow.iyn.ImagineYourNight;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TridentItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ImagineYourNight.MOD_ID);

    public static final DeferredItem<Item> TOURNEVIS = ITEMS.register("tournevis",
            () -> new Item(new Item.Properties().stacksTo(1).durability(2000)));

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
            () -> new Item(new Item.Properties().stacksTo(1).durability(2000)));

    public static final DeferredItem<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
