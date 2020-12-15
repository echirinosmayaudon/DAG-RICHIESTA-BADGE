<%@page import="com.accenture.mef.istanza.interpello.form.portlet.MefIstanzaInterpelloConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.LocalizationUtil"%>   

<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	MefIstanzaInterpelloConfig mefIstanzaInterpelloConfig = (MefIstanzaInterpelloConfig)renderRequest.getAttribute(MefIstanzaInterpelloConfig.class.getName());
	
	String formTitle = StringPool.BLANK;
	String formSubTitle = StringPool.BLANK;
	String formTitleRecap = StringPool.BLANK;
	String formSubTitleRecap = StringPool.BLANK;
	String formTitleDettaglio = StringPool.BLANK;
	String formSubTitleDettaglio = StringPool.BLANK;
	String sender = StringPool.BLANK;
	String emailSubject = StringPool.BLANK;
	String emailToDipDT = StringPool.BLANK;
	String emailToDipRGS = StringPool.BLANK;
	String emailToDipDF = StringPool.BLANK;
	String emailToDipDAG = StringPool.BLANK;
	String emailBody = StringPool.BLANK;
	
	if (Validator.isNotNull(mefIstanzaInterpelloConfig)) {
		
		formTitle = portletPreferences.getValue("formTitle", mefIstanzaInterpelloConfig.formTitle());
		
		formSubTitle= portletPreferences.getValue("formSubTitle", mefIstanzaInterpelloConfig.formSubTitle());
		
		formTitleRecap = portletPreferences.getValue("formTitleRecap", mefIstanzaInterpelloConfig.formTitleRecap());
		
		formSubTitleRecap = portletPreferences.getValue("formSubTitleRecap", mefIstanzaInterpelloConfig.formSubTitleRecap());
		
		formTitleDettaglio = portletPreferences.getValue("formTitleDettaglio", mefIstanzaInterpelloConfig.formTitleDettaglio());
		
		formSubTitleDettaglio = portletPreferences.getValue("formSubTitleDettaglio", mefIstanzaInterpelloConfig.formSubTitleDettaglio());
		
		sender = portletPreferences.getValue("sender", mefIstanzaInterpelloConfig.sender());
		
		emailSubject = portletPreferences.getValue("emailSubject", mefIstanzaInterpelloConfig.emailSubject());
		
		emailToDipDT = portletPreferences.getValue("emailToDipDT", mefIstanzaInterpelloConfig.emailToDipDT());
		
		emailToDipRGS = portletPreferences.getValue("emailToDipRGS", mefIstanzaInterpelloConfig.emailToDipRGS());
		
		emailToDipDF = portletPreferences.getValue("emailToDipDF", mefIstanzaInterpelloConfig.emailToDipDF());
		
		emailToDipDAG = portletPreferences.getValue("emailToDipDAG", mefIstanzaInterpelloConfig.emailToDipDAG());
		
		emailBody = portletPreferences.getValue("emailBody", mefIstanzaInterpelloConfig.emailBody());
	}
%>