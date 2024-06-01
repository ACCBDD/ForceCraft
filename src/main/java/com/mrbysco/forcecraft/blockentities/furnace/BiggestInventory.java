package com.mrbysco.forcecraft.blockentities.furnace;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

public class BiggestInventory implements Comparable<BiggestInventory> {
	private final int inventorySize;
	private final BlockPos tilePos;
	private final Direction direction;

	public BiggestInventory(BlockPos pos, int size, Direction dir) {
		this.tilePos = pos;
		this.inventorySize = size;
		this.direction = dir;
	}

	public IItemHandler getIItemHandler(Level level, BlockPos pos) {
		if (level.isAreaLoaded(pos, 1)) {
			return level.getCapability(Capabilities.ItemHandler.BLOCK, tilePos, direction);
		}
		return null;
	}

	@Override
	public int compareTo(BiggestInventory otherInventory) {
		return Integer.compare(this.inventorySize, otherInventory.inventorySize);
	}
}
