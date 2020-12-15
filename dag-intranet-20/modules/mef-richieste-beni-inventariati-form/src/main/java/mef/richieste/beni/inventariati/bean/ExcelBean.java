package mef.richieste.beni.inventariati.bean;

public class ExcelBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String id_richiesta;
	private String nome_richiedente;
	private String cognome_richiedente;
	private String oggetto;
	private String data;
	private String stato;
	public String getId_richiesta() {
		return id_richiesta;
	}
	public void setId_richiesta(String id_richiesta) {
		this.id_richiesta = id_richiesta;
	}
	public String getNome_richiedente() {
		return nome_richiedente;
	}
	public void setNome_richiedente(String nome_richiedente) {
		this.nome_richiedente = nome_richiedente;
	}
	public String getCognome_richiedente() {
		return cognome_richiedente;
	}
	public void setCognome_richiedente(String cognome_richiedente) {
		this.cognome_richiedente = cognome_richiedente;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
