package com.finallion.graveyard.blocks;

import com.finallion.graveyard.blockentities.GravestoneBlockEntity2;
import com.finallion.graveyard.world.level.block.state.GravestoneType;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Collections;
import java.util.List;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;

// Based on StandingSignBlock
public class GravestoneBlock2 extends SignBlock {
    public static final MapCodec<GravestoneBlock2> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    GravestoneType.CODEC.fieldOf("gravestone_type").forGetter(GravestoneBlock2::getGravestoneType),
                    propertiesCodec()
            ).apply(instance, GravestoneBlock2::new));
    private static final VoxelShape SHAPE_FACING_EW = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE_FACING_NS = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D);
    private final GravestoneType gravestoneType;

    public GravestoneBlock2(GravestoneType type, Properties properties) {
        super(WoodType.OAK, properties);
        this.gravestoneType = type;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public MapCodec<GravestoneBlock2> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GravestoneBlockEntity2(pos, state);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (Direction.NORTH == state.getValue(FACING) || Direction.SOUTH == state.getValue(FACING)) {
            return SHAPE_FACING_NS;
        } else {
            return SHAPE_FACING_EW;
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !this.canSurvive(state, level, currentPos) ?
                Blocks.AIR.defaultBlockState() :
                super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState()
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public float getYRotationDegrees(BlockState state) {
        return state.getValue(FACING).toYRot();
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(FACING, mirror.mirror(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        return Collections.singletonList(new ItemStack(this));
    }

    public GravestoneType getGravestoneType() {
        return this.gravestoneType;
    }

    public static GravestoneType getGravestoneTypeFor(Block block) {
        if (block instanceof GravestoneBlock2) {
            return ((GravestoneBlock2) block).getGravestoneType();
        }

        return GravestoneType.POLISHED_BASALT;
    }
}
