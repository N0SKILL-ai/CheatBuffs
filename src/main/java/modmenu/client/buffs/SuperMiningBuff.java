package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class SuperMiningBuff extends Buff {

    public SuperMiningBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.MINING_SPEED, 0f); // +100 Speed
        activeBuff.setModifier(BuffModifiers.MINING_RANGE, 0f); // +20 Range
    }
    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.MINING_SPEED) != CheatBuffs.instance.clientSideStash.superminingbuff) {
            activeBuff.setModifier(BuffModifiers.MINING_SPEED, (float) CheatBuffs.instance.clientSideStash.superminingbuff);
        }
        if(activeBuff.getModifier(BuffModifiers.MINING_RANGE) != CheatBuffs.instance.clientSideStash.superminingbuff) {
            activeBuff.setModifier(BuffModifiers.MINING_RANGE, (float) CheatBuffs.instance.clientSideStash.superminingbuff);
        }
    }
    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.MINING_SPEED) != CheatBuffs.instance.clientSideStash.superminingbuff) {
            activeBuff.setModifier(BuffModifiers.MINING_SPEED, (float) CheatBuffs.instance.clientSideStash.superminingbuff);
        }
        if(activeBuff.getModifier(BuffModifiers.MINING_RANGE) != CheatBuffs.instance.clientSideStash.superminingbuff) {
            activeBuff.setModifier(BuffModifiers.MINING_RANGE, (float) CheatBuffs.instance.clientSideStash.superminingbuff);
        }
    }

}