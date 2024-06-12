package elgrage.matthew.planofpbs.repository;

import elgrage.matthew.planofpbs.domain.Christian;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ChrisitanRepositoryTest {

    @Autowired
    ChristianRepository chrisitanRepository;

    @Test
    @DisplayName("SAVE")
    @Transactional
    void save() {
        //given
        Christian christian = Christian.builder()
                .role("ROLE_USER")
                .name("username")
                .password("passwordTest")
                .mail("abc@example.com")
                .build();

        //when
        Christian savedId = chrisitanRepository.save(christian);

        //then
        assertThat(savedId).isNotNull();
    }

}