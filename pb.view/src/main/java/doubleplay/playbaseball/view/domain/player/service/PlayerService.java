package doubleplay.playbaseball.view.domain.player.service;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.view.domain.player.model.PlayerDTO;

public interface PlayerService {

    ApiResult<PlayerDTO.ONE> one(Long id);
    ApiResult<PlayerDTO.ONE> save(PlayerDTO.ONE dto);
}
