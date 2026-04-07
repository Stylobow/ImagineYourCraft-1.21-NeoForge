package fr.stylobow.iyc.block.custom;

import fr.stylobow.iyc.client.renderer.IronFurnaceBlockEntity;
import fr.stylobow.iyc.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class IronFurnaceBlock extends FurnaceBlock {

    public IronFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new IronFurnaceBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createIronFurnaceTicker(level, type, ModBlockEntities.IRON_FURNACE_BE.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createIronFurnaceTicker(Level level, BlockEntityType<T> serverType, BlockEntityType<? extends IronFurnaceBlockEntity> clientType) {
        return level.isClientSide ? null : createTickerHelper(serverType, clientType, IronFurnaceBlockEntity::customServerTick);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof IronFurnaceBlockEntity) {
                player.openMenu((IronFurnaceBlockEntity)blockentity);
            }
            return InteractionResult.CONSUME;
        }
    }
}