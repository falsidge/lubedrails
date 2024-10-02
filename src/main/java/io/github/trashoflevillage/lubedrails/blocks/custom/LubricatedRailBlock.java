package io.github.trashoflevillage.lubedrails.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.RailShape;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LubricatedRailBlock extends AbstractRailBlock {
    public static final MapCodec<RailBlock> CODEC = createCodec(RailBlock::new);
    public static final EnumProperty<RailShape> SHAPE;

    public MapCodec<RailBlock> getCodec() {
        return CODEC;
    }

    public LubricatedRailBlock(AbstractBlock.Settings settings) {
        super(true, settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(SHAPE, RailShape.NORTH_SOUTH)).with(WATERLOGGED, false));
    }

    protected void updateBlockState(BlockState state, World world, BlockPos pos, Block neighbor) {
        if (neighbor.getDefaultState().emitsRedstonePower() && (new RailPlacementHelper(world, pos, state)).getNeighbors().size() == 3) {
            this.updateBlockState(world, pos, state, false);
        }

    }

    public Property<RailShape> getShapeProperty() {
        return SHAPE;
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        RailShape railShape = (RailShape)state.get(SHAPE);
        EnumProperty var10001 = SHAPE;
        RailShape var10002;
        switch (rotation) {
            case CLOCKWISE_180:
                switch (railShape) {
                    case NORTH_SOUTH:
                        var10002 = RailShape.NORTH_SOUTH;
                        return (BlockState)state.with(var10001, var10002);
                    case EAST_WEST:
                        var10002 = RailShape.EAST_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_EAST:
                        var10002 = RailShape.ASCENDING_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_WEST:
                        var10002 = RailShape.ASCENDING_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_NORTH:
                        var10002 = RailShape.ASCENDING_SOUTH;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_SOUTH:
                        var10002 = RailShape.ASCENDING_NORTH;
                        return (BlockState)state.with(var10001, var10002);
                    case SOUTH_EAST:
                        var10002 = RailShape.NORTH_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case SOUTH_WEST:
                        var10002 = RailShape.NORTH_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case NORTH_WEST:
                        var10002 = RailShape.SOUTH_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case NORTH_EAST:
                        var10002 = RailShape.SOUTH_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    default:
                        throw new MatchException((String)null, (Throwable)null);
                }
            case COUNTERCLOCKWISE_90:
                switch (railShape) {
                    case NORTH_SOUTH:
                        var10002 = RailShape.EAST_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case EAST_WEST:
                        var10002 = RailShape.NORTH_SOUTH;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_EAST:
                        var10002 = RailShape.ASCENDING_NORTH;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_WEST:
                        var10002 = RailShape.ASCENDING_SOUTH;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_NORTH:
                        var10002 = RailShape.ASCENDING_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_SOUTH:
                        var10002 = RailShape.ASCENDING_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case SOUTH_EAST:
                        var10002 = RailShape.NORTH_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case SOUTH_WEST:
                        var10002 = RailShape.SOUTH_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case NORTH_WEST:
                        var10002 = RailShape.SOUTH_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case NORTH_EAST:
                        var10002 = RailShape.NORTH_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    default:
                        throw new MatchException((String)null, (Throwable)null);
                }
            case CLOCKWISE_90:
                switch (railShape) {
                    case NORTH_SOUTH:
                        var10002 = RailShape.EAST_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case EAST_WEST:
                        var10002 = RailShape.NORTH_SOUTH;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_EAST:
                        var10002 = RailShape.ASCENDING_SOUTH;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_WEST:
                        var10002 = RailShape.ASCENDING_NORTH;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_NORTH:
                        var10002 = RailShape.ASCENDING_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case ASCENDING_SOUTH:
                        var10002 = RailShape.ASCENDING_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case SOUTH_EAST:
                        var10002 = RailShape.SOUTH_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case SOUTH_WEST:
                        var10002 = RailShape.NORTH_WEST;
                        return (BlockState)state.with(var10001, var10002);
                    case NORTH_WEST:
                        var10002 = RailShape.NORTH_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    case NORTH_EAST:
                        var10002 = RailShape.SOUTH_EAST;
                        return (BlockState)state.with(var10001, var10002);
                    default:
                        throw new MatchException((String)null, (Throwable)null);
                }
            default:
                var10002 = railShape;
                return (BlockState)state.with(var10001, var10002);
        }
    }

    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        RailShape railShape = (RailShape)state.get(SHAPE);
        switch (mirror) {
            case LEFT_RIGHT:
                switch (railShape) {
                    case ASCENDING_NORTH -> {
                        return (BlockState)state.with(SHAPE, RailShape.ASCENDING_SOUTH);
                    }
                    case ASCENDING_SOUTH -> {
                        return (BlockState)state.with(SHAPE, RailShape.ASCENDING_NORTH);
                    }
                    case SOUTH_EAST -> {
                        return (BlockState)state.with(SHAPE, RailShape.NORTH_EAST);
                    }
                    case SOUTH_WEST -> {
                        return (BlockState)state.with(SHAPE, RailShape.NORTH_WEST);
                    }
                    case NORTH_WEST -> {
                        return (BlockState)state.with(SHAPE, RailShape.SOUTH_WEST);
                    }
                    case NORTH_EAST -> {
                        return (BlockState)state.with(SHAPE, RailShape.SOUTH_EAST);
                    }
                    default -> {
                        return super.mirror(state, mirror);
                    }
                }
            case FRONT_BACK:
                switch (railShape) {
                    case ASCENDING_EAST:
                        return (BlockState)state.with(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_WEST:
                        return (BlockState)state.with(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_NORTH:
                    case ASCENDING_SOUTH:
                    default:
                        break;
                    case SOUTH_EAST:
                        return (BlockState)state.with(SHAPE, RailShape.SOUTH_WEST);
                    case SOUTH_WEST:
                        return (BlockState)state.with(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_WEST:
                        return (BlockState)state.with(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_EAST:
                        return (BlockState)state.with(SHAPE, RailShape.NORTH_WEST);
                }
        }

        return super.mirror(state, mirror);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{SHAPE, WATERLOGGED});
    }

    static {
        SHAPE = Properties.RAIL_SHAPE;
    }
}
