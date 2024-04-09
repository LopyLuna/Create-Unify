package uwu.lopyluna.create_unify.config;

public class UnifyConfigCommon extends UnifyConfigBase {

    public final ConfigGroup common = group(0, "common", Comments.common);

    public final ConfigBool worldgen_all = b(false, "worldgen_all", Comments.worldgen_all);
    public final ConfigBool worldgen_tin = b(false, "worldgen_tin", Comments.worldgen_tin);
    public final ConfigBool worldgen_aluminum = b(false, "worldgen_aluminum", Comments.worldgen_aluminum);
    public final ConfigBool worldgen_lead = b(false, "worldgen_lead", Comments.worldgen_lead);
    public final ConfigBool worldgen_silver = b(false, "worldgen_silver", Comments.worldgen_silver);
    public final ConfigBool worldgen_platinum = b(false, "worldgen_platinum", Comments.worldgen_platinum);
    public final ConfigBool worldgen_uranium = b(false, "worldgen_uranium", Comments.worldgen_uranium);

    @Override public String getName() { return "common"; }

    private static class Comments {
        static String common = "Common config file for Create Unify.";
        static String worldgen_all = "Enable Worldgen for All Materials";
        static String worldgen_tin = "Enable Worldgen for Tin";
        static String worldgen_aluminum = "Enable Worldgen for Aluminum";
        static String worldgen_lead = "Enable Worldgen for Lead";
        static String worldgen_silver = "Enable Worldgen for Silver";
        static String worldgen_platinum = "Enable Worldgen for Platinum";
        static String worldgen_uranium = "Enable Worldgen for Uranium";
    }
}
