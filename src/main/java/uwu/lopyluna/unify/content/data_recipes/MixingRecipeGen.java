package uwu.lopyluna.unify.content.data_recipes;

import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.DataGenerator;

@SuppressWarnings({"all"})
public class MixingRecipeGen extends UnifyProcessingRecipeGen {

    //GeneratedRecipe
    //;

    public MixingRecipeGen(DataGenerator generator) {
        super(generator);
    }


    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
