package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.world.structures.TGJigsawStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TGStructureType {
        public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister
                        .create(Registries.STRUCTURE_TYPE, TheGraveyard.MOD_ID);

        public static final DeferredHolder<StructureType<?>, StructureType<TGJigsawStructure>> TG_JIGSAW = STRUCTURE_TYPES
                        .register("tg_jigsaw", () -> () -> TGJigsawStructure.CODEC);
}