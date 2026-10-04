package net.saik.fftuntoldstory.procedures;

import net.saik.fftuntoldstory.network.FftUntoldStoryModVariables;

import net.minecraft.world.entity.Entity;

public class RecetRacePProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			FftUntoldStoryModVariables.PlayerVariables _vars = entity.getData(FftUntoldStoryModVariables.PLAYER_VARIABLES);
			_vars.Human = false;
			_vars.Imp = false;
			_vars.Birdman = false;
			_vars.markSyncDirty();
		}
	}
}