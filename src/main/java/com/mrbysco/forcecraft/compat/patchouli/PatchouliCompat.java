package com.mrbysco.forcecraft.compat.patchouli;

import com.mrbysco.forcecraft.Reference;

public class PatchouliCompat {
	public static void openBook() {
		vazkii.patchouli.api.PatchouliAPI.get().openBookGUI(Reference.modLoc("force_and_you"));
	}
}
