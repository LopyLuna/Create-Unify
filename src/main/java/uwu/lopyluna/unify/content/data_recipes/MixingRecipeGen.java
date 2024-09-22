package uwu.lopyluna.unify.content.data_recipes;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.unify.registry.UnifyMaterialProvider;

@SuppressWarnings("unused")
public class MixingRecipeGen extends UnifyProcessingRecipeGen {

    GeneratedRecipe
            ELECTRUM_INGOT = create("electrum_ingot", b -> b
                    .require(UnifyMaterialProvider.SILVER.ingot.get())
                    .require(Items.GOLD_INGOT)
                    .output(UnifyMaterialProvider.ELECTRUM.ingot.get(), 2)
                    .requiresHeat(HeatCondition.HEATED)),
            INVAR_INGOT = create("invar_ingot", b -> b
                    .require(UnifyMaterialProvider.NICKEL.ingot.get())
                    .require(Items.IRON_INGOT)
                    .require(Items.IRON_INGOT)
                    .output(UnifyMaterialProvider.INVAR.ingot.get(), 3)
                    .requiresHeat(HeatCondition.HEATED)),
            CONSTANTAN_INGOT = create("constantan_ingot", b -> b
                    .require(UnifyMaterialProvider.NICKEL.ingot.get())
                    .require(Items.COPPER_INGOT)
                    .output(UnifyMaterialProvider.CONSTANTAN.ingot.get(), 2)
                    .requiresHeat(HeatCondition.HEATED)),
            BRONZE_INGOT = create("bronze_ingot", b -> b
                    .require(UnifyMaterialProvider.TIN.ingot.get())
                    .require(Items.COPPER_INGOT)
                    .output(UnifyMaterialProvider.BRONZE.ingot.get(), 2)
                    .requiresHeat(HeatCondition.HEATED))
    ;

    public MixingRecipeGen(DataGenerator generator) {
        super(generator);
    }


    @Override
    protected @NotNull AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
