package uwu.lopyluna.unify.registry;

import com.simibubi.create.foundation.utility.Components;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.unify.Unify;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnifyCreativeModeTabs {
	private static final DeferredRegister<CreativeModeTab> REGISTER =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Unify.MOD_ID);

	public static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("base",
			() -> CreativeModeTab.builder()
					.title(Components.translatable("itemGroup."+ Unify.MOD_ID +".base"))
					.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
					.icon(() -> new ItemStack(UnifyMaterialProvider.TIN.ingot.get()))
					.build());

	public static void register(IEventBus modEventBus) {
		REGISTER.register(modEventBus);
	}
}
