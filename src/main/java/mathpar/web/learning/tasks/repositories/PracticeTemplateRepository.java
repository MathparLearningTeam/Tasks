package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.PracticeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeTemplateRepository extends JpaRepository<PracticeTemplate, Long> {
}
