package doubleplay.playbaseball.entities.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.Instant;

@Entity
@Data
@Comment("사용자 정보")
@Table(name = "USER")
public class User {

    @Id
    @Comment("사용자 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, length = 15)
    private Long id;

    @Comment("사용자 닉네임")
    @Column(name = "USER_NAME")
    private String username;

    @Comment("사용자 비밀번호")
    @Column(name = "PASSWORD")
    private String password;

    @Comment("사용자 이메일")
    @Column(name = "EMAIL")
    private String email;

    @Comment("권한")
    @Column(name = "ROLE")
    private ROLE role;

    @Comment("가입 경로")
    @Column(name = "PROVIDER")
    private PROVIDER provider;

    @Comment("등록 일시")
    @Column(name = "CREATE_AT", length = 21)
    private Timestamp createAt;

    @Comment("수정 일시")
    @Column(name = "UPDATE_AT", length = 21)
    private Timestamp updateAt;

    @PrePersist
    protected void onPersist() {
        this.createAt = this.updateAt = Timestamp.from(Instant.now(Clock.systemUTC()));
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = Timestamp.from(Instant.now(Clock.systemUTC()));
    }
}
