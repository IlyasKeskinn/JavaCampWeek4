package kodlama.io.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguagesDao {
	
	List<ProgrammingLanguage> getAll();
	void add(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	void update(int id,String newName);
	ProgrammingLanguage getById(int id);
}
