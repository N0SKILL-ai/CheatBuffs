package modmenu.client.menu;

import necesse.engine.Settings;
import necesse.engine.localization.message.StaticMessage;
import necesse.engine.network.client.Client;
import necesse.gfx.forms.MainGameFormManager;
import necesse.gfx.forms.components.FormContentIconButton;
import necesse.gfx.forms.components.FormInputSize;
import necesse.gfx.ui.ButtonColor;

public class CheatBuffsButton extends FormContentIconButton {

    public CheatBuffsButton(final MainGameFormManager formManager, final Client client) {
        super(0, 0, FormInputSize.SIZE_32, ButtonColor.BASE, Settings.UI.priority_high, new StaticMessage("CheatBuffs"));

        final BuffMenu menu = new BuffMenu(formManager, client);
        this.onClicked(e -> {
            if (menu.shown) {
                menu.shown = false;
                formManager.removeComponent(menu);
            } else {
                menu.shown = true;
                formManager.addComponent(menu);
                menu.initMenu();
            }
        });
    }



}
 