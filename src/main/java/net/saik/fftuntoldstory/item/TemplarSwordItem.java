package net.saik.fftuntoldstory.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class TemplarSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 723, 6f, 0, 16, TagKey.create(Registries.ITEM, ResourceLocation.parse("fft_untold_story:templar_sword_repair_items")));

	public TemplarSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 5f, -2.3f));
	}
}