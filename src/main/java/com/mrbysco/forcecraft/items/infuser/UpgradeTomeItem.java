package com.mrbysco.forcecraft.items.infuser;

import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.items.BaseItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class UpgradeTomeItem extends BaseItem {

	public UpgradeTomeItem(Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, context, tooltip, flagIn);
		UpgradeBookData bd = stack.getOrDefault(ForceComponents.UPGRADE_BOOK, UpgradeBookData.DEFAULT);

		MutableComponent tt = Component.translatable("item.forcecraft.upgrade_tome.tt.tier");
		tt.withStyle(Style.EMPTY.applyFormat(ChatFormatting.AQUA));
		tt.append(" " + bd.tier());
		if (!bd.progressCache().isEmpty()) {
			tt.append(" : " + bd.progressCache());
		}
		tooltip.add(tt);

		if (bd.tier() == UpgradeBookTier.FINAL) {
			tt = Component.translatable("item.forcecraft.upgrade_tome.tt.max");
			tt.withStyle(Style.EMPTY.applyFormat(ChatFormatting.AQUA));
		} else {
			tt = Component.translatable("item.forcecraft.upgrade_tome.tt.points");
			tt.withStyle(Style.EMPTY.applyFormat(ChatFormatting.AQUA));
			tt.append(" " + bd.points());
			tooltip.add(tt);

			tt = Component.translatable("item.forcecraft.upgrade_tome.tt.nexttier");
			tt.withStyle(Style.EMPTY.applyFormat(ChatFormatting.AQUA));
			tt.append(" " + bd.nextTier(stack));
		}
		tooltip.add(tt);


		if (!Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("forcecraft.tooltip.press_shift"));
			return;
		}

		tooltip.add(Component.translatable("item.forcecraft.upgrade_tome.tt.point_info"));
		tt.withStyle(Style.EMPTY.applyFormat(ChatFormatting.AQUA));
	}

	public static void onModifierApplied(ItemStack bookInSlot, ItemStack modifier, ItemStack tool) {
		UpgradeBookData.incrementPoints(bookInSlot, 25); // TODO: points per modifier upgrade value !!
	}
}
