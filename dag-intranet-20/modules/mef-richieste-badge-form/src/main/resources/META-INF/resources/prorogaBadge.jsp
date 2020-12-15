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
<%@page import="java.util.List"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<portlet:actionURL var="cercaUtentiDaAbilitareUrl" name="cercaUtentiDaAbilitare"/>
<portlet:actionURL var="cercaUtentiAbilitatiUrl" name="cercaUtentiAbilitati"/>

<portlet:actionURL var="cercaRichiesteInScadenza" name="cercaRichiesteInScadenza"/> 
<portlet:actionURL var="vaiARiepilogoProroga" name="vaiARiepilogoProroga"/> 

<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"/>
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
<portlet:actionURL var="vaiAGestioneUtenti" name="vaiAGestioneUtenti"/>
<portlet:actionURL var="vaiAProrogaBadge" name="vaiAProrogaBadge"/> 

<%
	String elenco_badge_scadenza = "";
	if(request.getAttribute("jsonScadenzaSelezionata")!=null) 
		elenco_badge_scadenza = (String)request.getAttribute("jsonScadenzaSelezionata");
	JSONArray jsonarray_badge_scadenza = null;
	if(elenco_badge_scadenza!=null && !"".equals(elenco_badge_scadenza))
		jsonarray_badge_scadenza = JSONFactoryUtil.createJSONArray(elenco_badge_scadenza);
	List<String> listIdRichiesteSelezionate = (List<String>)request.getAttribute("listIdRichiesteSelezionate");
	int listIdRichiesteSelezionateSize = 0;
	if(listIdRichiesteSelezionate!=null && !listIdRichiesteSelezionate.isEmpty()) {
		listIdRichiesteSelezionateSize = listIdRichiesteSelezionate.size();
	}
%>

<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                     <h2 class="title"><%=servizioProrogaTitle%></h2>
                     <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
                          <form enctype="multipart/form-data" action="<%=vaiAInserimento%>" method="post">
                              <button href="<%=vaiAInserimento%>" type="button" class="button-xs button button-primary mr-10-xs" onclick="this.form.submit()">
                                   <liferay-ui:message key="badge-gestione-utenti-bnt-nuova-richiesta"/>
                                 <span class="icomoon-plus icon-beni"></span>
                              </button>
                          </form>
                          <c:if test="<%=dirigente%>">
                              <a href="<%=vaiAGestioneUtenti%>" title="Gestione Utenti"  class="icon icomoon-profile"></a>     
                          </c:if>                
                        <a href="<%=vaiARicerca%>" title="<liferay-ui:message key="badge-gestione-utenti-ricerca-tooltip"/>" class="icon icomoon-search-richiesta"></a>
                    </div>
	               	  <p class="subtitle dot-point dot-200"><%=servizioProrogaSubtitle%></p>
	          	</div>
            </div>
        </div>
    </div>
</div>

