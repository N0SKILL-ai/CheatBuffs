package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class DamageMultiplierBuff extends Buff {

    public DamageMultiplierBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.ALL_DAMAGE, 0f); // x5 Damage Multiplier
    }
    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.ALL_DAMAGE) != CheatBuffs.instance.clientSideStash.dmgmultbuff) {
            activeBuff.setModifier(BuffModifiers.ALL_DAMAGE, (float) CheatBuffs.instance.clientSideStash.dmgmultbuff);
        }
    }
    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.ALL_DAMAGE) != CheatBuffs.instance.clientSideStash.dmgmultbuff) {
            activeBuff.setModifier(BuffModifiers.ALL_DAMAGE, (float) CheatBuffs.instance.clientSideStash.dmgmultbuff);
        }
    }

}