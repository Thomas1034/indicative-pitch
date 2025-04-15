package com.startraveler.indicativepitch.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MultiPlayerGameMode.class)
public abstract class MultiPlayerGameModeMixin {

    @Accessor("destroyProgress")
    public abstract float getDestroyProgress();

    @ModifyExpressionValue(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F"), method = "continueDestroyBlock")
    private float modifyPitch(float original) {
        float returnValue = (this.getDestroyProgress() * 2.5f * original);
        // System.out.println("Returning " + returnValue);
        return returnValue;
    }
}