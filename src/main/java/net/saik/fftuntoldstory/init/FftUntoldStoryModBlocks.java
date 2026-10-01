/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.fftuntoldstory.init;

import net.saik.fftuntoldstory.block.CrossHeartBlock;
import net.saik.fftuntoldstory.FftUntoldStoryMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class FftUntoldStoryModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(FftUntoldStoryMod.MODID);
	public static final DeferredBlock<Block> CROSS_HEART;
	static {
		CROSS_HEART = register("cross_heart", CrossHeartBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}