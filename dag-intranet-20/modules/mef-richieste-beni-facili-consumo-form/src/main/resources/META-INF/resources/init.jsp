<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="mef.richieste.beni.facili.consumo.portlet.MefRichiesteBeniFaciliConsumiConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%

MefRichiesteBeniFaciliConsumiConfig richiestaMefConfig = (MefRichiesteBeniFaciliConsumiConfig) renderRequest.getAttribute(MefRichiesteBeniFaciliConsumiConfig.class.getName());
String senderBeni = StringPool.BLANK;
String subjectNuova = StringPool.BLANK;
String subjectApprovazione = StringPool.BLANK;
String emailReferente = StringPool.BLANK;
String richiestaBeniTmpl = StringPool.BLANK;
String approvatoTmpl = StringPool.BLANK;
String formTitle = StringPool.BLANK;
String formSubtitle = StringPool.BLANK;
String riepilogoTitle = StringPool.BLANK;
String riepilogoSubtitle = StringPool.BLANK;
String gestioneUtentiTitle = StringPool.BLANK;
String gestioneUtentiSubtitle = StringPool.BLANK;
String cercaRichiestaTitle = StringPool.BLANK;
String cercaRichiestaSubtitle = StringPool.BLANK;
String oggettoBeniStandard = StringPool.BLANK;
String oggettoBeniInformatica = StringPool.BLANK;
String itemsPerPage = StringPool.BLANK;
String listaTitle = StringPool.BLANK;
String listaSubtitle = StringPool.BLANK;
String subjectAggiorna = StringPool.BLANK;
String aggiornaTmpl = StringPool.BLANK;
String rifiutaTmpl = StringPool.BLANK;
String subjectRifiuta = StringPool.BLANK;
String orarioRitiro = StringPool.BLANK;
String orarioSostituzione = StringPool.BLANK;
String indirizzoMagazzino = StringPool.BLANK;
String ubicazioneMagazzino = StringPool.BLANK;

String approvazioneDT = StringPool.BLANK;
String approvazioneRGS = StringPool.BLANK;
String approvazioneDF = StringPool.BLANK;
String approvazioneDAG = StringPool.BLANK;
String listaUfficiGeco = StringPool.BLANK;
String ambienteGecoPigreco = StringPool.BLANK;


