package net.saik.fftuntoldstory.client.renderer.item;

import net.saik.fftuntoldstory.init.FftUntoldStoryModItems;
import net.saik.fftuntoldstory.client.model.ModelTemplarTorso;
import net.saik.fftuntoldstory.client.model.ModelTemplarLeggs;
import net.saik.fftuntoldstory.client.model.ModelTemplarHelmet;
import net.saik.fftuntoldstory.client.model.ModelTemplarBoot;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.Minecraft;

import java.util.Map;
import java.util.Collections;

@EventBusSubscriber(Dist.CLIENT)
public class TemplarArmorArmor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private HumanoidModel armorModel = null;

			@Override
			public HumanoidModel getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
				if (armorModel == null) {
					armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head",
							new ModelPart(Collections.emptyList(),
									Map.of("head", new ModelTemplarHelmet(Minecraft.getInstance().getEntityModels().bakeLayer(ModelTemplarHelmet.LAYER_LOCATION)).TemplarHelmet, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()))),
							"body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm",
							new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				}
				return armorModel;
			}

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("fft_untold_story:textures/entities/templarfull.png");
			}
		}, FftUntoldStoryModItems.TEMPLAR_ARMOR_HELMET.get());
		event.registerItem(new IClientItemExtensions() {
			private HumanoidModel armorModel = null;

			@Override
			public HumanoidModel getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
				if (armorModel == null) {
					ModelTemplarTorso model = new ModelTemplarTorso(Minecraft.getInstance().getEntityModels().bakeLayer(ModelTemplarTorso.LAYER_LOCATION));
					armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("body", model.TemplarTorso, "left_arm", model.leftArm2, "right_arm", model.rightArm2, "head", new ModelPart(Collections.emptyList(), Map.of("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()))),
									"right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				}
				return armorModel;
			}

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("fft_untold_story:textures/entities/templarfull.png");
			}
		}, FftUntoldStoryModItems.TEMPLAR_ARMOR_CHESTPLATE.get());
		event.registerItem(new IClientItemExtensions() {
			private HumanoidModel armorModel = null;

			@Override
			public HumanoidModel getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
				if (armorModel == null) {
					ModelTemplarLeggs model = new ModelTemplarLeggs(Minecraft.getInstance().getEntityModels().bakeLayer(ModelTemplarLeggs.LAYER_LOCATION));
					armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("left_leg", model.LeftLeg2, "right_leg", model.RightLeg2, "head", new ModelPart(Collections.emptyList(), Map.of("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()))), "body",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				}
				return armorModel;
			}

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("fft_untold_story:textures/entities/templarfull.png");
			}
		}, FftUntoldStoryModItems.TEMPLAR_ARMOR_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			private HumanoidModel armorModel = null;

			@Override
			public HumanoidModel getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
				if (armorModel == null) {
					ModelTemplarBoot model = new ModelTemplarBoot(Minecraft.getInstance().getEntityModels().bakeLayer(ModelTemplarBoot.LAYER_LOCATION));
					armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("left_leg", model.leftBoot, "right_leg", model.rightBoot, "head", new ModelPart(Collections.emptyList(), Map.of("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()))), "body",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				}
				return armorModel;
			}

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("fft_untold_story:textures/entities/templarfull.png");
			}
		}, FftUntoldStoryModItems.TEMPLAR_ARMOR_BOOTS.get());
	}
}