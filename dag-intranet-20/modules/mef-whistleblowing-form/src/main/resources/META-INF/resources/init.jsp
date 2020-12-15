<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="mef.whistleblowing.form.portlet.MefWhistleBlowingConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<% 
MefWhistleBlowingConfig whislteBlowingConfig = (MefWhistleBlowingConfig)renderRequest.getAttribute(MefWhistleBlowingConfig.class.getName());

String formTitle = StringPool.BLANK;
String formSubtitle = StringPool.BLANK;
String recapTitle = StringPool.BLANK;
String recapSubtitle = StringPool.BLANK;
String emailReferente = StringPool.BLANK;
String sender = StringPool.BLANK;
String subject = StringPool.BLANK;
String segnalazioneTmpl = StringPool.BLANK;
String salvataggioDB = StringPool.BLANK;

if (Validator.isNotNull(whislteBlowingConfig)){
	
	  formTitle =  portletPreferences.getValue(
	     		"formTitle", String.valueOf(whislteBlowingConfig.formTitle()));
	  formSubtitle =  portletPreferences.getValue(
	     		"formSubtitle", String.valueOf(whislteBlowingConfig.formSubtitle()));
	  recapTitle =  portletPreferences.getValue(
	     		"recapTitle", String.valueOf(whislteBlowingConfig.recapTitle()));
	  recapSubtitle =  portletPreferences.getValue(
	     		"recapSubtitle", String.valueOf(whislteBlowingConfig.recapSubtitle()));
	  
	  emailReferente =  portletPreferences.getValue(
	     		"emailReferente", String.valueOf(whislteBlowingConfig.emailReferente()));
	  sender =  portletPreferences.getValue(
	     		"sender", String.valueOf(whislteBlowingConfig.sender()));
	  subject =  portletPreferences.getValue(
	     		"subject", String.valueOf(whislteBlowingConfig.subject()));
	  segnalazioneTmpl =  portletPreferences.getValue(
	     		"segnalazioneTmpl", String.valueOf(whislteBlowingConfig.segnalazioneTmpl()));
	  salvataggioDB =  portletPreferences.getValue(
	     		"salvataggioDB", String.valueOf(whislteBlowingConfig.salvataggioDB()));
}
%>

<style>
.bg-whistleblowing {
  padding: 130px 0;
  background-color: #1f6b91;
}
.bg-whistleblowing .button {
  width: 100%;
  display: inline-block;
  background-color: #2c354f;
  height: 90px;
  line-height: 90px;
  text-align: center;
}
.bg-whistleblowing .button span {
  display: inline-block;
  vertical-align: middle;
  line-height: normal;
}
.bg-whistleblowing .button span.text {
  font-size: 40px;
  margin-left: 10px;
  color: white;
  letter-spacing: 0.8px;
}
.bg-whistleblowing .button span.icon-btn {
  font-size: 60px;
  color: white;
}
.bg-whistleblowing .button:hover, .bg-whistleblowing .button:focus {
  background-color: #57ca85;
}
@media (max-width: 767px) {
  .bg-whistleblowing {
    padding: 75px 0;
  }
  .bg-whistleblowing .button {
    height: 50px;
    line-height: 50px;
  }
  .bg-whistleblowing .button span {
    display: inline-block;
  }
  .bg-whistleblowing .button span.text {
    font-size: 24px;
    margin-left: 10px;
  }
  .bg-whistleblowing .button span.icon-btn {
    font-size: 32px;
  }
}
</style>