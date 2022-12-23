package kodlama.io.kodlamaioDevs2.business.concretes;

import kodlama.io.kodlamaioDevs2.business.abstracts.LanguageTechnologyService;
import kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology.CreateLanguageTechnologyRequest;
import kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology.UpdateLanguageTechnologyRequest;
import kodlama.io.kodlamaioDevs2.business.responses.LanguageTechnology.GetAllLanguageTechnologysResponse;
import kodlama.io.kodlamaioDevs2.business.responses.LanguageTechnology.GetByIdTechnologyResponse;
import kodlama.io.kodlamaioDevs2.dataAccess.abstracts.LanguageTechnologyRepository;
import kodlama.io.kodlamaioDevs2.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlamaioDevs2.entities.concretes.LanguageTechnology;
import kodlama.io.kodlamaioDevs2.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageTechnologyManager implements LanguageTechnologyService {
    private LanguageTechnologyRepository languageTechnologyRepository;
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public LanguageTechnologyManager(LanguageTechnologyRepository languageTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
        this.languageTechnologyRepository = languageTechnologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<GetAllLanguageTechnologysResponse> getAll() {
        List<LanguageTechnology> languageTechnologies = languageTechnologyRepository.findAll();
        List<GetAllLanguageTechnologysResponse> languageTechnologiesResponses = new ArrayList<GetAllLanguageTechnologysResponse>();
        for (LanguageTechnology languagetechnology : languageTechnologies) {
            GetAllLanguageTechnologysResponse responseItem = new GetAllLanguageTechnologysResponse();
            responseItem.setId(languagetechnology.getId());
            responseItem.setTechnologyName(languagetechnology.getTechnologyName());
            responseItem.setLanguageName(languagetechnology.getProgrammingLanguage().getLanguageName());
            languageTechnologiesResponses.add(responseItem);
        }
        return languageTechnologiesResponses;
    }

    @Override
    public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
        LanguageTechnology languageTechnology = new LanguageTechnology();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createLanguageTechnologyRequest.getLanguageId()).get();
        languageTechnology.setProgrammingLanguage(programmingLanguage);
        languageTechnology.setTechnologyName(createLanguageTechnologyRequest.getTechnologyName());
        this.languageTechnologyRepository.save(languageTechnology);
    }

    @Override
    public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, int id) {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateLanguageTechnologyRequest.getLanguageId()).get();
        LanguageTechnology languageTechnology = languageTechnologyRepository.findById(updateLanguageTechnologyRequest.getId()).get();
        languageTechnology.setTechnologyName(updateLanguageTechnologyRequest.getTechnologyName());
        languageTechnology.setProgrammingLanguage(programmingLanguage);
        languageTechnologyRepository.save(languageTechnology);
    }

    @Override
    public void delete(int id) {
        languageTechnologyRepository.deleteById(id);
    }
    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Optional<LanguageTechnology> languageTechnology = languageTechnologyRepository.findById(id);
        GetByIdTechnologyResponse technologyResponse = new GetByIdTechnologyResponse();
        technologyResponse.setTechnologyName(languageTechnology.get().getTechnologyName());
        return technologyResponse;
    }
}
