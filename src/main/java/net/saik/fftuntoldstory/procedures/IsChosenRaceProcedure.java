package net.saik.fftuntoldstory.procedures;

import net.saik.fftuntoldstory.network.FftUntoldStoryModVariables;

import net.minecraft.world.entity.Entity;

public class IsChosenRaceProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(FftUntoldStoryModVariables.PLAYER_VARIABLES).Human == true || entity.getData(FftUntoldStoryModVariables.PLAYER_VARIABLES).Imp == true || entity.getData(FftUntoldStoryModVariables.PLAYER_VARIABLES).Birdman == true) {
			return false;
		}
		return true;
	}
}