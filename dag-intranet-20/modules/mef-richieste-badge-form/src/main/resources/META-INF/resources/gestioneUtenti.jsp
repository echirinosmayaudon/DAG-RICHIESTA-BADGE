<%@ include file="/init.jsp" %>
<%@page import="mef.richieste.badge.bean.Richiedente"%>
<%@page import="mef.richieste.badge.bean.ModuloRichiedente"%>
<%@page import="java.io.File"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="servizio.richieste.badge.mef.model.RichiestaBadge"%>
<%@page import="servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="servizio.richieste.badge.mef.service.StatoRichiestaLocalServiceUtil"%>
<%@page import="servizio.richieste.badge.mef.service.OggettoRichiestaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.intranet.mef.job.siap.model.OrganizationChart"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="servizio.richieste.badge.mef.model.StatoRichiesta"%>
<%@ page import="servizio.richieste.badge.mef.service.SediEsterneLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="servizio.richieste.badge.mef.model.OggettoRichiesta" %>
<%@ page import="servizio.richieste.badge.mef.model.SediEsterne" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<portlet:actionURL var="cercaUtentiDaAbilitareUrl" name="cercaUtentiDaAbilitare"/>
<portlet:actionURL var="cercaUtentiAbilitatiUrl" name="cercaUtentiAbilitati"/>

<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"/>
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
<portlet:actionURL var="vaiAGestioneUtenti" name="vaiAGestioneUtenti"/>
<portlet:actionURL var="vaiAProrogaBadge" name="vaiAProrogaBadge"/> 

<form enctype="multipart/form-data" id="<portlet:namespace/>refreshPage" action="<%=vaiAGestioneUtenti%>" method="post"></form>          
        
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<%
boolean dirigente = (boolean)request.getAttribute("roleDirigente");
boolean abilitatoBadge = (boolean)request.getAttribute("roleAbilitato");
boolean delegatoBadge = (boolean)request.getAttribute("roleDelegato");
boolean gestoreExt = (boolean)request.getAttribute("roleGestoreExt");
boolean gestoreInt = (boolean)request.getAttribute("roleGestoreInt");

String param_daAbilitareClass ="collapse in";
String param_abilitatiClass="collapse";
String param_abilitatiClassActive="";
String param_daAbilitareClassActive="active";
if (request.getAttribute("jsonArrayUtentiAbilitati")!=null){	
	param_daAbilitareClass = "collapse";
	param_abilitatiClass="collapse in";
	param_abilitatiClassActive="active";
	param_daAbilitareClassActive="";
} 

Integer dimensioneLista = 0;
if(request.getAttribute("totalSize")!=null)
    dimensioneLista = (Integer)request.getAttribute("totalSize");

