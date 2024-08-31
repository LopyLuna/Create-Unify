package uwu.lopyluna.unify.infrastructure.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class ermWhatTheSigma {

    private static List<String> unify$getAllIDs() {
        List<String> entry = new ArrayList<>();
        entry.addAll(unify$getIDs("PLATINUM", true));
        entry.addAll(unify$getIDs("LEAD", true));
        entry.addAll(unify$getIDs("SILVER", true));
        entry.addAll(unify$getIDs("TIN", true));
        entry.addAll(unify$getIDs("URANIUM", true));
        entry.addAll(unify$getIDs("ALUMINUM", true));
        entry.addAll(unify$getIDs("NICKEL", true));
        entry.addAll(unify$getIDs("TUNGSTEN", true));

        entry.addAll(unify$getIDs("STEEL", false));
        entry.addAll(unify$getIDs("ELECTRUM", false));
        entry.addAll(unify$getIDs("BRONZE", false));
        entry.addAll(unify$getIDs("CAST_IRON", false));
        entry.addAll(unify$getIDs("INVAR", false));
        entry.addAll(unify$getIDs("CONSTANTAN", false));
        entry.addAll(unify$getIDs("WROUGHT_IRON", false));
        entry.addAll(unify$getIDs("TARNISHED_GOLD", false));
        return entry;
    }

    private static List<String> unify$getIDs(String name, boolean isOre) {
        String id = name.toLowerCase();
        List<String> asIDs = new ArrayList<>();
        asIDs.add(id + "_ingot");
        asIDs.add(id + "_nugget");
        asIDs.add(id + "_sheet");
        asIDs.add(id + "_block");

        if (isOre) {
            asIDs.add("raw_" + id);
            asIDs.add("raw_" + id + "_block");
            asIDs.add(id + "_ore");
            asIDs.add("deepslate_" + id + "_ore");
        }
        return asIDs;
    }

    private static String unify$safeId(ItemLike registryEntry) {
        return unify$safeName(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(registryEntry.asItem()))).replace("unify:", "");
    }

    private static String unify$safeName(ResourceLocation id) {
        return id.getPath().replace('/', '_');
    }
}
