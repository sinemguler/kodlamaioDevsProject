package kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageTechnologyRequest {
    private int id;
    private String technologyName;
    private int languageId;
}
