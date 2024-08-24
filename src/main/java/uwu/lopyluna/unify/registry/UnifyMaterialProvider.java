package uwu.lopyluna.unify.registry;

import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry;
import uwu.lopyluna.unify.registry.helper.metal_provider.MaterialType;

import static uwu.lopyluna.unify.registry.helper.metal_provider.MaterialEntry.material;

@SuppressWarnings({"unused"})
public class UnifyMaterialProvider {

    public static final MaterialEntry PLATINUM = material("Platinum", MaterialType.ORE);
    public static final MaterialEntry LEAD = material("Lead", MaterialType.ORE);
    public static final MaterialEntry SILVER = material("Silver", MaterialType.ORE);
    public static final MaterialEntry TIN = material("Tin", MaterialType.ORE);
    public static final MaterialEntry URANIUM = material("Uranium", MaterialType.ORE);
    public static final MaterialEntry ALUMINUM = material("Aluminum", "Bauxite", MaterialType.ORE);
    public static final MaterialEntry NICKEL = material("Nickel", MaterialType.ORE);
    public static final MaterialEntry TUNGSTEN = material("Tungsten", "Wolfram", MaterialType.ORE);

    public static final MaterialEntry STEEL = material("Steel", MaterialType.ALLOY);
    public static final MaterialEntry ELECTRUM = material("Electrum", MaterialType.ALLOY);
    public static final MaterialEntry BRONZE = material("Bronze", MaterialType.ALLOY);
    public static final MaterialEntry CAST_IRON = material("Cast Iron", MaterialType.ALLOY);
    public static final MaterialEntry INVAR = material("Invar", MaterialType.ALLOY);
    public static final MaterialEntry CONSTANTANT = material("Constantant", MaterialType.ALLOY);
    public static final MaterialEntry WROUGHT_IRON = material("Wrought Iron", MaterialType.ALLOY);
    public static final MaterialEntry TARNISHED_GOLD = material("Tarnished Gold", MaterialType.ALLOY);


    public static void register() {}
}
