package net.oneglobe.idkp.player.service;

import java.util.List;

/**
 * Provides methods to access and manage players within the system.
 *
 * @author Stefan Schönthal
 */
public interface PlayerService {

    /**
     * Returns a list containing all players available in the system.
     *
     * @return
     */
    List<PlayerDto> findAll();

    /**
     * Returns a specific player or null if no such player exists.
     *
     * @param id
     * @return
     */
    PlayerDto findById(long id);

    /**
     * Deletes a specific player.
     *
     * @param id
     */
    void delete(long id);

    /**
     * Creates a new player and returns the created player.
     *
     * @param name
     * @return
     */
    PlayerDto create(String name);

    /**
     * Updates a specific player and returns the updated player or null in case
     * the player doesn't exist.
     *
     * @param id
     * @param name
     * @return
     */
    PlayerDto update(long id, String name);
}
