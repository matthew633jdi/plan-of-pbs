package elgrage.matthew.planofpbs.controller;

import elgrage.matthew.planofpbs.request.NoteCreate;
import elgrage.matthew.planofpbs.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/notes")
    public void post(@RequestBody @Valid NoteCreate request) {
        log.info("=== POST /notes - request body: {}", request);
        noteService.write(request);
    }
}
