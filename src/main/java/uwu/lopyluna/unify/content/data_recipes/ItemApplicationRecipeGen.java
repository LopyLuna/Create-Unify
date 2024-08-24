package uwu.lopyluna.unify.content.data_recipes;

import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.DataGenerator;

public class ItemApplicationRecipeGen extends UnifyProcessingRecipeGen {
    public ItemApplicationRecipeGen(DataGenerator generator) {
        super(generator);
    }


    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.ITEM_APPLICATION;
    }
}
