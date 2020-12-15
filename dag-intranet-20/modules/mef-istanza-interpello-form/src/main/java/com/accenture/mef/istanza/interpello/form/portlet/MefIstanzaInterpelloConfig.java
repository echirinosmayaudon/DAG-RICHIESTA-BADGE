package com.accenture.mef.istanza.interpello.form.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.accenture.mef.istanza.interpello.form.portlet.MefIstanzaInterpelloConfig")
public interface MefIstanzaInterpelloConfig {

	@Meta.AD(deflt = "ISTANZA INTERPELLO", required = false)
	public String formTitle();

	@Meta.AD(deflt = "testo per il sottotitolo del form ISTANZA INTERPELLO", required = false)
	public String formSubTitle();

	@Meta.AD(deflt = "RIEPILOGO ISTANZA INTERPELLO", required = false)
	public String formTitleRecap();

	@Meta.AD(deflt = "testo per il sottotitolo del riepilogo ISTANZA INTERPELLO", required = false)
	public String formSubTitleRecap();

	@Meta.AD(deflt = "DETTAGLIO ISTANZA INTERPELLO", required = false)
	public String formTitleDettaglio();

	@Meta.AD(deflt = "testo per il sottotitolo del dettaglio ISTANZA INTERPELLO", required = false)
	public String formSubTitleDettaglio();

	@Meta.AD(deflt = "ISTANZA INTERPELLO", required = false)
	public String sender();

	@Meta.AD(deflt = "Invio istanza interpello n.[$IDRICHIESTA$]", required = false)
	public String emailSubject();

	@Meta.AD(deflt = "", required = false)
	public String emailToDipDT();

	@Meta.AD(deflt = "", required = false)
	public String emailToDipRGS();

	@Meta.AD(deflt = "", required = false)
	public String emailToDipDF();

	@Meta.AD(deflt = "", required = false)
	public String emailToDipDAG();

	@Meta.AD(deflt = "<p>L'istanza interpello n.[$IDRICHIESTA$] &egrave; stata acquisita.</p><br/>"
			+ "<p>Il/la sottoscritto/a <strong>[$NOME$] [$COGNOME$]</strong>&#44;</p>"
			+ "<p>[$CONSEGUENZECIVILIPENALI$]</p>" + "<strong>dichiara</strong><p>[$DICHIARAZIONE$]</p>"
			+ "<p>[$REQUISITI$]</p><br/><br/>" + "<em>[$FUNZIONIDIRIGENZIALI$]</em>", required = false)
	public String emailBody();

}