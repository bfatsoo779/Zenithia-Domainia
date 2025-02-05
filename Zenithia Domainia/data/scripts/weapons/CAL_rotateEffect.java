//Created by Bfatsoo

package data.scripts.weapons;
import com.fs.starfarer.api.combat.CombatEngineAPI;
import com.fs.starfarer.api.combat.EveryFrameWeaponEffectPlugin;
import com.fs.starfarer.api.combat.WeaponAPI;

public class CAL_rotateEffect implements EveryFrameWeaponEffectPlugin {
    
    private boolean rotate = true;
    
    @Override
    public void advance(float amount, CombatEngineAPI engine, WeaponAPI weapon){
        if (engine.isPaused() || !rotate) {return;}

        if(!weapon.getShip().isAlive()){
            rotate=false;
            return;
        }
        
        weapon.setCurrAngle(weapon.getCurrAngle()+amount*25);
        
    }
}
