package elgrage.matthew.planofpbs.service;

import elgrage.matthew.planofpbs.domain.Christian;
import elgrage.matthew.planofpbs.domain.PbsNote;
import elgrage.matthew.planofpbs.exception.ChristianNotFoundException;
import elgrage.matthew.planofpbs.repository.ChrisitanRepository;
import elgrage.matthew.planofpbs.repository.PbsNoteRepository;
import elgrage.matthew.planofpbs.request.NoteCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final PbsNoteRepository pbsNoteRepository;
    private final ChrisitanRepository chrisitanRepository;

    public void write(NoteCreate noteCreate) {

        Christian christian = retrieveById(noteCreate.getUserId());


        PbsNote note = PbsNote.builder()
                .christian(christian)
                .part(noteCreate.getPassage())
                .keyword(noteCreate.getKeyword())
                .content(noteCreate.getExegesis())
                .goal(noteCreate.getActions())
                .isShared(noteCreate.isShare())
                .build();

        pbsNoteRepository.save(note);
    }

    private Christian retrieveById(String id) {
        return chrisitanRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ChristianNotFoundException("해당 ID의 사용자가 없습니다."));
    }
}
