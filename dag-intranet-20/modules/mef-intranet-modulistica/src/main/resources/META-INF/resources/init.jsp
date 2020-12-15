<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet"	prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="modulistica.mef.portlet.ModulisticaMefConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Locale"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="com.liferay.asset.kernel.model.AssetVocabulary" %>
<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>



<liferay-theme:defineObjects />

<portlet:defineObjects />


<% ModulisticaMefConfig modulisticaMefConfig =
        (ModulisticaMefConfig)
        renderRequest.getAttribute(ModulisticaMefConfig.class.getName());

    String viewTheme = StringPool.BLANK;
    String modulisticaPage = StringPool.BLANK;
    String itemsPerPage = StringPool.BLANK;
    String folder = StringPool.BLANK;
    String days = StringPool.BLANK;
    
    if (Validator.isNotNull(modulisticaMefConfig)) {
    	viewTheme = portletPreferences.getValue(
                "viewTheme", modulisticaMefConfig.viewTheme());
    	folder = portletPreferences.getValue(
                "folder", modulisticaMefConfig.folder());
    	days = portletPreferences.getValue(
                "days", String.valueOf(modulisticaMefConfig.days()));
        itemsPerPage =  portletPreferences.getValue(
        		"itemsPerPage", String.valueOf(modulisticaMefConfig.itemsPerPage()));
        modulisticaPage =  portletPreferences.getValue(
        		"modulisticaPage", String.valueOf(modulisticaMefConfig.modulisticaPage()));
      
        
    }
%>