%>

	<div class="trasporti-header">
	    <div class="ama-container-fluid">
	        <div class="ama-row">
	            <div class="ama-col-xs-12">
	                <div class="title-wrapper">
	                     <h2 class="title"><%=gestioneUtentiTitle%></h2>
	                     <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
		                        <form enctype="multipart/form-data" action="<%=vaiAInserimento%>" method="post">
		                            <button href="<%=vaiAInserimento%>" type="button" class="button-xs button button-primary mr-10-xs" onclick="this.form.submit()">
		                            	<liferay-ui:message key="badge-gestione-utenti-bnt-nuova-richiesta"/>
		                                <span class="icomoon-plus icon-beni"></span>
		                            </button>
		                        </form>
		                        <a href="<%=vaiARicerca%>" title="<liferay-ui:message key="badge-gestione-utenti-ricerca-tooltip"/>" class="icon icomoon-search-richiesta"></a>
	                        	<a href="<%=vaiAProrogaBadge%>" title="Proroga Badge" class="icon icomoon-time"></a>
	                        </div>
		               	 <p class="subtitle dot-point dot-200"><%=gestioneUtentiSubtitle%></p>
		          	</div>
	            </div>
	        </div>
	    </div>
	</div>

     <div class="ama-container-fluid">
         <div class="ama-row mt-30-xs">
             <div class="ama-col-xs-12">
                 <div class="tab-filtri filtro-categoria collapse-group mobile-trasporti" id="tabs-profile">
                     <div class="filtro-tabs-wrapper mr-0-xs mt-0-xs ml-0-xs">
                         <a href="" title="<liferay-ui:message key="badge-gestione-utenti-tl-cerca-da-abilitare"/>" class="tab-title <%=param_daAbilitareClassActive%>" data-toggle="collapse" data-target="#utenti-abilitare" data-parent="#tabs-beni"><liferay-ui:message key="badge-gestione-utenti-cerca-utenti-da-abilitare"/></a>
                         <a href="" title="<liferay-ui:message key="badge-gestione-utenti-tl-cerca-abilitati"/>" class="tab-title <%=param_abilitatiClassActive%>" data-toggle="collapse" data-target="#utenti-abilitati" data-parent="#tabs-beni"><liferay-ui:message key="badge-gestione-utenti-cerca-utenti-abilitati"/></a>
                     </div>
                     <div id="utenti-abilitare" class="<%=param_daAbilitareClass%>">
                         <div class="wrapper-tab-beni-consumo ">
                             <div class="box-gray no-margin">
                                 <div class="box-white box-gray-mobile">
                                     <form enctype="multipart/form-data" data-parsley-validate="true" id="<portlet:namespace/>cercaUtentiDaAbilitareForm" action="<%=cercaUtentiDaAbilitareUrl%>" method="post">
                                         <div class="ama-row">
											<div class="col-xs-12 pb-10-xs">
											<p class="copy-text blue-color"><liferay-ui:message key="badge-gestione-utenti-campi-obbligatori"/></p>
											</div>
										 </div>
                                         <div class="ama-row">
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="<portlet:namespace/>cognomeUtenteDaAbilitare" class="label-form mt-10-sm"><liferay-ui:message key="badge-gestione-utenti-cognome-richiedente"/>*</label>
                                                 <input onkeydown = "if (event.keyCode == 13) submitForm()" id="<portlet:namespace/>cognomeUtenteDaAbilitare" class="input-custom-light" 
                                                 	placeholder="<liferay-ui:message key="badge-gestione-utenti-ph-cognome"/>" name="<portlet:namespace/>cognomeUtenteDaAbilitare">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="argument2" class="label-form mt-10-sm "><liferay-ui:message key="badge-gestione-utenti-nome-richiedente"/></label>
                                                 <input onkeydown = "if (event.keyCode == 13) submitForm()" id="argument2" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="badge-gestione-utenti-ph-nome"/>" name="<portlet:namespace/>nomeUtenteDaAbilitare">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="argument4" class="label-form mt-10-sm"><liferay-ui:message key="badge-gestione-utenti-cf"/></label>
                                                 <input onkeydown = "if (event.keyCode == 13) submitForm()" id="argument4" class="input-custom-light data-parsley-validated" 
                                                 	data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                 	placeholder="<liferay-ui:message key="badge-gestione-utenti-ph-cf"/>" name="<portlet:namespace/>codFiscaleUtenteDaAbilitare">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12 ">
                                                 <label for="<portlet:namespace/>idUfficioUtenteDaAbilitare" class="label-form mt-10-sm"><liferay-ui:message key="badge-gestione-utenti-ufficio"/>*</label>
                                                 <select onkeydown = "if (event.keyCode == 13) submitForm()" id="<portlet:namespace/>idUfficioUtenteDaAbilitare" class="option-select-notice" name="<portlet:namespace/>idUfficioUtenteDaAbilitare">
                                                     <option value="" hidden><liferay-ui:message key="badge-gestione-utenti-scegli-elenco"/></option>
                                                     <c:forEach items="${uffici}" var="ufficio">
                                                       <option value="${ufficio.getIdOrgChart()}">${ufficio.getName().toUpperCase()}</option>
                                                     </c:forEach>
                                                 </select>
                                             </div>
                                         </div>
                                         <input type="text" style="display:none" id="<portlet:namespace/>inputDaAbilitare" name="<portlet:namespace/>inputDaAbilitare" class="data-parsley-validated"
                                          		data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="badge-gestione-utenti-error-ufficio-da-abilitare"/>"/>
                                     </form>	
                                 </div>
                             </div>
                         </div>      
                     </div>
                     
                     <div id="utenti-abilitati" class="<%=param_abilitatiClass%>">
                         <div class="wrapper-tab-beni-consumo ">
                             <div class="box-gray no-margin">
                                 <div class="box-white box-gray-mobile">
                                     <form enctype="multipart/form-data" data-parsley-validate="true" id="<portlet:namespace/>cercaUtentiAbilitatiForm" action="<%=cercaUtentiAbilitatiUrl%>" method="post">
                                         <div class="ama-row">
											<div class="col-xs-12 pb-10-xs">
											<p class="copy-text blue-color"><liferay-ui:message key="badge-gestione-utenti-campi-obbligatori"/></p>
										    </div>
										 </div>
                                         <div class="ama-row">
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="<portlet:namespace/>cognomeUtenteAbilitato" class="label-form mt-10-sm"><liferay-ui:message key="badge-gestione-utenti-cognome"/>*</label>
                                                 <input onkeydown = "if (event.keyCode == 13) submitForm()" id="<portlet:namespace/>cognomeUtenteAbilitato" class="input-custom-light" placeholder="<liferay-ui:message key="badge-gestione-utenti-ph-cognome"/>" name="<portlet:namespace/>cognomeUtenteAbilitato">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="<portlet:namespace/>nomeUtenteAbilitato"" class="label-form mt-10-sm"><liferay-ui:message key="badge-gestione-utenti-nome"/></label>
                                                 <input onkeydown = "if (event.keyCode == 13) submitForm()" id="<portlet:namespace/>nomeUtenteAbilitato" class="input-custom-light" placeholder="<liferay-ui:message key="badge-gestione-utenti-ph-nome"/>" name="<portlet:namespace/>nomeUtenteAbilitato">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="<portlet:namespace/>idUfficioUtenteAbilitato" class="label-form mt-10-sm"><liferay-ui:message key="badge-gestione-utenti-ufficio"/>*</label>
                                                 <select onkeydown = "if (event.keyCode == 13) submitForm()" id="<portlet:namespace/>idUfficioUtenteAbilitato"  class="option-select-notice" name="<portlet:namespace/>idUfficioUtenteAbilitato">
                                                     <option value="" hidden><liferay-ui:message key="badge-gestione-utenti-scegli-elenco"/></option>
                                                     <c:forEach items="${uffici}" var="ufficio">
                                                       <option value="${ufficio.getIdOrgChart()}">${ufficio.getName().toUpperCase()}</option>
                                                     </c:forEach>
                                                 </select>
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label  class="label-form mt-10-sm"><liferay-ui:message key="badge-gestione-utenti-DELEGA"/></label>
                                                 <div class="checkbox-blue mr-15-xs">
                                                     <div class="squaredOne">
                                                         <input class="checkboxyes checkbox-abilitato" type="checkbox" value="Yes" id="delegaSI" name="<portlet:namespace/>check">
                                                         <label for="delegaSI"></label>
                                                     </div>
                                                     <p class="text-check"><liferay-ui:message key="badge-gestione-utenti-SI"/></p>
                                                 </div>
                                                 <div class="checkbox-blue">
                                                     <div class="squaredOne">
                                                         <input  class="checkboxno checkbox-abilitato" type="checkbox" value="No" id="delegaNO" name="<portlet:namespace/>check">
                                                         <label for="delegaNO"></label>
                                                     </div>
                                                     <p class="text-check"><liferay-ui:message key="badge-gestione-utenti-NO"/></p>
                                                 </div>
                                             </div>
                                         </div>
                                         <input id="checkBoxArrayInputId" type="hidden" value="" name="<portlet:namespace/>checkBoxArray" >
	                                     <input type="text" style="display:none" id="<portlet:namespace/>inputAbilitati" name="<portlet:namespace/>inputAbilitati"
	                                         class="data-parsley-validated" data-parsley-required="true" data-parsley-required-message="Almeno uno dei due campi richiesti deve essere valorizzato"/>
                                     </form>
                                 </div>
                             </div>
                         </div>
                          
                         
                     </div>
                 </div>
             </div>
         </div>
         <div class="ama-row">
             <div class="ama-col-md-6 text-center mb-50-sm mt-50-sm">
                 <button class="button button-secondary" onclick="resetForm()"><liferay-ui:message key="badge-gestione-utenti-annulla"/></button>
             </div>
             <div class="ama-col-md-6 text-center mb-50-sm mt-50-sm">
                 <button class="button button-primary" onclick="submitForm(event)" id="<portlet:namespace/>submitForm"><liferay-ui:message key="badge-gestione-utenti-applica"/></button>
             </div>
         </div>
	
	<% 	String elencoRisultati = null;                                    
   		if(request.getAttribute("jsonArrayUtentiDaAbilitare")!=null) 
   			elencoRisultati = (String)request.getAttribute("jsonArrayUtentiDaAbilitare");
   		if(request.getAttribute("jsonArrayUtentiAbilitati")!=null) 
   			elencoRisultati = (String)request.getAttribute("jsonArrayUtentiAbilitati");
   		JSONArray arrayRes = JSONFactoryUtil.createJSONArray(elencoRisultati);
	%>
	
	 <c:if test="${filtriRicercaRichieste!=null}">
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay-ui:message key="badge-gestione-utenti-risultati-ricerca"/></h2>
                 </div>
             </div>
         </div>         
         <div class="ama-row">
             <div class="ama-col-xs-12">
                 <div class="labels-container mobile-click-open mt-0-xs mb-30-xs form-inline-wrap">
                     <span class="labels-container-title"><liferay-ui:message key="badge-gestione-utenti-filtrato-per"/>:</span>
                     <c:forEach items="${filtriRicercaRichieste}" var="filtro">
                         <div class="filter-label-item mt-10-xs">
                               <h2>${filtro.toUpperCase()}</h2>
                         </div>
                     </c:forEach>
                     <div class="filter-label-item btn-filter-reset">
                         <h2><liferay-ui:message key="badge-gestione-utenti-reset"/></h2><span class="icomoon-close-white"></span>
                     </div>
                     <span class="span-person"><p class="bold-span"><%=dimensioneLista%></p> 
                     <liferay-ui:message key="badge-gestione-utenti-persone-trovate"/></span>
                 </div>
             </div>
         </div>
   </c:if>
   <div class="ama-row">
	     <c:if test="<%=elencoRisultati!=null && arrayRes.length()<1%>">
	      	<p class="copy-text wysiwyg-editor"><liferay-ui:message key="badge-gestione-utenti-nessuna-persona-trovata"/></p>
	     </c:if>
   		 <% for(int i=0;i<arrayRes.length();i++) {
              JSONObject jsonRichiesta = JSONFactoryUtil.createJSONObject(arrayRes.get(i).toString());
              String id_utente = jsonRichiesta.get("id").toString();
         %>
         <c:if test="${jsonArrayUtentiDaAbilitare!=null}">
             <div class="ama-col-lg-3 ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                 <div class="wrappper-beni-consumo-component mb-30-xs">
                     <a href="#" title="" class="box-white text-center">
                         <p class="name mb-10-xs dot-point dot-70 dot-mobile"><%=jsonRichiesta.get("nome").toString().toUpperCase()%> <%=jsonRichiesta.get("cognome").toString().toUpperCase()%></p>
                         <p class="mb-20-xs"><%=jsonRichiesta.get("ufficio").toString().toUpperCase()%></p>
                         <button id="abilita<%=i%>" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message key="badge-gestione-utenti-abilita"/></button>
                         <button disabled id="abilitato<%=i%>" class="button button-primary active hide"><liferay-ui:message key="badge-gestione-utenti-abilitato"/></button>
                     </a>
                 </div>
             </div>
         </c:if>
         <c:if test="${jsonArrayUtentiAbilitati!=null}">
             <div class="ama-col-lg-3 ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                 <div class="wrappper-beni-consumo-component mb-30-xs">
                     <a href="#" title="" class="box-white text-center">
                        <p class="name mb-10-xs dot-point dot-70 dot-mobile"><%=jsonRichiesta.get("nome").toString().toUpperCase()%> <%=jsonRichiesta.get("cognome").toString().toUpperCase()%></p>
                         <p class="mb-20-xs"><%=jsonRichiesta.get("ufficio").toString().toUpperCase()%></p>
                         <c:if test="<%=jsonRichiesta.get("delega").toString().equals("true")%>">
                         	<button id="revoca<%=i%>" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message key="badge-gestione-utenti-revoca-delega"/></button>
                         	<button disabled id="revocata<%=i%>" class="button button-primary active hide"><liferay-ui:message key="badge-gestione-utenti-delega-revocata"/></button>
                         </c:if>
                         <c:if test="<%=jsonRichiesta.get("delega").toString().equals("false")%>">
                         	<button id="delega<%=i%>" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message key="badge-gestione-utenti-delega"/></button>
                         	<button disabled id="delegato<%=i%>" class="button button-primary active hide"><liferay-ui:message key="badge-gestione-utenti-delegato"/></button>
                         </c:if>
                       	 <button id="elimina<%=i%>" class="button button-secondary mt-10-xs" data-toggle="modal" data-target="#modal-user" onclick="openModal(<%=i%>)"><liferay-ui:message key="badge-gestione-utenti-elimina"/></button>
                         <button disabled id="eliminato<%=i%>" class="button button-primary active hide"><liferay-ui:message key="badge-gestione-utenti-eliminato"/></button>
                     </a>
                 </div>
             </div>
             <div id="modal-user<%=i%>" class="modal modal-custom fade modal-icon-page" role="dialog">
                 <div class="modal-dialog">
                     <div class="modal-content">
                         <div class="modal-body">
                             <div class="modal-title-box">
                                 <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>
                                 <div class="title-modal">
                                     <h2 class="title"><liferay-ui:message key="badge-gestione-utenti-messaggio-eliminazione-utente"/>
                                     </h2>
                                 </div>
                             </div>
                             <h2 class="text"><liferay-ui.message key="badge-gestione-utenti-messaggio-eliminazione"/></h2>
                             <div class="ama-row mb-50-xs buttons-bottom">
                                 <div class="ama-col-xs-12 ama-col-sm-6">
                                     <button class="button button-secondary" data-dismiss="modal"><liferay-ui:message key="badge-gestione-utenti-annulla"/></button>
                                 </div>
                                 <div class="ama-col-xs-12 ama-col-sm-6">
                                     <button id="eliminautente" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message key="badge-gestione-utenti-elimina-utente"/></button>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </c:if> 
         <%}%>
   
    </div>
    
    
    	 <% 
						Integer pageCurrent = (Integer)request.getAttribute("page");
						Integer pageNumber = (Integer)request.getAttribute("numPage");
						String back_btn = pageCurrent==1 ? "disabled" : "";
						String forward_btn = pageCurrent.equals(pageNumber) ? "disabled" : "";
				

					 %>
				 	<c:if test="<%= pageNumber>1 %>">

				      <portlet:actionURL var="paginaUtentiURL" name="paginaUtenti"/></portletactionURL>

                    <form style="display:none" id="formPaginaUtenti" action="<%=paginaUtentiURL%>" method="POST" enctype="multipart/form-data">
						<input type="hidden" name="<portlet:namespace/>numpage" id="numpageUtenti">
						<input type="hidden" name="<portlet:namespace/>size" value="<%=dimensioneLista%>" id="sizeRichiesteUtenti">
					</form>
				   
				   <div class="ama-col-xs-12 text-align-center">
                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
					
									<div class="btn-back-arrow <%= back_btn %>">
                                        <a href="#" onclick="showPagina(event, <%=pageCurrent-1%>,'Utenti')"><em class="icomoon-arrow"></em></a>
                                        </div>
                                        <ul class="pagination-numbers">
										
										<c:set var="currentPage" value="<%= pageCurrent %>"/>
										<c:forEach var="tag" begin="1" end="<%=pageNumber%>" >
											<c:choose>
											<c:when test="${tag==currentPage}">
												<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event, ${tag},'Utenti')" >${tag}</a></li>
											</c:when>
											<c:otherwise>
												<li id="pageClick${tag}"><a href="#" onclick="showPagina(event, ${tag},'Utenti')">${tag}</a></li>
											</c:otherwise>
											</c:choose>
										</c:forEach>
                                        </ul>
                                        <div class="btn-forward-arrow <%= forward_btn %>">
                                            <a href="#" onclick="showPagina(event, <%=pageCurrent+1%>,'Utenti')">
                                                <em class="icomoon-arrow"></em>
                                            </a>
                                        </div>
                                    </div>

                      </div>
				</c:if>
    
    
    
    
    
    
    
    
