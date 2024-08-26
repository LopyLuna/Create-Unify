package uwu.lopyluna.unify.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.unify.UnifyCreate;

@SuppressWarnings("unused")
public class UnifySoundEvents {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
			DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, UnifyCreate.MOD_ID);

	//public static RegistryObject<SoundEvent> CREATVEDITE_BREAK = registerSoundEvent("creatvedite_break");*
	//public static RegistryObject<SoundEvent> CREATVEDITE_STEP = registerSoundEvent("creatvedite_step");*
	//public static RegistryObject<SoundEvent> CREATVEDITE_PLACE = registerSoundEvent("creatvedite_place");*
	//public static RegistryObject<SoundEvent> CREATVEDITE_HIT = registerSoundEvent("creatvedite_hit");*
	//public static RegistryObject<SoundEvent> CREATVEDITE_FALL = registerSoundEvent("creatvedite_fall");*

	public static ForgeSoundType METAL_HEAVY = newSoundType(1.0F, 0.5F, SoundEvents.POLISHED_DEEPSLATE_BREAK, SoundEvents.POLISHED_DEEPSLATE_STEP, SoundEvents.POLISHED_DEEPSLATE_PLACE, SoundEvents.POLISHED_DEEPSLATE_HIT, SoundEvents.POLISHED_DEEPSLATE_FALL);
	public static ForgeSoundType NETHERITE_BLOCK_HEAVY = newSoundType(1.0F, 0.5F, SoundEvents.NETHERITE_BLOCK_BREAK, SoundEvents.NETHERITE_BLOCK_STEP, SoundEvents.NETHERITE_BLOCK_PLACE, SoundEvents.NETHERITE_BLOCK_HIT, SoundEvents.NETHERITE_BLOCK_FALL);
	public static ForgeSoundType COPPER_HEAVY = newSoundType(1.0F, 0.5F, SoundEvents.COPPER_BREAK, SoundEvents.COPPER_STEP, SoundEvents.COPPER_PLACE, SoundEvents.COPPER_HIT, SoundEvents.COPPER_FALL);

	public static ForgeSoundType newSoundType(float volumeIn, float pitchIn, SoundEvent breakSoundIn, SoundEvent stepSoundIn, SoundEvent placeSoundIn, SoundEvent hitSoundIn, SoundEvent fallSoundIn) {
		return new ForgeSoundType(volumeIn, pitchIn, () -> breakSoundIn, () -> stepSoundIn, () -> placeSoundIn, () -> hitSoundIn, () -> fallSoundIn);
	}

	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(UnifyCreate.MOD_ID, name)));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
