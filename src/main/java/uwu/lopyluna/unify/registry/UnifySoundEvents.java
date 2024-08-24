package uwu.lopyluna.unify.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
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

	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(UnifyCreate.MOD_ID, name)));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
