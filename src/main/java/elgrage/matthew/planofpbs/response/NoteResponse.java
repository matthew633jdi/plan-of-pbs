package elgrage.matthew.planofpbs.response;

import elgrage.matthew.planofpbs.domain.PbsNote;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoteResponse {
    private final Long id;
    private final String username;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final String passage;
    private final String exegesis;
    private final String keyword;
    private final String action;

    @Builder
    public NoteResponse(PbsNote entity) {
        this.id = entity.getId();
        this.username = entity.getChristian().getName();
        this.createdDate = entity.getCreatedDate();
        this.passage = entity.getPart();
        this.exegesis = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
        this.keyword = entity.getKeyword();
        this.action = entity.getGoal();
    }
}
