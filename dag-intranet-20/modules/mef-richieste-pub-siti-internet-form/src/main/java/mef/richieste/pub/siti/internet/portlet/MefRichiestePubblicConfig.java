package mef.richieste.pub.siti.internet.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "mef.richieste.pub.siti.internet.portlet.MefRichiestePubblicConfig")
public interface MefRichiestePubblicConfig {

	@Meta.AD(deflt = "MEF richiesta pubblicazione siti internet", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Modulo di richiesta pubblicazione siti internet", required = false)
	public String subject();
	
	@Meta.AD(deflt = "", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "", required = false)
	public String linkPaginaGuida();
	
	@Meta.AD(deflt = "<h1>Richiesta Pubblicazione Siti Internet </h1><br/>"
			+ "<p>dettagli </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/>", required = false)
	public String pubblicazioneSitiTmpl();
	
	@Meta.AD(deflt = "Servizio Richiesta di Pubblicazione sui siti Internet Dipartimentali", required = false)
	public String serviziPubblicazioneSitiTitle();
	
	@Meta.AD(deflt = " ", required = false)
	public String serviziPubblicazioneSitiSubTitle();
	
}
