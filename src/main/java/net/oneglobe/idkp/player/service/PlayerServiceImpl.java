package net.oneglobe.idkp.player.service;

import net.oneglobe.idkp.common.types.ChangeType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import net.oneglobe.idkp.common.annotations.Notifyable;
import net.oneglobe.idkp.player.repo.PlayerEntity;
import net.oneglobe.idkp.player.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

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
    @Notifyable(changeType = ChangeType.REMOVED)
    public PlayerDto delete(long id) {
        PlayerDto player = createFromEntity(playerRepository.findOne(id));
        if (player != null) {
            playerRepository.delete(id);
        }
        return (player);
    }

    @Override
    @Notifyable(changeType = ChangeType.CREATED)
    public PlayerDto create(String name) {
        return (createFromEntity(playerRepository.save(new PlayerEntity(name))));
    }

    @Override
    @Notifyable(changeType = ChangeType.UPDATED)
    public PlayerDto update(long id, String name) {
        PlayerEntity playerEntity = playerRepository.findOne(id);
        if (playerEntity != null) {
            playerEntity.setName(name);
            return (createFromEntity(playerRepository.save(playerEntity)));
        }
        return (null);
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
