package net.oneglobe.idkp.player.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
    public List<PlayerDto> findAll() {
        return (createFromEntities(playerRepository.findAll()));
    }

    @Override
    public PlayerDto findById(long id) {
        return (createFromEntity(playerRepository.findOne(id)));
    }

    @Override
    public void delete(long id) {
        PlayerDto player = createFromEntity(playerRepository.findOne(id));
        if (player != null) {
            playerRepository.delete(id);
            firePlayerChanged(player, PlayerChangeDto.Change.DELETED);
        }
    }

    @Override
    public PlayerDto create(String name) {
        return (firePlayerChanged(createFromEntity(playerRepository.save(new PlayerEntity(name))), PlayerChangeDto.Change.CREATED));
    }

    @Override
    public PlayerDto update(long id, String name) {
        PlayerEntity playerEntity = playerRepository.findOne(id);
        if (playerEntity != null) {
            playerEntity.setName(name);
            return (firePlayerChanged(createFromEntity(playerRepository.save(playerEntity)), PlayerChangeDto.Change.UPDATED));
        }
        return (null);
    }

    private PlayerDto firePlayerChanged(PlayerDto player, PlayerChangeDto.Change change) {
        playerWebSocketController.firePlayerChanged(new PlayerChangeDto(player, change));
        return (player);
    }

    private static PlayerDto createFromEntity(PlayerEntity playerEntity) {
        return (new PlayerDto(playerEntity.getId(), playerEntity.getName(), 0));
    }

    private static List<PlayerDto> createFromEntities(Iterable<PlayerEntity> playerEntities) {
        return (StreamSupport.stream(playerEntities.spliterator(), false)
                .map(playerEntity -> createFromEntity(playerEntity))
                .collect(Collectors.toList()));
    }
}
