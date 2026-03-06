package fr.stylobow.iyc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OakShelfBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(14.5, 0, 5, 16, 14.5, 16),
            Block.box(0, 0, 5, 1.5, 14.5, 16),
            Block.box(0, 14.5, 5, 16, 16, 16),
            Block.box(1.5, 6.5, 5, 14.5, 8, 16)
    );

    protected static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(0, 0, 0, 1.5, 14.5, 11),
            Block.box(14.5, 0, 0, 16, 14.5, 11),
            Block.box(0, 14.5, 0, 16, 16, 11),
            Block.box(1.5, 6.5, 0, 14.5, 8, 11)
    );

    protected static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(0, 0, 14.5, 11, 14.5, 16),
            Block.box(0, 0, 0, 11, 14.5, 1.5),
            Block.box(0, 14.5, 0, 11, 16, 16),
            Block.box(0, 6.5, 1.5, 11, 8, 14.5)
    );

    protected static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(5, 0, 0, 16, 14.5, 1.5),
            Block.box(5, 0, 14.5, 16, 14.5, 16),
            Block.box(5, 14.5, 0, 16, 16, 16),
            Block.box(5, 6.5, 1.5, 16, 8, 14.5)
    );

    public OakShelfBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}