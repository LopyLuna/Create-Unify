package uwu.lopyluna.create_unify.config;

public class UnifyConfigClient extends UnifyConfigBase {

    public final ConfigGroup client = group(0, "client", Comments.client);

    @Override public String getName() { return "client"; }

    private static class Comments {
        static String client = "Client config file for Create Unify.";
    }
}
