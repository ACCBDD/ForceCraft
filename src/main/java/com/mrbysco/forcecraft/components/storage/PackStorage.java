package com.mrbysco.forcecraft.components.storage;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

public class PackStorage {
	private final UUID uuid;
	private final PackStackHandler inventory;

	public PackStorage(UUID uuid) {
		this.uuid = uuid;
		this.inventory = new PackStackHandler();
	}

	public PackStorage(CompoundTag tag, HolderLookup.Provider registries) {
		this.uuid = tag.getUUID("uuid");
		this.inventory = new PackStackHandler();
		this.inventory.deserializeNBT(registries, tag.getCompound("inventory"));
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public PackStackHandler getInventory() {
		return this.inventory;
	}

	public CompoundTag toNBT(HolderLookup.Provider registries) {
		CompoundTag tag = new CompoundTag();

		tag.putUUID("uuid", this.uuid);
		tag.putString("sUUID", this.uuid.toString());

		tag.put("inventory", this.inventory.serializeNBT(registries));

		return tag;
	}
}
