package kodlama.io.kodlamaIoDevs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguagesDao;
import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;


@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguagesDao{

	List<ProgrammingLanguage> languages;
	
	
	public InMemoryProgrammingLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1,"Java"));
		languages.add(new ProgrammingLanguage(2,"C#"));
		languages.add(new ProgrammingLanguage(3,"Python"));
		languages.add(new ProgrammingLanguage(4,"PHP"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
			for(ProgrammingLanguage language: languages) {
				if(language.getId()==id) {
					languages.remove(language);
				}
				
			}
		
	}

	@Override
	public void update(int id, String newName) {
			for(ProgrammingLanguage language: languages){
				if(language.getId() == id){
					language.setpLanguage(newName);
				}
			}
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage language : languages) {
			if (language.getId()==id) {
				return language;
			}
		}
		return null;
	}

}
