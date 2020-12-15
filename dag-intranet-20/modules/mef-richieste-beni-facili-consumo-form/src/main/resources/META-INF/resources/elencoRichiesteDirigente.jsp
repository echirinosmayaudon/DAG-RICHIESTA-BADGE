  <%@page import="com.mef.intranet.bean.RisultatoListaRichieste"%> 
  <%@page import="servizio.beni.facile.consumo.model.Stato"%> 
  <%@page import="com.intranet.mef.job.siap.model.OrganizationChart"%> 
  <%@page import="java.util.Set"%> 
  <%List<Stato> lista_stati=(List<Stato>)request.getAttribute("lista_stati");
  Set<OrganizationChart> lista_uffici=(Set<OrganizationChart>)request.getAttribute("uffici");
  List<RisultatoListaRichieste>  listaRichieste = (List<RisultatoListaRichieste>) request.getAttribute("listarichieste");
  int itemsdelta=0;
  if (Integer.valueOf(itemsPerPage) > 0 ) {itemsdelta=Integer.valueOf(itemsPerPage);}
  %>
<portlet:actionURL  var="ricercaRichiesteUrl" name="ricercaRichieste"></portlet:actionURL>
<portlet:actionURL var="refreshPageRicercaUrl" name="refreshPageRicerca"/>
 <form enctype="multipart/form-data" id="<portlet:namespace/>refreshPageRicerca" action="<%=refreshPageRicercaUrl%>" method="post"></form>

  <div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=cercaRichiestaTitle%></h2>
                             <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
                                 <form enctype="multipart/form-data" action="<%=vaiAInserimento%>" method="post">
                                 <button href="<%=vaiAInserimento%>" type="button" class="button-xs button button-primary mr-10-xs" onclick="this.form.submit()"><liferay-ui:message key="beni-facile-consumo-nuova-richiesta"/>
                                     <span class="icomoon-plus icon-beni"></span>
                                 </button>
                             </form>
                            <c:if test="${dirigenteRole}">
                                  <a href="<%=vaiAGestioneUtenti%>" title="<liferay-ui:message key="beni-facile-consumo-gestione-utenti-tooltip"/>" class="icon icomoon-profile"></a>
                            </c:if>
                            <a href="<%=getListaRichieste%>" title="<liferay-ui:message key="beni-facile-consumo-lista-richieste-tooltip"/>" class="icon icomoon-user2"></a>
                             </div>
                         <p class="subtitle dot-point dot-200"><%=cercaRichiestaSubtitle%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>
      <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-md-12">
                <div class="wrapper-title-small">
                    <h2 class="title-box borders"><liferay-ui:message key="beni-facili-consumo-cerca-richiesta"/></h2>
                </div>
            </div>
        </div>
        <div class="wrapper-tab-beni-consumo">
            <form enctype="multipart/form-data" action="<%=ricercaRichiesteUrl%>" method="post" id="<portlet:namespace/>formRicerca" data-parsley-validate="true">
                <div class="ama-row">
					<div class="col-xs-12 pb-20-xs">
					<p class="copy-text blue-color"><liferay-ui:message key="beni-facile-consumo-campi-obbligatori"/></p>
					</div>
				</div>
                <div class="ama-row">
                    <div class="col-md-4">
                        <label for="<portlet:namespace/>cogn_richiedente" class="label-form "><liferay-ui:message key="beni-facile-consumo-cognome-richiedente"/>*</label>
                        <input id="<portlet:namespace/>cogn_richiedente" name="<portlet:namespace/>cogn_richiedente" class="input-custom-light" placeholder="INSERISCI IL COGNOME">
                    </div>
                    <div class="col-md-4">
                        <label for="<portlet:namespace/>nome_richiedente" class="label-form "><liferay-ui:message key="beni-facile-consumo-nome-richiedente"/></label>
                        <input id="<portlet:namespace/>nome_richiedente" name="<portlet:namespace/>nome_richiedente" class="input-custom-light" placeholder="INSERISCI IL NOME">
                    </div>
                    <div class="col-md-4">
                        <label for="<portlet:namespace/>selectUff" class="label-form"><liferay-ui:message key="beni-facile-consumo-ufficio"/>*</label>
                        <select id="<portlet:namespace/>selectUff" name="<portlet:namespace/>selectUff" class="option-select-notice">
                            <option value="" hidden><liferay-ui:message key="beni-facili-consumo-scegli-elenco"/></option>
                            <c:if test="<%=lista_uffici!=null && lista_uffici.size()>0 %>">
                           <c:forEach items="<%=lista_uffici%>" var="ufficio">
                             <option value="${ufficio.getAcronimo()}" >${ufficio.getName().toUpperCase()}</option>
                           </c:forEach>
                            </c:if>
                        </select>
                    </div>
                </div>
                <div class="ama-row">
                    <div class="col-xs-12"><label for="argument2" class="label-form mt-30-xs"><liferay-ui:message key="beni-facili-consumo-stato-richiesta"/>:</label></div>
                    <c:if test="<%=lista_stati!=null && lista_stati.size()>0 %>">
                    <c:forEach items="<%=lista_stati%>" var="stato">
                    <div class="ama-col-md-2 ama-col-sm-4 ama-col-xs-6">
                            <div class="box-gray-beni">
                       <c:choose>
                       <c:when test='${stato.getDescrizione().equalsIgnoreCase("in approvazione")}'>
                         <span class="icon-tab icomoon-in-approvazione"></span>
                       </c:when>
                       <c:when test='${stato.getDescrizione().equalsIgnoreCase("non approvata")}'>
                         <span class="icon-tab icomoon-non-approvata"></span>
                       </c:when>
                       <c:when test='${stato.getDescrizione().equalsIgnoreCase("nuova")}'>
                         <span class="icon-tab icomoon-file"></span>
                       </c:when>
                       <c:when test='${stato.getDescrizione().equalsIgnoreCase("accettata")}'>
                         <span class="icon-tab icomoon-success-blu "></span>
                       </c:when>
                        <c:when test='${stato.getDescrizione().equalsIgnoreCase("rifiutata")}'>
                         <span class="icon-tab icomoon-cancel"></span>
                       </c:when>
                        <c:when test='${stato.getDescrizione().equalsIgnoreCase("evasa")}'>
                          <span class="icon-tab icomoon-cart"></span>
                       </c:when>
                       <c:when test='${stato.getDescrizione().equalsIgnoreCase("non evasa")}'>
                           <span class="icon-tab icomoon-cart-2"></span>
                       </c:when>
                        <c:when test='${stato.getDescrizione().equalsIgnoreCase("consegnata")}'>
                           <span class="icon-tab icomoon-cart-3"></span>
                       </c:when>   
                       </c:choose>     
                              <input type="hidden" value=" ${stato.getId()}" name="<portlet:namespace/>idStato"/>
                           <p class="text-tab dot-50 dot-point dot-mobile">${stato.getDescrizione().toUpperCase()}</p>   
                    </div>
                    </div>
                    </c:forEach>
                    </c:if>
  
                </div>
                
                <input type="text" style="display:none" id="<portlet:namespace/>inputParsley" 
                class="data-parsley-validated"
                        data-parsley-required="true"
						data-parsley-required-message="Almeno uno dei due campi richiesti deve essere valorizzato"/>
              
                <div class="ama-row">
                    <div class="ama-col-md-6 text-center mb-40-sm mb-0-xs mt-90-md mt-20-sm mt-0-xs">
                        <button type="button" onclick="resetForm(event)" class="button button-secondary"><liferay-ui:message key="beni-facili-consumo-annulla"/></button>
                    </div>
                    <div class="ama-col-md-6 text-center mb-40-sm mb-30-xs mt-90-md mt-20-sm mt-0-xs">
                        <button type="button" onclick="submitForm()" class="button button-primary"><liferay-ui:message key="beni-facili-consumo-applica"/></button>
                    </div>
                </div>
             <input type="hidden" id="arrayLabelStati" name="<portlet:namespace/>arrayLabelStati"/>    
            </form>
        </div>

