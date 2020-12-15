package mef.richieste.figli.form.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.intranet.mef.portlet.RichiesteRimborsoFormConfig")
public interface RichiesteRimborsoFormConfig {

	@Meta.AD(deflt = "<p>Si invia, in allegato, il modulo per il rimborso "
			+ "delle spese per i figli fiscalmente "
			+ "a carico relativo a [$COGNOME$] [$NOME$] ([$CODICEFISCALE$])</p> ", required = false)
	public String richiestaRimborsoTmpl();
	
	@Meta.AD( required = false)
	public String senderRichiestaRimborso();
	
	@Meta.AD(deflt = "Richiesta rimborso per figli fiscalmente a carico relativo a [$NOME$] [$COGNOME$]", required = false)
	public String subjectRichiestaRimborso();
	
	@Meta.AD(deflt = "iniziativesocialipersonale.dag@tesoro.it", required = false)
	public String emailReferente();
	
	
	
	
	
}
