package com.finallion.graveyard.client.gui;

import com.finallion.graveyard.blockentities.GravestoneBlockEntity2;
import com.finallion.graveyard.blocks.GravestoneBlock2;
import com.finallion.graveyard.world.level.block.state.GravestoneType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector3f;

@OnlyIn(Dist.CLIENT)
public class Gravestone2Screen extends AbstractSignEditScreen {
    public static final float MAGIC_BACKGROUND_SCALE = 4.5F;
    private static final Vector3f TEXT_SCALE = new Vector3f(1.0F, 1.0F, 1.0F);
    private static final int TEXTURE_WIDTH = 64;
    private static final int TEXTURE_HEIGHT = 32;

    protected final GravestoneType gravestoneType;
    private final ResourceLocation texture;

    public Gravestone2Screen(GravestoneBlockEntity2 sign, boolean isFrontText, boolean isFiltered) {
        super(sign, isFrontText, isFiltered, Component.translatable("gravestone.edit"));
        this.gravestoneType = GravestoneBlock2.getGravestoneTypeFor(sign.getBlockState().getBlock());
        this.texture = gravestoneType.texture();
    }

    @Override
    protected void offsetSign(GuiGraphics guiGraphics, BlockState state) {
        guiGraphics.pose().translate((float) this.width / 2.0F, 125.0F, 50.0F);
    }

    @Override
    protected void renderSignBackground(GuiGraphics guiGraphics, BlockState state) {
        guiGraphics.pose().translate(0.0F, -2.0F, 0.0F);
        guiGraphics.pose().scale(MAGIC_BACKGROUND_SCALE, MAGIC_BACKGROUND_SCALE, 1.0F);
        guiGraphics.blit(this.texture, -12, -6, 1, 2, 24, 12, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }

    @Override
    protected Vector3f getSignTextScale() {
        return TEXT_SCALE;
    }
}
