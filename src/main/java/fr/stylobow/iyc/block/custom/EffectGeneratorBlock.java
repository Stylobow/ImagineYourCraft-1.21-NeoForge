package fr.stylobow.iyc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class EffectGeneratorBlock extends Block {
    private final ParticleOptions particleType;
    private final int particleCount;

    public EffectGeneratorBlock(Properties properties, ParticleOptions particleType, int particleCount) {
        super(properties);
        this.particleType = particleType;
        this.particleCount = particleCount;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double x = (double) pos.getX() + 0.5D;
        double y = (double) pos.getY() + 1D;
        double z = (double) pos.getZ() + 0.5D;

        for (int i = 0; i < this.particleCount; i++) {
            level.addParticle(this.particleType,
                    x, y, z,
                    0.0D,
                    .075D,
                    0.0D);
        }
    }
}