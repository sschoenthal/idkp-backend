package net.oneglobe.idkp.player.client;

import net.oneglobe.idkp.common.type.ChangeType;
import net.oneglobe.idkp.player.service.PlayerDto;

public class PlayerChangeDto {

    private final PlayerDto player;
    private final ChangeType changeType;

    public PlayerChangeDto(PlayerDto player, ChangeType changeType) {
        this.player = player;
        this.changeType = changeType;
    }

    public PlayerDto getPlayer() {
        return (player);
    }

    public ChangeType getChangeType() {
        return (changeType);
    }
}
