<%@page import="servizio.prenotazione.aule.mef.model.TipoEvento"%>
<%@page import="servizio.prenotazione.aule.mef.model.StrumentoTec"%>
<%@page import="servizio.prenotazione.aule.mef.model.StrumentoEvento"%>
<%@page import="servizio.prenotazione.aule.mef.model.ServizioLog"%>
<%@page import="mef.prenotazione.aule.bean.ModuloPrenotazioneBean"%>
<%@page import="mef.prenotazione.aule.bean.OrarioBean"%>
<%@page import="java.util.List"%>
<%@page import="servizio.prenotazione.aule.mef.model.Sala" %>
<%@page import="servizio.prenotazione.aule.mef.service.SalaLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil" %>
<%@page import="com.intranet.mef.job.siap.model.OrganizationChart" %>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil" %>
<%@page import="com.liferay.expando.kernel.model.ExpandoTableConstants" %>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil" %>
<%@page import="com.liferay.expando.kernel.model.ExpandoValue" %>
<%@page import="com.liferay.expando.kernel.model.ExpandoTableConstants" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@page import="com.liferay.portal.kernel.model.Role" %>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@page import="java.util.ArrayList" %>
<portlet:actionURL name="insertPrenotazione" var="insertPrenotazione" />
<portlet:actionURL name="updatePrenotazione" var="updatePrenotazione" />
<portlet:actionURL name="vaiPaginaRicerca" var="vaiPaginaRicerca" />

<%
String idUfficio = "";
String idDirigente = "";
String personalId = "";
String nomeUfficio = "";
String nomeDirigenteUfficio = "";
OrganizationChart ufficio = null;

User utente = themeDisplay.getUser();
long companyId = utente.getCompanyId();
long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());

if(utente != null){
	idUfficio = (String)utente.getExpandoBridge().getAttribute("idOrgChart");
	idDirigente = (String)utente.getExpandoBridge().getAttribute("idDirector");
	personalId = (String)utente.getExpandoBridge().getAttribute("personalId");
}

