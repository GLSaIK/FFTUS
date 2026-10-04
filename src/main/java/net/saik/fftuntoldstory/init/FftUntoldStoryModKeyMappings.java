/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.fftuntoldstory.init;

import org.lwjgl.glfw.GLFW;

import net.saik.fftuntoldstory.network.BirdmanRushMessage;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@EventBusSubscriber(Dist.CLIENT)
public class FftUntoldStoryModKeyMappings {
	public static final KeyMapping BIRDMAN_RUSH = new KeyMapping("key.fft_untold_story.birdman_rush", GLFW.GLFW_KEY_UP, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new BirdmanRushMessage(0, 0));
				BirdmanRushMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(BIRDMAN_RUSH);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				BIRDMAN_RUSH.consumeClick();
			}
		}
	}
}