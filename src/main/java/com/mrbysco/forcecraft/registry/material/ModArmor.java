package com.mrbysco.forcecraft.registry.material;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmor {

	public static final Holder<ArmorMaterial> FORCE = register(
			"force",
			Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 3);
				map.put(ArmorItem.Type.LEGGINGS, 4);
				map.put(ArmorItem.Type.CHESTPLATE, 6);
				map.put(ArmorItem.Type.HELMET, 3);
				map.put(ArmorItem.Type.BODY, 6);
			}),
			0,
			SoundEvents.ARMOR_EQUIP_IRON,
			4.0F,
			0.1F,
			() -> Ingredient.of(Items.NETHERITE_INGOT)
	);

	private static Holder<ArmorMaterial> register(String string, EnumMap<ArmorItem.Type, Integer> enumMap, int i,
	                                              Holder<SoundEvent> arg, float f, float g,
	                                              Supplier<Ingredient> supplier) {
		List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Reference.modLoc(string)));
		return register(string, enumMap, i, arg, f, g, supplier, list);
	}

	private static Holder<ArmorMaterial> register(String string, EnumMap<ArmorItem.Type, Integer> enumMap, int i,
	                                              Holder<SoundEvent> arg, float f, float g,
	                                              Supplier<Ingredient> supplier, List<ArmorMaterial.Layer> list) {
		EnumMap<ArmorItem.Type, Integer> typeIntegerEnumMap = new EnumMap<>(ArmorItem.Type.class);
		ArmorItem.Type[] values = ArmorItem.Type.values();
		int var10 = values.length;

		for (int var11 = 0; var11 < var10; ++var11) {
			ArmorItem.Type type = values[var11];
			typeIntegerEnumMap.put(type, (Integer) enumMap.get(type));
		}

		return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, Reference.modLoc(string), new ArmorMaterial(typeIntegerEnumMap, i, arg, supplier, list, f, g));
	}
}
