package kodlama.io.kodlamaIoDevs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="LanguageTechonology")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageTechnology {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	 @Column(name = "name")
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name="programming_language_id")
	private ProgrammingLanguage programmingLanguage;
}
