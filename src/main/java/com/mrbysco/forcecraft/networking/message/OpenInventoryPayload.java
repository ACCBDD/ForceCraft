package com.mrbysco.forcecraft.networking.message;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record OpenInventoryPayload(int inventoryType) implements CustomPacketPayload {
	public static final StreamCodec<FriendlyByteBuf, OpenInventoryPayload> CODEC = CustomPacketPayload.codec(
			OpenInventoryPayload::write,
			OpenInventoryPayload::new);
	public static final Type<OpenInventoryPayload> ID = new Type<>(Reference.modLoc("open_inventory"));

	public OpenInventoryPayload(final FriendlyByteBuf packetBuffer) {
		this(packetBuffer.readInt());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(inventoryType);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}