<div class="ama-container-fluid">
	<div class="ama-row">
        <div class="ama-col-xs-12">
            <div class="tab-ricerca-badge">
                <h3 class="tab-item text-uppercase"><liferay-ui:message key="badge-proroga-cerca-badge-scadenza"/></h3>
            </div>
        </div>
    </div>
	<div class="proroga-badge-main">
        <div class="proroga-badge-wrapper">
            <form class="form-proroga-badge" id="<portlet:namespace/>cercaRichiesteInScadenzaFrm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=cercaRichiesteInScadenza%>">
                <div class="ama-row">
                    <div class="ama-col-xs-12 pb-20-xs">
                        <label class="label-form"><liferay-ui:message key="badge-proroga-label-ricerca-per"/>:</label>
                    </div>
                </div>
                <div class="ama-row">
                    <div class="search-tab-proroga">
                        <div class="ama-col-md-4 ama-col-xs-12 search-item-proroga">
                            <div class="search-pb-date">
                                <p class="text"><liferay-ui:message key="badge-proroga-data-inizio"/>*</p>
                                <c:if test="${dataInizioSelezionata==null}">
	                                <input id="<portlet:namespace/>dataInizio"
	                                	name="<portlet:namespace/>dataInizio" 
	                                	type="text" 
	                                	class="datepicker-custom input-custom-light data-parsley-validated" 
	                                	placeholder="<liferay-ui:message key="badge-proroga-placeholder-data"/>"
	                                	data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
						                data-parsley-required="true" 
						                data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						                data-parsley-submission-date-check="#<portlet:namespace/>dataInizio"/>
					            </c:if>
					            <c:if test="${dataInizioSelezionata!=null}">
						            <input id="<portlet:namespace/>dataInizio"
	                                	name="<portlet:namespace/>dataInizio" 
	                                	type="text" 
	                                	class="datepicker-custom input-custom-light data-parsley-validated" 
	                                	placeholder="<liferay-ui:message key="badge-proroga-placeholder-data"/>"
	                                	value="${dataInizioSelezionata}"
	                                	data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
						                data-parsley-required="true" 
						                data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						                data-parsley-submission-date-check="#<portlet:namespace/>dataInizio"/>
					            </c:if>
                            </div>
                        </div>
                        <div class="ama-col-md-4 ama-col-xs-12 search-item-proroga">
                            <div class="search-pb-date">
                                <p class="text"><liferay-ui:message key="badge-proroga-data-fine"/>*</p>
                                <c:if test="${dataFineSelezionata==null}">
	                                <input id="dataFineProrogaBadge"
	                                	name="<portlet:namespace/>dataFine" 
	                                	type="text" 
	                                	class="datepicker-custom input-custom-light data-parsley-validated" 
	                                	placeholder="<liferay-ui:message key="badge-proroga-placeholder-data"/>"
	                                	data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
						                data-parsley-required="true" 
						                data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						                data-parsley-compare-data-fine-to-inizio="#<portlet:namespace/>dataInizio"/>
						        </c:if>
						        <c:if test="${dataFineSelezionata!=null}">
						        	<input id="dataFineProrogaBadge"
	                                	name="<portlet:namespace/>dataFine" 
	                                	type="text" 
	                                	class="datepicker-custom input-custom-light data-parsley-validated" 
	                                	placeholder="<liferay-ui:message key="badge-proroga-placeholder-data"/>"
	                                	value="${dataFineSelezionata}"
	                                	data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
						                data-parsley-required="true" 
						                data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						                data-parsley-compare-data-fine-to-inizio="#<portlet:namespace/>dataInizio"/>
						        </c:if>
                            </div>
                        </div>
                        <div class="ama-col-md-4 ama-col-xs-12 text-center search-item-proroga">
                            <button class="button button-primary cta-proroga-badge" id="<portlet:namespace/>cercaRichiesteInScadenzaBtn"><liferay-ui:message key="badge-proroga-btn-applica"/></button>
                        </div>
                    </div>
                </div>
                <input type="hidden" id="<portlet:namespace/>paramDataInizio" name="<portlet:namespace/>paramDataInizio">
                <input type="hidden" id="<portlet:namespace/>paramDataFine" name="<portlet:namespace/>paramDataFine">
            </form>
        </div>
        
    <c:if test="<%=!"".equals(elenco_badge_scadenza)%>">
	    <div class="proroga-badge">
	        <div class="pb-title-section">
	            <p class="pb-title-text"><liferay-ui:message key="badge-proroga-risultati-da"/> ${dataInizioSelezionata} <liferay-ui:message key="badge-proroga-risultati-a"/> ${dataFineSelezionata}</p>
	        </div>
	    </div>
    </c:if>
       
    <c:if test="<%=jsonarray_badge_scadenza!=null && jsonarray_badge_scadenza.length()<1%>">
    	<p class="copy-text wysiwyg-editor"><liferay-ui:message key="badge-proroga-nessun-badge-trovato"/>.</p>
    </c:if>   
        
    <c:if test="<%=jsonarray_badge_scadenza!=null && jsonarray_badge_scadenza.length()>0%>">   
    <div>
		<p class="copy-text blue-color"><liferay-ui:message key="badge-proroga-selezionare-almeno-un-badge"/></p>
    <form id="<portlet:namespace/>riepilogoProrogaFrm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=vaiARiepilogoProroga%>">
        <div class="pd-table-main table-responsive">
            <table class="table pd-table">
                <thead>
                    <tr>
                        <th><input id="checkedAll" type="checkbox"/> </th>
                        <th><liferay-ui:message key="badge-proroga-table-numero-badge"/></th>
                        <th><liferay-ui:message key="badge-proroga-table-assegnatario-badge"/></th>
                        <th><liferay-ui:message key="badge-proroga-table-cf-badge"/></th>
                        <th><liferay-ui:message key="badge-proroga-table-scadenza-badge"/></th>
                        <th><liferay-ui:message key="badge-proroga-table-tipo-utente-badge"/></th>
                    </tr>
                </thead>
                <tbody>
                
                	 <% for(int i=0;i<jsonarray_badge_scadenza.length();i++) {
			              JSONObject jsonobject_badge_scadenza = JSONFactoryUtil.createJSONObject(jsonarray_badge_scadenza.get(i).toString());
         			 %>
	    				<tr>
	                        <td><input id="<%=jsonobject_badge_scadenza.getString("id_pk")%>" class="check-item" name="checkboxItemRichiesta" value="<%=jsonobject_badge_scadenza.getString("id_pk")%>" type="checkbox"/>
	                        </td>
	                        <td><%=jsonobject_badge_scadenza.getString("num_badge")%></td>
	                        <td><%=jsonobject_badge_scadenza.getString("nome_int")%> <%=jsonobject_badge_scadenza.getString("cognome_int")%></td>
	                        <td><%=jsonobject_badge_scadenza.getString("cf_int")%></td>
	                        <td><%=jsonobject_badge_scadenza.getString("data_scadenza")%></td>
	                        <td><%=jsonobject_badge_scadenza.getString("tipologia_utente")%> 
	                        	<c:if test="<%="Esterno".equalsIgnoreCase(jsonobject_badge_scadenza.getString("tipologia_utente"))%>">
	                        	<span class="toolTip generic-tooltip" data-tip="tip-<%=jsonobject_badge_scadenza.getString("id_pk")%>"><span class="info-icon icomoon-info"></span></span>
			                            <div id="tip-<%=jsonobject_badge_scadenza.getString("id_pk")%>" class="tip-main hidden">
			                                <div class="tip-content">
			                                    <label class="tip-label"><liferay-ui:message key="badge-proroga-tooltip-societa"/></label>
			                                    <span class="tip-text"><%=jsonobject_badge_scadenza.getString("societa")%></span>
			                                </div>
			                                <div class="tip-content">
			                                    <label class="tip-label"><liferay-ui:message key="badge-proroga-tooltip-referente-societa-sogei"/></label>
			                                    <span class="tip-text"><%=jsonobject_badge_scadenza.getString("ref_societa")%></span>
			                                </div>
			                                <div class="tip-content">
			                                    <label class="tip-label"><liferay-ui:message key="badge-proroga-tooltip-sedi"/></label>
			                                    <span class="tip-text"><%=jsonobject_badge_scadenza.getString("sedi")%></span>
			                                </div>
			                            </div>
	                        	</c:if>
	                        </td>
                    	</tr>
	    			<%}%>
                    
                </tbody>
            </table>
        </div>
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div id="<portlet:namespace/>divWrapperTagAModal" class="submit-search-badge mt-30-xs mb-30-xs text-center" style="display:none">
                    <a id="<portlet:namespace/>continuaBtn" data-toggle="modal" data-target="#modal-proroga-badge" href="" title="<liferay-ui:message key="badge-proroga-btn-continua-title"/>" class="button button-primary"><liferay-ui:message key="badge-proroga-btn-continua-label"/></a>
                </div>
            </div>
        </div>
        <input type="hidden" id="<portlet:namespace/>nuovaDataScadenza" name="<portlet:namespace/>nuovaDataScadenza">
        <input type="hidden" id="<portlet:namespace/>jsonScadenzaSelezionata" name="<portlet:namespace/>jsonScadenzaSelezionata">
        <input type="hidden" id="<portlet:namespace/>dataInizioSelezionata" name="<portlet:namespace/>dataInizioSelezionata" value="${dataInizioSelezionata}">
        <input type="hidden" id="<portlet:namespace/>dataFineSelezionata" name="<portlet:namespace/>dataFineSelezionata" value="${dataFineSelezionata}">
    </form>
    </div>
    </c:if>
        
        
        <div id="modal-proroga-badge" class="modal modal-custom fade in" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="modal-title-box">
                        <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>
                        <div class="title-modal">
                            <h2 class="title"><liferay-ui:message key="badge-proroga-modal-title"/></h2>
                        </div>
                    </div>
                    <div class="modal-submit-badge" data-parsley-validate="true">
                    <form id="deadlineModal">
                        <div class="ama-row">
                            <div class="ama-col-xs-12 text-center">
                            <c:if test="${nuovaDataScadenzaModal==null}">
                                <div class="content-proroga-modal">
                                    <p class="text"><liferay-ui:message key="badge-proroga-modal-nuova-data-scadenza"/>*</p>
                                    <input id="<portlet:namespace/>dataProrogaModale"
                                    type="text" 
                                    class="datepicker-custom input-custom-light data-parsley-validated" 
                                    name="date" 
                                    placeholder="<liferay-ui:message key="badge-proroga-placeholder-data"/>"
                                    data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
									data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
					                data-parsley-required="true" 
					                data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					                data-parsley-new-deadline-check="#<portlet:namespace/>dataProrogaModale"/>
					                
                                </div>
                            </c:if>
                            <c:if test="${nuovaDataScadenzaModal!=null}">
                                <div class="content-proroga-modal">
                                    <p class="text"><liferay-ui:message key="badge-proroga-modal-nuova-data-scadenza"/>*</p>
                                    <input id="<portlet:namespace/>dataProrogaModale"
                                    type="text" 
                                    class="datepicker-custom input-custom-light data-parsley-validated" 
                                    name="date" 
                                    placeholder="<liferay-ui:message key="badge-proroga-placeholder-data"/>"
                                    value="${nuovaDataScadenzaModal}"
                                    data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
									data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
					                data-parsley-required="true" 
					                data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					                data-parsley-new-deadline-check="#<portlet:namespace/>dataProrogaModale"/>
					                
                                </div>
                            </c:if>
                            </div>
                        </div>
                        <div class="ama-row mt-35-xs mb-35-xs buttons-bottom text-center">
                            <div class="ama-col-xs-12 ama-col-sm-6">
                                <button class="button button-secondary" data-dismiss="modal"><liferay-ui:message key="badge-proroga-modal-btn-annulla"/></button>
                            </div>
                            <div class="ama-col-xs-12 ama-col-sm-6">
                                <button id="<portlet:namespace/>cta-submit-proroga" class="button button-primary submitButton" onclick="continuaFunction(event)"><liferay-ui:message key="badge-proroga-modal-btn-conferma"/></button>
                            </div>
                        </div>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<input type="hidden" id="validatorDataFine" value="${dataFineSelezionata}">
