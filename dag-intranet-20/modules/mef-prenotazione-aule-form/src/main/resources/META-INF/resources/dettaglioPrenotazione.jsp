<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="servizio.prenotazione.aule.mef.service.PrenotazioneLocalServiceUtil"%>
<%@page import="servizio.prenotazione.aule.mef.service.SalaLocalServiceUtil"%>
<%@page import="servizio.prenotazione.aule.mef.service.StatoAulaLocalServiceUtil"%>
<%@page import="servizio.prenotazione.aule.mef.service.TipoEventoLocalServiceUtil"%>
<%@page import="servizio.prenotazione.aule.mef.service.ApprovatoreLocalServiceUtil"%>
<%@page import="servizio.prenotazione.aule.mef.model.Sala" %>
<%@page import="servizio.prenotazione.aule.mef.model.Approvatore" %>
<%@page import="servizio.prenotazione.aule.mef.model.Prenotazione" %>
<%@page import="servizio.prenotazione.aule.mef.model.StatoAula" %>
<%@page import="servizio.prenotazione.aule.mef.model.TipoEvento" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.GregorianCalendar" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.model.Role" %>
<%@page import="com.liferay.portal.kernel.model.User" %>

<portlet:defineObjects />
<theme:defineObjects />

<%
boolean isUserApprover = false;
User utente = themeDisplay.getUser();
for (Role ruolo : user.getRoles()) {
	if (ruolo.getName().equalsIgnoreCase("approvatoreSale")) {
		isUserApprover = true;
	}
}
long id_prenotazione = 0;
 
if(request.getParameter("prenotazioneId")!=null){
  	id_prenotazione=Long.parseLong(request.getParameter("prenotazioneId"));
  }
else if(request.getAttribute("prenotazione_Id")!=null){
		id_prenotazione = (long)request.getAttribute("prenotazione_Id");
  }

