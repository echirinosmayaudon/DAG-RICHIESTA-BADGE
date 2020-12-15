<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="mef.organigramma.portlet.MefOrganigrammaConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
MefOrganigrammaConfig organigrammaMefConfig = (MefOrganigrammaConfig) renderRequest.getAttribute(MefOrganigrammaConfig.class.getName());
String officeDetailUrl = StringPool.BLANK;
if (Validator.isNotNull(organigrammaMefConfig)){
	officeDetailUrl =  portletPreferences.getValue(
      		"officeDetailUrl", String.valueOf(organigrammaMefConfig.officeDetailUrl()));
}
%>
