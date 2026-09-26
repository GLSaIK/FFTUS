/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.fftuntoldstory.init;

import net.saik.fftuntoldstory.FftUntoldStoryMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class FftUntoldStoryModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FftUntoldStoryMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FFT_UNTOLD_STORY = REGISTRY.register("fft_untold_story",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.fft_untold_story.fft_untold_story")).icon(() -> new ItemStack(Blocks.SUGAR_CANE)).displayItems((parameters, tabData) -> {
				tabData.accept(FftUntoldStoryModItems.TEMPLAR_ARMOR_HELMET.get());
				tabData.accept(FftUntoldStoryModItems.TEMPLAR_ARMOR_CHESTPLATE.get());
				tabData.accept(FftUntoldStoryModItems.TEMPLAR_ARMOR_LEGGINGS.get());
				tabData.accept(FftUntoldStoryModItems.TEMPLAR_ARMOR_BOOTS.get());
				tabData.accept(FftUntoldStoryModItems.TEMPLAR_SWORD.get());
				tabData.accept(FftUntoldStoryModItems.TEMPLAR_SHIELD.get());
			}).build());
}