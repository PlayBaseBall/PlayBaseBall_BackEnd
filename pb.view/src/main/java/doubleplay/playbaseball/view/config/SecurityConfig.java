package doubleplay.playbaseball.view.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        //Spring Security 5.7.0-M2부터 ebSecurityConfigureAdapter 사용 X
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            // CSRF 비활성화
            http.csrf(csrf -> csrf
                    .ignoringRequestMatchers("/api/**") // Disable CSRF for /api/** endpoints only
            );

            // 요청 URL에 대한 접근 권한 설정
            http.authorizeRequests()
                    .antMatchers("/user/**").authenticated() // "/user/**"는 인증된 사용자만 접근 가능
                    .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") // "/manager/**"는 ROLE_ADMIN 또는 ROLE_MANAGER 권한을 가진 사용자만 접근 가능
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") // "/admin/**"는 ROLE_ADMIN 권한을 가진 사용자만 접근 가능
                    .anyRequest().permitAll() // 나머지 모든 요청은 허용
                    .and()
                    .formLogin()
                    .loginPage("/login"); // 로그인 페이지 설정

            return http.build(); // 설정을 빌드하여 반환
        }

}
