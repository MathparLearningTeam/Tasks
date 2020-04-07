package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
