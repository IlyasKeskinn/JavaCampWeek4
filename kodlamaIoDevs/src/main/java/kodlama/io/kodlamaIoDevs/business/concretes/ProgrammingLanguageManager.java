package kodlama.io.kodlamaIoDevs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguagesDao;
import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;


@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguagesDao programmingLanguagesDao ;
	
	boolean isExit = false;
	
	

	public ProgrammingLanguageManager(ProgrammingLanguagesDao programmingLanguagesDao) {
		this.programmingLanguagesDao = programmingLanguagesDao;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
			
		return programmingLanguagesDao.getAll();
	
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
			
		if(programmingLanguage.getpLanguage()==null || programmingLanguage.getpLanguage().length()==0) {
			  throw new Exception("This field cannot be empty");
		}
		else {
			for(ProgrammingLanguage planguage : programmingLanguagesDao.getAll()) {
				if(isTheLanguageExist(programmingLanguage)==true){
					throw new Exception("Sorry that name is already existed");
				}
				else {
					System.out.println("Programming language added and id numbers is : " + programmingLanguage.getId());
					programmingLanguagesDao.add(programmingLanguage);
				}
			}
		}
		

	}

	@Override
	public void update(int id, String newName) {	
		for(ProgrammingLanguage pLanguage : programmingLanguagesDao.getAll()) {
			if(pLanguage.getpLanguage()==newName) {
				System.out.println("Sorry that name is already existed");
			}
			else {
				programmingLanguagesDao.update(id, newName);
			}
		}
		
		
		
	}

	@Override
	public void delete(int id) {
		for(ProgrammingLanguage pLanguage : programmingLanguagesDao.getAll()) {
			if(pLanguage.getId()!=id) {
				System.out.println("There is no such programming language");
			}
			else {
				programmingLanguagesDao.delete(id);
			}
		}
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguagesDao.getById(id);
	}

	@Override
	public boolean isTheLanguageExist(ProgrammingLanguage language) {

		for(ProgrammingLanguage planguage : programmingLanguagesDao.getAll()) {
			if(planguage.getpLanguage().toUpperCase() ==language.getpLanguage().toUpperCase()||planguage.getId()==language.getId()){
				isExit = true;
			}
		}
		
		return isExit;
	}

}
