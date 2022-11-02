package kodlama.io.kodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	List<ProgrammingLanguage> getAll();
	void add(ProgrammingLanguage programmingLanguage)throws Exception; 
	void update(int id,String newName);
	void delete(int id);
	ProgrammingLanguage getById(int id);
	boolean isTheLanguageExist(ProgrammingLanguage language);
	
	
}


