package com.mrbysco.forcecraft.datagen.assets;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.registry.ForceEffects;
import com.mrbysco.forcecraft.registry.ForceEntities;
import com.mrbysco.forcecraft.registry.ForceRegistry;
import com.mrbysco.forcecraft.registry.ForceSounds;
import com.mrbysco.forcecraft.registry.ForceTags;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

public class ForceLanguageProvider extends LanguageProvider {
	public ForceLanguageProvider(PackOutput packOutput) {
		super(packOutput, Reference.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		//Creative Tab
		add("itemGroup.forcecraft", "Forcecraft");

		//Items
		addItem(ForceRegistry.FORCE_INGOT, "Force Ingot");
		addItem(ForceRegistry.FORCE_GEM, "Force Gem");
		addItem(ForceRegistry.FORCE_NUGGET, "Force Nugget");
		addItem(ForceRegistry.FORCE_STICK, "Force Stick");
		addItem(ForceRegistry.FORTUNE_COOKIE, "Fortune Cookie");
		addItem(ForceRegistry.SOUL_WAFER, "Soul Wafer");
		addItem(ForceRegistry.RAW_BACON, "Raw Bacon");
		addItem(ForceRegistry.COOKED_BACON, "Cooked Bacon");
		addItem(ForceRegistry.GOLDEN_POWER_SOURCE, "Golden Power Source");
		addItem(ForceRegistry.FORTUNE, "Fortune");
		addItem(ForceRegistry.EXPERIENCE_TOME, "Experience Tome");
		addItem(ForceRegistry.UPGRADE_TOME, "Upgrade Tome");
		addItem(ForceRegistry.CLAW, "Claw");
		addItem(ForceRegistry.FORCE_GEAR, "Force Gear");
		addItem(ForceRegistry.SNOW_COOKIE, "Snow Cookie");
		addItem(ForceRegistry.FORCE_PACK, "Force Pack");
		addItem(ForceRegistry.FORCE_PACK_UPGRADE, "Force Pack Upgrade");
		addItem(ForceRegistry.FORCE_BELT, "Force Belt");
		addItem(ForceRegistry.BOTTLED_WITHER, "Bottled Wither");
		addItem(ForceRegistry.INERT_CORE, "Inert Core");
		addItem(ForceRegistry.BUCKET_FLUID_FORCE, "Force Bucket");
		addItem(ForceRegistry.BACONATOR, "Baconator");
		addItem(ForceRegistry.SPOILS_BAG, "Spoils Bag");
		addItem(ForceRegistry.SPOILS_BAG_T2, "Spoils Bag");
		addItem(ForceRegistry.SPOILS_BAG_T3, "Spoils Bag");
		addItem(ForceRegistry.LIFE_CARD, "Life Card");
		addItem(ForceRegistry.DARKNESS_CARD, "Darkness Card");
		addItem(ForceRegistry.UNDEATH_CARD, "Undeath Card");
		addItem(ForceRegistry.TREASURE_CORE, "Treasure Core");
		addItem(ForceRegistry.FORCE_ARROW, "Force Arrow");
		addItem(ForceRegistry.UPGRADE_CORE, "Upgrade Core");
		addItem(ForceRegistry.EXPERIENCE_CORE, "Experience Core");
		addItem(ForceRegistry.FREEZING_CORE, "Freezing Core");
		addItem(ForceRegistry.GRINDING_CORE, "Grinding Core");
		addItem(ForceRegistry.HEAT_CORE, "Heat Core");
		addItem(ForceRegistry.SPEED_CORE, "Speed Core");
		addItem(ForceRegistry.RECOVERY_HEART, "Recovery Heart");
		addItem(ForceRegistry.FORCE_FLASK, "Force Flask");
		addItem(ForceRegistry.MILK_FORCE_FLASK, "Milk Force Flask");
		addItem(ForceRegistry.FORCE_FILLED_FORCE_FLASK, "Liquid Force Force Flask");
		addItem(ForceRegistry.ENTITY_FLASK, "%s Flask");
		addItem(ForceRegistry.BAT_FLASK, "Bat Flask");
		addItem(ForceRegistry.BEE_FLASK, "Bee Flask");
		addItem(ForceRegistry.CAT_FLASK, "Cat Flask");
		addItem(ForceRegistry.CAVE_SPIDER_FLASK, "Cave Spider Flask");
		addItem(ForceRegistry.CHICKEN_FLASK, "Chicken Flask");
		addItem(ForceRegistry.COD_FLASK, "Cod Flask");
		addItem(ForceRegistry.COW_FLASK, "Cow Flask");
		addItem(ForceRegistry.DOLPHIN_FLASK, "Dolphin Flask");
		addItem(ForceRegistry.DONKEY_FLASK, "Donkey Flask");
		addItem(ForceRegistry.ENDERMAN_FLASK, "Enderman Flask");
		addItem(ForceRegistry.FOX_FLASK, "Fox Flask");
		addItem(ForceRegistry.HORSE_FLASK, "Horse Flask");
		addItem(ForceRegistry.IRON_GOLEM_FLASK, "Iron Golem Flask");
		addItem(ForceRegistry.LLAMA_FLASK, "Llama Flask");
		addItem(ForceRegistry.MOOSHROOM_FLASK, "Mooshroom Flask");
		addItem(ForceRegistry.MULE_FLASK, "Mule Flask");
		addItem(ForceRegistry.PANDA_FLASK, "Panda Flask");
		addItem(ForceRegistry.PARROT_FLASK, "Parrot Flask");
		addItem(ForceRegistry.PIG_FLASK, "Pig Flask");
		addItem(ForceRegistry.PIGLIN_FLASK, "Piglin Flask");
		addItem(ForceRegistry.POLAR_BEAR_FLASK, "Polar Bear Flask");
		addItem(ForceRegistry.PUFFERFISH_FLASK, "Pufferfish Flask");
		addItem(ForceRegistry.RABBIT_FLASK, "Rabbit Flask");
		addItem(ForceRegistry.SALMON_FLASK, "Salmon Flask");
		addItem(ForceRegistry.SHEEP_FLASK, "Sheep Flask");
		addItem(ForceRegistry.SKELETON_FLASK, "Skeleton Flask");
		addItem(ForceRegistry.SNOW_GOLEM_FLASK, "Snow Golem Flask");
		addItem(ForceRegistry.SPIDER_FLASK, "Spider Flask");
		addItem(ForceRegistry.SQUID_FLASK, "Squid Flask");
		addItem(ForceRegistry.STRIDER_FLASK, "Strider Flask");
		addItem(ForceRegistry.TROPICAL_FISH_FLASK, "Tropical Fish Flask");
		addItem(ForceRegistry.TURTLE_FLASK, "Turtle Flask");
		addItem(ForceRegistry.VILLAGER_FLASK, "Villager Flask");
		addItem(ForceRegistry.WANDERING_TRADER_FLASK, "Wandering Trader Flask");
		addItem(ForceRegistry.WOLF_FLASK, "Wolf Flask");
		addItem(ForceRegistry.ZOMBIFIED_PIGLIN_FLASK, "Zombified Piglin Flask");
		addItem(ForceRegistry.RED_POTION, "Red Potion");
		addItem(ForceRegistry.RED_CHU_JELLY, "Red Chu Jelly");
		addItem(ForceRegistry.GREEN_CHU_JELLY, "Green Chu Jelly");
		addItem(ForceRegistry.BLUE_CHU_JELLY, "Blue Chu Jelly");
		addItem(ForceRegistry.GOLD_CHU_JELLY, "Gold Chu Jelly");
		addItem(ForceRegistry.PILE_OF_GUNPOWDER, "Small Pile of Gunpowder");
		addItem(ForceRegistry.ITEM_CARD, "Item Card");

		//Armor
		addItem(ForceRegistry.FORCE_HELMET, "Force Cap");
		addItem(ForceRegistry.FORCE_CHEST, "Force Tunic");
		addItem(ForceRegistry.FORCE_LEGS, "Force Kilt");
		addItem(ForceRegistry.FORCE_BOOTS, "Force Boots");

		//Tools
		addItem(ForceRegistry.FORCE_PICKAXE, "Force Pickaxe");
		addItem(ForceRegistry.FORCE_AXE, "Force Axe");
		addItem(ForceRegistry.FORCE_SWORD, "Force Sword");
		addItem(ForceRegistry.FORCE_SHOVEL, "Force Shovel");
		addItem(ForceRegistry.FORCE_WRENCH, "Force Wrench");
		addItem(ForceRegistry.FORCE_ROD, "Force Rod");
		addItem(ForceRegistry.FORCE_SHEARS, "Force Shears");
		addItem(ForceRegistry.FORCE_BOW, "Force Bow");
		addItem(ForceRegistry.MAGNET_GLOVE, "Magnet Glove");
		addItem(ForceRegistry.FORCE_MITT, "Force Mitts");

		//Spawn eggs
		addItem(ForceRegistry.RED_CHU_CHU_SPAWN_EGG, "Red Chu Chu Spawn Egg");
		addItem(ForceRegistry.GREEN_CHU_CHU_SPAWN_EGG, "Green Chu Chu Spawn Egg");
		addItem(ForceRegistry.BLUE_CHU_CHU_SPAWN_EGG, "Blue Chu Chu Spawn Egg");
		addItem(ForceRegistry.GOLD_CHU_CHU_SPAWN_EGG, "Gold Chu Chu Spawn Egg");
		addItem(ForceRegistry.COLD_CHICKEN_SPAWN_EGG, "Cold Chicken Spawn Egg");
		addItem(ForceRegistry.COLD_COW_SPAWN_EGG, "Cold Cow Spawn Egg");
		addItem(ForceRegistry.COLD_PIG_SPAWN_EGG, "Cold Pig Spawn Egg");
		addItem(ForceRegistry.FAIRY_SPAWN_EGG, "Fairy Spawn Egg");
		addItem(ForceRegistry.CREEPER_TOT_SPAWN_EGG, "Creeper Tot Spawn Egg");
		addItem(ForceRegistry.ENDER_TOT_SPAWN_EGG, "Ender Tot Spawn Egg");
		addItem(ForceRegistry.ANGRY_ENDERMAN_SPAWN_EGG, "Angry Enderman Spawn Egg");

		//Item tooltips
		add("item.forcecraft.upgrade_tome.tt.tier", "Tier:");
		add("item.forcecraft.upgrade_tome.tt.max", "Mastered!");
		add("item.forcecraft.upgrade_tome.tt.owner", "Owner:");
		add("item.forcecraft.upgrade_tome.tt.points", "Force Points:");
		add("item.forcecraft.upgrade_tome.tt.point_info", "You get Force Points for applying infusions");
		add("item.forcecraft.upgrade_tome.tt.nexttier", "Next Tier:");

		//Blocks
		addBlock(ForceRegistry.POWER_ORE, "Power Ore");
		addBlock(ForceRegistry.DEEPSLATE_POWER_ORE, "Deepslate Power Ore");
		addBlock(ForceRegistry.FORCE_SAPLING, "Force Sapling");
		addBlock(ForceRegistry.FORCE_LOG, "Force Log");
		addBlock(ForceRegistry.FORCE_WOOD, "Force Wood");
		addBlock(ForceRegistry.FORCE_LEAVES, "Force Leaves");
		addBlock(ForceRegistry.INFUSER, "Force Infuser");
		addBlock(ForceRegistry.FORCE_FURNACE, "Yellow Force Furnace");
		addBlock(ForceRegistry.BLACK_FORCE_FURNACE, "Black Force Furnace");
		addBlock(ForceRegistry.BLUE_FORCE_FURNACE, "Blue Force Furnace");
		addBlock(ForceRegistry.BROWN_FORCE_FURNACE, "Brown Force Furnace");
		addBlock(ForceRegistry.CYAN_FORCE_FURNACE, "Cyan Force Furnace");
		addBlock(ForceRegistry.GRAY_FORCE_FURNACE, "Gray Force Furnace");
		addBlock(ForceRegistry.GREEN_FORCE_FURNACE, "Green Force Furnace");
		addBlock(ForceRegistry.LIGHT_BLUE_FORCE_FURNACE, "Light Blue Force Furnace");
		addBlock(ForceRegistry.LIGHT_GRAY_FORCE_FURNACE, "Light Gray Force Furnace");
		addBlock(ForceRegistry.LIME_FORCE_FURNACE, "Lime Force Furnace");
		addBlock(ForceRegistry.MAGENTA_FORCE_FURNACE, "Magenta Force Furnace");
		addBlock(ForceRegistry.ORANGE_FORCE_FURNACE, "Orange Force Furnace");
		addBlock(ForceRegistry.PINK_FORCE_FURNACE, "Pink Force Furnace");
		addBlock(ForceRegistry.PURPLE_FORCE_FURNACE, "Purple Force Furnace");
		addBlock(ForceRegistry.RED_FORCE_FURNACE, "Red Force Furnace");
		addBlock(ForceRegistry.WHITE_FORCE_FURNACE, "White Force Furnace");
		addBlock(ForceRegistry.FORCE_ENGINE, "Force Engine");
		addBlock(ForceRegistry.FORCE_PLANKS, "Force Planks");
		addBlock(ForceRegistry.FORCE_PLANK_STAIRS, "Force Plank Stairs");
		addBlock(ForceRegistry.FORCE_PLANK_SLAB, "Force Plank Slab");
		addBlock(ForceRegistry.FORCE_BRICK_BLACK, "Black Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_BLUE, "Blue Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_BROWN, "Brown Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_CYAN, "Cyan Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_GRAY, "Gray Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_GREEN, "Green Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_LIGHT_BLUE, "Light Blue Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_LIGHT_GRAY, "Light Gray Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_LIME, "Lime Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_MAGENTA, "Magenta Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_ORANGE, "Orange Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_PINK, "Pink Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_PURPLE, "Purple Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_RED, "Red Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_WHITE, "White Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_YELLOW, "Yellow Force Brick");
		addBlock(ForceRegistry.FORCE_BRICK_RED_STAIRS, "Red Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_YELLOW_STAIRS, "Yellow Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_GREEN_STAIRS, "Green Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_BLUE_STAIRS, "Blue Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_WHITE_STAIRS, "White Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_BLACK_STAIRS, "Black Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_BROWN_STAIRS, "Brown Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_ORANGE_STAIRS, "Orange Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_LIGHT_BLUE_STAIRS, "Light Blue Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_MAGENTA_STAIRS, "Magenta Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_PINK_STAIRS, "Pink Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_LIGHT_GRAY_STAIRS, "Light Gray Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_LIME_STAIRS, "Lime Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_CYAN_STAIRS, "Cyan Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_PURPLE_STAIRS, "Purple Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_GRAY_STAIRS, "Gray Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_STAIRS, "Force Brick Stairs");
		addBlock(ForceRegistry.FORCE_BRICK_RED_SLAB, "Red Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_YELLOW_SLAB, "Yellow Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_GREEN_SLAB, "Green Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_BLUE_SLAB, "Blue Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_WHITE_SLAB, "White Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_BLACK_SLAB, "Black Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_BROWN_SLAB, "Brown Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_ORANGE_SLAB, "Orange Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_LIGHT_BLUE_SLAB, "Light Blue Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_MAGENTA_SLAB, "Magenta Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_PINK_SLAB, "Pink Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_LIGHT_GRAY_SLAB, "Light Gray Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_LIME_SLAB, "Lime Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_CYAN_SLAB, "Cyan Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_PURPLE_SLAB, "Purple Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_GRAY_SLAB, "Gray Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK_SLAB, "Force Brick Slab");
		addBlock(ForceRegistry.FORCE_BRICK, "Force Brick");
		addBlock(ForceRegistry.TIME_TORCH, "§bTime Torch");
		addBlock(ForceRegistry.FORCE_TORCH, "Force Torch");
		addBlock(ForceRegistry.FORCE_RED_TORCH, "Red Force Torch");
		addBlock(ForceRegistry.FORCE_ORANGE_TORCH, "Orange Force Torch");
		addBlock(ForceRegistry.FORCE_GREEN_TORCH, "Green Force Torch");
		addBlock(ForceRegistry.FORCE_BLUE_TORCH, "Blue Force Torch");
		addBlock(ForceRegistry.FORCE_WHITE_TORCH, "White Force Torch");
		addBlock(ForceRegistry.FORCE_BLACK_TORCH, "Black Force Torch");
		addBlock(ForceRegistry.FORCE_BROWN_TORCH, "Brown Force Torch");
		addBlock(ForceRegistry.FORCE_LIGHT_BLUE_TORCH, "Light Blue Force Torch");
		addBlock(ForceRegistry.FORCE_MAGENTA_TORCH, "Magenta Force Torch");
		addBlock(ForceRegistry.FORCE_PINK_TORCH, "Pink Force Torch");
		addBlock(ForceRegistry.FORCE_LIGHT_GRAY_TORCH, "Light Gray Force Torch");
		addBlock(ForceRegistry.FORCE_LIME_TORCH, "Lime Force Torch");
		addBlock(ForceRegistry.FORCE_CYAN_TORCH, "Cyan Force Torch");
		addBlock(ForceRegistry.FORCE_PURPLE_TORCH, "Purple Force Torch");
		addBlock(ForceRegistry.FORCE_GRAY_TORCH, "Gray Force Torch");

		//Entities
		addEntityType(ForceEntities.COLD_CHICKEN, "Cold Chicken");
		addEntityType(ForceEntities.COLD_COW, "Cold Cow");
		addEntityType(ForceEntities.COLD_PIG, "Cold Pig");
		addEntityType(ForceEntities.RED_CHU_CHU, "Red Chu Chu");
		addEntityType(ForceEntities.GREEN_CHU_CHU, "Green Chu Chu");
		addEntityType(ForceEntities.BLUE_CHU_CHU, "Blue Chu Chu");
		addEntityType(ForceEntities.GOLD_CHU_CHU, "Gold Chu Chu");
		addEntityType(ForceEntities.FAIRY, "Fairy");
		addEntityType(ForceEntities.CREEPER_TOT, "Creeper Tot");
		addEntityType(ForceEntities.ENDER_TOT, "Ender Tot");
		addEntityType(ForceEntities.ANGRY_ENDERMAN, "Angry Enderman");

		//Subtitles
		addSubtitle(ForceSounds.WHOOSH, "Whooshing");
		addSubtitle(ForceSounds.FAIRY_PICKUP, "Fairy being absorbed");
		addSubtitle(ForceSounds.FAIRY_LISTEN, "Fairy yelling");
		addSubtitle(ForceSounds.FAIRY_LISTEN_SPECIAL, "Fairy wishing a happy birthday");
		addSubtitle(ForceSounds.INFUSER_DONE, "Infuser Completes");
		addSubtitle(ForceSounds.INFUSER_WORKING, "Infuser Processing");
		addSubtitle(ForceSounds.INFUSER_SPECIAL_BEEP, "Infuser Beeps");
		addSubtitle(ForceSounds.INFUSER_SPECIAL_DONE, "Infuser Completes");
		addSubtitle(ForceSounds.INFUSER_SPECIAL, "Infuser Humming");
		addSubtitle(ForceSounds.HEART_PICKUP, "Heart Pickup");
		addSubtitle(ForceSounds.FORCE_PUNCH, "Force Punched");

		//Effects
		addEffect(ForceEffects.BLEEDING, "Bleeding");
		addEffect(ForceEffects.MAGNET, "Magnet");
		addEffect(ForceEffects.SHAKING, "Shaking");

		//Damage
		add("death.attack.forcecraft.bleeding", "%1$s bled to death");
		add("death.attack.forcecraft.bleeding.player", "%1$s bled to death whilst trying to escape %2$s");
		add("death.attack.forcecraft.liquid_force", "%1$s was forced not to exist");
		add("death.attack.forcecraft.liquid_force.player", "%1$s was forced not to exist whilst trying to escape %2$s");

		//UI
		add("forcecraft.gui.guide_book", "Book of Mudora");
		add("forcecraft.container.belt", "Force Belt");
		add("forcecraft.container.pack", "Force Pack");
		add("forcecraft.container.force_furnace", "Force Furnace");
		add("forcecraft.container.spoils_bag", "Spoils Bag");
		add("forcecraft.container.card", "Item Card");
		add("forcecraft.container.force_engine", "Force Engine");

		//Fluid
		add("fluid.forcecraft.fluid_force_source", "Liquid Force");
		add("fluid_type.forcecraft.force", "Liquid Force");

		//Tags
		addTag(() -> ForceTags.INCORRECT_FOR_FORCE, "Incorrect for Force");
		addTag(() -> ForceTags.MINEABLE_WITH_MITTS, "Mineable with Mitts");
		addTag(() -> ForceTags.FORCE_BRICKS, "Force Bricks");

		addTag(() -> ForceTags.VALID_INFUSER_MODIFIERS, "Valid Infuser Modifiers");
		addTag(() -> ForceTags.VALID_INFUSER_TOOLS, "Valid Infuser Tools");
		addTag(() -> ForceTags.VALID_INFUSER_CHARGE, "Valid Infuser Charge");
		addTag(() -> ForceTags.TOOLS, "Tools");
		addTag(() -> ForceTags.FORCE_FUELS, "Force Fuels");
		addTag(() -> ForceTags.BACONATOR_FOOD, "Baconator Food");
		addTag(() -> ForceTags.FORTUNE, "Fortune");
		addTag(() -> ForceTags.VALID_FORCE_BELT, "Valid Force Belt");
		addTag(() -> ForceTags.VALID_BANE_TOOLS, "Valid Bane Tools");
		addTag(() -> ForceTags.VALID_HEALING_TOOLS, "Valid Healing Tools");
		addTag(() -> ForceTags.VALID_WING_TOOLS, "Valid Wing Tools");
		addTag(() -> ForceTags.VALID_STURDY_TOOLS, "Valid Sturdy Tools");
		addTag(() -> ForceTags.VALID_ENDER_TOOLS, "Valid Ender Tools");
		addTag(() -> ForceTags.VALID_LIGHT_TOOLS, "Valid Light Tools");
		addTag(() -> ForceTags.VALID_TREASURE_TOOLS, "Valid Treasure Tools");
		addTag(() -> ForceTags.VALID_BLEEDING_TOOLS, "Valid Bleeding Tools");
		addTag(() -> ForceTags.VALID_SILKY_TOOLS, "Valid Silky Tools");
		addTag(() -> ForceTags.VALID_CAMO_TOOLS, "Valid Camo Tools");
		addTag(() -> ForceTags.VALID_DAMAGE_TOOLS, "Valid Damage Tools");
		addTag(() -> ForceTags.VALID_LUCKY_TOOLS, "Valid Lucky Tools");
		addTag(() -> ForceTags.VALID_FREEZING_TOOLS, "Valid Freezing Tools");
		addTag(() -> ForceTags.VALID_HEAT_TOOLS, "Valid Heat Tools");
		addTag(() -> ForceTags.VALID_LUMBER_TOOLS, "Valid Lumber Tools");
		addTag(() -> ForceTags.VALID_SPEED_TOOLS, "Valid Speed Tools");
		addTag(() -> ForceTags.VALID_KNOCKBACK_TOOLS, "Valid Knockback Tools");
		addTag(() -> ForceTags.ENDER, "Ender");
		addTag(() -> ForceTags.FORCE_LOGS, "Force Logs");
		addTag(() -> ForceTags.ENTITY_FLASKS, "Entity Flasks");
		addTag(() -> ForceTags.CHU_JELLY, "Chu Jelly");
		addTag(() -> ForceTags.FORCE_INGOT, "Force Ingots");
		addTag(() -> ForceTags.FORCE_NUGGET, "Force Nuggets");
		addTag(() -> ForceTags.FORCE_FURNACES, "Force Furnaces");
		addTag(() -> ForceTags.FORCE_GEM, "Force Gems");
		addTag(() -> ForceTags.FORCE_ROD, "Force Rods");
		addTag(() -> ForceTags.FORCE_GEAR, "Force Gears");
		addTag(() -> ForceTags.HOLDS_ITEMS, "Holds Items");
		addTag(() -> ForceTags.FORCE, "Force");
		addTag(() -> ForceTags.MILK, "Milk");
		addTag(() -> ForceTags.FUEL, "Fuel");
		addTag(() -> ForceTags.BIOFUEL, "Bio Fuel");
		addTag(() -> ForceTags.ENDERTOT_HOLDABLE, "Endertot Holdable");
		addTag(() -> ForceTags.FLASK_BLACKLIST, "Flask Blacklist");

		//Config
		addConfig("title", "Forcecraft Config", null);
		// General settings
		addConfig("general", "General", "General Settings");
		addConfig("generateForceOre", "Generate Force Ore", "Enable Force Ore generation [Default: true]");
		addConfig("generateForceTree", "Generate Force Tree", "Enable Force Tree generation [Default: true]");
		addConfig("timeTorchEnabled", "Time Torch Enabled", "Enable Time Torch [Default: true]");
		addConfig("timeTorchLogging", "Time Torch Logging", "Print in Log when Time Torch is placed and by who [Default: true]");
		addConfig("timeTorchRate", "Time Torch Rate", "How many ticks in between ticking neighbour blocks [Default: 5]");
		addConfig("timeTorchAmount", "Time Torch Amount", "The amount of ticks the Time Torch applies to neighbour blocks [Default: 3]");
		addConfig("disableRecoveryHearts", "Disable Recovery Hearts", "Disable recovery hearts from dropping [Default: false]");
		addConfig("enableForceShake", "Enable Force Shake", "Enables screen shake when in Liquid Force [Default: false]");
		addConfig("sturdyDamageReduction", "Sturdy Damage Reduction", "The max amount of damage blocked when all armor pieces have the Sturdy infusion [Default: 0.75]");
		addConfig("forcePunchDamage", "Force Punch Damage", "The amount of half hearts of damage given by Force Punch given by the Damage infusion on armor [Default: 2]");
		addConfig("forceInfusingTime", "Force Infusing Time", "The max amount of ticks it takes to charge a tool with Force [Default: 120 (6 seconds)]");
		addConfig("furnaceOutputBlacklist", "Furnace Output Blacklist", "An additional list of tile entities the Force Furnace can NOT insert into [Syntax: modid:tile_name]\nExamples: \"minecraft:shulker_box\" would stop it inserting into shulkers");
		// Fortune messages
		addConfig("fortunes", "Fortunes", "Fortune Settings");
		addConfig("fortuneMessages", "Fortune Messages", "Adding lines / removing lines specifies what the fortunes can say");
		// Infusion settings
		addConfig("infusion", "Infusion", "Infusion Settings");
		addConfig("bleedCap", "Bleed Cap", "The max level of Bleeding that can be applied [Default: 3]");
		addConfig("healingCap", "Healing Cap", "The max level of Healing that can be applied [Default: 3]");
		addConfig("sturdyToolCap", "Sturdy Tool Cap", "The max level of Sturdy that can be applied on force tools [Default: 3]");
		addConfig("luckCap", "Luck Cap", "The max level of Luck that can be applied [Default: 4]");
		addConfig("damageCap", "Damage Cap", "The max level of Damage that can be applied [Default: 5]");
		addConfig("forceCap", "Force Cap", "The max level of Force that can be applied [Default: 2]");
		addConfig("speedCap", "Speed Cap", "The max level of Speed that can be applied [Default: 5]");
		addConfig("rodSpeedCap", "Rod Speed Cap", "The max level of Speed that can be applied to a Force Rod [Default: 3]");
		addConfig("liquidRegenLevel", "Liquid Regen Level", "The level of Regeneration given to the player when standing in Liquid Force (0 = Regeneration 1) [Default: 0]");

		//Info Text
		add("forcecraft.tooltip.press_shift", "Press Shift for Details");
		add("forcecraft.magnet_glove.active", "Activated");
		add("forcecraft.magnet_glove.deactivated", "Deactivated");
		add("forcecraft.baconator.shift.text", "Hold Shift to see the contents");
		add("forcecraft.baconator.shift.carrying", "Carrying, ");
		add("forcecraft.baconator.shift.nothing", "Nothing");
		add("forcecraft.item_card.recipe_output", "Crafts, %s");
		add("forcecraft.item_card.unset", "No Recipe Set");
		add("forcecraft.item_card.recipe_set", "Sneak Right-click to set a recipe");
		add("forcecraft.magnet_glove.change", "Sneak Right-click to change modes");
		add("forcecraft.ender_rod.text", "Shift-Right click to reset position");
		add("forcecraft.ender_rod.dimension.text", "Can't teleport to another dimension");
		add("forcecraft.ender_rod.location.set", "Ender Rod location has been changed");
		add("forcecraft.ender_rod.location", "Bound to %s, %s, %s in %s");
		add("forcecraft.ender_rod.unset", "Coordinates Not Set");
		add("forcecraft.wrench_rotate.insufficient", "Insufficient Force, need at least %s force to rotate a block");
		add("forcecraft.wrench_transport.insufficient", "Insufficient Force, need at least %s force to transport a block");

		add("item.infuser.tooltip.forcelevel", "Force, ");
		add("item.infuser.tooltip.lumberjack", "Lumberjack");
		add("item.infuser.tooltip.rainbow", "Rainbow");
		add("item.infuser.tooltip.heat", "Heat");
		add("item.infuser.tooltip.freezing", "Freezing");
		add("item.infuser.tooltip.bleed1", "Bleeding I");
		add("item.infuser.tooltip.bleed2", "Bleeding II");
		add("item.infuser.tooltip.bleed3", "Bleeding III");
		add("item.infuser.tooltip.bleed4", "Bleeding IV");
		add("item.infuser.tooltip.bleed5", "Bleeding V");
		add("item.infuser.tooltip.bane", "Bane");
		add("item.infuser.tooltip.wing", "Wing");
		add("item.infuser.tooltip.ender", "Ender");
		add("item.infuser.tooltip.camo", "Camo");
		add("item.infuser.tooltip.sight", "Sight");
		add("item.infuser.tooltip.light", "Light");
		add("item.infuser.tooltip.treasure", "Treasure");
		add("item.infuser.tooltip.sturdy1", "Sturdy I");
		add("item.infuser.tooltip.sturdy2", "Sturdy II");
		add("item.infuser.tooltip.sturdy3", "Sturdy III");
		add("item.infuser.tooltip.sturdy4", "Sturdy IV");
		add("item.infuser.tooltip.sturdy5", "Sturdy V");
		add("item.infuser.tooltip.sturdy6", "Sturdy VI");
		add("item.infuser.tooltip.sturdy7", "Sturdy VII");
		add("item.infuser.tooltip.sturdy8", "Sturdy VII");
		add("item.infuser.tooltip.sturdy9", "Sturdy IX");
		add("item.infuser.tooltip.sturdy10", "Sturdy X");
		add("item.infuser.tooltip.speed1", "Speed I");
		add("item.infuser.tooltip.speed2", "Speed II");
		add("item.infuser.tooltip.speed3", "Speed III");
		add("item.infuser.tooltip.speed4", "Speed IV");
		add("item.infuser.tooltip.speed5", "Speed V");
		add("item.infuser.tooltip.speed6", "Speed VI");
		add("item.infuser.tooltip.speed7", "Speed VII");
		add("item.infuser.tooltip.speed8", "Speed VII");
		add("item.infuser.tooltip.speed9", "Speed IX");
		add("item.infuser.tooltip.speed10", "Speed X");
		add("item.infuser.tooltip.luck1", "Luck I");
		add("item.infuser.tooltip.luck2", "Luck II");
		add("item.infuser.tooltip.luck3", "Luck III");
		add("item.infuser.tooltip.luck4", "Luck IV");
		add("item.infuser.tooltip.luck5", "Luck V");
		add("item.infuser.tooltip.force1", "Force I");
		add("item.infuser.tooltip.force2", "Force II");
		add("item.infuser.tooltip.force3", "Force III");
		add("item.infuser.tooltip.force4", "Force IV");
		add("item.infuser.tooltip.force5", "Force V");
		add("item.infuser.tooltip.force6", "Force VI");
		add("item.infuser.tooltip.force7", "Force VII");
		add("item.infuser.tooltip.force8", "Force VIII");
		add("item.infuser.tooltip.force9", "Force IX");
		add("item.infuser.tooltip.force10", "Force X");
		add("item.infuser.tooltip.healing1", "Healing I");
		add("item.infuser.tooltip.healing2", "Healing II");
		add("item.infuser.tooltip.healing3", "Healing III");
		add("item.infuser.tooltip.healing4", "Healing IV");
		add("item.infuser.tooltip.healing5", "Healing V");
		add("item.infuser.tooltip.sharp", "Force Punch");

		add("item.milk_force_flask.tooltip", "Farm Fresh");
		add("item.force_filled_force_flask.tooltip", "Force Potion Base");
		add("item.entity_flask.tooltip", "Mob, ");
		add("item.entity_flask.tooltip2", "Health, ");
		add("item.entity_flask.empty", "Invalid flask. Missing valid captured mob");
		add("item.entity_flask.empty2", "Couldn't find valid captured mob. Converting to empty flask");
		add("item.red_potion.tooltip", "Restores all Hearts");

		//Commands
		add("commands.forcecraft.null", "Second argument must be a valid command: ");
		add("commands.forcecraft.failed", "Command failed, ensure you have permission");

		//Infuser UI
		add("gui.forcecraft.infuser.nobook", "Upgrade Tome required");
		add("gui.forcecraft.infuser.patchouli", "The info screen requires Patchouli");
		add("gui.forcecraft.infuser.empty.tooltip", "Empty");
		add("gui.forcecraft.infuser.help.tooltip", "Help");
		add("gui.forcecraft.infuser.start.tooltip", "Start Infusion");
		add("gui.forcecraft.infuser.missing.tooltip", "Upgrade Tome or Center Slot empty");
		add("gui.forcecraft.infuser.missing.rf.tooltip", "Need more RF to operate");
		add("gui.forcecraft.infuser.missing.recipe", "Cannot find matching infusion recipe");
		add("gui.forcecraft.infuser.button.guide", "Open Guide GUI");
		add("gui.forcecraft.infuser.button.button", "Start Button");

		//Force Engine UI
		add("gui.forcecraft.force_engine.empty", "Empty");

		//Rename and recolor screen
		add("gui.forcecraft.rename.title", "Rename and Recolor");

		//Patchouli
		add("item.forcecraft.book.name", "Force and You");
		add("info.forcecraft.book.subtitle", "For all your Force needs");
		add("info.forcecraft.book.landing", "ForceCraft is a mod focused around a power called \"Force\". $(br)Here you'll learn how to use it.");

		add("info.forcecraft.book.infuser.name", "Infuser");
		add("info.forcecraft.book.infuser.desc", "The power of Force is used while infusing. $(br)To do so you'll have to get yourself an $(item)Infuser$()");

		add("info.forcecraft.book.infuser.entry.name", "Infuser");
		add("info.forcecraft.book.infuser_recipe.text", "The $(item)Infuser$() Crafting Recipe");
		add("info.forcecraft.book.infuser_info.text", "With the $(item)Infuser$() you can start exploring the infusions that can be applied.");

		add("info.forcecraft.book.force_engine.entry.name", "Force Engine");
		add("info.forcecraft.book.force_engine_info.text", "The $(item)Force Engine$() generates power in the form of $(4)RF$().$(br)To start generating power you have to insert a valid $(l)fuel$() into the left tank.$(br)The right tank is dedicated to $(l)Throttle Fluid$(). A throttle fluid acts as an output multiplier, it's not required but can highly increase the $(4)RF$() output.$(br)To activate the $(item)Force Engine$() you apply a redstone signal");
		add("info.forcecraft.book.force_engine_info_2.text", "after which it will start outputting $(4)RF$() into the block it's facing.$(br)$(br)A list of accepted Fuel and their $(4)RF$() rate,$(li)$(l)Lava$() - 5RF/tick / 100RF/1MB$(li)$(l)Fuel$() (if a mod adds a fuel fluid) - 10RF/tick / 200RF/1MB$(li)$(l)Bio-Fuel$() (if a mod adds a bio-fuel fluid) - 15RF/tick / 300RF/1MB$(li)$(l)Liquid Force$() - 20RF/tick / 400RF/1MB");
		add("info.forcecraft.book.force_engine_info_3.text", "A list of accepted Throttle Fluids and their Multiplier rate,$(li)$(l)Nothing$() - 1x$(li)$(l)Water$() - 2x$(li)$(l)Milk$() - 2.5x");
		add("info.forcecraft.book.force_engine_recipe.text", "The $(item)Force Engine$() Crafting Recipe");

		add("info.forcecraft.book.inert_core.entry.name", "Inert Core");
		add("info.forcecraft.book.inert_core_info.text", "The $(item)Inert Core$() is the inactive version of the $(l)Nether Star$() and is used to craft the $(l:forcecraft:infuser/inert_core)$(item)Bottled Wither$().$(br)$(br)To obtain the $(item)Inert Core$() one has to drain the $(l)Nether Star$() of its power.$(br)The $(l:forcecraft:infuser/force_engine)$(item)Force Engine$() is able to drain the star of its power.$(br)$(br)Once Inert it can be turned into a $(l:forcecraft:infuser/inert_core)$(item)Bottled Wither$()");
		add("info.forcecraft.book.inert_core_info2.text", "Set the $(item)Inert Core$() on fire and Right-click with a $(l:forcecraft:infuser/force_rod)$(item)Force Rod$() to craft a $(l:forcecraft:infuser/inert_core)$(item)Bottled Wither$()");

		add("info.forcecraft.book.force_flask.entry.name", "Force Flask");
		add("info.forcecraft.book.force_flask_info.text", "$(item)Force Flasks$() are force infused flasks that allow the user to capture mobs. $(br)$(br)To capture a mob you sneak right-click with the flask in hand to throw it at the mob. $(br)$(br)The flask can also be right-clicked on a cow to get a $(item)Milk Force Flask$()");
		add("info.forcecraft.book.force_flask_recipe.text", "The $(item)Force Flask$() Crafting Recipe");
		add("info.forcecraft.book.force_flask_recipe2.text", "A Crafting Recipe to convert entity flasks back into a $(item)Force Flask$()");

		add("info.forcecraft.book.claw.entry.name", "Claw");
		add("info.forcecraft.book.claw_info.text", "The $(item)Claw$() is an item that can be used to upgrade tools, weapons and armor with $(l:forcecraft:tier_0/damage)Damage$() $(br)$(br)It can be dropped by $(l)Bats$().");

		add("info.forcecraft.book.bottled_wither.entry.name", "Bottled Wither");
		add("info.forcecraft.book.bottled_wither_info.text", "The $(item)Bottled Wither$() is a portable $(l)Wither$() that can be spawned in by right-clicking the ground with the bottle. Be careful though, as it has no charge time and will immediately start destroying the area.$(br)$(br)It can be created by setting an $(l:forcecraft:infuser/inert_core)$(item)Inert Core$() on fire and right-clicking the fire with a $(l:forcecraft:infuser/force_rod)$(item)Force Rod$()");

		add("info.forcecraft.book.force_ingot.entry.name", "Force Ingot");
		add("info.forcecraft.book.force_ingot_info.text", "$(item)Force Ingots$() can be created by combining $(item)Force Gems$() and two of the same Iron or Gold Ingots.$(br)$(br)Doing so produces two or more $(item)Force Ingots$(), which are useable by a wide variety of tools and equipment.$(br)$(br)Just like any other ingot the $(item)Force Ingot$() can be crafted into 9 nuggets and back.");
		add("info.forcecraft.book.force_ingot_recipe.text", "The $(item)Force Ingot$() Crafting Recipe using Iron Ingots");
		add("info.forcecraft.book.force_ingot_recipe2.text", "The $(item)Force Ingot$() Crafting Recipe using Gold Ingots");
		add("info.forcecraft.book.force_ingot_recipe3.text", "The $(item)Force Ingot$() Crafting Recipe using Force Nuggets");

		add("info.forcecraft.book.force_rod.entry.name", "Force Rod");
		add("info.forcecraft.book.force_rod_info.text", "The $(item)Force Rod$() is used to transmutate various items and blocks.$(br)For example, when you craft a $(item)Force Rod$() together with an $(l)Enchanted Book$() it can create multiple $(l)Bottle o' Enchanting$() depending on the enchant power.$(br)$(br)Various tools can be transmuted back into the ores used to create them.");
		add("info.forcecraft.book.force_rod_recipe.text", "The $(item)Force Rod$() Crafting Recipe");

		add("info.forcecraft.book.baconator.entry.name", "Baconator");
		add("info.forcecraft.book.baconator_info.text", "The $(item)Baconator$() is a tool that can automatically feed the user as long as there is $(l:forcecraft:infuser/bacon)Bacon$() in the $(item)Baconator$()'s magazine.$(br)$(br)To insert $(l:forcecraft:infuser/bacon)Bacon$() into the $(item)Baconator$() you shift right-click the baconator while there's $(l:forcecraft:infuser/bacon)Cooked Bacon$() in your inventory.");
		add("info.forcecraft.book.baconator_recipe.text", "The $(item)Baconator$() Crafting Recipe$(br)$(br)Once $(l:forcecraft:infuser/bacon)Bacon$() has been inserted you can either hold right-click to manually eat or shift right-click again to activate automatic eating.");

		add("info.forcecraft.book.bacon.entry.name", "Bacon");
		add("info.forcecraft.book.bacon_info.text", "$(item)Bacon$() is a food item added by ForceCraft.$(br)$(br)It can be obtained by using $(l:forcecraft:infuser/force_shears)Force Shears$() on a $(l)Pig$(), which will drop $(item)Raw Bacon$() or $(item)Cooked Bacon$() when infused with $(l:forcecraft:tier_4/heat_upgrade)Heat$()$(br)$(br)The $(item)Bacon$() can be eaten or inserted into a $(l:forcecraft:infuser/baconator)Baconator$() to allow for automated eating.");
		add("info.forcecraft.book.bacon_recipe.text", "The $(item)Bacon$() Smelting Recipe");

		add("info.forcecraft.book.force_shears.entry.name", "Force Shears");
		add("info.forcecraft.book.force_shears_info.text", "The $(item)Force Shears$() can do the same things a regular Shear can do but in addition to that they can be used to gather materials from certain mobs without hurting them.");
		add("info.forcecraft.book.force_shears_info2.text", "The list of mobs that can be sheared with $(item)Force Shears$() is as follows,$(br)$(li)On a $(l)Cow$(), Drops leather$(li)On a $(l)Pig$(), $(l:forcecraft:infuser/bacon)Raw Bacon$()$(li)On a $(l)Chicken$(), Drops feathers");
		add("info.forcecraft.book.force_shears_recipe.text", "The $(item)Force Shears$() Crafting Recipe");

		add("info.forcecraft.book.force_furnace.entry.name", "Force Furnace");
		add("info.forcecraft.book.force_furnace_recipe.text", "The $(item)Force Furnace$() Crafting Recipe");
		add("info.forcecraft.book.force_furnace_info.text", "With the $(item)Force Furnace$() you can smelt blocks and items similar to a vanilla furnace but twice as fast.$(br)The furnace can be upgraded by applying an Upgrade Core of choice into the Upgrade slot on the top left. (Once an upgrade is applied taking it out will void it)");
		add("info.forcecraft.book.force_furnace_speed_core.text", "The $(item)Speed Core$() will increase the furnace speed fivefold.");
		add("info.forcecraft.book.force_furnace_heat_core.text", "The $(item)Heat Core$() will increase the furnace efficiency by twofold, allowing you to smelt twice the amount of items/blocks with the same amount of fuel.");
		add("info.forcecraft.book.force_furnace_grinding_core.text", "The $(item)Grinding Core$() will change the furnace into grinding mode. With grinding mode active, you can make use of Grinding recipes.$(br)For example, grinding a single Bone into 5 Bonemeal.");
		add("info.forcecraft.book.force_furnace_freezing_core.text", "The $(item)Freezing Core$() will change the furnace into freezing mode. With freezing mode active, you can make use of Freezing recipes.$(br)For example, freezing a Blaze Rod into a Bone.");
		add("info.forcecraft.book.force_furnace_experience_core.text", "The $(item)Experience Core$() will increase the experience that can be obtained from smelting by twofold.");

		add("info.forcecraft.book.requirements.entry.name", "Requirements");
		add("info.forcecraft.book.requirements_info.text", "To get started, the following items are required,$(br)$(br)Firstly, the $(item)Infuser$() requires power in the form of $(4)RF$().");
		add("info.forcecraft.book.requirements_gem.text", "The second requirement is $(6)Liquid Force$().$(br)Liquid force is added by inserting $(item)Force Gems$() into the slot above the liquid tank.");
		add("info.forcecraft.book.requirements_tome.text", "The third requirement is an $(item)Upgrade Tome$() which is required for infusions. Without it the $(item)Infuser$() will not function.$(br)$(br)To upgrade the Tome, you need to acquire Force Points and complete all infusions in the current tier");

		add("info.forcecraft.book.upgrade_core.entry.name", "Upgrade Core");
		add("info.forcecraft.book.upgrade_core_info.text", "The $(item)Upgrade Core$() can be used to craft $(l:forcecraft:infuser/furnace)$(item)Force Furnace$() upgrade cores. With these you can enhance aspects of the Furnace to suit your needs.");
		add("info.forcecraft.book.upgrade_core_recipe.text", "$(l)Note,$() The recipe requires an $(item)Experience Tome$() with at least 100 xp.");

		add("info.forcecraft.book.upgrade_core_link.text", "You can check the page on the $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$() to learn how to craft it");

		add("info.forcecraft.book.tier_0.name", "Tier 0 Infusions");
		add("info.forcecraft.book.tier_0.desc", "Infusions that can be executed by default$(br)$(br)Complete all tier zero infusions to upgrade your Tome to the next tier (2 total)");
		add("info.forcecraft.book.force.entry.name", "Force");
		add("info.forcecraft.book.force_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Sword$(), Adds one level of Knockback per item");
		add("info.forcecraft.book.damage.entry.name", "Damage");
		add("info.forcecraft.book.damage_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Sword$(), Adds one level of Sharpness per item$(br)$(li)On a $(item)Force Bow$(), Adds one level of Power per level$(br)$(li)On $(item)Force Armor$(), Increases Force Punch damage by half a heart per item");

		add("info.forcecraft.book.tier_1.name", "Tier 1 Infusions");
		add("info.forcecraft.book.tier_1.desc", "Infusions that can be executed by having an $(item)Upgrade Tome$() of at least Tier 1$(br)$(br)Complete all tier one infusions to upgrade your Tome to the next tier (3 total)");
		add("info.forcecraft.book.speed.entry.name", "Speed");
		add("info.forcecraft.book.speed_info.text", "This infusion does the following,$(br)$(li)On $(item)Force Tools$(), Increases the tool efficiency$(br)$(li)On a $(item)Force Bow$() (Max lvl, 1), Makes arrows fly faster and farther$(br)$(li)On $(item)Force Armor$() (Max lvl, 1), Increase player movement speed");
		add("info.forcecraft.book.speed_info.text2", "$(li)On an $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$(), Converts the Upgrade Core to an $(item)Speed Core$() to use as an upgrade for the $(l:forcecraft:infuser/furnace)$(item)Force Furnace$()");
		add("info.forcecraft.book.lumberjack.entry.name", "Lumberjack");
		add("info.forcecraft.book.lumberjack_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Axe$(), Breaks every wooden block in a vertical pillar instantly, using twice the durability");
		add("info.forcecraft.book.heat.entry.name", "Heat");
		add("info.forcecraft.book.heat_info.text", "This infusion does the following,$(br)$(li)On $(item)Force Tools$(), Attempts to smelt any mined block drop$(br)$(li)On $(item)Force Armor$() (Max lvl, 1), Increases Force Punch damage by half a heart per item and sets mobs on fire");

		add("info.forcecraft.book.tier_2.name", "Tier 2 Infusions");
		add("info.forcecraft.book.tier_2.desc", "Infusions that can be executed by having an $(item)Upgrade Tome$() of at least Tier 2$(br)$(br)Complete all tier two infusions to upgrade your Tome to the next tier (9 total)");
		add("info.forcecraft.book.luck.entry.name", "Luck");
		add("info.forcecraft.book.luck_info.text", "This infusion does the following,$(br)$(li)On $(item)Force Tools$(), Adds one level of Fortune per item$(br)$(li)On a $(item)Force Sword$(), Adds one level of Looting per item$(br)$(li)On a $(item)Force Bow$(), Adds one level of Looting per item which affects ranged kills");
		add("info.forcecraft.book.luck_info.text2", "$(li)On $(item)Force Armor$() (Max lvl, 1), Increases Force Punch mob drops similar to Looting on weapons");
		add("info.forcecraft.book.rainbow.entry.name", "Rainbow");
		add("info.forcecraft.book.rainbow_info.text", "This infusion does the following,$(br)$(li)On $(item)Force Shears$(), Randomly colors Wool dropped from shearing Sheep");
		add("info.forcecraft.book.experience.entry.name", "Experience Tome");
		add("info.forcecraft.book.experience_info.text", "This infusion does the following,$(br)$(li)On a $(item)Book$(), Creates an $(item)Experience Tome$()$(br)$(li)On an $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$(), Converts the Upgrade Core to an $(item)Experience Core$() to use as an upgrade for the $(l:forcecraft:infuser/furnace)$(item)Force Furnace$()");
		add("info.forcecraft.book.experience_core.entry.name", "Experience Core");
		add("info.forcecraft.book.experience_core_info.text", "This infusion does the following,$(br)$(li)On an $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$(), Converts the Upgrade Core to an $(item)Experience Core$() to use as an upgrade for the $(l:forcecraft:infuser/furnace)$(item)Force Furnace$()");
		add("info.forcecraft.book.holding.entry.name", "Holding");
		add("info.forcecraft.book.holding_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Pack$(), Adds an additional 8 storage slots. Allowing you to upgrade the base $(item)Force Pack$() to 16 slots.");
		add("info.forcecraft.book.freezing.entry.name", "Freezing");
		add("info.forcecraft.book.freezing_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Bow$(), Adds a freezing effect to the arrows");
		add("info.forcecraft.book.freezing_core.entry.name", "Freezing Core");
		add("info.forcecraft.book.freezing_core_info.text", "This infusion does the following,$(br)$(li)On an $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$(), Converts the Upgrade Core to an $(item)Freezing Core$() to use as an upgrade for the $(l:forcecraft:infuser/furnace)$(item)Force Furnace$()");
		add("info.forcecraft.book.grinding_core.entry.name", "Grinding Core");
		add("info.forcecraft.book.grinding_core_info.text", "This infusion does the following,$(br)$(li)On an $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$(), Converts the Upgrade Core to a $(item)Grinding Core$() to use as an upgrade for the $(l:forcecraft:infuser/furnace)$(item)Force Furnace$()");
		add("info.forcecraft.book.speed_core.entry.name", "Speed Core");
		add("info.forcecraft.book.speed_core_info.text", "This infusion does the following,$(br)$(li)On an $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$(), Converts the Upgrade Core to a $(item)Speed Core$() to use as an upgrade for the $(l:forcecraft:infuser/furnace)$(item)Force Furnace$()");

		add("info.forcecraft.book.tier_3.name", "Tier 3 Infusions");
		add("info.forcecraft.book.tier_3.desc", "Infusions that can be executed by having an $(item)Upgrade Tome$() of at least Tier 3$(br)$(br)Complete all tier three infusions to upgrade your Tome to the next tier (4 total)");
		add("info.forcecraft.book.holding_2.entry.name", "Holding 2");
		add("info.forcecraft.book.holding_2_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Pack$(), Adds an additional 8 storage slots. Allowing you to upgrade the $(item)Force Pack$() to 24 slots.");
		add("info.forcecraft.book.bleeding.entry.name", "Bleeding");
		add("info.forcecraft.book.bleeding_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Sword$(), Will imbue Force Punch with the Bleeding effect$(br)$(li)On a $(item)Force Bow$(), Will imbue the bow's projectiles with Bleeding$(br)$(li)On $(item)Force Armor$(), Will imbue the armor with Bleeding cursing any hit enemy");
		add("info.forcecraft.book.bleeding_info.text2", "Bleeding inflicts a half of damage twice per second. It lasts one second per cumulated level of Bleeding$(br)Bleeding from different items $(l)will$() stack up to 15 seconds");
		add("info.forcecraft.book.camo.entry.name", "Camo");
		add("info.forcecraft.book.camo_info.text", "This infusion does the following,$(br)$(li)On a $(l:forcecraft:infuser/force_rod)$(item)Force Rod$(), Will imbue the rod with Invisibility$(br)$(li)On $(item)Force Armor$(), Makes the armor invisible, showing the player's skin instead of the armor");
		add("info.forcecraft.book.silk.entry.name", "Silky");
		add("info.forcecraft.book.silk_info.text", "This infusion does the following,$(br)$(li)On $(item)Force Tools$(), Will imbue the tools with Silk Touch");

		add("info.forcecraft.book.tier_4.name", "Tier 4 Infusions");
		add("info.forcecraft.book.tier_4.desc", "Infusions that can be executed by having an $(item)Upgrade Tome$() of at least Tier 4$(br)$(br)Complete all tier four infusions to upgrade your Tome to the next tier (3 total)");
		add("info.forcecraft.book.holding_3.entry.name", "Holding 3");
		add("info.forcecraft.book.holding_3_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Pack$(), Adds an additional 8 storage slots. Allowing you to upgrade the $(item)Force Pack$() to 32 slots.");
		add("info.forcecraft.book.bane.entry.name", "Bane");
		add("info.forcecraft.book.bane_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Sword$(), Will imbue the sword with Bane$(br)$(li)On a $(item)Force Bow$(), Will imbue the bow's projectiles with Bane$(br)$(li)On $(item)Force Armor$(), will imbue any projectile fired by a bow with Bane");
		add("info.forcecraft.book.bane_info.text2", "Bane will permanently remove certain monster abilities, leaving them mostly harmless,$(br)$(li)$(l)Creepers$() hit with bane will lose the ability to blow up$(br)$(li)$(l)Enderman$() and $(l)Ender Tots$() hit with bane will lose the ability to teleport");
		add("info.forcecraft.book.heat_upgrade.entry.name", "Heat Upgrade");
		add("info.forcecraft.book.heat_upgrade_info.text", "This infusion does the following,$(br)$(li)On an $(l:forcecraft:infuser/upgrade_core)$(item)Upgrade Core$(), Converts the Upgrade Core to a $(item)Heat Core$() to use as an upgrade for the $(l:forcecraft:infuser/furnace)$(item)Force Furnace$()");

		add("info.forcecraft.book.tier_5.name", "Tier 5 Infusions");
		add("info.forcecraft.book.tier_5.desc", "Infusions that can be executed by having an $(item)Upgrade Tome$() of at least Tier 5$(br)$(br)Complete all tier five infusions to upgrade your Tome to the next tier (3 total)");
		add("info.forcecraft.book.holding_4.entry.name", "Holding 4");
		add("info.forcecraft.book.holding_4_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Pack$(), Adds an additional 8 storage slots. Allowing you to upgrade the $(item)Force Pack$() to 40 slots which is the maximum amount of slots the pack can handle.");
		add("info.forcecraft.book.healing.entry.name", "Healing");
		add("info.forcecraft.book.healing_info.text", "This infusion does the following,$(br)$(li)On a $(l:forcecraft:infuser/force_rod)$(item)Force Rod$() (Max lvl, 2), Will imbue the rod with Healing");
		add("info.forcecraft.book.wing.entry.name", "Wing");
		add("info.forcecraft.book.wing_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Sword$(), will allow the user to propel themselves forward while using some durability");

		add("info.forcecraft.book.tier_6.name", "Tier 6 Infusions");
		add("info.forcecraft.book.tier_6.desc", "Infusions that can be executed by having an $(item)Upgrade Tome$() of at least Tier 6$(br)$(br)Complete all tier six infusions to upgrade your Tome to the next tier (3 total, 2 if the Time Torch is disabled)");
		add("info.forcecraft.book.time.entry.name", "Time");
		add("info.forcecraft.book.time_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Torch$(), Imbues the torch with time converting it to a $(item)Time Torch$()$(br)$(br)$(l)Note,$() If you're unable to execute the infusion it means the recipe has been disabled in the config");
		add("info.forcecraft.book.ender.entry.name", "Ender");
		add("info.forcecraft.book.ender_info.text", "This infusion does the following,$(br)$(li)On a $(l:forcecraft:infuser/force_rod)$(item)Force Rod$(), Will imbue the rod with Ender allowing it to be used as a teleportation device$(br)$(li)On a $(item)Force Sword$(), Will add Ender to the sword allowing you to teleport to a targeted spot");
		add("info.forcecraft.book.ender_info.text2", "$(li)On a $(item)Force Bow$(), will imbue any projectile fired by the bow, causing enemies to teleport to a random location");
		add("info.forcecraft.book.sturdy.entry.name", "Sturdy");
		add("info.forcecraft.book.sturdy_info.text", "This infusion does the following,$(br)$(li)On $(item)Force Tools$() (Max lvl, 3), will imbue with the vanilla Unbreaking enchantment$(br)$(li)On $(item)Force Armor$() (1 level per piece), Reduces damage from all sources for a total of 75%%");

		add("info.forcecraft.book.tier_7.name", "Tier 7 Infusions");
		add("info.forcecraft.book.tier_7.desc", "Infusions that can be executed by having an $(item)Upgrade Tome$() of at least Tier 7");
		add("info.forcecraft.book.light.entry.name", "Light");
		add("info.forcecraft.book.light_info.text", "This infusion does the following,$(br)$(li)On a $(l:forcecraft:infuser/force_rod)$(item)Force Rod$() (Max lvl, 1), Will imbue the rod with Light, allowing you to make the enemy glow (The effect can be removed by drinking milk)$(br)$(li)On a $(item)Force Bow$(), will imbue any projectile fired by the bow, causing enemies to start glowing for 10 seconds");
		add("info.forcecraft.book.treasure.entry.name", "Treasure");
		add("info.forcecraft.book.treasure_info.text", "This infusion does the following,$(br)$(li)On a $(item)Force Sword$(), will imbue the sword with the 'treasure' property causing slain mobs to drop $(item)Treasure Cards$() $(li)On a $(item)Force Axe$(), will imbue the axe with the 'treasure' property causing slain mobs to drop $(item)Treasure Cards() which can be crafted into a $(item)Spoils Bag$()");

		//Keybinds
		add("key.forcecraft.category", "Forcecraft");
		add("key.forcecraft.open_hotbar_pack", "Open hotbar Force Pack");
		add("key.forcecraft.open_hotbar_belt", "Open hotbar Force Belt");
		add("key.forcecraft.quick_use", "Forcecraft Quick Use");
		add("key.forcecraft.quick_use_1", "Force Belt Slot 1");
		add("key.forcecraft.quick_use_2", "Force Belt Slot 2");
		add("key.forcecraft.quick_use_3", "Force Belt Slot 3");
		add("key.forcecraft.quick_use_4", "Force Belt Slot 4");
		add("key.forcecraft.quick_use_5", "Force Belt Slot 5");
		add("key.forcecraft.quick_use_6", "Force Belt Slot 6");
		add("key.forcecraft.quick_use_7", "Force Belt Slot 7");
		add("key.forcecraft.quick_use_8", "Force Belt Slot 8");


		//JEI Compat
		add("forcecraft.gui.jei.category.freezing", "Freezing");
		add("forcecraft.gui.jei.category.grinding", "Grinding");
		add("forcecraft.gui.jei.category.grinding.tooltip", "% Chance");
		add("forcecraft.gui.jei.category.infuser", "Infuser");
		add("forcecraft.gui.jei.category.infuser.tier", "Tier, %s");
	}

	public void addSubtitle(DeferredHolder<SoundEvent, SoundEvent> sound, String name) {
		String path = Reference.MOD_ID + "." + sound.getId().getPath() + ".subtitle";
		this.add(path, name);
	}

	/**
	 * Add the translation for a config entry
	 *
	 * @param path        The path of the config entry
	 * @param name        The name of the config entry
	 * @param description The description of the config entry (optional in case of targeting "title" or similar entries that have no tooltip)
	 */
	private void addConfig(String path, String name, @Nullable String description) {
		this.add(Reference.MOD_ID + ".configuration." + path, name);
		if (description != null && !description.isEmpty())
			this.add(Reference.MOD_ID + ".configuration." + path + ".tooltip", description);
	}
}