package fr.stylobow.iyc.item.custom;

import fr.stylobow.iyc.world.gamerule.ModGameRules;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import java.util.Optional;

public class L118AItem extends Item {

    private static final int COOLDOWN_TICKS = 60;

    public L118AItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.getGameRules().getBoolean(ModGameRules.ALLOW_SPECIAL_ITEMS)) {
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        }

        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        }

        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {

            Vec3 startPos = player.getEyePosition();
            Vec3 lookVec = player.getLookAngle();
            Vec3 maxEndPos = startPos.add(lookVec.scale(100));

            BlockHitResult blockHit = level.clip(new ClipContext(
                    startPos,
                    maxEndPos,
                    ClipContext.Block.COLLIDER,
                    ClipContext.Fluid.NONE,
                    player
            ));

            Vec3 endPos = blockHit.getType() != HitResult.Type.MISS ? blockHit.getLocation() : maxEndPos;

            AABB searchBox = new AABB(startPos, endPos).inflate(1.0D);

            EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(
                    player,
                    startPos,
                    endPos,
                    searchBox,
                    (entity) -> entity != player && !entity.isSpectator() && entity.isAlive() && entity instanceof LivingEntity,
                    0.0f
            );

            LivingEntity hitTarget = null;
            Vec3 impactPos = endPos;

            if (entityHit != null && entityHit.getEntity() instanceof LivingEntity living) {
                hitTarget = living;
                impactPos = entityHit.getLocation();
            }

            double distance = startPos.distanceTo(impactPos);
            for (double i = 0; i < distance; i += 0.4) {
                Vec3 particlePos = startPos.add(lookVec.scale(i));
                serverLevel.sendParticles(ParticleTypes.FIREWORK,
                        particlePos.x, particlePos.y, particlePos.z,
                        1, 0, 0, 0, 0);
            }

            if (hitTarget != null) {
                boolean isAllied = (player.getTeam() != null && hitTarget.isAlliedTo(player));

                if (!isAllied) {
                    AABB bodyBox = hitTarget.getBoundingBox();
                    double eyeY = hitTarget.getEyeY();

                    AABB headBox = new AABB(
                            bodyBox.minX, eyeY - 0.25D, bodyBox.minZ,
                            bodyBox.maxX, eyeY + 0.35D, bodyBox.maxZ
                    );

                    Optional<Vec3> headHit = headBox.clip(startPos, endPos);

                    if (headHit.isPresent()) {
                        boolean isCreativePlayer = (hitTarget instanceof Player targetPlayer && (targetPlayer.isCreative() || targetPlayer.isSpectator()));

                        if (!isCreativePlayer) {
                            hitTarget.kill();

                            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 0));

                            Component announcement = Component.literal(player.getName().getString() + " a HeadShot " + hitTarget.getName().getString())
                                    .withStyle(ChatFormatting.GOLD);

                            for (ServerPlayer serverPlayer : serverLevel.getServer().getPlayerList().getPlayers()) {
                                serverPlayer.sendSystemMessage(announcement);
                            }
                        }
                    }
                }
            }

            player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);

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