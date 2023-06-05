package modmenu.client.buffs;

import modmenu.CheatBuffs;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class ManyMobsBuff extends Buff {
    public ManyMobsBuff() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.MOB_SPAWN_RATE, 0f);
    }

    @Override
    public void clientTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.MOB_SPAWN_RATE) != CheatBuffs.instance.clientSideStash.mmbuff) {
            activeBuff.setModifier(BuffModifiers.MOB_SPAWN_RATE, (float) CheatBuffs.instance.clientSideStash.mmbuff);
        }
    }

    @Override
    public void serverTick(ActiveBuff activeBuff) {
        if(activeBuff.getModifier(BuffModifiers.MOB_SPAWN_RATE) != CheatBuffs.instance.clientSideStash.mmbuff) {
            activeBuff.setModifier(BuffModifiers.MOB_SPAWN_RATE, (float) CheatBuffs.instance.clientSideStash.mmbuff);
        }
    }

}