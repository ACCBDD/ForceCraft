package com.mrbysco.forcecraft.components.forcewrench;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public record ForceWrenchData(CompoundTag storedBlockNBT, BlockState storedBlockState, String name) {
	public static final ForceWrenchData EMPTY = new ForceWrenchData(null, null, "");
	public static final Codec<ForceWrenchData> CODEC = RecordCodecBuilder.create(inst -> inst.group(
					CompoundTag.CODEC.fieldOf("storedBlockNBT").forGetter(ForceWrenchData::storedBlockNBT),
					BlockState.CODEC.fieldOf("storedBlockState").forGetter(ForceWrenchData::storedBlockState),
					Codec.STRING.fieldOf("name").forGetter(ForceWrenchData::name))
			.apply(inst, ForceWrenchData::new));
	public static final StreamCodec<RegistryFriendlyByteBuf, ForceWrenchData> STREAM_CODEC = StreamCodec.of(
			ForceWrenchData::toNetwork, ForceWrenchData::fromNetwork
	);

	private static ForceWrenchData fromNetwork(RegistryFriendlyByteBuf byteBuf) {
		CompoundTag storedBlockNBT = byteBuf.readNbt();
		BlockState storedBlockState = Block.stateById(byteBuf.readInt());
		String name = byteBuf.readUtf(32767);
		return new ForceWrenchData(storedBlockNBT, storedBlockState, name);
	}

	private static void toNetwork(RegistryFriendlyByteBuf byteBuf, ForceWrenchData playerCompassData) {
		byteBuf.writeNbt(playerCompassData.storedBlockNBT());
		byteBuf.writeInt(Block.getId(playerCompassData.storedBlockState()));
		byteBuf.writeUtf(playerCompassData.name());
	}

	public boolean hasBlockStored() {
		return storedBlockState != null;
	}

	public boolean canStoreBlock() {
		return hasBlockStored();
	}
}
