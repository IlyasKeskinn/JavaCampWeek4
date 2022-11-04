package kodlama.io.kodlamaIoDevs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.kodlamaIoDevs.entities.concretes.LanguageTechnology;

public interface LanguageTechnologyDao extends JpaRepository<LanguageTechnology, Integer> {

}
