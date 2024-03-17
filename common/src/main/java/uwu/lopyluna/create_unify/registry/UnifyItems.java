package uwu.lopyluna.create_unify.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import me.alphamode.forgetags.Tags;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import uwu.lopyluna.create_unify.Unify;

import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.AllItemTags.PLATES;
import static com.simibubi.create.AllTags.forgeItemTag;

@SuppressWarnings({"unused"})
public class UnifyItems {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(Unify.MOD_ID);


    public static final ItemEntry<Item>
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

    public static final ItemEntry<Item>
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

    public static final ItemEntry<Item>
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

    public static final ItemEntry<Item>
            RAW_TIN = RawOre("tin", "Tin"),
            RAW_ALUMINUM = RawOre("aluminum", "Aluminum"),
            RAW_LEAD = RawOre("lead", "Lead"),
            RAW_SILVER = RawOre("silver", "Silver"),
            RAW_PLATINUM = RawOre("platinum", "Platinum"),
            RAW_URANIUM = RawOre("uranium", "Uranium")
    ;

    public static ItemEntry<Item> Ingot(String id, String lang) {
        return REGISTRATE.item(id + "_ingot", Item::new)
                .tag(forgeItemTag(id + "_ingots"))
                .tag(forgeItemTag("ingots"))
                .tag(forgeItemTag("ingots/" + id))
                .tag(CREATE_INGOTS.tag)
                .lang(lang + " Ingot")
                .register();
    }

    public static ItemEntry<Item> Nugget(String id, String lang) {
        return REGISTRATE.item(id + "_nugget", Item::new)
                .tag(forgeItemTag(id + "_nuggets"))
                .tag(forgeItemTag("nuggets/" + id))
                .tag(Tags.Items.NUGGETS)
                .lang(lang + " Nugget")
                .register();
    }

    public static ItemEntry<Item> Sheet(String id, String lang) {
        return REGISTRATE.item(id + "_sheet", Item::new)
                .tag(forgeItemTag(id + "_plates"))
                .tag(forgeItemTag("plates/" + id))
                .tag(PLATES.tag)
                .lang(lang + " Sheet")
                .register();
    }

    public static ItemEntry<Item> RawOre(String id, String lang) {
        return REGISTRATE.item("raw_" + id, Item::new)
                .tag(forgeItemTag("raw_" + id + "_ores"))
                .tag(forgeItemTag("raw_materials"))
                .tag(forgeItemTag("raw_materials/" + id))
                .tag(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "raw_ores")))
                .lang("Raw" + lang)
                .register();
    }

    public static void init() {
        // load the class and register everything
        Unify.LOGGER.info("Registering items for " + Unify.NAME);
    }
}
