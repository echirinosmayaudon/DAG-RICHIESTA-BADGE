package modulistica.mef.beans;

import java.util.List;

public class Module_bean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String titolo;
	private String descrizione;
	private List<String> categorie;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<String> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<String> categorie) {
		this.categorie = categorie;
	}
	
	
	
		
	
	
	
	
}
