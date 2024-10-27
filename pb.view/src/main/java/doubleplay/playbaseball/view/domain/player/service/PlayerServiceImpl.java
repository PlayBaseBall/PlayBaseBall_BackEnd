package doubleplay.playbaseball.view.domain.player.service;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.api.ApiResultCode;
import doubleplay.playbaseball.code.SystemCode;
import doubleplay.playbaseball.exceptions.CommonException;
import doubleplay.playbaseball.view.domain.player.model.PlayerDTO;
import doubleplay.playbaseball.view.domain.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;


    @Override
    public ApiResult<PlayerDTO.ONE> one(Long id) {

        if (id == null || id==0){
            throw new CommonException(SystemCode.COMMON_MESSAGE.NULL.getCode());
        }

        PlayerDTO.ONE one =  playerRepository.findById(id).map(PlayerDTO.ONE::of).orElseThrow(() -> new CommonException(SystemCode.COMMON_MESSAGE.NULL));

        return ApiResult.<PlayerDTO.ONE>builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.SUCCESS.getLabel())
                .data(one)
                .build();
    }
}
