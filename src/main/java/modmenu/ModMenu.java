package modmenu;

import modmenu.client.ClientSideStash;
import modmenu.client.buffs.*;
import modmenu.client.listener.ServerClientConnectListener;
import modmenu.client.listener.ServerClientDisconnectListener;
import modmenu.server.commands.*;
import modmenu.server.playerdata.PlayerDataManger;
import necesse.engine.GameEvents;
import necesse.engine.commands.CommandsManager;
import necesse.engine.events.ServerClientConnectedEvent;
import necesse.engine.events.ServerClientDisconnectEvent;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.*;
import necesse.entity.mobs.buffs.staticBuffs.FoodBuff;

@ModEntry
public class ModMenu {

    public static ModMenu instance;

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
        BuffRegistry.registerBuff("knockbackbuff", new KnockbackBuff());
        BuffRegistry.registerBuff("waterwalkingbuff", new WaterWalkingBuff());
        BuffRegistry.registerBuff("superbuildbuff", new SuperBuildBuff());
        BuffRegistry.registerBuff("alwayscritbuff", new AlwaysCritBuff());
    }

    public void initResources() {
    }

    public void postInit() {
    }

}
