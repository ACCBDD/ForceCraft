package com.mrbysco.forcecraft.util;

import com.mrbysco.forcecraft.attachments.ForceAttachments;
import com.mrbysco.forcecraft.attachments.playermodifier.PlayerModifierAttachment;
import com.mrbysco.forcecraft.registry.ForceEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class MobUtil {
	private static final int BLEEDING_SECONDS = 20;

	public static void addBleedingEffect(int level, LivingEntity target, Entity trueSource) {
		int adjustedLevel = level;
		if (trueSource instanceof Player player) {
			if (player.hasData(ForceAttachments.PLAYER_MOD)) {
				PlayerModifierAttachment attachment = player.getData(ForceAttachments.PLAYER_MOD);
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
			target.addEffect(new MobEffectInstance(ForceEffects.BLEEDING, BLEEDING_SECONDS * adjustedLevel, 0, false, true));
		}
	}
}
