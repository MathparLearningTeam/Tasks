package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.LectureTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LectureTemplateRepository extends JpaRepository<LectureTemplate, Long> {
    @Query(value = "select true from lecture_templates where id=?1 and authorId=?2", nativeQuery = true)
    Optional<Boolean> isTemplateCreatedByAccount(long templateId, long accountId);
}
