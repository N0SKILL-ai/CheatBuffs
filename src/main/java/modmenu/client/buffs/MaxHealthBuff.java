package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class MaxHealthBuff extends Buff {

    public MaxHealthBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
        overrideSync = true;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.MAX_HEALTH, 0f);
    }
    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.MAX_HEALTH) != CheatBuffs.instance.clientSideStash.maxhealthbuff) {
            activeBuff.setModifier(BuffModifiers.MAX_HEALTH, (float) CheatBuffs.instance.clientSideStash.maxhealthbuff);
        }
        activeBuff.forceManagerUpdate();
    }
    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.MAX_HEALTH) != CheatBuffs.instance.clientSideStash.maxhealthbuff) {
            activeBuff.setModifier(BuffModifiers.MAX_HEALTH, (float) CheatBuffs.instance.clientSideStash.maxhealthbuff);
        }
        activeBuff.forceManagerUpdate();
    }
}