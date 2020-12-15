package mef.richieste.badge.bean;

import java.io.File;
//import java.io.IOException;
import java.io.Serializable;

//import org.apache.commons.io.FileUtils;

public class ModuloRichiedente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long   id_richiesta;
	private String stato;
	private String tipo;
	private String dipartimento;
	private String direzione;
	private String ufficio;
	private String referenteMef;
	private String telReferente;
	private String emailReferente;
	private String cognome;
	private String nome;
	private String luogoNascita;
	private String dataNascita;
	private String codiceFiscale;
	private String societa;
	private String sedelegaleSocieta;
	private String indirizzoSocieta;
	private String telSocieta;
	private String faxSocieta;
	private String pecSocieta;
	private String emailSocieta;
	private String refSocieta;
	private String emailRefSocieta;
	private String telUfficioRefSocieta;
	private String cellRefSocieta;
	private String contratto;
	private String progetto;
	private String piano;
	private String postazione;
	private String sediAbilitate;
	private String dataScadenza;
	private String motivazione;
	private String oggettoRichiestaId;
	private String oggettoRichiestaDescrizione;
	private String numeroBadge;
	
	private File allegato;
	private String allegatoNome;
	private String allegatoMimeType;
	
	private File allegatoGenerato;
	private String allegatoNomeGenerato;
	private String allegatoMimeTypeGenerato;
	
	private File allegatoOpzionale;
	private String allegatoNomeOpzionale;
	private String allegatoMimeTypeOpzionale;
	
	private String note;
	
	private String sedePostazione;
	private String pianoPostazione;
	private String corridoioPostazione;
	private String fuoriPortaPostazione;
	
	public String getSedePostazione() {
		return sedePostazione;
	}
	public String getPianoPostazione() {
		return pianoPostazione;
	}
	public String getCorridoioPostazione() {
		return corridoioPostazione;
	}
	public String getFuoriPortaPostazione() {
		return fuoriPortaPostazione;
	}
	public void setSedePostazione(String sedePostazione) {
		this.sedePostazione = sedePostazione;
	}
	public void setPianoPostazione(String pianoPostazione) {
		this.pianoPostazione = pianoPostazione;
	}
	public void setCorridoioPostazione(String corridoioPostazione) {
		this.corridoioPostazione = corridoioPostazione;
	}
	public void setFuoriPortaPostazione(String fuoriPortaPostazione) {
		this.fuoriPortaPostazione = fuoriPortaPostazione;
	}
	
	public Long getId_richiesta() {
		return id_richiesta;
	}
	public void setId_richiesta(Long id_richiesta) {
		this.id_richiesta = id_richiesta;
	}
	public File getAllegatoGenerato() {
		return allegatoGenerato;
	}
	public void setAllegatoGenerato(File allegatoGenerato) {
		this.allegatoGenerato = allegatoGenerato;
	}
	public String getAllegatoNomeGenerato() {
		return allegatoNomeGenerato;
	}
	public void setAllegatoNomeGenerato(String allegatoNomeGenerato) {
		this.allegatoNomeGenerato = allegatoNomeGenerato;
	}
	public String getAllegatoMimeTypeGenerato() {
		return allegatoMimeTypeGenerato;
	}
	public void setAllegatoMimeTypeGenerato(String allegatoMimeTypeGenerato) {
		this.allegatoMimeTypeGenerato = allegatoMimeTypeGenerato;
	}
	public File getAllegatoOpzionale() {
		return allegatoOpzionale;
	}
	public void setAllegatoOpzionale(File allegatoOpzionale) {
		this.allegatoOpzionale = allegatoOpzionale;
	}
	public String getAllegatoNomeOpzionale() {
		return allegatoNomeOpzionale;
	}
	public void setAllegatoNomeOpzionale(String allegatoNomeOpzionale) {
		this.allegatoNomeOpzionale = allegatoNomeOpzionale;
	}
	public String getAllegatoMimeTypeOpzionale() {
		return allegatoMimeTypeOpzionale;
	}
	public void setAllegatoMimeTypeOpzionale(String allegatoMimeTypeOpzionale) {
		this.allegatoMimeTypeOpzionale = allegatoMimeTypeOpzionale;
	}
	
