package com.mrbysco.forcecraft.capability;

import com.mrbysco.forcecraft.attachment.storage.StorageManager;
import com.mrbysco.forcecraft.blockentities.ForceEngineBlockEntity;
import com.mrbysco.forcecraft.blockentities.InfuserBlockEntity;
import com.mrbysco.forcecraft.items.flask.FlaskFluidHandler;
import com.mrbysco.forcecraft.registry.ForceRegistry;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

public class CapabilityHandler {

	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ForceRegistry.INFUSER_BLOCK_ENTITY.get(), InfuserBlockEntity::getItemHandler);
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ForceRegistry.INFUSER_BLOCK_ENTITY.get(), InfuserBlockEntity::getFluidTank);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ForceRegistry.INFUSER_BLOCK_ENTITY.get(), InfuserBlockEntity::getEnergyStorage);

		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ForceRegistry.FURNACE_BLOCK_ENTITY.get(), (sidedContainer, side) ->
				side == null ? new InvWrapper(sidedContainer) : new SidedInvWrapper(sidedContainer, side));

		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ForceRegistry.FORCE_ENGINE_BLOCK_ENTITY.get(), ForceEngineBlockEntity::getItemHandler);
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ForceRegistry.FORCE_ENGINE_BLOCK_ENTITY.get(), ForceEngineBlockEntity::getFluidTank);

		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, unused) -> new FlaskFluidHandler(stack),
				ForceRegistry.FORCE_FLASK.get(),
				ForceRegistry.FORCE_FILLED_FORCE_FLASK.get(),
				ForceRegistry.MILK_FORCE_FLASK.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, unused) -> new FluidBucketWrapper(stack),
				ForceRegistry.BUCKET_FLUID_FORCE.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, unused) -> new ItemStackHandler(4), ForceRegistry.BACONATOR.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, unused) -> new ItemStackHandler(8),
				ForceRegistry.SPOILS_BAG.get(), ForceRegistry.SPOILS_BAG_T2.get(), ForceRegistry.SPOILS_BAG_T3.get());

		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, unused) -> StorageManager.getCapability(stack), ForceRegistry.FORCE_BELT.get(), ForceRegistry.FORCE_PACK.get());
	}
}
