package kodlama.io.kodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.DeleteProgrammingLanguage;
import kodlama.io.kodlamaIoDevs.business.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaIoDevs.business.responses.programminglanguageresponse.GetAllProgrammingLanguageResponse;
import kodlama.io.kodlamaIoDevs.business.responses.programminglanguageresponse.GetByIdProgrammingLanguageResponsse;
import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {

	ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	
	//call all data
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	//call object by id 
	
	@RequestMapping("/{id}")
	public GetByIdProgrammingLanguageResponsse getById( int id) {
		return programmingLanguageService.getById(id);
	}
	

	
	
	//add new language
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	//update language 
	@PutMapping(path = "/getall/{id}")
	public void update(@RequestBody int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.update(id, updateProgrammingLanguageRequest);
	}
	
	//delete language
	@DeleteMapping("/delete/{id}")
	public void delete(DeleteProgrammingLanguage deleteProgrammingLanguage) {
		programmingLanguageService.delete(deleteProgrammingLanguage);
	}
	
	


}
