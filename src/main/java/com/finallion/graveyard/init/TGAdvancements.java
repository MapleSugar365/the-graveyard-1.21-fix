package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.advancements.DimLightTrigger;
import com.finallion.graveyard.advancements.EquipCoffinTrigger;
import com.finallion.graveyard.advancements.KillHordeTrigger;
import com.finallion.graveyard.advancements.KillWhileBlindedTrigger;
import com.finallion.graveyard.advancements.KilledByBoneDaggerTrigger;
import com.finallion.graveyard.advancements.SpawnWraithTrigger;
import com.finallion.graveyard.advancements.VisitAtNightTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class TGAdvancements {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGER_TYPES = DeferredRegister.create(BuiltInRegistries.TRIGGER_TYPES, TheGraveyard.MOD_ID);

    public static Supplier<KilledByBoneDaggerTrigger> KILLED_BY_BONE_DAGGER = TRIGGER_TYPES.register("killed_by_bone_dagger", KilledByBoneDaggerTrigger::new);
    public static Supplier<KillWhileBlindedTrigger> KILL_WHILE_BLINDED = TRIGGER_TYPES.register("kill_while_blinded", KillWhileBlindedTrigger::new);
    public static Supplier<DimLightTrigger> DIM_LIGHT = TRIGGER_TYPES.register("dim_light", DimLightTrigger::new);
    public static Supplier<KillHordeTrigger> KILL_HORDE = TRIGGER_TYPES.register("kill_horde", KillHordeTrigger::new);
    public static Supplier<SpawnWraithTrigger> SPAWN_WRAITH = TRIGGER_TYPES.register("spawn_wraith", SpawnWraithTrigger::new);
    public static Supplier<EquipCoffinTrigger> EQUIP_COFFIN = TRIGGER_TYPES.register("equip_coffin", EquipCoffinTrigger::new);
    public static Supplier<VisitAtNightTrigger> VISIT_AT_NIGHT = TRIGGER_TYPES.register("visit_at_night", VisitAtNightTrigger::new);
}