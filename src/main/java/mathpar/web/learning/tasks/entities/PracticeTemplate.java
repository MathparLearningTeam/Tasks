package mathpar.web.learning.tasks.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "practice_templates")
public class PracticeTemplate {
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

    public PracticeTemplate(String text, String answer, long authorId) {
        this.text = text;
        this.answer = answer;
        this.authorId = authorId;
    }
}
