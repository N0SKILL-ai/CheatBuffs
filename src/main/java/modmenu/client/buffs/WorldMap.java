package modmenu.client.buffs;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class WorldMap extends Buff {

    public WorldMap() {
        canCancel = false;
        isVisible = false;
        shouldSave = false;
        overrideSync = true;
    }

    @Override
    public void init(ActiveBuff activeBuff) {
        activeBuff.setModifier(BuffModifiers.TRAVEL_DISTANCE, 999999999);
        activeBuff.setModifier(BuffModifiers.BIOME_VIEW_DISTANCE, 999999999);
    }

}