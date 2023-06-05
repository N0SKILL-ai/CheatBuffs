package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class AlwaysCritBuff extends Buff {
    public AlwaysCritBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.CRIT_CHANCE, 0f);
    }

    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.CRIT_CHANCE) != CheatBuffs.instance.clientSideStash.critchance) {
            activeBuff.setModifier(BuffModifiers.CRIT_CHANCE, (float) CheatBuffs.instance.clientSideStash.critchance);
        }
    }

    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.CRIT_CHANCE) != CheatBuffs.instance.clientSideStash.critchance) {
            activeBuff.setModifier(BuffModifiers.CRIT_CHANCE, (float) CheatBuffs.instance.clientSideStash.critchance);
        }
    }

}