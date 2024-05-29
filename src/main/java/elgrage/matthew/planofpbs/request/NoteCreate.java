package elgrage.matthew.planofpbs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class NoteCreate {
    @NotBlank(message = "사용자 ID를 입력해주세요")
    private String userId;

    @NotBlank(message = "성경 구절을 입력해주세요")
    @Size(min = 3)
    private String passage;
    private String keyword;

    @NotBlank(message = "성경 연구 본문을 입력하세요")
    @Size(min = 10)
    private String exegesis;
    private String actions;

    @NotNull
    private boolean share;

    @Builder
    public NoteCreate(String userId, String passage, String keyword, String exegesis, String actions, boolean share) {
        this.userId = userId;
        this.passage = passage;
        this.keyword = keyword;
        this.exegesis = exegesis;
        this.actions = actions;
        this.share = share;
    }
}