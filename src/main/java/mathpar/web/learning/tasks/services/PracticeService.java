package mathpar.web.learning.tasks.services;

import mathpar.web.learning.tasks.entities.Practice;
import mathpar.web.learning.tasks.entities.PracticeTemplate;
import mathpar.web.learning.tasks.repositories.PracticeRepository;
import mathpar.web.learning.tasks.repositories.PracticeTemplateRepository;
import mathpar.web.learning.tasks.utils.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class PracticeService {
    private final PracticeTemplateRepository practiceTemplateRepository;
    private final PracticeRepository practiceRepository;

    public PracticeService(PracticeTemplateRepository practiceTemplateRepository, PracticeRepository practiceRepository) {
        this.practiceTemplateRepository = practiceTemplateRepository;
        this.practiceRepository = practiceRepository;
    }

    public PracticeTemplate getTemplate(long id){
        return practiceTemplateRepository.findById(id).orElseThrow(BadRequestException::new);
    }

    public PracticeTemplate createTemplate(String text, String answer, long accountId){
        return practiceTemplateRepository.save(new PracticeTemplate(text, answer, accountId));
    }

    public Practice getPractice(long id){
        return practiceRepository.findById(id).orElseThrow(BadRequestException::new);
    }

    public Practice createPracticeFromTemplate(long templateId, long accountId){
        var template = practiceTemplateRepository.findById(templateId).orElseThrow(BadRequestException::new);
        return practiceRepository.save(new Practice(template, accountId));
    }
}
