package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class GodBuff extends Buff {

    public GodBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
        overrideSync = true;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.INCOMING_DAMAGE_MOD, -100f);
    }

}