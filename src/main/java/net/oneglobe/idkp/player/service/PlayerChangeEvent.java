package net.oneglobe.idkp.player.service;

import org.springframework.context.ApplicationEvent;

public class PlayerChangeEvent extends ApplicationEvent {

    private final PlayerChangeDto change;

    public PlayerChangeEvent(Object source, PlayerChangeDto change) {
        super(source);
        this.change = change;
    }

    public PlayerChangeDto getChange() {
        return (change);
    }

}
