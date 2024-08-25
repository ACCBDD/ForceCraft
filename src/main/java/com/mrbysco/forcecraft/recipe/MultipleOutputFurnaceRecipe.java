package com.mrbysco.forcecraft.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;

public abstract class MultipleOutputFurnaceRecipe extends AbstractCookingRecipe {
	protected final float secondaryChance;
	static int MAX_OUTPUT = 2;

	protected final NonNullList<ItemStack> results;

	public MultipleOutputFurnaceRecipe(RecipeType<?> typeIn, String groupIn, Ingredient ingredientIn, NonNullList<ItemStack> results, float secondaryChance, float experienceIn, int cookTimeIn) {
		super(typeIn, groupIn, CookingBookCategory.MISC, ingredientIn, results.getFirst(), experienceIn, cookTimeIn);
		this.results = results;
		this.secondaryChance = secondaryChance;
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

	@Override
	public ItemStack assemble(SingleRecipeInput inv, HolderLookup.Provider registries) {
		return getResultItem(registries).copy();
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider registries) {
		return this.results.getFirst();
	}

	public NonNullList<ItemStack> getRecipeOutputs() {
		return this.results;
	}

	public float getSecondaryChance() {
		return this.secondaryChance;
	}
}
