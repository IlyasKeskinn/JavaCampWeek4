package kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageTechnologyRequest {
	
	private String name;
	private int programmingLanguageID;

}
