package com.mrbysco.forcecraft.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.forcecraft.registry.ForceRecipeSerializers;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;

public class ShapedNoRemainderRecipe extends ShapedRecipe {
	final ShapedRecipePattern pattern;
	final ItemStack result;
	final String group;
	final CraftingBookCategory category;
	final boolean showNotification;

	public ShapedNoRemainderRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification) {
		super(group, category, pattern, result, showNotification);
		this.group = group;
		this.category = category;
		this.pattern = pattern;
		this.result = result;
		this.showNotification = showNotification;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ForceRecipeSerializers.SHAPED_NO_REMAINDER_SERIALIZER.get();
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInput inv) {
		NonNullList<ItemStack> nonnulllist = NonNullList.withSize(inv.size(), ItemStack.EMPTY);

		return nonnulllist;
	}

	public static class Serializer implements RecipeSerializer<ShapedNoRemainderRecipe> {
		public static final MapCodec<ShapedNoRemainderRecipe> CODEC = RecordCodecBuilder.mapCodec(
				p_340778_ -> p_340778_.group(
								Codec.STRING.optionalFieldOf("group", "").forGetter(p_311729_ -> p_311729_.group),
								CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(p_311732_ -> p_311732_.category),
								ShapedRecipePattern.MAP_CODEC.forGetter(p_311733_ -> p_311733_.pattern),
								ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_311730_ -> p_311730_.result),
								Codec.BOOL.optionalFieldOf("show_notification", Boolean.valueOf(true)).forGetter(p_311731_ -> p_311731_.showNotification)
						)
						.apply(p_340778_, ShapedNoRemainderRecipe::new)
		);
		public static final StreamCodec<RegistryFriendlyByteBuf, ShapedNoRemainderRecipe> STREAM_CODEC = StreamCodec.of(
				ShapedNoRemainderRecipe.Serializer::toNetwork, ShapedNoRemainderRecipe.Serializer::fromNetwork
		);

		@Override
		public MapCodec<ShapedNoRemainderRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, ShapedNoRemainderRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static ShapedNoRemainderRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			String s = buffer.readUtf();
			CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
			ShapedRecipePattern shapedrecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
			boolean flag = buffer.readBoolean();
			return new ShapedNoRemainderRecipe(s, craftingbookcategory, shapedrecipepattern, itemstack, flag);
		}

		private static void toNetwork(RegistryFriendlyByteBuf buffer, ShapedNoRemainderRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeEnum(recipe.category);
			ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
			ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
			buffer.writeBoolean(recipe.showNotification);
		}
	}
}
