package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TGParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, TheGraveyard.MOD_ID);

    public static final Supplier<SimpleParticleType> GRAVEYARD_FOG_PARTICLE = PARTICLES.register("graveyard_fog_particle", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> GRAVEYARD_SOUL_PARTICLE = PARTICLES.register("graveyard_soul_particle", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> GRAVEYARD_HAND_PARTICLE = PARTICLES.register("graveyard_hand_particle", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> GRAVEYARD_LEFT_HAND_PARTICLE = PARTICLES.register("graveyard_left_hand_particle", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> GRAVEYARD_SOUL_BEAM_PARTICLE = PARTICLES.register("graveyard_soul_beam_particle", () -> new SimpleParticleType(true));


}
