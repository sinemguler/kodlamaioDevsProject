package kodlama.io.kodlamaioDevs2.webApi.controllers;

import kodlama.io.kodlamaioDevs2.business.abstracts.LanguageTechnologyService;
import kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology.CreateLanguageTechnologyRequest;
import kodlama.io.kodlamaioDevs2.business.requests.LanguageTechnology.UpdateLanguageTechnologyRequest;
import kodlama.io.kodlamaioDevs2.business.responses.LanguageTechnology.GetAllLanguageTechnologysResponse;
import kodlama.io.kodlamaioDevs2.business.responses.LanguageTechnology.GetByIdTechnologyResponse;
import kodlama.io.kodlamaioDevs2.entities.concretes.LanguageTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/languagetechnology")
public class LanguageTechnologyControllers {
    private LanguageTechnologyService languageTechnologyService;

    @Autowired
    public LanguageTechnologyControllers(LanguageTechnologyService languageTechnologyService) {
        this.languageTechnologyService = languageTechnologyService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguageTechnologysResponse> getAll() {
        return languageTechnologyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateLanguageTechnologyRequest createLanguageTechnologyRequest) { //gelen istekleri java sınıfıyla eşlemek için requestbody kullanılır
        this.languageTechnologyService.add(createLanguageTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id) {
        languageTechnologyService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody() UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, int id) throws Exception {
        this.languageTechnologyService.update(updateLanguageTechnologyRequest, id);
    }

    @GetMapping("/{id}")
    public GetByIdTechnologyResponse getById(@PathVariable() int id) {
        return languageTechnologyService.getById(id);
    }

}
