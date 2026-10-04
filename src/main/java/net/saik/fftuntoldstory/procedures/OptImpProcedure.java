package net.saik.fftuntoldstory.procedures;

import net.saik.fftuntoldstory.network.FftUntoldStoryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class OptImpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			FftUntoldStoryModVariables.PlayerVariables _vars = entity.getData(FftUntoldStoryModVariables.PLAYER_VARIABLES);
			_vars.Imp = true;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.BURNING_TIME))
			_livingEntity1.getAttribute(Attributes.BURNING_TIME).setBaseValue(0.2);
		if (entity instanceof LivingEntity _entity) {
			AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("fft_untold_story:impspeed"), 0.1, AttributeModifier.Operation.ADD_VALUE);
			if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
				_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
			}
		}
		if (entity instanceof LivingEntity _entity) {
			AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("fft_untold_story:imphealth"), (-2), AttributeModifier.Operation.ADD_VALUE);
			if (!_entity.getAttribute(Attributes.MAX_HEALTH).hasModifier(modifier.id())) {
				_entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
			}
		}
	}
}