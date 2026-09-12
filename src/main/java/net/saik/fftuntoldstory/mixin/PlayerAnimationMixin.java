package net.saik.fftuntoldstory.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.saik.fftuntoldstory.FftUntoldStoryModPlayerAnimationAPI;
import net.saik.fftuntoldstory.FftUntoldStoryMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.Minecraft;

import java.util.Set;
import java.util.Map;
import java.util.HashSet;

@Mixin(PlayerModel.class)
public abstract class PlayerAnimationMixin {
	private String master = null;
	private Minecraft mc = Minecraft.getInstance();

	@Inject(method = "Lnet/minecraft/client/model/PlayerModel;setupAnim(Lnet/minecraft/client/renderer/entity/state/PlayerRenderState;)V", at = @At(value = "HEAD"))
	public void setupPivot(PlayerRenderState renderState, CallbackInfo ci) {
		if (master == null)
			master = "fft_untold_story";
		if (!master.equals("fft_untold_story"))
			return;
		Player player = (Player) renderState.getRenderData(FftUntoldStoryModPlayerAnimationAPI.ClientAttachments.PLAYER);
		if (player == null)
			return;
		PlayerModel model = (PlayerModel) (Object) this;
		hideModelParts(model, false);
		FftUntoldStoryModPlayerAnimationAPI.PlayerAnimation animation = FftUntoldStoryModPlayerAnimationAPI.active_animations.get(player);
		if (animation == null)
			return;
		if (animation.bones.get("left_arm") != null || animation.bones.get("torso") != null || animation.bones.get("right_arm") != null)
			renderState.attackTime = 0;
		renderState.isCrouching = false;
	}

