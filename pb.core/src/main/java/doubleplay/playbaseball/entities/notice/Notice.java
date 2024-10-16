package doubleplay.playbaseball.entities.notice;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Entity
@Comment("공지사항")
@Table(name = "NOTICE")
@Data
@EqualsAndHashCode
public class Notice {

    @Id
    @Comment("공지사항 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_ID", nullable = false, length = 15)
    private Long notice_id;

    @Basic
    @Comment("제목")
    @Column(name = "SUBJECT")
    private String subject;

    @Basic
    @Comment("내용")
    @Column(name = "CONTENT")
    private String content;
}

