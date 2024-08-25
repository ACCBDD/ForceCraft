package com.mrbysco.forcecraft.registry;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.recipe.FreezingRecipe;
import com.mrbysco.forcecraft.recipe.GrindingRecipe;
import com.mrbysco.forcecraft.recipe.InfuseRecipe;
import com.mrbysco.forcecraft.recipe.ShapedNoRemainderRecipe;
import com.mrbysco.forcecraft.recipe.TransmutationRecipe;
import com.mrbysco.forcecraft.recipe.TransmutationRecipe.Serializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ForceRecipeSerializers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Reference.MOD_ID);

	public static final Supplier<InfuseRecipe.Serializer> INFUSER_SERIALIZER = RECIPE_SERIALIZERS.register("infuser", InfuseRecipe.Serializer::new);
	public static final Supplier<TransmutationRecipe.Serializer> TRANSMUTATION_SERIALIZER = RECIPE_SERIALIZERS.register("transmutation", Serializer::new);
	public static final Supplier<ShapedNoRemainderRecipe.Serializer> SHAPED_NO_REMAINDER_SERIALIZER = RECIPE_SERIALIZERS.register("shaped_no_remainder", ShapedNoRemainderRecipe.Serializer::new);
	public static final Supplier<FreezingRecipe.Serializer> FREEZING_SERIALIZER = RECIPE_SERIALIZERS.register("freezing", FreezingRecipe.Serializer::new);
	public static final Supplier<GrindingRecipe.Serializer> GRINDING_SERIALIZER = RECIPE_SERIALIZERS.register("grinding", GrindingRecipe.Serializer::new);
}
