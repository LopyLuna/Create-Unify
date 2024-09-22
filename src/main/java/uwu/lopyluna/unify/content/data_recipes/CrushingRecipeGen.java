package uwu.lopyluna.unify.content.data_recipes;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry;
import static uwu.lopyluna.unify.registry.UnifyMaterialProvider.*;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class CrushingRecipeGen extends UnifyProcessingRecipeGen {

    public CrushingRecipeGen(PackOutput generator) {
        super(generator);
    }

    GeneratedRecipe
            PLATINUM_GEN = createMetalRecipes(PLATINUM, AllItems.CRUSHED_PLATINUM.get()),
            LEAD_GEN = createMetalRecipes(LEAD, AllItems.CRUSHED_LEAD.get()),
            SILVER_GEN = createMetalRecipes(SILVER, AllItems.CRUSHED_SILVER.get()),
            TIN_GEN = createMetalRecipes(TIN, AllItems.CRUSHED_TIN.get()),
            URANIUM_GEN = createMetalRecipes(URANIUM, AllItems.CRUSHED_URANIUM.get()),
            ALUMINUM_GEN = createMetalRecipes(ALUMINUM, AllItems.CRUSHED_BAUXITE.get()),
            NICKEL_GEN = createMetalRecipes(NICKEL, AllItems.CRUSHED_NICKEL.get()),
            TUNGSTEN_GEN = createMetalRecipes(TUNGSTEN, CRUSHED_WOLFRAM.get())
    ;


    protected GeneratedRecipe createMetalRecipes(MaterialEntry metal, ItemLike crushedOre) {
        deepslateOre(metal.oreDeepslate::get, () -> crushedOre, 2.25f, 350);
        stoneOre(metal.ore::get, () -> crushedOre, 1.75f, 250);

        rawOre(metal.rawMaterialBlock::get, () -> crushedOre, 9);
        return rawOre(metal.rawMaterial::get, () -> crushedOre, 1);
    }


    @SuppressWarnings({"SameParameterValue", "all"})
    protected GeneratedRecipe stoneOre(Supplier<ItemLike> ore, Supplier<ItemLike> raw, float expectedAmount, int duration) {
        return ore(Blocks.COBBLESTONE, ore, raw, expectedAmount, duration);
    }

    @SuppressWarnings({"SameParameterValue", "all"})
    protected GeneratedRecipe deepslateOre(Supplier<ItemLike> ore, Supplier<ItemLike> raw, float expectedAmount, int duration) {
        return ore(Blocks.COBBLED_DEEPSLATE, ore, raw, expectedAmount, duration);
    }

    protected GeneratedRecipe ore(ItemLike stoneType, Supplier<ItemLike> ore, Supplier<ItemLike> raw, float expectedAmount, int duration) {
        return create(ore, b -> {
            ProcessingRecipeBuilder<ProcessingRecipe<?>> builder = b.duration(duration)
                    .output(raw.get(), Mth.floor(expectedAmount));
            float extra = expectedAmount - Mth.floor(expectedAmount);
            if (extra > 0)
                builder.output(extra, raw.get(), 1);
            builder.output(.75f, AllItems.EXP_NUGGET.get(), raw.get() == AllItems.CRUSHED_GOLD.get() ? 2 : 1);
            return builder.output(.125f, stoneType);
        });
    }

    protected GeneratedRecipe rawOre(Supplier<ItemLike> input, Supplier<ItemLike> result, int amount) {
        return create(input, b -> b.duration(400)
                .output(result.get(), amount)
                .output(.75f, AllItems.EXP_NUGGET.get(), (result.get() == AllItems.CRUSHED_GOLD.get() ? 2 : 1) * amount));
    }

    @Override
    protected @NotNull IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.CRUSHING;
    }
}
