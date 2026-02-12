package com.finallion.graveyard.events;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.entities.horde.GraveyardHordeSpawner;
import com.finallion.graveyard.init.TGAdvancements;
import com.finallion.graveyard.util.TGFileWriterReader;
import com.finallion.graveyard.util.TGTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@EventBusSubscriber(modid = TheGraveyard.MOD_ID)
public class TGServerEvents {
    private static Map<ResourceLocation, GraveyardHordeSpawner> spawners = new HashMap<>();


    private static boolean isPlayerInGraveyardStructure(ServerLevel level, BlockPos pos) {
        Registry<Structure> registry = level.registryAccess().registryOrThrow(Registries.STRUCTURE);
        Optional<HolderSet.Named<Structure>> tag = registry.getTag(TGTags.GRAVEYARD_STRUCTURES);
        if (tag.isEmpty()) return false;

        StructureManager structureManager = level.structureManager();
        for (Holder<Structure> holder : tag.get()) {
            StructureStart start = structureManager.getStructureAt(pos, holder.value());
            if (start != null && start.isValid()) {
                for (StructurePiece piece : start.getPieces()) {
                    if (piece.getBoundingBox().isInside(pos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void onServerStart(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        spawners.put(Level.OVERWORLD.location(), new GraveyardHordeSpawner(server));
    }

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        MinecraftServer server = event.getLevel().getServer();

        if (server != null) {
            new TGFileWriterReader.Load().onWorldLoad(server);
        }
    }

    @SubscribeEvent
    public static void onWorldUnload(LevelEvent.Unload event) {
        MinecraftServer server = event.getLevel().getServer();

        if (server != null) {
            new TGFileWriterReader.Unload().onWorldUnload(server);
        }
    }

    @SubscribeEvent
    public static void onServerStopped(ServerStoppedEvent event) {
        spawners.clear();
    }

    @SubscribeEvent
    public static void afterServerTickEvent(ServerTickEvent.Post event) {
        for (ServerLevel level : event.getServer().getAllLevels()) {
            GraveyardHordeSpawner spawner = spawners.get(level.dimension().location());
            if (spawner != null) {
                spawner.tick(level);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerWakeUp(PlayerWakeUpEvent event) {
        
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            if (event.wakeImmediately()) return;

            ServerLevel level = serverPlayer.serverLevel();
            BlockPos pos = serverPlayer.blockPosition();

            if (isPlayerInGraveyardStructure(level, pos)) {
                TGAdvancements.VISIT_AT_NIGHT.get().trigger(serverPlayer);
            }
        }
    }
}