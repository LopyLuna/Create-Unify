package uwu.lopyluna.create_unify.forge;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import uwu.lopyluna.create_unify.UnifyBlocks;
import uwu.lopyluna.create_unify.Unify;

@Mod(Unify.MOD_ID)
public class UnifyModForge {
    public UnifyModForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        UnifyBlocks.REGISTRATE.registerEventListeners(eventBus);
        Unify.init();
    }
}
