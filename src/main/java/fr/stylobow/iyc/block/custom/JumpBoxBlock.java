package fr.stylobow.iyc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class JumpBoxBlock extends Block {

    public JumpBoxBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.isShiftKeyDown()) {
            if (entity.getDeltaMovement().y < 0.1D) {

                int jumpBlocksCount = 1;

                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++) {
                        if (x == 0 && z == 0) continue;

                        BlockPos checkPos = pos.offset(x, 0, z);
                        if (level.getBlockState(checkPos).getBlock() == this) {
                            jumpBlocksCount++;
                        }
                    }
                }

                double power = 3 + (jumpBlocksCount * 0.5D);

                Vec3 currentMovement = entity.getDeltaMovement();
                entity.setDeltaMovement(currentMovement.x, power, currentMovement.z);

                float soundPitch = 1.0F + (jumpBlocksCount * 0.1F);
                level.playSound(null, pos, SoundEvents.PISTON_EXTEND, SoundSource.BLOCKS, 1.0F, soundPitch);
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}