package com.intranet.mef.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.intranet.mef.portlet.RichiesteServiziLogisticiConfig")
public interface RichiesteServiziLogisticiConfig {
	

	@Meta.AD(deflt = "MEF richiesta servizi logistici", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Modulo di richiesta servizi logistici", required = false)
	public String subject();
	
	@Meta.AD(deflt = "MEF richiesta servizi logistici", required = false)
	public String cambioStatosender();
	
	@Meta.AD(deflt = "Cambio stato richiesta servizi logistici", required = false)
	public String cambioStatosubject();
	
	@Meta.AD(deflt = "", required = false)
	public String emailGestore();
	
	@Meta.AD(deflt = "<h1>Richiesta servizi logistici </h1><br/><p>nuova richiesta di intervento da parte di: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> LINK per accettare o rifiutare la richiesta </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO RICHIESTA </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String richiestaTmpl();
	
	
	@Meta.AD(deflt = "<h1>Cambio Stato richiesta servizi logistici </h1><br/><p> cambio stato della richiesta: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String cambioStatoTmpl();

	@Meta.AD(deflt = "testo configurabile per form di inserimento", required = false)
	public String serviziLogisticitxt();
	
	@Meta.AD(deflt = "SERVIZI LOGISTICI", required = false)
	public String serviziLogisticititle();
	
	@Meta.AD(deflt = "testo configurabile per elenco", required = false)
	public String serviziLogisticiElencotxt();
	
	@Meta.AD(deflt = "SERVIZIO LOGISTICI ELENCO", required = false)
	public String serviziLogisticiElencotitle();
	
	
	@Meta.AD(deflt = "testo configurabile per dettaglio", required = false)
	public String serviziLogisticiDettagliotxt();
	
	@Meta.AD(deflt = "SERVIZIO LOGISTICI DETTAGLIO", required = false)
	public String serviziLogisticiDettagliotitle();


	@Meta.AD(deflt = "10", required = false)
	public int itemsPerPage(); 
}
