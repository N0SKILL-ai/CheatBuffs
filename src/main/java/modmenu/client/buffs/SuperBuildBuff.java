package modmenu.client.buffs;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class SuperBuildBuff extends Buff {

    public SuperBuildBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.BUILDING_SPEED, 100f); // +100 Speed
        activeBuff.setModifier(BuffModifiers.BUILD_RANGE, 20f); // +20 Range
    }

}