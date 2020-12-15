<%@page import="com.intranet.mef.gestione.riunioni.model.RiunioneModel"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Riunione"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Luogo"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.StatoRiunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Riunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.TipoRiunione"%>
<%@page import="com.mef.ricercariunione.stub.Segreteria"%>

<%@page
	import="com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.intranet.mef.util.BeanCreator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
String roleCoordinatore = ParamUtil.getString(request, "roleCoordinatore");
if (roleCoordinatore.equals(""))
	roleCoordinatore = (String) request.getAttribute("roleCoordinatore");
if (roleCoordinatore==null)
	roleCoordinatore="";

String roleAdministrator = ParamUtil.getString(request, "roleAdministrator");
if (roleAdministrator.equals(""))
	roleAdministrator = (String) request.getAttribute("roleAdministrator");
if (roleAdministrator==null)
	roleAdministrator="";

Long companyIdLong = ParamUtil.getLong(request, "companyId");
if (companyIdLong==0){
	companyIdLong = (Long) request.getAttribute("companyId");

}
String companyId = String.valueOf(companyIdLong);
	int list_Size = 0;	
	
	/*
		call DB
	*/
		BeanCreator segrUtil= new BeanCreator();

	List<AmministrazioneConvocante> amministrazioni = segrUtil.getAmministrazioniConvocantiList();  

    List<TipoRiunione> tipologiaList = segrUtil.createListaTipiRiunione();
    List<StatoRiunione> allStatiRiunione = segrUtil.createListaStatoRiunione();
	List<Riunione> lista_res = new ArrayList<>(0);
	if(request.getAttribute("risultatiReport")!=null){
		 lista_res = (List<Riunione>) request.getAttribute("risultatiReport");
	}
	Long firstRiunione =0l;
	if(!lista_res.isEmpty()){
		firstRiunione = lista_res.get(0).getId_riunione();
	}
		
	List<Segreteria> listaIsp = segrUtil.createListaSegreterie();
	String titoloPrincipaleStampa=ParamUtil.getString(request, "titleStampaRiunione");
	String titoloStampa=ParamUtil.getString(request, "subTitleStampaRiunione");
	if(titoloPrincipaleStampa.isEmpty() && titoloStampa.isEmpty()){
		titoloPrincipaleStampa=(String)request.getAttribute("titleStampaRiunione");
	    titoloStampa=(String)request.getAttribute("subTitleStampaRiunione");
	}
    Luogo luogo = null;
	AmministrazioneConvocante amministrazioneConvocante=null;
	TipoRiunione tipoRiunione= null;
	
String param_chiave = "";
if(request.getAttribute("param_chiave") != null){
	param_chiave = (String) request.getAttribute("param_chiave");	
}

String param_da = "";
if(request.getAttribute("param_da") != null){
	param_da = (String) request.getAttribute("param_da");	
}

String param_a = "";
if(request.getAttribute("param_a") != null){
	param_a = (String) request.getAttribute("param_a");	
}

String param_stato = "";
if(request.getAttribute("param_stato") != null){
	param_stato = (String) request.getAttribute("param_stato");	
}

String param_isp = "";
if(request.getAttribute("param_isp") != null){
	param_isp = (String) request.getAttribute("param_isp");	
}

String param_data = "";
if(request.getAttribute("param_data") != null){
	param_data=(String) request.getAttribute("param_data");	
}

String param_protocollo = "";
if(request.getAttribute("param_protocollo") != null){
	param_protocollo = (String) request.getAttribute("param_protocollo");	
}
String param_tipo = "";
if(request.getAttribute("param_tipo") != null){
	param_tipo = (String) request.getAttribute("param_tipo");	
}

String param_amministrazione = "";
if (request.getAttribute("param_amministrazione") != null){
	param_amministrazione = (String) request.getAttribute("param_amministrazione");
}

String param_periodoClass ="collapse in";
String param_giornoClass="collapse";
String param_giornoClassActive="";
String param_periodoClassActive="active";

if (request.getAttribute("param_periodo") != null){
	if (request.getAttribute("param_periodo").equals("giorno")){
		param_da="";
		param_a="";
		param_periodoClass = "collapse";
		param_giornoClass="collapse in";
		param_giornoClassActive="active";
		param_periodoClassActive="";
	}else
		param_data="";
}

