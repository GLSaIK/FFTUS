package net.saik.fftuntoldstory.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class TemplarShieldKazhdyiTikVInvientarieProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack)) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack, 0);
		}
	}
}