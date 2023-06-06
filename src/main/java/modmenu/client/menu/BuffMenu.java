package modmenu.client.menu;

import modmenu.CheatBuffs;
import modmenu.server.playerdata.PlayerData;
import necesse.engine.commands.PermissionLevel;
import necesse.engine.control.InputEvent;
import necesse.engine.network.Packet;
import necesse.engine.network.client.Client;
import necesse.engine.network.server.ServerClient;
import necesse.engine.tickManager.TickManager;
import necesse.entity.mobs.PlayerMob;
import necesse.engine.registries.BuffRegistry;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.gfx.forms.Form;
import necesse.gfx.forms.FormManager;
import necesse.gfx.forms.components.*;
import necesse.gfx.gameFont.FontOptions;


public class BuffMenu extends Form {

    private final FormManager formManager;
    private final Client client;
    public boolean shown;

    public CurrentMenu currentMenu = CurrentMenu.Main;

    public BuffMenu(final FormManager formManager, final Client client) {
        super("Cheats", 500, 330);
        this.setPosition(700, 150);

        this.formManager = formManager;
        this.client = client;
    }

    @Override
    public void handleInputEvent(final InputEvent event, final TickManager tickManager, final PlayerMob perspective) {
        super.handleInputEvent(event, tickManager, perspective);

        if (event.isKeyboardEvent() && event.getID() == 256) {
            this.shown = false;
            this.formManager.removeComponent(this);
        }
    }

    public void initMenu() {
        this.clearComponents();
        if(client.getPermissionLevel() == PermissionLevel.ADMIN || client.getPermissionLevel() == PermissionLevel.OWNER) {
            this.currentMenu = CurrentMenu.CheatBuffs;
            this.initPane();
        }
    }

    public void initPane() {
        this.initPlayerMenu();

    }

    public void initPlayerMenu() {
        final PlayerData playerData = CheatBuffs.instance.playerDataManger.get(client.getPlayer());

        final FormSlider manyMobsSlider = new FormSlider("Mob Spawnrate", 250, 10, CheatBuffs.instance.clientSideStash.mmbuff, 0, 100, 200, new FontOptions(10));
        final FormSlider critchanceSloder = new FormSlider("Crit Chance", 250, 40, CheatBuffs.instance.clientSideStash.critchance, 0, 100, 200, new FontOptions(10));
        final FormSlider attackSpeedSlider = new FormSlider("Attack Speed", 250, 70, CheatBuffs.instance.clientSideStash.atsbuff, 0, 100, 200, new FontOptions(10));
        final FormSlider dmgMultSlider = new FormSlider("Damage Multiplier", 250, 100, CheatBuffs.instance.clientSideStash.dmgmultbuff, 0, 100, 200, new FontOptions(10));
        final FormSlider maxHealthSlider = new FormSlider("Max Health", 250, 130, CheatBuffs.instance.clientSideStash.maxhealthbuff, 0, 100, 200, new FontOptions(10));
        final FormSlider miningSlider = new FormSlider("Mining Buff", 250, 160, CheatBuffs.instance.clientSideStash.superminingbuff, 0, 100, 200, new FontOptions(10));
        final FormSlider pickupSlider = new FormSlider("Pickup Range", 250, 190, CheatBuffs.instance.clientSideStash.superpickupbuff, 0, 100, 200, new FontOptions(10));
        final FormSlider summonBuff = new FormSlider("Super Summons", 250, 220, CheatBuffs.instance.clientSideStash.supersummonsbuff, 0, 100, 200, new FontOptions(10));
        final FormSlider speedSlider = new FormSlider("Speed", 250, 250, CheatBuffs.instance.clientSideStash.speed, 10, 2000, 200, new FontOptions(10));
        final FormCheckBox godmodeCheckbox = new FormCheckBox("(Nearly) Godmode", 5, 10);
        final FormCheckBox staminaCheckBox = new FormCheckBox("Unlimited Stamina", 5, 40);
        final FormCheckBox lightCheckBox = new FormCheckBox("Afraid in the dark", 5, 70);
        final FormCheckBox infammobuffCheckBox = new FormCheckBox("Infinite Ammo", 5, 100);
        final FormCheckBox unlimitedSummonsCheckBox = new FormCheckBox("Unlimited Summons", 5, 130);
        final FormCheckBox insiviblebuffCheckBox = new FormCheckBox("Invisible", 5, 160);
        final FormCheckBox waterWalkingCheckbox = new FormCheckBox("Water Walking", 5, 190);
        final FormCheckBox superbuildCheckBox = new FormCheckBox("Super Build", 5, 220);
        final FormCheckBox worldmapCheckBox = new FormCheckBox("Worldmap High Range", 5, 250);
        final FormTextButton healButton = new FormTextButton("Heal", "Heal yourself", 5, 270, 80);

        necesse.entity.mobs.buffs.staticBuffs.Buff buffSums = BuffRegistry.getBuff("unlimitedsummonsbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffDamage = BuffRegistry.getBuff("dmgmultbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffATS = BuffRegistry.getBuff("atsbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffInv = BuffRegistry.getBuff("insiviblebuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffManyMobs = BuffRegistry.getBuff("manymobsbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffSuperMining = BuffRegistry.getBuff("superminingbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffSuperPickup = BuffRegistry.getBuff("superpickupbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffSuperSummons = BuffRegistry.getBuff("supersummonsbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffMaxHealth = BuffRegistry.getBuff("maxhealthbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffInfAmmo = BuffRegistry.getBuff("infammobuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffRegen = BuffRegistry.getBuff("regenbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffStamina = BuffRegistry.getBuff("staminabuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffLight = BuffRegistry.getBuff("lightbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffWaterWalking = BuffRegistry.getBuff("waterwalkingbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffSuperBuild = BuffRegistry.getBuff("superbuildbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffAlwaysCrit = BuffRegistry.getBuff("alwayscritbuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffGodMode = BuffRegistry.getBuff("godmodebuff");
        necesse.entity.mobs.buffs.staticBuffs.Buff buffWorldmap = BuffRegistry.getBuff("worldbuff");

        manyMobsSlider.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.mmbuff = manyMobsSlider.getValue();
            if(CheatBuffs.instance.clientSideStash.mmbuff > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffManyMobs)) {
                    ActiveBuff ab = new ActiveBuff(buffManyMobs, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffManyMobs, true);
            }
        });

        critchanceSloder.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.critchance = critchanceSloder.getValue();
            if(CheatBuffs.instance.clientSideStash.critchance > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffAlwaysCrit)) {
                    ActiveBuff ab = new ActiveBuff(buffAlwaysCrit, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffAlwaysCrit, true);
            }
        });

        attackSpeedSlider.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.atsbuff = attackSpeedSlider.getValue();
            if(CheatBuffs.instance.clientSideStash.atsbuff > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffATS)) {
                    ActiveBuff ab = new ActiveBuff(buffATS, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffATS, true);
            }
        });

