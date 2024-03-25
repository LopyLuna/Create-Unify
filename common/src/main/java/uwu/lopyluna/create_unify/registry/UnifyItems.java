package uwu.lopyluna.create_unify.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.TagDependentIngredientItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import io.github.fabricators_of_create.porting_lib.util.ItemGroupUtil;
import me.alphamode.forgetags.Tags;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import uwu.lopyluna.create_unify.Unify;
import uwu.lopyluna.create_unify.content.blocks.TagDependentBlockItem;

import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.AllItemTags.PLATES;
import static com.simibubi.create.AllTags.forgeItemTag;

@SuppressWarnings({"unused"})
public class UnifyItems {
    private static final CreateRegistrate REGISTRATE = Unify.registrate();

    public static final CreativeModeTab mainCreativeTab = new CreativeModeTab(ItemGroupUtil.expandArrayAndGetId(), Unify.MOD_ID) {
        @Override public ItemStack makeIcon() { return UnifyItems.TIN_INGOT.asStack(); }
    };

    public static final ItemEntry<TagDependentIngredientItem>
            TIN_INGOT = Ingot("tin", "Tin"),
            ALUMINUM_INGOT = Ingot("aluminum", "Aluminum"),
            LEAD_INGOT = Ingot("lead", "Lead"),
            SILVER_INGOT = Ingot("silver", "Silver"),
            PLATINUM_INGOT = Ingot("platinum", "Platinum"),
            URANIUM_INGOT = Ingot("uranium", "Uranium"),
            BRONZE_INGOT = Ingot("bronze", "Bronze"),
            ELECTRUM_INGOT = Ingot("electrum", "Electrum"),
            CAST_IRON_INGOT = Ingot("cast_iron", "Cast Iron"),
            STEEL_INGOT = Ingot("steel", "Steel")
    ;

    public static final ItemEntry<TagDependentIngredientItem>
            TIN_NUGGET = Nugget("tin", "Tin"),
            ALUMINUM_NUGGET = Nugget("aluminum", "Aluminum"),
            LEAD_NUGGET = Nugget("lead", "Lead"),
            SILVER_NUGGET = Nugget("silver", "Silver"),
            PLATINUM_NUGGET = Nugget("platinum", "Platinum"),
            URANIUM_NUGGET = Nugget("uranium", "Uranium"),
            BRONZE_NUGGET = Nugget("bronze", "Bronze"),
            ELECTRUM_NUGGET = Nugget("electrum", "Electrum"),
            CAST_IRON_NUGGET = Nugget("cast_iron", "Cast Iron"),
            STEEL_NUGGET = Nugget("steel", "Steel")
    ;

    public static final ItemEntry<TagDependentIngredientItem>
            ZINC_SHEET = Sheet("zinc", "Zinc"),
            ANDESITE_ALLOY_SHEET = Sheet("andesite_alloy", "Andesite Alloy"),
            NETHERITE_SHEET = Sheet("netherite", "Netherite"),

            TIN_SHEET = Sheet("tin", "Tin"),
            ALUMINUM_SHEET = Sheet("aluminum", "Aluminum"),
            LEAD_SHEET = Sheet("lead", "Lead"),
            SILVER_SHEET = Sheet("silver", "Silver"),
            PLATINUM_SHEET = Sheet("platinum", "Platinum"),
            URANIUM_SHEET = Sheet("uranium", "Uranium"),
            BRONZE_SHEET = Sheet("bronze", "Bronze"),
            ELECTRUM_SHEET = Sheet("electrum", "Electrum"),
            CAST_IRON_SHEET = Sheet("cast_iron", "Cast Iron"),
            STEEL_SHEET = Sheet("steel", "Steel")
    ;

    public static final ItemEntry<TagDependentIngredientItem>
            RAW_TIN = RawOre("tin", "Tin"),
            RAW_ALUMINUM = RawOre("aluminum", "Aluminum"),
            RAW_LEAD = RawOre("lead", "Lead"),
            RAW_SILVER = RawOre("silver", "Silver"),
            RAW_PLATINUM = RawOre("platinum", "Platinum"),
            RAW_URANIUM = RawOre("uranium", "Uranium")
    ;

    //BLOCKITEMS

    //public static final ItemEntry<TagDependentBlockItem>
    //        TIN_BLOCK_ITEM = MetalBlockItem("tin", UnifyBlocks.TIN_BLOCK.get()),
    //        ALUMINUM_BLOCK_ITEM = MetalBlockItem("aluminum", UnifyBlocks.ALUMINUM_BLOCK.get()),
    //        LEAD_BLOCK_ITEM = MetalBlockItem("lead", UnifyBlocks.LEAD_BLOCK.get()),
    //        SILVER_BLOCK_ITEM = MetalBlockItem("silver", UnifyBlocks.SILVER_BLOCK.get()),
    //        PLATINUM_BLOCK_ITEM = MetalBlockItem("platinum", UnifyBlocks.PLATINUM_BLOCK.get()),
    //        URANIUM_BLOCK_ITEM = MetalBlockItem("uranium", UnifyBlocks.URANIUM_BLOCK.get()),
    //        BRONZE_BLOCK_ITEM = MetalBlockItem("bronze", UnifyBlocks.BRONZE_BLOCK.get()),
    //        ELECTRUM_BLOCK_ITEM = MetalBlockItem("electrum", UnifyBlocks.ELECTRUM_BLOCK.get()),
    //        CAST_IRON_BLOCK_ITEM = MetalBlockItem("cast_iron", UnifyBlocks.CAST_IRON_BLOCK.get()),
    //        STEEL_BLOCK_ITEM = MetalBlockItem("steel", UnifyBlocks.STEEL_BLOCK.get())
    //;

