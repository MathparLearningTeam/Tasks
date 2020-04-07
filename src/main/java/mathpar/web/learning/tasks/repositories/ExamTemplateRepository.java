package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.ExamTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamTemplateRepository extends JpaRepository<ExamTemplate, Long> {
}
