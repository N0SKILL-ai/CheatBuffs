package modmenu;

import modmenu.client.ClientSideStash;
import modmenu.client.buffs.*;
import modmenu.client.listener.ServerClientConnectListener;
import modmenu.client.listener.ServerClientDisconnectListener;
import modmenu.server.playerdata.PlayerDataManger;
import necesse.engine.GameEvents;
import necesse.engine.events.ServerClientConnectedEvent;
import necesse.engine.events.ServerClientDisconnectEvent;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.*;

@ModEntry
public class CheatBuffs {

    public static CheatBuffs instance;

    public PlayerDataManger playerDataManger;
    public ClientSideStash clientSideStash = new ClientSideStash();

    public void init() {
        instance = this;

        this.playerDataManger = new PlayerDataManger();

        GameEvents.addListener(ServerClientDisconnectEvent.class, new ServerClientDisconnectListener());
        GameEvents.addListener(ServerClientConnectedEvent.class, new ServerClientConnectListener());
        BuffRegistry.registerBuff("unlimitedsummonsbuff", new UnlimitedSummonsBuff());
        BuffRegistry.registerBuff("dmgmultbuff", new DamageMultiplierBuff());
        BuffRegistry.registerBuff("atsbuff", new AttackSpeedBuff());
        BuffRegistry.registerBuff("insiviblebuff", new InsivibleBuff());
        BuffRegistry.registerBuff("manymobsbuff", new ManyMobsBuff());
        BuffRegistry.registerBuff("superminingbuff", new SuperMiningBuff());
        BuffRegistry.registerBuff("superpickupbuff", new SuperPickupBuff());
        BuffRegistry.registerBuff("supersummonsbuff", new SuperSummonsBuff());
        BuffRegistry.registerBuff("maxhealthbuff", new MaxHealthBuff());
        BuffRegistry.registerBuff("infammobuff", new InfinityAmmoBuff());
        BuffRegistry.registerBuff("regenbuff", new HPRegenBuff());
        BuffRegistry.registerBuff("staminabuff", new StaminaBuff());
        BuffRegistry.registerBuff("lightbuff", new LightBuff());
        BuffRegistry.registerBuff("waterwalkingbuff", new WaterWalkingBuff());
        BuffRegistry.registerBuff("superbuildbuff", new SuperBuildBuff());
        BuffRegistry.registerBuff("alwayscritbuff", new AlwaysCritBuff());
    }

    public void initResources() {
    }

    public void postInit() {
    }

}
