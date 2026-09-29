package net.saik.fftuntoldstory.mixin;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;

import net.saik.fftuntoldstory.client.CustomUseItem;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.world.phys.Vec2;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixinMixin {

    private static final float FFT_USE_SPEED_MULTIPLIER = 0.70F;

    @Redirect(
            method = "modifyInput",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/player/LocalPlayer;isUsingItem()Z"
            )
    )
    private boolean fft$ignoreUseSlowdown(LocalPlayer player) {

        if (!player.isUsingItem()) {
            return false;
        }

        ItemStack stack = player.getUseItem();

        if (CustomUseItem.shouldIgnoreUseSlowdown(stack)) {
            return false;
        }

        return true;
    }

    @Redirect(
            method = "modifyInput",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/phys/Vec2;scale(F)Lnet/minecraft/world/phys/Vec2;"
            )
    )
    private Vec2 fft$customUseSpeed(Vec2 movement, float vanillaMultiplier) {

        LocalPlayer player = (LocalPlayer) (Object) this;

        if (!player.isUsingItem()) {
            return movement.scale(vanillaMultiplier);
        }

        ItemStack stack = player.getUseItem();

        if (CustomUseItem.shouldIgnoreUseSlowdown(stack)) {
            return movement.scale(FFT_USE_SPEED_MULTIPLIER);
        }

        return movement.scale(vanillaMultiplier);
    }
}
