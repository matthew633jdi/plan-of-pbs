package elgrage.matthew.planofpbs.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Christian {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private String mail;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Builder
    public Christian(GenderType gender, String mail, RoleType role) {
        this.gender = gender;
        this.mail = mail;
        this.role = role;
    }
}
