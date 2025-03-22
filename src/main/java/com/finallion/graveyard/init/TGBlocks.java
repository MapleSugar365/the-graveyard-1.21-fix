package com.finallion.graveyard.init;


import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.blocks.*;
import com.finallion.graveyard.world.level.block.state.GravestoneType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;


public class TGBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TheGraveyard.MOD_ID);

    public static final DeferredBlock<Block> TG_ROOTED_DIRT = BLOCKS.register("tg_rooted_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).lootFrom(() -> Blocks.ROOTED_DIRT)));
    public static final DeferredBlock<Block> TG_TUFF = BLOCKS.register("tg_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).lootFrom(() -> Blocks.TUFF)));
    public static final DeferredBlock<TGMossBlock> TG_MOSS_BLOCK = BLOCKS.register("tg_moss_block", () -> new TGMossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK).lootFrom(() -> Blocks.MOSS_BLOCK)));
    public static final DeferredBlock<TGDeepslateBlock> TG_DEEPSLATE = BLOCKS.register("tg_deepslate", () -> new TGDeepslateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).lootFrom(() -> Blocks.DEEPSLATE)));

    // helper blocks that get don't get replaced on world generation, generate ores or generate trees on
    public static final DeferredBlock<TGGrassBlock> TG_GRASS_BLOCK = BLOCKS.register("tg_grass_block", () -> new TGGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).lootFrom(() -> Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<TGStoneBlock> TG_DIRT = BLOCKS.register("tg_dirt", () -> new TGStoneBlock(() -> Blocks.DIRT, BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).lootFrom(() -> Blocks.DIRT)));
    public static final DeferredBlock<TGStoneBlock> TG_COARSE_DIRT = BLOCKS.register("tg_coarse_dirt", () -> new TGStoneBlock(() -> Blocks.COARSE_DIRT, BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT).lootFrom(() -> Blocks.COARSE_DIRT)));
    public static final DeferredBlock<TGStoneBlock> TG_ANDESITE = BLOCKS.register("tg_andesite", () -> new TGStoneBlock(() -> Blocks.ANDESITE, BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).lootFrom(() -> Blocks.ANDESITE)));
    public static final DeferredBlock<TGStoneBlock> TG_GRANITE = BLOCKS.register("tg_granite", () -> new TGStoneBlock(() -> Blocks.GRANITE, BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).lootFrom(() -> Blocks.GRANITE)));
    public static final DeferredBlock<TGStoneBlock> TG_DIORITE = BLOCKS.register("tg_diorite", () -> new TGStoneBlock(() -> Blocks.DIORITE, BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).lootFrom(() -> Blocks.DIORITE)));
    public static final DeferredBlock<TGStoneBlock> TG_STONE = BLOCKS.register("tg_stone", () -> new TGStoneBlock(() -> Blocks.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lootFrom(() -> Blocks.STONE)));
    public static final DeferredBlock<TGStoneBlock> TG_PODZOL = BLOCKS.register("tg_podzol", () -> new TGStoneBlock(() -> Blocks.PODZOL, BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL).lootFrom(() -> Blocks.PODZOL)));


    public static final DeferredBlock<DarkIronBars> DARK_IRON_BARS = BLOCKS.register("dark_iron_bars", () -> new DarkIronBars(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion()));
    public static final DeferredBlock<BrazierBlock> SOUL_FIRE_BRAZIER = BLOCKS.register("soul_fire_brazier", () -> new BrazierBlock(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().lightLevel(BrazierBlock.STATE_TO_LUMINANCE).sound(SoundType.METAL), ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<BrazierBlock> FIRE_BRAZIER = BLOCKS.register("fire_brazier", () -> new BrazierBlock(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().lightLevel(BrazierBlock.STATE_TO_LUMINANCE).sound(SoundType.METAL), ParticleTypes.FLAME));
    public static final DeferredBlock<PedestalBlock> PEDESTAL = BLOCKS.register("pedestal", () -> new PedestalBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<CandleHolderBlock> CANDLE_HOLDER = BLOCKS.register("candle_holder", () -> new CandleHolderBlock(BlockBehaviour.Properties.of().strength(1.0F).noOcclusion().sound(SoundType.METAL)));
    public static final DeferredBlock<TGTrapDoorBlock> DARK_IRON_TRAPDOOR = BLOCKS.register("dark_iron_trapdoor", () -> new TGTrapDoorBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<TGDoorBlock> DARK_IRON_DOOR = BLOCKS.register("dark_iron_door", () -> new TGDoorBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> DARK_IRON_BLOCK = BLOCKS.register("dark_iron_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final DeferredBlock<BoneDisplayBlock> SKULL_WITH_RIB_CAGE = BLOCKS.register("skull_with_rib_cage", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> LEANING_SKELETON = BLOCKS.register("leaning_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> SKULL_PILE = BLOCKS.register("skull_pile", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> LYING_SKELETON = BLOCKS.register("lying_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> WITHER_SKULL_WITH_RIB_CAGE = BLOCKS.register("wither_skull_with_rib_cage", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> LEANING_WITHER_SKELETON = BLOCKS.register("leaning_wither_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> WITHER_SKULL_PILE = BLOCKS.register("wither_skull_pile", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> LYING_WITHER_SKELETON = BLOCKS.register("lying_wither_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> CREEPER_SKELETON = BLOCKS.register("creeper_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> SKELETON_HAND = BLOCKS.register("skeleton_hand", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> WITHER_SKELETON_HAND = BLOCKS.register("wither_skeleton_hand", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> BONE_REMAINS = BLOCKS.register("bone_remains", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> WITHER_BONE_REMAINS = BLOCKS.register("wither_bone_remains", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> LATERALLY_LYING_SKELETON = BLOCKS.register("laterally_lying_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> LATERALLY_LYING_WITHER_SKELETON = BLOCKS.register("laterally_lying_wither_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> SKULL_ON_PIKE = BLOCKS.register("skull_on_pike", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> WITHER_SKULL_ON_PIKE = BLOCKS.register("wither_skull_on_pike", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> TORSO_PILE = BLOCKS.register("torso_pile", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> WITHER_TORSO_PILE = BLOCKS.register("wither_torso_pile", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> HANGED_SKELETON = BLOCKS.register("hanged_skeleton", BoneDisplayBlock::new);
    public static final DeferredBlock<BoneDisplayBlock> HANGED_WITHER_SKELETON = BLOCKS.register("hanged_wither_skeleton", BoneDisplayBlock::new);


    public static final DeferredBlock<VaseBlock> VASE_BLOCK = BLOCKS.register("vase_block", VaseBlock::new);

    public static final DeferredBlock<GravestoneBlock> GRAVESTONE = BLOCKS.register("gravestone", () -> new GravestoneBlock(GravestoneType.POLISHED_BASALT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.BASALT).strength(1.25F, 4.2F)));
    public static final DeferredBlock<GravestoneBlock> COBBLESTONE_GRAVESTONE = BLOCKS.register("cobblestone_gravestone", () -> new GravestoneBlock(GravestoneType.COBBLESTONE, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> MOSSY_COBBLESTONE_GRAVESTONE = BLOCKS.register("mossy_cobblestone_gravestone", () -> new GravestoneBlock(GravestoneType.MOSSY_COBBLESTONE, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(2.0F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> DEEPSLATE_GRAVESTONE = BLOCKS.register("deepslate_gravestone", () -> new GravestoneBlock(GravestoneType.DEEPSLATE, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).forceSolidOn().sound(SoundType.DEEPSLATE).strength(3.0F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> BLACKSTONE_GRAVESTONE = BLOCKS.register("blackstone_gravestone", () -> new GravestoneBlock(GravestoneType.BLACKSTONE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> CRACKED_BLACKSTONE_GRAVESTONE = BLOCKS.register("cracked_blackstone_gravestone", () -> new GravestoneBlock(GravestoneType.CRACKED_BLACKSTONE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> STONE_BRICKS_GRAVESTONE = BLOCKS.register("stone_bricks_gravestone", () -> new GravestoneBlock(GravestoneType.STONE_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> MOSSY_STONE_BRICKS_GRAVESTONE = BLOCKS.register("mossy_stone_bricks_gravestone", () -> new GravestoneBlock(GravestoneType.MOSSY_STONE_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> BRICKS_GRAVESTONE = BLOCKS.register("bricks_gravestone", () -> new GravestoneBlock(GravestoneType.BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> SANDSTONE_GRAVESTONE = BLOCKS.register("sandstone_gravestone", () -> new GravestoneBlock(GravestoneType.SANDSTONE, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(0.8F)));
    public static final DeferredBlock<GravestoneBlock> RED_SANDSTONE_GRAVESTONE = BLOCKS.register("red_sandstone_gravestone", () -> new GravestoneBlock(GravestoneType.RED_SANDSTONE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(0.8F)));
    public static final DeferredBlock<GravestoneBlock> GILDED_BLACKSTONE_GRAVESTONE = BLOCKS.register("gilded_blackstone_gravestone", () -> new GravestoneBlock(GravestoneType.GILDED_BLACKSTONE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.GILDED_BLACKSTONE).strength(1.5F, 6.0F)));
    public static final DeferredBlock<GravestoneBlock> QUARTZ_BRICKS_GRAVESTONE = BLOCKS.register("quartz_bricks_gravestone", () -> new GravestoneBlock(GravestoneType.QUARTZ_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(0.8F)));

    public static final DeferredBlock<UrnBlock> BLACK_URN = BLOCKS.register("black_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> BROWN_URN = BLOCKS.register("brown_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> WHITE_URN = BLOCKS.register("white_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> GRAY_URN = BLOCKS.register("gray_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> LIGHT_GRAY_URN = BLOCKS.register("light_gray_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> BLUE_URN = BLOCKS.register("blue_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> CYAN_URN = BLOCKS.register("cyan_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> LIGHT_BLUE_URN = BLOCKS.register("light_blue_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> RED_URN = BLOCKS.register("red_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> ORANGE_URN = BLOCKS.register("orange_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> YELLOW_URN = BLOCKS.register("yellow_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> PINK_URN = BLOCKS.register("pink_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> MAGENTA_URN = BLOCKS.register("magenta_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> PURPLE_URN = BLOCKS.register("purple_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> GREEN_URN = BLOCKS.register("green_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> LIME_URN = BLOCKS.register("lime_urn", () -> new UrnBlock());

    public static final DeferredBlock<UrnBlock> SMALL_BLACK_URN = BLOCKS.register("small_black_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_BROWN_URN = BLOCKS.register("small_brown_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_WHITE_URN = BLOCKS.register("small_white_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_GRAY_URN = BLOCKS.register("small_gray_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_LIGHT_GRAY_URN = BLOCKS.register("small_light_gray_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_BLUE_URN = BLOCKS.register("small_blue_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_CYAN_URN = BLOCKS.register("small_cyan_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_LIGHT_BLUE_URN = BLOCKS.register("small_light_blue_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_RED_URN = BLOCKS.register("small_red_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_ORANGE_URN = BLOCKS.register("small_orange_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_YELLOW_URN = BLOCKS.register("small_yellow_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_PINK_URN = BLOCKS.register("small_pink_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_MAGENTA_URN = BLOCKS.register("small_magenta_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_PURPLE_URN = BLOCKS.register("small_purple_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_GREEN_URN = BLOCKS.register("small_green_urn", () -> new UrnBlock());
    public static final DeferredBlock<UrnBlock> SMALL_LIME_URN = BLOCKS.register("small_lime_urn", () -> new UrnBlock());

    public static final DeferredBlock<SarcophagusBlock> SARCOPHAGUS = BLOCKS.register("sarcophagus", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.5F), false, itemResourceLocation("sarcophagus_lid"), itemResourceLocation("sarcophagus_base")));
    public static final DeferredBlock<SarcophagusBlock> OAK_COFFIN = BLOCKS.register("oak_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("oak_coffin_lid"), itemResourceLocation("oak_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> SPRUCE_COFFIN = BLOCKS.register("spruce_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("spruce_coffin_lid"), itemResourceLocation("spruce_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> BIRCH_COFFIN = BLOCKS.register("birch_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("birch_coffin_lid"), itemResourceLocation("birch_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> DARK_OAK_COFFIN = BLOCKS.register("dark_oak_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("dark_oak_coffin_lid"), itemResourceLocation("dark_oak_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> JUNGLE_COFFIN = BLOCKS.register("jungle_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("jungle_coffin_lid"), itemResourceLocation("jungle_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> ACACIA_COFFIN = BLOCKS.register("acacia_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("acacia_coffin_lid"), itemResourceLocation("acacia_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> WARPED_COFFIN = BLOCKS.register("warped_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("warped_coffin_lid"), itemResourceLocation("warped_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> CRIMSON_COFFIN = BLOCKS.register("crimson_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("crimson_coffin_lid"), itemResourceLocation("crimson_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> MANGROVE_COFFIN = BLOCKS.register("mangrove_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("mangrove_coffin_lid"), itemResourceLocation("mangrove_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> BAMBOO_COFFIN = BLOCKS.register("bamboo_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("bamboo_coffin_lid"), itemResourceLocation("bamboo_coffin_base")));
    public static final DeferredBlock<SarcophagusBlock> CHERRY_COFFIN = BLOCKS.register("cherry_coffin", () -> new SarcophagusBlock(BlockBehaviour.Properties.of().ignitedByLava().noOcclusion().strength(1.0F), true, itemResourceLocation("cherry_coffin_lid"), itemResourceLocation("cherry_coffin_base")));
    public static final List<DeferredBlock<SarcophagusBlock>> COFFINS = List.of(
            OAK_COFFIN,
            SPRUCE_COFFIN,
            DARK_OAK_COFFIN,
            BIRCH_COFFIN,
            JUNGLE_COFFIN,
            ACACIA_COFFIN,
            CRIMSON_COFFIN,
            WARPED_COFFIN,
            MANGROVE_COFFIN,
            BAMBOO_COFFIN,
            CHERRY_COFFIN
    );
    private static ResourceLocation itemResourceLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "item/" + name);
    }

    public static final DeferredBlock<AltarBlock> ALTAR = BLOCKS.register("altar", () -> new AltarBlock(BlockBehaviour.Properties.of().strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<AltarSideBlock> ALTAR_SIDE = BLOCKS.register("altar_side", () -> new AltarSideBlock(BlockBehaviour.Properties.of().strength(50.0F, 1200.0F).noLootTable()));
    public static final DeferredBlock<AltarCornerBlock> ALTAR_CORNER = BLOCKS.register("altar_corner", () -> new AltarCornerBlock(BlockBehaviour.Properties.of().strength(50.0F, 1200.0F).noLootTable()));
    public static final DeferredBlock<AltarCenterBlock> ALTAR_CENTER = BLOCKS.register("altar_center", () -> new AltarCenterBlock(BlockBehaviour.Properties.of().strength(50.0F, 1200.0F).noLootTable()));

    public static final DeferredBlock<OminousBoneStaffFragmentBlock> LOWER_BONE_STAFF = BLOCKS.register("lower_bone_staff", OminousBoneStaffFragmentBlock::new);
    public static final DeferredBlock<OminousBoneStaffFragmentBlock> MIDDLE_BONE_STAFF = BLOCKS.register("middle_bone_staff", OminousBoneStaffFragmentBlock::new);
    public static final DeferredBlock<OminousBoneStaffFragmentBlock> UPPER_BONE_STAFF = BLOCKS.register("upper_bone_staff", OminousBoneStaffFragmentBlock::new);

    public static final DeferredBlock<OssuaryBlock> OSSUARY = BLOCKS.register("ossuary", () -> new OssuaryBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().noOcclusion().strength(3.5F)));
}
