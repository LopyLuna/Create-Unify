package uwu.lopyluna.create_unify.forge;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import uwu.lopyluna.create_unify.Unify;

@Mod(Unify.MOD_ID)
@Mod.EventBusSubscriber
public class UnifyImpl {
    static IEventBus bus;
    public UnifyImpl() {
        bus = FMLJavaModLoadingContext.get().getModEventBus();
        Unify.init();
    }

    public static void finalizeRegistrate() {
        Unify.registrate().registerEventListeners(bus);
    }
}
