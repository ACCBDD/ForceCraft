package com.mrbysco.forcecraft.items;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.components.storage.PackStackHandler;
import com.mrbysco.forcecraft.components.storage.PackStorage;
import com.mrbysco.forcecraft.components.storage.StorageManager;
import com.mrbysco.forcecraft.menu.ForcePackMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ForcePackItem extends BaseItem {

	public ForcePackItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	@NotNull
	public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player playerIn, @NotNull InteractionHand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);

		if (playerIn.isShiftKeyDown()) {
			if (level.isClientSide) {
				com.mrbysco.forcecraft.client.gui.pack.RenameAndRecolorScreen.openScreen(stack, handIn);
			}
		} else {
			if (!level.isClientSide) {
				PackStorage data = StorageManager.getOrCreatePack(stack);
				playerIn.openMenu(Objects.requireNonNull(getContainer(stack, data.getInventory())), buf -> buf.writeInt(data.getInventory().getUpgrades()));
			}
		}
		// If it doesn't, nothing bad happens
		return super.use(level, playerIn, handIn);
	}

	@Nullable
	public MenuProvider getContainer(ItemStack stack, PackStackHandler handler) {
		return new SimpleMenuProvider((id, playerInv, player) -> new ForcePackMenu(id, playerInv, handler),
				stack.has(DataComponents.CUSTOM_NAME) ? ((MutableComponent) stack.getHoverName()).withStyle(ChatFormatting.BLACK) :
						Component.translatable(Reference.MOD_ID + ".container.pack"));
	}

	@Override
	public boolean shouldCauseReequipAnimation(@NotNull ItemStack oldStack, @NotNull ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, context, tooltip, flagIn);
		if (stack.has(ForceComponents.SLOTS_USED) && stack.has(ForceComponents.SLOTS_TOTAL)) {
			tooltip.add(Component.literal(String.format("%s/%s Slots",
					stack.getOrDefault(ForceComponents.SLOTS_USED, 0),
					stack.getOrDefault(ForceComponents.SLOTS_TOTAL, 1))));
		} else {
			tooltip.add(Component.literal("0/8 Slots"));
		}

		if (flagIn.isAdvanced() && stack.has(ForceComponents.UUID)) {
			UUID uuid = stack.get(ForceComponents.UUID);
			tooltip.add(Component.literal("ID: " + uuid.toString().substring(0, 8))
					.withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
		}
	}

	@Override
	@NotNull
	public Component getName(@NotNull ItemStack stack) {
		return ((MutableComponent) super.getName(stack)).withStyle(ChatFormatting.YELLOW);
	}
}
