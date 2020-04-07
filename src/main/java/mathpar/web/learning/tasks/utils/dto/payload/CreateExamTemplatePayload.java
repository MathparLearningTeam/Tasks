package mathpar.web.learning.tasks.utils.dto.payload;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class CreateExamTemplatePayload {
    private String text;
    private String answer;
    @ApiParam(value = "Time restriction to complete the exam in seconds")
    private int timeRestriction;
}
