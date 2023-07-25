package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.webApi.controllers.ProgrammingLanguagesController;

@RestController
@RequestMapping("api/languages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	public ProgrammingLanguagesController() {
		
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();

	}

	@GetMapping("/get{id}")
	public ProgrammingLanguage getById(@PathVariable("id") int id) {
		return programmingLanguageService.getById(id);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") int id) {
		programmingLanguageService.delete(id);
	}

	@PostMapping("/addLanguage")
	public void addLanguage(@RequestBody ProgrammingLanguage language) throws Exception {
		programmingLanguageService.add(language);
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") int id, ProgrammingLanguage language) throws Exception {
		programmingLanguageService.update(id, language);

	}
}
