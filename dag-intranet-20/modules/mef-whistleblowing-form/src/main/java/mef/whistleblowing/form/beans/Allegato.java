package mef.whistleblowing.form.beans;

import java.io.File;

public class Allegato {

	private File allegato;
	private String allegatoNome;
	private String allegatoMimeType;
	
	
	@Override
	public String toString() {
		return "Allegato [allegato=" + allegato + ", allegatoNome=" + allegatoNome + ", allegatoMimeType="
				+ allegatoMimeType + "]";
	}
	public File getAllegato() {
		return allegato;
	}
	public void setAllegato(File allegato) {
		this.allegato = allegato;
	}
	public String getAllegatoNome() {
		return allegatoNome;
	}
	public void setAllegatoNome(String allegatoNome) {
		this.allegatoNome = allegatoNome;
	}
	public String getAllegatoMimeType() {
		return allegatoMimeType;
	}
	public void setAllegatoMimeType(String allegatoMimeType) {
		this.allegatoMimeType = allegatoMimeType;
	}
	
}
