package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.blockentities.BrazierBlockEntity;
import com.finallion.graveyard.blockentities.GravestoneBlockEntityOld;
import com.finallion.graveyard.blockentities.GravestoneBlockEntity2;
import com.finallion.graveyard.blockentities.OssuaryBlockEntity;
import com.finallion.graveyard.blockentities.SarcophagusBlockEntity;
import com.finallion.graveyard.blockentities.UrnBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class TGBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TheGraveyard.MOD_ID);

    public static final Supplier<BlockEntityType<OssuaryBlockEntity>> OSSUARY_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "ossuary_block_entity",
            () -> BlockEntityType.Builder.of(
                    OssuaryBlockEntity::new,
                    TGBlocks.OSSUARY.get()
            ).build(null)
    );

    public static final Supplier<BlockEntityType<GravestoneBlockEntityOld>> GRAVESTONE_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "gravestone_block_entity",
            () -> BlockEntityType.Builder.of(
                    GravestoneBlockEntityOld::new,
                    TGBlocks.GRAVESTONE.get(),
                    TGBlocks.DEEPSLATE_GRAVESTONE.get(),
                    TGBlocks.MOSSY_COBBLESTONE_GRAVESTONE.get(),
                    TGBlocks.COBBLESTONE_GRAVESTONE.get(),
                    TGBlocks.BLACKSTONE_GRAVESTONE.get(),
                    TGBlocks.CRACKED_BLACKSTONE_GRAVESTONE.get(),
                    TGBlocks.STONE_BRICKS_GRAVESTONE.get(),
                    TGBlocks.MOSSY_STONE_BRICKS_GRAVESTONE.get(),
                    TGBlocks.BRICKS_GRAVESTONE.get(),
                    TGBlocks.QUARTZ_BRICKS_GRAVESTONE.get(),
                    TGBlocks.RED_SANDSTONE_GRAVESTONE.get(),
                    TGBlocks.SANDSTONE_GRAVESTONE.get(),
                    TGBlocks.GILDED_BLACKSTONE_GRAVESTONE.get()
            ).build(null)
    );

    public static final Supplier<BlockEntityType<GravestoneBlockEntity2>> GRAVESTONE_BLOCK_ENTITY_2 = BLOCK_ENTITIES.register(
            "gravestone_block_entity_2",
            () -> BlockEntityType.Builder.of(
                    GravestoneBlockEntity2::new,
                    TGBlocks.GRAVESTONE2.get()
            ).build(null)
    );

    public static final Supplier<BlockEntityType<UrnBlockEntity>> URN_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "urn_block_entity",
            () -> BlockEntityType.Builder.of(
                    UrnBlockEntity::new,
                    TGBlocks.BLACK_URN.get(),
                    TGBlocks.BLUE_URN.get(),
                    TGBlocks.LIGHT_BLUE_URN.get(),
                    TGBlocks.CYAN_URN.get(),
                    TGBlocks.BROWN_URN.get(),
                    TGBlocks.GRAY_URN.get(),
                    TGBlocks.LIGHT_GRAY_URN.get(),
                    TGBlocks.PURPLE_URN.get(),
                    TGBlocks.MAGENTA_URN.get(),
                    TGBlocks.PINK_URN.get(),
                    TGBlocks.RED_URN.get(),
                    TGBlocks.YELLOW_URN.get(),
                    TGBlocks.ORANGE_URN.get(),
                    TGBlocks.GREEN_URN.get(),
                    TGBlocks.LIME_URN.get(),
                    TGBlocks.WHITE_URN.get(),
                    TGBlocks.SMALL_BLACK_URN.get(),
                    TGBlocks.SMALL_BLUE_URN.get(),
                    TGBlocks.SMALL_LIGHT_BLUE_URN.get(),
                    TGBlocks.SMALL_CYAN_URN.get(),
                    TGBlocks.SMALL_BROWN_URN.get(),
                    TGBlocks.SMALL_GRAY_URN.get(),
                    TGBlocks.SMALL_LIGHT_GRAY_URN.get(),
                    TGBlocks.SMALL_PURPLE_URN.get(),
                    TGBlocks.SMALL_MAGENTA_URN.get(),
                    TGBlocks.SMALL_PINK_URN.get(),
                    TGBlocks.SMALL_RED_URN.get(),
                    TGBlocks.SMALL_YELLOW_URN.get(),
                    TGBlocks.SMALL_ORANGE_URN.get(),
                    TGBlocks.SMALL_GREEN_URN.get(),
                    TGBlocks.SMALL_LIME_URN.get(),
                    TGBlocks.SMALL_WHITE_URN.get()
            ).build(null)
    );

    public static final Supplier<BlockEntityType<SarcophagusBlockEntity>> SARCOPHAGUS_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "sarcophagus_block_entity",
            () -> BlockEntityType.Builder.of(
                    SarcophagusBlockEntity::new,
                    TGBlocks.SARCOPHAGUS.get(),
                    TGBlocks.OAK_COFFIN.get(),
                    TGBlocks.DARK_OAK_COFFIN.get(),
                    TGBlocks.ACACIA_COFFIN.get(),
                    TGBlocks.JUNGLE_COFFIN.get(),
                    TGBlocks.BIRCH_COFFIN.get(),
                    TGBlocks.CRIMSON_COFFIN.get(),
                    TGBlocks.WARPED_COFFIN.get(),
                    TGBlocks.SPRUCE_COFFIN.get(),
                    TGBlocks.MANGROVE_COFFIN.get(),
                    TGBlocks.BAMBOO_COFFIN.get(),
                    TGBlocks.CHERRY_COFFIN.get()
            ).build(null)
    );

    public static final Supplier<BlockEntityType<BrazierBlockEntity>> BRAZIER_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "brazier_block_entity",
            () -> BlockEntityType.Builder.of(
                    BrazierBlockEntity::new,
                    TGBlocks.SOUL_FIRE_BRAZIER.get(),
                    TGBlocks.FIRE_BRAZIER.get()
            ).build(null)
    );
}
