/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.fftuntoldstory.init;

import net.saik.fftuntoldstory.client.model.ModelTemplarHelmet;
import net.saik.fftuntoldstory.client.model.ModelTemplarArmorF;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class FftUntoldStoryModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelTemplarHelmet.LAYER_LOCATION, ModelTemplarHelmet::createBodyLayer);
		event.registerLayerDefinition(ModelTemplarArmorF.LAYER_LOCATION, ModelTemplarArmorF::createBodyLayer);
	}
}