package fr.stylobow.iyc.block.custom;

import com.mojang.serialization.MapCodec;
import fr.stylobow.iyc.block.entity.ModEntities;
import fr.stylobow.iyc.block.entity.custom.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChairBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<ChairBlock> CODEC = simpleCodec(ChairBlock::new);

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide() && !player.isShiftKeyDown()) {
            Entity entity = null;
            List<ChairEntity> entites = level.getEntities(ModEntities.CHAIR_ENTITY.get(), new AABB(pos), chair -> true);
            if(entites.isEmpty()) {
                entity = ModEntities.CHAIR_ENTITY.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entites.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }

    protected static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(3, 0, 3, 13, 8, 13),
            Block.box(3, 8, 11.5, 13, 16, 13)
    );

    protected static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(3, 0, 3, 13, 8, 13),
            Block.box(3, 8, 3, 13, 16, 4.5)
    );

    protected static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(3, 0, 3, 13, 8, 13),
            Block.box(3, 8, 3, 4.5, 16, 13)
    );

    protected static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(3, 0, 3, 13, 8, 13),
            Block.box(11.5, 8, 3, 13, 16, 13)
    );

    public ChairBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}