package fr.stylobow.iyc.world.gamerule;

import net.minecraft.world.level.GameRules;

public class ModGameRules {
    public static GameRules.Key<GameRules.BooleanValue> ALLOW_SPECIAL_ITEMS;

    public static void register() {
        ALLOW_SPECIAL_ITEMS = GameRules.register(
                "allowSpecialItems",
                GameRules.Category.PLAYER,
                GameRules.BooleanValue.create(true)
        );
    }
}