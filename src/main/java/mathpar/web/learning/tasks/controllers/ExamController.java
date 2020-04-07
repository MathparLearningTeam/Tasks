package mathpar.web.learning.tasks.controllers;

import io.swagger.annotations.Api;
import mathpar.web.learning.tasks.entities.Exam;
import mathpar.web.learning.tasks.entities.ExamTemplate;
import mathpar.web.learning.tasks.services.ExamService;
import mathpar.web.learning.tasks.utils.PublicApi;
import mathpar.web.learning.tasks.utils.SecurityUtils;
import mathpar.web.learning.tasks.utils.dto.payload.CreateExamPayload;
import mathpar.web.learning.tasks.utils.dto.payload.CreateExamTemplatePayload;
import org.springframework.web.bind.annotation.*;

@PublicApi
@RestController
@Api(tags = "Exam")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/exam/template")
    public ExamTemplate getTemplate(@RequestParam("id") long id){
        return examService.getTemplate(id);
    }

    @PostMapping("/exam/template")
    public ExamTemplate createTemplate(@RequestBody CreateExamTemplatePayload payload){
        var accountId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
        return examService.createTemplate(payload.getText(), payload.getAnswer(), payload.getTimeRestriction(), accountId);
    }

    @GetMapping("/exam")
    public Exam getExam(@RequestParam("id") long id){
        return examService.getExam(id);
    }

    @PostMapping("/exam")
    public Exam createExam(@RequestBody CreateExamPayload payload){
        var accountId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
        return examService.createExamFromTemplate(payload.getTemplateId(), accountId);
    }
}
