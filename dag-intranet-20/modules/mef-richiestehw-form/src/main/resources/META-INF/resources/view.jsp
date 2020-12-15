<%@ include file="/init.jsp" %>
 <%@page import="com.liferay.portal.kernel.util.ParamUtil"%>


<% 
String nav= (String)request.getAttribute("navigation");
if(nav == null)
{
	nav = (String) ParamUtil.getString(request,"navigation");
}
%>

<c:if test='<%= nav!=null && nav.equals("inserimentohw") %>'>
	<%@ include file="/inserimentohw.jsp"%>
</c:if>

<c:if test='<%= nav!=null && nav.equals("riepilogo") %>'>
	<%@ include file="/riepilogo.jsp"%>
</c:if>

