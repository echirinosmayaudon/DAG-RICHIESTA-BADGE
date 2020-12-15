<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
final Log _log = LogFactoryUtil.getLog(String.class);


 long prefs_smc_id = GetterUtil.getLong(PropsUtil.get("id.company.social.collaboration"));

 boolean isSocialCollaborationCompany = (themeDisplay.getCompanyId() == prefs_smc_id);
%>

<c:choose>	
    <c:when test="<%= isSocialCollaborationCompany %>">
		<liferay-util:include page="/view_smc.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test="<%= !isSocialCollaborationCompany && themeDisplay.getScopeGroup().isControlPanel() %>">
		<liferay-util:include page="/view.original.jsp" useCustomPage="false" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/view_mef.jsp" servletContext="<%= application %>"  />
	</c:otherwise>
</c:choose>














