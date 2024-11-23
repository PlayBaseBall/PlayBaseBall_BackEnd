package doubleplay.playbaseball.view.domain.user.service;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.view.domain.user.model.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    ApiResult<?> join(UserDTO.JOIN dto);

    ApiResult<UserDTO.ONE> update(UserDTO.ONE dto);
    ApiResult<Long> delete(Long id);
}
