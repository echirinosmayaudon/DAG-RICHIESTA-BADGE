package mef.prenotazione.aule.bean;

public class LaTuaPrenotazioneBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String nomeSalaRiunione;
	private String dataPrenotazione;
	private String postiInSala;
	private String indirizzo;
	private String stato;
	private String orario;
	private String idSala;
	private String idPrenotazione;
	private int idAutorizzazione;

	public int getIdAutorizzazione() {
		return idAutorizzazione;
	}

	public void setIdAutorizzazione(int idAutorizzazione) {
		this.idAutorizzazione = idAutorizzazione;
	}

	public String getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public String getIdSala() {
		return idSala;
	}

	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getNomeSalaRiunione() {
		return nomeSalaRiunione;
	}

	public void setNomeSalaRiunione(String nomeSalaRiunione) {
		this.nomeSalaRiunione = nomeSalaRiunione;
	}

	public String getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(String dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public String getPostiInSala() {
		return postiInSala;
	}

	public void setPostiInSala(String postiInSala) {
		this.postiInSala = postiInSala;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

}
