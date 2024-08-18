package com.mrbysco.forcecraft.networking;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.networking.handler.ClientPayloadHandler;
import com.mrbysco.forcecraft.networking.handler.ServerPayloadHandler;
import com.mrbysco.forcecraft.networking.message.OpenInventoryPayload;
import com.mrbysco.forcecraft.networking.message.PackChangePayload;
import com.mrbysco.forcecraft.networking.message.QuickUseBeltPayload;
import com.mrbysco.forcecraft.networking.message.RecipeToCardPayload;
import com.mrbysco.forcecraft.networking.message.SaveCardRecipePayload;
import com.mrbysco.forcecraft.networking.message.StopInfuserSoundPayload;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class PacketHandler {

	public static void setupPackets(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(Reference.MOD_ID);

		registrar.playToClient(StopInfuserSoundPayload.ID, StopInfuserSoundPayload.CODEC, ClientPayloadHandler.getInstance()::handleStopData);

		registrar.playToServer(OpenInventoryPayload.ID, OpenInventoryPayload.CODEC, ServerPayloadHandler.getInstance()::handleOpen);
		registrar.playToServer(QuickUseBeltPayload.ID, QuickUseBeltPayload.CODEC, ServerPayloadHandler.getInstance()::handleQuickUse);
		registrar.playToServer(PackChangePayload.ID, PackChangePayload.CODEC, ServerPayloadHandler.getInstance()::handlePackChange);
		registrar.playToServer(RecipeToCardPayload.ID, RecipeToCardPayload.CODEC, ServerPayloadHandler.getInstance()::handleCard);
		registrar.playToServer(SaveCardRecipePayload.ID, SaveCardRecipePayload.CODEC, ServerPayloadHandler.getInstance()::handleSaveCard);
	}
}
