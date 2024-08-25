package com.mrbysco.forcecraft.handlers;

import com.mrbysco.forcecraft.attachments.ForceAttachments;
import com.mrbysco.forcecraft.attachments.playermodifier.PlayerModifierAttachment;
import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.config.ConfigHandler;
import com.mrbysco.forcecraft.items.ForceArmorItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class PlayerCapHandler {

	private static final int SPEED_DURATION = 200;

	@SubscribeEvent
	public void onPlayerUpdate(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			Iterable<ItemStack> armor = player.getArmorSlots();
			int speed = 0;
			for (ItemStack slotSelected : armor) {
				if (slotSelected.getItem() instanceof ForceArmorItem) {
					// Speed
					speed += slotSelected.getOrDefault(ForceComponents.TOOL_SPEED, 0);
				}
			}

			if (speed > 0) {
				MobEffectInstance speedEffect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SPEED_DURATION, speed - 1, false, false);
				if (!player.hasEffect(MobEffects.MOVEMENT_SPEED) || (player.hasEffect(MobEffects.MOVEMENT_SPEED) && player.getEffect(MobEffects.MOVEMENT_SPEED).getDuration() <= 100)) {
					player.addEffect(speedEffect);
				}
			}
		}
	}

	@SubscribeEvent
	public void onLogin(PlayerLoggedInEvent event) {
		//Sync on login
		updateArmorProperties(event.getEntity());
	}

	@SubscribeEvent
	public void equipmentChangeEvent(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof Player player) {
			updateArmorProperties(player);
		}
	}

	public static void updateArmorProperties(Player player) {
		Iterable<ItemStack> armor = player.getArmorSlots();
		int armorPieces = 0;
		int damage = 0;
		int heat = 0;
		int luck = 0;
		int bane = 0;
		int bleed = 0;

		for (ItemStack slotSelected : armor) {
			if (slotSelected.getItem() instanceof ForceArmorItem) {
				// Pieces
				armorPieces++;

				// Damage
				damage += (int) (slotSelected.getOrDefault(ForceComponents.TOOL_SHARPNESS, 0) * ConfigHandler.COMMON.forcePunchDamage.get());
				// Heat
				if (slotSelected.has(ForceComponents.TOOL_HEAT)) {
					heat++;
				}
				// Luck
				if (slotSelected.has(ForceComponents.TOOL_LUCK)) {
					luck++;
				}
				// Bane
				if (slotSelected.has(ForceComponents.TOOL_BANE)) {
					bane++;
				}
				// Bleed
				if (slotSelected.has(ForceComponents.TOOL_BLEED)) {
					bleed += slotSelected.getOrDefault(ForceComponents.TOOL_BLEED, 0);
				}
			}
		}

		PlayerModifierAttachment attachment = player.getData(ForceAttachments.PLAYER_MOD);
		int finalArmorPieces = armorPieces;
		attachment.setArmorPieces(finalArmorPieces);

		int finalDamage = damage;
		attachment.setAttackDamage(1.0F * finalDamage);

		int finalHeat = heat;
		attachment.setHeatPieces(finalHeat);
		attachment.setHeatDamage(2.0F * finalHeat);

		int finalLuck = luck;
		attachment.setLuckLevel(finalLuck);

		int finalBane = bane;
		attachment.setBane(finalBane > 0);

		int finalBleed = bleed;
		attachment.setBleeding(finalBleed);

		//Save the attachment data
		player.setData(ForceAttachments.PLAYER_MOD, attachment);
	}

	@SubscribeEvent
	public void harvestCheckEvent(PlayerEvent.HarvestCheck event) {
		final Player player = event.getEntity();
		if (player.hasData(ForceAttachments.PLAYER_MOD)) {
			PlayerModifierAttachment attachment = player.getData(ForceAttachments.PLAYER_MOD);
			if (attachment.hasFullSet() && player.getMainHandItem().isEmpty()) {
				if (event.getTargetBlock().getBlock().getExplosionResistance() <= 2) {
					event.setCanHarvest(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void breakSpeedEvent(PlayerEvent.BreakSpeed event) {
		final Player player = event.getEntity();
		if (player.hasData(ForceAttachments.PLAYER_MOD)) {
			PlayerModifierAttachment attachment = player.getData(ForceAttachments.PLAYER_MOD);
			if (attachment.hasFullSet() && player.getMainHandItem().isEmpty()) {
				if (event.getOriginalSpeed() < 6) {
					event.setNewSpeed(6);
				}
			}
		}
	}
}
