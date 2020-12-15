<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.intranet.mef.job.siap.model.OrganizationChart"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>

<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"></portlet:actionURL>
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"></portlet:actionURL>
<portlet:actionURL var="getListaRichieste" name="getListaRichieste">
                             <portlet:param name="richiedenteRole" value="${richiedenteRole}"/>
                             <portlet:param name="consegnatarioRole" value="${consegnatarioRole}"/>
                             </portlet:actionURL>
<portlet:actionURL var="cercaUtentiDaAbilitareUrl" name="cercaUtentiDaAbilitare"/>
<portlet:actionURL var="cercaUtentiAbilitatiUrl" name="cercaUtentiAbilitati"/>
<portlet:actionURL var="refreshPageUrl" name="refreshPage"/>
<form enctype="multipart/form-data" id="<portlet:namespace/>refreshPage" action="<%=refreshPageUrl%>" method="post"> </form>                  
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<%String param_daAbilitareClass ="collapse in";
String param_abilitatiClass="collapse";
String param_abilitatiClassActive="";
String param_daAbilitareClassActive="active";

if (request.getAttribute("jsonArrayUtentiAbilitati")!=null){	
	param_daAbilitareClass = "collapse";
	param_abilitatiClass="collapse in";
	param_abilitatiClassActive="active";
	param_daAbilitareClassActive="";
} 
%>

