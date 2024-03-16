package uwu.lopyluna.create_unify.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import uwu.lopyluna.create_unify.UnifyBlocks;
import uwu.lopyluna.create_unify.Unify;

public class UnifyModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Unify.init();
        Unify.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), Unify.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        UnifyBlocks.REGISTRATE.register();
    }
}
