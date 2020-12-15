package mef.richieste.interventi.beans;

public class RichiestaInterventiBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String modello;
	private String marca;
	private String tipologiaHardware;
	private String assetPc;
	private String descrizione;
    private String tipoAttivita;
	private String codiceFiscale;
	private String DiReteAssetStampante;
	private String localAssetPc;
	private String marcaModelloNumeroSerie;
	private String marcaModelloNumeroSerieHw;
	private String ubicazione;
	private String creazioneCartella;
	private String condivisioneCartella;
	private String abilitareUtenteLettura;
	private String abilitareUtenteScrittura;
	private String spostamentoApparecchiatura;
	private String ritiroApparecchiatura;
	private String abilitazionePresaRete;
		
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getTipologiaHardware() {
		return tipologiaHardware;
	}
	public void setTipologiaHardware(String tipologiaHardware) {
		this.tipologiaHardware = tipologiaHardware;
	}
	
	public String getAssetPc() {
		return assetPc;
	}
	public void setAssetPc(String assetPc) {
		this.assetPc = assetPc;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getTipoAttivita() {
		return tipoAttivita;
	}
	public void setTipoAttivita(String tipoAttivita) {
		this.tipoAttivita = tipoAttivita;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getDiReteAssetStampante() {
		return DiReteAssetStampante;
	}
	public void setDiReteAssetStampante(String diReteAssetStampante) {
		DiReteAssetStampante = diReteAssetStampante;
	}
	
	public String getLocalAssetPc() {
		return localAssetPc;
	}
	public void setLocalAssetPc(String localAssetPc) {
		this.localAssetPc = localAssetPc;
	}
	
	public String getMarcaModelloNumeroSerie() {
		return marcaModelloNumeroSerie;
	}
	public void setMarcaModelloNumeroSerie(String marcaModelloNumeroSerie) {
		this.marcaModelloNumeroSerie = marcaModelloNumeroSerie;
	}
	
	public String getUbicazione() {
		return ubicazione;
	}
	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}
	public String getCreazioneCartella() {
		return creazioneCartella;
	}
	
	public void setCreazioneCartella(String creazioneCartella) {
		this.creazioneCartella = creazioneCartella;
	}
	public String getCondivisioneCartella() {
		return condivisioneCartella;
	}
	
	public void setCondivisioneCartella(String condivisioneCartella) {
		this.condivisioneCartella = condivisioneCartella;
	}
	
	public String getAbilitareUtenteLettura() {
		return abilitareUtenteLettura;
	}
	public void setAbilitareUtenteLettura(String abilitareUtenteLettura) {
		this.abilitareUtenteLettura = abilitareUtenteLettura;
	}
	
	public String getAbilitareUtenteScrittura() {
		return abilitareUtenteScrittura;
	}
	public void setAbilitareUtenteScrittura(String abilitareUtenteScrittura) {
		this.abilitareUtenteScrittura = abilitareUtenteScrittura;
	}
	
	public String getSpostamentoApparecchiatura() {
		return spostamentoApparecchiatura;
	}
	public void setSpostamentoApparecchiatura(String spostamentoApparecchiatura) {
		this.spostamentoApparecchiatura = spostamentoApparecchiatura;
	}
	
	public String getRitiroApparecchiatura() {
		return ritiroApparecchiatura;
	}
	public void setRitiroApparecchiatura(String ritiroApparecchiatura) {
		this.ritiroApparecchiatura = ritiroApparecchiatura;
	}
	public String getAbilitazionePresaRete() {
		return abilitazionePresaRete;
	}
	public void setAbilitazionePresaRete(String abilitazionePresaRete) {
		this.abilitazionePresaRete = abilitazionePresaRete;
	}
	
	public String getMarcaModelloNumeroSerieHw() {
		return marcaModelloNumeroSerieHw;
	}
	public void setMarcaModelloNumeroSerieHw(String marcaModelloNumeroSerieHw) {
		this.marcaModelloNumeroSerieHw = marcaModelloNumeroSerieHw;
	}
	
}
