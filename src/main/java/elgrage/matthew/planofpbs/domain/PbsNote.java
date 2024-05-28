package elgrage.matthew.planofpbs.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "note")
@NoArgsConstructor @Getter
public class PbsNote extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;

    private String part;

    private String keyword;

    private String content;

    private String goal;

    @Column(name = "share")
    private boolean isShared;

    @Builder
    public PbsNote(String part, String keyword, String content, String goal, boolean isShared) {
        this.part = part;
        this.keyword = keyword;
        this.content = content;
        this.goal = goal;
        this.isShared = isShared;
    }
}
