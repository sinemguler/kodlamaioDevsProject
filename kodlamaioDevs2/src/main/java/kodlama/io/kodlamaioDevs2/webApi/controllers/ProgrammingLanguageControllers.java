package kodlama.io.kodlamaioDevs2.webApi.controllers;

import kodlama.io.kodlamaioDevs2.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlamaioDevs2.business.requests.ProgrammingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs2.business.requests.ProgrammingLanguage.UpdateProgrammingLanguageRequest;

import kodlama.io.kodlamaioDevs2.business.responses.ProgrammingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlamaioDevs2.business.responses.ProgrammingLanguage.GetByIdLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguageControllers {

    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageControllers(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return programmingLanguageService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        this.programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id) {
        programmingLanguageService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody() UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception {
        this.programmingLanguageService.update(updateProgrammingLanguageRequest, id);
    }

    @GetMapping("/{id}")
    public GetByIdLanguageResponse getById(@PathVariable() int id) {
        return programmingLanguageService.getById(id);
    }
}
