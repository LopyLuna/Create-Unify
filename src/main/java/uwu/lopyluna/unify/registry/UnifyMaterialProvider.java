package uwu.lopyluna.unify.registry;

import net.minecraft.world.level.block.SoundType;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialType;

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




    public static void register() {}
}
