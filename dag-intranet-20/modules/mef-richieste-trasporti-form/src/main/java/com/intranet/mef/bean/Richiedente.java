package com.intranet.mef.bean;

public class Richiedente implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String provinciaNascita;
	private String dataNascita;
	private String luogoNascita;
	private String indirizzo;
	private String citta;
	private String cap;
	private String provincia;
	private String dipartimento;
	private String comandato; //MEF, OTHER, SERVIZIO
	private String servizioDal;
	private String fasciaEconomica;
	private String mail;
	private String telefono;

	
	public String getComandato() {
		return comandato;
	}
	public void setComandato(String comandato) {
		this.comandato = comandato;
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
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getProvinciaNascita() {
		return provinciaNascita;
	}
	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public String getServizioDal() {
		return servizioDal;
	}
	public void setServizioDal(String servizioDal) {
		this.servizioDal = servizioDal;
	}
	public String getFasciaEconomica() {
		return fasciaEconomica;
	}
	public void setFasciaEconomica(String fasciaEconomica) {
		this.fasciaEconomica = fasciaEconomica;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean allInfo(){

		return !(("").equals(this.nome) || ("").equals(this.codiceFiscale) || ("").equals(this.cognome) || ("").equals(this.dataNascita) 
			|| ("").equals(this.luogoNascita) || ("").equals(this.indirizzo) || ("").equals(this.citta) || ("").equals(this.cap) 
			|| ("").equals(this.provincia) || ("").equals(this.dipartimento) 
			|| (("OTHER").equals(this.comandato) && ("").equals(this.servizioDal))
			|| ("").equals(this.fasciaEconomica) || ("").equals(this.mail) || ("").equals(this.telefono));
	}
	
}
