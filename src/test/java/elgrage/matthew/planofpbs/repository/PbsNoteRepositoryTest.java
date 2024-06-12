package elgrage.matthew.planofpbs.repository;

import elgrage.matthew.planofpbs.domain.Christian;
import elgrage.matthew.planofpbs.domain.PbsNote;
import elgrage.matthew.planofpbs.request.NoteSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PbsNoteRepositoryTest {

    @Autowired
    private PbsNoteRepository pbsNoteRepository;

    @Autowired
    private ChristianRepository chrisitanRepository;

    @Test
    @DisplayName("CREATE")
    @Transactional
    void create() {
        //given
        Optional<Christian> optionalChristian = chrisitanRepository.findById(2L);

        Christian christian = optionalChristian.orElseThrow();


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
                .christian(christian)
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
                () -> assertEquals("matthew 6: 33v", optionalPbsNote.get().getPart())
        );
    }

    @Test
    @DisplayName("QueryDSL")
    @Transactional
    void queryDsl() {
        //given
        NoteSearch search = NoteSearch.builder()
                .passage("matthew 6: 33v")
                .keyword("love jesus")
                .build();
        //when
        List<PbsNote> notes = pbsNoteRepository.findByDynamicQuery(search);
        //then
        assertThat(notes.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("QueryDSL fail")
    void failed() {
        //given
        NoteSearch search = NoteSearch.builder()
                .passage("matthew 6: 33v")
                .keyword("love jesu")
                .build();
        //when
        List<PbsNote> notes = pbsNoteRepository.findByDynamicQuery(search);
        //then
        assertThat(notes.size()).isZero();
    }

}