%>
<portlet:actionURL name="searchInvite" var="searchInvite"></portlet:actionURL>
<portlet:actionURL name="cancelInvite" var="cancelInvite"></portlet:actionURL>

<div class="gestione-riunioni-title-box">
	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<div class="title-wrapper">
					<h2 class="title">
						<%=titoloPrincipaleStampa %>
					</h2>
					<p class="subtitle dot-point dot-200"><%=titoloStampa%></p>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="gestione-riunioni-wrapper">
	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<portlet:actionURL name="ricercaReport" var="ricercaUrl" />
					<div class="tab-filtri filtro-categoria collapse-group"
						id="tabs-riunioni">
						<div class="filtro-tabs-wrapper">
						<a href="" title='<liferay-ui:message key="gestione-riunione-stampa-periodo-title"/>' class="tab-title <%=param_periodoClassActive%>"
							data-toggle="collapse" data-target="#filter-period"
							data-parent="#tabs-riunioni" onclick="setFieldsPeriod()">
							<liferay-ui:message key="gestione-riunione-stampa-periodo" /></a>
								<c:if test="<%=roleCoordinatore.equals("coordinatore") || roleAdministrator.equals("Administrator")%>">
									<a href="" title='<liferay-ui:message key="gestione-riunione-stampa-giorno-title" />' class="tab-title <%= param_giornoClassActive%>" data-toggle="collapse"
										data-target="#filter-day" data-parent="#tabs-riunioni" onclick="setFieldsDay()">
										<liferay-ui:message	key="gestione-riunione-stampa-giorno" /></a>
								</c:if>		
						</div>
						<div id="filter-period" class="<%=param_periodoClass%>">
						<form data-parsley-validate="true" id="form-global-search-period" action="<%=ricercaUrl%>" method="post" enctype="multipart/form-data" >
							<input type="hidden" name="<portlet:namespace/>companyId" id="<portlet:namespace/>companyId" value="<%=companyId%>"/>
							<div class="filtro-body-box">
								<div class="filtro-content-box filtro-additional">
									<div class="ama-row">
										<div class="ama-col-md-5 ama-col-sm-12">
											<div class="ama-row">
												<div class="ama-col-md-5 ama-col-sm-12">
													<div class="ama-row ">
														<div class="wrapper-content-date border-right">
															<div
																class="ama-col-md-12 ama-col-sm-6 ama-col-xs-6 filtro-type-wrapper">
																<label for="date1"
																	class="label-form-notice title margin-top-xs">
																	<liferay-ui:message key="gestione-riunione-stampa-dal" />*</label> 
																	<input id="date1" data-parsley-required="true" type="text"
																		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
																		data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
																		data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																		name="<portlet:namespace/>StartDate"
																		class="datepicker-custom input-custom-light data-parsley-validated"
																		placeholder="DD/MM/AAAA" value="<%=param_da%>"/>
															</div>
															<div
																class="ama-col-md-12 ama-col-sm-6 ama-col-xs-6 filtro-type-wrapper">
																<label for="date" class="label-form-notice title margin-top-xs margin-top">
																<liferay-ui:message key="gestione-riunione-stampa-al" />*</label> 
																	<input id="Deadline" data-parsley-required="true" type="text"
																		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
																		data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
																		data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																		name="<portlet:namespace/>Deadline"
																		class="datepicker-custom input-custom-light data-parsley-validated"
																		placeholder="DD/MM/AAAA" value="<%=param_a%>"
																		data-parsley-compare-sumbission-expiration-date="#date1"
																		data-parsley-check-start-date="#date1"/>
															</div>
														</div>
													</div>
												</div>

												<div class="ama-col-sm-12 ama-col-xs-12 ama-col-md-7">
													<div class="ama-row">
														<div
															class="ama-col-sm-6 ama-col-md-12 filtro-type-wrapper">
															<label for="parola_chiave"
																class="label-form-notice title margin-top-xs">
																<liferay-ui:message key="gestione-riunione-stampa-parola-chiave" /></label> <input type="text"
																name="<portlet:namespace/>parola_chiave" id="parola_chiave"
																class="input-meetings ico-search"
																placeholder='<liferay-ui:message key="gestione-riunione-stampa-parola-chiave-placeholder"/>' value="<%=param_chiave%>"/>
														</div>

														<div
															class="ama-col-sm-6 ama-col-md-12 filtro-type-wrapper">
															<label for="protocollo"
																class="label-form-notice title margin-top">
																<liferay-ui:message	key="gestione-riunione-stampa-protocollo" /></label> <input type="text"
																name="<portlet:namespace/>protocollo" id="protocollo"
																class="input-meetings"
																placeholder='<liferay-ui:message key="gestione-riunione-stampa-protocollo-placeholder" />' value="<%=param_protocollo%>"/>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="ama-col-md-7 ama-col-sm-12">
											<div class="ama-row ">
												<div class="wrapper-content-date">
													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="amministrazione"
															class="label-form-notice title margin-top-xs"><liferay-ui:message
																key="gestione-riunione-stampa-amministrazione-convocante" /></label> <select
															 class="option-select"
															name="<portlet:namespace/>amministrazione" id="amministrazione">
															<c:if test="<%=amministrazioni != null%>">
																<option value="0" hidden><liferay-ui:message
																			key="gestione-riunione-stampa-amministrazione-convocante-select" /></option>
																<c:forEach items="<%=amministrazioni%>" var="am">
																	<c:set var="id_amministrazione" value="${am.getId_amministrazione_convocante().toString()}"/>

																	
																	<c:if test="${param_amministrazione == id_amministrazione}">
																		<option selected="true" value="${am.getId_amministrazione_convocante()}">${am.getNome_amministrazione().toUpperCase()}</option>  								  	   	 
																   </c:if>
																	<c:if test="${param_amministrazione!=id_amministrazione}">
																		<option	value="${am.getId_amministrazione_convocante()}">${am.getNome_amministrazione().toUpperCase()}</option>
																	</c:if>
																	</c:forEach>
															</c:if>
														</select>
													</div>

													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="ispettorato"
															class="label-form-notice title margin-top-xs"><liferay-ui:message
																key="gestione-riunione-stampa-ispettorato" /> </label> <select 
															class="option-select"
															name="<portlet:namespace/>ispettorato" id="ispettorato">
															<c:if test="<%=listaIsp!= null%>">
															<option value="0" hidden><liferay-ui:message
																			key="gestione-riunione-stampa-ispettorato-select" /></option>
																<c:forEach items="<%=listaIsp%>" var="isp">
																<c:set var="id_segr" value="${isp.getId_segreteria().toString()}"/>
			
																
																	<c:if test="${param_isp == id_segr}">
																		<option selected="true" value="${isp.getId_segreteria()}">${isp.getSegreteria_nome().toUpperCase()}</option>  								  	   	 
																   </c:if>
																	<c:if test="${param_isp!=id_segr}">
																		<option value="${isp.getId_segreteria()}">${isp.getSegreteria_nome().toUpperCase()}</option>  								  	   	 
																	</c:if>
																</c:forEach>
															</c:if>
														</select>
													</div>
												</div>
											</div>

											<div class="ama-row ">
												<div class="wrapper-content-date">
													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="tipologia"
															class="label-form-notice title margin-top"><liferay-ui:message
																key="gestione-riunione-stampa-tipologia" /></label> <select
															 class="option-select"
															name="<portlet:namespace/>tipologia" id="tipologia">
															<c:if test="<%=tipologiaList!= null%>">
																<option value="0" hidden><liferay-ui:message
																			key="gestione-riunione-stampa-tipologia-select" /></option>
																<c:forEach items="<%=tipologiaList%>" var="tipo">
																<c:set var="id_tipo" value="${tipo.getId_tipo().toString()}"/>
																
																			<c:if test="${param_tipo == id_tipo}">
																		<option selected="true" value="${tipo.getId_tipo()}">${tipo.getDescrizione().toUpperCase()}</option>
																   </c:if>
																	<c:if test="${param_tipo!=id_tipo}">
																		<option value="${tipo.getId_tipo()}">${tipo.getDescrizione().toUpperCase()}</option>							  	   	 
																</c:if>
																</c:forEach>
															</c:if>
														</select>
													</div>

													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="stato"
															class="label-form-notice title margin-top"><liferay-ui:message
																key="gestione-riunione-stampa-stato" /></label> <select 
															class="option-select" name="<portlet:namespace/>stato" id="stato">
															<c:if test="<%=allStatiRiunione!= null%>">
																<option value="0" hidden><liferay-ui:message
																			key="gestione-riunione-stampa-stato-select" /></option>
																<c:forEach items="<%=allStatiRiunione%>" var="statoR">
																<c:set var="id_stato" value="${statoR.getPrimaryKey().toString()}"/>

																
															
																	<c:if test="${param_stato == id_stato}">
																		<option selected="true" value="${statoR.getPrimaryKey()}">${statoR.getLabel().toUpperCase()}</option>
																   </c:if>
																	<c:if test="${param_stato!=id_stato}">
																		<option value="${statoR.getPrimaryKey()}">${statoR.getLabel().toUpperCase()}</option>
																	</c:if>
																</c:forEach>
															</c:if>
														</select>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="buttons-wrapper ama-col-xs-12">
										<div class="ama-col-sm-6 ama-col-xs-12 text-center">
											<button type="button" onclick="resetForm()" 
												class="button button-secondary">
												<liferay-ui:message key="gestione-riunione-stampa-cancella" />
											</button>
										</div>
										<div class="ama-col-sm-6 ama-col-xs-12 text-center">
											<button  type="button" onclick="submitFormReport('#form-global-search-period')" class="button button-primary">
												<liferay-ui:message key="gestione-riunione-stampa-applica" />
											</button>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" name="<portlet:namespace/>periodo" value="periodo"/>
						</form>
					</div>
					<c:if test="<%=roleCoordinatore.equals("coordinatore") || roleAdministrator.equals("Administrator")%>">
						<div id="filter-day" class="<%=param_giornoClass%>">
							<form id="form-id-search" data-parsley-validate="true" action="<%=ricercaUrl%>" method="post" enctype="multipart/form-data">
								<input type="hidden" name="<portlet:namespace/>companyId" id="<portlet:namespace/>companyId" value="<%=companyId%>"/>
								<div class="filtro-body-box">
									<div class="filtro-content-box filtro-additional">
										<div class="ama-row">
											<div class="ama-col-md-5 ama-col-sm-12">
												<div class="ama-row">
													<div class="ama-col-md-5 ama-col-sm-12">
														<div class="ama-row ">
															<div class="wrapper-content-date border-right">
																<div class="ama-col-md-12 ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
																	<label for="date2"
																		class="label-form-notice title margin-top-xs"><liferay-ui:message
																		key="gestione-riunione-stampa-il" /></label> 
																	<input id="date2" 
																		data-parsley-required="true" type="text"
																		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
																		data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
																		data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																		name="<portlet:namespace/>data"
																		class="datepicker-custom input-custom-light data-parsley-validated"
																		placeholder="DD/MM/AAAA" value="<%=param_data%>">
																</div>
															</div>
														</div>
													</div>

												<div class="ama-col-sm-12 ama-col-xs-12 ama-col-md-7">
													<div class="ama-row">
														<div
															class="ama-col-sm-6 ama-col-md-12 filtro-type-wrapper">
															<label for="parola_chiave2" class="label-form-notice title margin-top-xs">
																<liferay-ui:message key="gestione-riunione-stampa-parola-chiave" />
															</label> 
															<input type="text"
																name="<portlet:namespace/>parola_chiave" id="parola_chiave2"
																class="input-meetings ico-search"
																placeholder="Che cosa stai cercando?" value="<%=param_chiave%>">
														</div>

														<div
															class="ama-col-sm-6 ama-col-md-12 filtro-type-wrapper">
															<label for="protocollo2"
																class="label-form-notice title margin-top">
																	<liferay-ui:message key="gestione-riunione-stampa-protocollo" />
															</label> 
															<input type="text"
																name="<portlet:namespace/>protocollo" id="protocollo2"
																class="input-meetings"
																placeholder="Inserisci il numero di protocollo" value="<%=param_protocollo%>">
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="ama-col-md-7 ama-col-sm-12">
											<div class="ama-row ">
												<div class="wrapper-content-date">
													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="amministrazione2"
															class="label-form-notice title margin-top-xs">	
															<liferay-ui:message key="gestione-riunione-stampa-amministrazione-convocante" />
														</label> 
														<select
															id="amministrazione2" class="option-select" name="<portlet:namespace/>amministrazione">
															<c:if test="<%=amministrazioni != null%>">
															<option value="0" hidden><liferay-ui:message
																			key="scegli-elenco" /></option>
																<c:forEach items="<%=amministrazioni%>" var="am">
																	<c:set var="id_amministrazione" value="${am.getId_amministrazione_convocante().toString()}"/>

																	
																	<c:if test="${param_amministrazione == id_amministrazione}">
																		<option selected="true" value="${am.getId_amministrazione_convocante()}">${am.getNome_amministrazione().toUpperCase()}</option>  								  	   	 
																   </c:if>
																	<c:if test="${param_amministrazione!=id_amministrazione}">
																		<option	value="${am.getId_amministrazione_convocante()}">${am.getNome_amministrazione().toUpperCase()}</option>
																	</c:if></c:forEach>
															</c:if>
														</select>
													</div>

													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="ispettorato2" class="label-form-notice title margin-top-xs">
																<liferay-ui:message	key="gestione-riunione-stampa-ispettorato" />
														</label> 
														<select id="ispettorato2"
															class="option-select" name="<portlet:namespace/>ispettorato">
															<c:if test="<%=listaIsp!= null%>">
																<option value="0" hidden><liferay-ui:message
																			key="scegli-elenco" /></option>
																<c:forEach items="<%=listaIsp%>" var="isp">
																	<c:set var="id_segr" value="${isp.getId_segreteria().toString()}"/>
			
																
																	<c:if test="${param_isp == id_segr}">
																		<option selected="true" value="${isp.getId_segreteria()}">${isp.getSegreteria_nome().toUpperCase()}</option>  								  	   	 
																   </c:if>
																	<c:if test="${param_isp!=id_segr}">
																		<option value="${isp.getId_segreteria()}">${isp.getSegreteria_nome().toUpperCase()}</option>  								  	   	 
																	</c:if>
																</c:forEach>
															</c:if>
														</select>
													</div>
												</div>
											</div>

											<div class="ama-row ">
												<div class="wrapper-content-date">
													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="tipologia2"
															class="label-form-notice title margin-top">
															<liferay-ui:message	key="gestione-riunione-stampa-tipologia" />
														</label> 
														<select
															id="tipologia2" class="option-select" name="<portlet:namespace/>tipologia">
															<c:if test="<%=tipologiaList!= null%>">
																<option value="0" hidden><liferay-ui:message
																			key="scegli-elenco" /></option>
																<c:forEach items="<%=tipologiaList%>" var="tipo">
																	<c:set var="id_tipo" value="${tipo.getId_tipo().toString()}"/>
																	
																			<c:if test="${param_tipo == id_tipo}">
																		<option selected="true" value="${tipo.getId_tipo()}">${tipo.getDescrizione().toUpperCase()}</option>
																   </c:if>
																	<c:if test="${param_tipo!=id_tipo}">
																		<option value="${tipo.getId_tipo()}">${tipo.getDescrizione().toUpperCase()}</option>							  	   	 
																</c:if>
																</c:forEach>
															</c:if>
														</select>
													</div>

													<div class="ama-col-sm-6 ama-col-xs-12 filtro-type-wrapper">
														<label for="stato2"
															class="label-form-notice title margin-top">
															<liferay-ui:message key="gestione-riunione-stampa-stato" />
														</label> 
														
														<select id="stato2"
															class="option-select" name="<portlet:namespace/>stato">
															<c:if test="<%=allStatiRiunione!= null%>">
															<option value="0" hidden><liferay-ui:message
																			key="scegli-elenco" /></option>
																<c:forEach items="<%=allStatiRiunione%>" var="statoR">
																	<c:set var="id_stato" value="${statoR.getPrimaryKey().toString()}"/>

																	
															
																	<c:if test="${param_stato == id_stato}">
																		<option selected="true" value="${statoR.getPrimaryKey()}">${statoR.getLabel().toUpperCase()}</option>
																   </c:if>
																	<c:if test="${param_stato!=id_stato}">
																		<option value="${statoR.getPrimaryKey()}">${statoR.getLabel().toUpperCase()}</option>
																	</c:if>
																</c:forEach>
															</c:if>
														</select>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="buttons-wrapper ama-col-xs-12">
										<div class="ama-col-sm-6 ama-col-xs-12 text-center">
											<button type="button" onclick="resetForm()" 
												class="button button-secondary">
												<liferay-ui:message key="gestione-riunione-stampa-cancella" />
											</button>
										</div>
										<div class="ama-col-sm-6 ama-col-xs-12 text-center">
											<button type="button" onclick="submitFormReport('#form-id-search')" class="button button-primary">
												<liferay-ui:message key="gestione-riunione-stampa-applica" />
											</button>
										</div>
									</div>
								</div>
							</div>
								<input type="hidden" name="<portlet:namespace/>periodo" value="giorno"/>
							</form>
						</div>
						</c:if>
					</div>
					<c:if test="<%=lista_res != null && !lista_res.isEmpty()%>">
						<div class="result-stampe-search">
							<c:if test="<%=lista_res.size() != 0%>">
								<c:if test="<%=lista_res.size() == 1%>">
									<p>
										<strong><%= list_Size = lista_res.size()%></strong>
										&nbsp;
										<liferay-ui:message key="gestione-riunione-stampa-riunione" />
									</p>
								</c:if>
								<c:if test="<%=lista_res.size() > 1%>">
									<p>
										<strong><%= list_Size = lista_res.size()%></strong>
										&nbsp;
										<liferay-ui:message key="gestione-riunione-stampa-riunioni" />
									</p>
								</c:if>
							</c:if>
						</div>


						<c:forEach items="<%=lista_res%>" var="riunione">
							<c:set var="riunione_luogo" value="${riunione.getId_luogo()}" />
							<c:set var="riunione_amministrazione_convocante"
								value="${riunione.getId_amministrazione_convocante()}" />
								<c:set var="riunione_protocollo" value="${riunione.getProtocollo()}" />
							<c:set var="riunione_Data_inizio"
								value="${riunione.getData_inizio()}" />
							<c:set var="riunione_Data_creazione"
								value="${riunione.getData_creazione()}" />
							<c:set var="riunione_Data_ultima_modifica"
								value="${riunione.getData_modifica()}" />
							<c:set var="riunione_id_tipo" value="${riunione.getId_tipo()}" />
							<%	
			 long riunione_luogo = (long) pageContext.getAttribute("riunione_luogo");
			 long riunione_amministrazione_convocante = (long) pageContext.getAttribute("riunione_amministrazione_convocante");
			 String riunione_protocollo = (String)  pageContext.getAttribute("riunione_protocollo");
			 long riunione_id_tipo = (long) pageContext.getAttribute("riunione_id_tipo");
			 
			 Date riunione_Data_inizio = (Date) pageContext.getAttribute("riunione_Data_inizio");
			 Date riunione_Data_creazione = (Date) pageContext.getAttribute("riunione_Data_creazione");
			 Date riunione_Data_ultima_modifica = (Date) pageContext.getAttribute("riunione_Data_ultima_modifica");
			if (riunione_luogo!=0)
				luogo =  LuogoLocalServiceUtil.fetchLuogo(riunione_luogo);
			if (riunione_amministrazione_convocante!=0)
			 amministrazioneConvocante = AmministrazioneConvocanteLocalServiceUtil.fetchAmministrazioneConvocante(riunione_amministrazione_convocante);
			
			if (riunione_id_tipo!=0)
				tipoRiunione = TipoRiunioneLocalServiceUtil.fetchTipoRiunione(riunione_id_tipo);
			 
			 SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
			 SimpleDateFormat sdfOra = new SimpleDateFormat("HH:mm");
    
    	 %>


							<liferay-portlet:renderURL var="dettaglioUrl">
								<portlet:param name="mvcPath" value="/dettaglioRiunione.jsp" />
								<portlet:param name="roleCoordinatore" value="<%= roleCoordinatore%>"/>
								<portlet:param name="roleAdministrator" value="<%= roleAdministrator%>"/>
								<portlet:param name="idRiunione" value="${riunione.getId_riunione()}" />
								<portlet:param name="companyId" value="<%=companyId%>" />
							</liferay-portlet:renderURL>
							<a href="${dettaglioUrl}">
							<div class="riunione-item clearfix">
								<div class="ama-col-xs-12 no-padding">
									<div class="ama-col-md-8 header-background">
										<div class="riunione-item-header clearfix">

											<div
												class="ama-col-sm-3 ama-col-xs-6 text-center-no-mobile pt-10-xs pt-0-md">
												<span class="header-title"><span
													class="icomoon-calendar-date"></span><span class="bold">&nbsp;<%=sdfData.format(riunione_Data_inizio)%></span></span>
											</div>
											<div
												class="ama-col-sm-2 text-center-no-mobile pt-10-xs pt-0-md">
												<span class="header-title"><span class="icomoon-time"></span><span
													class="bold">&nbsp;<%=sdfOra.format(riunione_Data_inizio)%></span></span>
											</div>
											<div class="ama-col-sm-7 pt-10-xs pb-10-xs pb-0-md pt-0-md">
												<span class="header-title"><span class="icomoon-pin"></span><span
													class="bold "><c:if test="<%= luogo!=null%>">
													&nbsp;<%=luogo.getNome()%></c:if></span></span>
											</div>
										</div>
									</div>
									<div class="ama-col-md-4 header-background-right">
										<div class="riunione-item-header-right">
											<div class="ama-col-md-12 pt-15-xs pt-0-md">
												<span class="header-title"><span class="bold">
												<liferay-ui:message key="gestione-riunione-stampa-convocante" />:</span><c:if test="<%= amministrazioneConvocante!=null%>">
												&nbsp;<%=amministrazioneConvocante.getNome_amministrazione()%></c:if><span></span></span>
											</div>
										</div>
									</div>
								</div>
								<div class="ama-col-xs-12 no-padding">
									<div class="ama-col-md-8 body-border">
										<div class="riunione-item-body text-center-button">
										
										<p class="riunine-name-protocol"><liferay-ui:message key="gestione-riunione-stampa-protocollo-numero" />:<c:if test="<%= riunione_protocollo!=null%>"> 
										${ riunione.getProtocollo()}</c:if></p>
											
											<span class="label-riunioni-state"><span
												class="label-state-name"><c:if test="<%= tipoRiunione!=null%>">
												<%=tipoRiunione.getDescrizione().toUpperCase()%></c:if></span></span>
											<p class="riunione-item-name dot-mobile">${ riunione.getOggetto()}</p>
											<p
												class="riunione-item-name no-bold dot-point dot-45 dot-mobile">
												${riunione.getNote()}</p>
										</div>
									</div>
									<div class="ama-col-md-4 body-border-right">
										<div class="riunione-item-body-right clearfix padding-body">
											<div class="riunione-item-orari">
												<p class="bold-body">
													<liferay-ui:message key="gestione-riunione-stampa-riunione-inserita-in-e-room" />:
												</p>
												<span class="header-title"><span
													class="icomoon-calendar-date color-blue"></span><span
													class="label-icon">&nbsp;<%=sdfData.format(riunione_Data_creazione)%></span></span>
												<span class="header-title"><span
													class="icomoon-time color-blue"></span><span
													class="label-icon">&nbsp;<%=sdfOra.format(riunione_Data_creazione)%></span></span>
											</div>

											<div class="riunione-item-orari">
												<p class="bold-body">
														<liferay-ui:message key="gestione-riunione-stampa-riunione-ultima-modifica" />:
													</p>
													<c:choose>
													<c:when test="<%=riunione_Data_ultima_modifica !=null %>">
													
													<span class="header-title"><span
														class="icomoon-calendar-date color-blue"></span><span
														class="label-icon">&nbsp;<%=sdfData.format(riunione_Data_ultima_modifica)%></span></span>
													<span class="header-title"><span
														class="icomoon-time color-blue"></span><span
														class="label-icon">&nbsp;<%=sdfOra.format(riunione_Data_ultima_modifica)%></span></span>
													</c:when>
												<c:otherwise>
													
													<span class="header-title"><span
														class="icomoon-calendar-date color-blue"></span><span
														class="label-icon">&nbsp;--</span></span>
													<span class="header-title"><span
														class="icomoon-time color-blue"></span><span
														class="label-icon">&nbsp;--</span></span>
												</c:otherwise>
												</c:choose>
											</div>

										</div>
									</div>
								</div>

							</div>
							</a>
						</c:forEach>
					</c:if>
			</div>
		</div>
		
		<c:if test="<%=lista_res != null && !lista_res.isEmpty()%>">
		<portlet:resourceURL var="resourceURL">
		</portlet:resourceURL>
			<form action="<%=resourceURL%>" method="post"
				name="<portlet:namespace/>name" id="printList" enctype="multipart/form-data"> 
				<input type="hidden" id="param_Ids" name="<portlet:namespace/>param_Ids" value="<%=firstRiunione%>"> 
				<input type="hidden" id="print-detail" name="<portlet:namespace/>detail" > 
				<input type="hidden" id="param_protocollo" name="<portlet:namespace/>param_protocollo" value="<%= param_protocollo %>" >
				<input type="hidden" id="param_da" name="<portlet:namespace/>param_da" value="<%= param_da %>"> 
				<input type="hidden" id="param_a" name="<portlet:namespace/>param_a" value="<%= param_a %>"> 
				<input type="hidden" id="param_stato" name="<portlet:namespace/>param_stato" value="<%= param_stato %>">
				<input type="hidden" id="param_isp" name="<portlet:namespace/>param_isp" value="<%= param_isp %>">  
				<input type="hidden" id="param_chiave" name="<portlet:namespace/>param_chiave" value="<%= param_chiave %>">
				<input type="hidden" id="param_tipo" name="<portlet:namespace/>param_tipo" value="<%= param_tipo %>">
				<input type="hidden" id="param_amministrazione" name="<portlet:namespace/>param_amministrazione" value="<%= param_amministrazione %>"> 
				<input type="hidden" id="param_data" name="<portlet:namespace/>param_data" value="<%= param_data %>"> 

				<div class="ama-row wrapper-button-management">
					<div class="ama-col-sm-6">
						<button class="button button-secondary" 
							 type="button" onclick="submitPrintDetails()">
							<liferay-ui:message key="gestione-riunione-stampa-crea-pdf-dettagliato" />
						</button>
					</div>

					<div class="ama-col-sm-6">
						<button class="button button-primary" id="print" type="button" onclick="submitPrintDefault()">
							<liferay-ui:message key="gestione-riunione-stampa-crea-pdf" />
						</button>
					</div>
				</div>
			</form>
			
		</c:if>
	</div>
