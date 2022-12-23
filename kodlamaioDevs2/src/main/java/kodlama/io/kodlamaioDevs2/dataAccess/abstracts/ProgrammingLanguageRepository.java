package kodlama.io.kodlamaioDevs2.dataAccess.abstracts;

import kodlama.io.kodlamaioDevs2.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
}
