<%@ include file="/init.jsp" %>
<% 
String navigation ="home";
if(request.getAttribute("navigation")!=null)
	navigation = (String) request.getAttribute("navigation");

String roleuser = (String) request.getParameter("roleuser");
%>


<c:if test='<%= roleuser != null && roleuser.equals("gestore")%>'>
	<%@ include file="/servizi-logistici-dettaglio.jsp"%>
</c:if>


<c:if test='<%= roleuser == null || !roleuser.equals("gestore")%>'>
	<c:choose>	
		<c:when test='<%=navigation.equalsIgnoreCase("dettaglio")%>'>
			<%@ include file="/servizi-logistici-dettaglio.jsp"%>
		</c:when>
		<c:when test='<%=navigation.equalsIgnoreCase("elenco")%>'>
			<%@ include file="/servizi-logistici-elenco.jsp"%>
		</c:when>
		<c:when test='<%=navigation.equalsIgnoreCase("forbidden")%>'>
			<%@ include file="/servizi-logistici-forbidden.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="/servizi-logistici.jsp" %>
		</c:otherwise>
	</c:choose>
</c:if>