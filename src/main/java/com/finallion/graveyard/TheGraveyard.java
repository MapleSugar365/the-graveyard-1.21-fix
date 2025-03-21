package com.finallion.graveyard;

import com.finallion.graveyard.config.GraveyardConfig;
import com.finallion.graveyard.init.*;
import com.finallion.graveyard.item.VialOfBlood;
import com.finallion.graveyard.recipe.TGRecipeTypes;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;


@Mod("graveyard")
public class TheGraveyard {
    public static final String MOD_ID = "graveyard";

    public TheGraveyard(IEventBus modEventBus, ModContainer modContainer) {
        TGProcessors.PROCESSORS.register(modEventBus);
        TGAdvancements.TRIGGER_TYPES.register(modEventBus);
        TGCreativeModeTabs.CREATIVE_MODE_TAB.register(modEventBus);
        TGBlocks.BLOCKS.register(modEventBus);
        TGItems.ITEMS.register(modEventBus);
        TGSounds.SOUNDS.register(modEventBus);
        TGEntities.ENTITIES.register(modEventBus);
        TGConfiguredStructureFeatures.STRUCTURES.register(modEventBus);
        TGScreens.MENUS.register(modEventBus);
        TGRecipeTypes.RECIPE_TYPES.register(modEventBus);
        TGRecipeTypes.RECIPE_SERIALIZERS.register(modEventBus);
        TGBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        TGParticles.PARTICLES.register(modEventBus);
        TGBiomeModifiers.BIOME_MODIFIERS.register(modEventBus);

        modEventBus.addListener(this::setupClient);

        modContainer.registerConfig(ModConfig.Type.COMMON, GraveyardConfig.COMMON_SPEC, MOD_ID + "-1.19.x-common.toml");
    }

    public void setupClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            /* CHANGING ITEM TEXTURE */
            ItemProperties.register(TGItems.VIAL_OF_BLOOD.get(), ResourceLocation.withDefaultNamespace("charged"), (stack, world, entity, seed) -> {
                if (entity != null && stack.is(TGItems.VIAL_OF_BLOOD.get())) {
                    return VialOfBlood.getBlood(stack);
                }
                return 0.0F;
            });

        });
    }
}
