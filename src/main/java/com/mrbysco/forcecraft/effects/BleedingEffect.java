package com.mrbysco.forcecraft.effects;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BleedingEffect extends MobEffect {
	public BleedingEffect() {
		super(MobEffectCategory.HARMFUL, 0);
	}

	@Override
	public boolean isInstantenous() {
		return false;
	}

	@Override
	public boolean isBeneficial() {
		return false;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity target, int amplifier) {
		//once per tick
		if (target.level().getGameTime() % 20 == 0) {
			target.hurt(Reference.causeBleedingDamage(target), 2.0F);
		}
		return true;
	}
}
