package net.oneglobe.idkp.player.client;

import net.oneglobe.idkp.player.service.PlayerChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerWebSocket {

    @Autowired
    private SimpMessagingTemplate template;

    @EventListener
    public void handlePlayerChanged(PlayerChangeEvent playerChangeEvent) {
        template.convertAndSend("/idkp/topic/players", new PlayerChangeDto(playerChangeEvent.getPlayer(), playerChangeEvent.getChangeType()));
    }
}
