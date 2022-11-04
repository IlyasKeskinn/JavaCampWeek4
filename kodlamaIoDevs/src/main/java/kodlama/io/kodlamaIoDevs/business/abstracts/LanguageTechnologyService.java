package kodlama.io.kodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.CreateLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.DeleteLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.UpdateLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.responses.languagetechnologyresponse.GetAllLangaugeTechnologyResponse;

public interface LanguageTechnologyService {
	
	List<GetAllLangaugeTechnologyResponse> getAll();
	void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest);
	void update(int id,UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest);
	void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest);
	

}
