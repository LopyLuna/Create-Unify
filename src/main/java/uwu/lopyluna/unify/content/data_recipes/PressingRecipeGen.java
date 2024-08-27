package uwu.lopyluna.unify.content.data_recipes;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.unify.registry.UnifyMaterialProvider;

@SuppressWarnings("unused")
public class PressingRecipeGen extends UnifyProcessingRecipeGen {

    GeneratedRecipe
            CAST_IRON_INGOT = create("cast_iron_ingot", b -> b
            .require(UnifyMaterialProvider.WROUGHT_IRON.ingot.get())
            .require(Items.COAL)
            .output(UnifyMaterialProvider.CAST_IRON.ingot.get(), 1)
            .requiresHeat(HeatCondition.HEATED)),
            STEEL_INGOT = create("steel_ingot", b -> b
            .require(UnifyMaterialProvider.WROUGHT_IRON.ingot.get())
            .require(UnifyMaterialProvider.WROUGHT_IRON.ingot.get())
            .require(Items.CHARCOAL)
            .output(UnifyMaterialProvider.STEEL.ingot.get(), 1)
            .requiresHeat(HeatCondition.HEATED))
    ;

    public PressingRecipeGen(PackOutput generator) {
        super(generator);
    }

    @Override
    protected @NotNull AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.COMPACTING;
    }
}
