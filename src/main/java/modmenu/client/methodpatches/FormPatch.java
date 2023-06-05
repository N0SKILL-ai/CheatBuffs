package modmenu.client.methodpatches;

import modmenu.client.menu.CheatBuffsButton;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.network.client.Client;
import necesse.engine.commands.PermissionLevel;
import necesse.gfx.forms.MainGameFormManager;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = MainGameFormManager.class, name = "setup", arguments = {})
public class FormPatch {

    @Advice.OnMethodExit
    public static void onExit(@Advice.This final MainGameFormManager formManager, @Advice.FieldValue("client") final Client client) {
        if(client.getPermissionLevel() == PermissionLevel.ADMIN || client.getPermissionLevel() == PermissionLevel.OWNER) {
            formManager.rightQuickbar.addButton(new CheatBuffsButton(formManager, client));
            formManager.rightQuickbar.updateButtons();
        }
    }

}
 