<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=gestioneUtentiTitle%></h2>
                             <div class="wrap-icon-title mobile-search form-inline-wrap">
                             <form enctype="multipart/form-data" action="<%=vaiAInserimento%>" method="post">
                                 <button href="<%=vaiAInserimento%>" type="button" class="button-xs button button-primary mr-10-xs" onclick="this.form.submit()">NUOVA RICHIESTA
                                     <span class="icomoon-plus icon-beni"></span>
                                 </button>
                             </form>
                             <a href="<%=getListaRichieste%>" title="<liferay-ui:message key="beni-facile-consumo-lista-richieste-tooltip"/>" class="icon icomoon-user2"></a>
                             <a href="<%=vaiARicerca%>" title="<liferay-ui:message key="beni-facile-consumo-ricerca-tooltip"/>" class="icon icomoon-search-richiesta"></a>
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
                         <a href="" title="CERCA UTENTI DA ABILITATARE" class="tab-title <%=param_daAbilitareClassActive%>" data-toggle="collapse" data-target="#utenti-abilitare" data-parent="#tabs-beni"><liferay-ui:message key="beni-facile-consumo-cerca-utenti-da-abilitare"/></a>
                         <a href="" title="CERCA UTENTI ABILITATI" class="tab-title <%=param_abilitatiClassActive%>" data-toggle="collapse" data-target="#utenti-abilitati" data-parent="#tabs-beni"><liferay-ui:message key="beni-facile-consumo-cerca-utenti-abilitati"/></a>
                     </div>
                     <div id="utenti-abilitare" class="<%=param_daAbilitareClass%>">
                         <div class="wrapper-tab-beni-consumo ">
                             <div class="box-gray no-margin">
                                 <div class="box-white box-gray-mobile">
                                     <form enctype="multipart/form-data" data-parsley-validate="true" id="<portlet:namespace/>cercaUtentiDaAbilitareForm" action="<%=cercaUtentiDaAbilitareUrl%>" method="post">
                                         <div class="ama-row">
											<div class="col-xs-12 pb-10-xs">
											<p class="copy-text blue-color"><liferay-ui:message key="beni-facile-consumo-campi-obbligatori"/></p>
											</div>
										</div>
                                         <div class="ama-row">
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="<portlet:namespace/>cognomeUtenteDaAbilitare" class="label-form mt-10-sm"><liferay-ui:message key="beni-facile-consumo-cognome-richiedente"/>*</label>
                                                 <input id="<portlet:namespace/>cognomeUtenteDaAbilitare" class="input-custom-light" 
                                                 	placeholder="INSERISCI IL COGNOME" name="<portlet:namespace/>cognomeUtenteDaAbilitare">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="argument2" class="label-form mt-10-sm "><liferay-ui:message key="beni-facile-consumo-nome-richiedente"/></label>
                                                 <input id="argument2" class="input-custom-light data-parsley-validated" placeholder="INSERISCI IL NOME" name="<portlet:namespace/>nomeUtenteDaAbilitare">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="argument4" class="label-form mt-10-sm"><liferay-ui:message key="beni-facile-consumo-cf"/></label>
                                                 <input id="argument4" class="input-custom-light data-parsley-validated" 
                                                 	data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                 	placeholder="INSERISCI IL CODICE FISCALE" name="<portlet:namespace/>codFiscaleUtenteDaAbilitare">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12 ">
                                                 <label for="<portlet:namespace/>idUfficioUtenteDaAbilitare" class="label-form mt-10-sm"><liferay-ui:message key="beni-facile-consumo-ufficio"/>*</label>
                                                 <select id="<portlet:namespace/>idUfficioUtenteDaAbilitare" 
                                                 	class="option-select-notice" name="<portlet:namespace/>idUfficioUtenteDaAbilitare">
                                                     <option value="" hidden><liferay-ui:message key="beni-facili-consumo-scegli-elenco"/></option>
                                                     <c:forEach items="${uffici}" var="ufficio">
                                                       <option value="${ufficio.getIdOrgChart()}">${ufficio.getName().toUpperCase()}</option>
                                                     </c:forEach>
                                                 </select>
                                             </div>
                                         </div>
                                         <input type="text" style="display:none" id="<portlet:namespace/>inputDaAbilitare" name="<portlet:namespace/>inputDaAbilitare"
                                          class="data-parsley-validated"
                                          data-parsley-required="true"
						                  data-parsley-required-message="Almeno uno dei due campi richiesti deve essere valorizzato"/>
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
											<p class="copy-text blue-color"><liferay-ui:message key="beni-facile-consumo-campi-obbligatori"/></p>
										    </div>
										</div>
                                         <div class="ama-row">
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="<portlet:namespace/>cognomeUtenteAbilitato" class="label-form mt-10-sm"><liferay-ui:message key="beni-facile-consumo-cognome"/>*</label>
                                                 <input id="<portlet:namespace/>cognomeUtenteAbilitato" class="input-custom-light" placeholder="INSERISCI IL COGNOME" name="<portlet:namespace/>cognomeUtenteAbilitato">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="argument2" class="label-form mt-10-sm"><liferay-ui:message key="beni-facile-consumo-nome"/></label>
                                                 <input id="argument2" class="input-custom-light" placeholder="INSERISCI IL NOME" name="<portlet:namespace/>nomeUtenteAbilitato">
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label for="<portlet:namespace/>idUfficioUtenteAbilitato" class="label-form mt-10-sm"><liferay-ui:message key="beni-facile-consumo-ufficio"/>*</label>
                                                 <select id="<portlet:namespace/>idUfficioUtenteAbilitato"  class="option-select-notice" name="<portlet:namespace/>idUfficioUtenteAbilitato">
                                                     <option value="" hidden><liferay-ui:message key="beni-facili-consumo-scegli-elenco"/></option>
                                                     <c:forEach items="${uffici}" var="ufficio">
                                                       <option value="${ufficio.getIdOrgChart()}">${ufficio.getName().toUpperCase()}</option>
                                                     </c:forEach>
                                                 </select>
                                             </div>
                                             <div class="ama-col-md-3 ama-col-xs-12">
                                                 <label  class="label-form mt-10-sm"><liferay-ui:message key="beni-facili-consumo-DELEGA"/></label>
                                                 <div class="checkbox-blue mr-15-xs">
                                                     <div class="squaredOne">
                                                         <input class="checkboxyes" type="checkbox" value="Yes" id="delegaSI" name="<portlet:namespace/>check">
                                                         <label for="delegaSI"></label>
                                                     </div>
                                                     <p class="text-check"><liferay-ui:message key="beni-facili-consumo-SI"/></p>
                                                 </div>
                                                 <div class="checkbox-blue">
                                                     <div class="squaredOne">
                                                         <input class="checkboxno" type="checkbox" value="No" id="delegaNO" name="<portlet:namespace/>check">
                                                         <label for="delegaNO"></label>
                                                     </div>
                                                     <p class="text-check"><liferay-ui:message key="beni-facili-consumo-NO"/></p>
                                                 </div>
                                             </div>
                                         </div>
                                         <input id="checkBoxArrayInputId" type="hidden" value="" name="<portlet:namespace/>checkBoxArray">
                                      <input type="text" style="display:none" id="<portlet:namespace/>inputAbilitati" name="<portlet:namespace/>inputAbilitati"
                                         class="data-parsley-validated"
                                         data-parsley-required="true"
						                 data-parsley-required-message="Almeno uno dei due campi richiesti deve essere valorizzato"/>
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
                 <button class="button button-secondary" onclick="resetForm()"><liferay-ui:message key="beni-facili-consumo-annulla"/></button>
             </div>
             <div class="ama-col-md-6 text-center mb-50-sm mt-50-sm">
                 <button class="button button-primary" onclick="submitForm(event)"><liferay-ui:message key="beni-facili-consumo-applica"/></button>
             </div>
         </div>
	
	<%String elencoRisultati = null;                                    
    		if(request.getAttribute("jsonArrayUtentiDaAbilitare")!=null) {
    			elencoRisultati = (String)request.getAttribute("jsonArrayUtentiDaAbilitare");
    	    }
    		if(request.getAttribute("jsonArrayUtentiAbilitati")!=null) {
    			elencoRisultati = (String)request.getAttribute("jsonArrayUtentiAbilitati");
    	    }
   		JSONArray arrayRes = JSONFactoryUtil.createJSONArray(elencoRisultati);
	%>
	
	 <c:if test="${filtriRicercaRichieste!=null}">
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay-ui:message key="beni-facili-consumo-risultati-ricerca"/></h2>
                 </div>
             </div>
         </div>         
         <div class="ama-row">
             <div class="ama-col-xs-12">
                 <div class="labels-container mobile-click-open mt-0-xs mb-30-xs form-inline-wrap">
                     <span class="labels-container-title"><liferay-ui:message key="beni-facili-consumo-filtrato-per"/>:</span>
                          <c:forEach items="${filtriRicercaRichieste}" var="filtro">
                                <div class="filter-label-item mt-10-xs">
                                      <h2>${filtro.toUpperCase()}</h2>
                                </div>
                          </c:forEach>
                          
                     <div class="filter-label-item btn-filter-reset">
                         <h2><liferay-ui:message key="beni-faicle-consumo-reset"/></h2><span class="icomoon-close-white"></span>
                     </div>
                    
                     <span class="span-person"><p class="bold-span"><%=arrayRes.length()%></p> 
                     <liferay-ui:message key="beni-facili-consumo-persone-trovate"/></span>
                 </div>
             </div>
         </div>
   </c:if>
   <div class="ama-row">
     <c:if test="<%=elencoRisultati!=null && arrayRes.length()<1%>">
      <p class="copy-text wysiwyg-editor"><liferay-ui:message key="beni-facili-consumo-nessuna-richiesta"/></p>
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
                         <button id="abilita<%=i%>" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message key="beni-facili-consumo-abilita"/></button>
                         <button disabled id="abilitato<%=i%>" class="button button-primary active hide"><liferay-ui:message key="beni-facili-consumo-abilitato"/></button>
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
                         <button id="revoca<%=i%>" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message key="beni-facili-consumo-revoca-delega"/></button>
                         <button disabled id="revocata<%=i%>" class="button button-primary active hide"><liferay-ui:message key="beni-facili-consumo-delega-revocata"/></button>
                         </c:if>
                         <c:if test="<%=jsonRichiesta.get("delega").toString().equals("false")%>">
                         <button id="delega<%=i%>" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message key="beni-facili-consumo-delega"/></button>
                         <button disabled id="delegato<%=i%>" class="button button-primary active hide"><liferay-ui:message key="beni-facili-consumo-delegato"/></button>
                         </c:if>
                         <button id="elimina<%=i%>" class="button button-secondary mt-10-xs" data-toggle="modal" data-target="#modal-user" onclick="openModal(<%=i%>)"><liferay-ui:message key="beni-facili-consumo-elimina"/></button>
                         <button disabled id="eliminato<%=i%>" class="button button-primary active hide"><liferay-ui:message key="beni-facili-consumo-eliminato"/></button>
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
                                     <h2 class="title"><liferay-ui:message key="beni-facile-consumo-messaggio-eliminazione-utente"/>
                                     </h2>
                                 </div>
                             </div>
             
                             <h2 class="text"><liferay-ui.message key="beni-facile-consumo-messaggio-eliminazione"/>
                             </h2>
             
                             <div class="ama-row mb-50-xs buttons-bottom">
                                 <div class="ama-col-xs-12 ama-col-sm-6">
                                     <button class="button button-secondary" data-dismiss="modal"><liferay-ui:message
												key="beni-facile-consumo-annulla"/></button>
                                 </div>
                                 <div class="ama-col-xs-12 ama-col-sm-6">
                                     <button id="eliminautente" class="button button-primary" onclick="callServeResource(event,this.id,<%=i%>,<%=id_utente%>)"><liferay-ui:message
												key="beni-facile-consumo-elimina-utente"/></button>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </c:if> 
         <%}%>
   
    </div>
