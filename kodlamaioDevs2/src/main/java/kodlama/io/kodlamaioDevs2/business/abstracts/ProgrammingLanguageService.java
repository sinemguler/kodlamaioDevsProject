package kodlama.io.kodlamaioDevs2.business.abstracts;

import kodlama.io.kodlamaioDevs2.business.requests.ProgrammingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs2.business.requests.ProgrammingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs2.business.responses.ProgrammingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlamaioDevs2.business.responses.ProgrammingLanguage.GetByIdLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest); //create language requestin içerisindeki datayı getirir
    void delete(int id);
    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception;
    GetByIdLanguageResponse getById(int id);
}
