package net.oneglobe.idkp.player.service;

public class PlayerChangeDto {

    public enum Change {
        CREATED,
        UPDATED,
        DELETED
    }

    private final PlayerDto player;
    private final Change change;

    public PlayerChangeDto(PlayerDto player, Change change) {
        this.player = player;
        this.change = change;
    }

    public PlayerDto getPlayer() {
        return (player);
    }

    public Change getChange() {
        return (change);
    }
}
