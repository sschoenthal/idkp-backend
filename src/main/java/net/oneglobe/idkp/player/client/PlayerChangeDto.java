package net.oneglobe.idkp.player.client;

import net.oneglobe.idkp.player.service.Player;

public class PlayerChangeDto {

    private final PlayerDto player;
    private final Player.Change change;

    public PlayerChangeDto(PlayerDto player, Player.Change change) {
        this.player = player;
        this.change = change;
    }

    public PlayerDto getPlayer() {
        return (player);
    }

    public Player.Change getChange() {
        return (change);
    }
}
