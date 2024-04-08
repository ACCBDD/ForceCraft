package com.mrbysco.forcecraft.util;

import com.mrbysco.forcecraft.attachment.playermodifier.PlayerModifierAttachment;
import com.mrbysco.forcecraft.registry.ForceEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import static com.mrbysco.forcecraft.attachment.ForceAttachments.PLAYER_MOD;

public class MobUtil {
	private static final int BLEEDING_SECONDS = 20;

	public static void addBleedingEffect(int level, LivingEntity target, Entity trueSource) {
		int adjustedLevel = level;
		if (trueSource instanceof Player player) {
			if (player.hasData(PLAYER_MOD)) {
				PlayerModifierAttachment attachment = player.getData(PLAYER_MOD);
				if (attachment.hasBleeding()) {
					adjustedLevel += attachment.getBleedingLevel();
				}
			}
		}
		if (adjustedLevel > 15) {
			adjustedLevel = 15;
		}

		if (adjustedLevel > 0) {
//            ForceCraft.LOGGER.info("Added BLEEDING to " + target.getName());
			target.addEffect(new MobEffectInstance(ForceEffects.BLEEDING.get(), BLEEDING_SECONDS * adjustedLevel, 0, false, true));
		}
	}
}
