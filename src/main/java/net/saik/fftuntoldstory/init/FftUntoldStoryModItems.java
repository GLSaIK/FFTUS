/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.fftuntoldstory.init;

import net.saik.fftuntoldstory.item.TemplarSwordItem;
import net.saik.fftuntoldstory.item.TemplarShieldItem;
import net.saik.fftuntoldstory.item.TemplarArmorItem;
import net.saik.fftuntoldstory.FftUntoldStoryMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import java.util.function.Function;

public class FftUntoldStoryModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(FftUntoldStoryMod.MODID);
	public static final DeferredItem<Item> TEMPLAR_ARMOR_HELMET;
	public static final DeferredItem<Item> TEMPLAR_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> TEMPLAR_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> TEMPLAR_ARMOR_BOOTS;
	public static final DeferredItem<Item> TEMPLAR_SWORD;
	public static final DeferredItem<Item> TEMPLAR_SHIELD;
	static {
		TEMPLAR_ARMOR_HELMET = register("templar_armor_helmet", TemplarArmorItem.Helmet::new);
		TEMPLAR_ARMOR_CHESTPLATE = register("templar_armor_chestplate", TemplarArmorItem.Chestplate::new);
		TEMPLAR_ARMOR_LEGGINGS = register("templar_armor_leggings", TemplarArmorItem.Leggings::new);
		TEMPLAR_ARMOR_BOOTS = register("templar_armor_boots", TemplarArmorItem.Boots::new);
		TEMPLAR_SWORD = register("templar_sword", TemplarSwordItem::new);
		TEMPLAR_SHIELD = register("templar_shield", TemplarShieldItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}