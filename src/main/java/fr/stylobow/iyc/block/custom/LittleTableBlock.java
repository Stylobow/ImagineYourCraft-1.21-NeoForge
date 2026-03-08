package fr.stylobow.iyc.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LittleTableBlock extends Block {
    public static final MapCodec<LittleTableBlock> CODEC = simpleCodec(LittleTableBlock::new);
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    protected static final VoxelShape TOP = Block.box(0.0, 5.5, 0.0, 16.0, 7, 16.0);
    protected static final VoxelShape LEG_NW = Block.box(0.875, 0.0, 0.875, 2.375, 5.5, 2.375);
    protected static final VoxelShape LEG_NE = Block.box(13.75, 0.0, 0.875, 15.25, 5.5, 2.375);
    protected static final VoxelShape LEG_SW = Block.box(0.875, 0.0, 13.75, 2.375, 5.5, 15.25);
    protected static final VoxelShape LEG_SE = Block.box(13.75, 0.0, 13.75, 15.25, 5.5, 15.25);

    public LittleTableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        boolean north = state.getValue(NORTH);
        boolean east = state.getValue(EAST);
        boolean south = state.getValue(SOUTH);
        boolean west = state.getValue(WEST);

        VoxelShape shape = TOP;

        if (!north && !west) shape = Shapes.or(shape, LEG_NW);
        if (!north && !east) shape = Shapes.or(shape, LEG_NE);
        if (!south && !west) shape = Shapes.or(shape, LEG_SW);
        if (!south && !east) shape = Shapes.or(shape, LEG_SE);

        return shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        return this.defaultBlockState()
                .setValue(NORTH, connectsTo(level.getBlockState(pos.north())))
                .setValue(EAST, connectsTo(level.getBlockState(pos.east())))
                .setValue(SOUTH, connectsTo(level.getBlockState(pos.south())))
                .setValue(WEST, connectsTo(level.getBlockState(pos.west())));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis().isHorizontal()) {
            return state.setValue(getPropertyForDirection(direction), connectsTo(neighborState));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    public boolean connectsTo(BlockState state) {
        return state.getBlock() instanceof LittleTableBlock;
    }

    public static BooleanProperty getPropertyForDirection(Direction direction) {
        return switch (direction) {
            case NORTH -> NORTH;
            case EAST -> EAST;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            default -> NORTH;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST);
    }
}