package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.advancements.TGAdvancementTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class TGAdvancements {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGER_TYPES = DeferredRegister.create(Registries.TRIGGER_TYPE, TheGraveyard.MOD_ID);

    public static Supplier<TGAdvancementTrigger> KILLED_BY_BONE_DAGGER = TRIGGER_TYPES.register("killed_by_bone_dagger", () -> new TGAdvancementTrigger(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "killed_by_bone_dagger")));
    public static Supplier<TGAdvancementTrigger> KILL_WHILE_BLINDED = TRIGGER_TYPES.register("kill_while_blinded",() -> new TGAdvancementTrigger(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "kill_while_blinded")));
    public static Supplier<TGAdvancementTrigger> DIM_LIGHT = TRIGGER_TYPES.register("dim_light",() -> new TGAdvancementTrigger(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "dim_light")));
    public static Supplier<TGAdvancementTrigger> KILL_HORDE = TRIGGER_TYPES.register("kill_horde",() -> new TGAdvancementTrigger(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "kill_horde")));
    public static Supplier<TGAdvancementTrigger> SPAWN_WRAITH = TRIGGER_TYPES.register("spawn_wraith",() -> new TGAdvancementTrigger(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "spawn_wraith")));
    public static Supplier<TGAdvancementTrigger> EQUIP_COFFIN = TRIGGER_TYPES.register("equip_coffin",() -> new TGAdvancementTrigger(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "equip_coffin")));
}
