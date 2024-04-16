package uwu.lopyluna.create_unify.fabric;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;
import uwu.lopyluna.create_unify.Unify;

public class UnifyCE {

    public static void addPackFinders() {
        ModContainer create = FabricLoader.getInstance().getModContainer(Unify.MOD_ID)
                .orElseThrow(() -> new IllegalStateException("Create's ModContainer couldn't be found!"));
        ResourceLocation packId_cbc = Unify.asResource("legacy_big_cannons");
        ResourceLocation packId_cdnd = Unify.asResource("legacy_dreams_n_desires");
        ResourceManagerHelper.registerBuiltinResourcePack(packId_cbc, create, "Legacy Create Big Cannons", ResourcePackActivationType.NORMAL);
        ResourceManagerHelper.registerBuiltinResourcePack(packId_cdnd, create, "Legacy Create Dreams n Desires", ResourcePackActivationType.NORMAL);
    }

    public static void register() {
        UnifyCE.addPackFinders();
    }
}
