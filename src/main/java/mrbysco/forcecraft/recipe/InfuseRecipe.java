package mrbysco.forcecraft.recipe;

import com.google.gson.JsonObject;
import mrbysco.forcecraft.ForceCraft;
import mrbysco.forcecraft.blocks.infuser.InfuserModifierType;
import mrbysco.forcecraft.blocks.infuser.InfuserTileEntity;
import mrbysco.forcecraft.items.infuser.UpgradeBookTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InfuseRecipe implements IRecipe<InfuserTileEntity> {

	private static final int MAX_SLOTS = 8;
	private static final Set<String> HASHES = new HashSet<>();
	public static final Set<InfuseRecipe> RECIPES = new HashSet<>();
	public static final Map<Integer, List<InfuseRecipe>> RECIPESBYLEVEL = new HashMap<>();
	private final ResourceLocation id;
	public Ingredient input = Ingredient.EMPTY;
	public InfuserModifierType modifier;
	ItemStack resultStack = ItemStack.EMPTY; // unused!!!! for now
	public UpgradeBookTier tier;

	public InfuseRecipe(ResourceLocation id, Ingredient input, InfuserModifierType result, UpgradeBookTier tier, ItemStack itemStack) {
		super();
		this.id = id;
		this.input = input;
		resultStack = itemStack;
		modifier = result; 
		this.tier = tier;
	}

	@Override
	public boolean matches(InfuserTileEntity inv, World worldIn) {
		for(int i = 0; i < inv.handler.getSlots(); i++) {
			ItemStack stack = inv.handler.getStackInSlot(i);
			if (input.test(stack)) {
				//at least one is true
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canFit(int width, int height) {
		return height == 1 && width < MAX_SLOTS;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// output is the center of the infuser but modified, so this is unused
		return resultStack; // unused ? for now
	}

	@Override
	public ItemStack getCraftingResult(InfuserTileEntity inv) {
		return getRecipeOutput();
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public IRecipeType<?> getType() {
		return ForceRecipes.INFUSER_TYPE;
	}
	public Ingredient getInput() {
		return input;
	}

	public void setInput(Ingredient input) {
		this.input = input;
	}

	public InfuserModifierType getModifier() {
		return modifier;
	}

	public void setModifier(InfuserModifierType modifier) {
		this.modifier = modifier;
	}

	public UpgradeBookTier getTier() {
		return tier;
	}

	public void setTier(UpgradeBookTier tier) {
		this.tier = tier;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return ForceRecipes.INFUSER_SERIALIZER.get();
	}

	public static class SerializeInfuserRecipe extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<InfuseRecipe> {

		@Override
		public InfuseRecipe read(ResourceLocation recipeId, JsonObject json) {
			InfuseRecipe recipe = null;
			try {
				Ingredient ingredient = Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));

				String result = JSONUtils.getString(json, "result");

				// hardcoded mod id: no api support rip
				InfuserModifierType type = InfuserModifierType.valueOf(result.replace("forcecraft:","").toUpperCase());
				int tier = JSONUtils.getInt(json, "tier");
				
				recipe = new InfuseRecipe(recipeId, ingredient, type, UpgradeBookTier.values()[tier], ItemStack.EMPTY);
				addRecipe(recipe);
				return recipe;
			} catch (Exception e) {
				ForceCraft.LOGGER.error("Error loading recipe " + recipeId, e);
				return null;
			}
		}

		@Override
		public InfuseRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {

			Ingredient ing = Ingredient.read(buffer);
			int enumlon = buffer.readVarInt();
			int tier = buffer.readInt();
			
			InfuseRecipe r = new InfuseRecipe(recipeId, ing, InfuserModifierType.values()[enumlon],  UpgradeBookTier.values()[tier],buffer.readItemStack());

			// server reading recipe from client or vice/versa
			addRecipe(r);
			return r;
		}

		@Override
		public void write(PacketBuffer buffer, InfuseRecipe recipe) {

			recipe.input.write(buffer);
			buffer.writeVarInt(recipe.modifier.ordinal());
			buffer.writeInt(recipe.tier.ordinal());
			buffer.writeItemStack(recipe.getRecipeOutput());
		}
	}

	public static boolean addRecipe(InfuseRecipe recipe) {
		ResourceLocation id = recipe.getId();
		if (HASHES.contains(id.toString())) {
			return false;
		}
		RECIPES.add(recipe);
		int thisTier = recipe.tier.ordinal();
		if(!RECIPESBYLEVEL.containsKey(thisTier)) {
			RECIPESBYLEVEL.put(thisTier, new ArrayList<>());
		}
		RECIPESBYLEVEL.get(thisTier).add(recipe);
		HASHES.add(id.toString());
		ForceCraft.LOGGER.info("Recipe loaded {} -> {} , {}" , id.toString(), recipe.modifier, recipe.input.serialize());
		return true;
	}

}
