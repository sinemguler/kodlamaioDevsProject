package kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLanguageTechnologyRequest {
    private String technologyName;
    private int languageId;
}
