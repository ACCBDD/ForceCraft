package com.mrbysco.forcecraft.attachments.banemodifier;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class BaneModifierAttachment implements IBaneModifier, INBTSerializable<CompoundTag> {
	boolean canTeleport = true;

	@Override
	public boolean canTeleport() {
		return canTeleport;
	}

	@Override
	public void setTeleportAbility(boolean canTeleport) {
		this.canTeleport = canTeleport;
	}

	boolean canExplode = true;

	@Override
	public boolean canExplode() {
		return canExplode;
	}

	@Override
	public void setExplodeAbility(boolean canExplode) {
		this.canExplode = canExplode;
	}

	@Override
	public CompoundTag serializeNBT(HolderLookup.Provider provider) {
		CompoundTag tag = new CompoundTag();
		tag.putBoolean("canTeleport", this.canTeleport());
		tag.putBoolean("canExplode", this.canExplode());
		return tag;
	}

	@Override
	public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
		this.setTeleportAbility(tag.getBoolean("canTeleport"));
		this.setExplodeAbility(tag.getBoolean("canExplode"));
	}
}
