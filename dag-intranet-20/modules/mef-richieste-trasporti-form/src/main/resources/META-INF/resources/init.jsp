<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@page import="com.intranet.mef.portlet.RichiesteTrasportiFormConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
RichiesteTrasportiFormConfig richiesteTrasportiConfig =
        (RichiesteTrasportiFormConfig)
        renderRequest.getAttribute(RichiesteTrasportiFormConfig.class.getName());

    String richiestaRimborsoTmpl = StringPool.BLANK;
    String senderRichiestaRimborso = StringPool.BLANK;
    String subjectRichiestaRimborso = StringPool.BLANK;
 
	String emailReferente = StringPool.BLANK;


    
    if (Validator.isNotNull(richiesteTrasportiConfig)) {
    		
    	richiestaRimborsoTmpl = portletPreferences.getValue(
                "richiestaRimborsoTmpl", richiesteTrasportiConfig.richiestaRimborsoTmpl());
    	
    	senderRichiestaRimborso = portletPreferences.getValue(
                "senderRichiestaRimborso", richiesteTrasportiConfig.senderRichiestaRimborso());
    	
    	subjectRichiestaRimborso = portletPreferences.getValue(
                "subjectRichiestaRimborso", richiesteTrasportiConfig.subjectRichiestaRimborso());
    	
		emailReferente = portletPreferences.getValue(
                "emailReferente", richiesteTrasportiConfig.emailReferente());
		
    	
		
    	
      
    }
    %>