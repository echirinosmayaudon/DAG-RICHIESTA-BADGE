package com.accenture.mef.lavoro.agile.form.portlet;

import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "com.accenture.mef.lavoro.agile.form.portlet.MefLavoroAgileConfig")
public interface MefLavoroAgileConfig {
	
	@Meta.AD(deflt = "ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formTitle();
	
	@Meta.AD(deflt = "testo per il sottotitolo del form di ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formSubTitle();
	
	@Meta.AD(deflt = "RIEPILOGO ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formTitleRecap();
	
	@Meta.AD(deflt = "testo per il sottotitolo del riepilogo ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formSubTitleRecap();
	
	@Meta.AD(deflt = "DETTAGLIO ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formTitleDettaglio();
	
	@Meta.AD(deflt = "testo per il sottotitolo del dettaglio ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formSubTitleDettaglio();
	
	@Meta.AD(deflt = "RICERCA ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formTitleSearch();
	
	@Meta.AD(deflt = "testo per il sottotitolo della ricerca ISTANZA PER L'AMMISSIONE AL LAVORO AGILE",required = false)
	public String formSubTitleSearch();
	
	@Meta.AD(deflt = "ISTANZA PER L'AMMISSIONE AL LAVORO AGILE", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Invio istanza ammissione lavoro agile n.[$IDRICHIESTA$]", required = false)
	public String emailSubject();
	
	@Meta.AD(deflt = "", required = false)
	public String emailToDipDT();
	
	@Meta.AD(deflt = "", required = false)
	public String emailToDipRGS();
	
	@Meta.AD(deflt = "", required = false)
	public String emailToDipDF();
	
	@Meta.AD(deflt = "", required = false)
	public String emailToDipDAG();

	@Meta.AD(deflt = "<p>L'istanza di ammissione al lavoro agile n.[$IDRICHIESTA$] &egrave; stata acquisita.</p><br><p><a href=[$LINK$]>Vai al dettaglio della richiesta</a></p>",required = false)
	public String emailBody();
	
	@Meta.AD(deflt = "", required = false)
	public String bando();
	
	@Meta.AD(deflt = "", required = false)
	public String regolamento();
	
	@Meta.AD(deflt = "10", required = false)
	public String itemsPerPage();
	
	@Meta.AD(deflt = "", required = false)
	public String dataInizioInserimentoRichiesta();
	
	@Meta.AD(deflt = "", required = false)
	public String oraInizioInserimentoRichiesta();
	
	@Meta.AD(deflt = "", required = false)
	public String dataFineInserimentoRichiesta();
	
	@Meta.AD(deflt = "", required = false)
	public String oraFineInserimentoRichiesta();
	
	@Meta.AD(deflt = "", required = false)
	public String dataInizioInserimentoAllegato();
	
	@Meta.AD(deflt = "", required = false)
	public String oraInizioInserimentoAllegato();
	
	@Meta.AD(deflt = "", required = false)
	public String dataFineInserimentoAllegato();
	
	@Meta.AD(deflt = "", required = false)
	public String oraFineInserimentoAllegato();
	
	@Meta.AD(deflt = "I termini per la presentazione delle istanze sono scaduti.", required = false)
	public String msgTerminiScaduti();
	
	@Meta.AD(deflt = "In questa sezione in basso &egrave; possibile caricare l'allegato con l'accordo individuale e il relativo progetto individuale ENTRO il giorno [$DATAFINEINSERIMENTOALLEGATO$] alle ore [$ORAFINEINSERIMENTOALLEGATO$].", required = false)
	public String msgNuovoAllegato();
	
}