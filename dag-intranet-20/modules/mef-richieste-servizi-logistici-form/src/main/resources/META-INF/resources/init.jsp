<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@page import="com.intranet.mef.portlet.RichiesteServiziLogisticiConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
RichiesteServiziLogisticiConfig richiesteConfig =
        (RichiesteServiziLogisticiConfig)
        renderRequest.getAttribute(RichiesteServiziLogisticiConfig.class.getName());

	String sender = StringPool.BLANK;
	String subject = StringPool.BLANK;
	String emailGestore = StringPool.BLANK;
	String richiestaTmpl = StringPool.BLANK;

	String cambioStatosender = StringPool.BLANK;
	String cambioStatosubject = StringPool.BLANK;
	String cambioStatoTmpl = StringPool.BLANK;
	
	
    String serviziLogisticitxt = StringPool.BLANK;
    String serviziLogisticititle = StringPool.BLANK;
  	String serviziLogisticiDettagliotxt = StringPool.BLANK;
    String serviziLogisticiDettagliotitle = StringPool.BLANK;
	String serviziLogisticiElencotxt = StringPool.BLANK;
    String serviziLogisticiElencotitle = StringPool.BLANK;
  
    String itemsPerPage = StringPool.BLANK;
    
    if (Validator.isNotNull(richiesteConfig)) {
    	
    	
    	sender =  portletPreferences.getValue(
     		"sender", String.valueOf(richiesteConfig.sender()));
	  subject =  portletPreferences.getValue(
     		"subject", String.valueOf(richiesteConfig.subject()));
	  richiestaTmpl =  portletPreferences.getValue(
	     		"richiestaTmpl", String.valueOf(richiesteConfig.richiestaTmpl()));
	  
	  cambioStatosender =  portletPreferences.getValue(
	     		"cambioStatosender", String.valueOf(richiesteConfig.cambioStatosender()));
	  cambioStatosubject =  portletPreferences.getValue(
	     		"cambioStatosubject", String.valueOf(richiesteConfig.cambioStatosubject()));
	  cambioStatoTmpl =  portletPreferences.getValue(
		     		"cambioStatoTmpl", String.valueOf(richiesteConfig.cambioStatoTmpl()));
	  
	  emailGestore =  portletPreferences.getValue(
	     		"emailGestore", String.valueOf(richiesteConfig.emailGestore()));
    
    	serviziLogisticitxt = portletPreferences.getValue(
                "serviziLogisticitxt", richiesteConfig.serviziLogisticitxt());
    	
    	serviziLogisticititle = portletPreferences.getValue(
                "serviziLogisticititle", richiesteConfig.serviziLogisticititle());
    	
    	
		serviziLogisticiDettagliotxt = portletPreferences.getValue(
                "serviziLogisticiDettagliotxt", richiesteConfig.serviziLogisticiDettagliotxt());
    	
    	serviziLogisticiDettagliotitle = portletPreferences.getValue(
                "serviziLogisticiDettagliotitle", richiesteConfig.serviziLogisticiDettagliotitle());
				
		serviziLogisticiElencotxt = portletPreferences.getValue(
                "serviziLogisticiElencotxt", richiesteConfig.serviziLogisticiElencotxt());
    	
    	serviziLogisticiElencotitle = portletPreferences.getValue(
                "serviziLogisticiElencotitle", richiesteConfig.serviziLogisticiElencotitle());
    	
    	itemsPerPage =  portletPreferences.getValue(
        		"itemsPerPage", String.valueOf(richiesteConfig.itemsPerPage()));
    	
      
    }
    %>