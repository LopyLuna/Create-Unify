package uwu.lopyluna.unify.infrastructure.data;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ermWhatTheSigma {

    public static List<String> getAllIDs() {
        List<String> entry = new ArrayList<>();
        entry.addAll(getIDs("PLATINUM", true));
        entry.addAll(getIDs("LEAD", true));
        entry.addAll(getIDs("SILVER", true));
        entry.addAll(getIDs("TIN", true));
        entry.addAll(getIDs("URANIUM", true));
        entry.addAll(getIDs("ALUMINUM", true));
        entry.addAll(getIDs("NICKEL", true));
        entry.addAll(getIDs("TUNGSTEN", true));

        entry.addAll(getIDs("STEEL", false));
        entry.addAll(getIDs("ELECTRUM", false));
        entry.addAll(getIDs("BRONZE", false));
        entry.addAll(getIDs("CAST_IRON", false));
        entry.addAll(getIDs("INVAR", false));
        entry.addAll(getIDs("CONSTANTAN", false));
        entry.addAll(getIDs("WROUGHT_IRON", false));
        entry.addAll(getIDs("TARNISHED_GOLD", false));
        return entry;
    }

    public static List<String> getIDs(String name, boolean isOre) {
        String id = name.toLowerCase();
        List<String> asIDs = new ArrayList<>();
        if (name.equals("CAST_IRON")) {
            asIDs.add("industrial_iron_ingot");
            asIDs.add("industrial_iron_nugget");
            asIDs.add("industrial_iron_sheet");
            asIDs.add("industrial_iron_block");
        }
        if (name.equals("ALUMINUM")) {
            if (isOre) {
                String rawId = "bauxite";
                asIDs.add("raw_" + rawId);
                asIDs.add("raw_" + rawId + "_block");
                asIDs.add(rawId + "_ore");
                asIDs.add("deepslate_" + rawId + "_ore");
            }

        }
        if (name.equals("TUNGSTEN")) {
            if (isOre) {
                asIDs.add("raw_tungsten_ore");
                String rawId = "wolfram";
                asIDs.add("raw_" + rawId);
                asIDs.add("raw_" + rawId + "_block");
                asIDs.add(rawId + "_ore");
                asIDs.add("deepslate_" + rawId + "_ore");
            }
        }

        asIDs.add(id + "_ingot");
        asIDs.add(id + "_nugget");
        asIDs.add(id + "_sheet");
        asIDs.add(id + "_plate");
        asIDs.add(id + "_block");

        asIDs.add("ingot_" + id);
        asIDs.add("nugget_" + id);
        asIDs.add("sheet_" + id);
        asIDs.add("plate_" + id);
        asIDs.add("block_" + id);

        if (isOre) {
            asIDs.add(id + "_raw");
            asIDs.add("raw_" + id);
            asIDs.add("raw_" + id + "_block");
            asIDs.add(id + "_raw_block");
            asIDs.add(id + "_ore");
            asIDs.add("ore_" + id);
            asIDs.add("deepslate_" + id + "_ore");
        }
        return asIDs;
    }
}
