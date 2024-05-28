package elgrage.matthew.planofpbs.repository;

import elgrage.matthew.planofpbs.domain.PbsNote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PbsNoteRepositoryTest {

    @Autowired
    private PbsNoteRepository pbsNoteRepository;

    @Test
    @DisplayName("CREATE")
    @Transactional
    void create() {
        //given
        String content = """
                == Test Content ==
                Enlightenments: love 
                Thanks: jesus love
                Repents: wordly desire
                Prays: please
                Practices: jesus desire
                """;
        PbsNote note = PbsNote.builder()
                .part("matthew 6: 33v")
                .keyword("love jesus")
                .content(content)
                .goal("jesus desire")
                .isShared(false)
                .build();
        //when
        PbsNote saveNote = pbsNoteRepository.save(note);
        //then
        assertThat(saveNote).isNotNull();

    }

    @Test
    @DisplayName("RETRIEVE")
    void retrieve() {
        //given
        Optional<PbsNote> optionalPbsNote = pbsNoteRepository.findById(2L);

        //then
        assertAll(
                () -> assertTrue(optionalPbsNote.isPresent()),
                () -> assertEquals(optionalPbsNote.get().getPart(), "matthew 6: 33v")
        );
    }

}