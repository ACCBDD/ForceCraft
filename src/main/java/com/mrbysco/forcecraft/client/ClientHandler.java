package com.mrbysco.forcecraft.client;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.client.gui.belt.ForceBeltScreen;
import com.mrbysco.forcecraft.client.gui.card.ItemCardScreen;
import com.mrbysco.forcecraft.client.gui.engine.ForceEngineScreen;
import com.mrbysco.forcecraft.client.gui.furnace.ForceFurnaceScreen;
import com.mrbysco.forcecraft.client.gui.infuser.InfuserScreen;
import com.mrbysco.forcecraft.client.gui.pack.ForcePackScreen;
import com.mrbysco.forcecraft.client.gui.spoils.SpoilsBagScreen;
import com.mrbysco.forcecraft.client.model.CreeperTotModel;
import com.mrbysco.forcecraft.client.model.EnderTotModel;
import com.mrbysco.forcecraft.client.model.FairyModel;
import com.mrbysco.forcecraft.client.renderer.BlueChuChuRenderer;
import com.mrbysco.forcecraft.client.renderer.ColdChickenRenderer;
import com.mrbysco.forcecraft.client.renderer.ColdCowRenderer;
import com.mrbysco.forcecraft.client.renderer.ColdPigRenderer;
import com.mrbysco.forcecraft.client.renderer.CreeperTotRenderer;
import com.mrbysco.forcecraft.client.renderer.EnderTotRenderer;
import com.mrbysco.forcecraft.client.renderer.FairyRenderer;
import com.mrbysco.forcecraft.client.renderer.ForceArrowRenderer;
import com.mrbysco.forcecraft.client.renderer.GoldChuChuRenderer;
import com.mrbysco.forcecraft.client.renderer.GreenChuChuRenderer;
import com.mrbysco.forcecraft.client.renderer.RedChuChuRenderer;
import com.mrbysco.forcecraft.items.BaconatorItem;
import com.mrbysco.forcecraft.registry.ForceEntities;
import com.mrbysco.forcecraft.registry.ForceFluids;
import com.mrbysco.forcecraft.registry.ForceMenus;
import com.mrbysco.forcecraft.registry.ForceRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

import static com.mrbysco.forcecraft.attachment.ForceAttachments.MAGNET;

public class ClientHandler {
	public static final ModelLayerLocation CREEPER_TOT = new ModelLayerLocation(Reference.modLoc("creeper_tot"), "main");
	public static final ModelLayerLocation FAIRY = new ModelLayerLocation(Reference.modLoc("fairy"), "main");
	public static final ModelLayerLocation ENDERTOT = new ModelLayerLocation(Reference.modLoc("endertot"), "main");

