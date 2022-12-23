package kodlama.io.kodlamaioDevs2.business.abstracts;

import kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology.CreateLanguageTechnologyRequest;
import kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology.UpdateLanguageTechnologyRequest;
import kodlama.io.kodlamaioDevs2.business.responses.LanguageTechnology.GetAllLanguageTechnologysResponse;
import kodlama.io.kodlamaioDevs2.business.responses.LanguageTechnology.GetByIdTechnologyResponse;

import java.util.List;

public interface LanguageTechnologyService {
    List<GetAllLanguageTechnologysResponse> getAll();

    void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest);

    void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, int id);

    void delete(int id);

    GetByIdTechnologyResponse getById(int id);
}
