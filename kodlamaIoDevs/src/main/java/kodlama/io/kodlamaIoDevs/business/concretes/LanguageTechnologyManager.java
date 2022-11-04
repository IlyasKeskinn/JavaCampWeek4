package kodlama.io.kodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlamaIoDevs.business.abstracts.LanguageTechnologyService;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.CreateLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.DeleteLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.UpdateLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.responses.languagetechnologyresponse.GetAllLangaugeTechnologyResponse;
import kodlama.io.kodlamaIoDevs.dataAccess.abstracts.LanguageTechnologyDao;
import kodlama.io.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguagesDao;
import kodlama.io.kodlamaIoDevs.entities.concretes.LanguageTechnology;
import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;



@Service
public class LanguageTechnologyManager implements LanguageTechnologyService{

	private ProgrammingLanguagesDao programmingLanguagesDao;
	private LanguageTechnologyDao languageTechnologyDao;
	
	
	
	
	
	public LanguageTechnologyManager(ProgrammingLanguagesDao programmingLanguagesDao,
			LanguageTechnologyDao languageTechnologyDao) {
		this.programmingLanguagesDao = programmingLanguagesDao;
		this.languageTechnologyDao = languageTechnologyDao;
	}





	@Override
	public List<GetAllLangaugeTechnologyResponse> getAll() {
		List<LanguageTechnology> languageTechnologies = languageTechnologyDao.findAll();
		List<GetAllLangaugeTechnologyResponse> langaugeTechnologyResponses = new ArrayList<>();
		
		for(LanguageTechnology languageTechnology : languageTechnologies) {
			GetAllLangaugeTechnologyResponse responseItem = new GetAllLangaugeTechnologyResponse();
			responseItem.setName(languageTechnology.getName());
			responseItem.setProgrammingLanguageName(languageTechnology.getProgrammingLanguage().getPLanguageName());
			langaugeTechnologyResponses.add(responseItem);
		}
		
		
		return langaugeTechnologyResponses;
	}





	@Override
	public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
		LanguageTechnology languageTechnology = new LanguageTechnology();
		ProgrammingLanguage programmingLanguage = programmingLanguagesDao.findById(createLanguageTechnologyRequest.getProgrammingLanguageID()).get();

		languageTechnology.setName(createLanguageTechnologyRequest.getName());
		languageTechnology.setProgrammingLanguage(programmingLanguage);
		
		languageTechnologyDao.save(languageTechnology);
	}





	@Override
	public void update(int id, UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
		LanguageTechnology languageTechnology = languageTechnologyDao.findById(id).get();
		
		ProgrammingLanguage programmingLanguage = programmingLanguagesDao.findById(updateLanguageTechnologyRequest.getProgrammingLanguageID()).get();
		
		languageTechnology.setName(updateLanguageTechnologyRequest.getName());
		languageTechnology.setProgrammingLanguage(programmingLanguage);
		
		languageTechnologyDao.save(languageTechnology);
	}





	@Override
	public void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest) {
		languageTechnologyDao.deleteById(deleteLanguageTechnologyRequest.getId());
	}

}
