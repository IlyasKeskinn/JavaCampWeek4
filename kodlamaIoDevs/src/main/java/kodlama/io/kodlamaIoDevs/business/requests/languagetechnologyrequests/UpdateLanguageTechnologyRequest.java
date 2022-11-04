package kodlama.io.kodlamaIoDevs.business.requests.languagetechnologyrequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageTechnologyRequest {

	private int programmingLanguageID;
	private String name;
}
