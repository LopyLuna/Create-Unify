package uwu.lopyluna.create_unify;

import uwu.lopyluna.create_unify.registry.UnifyBlocks;
import uwu.lopyluna.create_unify.registry.UnifyItems;
import uwu.lopyluna.create_unify.registry.UnifyTags;

public class ModSetup {
    public static void register() {
        UnifyItems.register();
        UnifyBlocks.register();
        UnifyTags.register();
    }
}
