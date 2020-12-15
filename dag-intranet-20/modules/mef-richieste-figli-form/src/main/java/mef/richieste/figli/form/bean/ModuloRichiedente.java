package mef.richieste.figli.form.bean;

import java.io.File;

public class ModuloRichiedente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String iban;
	private String importo;
	private String tipoViaggio;
	private String numeroViaggi;
	private String dataAcquistoViaggio;
	private String descrizione;
	private String flagTipoSpesaFiglioPersonale; 
	private String nomeFiglio;
	private String cognomeFiglio;
	private String dataNascitaFiglio;
	private String luogoNascitaFiglio;
	private String cfFiglio;
	private File allegato;
	private String allegatoNome;
	private String allegatoMimeType;
	
	public ModuloRichiedente() {}

	public ModuloRichiedente(String iban, String importo, String tipoViaggio, String numeroViaggi,
			String dataAcquistoViaggio, String descrizione, String flagTipoSpesaFiglioPersonale, String nomeFiglio,
			String cognomeFiglio, String dataNascitaFiglio, String luogoNascitaFiglio, String cfFiglio, File allegato,
			String allegatoNome, String allegatoMimeType) {
		
		setIban(iban);
		setImporto(importo);
		setTipoViaggio(tipoViaggio);
		setNumeroViaggi(numeroViaggi);
		setDataAcquistoViaggio(dataAcquistoViaggio);
		setDescrizione(descrizione);
		setFlagTipoSpesaFiglioPersonale(flagTipoSpesaFiglioPersonale);
		setNomeFiglio(cognomeFiglio);
		setCognomeFiglio(cognomeFiglio);
		setDataNascitaFiglio(dataNascitaFiglio);
		setLuogoNascitaFiglio(luogoNascitaFiglio);
		setCfFiglio(cfFiglio);
		setAllegato(allegato);
		setAllegatoNome(allegatoNome);
		setAllegatoMimeType(allegatoMimeType);
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

	public String getDataAcquistoViaggio() {
		return dataAcquistoViaggio;
	}

	public void setDataAcquistoViaggio(String dataAcquistoViaggio) {
		this.dataAcquistoViaggio = dataAcquistoViaggio;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFlagTipoSpesaFiglioPersonale() {
		return flagTipoSpesaFiglioPersonale;
	}

	public void setFlagTipoSpesaFiglioPersonale(String flagTipoSpesaFiglioPersonale) {
		this.flagTipoSpesaFiglioPersonale = flagTipoSpesaFiglioPersonale;
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

	public String getLuogoNascitaFiglio() {
		return luogoNascitaFiglio;
	}

	public void setLuogoNascitaFiglio(String luogoNascitaFiglio) {
		this.luogoNascitaFiglio = luogoNascitaFiglio;
	}

	public String getCfFiglio() {
		return cfFiglio;
	}

	public void setCfFiglio(String cfFiglio) {
		this.cfFiglio = cfFiglio;
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

	@Override
	public String toString() {
		return "ModuloRichiedente [iban=" + iban + ", importo=" + importo + ", descrizione=" + descrizione
				+ ", nomeFiglio=" + nomeFiglio + ", cognomeFiglio=" + cognomeFiglio + ", dataNascitaFiglio="
				+ dataNascitaFiglio + ", luogoNascitaFiglio=" + luogoNascitaFiglio + ", cfFiglio=" + cfFiglio
				+ ", allegato=" + allegato + ", allegatoNome=" + allegatoNome + ", allegatoMimeType=" + allegatoMimeType
				+ "]";
	}

	

	

	
	

	

	
	
	
	
	

}
