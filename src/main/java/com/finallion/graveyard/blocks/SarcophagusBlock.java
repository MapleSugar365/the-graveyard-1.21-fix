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
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
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
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.function.BiPredicate;

public class SarcophagusBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<SarcophagusBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    propertiesCodec(),
                    Codec.BOOL.fieldOf("isCoffin").forGetter(block -> block.isCoffin),
                    ResourceLocation.CODEC.fieldOf("lidModel").forGetter(block -> block.lidModel),
                    ResourceLocation.CODEC.fieldOf("baseModel").forGetter(block -> block.bodyModel)
            ).apply(instance, SarcophagusBlock::new)
    );

    protected static final VoxelShape DOUBLE_NORTH_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    protected static final VoxelShape DOUBLE_SOUTH_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    protected static final VoxelShape DOUBLE_WEST_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    protected static final VoxelShape DOUBLE_EAST_SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    public static final EnumProperty<SarcophagusPart> PART = EnumProperty.create("part", SarcophagusPart.class);

    public final ResourceLocation lidModel;
    public final ResourceLocation bodyModel;
    public final boolean isCoffin;

    public SarcophagusBlock(Properties properties, boolean isCoffin, ResourceLocation lidModel, ResourceLocation bodyModel) {
        super(properties);
        this.isCoffin = isCoffin;
        this.lidModel = lidModel;
        this.bodyModel = bodyModel;
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, SarcophagusPart.FOOT).setValue(BlockStateProperties.WATERLOGGED, false).setValue(BlockStateProperties.LOCKED, false).setValue(BlockStateProperties.LIT, isCoffin));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51562_) {
        p_51562_.add(BlockStateProperties.WATERLOGGED, BlockStateProperties.OPEN, HorizontalDirectionalBlock.FACING, PART, BlockStateProperties.LOCKED, BlockStateProperties.LIT);
    }

    public FluidState getFluidState(BlockState p_51581_) {
        return p_51581_.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_51581_);
    }


    public BlockState updateShape(BlockState p_49525_, Direction p_49526_, BlockState p_49527_, LevelAccessor p_49528_, BlockPos p_49529_, BlockPos p_49530_) {
        if (p_49526_ == getNeighbourDirection(p_49525_.getValue(PART), p_49525_.getValue(HorizontalDirectionalBlock.FACING))) {
            return p_49527_.is(this) && p_49527_.getValue(PART) != p_49525_.getValue(PART) ? p_49525_ : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(p_49525_, p_49526_, p_49527_, p_49528_, p_49529_, p_49530_);
        }
    }

    private static Direction getNeighbourDirection(SarcophagusPart p_49534_, Direction p_49535_) {
        return p_49534_ == SarcophagusPart.FOOT ? p_49535_ : p_49535_.getOpposite();
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    public VoxelShape getShape(BlockState p_51569_, BlockGetter p_51570_, BlockPos p_51571_, CollisionContext p_51572_) {
        switch (p_51569_.getValue(HorizontalDirectionalBlock.FACING)) {
            case NORTH:
            default:
                return DOUBLE_NORTH_SHAPE;
            case SOUTH:
                return DOUBLE_SOUTH_SHAPE;
            case WEST:
                return DOUBLE_WEST_SHAPE;
            case EAST:
                return DOUBLE_EAST_SHAPE;
        }

    }


    public InteractionResult use(BlockState p_49515_, Level p_49516_, BlockPos p_49517_, Player p_49518_, InteractionHand p_49519_, BlockHitResult p_49520_) {
        Random random = new Random();

        if (p_49516_.isClientSide) {
            return InteractionResult.CONSUME;
        } else {
            BlockPos original = p_49517_;
            if (p_49515_.getValue(PART) == SarcophagusPart.HEAD) {
                p_49517_ = p_49517_.relative(p_49515_.getValue(HorizontalDirectionalBlock.FACING).getOpposite());
            }

            MenuProvider menuprovider = this.getMenuProvider(p_49515_, p_49516_, p_49517_);
            if (menuprovider != null) {
                p_49518_.openMenu(menuprovider);
            }

            spawnGhost(p_49515_, p_49516_, original, p_49518_, random);

            return InteractionResult.CONSUME;
        }
    }

    private static Direction getDirectionTowardsOtherPart(SarcophagusPart part, Direction direction) {
        return part == SarcophagusPart.FOOT ? direction : direction.getOpposite();
    }

    public static void spawnGhost(BlockState state, Level world, BlockPos pos, Player player, Random random) {
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


    public void setPlacedBy(Level p_49499_, BlockPos p_49500_, BlockState p_49501_, @javax.annotation.Nullable LivingEntity p_49502_, ItemStack p_49503_) {
        super.setPlacedBy(p_49499_, p_49500_, p_49501_, p_49502_, p_49503_);
        if (!p_49499_.isClientSide) {
            BlockPos blockpos = p_49500_.relative(p_49501_.getValue(HorizontalDirectionalBlock.FACING));
            p_49499_.setBlock(p_49500_, p_49501_.setValue(BlockStateProperties.LOCKED, true), 3);
            p_49499_.setBlock(blockpos, p_49501_.setValue(PART, SarcophagusPart.HEAD).setValue(BlockStateProperties.LOCKED, true), 3);
            p_49499_.blockUpdated(p_49500_, Blocks.AIR);
            p_49501_.updateNeighbourShapes(p_49499_, p_49500_, 3);
        }

    }


    public BlockState rotate(BlockState p_51552_, Rotation p_51553_) {
        return p_51552_.setValue(HorizontalDirectionalBlock.FACING, p_51553_.rotate(p_51552_.getValue(HorizontalDirectionalBlock.FACING)));
    }

    public BlockState mirror(BlockState p_54122_, Mirror p_54123_) {
        return p_54122_.rotate(p_54123_.getRotation(p_54122_.getValue(HorizontalDirectionalBlock.FACING)));
    }


    public long getSeed(BlockState p_49522_, BlockPos p_49523_) {
        BlockPos blockpos = p_49523_.relative(p_49522_.getValue(HorizontalDirectionalBlock.FACING), p_49522_.getValue(PART) == SarcophagusPart.HEAD ? 0 : 1);
        return Mth.getSeed(blockpos.getX(), p_49523_.getY(), blockpos.getZ());
    }


    public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
        SarcophagusPart bedPart = (SarcophagusPart) state.getValue(PART);
        return bedPart == SarcophagusPart.HEAD ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

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


    public void onRemove(BlockState p_51538_, Level p_51539_, BlockPos p_51540_, BlockState p_51541_, boolean p_51542_) {
        if (!p_51538_.is(p_51541_.getBlock())) {
            BlockEntity blockentity = p_51539_.getBlockEntity(p_51540_);
            if (blockentity instanceof Container) {
                Containers.dropContents(p_51539_, p_51540_, (Container) blockentity);
                p_51539_.updateNeighbourForOutputSignal(p_51540_, this);
            }

            super.onRemove(p_51538_, p_51539_, p_51540_, p_51541_, p_51542_);
        }
    }


    public void tick(BlockState p_153059_, ServerLevel p_153060_, BlockPos p_153061_, Random p_153062_) {
        BlockEntity blockentity = p_153060_.getBlockEntity(p_153061_);
        if (blockentity instanceof SarcophagusBlockEntity) {
            ((SarcophagusBlockEntity) blockentity).recheckOpen();
        }

    }


    public BlockEntity newBlockEntity(BlockPos p_153064_, BlockState p_153065_) {
        return new SarcophagusBlockEntity(p_153064_, p_153065_);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public RenderShape getRenderShape(BlockState p_51567_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }


    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_49479_) {
        FluidState fluidstate = p_49479_.getLevel().getFluidState(p_49479_.getClickedPos());
        Direction direction = p_49479_.getHorizontalDirection();
        BlockPos blockpos = p_49479_.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        Level level = p_49479_.getLevel();
        return level.getBlockState(blockpos1).canBeReplaced(p_49479_) && level.getWorldBorder().isWithinBounds(blockpos1) ? this.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, direction).setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER)) : null;
    }


    public static Direction getConnectedDirection(BlockState p_51585_) {
        Direction direction = p_51585_.getValue(HorizontalDirectionalBlock.FACING);
        return p_51585_.getValue(PART) == SarcophagusPart.HEAD ? direction.getOpposite() : direction;
    }

    public ModelResourceLocation getLidModel() {
        return ModelResourceLocation.standalone(lidModel);
    }

    public ModelResourceLocation getBaseModel() {
        return ModelResourceLocation.standalone(bodyModel);
    }

    /*
    ANIMATION STUFF
     */


    public static DoubleBlockCombiner.Combiner<SarcophagusBlockEntity, Float2FloatFunction> opennessCombiner(final LidBlockEntity p_51518_) {
        return new DoubleBlockCombiner.Combiner<>() {
            public Float2FloatFunction acceptDouble(SarcophagusBlockEntity p_51633_, SarcophagusBlockEntity p_51634_) {
                return (p_51638_) -> {
                    return Math.max(p_51633_.getOpenNess(p_51638_), p_51634_.getOpenNess(p_51638_));
                };
            }

            public Float2FloatFunction acceptSingle(SarcophagusBlockEntity p_51631_) {
                return p_51631_::getOpenNess;
            }

            public Float2FloatFunction acceptNone() {
                return p_51518_::getOpenNess;
            }
        };
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153055_, BlockState p_153056_, BlockEntityType<T> p_153057_) {
        return p_153055_.isClientSide ? createTickerHelper(p_153057_, this.blockEntityType(), SarcophagusBlockEntity::lidAnimateTick) : null;
    }


    public DoubleBlockCombiner.NeighborCombineResult<? extends SarcophagusBlockEntity> combine(BlockState p_51544_, Level p_51545_, BlockPos p_51546_, boolean p_51547_) {
        BiPredicate<LevelAccessor, BlockPos> bipredicate;
        bipredicate = (world, pos) -> false;
        return DoubleBlockCombiner.combineWithNeigbour(TGBlockEntities.SARCOPHAGUS_BLOCK_ENTITY.get(), SarcophagusBlock::getBlockType, SarcophagusBlock::getConnectedDirection, HorizontalDirectionalBlock.FACING, p_51544_, p_51545_, p_51546_, bipredicate);
    }

    public BlockEntityType<? extends SarcophagusBlockEntity> blockEntityType() {
        return TGBlockEntities.SARCOPHAGUS_BLOCK_ENTITY.get();
    }

}
