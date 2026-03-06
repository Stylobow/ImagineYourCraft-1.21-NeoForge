package fr.stylobow.iyc.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ModTiers implements Tier {

    SAPHIR(
            1639, // Durability (Iron = 250, Diamond = 1561)
            8F,          // Mining speed (Iron = 6.0F, Diamod = 8.0F)
            3.5F,       // Bonus damages (Iron = 2.0F, Diamond = 3.0F)
            24,         // Enchantability (Iron = 14, Gold = 22)
            () -> Ingredient.of(ModItems.SAPHIR.get())
    ),

    RUBIS(
            1717,
            9.0F,
            4.0F,
            19,
            () -> Ingredient.of(ModItems.RUBIS.get())
    );

    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    ModTiers(int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override public int getUses() { return this.uses; }
    @Override public float getSpeed() { return this.speed; }
    @Override public float getAttackDamageBonus() { return this.damage; }
    @Override public int getEnchantmentValue() { return this.enchantmentValue; }
    @Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }

    @Override public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
    }
}