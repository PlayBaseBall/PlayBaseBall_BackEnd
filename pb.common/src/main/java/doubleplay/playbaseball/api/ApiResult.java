package doubleplay.playbaseball.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResult {
    private String message;
    private Optional<?> data;
    private ApiResultCode result;
}

