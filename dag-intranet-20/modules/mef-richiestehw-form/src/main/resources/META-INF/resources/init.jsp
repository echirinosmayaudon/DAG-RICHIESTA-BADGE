<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="mef.richiestehw.portlet.MefRichiestehwConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%

MefRichiestehwConfig richiestaMefConfig = (MefRichiestehwConfig) renderRequest.getAttribute(MefRichiestehwConfig.class.getName());
String sender = StringPool.BLANK;
String subject = StringPool.BLANK;
String emailReferente = StringPool.BLANK;
String richiestaTmpl = StringPool.BLANK;
String formTitle = StringPool.BLANK;
String formSubtitle = StringPool.BLANK;
String recapTitle = StringPool.BLANK;
String recapSubtitle = StringPool.BLANK;
if (Validator.isNotNull(richiestaMefConfig)){
	 sender =  portletPreferences.getValue(
     		"sender", String.valueOf(richiestaMefConfig.sender()));
	  subject =  portletPreferences.getValue(
     		"subject", String.valueOf(richiestaMefConfig.subject()));
	  richiestaTmpl =  portletPreferences.getValue(
	     		"richiestaTmpl", String.valueOf(richiestaMefConfig.richiestaTmpl()));
	  emailReferente =  portletPreferences.getValue(
	     		"emailReferente", String.valueOf(richiestaMefConfig.emailReferente()));
	  formTitle =  portletPreferences.getValue(
	     		"formTitle", String.valueOf(richiestaMefConfig.formTitle()));
	  formSubtitle =  portletPreferences.getValue(
	     		"formSubtitle", String.valueOf(richiestaMefConfig.formSubtitle()));
	  recapTitle =  portletPreferences.getValue(
	     		"recapTitle", String.valueOf(richiestaMefConfig.recapTitle()));
	  recapSubtitle =  portletPreferences.getValue(
	     		"recapSubtitle", String.valueOf(richiestaMefConfig.recapSubtitle()));
}

%>