</div>
<script>
$('.icomoon-close-white').on('click',function(){
	$('#<portlet:namespace/>refreshPage').submit();
});

var checkBoxArray = [];

function submitForm(event) {
	
	if ($('#utenti-abilitare').hasClass("collapse in")) {
		
		$('#<portlet:namespace/>inputDaAbilitare').val("");

		if($('#<portlet:namespace/>cognomeUtenteDaAbilitare').val()!="" || $('#<portlet:namespace/>idUfficioUtenteDaAbilitare').val()!=""){
			$('#<portlet:namespace/>inputDaAbilitare').val("almeno un campo inserito");
		}
		$('#<portlet:namespace/>cercaUtentiDaAbilitareForm').parsley().validate();
		if($('#<portlet:namespace/>cercaUtentiDaAbilitareForm').parsley().isValid()){
			$('#<portlet:namespace/>cercaUtentiDaAbilitareForm').submit();	
			}		
	}
	else {
		if ($('.checkboxyes:checked').val()=="Yes") {
			checkBoxArray.push($('.checkboxyes:checked').val());
		}
        if ($('.checkboxno:checked').val()=="No") {
        	checkBoxArray.push($('.checkboxno:checked').val());
		}
        $('#checkBoxArrayInputId').val(checkBoxArray);

        $('#<portlet:namespace/>inputAbilitati').val("");

		if($('#<portlet:namespace/>cognomeUtenteAbilitato').val()!="" || $('#<portlet:namespace/>idUfficioUtenteAbilitato').val()!=""){
			$('#<portlet:namespace/>inputAbilitati').val("almeno un campo inserito");
		}
		$('#<portlet:namespace/>cercaUtentiAbilitatiForm').parsley().validate();
		if($('#<portlet:namespace/>cercaUtentiAbilitatiForm').parsley().isValid()){
			$('#<portlet:namespace/>cercaUtentiAbilitatiForm').submit();
			}		
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