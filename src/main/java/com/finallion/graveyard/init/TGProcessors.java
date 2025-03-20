package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.world.processors.RemoveWaterloggedCryptProcessor;
import com.finallion.graveyard.world.processors.RemoveWaterloggedProcessor;
import com.finallion.graveyard.world.processors.SwitchSpawnerProcessor;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TGProcessors {
    public static final DeferredRegister<StructureProcessorType<?>> PROCESSORS = DeferredRegister.create(BuiltInRegistries.STRUCTURE_PROCESSOR, TheGraveyard.MOD_ID);


    public static Supplier<StructureProcessorType<RemoveWaterloggedProcessor>> REMOVE_WATERLOGGED = register("remove_waterlogged_processor", RemoveWaterloggedProcessor.CODEC);
    public static Supplier<StructureProcessorType<SwitchSpawnerProcessor>> SWITCH_SPAWNER = register("switch_spawner_processor", SwitchSpawnerProcessor.CODEC);
    public static Supplier<StructureProcessorType<RemoveWaterloggedCryptProcessor>> REMOVE_WATERLOGGED_CRYPT = register("waterlogged_crypt_processor", RemoveWaterloggedCryptProcessor.CODEC);

    static <P extends StructureProcessor> Supplier<StructureProcessorType<P>> register(String name, MapCodec<P> codec) {
        return PROCESSORS.register(name, () -> () -> codec);
    }
}
