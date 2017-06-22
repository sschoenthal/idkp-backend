package net.oneglobe.idkp.player.client;

import net.oneglobe.idkp.common.notify.client.ChangeDto;
import net.oneglobe.idkp.common.notify.client.ChangeEvent;
import net.oneglobe.idkp.player.service.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerWebSocket {

    @Autowired
    private SimpMessagingTemplate template;

    @EventListener
    public void handlePlayerChanged(ChangeEvent<PlayerDto> playerChangeEvent) {
        template.convertAndSend("/idkp/topic/players", new ChangeDto(playerChangeEvent.getNotifyable(), playerChangeEvent.getType()));
    }
}
