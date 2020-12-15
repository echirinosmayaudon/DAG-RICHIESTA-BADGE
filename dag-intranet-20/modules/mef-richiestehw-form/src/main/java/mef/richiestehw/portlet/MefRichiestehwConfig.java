package mef.richiestehw.portlet;

import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "mef.richiestehw.portlet.MefRichiestehwConfig")
public interface MefRichiestehwConfig {

	
	
	@Meta.AD(deflt = "MEF richiesta hardware software", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Modulo di richiesta apparecchiature hardware e software", required = false)
	public String subject();
	
	@Meta.AD(deflt = "", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "<h1>Richiesta apparecchiature Hardware e software</h1><br/><p>nuova richiesta di apparecchiature da parte di: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String richiestaTmpl();
	
	
	@Meta.AD(deflt = "Richiesta apparecchiature informatiche e software", required = false)
	public String formTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di inserimento", required = false)
	public String formSubtitle();
	
	@Meta.AD(deflt = "Richiesta apparecchiature informatiche e software", required = false)
	public String recapTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del riepilogo", required = false)
	public String recapSubtitle();
	
}
