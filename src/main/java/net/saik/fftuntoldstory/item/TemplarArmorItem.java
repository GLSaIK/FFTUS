package net.saik.fftuntoldstory.item;

import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.Map;

public abstract class TemplarArmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(15, Map.of(ArmorType.BOOTS, 1, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 5, ArmorType.HELMET, 3, ArmorType.BODY, 5), 11,
			DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_chain")), 0f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("fft_untold_story:templar_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("fft_untold_story:templar_armor")));

	private TemplarArmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends TemplarArmorItem {
		public Helmet(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}
	}

	public static class Chestplate extends TemplarArmorItem {
		public Chestplate(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
		}
	}

	public static class Leggings extends TemplarArmorItem {
		public Leggings(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
		}
	}

	public static class Boots extends TemplarArmorItem {
		public Boots(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
		}
	}
}