	@Inject(method = "Lnet/minecraft/client/model/PlayerModel;setupAnim(Lnet/minecraft/client/renderer/entity/state/PlayerRenderState;)V", at = @At(value = "TAIL"))
	public void setupAnim(PlayerRenderState renderState, CallbackInfo ci) {
		if (renderState.ageInTicks <= 0)
			return;
		if (!master.equals("fft_untold_story")) {
			if (!FftUntoldStoryModPlayerAnimationAPI.animations.isEmpty())
				FftUntoldStoryModPlayerAnimationAPI.animations.clear();
			return;
		}
		Player player = (Player) renderState.getRenderData(FftUntoldStoryModPlayerAnimationAPI.ClientAttachments.PLAYER);
		if (player == null)
			return;
		PlayerModel model = (PlayerModel) (Object) this;
		CompoundTag data = player.getPersistentData();
		String playingAnimation = data.getStringOr("PlayerCurrentAnimation", "");
		boolean overrideAnimation = data.getBooleanOr("OverrideCurrentAnimation", false);
		boolean firstPerson = data.getBooleanOr("FirstPersonAnimation", false) && mc.options.getCameraType().isFirstPerson() && player == mc.player && mc.screen == null;
		if (data.getBooleanOr("ResetPlayerAnimation", false)) {
			data.remove("ResetPlayerAnimation");
			data.remove("LastTickTime");
			data.remove("LastAnimationProgress");
			data.remove("PlayedSoundTimes");
			FftUntoldStoryModPlayerAnimationAPI.active_animations.put(player, null);
		}
		if (playingAnimation.isEmpty()) {
			return;
		}
		if (firstPerson) {
			hideModelParts(model, true);
			player.yBodyRotO = player.yHeadRotO;
			player.yBodyRot = player.yHeadRot;
		}
		if (overrideAnimation) {
			firstPerson = data.getBooleanOr("FirstPersonAnimation", false) && mc.options.getCameraType().isFirstPerson() && player == mc.player && mc.screen == null;
			FftUntoldStoryModPlayerAnimationAPI.active_animations.put(player, null);
			data.remove("PlayerAnimationProgress");
			data.remove("LastAnimationProgress");
			data.remove("PlayedSoundTimes");
			data.putBoolean("OverrideCurrentAnimation", false);
		}
		FftUntoldStoryModPlayerAnimationAPI.PlayerAnimation animation = FftUntoldStoryModPlayerAnimationAPI.active_animations.get(player);
		if (animation == null) {
			animation = FftUntoldStoryModPlayerAnimationAPI.animations.get(playingAnimation);
			if (animation == null) {
				FftUntoldStoryMod.LOGGER.info("Attepted to play null animation " + playingAnimation + ", did animations fail to load?");
				return;
			}
			FftUntoldStoryModPlayerAnimationAPI.active_animations.put(player, animation);
		}
		float animationProgress;
		float lastAnimationProgress = data.getFloatOr("LastAnimationProgress", 0);
		ListTag playedSoundsTag = data.getListOrEmpty("PlayedSoundTimes");
		if (!data.contains("PlayerAnimationProgress")) {
			animationProgress = 0f;
			data.putFloat("PlayerAnimationProgress", animationProgress);
			data.putFloat("LastTickTime", renderState.ageInTicks);
		} else {
			animationProgress = data.getFloatOr("PlayerAnimationProgress", 0);
			float lastTickTime = data.getFloatOr("LastTickTime", renderState.ageInTicks);
			float deltaTime = (renderState.ageInTicks - lastTickTime) / 20f; // Convert ticks to seconds
			animationProgress += deltaTime;
			data.putFloat("PlayerAnimationProgress", animationProgress);
			data.putFloat("LastTickTime", renderState.ageInTicks);
			if (animationProgress >= animation.length) {
				if (!animation.hold_on_last_frame && !animation.loop) {
					data.putBoolean("FirstPersonAnimation", false);
					data.putBoolean("ResetPlayerAnimation", true);
					data.remove("PlayerCurrentAnimation");
					data.remove("PlayerAnimationProgress");
					data.remove("LastAnimationProgress");
					data.remove("PlayedSoundTimes");
					FftUntoldStoryModPlayerAnimationAPI.active_animations.put(player, null);
					animationProgress = animation.length;
				} else if (animation.hold_on_last_frame) {
					data.putFloat("PlayerAnimationProgress", animation.length);
				} else if (animation.loop) {
					data.remove("PlayerAnimationProgress");
					data.remove("LastAnimationProgress");
					data.remove("PlayedSoundTimes");
				}
			}
		}
		if (!animation.soundEffects.isEmpty()) {
			Set<Float> playedSoundTimes = new HashSet<>();
			for (int i = 0; i < playedSoundsTag.size(); i++) {
				playedSoundTimes.add(playedSoundsTag.getFloatOr(i, 0));
			}
			// Play any sound keyframes
			for (Map.Entry<Float, String> soundEntry : animation.soundEffects.entrySet()) {
				float soundTime = soundEntry.getKey();
				String soundId = soundEntry.getValue();
				if (playedSoundTimes.contains(soundTime)) {
					continue;
				}
				boolean shouldPlay = false;
				if (lastAnimationProgress <= animationProgress) {
					shouldPlay = lastAnimationProgress <= soundTime && animationProgress >= soundTime;
				} else {
					shouldPlay = lastAnimationProgress <= soundTime || animationProgress >= soundTime;
				}
				if (shouldPlay && player.level() instanceof ClientLevel clientLevel) {
					clientLevel.playLocalSound(player.getX(), player.getY(), player.getZ(), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse(soundId)), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
					playedSoundsTag.add(FloatTag.valueOf(soundTime));
				}
			}
			data.put("PlayedSoundTimes", playedSoundsTag);
			data.putFloat("LastAnimationProgress", animationProgress);
		}
		if (!data.getBooleanOr("FirstPersonAnimation", false) && mc.options.getCameraType().isFirstPerson() && player == mc.player && mc.screen == null)
			return;
		// Apply each bone's transformations
		for (Map.Entry<String, FftUntoldStoryModPlayerAnimationAPI.PlayerBone> entry : animation.bones.entrySet()) {
			String boneName = entry.getKey();
			FftUntoldStoryModPlayerAnimationAPI.PlayerBone bone = entry.getValue();
			ModelPart modelPart = getModelPart(model, boneName);
			if (modelPart == null)
				continue;
			// Apply rotation
			Vec3 rotation = FftUntoldStoryModPlayerAnimationAPI.PlayerBone.interpolate(bone.rotations, animationProgress, player);
			if (rotation != null) {
				modelPart.xRot = (float) Math.toRadians(rotation.x);
				modelPart.yRot = (float) Math.toRadians(rotation.y);
				modelPart.zRot = (float) Math.toRadians(rotation.z);
			}
			// Apply position (don't apply if null - keep default position)
			Vec3 position = FftUntoldStoryModPlayerAnimationAPI.PlayerBone.interpolate(bone.positions, animationProgress, player);
			if (position != null) {
				// Position offsets are relative, not absolute
				modelPart.x += (float) position.x;
				modelPart.y -= (float) position.y;
				modelPart.z += (float) position.z;
			}
			// Apply scale
			Vec3 scale = FftUntoldStoryModPlayerAnimationAPI.PlayerBone.interpolate(bone.scales, animationProgress, player);
			if (scale != null) {
				modelPart.xScale = (float) scale.x;
				modelPart.yScale = (float) scale.y;
				modelPart.zScale = (float) scale.z;
			}
			boolean firstPersonArms = firstPerson && (boneName.equals("right_arm") || boneName.equals("left_arm"));
			if (firstPersonArms) {
				float frameBuffer = 0.09f;
				float timeLeft = animation.length - animationProgress;
				float fpWeight = 1.0f;
				boolean rightArm = boneName.equals("right_arm");
				if (!animation.loop && timeLeft < frameBuffer) {
					fpWeight = Math.max(0f, timeLeft / frameBuffer);
				}
				if (fpWeight > 0) {
					float pitchRadians = (float) Math.toRadians(player.getXRot());
					modelPart.xRot += pitchRadians * fpWeight;
					float yRotCorrection = pitchRadians * (rightArm ? -0.42f : 0.42f);
					modelPart.yRot += yRotCorrection * fpWeight;
					float zRotCorrection = pitchRadians * (rightArm ? -0.34f : 0.34f);
					modelPart.zRot += zRotCorrection * fpWeight;
					float originalY = modelPart.y;
					float originalZ = modelPart.z;
					float cosP = (float) Math.cos(pitchRadians);
					float sinP = (float) Math.sin(pitchRadians);
					float targetY = originalY * cosP - originalZ * sinP;
					float targetZ = originalY * sinP + originalZ * cosP;
					modelPart.y = originalY + (targetY - originalY) * fpWeight;
					modelPart.z = originalZ + (targetZ - originalZ) * fpWeight;
				}
			}
		}
	}

	private ModelPart getModelPart(PlayerModel model, String boneName) {
		switch (boneName) {
			case "torso" :
				return model.body;
			case "head" :
				return model.head;
			case "right_arm" :
				return model.rightArm;
			case "left_arm" :
				return model.leftArm;
			case "right_leg" :
				return model.rightLeg;
			case "left_leg" :
				return model.leftLeg;
			default :
				return null;
		}
	}

	private void hideModelParts(PlayerModel model, boolean hide) {
		model.head.skipDraw = hide;
		model.hat.skipDraw = hide;
		model.body.skipDraw = hide;
		model.jacket.skipDraw = hide;
		model.leftLeg.skipDraw = hide;
		model.leftPants.skipDraw = hide;
		model.rightLeg.skipDraw = hide;
		model.rightPants.skipDraw = hide;
	}
}