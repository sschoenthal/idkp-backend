package net.oneglobe.idkp.player.client;

import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
        return (getResponseEntity(playerService.findById(id)));
    }

    @RequestMapping(value = "/{name}", method = PUT)
    public ResponseEntity<PlayerDto> put(@PathVariable String name, @RequestBody(required = false) Object input) {
        return (getResponseEntity(playerService.create(name)));
    }

    @RequestMapping(value = "/{id}/{name}", method = POST)
    public ResponseEntity<PlayerDto> post(@PathVariable long id, @PathVariable String name, @RequestBody(required = false) Object input) {
        return (getResponseEntity(playerService.update(id, name)));
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<PlayerDto> delete(@PathVariable long id) {
        return (getResponseEntity(playerService.delete(id)));
    }

    private ResponseEntity<PlayerDto> getResponseEntity(PlayerDto playerDto) {
        return (new ResponseEntity<>(playerDto, playerDto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    /**
     * Helper method to create a huge amount of players.
     */
    @RequestMapping(value = "/createData", method = RequestMethod.GET)
    public void createData() {
        long start = System.currentTimeMillis() / 1000;
        for (long i = start; i <= (start + 1000); i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayerRest.class.getName()).log(Level.SEVERE, null, ex);
            }
            playerService.create("a" + i);
        }
    }

}
