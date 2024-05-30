package elgrage.matthew.planofpbs.repository;

import elgrage.matthew.planofpbs.domain.Christian;
import elgrage.matthew.planofpbs.domain.GenderType;
import elgrage.matthew.planofpbs.domain.RoleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ChrisitanRepositoryTest {

    @Autowired
    ChrisitanRepository chrisitanRepository;

    @Test
    @DisplayName("SAVE")
    void save() {
        //given
        Christian christian = Christian.builder()
                .gender(GenderType.MALE)
                .role(RoleType.ADMIN)
                .mail("abc@example.com")
                .build();

        //when
        Christian savedId = chrisitanRepository.save(christian);

        //then
        assertThat(savedId).isNotNull();
    }

}