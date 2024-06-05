package elgrage.matthew.planofpbs.service;

import elgrage.matthew.planofpbs.domain.Christian;
import elgrage.matthew.planofpbs.domain.PbsNote;
import elgrage.matthew.planofpbs.exception.ChristianNotFoundException;
import elgrage.matthew.planofpbs.exception.NoteNotFound;
import elgrage.matthew.planofpbs.repository.ChrisitanRepository;
import elgrage.matthew.planofpbs.repository.PbsNoteRepository;
import elgrage.matthew.planofpbs.request.NoteCreate;
import elgrage.matthew.planofpbs.request.NoteEdit;
import elgrage.matthew.planofpbs.request.NoteSearch;
import elgrage.matthew.planofpbs.response.NoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<NoteResponse> retrieve(NoteSearch noteSearch) {
        List<PbsNote> notes = pbsNoteRepository.findByDynamicQuery(noteSearch);
        return notes.stream().map(NoteResponse::new).collect(Collectors.toList());
    }

    public NoteResponse get(Long id) {
        PbsNote note = pbsNoteRepository.findById(id).orElseThrow(() -> new NoteNotFound("not found pbs note"));
        return new NoteResponse(note);
    }

    private Christian retrieveById(Long id) {
        return chrisitanRepository.findById(id).orElseThrow(() -> new ChristianNotFoundException("해당 ID의 사용자가 없습니다."));
    }

    public void edit(Long id, NoteEdit request) {
        PbsNote note = pbsNoteRepository.findById(id).orElseThrow(() -> new NoteNotFound("not found pbs note"));
        // TODO
    }
}
