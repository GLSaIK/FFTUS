package net.saik.fftuntoldstory.procedures;

import net.saik.fftuntoldstory.network.FftUntoldStoryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class OptBirdmanProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			FftUntoldStoryModVariables.PlayerVariables _vars = entity.getData(FftUntoldStoryModVariables.PLAYER_VARIABLES);
			_vars.Birdman = true;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof LivingEntity _entity) {
			AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("fft_untold_story:birdmanstrenth"), (-0.5), AttributeModifier.Operation.ADD_VALUE);
			if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
				_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
			}
		}
		if (entity instanceof LivingEntity _entity) {
			AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("fft_untold_story:birdmanspeed"), (-0.025), AttributeModifier.Operation.ADD_VALUE);
			if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
				_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
			}
		}
	}
}