package com.mrbysco.forcecraft.items.tools;

import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.items.BaseItem;
import com.mrbysco.forcecraft.registry.ForceEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.FakePlayer;

import java.util.List;

import static com.mrbysco.forcecraft.components.ForceComponents.MAGNET;

public class MagnetGloveItem extends BaseItem {

	public MagnetGloveItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		if (playerIn.isShiftKeyDown()) {
			ItemStack stack = playerIn.getItemInHand(handIn);
			boolean state = stack.getOrDefault(MAGNET, false);
			stack.set(MAGNET, !state);
			level.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.NEUTRAL, 1.0F, 1.0F);
		}
		return super.use(level, playerIn, handIn);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof Player && !(entityIn instanceof FakePlayer)) {
			if (itemSlot >= 0 && itemSlot <= Inventory.getSelectionSize()) {
				boolean state = stack.getOrDefault(MAGNET, false);
				if (state) {
					((Player) entityIn).addEffect(new MobEffectInstance(ForceEffects.MAGNET, 20, 1, true, false));
				}
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltip, tooltipFlag);
		if (stack.has(ForceComponents.MAGNET)) {
			boolean activated = stack.getOrDefault(ForceComponents.MAGNET, false);
			if (activated) {
				tooltip.add(Component.translatable("forcecraft.magnet_glove.active").withStyle(ChatFormatting.GREEN));
			} else {
				tooltip.add(Component.translatable("forcecraft.magnet_glove.deactivated").withStyle(ChatFormatting.RED));
			}
			tooltip.add(Component.empty());
			tooltip.add(Component.translatable("forcecraft.magnet_glove.change").withStyle(ChatFormatting.BOLD));
		}
	}
}
