package net.oneglobe.idkp.player.service;

import java.util.List;
import net.oneglobe.idkp.player.client.PlayerWebSocket;
import net.oneglobe.idkp.player.repo.PlayerEntity;
import net.oneglobe.idkp.player.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerWebSocket playerWebSocketController;

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<? extends Player> findAll() {
        return (PlayerImpl.fromPlayerEntities(playerRepository.findAll()));
    }

    @Override
    public Player findById(long id) {
        return (PlayerImpl.fromPlayerEntity(playerRepository.findOne(id)));
    }

    @Override
    public void delete(long id) {
        PlayerImpl player = PlayerImpl.fromPlayerEntity(playerRepository.findOne(id));
        if (player != null) {
            playerRepository.delete(id);
            firePlayerChanged(player, Player.Change.DELETED);
        }
    }

    @Override
    public Player create(String name) {
        return (firePlayerChanged(PlayerImpl.fromPlayerEntity(playerRepository.save(new PlayerEntity(name))), Player.Change.CREATED));
    }

    @Override
    public Player update(long id, String name) {
        PlayerEntity playerEntity = playerRepository.findOne(id);
        if (playerEntity != null) {
            playerEntity.setName(name);
            return(firePlayerChanged(PlayerImpl.fromPlayerEntity(playerRepository.save(playerEntity)), Player.Change.UPDATED));
        }
        return (null);
    }

    private Player firePlayerChanged(PlayerImpl player, Player.Change change) {
        playerWebSocketController.firePlayerChanged(player, change);
        return(player);
    }
}
