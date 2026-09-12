package net.saik.fftuntoldstory.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import org.checkerframework.checker.units.qual.h;
import org.checkerframework.checker.units.qual.g;

import net.saik.fftuntoldstory.FftUntoldStoryModPlayerAnimationAPI;

import net.minecraft.world.level.LevelReader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.PoseStack;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRenderDispatcherMixin {
	private static Minecraft mc = Minecraft.getInstance();

	@Inject(method = "renderShadow", at = @At("HEAD"), cancellable = true)
	private static void renderShadow(PoseStack poseStack, MultiBufferSource multiBufferSource, EntityRenderState entityRenderState, float g, LevelReader levelReader, float h, CallbackInfo ci) {
		if (entityRenderState instanceof PlayerRenderState state) {
			Player player = (Player) state.getRenderData(FftUntoldStoryModPlayerAnimationAPI.ClientAttachments.PLAYER);
			if (player.getPersistentData().getBooleanOr("FirstPersonAnimation", false) && mc.options.getCameraType().isFirstPerson() && player == mc.player && mc.screen == null) {
				ci.cancel();
			}
		}
	}
}