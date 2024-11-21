package doubleplay.playbaseball.view.domain.user.model;

import doubleplay.playbaseball.entities.user.PROVIDER;
import lombok.Data;

public class UserDTO {

    @Data
    public static class JOIN {
        private String username;
        private String email;
        private String password;
        private PROVIDER provider;

    }
}
