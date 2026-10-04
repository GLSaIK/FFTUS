/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.fftuntoldstory.init;

import net.saik.fftuntoldstory.client.gui.RaceChoiceUIScreen;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class FftUntoldStoryModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(FftUntoldStoryModMenus.RACE_CHOICE_UI.get(), RaceChoiceUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}