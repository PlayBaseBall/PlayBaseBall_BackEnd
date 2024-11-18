package doubleplay.playbaseball.view.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }
    //Spring Security 5.7.0-M2부터 ebSecurityConfigureAdapter 사용 X
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .httpBasic(HttpBasicConfigurer::disable)    // HTTP Basic 인증 비활성화
                .csrf(CsrfConfigurer::disable)              // CSRF 보호 비활성화
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().permitAll()  // 모든 요청에 대해 접근 허용
                )
                .headers(HeadersConfigurer::disable)
        ;
    //        // 요청 URL에 대한 접근 권한 설정
    //        http.authorizeRequests()
    //                .antMatchers("/user/**").authenticated() // "/user/**"는 인증된 사용자만 접근 가능
    //                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") // "/manager/**"는 ROLE_ADMIN 또는 ROLE_MANAGER 권한을 가진 사용자만 접근 가능
    //                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") // "/admin/**"는 ROLE_ADMIN 권한을 가진 사용자만 접근 가능
    //                .anyRequest().permitAll() // 나머지 모든 요청은 허용
    //                .and()
    //                .formLogin()
    //                .loginPage("/login"); // 로그인 페이지 설정

        return http.build(); // 설정을 빌드하여 반환
    }

}
