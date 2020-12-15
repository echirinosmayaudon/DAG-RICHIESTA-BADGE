package mef.whistleblowing.form.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Segnalazione implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String ufficio;
	private String ufficio_esterno;
	
	private List<String> check;
	private String altro;
	
	private String descrizione;
	private String autore;
	private String altri_soggetti;
	
	private List<Allegato> allegati;

	
	@Override
	public String toString() {
		return "Segnalazione [ufficio=" + ufficio + ", ufficio_esterno="
				+ ufficio_esterno + ", check=" + check + ", altro=" + altro + ", descrizione=" + descrizione
				+ ", autore=" + autore + ", altri_soggetti=" + altri_soggetti + ", allegati=" + allegati + "]";
	}

	public String getUfficio() {
		return ufficio;
	}

	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

	public String getUfficio_esterno() {
		return ufficio_esterno;
	}

	public void setUfficio_esterno(String ufficio_esterno) {
		this.ufficio_esterno = ufficio_esterno;
	}

	public List<String> getCheck() {
		return check;
	}

	public void setCheck(List<String> check) {
		this.check = check;
	}

	public String getAltro() {
		return altro;
	}

	public void setAltro(String altro) {
		this.altro = altro;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getAltri_soggetti() {
		return altri_soggetti;
	}

	public void setAltri_soggetti(String altri_soggetti) {
		this.altri_soggetti = altri_soggetti;
	}

	public List<Allegato> getAllegati() {
		return allegati;
	}

	public void setAllegati(List<Allegato> allegati) {
		this.allegati = allegati;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
