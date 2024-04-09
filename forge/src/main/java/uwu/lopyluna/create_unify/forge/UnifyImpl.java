package uwu.lopyluna.create_unify.forge;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import uwu.lopyluna.create_unify.Unify;
import uwu.lopyluna.create_unify.registry.UnifyConfig;

@Mod(Unify.MOD_ID)
@Mod.EventBusSubscriber
public class UnifyImpl {
    static IEventBus bus;
    public UnifyImpl() {
        bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        Unify.init();
        UnifyConfig.registerConfigs(modLoadingContext::registerConfig);
    }

    public static void finalizeRegistrate() {
        Unify.registrate().registerEventListeners(bus);
    }

    private void onLoadConfig(ModConfigEvent.Loading event) {
        UnifyConfig.onLoad(event.getConfig());
    }

    private void onReloadConfig(ModConfigEvent.Reloading event) {
        UnifyConfig.onReload(event.getConfig());
    }
}
