<%@ include file="/init.jsp" %>

<%@ page import="mef.richieste.badge.bean.Richiedente"%>
<%@ page import="mef.richieste.badge.bean.ModuloRichiedente"%>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@ page import="com.intranet.mef.job.siap.model.OrganizationChart"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log"%>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="java.io.File"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="servizio.richieste.badge.mef.model.RichiestaBadge"%>
<%@ page import="servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil"%>
<%@ page import="servizio.richieste.badge.mef.service.StatoRichiestaLocalServiceUtil"%>
<%@ page import="servizio.richieste.badge.mef.service.OggettoRichiestaLocalServiceUtil"%>
<%@ page import="servizio.richieste.badge.mef.model.StatoRichiesta"%>
<%@ page import="servizio.richieste.badge.mef.service.SediEsterneLocalServiceUtil" %>
<%@ page import="servizio.richieste.badge.mef.model.OggettoRichiesta" %>
<%@ page import="servizio.richieste.badge.mef.model.SediEsterne" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"/>
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
<portlet:actionURL var="vaiAGestioneUtenti" name="vaiAGestioneUtenti"/>
<portlet:actionURL var="vaiAProrogaBadge" name="vaiAProrogaBadge"/> 

<%
	boolean dirigente = (boolean)request.getAttribute("roleDirigente");
	boolean abilitatoBadge = (boolean)request.getAttribute("roleAbilitato");
	boolean delegatoBadge = (boolean)request.getAttribute("roleDelegato");
	boolean gestoreExt = (boolean)request.getAttribute("roleGestoreExt");
	boolean gestoreInt = (boolean)request.getAttribute("roleGestoreInt");

	String navigation ="home";
	if(request.getAttribute("navigation")!=null) 
		navigation = (String) request.getAttribute("navigation");
%>
	<c:choose>
			<c:when test='<%=navigation.equalsIgnoreCase("recap") || navigation.equalsIgnoreCase("vaiADettaglio") || (request.getParameter("navigation")!=null && request.getParameter("navigation").equalsIgnoreCase("recap"))%>'>
				<jsp:include page="inserimentobadge-recap.jsp" />
			</c:when>	
			<c:when test='<%=navigation.equalsIgnoreCase("vaiARicerca") || (!(request.getAttribute("navigation")!=null) && (gestoreExt || gestoreInt)) %>'>
			   <jsp:include page="ricerca-richieste.jsp" />
			</c:when>
			<c:when test='<%=navigation.equalsIgnoreCase("gestioneutenti")%>'>
				<jsp:include page="gestioneUtenti.jsp" />
			</c:when>
			<c:when test='<%=navigation.equalsIgnoreCase("vaiAProrogaBadge") || (request.getParameter("navigation")!=null && "vaiAProrogaBadge".equalsIgnoreCase(request.getParameter("navigation")))%>'>
			<%@ include file="/prorogaBadge.jsp"%>
			</c:when>
			<c:when test='<%=navigation.equalsIgnoreCase("vaiARiepilogoProroga")%>'>
				<%@ include file="/riepilogoProroga.jsp"%>
			</c:when>
			<c:otherwise>
				<jsp:include page="formRichiestaBadge.jsp" />
			</c:otherwise>
	</c:choose>