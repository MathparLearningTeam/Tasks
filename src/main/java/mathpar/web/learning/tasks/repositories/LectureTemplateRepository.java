package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.LectureTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureTemplateRepository extends JpaRepository<LectureTemplate, Long> {
}
