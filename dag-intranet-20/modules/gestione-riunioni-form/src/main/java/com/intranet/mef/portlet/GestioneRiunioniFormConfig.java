package com.intranet.mef.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.intranet.mef.portlet.GestioneRiunioniFormConfig")
public interface GestioneRiunioniFormConfig {

	/* revoca invito 
	 * email inviata ad un'ispettorato rimosso dalla riunione
	 * */
	@Meta.AD(deflt = "Il suo invito a partecipare "
	+ "alla riunione con oggetto: "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG>"
	+ "<br/><br/><ul><li>&egrave; stata "
	+ "convocata da: [$CONVOCANTE$]</li><li>"
	+ "nel giorno: [$DATARIUNIONE$] "
	+ "</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$] </li></ul> "
	+ "<STRONG>&Egrave; STATO ANNULLATO</STRONG>."
	+ "<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String cancellainvitoriunioneTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderCancellaInvito();
	
	@Meta.AD(deflt = "Annullamento partecipazione alla Riunione", required = false)
	public String subjectCancellaInvito();
	
	/*  invito 
	 * email inviata ad un'ispettorato aggiunto dalla riunione
	 * */	
	@Meta.AD(deflt = "Lei &egrave; stato invitato "
	+ "ad una riunione "
	+ "che ha per oggetto: <STRONG>"
	+ "[$OGGETTORIUNIONE$]</STRONG>"
	+ "<br/><br/>La riunione  "
	+ "<ul><li>&egrave; stata convocata da: [$CONVOCANTE$]</li>"
	+ "<li>si svolger&agrave; "
	+ "nel giorno: [$DATARIUNIONE$] </li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$] </li></ul>   "
	+"Gli ispettorati/uffici di staff RGS invitati alla riunione "
	 +"(in grassetto il capofila) sono: <br/>[$ISPETTORATI$]<br/>"
	+"Per conoscere tutti i dettagli della riunione e per dare una "
	+ "risposta riguardo la propria partecipazione &egrave; "
	 +"necessario utilizzare il sistema<a href='[$LINK$]'> Gestione Riunioni (Intranet RGS)</a>"
	+ ".<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String invitoriunioneTmpl();

	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderInvito();
	
	@Meta.AD(deflt = "Convocazione Riunione", required = false)
	public String subjectInvito();
	
	
	/*  annullata   
	 * email inviata a tutti gli spettorati invitati alla riunione
	 * */	
	@Meta.AD(deflt = "La riunione con oggetto: "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG><ul>"
	+ "<li>convocata da: "
	+ "[$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$]</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li>"
	+ "</ul><STRONG>&Egrave; STATA ANNULLATA</STRONG> "
   +"<br><br>Cordiali Saluti<br>"
   + "<small>P.S. Non rispondere a questa mail</small>", required = false)
	public String cambiostatoriunioneTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderCambioStato();
	
	@Meta.AD(deflt = "Riunione Annullata", required = false)
	public String subjectCambioStato();
	
	
	
	/*  rinvita  
	 * email inviata a tutti gli spettorati invitati alla riunione
	 * */	
	@Meta.AD(deflt = "La riunione con oggetto:  "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG><ul>"
	+ "<li>convocata da: "
	+ "[$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$]</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li>"
	+ "</ul><STRONG>&Egrave; STATA RINVIATA</STRONG> a data da destinarsi."
   +"<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String riunionerinviataTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderRiunioneRinviata();
	
	@Meta.AD(deflt = "Riunione Rinviata", required = false)
	public String subjectRiunioneRinviata();
	
	
	
	
	/*  riunione modificata:
	 * i dati della riunione sono stati modificati 
	 * email inviata a tutti gli spettorati invitati alla riunione
	 * */
	@Meta.AD(deflt = "La riunione con oggetto: "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG>"
	+ "<br/> <ul><li>convocata da: [$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$] </li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li>"
	+ "</ul> <STRONG>&Egrave; STATA MODIFICATA</STRONG>."
	+ "<br/><br/>Gli attributi modificati sono i seguenti: "
	+ "<br/>[$DATI$]<br/><br>Per vedere tutti i dettagli della riunione &egrave; necessario utilizzare il"
	+ " sistema <a href='[$LINK$]'>Gestione Riunioni (Intranet RGS)</a>."
	+ "<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String modificariunioneTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderModifica();
	
	@Meta.AD(deflt = "Riunione Modificata", required = false)
	public String subjectModifica();
		

	/* sposta riunione
	 * richiamato durante il cambio luogo e data */
	@Meta.AD(deflt = "La riunione con oggetto: "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG><ul><li>convocata da: "
	+ "[$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$]</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li></ul>"
	+ "<STRONG>&Egrave; STATA SPOSTATA</STRONG> "
	+"<ul> <li>al giorno: [$NUOVADATARIUNIONE$]</li>"
	+ "<li>alle ore: [$NUOVAORARIUNIONE$]</li>"
	+ "<li>presso: [$NUOVOLUOGORIUNIONE$]</li></ul>"
	+"&Egrave; necessario utilizzare nuovamente"
	  +" (se lo si &egrave; gi&agrave; fatto) il sistema <a href='[$LINK$]'>"
	   +"Gestione Riunioni (Intranet RGS)</a> per dare una risposta riguardo "
	   + "la propria partecipazione.<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String spostariunioneTmpl();

	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderSposta();
	
	@Meta.AD(deflt = "Riunione Spostata", required = false)
	public String subjectSposta();
		
		
	/* Convocazione riunione precedentemente rinviata
	 *  */
	@Meta.AD(deflt = "Lei &egrave; stato invitato nuovamente ad una riunione rinviata in precedenza che ha per oggetto: "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG>.<br><br>La riunione <ul><li>&egrave; stata convocata "
	+ "da: [$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$]</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li>"
	+ "</ul>"
	+"Gli ispettorati invitati alla riunione (in grassetto il capofila) sono: "
	 +"<br/>[$ISPETTORATI$]<br/>"
	+"Per conoscere tutti i dettagli della riunione e per dare una "
	+ "risposta riguardo la propria partecipazione &egrave; "
	 +"necessario utilizzare il sistema <a href='[$LINK$]'>Gestione Riunioni (Intranet RGS)</a>"
	+ ".<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String cambiostatoriunioneindettaTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderStatoIndetta();
	
	@Meta.AD(deflt = "Convocazione riunione precedentemente rinviata", required = false)
	public String subjectStatoIndetta();
	
	/*MODIFICA INVITATI 
	 * inviata a tutti gli invitati
	 * */
	@Meta.AD(deflt = "Riunione con oggetto:   "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG><ul>"
	+ "<li>convocata da: "
	+ "[$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$]</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li></ul>"
	+"<br><br><strong>L'ordine degli invitati &egrave; stato modificato come segue </strong>(in grassetto il capofila): "
	 +"<br/>[$ISPETTORATI$]<br/>"
	+"Per conoscere tutti i dettagli della riunione e per dare una "
	+ "risposta riguardo la propria partecipazione &egrave; "
	 +"necessario utilizzare il sistema <a href='[$LINK$]'>Gestione Riunioni (Intranet RGS)</a>"
	+ ".<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String modificainvitatiriunioneTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderModificaInvitati();
	
	@Meta.AD(deflt = "Modifica elenco invitati", required = false)
	public String subjectModificaInvitati();
	
	
	/*AGGIUNTA nuovi invitati INVITATI 
	 * 
	 * */
	@Meta.AD(deflt = "Riunione con oggetto: "
	+ "<STRONG>[$OGGETTORIUNIONE$]</STRONG><ul><li>convocata da: "
	+ "[$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$]</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li></ul><br><br>"
	+"<strong>Sono stati aggiunti nuovi invitati alla riunione </strong>(in grassetto il capofila): "
	 +"<br/>[$ISPETTORATI$]<br/>"
	+"Per conoscere tutti i dettagli della riunione e per dare una "
	+ "risposta riguardo la propria partecipazione &egrave; "
	 +"necessario utilizzare il sistema <a href='[$LINK$]'>Gestione Riunioni (Intranet RGS)</a>"
	+ ".<br><br>Cordiali Saluti<br><small>P.S. Non rispondere a questa mail</small>", required = false)
	public String aggiuntainvitatiriunioneTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderAggiuntaInvitati();
	
	@Meta.AD(deflt = "Notifica nuovi invitati nella riunione", required = false)
	public String subjectAggiuntaInvitati();
	
	
	
	
	
	@Meta.AD(deflt = "<STRONG>Si prega di inserire i nominativi dei partecipanti; "
	+ " in caso di mancata indicazione dei nominativi, motivarla nel campo note</STRONG><br><br>"
	+ "Riunione: <STRONG>[$OGGETTORIUNIONE$]</STRONG> <ul> <li>convocata da: [$CONVOCANTE$]</li>"
	+ " <li>nel giorno: [$DATARIUNIONE$]</li> <li>alle ore: [$ORARIUNIONE$]</li> <li>presso: [$LUOGORIUNIONE$]</li> "
	+ "</ul>Gli ispettorati/uffici di staff RGS invitati alla riunione (in grassetto il capofila) sono: "
	+ "<br/> [$ISPETTORATI$]<br/> Per conoscere tutti i dettagli della riunione e per dare una risposta riguardo "
	+ "la propria partecipazione &egrave; necessario utilizzare il sistema <a href='[$LINK$]'> "
	+ "Gestione Riunioni (Intranet RGS)</a>.<br> <br> Cordiali Saluti<br> "
	+ "<small>P.S. Non rispondere a questa mail</small>", required = false)
	public String sollecitoaccettatariunioneTmpl();
	
	
	@Meta.AD(deflt = "<STRONG>Si prega di inserire i nominativi dei partecipanti; " 
	+"in caso di mancata indicazione dei nominativi, motivarla "
	+"nel campo note</STRONG><br><br>Riunione: <STRONG>"
   +"[$OGGETTORIUNIONE$]</STRONG><br/> <ul><li>convocata da: "
	+ "[$CONVOCANTE$]</li>"
	+ "<li>nel giorno: [$DATARIUNIONE$]</li>"
	+ "<li>alle ore: [$ORARIUNIONE$]</li>"
	+ "<li>presso: [$LUOGORIUNIONE$]</li></ul>"
	+"Gli ispettorati/uffici di staff RGS invitati alla riunione"
	+ " (in grassetto il capofila) sono: <br/> [$ISPETTORATI$]<br/> Per conoscere "
	+ "tutti i dettagli della riunione e per dare una risposta riguardo "
	+ "la propria partecipazione &egrave; necessario utilizzare il sistema"
	+ " <a href='[$LINK$]'>Gestione Riunioni (Intranet RGS)</a>.<br> <br>"
	+ "Cordiali Saluti<br> <small>P.S. Non rispondere a questa mail</small>", required = false)
	public String sollecitoriunioneTmpl();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderSollecito();
	
	@Meta.AD(deflt = "Sollecito riunione \"In attesa di risposta\"", required = false)
	public String subjectSollecito();
	
	@Meta.AD(deflt = "MEF riunione", required = false)
	public String senderSollecitoAccettata();
	
	@Meta.AD(deflt = "Sollecito riunione \"Accettato\" (senza partecipanti)", required = false)
	public String subjectSollecitoAccettata();
	
	
	
	
	
	@Meta.AD(deflt = "Testo ricerca riunione", required = false)
	public String ricercaRiunionetxt();
	
	@Meta.AD(deflt = "GESTIONE RIUNIONI", required = false)
	public String ricercaRiunionetitle();
	
	@Meta.AD(deflt = "Testo crea riunione", required = false)
	public String creaRiunionetxt();
	
	@Meta.AD(deflt = "CREA RIUNIONE", required = false)
	public String creaRiunionetitle();
	
	@Meta.AD(deflt = "Testo luoghi riunione", required = false)
	public String luoghiRiunionetxt();
	
	@Meta.AD(deflt = "GESTIONE LUOGHI", required = false)
	public String luoghiRiunionetitle();
	
	@Meta.AD(deflt = "Testo convocanti riunione", required = false)
	public String convocantiRiunionetxt();
	
	@Meta.AD(deflt = "GESTIONE CONVOCANTI", required = false)
	public String convocantiRiunionetitle();
	
	@Meta.AD(deflt = "Testo modifica riunione", required = false)
	public String modificaRiunionetxt();
	
	@Meta.AD(deflt = "MODIFICA RIUNIONE", required = false)
	public String modificaRiunionetitle();
	
	@Meta.AD(deflt = "Testo stampa riunione", required = false)
	public String stampaRiunionetxt();
	
	@Meta.AD(deflt = "STAMPA RIUNIONE", required = false)
	public String stampaRiunionetitle();
	
	@Meta.AD(deflt = "Testo accetta  riunione", required = false)
	public String accettaRiunionetxt();
	
	@Meta.AD(deflt = "ACCETTA RIUNIONE", required = false)
	public String accettaRiunionetitle();
	
	@Meta.AD(deflt = "10", required = false)
	public int itemsPerPage(); 
}
