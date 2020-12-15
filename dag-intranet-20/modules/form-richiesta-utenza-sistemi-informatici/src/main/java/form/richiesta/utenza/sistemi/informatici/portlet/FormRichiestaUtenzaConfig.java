package form.richiesta.utenza.sistemi.informatici.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id ="form.richiesta.utenza.sistemi.informatici.portlet.FormRichiestaUtenzaConfig")
public interface FormRichiestaUtenzaConfig {

	@Meta.AD(deflt = "MEF richiesta utenza sistemi informatici", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Modulo di richiesta intervento", required = false)
	public String subject();
	
	@Meta.AD(deflt = "", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "<h1>Richiesta utenza sistemi informatici</h1><br/><p>nuova richiesta id utenza sistemi informatici: </p><br/><p><font color=red>riepilogo dati richiesta:</font></p><br/><p>[$DATIRICHIEDENTE$]</p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String richiestaTmpl();
	
	
	@Meta.AD(deflt = "SERVIZIO DI RICHIESTA UTENZE PER SISTEMI INFORMATICI", required = false)
	public String formTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di inserimento", required = false)
	public String formSubtitle();
	
	@Meta.AD(deflt = "SERVIZIO DI RICHIESTA UTENZE PER SISTEMI INFORMATICI", required = false)
	public String recapTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del riepilogo", required = false)
	public String recapSubtitle();
	
	
	
}