<c:if test="${listarichieste!=null}">

         <div class="top-paginator-scroll">
         
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay-ui:message key="beni-facile-consumo-ricerca-risultati-title"/></h2>
                 </div>
             </div>
         </div> 
         
            <c:if test="<%=request.getAttribute("filtriRicercaRichieste")!=null%>">   
             <div class="ama-row">
             <div class="ama-col-xs-12">
                 <div class="labels-container mobile-click-open mt-0-xs mb-30-xs">
                     <span class="labels-container-title"><liferay-ui:message key="beni-facili-consumo-filtrato-per"/>:</span>
                     <c:forEach items="<%=request.getAttribute("filtriRicercaRichieste")%>" var="filtro">
                     <div class="filter-label-item">
                         <h2>${filtro.toUpperCase()}</h2>
                     </div>
                     </c:forEach>
                    
                     <div class="filter-label-item btn-filter-reset">
                         <h2><liferay-ui:message key="beni-faicle-consumo-reset"/></h2><span class="icomoon-close-white"></span>
                     </div>
                  
                     <span class="span-person">
                     <p class="bold-span">${listarichieste.size()}</p> 
                     <liferay-ui:message key="beni-facile-consumo-risultato-richieste"/></span>
                 </div>
             </div>
         </div>
         </c:if>
         
           <c:if test="${listarichieste.size()==0}"> 
           <p class="copy-text wysiwyg-editor"><liferay-ui:message key="beni-facili-consumo-nessuna-richiesta"/></p>
           </c:if>

         <div class="js-list-pagination">
             <div class="ama-row">

               <c:forEach items="${listarichieste}" var="richiesta"> 

			   <portlet:actionURL name="vaiADettaglio" var="vaiADettaglio">
                	<portlet:param name="richiestaId" value="${richiesta.getId()}" />
                	<portlet:param name="statoRichiesta" value="${richiesta.getStato()}" />	
                </portlet:actionURL>

                 <div class="ama-col-lg-3 ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                      <div class="item-pagination">
                        <div class="wrappper-beni-consumo-component mb-30-xs">
                             <a href="<%=vaiADettaglio%>" title="" class="wrapper-box-beni">
                                 <div class="header-white header-ricerca">
                                       <p class="text-new mb-20-xs">
                                 
                                    <c:if test="${richiesta.getStato() ==  'in approvazione'}">
										  <span class="ico-new icomoon-in-approvazione"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'non approvata'}">
										  <span class="ico-new icomoon-non-approvata"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'nuova'}">
										  <span class="ico-new icomoon-file"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'accettata'}">
										<span class="ico-new icomoon-success-blu"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'rifiutata'}">
										  <span class="ico-new icomoon-cancel"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'evasa'}">
										 <span class="ico-new icomoon-cart"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'non evasa'}">
										  <span class="ico-new icomoon-cart-2"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'consegnata'}">
										 <span class="ico-new icomoon-cart-3"></span>
									</c:if>
									${richiesta.getStato().toUpperCase()}
                                </p>
                                 
                               <p class="name dot-point dot-60 dot-mobile name-new">${richiesta.getNome()} ${richiesta.getCognome()}</p>
                                 </div>
                                 <div class="footer-blue">
                                     <span class="icon-footer icomoon-calendar-date"></span>
                                     <p class="display-in-bl mr-30-xs"> <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${richiesta.getData()}" /></p>                     
                                     <span class="icon-footer icomoon-time"></span>
                                     <p class="display-in-bl"> <fmt:formatDate type = "time"  pattern="HH:mm" value = "${richiesta.getData()}" /></p>   
                                 </div>
                             </a>
                         </div>
                     </div>
                 </div>
     </c:forEach>  
                             </div>
                             
                 <div class="ama-row">
                     <div class="ama-col-xs-12 text-align-center">
                         <div data-totpage="<%=itemsdelta%>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                             <div class="btn-back-arrow disabled">
                                 <a href="" title="Pagina precedente">
                                     <em class="icomoon-arrow"></em>
                                 </a>
                             </div>
                             <ul class="pagination-numbers">
                                 <li class="current-page"><a title="Vai a pagina" href="">1</a></li>
                                 <li><a title="Vai a pagina" href="">2</a></li>
                             </ul>
                             <div class="btn-forward-arrow">
                                 <a href="" title="Pagina successiva">
                                     <em class="icomoon-arrow">
                                         <span class=""></span>
                                     </em>
                                 </a>
                             </div>
                         </div>
                     </div>
                 </div>     
             </div>
         </div>
         </c:if>
