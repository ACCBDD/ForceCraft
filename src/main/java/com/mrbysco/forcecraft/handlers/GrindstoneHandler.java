package com.mrbysco.forcecraft.handlers;

import com.mrbysco.forcecraft.components.ForceComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.GrindstoneEvent;

public class GrindstoneHandler {
	@SubscribeEvent
	public void onPlace(GrindstoneEvent.OnPlaceItem event) {
		if (!event.getTopItem().isEmpty()) {
			if (event.getTopItem().has(ForceComponents.FORCE_INFUSED)) {
				if (!event.getBottomItem().isEmpty()) {
					event.setCanceled(true);
				} else {
					event.setOutput(removeInfusions(event.getTopItem()));
				}
			}
		} else {
			if (event.getBottomItem().has(ForceComponents.FORCE_INFUSED) && event.getTopItem().isEmpty()) {
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
		itemstack.remove(ForceComponents.FORCE_INFUSED);
		itemstack.remove(DataComponents.ENCHANTMENTS);
		itemstack.remove(DataComponents.STORED_ENCHANTMENTS);
		itemstack.set(DataComponents.REPAIR_COST, 0);

		itemstack.remove(ForceComponents.TOOL_SPEED);
		itemstack.remove(ForceComponents.TOOL_HEAT);
		itemstack.remove(ForceComponents.TOOL_FORCE);
		itemstack.remove(ForceComponents.TOOL_SILK);
		itemstack.remove(ForceComponents.TOOL_SHARPNESS);
		itemstack.remove(ForceComponents.TOOL_LUCK);
		itemstack.remove(ForceComponents.TOOL_STURDY);
		itemstack.remove(ForceComponents.TOOL_RAINBOW);
		itemstack.remove(ForceComponents.TOOL_LUMBERJACK);
		itemstack.remove(ForceComponents.TOOL_BLEED);
		itemstack.remove(ForceComponents.TOOL_BANE);
		itemstack.remove(ForceComponents.TOOL_WING);
		itemstack.remove(ForceComponents.TOOL_CAMO);
		itemstack.remove(ForceComponents.TOOL_SIGHT);
		itemstack.remove(ForceComponents.TOOL_LIGHT);
		itemstack.remove(ForceComponents.TOOL_ENDER);
		itemstack.remove(ForceComponents.TOOL_FREEZING);
		itemstack.remove(ForceComponents.TOOL_TREASURE);

		//Remove all Rod components
		itemstack.remove(ForceComponents.ROD_HEALING);
		itemstack.remove(ForceComponents.ROD_SPEED);
		itemstack.remove(ForceComponents.ROD_LIGHT);
		itemstack.remove(ForceComponents.ROD_CAMO);
		itemstack.remove(ForceComponents.ROD_ENDER);
		itemstack.remove(ForceComponents.ROD_SIGHT);
		itemstack.remove(ForceComponents.ROD_POS);

		itemstack.remove(ForceComponents.TOME_EXPERIENCE);
		itemstack.remove(ForceComponents.WRENCH);

		return itemstack;
	}
}
