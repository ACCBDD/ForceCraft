package com.mrbysco.forcecraft.util;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;

public final class EnchantUtils {

	public static void removeEnchant(ItemStack stack, Holder<Enchantment> enchantment) {
		ItemEnchantments itemenchantments = EnchantmentHelper.updateEnchantments(
				stack, mutable -> mutable.removeIf(holder -> !holder.is(enchantment))
		);
	}

	public static void incrementLevel(ItemStack stack, Holder<Enchantment> enchantment) {
		incrementLevel(stack, enchantment, 1);
	}

	public static void incrementLevel(ItemStack stack, Holder<Enchantment> enchantment, int levels) {
		ItemEnchantments itemenchantments = EnchantmentHelper.updateEnchantments(
				stack, mutable -> mutable.upgrade(enchantment, levels) //TODO: Test if this works!
		);
	}
}
