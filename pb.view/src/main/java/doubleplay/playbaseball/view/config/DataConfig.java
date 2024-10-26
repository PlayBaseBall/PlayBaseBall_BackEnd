package doubleplay.playbaseball.view.config;

import doubleplay.playbaseball.constants.GlobalConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {GlobalConstants.ENTITY_PACKAGE})
@EnableJpaRepositories(basePackages = {"doubleplay.playbaseball"})
@RequiredArgsConstructor
public class DataConfig {
//    private final EntityManager entityManager;


//    @Bean
//    public JPAQueryFactory jpaQueryFactory() {
//        return new JPAQueryFactory(entityManager);
//    }
}
