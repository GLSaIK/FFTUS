package net.saik.fftuntoldstory.procedures;

import net.saik.fftuntoldstory.network.FftUntoldStoryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class OptHumanProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			FftUntoldStoryModVariables.PlayerVariables _vars = entity.getData(FftUntoldStoryModVariables.PLAYER_VARIABLES);
			_vars.Human = true;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}