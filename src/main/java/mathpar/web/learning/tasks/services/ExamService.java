package mathpar.web.learning.tasks.services;

import mathpar.web.learning.tasks.entities.Exam;
import mathpar.web.learning.tasks.entities.ExamTemplate;
import mathpar.web.learning.tasks.repositories.ExamRepository;
import mathpar.web.learning.tasks.repositories.ExamTemplateRepository;
import mathpar.web.learning.tasks.utils.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    private final ExamTemplateRepository examTemplateRepository;
    private final ExamRepository examRepository;

    public ExamService(ExamTemplateRepository examTemplateRepository, ExamRepository examRepository) {
        this.examTemplateRepository = examTemplateRepository;
        this.examRepository = examRepository;
    }

    public ExamTemplate getTemplate(long id){
        return examTemplateRepository.findById(id).orElseThrow(BadRequestException::new);
    }

    public ExamTemplate createTemplate(String text, String answer, int timeRestriction, long accountId){
        return examTemplateRepository.save(new ExamTemplate(text, answer, timeRestriction, accountId));
    }

    public Exam getExam(long id){
        return examRepository.findById(id).orElseThrow(BadRequestException::new);
    }

    public Exam createExamFromTemplate(long templateId, long accountId){
        var template = getTemplate(templateId);
        return examRepository.save(new Exam(template, accountId));
    }
}
