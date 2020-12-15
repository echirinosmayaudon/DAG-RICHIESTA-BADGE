<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="mef.richieste.beni.inventariati.portlet.MefRichiesteBeniInventariatiConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="java.lang.StringBuilder" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%

MefRichiesteBeniInventariatiConfig richiestaMefBeniInvConfig = (MefRichiesteBeniInventariatiConfig) renderRequest.getAttribute(MefRichiesteBeniInventariatiConfig.class.getName());
String nuovaRichiestaSender = StringPool.BLANK;
String nuovaRichiestaSubject = StringPool.BLANK;
String nuovaRichiestaTmpl = StringPool.BLANK;
String cambioStatoConsegnatarioSender = StringPool.BLANK;
String cambioStatoConsegnatarioSubject = StringPool.BLANK;
String cambioStatoConsegnatarioTmpl = StringPool.BLANK;
String cambioStatoCDCSender = StringPool.BLANK;
String cambioStatoCDCSubject = StringPool.BLANK;
String cambioStatoCDCTmpl = StringPool.BLANK;

String beniInvRicercaTitle = StringPool.BLANK;
String beniInvRicercaTxt = StringPool.BLANK;
String beniInvInserimentoTitle = StringPool.BLANK;
String beniInvInserimentoTxt = StringPool.BLANK;

if (Validator.isNotNull(richiestaMefBeniInvConfig)){
	nuovaRichiestaSender =  portletPreferences.getValue(
     		"nuovaRichiestaSender", String.valueOf(richiestaMefBeniInvConfig.nuovaRichiestaSender()));
	nuovaRichiestaSubject =  portletPreferences.getValue(
     		"nuovaRichiestaSubject", String.valueOf(richiestaMefBeniInvConfig.nuovaRichiestaSubject()));
	nuovaRichiestaTmpl =  portletPreferences.getValue(
	     		"nuovaRichiestaTmpl", String.valueOf(richiestaMefBeniInvConfig.nuovaRichiestaTmpl()));
	cambioStatoConsegnatarioSender =  portletPreferences.getValue(
	     		"cambioStatoConsegnatarioSender", String.valueOf(richiestaMefBeniInvConfig.cambioStatoConsegnatarioSender()));
	cambioStatoConsegnatarioSubject =  portletPreferences.getValue(
	     		"cambioStatoConsegnatarioSubject", String.valueOf(richiestaMefBeniInvConfig.cambioStatoConsegnatarioSubject()));
	cambioStatoConsegnatarioTmpl =  portletPreferences.getValue(
		     		"cambioStatoConsegnatarioTmpl", String.valueOf(richiestaMefBeniInvConfig.cambioStatoConsegnatarioTmpl()));
	cambioStatoCDCSender =  portletPreferences.getValue(
		     		"cambioStatoCDCSender", String.valueOf(richiestaMefBeniInvConfig.cambioStatoCDCSender()));
	cambioStatoCDCSubject =  portletPreferences.getValue(
		     		"cambioStatoCDCSubject", String.valueOf(richiestaMefBeniInvConfig.cambioStatoCDCSubject()));
	cambioStatoCDCTmpl =  portletPreferences.getValue(
			     		"cambioStatoCDCTmpl", String.valueOf(richiestaMefBeniInvConfig.cambioStatoCDCTmpl()));
	
	
	beniInvRicercaTitle = portletPreferences.getValue(
            "beniInvRicercaTitle", String.valueOf(richiestaMefBeniInvConfig.beniInvRicercaTitle()));
	
	beniInvRicercaTxt = portletPreferences.getValue(
            "beniInvRicercaTxt", String.valueOf(richiestaMefBeniInvConfig.beniInvRicercaTxt()));
			
	beniInvInserimentoTitle = portletPreferences.getValue(
            "beniInvInserimentoTitle",String.valueOf(richiestaMefBeniInvConfig.beniInvInserimentoTitle()));
	
	beniInvInserimentoTxt = portletPreferences.getValue(
            "beniInvInserimentoTxt", String.valueOf(richiestaMefBeniInvConfig.beniInvInserimentoTxt()));
}

%>