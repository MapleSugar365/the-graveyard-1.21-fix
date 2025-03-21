package com.finallion.graveyard.client;


import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.blockentities.render.BrazierBlockEntityRenderer;
import com.finallion.graveyard.blockentities.render.GravestoneBlockEntityRenderer;
import com.finallion.graveyard.blockentities.render.OssuaryBlockEntityRenderer;
import com.finallion.graveyard.blockentities.render.SarcophagusBlockEntityRenderer;
import com.finallion.graveyard.client.gui.OssuaryScreen;
import com.finallion.graveyard.entities.models.CorruptedIllagerModel;
import com.finallion.graveyard.entities.renders.*;
import com.finallion.graveyard.init.*;
import com.finallion.graveyard.particles.GraveyardFogParticle;
import com.finallion.graveyard.particles.GraveyardHandParticle;
import com.finallion.graveyard.particles.GraveyardSoulParticle;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.particle.SonicBoomParticle;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = TheGraveyard.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheGraveyardClient {
    public static final ModelLayerLocation CORRUPTED_ILLAGER_MODEL_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "corrupted_illager"), "main");
    private static final RenderType CUTOUT_MIPPED = RenderType.cutoutMipped();

    @SubscribeEvent
    private static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(TGScreens.OSSUARY_SCREEN_HANDLER.get(), OssuaryScreen::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CORRUPTED_ILLAGER_MODEL_LAYER, CorruptedIllagerModel::createBodyModel);
    }

    @SubscribeEvent
    public static void clientInit(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(TGBlocks.TG_GRASS_BLOCK.get(), CUTOUT_MIPPED);
    }

    @SubscribeEvent
    public static void initParticles(RegisterParticleProvidersEvent event){
        event.registerSpriteSet(TGParticles.GRAVEYARD_FOG_PARTICLE.get(), GraveyardFogParticle.FogFactory::new);
        event.registerSpriteSet(TGParticles.GRAVEYARD_SOUL_PARTICLE.get(), GraveyardSoulParticle.Provider::new);
        event.registerSpriteSet(TGParticles.GRAVEYARD_HAND_PARTICLE.get(), GraveyardHandParticle.Provider::new);
        event.registerSpriteSet(TGParticles.GRAVEYARD_LEFT_HAND_PARTICLE.get(), GraveyardHandParticle.Provider::new);
        event.registerSpriteSet(TGParticles.GRAVEYARD_SOUL_BEAM_PARTICLE.get(), SonicBoomParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TGEntities.SKELETON_CREEPER.get(), SkeletonCreeperRender::new);
        event.registerEntityRenderer(TGEntities.ACOLYTE.get(), AcolyteRender::new);
        event.registerEntityRenderer(TGEntities.GHOUL.get(), GhoulRenderer::new);
        event.registerEntityRenderer(TGEntities.REAPER.get(), ReaperRenderer::new);
        event.registerEntityRenderer(TGEntities.REVENANT.get(), RevenantRenderer::new);
        event.registerEntityRenderer(TGEntities.NIGHTMARE.get(), NightmareRenderer::new);
        event.registerEntityRenderer(TGEntities.CORRUPTED_PILLAGER.get(), CorruptedPillagerRenderer::new);
        event.registerEntityRenderer(TGEntities.CORRUPTED_VINDICATOR.get(), CorruptedVindicatorRenderer::new);
        event.registerEntityRenderer(TGEntities.WRAITH.get(), WraithRenderer::new);
        event.registerEntityRenderer(TGEntities.LICH.get(), LichRenderer::new);
        event.registerEntityRenderer(TGEntities.FALLING_CORPSE.get(), FallingCorpseRenderer::new);
        event.registerEntityRenderer(TGEntities.SKULL.get(), SkullEntityRenderer::new);
        event.registerEntityRenderer(TGEntities.GHOULING.get(), GhoulingRenderer::new);
        event.registerEntityRenderer(TGEntities.NAMELESS_HANGED.get(), NamelessHangedRenderer::new);


        event.registerBlockEntityRenderer(TGBlockEntities.GRAVESTONE_BLOCK_ENTITY.get(), GravestoneBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(TGBlockEntities.SARCOPHAGUS_BLOCK_ENTITY.get(), SarcophagusBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(TGBlockEntities.BRAZIER_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context in) -> new BrazierBlockEntityRenderer());
        event.registerBlockEntityRenderer(TGBlockEntities.OSSUARY_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context in) -> new OssuaryBlockEntityRenderer());
    }

    @SubscribeEvent
    public static void onBlockColorsInit(RegisterColorHandlersEvent.Block event) {
        final BlockColors blockColors = event.getBlockColors();
        blockColors.register((state, reader, pos, color) -> reader != null && pos != null ? BiomeColors.getAverageGrassColor(reader, pos) : GrassColor.get(0.5D, 1.0D), TGBlocks.TG_GRASS_BLOCK.get());

    }

    @SubscribeEvent
    public static void onItemColorsInit(RegisterColorHandlersEvent.Item event) {
        final BlockColors blockColors = event.getBlockColors();
        final ItemColors itemColors = event.getItemColors();


        itemColors.register((stack, color) -> {
            BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(blockstate, null, null, color);
        }, TGBlocks.TG_GRASS_BLOCK.get());

    }

    @SubscribeEvent
    public static void registerEntityModels(ModelEvent.RegisterAdditional event) {
        event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "item/sarcophagus_base")));
        event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "item/sarcophagus_lid")));

        for (Block block : TGBlocks.getCoffins()) {
            String woodType = block.getDescriptionId().split("\\.")[2];
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "item/" + woodType + "_base")));
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "item/" + woodType + "_lid")));
        }

    }

}
