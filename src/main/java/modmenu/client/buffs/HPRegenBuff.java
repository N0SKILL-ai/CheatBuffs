package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class HPRegenBuff extends Buff {

    public HPRegenBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.REGEN, 10000000f);
        activeBuff.setModifier(BuffModifiers.COMBAT_REGEN, 10000000f);
    }

    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.REGEN) != CheatBuffs.instance.clientSideStash.regen) {
            activeBuff.setModifier(BuffModifiers.REGEN, (float) CheatBuffs.instance.clientSideStash.regen);
        }
        if(activeBuff.getModifier(BuffModifiers.COMBAT_REGEN) != CheatBuffs.instance.clientSideStash.regen) {
            activeBuff.setModifier(BuffModifiers.COMBAT_REGEN, (float) CheatBuffs.instance.clientSideStash.regen);
        }
    }
    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.REGEN) != CheatBuffs.instance.clientSideStash.regen) {
            activeBuff.setModifier(BuffModifiers.REGEN, (float) CheatBuffs.instance.clientSideStash.regen);
        }
        if(activeBuff.getModifier(BuffModifiers.COMBAT_REGEN) != CheatBuffs.instance.clientSideStash.regen) {
            activeBuff.setModifier(BuffModifiers.COMBAT_REGEN, (float) CheatBuffs.instance.clientSideStash.regen);
        }
    }

}