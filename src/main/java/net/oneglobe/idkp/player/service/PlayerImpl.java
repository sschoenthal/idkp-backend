package net.oneglobe.idkp.player.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import net.oneglobe.idkp.player.repo.PlayerEntity;

public class PlayerImpl implements Player {

    private final long id;
    private String name;
    private final int debuff;

    public PlayerImpl() {
        this.id = -1;
        this.debuff = -1;
    }

    public PlayerImpl(long id, String name, int debuff) {
        this.id = id;
        this.name = name;
        this.debuff = debuff;
    }

    @Override
    public String toString() {
        return "EntityInfo{" + "id=" + id + ", name=" + name + ", debuff=" + debuff + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerImpl other = (PlayerImpl) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public long getId() {
        return (id);
    }

    @Override
    public String getName() {
        return (name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getDebuff() {
        return (debuff);
    }

    public static PlayerImpl fromPlayerEntity(PlayerEntity playerEntity) {
        return (new PlayerImpl(playerEntity.getId(), playerEntity.getName(), 0));
    }

    public static List<PlayerImpl> fromPlayerEntities(Iterable<PlayerEntity> playerEntities) {
        return (StreamSupport.stream(playerEntities.spliterator(), false)
                .map(playerEntity -> PlayerImpl.fromPlayerEntity(playerEntity))
                .collect(Collectors.toList()));
    }
}