        dmgMultSlider.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.dmgmultbuff = dmgMultSlider.getValue();
            if(CheatBuffs.instance.clientSideStash.dmgmultbuff > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffDamage)) {
                    ActiveBuff ab = new ActiveBuff(buffDamage, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffDamage, true);
            }
        });

        maxHealthSlider.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.maxhealthbuff = maxHealthSlider.getValue();
            if(CheatBuffs.instance.clientSideStash.maxhealthbuff > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffMaxHealth)) {
                    ActiveBuff ab = new ActiveBuff(buffMaxHealth, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set

                    CheatBuffs.instance.clientSideStash.regen = 10000000;
                    ActiveBuff abHeal = new ActiveBuff(buffRegen, client.getPlayer(), 1000, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(abHeal, true, false); // set buff
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffMaxHealth, true);
            }

        });

        miningSlider.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.superminingbuff = miningSlider.getValue();
            if(CheatBuffs.instance.clientSideStash.superminingbuff > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffSuperMining)) {
                    ActiveBuff ab = new ActiveBuff(buffSuperMining, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffSuperMining, true);
            }
        });

        pickupSlider.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.superpickupbuff = pickupSlider.getValue();
            if(CheatBuffs.instance.clientSideStash.superpickupbuff > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffSuperPickup)) {
                    ActiveBuff ab = new ActiveBuff(buffSuperPickup, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffSuperPickup, true);
            }
        });

        summonBuff.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.supersummonsbuff = summonBuff.getValue();
            if(CheatBuffs.instance.clientSideStash.supersummonsbuff > 0) {
                if(!client.getPlayer().buffManager.hasBuff(buffSuperSummons)) {
                    ActiveBuff ab = new ActiveBuff(buffSuperSummons, client.getPlayer(), 999999999, null); // initiate and configure buff
                    client.getPlayer().buffManager.addBuff(ab, true); // set
                }
            } else {
                client.getPlayer().buffManager.removeBuff(buffSuperSummons, true);
            }
        });

        speedSlider.onChanged(e -> {
            CheatBuffs.instance.clientSideStash.speed = speedSlider.getValue();
            client.getPlayer().setSpeed(35.0F + speedSlider.getValue());
        });

        unlimitedSummonsCheckBox.onClicked(e -> {
            ActiveBuff ab;

            System.out.println("unlimitedSumms: " + CheatBuffs.instance.clientSideStash.unlimitedsummonsbuff);
            if(CheatBuffs.instance.clientSideStash.unlimitedsummonsbuff) {
                CheatBuffs.instance.clientSideStash.unlimitedsummonsbuff = false;
                client.getPlayer().buffManager.removeBuff(buffSums, true);
            } else {
                CheatBuffs.instance.clientSideStash.unlimitedsummonsbuff = true;
                ab = new ActiveBuff(buffSums, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });

        infammobuffCheckBox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.infammobuff = false;
                client.getPlayer().buffManager.removeBuff(buffInfAmmo, true);
            } else {
                CheatBuffs.instance.clientSideStash.infammobuff = true;
                ab = new ActiveBuff(buffInfAmmo, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });

        staminaCheckBox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.staminabuff = false;
                client.getPlayer().buffManager.removeBuff(buffStamina, true);
            } else {
                CheatBuffs.instance.clientSideStash.staminabuff = true;
                ab = new ActiveBuff(buffStamina, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });

        lightCheckBox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.lightbuff = false;
                client.getPlayer().buffManager.removeBuff(buffLight, true);
            } else {
                CheatBuffs.instance.clientSideStash.lightbuff = true;
                ab = new ActiveBuff(buffLight, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });

        waterWalkingCheckbox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.waterwalkingbuff = false;
                client.getPlayer().buffManager.removeBuff(buffWaterWalking, true);
            } else {
                CheatBuffs.instance.clientSideStash.waterwalkingbuff = true;
                ab = new ActiveBuff(buffWaterWalking, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });

        superbuildCheckBox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.superbuildbuff = false;
                client.getPlayer().buffManager.removeBuff(buffSuperBuild, true);
            } else {
                CheatBuffs.instance.clientSideStash.superbuildbuff = true;
                ab = new ActiveBuff(buffSuperBuild, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });

        worldmapCheckBox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.worldbuff = false;
                client.getPlayer().buffManager.removeBuff(buffWorldmap, true);
            } else {
                CheatBuffs.instance.clientSideStash.worldbuff = true;
                ab = new ActiveBuff(buffWorldmap, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });

        insiviblebuffCheckBox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.invisiblebuff = false;
                client.getPlayer().buffManager.removeBuff(buffInv, true);
            } else {
                CheatBuffs.instance.clientSideStash.invisiblebuff = true;
                ab = new ActiveBuff(buffInv, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true); // set buff
            }
        });


        godmodeCheckbox.onClicked(e -> {
            ActiveBuff ab;

            if(!e.from.checked) {
                CheatBuffs.instance.clientSideStash.godMode = false;
                client.getPlayer().buffManager.removeBuff(buffGodMode, true);

            } else {
                CheatBuffs.instance.clientSideStash.godMode = true;
                ab = new ActiveBuff(buffGodMode, client.getPlayer(), 999999999, null); // initiate and configure buff
                client.getPlayer().buffManager.addBuff(ab, true, false); // set buff
            }
        });

        healButton.onClicked(e -> {
            CheatBuffs.instance.clientSideStash.regen = 10000000;
            ActiveBuff ab = new ActiveBuff(buffRegen, client.getPlayer(), 1000, null); // initiate and configure buff
            client.getPlayer().buffManager.addBuff(ab, true, false); // set buff
        });


        this.addComponent(manyMobsSlider);
        this.addComponent(critchanceSloder);
        this.addComponent(attackSpeedSlider);
        this.addComponent(dmgMultSlider);
        this.addComponent(maxHealthSlider);
        this.addComponent(miningSlider);
        this.addComponent(pickupSlider);
        this.addComponent(summonBuff);
        this.addComponent(speedSlider);

        this.addComponent(godmodeCheckbox);
        this.addComponent(staminaCheckBox);
        this.addComponent(lightCheckBox);
        this.addComponent(infammobuffCheckBox);
        this.addComponent(unlimitedSummonsCheckBox);
        this.addComponent(insiviblebuffCheckBox);
        this.addComponent(waterWalkingCheckbox);
        this.addComponent(superbuildCheckBox);
        this.addComponent(worldmapCheckBox);
        this.addComponent(healButton);

        godmodeCheckbox.checked = CheatBuffs.instance.clientSideStash.godMode;
        unlimitedSummonsCheckBox.checked = CheatBuffs.instance.clientSideStash.unlimitedsummonsbuff;
        insiviblebuffCheckBox.checked = CheatBuffs.instance.clientSideStash.invisiblebuff;
        infammobuffCheckBox.checked = CheatBuffs.instance.clientSideStash.infammobuff;
        staminaCheckBox.checked = CheatBuffs.instance.clientSideStash.staminabuff;
        lightCheckBox.checked = CheatBuffs.instance.clientSideStash.lightbuff;
        waterWalkingCheckbox.checked = CheatBuffs.instance.clientSideStash.waterwalkingbuff;
        superbuildCheckBox.checked = CheatBuffs.instance.clientSideStash.superbuildbuff;
        worldmapCheckBox.checked = CheatBuffs.instance.clientSideStash.worldbuff;
    }

}