</div>

<script>
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("checkedAll").addEventListener("change", function () {
        if (this.checked) {
            var checkboxTable = document.querySelectorAll(".check-item");
            for (i = 0; i < checkboxTable.length; i++){
                checkboxTable[i].checked=true;
            }
        }
        else {
            var checkboxTable = document.querySelectorAll(".check-item");
            for (i = 0; i < checkboxTable.length; i++){
                checkboxTable[i].checked=false;
            }
        }
    });
    var allSingleCheckbox = document.querySelectorAll(".check-item");
    for (y = 0; y < allSingleCheckbox.length; y++){
        allSingleCheckbox[y].addEventListener("click",function (evt) {
            if (this.checked) {
                var isAllChecked = 0;
                for (x = 0; x < allSingleCheckbox.length; x++){
                    if(!allSingleCheckbox[x].checked){
                        var isAllChecked = 1;
                    }
                }
                if (isAllChecked == 0) {
                    document.getElementById("checkedAll").checked = true;
                }
            }
            else {
                document.getElementById("checkedAll").checked = false;
            }
        });
    }
});

$("#<portlet:namespace/>cercaRichiesteInScadenzaBtn").on('click', function(event){
	$("#<portlet:namespace/>cercaRichiesteInScadenzaFrm").parsley().validate();
	var esito_validazione_ricerca = $("#<portlet:namespace/>cercaRichiesteInScadenzaFrm").parsley().isValid();
	
	if(esito_validazione_ricerca){
		$("#<portlet:namespace/>cercaRichiesteInScadenzaFrm").submit();
	}
});

