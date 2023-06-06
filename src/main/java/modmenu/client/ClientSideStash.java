package modmenu.client;

import modmenu.client.buffs.ManyMobsBuff;
import necesse.entity.mobs.buffs.ActiveBuff;

public final class ClientSideStash {
    public boolean godMode = false;
    public int speed = 0;
    public int mmbuff = 0;
    public int atsbuff = 0;
    public int superminingbuff = 0;
    public int superpickupbuff = 0;
    public int supersummonsbuff = 0;
    public int maxhealthbuff = 0;
    public int dmgmultbuff = 0;
    public int critchance = 0;
    public int regen = 0;
    public boolean infammobuff = false;
    public boolean staminabuff = false;
    public boolean lightbuff = false;
    public boolean waterwalkingbuff = false;
    public boolean superbuildbuff = false;
    public boolean invisiblebuff = false;
    public boolean unlimitedsummonsbuff = false;
    public boolean worldbuff = false;

    public void resetAll() {
        this.godMode = false;
        this.speed = 0;
        this.mmbuff = 0;
        this.atsbuff = 0;
        this.superminingbuff = 0;
        this.superpickupbuff = 0;
        this.supersummonsbuff = 0;
        this.maxhealthbuff = 0;
        this.dmgmultbuff = 0;
        this.critchance = 0;
        this.regen = 0;
        this.infammobuff = false;
        this.staminabuff = false;
        this.lightbuff = false;
        this.waterwalkingbuff = false;
        this.superbuildbuff = false;
        this.invisiblebuff = false;
        this.unlimitedsummonsbuff = false;
        this.worldbuff = false;
    }

}
