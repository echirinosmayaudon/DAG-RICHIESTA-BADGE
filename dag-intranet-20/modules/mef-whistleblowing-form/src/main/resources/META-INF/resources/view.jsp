<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mef.whistleblowing.form.beans.Segnalazione"%>
<%@page import="mef.whistleblowing.form.beans.Richiedente"%>
<%@page import="mef.whistleblowing.form.beans.Allegato"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<% 
Log _logJsp = LogFactoryUtil.getLog(String.class);

String nav = (String)request.getAttribute("navigation");

if(nav == null) {
	nav = (String) ParamUtil.getString(request,"navigation");
}

Richiedente richiedente = new Richiedente();
Segnalazione moduloSegnalazione = new Segnalazione();

if(request.getAttribute("richiedente")!=null) {
	richiedente = (Richiedente) request.getAttribute("richiedente");
}

if(request.getAttribute("moduloSegnalazione")!=null) {
	moduloSegnalazione = (Segnalazione) request.getAttribute("moduloSegnalazione");
}
%>

<c:if test='<%= nav!=null && nav.equals("inserimento") %>'>
	<%@ include file="/inserimento.jsp"%>
</c:if>

<c:if test='<%= nav!=null && nav.equals("riepilogo") %>'>
	<%@ include file="/riepilogo.jsp"%>
</c:if>

<script>

	window.setTimeout(function() {
	             window.Parsley
	             .addValidator('checkDateBeforeToday', {
	        		requirementType : 'string',
	        		validateString :function(value, requirement){
	            	var requirementSplit = $(requirement).val().split("/");
	            	submissionDate = new Date(requirementSplit[2], requirementSplit[1] - 1, requirementSplit[0]);
	            	var today = new Date();
	            	if( submissionDate > today) {
	                return false;
	              }
	                return true;
		        },
		        messages : {
		            it: '<liferay-ui:message key="error-compare-check-date-before-today"/>',
		            en: '<liferay-ui:message key="error-compare-check-date-before-today"/>'
		        }
	    });
	 }, 2000); 

</script>
