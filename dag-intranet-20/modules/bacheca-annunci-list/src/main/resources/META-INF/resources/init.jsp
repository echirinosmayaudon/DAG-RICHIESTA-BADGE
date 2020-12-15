<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="bacheca.annunci.list.portlet.BachecaAnnunciListConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil" %><%@
page import="com.liferay.portal.kernel.settings.ParameterMapSettingsLocator" %><%@
page import="com.liferay.portal.kernel.settings.PortletInstanceSettingsLocator" %><%@
page import="com.liferay.portal.kernel.util.Constants" %>

<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>

<%@ page import="com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
BachecaAnnunciListConfig annunciMefConfig =
        (BachecaAnnunciListConfig)
        renderRequest.getAttribute(BachecaAnnunciListConfig.class.getName());

    String viewTheme = StringPool.BLANK;
    String zona = StringPool.BLANK;
	 String metaAreaCategoria = StringPool.BLANK;

    String itemsPerPage = StringPool.BLANK;
    String bachecaPage = StringPool.BLANK;

    String sender = StringPool.BLANK;
    String subject = StringPool.BLANK;
    String inserisciannuncioTmpl = StringPool.BLANK;
    
    if (Validator.isNotNull(annunciMefConfig)) {
    	viewTheme = portletPreferences.getValue(
                "viewTheme", annunciMefConfig.viewTheme());
    	
    	zona = portletPreferences.getValue(
                "zona", annunciMefConfig.zona());
    	
    	 itemsPerPage =  portletPreferences.getValue(
         		"itemsPerPage", String.valueOf(annunciMefConfig.itemsPerPage()));
    	  bachecaPage =  portletPreferences.getValue(
          		"bachecaPage", String.valueOf(annunciMefConfig.bachecaPage()));
    	  sender =  portletPreferences.getValue(
            		"sender", String.valueOf(annunciMefConfig.sender()));
    	  subject =  portletPreferences.getValue(
            		"subject", String.valueOf(annunciMefConfig.subject()));
    	  
    	  inserisciannuncioTmpl =  portletPreferences.getValue(
          		"inserisciannuncioTmpl", String.valueOf(annunciMefConfig.inserisciannuncioTmpl()));
    	metaAreaCategoria = portletPreferences.getValue(
                "metaAreaCategoria", annunciMefConfig.metaAreaCategoria());
    }
%>



