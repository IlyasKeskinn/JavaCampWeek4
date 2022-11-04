package kodlama.io.kodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.DeleteProgrammingLanguage;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaIoDevs.business.responses.programminglanguageresponse.GetAllProgrammingLanguageResponse;
import kodlama.io.kodlamaIoDevs.business.responses.programminglanguageresponse.GetByIdProgrammingLanguageResponsse;

public interface ProgrammingLanguageService {

	List<GetAllProgrammingLanguageResponse> getAll();
	GetByIdProgrammingLanguageResponsse getById(int id);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void update (int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	void delete(DeleteProgrammingLanguage deleteProgrammingLanguage);
	
}


