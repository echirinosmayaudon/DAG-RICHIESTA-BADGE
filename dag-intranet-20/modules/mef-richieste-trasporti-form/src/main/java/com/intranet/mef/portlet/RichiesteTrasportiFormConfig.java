package com.intranet.mef.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.intranet.mef.portlet.RichiesteTrasportiFormConfig")
public interface RichiesteTrasportiFormConfig {
	
	@Meta.AD(deflt = "<p>Si invia, in allegato, il modulo per il rimborso "
			+ "delle spese per l'utilizzo dei mezzi di "
			+ "trasporto pubblico relativo a [$COGNOME$] [$NOME$] ([$CODICEFISCALE$])</p> ", required = false)
	public String richiestaRimborsoTmpl();
	
	@Meta.AD(deflt = "MEF rimborso trasporti", required = false)
	public String senderRichiestaRimborso();
	
	@Meta.AD(deflt = "Richiesta rimborso utilizzo mezzi di trasporto pubblico_[$NOME$] [$COGNOME$]", required = false)
	public String subjectRichiestaRimborso();
	


	
	@Meta.AD(deflt = "iniziativesocialipersonale.dag@tesoro.it", required = false)
	public String emailReferente();
	

}