    //public static final ItemEntry<TagDependentBlockItem>
    //        RAW_TIN_BLOCK_ITEM = RawOreBlockItem("tin", UnifyBlocks.RAW_TIN_BLOCK.get()),
    //        RAW_ALUMINUM_BLOCK_ITEM = RawOreBlockItem("aluminum", UnifyBlocks.RAW_ALUMINUM_BLOCK.get()),
    //        RAW_LEAD_BLOCK_ITEM = RawOreBlockItem("lead", UnifyBlocks.RAW_LEAD_BLOCK.get()),
    //        RAW_SILVER_BLOCK_ITEM = RawOreBlockItem("silver", UnifyBlocks.RAW_SILVER_BLOCK.get()),
    //        RAW_PLATINUM_BLOCK_ITEM = RawOreBlockItem("platinum", UnifyBlocks.RAW_PLATINUM_BLOCK.get()),
    //        RAW_URANIUM_BLOCK_ITEM = RawOreBlockItem("uranium", UnifyBlocks.RAW_URANIUM_BLOCK.get())
    //;

    //public static final ItemEntry<TagDependentBlockItem>
    //        TIN_ORE_ITEM = OreBlockItem("tin", UnifyBlocks.TIN_ORE.get()),
    //        ALUMINUM_ORE_ITEM = OreBlockItem("aluminum", UnifyBlocks.ALUMINUM_ORE.get()),
    //        LEAD_ORE_ITEM = OreBlockItem("lead", UnifyBlocks.LEAD_ORE.get()),
    //        SILVER_ORE_ITEM = OreBlockItem("silver", UnifyBlocks.SILVER_ORE.get()),
    //        PLATINUM_ORE_ITEM = OreBlockItem("platinum", UnifyBlocks.PLATINUM_ORE.get()),
    //        URANIUM_ORE_ITEM = OreBlockItem("uranium", UnifyBlocks.URANIUM_ORE.get())
    //;

    public static ItemEntry<TagDependentIngredientItem> Ingot(String id, String lang) {
        return REGISTRATE.item(id + "_ingot", props -> new TagDependentIngredientItem(props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
                .tag(forgeItemTag(id + "_ingots"))
                .tag(forgeItemTag("ingots"))
                .tag(forgeItemTag("ingots/" + id))
                .tag(CREATE_INGOTS.tag)
                .lang(lang + " Ingot")
                .register();
    }

    public static ItemEntry<TagDependentIngredientItem> Nugget(String id, String lang) {
        return REGISTRATE.item(id + "_nugget", props -> new TagDependentIngredientItem(props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
                .tag(forgeItemTag(id + "_nuggets"))
                .tag(forgeItemTag("nuggets/" + id))
                .tag(Tags.Items.NUGGETS)
                .lang(lang + " Nugget")
                .register();
    }

    public static ItemEntry<TagDependentIngredientItem> Sheet(String id, String lang) {
        return REGISTRATE.item(id + "_sheet", props -> new TagDependentIngredientItem(props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
                .tag(forgeItemTag(id + "_plates"))
                .tag(forgeItemTag("plates/" + id))
                .tag(PLATES.tag)
                .lang(lang + " Sheet")
                .register();
    }

    public static ItemEntry<TagDependentIngredientItem> RawOre(String id, String lang) {
        return REGISTRATE.item("raw_" + id, props -> new TagDependentIngredientItem(props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
                .tag(forgeItemTag("raw_" + id + "_ores"))
                .tag(forgeItemTag("raw_materials"))
                .tag(forgeItemTag("raw_materials/" + id))
                .tag(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "raw_ores")))
                .lang("Raw" + lang)
                .register();
    }

    //public static ItemEntry<TagDependentBlockItem> MetalBlockItem(String id, Block block) {
    //    return REGISTRATE.item(id + "_block", props -> new TagDependentBlockItem(block, props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
    //            .register();
    //}

    //public static ItemEntry<TagDependentBlockItem> RawOreBlockItem(String id, Block block) {
    //    return REGISTRATE.item("raw_" + id + "_block", props -> new TagDependentBlockItem(block, props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
    //            .register();
    //}

    //public static ItemEntry<TagDependentBlockItem> OreBlockItem(String id, Block block) {
    //    REGISTRATE.item("deepslate_" + id + "_ore", props -> new TagDependentBlockItem(block, props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
    //            .register();
    //    return REGISTRATE.item(id + "_ore", props -> new TagDependentBlockItem(block, props, UnifyTags.AllItemTags.ENABLE_FEATURES.tag))
    //            .register();
    //}

    public static void register() {}
}
