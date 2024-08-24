package uwu.lopyluna.unify.registry;

import java.util.function.BiConsumer;

@SuppressWarnings({"unused", "SameParameterValue"})
public class UnifyLangPartial {
    public static void provideLang(BiConsumer<String, String> consumer) {
        consume(consumer, "itemGroup.unify.base", "Create: Unify");

    }

    private static void consume(BiConsumer<String, String> consumer, String key, String enUS) {
        consumer.accept(key, enUS);
    }
}
