package modmenu.client.listener;

import modmenu.CheatBuffs;
import necesse.engine.GameEventListener;
import necesse.engine.events.ServerClientConnectedEvent;

public class ServerClientConnectListener extends GameEventListener<ServerClientConnectedEvent> {

    @Override
    public void onEvent(final ServerClientConnectedEvent event) {
        CheatBuffs.instance.playerDataManger.create(event.client.playerMob);
    }

}
