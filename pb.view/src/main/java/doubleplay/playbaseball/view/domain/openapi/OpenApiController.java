package doubleplay.playbaseball.view.domain.openapi;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

@RestController
public class OpenApiController {

    @GetMapping("/openapi.yaml")
    public ResponseEntity<Resource> getOpenApiSpecification() {
        Resource resource = new ClassPathResource("openapi.yaml");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/x-yaml"))
                .body(resource);
    }
}
