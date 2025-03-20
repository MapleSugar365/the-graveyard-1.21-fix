package com.finallion.graveyard.advancements;

import com.finallion.graveyard.init.TGAdvancements;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class KillHordeTrigger extends SimpleCriterionTrigger<KillHordeTrigger.TriggerInstance> {

    public void trigger(ServerPlayer player) {
        super.trigger(player, (instance) -> true);
    }

    @Override
    public Codec<TriggerInstance> codec() {
        return TriggerInstance.CODEC;
    }

    @Override
    public Criterion<TriggerInstance> createCriterion(TriggerInstance triggerInstance) {
        return super.createCriterion(triggerInstance);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleInstance {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player)
        ).apply(instance, TriggerInstance::new));

        @Override
        public Optional<ContextAwarePredicate> player() {
            return player;
        }

        public static Criterion<TriggerInstance> instance(ContextAwarePredicate player) {
            return TGAdvancements.KILL_HORDE.get().createCriterion(new TriggerInstance(Optional.of(player)));
        }
    }

}
