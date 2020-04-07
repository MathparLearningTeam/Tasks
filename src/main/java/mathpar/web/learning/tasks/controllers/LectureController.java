package mathpar.web.learning.tasks.controllers;

import io.swagger.annotations.Api;
import mathpar.web.learning.tasks.entities.LectureTemplate;
import mathpar.web.learning.tasks.services.LectureService;
import mathpar.web.learning.tasks.utils.PublicApi;
import mathpar.web.learning.tasks.utils.SecurityUtils;
import mathpar.web.learning.tasks.utils.dto.payload.CreateLectureTemplate;
import org.springframework.web.bind.annotation.*;

@PublicApi
@RestController
@Api("Lecture")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/lecture/template")
    public LectureTemplate getLectureTemplate(@RequestParam("id") long id){
        return lectureService.getTemplate(id);
    }

    @PostMapping("/lecture/template")
    public LectureTemplate createLectureTemplate(@RequestBody CreateLectureTemplate payload){
        return lectureService.createTemplate(payload.getText(), SecurityUtils.getCurrentlyAuthenticatedAccountId());
    }
}
