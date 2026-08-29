package fr.stylobow.iyc.item.custom;

import fr.stylobow.iyc.world.gamerule.ModGameRules;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import java.util.List;

public class BaguetteRougeItem extends Item {

    public BaguetteRougeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.getGameRules().getBoolean(ModGameRules.ALLOW_SPECIAL_ITEMS)) {
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        }

        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {

            Vec3 startPos = player.getEyePosition();
            Vec3 lookVec = player.getLookAngle();
            Vec3 endPos = startPos.add(lookVec.scale(20));

            BlockHitResult blockHit = level.clip(new ClipContext(
                    startPos,
                    endPos,
                    ClipContext.Block.COLLIDER,
                    ClipContext.Fluid.NONE,
                    player
            ));

            Vec3 impactPos = blockHit.getType() != HitResult.Type.MISS ? blockHit.getLocation() : endPos;

            AABB searchBox = player.getBoundingBox()
                    .expandTowards(lookVec.scale(startPos.distanceTo(impactPos)))
                    .inflate(1.0D);

            EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(
                    player,
                    startPos,
                    impactPos,
                    searchBox,
                    (entity) -> !entity.isSpectator() && entity.isPickable(),
                    0.0f
            );

            if (entityHit != null) {
                impactPos = entityHit.getLocation();
            }

            double distance = startPos.distanceTo(impactPos);
            for (double i = 0; i < distance; i += 0.4) {
                Vec3 particlePos = startPos.add(lookVec.scale(i));
                serverLevel.sendParticles(ParticleTypes.FLAME,
                        particlePos.x, particlePos.y, particlePos.z,
                        1, 0, 0, 0, 0);
            }

            double radius = 1.2;
            for (int i = 0; i < 35; i++) {
                double offsetX = (level.random.nextDouble() - 0.5) * 2 * radius;
                double offsetY = (level.random.nextDouble() - 0.5) * 2 * radius;
                double offsetZ = (level.random.nextDouble() - 0.5) * 2 * radius;

                serverLevel.sendParticles(ParticleTypes.FLAME,
                        impactPos.x + offsetX, impactPos.y + offsetY, impactPos.z + offsetZ,
                        1, 0, 0, 0, 0);
            }

            AABB effectBox = new AABB(impactPos, impactPos).inflate(1.5D);
            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, effectBox);

            for (LivingEntity target : targets) {
                if (target == player) continue;

                target.igniteForSeconds(5);
            }

            level.playSound(null, impactPos.x, impactPos.y, impactPos.z,
                    SoundEvents.BLAZE_AMBIENT, SoundSource.PLAYERS, 1.0f, 1.0f);

            player.getCooldowns().addCooldown(this, 80);

            ItemStack stack = player.getItemInHand(hand);
            if (player instanceof ServerPlayer serverPlayer) {
                stack.hurtAndBreak(1, serverLevel, serverPlayer,
                        item -> player.onEquippedItemBroken(item, LivingEntity.getSlotForHand(hand))
                );
            }
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}