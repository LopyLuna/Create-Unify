package uwu.lopyluna.unify.registry.helper;

import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.LangBuilder;
import net.minecraft.network.chat.MutableComponent;
import uwu.lopyluna.unify.UnifyCreate;

public class Lang extends com.simibubi.create.foundation.utility.Lang {

    public static MutableComponent translateDirect(String key, Object... args) {
        return Components.translatable(UnifyCreate.MOD_ID + "." + key, resolveBuilders(args));
    }

    public static LangBuilder builder() {
        return new LangBuilder(UnifyCreate.MOD_ID);
    }
}
