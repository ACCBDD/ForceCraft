package com.mrbysco.forcecraft.networking.message;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.InteractionHand;

public record PackChangePayload(InteractionHand hand, String customName, int color) implements CustomPacketPayload {
	public static final StreamCodec<FriendlyByteBuf, PackChangePayload> CODEC = CustomPacketPayload.codec(
			PackChangePayload::write,
			PackChangePayload::new);
	public static final Type<OpenInventoryPayload> ID = new Type<>(Reference.modLoc("pack_change"));

	public PackChangePayload(final FriendlyByteBuf packetBuffer) {
		this(packetBuffer.readInt() == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND, packetBuffer.readUtf(), packetBuffer.readInt());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(hand == InteractionHand.MAIN_HAND ? 0 : 1);
		buf.writeUtf(customName);
		buf.writeInt(color);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}
