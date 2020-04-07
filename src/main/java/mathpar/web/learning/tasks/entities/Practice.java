package mathpar.web.learning.tasks.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@Entity(name = "practices")
public class Practice {
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
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    @ManyToOne(fetch = LAZY)
    public PracticeTemplate template;

    public Practice(PracticeTemplate template, long authorId) {
        this.template = template;
        this.text = template.getText();
        this.answer = template.getAnswer();
        this.authorId = authorId;
    }
}
