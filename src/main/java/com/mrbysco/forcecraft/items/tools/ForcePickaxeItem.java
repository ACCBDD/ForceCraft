package com.mrbysco.forcecraft.items.tools;

import com.mrbysco.forcecraft.items.infuser.ForceToolData;
import com.mrbysco.forcecraft.items.infuser.IForceChargingTool;
import com.mrbysco.forcecraft.registry.material.ModToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class ForcePickaxeItem extends PickaxeItem implements IForceChargingTool {

	public ForcePickaxeItem(Item.Properties properties) {
		super(ModToolTiers.FORCE, properties.attributes(createAttributes(ModToolTiers.FORCE, -6, -2.8F)));
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		ForceToolData fd = new ForceToolData(stack);
		fd.attachInformation(tooltip);
		super.appendHoverText(stack, context, tooltip, tooltipFlag);
	}

	@Override
	public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
		return this.damageItem(stack, amount);
	}

	@Override
	public int getEnchantmentValue() {
		return 0;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

}