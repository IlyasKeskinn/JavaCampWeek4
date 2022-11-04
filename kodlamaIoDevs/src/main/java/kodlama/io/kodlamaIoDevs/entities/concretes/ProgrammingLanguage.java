package kodlama.io.kodlamaIoDevs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProgrammingLanguage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String pLanguageName;
	
	@OneToMany(mappedBy = "programmingLanguage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LanguageTechnology> technologies;

}
