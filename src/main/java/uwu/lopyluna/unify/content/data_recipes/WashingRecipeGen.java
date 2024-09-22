package uwu.lopyluna.unify.content.data_recipes;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry;
import static uwu.lopyluna.unify.registry.UnifyMaterialProvider.*;

@SuppressWarnings("unused")
public class WashingRecipeGen extends UnifyProcessingRecipeGen {

    GeneratedRecipe

    CRUSHED_PLATINUM = crushedOre(  AllItems.CRUSHED_PLATINUM.get(), PLATINUM, AllItems.CINDER_FLOUR.get(),     .25f ),
    CRUSHED_LEAD = crushedOre(      AllItems.CRUSHED_LEAD.get(),     LEAD,        Items.SUGAR,                  .5f  ),
    CRUSHED_SILVER = crushedOre(    AllItems.CRUSHED_SILVER.get(),   SILVER,      Items.LAPIS_LAZULI,           .25f ),
    CRUSHED_TIN = crushedOre(       AllItems.CRUSHED_TIN.get(),      TIN,         Items.FLINT,                  .25f ),
    CRUSHED_URANIUM = crushedOre(   AllItems.CRUSHED_URANIUM.get(),  URANIUM,     Items.GLOWSTONE_DUST,         .5f  ),
    CRUSHED_ALUMINUM = crushedOre(  AllItems.CRUSHED_BAUXITE.get(),  ALUMINUM,    Items.POINTED_DRIPSTONE,      .25f ),
    CRUSHED_NICKEL = crushedOre(    AllItems.CRUSHED_NICKEL.get(),   NICKEL,      Items.CHARCOAL,               .5f  ),
    CRUSHED_TUNGSTEN = crushedOre(           CRUSHED_WOLFRAM.get(),  TUNGSTEN, AllItems.POWDERED_OBSIDIAN.get(),.5f  )

    ;

    public WashingRecipeGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected @NotNull IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.SPLASHING;
    }

    public GeneratedRecipe crushedOre(ItemLike crushedOre, MaterialEntry metal, ItemLike byProduct, float chance) {
        return create(() -> crushedOre, b -> b.output(metal.nugget.get(), 9)
                .output(chance, byProduct, 1));
    }
}
