package net.oneglobe.idkp.player.service;

import java.io.Serializable;

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
        final PlayerDto other = (PlayerDto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
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
}
