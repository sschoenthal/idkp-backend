package net.oneglobe.idkp.player.client;

import net.oneglobe.idkp.player.service.PlayerDto;
import net.oneglobe.idkp.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/player")
public class PlayerRest {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = GET)
    public Page<PlayerDto> list(Pageable pageable) {
        return (playerService.findAll(pageable));
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<PlayerDto> get(@PathVariable long id) {
        PlayerDto playerDTO = playerService.findById(id);
        return (new ResponseEntity<>(playerDTO, playerDTO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/{name}", method = PUT)
    public ResponseEntity<PlayerDto> put(@PathVariable String name, @RequestBody(required = false) Object input) {
        return (new ResponseEntity<>(playerService.create(name), HttpStatus.OK));
    }

    @RequestMapping(value = "/{id}/{name}", method = POST)
    public ResponseEntity<PlayerDto> post(@PathVariable long id, @PathVariable String name, @RequestBody(required = false) Object input) {
        return (new ResponseEntity<>(playerService.update(id, name), HttpStatus.OK));
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable long id) {
        playerService.delete(id);
        return (new ResponseEntity<>(null, HttpStatus.OK));
    }

}
