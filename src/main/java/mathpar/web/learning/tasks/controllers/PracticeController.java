package mathpar.web.learning.tasks.controllers;

import io.swagger.annotations.Api;
import mathpar.web.learning.tasks.entities.Practice;
import mathpar.web.learning.tasks.entities.PracticeTemplate;
import mathpar.web.learning.tasks.services.PracticeService;
import mathpar.web.learning.tasks.utils.PublicApi;
import mathpar.web.learning.tasks.utils.SecurityUtils;
import mathpar.web.learning.tasks.utils.dto.payload.CreatePracticePayload;
import mathpar.web.learning.tasks.utils.dto.payload.CreatePracticeTemplatePayload;
import org.springframework.web.bind.annotation.*;

@PublicApi
@RestController
@Api(tags = "Practice")
public class PracticeController {
    private final PracticeService practiceService;

    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @GetMapping("/practice/template")
    public PracticeTemplate getPracticeTemplate(@RequestParam("id") long id){
        return practiceService.getTemplate(id);
    }

    @PostMapping("/practice/template")
    public PracticeTemplate createPracticeTemplate(@RequestBody CreatePracticeTemplatePayload payload){
        var accountId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
        return practiceService.createTemplate(payload.getText(), payload.getAnswer(), accountId);
    }

    @GetMapping("/practice")
    public Practice getPractice(@RequestParam("id") long id){
        return practiceService.getPractice(id);
    }

    @PostMapping("/practice")
    public Practice createPractice(@RequestBody CreatePracticePayload payload){
        var accountId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
        return practiceService.createPracticeFromTemplate(payload.getTemplateId(), accountId);
    }
}
