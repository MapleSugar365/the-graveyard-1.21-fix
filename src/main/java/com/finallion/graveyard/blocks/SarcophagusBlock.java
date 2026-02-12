package com.finallion.graveyard.blocks;

import com.finallion.graveyard.blockentities.SarcophagusBlockEntity;
import com.finallion.graveyard.blockentities.enums.SarcophagusPart;
import com.finallion.graveyard.entities.WraithEntity;
import com.finallion.graveyard.init.TGAdvancements;
import com.finallion.graveyard.init.TGBlockEntities;
import com.finallion.graveyard.init.TGEntities;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class SarcophagusBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<SarcophagusBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    propertiesCodec(),
                    Codec.BOOL.fieldOf("isCoffin").forGetter(block -> block.isCoffin),
                    ResourceLocation.CODEC.fieldOf("lidModelLocation").forGetter(block -> block.lidModelLocation),
                    ResourceLocation.CODEC.fieldOf("baseModelLocation").forGetter(block -> block.baseModelLocation)
            ).apply(instance, SarcophagusBlock::new)
    );

    protected static final VoxelShape DOUBLE_NORTH_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    protected static final VoxelShape DOUBLE_SOUTH_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    protected static final VoxelShape DOUBLE_WEST_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    protected static final VoxelShape DOUBLE_EAST_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    public static final EnumProperty<SarcophagusPart> PART = EnumProperty.create("part", SarcophagusPart.class);

    public final boolean isCoffin;
    public final ResourceLocation lidModelLocation;
    public final ResourceLocation baseModelLocation;

    public SarcophagusBlock(Properties properties, boolean isCoffin, ResourceLocation lidModelLocation, ResourceLocation baseModelLocation) {
        super(properties);
        this.isCoffin = isCoffin;
        this.lidModelLocation = lidModelLocation;
        this.baseModelLocation = baseModelLocation;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(PART, SarcophagusPart.FOOT)
                .setValue(BlockStateProperties.WATERLOGGED, false)
                .setValue(BlockStateProperties.LOCKED, false)
                .setValue(BlockStateProperties.LIT, isCoffin));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(HorizontalDirectionalBlock.FACING)) {
            case SOUTH -> DOUBLE_SOUTH_SHAPE;
            case WEST -> DOUBLE_WEST_SHAPE;
            case EAST -> DOUBLE_EAST_SHAPE;
            default -> DOUBLE_NORTH_SHAPE;
        };
    }

    // Adapted from BedBlock#updateShape
    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (facing != getNeighbourDirection(state.getValue(PART), state.getValue(HorizontalDirectionalBlock.FACING))) {
            return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        } else {
            return facingState.is(this) && facingState.getValue(PART) != state.getValue(PART) ? state : Blocks.AIR.defaultBlockState();
        }
    }

    // Adapted from BedBlock#getNeighbourDirection
    private static Direction getNeighbourDirection(SarcophagusPart part, Direction direction) {
        return part == SarcophagusPart.FOOT ? direction : direction.getOpposite();
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            SarcophagusPart part = state.getValue(PART);
            if (part == SarcophagusPart.FOOT) {
                BlockPos blockpos = pos.relative(getNeighbourDirection(part, state.getValue(HorizontalDirectionalBlock.FACING)));
                BlockState blockstate = level.getBlockState(blockpos);
                if (blockstate.is(this) && blockstate.getValue(PART) == SarcophagusPart.HEAD) {
                    level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
                }
            }
        }

        return super.playerWillDestroy(level, pos, state, player);
    }

    // Adapted from BedBlock#getStateForPlacement
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction direction = context.getHorizontalDirection();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        Level level = context.getLevel();

        if (!level.getBlockState(blockpos1).canBeReplaced(context) || !level.getWorldBorder().isWithinBounds(blockpos1)) {
            return null;
        }

        return this.defaultBlockState()
                .setValue(HorizontalDirectionalBlock.FACING, direction)
                .setValue(BlockStateProperties.WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ?
                Fluids.WATER.getSource(false) :
                super.getFluidState(state);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        Random random = new Random();

        if (level.isClientSide) {
            return InteractionResult.CONSUME;
        } else {
            BlockPos original = pos;
            if (state.getValue(PART) == SarcophagusPart.HEAD) {
                pos = pos.relative(state.getValue(HorizontalDirectionalBlock.FACING).getOpposite());
            }

            MenuProvider menuprovider = this.getMenuProvider(state, level, pos);
            if (menuprovider != null) {
                player.openMenu(menuprovider);
            }

            spawnGhost(state, level, original, player, random);

            return InteractionResult.CONSUME;
        }
    }


    // Adapted from BedBlock#setPlacedBy
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            BlockPos blockpos = pos.relative(state.getValue(HorizontalDirectionalBlock.FACING));
            level.setBlock(pos, state.setValue(BlockStateProperties.LOCKED, true), 3);
            level.setBlock(blockpos, state.setValue(PART, SarcophagusPart.HEAD).setValue(BlockStateProperties.LOCKED, true), 3);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, 3);
        }

    }

    // Adapted from BedBlock#getSeed
    @Override
    protected long getSeed(BlockState state, BlockPos pos) {
        BlockPos blockpos = pos.relative(state.getValue(HorizontalDirectionalBlock.FACING), state.getValue(PART) == SarcophagusPart.HEAD ? 0 : 1);
        return Mth.getSeed(blockpos.getX(), pos.getY(), blockpos.getZ());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(HorizontalDirectionalBlock.FACING, rotation.rotate(state.getValue(HorizontalDirectionalBlock.FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(HorizontalDirectionalBlock.FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.WATERLOGGED, BlockStateProperties.OPEN, HorizontalDirectionalBlock.FACING, PART, BlockStateProperties.LOCKED, BlockStateProperties.LIT);
    }

    // Adapted from BarrelBlock#onRemove
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        Containers.dropContentsOnDestroy(state, newState, level, pos);
        super.onRemove(state, level, pos, newState, isMoving);
    }

    // Adapted from BarrelBlock#tick
    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof SarcophagusBlockEntity) {
            ((SarcophagusBlockEntity) blockentity).recheckOpen();
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SarcophagusBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    // Adapted from ChestBlock#getTicker
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? createTickerHelper(blockEntityType, TGBlockEntities.SARCOPHAGUS_BLOCK_ENTITY.get(), SarcophagusBlockEntity::lidAnimateTick) : null;
    }

    // Adapted from BedBlock#getBlockType
    public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
        SarcophagusPart bedPart = state.getValue(PART);
        return bedPart == SarcophagusPart.HEAD ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

    // Adapted from BedBlock#getConnectedDirection
    public static Direction getConnectedDirection(BlockState state) {
        Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
        return state.getValue(PART) == SarcophagusPart.HEAD ? direction.getOpposite() : direction;
    }

    // Adapted from ChestBlock#opennessCombiner
    public static DoubleBlockCombiner.Combiner<SarcophagusBlockEntity, Float2FloatFunction> opennessCombiner(final LidBlockEntity thisLid) {
        return new DoubleBlockCombiner.Combiner<>() {
            public Float2FloatFunction acceptDouble(SarcophagusBlockEntity left, SarcophagusBlockEntity right) {
                return (partialTicks) -> Math.max(left.getOpenNess(partialTicks), right.getOpenNess(partialTicks));
            }

            public Float2FloatFunction acceptSingle(SarcophagusBlockEntity single) {
                return single::getOpenNess;
            }

            public Float2FloatFunction acceptNone() {
                return thisLid::getOpenNess;
            }
        };
    }

    private static Direction getDirectionTowardsOtherPart(SarcophagusPart part, Direction direction) {
        return part == SarcophagusPart.FOOT ? direction : direction.getOpposite();
    }

    private static void spawnGhost(BlockState state, Level world, BlockPos pos, Player player, Random random) {
        if (!state.getValue(BlockStateProperties.LOCKED) && random.nextInt(4) == 0 && pos.getY() < 62) {
            BlockPos entityPos = pos;
            for (int i = 0; i < 10; i++) { // 10 spawn attempts to find air, else just spawn
                entityPos = player.getOnPos().offset(-2 + random.nextInt(5), 1, -2 + random.nextInt(5));
                if (world.getBlockState(entityPos).isAir() && world.getBlockState(entityPos.above()).isAir()) {
                    break;
                }
            }
            WraithEntity ghost = TGEntities.WRAITH.get().create(world);
            ghost.moveTo(entityPos, 0.0F, 0.0F);
            world.addFreshEntity(ghost);
            world.setBlock(pos, state.setValue(BlockStateProperties.LOCKED, true), 3);
            BlockPos otherPartPos = pos.relative(getDirectionTowardsOtherPart(state.getValue(PART), state.getValue(HorizontalDirectionalBlock.FACING)));
            BlockState otherPart = world.getBlockState(otherPartPos);
            if (player instanceof ServerPlayer) {
                TGAdvancements.SPAWN_WRAITH.get().trigger((ServerPlayer) player);
            }
            world.setBlock(otherPartPos, otherPart.setValue(BlockStateProperties.LOCKED, true), 3);
        }
    }
}
