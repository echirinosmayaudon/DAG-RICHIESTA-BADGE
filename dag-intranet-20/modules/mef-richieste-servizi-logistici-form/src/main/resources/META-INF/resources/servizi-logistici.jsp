<%@page import="com.intranet.mef.bean.Richiedente"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%@page import="service.intranet.mef.model.LogisticaServizio"%>
<%@page import="java.util.List"%>

<% 
Richiedente richiedente;
int countService =0;
if(request.getAttribute("richiedente")!=null){
	richiedente = (Richiedente)request.getAttribute("richiedente");


  	Date startD = new Date();
  	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
  	String today=format.format(startD);

	List<LogisticaServizio> servizi = (List<LogisticaServizio>) request.getAttribute("servizi");

 %>
<portlet:actionURL name="insertServizio" var="insertServizio"></portlet:actionURL>
<portlet:actionURL name="gotoElenco" var="gotoElenco"></portlet:actionURL>

    <form action="<%=gotoElenco%>" method="post" id="<portlet:namespace/>formElencoServizio" enctype="multipart/form-data" ></form>
     
	 <div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=serviziLogisticititle%> </h2>
                         <a class="icomoon-star title-star btn-star-bookmarks star mr-20-xs">
                             <span class="sr-only"><liferay-ui:message key="add-to-favourite" /></span>
                         </a>
                             <div class="wrap-icon-title mobile-search">
                                 <a href="#" id="serviziLogisticiElenco" title="elenco richieste" class="icon icomoon-user2"></a>
                             </div>
     
                         <p class="subtitle dot-point dot-200"><%=serviziLogisticitxt%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>

     <div class="ama-container-fluid">
         
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay-ui:message key="servizi-logistici-dati-richiedente" /></h2>
                 </div>
             </div>
         </div>
         <div class="ama-row">
             <form action="<%=insertServizio%>" method="post" id="<portlet:namespace/>formServizioLogistico" data-parsley-validate="true" enctype="multipart/form-data" >
                <div class="ama-col-xs-12 mb-25-md">
                     <div class="ama-row">
					    <div class="ama-col-sm-6 ama-col-xs-12">
							<label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-organizzazione" />*</label>
						 <c:if test="${richiedente.getOrganizzazione() != null}">
							 <input id="<portlet:namespace/>organizzazione" 
							 type="text" class="input-custom-light data-parsley-validated"
							 value="<%=richiedente.getOrganizzazione()%>"
							 name="<portlet:namespace/>organizzazione"
							 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'  readonly>
						 </c:if>
						   <c:if test="${richiedente.getOrganizzazione() == null}">
							 <input id="<portlet:namespace/>organizzazione" 
							 type="text" class="input-custom-light data-parsley-validated"
							 name="<portlet:namespace/>organizzazione"
							 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' >
						 </c:if>
											  </div>
					 
                         <div class="ama-col-sm-6 ama-col-xs-12">

					 <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-ufficio-richiedente" />*</label>
						 <c:if test="${richiedente.getUfficioRichiedente() != null}">
							 <input id="IntUfficioRichiedente" 
							 type="text" class="input-custom-light data-parsley-validated"
							 value="<%=richiedente.getUfficioRichiedente()%>"
							 name="<portlet:namespace/>ufficioRichiedente"
							 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' readonly>
						 </c:if>
						   <c:if test="${richiedente.getUfficioRichiedente() == null}">
							 <input id="IntUfficioRichiedente" 
							 type="text" class="input-custom-light data-parsley-validated"
							 name="<portlet:namespace/>ufficioRichiedente"
							 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' >
						 </c:if>
						 </div>
						 
					 </div>
                 </div>
                 <div class="ama-col-xs-12 mb-25-md">
                     <div class="ama-row">
                         <div class="ama-col-sm-6 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-nome-richiedente" />*</label>
                             <c:if test="${richiedente.getNome() != null}">
	                             <input id="IntNomeRich" type="text" 
								 class="input-custom-light data-parsley-validated" 
								 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
								 value="<%=richiedente.getNome()%>" name="<portlet:namespace/>nome" readonly>
							 </c:if>
							 <c:if test="${richiedente.getNome() == null}">
	                             <input id="IntNomeRich" type="text" 
								 class="input-custom-light data-parsley-validated" 
								 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
								 name="<portlet:namespace/>nome">
							 </c:if>
                         </div>
                         <div class="ama-col-sm-6 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-cognome-richiedente" />*</label>
                              <c:if test="${richiedente.getCognome() != null}">
	                             <input id="IntCognomeRich" type="text" class="input-custom-light data-parsley-validated" 
								 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' value="<%=richiedente.getCognome()%>" name="<portlet:namespace/>cognome" readonly>
							 </c:if>
							  <c:if test="${richiedente.getCognome() == null}">
	                             <input id="IntCognomeRich" type="text" class="input-custom-light data-parsley-validated" 
								 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'  name="<portlet:namespace/>cognome">
							 </c:if>
                         </div>
                     </div>
                 </div>
                 <div class="ama-col-xs-12 mb-25-md">
                     <div class="ama-row">
                         <div class="ama-col-sm-4 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-ubicazione-richiedente" /></label>
                             <c:if test="${richiedente.getUbicazione() != null}">
                             	<input id="IntUbicazioneAttuale" type="text" class="input-custom-light" value="<%=richiedente.getUbicazione()%>" name="<portlet:namespace/>ubicazione" readonly>
                             </c:if>
                             <c:if test="${richiedente.getUbicazione() == null}">
                             	<input id="IntUbicazioneAttuale" type="text" class="input-custom-light"  name="<portlet:namespace/>ubicazione">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-palazzina" /></label>
                             <c:if test="${richiedente.getPalazzina() != null}">
                             	<input id="IntPalazzina" type="text" class="input-custom-light" value="<%=richiedente.getPalazzina()%>" name="<portlet:namespace/>palazzina">
                             </c:if>
                             <c:if test="${richiedente.getPalazzina() == null}">
                             	<input id="IntPalazzina" type="text" class="input-custom-light"  name="<portlet:namespace/>palazzina">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-piano" /></label>
                             <c:if test="${richiedente.getPiano() != null}">
                             	<input id="IntPiano" type="text" class="input-custom-light" value="<%=richiedente.getPiano()%>" name="<portlet:namespace/>piano">
                             </c:if>
                              <c:if test="${richiedente.getPiano() == null}">
                             	<input id="IntPiano" type="text" class="input-custom-light"  name="<portlet:namespace/>piano">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-scala" /></label>
                             <c:if test="${richiedente.getScala() != null}">
                             	<input id="IntScala" type="text" class="input-custom-light" value="<%=richiedente.getScala()%>" name="<portlet:namespace/>scala">
                             </c:if>
                             <c:if test="${richiedente.getScala() == null}">
                             	<input id="IntScala" type="text" class="input-custom-light"  name="<portlet:namespace/>scala">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-stanza" /></label>
                             <c:if test="${richiedente.getStanza() != null}">
                             	<input id="IntStanza" type="text" class="input-custom-light" value="<%=richiedente.getStanza()%>" name="<portlet:namespace/>stanza">
                             </c:if>
                             <c:if test="${richiedente.getStanza() == null}">
                             	<input id="IntStanza" type="text" class="input-custom-light"  name="<portlet:namespace/>stanza">
                             </c:if>
                         </div>
                     </div>
                 </div>
                 <div class="ama-col-xs-12">
                     <div class="ama-row">
                         <div class="ama-col-sm-6 ama-col--xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-telefono" /></label>
                              <c:if test="${richiedente.getTelefono() != null}">
	                              <input id="IntTelephone" type="text" class="input-custom-light data-parsley-validated"
										    value="<%=richiedente.getTelefono()%>" name="<portlet:namespace/>telefono"
											data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
											data-parsley-maxlength="30"
											data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>">
							 </c:if>
                              <c:if test="${richiedente.getTelefono() == null}">
	                              <input id="IntTelephone" type="text" class="input-custom-light data-parsley-validated"
										    name="<portlet:namespace/>telefono"
											data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
											data-parsley-maxlength="30"
											data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>">
							 </c:if>
                             
                         </div>
                         <div class="ama-col-sm-6 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="servizi-logistici-email-richiedente" /></label>
                              <c:if test="${richiedente.getEmailRichiedente() != null}">
	                             <input id="IntEmailDirigente" type="text"                    
											data-parsley-type="email"
											data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"        
	                                		name="<portlet:namespace/>emailRichiedente" 
	                                		class="input-custom-light data-parsley-validated" value="<%=richiedente.getEmailRichiedente()%>" readonly>
                      		 </c:if>
                      		  <c:if test="${richiedente.getEmailRichiedente() == null}">
	                             <input id="IntEmailDirigente" type="text"                    
											data-parsley-type="email"
											data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"        
	                                		name="<portlet:namespace/>emailRichiedente" 
	                                		class="input-custom-light data-parsley-validated">
                      		 </c:if>
                             
                         </div>
                     </div>
                 </div>
                   <input type="hidden" name="<portlet:namespace/>emailDirigente" id="<portlet:namespace/>emailDirigente" value="${richiedente.getEmailDirigente()}">
                 <input type="hidden" name="<portlet:namespace/>oggettoRichiesta" id="<portlet:namespace/>oggettoRichiesta">
                 <input type="hidden" name="<portlet:namespace/>richiesteJson" id="<portlet:namespace/>richiesteJson">
				  <input type="hidden" name="<portlet:namespace/>note" id="<portlet:namespace/>note">

             </form>
         </div>                
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay-ui:message key="servizi-logistici-dati-richiesta" /></h2>
                 </div>
             </div>
         </div>
         <div class="wrapper-servizi-logistici">
             <form id="<portlet:namespace/>formService" data-parsley-validate="true" enctype="multipart/form-data" >
            <div class="ama-row" >
                     <div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12 mb-25-md">
                         <label for="<portlet:namespace/>oggetto" class="label-form "><liferay-ui:message key="servizi-logistici-oggetto-richiesta" />*</label>
                         <input id="<portlet:namespace/>oggetto" class="input-custom-light data-parsley-validated" 
							 data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' placeholder='<liferay-ui:message key="servizi-logistici-placeholder-oggetto-richiesta" />' >
                     </div>
                     <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
                         <label for="date" class="label-form "><liferay-ui:message key="servizi-logistici-data-richiesta" /></label>
                         <input disabled id="date" type="text" name="date" class="datepicker-custom input-custom-light" placeholder="DD/MM/AAAA"  name="<portlet:namespace/>Data" value="<%=today%>">
                     </div>
					<div class="col-xs-12">
                         <p class="title-form mb-20-xs mt-10-xs"><liferay-ui:message key="servizi-logistici-beni-richiesta" /></p>
					</div>
			</div>
			
		 	<div class="ama-row" id="<portlet:namespace/>divButtonRichiesta">

                     <div class="ama-col-xs-12 buttonRichiesta">
                         <div class="mt-30-xs mb-30-xs">
                             <button href="#" type="button" id="<portlet:namespace/>AddRichiesta" class="button button-primary">
                                 <span class="icomoon-plus icon mr-10-xs"></span><liferay-ui:message key="servizi-logistici-aggiungi-richiesta" />
                             </button>
                         </div>
                     </div>
         
                     <div class="ama-col-xs-12 mb-25-xs">
                         <div class="wrapper-content-textarea">
                             <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="servizi-logistici-descrizione-richiesta" /></label>
                             <textarea class="form-control textarea-custom-light" id="<portlet:namespace/>descrizione" placeholder='<liferay-ui:message key="servizi-logistici-placeholder-descrizione" />'></textarea>
                             <div class="content-textarea">0/
                                 <p class="color-gray">
                                     500
                                 </p>
                             </div>
                         </div>
                     </div>
                 </div>
             </form>
         </div>
          
         

         <div class="ama-row">
             <div class="ama-col-xs-12 text-center mb-100-sm mb-30-xs mt-50-sm mt-20-xs">
                 <button class="button button-primary" id="<portlet:namespace/>prosegui"><liferay-ui:message key="servizi-logistici-prosegui-richiesta" /></button>
             </div>
         </div>
     </div>
	 
	 

	 
	 
	 
	<div id="<portlet:namespace/>dynamicService" style="display:none">


                     <div class="col-xs-12">
                         <div class="wrap-serv-logistici mb-25-xs">
                             <span class="number numberServizioLogisticoClass"></span>
                             <div class="position-button">
                                 <button href="#" type="button" class=" button button-primary mt-0-xs removeServizioLogisticoClass">
                                     <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="servizi-logistici-rimuovi-button" /></button>
                             </div>
                         </div>
                     </div>
                 
                 
                     <div class=" ama-col-md-6 ama-col-xs-12">
                         <label id="<portlet:namespace/>servizioSelectLabel" for="<portlet:namespace/>servizioSelect" class="label-form"><liferay-ui:message key="servizi-logistici-servizio-richiesta" />*</label>
                         <select id="<portlet:namespace/>servizioSelect" class="option-select-notice">
                             <option value="" hidden><liferay-ui:message key="servizi-logistici-scelta-tipo-servizio" /></option>
								
							<c:forEach items='<%= servizi %>' var="servizio">
								<option value="${servizio.getDescrizione()}" >${servizio.getDescrizione()}</option>
							</c:forEach>
							

                         </select>
                     </div>
			</div>
	 
	

	 
<% }%>
	 <script>
	 
	 
	 var countService = "<%= countService %>";
	 var countServiceId = countService;

	 var idButtonAddRichiesta= "#<portlet:namespace/>AddRichiesta";
	 var idDynamicServiceNone="#<portlet:namespace/>dynamicService";
	 
	 var nameDivService = "<portlet:namespace/>service";
	 
	 var numberCountClass = ".numberServizioLogisticoClass";
	 var removeButtonClass = ".removeServizioLogisticoClass";
	 
	 var idElementInsertBefore ="#<portlet:namespace/>divButtonRichiesta";
	 var idFormSevice = "#<portlet:namespace/>formService";
	 
	 var idButtonProsegui="#<portlet:namespace/>prosegui";
	 
	 var nameServizioSelect ="<portlet:namespace/>servizioSelect";
	 var nameServizioSelectLabel ="<portlet:namespace/>servizioSelectLabel";


	 var idForm = "#<portlet:namespace/>formServizioLogistico";
	 
	 
	 
	var idOggetto = "#<portlet:namespace/>oggetto";
	var idOggettoHidden = "#<portlet:namespace/>oggettoRichiesta";
	var idJsonHidden = "#<portlet:namespace/>richiesteJson";
	var idNote = "#<portlet:namespace/>descrizione";
	var idNoteHidden ="#<portlet:namespace/>note";
	 
	 
	var idElenco = "#serviziLogisticiElenco";
	var idFormElenco = "#<portlet:namespace/>formElencoServizio";

	
	 
	 updateFormServizioLogistico();
	 
	 
	 function updateFormServizioLogistico(){
		 countService++;
		 countServiceId++;
		 
		 
			 var dynamicService = $(idDynamicServiceNone).html();
			 var divMaster = document.createElement("div");
			$(divMaster).attr("id",nameDivService+countServiceId);
			$(divMaster).addClass("ama-row");
			 
			 $(divMaster).append(dynamicService);

			$(divMaster).find(numberCountClass).html(countService);

			$(divMaster).find("#"+nameServizioSelect).attr("id",nameServizioSelect+countServiceId);
			
			
			$(divMaster).find("#"+nameServizioSelect+countServiceId).attr("data-parsley-required","true");
			$(divMaster).find("#"+nameServizioSelect+countServiceId).attr("data-parsley-required-message",'<liferay-ui:message key="error-mandatory"/>');
			$(divMaster).find("#"+nameServizioSelect+countServiceId).addClass("data-parsley-validated");

			
			$(divMaster).find("#"+nameServizioSelectLabel).attr("for",nameServizioSelect+countServiceId);
			$(divMaster).find("#"+nameServizioSelectLabel).attr("id",nameServizioSelectLabel+countServiceId);
			 
			 if (countService>1){
			$(divMaster).find(removeButtonClass).each(function(){
					$(this).click({index: countServiceId},function (event){						
					removeRichiesta(event.data.index);
					});						
				});
			 }else{
				 $(divMaster).find(removeButtonClass).remove();
				 
			 }

			 $( divMaster ).insertBefore(idElementInsertBefore ); 
			  
			
			
	 }
	 
	 
	  $(idElenco).click("on",function(){
		 event.preventDefault();
		$(idFormElenco).submit();
	 });
	 
	 $(idButtonAddRichiesta).click("on",function(){
		 event.preventDefault();
		$(idFormSevice).parsley().validate();
		
		if ($(idFormSevice).parsley().isValid())	 
			updateFormServizioLogistico();
	 });
	 
	 

	 
	 
	 
	 
	 
	 function removeRichiesta(index){
		 $(idFormSevice).find("#"+nameDivService+index).remove();
		countService--;
		
		var countNumber=1;
		$(idFormSevice).find(numberCountClass).each(function(){
			$(this).html(countNumber);
			countNumber++;
			
		});
		
		
		
		
	 }
	 
		
	
	 $(idButtonProsegui).click("on",function(){
		
		var jsonArray=[];
		
		$(idForm).parsley().validate();
		$(idFormSevice).parsley().validate();
		
		var flagValidate =  $(idForm).parsley().isValid() && $(idFormSevice).parsley().isValid();
		if (flagValidate){
			for(var i=1; i<=countServiceId; i++){
				if ($("#"+nameServizioSelect+i).length) {
					jsonArray.push({"servizio":$("#"+nameServizioSelect+i).val()});
				}
					
			}
			var jsonObj = {"richieste":jsonArray};
			
			$(idJsonHidden).val(JSON.stringify(jsonObj));
			$(idOggettoHidden).val($(idOggetto).val());
			$(idNoteHidden).val($(idNote).val());
			$(idForm).submit();
		}
	 });
	 
	 	
	
	 </script>

