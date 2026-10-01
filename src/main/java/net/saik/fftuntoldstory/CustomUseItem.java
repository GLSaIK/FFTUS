package net.saik.fftuntoldstory;
import net.saik.fftuntoldstory.FftUntoldStoryMod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.saik.fftuntoldstory.item.TemplarShieldItem;

public class CustomUseItem {


    public static boolean shouldIgnoreUseSlowdown(ItemStack stack) {

        if (stack == null || stack.isEmpty()) {
            return false;
        }

        Item item = stack.getItem();

        if (item instanceof TemplarShieldItem) {
            return true;
        }

        return false;
    }
}
