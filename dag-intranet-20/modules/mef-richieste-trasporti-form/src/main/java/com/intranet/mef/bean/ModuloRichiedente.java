package com.intranet.mef.bean;

import java.io.File;

public class ModuloRichiedente implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String iban;
	private String importo;
	private String tipoViaggio;
	private String numeroViaggi;
	private String dataAcquistoViaggio;
	private String descrizione;
	private String flagTipoSpesa; //figlio/personale
	private String nomeFiglio;
	private String cognomeFiglio;
	private String dataNascitaFiglio;
	private String luogoNascitaFiglio;
	private String cfFiglio;
	
	private File allegato;
	private String allegatoNome;
	private String allegatoMimeType;
	
	
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
	public String getLuogoNascitaFiglio() {
		return luogoNascitaFiglio;
	}
	public void setLuogoNascitaFiglio(String luogoNascitaFiglio) {
		this.luogoNascitaFiglio = luogoNascitaFiglio;
	}
	public String getDataAcquistoViaggio() {
		return dataAcquistoViaggio;
	}
	public void setDataAcquistoViaggio(String dataAcquistoViaggio) {
		this.dataAcquistoViaggio = dataAcquistoViaggio;
	}
	public File getAllegato() {
		return allegato;
	}
	public void setAllegato(File allegato) {
		this.allegato = allegato;
	}
	public String getCfFiglio() {
		return cfFiglio;
	}
	public void setCfFiglio(String cfFiglio) {
		this.cfFiglio = cfFiglio;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
	}
	public String getTipoViaggio() {
		return tipoViaggio;
	}
	public void setTipoViaggio(String tipoViaggio) {
		this.tipoViaggio = tipoViaggio;
	}
	public String getNumeroViaggi() {
		return numeroViaggi;
	}
	public void setNumeroViaggi(String numeroViaggi) {
		this.numeroViaggi = numeroViaggi;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFlagTipoSpesa() {
		return flagTipoSpesa;
	}
	public void setFlagTipoSpesa(String flagTipoSpesa) {
		this.flagTipoSpesa = flagTipoSpesa;
	}
	public String getNomeFiglio() {
		return nomeFiglio;
	}
	public void setNomeFiglio(String nomeFiglio) {
		this.nomeFiglio = nomeFiglio;
	}
	public String getCognomeFiglio() {
		return cognomeFiglio;
	}
	public void setCognomeFiglio(String cognomeFiglio) {
		this.cognomeFiglio = cognomeFiglio;
	}
	public String getDataNascitaFiglio() {
		return dataNascitaFiglio;
	}
	public void setDataNascitaFiglio(String dataNascitaFiglio) {
		this.dataNascitaFiglio = dataNascitaFiglio;
	}


}
