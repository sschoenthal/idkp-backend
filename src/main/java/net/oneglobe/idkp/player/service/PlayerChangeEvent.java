package net.oneglobe.idkp.player.service;

import net.oneglobe.idkp.common.type.ChangeType;
import org.springframework.context.ApplicationEvent;

public class PlayerChangeEvent extends ApplicationEvent {

    private final PlayerDto player;
    private final ChangeType changeType;

    public PlayerChangeEvent(Object source, PlayerDto player, ChangeType changeType) {
        super(source);
        this.player = player;
        this.changeType = changeType;
    }

    public ChangeType getChangeType() {
        return (changeType);
    }

    public PlayerDto getPlayer() {
        return (player);
    }

}
