package mathpar.web.learning.tasks.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "exam_templates")
public class ExamTemplate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "text")
    public String text;
    @Column(name = "answer")
    public String answer;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    public Date creationDate;
    @Column(name = "author_id")
    public long authorId;
    @Column(name = "time_restriction")
    public int timeRestriction;

    public ExamTemplate(String text, String answer, int timeRestriction, long authorId) {
        this.text = text;
        this.answer = answer;
        this.authorId = authorId;
        this.timeRestriction = timeRestriction;
    }
}