</div>

<script>

$('.icomoon-close-white').on('click',function(){
	$('#<portlet:namespace/>refreshPageRicerca').submit();
});

function submitForm(){
	$('#<portlet:namespace/>inputParsley').val("");
	$("#arrayLabelStati").val(checkCategory());

	if($('#<portlet:namespace/>selectUff').val()!="" || $('#<portlet:namespace/>cogn_richiedente').val()!=""){
		$('#<portlet:namespace/>inputParsley').val("almeno un campo inserito");
	}
	
	$('#<portlet:namespace/>formRicerca').parsley().validate();
	if($('#<portlet:namespace/>formRicerca').parsley().isValid()){
	$('#<portlet:namespace/>formRicerca').submit();
	}
}

var checkCategory = function(){
	 var arrayNomeStato=[];
	 resetFilterCategory();
	 $(".box-gray-beni").each(function() {		
			if ($(this).is(".active")){
				var input = document.createElement("input");				    
			     $(input).attr("type", 'hidden');				  
			     $(input).attr("name", '<portlet:namespace/>stato_richiesta');
		         $(input).val($(this).children()[1].value);	
				     $(this).append(input);
				     arrayNomeStato.push($(this).children()[2].innerHTML);
          }      
  		}); 
	 return arrayNomeStato;
}

function removeClassActive(){
	  resetFilterCategory();      
   	  $(".box-gray-beni").each(function() {
				if ($(this).is(".active")){	
					 $(this).removeClass("active");
				}
			});
}
 
function resetFilterCategory(){	 
	 $("input[name=<portlet:namespace/>stato_richiesta]").each(function() {
		 $(this).remove();
	 });
}

function resetForm(event){
	 event.preventDefault();
	 removeClassActive();
		document.getElementById("<portlet:namespace/>formRicerca").reset();
	
}
</script>