package mathpar.web.learning.tasks.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@Entity(name = "exams")
public class Exam {
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
    //Time restriction for this exam in seconds
    @Column(name = "time_restriction")
    public long timeRestriction;
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    @ManyToOne(fetch = LAZY)
    public ExamTemplate template;

    public Exam(ExamTemplate template, long authorId) {
        this.template = template;
        this.text = template.getText();
        this.answer = template.getAnswer();
        this.authorId = authorId;
        this.timeRestriction = template.getTimeRestriction();
    }
}
