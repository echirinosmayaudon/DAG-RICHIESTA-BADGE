<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
String navigation= (String)request.getAttribute("navigation");
if(navigation == null)
{
	navigation = "inserimentoRichiesta";
}
%>
<portlet:actionURL var="vaiARicerca" name="vaiARicerca">
	<portlet:param name="richiedenteRole" value="${richiedenteRole}"/>
    <portlet:param name="consegnatarioRole" value="${consegnatarioRole}"/>
</portlet:actionURL>
<portlet:actionURL var="getListaRichieste" name="getListaRichieste">
	<portlet:param name="richiedenteRole" value="${richiedenteRole}"/>
	<portlet:param name="consegnatarioRole" value="${consegnatarioRole}"/>
</portlet:actionURL>
<portlet:actionURL var="vaiAGestioneUtenti" name="vaiAGestioneUtenti"></portlet:actionURL>
<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"></portlet:actionURL>
<c:choose>
<c:when test='<%= navigation!=null && navigation.equals("inserimentoRichiesta") %>'>
	<%@ include file="/inserimentoRichiesta.jsp"%>
</c:when>
<c:when test='<%= navigation!=null && navigation.equals("riepilogo") %>'>
	<%@ include file="/riepilogo.jsp"%>
</c:when>
<c:when test='<%= navigation!=null && navigation.equals("listarichieste") %>'>
	<%@ include file="/elencoRichiesteUtenti.jsp"%>
</c:when>
<c:when test='<%= navigation!=null && navigation.equals("risultatiricercarichieste") %>'>
	<%@ include file="/elencoRichiesteDirigente.jsp"%>
</c:when>
<c:otherwise>
	<%@ include file="/gestioneUtenti.jsp"%>
</c:otherwise>
</c:choose>
