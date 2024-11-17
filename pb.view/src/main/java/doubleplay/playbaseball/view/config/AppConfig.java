package doubleplay.playbaseball.view.config;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
public class AppConfig {

    //클라이언트의 요청이 역방향 프록시나 로드 밸런서를 통해 전달될 때, 올바른 클라이언트 정보를 처리하도록 도와주는 역할
    @Bean
    public FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {
        return new FilterRegistrationBean<>(new ForwardedHeaderFilter());
    }
}
