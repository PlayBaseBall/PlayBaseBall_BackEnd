package doubleplay.playbaseball.view.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "PlayBaseBall API Documentation",
                version = "1.0.0",
                description = "API documentation for the PlayBaseBall application",
                contact = @Contact(
                        name = "Support",
                        email = "support@doubleplay.com",
                        url = "https://doubleplay.com"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local server"),
                @Server(url = "https://api.doubleplay.com", description = "Production server")
        }
)
public class OpenApiConfig {
}
