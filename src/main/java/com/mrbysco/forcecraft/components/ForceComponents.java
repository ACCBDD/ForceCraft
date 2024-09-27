package com.mrbysco.forcecraft.components;

import com.mojang.serialization.Codec;
import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.components.card.RecipeContentsData;
import com.mrbysco.forcecraft.components.flask.FlaskContent;
import com.mrbysco.forcecraft.components.forcewrench.ForceWrenchData;
import com.mrbysco.forcecraft.items.infuser.UpgradeBookData;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.UUID;
import java.util.function.Supplier;

public class ForceComponents {
	public static final DeferredRegister<DataComponentType<?>> COMPONENT_TYPE = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Reference.MOD_ID);

	/**
	 * Modifier: Speed
	 * Item: Sugar
	 * Levels: 5
	 * Effect: Gives Player Haste [Level] when holding the tool
	 */
	public static final Supplier<DataComponentType<Integer>> TOOL_SPEED = COMPONENT_TYPE.register("tool_speed", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.intRange(1, 5))
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier Heat
	 * Item: Golden Power Source
	 * Levels: 1
	 * Effect: Auto-Smelt Item drops
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_HEAT = COMPONENT_TYPE.register("tool_heat", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Force
	 * Item: Force Nugget
	 * Levels: 3
	 * Effect: Gives the Sword Knockback
	 */
	public static final Supplier<DataComponentType<Integer>> TOOL_FORCE = COMPONENT_TYPE.register("tool_force", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.POSITIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier Silk
	 * Item: Web
	 * Levels: 1
	 * Effect: Give Pick/Shovel/Axe Silk Touch
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_SILK = COMPONENT_TYPE.register("tool_silk", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Sharpness
	 * Item: Claw
	 * Levels: 10
	 * Effect: Adds Sharpness to Force Sword
	 */
	public static final Supplier<DataComponentType<Integer>> TOOL_SHARPNESS = COMPONENT_TYPE.register("tool_sharpness", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.POSITIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier: Luck
	 * Item: Fortune
	 * Levels: 5
	 * Effect: Adds Fortune to a tool or Looting to a sword
	 */
	public static final Supplier<DataComponentType<Integer>> TOOL_LUCK = COMPONENT_TYPE.register("tool_luck", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.intRange(1, 5))
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier: Sturdy
	 * Item: Bricks/Obsidian
	 * Levels: 3 (tools) 1 (armor)
	 * Effect: Adds 1 Level of Unbreaking to tool up to 10
	 */
	public static final Supplier<DataComponentType<Integer>> TOOL_STURDY = COMPONENT_TYPE.register("tool_sturdy", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.intRange(1, 3))
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier: Rainbow
	 * Items: Lapis Lazuli
	 * Levels: 1
	 * Effect: Makes sheep drop a random amount of colored wool
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_RAINBOW = COMPONENT_TYPE.register("tool_rainbow", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Lumberjack
	 * Items: Force Log
	 * Levels: 1
	 * Effect: Allows an axe to chop an entire tree down
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_LUMBERJACK = COMPONENT_TYPE.register("tool_lumberjack", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Bleeding
	 * Items: Arrow
	 * Levels: 2
	 * Effect: Applies Bleeding Potion Effect
	 */
	public static final Supplier<DataComponentType<Integer>> TOOL_BLEED = COMPONENT_TYPE.register("tool_bleed", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.POSITIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier: Bane
	 * Items: Spider Eye
	 * Levels: 4
	 * Effect: Applies Bane Potion Effect
	 */
	public static final Supplier<DataComponentType<Integer>> TOOL_BANE = COMPONENT_TYPE.register("tool_bane", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.intRange(1, 4))
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier: Wing
	 * Items: Feathers
	 * Levels: 1
	 * Effect: If full armor set is equipped, player can fly
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_WING = COMPONENT_TYPE.register("tool_wing", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Camo
	 * Items: Invisibility Potion
	 * Levels: 1
	 * Effect: Gives Invisibility to wearer/user
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_CAMO = COMPONENT_TYPE.register("tool_camo", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Sight
	 * Items: Night Vision Potion
	 * Levels: 1
	 * Effect: Gives Night Vision
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_SIGHT = COMPONENT_TYPE.register("tool_sight", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Light
	 * Items: Glowstone Dust
	 * Levels: 1
	 * Effect: Shows mobs through walls
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_LIGHT = COMPONENT_TYPE.register("tool_light", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Ender
	 * Items: Ender Pearl / Eye of Ender
	 * Levels: 1
	 * Effect: Teleports target to random location
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_ENDER = COMPONENT_TYPE.register("tool_ender", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Freezing
	 * Items: Snow Cookie
	 * Levels: 1
	 * Effect: Gives Slowness to enemy
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_FREEZING = COMPONENT_TYPE.register("tool_freezing", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	/**
	 * Modifier: Treasure
	 * Items: Treasure Core
	 * Levels: 1
	 * Effect: Allows treasure cards to drop upon killing mobs
	 */
	public static final Supplier<DataComponentType<Boolean>> TOOL_TREASURE = COMPONENT_TYPE.register("tool_treasure", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());

	public static final Supplier<DataComponentType<Boolean>> MAGNET = COMPONENT_TYPE.register("magnet", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());

	public static final Supplier<DataComponentType<Integer>> FORCE = COMPONENT_TYPE.register("force", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.POSITIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	public static final Supplier<DataComponentType<Integer>> TOME_EXPERIENCE = COMPONENT_TYPE.register("tome_experience", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.NON_NEGATIVE_INT)
					.networkSynchronized(ByteBufCodecs.INT)
					.build());
	public static final Supplier<DataComponentType<ForceWrenchData>> WRENCH = COMPONENT_TYPE.register("wrench", () ->
			DataComponentType.<ForceWrenchData>builder()
					.persistent(ForceWrenchData.CODEC)
					.networkSynchronized(ForceWrenchData.STREAM_CODEC)
					.build());
	/**
	 * Modifier: Healing
	 * Items: Ghast Tear
	 * Levels: 3
	 * Effect: Allows the Force Rod to give Healing depending on the level set
	 */
	public static final Supplier<DataComponentType<Integer>> ROD_HEALING = COMPONENT_TYPE.register("rod_healing", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.POSITIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier: Speed
	 * Levels: 3
	 * Effect: when using the rod give speed to player
	 */
	public static final Supplier<DataComponentType<Integer>> ROD_SPEED = COMPONENT_TYPE.register("rod_speed", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.intRange(1, 3))
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	/**
	 * Modifier: Light
	 * Items: Glowstone Dust
	 * Levels: 1
	 * Effect: Shows mobs through walls
	 */
	public static final Supplier<DataComponentType<Boolean>> ROD_LIGHT = COMPONENT_TYPE.register("rod_light", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	public static final Supplier<DataComponentType<Boolean>> ROD_CAMO = COMPONENT_TYPE.register("rod_camo", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	public static final Supplier<DataComponentType<Boolean>> ROD_ENDER = COMPONENT_TYPE.register("rod_ender", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	public static final Supplier<DataComponentType<Boolean>> ROD_SIGHT = COMPONENT_TYPE.register("rod_sight", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());
	public static final Supplier<DataComponentType<GlobalPos>> ROD_POS = COMPONENT_TYPE.register("rod_position", () ->
			DataComponentType.<GlobalPos>builder()
					.persistent(GlobalPos.CODEC)
					.networkSynchronized(GlobalPos.STREAM_CODEC)
					.build());


	public static final Supplier<DataComponentType<Integer>> PACK_COLOR = COMPONENT_TYPE.register("pack_color", () ->
			DataComponentType.<Integer>builder()
					.persistent(Codec.INT)
					.networkSynchronized(ByteBufCodecs.INT)
					.build());


	public static final Supplier<DataComponentType<Boolean>> FORCE_INFUSED = COMPONENT_TYPE.register("infused", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());

	public static final Supplier<DataComponentType<Boolean>> SPOILS_FILLED = COMPONENT_TYPE.register("spoils_filled", () ->
			DataComponentType.<Boolean>builder()
					.persistent(Codec.BOOL)
					.networkSynchronized(ByteBufCodecs.BOOL)
					.build());

	public static final Supplier<DataComponentType<String>> MESSAGE = COMPONENT_TYPE.register("message", () ->
			DataComponentType.<String>builder()
					.persistent(Codec.STRING)
					.networkSynchronized(ByteBufCodecs.STRING_UTF8)
					.build());

	public static final Supplier<DataComponentType<RecipeContentsData>> RECIPE_CONTENTS = COMPONENT_TYPE.register("recipe_contents", () ->
			DataComponentType.<RecipeContentsData>builder()
					.persistent(RecipeContentsData.CODEC)
					.networkSynchronized(RecipeContentsData.STREAM_CODEC)
					.build());

	public static final Supplier<DataComponentType<ItemContainerContents>> STORED_FOOD = COMPONENT_TYPE.register("stored_food", () ->
			DataComponentType.<ItemContainerContents>builder()
					.persistent(ItemContainerContents.CODEC)
					.networkSynchronized(ItemContainerContents.STREAM_CODEC)
					.build());
	public static final Supplier<DataComponentType<ItemContainerContents>> SPOILS_CONTENT = COMPONENT_TYPE.register("spoils_content", () ->
			DataComponentType.<ItemContainerContents>builder()
					.persistent(ItemContainerContents.CODEC)
					.networkSynchronized(ItemContainerContents.STREAM_CODEC)
					.build());

	public static final Supplier<DataComponentType<Integer>> SLOTS_USED = COMPONENT_TYPE.register("slots_used", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.NON_NEGATIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	public static final Supplier<DataComponentType<Integer>> SLOTS_TOTAL = COMPONENT_TYPE.register("slots_total", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.POSITIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	public static final Supplier<DataComponentType<Integer>> PACK_TIER = COMPONENT_TYPE.register("pack_tier", () ->
			DataComponentType.<Integer>builder()
					.persistent(ExtraCodecs.NON_NEGATIVE_INT)
					.networkSynchronized(ByteBufCodecs.VAR_INT)
					.build());
	public static final Supplier<DataComponentType<UUID>> UUID = COMPONENT_TYPE.register("uuid", () ->
			DataComponentType.<UUID>builder()
					.persistent(UUIDUtil.CODEC)
					.networkSynchronized(UUIDUtil.STREAM_CODEC)
					.build());
	public static final Supplier<DataComponentType<UpgradeBookData>> UPGRADE_BOOK = COMPONENT_TYPE.register("upgrade_book", () ->
			DataComponentType.<UpgradeBookData>builder()
					.persistent(UpgradeBookData.CODEC)
					.networkSynchronized(UpgradeBookData.STREAM_CODEC)
					.build());

	public static final Supplier<DataComponentType<FlaskContent>> FLASK_CONTENT = COMPONENT_TYPE.register("flask_content", () ->
			DataComponentType.<FlaskContent>builder()
					.persistent(FlaskContent.CODEC)
					.networkSynchronized(FlaskContent.STREAM_CODEC)
					.build());
	public static final Supplier<DataComponentType<SimpleFluidContent>> FLASK_FLUID = COMPONENT_TYPE.register("flask_fluid", () ->
			DataComponentType.<SimpleFluidContent>builder()
					.persistent(SimpleFluidContent.CODEC)
					.networkSynchronized(SimpleFluidContent.STREAM_CODEC)
					.build());
	public static final Supplier<DataComponentType<ItemStack>> FURNACE_UPGRADE = COMPONENT_TYPE.register("furnace_upgrade", () ->
			DataComponentType.<ItemStack>builder()
					.persistent(ItemStack.CODEC)
					.networkSynchronized(ItemStack.STREAM_CODEC)
					.build());
}
