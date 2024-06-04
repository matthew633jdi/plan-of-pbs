package elgrage.matthew.planofpbs.service;

import elgrage.matthew.planofpbs.repository.PbsNoteRepository;
import elgrage.matthew.planofpbs.request.NoteCreate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NoteServiceTest {

    @Autowired
    NoteService noteService;

    @Autowired
    PbsNoteRepository pbsNoteRepository;

    @Test
    @DisplayName("WRITE Test")
    @Transactional
    void write() {
        //given
        NoteCreate request = NoteCreate.builder()
                .userId(2L)
                .passage("test passage")
                .keyword("test keyword")
                .exegesis("test exegesis")
                .actions("test actions")
                .share(false)
                .build();

        //when
        noteService.write(request);
        //then
        assertThat(pbsNoteRepository.count()).isEqualTo(4L);
    }
}