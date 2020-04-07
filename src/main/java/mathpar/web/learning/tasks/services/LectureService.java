package mathpar.web.learning.tasks.services;

import mathpar.web.learning.tasks.entities.LectureTemplate;
import mathpar.web.learning.tasks.repositories.LectureTemplateRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    private final LectureTemplateRepository lectureTemplateRepository;

    public LectureService(LectureTemplateRepository lectureTemplateRepository) {
        this.lectureTemplateRepository = lectureTemplateRepository;
    }

    public LectureTemplate createTemplate(String text, long accountId){
        return lectureTemplateRepository.save(new LectureTemplate(text, accountId));
    }

    public LectureTemplate getTemplate(long id){
        return lectureTemplateRepository.findById(id).orElse(null);
    }
}
