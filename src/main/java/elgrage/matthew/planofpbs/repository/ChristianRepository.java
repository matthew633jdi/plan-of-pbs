package elgrage.matthew.planofpbs.repository;

import elgrage.matthew.planofpbs.domain.Christian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChristianRepository extends JpaRepository<Christian, Long> {
    Optional<Christian> findByName(String name);
}
