package net.saik.fftuntoldstory.procedures;

import net.saik.fftuntoldstory.init.FftUntoldStoryModItems;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class CrossHeartPriObnovlieniiTikaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.GOLD_BLOCK
				&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.GOLD_BLOCK
						|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.GOLD_BLOCK)) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player) {
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == FftUntoldStoryModItems.TEMPLAR_ARMOR_HELMET.get()
								|| (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == FftUntoldStoryModItems.TEMPLAR_ARMOR_CHESTPLATE.get()
								|| (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == FftUntoldStoryModItems.TEMPLAR_ARMOR_LEGGINGS.get()
								|| (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == FftUntoldStoryModItems.TEMPLAR_ARMOR_BOOTS.get()) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0));
						}
					} else if (entityiterator.getType().is(EntityTypeTags.UNDEAD)) {
						if (Mth.nextInt(RandomSource.create(), 1, 50) == 3) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);
						}
					}
				}
			}
		} else {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}