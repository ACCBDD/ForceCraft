package com.mrbysco.forcecraft.handlers;

import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.items.ForceArmorItem;
import com.mrbysco.forcecraft.items.tools.ForceAxeItem;
import com.mrbysco.forcecraft.items.tools.ForceBowItem;
import com.mrbysco.forcecraft.items.tools.ForcePickaxeItem;
import com.mrbysco.forcecraft.items.tools.ForceRodItem;
import com.mrbysco.forcecraft.items.tools.ForceShearsItem;
import com.mrbysco.forcecraft.items.tools.ForceShovelItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class LumberHandler {

	@SubscribeEvent
	public void onTooltipEvent(BlockEvent.BreakEvent event) {
		final ItemStack stack = event.getPlayer().getMainHandItem();
		if (stack.has(ForceComponents.TOOL_LUMBERJACK)) {
			ForceAxeItem.fellTree(stack, event.getPos(), event.getPlayer());
		}
	}
}
