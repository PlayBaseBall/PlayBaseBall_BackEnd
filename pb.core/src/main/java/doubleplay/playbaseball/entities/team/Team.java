package doubleplay.playbaseball.entities.team;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Entity
@Comment("팀 정보")
@Table(name = "TEAM")
@Data
@EqualsAndHashCode
public class Team {

    @Id
    @Comment("팀 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID", nullable = false, length = 15)
    private Long team_id;

    @Basic
    @Comment("경기")
    @Column(name = "GAME")
    private Integer game;

    @Basic
    @Comment("승")
    @Column(name = "WIN")
    private Integer win;

    @Basic
    @Comment("경기")
    @Column(name = "LOSS")
    private Integer loss;

    @Basic
    @Comment("무승부")
    @Column(name = "DRAW")
    private Integer draw;
}
