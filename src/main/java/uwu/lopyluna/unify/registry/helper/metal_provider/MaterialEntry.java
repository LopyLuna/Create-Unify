package uwu.lopyluna.unify.registry.helper.metal_provider;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.ForgeRegistries;
import uwu.lopyluna.unify.UnifyCreate;
import uwu.lopyluna.unify.registry.UnifyCreativeModeTabs;

import java.util.Objects;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static uwu.lopyluna.unify.UnifyCreate.REGISTRATE;
import static uwu.lopyluna.unify.registry.UnifyTags.*;

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

    public static TagKey<Block> stoneTool = BlockTags.NEEDS_STONE_TOOL;
    public static TagKey<Block> ironTool = BlockTags.NEEDS_IRON_TOOL;
    public static TagKey<Block> diamondTool = BlockTags.NEEDS_DIAMOND_TOOL;

    public static MaterialEntry material(String name, MaterialType type, TagKey<Block> needTierLevel, boolean beaconCompatible, SoundType pSoundType) {
        return material(name, name, type, needTierLevel, beaconCompatible, pSoundType);
    }

    public static MaterialEntry material(String name, String oreLang, MaterialType type, TagKey<Block> needTierLevel, boolean beaconCompatible, SoundType pSoundType) {

        NonNullSupplier<? extends CreativeModeTab> tab = () -> UnifyCreativeModeTabs.BASE_CREATIVE_TAB;
        String id = name.toLowerCase().replace(" ", "_");

        ItemEntry<Item> ingot;
        BlockEntry<Block> block;
        ItemEntry<Item> nugget;
        ItemEntry<Item> sheet;
        ItemEntry<Item> rawMaterial;
        BlockEntry<Block> rawMaterialBlock;
        BlockEntry<Block> ore;
        BlockEntry<Block> oreDeepslate;

        if (type == MaterialType.ORE || type == MaterialType.ALLOY || type == MaterialType.ALL) {
            ingot = REGISTRATE.item(id + "_ingot", Item::new)
                    .lang(name + " Ingot")
                    .tag(beaconCompatible ? ItemTags.BEACON_PAYMENT_ITEMS : regItemTag("unify", "raw_beacon"))
                    .tag(forgeItemTag("ingots/" + id), forgeItemTag("ingots"))
                    .tab(tab)
                    .register();

            nugget = REGISTRATE.item(id + "_nugget", Item::new)
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

            sheet = REGISTRATE.item(id + "_sheet", Item::new)
                    .lang(name + " Sheet")
                    .tag(forgeItemTag("plates/" + id), forgeItemTag("plates"))
                    .tab(tab)
                    .register();

            block = REGISTRATE.block(id + "_block", Block::new)
                    .lang(name + " Block")
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .properties(p -> p.requiresCorrectToolForDrops().sound(pSoundType))
                    .transform(pickaxeOnly())
                    .tag(beaconCompatible ? BlockTags.BEACON_BASE_BLOCKS : regBlockTag("unify", "raw_beacon"))
                    .tag(needTierLevel)
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
        } else {
            ingot = null;
            nugget = null;
            sheet = null;
            block = null;
        }

        if (type == MaterialType.ORE || type == MaterialType.ALL) {
            rawMaterial = REGISTRATE.item("raw_" + id, Item::new)
                    .lang("Raw " + oreLang)
                    .tag(forgeItemTag("raw_materials/" + id), forgeItemTag("raw_materials"))
                    .tab(tab)
                    .recipe((c, p) -> {
                        SimpleCookingRecipeBuilder.smelting(Ingredient.of(c.get().asItem()), ingot.get(), 0.7F, 200)
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                                .save(p, inputFromResult(c.get(), ingot.get()));
                        SimpleCookingRecipeBuilder.blasting(Ingredient.of(c.get().asItem()), ingot.get(), 0.7F, 100)
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                                .save(p, inputFromResult(c.get(), ingot.get()) + "_blasting");
                    })
                    .register();

            rawMaterialBlock = REGISTRATE.block("raw_" + id + "_block", Block::new)
                    .lang("Block of Raw " + oreLang)
                    .initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .transform(pickaxeOnly())
                    .tag(needTierLevel)
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
                    .initialProperties(() -> Blocks.GOLD_ORE)
                    .properties(p -> p.color(MaterialColor.METAL)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE))
                    .transform(pickaxeOnly())
                    .loot((lt, b) -> lt.add(b,
                            RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
                                    RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(rawMaterial.get())
                                            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
                    .tag(needTierLevel)
                    .tag(forgeBlockTag("ores/" + id), forgeBlockTag("ores"), forgeBlockTag("ores_in_ground/stone"))
                    .item()
                    .tab(tab)
                    .tag(forgeItemTag("ores/" + id), forgeItemTag("ores"), forgeItemTag("ores_in_ground/stone"))
                    .recipe((c, p) -> {
                        SimpleCookingRecipeBuilder.smelting(Ingredient.of(c.get().asItem()), ingot.get(), 0.7F, 200)
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                                .save(p, inputFromResult(c.get(), ingot.get()));
                        SimpleCookingRecipeBuilder.blasting(Ingredient.of(c.get().asItem()), ingot.get(), 0.7F, 100)
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                                .save(p, inputFromResult(c.get(), ingot.get()) + "_blasting");
                    })
                    .build()
                    .register();

            oreDeepslate = REGISTRATE.block("deepslate_" + id + "_ore", Block::new)
                    .lang("Deepslate " + oreLang + " Ore")
                    .initialProperties(() -> Blocks.DEEPSLATE_GOLD_ORE)
                    .properties(p -> p.color(MaterialColor.STONE)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE))
                    .transform(pickaxeOnly())
                    .loot((lt, b) -> lt.add(b,
                            RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
                                    RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(rawMaterial.get())
                                            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
                    .tag(needTierLevel)
                    .tag(forgeBlockTag("ores/" + id), forgeBlockTag("ores"), forgeBlockTag("ores_in_ground/deepslate"))
                    .item()
                    .tag(forgeItemTag("ores/" + id), forgeItemTag("ores"), forgeItemTag("ores_in_ground/deepslate"))
                    .recipe((c, p) -> {
                        SimpleCookingRecipeBuilder.smelting(Ingredient.of(c.get().asItem()), ingot.get(), 0.7F, 200)
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                                .save(p, inputFromResult(c.get(), ingot.get()));
                        SimpleCookingRecipeBuilder.blasting(Ingredient.of(c.get().asItem()), ingot.get(), 0.7F, 100)
                                .unlockedBy("has_ingredient", RegistrateRecipeProvider.has(c.get()))
                                .save(p, inputFromResult(c.get(), ingot.get()) + "_blasting");
                    })
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
