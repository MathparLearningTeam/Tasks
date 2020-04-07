package mathpar.web.learning.tasks.services;

import mathpar.web.learning.tasks.entities.Lecture;
import mathpar.web.learning.tasks.entities.LectureTemplate;
import mathpar.web.learning.tasks.repositories.LectureRepository;
import mathpar.web.learning.tasks.repositories.LectureTemplateRepository;
import mathpar.web.learning.tasks.utils.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    private final LectureTemplateRepository lectureTemplateRepository;
    private final LectureRepository lectureRepository;

    public LectureService(LectureTemplateRepository lectureTemplateRepository, LectureRepository lectureRepository) {
        this.lectureTemplateRepository = lectureTemplateRepository;
        this.lectureRepository = lectureRepository;
    }

    public LectureTemplate createTemplate(String text, long accountId){
        return lectureTemplateRepository.save(new LectureTemplate(text, accountId));
    }

    public LectureTemplate getTemplate(long id){
        return lectureTemplateRepository.findById(id).orElse(null);
    }

    public boolean deleteTemplate(long templateId, long accountId){
        if(!lectureTemplateRepository.isTemplateCreatedByAccount(templateId, accountId).orElse(false))
            return false;
        lectureTemplateRepository.deleteById(templateId);
        return true;
    }

    public Lecture getLecture(long lectureId){
        return lectureRepository.findById(lectureId).orElseThrow(BadRequestException::new);
    }

    public Lecture createLectureFromTemplate(long templateId, long accountId){
        var template = lectureTemplateRepository.findById(templateId).orElseThrow(BadRequestException::new);
        return lectureRepository.save(new Lecture(template, accountId));
    }
}
