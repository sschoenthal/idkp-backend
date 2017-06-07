package net.oneglobe.idkp.player.client;

import net.oneglobe.idkp.player.service.PlayerChangeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerWebSocket {

    @Autowired
    private SimpMessagingTemplate template;
    
    public void firePlayerChanged(PlayerChangeDto playerChange){
        template.convertAndSend("/idkp/topic/players", playerChange);
    }
}
