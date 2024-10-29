package doubleplay.playbaseball.view.domain.player.controller;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.view.constants.Constants;
import doubleplay.playbaseball.view.domain.player.model.PlayerDTO;
import doubleplay.playbaseball.view.domain.player.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/"+ Constants.URI.player)
public class PlayerRestController {
    @Autowired
    PlayerService playerService;
    @PostMapping("/player")
    public ApiResult<PlayerDTO.ONE> findById(@RequestBody Long id) {
        return playerService.one(id);
    }

    @PostMapping("/savePlayer")
    public ApiResult<PlayerDTO.ONE> save(@RequestBody PlayerDTO.ONE one) {
        return playerService.save(one);
    }

}
