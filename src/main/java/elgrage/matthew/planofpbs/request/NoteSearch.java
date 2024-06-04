package elgrage.matthew.planofpbs.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class NoteSearch {

    private Long userId;
    private String keyword;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    private String passage;
    private Boolean isShared;

    @Builder
    public NoteSearch(Long userId, String keyword, LocalDateTime createdTime, LocalDateTime modifiedTime, String passage, Boolean isShared) {
        this.userId = userId;
        this.keyword = keyword;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.passage = passage;
        this.isShared = isShared;
    }
}
