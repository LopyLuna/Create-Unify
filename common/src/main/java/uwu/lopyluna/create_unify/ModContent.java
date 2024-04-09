package uwu.lopyluna.create_unify;

import uwu.lopyluna.create_unify.registry.UnifyConfig;

@SuppressWarnings("all")
public class ModContent {
    /*
     * MIXIN THIS IF NEEDED
     */

    public static boolean EnableAllMetals() {
        return UnifyConfig.SERVER.feature_all.get() || false;
    }
    public static boolean EnableAllWorldGen() {
        return UnifyConfig.COMMON.worldgen_all.get() || false;
    }

    public static boolean EnableTin() {
        return UnifyConfig.SERVER.feature_tin.get() || EnableAllMetals() || false;
    }
    public static boolean EnableAluminum() {
        return UnifyConfig.SERVER.feature_aluminum.get() || EnableAllMetals() || false;
    }
    public static boolean EnableLead() {
        return UnifyConfig.SERVER.feature_lead.get() || EnableAllMetals() || false;
    }
    public static boolean EnableSilver() {
        return UnifyConfig.SERVER.feature_silver.get() || EnableAllMetals() || false;
    }
    public static boolean EnablePlatinum() {
        return UnifyConfig.SERVER.feature_platinum.get() || EnableAllMetals() || false;
    }
    public static boolean EnableUranium() {
        return UnifyConfig.SERVER.feature_uranium.get() || EnableAllMetals() || false;
    }
    public static boolean EnableBronze() {
        return UnifyConfig.SERVER.feature_bronze.get() || EnableAllMetals() || false;
    }
    public static boolean EnableElectrum() {
        return UnifyConfig.SERVER.feature_electrum.get() || EnableAllMetals() || false;
    }
    public static boolean EnableCastIron() {
        return UnifyConfig.SERVER.feature_cast_iron.get() || EnableAllMetals() || false;
    }
    public static boolean EnableSteel() {
        return UnifyConfig.SERVER.feature_steel.get() || EnableAllMetals() || false;
    }

    public static boolean EnableTinWorldGen() {
        return UnifyConfig.COMMON.worldgen_tin.get() || EnableAllWorldGen() || false;
    }
    public static boolean EnableAluminumWorldGen() {
        return UnifyConfig.COMMON.worldgen_aluminum.get() || EnableAllWorldGen() || false;
    }
    public static boolean EnableLeadWorldGen() {
        return UnifyConfig.COMMON.worldgen_lead.get() || EnableAllWorldGen() || false;
    }
    public static boolean EnableSilverWorldGen() {
        return UnifyConfig.COMMON.worldgen_silver.get() || EnableAllWorldGen() || false;
    }
    public static boolean EnablePlatinumWorldGen() {
        return UnifyConfig.COMMON.worldgen_platinum.get() || EnableAllWorldGen() || false;
    }
    public static boolean EnableUraniumWorldGen() {
        return UnifyConfig.COMMON.worldgen_uranium.get() || EnableAllWorldGen() || false;
    }
}
