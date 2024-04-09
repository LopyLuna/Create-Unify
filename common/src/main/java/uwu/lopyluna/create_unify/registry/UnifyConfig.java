package uwu.lopyluna.create_unify.registry;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.simibubi.create.foundation.config.ui.BaseConfigScreen;

import net.minecraft.client.gui.screens.Screen;

import org.apache.commons.lang3.tuple.Pair;

import com.simibubi.create.foundation.config.ConfigBase;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import uwu.lopyluna.create_unify.Unify;
import uwu.lopyluna.create_unify.config.UnifyConfigBase;
import uwu.lopyluna.create_unify.config.UnifyConfigClient;
import uwu.lopyluna.create_unify.config.UnifyConfigCommon;
import uwu.lopyluna.create_unify.config.UnifyConfigServer;

public class UnifyConfig {

    private static final Map<ModConfig.Type, ConfigBase> CONFIGS = new EnumMap<>(ModConfig.Type.class);

    public static UnifyConfigClient CLIENT;
    public static UnifyConfigCommon COMMON;
    public static UnifyConfigServer SERVER;

    public static ConfigBase byType(ModConfig.Type type) {
        return CONFIGS.get(type);
    }

    private static <T extends UnifyConfigBase> T register(Supplier<T> factory, ModConfig.Type side) {
        Pair<T, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(builder -> {
            T config = factory.get();
            config.registerAll(builder);
            return config;
        });

        T config = specPair.getLeft();
        config.specification = specPair.getRight();
        CONFIGS.put(side, config);
        return config;
    }

    public static void registerConfigs(BiConsumer<ModConfig.Type, ForgeConfigSpec> cons) {
        CLIENT = register(UnifyConfigClient::new, ModConfig.Type.CLIENT);
        COMMON = register(UnifyConfigCommon::new, ModConfig.Type.COMMON);
        SERVER = register(UnifyConfigServer::new, ModConfig.Type.SERVER);

        for (Entry<ModConfig.Type, ConfigBase> pair : CONFIGS.entrySet())
            cons.accept(pair.getKey(), pair.getValue().specification);

    }

    public static void onLoad(ModConfig modConfig) {
        for (ConfigBase config : CONFIGS.values())
            if (config.specification == modConfig
                    .getSpec())
                config.onLoad();
    }

    public static void onReload(ModConfig modConfig) {
        for (ConfigBase config : CONFIGS.values())
            if (config.specification == modConfig
                    .getSpec())
                config.onReload();
    }

    public static BaseConfigScreen createConfigScreen(Screen parent) {
        BaseConfigScreen.setDefaultActionFor(Unify.MOD_ID, (base) ->
                base.withSpecs(CLIENT.specification, COMMON.specification, SERVER.specification)
                        .withTitles("Client Settings", "Common Settings", "Server Settings")
        );
        return new BaseConfigScreen(parent, Unify.MOD_ID);
    }
}
