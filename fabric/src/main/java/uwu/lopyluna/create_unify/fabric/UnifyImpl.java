package uwu.lopyluna.create_unify.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.api.fml.event.config.ModConfigEvent;
import uwu.lopyluna.create_unify.Unify;
import uwu.lopyluna.create_unify.registry.UnifyConfig;

public class UnifyImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        Unify.init();

        UnifyConfig.registerConfigs((t, c) -> ModLoadingContext.registerConfig(Unify.MOD_ID, t, c));

        Unify.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), Unify.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.

        ModConfigEvent.LOADING.register(UnifyConfig::onLoad);
        ModConfigEvent.RELOADING.register(UnifyConfig::onReload);
    }

    public static void finalizeRegistrate() {
        Unify.registrate().register();
    }
}
