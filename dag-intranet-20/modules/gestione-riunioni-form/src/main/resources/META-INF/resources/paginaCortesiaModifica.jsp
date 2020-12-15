<%@page import="com.intranet.mef.gestione.riunioni.model.Riunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
long id=0;
if((request.getAttribute("idRiunione")!=null)){
	
	id=(long)request.getAttribute("idRiunione");


	  Riunione riun = RiunioneLocalServiceUtil.getRiunione(id);
		long idStatoRiuDefault = riun.getId_stato_riunione();
	String labelStatoRiuDefault = (StatoRiunioneLocalServiceUtil.getStatoRiunione(idStatoRiuDefault)).getLabel();
		
	

	String obj = riun.getOggetto();

%>

<div class="gestione-riunioni-modifica-wrapper">
    <div class="ama-container-fluid">
        <div class="tab-negative-wrap">
       		<div class="tab-content">  
				<div class="dati-riunione-dati-personali-wrap dati-riunione-success">
					<span class="icomoon-success dati-riunione-success-icon"></span>
					<div class="dati-riunione-success-container">
						<p class="dati-riunione-success-text">
						<liferay-ui:message key="gestione-riunione-cortesia-dati-della"/></p>
						<div class="dati-riunione-name-box">
							<p class="dati-riunione-name"><%=obj%></p>
						</div>
						<p class="dati-riunione-success-text mt-25-xs"><liferay-ui:message key="gestione-riunione-cortesia-aggiornati-successo"/></p>
						<p class="dati-riunione-success-text mt-45-xs"><liferay-ui:message key="gestione-riunione-cortesia-messaggio-email"/></p>
					</div>
					
					<portlet:renderURL var="dettaglioUrl">
						<portlet:param name="mvcPath" value="/dettaglioRiunione.jsp" />
						<portlet:param name="idRiunione" value="<%=riun.getId_riunione() + ""%>" /> 
						<portlet:param name="roleCoordinatore" value="<%= (String)request.getAttribute("roleCoordinatore")%>"/>
						<portlet:param name="roleAdministrator" value="<%= (String)request.getAttribute("roleAdministrator")%>"/>
					</portlet:renderURL>
					
					<portlet:actionURL var="passamodificaUrl" name="passamodifica"> 
						<portlet:param name="idRiunione" value="<%=riun.getId_riunione() + ""%>"/>
					</portlet:actionURL>
					
					<div class="ama-row mt-35-xs">
						<div class="buttons-wrapper ama-col-xs-12 mt-25-xs mb-60-xs ">
							<div
								class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
								<form action="<%=dettaglioUrl%>" method="post">
									<button class="button button-secondary">
									<liferay-ui:message key="gestione-riunione-cortesia-dettaglio"/></button>
								</form>
							</div>
							<c:if test="<%=labelStatoRiuDefault.equalsIgnoreCase("indetta") || labelStatoRiuDefault.equalsIgnoreCase("rinviata")%>">
							<div
								class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
								<form action="<%=passamodificaUrl%>" method="post">
				 						<button type="submit" name="modifica" id="modifica_b" class="button button-primary">
										<liferay-ui:message key="gestione-riunione-cortesia-modifica"/></button>
				 					</form>
							</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%}else{ %>
<%@ include file="/erroreRiunione.jsp"%>
<%}%>