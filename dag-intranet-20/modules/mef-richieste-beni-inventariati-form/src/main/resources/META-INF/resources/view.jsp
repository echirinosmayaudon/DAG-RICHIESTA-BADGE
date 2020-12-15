<%@ include file="/init.jsp" %>
<%@page import="mef.richieste.beni.inventariati.bean.Utente"%>


<%
String navigation = "home";
if(request.getAttribute("navigation")!=null) {
      navigation = (String) request.getAttribute("navigation");
}
if(request.getParameter("navigation")!=null) {
      navigation = (String)request.getParameter("navigation");
}

Utente utente = null;
if(request.getAttribute("utente")!=null){
	utente = (Utente)request.getAttribute("utente");
}
%>

<c:choose>
<c:when test='<%=navigation.equalsIgnoreCase("home") && (boolean)request.getAttribute("richiedenteRole")%>'>
<%@ include file="/richiestaBeniInventariati.jsp" %>
</c:when>
<c:when test='<%=navigation.equalsIgnoreCase("home") && !(boolean)request.getAttribute("richiedenteRole")%>'>
<%@ include file="/ricercaBeniInventariati.jsp" %>
</c:when>
<c:when test='<%=navigation.equalsIgnoreCase("vaiARicerca")%>'>
<%@ include file="/ricercaBeniInventariati.jsp" %>
</c:when>
<c:when test='<%=navigation.equalsIgnoreCase("riepilogo")%>'>
<%@ include file="/riepilogoRichiesta.jsp" %>
</c:when>
<c:otherwise>
<%@ include file="/dettaglioRichiesta.jsp"%>
</c:otherwise>
</c:choose>
