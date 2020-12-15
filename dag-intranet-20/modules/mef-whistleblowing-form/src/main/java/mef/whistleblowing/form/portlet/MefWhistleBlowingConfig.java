package mef.whistleblowing.form.portlet;
import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "mef.whistleblowing.form.portlet.MefWhistleBlowingConfig")
public interface MefWhistleBlowingConfig {
	
	@Meta.AD(deflt = "WhistleBlowing", required = false)
	public String formTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di WhistleBlowing", required = false)
	public String formSubtitle();	
	
	@Meta.AD(deflt = "WhistleBlowing", required = false)
	public String recapTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del riepilogo di WhistleBlowing", required = false)
	public String recapSubtitle();
	
	@Meta.AD(deflt = "", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "MEF Whistle Blowing", required = false)
	public String sender();
	
	@Meta.AD(deflt = "nuova segnalazione Whistle Blowing", required = false)
	public String subject();
	
	@Meta.AD(deflt = "<p> La segnalazione &egrave stata inviata correttamente. </p>", required = false)
	public String segnalazioneTmpl();
	
	@Meta.AD(deflt = "NO", required = false)
	public String salvataggioDB();
	
}