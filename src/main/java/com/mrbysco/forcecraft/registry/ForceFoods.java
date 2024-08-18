package com.mrbysco.forcecraft.registry;

import net.minecraft.world.food.FoodProperties;

public class ForceFoods {
	public static final FoodProperties FORTUNE_COOKIE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).alwaysEdible().build();
	public static final FoodProperties SOUL_WAFER = (new FoodProperties.Builder()).nutrition(2).saturationModifier(1.0F).build();
	public static final FoodProperties BACON = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4F).build();
	public static final FoodProperties COOKED_BACON = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.8F).build();
	//TODO: Add bacon and cooked bacon to minecraft:meat
}
