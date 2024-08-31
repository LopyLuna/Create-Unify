package uwu.lopyluna.unify.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialType;

import java.util.ArrayList;
import java.util.List;

import static uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry.*;

@SuppressWarnings({"unused"})
public class UnifyMaterialProvider {

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



    public static List<Item> getEntries() {
        List<Item> entry = new ArrayList<>();
        PLATINUM.itemEntries.stream().map(i -> i.get().asItem()).forEachOrdered(entry::add);

        PLATINUM.blockEntries.stream().map(i -> i.get().asItem()).forEachOrdered(entry::add);

        for (ItemEntry<Item> item : PLATINUM.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : LEAD.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : SILVER.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : TIN.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : URANIUM.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : ALUMINUM.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : NICKEL.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : TUNGSTEN.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : STEEL.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : ELECTRUM.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : BRONZE.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : CAST_IRON.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : INVAR.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : CONSTANTAN.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : WROUGHT_IRON.itemEntries) {entry.add(item.get());}
        for (ItemEntry<Item> item : TARNISHED_GOLD.itemEntries) {entry.add(item.get());}

        for (BlockEntry<Block> block : PLATINUM.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : LEAD.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : SILVER.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : TIN.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : URANIUM.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : ALUMINUM.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : NICKEL.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : TUNGSTEN.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : STEEL.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : ELECTRUM.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : BRONZE.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : CAST_IRON.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : INVAR.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : CONSTANTAN.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : WROUGHT_IRON.blockEntries) {entry.add(block.get().asItem());}
        for (BlockEntry<Block> block : TARNISHED_GOLD.blockEntries) {entry.add(block.get().asItem());}
        return entry;
    }

    public static void register() {}
}