	public static void onClientSetup(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(ForceFluids.FORCE_FLUID_FLOWING.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ForceFluids.FORCE_FLUID_SOURCE.get(), RenderType.translucent());

		event.enqueueWork(() -> {
			ItemProperties.register(ForceRegistry.MAGNET_GLOVE.get(), new ResourceLocation("active"), (stack, world, livingEntity, i) ->
					stack.hasData(MAGNET) && stack.getData(MAGNET).isActivated() ? 1.0F : 0.0F);

			ItemProperties.register(ForceRegistry.ENTITY_FLASK.get(), new ResourceLocation("captured"), (stack, world, livingEntity, i) ->
					stack.hasTag() && stack.getTag().contains("StoredEntity") ? 1.0F : 0.0F);

			ItemProperties.register(ForceRegistry.BACONATOR.get(), new ResourceLocation("filled"), (stack, world, livingEntity, i) ->
					stack.hasTag() && stack.getTag().contains(BaconatorItem.HAS_FOOD_TAG) ? 1.0F : 0.0F);

			ItemProperties.register(ForceRegistry.FORCE_PACK.get(), new ResourceLocation("color"), (stack, world, livingEntity, i) ->
					stack.hasTag() && stack.getTag().contains("Color") ? (1.0F / 16) * stack.getTag().getInt("Color") : 0.9375F);

			ItemProperties.register(ForceRegistry.FORCE_BELT.get(), new ResourceLocation("color"), (stack, world, livingEntity, i) ->
					stack.hasTag() && stack.getTag().contains("Color") ? (1.0F / 16) * stack.getTag().getInt("Color") : 0.9375F);

			ItemProperties.register(ForceRegistry.FORCE_BOW.get(), new ResourceLocation("pull"), (stack, world, livingEntity, i) -> {
				if (livingEntity == null) {
					return 0.0F;
				} else {
					return livingEntity.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
				}
			});
			ItemProperties.register(ForceRegistry.FORCE_BOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity, i) ->
					livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F);
		});
	}

	public static void onRegisterMenu(final RegisterMenuScreensEvent event) {
		event.register(ForceMenus.FORCE_FURNACE.get(), ForceFurnaceScreen::new);
		event.register(ForceMenus.INFUSER.get(), InfuserScreen::new);
		event.register(ForceMenus.FORCE_BELT.get(), ForceBeltScreen::new);
		event.register(ForceMenus.FORCE_PACK.get(), ForcePackScreen::new);
		event.register(ForceMenus.SPOILS_BAG.get(), SpoilsBagScreen::new);
		event.register(ForceMenus.ITEM_CARD.get(), ItemCardScreen::new);
		event.register(ForceMenus.FORCE_ENGINE.get(), ForceEngineScreen::new);
	}

	public static void registerKeymapping(final RegisterKeyMappingsEvent event) {
		event.register(KeybindHandler.KEY_OPEN_HOTBAR_PACK);
		event.register(KeybindHandler.KEY_OPEN_HOTBAR_BELT);
		event.register(KeybindHandler.KEY_QUICK_USE_1);
		event.register(KeybindHandler.KEY_QUICK_USE_2);
		event.register(KeybindHandler.KEY_QUICK_USE_3);
		event.register(KeybindHandler.KEY_QUICK_USE_4);
		event.register(KeybindHandler.KEY_QUICK_USE_5);
		event.register(KeybindHandler.KEY_QUICK_USE_6);
		event.register(KeybindHandler.KEY_QUICK_USE_7);
		event.register(KeybindHandler.KEY_QUICK_USE_8);
	}


	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(CREEPER_TOT, CreeperTotModel::createBodyLayer);
		event.registerLayerDefinition(ENDERTOT, EnderTotModel::createBodyLayer);
		event.registerLayerDefinition(FAIRY, FairyModel::createBodyLayer);
	}

	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ForceEntities.NON_BURNABLE_ITEM.get(), ItemEntityRenderer::new);
		event.registerEntityRenderer(ForceEntities.COLD_CHICKEN.get(), ColdChickenRenderer::new);
		event.registerEntityRenderer(ForceEntities.COLD_COW.get(), ColdCowRenderer::new);
		event.registerEntityRenderer(ForceEntities.COLD_PIG.get(), ColdPigRenderer::new);
		event.registerEntityRenderer(ForceEntities.RED_CHU_CHU.get(), RedChuChuRenderer::new);
		event.registerEntityRenderer(ForceEntities.GREEN_CHU_CHU.get(), GreenChuChuRenderer::new);
		event.registerEntityRenderer(ForceEntities.BLUE_CHU_CHU.get(), BlueChuChuRenderer::new);
		event.registerEntityRenderer(ForceEntities.GOLD_CHU_CHU.get(), GoldChuChuRenderer::new);
		event.registerEntityRenderer(ForceEntities.FAIRY.get(), FairyRenderer::new);
		event.registerEntityRenderer(ForceEntities.CREEPER_TOT.get(), CreeperTotRenderer::new);
		event.registerEntityRenderer(ForceEntities.ENDER_TOT.get(), EnderTotRenderer::new);
		event.registerEntityRenderer(ForceEntities.ANGRY_ENDERMAN.get(), EndermanRenderer::new);
		event.registerEntityRenderer(ForceEntities.FORCE_ARROW.get(), ForceArrowRenderer::new);
		event.registerEntityRenderer(ForceEntities.FORCE_FLASK.get(), ThrownItemRenderer::new);
	}

	public static void registerItemColors(final RegisterColorHandlersEvent.Item event) {
		event.register((stack, tintIndex) -> {
			if (tintIndex == 0 || tintIndex == 1) {
				if (stack.hasTag() && stack.getTag().contains("StoredEntity", CompoundTag.TAG_STRING)) {
					ResourceLocation id = new ResourceLocation(stack.getTag().getString("StoredEntity"));
					SpawnEggItem info = SpawnEggItem.byId(BuiltInRegistries.ENTITY_TYPE.get(id));

					if (info != null) {
						return tintIndex == 0 ? info.getColor(0) : info.getColor(1);
					} else {
						return tintIndex == 0 ? 10489616 : tintIndex == 1 ? 951412 : 0xFFFFFF;
					}
				}
				return 0xFFFFFF;
			}
			return 0xFFFFFF;
		}, ForceRegistry.ENTITY_FLASK.get());
	}
}
