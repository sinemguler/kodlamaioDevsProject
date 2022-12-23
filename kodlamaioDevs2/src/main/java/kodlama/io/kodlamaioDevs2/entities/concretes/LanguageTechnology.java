package kodlama.io.kodlamaioDevs2.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "technologys")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LanguageTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private int id;
    @Column(name = "technology_name")
    private String technologyName;
    @ManyToOne
    @JoinColumn(name = "language_id")
    public ProgrammingLanguage programmingLanguage;
}
