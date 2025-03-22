package com.finallion.graveyard.world.level.block.state;

import com.finallion.graveyard.TheGraveyard;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.stream.Stream;

public record GravestoneType(String name, ResourceLocation texture) {
    private static final Map<String, GravestoneType> TYPES = new Object2ObjectArrayMap();
    public static final Codec<GravestoneType> CODEC =
            Codec.stringResolver(GravestoneType::name, GravestoneType.TYPES::get);

    public static final GravestoneType POLISHED_BASALT = register(new GravestoneType("polished_basalt"));
    public static final GravestoneType COBBLESTONE = register(new GravestoneType("cobblestone"));
    public static final GravestoneType MOSSY_COBBLESTONE = register(new GravestoneType("mossy_cobblestone"));
    public static final GravestoneType DEEPSLATE = register(new GravestoneType("deepslate"));
    public static final GravestoneType BLACKSTONE = register(new GravestoneType("blackstone"));
    public static final GravestoneType CRACKED_BLACKSTONE = register(new GravestoneType("cracked_blackstone"));
    public static final GravestoneType STONE_BRICKS = register(new GravestoneType("stone_bricks"));
    public static final GravestoneType MOSSY_STONE_BRICKS = register(new GravestoneType("mossy_stone_bricks"));
    public static final GravestoneType BRICKS = register(new GravestoneType("bricks"));
    public static final GravestoneType SANDSTONE = register(new GravestoneType("sandstone"));
    public static final GravestoneType RED_SANDSTONE = register(new GravestoneType("red_sandstone"));
    public static final GravestoneType GILDED_BLACKSTONE = register(new GravestoneType("gilded_blackstone"));
    public static final GravestoneType QUARTZ_BRICKS = register(new GravestoneType("quartz_bricks"));

    public GravestoneType(String name) {
        this(name, ResourceLocation.fromNamespaceAndPath(
                TheGraveyard.MOD_ID,
                "textures/entity/gravestone/" + name + ".png"));
    }

    public static GravestoneType register(GravestoneType gravestoneType) {
        TYPES.put(gravestoneType.name(), gravestoneType);
        return gravestoneType;
    }

    public static Stream<GravestoneType> values() {
        return TYPES.values().stream();
    }
}
