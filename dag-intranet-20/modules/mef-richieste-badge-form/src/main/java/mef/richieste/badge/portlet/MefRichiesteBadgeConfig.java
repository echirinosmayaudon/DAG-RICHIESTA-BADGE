package mef.richieste.badge.portlet;
import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "mef.richieste.badge.portlet.MefRichiesteBadgeConfig")

public interface MefRichiesteBadgeConfig {
	
	@Meta.AD(deflt = "SERVIZIO RICHIESTA BADGE", required = false)
	public String formTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di Servizio Richiesta Badge", required = false)
	public String formSubtitle();
	
	@Meta.AD(deflt = "GESTIONE UTENTI BADGE", required = false)
	public String gestioneUtentiTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di Gestione Utenti Badge", required = false)
	public String gestioneUtentiSubtitle();
	
	@Meta.AD(deflt = "SERVIZIO PROROGA BADGE", required = false)
	public String servizioProrogaTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del Servizio Proroga Badge", required = false)
	public String servizioProrogaSubtitle();
	
	@Meta.AD(deflt = "RIEPILOGO PROROGA BADGE", required = false)
	public String riepilogoProrogaTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del Riepilogo Proroga Badge", required = false)
	public String riepilogoProrogaSubtitle();
	
	@Meta.AD(deflt = "RICERCA RICHIESTA BADGE", required = false)
	public String ricercaTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di Ricerca Richiesta Badge", required = false)
	public String ricercaSubtitle();
	
	@Meta.AD(deflt = "MEF richiesta badge", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Nuova Richiesta Badge online n. [$IDRICHIESTA$]", required = false)
	public String subjectNuova();
	
	@Meta.AD(deflt = "Richiesta di modifica Badge online n. [$IDRICHIESTA$]", required = false)
	public String subjectRichiediModifica();
	
	@Meta.AD(deflt = "Modifica della Richiesta Badge online n. [$IDRICHIESTA$]", required = false)
	public String subjectModifica();
	
	@Meta.AD(deflt = "Approvazione della Richiesta Badge online n. [$IDRICHIESTA$]", required = false)
	public String subjectApprovazione();
	
	@Meta.AD(deflt = "Rifiuto della Richiesta Badge online n. [$IDRICHIESTA$]", required = false)
	public String subjectRifiuta();
	
	@Meta.AD(deflt = "", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "<h2>Riepilogo della Richiesta: [$OGGETTO$]</h2><br/> <p> Di seguito vengono riportati i dettagli della Richiesta Badge in oggetto: <br/> [$DATI$] <br/><br/> <p> Portale Intranet MEF </p> <br/>", required = false)
	public String richiestaTmpl();
	
	@Meta.AD(deflt = "6", required = false)
	public int itemsPerPage(); 
	
	@Meta.AD(deflt = "8", required = false)
	public int itemsPerPageUtenti(); 
	
//	@Meta.AD(deflt = "<h1>Richiesta badge</h1><br/><p>Il dirigente ha richiesto una modifica della seguente richiesta: </p> <br/><p> Portale Intranet MEF </p><br/>", required = false)
//	public String richiestaModificaTmpl();
//	
//
//	@Meta.AD(deflt = "<h1>Richiesta badge</h1><br/><p>La richiesta è stata approvata dal dirigente: </p> <br/><p> Portale Intranet MEF </p><br/>", required = false)
//	public String approvaDirTmpl();
//	
//	@Meta.AD(deflt = "<h1>Richiesta badge</h1><br/><p>La richiesta è stata approvata dal gestore: </p> <br/><p> Portale Intranet MEF </p><br/>", required = false)
//	public String approvaGestTmpl();
//	
//	@Meta.AD(deflt = "<h1>Richiesta badge</h1><br/><p>La richiesta è stata approvata dal dirigente: </p> <br/><p> Portale Intranet MEF </p><br/>", required = false)
//	public String rifiutaDirTmpl();
//	
//	@Meta.AD(deflt = "<h1>Richiesta badge</h1><br/><p>La richiesta è stata approvata dal gestore: </p> <br/><p> Portale Intranet MEF </p><br/>", required = false)
//	public String rifiutaGestTmpl();

}
