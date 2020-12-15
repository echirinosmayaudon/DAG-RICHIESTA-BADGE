package mef.richieste.beni.facili.consumo.portlet;


import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "mef.richieste.beni.facili.consumo.portlet.MefRichiesteBeniFaciliConsumiConfig")
public interface MefRichiesteBeniFaciliConsumiConfig {
	
	
	@Meta.AD(deflt = "MEF richiesta beni facili consumo", required = false)
	public String senderBeni();
	
	@Meta.AD(deflt = "Richiesta BFC", required = false)
	public String subjectNuova();
	
	@Meta.AD(deflt = "approvazione della richiesta di beni", required = false)
	public String subjectApprovazione();
	
	@Meta.AD(deflt = "non approvazione della richiesta di beni", required = false)
	public String subjectRifiuta();
	
	@Meta.AD(deflt = "aggiornamento della richiesta di beni", required = false)
	public String subjectAggiorna();
	
	@Meta.AD(deflt = "", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "<h1>Richiesta beni facili consumo</h1><br/><p>Una nuova richiesta &egrave; stata inserita: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String richiestaBeniTmpl();
	
	@Meta.AD(deflt = "<h1>Richiesta beni facili consumo</h1><br/><p>La seguente richiesta &egrave; stata approvata: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String approvatoTmpl();
	
	@Meta.AD(deflt = "<h1>Richiesta beni facili consumo</h1><br/><p>La seguente richiesta non &egrave; stata approvata: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String rifiutaTmpl();
	
	@Meta.AD(deflt = "<h1>Richiesta beni facili consumo</h1><br/><p>La seguente richiesta &egrave; stata modificata: </p> <br/><p>[$DATIRICHIEDENTE$]</font></p><br/><p><font color=red>Riepilogo richieste:</font></p><br/>[$DATI$]<br/><p> Portale Intranet MEF </p><br/>", required = false)
	public String aggiornaTmpl();
	
	@Meta.AD(deflt = "Titolo form di inserimento", required = false)
	public String formTitle();
	
	@Meta.AD(deflt = "Sottotitolo form di inserimento", required = false)
	public String formSubtitle();
	
	@Meta.AD(deflt = "Titolo riepilogo", required = false)
	public String riepilogoTitle();
	
	@Meta.AD(deflt = "Sottotitolo riepilogo", required = false)
	public String riepilogoSubtitle();
	
	@Meta.AD(deflt = "Titolo lista", required = false)
	public String listaTitle();
	
	@Meta.AD(deflt = "Sottotitolo lista", required = false)
	public String listaSubtitle();
	
	@Meta.AD(deflt = "Titolo gestione utenti", required = false)
	public String gestioneUtentiTitle();
	
	@Meta.AD(deflt = "Sottotitolo gestione utenti", required = false)
	public String gestioneUtentiSubtitle();
	
	@Meta.AD(deflt = "Titolo cerca richiesta", required = false)
	public String cercaRichiestaTitle();
	
	@Meta.AD(deflt = "Sottotitolo cerca richiesta", required = false)
	public String cercaRichiestaSubtitle();
	
	@Meta.AD(deflt = "Richiesta BFC Ottobre", required = false)
	public String oggettoBeniStandard();
	
	@Meta.AD(deflt = "Richiesta BFC Ottobre", required = false)
	public String oggettoBeniInformatica();
	
	@Meta.AD(deflt = "12", required = false)
	public int itemsPerPage(); 

	@Meta.AD(deflt = "stanza n. 0621(piano terra - scala E)", required = false)
	public String ubicazioneMagazzino();
	
	@Meta.AD(deflt = "via XX Settembre", required = false)
	public String indirizzoMagazzino(); 
	
	@Meta.AD(deflt = "luned\u00EC/mercoled\u00EC/venerd\u00EC; dalle ore 9,00 alle ore 13,00", required = false)
	public String orarioRitiro(); 
	
	
	@Meta.AD(deflt = "tutti i giorni dalle ore 9,00 alle ore 13,00", required = false)
	public String orarioSostituzione(); 
	
	
	@Meta.AD(deflt = "SI", required = false)
	public String approvazioneDT(); 
	
	@Meta.AD(deflt = "NO", required = false)
	public String approvazioneRGS(); 
	
	@Meta.AD(deflt = "SI", required = false)
	public String approvazioneDF(); 
	
	@Meta.AD(deflt = "SI", required = false)
	public String approvazioneDAG(); 
	
	@Meta.AD(deflt = "16297,15276,90355,16313,90140", required = false)
	public String listaUfficiGeco();
	
	@Meta.AD(deflt = "esercizio", required = false)
	public String ambienteGecoPigreco(); 
	
}
