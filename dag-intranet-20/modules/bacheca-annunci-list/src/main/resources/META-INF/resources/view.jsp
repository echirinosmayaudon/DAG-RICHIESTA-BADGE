<%@ include file="/init.jsp" %>

<% 
String nav= (String)request.getParameter("navigation");

if (request.getAttribute("navigation")!=null) {
	nav = (String)request.getAttribute("navigation");
}
%>


<c:if test='<%= nav!=null && nav.equals("inserisciannuncio") %>'>
	<%@ include file="/inserisciannuncio.jsp"%>
</c:if>

<c:if test='<%= nav!=null && nav.equals("advdetail") %>'>
	<%@ include file="/annuncioview.jsp"%>
</c:if>

<c:if test='<%= nav!=null && nav.equals("dialogupdate") %>'>
	<%@ include file="/dialogupdate.jsp"%>
</c:if>

<c:if test='<%=nav==null || (!nav.equals("inserisciannuncio") && !nav.equals("advdetail") && !nav.equals("dialogupdate")) %>'>

	<c:if test='<%= viewTheme.equals("list") %>'>
		<%@ include file="/advertises.jsp"%>
	</c:if>
	
	<c:if test='<%= viewTheme.equals("grid") %>'>
		<%@ include file="/advertisesgrid.jsp"%>
	</c:if>
	
	<c:if test='<%= viewTheme.equals("myadvertise") %>'>
		<%@ include file="/myadvertise.jsp"%>
	</c:if>

</c:if>