package kodlama.io.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguagesDao extends JpaRepository<ProgrammingLanguage, Integer>{
	
	
}
