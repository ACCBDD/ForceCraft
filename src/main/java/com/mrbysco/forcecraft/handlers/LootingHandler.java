package com.mrbysco.forcecraft.handlers;

public class LootingHandler {

//	@SubscribeEvent
//	public void onLooting(LootingLevelEvent event) { TODO: Somehow re-implement Luck or scrap it!
//		final DamageSource source = event.getDamageSource();
//		if (source == null || source.getEntity() == null) {
//			return;
//		}
//
//		int level = event.getLootingLevel();
//
//		int customLevel = 0;
//		if (source.getEntity().hasData(PLAYER_MOD)) {
//			customLevel += source.getEntity().getData(PLAYER_MOD).getLuckLevel();
//		}
//
//		if (source.getDirectEntity() instanceof ForceArrowEntity forceArrow) {
//			customLevel += forceArrow.getLuck();
//		}
//
//		if (customLevel > 4) {
//			customLevel = 4;
//		}
//		level += customLevel;
//
//		event.setLootingLevel(level);
//	}

//	@SubscribeEvent
//	public void onTreasureDrop(LivingDropsEvent event) { TODO: Implement looting or scrap it!
//		if (event.getSource() == null || event.getSource().getEntity() == null) {
//			return;
//		}
//
//		Entity source = event.getSource().getEntity();
//		if (source instanceof Player player) {
//			ItemStack heldStack = player.getMainHandItem();
//			if (heldStack.hasData(TOOL_MODIFIER)) {
//				ToolModifierData attachment = heldStack.getData(TOOL_MODIFIER);
//				if (attachment.hasTreasure()) {
//					RandomSource rand = player.getRandom();
//					int looting = event.getLootingLevel();
//					LivingEntity entity = event.getEntity();
//					BlockPos entityPos = entity.blockPosition();
//
//					int chanceMax = 20;
//					if (looting > 0) {
//						chanceMax = chanceMax / looting;
//						if (chanceMax < 0) {
//							chanceMax = 1;
//						}
//					}
//					float dropChance = rand.nextInt(chanceMax);
//					if (dropChance == 0) {
//						if (entity.isInvertedHealAndHarm()) {
//							event.getDrops().add(new ItemEntity(entity.level(), entityPos.getX(), entityPos.getY(), entityPos.getZ(), new ItemStack(ForceRegistry.UNDEATH_CARD.get(), rand.nextInt(Math.max(1, looting)) + 1)));
//						} else {
//							if (entity instanceof Monster) {
//								event.getDrops().add(new ItemEntity(entity.level(), entityPos.getX(), entityPos.getY(), entityPos.getZ(), new ItemStack(ForceRegistry.DARKNESS_CARD.get(), rand.nextInt(Math.max(1, looting)) + 1)));
//							} else {
//								event.getDrops().add(new ItemEntity(entity.level(), entityPos.getX(), entityPos.getY(), entityPos.getZ(), new ItemStack(ForceRegistry.LIFE_CARD.get(), rand.nextInt(Math.max(1, looting)) + 1)));
//							}
//						}
//					}
//				}
//			}
//		}
//	}
}
