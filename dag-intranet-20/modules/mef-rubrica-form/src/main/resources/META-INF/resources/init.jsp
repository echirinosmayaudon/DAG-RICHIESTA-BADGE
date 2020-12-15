<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.mef.intranet.rubrica.portlet.portlet.MefRubricaFormConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />

<% MefRubricaFormConfig rubricaFormConfig =
(MefRubricaFormConfig)
renderRequest.getAttribute(MefRubricaFormConfig.class.getName());

String itemsPerPage = StringPool.BLANK;
String lastResearch = StringPool.BLANK;
    
    if (Validator.isNotNull(rubricaFormConfig)) {
        itemsPerPage =  portletPreferences.getValue(
        		"itemsPerPage", String.valueOf(rubricaFormConfig.itemsPerPage()));
        lastResearch =  portletPreferences.getValue(
        		"lastResearch", String.valueOf(rubricaFormConfig.lastResearch()));
     
        
        
    }
%>