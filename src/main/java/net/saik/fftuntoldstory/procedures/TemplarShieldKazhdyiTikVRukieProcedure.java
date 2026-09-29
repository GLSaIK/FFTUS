package net.saik.fftuntoldstory.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class TemplarShieldKazhdyiTikVRukieProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrCldRem1 ? _plrCldRem1.getCooldowns().getCooldownPercent(itemstack, 0f) * 100 : 0) > 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack, 0);
		}
	}
}