</div>

<script>


function showPagina(event, id, tagId) {
	event.preventDefault();
	$("#numpage" + tagId).val(id);
	$("#formPagina" + tagId).submit();
}


$(".checkbox-abilitato").on('click',function(){
  	//decidere il focus
  	if ($( "#<portlet:namespace/>cognomeUtenteAbilitato" ).val()=="" &&
        	$( "#<portlet:namespace/>idUfficioUtenteAbilitato" ).val()=="")
	    $( "#<portlet:namespace/>cognomeUtenteAbilitato" ).focus();
    else
       	$( "#<portlet:namespace/>submitForm" ).focus();
 
});


	 
$('.icomoon-close-white').on('click',function(){
	$('#<portlet:namespace/>refreshPage').submit();
});

var checkBoxArray = [];

function submitForm(event) {
	if ($('#utenti-abilitare').hasClass("collapse in")) {
		$('#<portlet:namespace/>inputDaAbilitare').val("");
		if($('#<portlet:namespace/>cognomeUtenteDaAbilitare').val()!="" || $('#<portlet:namespace/>idUfficioUtenteDaAbilitare').val()!="")
			$('#<portlet:namespace/>inputDaAbilitare').val("almeno un campo inserito");
		$('#<portlet:namespace/>cercaUtentiDaAbilitareForm').parsley().validate();
		if($('#<portlet:namespace/>cercaUtentiDaAbilitareForm').parsley().isValid())
			$('#<portlet:namespace/>cercaUtentiDaAbilitareForm').submit();	
	} else {
		checkBoxArray = [];
		if ($('.checkboxyes:checked').val()=="Yes") 
			checkBoxArray.push($('.checkboxyes:checked').val());
        if ($('.checkboxno:checked').val()=="No") 
        	checkBoxArray.push($('.checkboxno:checked').val());
        $('#checkBoxArrayInputId').val(checkBoxArray);
        $('#<portlet:namespace/>inputAbilitati').val("");
		if($('#<portlet:namespace/>cognomeUtenteAbilitato').val()!="" || $('#<portlet:namespace/>idUfficioUtenteAbilitato').val()!="")
			$('#<portlet:namespace/>inputAbilitati').val("almeno un campo inserito");
		$('#<portlet:namespace/>cercaUtentiAbilitatiForm').parsley().validate();
		if($('#<portlet:namespace/>cercaUtentiAbilitatiForm').parsley().isValid())
			$('#<portlet:namespace/>cercaUtentiAbilitatiForm').submit();
	}
}

