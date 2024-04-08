package com.mrbysco.forcecraft.attachment;

import com.mrbysco.forcecraft.Reference;
import com.mrbysco.forcecraft.attachment.banemodifier.BaneModifierAttachment;
import com.mrbysco.forcecraft.attachment.experiencetome.ExperienceTomeAttachment;
import com.mrbysco.forcecraft.attachment.forcerod.ForceRodAttachment;
import com.mrbysco.forcecraft.attachment.forcewrench.ForceWrenchAttachment;
import com.mrbysco.forcecraft.attachment.magnet.MagnetAttachment;
import com.mrbysco.forcecraft.attachment.playermodifier.PlayerModifierAttachment;
import com.mrbysco.forcecraft.attachment.toolmodifier.ToolModifierAttachment;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ForceAttachments {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, Reference.MOD_ID);

	public static final Supplier<AttachmentType<ToolModifierAttachment>> TOOL_MODIFIER = ATTACHMENT_TYPES.register("tool_modifier", () -> AttachmentType.serializable(ToolModifierAttachment::new).build());
	public static final Supplier<AttachmentType<ForceRodAttachment>> FORCE_ROD = ATTACHMENT_TYPES.register("force_rod", () -> AttachmentType.serializable(ForceRodAttachment::new).build());
	public static final Supplier<AttachmentType<ExperienceTomeAttachment>> EXP_TOME = ATTACHMENT_TYPES.register("exp_tome", () -> AttachmentType.serializable(ExperienceTomeAttachment::new).build());
	public static final Supplier<AttachmentType<BaneModifierAttachment>> BANE_MODIFIER = ATTACHMENT_TYPES.register("bane_modifier", () -> AttachmentType.serializable(BaneModifierAttachment::new).build());
	public static final Supplier<AttachmentType<PlayerModifierAttachment>> PLAYER_MOD = ATTACHMENT_TYPES.register("player_mod", () -> AttachmentType.serializable(PlayerModifierAttachment::new).build());
	public static final Supplier<AttachmentType<ForceWrenchAttachment>> FORCE_WRENCH = ATTACHMENT_TYPES.register("force_wrench", () -> AttachmentType.serializable(ForceWrenchAttachment::new).build());
	public static final Supplier<AttachmentType<MagnetAttachment>> MAGNET = ATTACHMENT_TYPES.register("magnet", () -> AttachmentType.serializable(MagnetAttachment::new).build());

}
