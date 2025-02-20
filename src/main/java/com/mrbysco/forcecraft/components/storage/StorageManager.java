package com.mrbysco.forcecraft.components.storage;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.components.ForceComponents;
import com.mrbysco.forcecraft.items.ForceBeltItem;
import com.mrbysco.forcecraft.items.ForcePackItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class StorageManager {
	public static boolean isServer() {
		return Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER;
	}

	private static final BeltWSD blankBelts = new BeltWSD();
	private static final PackWSD blankPacks = new PackWSD();

	protected static BeltWSD cachedBelts;
	protected static PackWSD cachedPacks;

	public static BeltWSD getBelts() {
		if (isServer()) {
			if (cachedBelts == null)
				cachedBelts = ServerLifecycleHooks.getCurrentServer().getLevel(Level.OVERWORLD).getDataStorage()
						.computeIfAbsent(new SavedData.Factory<>(BeltWSD::new, BeltWSD::load), BeltWSD.NAME);

			return cachedBelts;
		}
		//just in case the client calls this somehow...
		return blankBelts;
	}

	public static PackWSD getPacks() {
		if (isServer()) {
			if (cachedPacks == null)
				cachedPacks = ServerLifecycleHooks.getCurrentServer().getLevel(Level.OVERWORLD).getDataStorage().
						computeIfAbsent(new SavedData.Factory<>(PackWSD::new, PackWSD::load), PackWSD.NAME);

			return cachedPacks;
		}
		//just in case the client calls this somehow...
		return blankPacks;
	}

	public static BeltStorage getOrCreateBelt(ItemStack stack) {
		UUID uuid;
		BeltWSD data = getBelts();

		if (!stack.has(ForceComponents.UUID)) {
			uuid = UUID.randomUUID();
			stack.set(ForceComponents.UUID, uuid);
		} else {
			uuid = stack.get(ForceComponents.UUID);
		}

		return data.getOrCreate(uuid);
	}

	public static Optional<BeltStorage> getBelt(ItemStack stack) {
		if (stack.has(ForceComponents.UUID)) {
			BeltWSD data = getBelts();
			UUID uuid = stack.get(ForceComponents.UUID);
			if (data.contains(uuid)) {
				return Optional.of(data.get(uuid));
			}
		}
		return Optional.empty();
	}

	public static Optional<BeltStorage> getBelt(UUID uuid) {
		BeltWSD data = getBelts();
		if (data.contains(uuid)) {
			return Optional.of(data.get(uuid));
		}
		return Optional.empty();
	}

	public static PackStorage getOrCreatePack(ItemStack stack) {
		UUID uuid;
		PackWSD data = getPacks();

		if (!stack.has(ForceComponents.UUID)) {
			uuid = UUID.randomUUID();
			stack.set(ForceComponents.UUID, uuid);
		} else {
			uuid = stack.get(ForceComponents.UUID);
		}

		return data.getOrCreate(uuid);
	}

	public static Optional<PackStorage> getPack(ItemStack stack) {
		if (stack.has(ForceComponents.UUID)) {
			PackWSD data = getPacks();
			UUID uuid = stack.get(ForceComponents.UUID);
			if (data.contains(uuid)) {
				return Optional.of(data.get(uuid));
			}
		}
		return Optional.empty();
	}

	public static Optional<PackStorage> getPack(UUID uuid) {
		PackWSD data = getPacks();
		if (data.contains(uuid)) {
			return Optional.of(data.get(uuid));
		}
		return Optional.empty();
	}


	public static Optional<UUID> getUUID(ItemStack stack) {
		if (stack.has(ForceComponents.UUID)) {
			return Optional.of(stack.get(ForceComponents.UUID));
		}
		return Optional.empty();
	}

	public static IItemHandler getCapability(ItemStack stack) {
		if (isServer()) {
			if (stack.has(ForceComponents.UUID)) {
				UUID uuid = stack.get(ForceComponents.UUID);
				if (stack.getItem() instanceof ForceBeltItem) {
					return getBelt(uuid).map(BeltStorage::getInventory).orElse(null);
				} else if (stack.getItem() instanceof ForcePackItem) {
					return getPack(uuid).map(PackStorage::getInventory).orElse(null);
				}
			}
		}
		return null;
	}


	public static class PackWSD extends SavedData {
		public static final String NAME = Reference.MOD_ID + "_packs";

		protected final HashMap<UUID, PackStorage> PACKS = new HashMap<>();

		public HashMap<UUID, PackStorage> get() {
			return PACKS;
		}

		public boolean contains(UUID uuid) {
			return PACKS.containsKey(uuid);
		}

		public PackStorage get(UUID uuid) {
			return PACKS.get(uuid);
		}

		public PackStorage getOrCreate(UUID uuid) {
			return PACKS.computeIfAbsent(uuid, id -> {
				setDirty();
				return new PackStorage(uuid);
			});
		}

		public static PackWSD load(CompoundTag tag, HolderLookup.Provider provider) {
			PackWSD data = new PackWSD();
			if (tag.contains("packs")) {
				ListTag list = tag.getList("packs", Tag.TAG_COMPOUND);
				list.forEach((invNBT) -> data.PACKS.put(((CompoundTag) invNBT).getUUID("uuid"),
						new PackStorage((CompoundTag) invNBT, provider)));
			}
			return data;
		}

		@Override
		@NotNull
		public CompoundTag save(CompoundTag compound, HolderLookup.Provider provider) {
			ListTag packs = new ListTag();
			PACKS.forEach(((uuid, data) -> packs.add(data.toNBT(provider))));
			compound.put("packs", packs);
			return compound;
		}
	}

	protected static class BeltWSD extends SavedData {
		public static final String NAME = Reference.MOD_ID + "_belts";

		protected final HashMap<UUID, BeltStorage> BELTS = new HashMap<>();

		public HashMap<UUID, BeltStorage> get() {
			return BELTS;
		}

		public boolean contains(UUID uuid) {
			return BELTS.containsKey(uuid);
		}

		public BeltStorage get(UUID uuid) {
			return BELTS.get(uuid);
		}

		public BeltStorage getOrCreate(UUID uuid) {
			return BELTS.computeIfAbsent(uuid, id -> {
				setDirty();
				return new BeltStorage(uuid);
			});
		}

		public static BeltWSD load(CompoundTag tag, HolderLookup.Provider provider) {
			BeltWSD data = new BeltWSD();
			if (tag.contains("belts")) {
				ListTag list = tag.getList("belts", Tag.TAG_COMPOUND);
				list.forEach((invNBT) -> data.BELTS.put(((CompoundTag) invNBT).getUUID("uuid"),
						new BeltStorage((CompoundTag) invNBT, provider)));
			}
			return data;
		}

		@Override
		@NotNull
		public CompoundTag save(CompoundTag compound, HolderLookup.Provider provider) {
			ListTag belts = new ListTag();
			BELTS.forEach(((uuid, data) -> belts.add(data.toNBT(provider))));
			compound.put("belts", belts);
			return compound;
		}
	}
}
