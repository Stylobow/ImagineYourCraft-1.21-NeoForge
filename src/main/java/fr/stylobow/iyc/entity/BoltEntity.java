package fr.stylobow.iyc.entity;

import fr.stylobow.iyc.block.entity.ModEntities;
import fr.stylobow.iyc.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BoltEntity extends AbstractArrow {
    public BoltEntity(EntityType<? extends BoltEntity> type, Level level) {
        super(type, level);
    }

    public BoltEntity(Level level, LivingEntity shooter, ItemStack pickupStack) {
        super(ModEntities.BOLT.get(), shooter, level, pickupStack, null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.BOLT.get());
    }
}