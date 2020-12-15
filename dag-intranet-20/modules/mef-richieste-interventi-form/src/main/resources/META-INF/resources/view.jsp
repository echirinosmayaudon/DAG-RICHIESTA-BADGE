<%@ include file="/init.jsp" %>
<%@page import="mef.richieste.interventi.beans.Richiedente"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%

String navigation = (String) request.getAttribute("navigation");

if(navigation == null){
	navigation = (String) ParamUtil.getString(request,"navigation");
}

if(request.getAttribute("richiedente")!=null){
	Richiedente richiedente = (Richiedente)request.getAttribute("richiedente");
%>
<c:choose>
<c:when test='<%= navigation!=null && navigation.equals("riepilogo") %>'>
	<%@ include file="/riepilogo.jsp"%>
</c:when>
<c:otherwise>
	<%@ include file="/inserimentoRichiesteInterventi.jsp"%>
</c:otherwise>

</c:choose>

<% } else{
	%>
Pagina non trovata
<%}%>