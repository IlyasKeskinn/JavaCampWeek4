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
import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {

	private static final int json = 0;
	ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getall(){
		return programmingLanguageService.getAll();
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	public ProgrammingLanguage getById(@PathVariable("id") int id) {
		return programmingLanguageService.getById(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		programmingLanguageService.delete(id);
	}
	
	@PutMapping(path = "/getall" , consumes = {"aplication/json"})
	public void update(@RequestBody int id, String newName) {
		programmingLanguageService.update(id, newName);
	}
}
