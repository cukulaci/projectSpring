package kodlama.io.devs.business.concretes;

import java.util.List;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	List<ProgrammingLanguage> languages;
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

	
	@Override
	public void add(ProgrammingLanguage language) throws Exception {
		
		if(language.getName() != null) {
			if (languages.contains(language.getName())) {
				throw new Exception (language.getName() + " this programming language already exist.");
			}
			else {
				programmingLanguageRepository.add(language);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
	}

	@Override
	public void update(int id, ProgrammingLanguage language) throws Exception {
		
		if(!languages.contains(language.getId())) {
			if(language.getName() != null) {
				if (languages.contains(language.getName())) {
					throw new Exception (language.getName() + " this programming language already exist.");
				}
				else {
					programmingLanguageRepository.update(id, language);
				}
			}
		
		}
		else {
			throw new Exception ("This id(" + language.getId() + ") is possesed by " + language.getName() + ". Choose another ID.");
		}
		
	}

	
	
}
