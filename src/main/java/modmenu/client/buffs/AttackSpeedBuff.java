package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class AttackSpeedBuff extends Buff {

    public AttackSpeedBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.ATTACK_SPEED, 0f);
    }
    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.ATTACK_SPEED) != CheatBuffs.instance.clientSideStash.atsbuff) {
            activeBuff.setModifier(BuffModifiers.ATTACK_SPEED, (float) CheatBuffs.instance.clientSideStash.atsbuff);
        }
    }
    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.ATTACK_SPEED) != CheatBuffs.instance.clientSideStash.atsbuff) {
            activeBuff.setModifier(BuffModifiers.ATTACK_SPEED, (float) CheatBuffs.instance.clientSideStash.atsbuff);
        }
    }

}