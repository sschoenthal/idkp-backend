package net.oneglobe.idkp.player.client;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import net.oneglobe.idkp.player.service.Player;

public class PlayerDto implements Serializable {

    private final long id;
    private String name;
    private final int debuff;

    public PlayerDto() {
        this.id = -1;
        this.debuff = -1;
    }

    public PlayerDto(long id, String name, int debuff) {
        this.id = id;
        this.name = name;
        this.debuff = debuff;
    }

    public long getId() {
        return (id);
    }

    public String getName() {
        return (name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDebuff() {
        return (debuff);
    }

    public static PlayerDto fromPlayer(Player player) {
        if(player == null){
            return(null);
        }
        return (new PlayerDto(player.getId(), player.getName(), player.getDebuff()));
    }

    public static List<PlayerDto> fromPlayers(List<? extends Player> players) {
        return (players.stream()
                .map(player -> PlayerDto.fromPlayer(player))
                .collect(Collectors.toList()));
    }
}
