package net.oneglobe.idkp.player.service;

/**
 * A player identifies a single individual within the iKDP system.
 *
 * @author Stefan Schönthal
 */
public interface Player {

    /**
     * Type of player change
     */
    enum Change {

        /**
         * The player was created
         */
        CREATED,
        /**
         * The player was updated
         */
        UPDATED,
        /**
         * The player was deleted
         */
        DELETED
    }

    /**
     * Returns the unique identifier for this player.
     *
     * @return
     */
    long getId();

    /**
     * Returns the name for this player or null if no name is specified.
     *
     * @return
     */
    String getName();

    /**
     * Returns the current debuff for this player. The debuff is calculated
     * based on the player's event attendance & loot yield which are within the
     * specified tracking window.
     *
     * @return
     */
    int getDebuff();
}
