<portlet:actionURL var="modificaRichiesteBadgeProroga" name="modificaRichiesteBadgeProroga"/> 
<portlet:actionURL var="prorogaRichiesteBadge" name="prorogaRichiesteBadge"/> 

<%
	String nuovaDataScadenza = (String)request.getAttribute("nuovaDataScadenza");
	String elenco_badge_scadenza = "";
	if(request.getAttribute("jsonScadenzaSelezionata")!=null) 
		elenco_badge_scadenza = (String)request.getAttribute("jsonScadenzaSelezionata");

	String elenco_badge_proroga = "";
	if(request.getAttribute("jsonListaRiepilogoProroga")!=null) 
		elenco_badge_proroga = (String)request.getAttribute("jsonListaRiepilogoProroga");
	JSONArray jsonarray_badge_proroga = null;
	if(elenco_badge_proroga!=null && !"".equals(elenco_badge_proroga))
		jsonarray_badge_proroga = JSONFactoryUtil.createJSONArray(elenco_badge_proroga);
%>

<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                     <h2 class="title"><%=riepilogoProrogaTitle%></h2>
                     <a class="icomoon-star title-star btn-star-bookmarks pl-0-sm pl-20-md">
                        <span class="sr-only"><liferay-ui:message key="badge-proroga-preferiti"/></span>
                     </a>
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
	               	 <p class="subtitle dot-point dot-200"><%=riepilogoProrogaSubtitle%></p>
	          	</div>
            </div>
        </div>
    </div>
</div>


<div class="ama-container-fluid">
    <div class="ama-row">
        <div class="ama-col-xs-12">
            <div class="tab-ricerca-badge">
                <h3 class="tab-item text-uppercase"><liferay-ui:message key="badge-proroga-riepilogo-badge-da-prorogare"/></h3>
            </div>
        </div>
    </div>
    <div class="proroga-badge-main">
        <div class="proroga-badge">
            <div class="pb-title-section">
                <p class="pb-title-text"><liferay-ui:message key="badge-proroga-riepilogo-stai-richiedendo-la-proroga"/>: ${nuovaDataScadenza}</p>
            </div>
        </div>
        <p class="copy-text blue-color"><liferay-ui:message key="badge-proroga-riepilogo-mantenere-almeno-un-badge"/></p>
        <div class="pd-table-main resume-pd-table table-responsive">
            <table class="table pd-table">
                <thead>
                <tr>
                    <th><span class="icomoon-trash1"></span></th>
                    <th><liferay-ui:message key="badge-proroga-table-numero-badge"/></th>
                    <th><liferay-ui:message key="badge-proroga-table-assegnatario-badge"/></th>
                    <th><liferay-ui:message key="badge-proroga-table-cf-badge"/></th>
                    <th><liferay-ui:message key="badge-proroga-table-scadenza-badge"/></th>
                    <th><liferay-ui:message key="badge-proroga-table-tipo-utente-badge"/></th>
                </tr>
                </thead>
                <tbody>
                
	                <% for(int i=0;i<jsonarray_badge_proroga.length();i++) {
				              JSONObject jsonobject_badge_proroga = JSONFactoryUtil.createJSONObject(jsonarray_badge_proroga.get(i).toString());
	         		%>
		                <tr class="item-list-proroga" id="<%=jsonobject_badge_proroga.getString("id_pk")%>">
		                    <td><a class="disable-proroga" title="<liferay-ui:message key="badge-proroga-riepilogo-disabilita-proroga-badge-n"/>: <%=jsonobject_badge_proroga.getString("num_badge")%>" href="" data-id-badge="135789"><liferay-ui:message key="badge-proroga-riepilogo-disabilita-proroga-badge-X"/></a></td>
		                    <td><%=jsonobject_badge_proroga.getString("num_badge")%></td>
	                        <td><%=jsonobject_badge_proroga.getString("nome_int")%> <%=jsonobject_badge_proroga.getString("cognome_int")%></td>
	                        <td><%=jsonobject_badge_proroga.getString("cf_int")%></td>
	                        <td><%=jsonobject_badge_proroga.getString("data_scadenza")%></td>
	                        <td><%=jsonobject_badge_proroga.getString("tipologia_utente")%> 
	                        
	                        	<c:if test="<%="Esterno".equalsIgnoreCase(jsonobject_badge_proroga.getString("tipologia_utente"))%>">
	                        	<span class="toolTip generic-tooltip" data-tip="tip-<%=jsonobject_badge_proroga.getString("id_pk")%>"><span class="info-icon icomoon-info"></span></span>
			                            <div id="tip-<%=jsonobject_badge_proroga.getString("id_pk")%>" class="tip-main hidden">
			                                <div class="tip-content">
			                                    <label class="tip-label"><liferay-ui:message key="badge-proroga-tooltip-societa"/></label>
			                                    <span class="tip-text"><%=jsonobject_badge_proroga.getString("societa")%></span>
			                                </div>
			                                <div class="tip-content">
			                                    <label class="tip-label"><liferay-ui:message key="badge-proroga-tooltip-referente-societa-sogei"/></label>
			                                    <span class="tip-text"><%=jsonobject_badge_proroga.getString("ref_societa")%></span>
			                                </div>
			                                <div class="tip-content">
			                                    <label class="tip-label"><liferay-ui:message key="badge-proroga-tooltip-sedi"/></label>
			                                    <span class="tip-text"><%=jsonobject_badge_proroga.getString("sedi")%></span>
			                                </div>
			                            </div>
	                        	</c:if>
	                        	
		                    </td>
		                </tr>
                	<%}%>
                
                </tbody>
            </table>
            
            <div class="ama-row">
                <div class="ama-col-xs-12 ama-col-sm-6 text-center">
                    <button class="mt-30-xs mb-20-xs button button-secondary" data-dismiss="modal" id="<portlet:namespace/>modificaRichiesteBadgeProrogaBtn"><liferay-ui:message key="badge-proroga-riepilogo-btn-modifica"/></button>
                </div>
                <div class="ama-col-xs-12 ama-col-sm-6">
                    <div class="submit-search-badge mt-30-xs mb-20-xs text-center">
                        <button class="button button-primary" id="<portlet:namespace/>prorogaRichiesteBadgeBtn"><liferay-ui:message key="badge-proroga-riepilogo-btn-proroga"/></button>
                    </div>
                </div>
            </div> 
        </div>
    </div>
    
