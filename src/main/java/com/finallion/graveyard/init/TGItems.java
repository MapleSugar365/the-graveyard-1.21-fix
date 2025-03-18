package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.item.BoneStaffItem;
import com.finallion.graveyard.item.DaggerItem;
import com.finallion.graveyard.item.VialOfBlood;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class TGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(TheGraveyard.MOD_ID);

    public static final Supplier<Item> OSSUARY = ITEMS.register("ossuary", () -> new BlockItem(TGBlocks.OSSUARY.get(), new Item.Properties()));
    public static final Supplier<Item> INCARNATED_EVIL_MUSIC_DISC = ITEMS.register("incarnated_evil_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(TGSounds.LICH_THEME_01_KEY).stacksTo(1)));

    public static final Supplier<Item> SKELETON_CREEPER_SPAWN_EGG = ITEMS.register("skeleton_creeper_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.SKELETON_CREEPER, 7960171, 15263976, (new Item.Properties())));
    public static final Supplier<Item> ACOLYTE_SPAWN_EGG = ITEMS.register("acolyte_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.ACOLYTE, 2688830, 5898240, (new Item.Properties())));
    public static final Supplier<Item> GHOUL_SPAWN_EGG = ITEMS.register("ghoul_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.GHOUL, 6239802, 16487198, (new Item.Properties())));
    public static final Supplier<Item> REAPER_SPAWN_EGG = ITEMS.register("reaper_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.REAPER, 1381653, 7456477, (new Item.Properties())));
    public static final Supplier<Item> REVENANT_SPAWN_EGG = ITEMS.register("revenant_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.REVENANT, 12965589, 9765908, (new Item.Properties())));
    public static final Supplier<Item> NIGHTMARE_SPAWN_EGG = ITEMS.register("nightmare_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.NIGHTMARE, 592137, 4718849, (new Item.Properties())));
    public static final Supplier<Item> LICH_SPAWN_EGG = ITEMS.register("lich_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.LICH, 13750223, 4144959, (new Item.Properties())));
    public static final Supplier<Item> NAMELESS_HANGED_SPAWN_EGG = ITEMS.register("nameless_hanged_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.NAMELESS_HANGED, 5389367, 9803156, (new Item.Properties())));
    public static final Supplier<Item> WRAITH_SPAWN_EGG = ITEMS.register("wraith_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.WRAITH, 1644568, 16777215, (new Item.Properties())));
    public static final Supplier<Item> CORRUPTED_PILLAGER_SPAWN_EGG = ITEMS.register("corrupted_pillager_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.CORRUPTED_PILLAGER, 7567737, 4924973, (new Item.Properties())));
    public static final Supplier<Item> CORRUPTED_VINDICATOR_SPAWN_EGG = ITEMS.register("corrupted_vindicator_spawn_egg", () -> new DeferredSpawnEggItem(TGEntities.CORRUPTED_VINDICATOR, 7567737, 2380632, (new Item.Properties())));

    public static final Supplier<Item> BONE_DAGGER = ITEMS.register("bone_dagger", () -> new DaggerItem(Tiers.STONE, 4, -2.0F, new Item.Properties()));
    public static final Supplier<Item> DARK_IRON_INGOT = ITEMS.register("dark_iron_ingot", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CORRUPTION = ITEMS.register("corruption", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> TG_ROOTED_DIRT = ITEMS.register("tg_rooted_dirt", () -> new BlockItem(TGBlocks.TG_ROOTED_DIRT.get(), new Item.Properties()));
    public static final Supplier<Item> TG_TUFF = ITEMS.register("tg_tuff", () -> new BlockItem(TGBlocks.TG_TUFF.get(), new Item.Properties()));
    public static final Supplier<Item> TG_MOSS_BLOCK = ITEMS.register("tg_moss_block", () -> new BlockItem(TGBlocks.TG_MOSS_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> TG_DEEPSLATE = ITEMS.register("tg_deepslate", () -> new BlockItem(TGBlocks.TG_DEEPSLATE.get(), new Item.Properties()));

    // helper blocks that get don't get replaced on world generation, generate ores or generate trees on
    public static final Supplier<Item> TG_GRASS_BLOCK = ITEMS.register("tg_grass_block", () -> new BlockItem(TGBlocks.TG_GRASS_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> TG_DIRT = ITEMS.register("tg_dirt", () -> new BlockItem(TGBlocks.TG_DIRT.get(), new Item.Properties()));
    public static final Supplier<Item> TG_COARSE_DIRT = ITEMS.register("tg_coarse_dirt", () -> new BlockItem(TGBlocks.TG_COARSE_DIRT.get(), new Item.Properties()));
    public static final Supplier<Item> TG_ANDESITE = ITEMS.register("tg_andesite", () -> new BlockItem(TGBlocks.TG_ANDESITE.get(), new Item.Properties()));
    public static final Supplier<Item> TG_GRANITE = ITEMS.register("tg_granite", () -> new BlockItem(TGBlocks.TG_GRANITE.get(), new Item.Properties()));
    public static final Supplier<Item> TG_DIORITE = ITEMS.register("tg_diorite", () -> new BlockItem(TGBlocks.TG_DIORITE.get(), new Item.Properties()));
    public static final Supplier<Item> TG_STONE = ITEMS.register("tg_stone", () -> new BlockItem(TGBlocks.TG_STONE.get(), new Item.Properties()));
    public static final Supplier<Item> TG_PODZOL = ITEMS.register("tg_podzol", () -> new BlockItem(TGBlocks.TG_PODZOL.get(), new Item.Properties()));


    public static final Supplier<Item> DARK_IRON_BARS = ITEMS.register("dark_iron_bars", () -> new BlockItem(TGBlocks.DARK_IRON_BARS.get(), new Item.Properties()));
    public static final Supplier<Item> SOUL_FIRE_BRAZIER = ITEMS.register("soul_fire_brazier", () -> new BlockItem(TGBlocks.SOUL_FIRE_BRAZIER.get(), new Item.Properties()));
    public static final Supplier<Item> FIRE_BRAZIER = ITEMS.register("fire_brazier", () -> new BlockItem(TGBlocks.FIRE_BRAZIER.get(), new Item.Properties()));
    public static final Supplier<Item> PEDESTAL = ITEMS.register("pedestal", () -> new BlockItem(TGBlocks.PEDESTAL.get(), new Item.Properties()));
    public static final Supplier<Item> CANDLE_HOLDER = ITEMS.register("candle_holder", () -> new BlockItem(TGBlocks.CANDLE_HOLDER.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_IRON_TRAPDOOR = ITEMS.register("dark_iron_trapdoor", () -> new BlockItem(TGBlocks.DARK_IRON_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_IRON_DOOR = ITEMS.register("dark_iron_door", () -> new BlockItem(TGBlocks.DARK_IRON_DOOR.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_IRON_BLOCK = ITEMS.register("dark_iron_block", () -> new BlockItem(TGBlocks.DARK_IRON_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Item> SKULL_WITH_RIB_CAGE = ITEMS.register("skull_with_rib_cage", () -> new BlockItem(TGBlocks.SKULL_WITH_RIB_CAGE.get(), new Item.Properties()));
    public static final Supplier<Item> LEANING_SKELETON = ITEMS.register("leaning_skeleton", () -> new BlockItem(TGBlocks.LEANING_SKELETON.get(), new Item.Properties()));
    public static final Supplier<Item> SKULL_PILE = ITEMS.register("skull_pile", () -> new BlockItem(TGBlocks.SKULL_PILE.get(), new Item.Properties()));
    public static final Supplier<Item> LYING_SKELETON = ITEMS.register("lying_skeleton", () -> new BlockItem(TGBlocks.LYING_SKELETON.get(), new Item.Properties()));
    public static final Supplier<Item> WITHER_SKULL_WITH_RIB_CAGE = ITEMS.register("wither_skull_with_rib_cage", () -> new BlockItem(TGBlocks.WITHER_SKULL_WITH_RIB_CAGE.get(), new Item.Properties()));
    public static final Supplier<Item> LEANING_WITHER_SKELETON = ITEMS.register("leaning_wither_skeleton", () -> new BlockItem(TGBlocks.LEANING_WITHER_SKELETON.get(), new Item.Properties()));
    public static final Supplier<Item> WITHER_SKULL_PILE = ITEMS.register("wither_skull_pile", () -> new BlockItem(TGBlocks.WITHER_SKULL_PILE.get(), new Item.Properties()));
    public static final Supplier<Item> LYING_WITHER_SKELETON = ITEMS.register("lying_wither_skeleton", () -> new BlockItem(TGBlocks.LYING_WITHER_SKELETON.get(), new Item.Properties()));
    public static final Supplier<Item> CREEPER_SKELETON = ITEMS.register("creeper_skeleton", () -> new BlockItem(TGBlocks.CREEPER_SKELETON.get(), new Item.Properties()));
    public static final Supplier<Item> SKELETON_HAND = ITEMS.register("skeleton_hand", () -> new BlockItem(TGBlocks.SKELETON_HAND.get(), new Item.Properties()));
    public static final Supplier<Item> WITHER_SKELETON_HAND = ITEMS.register("wither_skeleton_hand", () -> new BlockItem(TGBlocks.WITHER_SKELETON_HAND.get(), new Item.Properties()));
    public static final Supplier<Item> HANGED_SKELETON = ITEMS.register("hanged_skeleton", () -> new BlockItem(TGBlocks.HANGED_SKELETON.get(), new Item.Properties()));
    public static final Supplier<Item> HANGED_WITHER_SKELETON = ITEMS.register("hanged_wither_skeleton", () -> new BlockItem(TGBlocks.HANGED_WITHER_SKELETON.get(), new Item.Properties()));

    public static final Supplier<Item> VASE_BLOCK = ITEMS.register("vase_block", () -> new BlockItem(TGBlocks.VASE_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Item> GRAVESTONE = ITEMS.register("gravestone", () -> new BlockItem(TGBlocks.GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> COBBLESTONE_GRAVESTONE = ITEMS.register( "cobblestone_gravestone", () -> new BlockItem(TGBlocks.COBBLESTONE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> MOSSY_COBBLESTONE_GRAVESTONE = ITEMS.register("mossy_cobblestone_gravestone", () -> new BlockItem(TGBlocks.MOSSY_COBBLESTONE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> DEEPSLATE_GRAVESTONE = ITEMS.register("deepslate_gravestone", () -> new BlockItem(TGBlocks.DEEPSLATE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> BLACKSTONE_GRAVESTONE = ITEMS.register("blackstone_gravestone", () -> new BlockItem(TGBlocks.BLACKSTONE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> CRACKED_BLACKSTONE_GRAVESTONE = ITEMS.register("cracked_blackstone_gravestone", () -> new BlockItem(TGBlocks.CRACKED_BLACKSTONE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> STONE_BRICKS_GRAVESTONE = ITEMS.register("stone_bricks_gravestone", () -> new BlockItem(TGBlocks.STONE_BRICKS_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> MOSSY_STONE_BRICKS_GRAVESTONE = ITEMS.register("mossy_stone_bricks_gravestone", () -> new BlockItem(TGBlocks.MOSSY_STONE_BRICKS_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> BRICKS_GRAVESTONE = ITEMS.register("bricks_gravestone", () -> new BlockItem(TGBlocks.BRICKS_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> GILDED_BLACKSTONE_GRAVESTONE = ITEMS.register("gilded_blackstone_gravestone", () -> new BlockItem(TGBlocks.GILDED_BLACKSTONE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> SANDSTONE_GRAVESTONE = ITEMS.register("sandstone_gravestone", () -> new BlockItem(TGBlocks.SANDSTONE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> RED_SANDSTONE_GRAVESTONE = ITEMS.register("red_sandstone_gravestone", () -> new BlockItem(TGBlocks.RED_SANDSTONE_GRAVESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> QUARTZ_BRICKS_GRAVESTONE = ITEMS.register("quartz_bricks_gravestone", () -> new BlockItem(TGBlocks.QUARTZ_BRICKS_GRAVESTONE.get(), new Item.Properties()));

    public static final Supplier<Item> BLACK_URN = ITEMS.register("black_urn", () -> new BlockItem(TGBlocks.BLACK_URN.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_URN = ITEMS.register("brown_urn", () -> new BlockItem(TGBlocks.BROWN_URN.get(), new Item.Properties()));
    public static final Supplier<Item> WHITE_URN = ITEMS.register("white_urn", () -> new BlockItem(TGBlocks.WHITE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_URN = ITEMS.register("gray_urn", () -> new BlockItem(TGBlocks.GRAY_URN.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_URN = ITEMS.register("light_gray_urn", () -> new BlockItem(TGBlocks.LIGHT_GRAY_URN.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_URN = ITEMS.register("blue_urn", () -> new BlockItem(TGBlocks.BLUE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_URN = ITEMS.register("cyan_urn", () -> new BlockItem(TGBlocks.CYAN_URN.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_URN = ITEMS.register("light_blue_urn", () -> new BlockItem(TGBlocks.LIGHT_BLUE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> RED_URN = ITEMS.register("red_urn", () -> new BlockItem(TGBlocks.RED_URN.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_URN = ITEMS.register("orange_urn", () -> new BlockItem(TGBlocks.ORANGE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_URN = ITEMS.register("yellow_urn", () -> new BlockItem(TGBlocks.YELLOW_URN.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_URN = ITEMS.register("pink_urn", () -> new BlockItem(TGBlocks.PINK_URN.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_URN = ITEMS.register("magenta_urn", () -> new BlockItem(TGBlocks.MAGENTA_URN.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_URN = ITEMS.register("purple_urn", () -> new BlockItem(TGBlocks.PURPLE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_URN = ITEMS.register("green_urn", () -> new BlockItem(TGBlocks.GREEN_URN.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_URN = ITEMS.register("lime_urn", () -> new BlockItem(TGBlocks.LIME_URN.get(), new Item.Properties()));

    public static final Supplier<Item> SMALL_BLACK_URN = ITEMS.register("small_black_urn", () -> new BlockItem(TGBlocks.SMALL_BLACK_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_BROWN_URN = ITEMS.register("small_brown_urn", () -> new BlockItem(TGBlocks.SMALL_BROWN_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_WHITE_URN = ITEMS.register("small_white_urn", () -> new BlockItem(TGBlocks.SMALL_WHITE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_GRAY_URN = ITEMS.register("small_gray_urn", () -> new BlockItem(TGBlocks.SMALL_GRAY_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_LIGHT_GRAY_URN = ITEMS.register("small_light_gray_urn", () -> new BlockItem(TGBlocks.SMALL_LIGHT_GRAY_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_BLUE_URN = ITEMS.register("small_blue_urn", () -> new BlockItem(TGBlocks.SMALL_BLUE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_CYAN_URN = ITEMS.register("small_cyan_urn", () -> new BlockItem(TGBlocks.SMALL_CYAN_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_LIGHT_BLUE_URN = ITEMS.register("small_light_blue_urn", () -> new BlockItem(TGBlocks.SMALL_LIGHT_BLUE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_RED_URN = ITEMS.register("small_red_urn", () -> new BlockItem(TGBlocks.SMALL_RED_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_ORANGE_URN = ITEMS.register("small_orange_urn", () -> new BlockItem(TGBlocks.SMALL_ORANGE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_YELLOW_URN = ITEMS.register("small_yellow_urn", () -> new BlockItem(TGBlocks.SMALL_YELLOW_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_PINK_URN = ITEMS.register("small_pink_urn", () -> new BlockItem(TGBlocks.SMALL_PINK_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_MAGENTA_URN = ITEMS.register("small_magenta_urn", () -> new BlockItem(TGBlocks.SMALL_MAGENTA_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_PURPLE_URN = ITEMS.register("small_purple_urn", () -> new BlockItem(TGBlocks.SMALL_PURPLE_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_GREEN_URN = ITEMS.register("small_green_urn", () -> new BlockItem(TGBlocks.SMALL_GREEN_URN.get(), new Item.Properties()));
    public static final Supplier<Item> SMALL_LIME_URN = ITEMS.register("small_lime_urn", () -> new BlockItem(TGBlocks.SMALL_LIME_URN.get(), new Item.Properties()));

    public static final Supplier<Item> SARCOPHAGUS = ITEMS.register("sarcophagus", () -> new BlockItem(TGBlocks.SARCOPHAGUS.get(), new Item.Properties()));
    public static final Supplier<Item> OAK_COFFIN = ITEMS.register("oak_coffin", () -> new BlockItem(TGBlocks.OAK_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_COFFIN = ITEMS.register("spruce_coffin", () -> new BlockItem(TGBlocks.SPRUCE_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_COFFIN = ITEMS.register("birch_coffin", () -> new BlockItem(TGBlocks.BIRCH_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_COFFIN = ITEMS.register("dark_oak_coffin", () -> new BlockItem(TGBlocks.DARK_OAK_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_COFFIN = ITEMS.register("jungle_coffin", () -> new BlockItem(TGBlocks.JUNGLE_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_COFFIN = ITEMS.register("acacia_coffin", () -> new BlockItem(TGBlocks.ACACIA_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_COFFIN = ITEMS.register("warped_coffin", () -> new BlockItem(TGBlocks.WARPED_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_COFFIN = ITEMS.register("crimson_coffin", () -> new BlockItem(TGBlocks.CRIMSON_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_COFFIN = ITEMS.register("mangrove_coffin", () -> new BlockItem(TGBlocks.MANGROVE_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> BAMBOO_COFFIN = ITEMS.register("bamboo_coffin", () -> new BlockItem(TGBlocks.BAMBOO_COFFIN.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_COFFIN = ITEMS.register("cherry_coffin", () -> new BlockItem(TGBlocks.CHERRY_COFFIN.get(), new Item.Properties()));

    public static final Supplier<Item> SARCOPHAGUS_LID = ITEMS.register("sarcophagus_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SARCOPHAGUS_BASE = ITEMS.register("sarcophagus_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_COFFIN_LID = ITEMS.register("dark_oak_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_COFFIN_BASE = ITEMS.register("dark_oak_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> OAK_COFFIN_LID = ITEMS.register("oak_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> OAK_COFFIN_BASE = ITEMS.register("oak_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BIRCH_COFFIN_LID = ITEMS.register("birch_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BIRCH_COFFIN_BASE = ITEMS.register("birch_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> JUNGLE_COFFIN_LID = ITEMS.register("jungle_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> JUNGLE_COFFIN_BASE = ITEMS.register("jungle_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ACACIA_COFFIN_LID = ITEMS.register("acacia_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ACACIA_COFFIN_BASE = ITEMS.register("acacia_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SPRUCE_COFFIN_LID = ITEMS.register("spruce_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SPRUCE_COFFIN_BASE = ITEMS.register("spruce_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> WARPED_COFFIN_LID = ITEMS.register("warped_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> WARPED_COFFIN_BASE = ITEMS.register("warped_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CRIMSON_COFFIN_LID = ITEMS.register("crimson_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CRIMSON_COFFIN_BASE = ITEMS.register("crimson_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> MANGROVE_COFFIN_LID = ITEMS.register("mangrove_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> MANGROVE_COFFIN_BASE = ITEMS.register("mangrove_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BAMBOO_COFFIN_LID = ITEMS.register("bamboo_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BAMBOO_COFFIN_BASE = ITEMS.register("bamboo_coffin_base", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CHERRY_COFFIN_LID = ITEMS.register("cherry_coffin_lid", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CHERRY_COFFIN_BASE = ITEMS.register("cherry_coffin_base", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> VIAL_OF_BLOOD = ITEMS.register("vial_of_blood", VialOfBlood::new);

    public static final Supplier<Item> TORSO_PILE = ITEMS.register("torso_pile", () -> new BlockItem(TGBlocks.TORSO_PILE.get(), new Item.Properties()));
    public static final Supplier<Item> WITHER_TORSO_PILE = ITEMS.register("wither_torso_pile", () -> new BlockItem(TGBlocks.WITHER_TORSO_PILE.get(), new Item.Properties()));
    public static final Supplier<Item> SKULL_ON_PIKE = ITEMS.register("skull_on_pike", () -> new BlockItem(TGBlocks.SKULL_ON_PIKE.get(), new Item.Properties()));
    public static final Supplier<Item> WITHER_SKULL_ON_PIKE = ITEMS.register("wither_skull_on_pike", () -> new BlockItem(TGBlocks.WITHER_SKULL_ON_PIKE.get(), new Item.Properties()));
    public static final Supplier<Item> BONE_REMAINS = ITEMS.register("bone_remains", () -> new BlockItem(TGBlocks.BONE_REMAINS.get(), new Item.Properties()));
    public static final Supplier<Item> WITHER_BONE_REMAINS = ITEMS.register("wither_bone_remains", () -> new BlockItem(TGBlocks.WITHER_BONE_REMAINS.get(), new Item.Properties()));
    public static final Supplier<Item> LATERALLY_LYING_SKELETON = ITEMS.register("laterally_lying_skeleton", () -> new BlockItem(TGBlocks.LATERALLY_LYING_SKELETON.get(), new Item.Properties()));
    public static final Supplier<Item> LATERALLY_LYING_WITHER_SKELETON = ITEMS.register("laterally_lying_wither_skeleton", () -> new BlockItem(TGBlocks.LATERALLY_LYING_WITHER_SKELETON.get(), new Item.Properties()));

    public static final Supplier<Item> WHITE_BONE_STAFF = ITEMS.register("white_bone_staff", () -> new BoneStaffItem((byte) 1));
    public static final Supplier<Item> BLACK_BONE_STAFF = ITEMS.register("black_bone_staff", () -> new BoneStaffItem((byte) 2));
    public static final Supplier<Item> RED_BONE_STAFF = ITEMS.register("red_bone_staff", () -> new BoneStaffItem((byte) 3));
    public static final Supplier<Item> CYAN_BONE_STAFF = ITEMS.register("cyan_bone_staff", () -> new BoneStaffItem((byte) 4));
    public static final Supplier<Item> PURPLE_BONE_STAFF = ITEMS.register("purple_bone_staff", () -> new BoneStaffItem((byte) 5));


    public static final Supplier<Item> ALTAR = ITEMS.register("altar", () -> new BlockItem(TGBlocks.ALTAR.get(), new Item.Properties()));
    public static final Supplier<Item> ALTAR_SIDE = ITEMS.register("altar_side", () -> new BlockItem(TGBlocks.ALTAR_SIDE.get(), new Item.Properties()));
    public static final Supplier<Item> ALTAR_CORNER = ITEMS.register("altar_corner", () -> new BlockItem(TGBlocks.ALTAR_CORNER.get(), new Item.Properties()));
    public static final Supplier<Item> ALTAR_CENTER = ITEMS.register("altar_center", () -> new BlockItem(TGBlocks.ALTAR_CENTER.get(), new Item.Properties()));
    public static final Supplier<Item> UPPER_BONE_STAFF = ITEMS.register("upper_bone_staff", () -> new BlockItem(TGBlocks.UPPER_BONE_STAFF.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MIDDLE_BONE_STAFF = ITEMS.register("middle_bone_staff", () -> new BlockItem(TGBlocks.MIDDLE_BONE_STAFF.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> LOWER_BONE_STAFF = ITEMS.register("lower_bone_staff", () -> new BlockItem(TGBlocks.LOWER_BONE_STAFF.get(), new Item.Properties().stacksTo(1)));


}
