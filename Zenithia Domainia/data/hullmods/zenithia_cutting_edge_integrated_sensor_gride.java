package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;

public class zenithia_cutting_edge_integrated_sensor_gride extends BaseHullMod {


    private static final int SENSOR_STRENGTH = 20000;
    public static final float SENSOR_PROFILE = 20000f;


    public void applyEffectsBeforeShipCreation(ShipAPI.HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getSensorStrength().modifyFlat(id, SENSOR_STRENGTH);
        stats.getSensorProfile().modifyFlat(id, SENSOR_PROFILE);
    }

    public String getDescriptionParam(int index, ShipAPI.HullSize hullSize) {
        if (index == 0) return "" + SENSOR_STRENGTH;
        if (index == 1) return "" + (int) SENSOR_PROFILE;
        return null;
    }
}