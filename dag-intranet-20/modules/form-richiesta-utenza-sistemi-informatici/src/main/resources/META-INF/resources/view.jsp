<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ include file="/init.jsp" %>

<%

String nav= (String)request.getAttribute("navigation");
if(nav == null)
{
	nav = (String) ParamUtil.getString(request,"navigation");
}
%>




<c:if test='<%= nav!=null && nav.equals("inserimento") %>'>
	<%@ include file="/richiesta-utenza.jsp"%>
</c:if>

<c:if test='<%= nav!=null && nav.equals("riepilogo") %>'>
	<%@ include file="/richiesta-utenza-recap.jsp"%>
</c:if>


