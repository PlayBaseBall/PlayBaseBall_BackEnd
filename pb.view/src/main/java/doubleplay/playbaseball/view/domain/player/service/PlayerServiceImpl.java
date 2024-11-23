package doubleplay.playbaseball.view.domain.player.service;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.api.ApiResultCode;
import doubleplay.playbaseball.code.SystemCode;
import doubleplay.playbaseball.entities.players.Players;
import doubleplay.playbaseball.exceptions.CommonException;
import doubleplay.playbaseball.view.domain.player.model.PlayerDTO;
import doubleplay.playbaseball.view.domain.player.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ApiResult<PlayerDTO.ONE> one(Long id) {

        if (id == null || id==0){
            throw new CommonException(SystemCode.COMMON_MESSAGE.ERROR_NULL_REFERENCE.getCode());
        }

        PlayerDTO.ONE one =  playerRepository.findById(id).map(PlayerDTO.ONE::of).orElseThrow(() -> new CommonException(SystemCode.COMMON_MESSAGE.ERROR_NULL_REFERENCE));

        return ApiResult.<PlayerDTO.ONE>builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.MSG_SUCCESS.getLabel())
                .data(one)
                .build();
    }

    @Override
    @Transactional
    public ApiResult<PlayerDTO.ONE> save(PlayerDTO.ONE dto) {
        // 존재하면 업데이트, 아니면 새로운 엔티티 생성 및 저장
        Players playersEntity = playerRepository.findById(dto.getPlayer_id())
                .map(entity -> {
                    modelMapper.map(dto, entity);
                    return entity;
                })
                .orElseGet(() -> PlayerDTO.ONE.saveOf(dto));

        playerRepository.save(playersEntity);

        return ApiResult.<PlayerDTO.ONE>builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.MSG_SUCCESS.getLabel())
                .data(dto)
                .build();
    }

    @Override
    @Transactional
    public ApiResult<PlayerDTO.ONE> deleteOne(Long id) {
        playerRepository.deleteById(id);
        return ApiResult.<PlayerDTO.ONE>builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.MSG_SUCCESS.getLabel())
                .build();
    }

}
