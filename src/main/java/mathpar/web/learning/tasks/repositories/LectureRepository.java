package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
