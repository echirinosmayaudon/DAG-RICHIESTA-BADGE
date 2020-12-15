<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%
	Log _log = LogFactoryUtil.getLog("view_jsp");

	String navigation = "home";
    if (request.getParameter("navigation")!=null)
    navigation= (String)request.getParameter("navigation");
	if(request.getAttribute("navigation")!=null) 
		navigation = (String) request.getAttribute("navigation");
	
	//boolean role and role layout view permission
	boolean booleanRichiedenteLavAgile = false;
	boolean booleanSegreteriaLavAgile = false;
	boolean booleanLayoutViewPermissionRichiedenteLavAgile = false;
	boolean booleanLayoutViewPermissionSegreteriaLavAgile = false;
	
	if(request.getAttribute("booleanRichiedenteLavAgile")!=null) {
		booleanRichiedenteLavAgile = (boolean)request.getAttribute("booleanRichiedenteLavAgile");
	}
	if(request.getAttribute("booleanSegreteriaLavAgile")!=null) {
		booleanSegreteriaLavAgile = (boolean)request.getAttribute("booleanSegreteriaLavAgile");
	}
	if(request.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgile")!=null) {
		booleanLayoutViewPermissionRichiedenteLavAgile = (boolean)request.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgile");
	}
	if(request.getAttribute("booleanLayoutViewPermissionSegreteriaLavAgile")!=null) {
		booleanLayoutViewPermissionSegreteriaLavAgile = (boolean)request.getAttribute("booleanLayoutViewPermissionSegreteriaLavAgile");
	}
	
	// IMEF-1780
	boolean booleanRichiedenteLavAgilePlus = false;
	boolean booleanLayoutViewPermissionRichiedenteLavAgilePlus = false;
	if(request.getAttribute("booleanRichiedenteLavAgilePlus")!=null) {
		booleanRichiedenteLavAgilePlus = (boolean)request.getAttribute("booleanRichiedenteLavAgilePlus");
	}
	if(request.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgilePlus")!=null) {
		booleanLayoutViewPermissionRichiedenteLavAgilePlus = (boolean)request.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgilePlus");
	}
	// end IMEF-1780
%>
	<c:choose>
		<c:when test='<%=(booleanLayoutViewPermissionRichiedenteLavAgile || booleanLayoutViewPermissionRichiedenteLavAgilePlus) && (navigation.equalsIgnoreCase("recap") || navigation.equalsIgnoreCase("dettaglio") || request.getAttribute("richlavId")!= null) && !navigation.equalsIgnoreCase("ricerca")%>'>
			<jsp:include page="recap.jsp" />
		</c:when>	
		<c:when test='<%=(navigation.equalsIgnoreCase("ricerca")) || (booleanSegreteriaLavAgile && !booleanRichiedenteLavAgile && !booleanRichiedenteLavAgilePlus) || (booleanSegreteriaLavAgile && (booleanRichiedenteLavAgile || booleanRichiedenteLavAgilePlus) && (!booleanLayoutViewPermissionRichiedenteLavAgile || !booleanLayoutViewPermissionRichiedenteLavAgilePlus) && booleanLayoutViewPermissionSegreteriaLavAgile && !navigation.equalsIgnoreCase("form"))%>'>
			<jsp:include page="ricerca.jsp" />
		</c:when>	
		<c:otherwise>
			<jsp:include page="form.jsp" />
		</c:otherwise>
	</c:choose>
	