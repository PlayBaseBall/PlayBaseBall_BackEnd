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
}
