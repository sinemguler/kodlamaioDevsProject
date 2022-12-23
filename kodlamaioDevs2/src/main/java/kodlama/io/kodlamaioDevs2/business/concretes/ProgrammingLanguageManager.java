package kodlama.io.kodlamaioDevs2.business.concretes;

import kodlama.io.kodlamaioDevs2.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlamaioDevs2.business.requests.ProgrammingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs2.business.requests.ProgrammingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs2.business.responses.ProgrammingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlamaioDevs2.business.responses.ProgrammingLanguage.GetByIdLanguageResponse;
import kodlama.io.kodlamaioDevs2.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlamaioDevs2.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll(); //veritabanından gelen veriler tutulur
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>(); //boş liste oluşturulur
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) { //for ile veritabanından gelen datalar dolaşılır
            GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse(); //her dolaştığımızda yeni eleman oluşturulur
            responseItem.setId(programmingLanguage.getId());
            responseItem.setLanguageName(programmingLanguage.getLanguageName());
            programmingLanguagesResponses.add(responseItem);
        }
        return programmingLanguagesResponses;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) { //veritabanına kayıt ekler
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(); //yeni programming language oluşturulur
        programmingLanguage.setLanguageName((createProgrammingLanguageRequest.getLanguageName()));
        this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception {
        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(id);
        if (programmingLanguage.isPresent()) {
            ProgrammingLanguage programmingLanguage1 = programmingLanguage.get();
            programmingLanguage1.setLanguageName(updateProgrammingLanguageRequest.getLanguageName());
            this.programmingLanguageRepository.save(programmingLanguage1);
        }
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(id);
        GetByIdLanguageResponse languageResponse = new GetByIdLanguageResponse();
        languageResponse.setLanguageName(programmingLanguage.get().getLanguageName());
        return languageResponse;
    }
}
