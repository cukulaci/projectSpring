package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;

public interface ProgrammingLanguageService {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	void add(ProgrammingLanguage language) throws Exception;
	void delete(int id);
	void update(int id, ProgrammingLanguage language) throws Exception;
}
