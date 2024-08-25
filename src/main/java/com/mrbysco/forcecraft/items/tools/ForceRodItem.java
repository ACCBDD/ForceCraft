package com.mrbysco.forcecraft.items.tools;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.items.BaseItem;
import com.mrbysco.forcecraft.items.infuser.ForceToolData;
import com.mrbysco.forcecraft.items.infuser.IForceChargingTool;
import com.mrbysco.forcecraft.items.nonburnable.InertCoreItem;
import com.mrbysco.forcecraft.items.nonburnable.NonBurnableItemEntity;
import com.mrbysco.forcecraft.registry.ForceRegistry;
import com.mrbysco.forcecraft.util.ForceUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mrbysco.forcecraft.Reference.MODIFIERS.MOD_ENDER;
import static com.mrbysco.forcecraft.Reference.MODIFIERS.MOD_HEALING;

public class ForceRodItem extends BaseItem implements IForceChargingTool {

	public List<Reference.MODIFIERS> applicableModifiers = new ArrayList<>();

	public ForceRodItem(Item.Properties properties) {
		super(properties.durability(75));
		setApplicableModifiers();
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		Player player = context.getPlayer();
		InteractionHand handIn = context.getHand();
		ItemStack stack = context.getItemInHand();
		if (!level.isClientSide && player != null) {
			if (level.getBlockState(pos).getBlock() instanceof FireBlock) {
				level.removeBlock(pos, false);
				List<ItemEntity> list = level.getEntitiesOfClass(ItemEntity.class,
						new AABB(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).expandTowards(0.5, 1, 0.5));
				boolean bw = false;
				for (ItemEntity itemEntity : list) {
					if (itemEntity != null) {
						if (itemEntity.getItem().getItem() instanceof InertCoreItem) {
							ItemEntity bottledWither = new NonBurnableItemEntity(level, pos.getX(), pos.getY() + 1,
									pos.getZ(), new ItemStack(ForceRegistry.BOTTLED_WITHER.get(),
									itemEntity.getItem().getCount()));
							level.addFreshEntity(bottledWither);
							stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
							bw = true;
						}
					}
				}
				if (bw) {
					for (ItemEntity itemEntity : list) {
						if (itemEntity != null) {
							if (itemEntity.getItem().getItem() instanceof InertCoreItem) {
								itemEntity.discard();
							}
						}
					}
				}
			} else {
				List<ItemEntity> list = level.getEntitiesOfClass(ItemEntity.class,
						new AABB(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).expandTowards(0.5, 1, 0.5));
				// If it is a subset of items, it will drop swap an item
				for (ItemEntity itemEntity : list) {
					if (itemEntity != null) {
						// Armor
						if (itemEntity.getItem().getItem() instanceof ArmorItem) {
							if (((ArmorItem) itemEntity.getItem().getItem())
									.getEquipmentSlot() == EquipmentSlot.CHEST) {
								if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.IRON) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.IRON_INGOT, 6)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.GOLD) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.GOLD_INGOT, 6)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.LEATHER) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(ForceRegistry.FORCE_CHEST.get(), 1)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								}
							}
							if (((ArmorItem) itemEntity.getItem().getItem())
									.getEquipmentSlot() == EquipmentSlot.LEGS) {
								if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.IRON) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.IRON_INGOT, 5)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.GOLD) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.GOLD_INGOT, 5)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.LEATHER) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(ForceRegistry.FORCE_LEGS.get(), 1)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								}
							}
							if (((ArmorItem) itemEntity.getItem().getItem())
									.getEquipmentSlot() == EquipmentSlot.FEET) {
								if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.IRON) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.IRON_INGOT, 3)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.GOLD) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.GOLD_INGOT, 3)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.LEATHER) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(ForceRegistry.FORCE_BOOTS.get(), 1)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								}
							}
							if (((ArmorItem) itemEntity.getItem().getItem())
									.getEquipmentSlot() == EquipmentSlot.HEAD) {
								if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.IRON) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.IRON_INGOT, 4)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.GOLD) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(Items.GOLD_INGOT, 4)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								} else if (((ArmorItem) itemEntity.getItem().getItem())
										.getMaterial() == ArmorMaterials.LEATHER) {
									itemEntity.discard();
									level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(),
											new ItemStack(ForceRegistry.FORCE_HELMET.get(), 1)));
									stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
								}
							}
						}
					}
				}
			}

			if (stack.has(ForceComponents.ROD_ENDER)) {
				if (player.isShiftKeyDown()) {
					stack.set(ForceComponents.ROD_POS, GlobalPos.of(player.level().dimension(), player.blockPosition()));
					player.displayClientMessage(Component.translatable("forcecraft.ender_rod.location.set").withStyle(ChatFormatting.DARK_PURPLE), true);
				} else {
					if (stack.has(ForceComponents.ROD_POS)) {
						ForceUtils.teleportPlayerToLocation(player, stack.get(ForceComponents.ROD_POS));
						stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
						player.getCooldowns().addCooldown(this, 10);
						level.playSound((Player) null, player.xo, player.yo, player.zo, SoundEvents.ENDERMAN_TELEPORT, player.getSoundSource(), 1.0F, 1.0F);
						player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
					}
				}
			}
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand handIn) {
		ItemStack stack = player.getItemInHand(handIn);

		if (player != null) {
			if (stack.has(ForceComponents.ROD_HEALING)) {
				int healingLevel = stack.getOrDefault(ForceComponents.ROD_HEALING, 1);
				player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, healingLevel - 1, false, false));
				stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
				player.getCooldowns().addCooldown(this, 10);
			}

			if (stack.has(ForceComponents.ROD_CAMO)) {
				player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1000, 0, false, false));
				stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
				player.getCooldowns().addCooldown(this, 10);
			}

			if (stack.has(ForceComponents.ROD_ENDER)) {
				if (player.isShiftKeyDown()) {
					stack.set(ForceComponents.ROD_POS, GlobalPos.of(player.level().dimension(), player.blockPosition()));
					player.displayClientMessage(Component.translatable("forcecraft.ender_rod.location.set").withStyle(ChatFormatting.DARK_PURPLE), true);
				} else {
					if (stack.has(ForceComponents.ROD_POS)) {
						ForceUtils.teleportPlayerToLocation(player, stack.get(ForceComponents.ROD_POS));
						stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
						player.getCooldowns().addCooldown(this, 10);
						level.playSound((Player) null, player.xo, player.yo, player.zo, SoundEvents.ENDERMAN_TELEPORT, player.getSoundSource(), 1.0F, 1.0F);
						player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
					}
				}
			}

			if (stack.has(ForceComponents.ROD_SIGHT)) {
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0, false, false));
				stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
				player.getCooldowns().addCooldown(this, 10);
			}

			if (stack.has(ForceComponents.ROD_LIGHT)) {
				player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1000, 0, false, false));
				stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
				player.getCooldowns().addCooldown(this, 10);
			}
			if (stack.has(ForceComponents.ROD_SPEED)) {
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10 * 20,
						stack.getOrDefault(ForceComponents.ROD_SPEED, 1) - 1,
						false, false));
				stack.hurtAndBreak(1, player, Player.getSlotForHand(handIn));
				player.getCooldowns().addCooldown(this, 10);
			}
		}

		return super.use(level, player, handIn);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand handIn) {
		if (playerIn != null) {
			if (stack.has(ForceComponents.ROD_LIGHT)) {
				target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2400, 0, false, false));
				stack.hurtAndBreak(1, playerIn, Player.getSlotForHand(handIn));
				playerIn.getCooldowns().addCooldown(this, 10);
			}
		}
		return super.interactLivingEntity(stack, playerIn, target, handIn);
	}

	public void setApplicableModifiers() {
		applicableModifiers.add(MOD_HEALING);
		applicableModifiers.add(MOD_ENDER);
	}

	@Override
	public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
		return this.damageItem(stack, amount);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		ForceToolData fd = new ForceToolData(stack);
		fd.attachInformation(tooltip);
		if (stack.has(ForceComponents.ROD_HEALING)) {
			tooltip.add(Component.translatable("item.infuser.tooltip.healing" + stack.get(ForceComponents.ROD_HEALING)).withStyle(ChatFormatting.RED));
		}
		if (stack.has(ForceComponents.ROD_SPEED)) {
			tooltip.add(Component.translatable("item.infuser.tooltip.speed" + stack.get(ForceComponents.ROD_SPEED)));
		}
		if (stack.has(ForceComponents.ROD_CAMO)) {
			tooltip.add(Component.translatable("item.infuser.tooltip.camo").withStyle(ChatFormatting.DARK_GREEN));
		}
		if (stack.has(ForceComponents.ROD_ENDER)) {
			tooltip.add(Component.translatable("item.infuser.tooltip.ender").withStyle(ChatFormatting.DARK_PURPLE));

			if (stack.has(ForceComponents.ROD_POS)) {
				GlobalPos globalPos = stack.get(ForceComponents.ROD_POS);
				if (globalPos != null) {
					BlockPos pos = globalPos.pos();
					tooltip.add(Component.translatable("forcecraft.ender_rod.location",
							pos.getX(), pos.getY(), pos.getZ(),
							globalPos.dimension().location()).withStyle(ChatFormatting.YELLOW));
				}
			} else {
				tooltip.add(Component.translatable("forcecraft.ender_rod.unset").withStyle(ChatFormatting.RED));
			}
			tooltip.add(Component.translatable("forcecraft.ender_rod.text").withStyle(ChatFormatting.GRAY));
		}
		if (stack.has(ForceComponents.ROD_SIGHT)) {
			tooltip.add(Component.translatable("item.infuser.tooltip.sight").withStyle(ChatFormatting.LIGHT_PURPLE));
		}
		if (stack.has(ForceComponents.ROD_LIGHT)) {
			tooltip.add(Component.translatable("item.infuser.tooltip.light").withStyle(ChatFormatting.YELLOW));
		}
		super.appendHoverText(stack, context, tooltip, tooltipFlag);
	}
}