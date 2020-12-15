<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="mef.richieste.pub.siti.internet.portlet.MefRichiestePubblicConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
MefRichiestePubblicConfig richiestePubblicConfig=
(MefRichiestePubblicConfig)
renderRequest.getAttribute(MefRichiestePubblicConfig.class.getName());

String sender = StringPool.BLANK;
String subject= StringPool.BLANK;
String emailReferente = StringPool.BLANK;
String linkPaginaGuida = StringPool.BLANK;
String pubblicazioneSitiTmpl = StringPool.BLANK;
String serviziPubblicazioneSitiTitle = StringPool.BLANK;
String serviziPubblicazioneSitiSubTitle = StringPool.BLANK;

if (Validator.isNotNull(richiestePubblicConfig)) {
	
	sender = portletPreferences.getValue(
            "sender", richiestePubblicConfig.sender());
	
	subject = portletPreferences.getValue(
            "subject", richiestePubblicConfig.subject());
	
	emailReferente = portletPreferences.getValue(
            "emailReferente", richiestePubblicConfig.emailReferente());
	
	linkPaginaGuida = portletPreferences.getValue(
            "linkPaginaGuida", richiestePubblicConfig.linkPaginaGuida());

	pubblicazioneSitiTmpl = portletPreferences.getValue(
            "pubblicazioneSitiTmpl", richiestePubblicConfig.pubblicazioneSitiTmpl());
	
	serviziPubblicazioneSitiTitle = portletPreferences.getValue(
		"serviziPubblicazioneSitiTitle", String.valueOf(richiestePubblicConfig.serviziPubblicazioneSitiTitle()));
	
	serviziPubblicazioneSitiSubTitle = portletPreferences.getValue(
		"serviziPubblicazioneSitiSubTitle", String.valueOf(richiestePubblicConfig.serviziPubblicazioneSitiSubTitle()));
}

%>