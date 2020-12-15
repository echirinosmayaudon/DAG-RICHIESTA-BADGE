<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="mef.prenotazione.aule.portlet.MefPrenotazioneAuleConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%

MefPrenotazioneAuleConfig richiestaMefConfig = (MefPrenotazioneAuleConfig) renderRequest.getAttribute(MefPrenotazioneAuleConfig.class.getName());
String sender = StringPool.BLANK;
String subjectNoApprovazione = StringPool.BLANK;
String subjectApprovazione = StringPool.BLANK;
String subjectPrenotazioneAutorizzata = StringPool.BLANK;
String subjectPrenotazioneRifiutata = StringPool.BLANK;
String subjectPrenotazioneModificata = StringPool.BLANK;
String subjectPrenotazioneEliminata = StringPool.BLANK;
String richiestaNoApprovazioneTmpl = StringPool.BLANK;
String richiestaApprovazioneTmpl = StringPool.BLANK;
String prenotazioneAutorizzataTmpl = StringPool.BLANK;
String prenotazioneRifiutataTmpl = StringPool.BLANK;
String prenotazioneModificataTmpl = StringPool.BLANK;
String prenotazioneEliminataTmpl = StringPool.BLANK;
String formTitleInsertPrenotazioni = StringPool.BLANK;
String formSubtitleInsertPrenotazioni = StringPool.BLANK;
String formTitleLeTuePrenotazioni = StringPool.BLANK;
String formSubtitleLeTuePrenotazioni = StringPool.BLANK;
String formTitleRicercaAule = StringPool.BLANK;
String formSubtitleRicercaAule = StringPool.BLANK;
String formTitleRicercaAuleApprovatore = StringPool.BLANK;
String formSubtitleRicercaAuleApprovatore = StringPool.BLANK;


if (Validator.isNotNull(richiestaMefConfig)){
	  sender =  portletPreferences.getValue(
    		"sender", String.valueOf(richiestaMefConfig.sender()));
	  subjectNoApprovazione =  portletPreferences.getValue(
    		"subjectNoApprovazione", String.valueOf(richiestaMefConfig.subjectNoApprovazione()));
	  subjectApprovazione =  portletPreferences.getValue(
	    		"subjectApprovazione", String.valueOf(richiestaMefConfig.subjectApprovazione()));
	  subjectPrenotazioneAutorizzata = portletPreferences.getValue(
	    		"subjectPrenotazioneAutorizzata", String.valueOf(richiestaMefConfig.subjectPrenotazioneAutorizzata()));
	  subjectPrenotazioneRifiutata = portletPreferences.getValue(
	    		"subjectPrenotazioneRifiutata", String.valueOf(richiestaMefConfig.subjectPrenotazioneRifiutata()));
	  subjectPrenotazioneModificata =  portletPreferences.getValue(
	    		"subjectPrenotazioneModificata", String.valueOf(richiestaMefConfig.subjectPrenotazioneModificata()));
	  subjectPrenotazioneEliminata =  portletPreferences.getValue(
	    		"subjectPrenotazioneEliminata", String.valueOf(richiestaMefConfig.subjectPrenotazioneEliminata()));
	  richiestaNoApprovazioneTmpl =  portletPreferences.getValue(
	     		"richiestaNoApprovazioneTmpl", String.valueOf(richiestaMefConfig.richiestaNoApprovazioneTmpl()));
	  richiestaApprovazioneTmpl =  portletPreferences.getValue(
	     		"richiestaApprovazioneTmpl", String.valueOf(richiestaMefConfig.richiestaApprovazioneTmpl()));
	  prenotazioneAutorizzataTmpl =  portletPreferences.getValue(
	     		"prenotazioneAutorizzataTmpl", String.valueOf(richiestaMefConfig.prenotazioneAutorizzataTmpl()));
	  prenotazioneRifiutataTmpl =  portletPreferences.getValue(
	     		"prenotazioneRifiutataTmpl", String.valueOf(richiestaMefConfig.prenotazioneRifiutataTmpl()));
	  prenotazioneModificataTmpl =  portletPreferences.getValue(
	     		"prenotazioneModificataTmpl", String.valueOf(richiestaMefConfig.prenotazioneModificataTmpl()));
	  prenotazioneEliminataTmpl =  portletPreferences.getValue(
	     		"prenotazioneEliminataTmpl", String.valueOf(richiestaMefConfig.prenotazioneEliminataTmpl()));
	  formTitleInsertPrenotazioni =  portletPreferences.getValue(
		 		"formTitleInsertPrenotazioni", String.valueOf(richiestaMefConfig.formTitleInsertPrenotazioni()));
	  formSubtitleInsertPrenotazioni =  portletPreferences.getValue(
		 		"formSubtitleInsertPrenotazioni", String.valueOf(richiestaMefConfig.formSubtitleInsertPrenotazioni()));
	  formTitleLeTuePrenotazioni =  portletPreferences.getValue(
		 		"formTitleLeTuePrenotazioni", String.valueOf(richiestaMefConfig.formTitleLeTuePrenotazioni()));
	  formSubtitleLeTuePrenotazioni =  portletPreferences.getValue(
		 		"formSubtitleLeTuePrenotazioni", String.valueOf(richiestaMefConfig.formSubtitleLeTuePrenotazioni()));
	  formTitleRicercaAuleApprovatore =  portletPreferences.getValue(
				"formTitleRicercaAuleApprovatore", String.valueOf(richiestaMefConfig.formTitleRicercaAuleApprovatore()));
	  formSubtitleRicercaAuleApprovatore =  portletPreferences.getValue(
				"formSubtitleRicercaAuleApprovatore", String.valueOf(richiestaMefConfig.formSubtitleRicercaAuleApprovatore()));
	  formTitleRicercaAule =  portletPreferences.getValue(
			 		"formTitleRicercaAule", String.valueOf(richiestaMefConfig.formTitleRicercaAule()));
	  formSubtitleRicercaAule =  portletPreferences.getValue(
			 		"formSubtitleRicercaAule", String.valueOf(richiestaMefConfig.formSubtitleRicercaAule()));

}



%>