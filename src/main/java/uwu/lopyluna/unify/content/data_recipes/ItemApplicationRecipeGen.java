package uwu.lopyluna.unify.content.data_recipes;

import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

public class ItemApplicationRecipeGen extends UnifyProcessingRecipeGen {
    public ItemApplicationRecipeGen(PackOutput generator) {
        super(generator);
    }


    @Override
    protected @NotNull AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.ITEM_APPLICATION;
    }
}
