package com.mrbysco.forcecraft.registry;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ForceTables {
	public static final ResourceKey<LootTable> TIER_1 = register("spoils/tier1");
	public static final ResourceKey<LootTable> TIER_2 = register("spoils/tier2");
	public static final ResourceKey<LootTable> TIER_3 = register("spoils/tier3");

	private static ResourceKey<LootTable> register(String name) {
		return ResourceKey.create(Registries.LOOT_TABLE, Reference.modLoc(name));
	}
}
