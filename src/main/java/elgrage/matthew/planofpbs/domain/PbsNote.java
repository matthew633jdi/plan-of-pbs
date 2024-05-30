package elgrage.matthew.planofpbs.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@Table(name = "note")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PbsNote extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "christian_id")
    private Christian christian;

    @Column(nullable = false)
    private String part;

    private String keyword;

    @Lob
    @Column(nullable = false)
    private String content;

    private String goal;

    @Column(name = "share", nullable = false)
    private boolean isShared;

    @Builder
    public PbsNote(Christian christian, String part, String keyword, String content, String goal, boolean isShared) {
        this.christian = christian;
        this.part = part;
        this.keyword = keyword;
        this.content = content;
        this.goal = goal;
        this.isShared = isShared;
    }
}
