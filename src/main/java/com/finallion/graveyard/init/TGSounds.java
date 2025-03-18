package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TGSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TheGraveyard.MOD_ID);

    public static final Supplier<SoundEvent> LICH_SPAWN = registerSoundEvent("entity.lich.spawn");
    public static final Supplier<SoundEvent> LICH_MELEE = registerSoundEvent("entity.lich.melee");
    public static final Supplier<SoundEvent> LICH_PHASE_02 = registerSoundEvent("entity.lich.phase_two");
    public static final Supplier<SoundEvent> LICH_PHASE_03 = registerSoundEvent("entity.lich.phase_three");
    public static final Supplier<SoundEvent> LICH_CORPSE_SPELL = registerSoundEvent("entity.lich.corpse_spell");
    public static final Supplier<SoundEvent> LICH_CAST_SKULL = registerSoundEvent("entity.lich.shoot_skull");
    public static final Supplier<SoundEvent> LICH_CAST_LEVITATION = registerSoundEvent("entity.lich.levitation");
    public static final Supplier<SoundEvent> LICH_CAST_TELEPORT = registerSoundEvent("entity.lich.heal");
    public static final Supplier<SoundEvent> LICH_DEATH = registerSoundEvent("entity.lich.death");
    public static final Supplier<SoundEvent> LICH_HUNT = registerSoundEvent("entity.lich.hunt");
    public static final Supplier<SoundEvent> LICH_SCARE = registerSoundEvent("entity.lich.scare");
    public static final Supplier<SoundEvent> LICH_PHASE_03_ATTACK = registerSoundEvent("entity.lich.phase_three_attack");
    public static final Supplier<SoundEvent> LICH_IDLE = registerSoundEvent("entity.lich.idle");
    public static final Supplier<SoundEvent> LICH_HURT = registerSoundEvent("entity.lich.hurt");

    public static final Supplier<SoundEvent> NAMELESS_HANGED_BREATH = registerSoundEvent("entity.nameless_hanged.breath");
    public static final Supplier<SoundEvent> NAMELESS_HANGED_AMBIENT = registerSoundEvent("entity.nameless_hanged.ambient");
    public static final Supplier<SoundEvent> NAMELESS_HANGED_INTERACT = registerSoundEvent("entity.nameless_hanged.interact");

    public static final Supplier<SoundEvent> CORRUPTED_ILLAGER_AMBIENT = registerSoundEvent("entity.corrupted_illager.ambient");
    public static final Supplier<SoundEvent> CORRUPTED_ILLAGER_HURT = registerSoundEvent("entity.corrupted_illager.hurt");
    public static final Supplier<SoundEvent> CORRUPTED_ILLAGER_DEATH = registerSoundEvent("entity.corrupted_illager.death");
    public static final Supplier<SoundEvent> CORRUPTED_ILLAGER_STEP = registerSoundEvent("entity.corrupted_illager.step");

    public static final Supplier<SoundEvent> ACOLYTE_AMBIENT = registerSoundEvent("entity.acolyte.ambient");
    public static final Supplier<SoundEvent> ACOLYTE_HURT = registerSoundEvent("entity.acolyte.hurt");
    public static final Supplier<SoundEvent> ACOLYTE_DEATH = registerSoundEvent("entity.acolyte.death");

    public static final Supplier<SoundEvent> REAPER_AMBIENT = registerSoundEvent("entity.reaper.ambient");
    public static final Supplier<SoundEvent> REAPER_HURT = registerSoundEvent("entity.reaper.hurt");
    public static final Supplier<SoundEvent> REAPER_DEATH = registerSoundEvent("entity.reaper.death");
    public static final Supplier<SoundEvent> REAPER_CHARGE = registerSoundEvent("entity.reaper.charge");

    public static final Supplier<SoundEvent> GHOUL_ROAR = registerSoundEvent("entity.ghoul.roar");
    public static final Supplier<SoundEvent> GHOUL_AMBIENT = registerSoundEvent("entity.ghoul.ambient");
    public static final Supplier<SoundEvent> GHOUL_HURT = registerSoundEvent("entity.ghoul.hurt");
    public static final Supplier<SoundEvent> GHOUL_DEATH = registerSoundEvent("entity.ghoul.death");
    public static final Supplier<SoundEvent> GHOUL_STEP = registerSoundEvent("entity.ghoul.step");

    public static final Supplier<SoundEvent> GHOULING_GROAN = registerSoundEvent("entity.ghouling.groan");
    public static final Supplier<SoundEvent> GHOULING_AMBIENT = registerSoundEvent("entity.ghouling.ambient");
    public static final Supplier<SoundEvent> GHOULING_HURT = registerSoundEvent("entity.ghouling.hurt");
    public static final Supplier<SoundEvent> GHOULING_DEATH = registerSoundEvent("entity.ghouling.death");
    public static final Supplier<SoundEvent> GHOULING_ATTACK = registerSoundEvent("entity.ghouling.attack");
    public static final Supplier<SoundEvent> GHOULING_STEP = registerSoundEvent("entity.ghouling.step");
    public static final Supplier<SoundEvent> GHOULING_SPAWN = registerSoundEvent("entity.ghouling.spawn");

    public static final Supplier<SoundEvent> REVENANT_AMBIENT = registerSoundEvent("entity.revenant.ambient");
    public static final Supplier<SoundEvent> REVENANT_HURT = registerSoundEvent("entity.revenant.hurt");
    public static final Supplier<SoundEvent> REVENANT_DEATH = registerSoundEvent("entity.revenant.death");
    public static final Supplier<SoundEvent> REVENANT_STEP = registerSoundEvent("entity.revenant.step");

    public static final Supplier<SoundEvent> NIGHTMARE_AMBIENT = registerSoundEvent("entity.nightmare.ambient");
    public static final Supplier<SoundEvent> NIGHTMARE_HURT = registerSoundEvent("entity.nightmare.hurt");
    public static final Supplier<SoundEvent> NIGHTMARE_DEATH = registerSoundEvent("entity.nightmare.death");

    public static final Supplier<SoundEvent> WRAITH_AMBIENT = registerSoundEvent("entity.wraith.ambient");
    public static final Supplier<SoundEvent> WRAITH_HURT = registerSoundEvent("entity.wraith.hurt");

    public static final Supplier<SoundEvent> ALTAR_AMBIENT = registerSoundEvent("block.altar.ambient");

    public static final Supplier<SoundEvent> COFFIN_OPEN = registerSoundEvent("block.coffin.open");
    public static final Supplier<SoundEvent> COFFIN_CLOSE = registerSoundEvent("block.coffin.close");

    public static final Supplier<SoundEvent> URN_OPEN = registerSoundEvent("block.urn.open");
    public static final Supplier<SoundEvent> URN_CLOSE = registerSoundEvent("block.urn.close");

    public static final Supplier<SoundEvent> OSSUARY_OPEN = registerSoundEvent("block.ossuary.open");

    public static final Supplier<SoundEvent> SARCOPHAGUS_USE = registerSoundEvent("block.sarcophagus.use");

    public static final Supplier<SoundEvent> BONE_PLACED = registerSoundEvent("block.bone.placed");
    public static final Supplier<SoundEvent> BONE_AMBIENT = registerSoundEvent("block.bone.ambient");


    public static final Supplier<SoundEvent> VIAL_SPLASH = registerSoundEvent("item.vial.splash");

    public static final DeferredHolder<SoundEvent, SoundEvent> LICH_THEME_01 = registerSoundEvent("entity.lich.theme_01");
    public static final ResourceKey<JukeboxSong> LICH_THEME_01_KEY = createSong("entity.lich.theme_01");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, name));
    }

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, name);
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
