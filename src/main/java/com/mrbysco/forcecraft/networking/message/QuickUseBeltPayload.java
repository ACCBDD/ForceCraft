package com.mrbysco.forcecraft.networking.message;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record QuickUseBeltPayload(int slot) implements CustomPacketPayload {
	public static final StreamCodec<FriendlyByteBuf, QuickUseBeltPayload> CODEC = CustomPacketPayload.codec(
			QuickUseBeltPayload::write,
			QuickUseBeltPayload::new);
	public static final Type<QuickUseBeltPayload> ID = new Type<>(Reference.modLoc("quick_use_belt"));

	public QuickUseBeltPayload(final FriendlyByteBuf packetBuffer) {
		this(packetBuffer.readInt());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(slot);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}
