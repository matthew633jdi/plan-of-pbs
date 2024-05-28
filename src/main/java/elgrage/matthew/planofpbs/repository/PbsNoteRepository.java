package elgrage.matthew.planofpbs.repository;

import elgrage.matthew.planofpbs.domain.PbsNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PbsNoteRepository extends JpaRepository<PbsNote, Long> {
}
