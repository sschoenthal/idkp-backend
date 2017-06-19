package net.oneglobe.idkp.player.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Provides methods to access and manage players within the system.
 *
 * @author Stefan Schönthal
 */
public interface PlayerService {

    /**
     * Returns a page containing a list of players according to the pageable
     * parameter.
     *
     * @param pageable
     * @return
     */
    Page<PlayerDto> findAll(Pageable pageable);

    /**
     * Returns a specific player or null if no such player exists.
     *
     * @param id
     * @return
     */
    PlayerDto findById(long id);

    /**
     * Deletes a specific player and returns the deleted player or null in case
     * the player didn't exist.
     *
     * @param id
     * @return
     */
    PlayerDto delete(long id);

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
