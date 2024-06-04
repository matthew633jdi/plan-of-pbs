package elgrage.matthew.planofpbs.repository;

import elgrage.matthew.planofpbs.domain.PbsNote;
import elgrage.matthew.planofpbs.request.NoteSearch;

import java.util.List;

public interface PbsNoteCustomRepository {
    List<PbsNote> findByDynamicQuery(NoteSearch search);
}
