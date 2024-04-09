package uwu.lopyluna.create_unify.config;

public class UnifyConfigServer extends UnifyConfigBase {

    public final ConfigGroup server = group(0, "common", Comments.server);
    public final ConfigBool feature_all = b(false, "feature_all", Comments.feature_all);

    public final ConfigBool feature_tin = b(false, "feature_tin", Comments.feature_tin);
    public final ConfigBool feature_aluminum = b(false, "feature_aluminum", Comments.feature_aluminum);
    public final ConfigBool feature_lead = b(false, "feature_lead", Comments.feature_lead);
    public final ConfigBool feature_silver = b(false, "feature_silver", Comments.feature_silver);
    public final ConfigBool feature_platinum = b(false, "feature_platinum", Comments.feature_platinum);
    public final ConfigBool feature_uranium = b(false, "feature_uranium", Comments.feature_uranium);
    public final ConfigBool feature_bronze = b(false, "feature_bronze", Comments.feature_bronze);
    public final ConfigBool feature_electrum = b(false, "feature_electrum", Comments.feature_electrum);
    public final ConfigBool feature_cast_iron = b(false, "feature_cast_iron", Comments.feature_cast_iron);
    public final ConfigBool feature_steel = b(false, "feature_steel", Comments.feature_steel);

    @Override public String getName() { return "server"; }

    private static class Comments {
        static String server = "Server config file for Create Unify.";
        static String feature_all = "Display & Enable All Materials";
        static String feature_tin = "Display & Enable Tin Materials";
        static String feature_aluminum = "Display & Enable Aluminum Materials";
        static String feature_lead = "Display & Enable Lead Materials";
        static String feature_silver = "Display & Enable Silver Materials";
        static String feature_platinum = "Display & Enable Platinum Materials";
        static String feature_uranium = "Display & Enable Uranium Materials";
        static String feature_bronze = "Display & Enable Bronze Materials";
        static String feature_electrum = "Display & Enable Electrum Materials";
        static String feature_cast_iron = "Display & Enable CastIron Materials";
        static String feature_steel = "Display & Enable Steel Materials";
    }
}