if (Validator.isNotNull(richiestaMefConfig)){
	senderBeni =  portletPreferences.getValue(
    		"senderBeni", String.valueOf(richiestaMefConfig.senderBeni()));
	subjectRifiuta =  portletPreferences.getValue(
    		"subjectRifiuta", String.valueOf(richiestaMefConfig.subjectRifiuta()));
	 subjectNuova =  portletPreferences.getValue(
	    		"subjectNuova", String.valueOf(richiestaMefConfig.subjectNuova()));
	 subjectApprovazione =  portletPreferences.getValue(
	    		"subjectApprovazione", String.valueOf(richiestaMefConfig.subjectApprovazione()));
	 subjectAggiorna =  portletPreferences.getValue(
	    		"subjectAggiorna", String.valueOf(richiestaMefConfig.subjectAggiorna()));
	 rifiutaTmpl =  portletPreferences.getValue(
	    		"rifiutaTmpl", String.valueOf(richiestaMefConfig.rifiutaTmpl())); 
	 aggiornaTmpl =  portletPreferences.getValue(
	    		"aggiornaTmpl", String.valueOf(richiestaMefConfig.aggiornaTmpl())); 
	 richiestaBeniTmpl =  portletPreferences.getValue(
	     		"richiestaBeniTmpl", String.valueOf(richiestaMefConfig.richiestaBeniTmpl()));
	  approvatoTmpl =  portletPreferences.getValue(
	     		"approvatoTmpl", String.valueOf(richiestaMefConfig.approvatoTmpl()));
	  emailReferente =  portletPreferences.getValue(
	     		"emailReferente", String.valueOf(richiestaMefConfig.emailReferente()));
	  formTitle =  portletPreferences.getValue(
	     		"formTitle", String.valueOf(richiestaMefConfig.formTitle()));
	  formSubtitle =  portletPreferences.getValue(
	     		"formSubtitle", String.valueOf(richiestaMefConfig.formSubtitle()));
	  riepilogoTitle =  portletPreferences.getValue(
	     		"riepilogoTitle", String.valueOf(richiestaMefConfig.riepilogoTitle()));
	  riepilogoSubtitle =  portletPreferences.getValue(
	     		"riepilogoSubtitle", String.valueOf(richiestaMefConfig.riepilogoSubtitle()));
	  gestioneUtentiTitle =  portletPreferences.getValue(
	     		"gestioneUtentiTitle", String.valueOf(richiestaMefConfig.gestioneUtentiTitle()));
	  gestioneUtentiSubtitle =  portletPreferences.getValue(
	     		"gestioneUtentiSubtitle", String.valueOf(richiestaMefConfig.gestioneUtentiSubtitle()));
	  cercaRichiestaTitle =  portletPreferences.getValue(
	     		"cercaRichiestaTitle", String.valueOf(richiestaMefConfig.cercaRichiestaTitle()));
	  cercaRichiestaSubtitle =  portletPreferences.getValue(
	     		"cercaRichiestaSubtitle", String.valueOf(richiestaMefConfig.cercaRichiestaSubtitle()));
	  oggettoBeniStandard =  portletPreferences.getValue(
	     		"oggettoBeniStandard", String.valueOf(richiestaMefConfig.oggettoBeniStandard()));
	  oggettoBeniInformatica =  portletPreferences.getValue(
	     		"oggettoBeniInformatica", String.valueOf(richiestaMefConfig.oggettoBeniInformatica()));
	  itemsPerPage =  portletPreferences.getValue(
      		"itemsPerPage", String.valueOf(richiestaMefConfig.itemsPerPage()));
	  listaTitle =  portletPreferences.getValue(
	      		"listaTitle", String.valueOf(richiestaMefConfig.listaTitle()));
	  listaSubtitle =  portletPreferences.getValue(
	      		"listaSubtitle", String.valueOf(richiestaMefConfig.listaSubtitle()));
	  orarioRitiro =  portletPreferences.getValue(
	      		"orarioRitiro", String.valueOf(richiestaMefConfig.orarioRitiro()));	  
	  orarioSostituzione =  portletPreferences.getValue(
	      		"orarioSostituzione", String.valueOf(richiestaMefConfig.orarioSostituzione()));
	  indirizzoMagazzino =  portletPreferences.getValue(
	    		"indirizzoMagazzino", String.valueOf(richiestaMefConfig.indirizzoMagazzino()));
	  ubicazioneMagazzino =  portletPreferences.getValue(
	    		"ubicazioneMagazzino", String.valueOf(richiestaMefConfig.ubicazioneMagazzino()));
	  
	  approvazioneDT =  portletPreferences.getValue(
	    		"approvazioneDT", String.valueOf(richiestaMefConfig.approvazioneDT()));
	  
	  approvazioneRGS =  portletPreferences.getValue(
	    		"approvazioneRGS", String.valueOf(richiestaMefConfig.approvazioneRGS()));
	  
	  approvazioneDF =  portletPreferences.getValue(
	    		"approvazioneDF", String.valueOf(richiestaMefConfig.approvazioneDF()));
	  
	  approvazioneDAG =  portletPreferences.getValue(
	    		"approvazioneDAG", String.valueOf(richiestaMefConfig.approvazioneDAG()));
	  
	  listaUfficiGeco =  portletPreferences.getValue(
	    		"listaUfficiGeco", String.valueOf(richiestaMefConfig.listaUfficiGeco()));
	  
	  ambienteGecoPigreco =  portletPreferences.getValue(
	    		"ambienteGecoPigreco", String.valueOf(richiestaMefConfig.ambienteGecoPigreco()));

}

%>