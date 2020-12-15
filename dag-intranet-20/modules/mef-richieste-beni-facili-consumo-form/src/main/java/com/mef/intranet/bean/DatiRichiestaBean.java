package com.mef.intranet.bean;

public class DatiRichiestaBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String stato;

	private String tipoBeni;
	
	private String oggetto;
	
	private String dataRichiesta;
	
	private String periodicita;
	
	private String descrizione;
	
	private String gruppo;
	
	private String sottoGruppo;

	private String materiale;

	private String quantita;
	
	private String materialeDescrizione;
	
	private String sottoGruppoDescrizione;
	
	private String gruppoDescrizione;
	
	private String periodicitaDescrizione;
	
	private String costoUnitario;
	
	private String costoTotale;
	
	private String numeroInventarioMacchina;
	
	private String inputValue;
	
	private String disponibilita;
	
	private String organizzazione;
	
    private String sedeDescrizione;
	
	private String sede;
	private String codiceGeco;
	
	public String getSedeDescrizione() {
		return sedeDescrizione;
	}
	public void setSedeDescrizione(String sedeDescrizione) {
		this.sedeDescrizione = sedeDescrizione;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public String getOrganizzazione() {
		return organizzazione;
	}
	public void setOrganizzazione(String organizzazione) {
		this.organizzazione = organizzazione;
	}
	public String getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(String disponibilita) {
		this.disponibilita = disponibilita;
	}
	public String getInputValue() {
		return inputValue;
	}
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public String getPeriodicitaDescrizione() {
		return periodicitaDescrizione;
	}
	public void setPeriodicitaDescrizione(String periodicitaDescrizione) {
		this.periodicitaDescrizione = periodicitaDescrizione;
	}
	
	public String getNumeroInventarioMacchina() {
		return numeroInventarioMacchina;
	}
	public void setNumeroInventarioMacchina(String numeroInventarioMacchina) {
		this.numeroInventarioMacchina = numeroInventarioMacchina;
	}
	public String getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(String costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public String getCostoTotale() {
		return costoTotale;
	}
	public void setCostoTotale(String costoTotale) {
		this.costoTotale = costoTotale;
	}
	
	public String getMaterialeDescrizione() {
		return materialeDescrizione;
	}
	public void setMaterialeDescrizione(String materialeDescrizione) {
		this.materialeDescrizione = materialeDescrizione;
	}
	public String getSottoGruppoDescrizione() {
		return sottoGruppoDescrizione;
	}
	public void setSottoGruppoDescrizione(String sottoGruppoDescrizione) {
		this.sottoGruppoDescrizione = sottoGruppoDescrizione;
	}
	public String getGruppoDescrizione() {
		return gruppoDescrizione;
	}
	public void setGruppoDescrizione(String gruppoDescrizione) {
		this.gruppoDescrizione = gruppoDescrizione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipoBeni() {
		return tipoBeni;
	}
	public void setTipoBeni(String tipoBeni) {
		this.tipoBeni = tipoBeni;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getDataRichiesta() {
		return dataRichiesta;
	}
	public void setDataRichiesta(String dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	public String getPeriodicita() {
		return periodicita;
	}
	public void setPeriodicita(String periodicita) {
		this.periodicita = periodicita;
	}
	public String getGruppo() {
		return gruppo;
	}
	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}
	public String getSottoGruppo() {
		return sottoGruppo;
	}
	public void setSottoGruppo(String sottoGruppo) {
		this.sottoGruppo = sottoGruppo;
	}
	public String getMateriale() {
		return materiale;
	}
	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
	public String getQuantita() {
		return quantita;
	}
	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}

	public String getCodiceGeco() {
		return codiceGeco;
	}
	public void setCodiceGeco(String codiceGeco) {
		this.codiceGeco = codiceGeco;
	}
	public String toJSON(){
	return "{\"gruppo\"  : \"" + this.gruppo + "\" ,\"sottoGruppo\":\"" 
	+ this.sottoGruppo + "\" ,\"materiale\":\"" 
	+ this.materiale + "\" ,\"quantita\":\"" 
	+ this.quantita + "\" ,\"gruppoDescrizione\":\"" 
	+ this.gruppoDescrizione + "\" ,\"sottoGruppoDescrizione\":\"" 
	+ this.sottoGruppoDescrizione + "\" ,\"materialeDescrizione\":\"" 
	+ this.materialeDescrizione + "\" ,\"costoUnitario\":\"" 
	+ this.costoUnitario + "\" ,\"costoTotale\":\"" 
	+ this.costoTotale + "\"}";
	}

	

}
