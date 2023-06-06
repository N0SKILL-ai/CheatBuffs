package modmenu.server.playerdata.patches;

import modmenu.CheatBuffs;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.ObjectRegistry;
import necesse.entity.mobs.Attacker;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.pickup.ItemPickupEntity;
import necesse.entity.pickup.PickupEntity;
import net.bytebuddy.asm.Advice;

import java.util.HashSet;

@ModMethodPatch(
        target = PlayerMob.class,
        name = "onDeath",
        arguments = {Attacker.class, HashSet.class}
)
public class DeathPatch {
    @Advice.OnMethodExit
    static void onExit(@Advice.This Mob mob, @Advice.Argument(0) Attacker attacker, @Advice.Argument(1) HashSet<Attacker> attackers) {
        if (mob == null) return;
        if (!mob.isPlayer) return;
        int tileX = mob.getTileX();
        int tileY = mob.getTileY();
        ServerClient serverClient = ((PlayerMob) mob).getServerClient();
        CheatBuffs.instance.clientSideStash.resetAll();
        mob.getLevel().sendObjectUpdatePacket(tileX, tileY);
    }
}