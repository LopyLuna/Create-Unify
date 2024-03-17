package uwu.lopyluna.create_unify;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uwu.lopyluna.create_unify.registry.UnifyBlocks;
import uwu.lopyluna.create_unify.registry.UnifyItems;

public class Unify {
    public static final String MOD_ID = "create_unify";
    public static final String NAME = "Create Unify";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(Unify.MOD_ID);

    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, ExampleExpectPlatform.platformName());
        UnifyBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        UnifyItems.init();
    }

    //NOTES: I'm not gonna to make datagen as It's too much for me to set up
    //Feel free to make a datagen for me otherwise for now im going to do it manually

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