function resetForm(){
	 document.getElementById("<portlet:namespace/>cercaUtentiDaAbilitareForm").reset();
	 document.getElementById("<portlet:namespace/>cercaUtentiAbilitatiForm").reset();
}

function callServeResource(event,id,index,idutente) {
	event.preventDefault();
	AUI().use('aui-io-request', function(A){           	 
		A.io.request('<%=resourceURL.toString()%>', {
	   		method: 'post',
	        data: {
	        	<portlet:namespace />idutente: idutente,
	        	<portlet:namespace />btnAction: id
	        },
	        on: {success: function() {
		        	if(id=="abilita"+index) {
		        		$('#abilita'+index).addClass("hide");
		        		$('#abilitato'+index).removeClass("hide");
		        	}
		        	if(id=="revoca"+index) {
		        		$('#revoca'+index).addClass("hide");
		        		$('#revocata'+index).removeClass("hide");
		        	}
		        	if(id=="delega"+index) {
		        		$('#delega'+index).addClass("hide");
		        		$('#delegato'+index).removeClass("hide");
		        	}
		        	if(id=="eliminautente") {
		        		$('#elimina'+index).addClass("hide");
		        		$('#eliminato'+index).removeClass("hide");
		        		$('#modal-user'+index).modal('hide');
		        	}
	        	}
           }
	    });
	});
}

function openModal(index) {
	event.preventDefault();
	$('#modal-user'+index).modal('show');
}
</script>