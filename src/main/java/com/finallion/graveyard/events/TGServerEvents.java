package com.finallion.graveyard.events;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.entities.horde.GraveyardHordeSpawner;
import com.finallion.graveyard.util.TGFileWriterReader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(modid = TheGraveyard.MOD_ID)
public class TGServerEvents {
    private static Map<ResourceLocation, GraveyardHordeSpawner> spawners = new HashMap<>();


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
}
