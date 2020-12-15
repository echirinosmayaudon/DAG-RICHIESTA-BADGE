<%@ include file="/init.jsp" %>

<%
String navigation = "home";

if(request.getAttribute("navigation")!=null) {
    navigation = (String) request.getAttribute("navigation");
}

if(request.getParameter("navigation")!=null) {
    navigation = (String)request.getParameter("navigation");
}
%>

<c:choose>
<c:when test='<%=navigation.equalsIgnoreCase("home")%>'>
	<%@ include file="/ricercaAule.jsp"%>
</c:when>
<c:when test='<%=navigation.equalsIgnoreCase("leTuePrenotazioni")%>'>
	<%@ include file="/leTuePrenotazioni.jsp"%>
</c:when>
<c:when test='<%=navigation.equalsIgnoreCase("prenotaAula")%>'>
	<%@ include file="/prenotaAula.jsp"%>
</c:when>
<c:when test='<%=navigation.equalsIgnoreCase("dettaglioPrenotazione")%>'>
	<%@ include file="/dettaglioPrenotazione.jsp"%>
</c:when>
<c:otherwise>
<%@ include file="/dettaglioPrenotazione.jsp"%>
</c:otherwise>
</c:choose>