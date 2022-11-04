package kodlama.io.kodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlamaIoDevs.business.abstracts.LanguageTechnologyService;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.CreateLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.DeleteLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests.UpdateLanguageTechnologyRequest;
import kodlama.io.kodlamaIoDevs.business.responses.languagetechnologyresponse.GetAllLangaugeTechnologyResponse;

@RestController
@RequestMapping("/api/languagetechnologies")
public class LanguageTechnologiesController {
	
	
	private LanguageTechnologyService languageTechnologyService;
	
	@Autowired
	public LanguageTechnologiesController(LanguageTechnologyService languageTechnologyService) {
		super();
		this.languageTechnologyService = languageTechnologyService;
	}
	
	
	
	@GetMapping("/getall")
	public List<GetAllLangaugeTechnologyResponse> getAll() {
		return languageTechnologyService.getAll();
	}
	
	
	@PostMapping("/add")
	public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
		languageTechnologyService.add(createLanguageTechnologyRequest);
	}
	
	@PutMapping("/getall/{id})")
	public void update(int id,UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
		languageTechnologyService.update(id, updateLanguageTechnologyRequest);
	}

	@DeleteMapping("delete/{id}")
	public void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest) {
		languageTechnologyService.delete(deleteLanguageTechnologyRequest);
	}
}
