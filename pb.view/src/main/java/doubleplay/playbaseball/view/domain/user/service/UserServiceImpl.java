package doubleplay.playbaseball.view.domain.user.service;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.api.ApiResultCode;
import doubleplay.playbaseball.code.SystemCode;
import doubleplay.playbaseball.entities.user.User;
import doubleplay.playbaseball.exceptions.CommonException;
import doubleplay.playbaseball.view.domain.user.model.UserDTO;
import doubleplay.playbaseball.view.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public ApiResult<?> join(UserDTO.JOIN dto) {
        validateJoinRequest(dto);

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return ApiResult.builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.MSG_SUCCESS.getLabel())
                .build();
    }
    /**
     * 회원가입 요청 데이터 유효성 검증
     */
    private void validateJoinRequest(UserDTO.JOIN dto) {
        if (dto.getUsername() == null || dto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("아이디를 쓰세요.");
        }
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("이메일을 쓰세요.");
        }
        if (dto.getPassword() == null || dto.getPassword().length() < 6) {
            throw new IllegalArgumentException("비밀번호는 적어도 6자 이상이어야 합니다.");
        }
        if (isUsernameTaken(dto.getUsername())) {
            throw new IllegalArgumentException("이미 등록된 아이디입니다.");
        }
        if (isEmailTaken(dto.getEmail())) {
            throw new IllegalArgumentException("이미 등록된 이메일입니다.");
        }
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


    @Override
    @Transactional
    public ApiResult<UserDTO.ONE> update(UserDTO.ONE dto) {
        Optional.ofNullable(dto.getId()).orElseThrow(() -> new CommonException(SystemCode.COMMON_MESSAGE.ERROR_MISSING_REQUIRED_DATA));
        User userEntity = userRepository.findById(dto.getId()).orElseThrow(() -> new CommonException(SystemCode.COMMON_MESSAGE.ERROR_NULL_REFERENCE));

        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity.setRole(dto.getRole());

        UserDTO.ONE one = UserDTO.ONE.of(userEntity);
        return ApiResult.<UserDTO.ONE>builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.MSG_SUCCESS.getLabel())
                .data(one)
                .build();
    }

    @Override
    public ApiResult<Long> delete(Long id) {
        Optional.ofNullable(id).orElseThrow(() -> new CommonException(SystemCode.COMMON_MESSAGE.ERROR_MISSING_REQUIRED_DATA));
        userRepository.deleteById(id);
        return ApiResult.<Long>builder()
                .result(ApiResultCode.SUCCESS)
                .message(SystemCode.COMMON_MESSAGE.MSG_SUCCESS.getLabel())
                .data(id)
                .build();
    }
}
