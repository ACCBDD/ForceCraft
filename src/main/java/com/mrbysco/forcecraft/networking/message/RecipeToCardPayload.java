package com.mrbysco.forcecraft.networking.message;

import com.mrbysco.forcecraft.Reference;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public record RecipeToCardPayload(List<ItemStack> stacks) implements CustomPacketPayload {
	public static final StreamCodec<FriendlyByteBuf, RecipeToCardPayload> CODEC = CustomPacketPayload.codec(
			RecipeToCardPayload::write,
			RecipeToCardPayload::new);
	public static final Type<RecipeToCardPayload> ID = new Type<>(Reference.modLoc("recipe_to_card"));

	public RecipeToCardPayload(final FriendlyByteBuf packetBuffer) {
		this(new ArrayList<>());
		int size = packetBuffer.readInt();
		for (int i = 0; i < size; i++) {
			stacks.add(packetBuffer.readItem());
		}
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(stacks.size());
		for (ItemStack output : stacks) {
			buf.writeItem(output);
		}
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}
