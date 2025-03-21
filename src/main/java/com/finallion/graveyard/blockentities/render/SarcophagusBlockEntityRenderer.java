package com.finallion.graveyard.blockentities.render;

import com.finallion.graveyard.blockentities.SarcophagusBlockEntity;
import com.finallion.graveyard.blockentities.enums.SarcophagusPart;
import com.finallion.graveyard.blocks.SarcophagusBlock;
import com.finallion.graveyard.init.TGBlockEntities;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class SarcophagusBlockEntityRenderer implements BlockEntityRenderer<SarcophagusBlockEntity> {
    private final ModelBlockRenderer modelBlockRenderer;

    public SarcophagusBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        modelBlockRenderer = ctx.getBlockRenderDispatcher().getModelRenderer();
    }

    @Override
    public void render(SarcophagusBlockEntity entity, float tickDelta, PoseStack matrixStack, MultiBufferSource vertexConsumers, int light, int overlay) {
        if (entity.getLevel() != null && entity.getBlockState().getValue(SarcophagusBlock.PART) == SarcophagusPart.HEAD) {
            renderLid(entity, matrixStack, vertexConsumers, light, overlay, tickDelta);
            renderBase(entity, matrixStack, vertexConsumers, light, overlay);
        }
    }
    // prevents model from clipping to invis when in the corner of the screen TODO: Need to override getRenderBoundingBox in the blockEntity
    @Override
    public boolean shouldRenderOffScreen(SarcophagusBlockEntity blockEntity) {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 45;
    }

    private void renderBase(SarcophagusBlockEntity entity, PoseStack matrixStack, MultiBufferSource vertexConsumer, int light, int overlay) {
        matrixStack.pushPose();

        Direction direction = entity.getBlockState().getValue(HorizontalDirectionalBlock.FACING).getOpposite();
        float f = direction.toYRot();
        matrixStack.mulPose(Axis.YP.rotationDegrees(-f));

        switch (direction) {
            case EAST -> matrixStack.translate(-1.0F, 0F, 1.0F);
            case SOUTH -> matrixStack.translate(0, 0F, 1.0F);
            case NORTH -> matrixStack.translate(-1.0F, 0F, 0F);
        }

        BakedModel model = ((SarcophagusBlock) entity.getBlockState().getBlock()).getBaseModel();
        modelBlockRenderer.renderModel(matrixStack.last(), vertexConsumer.getBuffer(ItemBlockRenderTypes.getRenderType(entity.getBlockState(), true)), entity.getBlockState(), model, 1.0F, 1.0F, 1.0F, light, overlay);

        matrixStack.popPose();
    }

    private void renderLid(SarcophagusBlockEntity entity, PoseStack matrixStack, MultiBufferSource vertexConsumer, int light, int overlay, float tickDelta) {
        matrixStack.pushPose();

        Direction direction = entity.getBlockState().getValue(HorizontalDirectionalBlock.FACING).getOpposite();
        float f = direction.toYRot();
        matrixStack.mulPose(Axis.YP.rotationDegrees(-f));

        switch (direction) {
            case EAST -> matrixStack.translate(-1.0F, 0F, 1.0F);
            case SOUTH -> matrixStack.translate(0, 0F, 1.0F);
            case NORTH -> matrixStack.translate(-1.0F, 0F, 0F);
        }

        DoubleBlockCombiner.NeighborCombineResult<? extends SarcophagusBlockEntity> propertySource = DoubleBlockCombiner.combineWithNeigbour(TGBlockEntities.SARCOPHAGUS_BLOCK_ENTITY.get(), SarcophagusBlock::getBlockType, SarcophagusBlock::getConnectedDirection, HorizontalDirectionalBlock.FACING, entity.getBlockState(), entity.getLevel(), entity.getBlockPos(), (worldx, pos) -> false);
        float g = 1.0F - propertySource.apply(SarcophagusBlock.opennessCombiner(entity)).get(tickDelta);
        g = 1.0F - g * g * g;

        matrixStack.translate(g * 0.3, g * 0.3, 0.0F); // lid offset to the ground and away from body
        matrixStack.mulPose(Axis.ZN.rotationDegrees(g * 45)); // lid rotation

        BakedModel model = ((SarcophagusBlock) entity.getBlockState().getBlock()).getLidModel();
        modelBlockRenderer.renderModel(matrixStack.last(), vertexConsumer.getBuffer(ItemBlockRenderTypes.getRenderType(entity.getBlockState(), true)), entity.getBlockState(), model, 1.0F, 1.0F, 1.0F, light, overlay);

        matrixStack.popPose();
    }
}

