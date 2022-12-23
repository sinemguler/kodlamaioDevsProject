package kodlama.io.kodlamaioDevs2.business.responses.LanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageTechnologysResponse {
    private int id;
    private String technologyName;
    private String languageName;
}
