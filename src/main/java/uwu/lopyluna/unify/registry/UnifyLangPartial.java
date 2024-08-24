package uwu.lopyluna.unify.registry;

import java.util.function.BiConsumer;

@SuppressWarnings({"unused"})
public class UnifyLangPartial {
    public static void provideLang(BiConsumer<String, String> consumer) {
        consume(consumer, "itemGroup.unify.base", "Create: Unify");
        consume(consumer, "itemGroup.unify.palettes", "Unify Building Blocks");

    }

    private static void consume(BiConsumer<String, String> consumer, String key, String enUS) {
        consumer.accept(key, enUS);
    }
}
