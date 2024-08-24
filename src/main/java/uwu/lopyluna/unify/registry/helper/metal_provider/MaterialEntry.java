package uwu.lopyluna.unify.registry.helper.metal_provider;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import uwu.lopyluna.unify.UnifyCreate;
import uwu.lopyluna.unify.registry.UnifyCreativeModeTabs;

import java.util.Objects;

import static uwu.lopyluna.unify.UnifyCreate.REGISTRATE;
import static uwu.lopyluna.unify.registry.UnifyTags.forgeBlockTag;
import static uwu.lopyluna.unify.registry.UnifyTags.forgeItemTag;

public class MaterialEntry {
    // MaterialType.ORE || MaterialType.ALLOY
    public ItemEntry<Item> ingot;
    public ItemEntry<Item> nugget;
    public ItemEntry<Item> sheet;
    public BlockEntry<Block> block;
    //

    // MaterialType.ORE
    public ItemEntry<Item> rawMaterial;
    public BlockEntry<Block> rawMaterialBlock;
    public BlockEntry<Block> ore;
    public BlockEntry<Block> oreDeepslate;
    //

    public MaterialEntry(ItemEntry<Item> ingot, ItemEntry<Item> nugget, ItemEntry<Item> sheet, BlockEntry<Block> block,
                      ItemEntry<Item> rawMaterial, BlockEntry<Block> rawMaterialBlock, BlockEntry<Block> ore, BlockEntry<Block> oreDeepslate) {
        this.ingot = ingot;
        this.nugget = nugget;
        this.sheet = sheet;
        this.block = block;
        this.rawMaterial = rawMaterial;
        this.rawMaterialBlock = rawMaterialBlock;
        this.ore = ore;
        this.oreDeepslate = oreDeepslate;
    }
    public static MaterialEntry material(String name, MaterialType type) {
        return material(name, name, type);
    }

    public static MaterialEntry material(String name, String oreLang, MaterialType type) {

        NonNullSupplier<? extends CreativeModeTab> tab = () -> UnifyCreativeModeTabs.BASE_CREATIVE_TAB;
        String id = name.toLowerCase().replace(" ", "_");

        ItemEntry<Item> ingot = REGISTRATE.item(id + "_ingot", Item::new)
                .lang(name + " Ingot")
                .tag(forgeItemTag("ingots/" + id), forgeItemTag("ingots"))
                .tab(tab)
                .register();

        ItemEntry<Item> nugget = REGISTRATE.item(id + "_nugget", Item::new)
                .lang(name + " Nugget")
                .tag(forgeItemTag("nuggets/" + id), forgeItemTag("nuggets"))
                .recipe((c, p) -> {
                    ShapedRecipeBuilder.shaped(ingot.get(), 1)
                            .pattern("CCC")
                            .pattern("CCC")
                            .pattern("CCC")
                            .define('C', c.get())
                            .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                            .save(p, inputFromResult(ingot.get(), c.get()));
                    ShapelessRecipeBuilder.shapeless(c.get(), 9)
                            .requires(ingot.get())
                            .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(ingot.get()))
                            .save(p, inputFromResult(c.get(), ingot.get()));
                })
                .tab(tab)
                .register();

        ItemEntry<Item> sheet = REGISTRATE.item(id + "_sheet", Item::new)
                .lang(name + " Sheet")
                .tag(forgeItemTag("plates/" + id), forgeItemTag("plates"))
                .tab(tab)
                .register();

        BlockEntry<Block> block = REGISTRATE.block(id + "_block", Block::new)
                .lang(name + " Block")
                .tag(forgeBlockTag("storage_blocks/" + id), forgeBlockTag("storage_blocks"))
                .item()
                .tab(tab)
                .tag(forgeItemTag("storage_blocks/" + id), forgeItemTag("storage_blocks"))
                .recipe((c, p) -> {
                    ShapedRecipeBuilder.shaped(c.get(), 1)
                            .pattern("CCC")
                            .pattern("CCC")
                            .pattern("CCC")
                            .define('C', ingot.get())
                            .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(ingot.get()))
                            .save(p, inputFromResult(c.get(), ingot.get()));
                    ShapelessRecipeBuilder.shapeless(ingot.get(), 9)
                            .requires(c.get())
                            .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                            .save(p, inputFromResult(ingot.get(), c.get()));
                })
                .build()
                .register();

        ItemEntry<Item> rawMaterial;
        BlockEntry<Block> rawMaterialBlock;

        BlockEntry<Block> ore;
        BlockEntry<Block> oreDeepslate;

        if (type == MaterialType.ORE) {
            rawMaterial = REGISTRATE.item("raw_" + id, Item::new)
                    .lang("Raw " + oreLang)
                    .tag(forgeItemTag("raw_materials/" + id), forgeItemTag("raw_materials"))
                    .tab(tab)
                    .register();

            rawMaterialBlock = REGISTRATE.block("raw_" + id + "_block", Block::new)
                    .lang("Block of Raw " + oreLang)
                    .tag(forgeBlockTag("storage_blocks/raw_" + id), forgeBlockTag("storage_blocks"))
                    .item()
                    .tab(tab)
                    .tag(forgeItemTag("storage_blocks/raw_" + id), forgeItemTag("storage_blocks"))
                    .recipe((c, p) -> {
                        ShapedRecipeBuilder.shaped(c.get(), 1)
                                .pattern("CCC")
                                .pattern("CCC")
                                .pattern("CCC")
                                .define('C', rawMaterial.get())
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(rawMaterial.get()))
                                .save(p, inputFromResult(rawMaterial.get(), c.get()));
                        ShapelessRecipeBuilder.shapeless(rawMaterial.get(), 9)
                                .requires(c.get())
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                                .save(p, inputFromResult(c.get(), rawMaterial.get()));
                    })
                    .build()
                    .register();

            ore = REGISTRATE.block(id + "_ore", Block::new)
                    .lang(oreLang + " Ore")
                    .tag(forgeBlockTag("ores/" + id), forgeBlockTag("ores"))
                    .item()
                    .tab(tab)
                    .tag(forgeItemTag("ores/" + id), forgeItemTag("ores"))
                    .build()
                    .register();

            oreDeepslate = REGISTRATE.block("deepslate_" + id + "_ore", Block::new)
                    .lang("Deepslate " + oreLang + " Ore")
                    .tag(forgeBlockTag("ores/" + id), forgeBlockTag("ores"))
                    .item()
                    .tag(forgeItemTag("ores/" + id), forgeItemTag("ores"))
                    .build()
                    .register();
        } else {
            rawMaterial = null;
            rawMaterialBlock = null;

            ore = null;
            oreDeepslate = null;
        }

        return new MaterialEntry(ingot, nugget, sheet, block, rawMaterial, rawMaterialBlock, ore, oreDeepslate);
    }

    public static ResourceLocation inputFromResult(ItemLike input, ItemLike result) {
        return UnifyCreate.asResource(safeId(result) + "_from_" + safeId(input));
    }
    public static String safeId(ItemLike registryEntry) {
        return safeName(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(registryEntry.asItem())));
    }
    public static String safeName(ResourceLocation id) {
        return id.getPath().replace('/', '_');
    }
}
