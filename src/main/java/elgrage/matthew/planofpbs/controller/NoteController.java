package elgrage.matthew.planofpbs.controller;

import elgrage.matthew.planofpbs.request.NoteCreate;
import elgrage.matthew.planofpbs.request.NoteSearch;
import elgrage.matthew.planofpbs.response.NoteResponse;
import elgrage.matthew.planofpbs.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/notes")
    public void post(@RequestBody @Valid NoteCreate requestBody) {
        log.info("=== POST /notes - requestBody body: {}", requestBody);
        noteService.write(requestBody);
    }

    @GetMapping("/notes/{noteId}")
    public NoteResponse get(@PathVariable Long noteId) {
        return noteService.get(noteId);
    }

    @GetMapping("/notes")
    public List<NoteResponse> retrieve(NoteSearch request) {
        log.info("=== GET /note - request: {}", request);
        return noteService.retrieve(request);
    }

}
