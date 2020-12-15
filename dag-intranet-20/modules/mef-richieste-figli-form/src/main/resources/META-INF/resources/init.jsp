<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.Constants" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="mef.richieste.figli.form.Configuration.mefRichiesteFigliFormConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.model.Role" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
   
<%
    mefRichiesteFigliFormConfiguration richiesteFigliFormConfiguration =
        (mefRichiesteFigliFormConfiguration)
        renderRequest.getAttribute(mefRichiesteFigliFormConfiguration.class.getName());

 	 String richiestaRimborsoTmpl = StringPool.BLANK;
	 String senderRichiestaRimborso= StringPool.BLANK; 
	 String emailReferente= StringPool.BLANK;
	 String subjectRichiestaRimborso= StringPool.BLANK;
	 String dataRichiestaRimborso= StringPool.BLANK;
	 String dimensioneAllegato= StringPool.BLANK;
	 String oggettoPDF=StringPool.BLANK;
	 String richiestaPDF=StringPool.BLANK;
	 String spesaSostenutaPDF=StringPool.BLANK;
	 String eventualiNotePDF=StringPool.BLANK;
	 String tmplRisposta=StringPool.BLANK;
	 
    if (Validator.isNotNull(richiesteFigliFormConfiguration)) {
    	subjectRichiestaRimborso=portletPreferences.getValue("subjectRichiestaRimborso", richiesteFigliFormConfiguration.subjectRichiestaRimborso());
	   	richiestaRimborsoTmpl = portletPreferences.getValue( "richiestaRimborsoTmpl", richiesteFigliFormConfiguration.richiestaRimborsoTmpl());
        senderRichiestaRimborso = portletPreferences.getValue("senderRichiestaRimborso", richiesteFigliFormConfiguration.senderRichiestaRimborso());
        emailReferente = portletPreferences.getValue("emailReferente", richiesteFigliFormConfiguration.emailReferente());
        dataRichiestaRimborso= portletPreferences.getValue("dataRichiestaRimborso", richiesteFigliFormConfiguration.dataRichiestaRimborso());
        dimensioneAllegato= portletPreferences.getValue("dimensioneAllegato", richiesteFigliFormConfiguration.dimensioneAllegato());
        oggettoPDF= portletPreferences.getValue("oggettoPDF", richiesteFigliFormConfiguration.oggettoPDF());
        richiestaPDF= portletPreferences.getValue("richiestaPDF", richiesteFigliFormConfiguration.richiestaPDF());
        spesaSostenutaPDF= portletPreferences.getValue("spesaSostenutaPDF", richiesteFigliFormConfiguration.spesaSostenutaPDF());
        eventualiNotePDF= portletPreferences.getValue("eventualiNotePDF", richiesteFigliFormConfiguration.eventualiNotePDF());
        
        
    }
    
    renderRequest.setAttribute("richiestaRimborsoTmpl", richiestaRimborsoTmpl);
    renderRequest.setAttribute("senderRichiestaRimborso", senderRichiestaRimborso);
    renderRequest.setAttribute("emailReferente", emailReferente);
    renderRequest.setAttribute("subjectRichiestaRimborso", subjectRichiestaRimborso);
    renderRequest.setAttribute("dataRichiestaRimborso", dataRichiestaRimborso);
    renderRequest.setAttribute("dimensioneAllegato", dimensioneAllegato);
    renderRequest.setAttribute("oggettoPDF", oggettoPDF);
    renderRequest.setAttribute("richiestaPDF", richiestaPDF);
    renderRequest.setAttribute("spesaSostenutaPDF", spesaSostenutaPDF);
    renderRequest.setAttribute("eventualiNotePDF", eventualiNotePDF);
    
%>
<% 
Log _log_init = LogFactoryUtil.getLog("init.jsp");

boolean isAdmin = false;
User currentUser = PortalUtil.getUser(request);
List<Role> userRolesList = RoleLocalServiceUtil.getUserRoles(currentUser.getUserId());
for(Role ruolo : userRolesList){
	
	if(ruolo.getName().equalsIgnoreCase("Administrator")){
		
		isAdmin = true;
		
	}else{
		
	}
}



%>

<% if(!isAdmin){ %>

<style>


.portlet-topper{
    display:none !important;
}

</style>


<%}else{ %>
	<style>


.portlet-topper{
    display:block !important;
}

</style>
<%}


%>