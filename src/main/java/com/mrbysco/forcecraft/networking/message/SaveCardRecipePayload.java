package com.mrbysco.forcecraft.networking.message;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record SaveCardRecipePayload() implements CustomPacketPayload {
	public static final StreamCodec<FriendlyByteBuf, SaveCardRecipePayload> CODEC = CustomPacketPayload.codec(
			SaveCardRecipePayload::write,
			SaveCardRecipePayload::new);
	public static final Type<SaveCardRecipePayload> ID = new Type<>(Reference.modLoc("save_card_recipe"));

	public SaveCardRecipePayload(final FriendlyByteBuf packetBuffer) {
		this();
	}

	public void write(FriendlyByteBuf buf) {

	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}
