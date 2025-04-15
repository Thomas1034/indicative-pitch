package com.startraveler.indicativepitch.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.LevelEventHandler;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LevelEventHandler.class)
public class LevelEventHandlerMixin {

    @ModifyExpressionValue(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F"), method = "levelEvent")
    private float modifyPitch(float original, @Local BlockState blockState) {
        float returnValue = blockState.getBlock().defaultDestroyTime() == 0 ? original : 1.5f * original;
        // System.out.println("Returning " + returnValue);
        return returnValue;
    }

}
