package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class SuperPickupBuff extends Buff {

    public SuperPickupBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.ITEM_PICKUP_RANGE, 0f); // +30 Range
    }
    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.ITEM_PICKUP_RANGE) != CheatBuffs.instance.clientSideStash.superpickupbuff) {
            activeBuff.setModifier(BuffModifiers.ITEM_PICKUP_RANGE, (float) CheatBuffs.instance.clientSideStash.superpickupbuff);
        }
    }

    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.ITEM_PICKUP_RANGE) != CheatBuffs.instance.clientSideStash.superpickupbuff) {
            activeBuff.setModifier(BuffModifiers.ITEM_PICKUP_RANGE, (float) CheatBuffs.instance.clientSideStash.superpickupbuff);
        }
    }

}