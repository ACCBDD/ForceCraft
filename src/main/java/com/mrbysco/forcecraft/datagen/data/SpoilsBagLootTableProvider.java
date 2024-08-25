package com.mrbysco.forcecraft.datagen.data;

import com.mrbysco.forcecraft.registry.ForceTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

import static com.mrbysco.forcecraft.registry.ForceRegistry.BACONATOR;
import static com.mrbysco.forcecraft.registry.ForceRegistry.BUCKET_FLUID_FORCE;
import static com.mrbysco.forcecraft.registry.ForceRegistry.DARKNESS_CARD;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_ARROW;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_AXE;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_GEM;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_INGOT;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_MITT;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_PICKAXE;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_SAPLING;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_SHEARS;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_SHOVEL;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORCE_SWORD;
import static com.mrbysco.forcecraft.registry.ForceRegistry.FORTUNE_COOKIE;
import static com.mrbysco.forcecraft.registry.ForceRegistry.LIFE_CARD;
import static com.mrbysco.forcecraft.registry.ForceRegistry.UNDEATH_CARD;

public class SpoilsBagLootTableProvider implements LootTableSubProvider {
	public SpoilsBagLootTableProvider(HolderLookup.Provider provider) {
	}

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, Builder> consumer) {
		consumer.accept(ForceTables.TIER_1, LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 4.0F))
						.name("Force Loot")
						.add(LootItem.lootTableItem(FORCE_MITT.get()).setWeight(15))
						.add(LootItem.lootTableItem(BUCKET_FLUID_FORCE.get()).setWeight(12))
						.add(LootItem.lootTableItem(FORCE_GEM.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
						.add(LootItem.lootTableItem(FORCE_INGOT.get()).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
						.add(LootItem.lootTableItem(FORCE_INGOT.get()).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 8.0F))))
						.add(LootItem.lootTableItem(FORCE_ARROW.get()).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 11.0F))))
						.add(LootItem.lootTableItem(FORTUNE_COOKIE.get()).setWeight(10))
						.add(LootItem.lootTableItem(FORCE_SAPLING.get()).setWeight(12))
						.add(LootItem.lootTableItem(BACONATOR.get()).setWeight(10))
						.add(LootItem.lootTableItem(Items.CAKE).setWeight(6))
				)
				.withPool(LootPool.lootPool()
						.name("Other tables")
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.VILLAGE_TOOLSMITH))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.VILLAGE_WEAPONSMITH))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.SPAWN_BONUS_CHEST)))
		);

		consumer.accept(ForceTables.TIER_2, LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 4.0F))
						.name("Force Loot")
						.add(LootItem.lootTableItem(FORCE_MITT.get()).setWeight(15))
						.add(LootItem.lootTableItem(BUCKET_FLUID_FORCE.get()).setWeight(12))
						.add(LootItem.lootTableItem(FORCE_GEM.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
						.add(LootItem.lootTableItem(FORCE_INGOT.get()).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
						.add(LootItem.lootTableItem(FORCE_INGOT.get()).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 8.0F))))
						.add(LootItem.lootTableItem(FORCE_ARROW.get()).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 11.0F))))
						.add(LootItem.lootTableItem(FORTUNE_COOKIE.get()).setWeight(10))
						.add(LootItem.lootTableItem(LIFE_CARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(DARKNESS_CARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(UNDEATH_CARD.get()).setWeight(1))
				)
				.withPool(LootPool.lootPool()
						.name("Other Tables")
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.SIMPLE_DUNGEON))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.DESERT_PYRAMID))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.JUNGLE_TEMPLE))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.NETHER_BRIDGE))
				)
		);

		consumer.accept(ForceTables.TIER_3, LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 4.0F))
						.name("Force Loot")
						.add(LootItem.lootTableItem(FORCE_MITT.get()).setWeight(15))
						.add(LootItem.lootTableItem(BUCKET_FLUID_FORCE.get()).setWeight(12))
						.add(LootItem.lootTableItem(FORCE_GEM.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
						.add(LootItem.lootTableItem(FORCE_INGOT.get()).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
						.add(LootItem.lootTableItem(FORCE_INGOT.get()).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 8.0F))))
						.add(LootItem.lootTableItem(FORCE_PICKAXE.get()).setWeight(15))
						.add(LootItem.lootTableItem(FORCE_AXE.get()).setWeight(15))
						.add(LootItem.lootTableItem(FORCE_SWORD.get()).setWeight(15))
						.add(LootItem.lootTableItem(FORCE_SHEARS.get()).setWeight(15))
						.add(LootItem.lootTableItem(FORCE_SHOVEL.get()).setWeight(15))
						.add(LootItem.lootTableItem(LIFE_CARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(DARKNESS_CARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(UNDEATH_CARD.get()).setWeight(1))
				)
				.withPool(LootPool.lootPool()
						.name("Other Tables")
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.ABANDONED_MINESHAFT))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.STRONGHOLD_CORRIDOR))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.STRONGHOLD_LIBRARY))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.STRONGHOLD_CROSSING))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.BASTION_TREASURE))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.BURIED_TREASURE))
						.add(NestedLootTable.lootTableReference(BuiltInLootTables.END_CITY_TREASURE))
				)
		);
	}
}
