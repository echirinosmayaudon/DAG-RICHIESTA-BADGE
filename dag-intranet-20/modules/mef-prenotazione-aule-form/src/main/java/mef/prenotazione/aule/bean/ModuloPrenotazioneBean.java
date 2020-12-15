package mef.prenotazione.aule.bean;

import java.util.ArrayList;
import java.util.List;

import servizio.prenotazione.aule.mef.model.Orario;
import servizio.prenotazione.aule.mef.model.Sala;
import servizio.prenotazione.aule.mef.model.ServizioLog;
import servizio.prenotazione.aule.mef.model.StrumentoEvento;
import servizio.prenotazione.aule.mef.model.StrumentoTec;
import servizio.prenotazione.aule.mef.model.TipoEvento;

public class ModuloPrenotazioneBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String dataDiPrenotazione;
	private String sala;
	private String idSala;
	private String data;
	private String oraInizio;
	private String oraFine;
	private String numeroPartecipanti;
	private String attivita_OggettoPrenotazione;
	private String note;
	private String ufficioRichiedente;
	private String dirigenteUfficio;
	private String utenteRichiedente;
	private String telefonoRichiedente;
	private String utenteReferente;
	private String telefonoReferente;
	private String idPrenotazione;
	private List<Sala> listSala = new ArrayList<Sala>(0);
	private List<Long> strumentazioneTecnicaId = new ArrayList<Long>(0);
	private List<TipoEvento> tipologiaEvento = new ArrayList<TipoEvento>(0);
	private List<String> utilizzatoreSala = new ArrayList<String>(0);
	private List<StrumentoTec> strumentazioneTecnica = new ArrayList<StrumentoTec>(0);
	private List<StrumentoEvento> strumentazioneEventi = new ArrayList<StrumentoEvento>(0);
	private List<ServizioLog> servizioLogistici = new ArrayList<ServizioLog>(0);
	private List<OrarioBean> Orari = new ArrayList<OrarioBean>(0);

	public List<Sala> getListSala() {
		return listSala;
	}

	public void setListSala(List<Sala> listSala) {
		this.listSala = listSala;
	}

	public String getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}

	public String getOraFine() {
		return oraFine;
	}

	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}

	public String getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public List<Long> getStrumentazioneTecnicaId() {
		return strumentazioneTecnicaId;
	}

	public void setStrumentazioneTecnicaId(List<Long> strumentazioneTecnicaId) {
		this.strumentazioneTecnicaId = strumentazioneTecnicaId;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getAttivita_OggettoPrenotazione() {
		return attivita_OggettoPrenotazione;
	}

	public void setAttivita_OggettoPrenotazione(String attivita_OggettoPrenotazione) {
		this.attivita_OggettoPrenotazione = attivita_OggettoPrenotazione;
	}

	public String getIdSala() {
		return idSala;
	}

	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}

	public List<OrarioBean> getOrari() {
		return Orari;
	}

	public void setOrari(List<OrarioBean> orari) {
		Orari = orari;
	}

	public List<TipoEvento> getTipologiaEvento() {
		return tipologiaEvento;
	}

	public void setTipologiaEvento(List<TipoEvento> tipologiaEvento) {
		this.tipologiaEvento = tipologiaEvento;
	}

	public List<String> getUtilizzatoreSala() {
		return utilizzatoreSala;
	}

	public void setUtilizzatoreSala(List<String> utilizzatoreSala) {
		this.utilizzatoreSala = utilizzatoreSala;
	}

	public List<StrumentoTec> getStrumentazioneTecnica() {
		return strumentazioneTecnica;
	}

	public void setStrumentazioneTecnica(List<StrumentoTec> strumentazioneTecnica) {
		this.strumentazioneTecnica = strumentazioneTecnica;
	}

	public List<StrumentoEvento> getStrumentazioneEventi() {
		return strumentazioneEventi;
	}

	public void setStrumentazioneEventi(List<StrumentoEvento> strumentazioneEventi) {
		this.strumentazioneEventi = strumentazioneEventi;
	}

	public List<ServizioLog> getServizioLogistici() {
		return servizioLogistici;
	}

	public void setServizioLogistici(List<ServizioLog> servizioLogistici) {
		this.servizioLogistici = servizioLogistici;
	}

	public String getDataDiPrenotazione() {
		return dataDiPrenotazione;
	}

	public void setDataDiPrenotazione(String dataDiPrenotazione) {
		this.dataDiPrenotazione = dataDiPrenotazione;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNumeroPartecipanti() {
		return numeroPartecipanti;
	}

	public void setNumeroPartecipanti(String numeroPartecipanti) {
		this.numeroPartecipanti = numeroPartecipanti;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUfficioRichiedente() {
		return ufficioRichiedente;
	}

	public void setUfficioRichiedente(String ufficioRichiedente) {
		this.ufficioRichiedente = ufficioRichiedente;
	}

	public String getDirigenteUfficio() {
		return dirigenteUfficio;
	}

	public void setDirigenteUfficio(String dirigenteUfficio) {
		this.dirigenteUfficio = dirigenteUfficio;
	}

	public String getUtenteRichiedente() {
		return utenteRichiedente;
	}

	public void setUtenteRichiedente(String utenteRichiedente) {
		this.utenteRichiedente = utenteRichiedente;
	}

	public String getTelefonoRichiedente() {
		return telefonoRichiedente;
	}

	public void setTelefonoRichiedente(String telefonoRichiedente) {
		this.telefonoRichiedente = telefonoRichiedente;
	}

	public String getUtenteReferente() {
		return utenteReferente;
	}

	public void setUtenteReferente(String utenteReferente) {
		this.utenteReferente = utenteReferente;
	}

	public String getTelefonoReferente() {
		return telefonoReferente;
	}

	public void setTelefonoReferente(String telefonoReferente) {
		this.telefonoReferente = telefonoReferente;
	}
}
