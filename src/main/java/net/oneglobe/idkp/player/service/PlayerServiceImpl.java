package net.oneglobe.idkp.player.service;

import net.oneglobe.idkp.common.client.notify.Notifyable;
import net.oneglobe.idkp.player.repository.PlayerEntity;
import net.oneglobe.idkp.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Page<PlayerDto> findAll(Pageable pageable) {
        return (createFromEntities(playerRepository.findAll(pageable)));
    }

    @Override
    public PlayerDto findById(long id) {
        return (createFromEntity(playerRepository.findOne(id)));
    }

    @Override
    @Notifyable(changeType = Notifyable.ChangeType.REMOVED)
    public PlayerDto delete(long id) {
        PlayerDto player = createFromEntity(playerRepository.findOne(id));
        if (player != null) {
            playerRepository.delete(id);
        }
        return (player);
    }

    @Override
    @Notifyable(changeType = Notifyable.ChangeType.CREATED)
    public PlayerDto create(String name) {
        return (createFromEntity(playerRepository.save(new PlayerEntity(name))));
    }

    @Override
    @Notifyable(changeType = Notifyable.ChangeType.UPDATED)
    public PlayerDto update(long id, String name) {
        PlayerEntity playerEntity = playerRepository.findOne(id);
        if (playerEntity != null) {
            playerEntity.setName(name);
            return (createFromEntity(playerRepository.save(playerEntity)));
        }
        return (null);
    }

    private PlayerDto createFromEntity(PlayerEntity playerEntity) {
        return (new PlayerDto(playerEntity.getId(), playerEntity.getName(), 0));
    }

    private Page<PlayerDto> createFromEntities(Page<PlayerEntity> playerEntitiesPage) {
        return (playerEntitiesPage.map(this::createFromEntity));
    }
}
