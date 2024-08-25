package com.mrbysco.forcecraft.components.flask;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record FlaskContent(ResourceLocation storedType, CompoundTag entityData) {
	public static final Codec<FlaskContent> CODEC = RecordCodecBuilder.create(inst -> inst.group(
					ResourceLocation.CODEC.fieldOf("storedType").forGetter(FlaskContent::storedType),
					CompoundTag.CODEC.optionalFieldOf("entityData", new CompoundTag()).forGetter(FlaskContent::entityData))
			.apply(inst, FlaskContent::new));
	public static final StreamCodec<RegistryFriendlyByteBuf, FlaskContent> STREAM_CODEC = StreamCodec.of(
			FlaskContent::toNetwork, FlaskContent::fromNetwork
	);

	private static FlaskContent fromNetwork(RegistryFriendlyByteBuf byteBuf) {
		ResourceLocation storedType = ResourceLocation.STREAM_CODEC.decode(byteBuf);
		CompoundTag storedBlockNBT = byteBuf.readNbt();
		return new FlaskContent(storedType, storedBlockNBT);
	}

	private static void toNetwork(RegistryFriendlyByteBuf byteBuf, FlaskContent playerCompassData) {
		ResourceLocation.STREAM_CODEC.encode(byteBuf, playerCompassData.storedType());
		byteBuf.writeNbt(playerCompassData.entityData());
	}
}