//	public String getDataDisattivazione() {
//		return dataDisattivazione;
//	}
//	public void setDataDisattivazione(String dataDisattivazione) {
//		this.dataDisattivazione = dataDisattivazione;
//	}
//	public String getTab() {
//		return tab;
//	}
//	public void setTab(String tab) {
//		this.tab = tab;
//	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNumeroBadge() {
		return numeroBadge;
	}
	public void setNumeroBadge(String numeroBadge) {
		this.numeroBadge = numeroBadge;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}
	public String getDirezione() {
		return direzione;
	}
	public void setDirezione(String direzione) {
		this.direzione = direzione;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getReferenteMef() {
		return referenteMef;
	}
	public void setReferenteMef(String referenteMef) {
		this.referenteMef = referenteMef;
	}
	public String getTelReferente() {
		return telReferente;
	}
	public void setTelReferente(String telReferente) {
		this.telReferente = telReferente;
	}
	public String getEmailReferente() {
		return emailReferente;
	}
	public void setEmailReferente(String emailReferente) {
		this.emailReferente = emailReferente;
	}
	public String getSocieta() {
		return societa;
	}
	public void setSocieta(String societa) {
		this.societa = societa;
	}
	public String getSedelegaleSocieta() {
		return sedelegaleSocieta;
	}
	public void setSedelegaleSocieta(String sedelegaleSocieta) {
		this.sedelegaleSocieta = sedelegaleSocieta;
	}
	public String getIndirizzoSocieta() {
		return indirizzoSocieta;
	}
	public void setIndirizzoSocieta(String indirizzoSocieta) {
		this.indirizzoSocieta = indirizzoSocieta;
	}
	public String getTelSocieta() {
		return telSocieta;
	}
	public void setTelSocieta(String telSocieta) {
		this.telSocieta = telSocieta;
	}
	public String getFaxSocieta() {
		return faxSocieta;
	}
	public void setFaxSocieta(String faxSocieta) {
		this.faxSocieta = faxSocieta;
	}
	public String getPecSocieta() {
		return pecSocieta;
	}
	public void setPecSocieta(String pecSocieta) {
		this.pecSocieta = pecSocieta;
	}
	public String getEmailSocieta() {
		return emailSocieta;
	}
	public void setEmailSocieta(String emailSocieta) {
		this.emailSocieta = emailSocieta;
	}
	public String getRefSocieta() {
		return refSocieta;
	}
	public void setRefSocieta(String refSocieta) {
		this.refSocieta = refSocieta;
	}
	public String getEmailRefSocieta() {
		return emailRefSocieta;
	}
	public void setEmailRefSocieta(String emailRefSocieta) {
		this.emailRefSocieta = emailRefSocieta;
	}
	public String getTelUfficioRefSocieta() {
		return telUfficioRefSocieta;
	}
	public void setTelUfficioRefSocieta(String telUfficioRefSocieta) {
		this.telUfficioRefSocieta = telUfficioRefSocieta;
	}
	public String getCellRefSocieta() {
		return cellRefSocieta;
	}
	public void setCellRefSocieta(String cellRefSocieta) {
		this.cellRefSocieta = cellRefSocieta;
	}
	public String getContratto() {
		return contratto;
	}
	public void setContratto(String contratto) {
		this.contratto = contratto;
	}
	public String getProgetto() {
		return progetto;
	}
	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}
	public String getPiano() {
		return piano;
	}
	public void setPiano(String piano) {
		this.piano = piano;
	}
	public String getPostazione() {
		return postazione;
	}
	public void setPostazione(String postazione) {
		this.postazione = postazione;
	}
	public String getSediAbilitate() {
		return sediAbilitate;
	}
	public void setSediAbilitate(String sediAbilitate) {
		this.sediAbilitate = sediAbilitate;
	}
	public String getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public String getMotivazione() {
		return motivazione;
	}
	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getOggettoRichiestaId() {
		return oggettoRichiestaId;
	}
	public void setOggettoRichiestaId(String oggettoRichiestaId) {
		this.oggettoRichiestaId = oggettoRichiestaId;
	}
	public String getOggettoRichiestaDescrizione() {
		return oggettoRichiestaDescrizione;
	}
	public void setOggettoRichiestaDescrizione(String oggettoRichiestaDescrizione) {
		this.oggettoRichiestaDescrizione = oggettoRichiestaDescrizione;
	}
	
	

}
