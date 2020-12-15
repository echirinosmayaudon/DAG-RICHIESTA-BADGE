package com.mef.intranet.bean;

public class Richiedente implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String ufficioRichiedente;
	private String organizzazione;
	private String nome;
	private String cognome;
	private String emailRichiedente;
	private String ubicazione;
	private String palazzina ;
	private String piano;
	private String scala ;
	private String stanza ;
	private String telefono;
	private String emailDirigente; 
	private String nomeDirigente;
	private String telefonoDirigente;
	private String sede;
	private String sedeDescrizione;

	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getSedeDescrizione() {
		return sedeDescrizione;
	}
	public void setSedeDescrizione(String sedeDescrizione) {
		this.sedeDescrizione = sedeDescrizione;
	}
	
	public String getUfficioRichiedente() {
		return ufficioRichiedente;
	}
	public void setUfficioRichiedente(String ufficioRichiedente) {
		this.ufficioRichiedente = ufficioRichiedente;
	}
	public String getOrganizzazione() {
		return organizzazione;
	}
	public void setOrganizzazione(String organizzazione) {
		this.organizzazione = organizzazione;
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
	public String getEmailRichiedente() {
		return emailRichiedente;
	}
	public void setEmailRichiedente(String emailRichiedente) {
		this.emailRichiedente = emailRichiedente;
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
	
	public String getNomeDirigente() {
		return nomeDirigente;
	}
	public void setNomeDirigente(String nomeDirigente) {
		this.nomeDirigente = nomeDirigente;
	}
	public String getTelefonoDirigente() {
		return telefonoDirigente;
	}
	public void setTelefonoDirigente(String telefonoDirigente) {
		this.telefonoDirigente = telefonoDirigente;
	}
	public String toJSON(){	

		return "{\"ubicazione\"  : \"" + this.ubicazione+ "\" ,\"palazzina\":\""+this.palazzina + "\" ,\"piano\":\""+this.piano
				+ "\" ,\"scala\":\""+this.scala+ "\" ,\"stanza\":\""+this.stanza+ "\"}";
	}
}
