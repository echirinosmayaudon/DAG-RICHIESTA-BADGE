package mef.prenotazione.aule.bean;

public class SalaBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String desc_sala;
	private String indirizzo;
	private String citta;
	private String cap;
	private String cod_prov;
	private String piano;
	private String stanza;
	private int posti;
	private boolean video_conferenza;
	private boolean proiettore;
	private boolean postazione_rete;
	private boolean autorizzazione;
	private String email_ref;

	public String getDesc_sala() {
		return desc_sala;
	}

	public void setDesc_sala(String desc_sala) {
		this.desc_sala = desc_sala;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCod_prov() {
		return cod_prov;
	}

	public void setCod_prov(String cod_prov) {
		this.cod_prov = cod_prov;
	}

	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	public String getStanza() {
		return stanza;
	}

	public void setStanza(String stanza) {
		this.stanza = stanza;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public boolean isVideo_conferenza() {
		return video_conferenza;
	}

	public void setVideo_conferenza(boolean video_conferenza) {
		this.video_conferenza = video_conferenza;
	}

	public boolean isProiettore() {
		return proiettore;
	}

	public void setProiettore(boolean proiettore) {
		this.proiettore = proiettore;
	}

	public boolean isPostazione_rete() {
		return postazione_rete;
	}

	public void setPostazione_rete(boolean postazione_rete) {
		this.postazione_rete = postazione_rete;
	}

	public boolean isAutorizzazione() {
		return autorizzazione;
	}

	public void setAutorizzazione(boolean autorizzazione) {
		this.autorizzazione = autorizzazione;
	}

	public String getEmail_ref() {
		return email_ref;
	}

	public void setEmail_ref(String email_ref) {
		this.email_ref = email_ref;
	}
}
