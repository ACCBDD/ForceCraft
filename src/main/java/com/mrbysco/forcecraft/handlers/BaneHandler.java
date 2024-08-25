package com.mrbysco.forcecraft.handlers;

import com.mrbysco.forcecraft.attachments.ForceAttachments;
import com.mrbysco.forcecraft.attachments.banemodifier.BaneModifierAttachment;
import net.minecraft.world.entity.ai.goal.SwellGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;

public class BaneHandler {
	@SubscribeEvent
	public void onEnderTeleportEvent(EntityTeleportEvent.EnderEntity event) {
		if (event.getEntity() instanceof EnderMan enderman) {
			if (enderman.hasData(ForceAttachments.BANE_MODIFIER)) {
				BaneModifierAttachment attachment = enderman.getData(ForceAttachments.BANE_MODIFIER);
				if (!attachment.canTeleport()) {
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityCreation(EntityJoinLevelEvent event) {
		if (!event.getLevel().isClientSide()) {
			if (event.getEntity() instanceof Creeper creeper) {
				if (creeper.hasData(ForceAttachments.BANE_MODIFIER)) {
					BaneModifierAttachment attachment = creeper.getData(ForceAttachments.BANE_MODIFIER);
					if (!attachment.canExplode()) {
						creeper.setSwellDir(-1);
						creeper.getEntityData().set(Creeper.DATA_IS_IGNITED, false);
						attachment.setExplodeAbility(false);
						creeper.goalSelector.getAvailableGoals().removeIf(goal -> goal.getGoal() instanceof SwellGoal);

						creeper.setData(ForceAttachments.BANE_MODIFIER, attachment);
					}
				}
			}
		}
	}
}
