package com.finallion.graveyard.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;


@OnlyIn(Dist.CLIENT)
public class ClientModelManager {
    private static final Map<ResourceLocation, BakedModel> MODEL_CACHE = new HashMap<>();

    public static BakedModel getModel(ResourceLocation modelLocation) {
        if (Minecraft.getInstance() != null && Minecraft.getInstance().getModelManager() != null) {
            return Minecraft.getInstance().getModelManager().getModel(ModelResourceLocation.standalone(modelLocation));
        }
        return null;
    }

    public static BakedModel getCachedModel(ResourceLocation modelLocation) {
        return MODEL_CACHE.computeIfAbsent(modelLocation, ClientModelManager::getModel);
    }

    public static void clearCache() {
        MODEL_CACHE.clear();
    }
}