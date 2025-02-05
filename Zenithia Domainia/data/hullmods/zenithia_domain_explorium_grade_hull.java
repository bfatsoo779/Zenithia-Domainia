package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class zenithia_domain_explorium_grade_hull extends BaseHullMod {

	public static float HULL_BONUS = 60f;
	public static float CASUALTY_REDUCTION = 95f;
	public static float CORONA_EFFECT_MULT = 0.05f;
	public static float ENERGY_DAMAGE_MULT = 0.85f;
	public static float REPAIR_RATE_BONUS = 50f;
	public static float CR_RECOVERY_BONUS = 50f;
	public static float REPAIR_BONUS = 50f;
	//public static final float HULL_DAMAGE_CR_MULT = 0.25f;

	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
//		stats.getCargoMod().modifyPercent(id, -50f);
//		stats.getCargoMod().modifyPercent(id + "sfsdfd", +25f);
//		stats.getMaxCrewMod().modifyPercent(id, 100);
        stats.getHullBonus().modifyPercent(id, HULL_BONUS);
		stats.getCrewLossMult().modifyMult(id, 1f - (CASUALTY_REDUCTION) * 0.01f);
		//stats.getDynamic().getStat(Stats.HULL_DAMAGE_CR_LOSS).modifyMult(id, HULL_DAMAGE_CR_MULT);
        stats.getEnergyDamageTakenMult().modifyMult(id, ENERGY_DAMAGE_MULT);
		stats.getEnergyShieldDamageTakenMult().modifyMult(id, ENERGY_DAMAGE_MULT);
		float bonus = REPAIR_BONUS;
		stats.getCombatEngineRepairTimeMult().modifyMult(id, 1f - bonus * 0.01f);
		stats.getCombatWeaponRepairTimeMult().modifyMult(id, 1f - bonus * 0.01f);
//		stats.getBaseCRRecoveryRatePercentPerDay().modifyPercent(id, CR_RECOVERY_BONUS);
//		stats.getRepairRatePercentPerDay().modifyPercent(id, REPAIR_RATE_BONUS);
//		stats.getSuppliesToRecover().modifyPercent(id, LOGISTICS_PENALTY);
//		stats.getSuppliesPerMonth().modifyPercent(id, LOGISTICS_PENALTY);
	}
	public String getDescriptionParam(int index, HullSize hullSize) {
		if (index == 0) return "" + (int) HULL_BONUS + "%";
		if (index == 1) return "" + (int) CASUALTY_REDUCTION + "%";
		if (index == 2) return "" + (int) Math.round((1f - CORONA_EFFECT_MULT) * 100f) + "%";
		if (index == 3) return "" + (int) Math.round((1f - ENERGY_DAMAGE_MULT) * 100f) + "%";
		if (index == 4) return "" + (int) REPAIR_BONUS + "%";
//		if (index == 5) return "" + (int) CR_RECOVERY_BONUS + "%";
		//if (index == 6) return "" + (int) ((1f - HULL_DAMAGE_CR_MULT) * 100f);
		return null;
	}
}
