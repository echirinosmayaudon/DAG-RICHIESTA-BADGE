package mef.richieste.beni.inventariati.portlet;

import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "mef.richieste.beni.inventariati.portlet.MefRichiesteBeniInventariatiConfig")
public interface MefRichiesteBeniInventariatiConfig {

	@Meta.AD(deflt = "MEF richiesta beni inventariati", required = false)
	public String nuovaRichiestaSender();
	
	@Meta.AD(deflt = "Nuova richiesta di beni inventariati", required = false)
	public String nuovaRichiestaSubject();
	
	@Meta.AD(deflt = "<h1>Richiesta beni inventariati</h1><br/><p>Nuova richiesta di beni inventariati da parte di: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p>Beneficiario della richiesta: </p> <br/><p>[$DATIBENEFICIARIO$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/>"
			+ "<p> LINK al dettaglio </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO DELLA RICHIESTA </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String nuovaRichiestaTmpl();
	
	@Meta.AD(deflt = "MEF richiesta beni inventariati", required = false)
	public String cambioStatoConsegnatarioSender();
	
	@Meta.AD(deflt = "Cambio stato della richiesta con id: [$IDRICHIESTA$]", required = false)
	public String cambioStatoConsegnatarioSubject();
	
	@Meta.AD(deflt = "<h1>Cambio stato richiesta beni inventariati</h1><br/><p>Il consegnatario ha cambiato lo stato della richiesta in: [$NUOVOSTATO$]</p><br/><p>Dettaglio della richiesta: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p>Beneficiario della richiesta: </p> <br/><p>[$DATIBENEFICIARIO$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p>Note del consegnatario: </p> <br/><p>[$NOTECONSEGNATARIO$]</font></p><br/><p> LINK al dettaglio </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO DELLA RICHIESTA </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String cambioStatoConsegnatarioTmpl();
	
	@Meta.AD(deflt = "MEF richiesta beni inventariati", required = false)
	public String cambioStatoCDCSender();
	
	@Meta.AD(deflt = "Cambio stato della richiesta con id: [$IDRICHIESTA$]", required = false)
	public String cambioStatoCDCSubject();
	
	@Meta.AD(deflt = "<h1>Cambio stato richiesta beni inventariati</h1><br/><p>Il responsabile del centro di costo ha cambiato lo stato della richiesta in: [$NUOVOSTATO$]</p><br/><p>Dettaglio della richiesta: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p>Beneficiario della richiesta: </p> <br/><p>[$DATIBENEFICIARIO$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p>Note del consegnatario: </p> <br/><p>[$NOTECONSEGNATARIO$]</font></p><br/><p> LINK al dettaglio </p><br/><a href='[$LINK$]'> VAI AL DETTAGLIO DELLA RICHIESTA </a><br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String cambioStatoCDCTmpl();
	
	@Meta.AD(deflt = "", required = false)
	public String beniInvInserimentoTxt();
	
	@Meta.AD(deflt = "SERVIZIO RICHIESTA BENI INVENTARIATI", required = false)
	public String beniInvInserimentoTitle();
	
	@Meta.AD(deflt = "", required = false)
	public String beniInvRicercaTxt();
	
	@Meta.AD(deflt = "SERVIZIO RICHIESTA BENI INVENTARIATI", required = false)
	public String beniInvRicercaTitle();
	
}
