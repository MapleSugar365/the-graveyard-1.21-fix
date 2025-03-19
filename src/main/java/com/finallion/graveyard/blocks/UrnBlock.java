package com.finallion.graveyard.blocks;

import com.finallion.graveyard.blockentities.UrnBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import com.finallion.graveyard.init.TGTileEntities;

import javax.annotation.Nullable;
import java.util.Random;

public class UrnBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<UrnBlock> CODEC = simpleCodec(UrnBlock::new);
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;
    private static final VoxelShape LARGE_URN = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final VoxelShape SMALL_URN = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);

    public UrnBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(OPEN, false));
    }

    public UrnBlock() {
        this(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(0.3F));
    }

    @Override
    protected MapCodec<UrnBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    @Override
    public float getShadeBrightness(BlockState p_60472_, BlockGetter p_60473_, BlockPos p_60474_) {
        return 1.0F;
    }

    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        if (this.asBlock().toString().contains("small")) {
            return SMALL_URN;
        }
        return LARGE_URN;
    }



    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, CollisionContext p_220071_4_) {
        if (this.asBlock().toString().contains("small")) {
            return SMALL_URN;
        }
        return LARGE_URN;
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public InteractionResult use(BlockState p_49069_, Level p_49070_, BlockPos p_49071_, Player p_49072_, InteractionHand p_49073_, BlockHitResult p_49074_) {
        if (p_49070_.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = p_49070_.getBlockEntity(p_49071_);
            if (blockentity instanceof UrnBlockEntity) {
                p_49072_.openMenu((UrnBlockEntity)blockentity);
                p_49072_.awardStat(Stats.OPEN_BARREL);
                PiglinAi.angerNearbyPiglins(p_49072_, true);
            }

            return InteractionResult.CONSUME;
        }
    }



    public void onRemove(BlockState p_49076_, Level p_49077_, BlockPos p_49078_, BlockState p_49079_, boolean p_49080_) {
        if (!p_49076_.is(p_49079_.getBlock())) {
            BlockEntity blockentity = p_49077_.getBlockEntity(p_49078_);
            if (blockentity instanceof Container) {
                Containers.dropContents(p_49077_, p_49078_, (Container)blockentity);
                p_49077_.updateNeighbourForOutputSignal(p_49078_, this);
            }

            super.onRemove(p_49076_, p_49077_, p_49078_, p_49079_, p_49080_);
        }
    }


    public void tick(BlockState p_49060_, ServerLevel p_49061_, BlockPos p_49062_, Random p_49063_) {
        BlockEntity blockentity = p_49061_.getBlockEntity(p_49062_);
        if (blockentity instanceof UrnBlockEntity) {
            ((UrnBlockEntity)blockentity).recheckOpen();
        }

    }

    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }

    // TODO Check if needed and reintroduce or delete
//    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
//        if (stack.hasCustomHoverName()) {
//            BlockEntity blockentity = level.getBlockEntity(pos);
//            if (blockentity instanceof UrnBlockEntity) {
//                ((UrnBlockEntity)blockentity).setCustomName(stack.getHoverName());
//            }
//        }
//    }

    public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState p_49065_, Level p_49066_, BlockPos p_49067_) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(p_49066_.getBlockEntity(p_49067_));
    }

    public BlockState rotate(BlockState p_49085_, Rotation p_49086_) {
        return p_49085_.setValue(FACING, p_49086_.rotate(p_49085_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_49082_, Mirror p_49083_) {
        return p_49082_.rotate(p_49083_.getRotation(p_49082_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING, OPEN, WATERLOGGED);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction direction = context.getHorizontalDirection();
        return this.defaultBlockState().setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }


    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return TGTileEntities.URN_BLOCK_ENTITY.get().create(pos, state);
    }


    static {
        FACING = BlockStateProperties.FACING;
        OPEN = BlockStateProperties.OPEN;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }



}
