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

    private String name;
    private String password;
    private String mail;
    private String role;
    private String provider;

    private String providerId;

    @Builder
    public Christian(String name, String password, String mail, String role, String provider, String providerId) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}
