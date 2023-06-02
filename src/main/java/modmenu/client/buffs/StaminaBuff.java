package modmenu.client.buffs;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class StaminaBuff extends Buff {

    public StaminaBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.STAMINA_REGEN, 10000000f);
        activeBuff.setModifier(BuffModifiers.STAMINA_CAPACITY, 10000000f);
    }

}