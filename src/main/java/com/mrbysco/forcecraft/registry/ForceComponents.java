package com.mrbysco.forcecraft.registry;

import com.mojang.serialization.Codec;
import com.mrbysco.forcecraft.Reference;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ForceComponents {
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Reference.MOD_ID);

	public static final Supplier<DataComponentType<Integer>> PACK_COLOR = DATA_COMPONENT_TYPES.register("pack_color", () ->
			DataComponentType.<Integer>builder()
					.persistent(Codec.INT)
					.networkSynchronized(ByteBufCodecs.INT)
					.build());
}
