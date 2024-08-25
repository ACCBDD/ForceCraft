package com.mrbysco.forcecraft.items.tools;

import com.mrbysco.forcecraft.items.infuser.ForceToolData;
import com.mrbysco.forcecraft.items.infuser.IForceChargingTool;
import com.mrbysco.forcecraft.registry.material.ModToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

import static com.mrbysco.forcecraft.components.ForceComponents.TOOL_ENDER;
import static com.mrbysco.forcecraft.components.ForceComponents.TOOL_WING;

public class ForceSwordItem extends SwordItem implements IForceChargingTool {

	public ForceSwordItem(Item.Properties properties) {
		super(ModToolTiers.FORCE, properties.attributes(createAttributes(ModToolTiers.FORCE, -2, -2.4F)));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		ItemStack heldStack = playerIn.getItemInHand(handIn);
		//Wing Modifier
		if (heldStack.has(TOOL_WING)) {
			Vec3 vec = playerIn.getLookAngle();
			double wantedVelocity = 1.7;
			playerIn.setDeltaMovement(vec.x * wantedVelocity, vec.y * wantedVelocity, vec.z * wantedVelocity);
			heldStack.hurtAndBreak(1, playerIn, Player.getSlotForHand(handIn));

			playerIn.getCooldowns().addCooldown(this, 20);
			level.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (level.random.nextFloat() - level.random.nextFloat()) * 0.8F);
		}
		//Ender Modifier
		if (heldStack.has(TOOL_ENDER)) {
			BlockHitResult traceResult = getPlayerPOVHitResult(level, playerIn, Fluid.NONE);
			BlockPos lookPos = traceResult.getBlockPos().relative(traceResult.getDirection());
			EntityTeleportEvent event = new EntityTeleportEvent(playerIn, lookPos.getX(), lookPos.getY(), lookPos.getZ());
			if (!NeoForge.EVENT_BUS.post(event).isCanceled()) {
				boolean flag2 = playerIn.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
				if (flag2 && !playerIn.isSilent()) {
					level.playSound((Player) null, playerIn.xo, playerIn.yo, playerIn.zo, SoundEvents.ENDERMAN_TELEPORT, playerIn.getSoundSource(), 1.0F, 1.0F);
					playerIn.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
					heldStack.hurtAndBreak(1, playerIn, Player.getSlotForHand(handIn));
					playerIn.getCooldowns().addCooldown(this, 10);
				}
			}
		}
		return super.use(level, playerIn, handIn);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		ForceToolData fd = new ForceToolData(stack);
		fd.attachInformation(tooltip);
		super.appendHoverText(stack, context, tooltip, tooltipFlag);
	}

	@Override
	public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
		return this.damageItem(stack, amount);
	}

	@Override
	public int getEnchantmentValue() {
		return 0;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}
}
