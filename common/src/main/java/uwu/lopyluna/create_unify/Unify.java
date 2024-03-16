package uwu.lopyluna.create_unify;

import com.simibubi.create.Create;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unify {
    public static final String MOD_ID = "create_unify";
    public static final String NAME = "Create Unify";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, ExampleExpectPlatform.platformName());
        UnifyBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    public static ResourceLocation mod_ID(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
