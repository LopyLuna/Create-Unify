package uwu.lopyluna.unify.registry.helper.metal_provider;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import uwu.lopyluna.unify.UnifyCreate;
import uwu.lopyluna.unify.registry.UnifyCreativeModeTabs;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;
import static uwu.lopyluna.unify.UnifyCreate.REGISTRATE;
import static uwu.lopyluna.unify.registry.UnifyTags.forgeBlockTag;
import static uwu.lopyluna.unify.registry.UnifyTags.forgeItemTag;

public class MaterialEntry {
    // MaterialType.ORE || MaterialType.ALLOY
    public static ItemEntry<Item> ingot;
    public static ItemEntry<Item> nugget;
    public static ItemEntry<Item> sheet;
    public static BlockEntry<Block> block;
    //

    // MaterialType.ORE
    public static ItemEntry<Item> rawMaterial;
    public static BlockEntry<Block> rawMaterialBlock;
    public static BlockEntry<Block> ore;
    public static BlockEntry<Block> oreDeepslate;
    //

    public MaterialEntry(ItemEntry<Item> ingot, ItemEntry<Item> nugget, ItemEntry<Item> sheet, BlockEntry<Block> block,
                      ItemEntry<Item> rawMaterial, BlockEntry<Block> rawMaterialBlock, BlockEntry<Block> ore, BlockEntry<Block> oreDeepslate) {
        MaterialEntry.ingot = ingot;
        MaterialEntry.nugget = nugget;
        MaterialEntry.sheet = sheet;
        MaterialEntry.block = block;
        MaterialEntry.rawMaterial = rawMaterial;
        MaterialEntry.rawMaterialBlock = rawMaterialBlock;
        MaterialEntry.ore = ore;
        MaterialEntry.oreDeepslate = oreDeepslate;
    }

    @SuppressWarnings("all")
    public static MaterialEntry material(String name, MaterialType type) {

        String id = name.toLowerCase().replace(" ", "_");

        ItemEntry<Item> ingot = REGISTRATE.item(id + "_ingot", p -> new Item(p.tab(UnifyCreativeModeTabs.BASE_CREATIVE_TAB)))
                .lang(name + " Ingot")
                .tag(forgeItemTag("ingots/" + id), forgeItemTag("ingots"))
                .register();

        ItemEntry<Item> nugget = REGISTRATE.item(id + "_nugget", p -> new Item(p.tab(UnifyCreativeModeTabs.BASE_CREATIVE_TAB)))
                .lang(name + " Nugget")
                .tag(forgeItemTag("nuggets/" + id), forgeItemTag("nuggets"))
                .recipe((c, p) -> {
                    ShapedRecipeBuilder.shaped(ingot.get(), 1)
                            .pattern("CCC")
                            .pattern("CCC")
                            .pattern("CCC")
                            .define('C', c.get())
                            .unlockedBy("has_" + getItemName(c.get()), has(c.get()))
                            .save(p, UnifyCreate.asResource("crafting/" + getItemName(ingot.get()) + "_from_" + getItemName(c.get())));
                    ShapelessRecipeBuilder.shapeless(c.get(), 9)
                            .requires(ingot.get())
                            .unlockedBy("has_" + getItemName(ingot.get()), has(ingot.get()))
                            .save(p, UnifyCreate.asResource("crafting/" + getItemName(c.get()) + "_from_" + getItemName(ingot.get())));
                })
                .register();

        ItemEntry<Item> sheet = REGISTRATE.item(id + "_sheet", p -> new Item(p.tab(UnifyCreativeModeTabs.BASE_CREATIVE_TAB)))
                .lang(name + " Sheet")
                .tag(forgeItemTag("plates/" + id), forgeItemTag("plates"))
                .register();

        BlockEntry<Block> block = REGISTRATE.block(id + "_block", Block::new)
                .lang(name + " Block")
                .tag(forgeBlockTag("storage_blocks/" + id), forgeBlockTag("storage_blocks"))
                .item()
                .tag(forgeItemTag("storage_blocks/" + id), forgeItemTag("storage_blocks"))
                .recipe((c, p) -> {
                    ShapedRecipeBuilder.shaped(c.get(), 1)
                            .pattern("CCC")
                            .pattern("CCC")
                            .pattern("CCC")
                            .define('C', ingot.get())
                            .unlockedBy("has_" + getItemName(ingot.get()), has(ingot.get()))
                            .save(p, UnifyCreate.asResource("crafting/" + c.getName() + "_from_" + getItemName(ingot.get())));
                    ShapelessRecipeBuilder.shapeless(ingot.get(), 9)
                            .requires(c.get())
                            .unlockedBy("has_" + c.getName(), has(c.get()))
                            .save(p, UnifyCreate.asResource("crafting/" + getItemName(ingot.get()) + "_from_" + c.getName()));
                })
                .build()
                .register();

        ItemEntry<Item> rawMaterial;
        BlockEntry<Block> rawMaterialBlock;

        BlockEntry<Block> ore;
        BlockEntry<Block> oreDeepslate;

        if (type == MaterialType.ORE) {
            rawMaterial = REGISTRATE.item("raw_" + id, p -> new Item(p.tab(UnifyCreativeModeTabs.BASE_CREATIVE_TAB)))
                    .lang("Raw " + name)
                    .tag(forgeItemTag("raw_materials/" + id), forgeItemTag("raw_materials"))
                    .register();

            rawMaterialBlock = REGISTRATE.block("raw_" + id + "_block", Block::new)
                    .lang("Block of Raw " + name)
                    .tag(forgeBlockTag("storage_blocks/raw_" + id), forgeBlockTag("storage_blocks"))
                    .item()
                    .tag(forgeItemTag("storage_blocks/raw_" + id), forgeItemTag("storage_blocks"))
                    .build()
                    .recipe((c, p) -> {
                        ShapedRecipeBuilder.shaped(c.get(), 1)
                                .pattern("CCC")
                                .pattern("CCC")
                                .pattern("CCC")
                                .define('C', rawMaterial.get())
                                .unlockedBy("has_" + getItemName(rawMaterial.get()), has(rawMaterial.get()))
                                .save(p, UnifyCreate.asResource("crafting/" + c.getName() + "_from_" + getItemName(rawMaterial.get())));
                        ShapelessRecipeBuilder.shapeless(rawMaterial.get(), 9)
                                .requires(c.get())
                                .unlockedBy("has_" + c.getName(), has(c.get()))
                                .save(p, UnifyCreate.asResource("crafting/" + getItemName(rawMaterial.get()) + "_from_" + c.getName()));
                    })
                    .register();

            ore = REGISTRATE.block(id + "_ore", Block::new)
                    .lang(name + " Ore")
                    .tag(forgeBlockTag("ores/" + id), forgeBlockTag("ores"))
                    .item()
                    .tag(forgeItemTag("ores/" + id), forgeItemTag("ores"))
                    .build()
                    .register();

            oreDeepslate = REGISTRATE.block("deepslate_" + id + "_ore", Block::new)
                    .lang("Deepslate " + name + " Ore")
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

    @SuppressWarnings("deprecation")
    protected static String getItemName(ItemLike pItemLike) {
        return Registry.ITEM.getKey(pItemLike.asItem()).getPath();
    }
}
