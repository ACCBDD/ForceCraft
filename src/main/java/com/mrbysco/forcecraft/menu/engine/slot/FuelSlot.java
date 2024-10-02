package com.mrbysco.forcecraft.menu.engine.slot;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class FuelSlot extends SlotItemHandler {

	public FuelSlot(IItemHandler handler, int index, int posX, int posY) {
		super(handler, index, posX, posY);
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		return getItemHandler().isItemValid(0, stack);
	}

	@Override
	public int getMaxStackSize(@NotNull ItemStack stack) {
		if (stack.getCapability(Capabilities.FluidHandler.ITEM) != null) {
			if (stack.getMaxStackSize() > 1) {
				return 1;
			}
		}
		return super.getMaxStackSize(stack);
	}
}
