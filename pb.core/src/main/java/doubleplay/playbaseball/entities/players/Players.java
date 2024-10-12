package doubleplay.playbaseball.entities.players;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Entity
@Comment("선수 정보")
@Table(name = "PLAYER")
@Data
@EqualsAndHashCode
public class Players {

    @Id
    @Comment("선수 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYER_ID", nullable = false, length = 15)
    private Long player_id;

    @Basic
    @Comment("게임 출장 횟수")
    @Column(name = "GAME_COUNT")
    private Long gameCount;

    @Basic
    @Comment("나이")
    @Column(name = "AGE")
    private Long age;

    @Basic
    @Comment("타석")
    @Column(name = "PLATE_APPEARANCE")
    private Long plateAppearance;

    @Basic
    @Comment("타수")
    @Column(name = "AT_BAT")
    private Long atBat;

    @Basic
    @Comment("득점")
    @Column(name = "RUNS")
    private Long runs;

    @Basic
    @Comment("안타")
    @Column(name = "HITS")
    private Long hits;

    @Basic
    @Comment("2루타")
    @Column(name = "DOUBLE")
    private Long double_hits;

    @Basic
    @Comment("3루타")
    @Column(name = "TRIPLE")
    private Long triple_hits;

    @Basic
    @Comment("홈런")
    @Column(name = "HOME_RUN")
    private Long homeRun;
    @Basic
    @Comment("루타")
    @Column(name = "TOTAL_BASE")
    private Long totalBase;
    @Basic
    @Comment("득점")
    @Column(name = "RUN_BASE_IN")
    private Long runBaseIn;
    @Basic
    @Comment("도루 성공")
    @Column(name = "STOLEN_BASE")
    private Long stolenBase;
    @Basic
    @Comment("도루 실패")
    @Column(name = "CAUGHT_STEALING")
    private Long caughtStealing;
    @Basic
    @Comment("4구")
    @Column(name = "BASED_ON_BALLS")
    private Long basedOnBalls;
    @Basic
    @Comment("사구")
    @Column(name = "HIT_BY_PITCH")
    private Long hitByPitch;
    @Basic
    @Comment("고의 4구")
    @Column(name = "INTENTIONAL_BASED_ON_BALLS")
    private Long intentionalBasedOnBalls;
    @Basic
    @Comment("삼진")
    @Column(name = "STRIKE_OUT")
    private Long strikeOut;
    @Basic
    @Comment("병살타")
    @Column(name = "DOUBLE_PLAY")
    private Long doublePlay;
    @Basic
    @Comment("타율")
    @Column(name = "AVG")
    private double avg;
    @Basic
    @Comment("출루율")
    @Column(name = "OBP")
    private double obp;
    @Basic
    @Comment("장타율")
    @Column(name = "SLG")
    private double slg;
    @Basic
    @Comment("OPS")
    @Column(name = "OPS")
    private double ops;
    @Basic
    @Comment("WRC+")
    @Column(name = "WRC")
    private double wrc;
    @Basic
    @Comment("WAR")
    @Column(name = "WAR")
    private double war;
}
