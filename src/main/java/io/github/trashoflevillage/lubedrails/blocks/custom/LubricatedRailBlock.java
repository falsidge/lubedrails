package io.github.trashoflevillage.lubedrails.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RailShape;

public class LubricatedRailBlock extends BaseRailBlock {
    public static final MapCodec<RailBlock> CODEC = simpleCodec(RailBlock::new);
    public static final EnumProperty<RailShape> SHAPE;

    public MapCodec<RailBlock> codec() {
        return CODEC;
    }

    public LubricatedRailBlock(BlockBehaviour.Properties settings) {
        super(true, settings);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(SHAPE, RailShape.NORTH_SOUTH)).setValue(WATERLOGGED, false));
    }

    protected void updateState(BlockState state, Level world, BlockPos pos, Block neighbor) {
        if (neighbor.defaultBlockState().isSignalSource() && (new RailState(world, pos, state)).getConnections().size() == 3) {
            this.updateDir(world, pos, state, false);
        }

    }

    public Property<RailShape> getShapeProperty() {
        return SHAPE;
    }

    protected BlockState rotate(BlockState state, Rotation rotation) {
        RailShape railShape = (RailShape)state.getValue(SHAPE);
        EnumProperty var10001 = SHAPE;
        RailShape var10002;
        switch (rotation) {
            case CLOCKWISE_180:
                switch (railShape) {
                    case NORTH_SOUTH:
                        var10002 = RailShape.NORTH_SOUTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case EAST_WEST:
                        var10002 = RailShape.EAST_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_EAST:
                        var10002 = RailShape.ASCENDING_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_WEST:
                        var10002 = RailShape.ASCENDING_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_NORTH:
                        var10002 = RailShape.ASCENDING_SOUTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_SOUTH:
                        var10002 = RailShape.ASCENDING_NORTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case SOUTH_EAST:
                        var10002 = RailShape.NORTH_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case SOUTH_WEST:
                        var10002 = RailShape.NORTH_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case NORTH_WEST:
                        var10002 = RailShape.SOUTH_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case NORTH_EAST:
                        var10002 = RailShape.SOUTH_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    default:
                        throw new MatchException((String)null, (Throwable)null);
                }
            case COUNTERCLOCKWISE_90:
                switch (railShape) {
                    case NORTH_SOUTH:
                        var10002 = RailShape.EAST_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case EAST_WEST:
                        var10002 = RailShape.NORTH_SOUTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_EAST:
                        var10002 = RailShape.ASCENDING_NORTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_WEST:
                        var10002 = RailShape.ASCENDING_SOUTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_NORTH:
                        var10002 = RailShape.ASCENDING_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_SOUTH:
                        var10002 = RailShape.ASCENDING_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case SOUTH_EAST:
                        var10002 = RailShape.NORTH_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case SOUTH_WEST:
                        var10002 = RailShape.SOUTH_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case NORTH_WEST:
                        var10002 = RailShape.SOUTH_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case NORTH_EAST:
                        var10002 = RailShape.NORTH_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    default:
                        throw new MatchException((String)null, (Throwable)null);
                }
            case CLOCKWISE_90:
                switch (railShape) {
                    case NORTH_SOUTH:
                        var10002 = RailShape.EAST_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case EAST_WEST:
                        var10002 = RailShape.NORTH_SOUTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_EAST:
                        var10002 = RailShape.ASCENDING_SOUTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_WEST:
                        var10002 = RailShape.ASCENDING_NORTH;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_NORTH:
                        var10002 = RailShape.ASCENDING_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case ASCENDING_SOUTH:
                        var10002 = RailShape.ASCENDING_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case SOUTH_EAST:
                        var10002 = RailShape.SOUTH_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case SOUTH_WEST:
                        var10002 = RailShape.NORTH_WEST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case NORTH_WEST:
                        var10002 = RailShape.NORTH_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    case NORTH_EAST:
                        var10002 = RailShape.SOUTH_EAST;
                        return (BlockState)state.setValue(var10001, var10002);
                    default:
                        throw new MatchException((String)null, (Throwable)null);
                }
            default:
                var10002 = railShape;
                return (BlockState)state.setValue(var10001, var10002);
        }
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        RailShape railShape = (RailShape)state.getValue(SHAPE);
        switch (mirror) {
            case LEFT_RIGHT:
                switch (railShape) {
                    case ASCENDING_NORTH -> {
                        return (BlockState)state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    }
                    case ASCENDING_SOUTH -> {
                        return (BlockState)state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    }
                    case SOUTH_EAST -> {
                        return (BlockState)state.setValue(SHAPE, RailShape.NORTH_EAST);
                    }
                    case SOUTH_WEST -> {
                        return (BlockState)state.setValue(SHAPE, RailShape.NORTH_WEST);
                    }
                    case NORTH_WEST -> {
                        return (BlockState)state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    }
                    case NORTH_EAST -> {
                        return (BlockState)state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    }
                    default -> {
                        return super.mirror(state, mirror);
                    }
                }
            case FRONT_BACK:
                switch (railShape) {
                    case ASCENDING_EAST:
                        return (BlockState)state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_WEST:
                        return (BlockState)state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_NORTH:
                    case ASCENDING_SOUTH:
                    default:
                        break;
                    case SOUTH_EAST:
                        return (BlockState)state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case SOUTH_WEST:
                        return (BlockState)state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_WEST:
                        return (BlockState)state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_EAST:
                        return (BlockState)state.setValue(SHAPE, RailShape.NORTH_WEST);
                }
        }

        return super.mirror(state, mirror);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{SHAPE, WATERLOGGED});
    }

    static {
        SHAPE = BlockStateProperties.RAIL_SHAPE;
    }
}
