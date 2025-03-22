package com.finallion.graveyard.blockentities.render;

import com.finallion.graveyard.blockentities.GravestoneBlockEntity2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;


@OnlyIn(Dist.CLIENT)
public class GravestoneBlockEntity2Renderer implements BlockEntityRenderer<GravestoneBlockEntity2> {
    private static final int BLACK_TEXT_OUTLINE_COLOR = 0xFFF0EBCC;
    private static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);
    private static final float RENDER_SCALE = 0.6666667F;
    private static final Vec3 TEXT_OFFSET = new Vec3(0.0, 0.07, 0.22);
    private final Font font;

    public GravestoneBlockEntity2Renderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
    }

    @Override
    public void render(GravestoneBlockEntity2 blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState blockstate = blockEntity.getBlockState();
        SignBlock signblock = (SignBlock) blockstate.getBlock();
        this.renderSignWithText(blockEntity, poseStack, bufferSource, packedLight, packedOverlay, blockstate, signblock);
    }

    public float getSignTextRenderScale() {
        return RENDER_SCALE;
    }

    void renderSignWithText(GravestoneBlockEntity2 signEntity, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, BlockState state, SignBlock signBlock) {
        poseStack.pushPose();
        this.translateSign(poseStack, -signBlock.getYRotationDegrees(state), state);
        this.renderSign(signEntity, poseStack, buffer, packedLight, packedOverlay);
        this.renderSignText(signEntity.getBlockPos(), signEntity.getFrontText(), poseStack, buffer, packedLight, signEntity.getTextLineHeight(), signEntity.getMaxTextLineWidth(), true);
        this.renderSignText(signEntity.getBlockPos(), signEntity.getBackText(), poseStack, buffer, packedLight, signEntity.getTextLineHeight(), signEntity.getMaxTextLineWidth(), false);
        poseStack.popPose();
    }

    void translateSign(PoseStack poseStack, float yRot, BlockState state) {
        poseStack.translate(0.5F, 0.5f, 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
    }

    void renderSign(GravestoneBlockEntity2 entity, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();

        poseStack.translate(0, -0.07f, 0);
        poseStack.scale(2.28F, 2.15F, 2.28F);
        Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(entity.getBlockState().getBlock().asItem(), 1), ItemDisplayContext.GROUND, packedLight, packedOverlay, poseStack, buffer, entity.getLevel(), 2);

        poseStack.popPose();
    }

    void renderSignText(BlockPos pos, SignText text, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int lineHeight, int maxWidth, boolean isFrontText) {
        poseStack.pushPose();
        this.translateSignText(poseStack, isFrontText, TEXT_OFFSET);
        int i = getDarkColor(text);
        int j = 4 * lineHeight / 2;
        FormattedCharSequence[] aformattedcharsequence = text.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (component) -> {
            List<FormattedCharSequence> list = this.font.split(component, maxWidth);
            return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
        });
        int k;
        boolean flag;
        int l;
        if (text.hasGlowingText()) {
            k = text.getColor().getTextColor();
            flag = isOutlineVisible(pos, k);
            l = 15728880;
        } else {
            k = i;
            flag = false;
            l = packedLight;
        }

        for (int i1 = 0; i1 < 4; ++i1) {
            FormattedCharSequence formattedcharsequence = aformattedcharsequence[i1];
            float f = (float) (-this.font.width(formattedcharsequence) / 2);
            if (flag) {
                this.font.drawInBatch8xOutline(formattedcharsequence, f, (float) (i1 * lineHeight - j), k, i, poseStack.last().pose(), buffer, l);
            } else {
                this.font.drawInBatch(formattedcharsequence, f, (float) (i1 * lineHeight - j), k, false, poseStack.last().pose(), buffer, Font.DisplayMode.POLYGON_OFFSET, 0, l);
            }
        }

        poseStack.popPose();
    }

    private void translateSignText(PoseStack poseStack, boolean isFrontText, Vec3 offset) {
        if (!isFrontText) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        }

        float f = 0.015625F * this.getSignTextRenderScale();
        poseStack.translate(offset.x, offset.y, offset.z);
        poseStack.scale(f, -f, f);
    }

    static boolean isOutlineVisible(BlockPos pos, int textColor) {
        if (textColor == DyeColor.BLACK.getTextColor()) {
            return true;
        } else {
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localplayer = minecraft.player;
            if (localplayer != null && minecraft.options.getCameraType().isFirstPerson() && localplayer.isScoping()) {
                return true;
            } else {
                Entity entity = minecraft.getCameraEntity();
                return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pos)) < (double) OUTLINE_RENDER_DISTANCE;
            }
        }
    }

    public static int getDarkColor(SignText signText) {
        int i = signText.getColor().getTextColor();
        if (i == DyeColor.BLACK.getTextColor() && signText.hasGlowingText()) {
            return BLACK_TEXT_OUTLINE_COLOR;
        } else {
            double amount = 0.4;
            int r = (int) ((double) FastColor.ARGB32.red(i) * amount);
            int g = (int) ((double) FastColor.ARGB32.green(i) * amount);
            int b = (int) ((double) FastColor.ARGB32.blue(i) * amount);
            return FastColor.ARGB32.color(0, r, g, b);
        }
    }
}