</div>

<script type="text/javascript">





function submitFormReport(id){
	$(id).parsley().validate();
	if($(id).parsley().isValid()){
		$(id).submit();
	}
}

	function submitPrint(){
		var countList = "<%= lista_res.size()%>";
		if (countList>1){
			var idList = new Array(<%
						for(int i = 0; i < lista_res.size(); i++) {
							   out.print(lista_res.get(i).getId_riunione());
							  if(i+1 < lista_res.size()) {
								out.print(",");
							  }
							}	
			%>);
			$("#param_Ids").val(idList.toString());

		}
	
		$("#printList").submit();
	}
	
	function submitPrintDefault(){
		$("#print-detail").val("false");
		submitPrint();
	}
	
	function submitPrintDetails(){
		$("#print-detail").val("true");
		submitPrint();
	}



function resetForm(){
	
	$('#parola_chiave').val("");
	$('#parola_chiave2').val("");
	$('#date1').val("");
	$('#date2').val("");

	$('#Deadline').val("");
	$('#amministrazione').val("0");
	$('#amministrazione2').val("0");

	$('#protocollo').val("");
	$('#protocollo2').val("");

	$('#ispettorato').val("0");
	$('#ispettorato2').val("0");

	$('#tipologia').val("0");
	$('#tipologia2').val("0");

	$('#stato').val("0");
		$('#stato2').val("0");

}

function changeTabDate() {
	
	if($('#days').css('display')=='none'){
		$('#StartDate').val(null);
		$('#Deadline').val(null);
		$('#days').css('display', 'block');
		$('#day').css('display', 'none');
	}
	else if ($('#days').css('display')=='block'){
		$('#data').val(null);
		$('#days').css('display', 'none');
		$('#day').css('display', 'block');
		   
	} 
}
function setFieldsPeriod(){
	$('#parola_chiave').val($('#parola_chiave2').val());
	$('#amministrazione').val($('#amministrazione2').val());
	$('#protocollo').val($('#protocollo2').val());
	$('#ispettorato').val($('#ispettorato2').val());
	$('#tipologia').val($('#tipologia2').val());
	$('#stato').val($('#stato2').val());	

}
function setFieldsDay(){
	$('#parola_chiave2').val($('#parola_chiave').val());
	$('#amministrazione2').val($('#amministrazione').val());
	$('#protocollo2').val($('#protocollo').val());
	$('#ispettorato2').val($('#ispettorato').val());
	$('#tipologia2').val($('#tipologia').val());
	$('#stato2').val($('#stato').val());	

}

</script>
