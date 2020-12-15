<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="servizio.prenotazione.aule.mef.model.StatoAula"%>
<%@page import="servizio.prenotazione.aule.mef.service.StatoAulaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>

<%
boolean autorizzazione = (boolean) request.getAttribute("autorizzazione");
%>

<portlet:actionURL var="ricercaAuleUrl" name="ricercaAule"/>
<portlet:actionURL var="vaiALeTuePrenotazioniUrl" name="vaiALeTuePrenotazioni"/>
<portlet:actionURL var="requestForApprovalUrl" name="requestForApproval"/>

<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title mb-30-sm mb-0-md"><%=formTitleRicercaAule%></h2>
                         <a class="icomoon-star title-star btn-star-bookmarks pl-0-sm pl-20-md">
                             <span class="sr-only"><liferay-ui:message key="prenotazione-ricerca-aggiungi-preferiti"/></span>
                         </a>
                         <c:if test="${approvatore==true}">
                         <form action="<%=requestForApprovalUrl%>" method="post">
                         <div class="wrap-icon-title mt-5-md">
                             <a href="<%=requestForApprovalUrl%>" title="Sale in attesa di approvazione" class="icon icomoon-prenota-approvata"></a>
                         </div>
                         </form>
                         </c:if>
                         <form action="<%=vaiALeTuePrenotazioniUrl%>" method="post">
                         <div class="wrap-icon-title mt-5-md">
                             <a href="<%=vaiALeTuePrenotazioniUrl%>" title="Sale Prenotate" class="icon icomoon-user2"></a>
                         </div>
                         </form>
                         <p class="subtitle dot-point dot-200"><%=formSubtitleRicercaAule%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>
     <div class="ama-container-fluid">
   	 	<div class="ama-row">
            <div class="ama-col-md-12">
                <div class="wrapper-title-small">
                    <h2 class="title-box borders"><liferay-ui:message key="prenotazione-ricerca-ricerca-aule"/></h2>
                </div>
            </div>
        </div>
        <form  id="<portlet:namespace/>ricercaAuleForm" action="<%=ricercaAuleUrl%>" method="post" class="data-parsley-validated"
        	data-parsley-validate="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
				data-parsley-type-error="<liferay-ui:message key="error-syntactic"/>" enctype="multipart/form-data">
            <div class="ama-row servizi-richiesta-wrapper">
                <div class="ama-col-md-6 ama-col-xs-12">
                    <div class="ama-row">
                        <div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12 mb-25-md">
                            <label for="argument" class="label-form"><liferay-ui:message key="prenotazione-ricerca-sala-riunione"/></label>
                            <select id="argument" class="option-select" name="<portlet:namespace/>sala-select">
                                <option value=""><liferay-ui:message key="prenotazione-ricerca-tutte-sale"/></option>
                                	<c:if test="${saleList!=null}">
                                		<c:forEach items="${saleList}" var="sala" >
                                			<option value="${sala.getId_sala()}">${sala.getDesc_sala().toUpperCase()} - ${sala.getIndirizzo().toUpperCase()}</option>
                                		</c:forEach>
                                	</c:if>
                            </select>
                        </div>
                        <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-6 mb-25-md">
                            <label for="date" class="label-form"><liferay-ui:message key="prenotazione-ricerca-data"/>*</label>
                            <input id="date" type="text" class="datepicker-custom input-custom-light data-parsley-validated" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime())%>" name="<portlet:namespace/>data-input"
                            	data-parsley-required="true" data-parsley-submission-date-check="#date"
                            	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                        </div>
                    </div>
                    <div class="ama-row">
                        <div class="ama-col-md-6 mb-25-md ama-col-sm-6 ama-col-xs-12">
                            <label for="start" class="label-form margin-top"><liferay-ui:message key="prenotazione-ricerca-ora-inizio"/></label>
                            <select id="start" class="option-select data-parsley-validated" name="<portlet:namespace/>ora-inizio-select" data-parsley-submission-date-inizio-fine-check="#date">
                            <option value=""><liferay-ui:message key="prenotazione-ricerca-scegli-ora-inizio"/></option>
                                <c:if test="${oreListInizio!=null}">
                                		<c:forEach items="${oreListInizio}" var="orario" >
                                			<option value="${orario.getOre()}">${orario.getOre()}</option>
                                		</c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="ama-col-md-6 mb-25-md ama-col-sm-6 ama-col-xs-12">
                            <label for="end" class="label-form margin-top"><liferay-ui:message key="prenotazione-ricerca-ora-fine"/></label>
                            <select id="end" class="option-select" name="<portlet:namespace/>ora-fine-select">
                            <option value=""><liferay-ui:message key="prenotazione-ricerca-scegli-ora-fine"/></option>
                                <c:if test="${oreListFine!=null}">
                                		<c:forEach items="${oreListFine}" var="orario" >
                                			<option value="${orario.getOre()}">${orario.getOre()}</option>
                                		</c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="ama-col-md-6 ama-col-xs-12 button-wrapper align-text">
                    <p class="label-form mb-10-xs mb-5-md"><liferay-ui:message key="prenotazione-ricerca-stato-sala"/>:</p>
                    <div class="ama-row">
                    	<c:if test="${statiList!=null}">
                                		<c:forEach items="${statiList}" var="statoAula" >
                                			<%  
                                            StatoAula statoAula=(StatoAula) pageContext.getAttribute("statoAula");
                                            String desc_stato=statoAula.getDesc_stato();
                                            %>
                                                
                                		    <c:if test="<%=desc_stato.equalsIgnoreCase("disponibile")%>">
                                			<div class="ama-col-md-4 ama-col-sm-4">
                            					<div class="container-button no-width">
                                					<button class="servizio-richiesta-button box-aule" type="button">
                                    					<div class="icon-button">
                                        					<span class="icon-text icomoon-unlocked"></span>
                                    					</div>
                                    						<div class="text-button">
                                        						<span class="text">${statoAula.getDesc_stato().toUpperCase()}</span>
                                    						</div>
                                    						<input type="hidden" value=" ${statoAula.getId_stato_aula()}" name="<portlet:namespace/>idStato"/>
                                					</button>
                            					</div>
                        					</div>
                        					</c:if>
                        					<c:if test="<%=desc_stato.equalsIgnoreCase("prenotata")%>">
                                			<div class="ama-col-md-4 ama-col-sm-4">
                            					<div class="container-button no-width">
                                					<button class="servizio-richiesta-button box-aule" type="button">
                                    					<div class="icon-button">
                                        					<span class="icon-text icomoon-lock"></span>
                                    					</div>
                                    						<div class="text-button">
                                        						<span class="text">${statoAula.getDesc_stato().toUpperCase()}</span>
                                    						</div>
                                    						<input type="hidden" value=" ${statoAula.getId_stato_aula()}" name="<portlet:namespace/>idStato"/>
                                					</button>
                            					</div>
                        					</div>
                        					</c:if>
                        					<c:if test="<%=desc_stato.equalsIgnoreCase("da approvare")%>">
                                			<div id="divStatoDaApprovare" class="ama-col-md-4 ama-col-sm-4">
                            					<div class="container-button no-width">
                                					<button id="btnStatoDaApprovare" class="servizio-richiesta-button box-aule" type="button">
                                    					<div class="icon-button">
                                        					<span class="icon-text icomoon-hourglass"></span>
                                    					</div>
                                    						<div class="text-button">
                                        						<span class="text">${statoAula.getDesc_stato().toUpperCase()}</span>
                                    						</div>
                                    						<input type="hidden" value=" ${statoAula.getId_stato_aula()}" name="<portlet:namespace/>idStato"/>
                                					</button>
                            					</div>
                        					</div>
                        					</c:if>
                                		</c:forEach>
                         </c:if>
                    </div>
                </div>
            </div>
         <div class="ama-row">
             <div class="ama-col-sm-6 text-right mb-100-md mt-50-sm">
                 <button class="button button-secondary" onclick="resetForm(event)"><liferay-ui:message key="prenotazione-ricerca-annulla-btn"/></button>
             </div>
             <div class="ama-col-sm-6 text-left mb-100-md mb-30-xs mt-50-sm">
                 <button class="button button-primary" onclick="submitForm()"><liferay-ui:message key="prenotazione-ricerca-applica-btn"/></button>
             </div>
         </div>
         </form>

	
	<%
    	String elencoRisultati = null;                                    
    		if(request.getAttribute("jsonRisultati")!=null) {
    			elencoRisultati = (String)request.getAttribute("jsonRisultati");
    	}
   		JSONArray arrayRes = JSONFactoryUtil.createJSONArray(elencoRisultati);
	%>
	
	<c:if test="<%=elencoRisultati!=null && !(request.getAttribute("filtriRicercaRichieste").toString()).equals("[]")%>">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-md-12 ama-col-xs-12">
                     <div class="tab-filtri filtro-categoria">
                         <div class="filtro-tabs-wrapper">
                            <span class="tab-title active top-paginator-scroll"><liferay-ui:message key="prenotazione-ricerca-risulati-ricerca"/>
                            </span>
                         </div>
                         <div id="filtro-modulistica">
                         
                         <c:if test="${filtriRicercaRichieste!=null}">
                             <div class="filtro-body-box">
                                 <div class="labels-container mt-0-xs text-center-xs">
                                     <span class="labels-container-title mt-0-xs"><liferay-ui:message key="prenotazione-ricerca-flitrato-per"/>:</span>
                                     <c:forEach items="${filtriRicercaRichieste}" var="filtro">
                                     <div class="filter-label-item mt-10-xs">
                                         <h2>${filtro.toUpperCase()}</h2>
                                     </div>
                                     </c:forEach>
                                     <div class="filter-label-item mt-10-xs btn-filter-reset">
                                         <h2><liferay-ui:message key="prenotazione-ricerca-reset"/></h2><span class="icomoon-close-white"></span>
                                     </div>
                                     <span class="filtro-numbers">
                                         <span class="bold"><%=arrayRes.length()%> 
                                         </span> <liferay-ui:message key="prenotazione-ricerca-richiesta-trovate"/>
                                     </span>
                                 </div>
                             </div>
                         </c:if>
                             
                             <portlet:actionURL var="vaiAInserimentoUrl" name="vaiAInserimento"/>
                             <div class="modulistica-wrapper">
                                 <div class="ama-row js-list-pagination">
                                     <div class="ama-col-xs-12">
                                     
                                     <% for(int i=0;i<arrayRes.length();i++) {
                         		        JSONObject jsonRichiesta = JSONFactoryUtil.createJSONObject(arrayRes.get(i).toString());
                         		     %>
                                         <form action="<%=vaiAInserimentoUrl%>" method="post" id="formSingleItem<%=i%>" enctype="multipart/form-data">
                                         <input type="hidden" value="<%=jsonRichiesta.get("data")%>" name="<portlet:namespace/>dataDisponibile"/>
                                         <input type="hidden" value="<%=jsonRichiesta.get("rangeorario")%>" name="<portlet:namespace/>rangeOrarioDisponibile"/>
                                         <input type="hidden" value="<%=jsonRichiesta.get("nome").toString().toUpperCase()%>" name="<portlet:namespace/>salaDisponibile"/>
                                         <div class="wrapper-servizi-aule item-pagination">
                                             <a href="<%=vaiAInserimentoUrl%>" title="aule" class="box-aule mt-30-xs text-center" onclick="submitFormDettaglio(event,'<%=i%>','<%=jsonRichiesta.get("stato").toString()%>')">
                                                 <div class="ama-row">
                                                     <div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-12 border-right">
                                                         <p class="reservations">
                                                             <span class="ico-reservations icomoon-calendar-date mr-10-xs"></span>
                                                             <%=jsonRichiesta.get("data")%>
                                                         </p>
                                                     </div>
                                                     <div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-12 mb-30-xs mb-0-md border-right">
                                                         <p class="reservations">
                                                             <span class="ico-reservations icomoon-time mr-10-xs"></span>
                                                             <%=jsonRichiesta.get("rangeorario")%>
                                                         </p>
                                                     </div>
                                                     <div class="ama-col-md-5 ama-col-sm-12 ama-col-xs-12 border-right">
                                                         <div class="wrap-classrooms mb-30-xs mb-0-md">
                                                             <p class="position-classrooms"><%=jsonRichiesta.get("nome").toString().toUpperCase()%></p>
                                                             <p class="text-box"><span class="ico icomoon-pin-white-bold"></span><%=jsonRichiesta.get("sede").toString().toUpperCase()%></p>
                                                         </div>
                                                     </div>
                                                     <div class="ama-col-md-1 ama-col-xs-6 border-right">
                                                         <span class="icon icomoon-posti"></span>
                                                         <p class="number-posti"><%=jsonRichiesta.get("numeroposti")%> Posti</p>
                                                     </div>
                                                     <div class="ama-col-md-2 ama-col-xs-6">
                                                         <c:if test="<%=jsonRichiesta.get("stato").toString().equalsIgnoreCase("disponibile")%>">
                                                         <span class="icon-violet icomoon-unlocked"></span>
                                                         </c:if>
                                                         <c:if test="<%=jsonRichiesta.get("stato").toString().equalsIgnoreCase("prenotata")%>">
                                                         <span class="icon-violet icomoon-lock"></span>
                                                         </c:if>
                                                         <c:if test="<%=jsonRichiesta.get("stato").toString().equalsIgnoreCase("da approvare")%>">
                                                         <span class="icon-violet icomoon-hourglass"></span>
                                                         </c:if>
                                                         <p class="type"><%=jsonRichiesta.get("stato").toString().toUpperCase()%></p>
                                                     </div>
                                                 </div>
                                             </a>
                                             <c:if test="<%=jsonRichiesta.get("stato").toString().equalsIgnoreCase("prenotata")%>">
                                             <div class="ama-row">
                                                 <div class="ama-col-xs-12">
                                                     <span class="ico-information icomoon-vedi-dark"></span>
                                                     <div class="collapse-aule animated fadeIn">
                                                         <div class="ama-row">
                                                             <div class="ama-col-md-5">
                                                                 <p class="text-collapse-info mb-20-xs mb-0-md">
                                                                     <liferay-ui:message key="prenotazione-ricerca-sala-prenotata-da"/>:
                                                                     <span class="text-bold ml-10-xs dot-point dot-mobile dot-20"><%=jsonRichiesta.getString("utenterichiedente").toUpperCase()%></span>
                                                                 </p>
                                                             </div>
                                                             <div class="ama-col-md-4">
                                                                 <p class="text-collapse-info mb-20-xs mb-0-md">
                                                                     <span class="ico-collapse icomoon-send-mail mr-10-xs dot-point dot-mobile dot-20"></span><%=jsonRichiesta.get("utenteemailrichiedente")%>
                                                                 </p>
                                                             </div>
                                                             <div class="ama-col-md-3">
                                                                 <p class="text-collapse-info">
                                                                 <c:if test="<%=jsonRichiesta.get("telefonorichiedente")!=null%>">
                                                                     <span class="ico-collapse icomoon-phone-call mr-10-xs"></span><%=jsonRichiesta.get("telefonorichiedente")%>
                                                                 </c:if>
                                                                 </p>
                                                             </div>
                                                         </div>
                                                     </div>
                                                 </div>
                                             </div>
                                             </c:if>
                                         </div>
                                         
                                         </form>
                                         <%} %>

                                         <div class="ama-row">
                                             <div class="ama-col-xs-12 text-align-center">
                                                 <div data-totpage="5" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
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
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
	</c:if>
</div>

<script>
var autorizzazione = '<%=autorizzazione%>';

 if (autorizzazione=="false") {
	 $("#btnStatoDaApprovare").attr("style", "display: none;");
 }

 $('.icomoon-close-white').on('click',function(){
	 window.location.href =  window.location.href.split('?')[0];
 });

 var checkCategory = function(){
	 $(".box-aule").each(function() {	
			if ($(this).is(".active")){
				 var input = document.createElement("input");				    
			     $(input).attr("type", 'hidden');				  
			     $(input).attr("name", '<portlet:namespace/>stato_richiesta');
		         $(input).val($(this).children()[2].value);				  
				 $(this).append(input);
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
	 $('#argument').val("");
	 $('#date').val("<%=new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime())%>");
	 $('#start').val("");
	 $('#end').val("");
	 $(".box-aule").each(function() {	
		 if ($(this).is(".active")){
			 $(this).removeClass("active"); 
		 }
		 }
	 );
 }
 
 function submitForm(){
	checkCategory();
 	$('#ricercaAuleForm').submit();	
 }
 
 function submitFormDettaglio(event,index,stato){
	 event.preventDefault();
	 if(stato=="disponibile") {
	 $('#formSingleItem'+index).submit();
	 }
}

</script>