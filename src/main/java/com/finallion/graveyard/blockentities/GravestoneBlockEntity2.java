package com.finallion.graveyard.blockentities;

import com.finallion.graveyard.init.TGBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GravestoneBlockEntity2 extends SignBlockEntity {
    public GravestoneBlockEntity2(BlockPos pos, BlockState blockState) {
        super(TGBlockEntities.GRAVESTONE_BLOCK_ENTITY_2.get(), pos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return TGBlockEntities.GRAVESTONE_BLOCK_ENTITY_2.get();
    }
}
