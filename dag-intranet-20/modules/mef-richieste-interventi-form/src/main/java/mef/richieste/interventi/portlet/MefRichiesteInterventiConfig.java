package mef.richieste.interventi.portlet;
import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "mef.richieste.interventi.portlet.MefRichiesteInterventiConfig")
public interface MefRichiesteInterventiConfig {

	@Meta.AD(deflt = "MEF richiesta servizio interventi tecnici", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Modulo di richiesta intervento", required = false)
	public String subject();
	
	@Meta.AD(deflt = "", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "<h1>Richiesta servizio interventi tecnici </h1><br/><p>nuova richiesta di intervento da parte di: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String richiestaTmpl();
	
	
	@Meta.AD(deflt = "Richiesta servizio interventi tecnici", required = false)
	public String formTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di inserimento", required = false)
	public String formSubtitle();
	
	@Meta.AD(deflt = "Richiesta servizio interventi tecnici", required = false)
	public String recapTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del riepilogo", required = false)
	public String recapSubtitle();
	
	
	
}
