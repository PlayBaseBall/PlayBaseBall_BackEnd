package doubleplay.playbaseball.view.domain.user.service;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.api.ApiResultCode;
import doubleplay.playbaseball.code.SystemCode;
import doubleplay.playbaseball.entities.user.User;
import doubleplay.playbaseball.view.domain.user.model.UserDTO;
import doubleplay.playbaseball.view.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public ApiResult<?> join(UserDTO.JOIN dto) {

        if (isUsernameTaken(dto.getUsername())) {
            throw new IllegalArgumentException("Username is already taken.");
        }
        if (isEmailTaken(dto.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return ApiResult.builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.SUCCESS.getLabel())
                .build();
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
