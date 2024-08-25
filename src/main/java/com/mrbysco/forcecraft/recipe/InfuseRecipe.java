package com.mrbysco.forcecraft.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.forcecraft.blockentities.InfuserBlockEntity;
import com.mrbysco.forcecraft.blockentities.InfuserModifierType;
import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.components.storage.PackStackHandler;
import com.mrbysco.forcecraft.items.infuser.UpgradeBookData;
import com.mrbysco.forcecraft.items.infuser.UpgradeBookTier;
import com.mrbysco.forcecraft.registry.ForceRecipeSerializers;
import com.mrbysco.forcecraft.registry.ForceRecipes;
import com.mrbysco.forcecraft.registry.ForceRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

public class InfuseRecipe implements Recipe<RecipeInput> {
	private static final int MAX_SLOTS = 8;
	protected Ingredient ingredient;
	protected InfuserModifierType resultModifier;
	protected ItemStack output;
	protected UpgradeBookTier tier;
	protected Ingredient center;
	protected int time;

	public InfuseRecipe(Ingredient center, Ingredient input, InfuserModifierType resultType, UpgradeBookTier tier, ItemStack outputStack, int time) {
		this.ingredient = input;
		this.center = center;
		this.output = outputStack;
		this.resultModifier = resultType;
		this.tier = tier;
		this.time = time;
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public boolean matches(RecipeInput inv, Level level) {
		for (int i = 0; i < inv.size(); i++) {
			ItemStack stack = inv.getItem(i);
			if (i < InfuserBlockEntity.SLOT_TOOL) {
				return matchesModifier(inv, stack, false);
			}
		}
		return false;
	}

	public boolean matchesModifier(RecipeInput inv, ItemStack modifier, boolean ignoreInfused) {
		//Has the correct tier
		ItemStack bookStack = inv.getItem(InfuserBlockEntity.SLOT_BOOK);
		UpgradeBookData bd = bookStack.getOrDefault(ForceComponents.UPGRADE_BOOK, UpgradeBookData.DEFAULT);
		int bookTier = bd.tier().ordinal();
		if (getTier().ordinal() > bookTier) {
			return false;
		}

		//Does the center match
		ItemStack centerStack = inv.getItem(InfuserBlockEntity.SLOT_TOOL);
		boolean toolMatches = matchesTool(centerStack, ignoreInfused);
		boolean modifierMatches = matchesModifier(centerStack, modifier);

//		ForceCraft.LOGGER.info(cent + " does  match center for "+this.id);


		return toolMatches && modifierMatches;
	}

	public boolean matchesModifier(InfuserBlockEntity inv, ItemStack modifierStack) {
		ItemStack centerStack = inv.handler.getStackInSlot(InfuserBlockEntity.SLOT_TOOL);
		return matchesModifier(centerStack, modifierStack);
	}

	public boolean matchesModifier(ItemStack centerStack, ItemStack modifierStack) {
		if (modifierStack.getItem() == ForceRegistry.FORCE_PACK_UPGRADE.get()) {
			IItemHandler handler = centerStack.getCapability(Capabilities.ItemHandler.ITEM);
			if (handler instanceof PackStackHandler) {
				if (((PackStackHandler) handler).getUpgrades() != getTier().ordinal() - 2) {
					return false;
				}
			}
		}

		return this.ingredient.test(modifierStack);
	}

	public boolean matchesTool(ItemStack toolStack, boolean ignoreInfused) {
		if (!this.center.test(toolStack)) {
			// center doesn't match this recipe. move over
			return false;
		}
		if (!ignoreInfused) {
			//Ignore if the tool is infused in case of infusing for the first time
			return !toolStack.has(ForceComponents.FORCE_INFUSED);
		}
		return true;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return height == 1 && width < MAX_SLOTS;
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider registries) {
		return output;
	}

	public boolean hasOutput() {
		return !output.isEmpty(); //should also be for modifier == ITEM
	}

	@Override
	public ItemStack assemble(RecipeInput inv, HolderLookup.Provider registries) {
		return getResultItem(registries);
	}

	@Override
	public RecipeType<?> getType() {
		return ForceRecipes.INFUSER_TYPE.get();
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public Ingredient getCenter() {
		return center;
	}

	public InfuserModifierType getModifier() {
		return resultModifier;
	}

	public void setModifier(InfuserModifierType modifier) {
		this.resultModifier = modifier;
	}

	public UpgradeBookTier getTier() {
		return tier;
	}

	public void setTier(UpgradeBookTier tier) {
		this.tier = tier;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> ingredients = NonNullList.create();
		ingredients.add(center);
		ingredients.add(ingredient);
		return ingredients;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ForceRecipeSerializers.INFUSER_SERIALIZER.get();
	}

	public static class Serializer implements RecipeSerializer<InfuseRecipe> {
		private static final MapCodec<InfuseRecipe> CODEC = RecordCodecBuilder.mapCodec(
				instance -> instance.group(
								Ingredient.CODEC_NONEMPTY.fieldOf("center").forGetter(recipe -> recipe.center),
								Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
								InfuserModifierType.CODEC.fieldOf("resultType").forGetter(recipe -> recipe.resultModifier),
								UpgradeBookTier.CODEC.fieldOf("tier").forGetter(recipe -> recipe.tier),
								ItemStack.OPTIONAL_CODEC.optionalFieldOf("output", ItemStack.EMPTY).forGetter(recipe -> recipe.output),
								Codec.INT.fieldOf("time").forGetter(recipe -> recipe.time)
						)
						.apply(instance, InfuseRecipe::new)
		);
		public static final StreamCodec<RegistryFriendlyByteBuf, InfuseRecipe> STREAM_CODEC = StreamCodec.of(
				Serializer::toNetwork, Serializer::fromNetwork
		);

		@Override
		public MapCodec<InfuseRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, InfuseRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		public static void toNetwork(RegistryFriendlyByteBuf buffer, InfuseRecipe recipe) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.center);
			Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.ingredient);
			buffer.writeEnum(recipe.resultModifier);
			buffer.writeEnum(recipe.tier);
			ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.output);
			buffer.writeInt(recipe.getTime());
		}

		public static InfuseRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			Ingredient center = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
			Ingredient ing = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
			InfuserModifierType infuserType = buffer.readEnum(InfuserModifierType.class);
			UpgradeBookTier tier = buffer.readEnum(UpgradeBookTier.class);
			ItemStack output = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
			int time = buffer.readInt();
			return new InfuseRecipe(center, ing, infuserType, tier, output, time);
		}
	}
}
