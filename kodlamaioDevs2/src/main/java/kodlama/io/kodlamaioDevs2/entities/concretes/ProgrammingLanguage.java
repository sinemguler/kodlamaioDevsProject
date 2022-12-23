package kodlama.io.kodlamaioDevs2.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int id;
    @Column(name = "language_name")
    private String languageName;
    @OneToMany(mappedBy = "programmingLanguage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LanguageTechnology> technologies;
}
