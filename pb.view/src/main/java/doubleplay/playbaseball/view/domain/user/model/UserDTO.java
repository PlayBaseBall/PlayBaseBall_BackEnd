package doubleplay.playbaseball.view.domain.user.model;

import doubleplay.playbaseball.entities.user.PROVIDER;
import doubleplay.playbaseball.entities.user.ROLE;
import doubleplay.playbaseball.entities.user.User;
import lombok.Data;
import org.modelmapper.ModelMapper;

public class UserDTO {

    @Data
    public static class JOIN {
        private String username;
        private String email;
        private String password;
        private PROVIDER provider;

    }

    @Data
    public static class ONE {
        private Long id;
        private String username;
        private String email;
        private String password;
        private ROLE role;
        private PROVIDER provider;

        public static UserDTO.ONE of(User user) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(user, UserDTO.ONE.class);
        }
    }
}
