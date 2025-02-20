package com.mrbysco.forcecraft.recipe.condition;

import com.mojang.serialization.MapCodec;
import com.mrbysco.forcecraft.Reference;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ForceConditions {
	public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS = DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Reference.MOD_ID);

	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<TorchEnabledCondition>> TIME_TORCH_ENABLED = CONDITION_CODECS.register("time_torch_enabled", () -> TorchEnabledCondition.CODEC);
}
