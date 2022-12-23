package kodlama.io.kodlamaioDevs2.dataAccess.abstracts;

import kodlama.io.kodlamaioDevs2.entities.concretes.LanguageTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageTechnologyRepository extends JpaRepository<LanguageTechnology, Integer> {
}