if ((utente != null) && (utente.getExpandoBridge() != null)
		&& (idDirigente != null)) {
	
	List<ExpandoValue> values = ExpandoValueLocalServiceUtil.getColumnValues(
			companyId, User.class.getName(),
			ExpandoTableConstants.DEFAULT_TABLE_NAME, "personalId", idDirigente,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	    User cuseritem = null;
	    
		for (ExpandoValue value : values) {
			cuseritem = UserLocalServiceUtil.getUser(value.getClassPK());
		}
		
		if(cuseritem!=null){
			nomeDirigenteUfficio = cuseritem.getFirstName() + " " + cuseritem.getLastName();
		}
}

if(idUfficio != null && !"".equals(idUfficio)){
	try{
		ufficio = OrganizationChartLocalServiceUtil.fetchOrganizationChart(Long.parseLong(idUfficio));
		if(ufficio != null){
			nomeUfficio = ufficio.getName();
		}
	}catch(Exception e){
		System.out.println("Errore nel recupero dell'ufficio");
	}
}


ModuloPrenotazioneBean moduloPrenotazioneBean = (ModuloPrenotazioneBean) request.getAttribute("moduloPrenotazioneBean");
String id_prenotazione = null;
if (request.getAttribute("idPrenotazione")!=null) {
	id_prenotazione=(String)request.getAttribute("idPrenotazione");
	moduloPrenotazioneBean.setIdPrenotazione(id_prenotazione);
}
List<Long> listServiziTecniciId = new ArrayList<>(0);
if(request.getAttribute("listServiziTecniciId") != null){
	listServiziTecniciId = (List<Long>) request.getAttribute("listServiziTecniciId");
}
List<Long> listServiziLogisticiId = new ArrayList<>(0);;
if(request.getAttribute("listServiziLogisticiId") != null){
	listServiziLogisticiId = (List<Long>) request.getAttribute("listServiziLogisticiId");
}
List<Long> listServiziEventiId = new ArrayList<>(0);;
if(request.getAttribute("listServiziEventiId") != null){
	listServiziEventiId = (List<Long>) request.getAttribute("listServiziEventiId");
}

List<OrarioBean> orarioBeans =  moduloPrenotazioneBean.getOrari();
String id_sala = moduloPrenotazioneBean.getIdSala();
List<Sala> listaSale = moduloPrenotazioneBean.getListSala();
Sala sala = null;
int numeroPostiSala = 0;
if(id_sala != null && !"".equals(id_sala)){
	sala = SalaLocalServiceUtil.getSala(Long.parseLong(id_sala));
	if(sala != null){
		numeroPostiSala = sala.getPosti();
	}
}else{
	id_sala = (String)request.getAttribute("id_sala");
	sala = SalaLocalServiceUtil.getSala(Long.parseLong(id_sala));
	if(sala != null){
		numeroPostiSala = sala.getPosti();
	}
}
%>

<input id="numeroPostiSalaModifica" type="hidden" value="<%= numeroPostiSala%>">
<input id="numeroPostiSalaInserimento" type="hidden" value="${moduloPrenotazioneBean.getNumeroPartecipanti()}">
<input id="idSalaSelected" type="hidden" value="<%= id_sala%>">
<input id="namespace" type="hidden" value="<portlet:namespace/>">

<% if(listaSale != null && listaSale.size() > 0){%>

	<c:forEach items="<%=listaSale %>" var="sala">
		<input type="hidden" id="n_posti${sala.getId_sala()}" value="${sala.getPosti()}">
	</c:forEach>
	
<%} %>
<input id="numeroPostiSalaInserimento" type="hidden" value="">
<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title mb-30-sm mb-0-md"><%=formTitleInsertPrenotazioni%></h2>
                         <a class="icomoon-star title-star btn-star-bookmarks pl-0-sm pl-20-md">
                             <span class="sr-only"><liferay-ui:message key="prenotazione-aggiungi-preferiti"/></span>
                         </a>
                         <p class="subtitle dot-point dot-200"><%=formSubtitleInsertPrenotazioni%></p>
                     </div>
                 </div>
             </div>
         </div>
</div>
<div class="ama-container-fluid" id="mainContainer">
	<div class="ama-row">
		<div class="ama-col-md-12">
			<c:if test="<%=request.getAttribute("errormessage")!=null%>">
				<h2 style="color: Red;"><liferay-ui:message key="prenotazione-error-message-inserimento" />.</h2>
			</c:if>
			<br>
			<br>
			<div class="wrapper-title-small">
				<h2 class="title-box borders">
					<liferay-ui:message key="prenotazione-prenota-dati-di-prenotazione" />
				</h2>
			</div>
		</div>
	</div>
	<form action="<%=insertPrenotazione%>" method="post" id="<portlet:namespace/>prenotaAula" 
		enctype="multipart/form-data">
		<div class="ama-row">
			<div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
				<input type="hidden" name="<portlet:namespace/>dataDiPrenotazione"
					class="datepicker-custom input-custom-light"
					placeholder="DD/MM/AAAA" value="${dataDiPrenotazione}"
					id="<portlet:namespace/>dataDiPrenotazione" readonly>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-sm-8 ama-col-xs-12 mb-25-md">
				<label for="<portlet:namespace/>salaRiunione" class="label-form"><liferay-ui:message
						key="prenotazione-prenota-sala-riunione" />*</label>
				<c:choose>
					<c:when test="${modificaPrenota == 0}">
						<input type="text" name="<portlet:namespace/>salaRiunione"
							class="input-custom-light"
							value="${moduloPrenotazioneBean.getSala().toUpperCase()}"
							id="<portlet:namespace/>salaRiunione" readonly>
						<input type="hidden" name="<portlet:namespace/>idSala"
							value="${moduloPrenotazioneBean.getIdSala()}">
					</c:when>
					<c:otherwise>
						<select class="option-select data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							id="<portlet:namespace/>SalaId" onchange="onChangeSala()"
							name="<portlet:namespace/>SalaId">
							<option value="" hidden=""><liferay-ui:message key="prenotazione-prenota-scegli-scala" /></option>

							<c:forEach items="${moduloPrenotazioneBean.getListSala()}"
								var="listSala">
								<c:if
									test="${listSala.getId_sala() == moduloPrenotazioneBean.getIdSala()}">
									<option value="${listSala.getId_sala()}" selected>${listSala.getDesc_sala().toUpperCase()}</option>
								</c:if>
								<c:if
									test="${listSala.getId_sala() != moduloPrenotazioneBean.getIdSala()}">
									<option value="${listSala.getId_sala()}">${listSala.getDesc_sala().toUpperCase()}</option>
								</c:if>
							</c:forEach>
						</select>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="ama-col-md-4 ama-col-xs-12 mb-25-md">
				<label for="<portlet:namespace/>data"
					class="label-form margin-top"><liferay-ui:message
						key="prenotazione-prenota-data" />*</label>
				<c:if test="${moduloPrenotazioneBean.getData() == null}">
					<input type="text" id="<portlet:namespace/>data"
						name="<portlet:namespace/>data"
						class="datepicker-custom input-custom-light"
						placeholder="DD/MM/AAAA" readonly>
				</c:if>
				<c:if test="${moduloPrenotazioneBean.getData() != null}">
					<c:choose>
						<c:when test="${modificaPrenota == 0}">
							<input type="text" id="<portlet:namespace/>data"
								name="<portlet:namespace/>data"
								class="datepicker-custom input-custom-light"
								placeholder="DD/MM/AAAA"
								value="${moduloPrenotazioneBean.getData()}" readonly>
						</c:when>
						<c:otherwise>
							<input type="text" id="<portlet:namespace/>data"
								name="<portlet:namespace/>data"
								class="datepicker-custom input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-submission-date-check="#<portlet:namespace/>data"
								placeholder="DD/MM/AAAA"
								value="${moduloPrenotazioneBean.getData()}">
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-sm-6 ama-col-xs-12 mb-25-md">
				<label for="<portlet:namespace/>tipoEvent" class="label-form"><liferay-ui:message
					key="prenotazione-prenota-tipo-event" />*</label> <select
					class="option-select data-parsley-validated" 
					data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
				    id="<portlet:namespace/>tipoEvent"
					name="<portlet:namespace/>tipoEvent">
					<option value="" hidden=""><liferay-ui:message
							key="prenotazione-prenota-conferenza-stampa" /></option>
					<c:forEach items="${moduloPrenotazioneBean.getTipologiaEvento()}"
						var="tipoEventi">
						<c:if test="${tipoEventi.getId_evento() == id_TipoEvento}">
							<option value="${tipoEventi.getId_evento()}" selected>${tipoEventi.getDesc_evento().toUpperCase()}</option>
						</c:if>
						<c:if test="${tipoEventi.getId_evento() != id_TipoEvento}">
							<option value="${tipoEventi.getId_evento()}">${tipoEventi.getDesc_evento().toUpperCase()}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="ama-col-md-2 mb-25-md ama-col-xs-6">
				<label for="<portlet:namespace/>oraInizio"
					class="label-form margin-top"><liferay-ui:message
						key="prenotazione-prenota-ora-inizio" />*</label> <select
					id="<portlet:namespace/>oraInizio"
					name="<portlet:namespace/>oraInizio" class="option-select data-parsley-validated"
					data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					data-parsley-submission-data-inizio-eq-today-check="#<portlet:namespace/>">
					<option value="" hidden=""><liferay-ui:message key="prenotazione-prenota-scegli-ora-inizio" /></option>
				</select>
			</div>
			<div class="ama-col-md-2 mb-25-md ama-col-xs-6">
				<label for="<portlet:namespace/>oraFine"
					class="label-form margin-top"><liferay-ui:message
						key="prenotazione-prenota-ora-fine" />*</label> 
				<select
					id="<portlet:namespace/>oraFine" name="<portlet:namespace/>oraFine"
					class="option-select data-parsley-validated" 
					data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
						<option value="" hidden=""><liferay-ui:message key="prenotazione-prenota-scegli-ora-fine"/></option>
				</select>
			</div>
			<div class="ama-col-md-2 mb-25-md ama-col-xs-12">
				<label for="<portlet:namespace/>numeroPartecipanti"
					class="label-form margin-top"><liferay-ui:message
						key="prenotazione-prenota-num-partecipanti" />*</label>
				<c:if
					test="${moduloPrenotazioneBean.getNumeroPartecipanti() !=null}">
					<input id="<portlet:namespace/>numeroPartecipanti"
						name="<portlet:namespace/>numeroPartecipanti"
						class="input-custom-light data-parsley-validated" 
						data-parsley-required="true" data-parlsey-required-message="<liferay-ui:message key="error-mandatory"/>"
						data-parsley-type="number"
						data-parsley-type-message="<liferay-ui:message key="error-number-partecipanti-message"/>"
						data-parsley-min="1"
						data-parsley-min-message="<liferay-ui:message key="error-min-partecipanti-message"/>"
						data-parsley-submission-posti-sala-check="#<portlet:namespace/>numeroPartecipanti"
						value="${moduloPrenotazioneBean.getNumeroPartecipanti()}"
						placeholder="<liferay-ui:message key='prenotazione-prenota-num-partecipanti-placeholder'/>">
				</c:if>
				<c:if
					test="${moduloPrenotazioneBean.getNumeroPartecipanti() ==null}">

					<input id="<portlet:namespace/>numeroPartecipanti"
						name="<portlet:namespace/>numeroPartecipanti"
						class="input-custom-light data-parsley-validated" 
						data-parsley-type="number"
						data-parsley-type-message="<liferay-ui:message key="error-number-partecipanti-message"/>"
						data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						data-parsley-min="1"
						data-parsley-min-message="<liferay-ui:message key="error-min-partecipanti-message"/>"
						data-parsley-submission-posti-sala-check="#<portlet:namespace/>numeroPartecipanti"
						placeholder="<liferay-ui:message key='prenotazione-prenota-num-partecipanti-placeholder'/>">
				</c:if>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mb-25-md">
				<div class="wrapper-content-textarea">
					<label class="label-form margin-top"
						for="<portlet:namespace/>oggetto"><liferay-ui:message
							key="prenotazione-prenota-attivita-oggetto" />*</label>
					<c:if
						test="${moduloPrenotazioneBean.getAttivita_OggettoPrenotazione() != null }">
						<input type="text" class="form-control textarea-custom-light input-custom-light data-parsley-validated" 
							data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							id="<portlet:namespace/>oggetto"
							data-parsley-maxlength="100" 
                            data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
							name="<portlet:namespace/>oggetto"
							placeholder="<liferay-ui:message key='prenotazione-prenota-attivita-oggetto-placeholder'/>"
							value="${moduloPrenotazioneBean.getAttivita_OggettoPrenotazione().toUpperCase()}">
						<div class="content-textarea">${moduloPrenotazioneBean.getAttivita_OggettoPrenotazione().length()}/
							<p class="color-gray">100</p>
						</div>
					</c:if>
					<c:if
						test="${moduloPrenotazioneBean.getAttivita_OggettoPrenotazione() == null }">
						<input type="text" class="form-control textarea-custom-light input-custom-light input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							id="<portlet:namespace/>oggetto"
							data-parsley-maxlength="100" 
                            data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
							name="<portlet:namespace/>oggetto"
							placeholder="<liferay-ui:message key='prenotazione-prenota-attivita-oggetto-placeholder'/>">
						<div class="content-textarea">
							0/
							<p class="color-gray">100</p>
						</div>
					</c:if>
				</div>
			</div>
			<div class="ama-col-xs-12 mb-25-md">
				<div class="wrapper-content-textarea">
					<label class="label-form margin-top" for="<portlet:namespace/>note"><liferay-ui:message
							key="prenotazione-prenota-note" /> </label>
					<c:if test="${moduloPrenotazioneBean.getNote() != null}">
						<textarea class="form-control textarea-custom-light"
							id="<portlet:namespace/>note" name="<portlet:namespace/>note"
							data-parsley-maxlength="500" 
                            data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-note-placeholder'/>">${moduloPrenotazioneBean.getNote().toUpperCase()}</textarea>
						<div class="content-textarea">${moduloPrenotazioneBean.getNote().length()}/
							<p class="color-gray">500</p>
						</div>
					</c:if>
					<c:if test="${moduloPrenotazioneBean.getNote() == null}">
						<textarea class="form-control textarea-custom-light"
							data-parsley-maxlength="500" 
                            data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
							id="<portlet:namespace/>note" name="<portlet:namespace/>note"
							placeholder="<liferay-ui:message key='prenotazione-prenota-note-placeholder'/>"></textarea>
						<div class="content-textarea">
							0/
							<p class="color-gray">500</p>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="ama-row">
			
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="prenotazione-prenota-dati-richiedente" />
					</h2>
				</div>
			</div>
		</div>
		<div class="datiRichiedenti">
			<div class="ama-row">
				<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
					<label for="<portlet:namespace/>ufficioRichidente"
						class="label-form"><liferay-ui:message
							key="prenotazione-prenota-ufficio-richiedente" />*</label>
					<c:if
						test="${moduloPrenotazioneBean.getUfficioRichiedente() == null}">
						<input type="text" name="<portlet:namespace/>ufficioRichidente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-ufficio-richiedente-placeholder'/>"
							id="<portlet:namespace/>ufficioRichidente"
							value="<%= nomeUfficio.toUpperCase() %>">
					</c:if>
					<c:if
						test="${moduloPrenotazioneBean.getUfficioRichiedente() != null}">
						<input type="text" name="<portlet:namespace/>ufficioRichidente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-ufficio-richiedente-placeholder'/>"
							id="<portlet:namespace/>ufficioRichidente"
							value="${moduloPrenotazioneBean.getUfficioRichiedente().toUpperCase()}">
					</c:if>
				</div>
				<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
					<label for="<portlet:namespace/>ufficioDirigente"
						class="label-form"><liferay-ui:message
							key="prenotazione-prenota-ufficio-dirigente" />*</label>
					<c:if
						test="${moduloPrenotazioneBean.getDirigenteUfficio() == null }">
						<input type="text" name="<portlet:namespace/>ufficioDirigente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-ufficio-dirigente-placeholder'/>"
							id="<portlet:namespace/>ufficioDirigente"
							value="<%= nomeDirigenteUfficio.toUpperCase()%>">
					</c:if>
					<c:if
						test="${moduloPrenotazioneBean.getDirigenteUfficio() != null }">
						<input type="text" name="<portlet:namespace/>ufficioDirigente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-ufficio-dirigente-placeholder'/>"
							id="<portlet:namespace/>ufficioDirigente"
							value="${moduloPrenotazioneBean.getDirigenteUfficio().toUpperCase()}">
					</c:if>
				</div>
				<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
					<label for="<portlet:namespace/>utenteRichiedente"
						class="label-form"><liferay-ui:message
							key="prenotazione-prenota-utente-richiedente" />*</label>
					<c:if
						test="${moduloPrenotazioneBean.getUtenteRichiedente() == null}">
						<input type="text"
							name="<portlet:namespace/>nomeUtenteRichiedente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-utente-richiedente-placeholder'/>"
							id="<portlet:namespace/>utenteRichiedente">
					</c:if>
					<c:if
						test="${moduloPrenotazioneBean.getUtenteRichiedente() != null}">
						<input type="text"
							name="<portlet:namespace/>nomeUtenteRichiedente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-utente-richiedente-placeholder'/>"
							id="<portlet:namespace/>utenteRichiedente"
							value="${moduloPrenotazioneBean.getUtenteRichiedente().toUpperCase()}">
					</c:if>
				</div>
				<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
					<label for="<portlet:namespace/>telefonoRichiedente"
						class="label-form"><liferay-ui:message
							key="prenotazione-prenota-telefono-richiedente" />*</label>
					<c:if
						test="${moduloPrenotazioneBean.getTelefonoRichiedente() == null }">
						<input type="text" name="<portlet:namespace/>telefonoRichiedente"
							class="input-custom-light data-parsley-validated" 
							data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
							data-parsley-maxlength="30"
							data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-telefono-richiedente-placeholder'/>"
							id="<portlet:namespace/>telefonoRichiedente">
					</c:if>
					<c:if
						test="${moduloPrenotazioneBean.getTelefonoRichiedente() != null }">
						<input type="text" name="<portlet:namespace/>telefonoRichiedente"
							class="input-custom-light data-parsley-validated" 
							data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
							data-parsley-maxlength="30"
							data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-telefono-richiedente-placeholder'/>"
							id="<portlet:namespace/>telefonoRichiedente"
							value="${moduloPrenotazioneBean.getTelefonoRichiedente().toUpperCase()}">
					</c:if>
				</div>
				<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
					<label for="<portlet:namespace/>utenteReferente" class="label-form"><liferay-ui:message
							key="prenotazione-prenota-utente-referente" />*</label>
					<c:if test="${moduloPrenotazioneBean.getUtenteReferente() == null}">
						<input type="text" name="<portlet:namespace/>utenteReferente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-utente-referente-placeholder'/>"
							id="<portlet:namespace/>utenteReferente"
							value="${moduloPrenotazioneBean.getUtenteRichiedente().toUpperCase()}"
							>
					</c:if>
					<c:if test="${moduloPrenotazioneBean.getUtenteReferente() != null}">
						<input type="text" name="<portlet:namespace/>utenteReferente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-utente-referente-placeholder'/>"
							id="<portlet:namespace/>utenteReferente"
							value="${moduloPrenotazioneBean.getUtenteReferente().toUpperCase()}">
					</c:if>
				</div>
				<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
					<label for="<portlet:namespace/>telefonoReferente"
						class="label-form"><liferay-ui:message
							key="prenotazione-prenota-telefono-referente" />*</label>
					<c:if
						test="${moduloPrenotazioneBean.getTelefonoReferente() == null}">
						<input type="text" name="<portlet:namespace/>telefonoReferente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
							data-parsley-maxlength="30"
							data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-telefono-referente-placeholder'/>"
							id="<portlet:namespace/>telefonoReferente"
							value="${moduloPrenotazioneBean.getTelefonoRichiedente()}">
					</c:if>
					<c:if
						test="${moduloPrenotazioneBean.getTelefonoReferente() != null}">
						<input type="text" name="<portlet:namespace/>telefonoReferente"
							class="input-custom-light data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
							data-parsley-maxlength="30"
							data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
							placeholder="<liferay-ui:message key='prenotazione-prenota-telefono-referente-placeholder'/>"
							id="<portlet:namespace/>telefonoReferente"
							value="${moduloPrenotazioneBean.getTelefonoReferente()}">
					</c:if>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="prenotazione-prenota-servizi-aggiuntivi" />
					</h2>
				</div>
			</div>
		</div>
		
		<div class="ama-row">
		 <div class="ama-col-md-6 mb-25-xs">
            <label for="<portlet:namespace/>strumentazioneTecnici"
					class="label-form"><liferay-ui:message
						key="prenotazione-prenota-strumentazione-tecnici" />
					<p class="aler-msg">
						<span class="icomoon-alert"></span>
						<liferay-ui:message key="prenotazione-prenota-giorno-preavviso" />
					</p> </label> <select class="init-multiselect multiselect-ui form-control" multiple="multiple"
					name="<portlet:namespace/>strumentazioneTecnici"
					id="<portlet:namespace/>strumentazioneTecnici"
					>
					<c:forEach
						items="${moduloPrenotazioneBean.getStrumentazioneTecnica()}"
						var="strumentoTecnica">
						<c:choose>
							<c:when test="${listServiziTecniciId != null}">
								<c:choose>
									<c:when
										test="${listServiziTecniciId.contains(strumentoTecnica.getId_strumento())}">
										<option value="${strumentoTecnica.getId_strumento()}" selected>${strumentoTecnica.getDesc_strumento().toUpperCase()}</option>
									</c:when>
									<c:otherwise>
										<option value="${strumentoTecnica.getId_strumento()}">${strumentoTecnica.getDesc_strumento().toUpperCase()}</option>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<option value="${strumentoTecnica.getId_strumento()}">${strumentoTecnica.getDesc_strumento().toUpperCase()}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
        </div> 
        
        <div class="ama-col-md-6 mb-25-xs">
            <label for="<portlet:namespace/>strumentazioneEventi"
					class="label-form"><liferay-ui:message
						key="prenotazione-prenota-strumentazione-eventi" /></label> <select
					class="init-multiselect multiselect-ui form-control" multiple="multiple"
					name="<portlet:namespace/>strumentazioneEventi"
					id="<portlet:namespace/>strumentazioneEventi" disabled>
					<c:forEach
						items="${moduloPrenotazioneBean.getStrumentazioneEventi()}"
						var="strumentoEvent">
						
						<c:choose>
							<c:when test="${listServiziEventiId != null}">
								<c:choose>
									<c:when test="${listServiziEventiId.contains(strumentoEvent.getId_strumento())}">
										<option value="${strumentoEvent.getId_strumento()}" selected>${strumentoEvent.getDesc_strumento().toUpperCase()}</option>
									</c:when>
									<c:otherwise>
										<option value="${strumentoEvent.getId_strumento()}">${strumentoEvent.getDesc_strumento().toUpperCase()}</option>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<option value="${strumentoEvent.getId_strumento()}">${strumentoEvent.getDesc_strumento().toUpperCase()}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
        </div>
        
        <div class="ama-col-md-6 mb-25-xs">
            <label for="<portlet:namespace/>serviziLogistici" class="label-form"><liferay-ui:message
						key="prenotazione-prenota-servizi-logistici" /></label> <select
					class="init-multiselect multiselect-ui form-control" multiple="multiple"
					name="<portlet:namespace/>serviziLogistici"
					id="<portlet:namespace/>serviziLogistici"
					name="<portlet:namespace/>serviziLogistici" disabled>
					<c:forEach items="${moduloPrenotazioneBean.getServizioLogistici()}"
						var="servizioLogistic">
					<c:choose>
							<c:when test="${listServiziLogisticiId != null}">
								<c:choose>
									<c:when
										test="${listServiziLogisticiId.contains(servizioLogistic.getId_servizio())}">
										<option value="${servizioLogistic.getId_servizio()}" selected>${servizioLogistic.getDesc_servizio().toUpperCase()}</option>
									</c:when>
									<c:otherwise>
										<option value="${servizioLogistic.getId_servizio()}">${servizioLogistic.getDesc_servizio().toUpperCase()}</option>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<option value="${servizioLogistic.getId_servizio()}">${servizioLogistic.getDesc_servizio().toUpperCase()}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
        </div>
        
        </div>

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<input type="hidden" name="<portlet:namespace/>jsonRichiedente"
				id="<portlet:namespace/>jsonRichiedente">
				 
				 <input type="hidden"
				value="${moduloPrenotazioneBean.getIdPrenotazione()}"
				name="<portlet:namespace/>idPrenotazione" />
				
				<input type="hidden" id="<portlet:namespace/>currentUserEmail"
				value="${currentUserEmail}"
				name="<portlet:namespace/>currentUserEmail" />
	</form>
</div>
<div class="ama-row">
	<div class="ama-col-sm-6 text-right mb-100-md mb-10-xs mt-50-md">
		<form action="<%=vaiPaginaRicerca%>" method="post">
			<button class="button button-secondary"
				id="<portlet:namespace/>annulla">
				<liferay-ui:message key="prenotazione-prenota-annulla-btn" />
			</button>
		</form>
	</div>
	<c:choose>
		<c:when test="${modificaPrenota == 0}">
			<div class="ama-col-sm-6 text-left mb-100-md mb-30-xs mt-50-md">
				<button class="button button-primary"
					id="<portlet:namespace/>prenota">
					<liferay-ui:message key="prenotazione-prenota-btn" />
				</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="ama-col-sm-6 text-left mb-100-md mb-30-xs mt-50-md">
				<button  class="button button-primary"
					id="<portlet:namespace/>modifica"><liferay-ui:message key="prenotazione-modifica-btn"/></button>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<script type="text/javascript">

	function placeholderIe(){
	    if($("html").hasClass("ie10") || $("html").hasClass("ie11")){
	        $('[placeholder]').focus(function() {
	            var input = $(this);
	            if (input.val() == input.attr('placeholder')) {
	                input.val('');
	                input.removeClass('placeholder');
	            }
	        }).blur(function() {
	            var input = $(this);
	            if (input.val() == '' || input.val() == input.attr('placeholder')) {
	                input.addClass('placeholder');
	                input.val('');
	            }
	        }).blur();
	    }    
	} 
	
	if ($(".form-control.textarea-custom-light").length > 0) {
	    $(".form-control.textarea-custom-light").keyup(function(){
	        element = $(this);
	        var len = 0;
	        var maxLength = $(element).attr("data-parsley-maxlength");
	        if (element.val() != null){
	            len = element.val().length;
	        } else{
	            len = element.length;
	        }
	        if(maxLength==null || maxLength=="" || maxLength<1 ){
	            maxLength = 500;
	        }
	        if (len > maxLength) {
	            element.val(element.val().substring(0,maxLength));
	            len = maxLength;
	        }
	        $(element).parent(".wrapper-content-textarea").find(".content-textarea").text( (len)+ "/"+maxLength);
	    });
	    placeholderIe();
	}
	
	var arrayOraInizio = [];
	arrayOraInizio = new Array('<%for(int i = 0; i <moduloPrenotazioneBean.getOrari().size()-1; i++) {out.print(moduloPrenotazioneBean.getOrari().get(i).toJSON());if(i+1 < moduloPrenotazioneBean.getOrari().size()) {out.print(",");}}%>');
</script>

<script type="text/javascript">
	var flagPrenota = true;
	var idOraInizio = <%=request.getAttribute("oraInizioSalaPrenota")%>;
	var idOraFine = <%=request.getAttribute("oraFineSalaPrenota")%>;
	var array = [];
	var jsonObj = {};
	var jsonObjServiziAggiuntivi = {};
	if ($("#<portlet:namespace/>tipoEvent").val() == "2" || $("#<portlet:namespace/>tipoEvent").val() == "3"){
		$("#<portlet:namespace/>strumentazioneEventi").prop("disabled",false);
		$("#<portlet:namespace/>strumentazioneEventi").next("div").find("button").removeClass("disabled").prop("disabled", false);
		$("#<portlet:namespace/>serviziLogistici").prop("disabled",false);
		$("#<portlet:namespace/>serviziLogistici").next("div").find("button").removeClass("disabled").prop("disabled", false);
	}
	$("#<portlet:namespace/>tipoEvent").change(function(){

	if($(this).val() == "2" || $(this).val() == "3"){
			$("#<portlet:namespace/>strumentazioneEventi").prop("disabled",false);
			$("#<portlet:namespace/>strumentazioneEventi").next("div").find("button").removeClass("disabled").prop("disabled", false);
			
			$("#<portlet:namespace/>serviziLogistici").prop("disabled",false);
			$("#<portlet:namespace/>serviziLogistici").next("div").find("button").removeClass("disabled").prop("disabled", false);
		}else{
			$("#<portlet:namespace/>strumentazioneEventi").next("div").find("button").prop("title", "NESSUN ELEMENTO SELEZIONATO");
			$("#<portlet:namespace/>strumentazioneEventi").next("div").find("span").text("NESSUN ELEMENTO SELEZIONATO");
			$("#<portlet:namespace/>strumentazioneEventi").next("div").find(".multiselect-container li").removeClass("active");
			$("#<portlet:namespace/>strumentazioneEventi").next("div").find(".multiselect-container li").find("input").prop("checked",false);
			$("#<portlet:namespace/>strumentazioneEventi").prop("disabled",true);
			$("#<portlet:namespace/>strumentazioneEventi").next("div").find("button").addClass("disabled").prop("disabled", true);
			$("#<portlet:namespace/>strumentazioneEventi").prop("selectedIndex",0);
			
			$("#<portlet:namespace/>serviziLogistici").next("div").find("button").prop("title", "NESSUN ELEMENTO SELEZIONATO");
			$("#<portlet:namespace/>serviziLogistici").next("div").find("span").text("NESSUN ELEMENTO SELEZIONATO");
			$("#<portlet:namespace/>serviziLogistici").next("div").find(".multiselect-container li").removeClass("active");
			$("#<portlet:namespace/>serviziLogistici").next("div").find(".multiselect-container li").find("input").prop("checked",false);
			$("#<portlet:namespace/>serviziLogistici").prop("disabled",true);
			$("#<portlet:namespace/>serviziLogistici").next("div").find("button").addClass("disabled").prop("disabled", true);
			$("#<portlet:namespace/>serviziLogistici").prop("selectedIndex",0);
		}
	});
	
	$("#<portlet:namespace/>prenota").click("on",function(){
		
		$("#<portlet:namespace/>prenotaAula").parsley().validate();
		
		if( flagPrenota && $("#<portlet:namespace/>prenotaAula").parsley().isValid() ){
			flagPrenota = false;	
		
			var datiUfficioRichiedente = $("#<portlet:namespace/>ufficioRichidente").val();
			var datiUfficioDirigente = $("#<portlet:namespace/>ufficioDirigente").val();
			var datiUtenteRichiedente = $("#<portlet:namespace/>utenteRichiedente").val();
			var utenteEmailReferente = $("#<portlet:namespace/>currentUserEmail").val();
			var datiTelefonoRichiedente = $("#<portlet:namespace/>telefonoRichiedente").val();
			var datiUtenteReferente = $("#<portlet:namespace/>utenteReferente").val();
			var datiTelefonoReferente = $("#<portlet:namespace/>telefonoReferente").val();		
		
			var servizioTecniche   = $("#<portlet:namespace/>strumentazioneTecnici").val();
			var servizioLogistiche = $("#<portlet:namespace/>serviziLogistici").val();
			var strumentiEventi = $("#<portlet:namespace/>strumentazioneEventi").val();
		
			jsonObj = {
			ufficiorichiedente : datiUfficioRichiedente,
			dirigenteufficio : datiUfficioDirigente,
			utenterichiedente : datiUtenteRichiedente,
			utenteEmailRichiedente : utenteEmailReferente,
			telefonorichiedente : datiTelefonoRichiedente,
			referente : datiUtenteReferente,
			telefonoreferente : datiTelefonoReferente
			};
			
			$("#<portlet:namespace/>jsonRichiedente").val(JSON.stringify(jsonObj));
			$("#<portlet:namespace/>prenotaAula").submit();
		}
		
	});
	
	$("#<portlet:namespace/>modifica").click("on",function(){
		
		var datiUfficioRichiedente = $("#<portlet:namespace/>ufficioRichidente").val();
		var datiUfficioDirigente = $("#<portlet:namespace/>ufficioDirigente").val();
		var datiUtenteRichiedente = $("#<portlet:namespace/>utenteRichiedente").val();
		var utenteEmailReferente = $("#<portlet:namespace/>currentUserEmailAddress").val();
		var datiTelefonoRichiedente = $("#<portlet:namespace/>telefonoRichiedente").val();
		var datiUtenteReferente = $("#<portlet:namespace/>utenteReferente").val();
		var datiTelefonoReferente = $("#<portlet:namespace/>telefonoReferente").val();
		
		datiUfficioRichiedente = datiUfficioRichiedente.toLowerCase();
		datiUfficioDirigente = datiUfficioDirigente.toLowerCase();
		datiUtenteRichiedente = datiUtenteRichiedente.toLowerCase();
		datiUtenteReferente = datiUtenteReferente.toLowerCase();
		
		var servizioTecniche   = $("#<portlet:namespace/>strumentazioneTecnici").val();
		var servizioLogistiche = $("#<portlet:namespace/>serviziLogistici").val();
		var strumentiEventi = $("#<portlet:namespace/>strumentazioneEventi").val();
		
		jsonObj = {
		ufficiorichiedente : datiUfficioRichiedente,
		dirigenteufficio : datiUfficioDirigente,
		utenterichiedente : datiUtenteRichiedente,
		utenteEmailRichiedente : utenteEmailReferente,
		telefonorichiedente : datiTelefonoRichiedente,
		referente : datiUtenteReferente,
		telefonoreferente : datiTelefonoReferente
		};
		
		$("#<portlet:namespace/>jsonRichiedente").val(JSON.stringify(jsonObj));
		$("#<portlet:namespace/>prenotaAula").attr("action","${updatePrenotazione}");
		$("#<portlet:namespace/>prenotaAula").submit();
		
	});
	var selectIdOraInizio = "#<portlet:namespace/>oraInizio";
	var selectIdOraFine = "#<portlet:namespace/>oraFine";
	var arrayOraInizio =[];
	var arrayOraFine=[];
	arrayOraInizio = new Array(<%
			for(int i = 0; i <orarioBeans.size()-1; i++) {
				   out.print(orarioBeans.get(i).toJSON());
				  if(i+1 < orarioBeans.size()-1) {
				    out.print(",");
				  }
				}	
		%>);
		
		arrayOraInizio.forEach(createOptionForSelectOra,{selectId:selectIdOraInizio, optionSelected:idOraInizio});
		
		arrayOraFine = new Array(<%
			for(int i = 1; i <orarioBeans.size(); i++) {
				   out.print(orarioBeans.get(i).toJSON());
				  if(i+1 < orarioBeans.size()) {
				    out.print(",");
				  }
				}	
		%>);
		
		arrayOraFine.forEach(createOptionForSelectOra,{selectId:selectIdOraFine, optionSelected:idOraFine});
	
		var arrayTmp =[];
		arrayTmp =arrayOraFine.slice(0);
		var arrayInizioTmp = [];
		arrayInizioTmp = arrayOraInizio.slice(0);
		function createOptionForSelectOra(item,index,arr){
		if(this.optionSelected!=null && this.optionSelected!="" && this.optionSelected==item.id){
			
			$(this.selectId).append("<option value='"+item.id+"' selected>"+item.ora+"</option>");
		}else{
			
			$(this.selectId).append("<option value='"+item.id+"' >"+item.ora+"</option>");
		}
			
	}
	var removeIndex=0;
	function removeOptionSelectOraFine(item,index,arr){
			var oraInizio = this.oraValue;
		  	var removeItemId = parseInt(item.id);
			var oraInzioValue = parseInt(oraInizio);
			if(removeItemId <= oraInzioValue){
				arrayTmp.splice(removeIndex,1);
			}else{
				removeIndex=index;
			 	}
			$(selectIdOraFine).empty();
			arrayTmp.forEach(createOptionForSelectOra,{selectId:selectIdOraFine});
		}
	$(selectIdOraInizio).change(function(){
		var oraValue = $(this).val();
		
		arrayOraFine.forEach(removeOptionSelectOraFine,{oraValue:oraValue});
		removeIndex = 0;
		arrayTmp =arrayOraFine.slice(0);
		});
		
	function onChangeSala(){
		var id_sala_selected = $("#<portlet:namespace/>SalaId").val();
		var idSalaHidden = "";
		var capienzaSalaSelezionata = 0;
		if(id_sala_selected != null && id_sala_selected != ""){
			idSalaHidden = "#n_posti" + id_sala_selected;
			capienzaSalaSelezionata = $(idSalaHidden).val();
			$("#numeroPostiSalaInserimento").val(capienzaSalaSelezionata);
		}
	}
	
	 $(function(){
	      $(document).ready(function(){
	    	 var idSalaSelected = $("#idSalaSelected").val();
	    	 var idSelectSala = $("#namespace").val() + "SalaId";
	    	 if(idSalaSelected != null && typeof idSalaSelected !== "undefined" && idSalaSelected != ""){
	    	 	var selection = "select[id="+idSelectSala+"] option[value=" + idSalaSelected + "]";
	        	$(selection).attr("selected", "selected");
	    	 }
	       });
	   });
	 
	 
	 
	 
	 
</script>