<form id="<portlet:namespace/>modificaRichiesteBadgeProrogaFrm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=modificaRichiesteBadgeProroga%>">
	<input type="hidden" id="<portlet:namespace/>nuovaDataScadenza" name="<portlet:namespace/>nuovaDataScadenza" value="<%=nuovaDataScadenza%>">
    <input type="hidden" id="<portlet:namespace/>jsonScadenzaSelezionata" name="<portlet:namespace/>jsonScadenzaSelezionata">
    <input type="hidden" id="<portlet:namespace/>dataInizioSelezionata" name="<portlet:namespace/>dataInizioSelezionata" value="${dataInizioSelezionata}">
    <input type="hidden" id="<portlet:namespace/>dataFineSelezionata" name="<portlet:namespace/>dataFineSelezionata" value="${dataFineSelezionata}">
    <input type="hidden" id="<portlet:namespace/>listIdRichiesteSelezionate" name="<portlet:namespace/>listIdRichiesteSelezionate" value="${listIdRichiesteSelezionate}">
</form>

<form id="<portlet:namespace/>prorogaRichiesteBadgeFrm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=prorogaRichiesteBadge%>">
    
    <input type="hidden" id="<portlet:namespace/>nuovaDataScadenzaProroga" name="<portlet:namespace/>nuovaDataScadenzaProroga" value="<%=nuovaDataScadenza%>">
    
    <div id="<portlet:namespace/>divInputIdBadgeDaProrogare">
    </div>
</form>
    
</div>

<script>
var confermaProroga = true;

document.addEventListener('DOMContentLoaded', function() {
    if (window.Element && !Element.prototype.closest) {
        Element.prototype.closest =
        function(s) {
            var matches = (this.document || this.ownerDocument).querySelectorAll(s),
                i,
                el = this;
            do {
                i = matches.length;
                while (--i >= 0 && matches.item(i) !== el) {};
            } while ((i < 0) && (el = el.parentElement));
            return el;
        };
    }
    var disableRequestBadge = document.querySelectorAll(".disable-proroga");
    for (y = 0; y < disableRequestBadge.length; y++){
        disableRequestBadge[y].addEventListener("click",function (evt) {
            evt.preventDefault();
            this.closest("tr").classList.add("disabled-request-badge");
            
            var itemslength = $('tr.disabled-request-badge').length;
            
            if (itemslength==<%=jsonarray_badge_proroga.length()%>) {
   				$("#<portlet:namespace/>prorogaRichiesteBadgeBtn").attr('disabled', true);
   	     	} else {
   	     		$("#<portlet:namespace/>prorogaRichiesteBadgeBtn").attr('disabled', false);
   	     	}  
            
        });
    }
});

var checkIdBadgeDaProrogare = function() {
	var arrayIdBadgeDaProrogare = [];
	$(".item-list-proroga").each(function() {		
			if (!$(this).hasClass("disabled-request-badge")){
				 var input = document.createElement("input");				    
			     $(input).attr("type", 'hidden');				  
			     $(input).attr("name", '<portlet:namespace/>idBadgeDaProrogare');
		         $(input).val($(this).attr("id"));	
				 $("#<portlet:namespace/>divInputIdBadgeDaProrogare").append(input);
				 arrayIdBadgeDaProrogare.push($(this).val());
	     }      
			}); 
	return arrayIdBadgeDaProrogare;
	}

$("#<portlet:namespace/>modificaRichiesteBadgeProrogaBtn").on('click', function(event){
	$("#<portlet:namespace/>jsonScadenzaSelezionata").val(JSON.stringify(<%=elenco_badge_scadenza%>));
	$("#<portlet:namespace/>modificaRichiesteBadgeProrogaFrm").submit();
});

$("#<portlet:namespace/>prorogaRichiesteBadgeBtn").on('click', function(event){
	if( confermaProroga && $($("#<portlet:namespace/>prorogaRichiesteBadgeBtn")).parsley().isValid() ){
	
	checkIdBadgeDaProrogare();
	confermaProroga = false;
	$("#<portlet:namespace/>prorogaRichiesteBadgeFrm").submit();
}});
</script>