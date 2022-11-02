package kodlama.io.kodlamaIoDevs.entities.concretes;

public class ProgrammingLanguage {
	
	private int id;
	private String pLanguage ;
	
	public ProgrammingLanguage() {
	}

	public ProgrammingLanguage(int id, String pLanguage) {
		this.id = id;
		this.pLanguage = pLanguage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpLanguage() {
		return pLanguage;
	}

	public void setpLanguage(String pLanguage) {
		this.pLanguage = pLanguage;
	}
	
	
	
	

}
