package com.mrbysco.forcecraft.entities.projectile;

import com.mrbysco.forcecraft.ForceCraft;
import com.mrbysco.forcecraft.attachments.ForceAttachments;
import com.mrbysco.forcecraft.attachments.banemodifier.BaneModifierAttachment;
import com.mrbysco.forcecraft.registry.ForceEntities;
import com.mrbysco.forcecraft.registry.ForceRegistry;
import com.mrbysco.forcecraft.util.ForceUtils;
import com.mrbysco.forcecraft.util.MobUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.SwellGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ForceArrowEntity extends Arrow {
	private static final EntityDataAccessor<Boolean> ENDER = SynchedEntityData.defineId(ForceArrowEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> BANE = SynchedEntityData.defineId(ForceArrowEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SPEED = SynchedEntityData.defineId(ForceArrowEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> GLOWING = SynchedEntityData.defineId(ForceArrowEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> LUCK = SynchedEntityData.defineId(ForceArrowEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> BLEEDING = SynchedEntityData.defineId(ForceArrowEntity.class, EntityDataSerializers.INT);

	public ForceArrowEntity(EntityType<? extends Arrow> type, Level level) {
		super(type, level);
	}

	public ForceArrowEntity(Level level, LivingEntity shooter) {
		super(ForceEntities.FORCE_ARROW.get(), level);
		this.setOwner(shooter);
	}

	public ForceArrowEntity(Level level, LivingEntity shooter, ItemStack itemStack, @Nullable ItemStack weapon) {
		super(level, shooter, itemStack, weapon);
	}

	@Override
	public void shootFromRotation(Entity projectile, float x, float y, float z, float velocity, float inaccuracy) {
		float newVelocity = isSpeedy() ? velocity + 1.0F : velocity;
		super.shootFromRotation(projectile, x, y, z, newVelocity, inaccuracy);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(ENDER, false);
		builder.define(BANE, false);
		builder.define(LUCK, 0);
		builder.define(BLEEDING, 0);
		builder.define(SPEED, false);
		builder.define(GLOWING, false);
	}

	public boolean isBane() {
		return this.entityData.get(BANE);
	}

	public void setBane() {
		this.entityData.set(BANE, true);
	}

	public boolean isSpeedy() {
		return this.entityData.get(SPEED);
	}

	public void setSpeedy() {
		this.entityData.set(SPEED, true);
	}

	public boolean isEnder() {
		return this.entityData.get(ENDER);
	}

	public void setEnder() {
		this.entityData.set(ENDER, true);
	}

	public boolean appliesGlowing() {
		return this.entityData.get(GLOWING);
	}

	public void setAppliesGlowing() {
		this.entityData.set(GLOWING, true);
	}

	public int getLuck() {
		return this.entityData.get(LUCK);
	}

	public void setLuck(int luck) {
		this.entityData.set(LUCK, luck);
	}

	public int getBleeding() {
		return this.entityData.get(BLEEDING);
	}

	public void setBleeding(int bleeding) {
		this.entityData.set(BLEEDING, bleeding);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);

		if (compound.getBoolean("Bane")) {
			setBane();
		}
		if (compound.getBoolean("Ender")) {
			setEnder();
		}
		if (compound.getBoolean("AppliesGlowing")) {
			setAppliesGlowing();
		}
		if (compound.getBoolean("Speedy")) {
			setSpeedy();
		}
		this.setLuck(compound.getInt("Luck"));
		this.setBleeding(compound.getInt("Bleeding"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);

		if (isBane()) {
			compound.putBoolean("Bane", true);
		}
		if (isEnder()) {
			compound.putBoolean("Ender", true);
		}
		if (appliesGlowing()) {
			compound.putBoolean("AppliesGlowing", true);
		}
		if (isSpeedy()) {
			compound.putBoolean("Speedy", true);
		}
		compound.putInt("Luck", getLuck());
		compound.putInt("Bleeding", getBleeding());
	}

//	@Override
//	public void setEffectsFromItem(ItemStack stack) {
//		if (stack.getItem() == Items.ARROW) {
//			this.potion = Potions.EMPTY;
//			this.effects.clear();
//			this.entityData.set(ID_EFFECT_COLOR, -1);
//		}
//	}

	@Override
	protected void doPostHurtEffects(LivingEntity living) {
		super.doPostHurtEffects(living);

		if (isEnder()) {
			ForceUtils.teleportRandomly(living);
		}

		if (appliesGlowing()) {
			living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0));
		}

		if (getBleeding() > 0) {
			MobUtil.addBleedingEffect(getBleeding(), living, getOwner());
		}

		if (isBane()) {
			if (living instanceof Creeper creeper) {
				BaneModifierAttachment attachment = creeper.getData(ForceAttachments.BANE_MODIFIER);
				if (attachment.canExplode()) {
					creeper.setSwellDir(-1);
					creeper.getEntityData().set(Creeper.DATA_IS_IGNITED, false);
					attachment.setExplodeAbility(false);
					creeper.goalSelector.getAvailableGoals().removeIf(goal -> goal.getGoal() instanceof SwellGoal);
					ForceCraft.LOGGER.debug("Added Bane to {}", living.getName());

					creeper.setData(ForceAttachments.BANE_MODIFIER, attachment);
				}
			}
		}
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(ForceRegistry.FORCE_ARROW.get());
	}

	@Override
	public EntityType<?> getType() {
		return ForceEntities.FORCE_ARROW.get();
	}
}
