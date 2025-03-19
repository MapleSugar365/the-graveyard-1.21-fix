package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.world.processors.RemoveWaterloggedCryptProcessor;
import com.finallion.graveyard.world.processors.RemoveWaterloggedProcessor;
import com.finallion.graveyard.world.processors.SwitchSpawnerProcessor;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class TGProcessors {
    // Processor uses:
    // Haunted House
    // Small Crypt
    // Wither Mill

    public static StructureProcessorType<RemoveWaterloggedProcessor> REMOVE_WATERLOGGED = register("remove_waterlogged_processor", RemoveWaterloggedProcessor.CODEC);
    public static StructureProcessorType<SwitchSpawnerProcessor> SWITCH_SPAWNER = register("switch_spawner_processor", SwitchSpawnerProcessor.CODEC);
    public static StructureProcessorType<RemoveWaterloggedCryptProcessor> REMOVE_WATERLOGGED_CRYPT = register("waterlogged_crypt_processor", RemoveWaterloggedCryptProcessor.CODEC);

    static <P extends StructureProcessor> StructureProcessorType<P> register(String name, MapCodec<P> codec) {
        return Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, name), () -> codec);
    }
}
