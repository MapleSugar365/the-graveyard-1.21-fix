package com.finallion.graveyard.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class CommonConfig {
    public final ModConfigSpec.BooleanValue canGenerateHauntedHouse;
    public final ModConfigSpec.BooleanValue canGenerateMediumGraveyard;
    public final ModConfigSpec.BooleanValue canGenerateLargeGraveyard;
    public final ModConfigSpec.BooleanValue canGenerateSmallGrave;
    public final ModConfigSpec.BooleanValue canGenerateSmallDesertGrave;
    public final ModConfigSpec.BooleanValue canGenerateSmallSavannaGrave;
    public final ModConfigSpec.BooleanValue canGenerateSmallMountainGrave;
    public final ModConfigSpec.BooleanValue canGenerateSmallGraveyard;
    public final ModConfigSpec.BooleanValue canGenerateSmallDesertGraveyard;
    public final ModConfigSpec.BooleanValue canGenerateMushroomGrave;
    public final ModConfigSpec.BooleanValue canGenerateMemorialTree;
    public final ModConfigSpec.BooleanValue canGenerateAltar;
    public final ModConfigSpec.BooleanValue canGenerateCrypt;
    public final ModConfigSpec.BooleanValue canGenerateGiantMushroom;
    public final ModConfigSpec.BooleanValue canGenerateLichPrison;
    public final ModConfigSpec.BooleanValue canGenerateRuins;
    public final ModConfigSpec.BooleanValue canGenerateDeadTree;

    public final ModConfigSpec.BooleanValue enableGhoul;
    public final ModConfigSpec.IntValue weightGhoul;
    public final ModConfigSpec.IntValue minGroupSizeGhoul;
    public final ModConfigSpec.IntValue maxGroupSizeGhoul;
    public final ModConfigSpec.BooleanValue ghoulCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue ghoulCanBeWithered;

    public final ModConfigSpec.BooleanValue enableRevenant;
    public final ModConfigSpec.IntValue weightRevenant;
    public final ModConfigSpec.IntValue minGroupSizeRevenant;
    public final ModConfigSpec.IntValue maxGroupSizeRevenant;
    public final ModConfigSpec.BooleanValue revenantCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue revenantCanBeWithered;

    public final ModConfigSpec.BooleanValue enableReaper;
    public final ModConfigSpec.IntValue weightReaper;
    public final ModConfigSpec.IntValue minGroupSizeReaper;
    public final ModConfigSpec.IntValue maxGroupSizeReaper;
    public final ModConfigSpec.BooleanValue reaperCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue reaperCanBeWithered;

    public final ModConfigSpec.BooleanValue enableNightmare;
    public final ModConfigSpec.IntValue weightNightmare;
    public final ModConfigSpec.IntValue minGroupSizeNightmare;
    public final ModConfigSpec.IntValue maxGroupSizeNightmare;
    public final ModConfigSpec.BooleanValue nightmareCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue nightmareCanBeWithered;

    public final ModConfigSpec.BooleanValue enableSkeletonCreeper;
    public final ModConfigSpec.IntValue weightSkeletonCreeper;
    public final ModConfigSpec.IntValue minGroupSizeSkeletonCreeper;
    public final ModConfigSpec.IntValue maxGroupSizeSkeletonCreeper;
    public final ModConfigSpec.BooleanValue skeletonCreeperCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue skeletonCreeperCanBeWithered;

    public final ModConfigSpec.BooleanValue enableAcolyte;
    public final ModConfigSpec.BooleanValue acolyteCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue acolyteCanBeWithered;

    public final ModConfigSpec.BooleanValue enableWraith;
    public final ModConfigSpec.BooleanValue wraithCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue wraithCanBeWithered;

    public final ModConfigSpec.BooleanValue enableCorruptedPillager;
    public final ModConfigSpec.BooleanValue corruptedPillagerCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue corruptedPillagerCanBeWithered;

    public final ModConfigSpec.BooleanValue enableCorruptedVindicator;
    public final ModConfigSpec.BooleanValue corruptedVindicatorCanBurnInSunlight;
    public final ModConfigSpec.BooleanValue corruptedVindicatorCanBeWithered;

    public final ModConfigSpec.BooleanValue enableHorde;
    public final ModConfigSpec.IntValue mobSpawnAttempts;
    public final ModConfigSpec.IntValue ticksUntilSpawnHorde;
    public final ModConfigSpec.IntValue additionalRandomizedTicks;

    public final ModConfigSpec.BooleanValue enableMossParticle;
    public final ModConfigSpec.IntValue particleFrequency;

    public final ModConfigSpec.BooleanValue disableWitherSkeletonSpawner;
    public final ModConfigSpec.BooleanValue enableBossMusic;

    public final ModConfigSpec.DoubleValue healthInCastingPhase;
    public final ModConfigSpec.DoubleValue healthInHuntingPhase;
    public final ModConfigSpec.DoubleValue damageCastingPhase;
    public final ModConfigSpec.DoubleValue damageHuntingPhaseAddition;
    public final ModConfigSpec.DoubleValue armor;
    public final ModConfigSpec.DoubleValue armorToughness;
    public final ModConfigSpec.DoubleValue speedInHuntPhase;
    public final ModConfigSpec.IntValue durationHuntingPhase;
    public final ModConfigSpec.IntValue durationFallingCorpseSpell;
    public final ModConfigSpec.IntValue durationHealingSpell;
    public final ModConfigSpec.IntValue durationLevitationSpell;
    public final ModConfigSpec.IntValue maxAmountSkullsInShootSkullSpell;
    public final ModConfigSpec.IntValue maxSummonedMobs;
    public final ModConfigSpec.IntValue maxGroupSizeSummonedMobs;
    public final ModConfigSpec.IntValue ghoulSpawnTimerInFight;
    public final ModConfigSpec.ConfigValue<List<? extends String>> isBloodCollectableEntity;
    public final ModConfigSpec.ConfigValue<List<? extends String>> isBossSummonableItem;
    public final ModConfigSpec.BooleanValue summoningNeedsStaffFragments;
    public final ModConfigSpec.BooleanValue isMultiphaseFight;
    public final ModConfigSpec.BooleanValue isInvulnerableDuringSpells;
    public final ModConfigSpec.IntValue cooldownCorpseSpell;
    public final ModConfigSpec.IntValue cooldownTeleportPlayerAndHeal;
    public final ModConfigSpec.IntValue cooldownLevitationSpell;
    public final ModConfigSpec.IntValue playerTeleportYOffset;


    public CommonConfig(ModConfigSpec.Builder builder) {
        builder.comment(" Welcome to The Graveyard Config!" +
                "Welcome to The Graveyard Config! \n " +
                "\n" +
                "Structures: \n " +
                "Enable or disable structure spawns. \n " +
                "\n" +
                "Mobs: \n" +
                "Configure spawning weight and group size of the spawn (ghoul, revenant, reaper, nightmare, skeleton creeper). \n " +
                "Configure if mobs burn in sunlight and/or if mobs are affected by the wither effect. \n " +
                "\n" +
                "Additional: \n" +
                "Configure graveyard fog particles rising from moss and set the chance of spawning them (higher numbers = lower chance of spawning). \n " +
                "Configure if hordes of graveyard mobs can spawn and set their size and frequency. \n " +
                "Configure if urns have a double chest inventory. \n " +
                "Configure if the wither skeleton spawner in the large graveyard will be replaced by a skeleton spawner. \n ",
                "Configure if boss music plays during the fight against the Corrupted Champion. \n ",
                "\n",
                "Music: \n",
                "Incarnated Evil by Rotch Gwylt (Official The Graveyard Soundtrack). \n "
        );

        builder.push("The Graveyard - Structures Config");

        this.canGenerateHauntedHouse = builder.define("hauntedHouse.generate", true);
        this.canGenerateLargeGraveyard = builder.define("largeGraveyard.generate", true);
        this.canGenerateMediumGraveyard = builder.define("mediumGraveyard.generate", true);
        this.canGenerateMemorialTree = builder.define("memorialTree.generate", true);
        this.canGenerateMushroomGrave = builder.define("mushroomGrave.generate", true);
        this.canGenerateSmallDesertGrave = builder.define("smallDesertGrave.generate", true);
        this.canGenerateSmallDesertGraveyard = builder.define("smallDesertGraveyard.generate", true);
        this.canGenerateSmallGrave = builder.define("smallGrave.generate", true);
        this.canGenerateSmallSavannaGrave = builder.define("smallSavannaGrave.generate", true);
        this.canGenerateSmallGraveyard = builder.define("smallGraveyard.generate", true);
        this.canGenerateSmallMountainGrave = builder.define("smallMountainGraveyard.generate", true);
        this.canGenerateCrypt = builder.define("crypt.generate", true);
        this.canGenerateAltar = builder.define("altar.generate", true);
        this.canGenerateGiantMushroom = builder.define("giantMushroom.generate", true);
        this.canGenerateLichPrison = builder.define("lichPrison.generate", true);
        this.canGenerateRuins = builder.define("ruins.generate", true);
        this.canGenerateDeadTree = builder.define("deadTree.generate", true);

        builder.pop();


        builder.push("The Graveyard - Mob Spawning Config");
        this.enableGhoul = builder.define("ghoul.enabled", true);
        this.weightGhoul = builder.defineInRange("ghoul.weight", 25, 0, 100);
        this.minGroupSizeGhoul = builder.defineInRange("ghoul.minGroupSizeGhoul", 2, 1, 100);
        this.maxGroupSizeGhoul = builder.defineInRange("ghoul.maxGroupSizeGhoul", 5, 1, 100);
        this.ghoulCanBurnInSunlight = builder.define("ghoul.canBurnInSunlight", true);
        this.ghoulCanBeWithered = builder.define("ghoul.canBeWithered", true);

        this.enableRevenant = builder.define("revenant.enabled", true);
        this.weightRevenant = builder.defineInRange("revenant.weight", 25, 0, 100);
        this.minGroupSizeRevenant = builder.defineInRange("revenant.minGroupSizeRevenant", 5, 1, 100);
        this.maxGroupSizeRevenant = builder.defineInRange("revenant.maxGroupSizeRevenant", 8, 1, 100);
        this.revenantCanBurnInSunlight = builder.define("revenant.canBurnInSunlight", true);
        this.revenantCanBeWithered = builder.define("revenant.canBeWithered", true);

        this.enableReaper = builder.define("reaper.enabled", true);
        this.weightReaper = builder.defineInRange("reaper.weight", 10, 0, 100);
        this.minGroupSizeReaper = builder.defineInRange("reaper.minGroupSizeReaper", 2, 1, 100);
        this.maxGroupSizeReaper = builder.defineInRange("reaper.maxGroupSizeGhoul", 3, 1, 100);
        this.reaperCanBurnInSunlight = builder.define("reaper.canBurnInSunlight", true);
        this.reaperCanBeWithered = builder.define("reaper.canBeWithered", true);

        this.enableNightmare = builder.define("nightmare.enabled", true);
        this.weightNightmare = builder.defineInRange("nightmare.weight", 10, 0, 100);
        this.minGroupSizeNightmare = builder.defineInRange("nightmare.minGroupSizeNightmare", 1, 1, 100);
        this.maxGroupSizeNightmare = builder.defineInRange("nightmare.maxGroupSizeNightmare", 1, 1, 100);
        this.nightmareCanBurnInSunlight = builder.define("nightmare.canBurnInSunlight", false);
        this.nightmareCanBeWithered = builder.define("nightmare.canBeWithered", false);

        this.enableSkeletonCreeper = builder.define("skeleton_creeper.enabled", true);
        this.weightSkeletonCreeper = builder.defineInRange("skeleton_creeper.weight", 25, 0, 100);
        this.minGroupSizeSkeletonCreeper = builder.defineInRange("skeleton_creeper.minGroupSizeSkeletonCreeper", 1, 1, 100);
        this.maxGroupSizeSkeletonCreeper = builder.defineInRange("skeleton_creeper.maxGroupSizeSkeletonCreeper", 4, 1, 100);
        this.skeletonCreeperCanBurnInSunlight = builder.define("skeleton_creeper.canBurnInSunlight", true);
        this.skeletonCreeperCanBeWithered = builder.define("skeleton_creeper.canBeWithered", true);

        this.enableAcolyte = builder.define("acolyte.enabled", false);
        this.acolyteCanBurnInSunlight = builder.define("acolyte.canBurnInSunlight", false);
        this.acolyteCanBeWithered = builder.define("acolyte.canBeWithered", true);

        this.enableWraith = builder.define("wraith.enabled", false);
        this.wraithCanBurnInSunlight = builder.define("wraith.canBurnInSunlight", true);
        this.wraithCanBeWithered = builder.define("wraith.canBeWithered", false);

        this.enableCorruptedPillager = builder.define("corruptedPillager.enabled", false);
        this.corruptedPillagerCanBurnInSunlight = builder.define("corruptedPillager.canBurnInSunlight", true);
        this.corruptedPillagerCanBeWithered = builder.define("corruptedPillager.canBeWithered", true);

        this.enableCorruptedVindicator = builder.define("corruptedVindicator.enabled", false);
        this.corruptedVindicatorCanBurnInSunlight = builder.define("corruptedVindicator.canBurnInSunlight", true);
        this.corruptedVindicatorCanBeWithered = builder.define("corruptedVindicator.canBeWithered", true);

        builder.pop();

        builder.push("The Graveyard - Corrupted Champion Config");
        this.healthInCastingPhase = builder.defineInRange("corruptedChampion.healthInCastingPhase", 400.0D, 1.0D, 1024.0D);
        this.healthInHuntingPhase = builder.defineInRange("corruptedChampion.healthInHuntingPhase", 200.0D, 1.0D, 1024.0D);
        this.damageCastingPhase = builder.defineInRange("corruptedChampion.damageCastingPhase", 30.0D, 1.0D, 2048.0D);
        this.damageHuntingPhaseAddition = builder.defineInRange("corruptedChampion.damageHuntingPhaseAddition", 40.0D, 1.0D, 2048.0D);
        this.armor = builder.defineInRange("corruptedChampion.armor", 18.0D, 0, 30.0D);
        this.armorToughness = builder.defineInRange("corruptedChampion.armorToughness", 14.0D, 0, 20.0D);
        this.speedInHuntPhase = builder.defineInRange("corruptedChampion.speedInHuntPhase", 0.15D, 0, 1024.0D);
        this.durationHuntingPhase = builder.defineInRange("corruptedChampion.durationHuntingPhase", 800, 0, 100000);
        this.durationFallingCorpseSpell = builder.defineInRange("corruptedChampion.durationFallingCorpseSpell", 400, 0, 100000);
        this.durationHealingSpell = builder.defineInRange("corruptedChampion.durationHealingSpell", 700, 0, 100000);
        this.durationLevitationSpell = builder.defineInRange("corruptedChampion.durationLevitationSpell", 150, 0, 100000);
        this.maxAmountSkullsInShootSkullSpell = builder.defineInRange("corruptedChampion.maxAmountSkullsInShootSkullSpell", 5, 1, 100);
        this.maxSummonedMobs = builder.defineInRange("corruptedChampion.maxSummonedMobs", 30, 0, 100);
        this.maxGroupSizeSummonedMobs = builder.defineInRange("corruptedChampion.maxGroupSizeSummonedMobs", 5, 1, 100);
        this.ghoulSpawnTimerInFight = builder.defineInRange("corruptedChampion.ghoulSpawnTimerInFight", 6000, 0, 100000);
        this.isBloodCollectableEntity = builder.defineList("corruptedChampion.isBloodCollectableEntity", List.of("entity.minecraft.villager"), o -> o instanceof String);
        this.isBossSummonableItem = builder.defineList("corruptedChampion.isBossSummonableItem", List.of("item.minecraft.debug_stick"), o -> o instanceof String);
        this.summoningNeedsStaffFragments = builder.define("corruptedChampion.summoningNeedsStaffFragments", true);
        this.isMultiphaseFight = builder.define("corruptedChampion.isMultiphaseFight", true);
        this.isInvulnerableDuringSpells = builder.define("corruptedChampion.isInvulnerableDuringSpells", true);
        this.cooldownCorpseSpell = builder.defineInRange("corruptedChampion.cooldownCorpseSpell", 400, 1, 100000);
        this.cooldownTeleportPlayerAndHeal = builder.defineInRange("corruptedChampion.cooldownTeleportPlayerAndHeal", 600, 1, 100000);
        this.cooldownLevitationSpell = builder.defineInRange("corruptedChampion.cooldownLevitationSpell", 400, 1, 100000);
        this.playerTeleportYOffset = builder.defineInRange("corruptedChampion.playerTeleportYOffset", -15, -64, 100000);
        builder.pop();

        builder.push("The Graveyard - Horde Config");
        this.enableHorde = builder.define("horde.generate", true);
        this.mobSpawnAttempts = builder.defineInRange("horde.mobSpawnAttempts", 40, 0, 1000);
        this.ticksUntilSpawnHorde = builder.defineInRange("horde.ticksUntilSpawnHorde", 24000, 1, 1000000);
        this.additionalRandomizedTicks = builder.defineInRange("horde.additionalRandomizedTicks", 1200, 1, 1000000);
        builder.pop();

        builder.push("The Graveyard - Particle Config");
        this.enableMossParticle = builder.define("particle.generate", true);
        this.particleFrequency = builder.defineInRange("particle.frequency", 50, 1, 500);
        builder.pop();

        builder.push("The Graveyard - Additional Config");
        this.enableBossMusic = builder.define("bossMusic.enableBossMusic", true);
        this.disableWitherSkeletonSpawner = builder.define("spawner.disableWitherSkeletonSpawner", false);
        builder.pop();
    }
}
