package mef.richieste.badge.bean;

import java.io.Serializable;

public class Richiedente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String direzione;
	private String ufficioRichiedente;
	private String nome;
	private String cognome;
	private String ubicazione;
	private String palazzina;
	private String piano;
	private String scala;
	private String stanza;
	private String telefono;
	private String emailDirigente;
	private String codiceFiscale;
	private String email;
	private String dipartimento;

	public String toJSON(){
		
	return "{\"ufficioRichiedente\"  : \"" + this.ufficioRichiedente + "\" ,\"nome\":\""+this.nome+"\",\"cognome\"  : \"" 
+ this.cognome + "\",\"ubicazione\"  : \"" + this.ubicazione+ "\" ,\"palazzina\":\""+this.palazzina + "\" ,\"piano\":\""+this.piano
+ "\" ,\"scala\":\""+this.scala+ "\" ,\"stanza\":\""+this.stanza+ "\" ,\"telefono\":\""+this.telefono+ "\" ,\"emailDirigente\":\""+this.emailDirigente
+ "\",\"codiceFiscale\":\""+this.codiceFiscale+ "\" ,\"email\":\""+this.email+ "\" ,\"dipartimento\":\""+this.dipartimento+ "\" }";
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getDirezione() {
		return direzione;
	}

	public void setDirezione(String direzione) {
		this.direzione = direzione;
	}

	public String getUfficioRichiedente() {
		return ufficioRichiedente;
	}

	public void setUfficioRichiedente(String ufficioRichiedente) {
		this.ufficioRichiedente = ufficioRichiedente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

	public String getPalazzina() {
		return palazzina;
	}

	public void setPalazzina(String palazzina) {
		this.palazzina = palazzina;
	}

	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	public String getScala() {
		return scala;
	}

	public void setScala(String scala) {
		this.scala = scala;
	}

	public String getStanza() {
		return stanza;
	}

	public void setStanza(String stanza) {
		this.stanza = stanza;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmailDirigente() {
		return emailDirigente;
	}

	public void setEmailDirigente(String emailDirigente) {
		this.emailDirigente = emailDirigente;
	}

    public String getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}
    
}