Prenotazione prenotazione = PrenotazioneLocalServiceUtil.getPrenotazione(id_prenotazione);
Sala sala = SalaLocalServiceUtil.getSala(prenotazione.getId_sala());
boolean currentApprovatore = false;
for (Approvatore a: ApprovatoreLocalServiceUtil.getApprovatores(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
	if (a.getEmail_approvatore().equalsIgnoreCase(user.getEmailAddress())) {
		currentApprovatore = true;
	}
}
boolean currentRichiedente = false;
if (prenotazione.getCod_fiscale().equalsIgnoreCase(user.getScreenName())) {
	currentRichiedente = true;
}
long stato_aula = prenotazione.getId_stato();
StatoAula statoAula = StatoAulaLocalServiceUtil.getStatoAula(stato_aula);
TipoEvento tipoEvento = TipoEventoLocalServiceUtil.getTipoEvento(prenotazione.getId_evento());
SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat hourFormatter = new SimpleDateFormat("HH:mm");

Date data_inizio = prenotazione.getData_inizio();
String data_string = dateFormatter.format(prenotazione.getData_inizio());
Date data_fine = prenotazione.getData_fine();
Date data_prenota = prenotazione.getData_prenota();
String data_prenota_string = dateFormatter.format(data_prenota);
Calendar calendarInizio = GregorianCalendar.getInstance();
calendarInizio.setTime(data_inizio);
String ora_inizio = hourFormatter.format(calendarInizio.getTime());
Calendar calendarFine = GregorianCalendar.getInstance();
int minutiCorretti = data_fine.getMinutes() + 1;
data_fine.setMinutes(minutiCorretti);
calendarFine.setTime(data_fine);
String ora_fine = hourFormatter.format(calendarFine.getTime());
int numeroPartecipanti = prenotazione.getPartecipanti();
String note = prenotazione.getNote();
String attivita = prenotazione.getAttivita();
String desc_sala = sala.getDesc_sala();
String indirizzo_sala = sala.getIndirizzo();
String citta_sala = sala.getCitta();
JSONObject richiedenteJsonObj = JSONFactoryUtil.createJSONObject(prenotazione.getDati_rich());
String ufficio_richiedente = (String)richiedenteJsonObj.get("ufficiorichiedente");
String dirigente_ufficio = (String)richiedenteJsonObj.get("dirigenteufficio");
String utente_richiedente = (String)richiedenteJsonObj.get("utenterichiedente");
String telefono_richiedente = (String)richiedenteJsonObj.get("telefonorichiedente");
String utilizzatore = (String)richiedenteJsonObj.get("utilizzatore");
String referente = (String)richiedenteJsonObj.get("referente");
String telefono_referente = (String)richiedenteJsonObj.get("telefonoreferente");
String stato_aula_desc = statoAula.getDesc_stato();
String tipo_evento = tipoEvento.getDesc_evento();
JSONObject serviziJsonObj = JSONFactoryUtil.createJSONObject(prenotazione.getServizi());
JSONArray strumentazione_tecnica = null;
JSONArray strumentazione_tecnica_evento = null;
JSONArray servizi_logistici = null;

%>

<portlet:actionURL var="rifiutaPrenotazioneUrl" name="rifiutaPrenotazione">
	<portlet:param name="id_prenota" value="<%=String.valueOf(prenotazione.getId_prenota())%>"/>
</portlet:actionURL>
<portlet:actionURL var="accettaPrenotazioneUrl" name="accettaPrenotazione">
	<portlet:param name="id_prenota" value="<%=String.valueOf(prenotazione.getId_prenota())%>"/>
</portlet:actionURL>
<portlet:actionURL name="eliminaPrenotazione" var="eliminaPrenotazione">
<portlet:param name="idPrenotazione" value="<%=String.valueOf(prenotazione.getId_prenota())%>"/>
</portlet:actionURL>
<portlet:actionURL name="modificaPrenotazione" var="modificaPrenotazione">
	<portlet:param name="idPrenotazione" value="<%=String.valueOf(prenotazione.getId_prenota())%>"/>
</portlet:actionURL>
<portlet:actionURL name="vaiPaginaRicerca" var="vaiPaginaRicerca"/>
<portlet:actionURL var="vaiALeTuePrenotazioniUrl" name="vaiALeTuePrenotazioni"/>
<portlet:actionURL var="requestForApprovalUrl" name="requestForApproval"/>

<div class="trasporti-header">
	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<div class="title-wrapper mb-70-md">
					<h2 class="title"><%=desc_sala.toUpperCase()%></h2>
					<div class="wrap-icon-title mt-30-xs mt-5-md">                   
                     <div class="wrap-icon-title mobile-search form-inline-wrap">
                     <form class="btn-prenota-wrap" action="<%=vaiPaginaRicerca%>" method="post">
                       <button class="button-xs button button-primary mr-10-xs">
                       <span class="icomoon-plus icon-beni"></span>
                       <liferay-ui:message key="prenotazione-dettaglio-prenota-sala"/>
                       </button>
                       </form>                    
                       <c:if test="${approvatore==true}">
                       <form action="<%=requestForApprovalUrl%>" method="post">                     
                             <a href="<%=requestForApprovalUrl%>" title="Sale in attesa di approvazione" class="icon icomoon-prenota-approvata mr-10-xs"></a>                       
                         </form>
                         </c:if>                        
                         <form action="<%=vaiALeTuePrenotazioniUrl%>" method="post">                         
                             <a href="<%=vaiALeTuePrenotazioniUrl%>" title="Sale Prenotate" class="icon icomoon-user2 mr-10-xs"></a>                         
                         </form>                     
                       
                       <c:if test="<%=stato_aula != 4 && currentRichiedente==true%>">
                       
                       		<c:if test="<%=sala.getAutorizzazione()==false%>">
                       				<form action="<%=modificaPrenotazione%>" method="post">
                       				<a href="<%=modificaPrenotazione%>" title="Modifica" class="icon icomoon-edit-border mr-10-xs"></a>
                                 	</form>
                            </c:if>
                                 	
                                 	<form action="<%=eliminaPrenotazione%>" method="post">
                                 	<a href="<%=eliminaPrenotazione%>" title="Elimina" class="icon icomoon-cancel"></a>
                             		</form>
                            
                       </c:if>
                                                    
                               </div>
                             </div>
				</div>
				<div class="wrap-button-type">
					<div
						class="box-white-beni mobile-width padding-general mt-20-xs mt-60-md mr-20-sm mr-5-xs">
						<p class="text">
							<c:if test="<%=stato_aula == 1 %>">
								<span class="file icomoon-unlocked"></span><%=stato_aula_desc.toUpperCase()%>
							</c:if>
							<c:if test="<%=stato_aula == 2 %>">
								<span class="file icomoon-lock"></span><%=stato_aula_desc.toUpperCase()%>
							</c:if>
							<c:if test="<%=stato_aula == 3 %>">
								<span class="file icomoon-hourglass"></span><%=stato_aula_desc.toUpperCase()%>
							</c:if>
							<c:if test="<%=stato_aula == 4 %>">
								<span class="file icomoon-cancel"></span><%=stato_aula_desc.toUpperCase()%>
							</c:if>
						</p>
					</div>
					<div href="#" title="conferenza stampa"
						class="box-white-beni mobile-width padding mt-20-xs mt-60-md">
						<p class="text"><%=tipo_evento.toUpperCase()%></p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="ama-container-fluid">
	<div class="wrapper-servizi-aule">
		<div class="wrap-date mb-30-xs mt-30-xs">
			<span class="ico-time-date icomoon-calendar"></span>
			<p class="text-classrooms ml-10-xs">
				<liferay-ui:message key="prenotazione-dettaglio-data"/>: <span><%=data_string%></span>
			</p>
		</div>
		<div class="wrap-time mb-30-xs mt-30-xs">
			<span class="ico-time-date icomoon-time"></span>
			<p class="text-classrooms ml-20-xs">
				<liferay-ui:message key="prenotazione-dettaglio-ora-inizio"/>: <span><%=ora_inizio %></span>
			</p>
			<p class="text-classrooms ml-40-xs ml-20-sm">
				<liferay-ui:message key="prenotazione-dettaglio-ora-fine"/>: <span><%=ora_fine %></span>
			</p>
		</div>
		<div class="wrapper-servizi-aule">
			<div class="box-aule mb-20-xs">
				<div class="ama-row">
					<div class="ama-col-md-9 ama-col-xs-12 border">
						<p class="position-classrooms"><%=desc_sala.toUpperCase()%> - <%=indirizzo_sala.toUpperCase()%></p>
						<p class="text-box">
							<span class="ico icomoon-pin-white-bold"></span><%=indirizzo_sala.toUpperCase()%>, <%=citta_sala.toUpperCase()%>
						</p>
					</div>
					<div class="ama-col-md-3 ama-col-xs-12">
						<span class="ico-people icomoon-partecipanti mr-20-xs"></span>
						<div class="wrap-container-people">
							<p class="people"><liferay-ui:message key="prenotazione-dettaglio-partecipanti"/>:</p>
							<span class="number"><%=numeroPartecipanti%></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="mb-20-xs">
			<span class="text-classrooms"> <liferay-ui:message key="prenotazione-dettaglio-attivia-oggetto-riunione"/> </span>
			<p class="info-classrooms"><%=attivita %></p>
		</div>
		<div class="mb-20-xs">
			<span class="text-classrooms"> <liferay-ui:message key="prenotazione-dettaglio-note"/> </span>
			<p class="info-classrooms"><%=note %></p>
		</div>
		<div class="mb-30-xs mt-30-xs text-center border-top">
			<span class="ico-time-date icomoon-calendar mt-20-sm mr-20-xs"></span>
			<p class="text-classrooms mt-20-xs">
				<liferay-ui:message key="prenotazione-dettaglio-data-prenotazione"/>: <span class="display-b"><%=data_prenota_string %></span>
			</p>
		</div>
	</div>
	<div class="ama-row">
		<div class="ama-col-xs-12 mobile-no-padding">
			<div class="wrapper-istanza-trasporti mobile-no-padding">
				<div class="box-gray">
					<div class=" box-white pb-0-xs">
						<p class="name"><%=utente_richiedente.toUpperCase()%></p>
						<span
							class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm"
							data-toggle="collapse" data-target="#collapse-trasporti"
							data-parent="#accordion"></span>
						<div id="collapse-trasporti" class="collapse1 in no-overflow">
							<div class="ama-row border-section border-mobile">
								<div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
									<span class="section-information">
										<liferay-ui:message key="prenotazione-dettaglio-telefono-richiedente"/>:
									</span>
									<p class="info"><%=telefono_richiedente%></p>
								</div>
							</div>
							<div class="ama-row">
								<div class="ama-col-md-3 ama-col-sm-6">
									<span class="section-information mt-30-md mt-30-xs">
										<liferay-ui:message key="prenotazione-dettaglio-ufficio-richiedente"/>:
									</span>
									<p class="info"><%=ufficio_richiedente.toUpperCase()%></p>
								</div>
								<div class="ama-col-md-3 ama-col-sm-6">
									<span class="section-information mt-30-md mt-30-sm">
										<liferay-ui:message key="prenotazione-dettaglio-dirigente-ufficio"/>:
									</span>
									<p class="info"><%=dirigente_ufficio.toUpperCase()%></p>
								</div>
							</div>
							<div class="ama-row">
								<div class="ama-col-md-3 ama-col-sm-6">
									<span class="section-information mt-30-md">
										<liferay-ui:message key="prenotazione-dettaglio-utente-referente"/>:
									</span>
									<p class="info"><%=referente.toUpperCase()%></p>
								</div>

								<div class="ama-col-md-3 ama-col-sm-6">
									<span class="section-information mt-30-md">
										<liferay-ui:message key="prenotazione-dettaglio-telefono-referente"/>:
									</span>
									<p class="info"><%=telefono_referente %></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	  strumentazione_tecnica = (JSONArray)serviziJsonObj.getJSONArray("strumentazionetecnica");
	  strumentazione_tecnica_evento = (JSONArray)serviziJsonObj.getJSONArray("strumentazionetecnicaevento");
	  servizi_logistici = (JSONArray)serviziJsonObj.getJSONArray("servizilogistici");
	%>
	<c:if test="<%= (strumentazione_tecnica != null && strumentazione_tecnica.length() > 0) ||  strumentazione_tecnica_evento!=null || servizi_logistici!=null %>">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders"><liferay-ui:message key="prenotazione-dettaglio-servizi-aggiuntivi"/></h2>
				</div>
			</div>
		</div>
	</c:if>
	<div class="wrapper-servizi-aule">
		<div class="ama-row mb-40-xs">
			<% 
			for(int j=0; j<strumentazione_tecnica.length();j++) {
				String strumentazione = (String)strumentazione_tecnica.get(j);
			%>
				<div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12">
					<div class="box-container mb-20-xs">
						<p class="strument"><liferay-ui:message key="prenotazione-dettaglio-strumentazione-tecnica"/></p>
						<p class="info"><%=strumentazione.toUpperCase()%></p>
					</div>
				</div>
			<%} %>
			<c:if test="<%=strumentazione_tecnica_evento!=null%>">
			<% 
			for(int j=0; j<strumentazione_tecnica_evento.length();j++) {
				String strumentazioneEvento = (String)strumentazione_tecnica_evento.get(j);
			%>
			<div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12">
				<div class="box-container mb-20-xs">
					<p class="strument"><liferay-ui:message key="prenotazione-dettaglio-strumentazione-tecnica-eventi"/></p>
					<p class="info"><%=strumentazioneEvento.toUpperCase()%></p>
				</div>
			</div>
			<%} %>
			</c:if>
			<c:if test="<%=servizi_logistici!=null%>">
			<% 
			for(int j=0; j<servizi_logistici.length();j++) {
				String serviziLogistici = (String)servizi_logistici.get(j);
			%>
			<div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12">
				<div class="box-container mb-20-xs">
					<p class="strument"><liferay-ui:message key="prenotazione-dettaglio-servizi-logistici"/></p>
					<p class="info"><%=serviziLogistici.toUpperCase()%></p>
				</div>
			</div>
			<%} %>
			</c:if>
		</div>
	</div>
	<c:if test="<%=isUserApprover && stato_aula == 3 && currentApprovatore==true%>">
		<div class="ama-row">
	    	<div class="ama-col-sm-6 text-right mb-100-md mb-10-xs mt-50-md">
	        	<button class="button button-secondary" onclick="callProcessActionRifiuta('<%=rifiutaPrenotazioneUrl.toString()%>')"><liferay-ui:message key="prenotazione-dettaglio-rifiuta"/></button>
	        </div>
	        <div class="ama-col-sm-6 text-left mb-100-md mb-30-xs mt-50-md">
	        	<button class="button button-primary" onclick="callProcessActionAccetta('<%=accettaPrenotazioneUrl.toString()%>')"><liferay-ui:message key="prenotazione-dettaglio-accetta"/></button>
	        </div>
	    </div>
	</c:if>
</div>

<script type="text/javascript">
	function callProcessActionRifiuta(url) {    
		window.location.href = url+"&id_prenota=1";
	}
	
	function callProcessActionAccetta(url) {    
		window.location.href = url+"&id_prenota=1";
	}
</script>