package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.Practice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeRepository extends JpaRepository<Practice, Long> {
}