var listIdRichiesteSelezionateSize = <%=listIdRichiesteSelezionateSize%>;

if (listIdRichiesteSelezionateSize > 0) {
	$("#<portlet:namespace/>divWrapperTagAModal").css("display","block");
} else {
	$("#<portlet:namespace/>divWrapperTagAModal").css("display","none");
}

$("#checkedAll").click(function () {
	if(this.checked) {
	  $("#<portlet:namespace/>divWrapperTagAModal").css("display","block");
  	} else {
	  $("#<portlet:namespace/>divWrapperTagAModal").css("display","none");
  	}
});

var atLeastOneIsChecked;
var checkboxes = $("input[class='check-item']");

checkboxes.click(function () {
	  atLeastOneIsChecked = false;
	  checkboxes.each(function () {
		  if($(this).prop('checked')){
	      atLeastOneIsChecked = true;
	      return false;
	    }
	  });
	  if(atLeastOneIsChecked==true) {
		  $("#<portlet:namespace/>divWrapperTagAModal").css("display","block");
	  } else {
		  $("#<portlet:namespace/>divWrapperTagAModal").css("display","none");
	  }
});

var checkIdRichiesteSelezionate = function() {
	var arrayIdRichiesteSelezionate = [];
	$(".check-item").each(function() {		
		if ($(this).prop('checked')){
			 var input = document.createElement("input");				    
		     $(input).attr("type", 'hidden');				  
		     $(input).attr("name", '<portlet:namespace/>idRichiestaSelezionata');
	         $(input).val($(this).val());				  
			 $(this).append(input);
			 arrayIdRichiesteSelezionate.push($(this).val());
	    }      
	}); 
	return arrayIdRichiesteSelezionate;
}
	
function continuaFunction(event){
	event.preventDefault();
	$("#deadlineModal").parsley().validate();
	
    var esito_validazione_scadenza = $("#deadlineModal").parsley().isValid();
	
	if(esito_validazione_scadenza){
		checkIdRichiesteSelezionate();
		$("#<portlet:namespace/>nuovaDataScadenza").val($("#<portlet:namespace/>dataProrogaModale").val());
		$("#<portlet:namespace/>jsonScadenzaSelezionata").val(JSON.stringify(<%=elenco_badge_scadenza%>));
		$("#<portlet:namespace/>riepilogoProrogaFrm").submit();
	}
}

<%
if (listIdRichiesteSelezionate!=null && !listIdRichiesteSelezionate.isEmpty()) {
	for (String idRichiestaSelezionata: listIdRichiesteSelezionate) {
%>
	checkboxes.each(function () {
		if($(this).attr("id")==<%=idRichiestaSelezionata%>) {
			$(this).prop("checked", true); 
		}
	});
	if (checkboxes.length==<%=listIdRichiesteSelezionateSize%>) {
		document.getElementById("checkedAll").checked = true;
	}
<%
	}
}
%>
</script>