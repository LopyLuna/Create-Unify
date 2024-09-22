package uwu.lopyluna.unify.registry;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.TagDependentIngredientItem;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialType;

import java.util.ArrayList;
import java.util.List;

import static com.simibubi.create.AllTags.AllItemTags.CRUSHED_RAW_MATERIALS;
import static uwu.lopyluna.unify.Unify.REGISTRATE;
import static uwu.lopyluna.unify.registry.UnifyTags.forgeItemTag;
import static uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry.*;

@SuppressWarnings({"unused"})
public class UnifyMaterialProvider {
    static ResourceKey<CreativeModeTab> tab = UnifyCreativeModeTabs.BASE_CREATIVE_TAB.getKey();
    static ResourceKey<CreativeModeTab> tabCreate = AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey();


    public static final ItemEntry<Item> GAY_INGOT = REGISTRATE.item("gay_ingot", Item::new)
            .lang("Gay Ingot")
            .tag(ItemTags.BEACON_PAYMENT_ITEMS)
            .tag(forgeItemTag("ingots/gay"), forgeItemTag("ingots"))
            .register();

    public static final MaterialEntry PLATINUM = material("Platinum", MaterialType.ORE, diamondTool, true, SoundType.METAL);
    public static final MaterialEntry LEAD = material("Lead", MaterialType.ORE, ironTool, true, SoundType.METAL);
    public static final MaterialEntry SILVER = material("Silver", MaterialType.ORE, ironTool, true, SoundType.METAL);
    public static final MaterialEntry TIN = material("Tin", MaterialType.ORE, stoneTool, false, SoundType.METAL);
    public static final MaterialEntry URANIUM = material("Uranium", MaterialType.ORE, ironTool, true, UnifySoundEvents.METAL_HEAVY);
    public static final MaterialEntry ALUMINUM = material("Aluminum", "Bauxite", MaterialType.ORE, stoneTool, false, SoundType.COPPER);
    public static final MaterialEntry NICKEL = material("Nickel", MaterialType.ORE, ironTool, true, SoundType.METAL);
    public static final MaterialEntry TUNGSTEN = material("Tungsten", "Wolfram", MaterialType.ORE, diamondTool, true, UnifySoundEvents.NETHERITE_BLOCK_HEAVY);

    public static final MaterialEntry STEEL = material("Steel", MaterialType.ALLOY, ironTool, true, UnifySoundEvents.NETHERITE_BLOCK_HEAVY);
    public static final MaterialEntry ELECTRUM = material("Electrum", MaterialType.ALLOY, ironTool, true, UnifySoundEvents.COPPER_HEAVY);
    public static final MaterialEntry BRONZE = material("Bronze", MaterialType.ALLOY, ironTool, true, UnifySoundEvents.NETHERITE_BLOCK_HEAVY);
    public static final MaterialEntry CAST_IRON = material("Cast Iron", MaterialType.ALLOY, ironTool, true, SoundType.NETHERITE_BLOCK);
    public static final MaterialEntry INVAR = material("Invar", MaterialType.ALLOY, ironTool, true, UnifySoundEvents.COPPER_HEAVY);
    public static final MaterialEntry CONSTANTAN = material("Constantan", MaterialType.ALLOY, ironTool, true, SoundType.METAL);
    public static final MaterialEntry WROUGHT_IRON = material("Wrought Iron", MaterialType.ALLOY, ironTool, true, SoundType.NETHERITE_BLOCK);
    public static final MaterialEntry TARNISHED_GOLD = material("Tarnished Gold", MaterialType.ALLOY, ironTool, true, SoundType.METAL);


    public static final ItemEntry<TagDependentIngredientItem>
            CRUSHED_WOLFRAM = compatCrushedOre("tungsten").register();


    public static List<Item> getEntries() {
        List<Item> entry = new ArrayList<>();
        MaterialEntry[] materialEntries = {PLATINUM, LEAD, SILVER, TIN, URANIUM, ALUMINUM, NICKEL, TUNGSTEN, STEEL, ELECTRUM, BRONZE, CAST_IRON, INVAR, CONSTANTAN, WROUGHT_IRON};

        for (MaterialEntry mats : materialEntries) {
            for (ItemEntry<Item> item : mats.itemEntries) {
                entry.add(item.get());
            }
            for (BlockEntry<Block> block : mats.blockEntries) {
                entry.add(block.get().asItem());
            }
        }
        return entry;
    }
    public static List<TagKey<Item>> getTagEntries() {
        List<TagKey<Item>> entry = new ArrayList<>();
        MaterialEntry[] materialEntries = {PLATINUM, LEAD, SILVER, TIN, URANIUM, ALUMINUM, NICKEL, TUNGSTEN, STEEL, ELECTRUM, BRONZE, CAST_IRON, INVAR, CONSTANTAN, WROUGHT_IRON};

        for (MaterialEntry mats : materialEntries) {
            entry.addAll(mats.tagKeys);
        }
        return entry;
    }

    @SuppressWarnings("SameParameterValue")
    private static ItemBuilder<TagDependentIngredientItem, CreateRegistrate> compatCrushedOre(String metalName) {
        return REGISTRATE
                .item("crushed_raw_" + metalName, props -> new TagDependentIngredientItem(props, AllTags.forgeItemTag("ores/" + metalName)))
                .tab(tabCreate != null ? tabCreate : tab)
                .tag(CRUSHED_RAW_MATERIALS.tag);
    }

    public static void register() {}
}
