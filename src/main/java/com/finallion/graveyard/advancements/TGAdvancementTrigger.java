package com.finallion.graveyard.advancements;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;


public class TGAdvancementTrigger extends SimpleCriterionTrigger<TGAdvancementTrigger.TGTriggerInstance> {
    public final ResourceLocation identifier;

    public TGAdvancementTrigger(ResourceLocation identifier) {
        this.identifier = identifier;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, (triggerInstance) -> true);
    }

    @Override
    public @NotNull Codec<TGTriggerInstance> codec() {
        return TGTriggerInstance.CODEC;
    }

    @Override
    public @NotNull Criterion<TGTriggerInstance> createCriterion(@NotNull TGTriggerInstance triggerInstance) {
        return super.createCriterion(triggerInstance);
    }

    public record TGTriggerInstance(
            Optional<ContextAwarePredicate> player,
            ResourceLocation location
    ) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<TGTriggerInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TGTriggerInstance::player),
                ResourceLocation.CODEC.fieldOf("location").forGetter(TGTriggerInstance::location)
        ).apply(instance, TGTriggerInstance::new));
    }
}
