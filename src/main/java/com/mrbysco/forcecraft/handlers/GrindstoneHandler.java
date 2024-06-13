package com.mrbysco.forcecraft.handlers;

import com.mrbysco.forcecraft.attachment.ForceAttachments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.GrindstoneEvent;

import java.util.Map;
import java.util.stream.Collectors;

public class GrindstoneHandler {
	@SubscribeEvent
	public void onPlace(GrindstoneEvent.OnPlaceItem event) {
		if (!event.getTopItem().isEmpty()) {
			CompoundTag topTag = event.getTopItem().getTag();
			if (topTag != null && topTag.contains("ForceInfused")) {
				if (!event.getBottomItem().isEmpty()) {
					event.setCanceled(true);
				} else {
					event.setOutput(removeInfusions(event.getTopItem()));
				}
			}
		} else {
			CompoundTag bottomTag = event.getBottomItem().getTag();
			if (bottomTag != null && bottomTag.contains("ForceInfused") && event.getTopItem().isEmpty()) {
				if (!event.getTopItem().isEmpty()) {
					event.setCanceled(true);
				} else {
					event.setOutput(removeInfusions(event.getBottomItem()));
				}
			}
		}
	}

	private ItemStack removeInfusions(ItemStack stack) {
		ItemStack itemstack = stack.copyWithCount(stack.getCount());
		itemstack.removeTagKey("ForceInfused");
		itemstack.removeTagKey("Enchantments");
		itemstack.removeTagKey("StoredEnchantments");

		Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack)
				.entrySet()
				.stream()
				.filter(entry -> entry.getKey().isCurse())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		EnchantmentHelper.setEnchantments(map, itemstack);
		itemstack.setRepairCost(0);

		itemstack.removeData(ForceAttachments.TOOL_MODIFIER);
		itemstack.removeData(ForceAttachments.FORCE_ROD);
		itemstack.removeData(ForceAttachments.EXP_TOME);
		itemstack.removeData(ForceAttachments.BANE_MODIFIER);
		itemstack.removeData(ForceAttachments.PLAYER_MOD);
		itemstack.removeData(ForceAttachments.FORCE_WRENCH);

		return itemstack;
	}
}
