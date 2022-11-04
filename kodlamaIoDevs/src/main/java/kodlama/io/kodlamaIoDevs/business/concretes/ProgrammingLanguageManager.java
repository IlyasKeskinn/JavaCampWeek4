package kodlama.io.kodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.DeleteProgrammingLanguage;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaIoDevs.business.responses.programminglanguageresponse.GetAllProgrammingLanguageResponse;
import kodlama.io.kodlamaIoDevs.business.responses.programminglanguageresponse.GetByIdProgrammingLanguageResponsse;
import kodlama.io.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguagesDao;
import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@Service

public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguagesDao programmingLanguagesDao;

	boolean isExit = false;

	public ProgrammingLanguageManager(ProgrammingLanguagesDao programmingLanguagesDao) {
		this.programmingLanguagesDao = programmingLanguagesDao;
	}

	// getallName

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguagesDao.findAll();

		List<GetAllProgrammingLanguageResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguageResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setPLanguageName(programmingLanguage.getPLanguageName());
			programmingLanguagesResponse.add(responseItem);
		}
		return programmingLanguagesResponse;

	}
	
	//get item by id
	
	@Override
	public GetByIdProgrammingLanguageResponsse getById(int id) {
		
		ProgrammingLanguage programmingLanguage =  programmingLanguagesDao.findById(id).get();
		GetByIdProgrammingLanguageResponsse response = new GetByIdProgrammingLanguageResponsse();
		response.setName(programmingLanguage.getPLanguageName());
		return response;
	}

	// add new language

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setPLanguageName(createProgrammingLanguageRequest.getName());
		
		if(createProgrammingLanguageRequest.getName()==null|| createProgrammingLanguageRequest.getName().length()==0) {
			throw new Exception("Program name cannot be empty");
		}
		else {
			if (isTheLanguageExist(createProgrammingLanguageRequest.getName())==true) {
				throw new Exception("Program name already in use.");
			} else {
				this.programmingLanguagesDao.save(programmingLanguage);
				System.out.println("Programming language added and id name is : " + programmingLanguage.getPLanguageName());
			}
		}

	}
	
	//validator

	public boolean isTheLanguageExist(String languageName) {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguagesDao.findAll();

		for (ProgrammingLanguage planguage : programmingLanguages) {
			if (planguage.getPLanguageName().equalsIgnoreCase(languageName)) {
				isExit = true;
			}
		}
		return isExit;

	}



	//update item 
	
	@Override
	public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {	
		ProgrammingLanguage programmingLanguage = programmingLanguagesDao.findById(id).get();
		
		if(programmingLanguage.getPLanguageName().equalsIgnoreCase(updateProgrammingLanguageRequest.getName())){
			throw new Exception("Program name already in use.");
		}
		else {
			programmingLanguage.setPLanguageName(updateProgrammingLanguageRequest.getName());
			this.programmingLanguagesDao.save(programmingLanguage);
		}
	}
	
	
	
	//delete item
	
	@Override
	public void delete(DeleteProgrammingLanguage deleteProgrammingLanguage) {
		this.programmingLanguagesDao.deleteById(deleteProgrammingLanguage.getId());
	}

	
	


	

}
