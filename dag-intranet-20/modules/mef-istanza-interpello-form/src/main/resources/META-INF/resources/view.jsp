<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%
	Log _log = LogFactoryUtil.getLog("view_jsp");

	String navigation = "home";
    if (request.getParameter("navigation")!=null)
    	navigation= (String)request.getParameter("navigation");
	if (request.getAttribute("navigation")!=null) 
		navigation = (String) request.getAttribute("navigation");
%>

<c:choose>
	<c:when test='<%=(navigation.equalsIgnoreCase("recap") || navigation.equalsIgnoreCase("detail") || request.getAttribute("richIstInterpelloId")!= null)%>'>
		<jsp:include page="recap.jsp" />
	</c:when>	
	<c:otherwise>
		<jsp:include page="form.jsp" />
	</c:otherwise>
</c:choose>