package doubleplay.playbaseball.view.domain.user;

import doubleplay.playbaseball.api.ApiResult;
import doubleplay.playbaseball.entities.user.PROVIDER;
import doubleplay.playbaseball.entities.user.User;
import doubleplay.playbaseball.view.domain.user.model.UserDTO;
import doubleplay.playbaseball.view.domain.user.repository.UserRepository;
import doubleplay.playbaseball.view.domain.user.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@DisplayName("사용자 서비스 테스트")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    //userService 객체를 생성하고, 테스트 대상 클래스에 Mock 객체(userRepository)를 자동으로 주입.
    @InjectMocks
    private UserServiceImpl userService;

    //UserRepository를 Mock 객체로 생성. 테스트 중 가짜 데이터 반환.
    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @DisplayName("유저 저장 테스트")
    @Test
    public void givenUserInfo_whenAddUser_thenOK(){
        UserDTO.JOIN dto = new UserDTO.JOIN();
        dto.setUsername("홍길동");
        dto.setEmail("gildong@hahah.com");
        dto.setPassword("123");
        dto.setProvider(PROVIDER.NAVER);

        User user = new User();
        user.setId(1L);
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setProvider(dto.getProvider());

        //when().thenReturn(): userRepository.save() 호출 시, Mock 객체로부터 미리 준비된 User 객체를 반환하도록 설정.
        //any(User.class): 메서드 호출 시 어떤 User 객체가 전달되더라도 Mock 객체에서 정의한 동작 수행.
        when(userRepository.save(any(User.class))).thenReturn(user);
        userService.join(dto);

        when(userRepository.findByUsername(dto.getUsername())).thenReturn(Optional.of(user));
        User userEntity = userRepository.findByUsername(dto.getUsername()).get();

        assertThat(userEntity).isNotNull();
        assertThat(userEntity.getId()).isEqualTo(1L);
        assertThat(userEntity.getUsername()).isEqualTo("홍길동");
        assertThat(userEntity.getEmail()).isEqualTo("gildong@hahah.com");
        assertThat(userEntity.getProvider()).isEqualTo(PROVIDER.NAVER);

        // userRepository.save() 메서드가 정확히 1번 호출되었는지 확인.
        verify(userRepository, times(2)).save(any(User.class));
    }
}
