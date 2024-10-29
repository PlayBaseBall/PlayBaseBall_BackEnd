package doubleplay.playbaseball.view.domain.player.model;

import doubleplay.playbaseball.entities.players.Players;
import org.modelmapper.ModelMapper;
import lombok.Data;

public class PlayerDTO {

    @Data
    public static class ONE {

        private Long player_id;
        private Integer gameCount;
        private Integer age;
        private Integer plateAppearance;
        private Integer atBat;
        private Integer runs;
        private Integer hits;
        private Integer double_hits;
        private Integer triple_hits;
        private Integer homeRun;
        private Integer totalBase;
        private Integer runBaseIn;
        private Integer stolenBase;
        private Integer caughtStealing;
        private Integer basedOnBalls;
        private Integer hitByPitch;
        private Integer intentionalBasedOnBalls;
        private Integer strikeOut;
        private Integer doublePlay;
        private double avg;
        private double obp;
        private double slg;
        private double ops;
        private double wrc;
        private double war;

        public static ONE of(Players playerEntity) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(playerEntity, ONE.class);
        }

        public static Players saveOf(ONE dto) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(dto, Players.class);
        }
    }
}
