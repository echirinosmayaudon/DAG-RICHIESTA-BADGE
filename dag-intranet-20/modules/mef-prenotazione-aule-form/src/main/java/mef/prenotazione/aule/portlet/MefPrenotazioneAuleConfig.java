package mef.prenotazione.aule.portlet;

import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "mef.prenotazione.aule.portlet.MefPrenotazioneAuleConfig")
public interface MefPrenotazioneAuleConfig {
	
	@Meta.AD(deflt = "MEF prenotazione aule", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Nuova prenotazione aula", required = false)
	public String subjectNoApprovazione();
	
	@Meta.AD(deflt = "Richiesta di prenotazione aula in attesa di approvazione", required = false)
	public String subjectApprovazione();
	
	@Meta.AD(deflt = "Prenotazione aula autorizzata", required = false)
	public String subjectPrenotazioneAutorizzata();
	
	@Meta.AD(deflt = "Prenotazione aula rifiutata", required = false)
	public String subjectPrenotazioneRifiutata();
	
	@Meta.AD(deflt = "Prenotazione aula modificata", required = false)
	public String subjectPrenotazioneModificata();
	
	@Meta.AD(deflt = "Prenotazione aula eliminata", required = false)
	public String subjectPrenotazioneEliminata();
	
	@Meta.AD(deflt = "<h1>Nuova prenotazione aula</h1><br/><p>Nuova prenotazione aula da parte di: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo della prenotazione:</font></p><br/>[$DATI$]<br/><p> LINK al dettaglio </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO DELLA NUOVA PRENOTAZIONE </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String richiestaNoApprovazioneTmpl();
	
	@Meta.AD(deflt = "<h1>La richiesta di prenotazione aula &egrave; stata inoltrata ed &egrave; in attesa di approvazione</h1><br/><p>Nuova richiesta di prenotazione aula da parte di: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo della richiesta di prenotazione:</font></p><br/>[$DATI$]<br/><p> LINK al dettaglio </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO DELLA NUOVA RICHIESTA DI PRENOTAZIONE </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String richiestaApprovazioneTmpl();
	
	@Meta.AD(deflt = "<h1>Conferma di approvazione della richiesta di prenotazione aula</h1><br/><p>Prenotazione aula da parte di:</p><br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo della prenotazione:</font></p><br/>[$DATI$]<br/><p> LINK al dettaglio </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO DELLA PRENOTAZIONE APPROVATA </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String prenotazioneAutorizzataTmpl();
	
	@Meta.AD(deflt = "<h1>La prenotazione della sala &egrave; stata rifiutata</h1><br/><p>Richiesta di prenotazione aula da parte di:</p><br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo della richiesta di prenotazione:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String prenotazioneRifiutataTmpl();
	
	@Meta.AD(deflt = "<h1>La prenotazione della sala &egrave; stata aggiornata</h1><br/><p>Prenotazione aula da parte di:</p><br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo della prenotazione:</font></p><br/>[$DATI$]<br/><p> LINK al dettaglio </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO DELLA PRENOTAZIONE AGGIORNATA </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String prenotazioneModificataTmpl();
	
	@Meta.AD(deflt = "<h1>La prenotazione della sala &egrave; stata eliminata</h1><br/><p>Prenotazione aula da parte di:</p><br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo della prenotazione:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String prenotazioneEliminataTmpl();
	
	@Meta.AD(deflt = "testo per il titolo di prenota aule", required = false)
	public String formTitleInsertPrenotazioni();
	
	@Meta.AD(deflt = "testo per il sottotitolo di prenota aule", required = false)
	public String formSubtitleInsertPrenotazioni();

	@Meta.AD(deflt = "testo per il titolo de le tue prenotazioni", required = false)
	public String formTitleLeTuePrenotazioni();
	
	@Meta.AD(deflt = "testo per il sottotitolo de le tue prenotazioni", required = false)
	public String formSubtitleLeTuePrenotazioni();
	
	@Meta.AD(deflt = "testo per il titolo di ricerca aule", required = false)
	public String formTitleRicercaAule();
	
	@Meta.AD(deflt = "testo per il sottotitolo di ricerca aule", required = false)
	public String formSubtitleRicercaAule();
	
	@Meta.AD(deflt = "testo per il titolo di le tue prenotazioni per approvatore", required = false)
	public String formTitleRicercaAuleApprovatore();
	
	@Meta.AD(deflt = "testo per il sottotitolo di le tue prenotazioni per approvatore", required = false)
	public String formSubtitleRicercaAuleApprovatore();


}
