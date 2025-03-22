package com.finallion.graveyard.mixin;

import com.finallion.graveyard.blockentities.GravestoneBlockEntity2;
import com.finallion.graveyard.client.gui.Gravestone2Screen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {

    @Inject(method = "openTextEdit", at = @At(value = "HEAD"), cancellable = true)
    public void openTextEdit(SignBlockEntity signEntity, boolean isFrontText, CallbackInfo info) {
        if (signEntity instanceof GravestoneBlockEntity2 gravestoneBlockEntity) {
            Minecraft.getInstance().setScreen(new Gravestone2Screen(gravestoneBlockEntity, isFrontText, Minecraft.getInstance().isTextFilteringEnabled()));
            info.cancel();
        }
    }
}
