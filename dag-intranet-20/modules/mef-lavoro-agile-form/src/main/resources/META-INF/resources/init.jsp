<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.LocalizationUtil"%>   
<%@ page import="com.accenture.mef.lavoro.agile.form.portlet.MefLavoroAgileConfig" %>

<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	MefLavoroAgileConfig mefLavoroAgileConfig = (MefLavoroAgileConfig)renderRequest.getAttribute(MefLavoroAgileConfig.class.getName());
	
	String formTitle = StringPool.BLANK;
	String formSubTitle = StringPool.BLANK;
	String formTitleRecap = StringPool.BLANK;
	String formSubTitleRecap = StringPool.BLANK;
	String formTitleDettaglio = StringPool.BLANK;
	String formSubTitleDettaglio = StringPool.BLANK;
	String formTitleSearch = StringPool.BLANK;
	String formSubTitleSearch = StringPool.BLANK;
	String sender = StringPool.BLANK;
	String emailSubject = StringPool.BLANK;
	String emailToDipDT = StringPool.BLANK;
	String emailToDipRGS = StringPool.BLANK;
	String emailToDipDF = StringPool.BLANK;
	String emailToDipDAG = StringPool.BLANK;
	String emailBody = StringPool.BLANK;
	String bando = StringPool.BLANK;
	String regolamento = StringPool.BLANK;
	String itemsPerPage = StringPool.BLANK;
	String dataInizioInserimentoRichiesta = StringPool.BLANK;
	String oraInizioInserimentoRichiesta = StringPool.BLANK;
	String dataFineInserimentoRichiesta = StringPool.BLANK;
	String oraFineInserimentoRichiesta = StringPool.BLANK;
	String dataInizioInserimentoAllegato = StringPool.BLANK;
	String oraInizioInserimentoAllegato = StringPool.BLANK;
	String dataFineInserimentoAllegato = StringPool.BLANK;
	String oraFineInserimentoAllegato = StringPool.BLANK;
	String msgTerminiScaduti = StringPool.BLANK;
	String msgNuovoAllegato = StringPool.BLANK;

	
	if (Validator.isNotNull(mefLavoroAgileConfig)) {
		
		formTitle = portletPreferences.getValue("formTitle", mefLavoroAgileConfig.formTitle());
		
		formSubTitle= portletPreferences.getValue("formSubTitle", mefLavoroAgileConfig.formSubTitle());
		
		formTitleRecap = portletPreferences.getValue("formTitleRecap", mefLavoroAgileConfig.formTitleRecap());
		
		formSubTitleRecap = portletPreferences.getValue("formSubTitleRecap", mefLavoroAgileConfig.formSubTitleRecap());
		
		formTitleDettaglio = portletPreferences.getValue("formTitleDettaglio", mefLavoroAgileConfig.formTitleDettaglio());
		
		formSubTitleDettaglio = portletPreferences.getValue("formSubTitleDettaglio", mefLavoroAgileConfig.formSubTitleDettaglio());
		
		formTitleSearch = portletPreferences.getValue("formTitleSearch", mefLavoroAgileConfig.formTitleSearch());
		
		formSubTitleSearch = portletPreferences.getValue("formSubTitleSearch", mefLavoroAgileConfig.formSubTitleSearch());
		
		sender = portletPreferences.getValue("sender", mefLavoroAgileConfig.sender());
		
		emailSubject = portletPreferences.getValue("emailSubject", mefLavoroAgileConfig.emailSubject());
		
		emailToDipDT = portletPreferences.getValue("emailToDipDT", mefLavoroAgileConfig.emailToDipDT());
		
		emailToDipRGS = portletPreferences.getValue("emailToDipRGS", mefLavoroAgileConfig.emailToDipRGS());
		
		emailToDipDF = portletPreferences.getValue("emailToDipDF", mefLavoroAgileConfig.emailToDipDF());
		
		emailToDipDAG = portletPreferences.getValue("emailToDipDAG", mefLavoroAgileConfig.emailToDipDAG());
		
		emailBody = portletPreferences.getValue("emailBody", mefLavoroAgileConfig.emailBody());
		
		bando = portletPreferences.getValue("bando", mefLavoroAgileConfig.bando());
		
		regolamento = portletPreferences.getValue("regolamento", mefLavoroAgileConfig.regolamento());
		
		itemsPerPage = portletPreferences.getValue("itemsPerPage", mefLavoroAgileConfig.itemsPerPage());
		
		dataInizioInserimentoRichiesta = portletPreferences.getValue("dataInizioInserimentoRichiesta", mefLavoroAgileConfig.dataInizioInserimentoRichiesta());
		
		oraInizioInserimentoRichiesta = portletPreferences.getValue("oraInizioInserimentoRichiesta", mefLavoroAgileConfig.oraInizioInserimentoRichiesta());
		
		dataFineInserimentoRichiesta = portletPreferences.getValue("dataFineInserimentoRichiesta", mefLavoroAgileConfig.dataFineInserimentoRichiesta());
		
		oraFineInserimentoRichiesta = portletPreferences.getValue("oraFineInserimentoRichiesta", mefLavoroAgileConfig.oraFineInserimentoRichiesta());
		
		dataInizioInserimentoAllegato = portletPreferences.getValue("dataInizioInserimentoAllegato", mefLavoroAgileConfig.dataInizioInserimentoAllegato());
		
		oraInizioInserimentoAllegato = portletPreferences.getValue("oraInizioInserimentoAllegato", mefLavoroAgileConfig.oraInizioInserimentoAllegato());
		
		dataFineInserimentoAllegato = portletPreferences.getValue("dataFineInserimentoAllegato", mefLavoroAgileConfig.dataFineInserimentoAllegato());
		
		oraFineInserimentoAllegato = portletPreferences.getValue("oraFineInserimentoAllegato", mefLavoroAgileConfig.oraFineInserimentoAllegato());
		
		msgTerminiScaduti = portletPreferences.getValue("msgTerminiScaduti", mefLavoroAgileConfig.msgTerminiScaduti());
		
		msgNuovoAllegato = portletPreferences.getValue("msgNuovoAllegato", mefLavoroAgileConfig.msgNuovoAllegato());
	}
%>
