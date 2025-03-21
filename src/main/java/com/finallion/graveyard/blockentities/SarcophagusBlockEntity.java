package com.finallion.graveyard.blockentities;

import com.finallion.graveyard.blockentities.animation.SarcophagusLidAnimator;
import com.finallion.graveyard.init.TGBlockEntities;
import com.finallion.graveyard.init.TGSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class SarcophagusBlockEntity extends RandomizableContainerBlockEntity implements LidBlockEntity {
    private static final int CONTAINER_SIZE = 54;

    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    private final SarcophagusLidAnimator chestLidController = new SarcophagusLidAnimator();

    // Adapted from ChestBlockEntity#openersCounter
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            // TODO: Find a different way of differentiating between coffins and sarcophagi than
            //  checking for BlockStateProperties.LIT, which is only set for coffins.
            if (state.getValue(BlockStateProperties.LIT)) {
                SarcophagusBlockEntity.playSound(level, pos, state, TGSounds.COFFIN_OPEN.get());
            } else {
                SarcophagusBlockEntity.playSound(level, pos, state, TGSounds.SARCOPHAGUS_USE.get());
            }
        }

        protected void onClose(Level level, BlockPos pos, BlockState state) {
            if (state.getValue(BlockStateProperties.LIT)) {
                SarcophagusBlockEntity.playSound(level, pos, state, TGSounds.COFFIN_CLOSE.get());
            } else {
                SarcophagusBlockEntity.playSound(level, pos, state, TGSounds.SARCOPHAGUS_USE.get());
            }
        }

        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int eventId, int eventParam) {
            SarcophagusBlockEntity.this.signalOpenCount(level, pos, state, eventId, eventParam);
        }

        protected boolean isOwnContainer(Player player) {
            if (!(player.containerMenu instanceof ChestMenu)) {
                return false;
            } else {
                Container container = ((ChestMenu) player.containerMenu).getContainer();
                return container == SarcophagusBlockEntity.this || container instanceof CompoundContainer && ((CompoundContainer) container).contains(SarcophagusBlockEntity.this);
            }
        }
    };


    public SarcophagusBlockEntity(BlockPos pos, BlockState state) {
        super(TGBlockEntities.SARCOPHAGUS_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return CONTAINER_SIZE;
    }

    @Override
    protected Component getDefaultName() {
        if (getBlockState().getValue(BlockStateProperties.LIT)) {
            return Component.translatable("container.coffin");
        }
        return Component.translatable("container.sarcophagus");
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items, registries);
        }

    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items, registries);
        }

    }

    // Adapted from ChestBlockEntity#triggerEvent
    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            this.chestLidController.shouldBeOpen(type > 0);
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }

    // Adapted from ChestBlockEntity#startOpen
    @Override
    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    // Adapted from ChestBlockEntity#stopOpen
    @Override
    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return ChestMenu.sixRows(id, player, this);
    }

    // Adapted from ChestBlockEntity#signalOpenCount
    protected void signalOpenCount(Level level, BlockPos pos, BlockState state, int eventId, int eventParam) {
        Block block = state.getBlock();
        level.blockEvent(pos, block, 1, eventParam);
    }

    // Adapted from ChestBlockEntity#lidAnimateTick
    public static void lidAnimateTick(Level level, BlockPos pos, BlockState state, SarcophagusBlockEntity blockEntity) {
        blockEntity.chestLidController.tickLid();
    }

    static void playSound(Level level, BlockPos pos, BlockState state, SoundEvent sound) {
        double dx = (double) pos.getX() + 0.5D;
        double dy = (double) pos.getY() + 0.5D;
        double dz = (double) pos.getZ() + 0.5D;

        level.playSound(null, dx, dy, dz, sound, SoundSource.BLOCKS, 0.75F, level.random.nextFloat() * 0.1F - 70.0F);
    }

    public float getOpenNess(float partialTicks) {
        return this.chestLidController.getOpenness(partialTicks);
    }

    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }
}
