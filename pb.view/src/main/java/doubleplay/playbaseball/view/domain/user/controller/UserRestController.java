package doubleplay.playbaseball.view.domain.user.controller;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.view.constants.Constants;
import doubleplay.playbaseball.view.domain.user.model.UserDTO;
import doubleplay.playbaseball.view.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/"+ Constants.URI.user)
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping("/join")
    public ApiResult<?> join(@RequestBody UserDTO.JOIN dto) {
        return userService.join(dto);
    }

    @PostMapping("/update")
    public ApiResult<UserDTO.ONE> update(@RequestBody UserDTO.ONE dto) {
        return userService.update(dto);
    }
    @PostMapping("/delete")
    public ApiResult<Long> delete(@RequestBody Long id) {
        return userService.delete(id);
    }
}
