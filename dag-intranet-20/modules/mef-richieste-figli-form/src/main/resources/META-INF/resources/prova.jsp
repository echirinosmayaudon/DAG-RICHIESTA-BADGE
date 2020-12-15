	<%@page import="com.liferay.portal.kernel.model.User"%>
	<%@ include file="/init.jsp" %>
	<%@page import="com.liferay.portal.kernel.log.Log"%>
	<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
	<%@page import="com.liferay.portal.kernel.util.Validator" %>
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.ArrayList" %>
	<%@page import="mef.richieste.figli.model.RICHIESTA_RIMBORSO" %>
	<%@page import="mef.richieste.figli.service.RICHIESTA_RIMBORSOLocalServiceUtil" %>
	<%@ page import="java.util.ArrayList" %>
	
	<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil" %>

	<%
	String displayAllegato ="display:none";
	String displayNoAllegato="display:block";

	Long id = CounterLocalServiceUtil.increment(RICHIESTA_RIMBORSO.class.getName());
	RICHIESTA_RIMBORSO richiestaRimborso = RICHIESTA_RIMBORSOLocalServiceUtil.createRICHIESTA_RIMBORSO(id);


	List<RICHIESTA_RIMBORSO> listRichiesta = new ArrayList<RICHIESTA_RIMBORSO>();

	listRichiesta.add(richiestaRimborso);
	if(listRichiesta  == null){
		listRichiesta.add( RICHIESTA_RIMBORSOLocalServiceUtil.createRICHIESTA_RIMBORSO(-1l));
	}
	System.out.println("lista richiesta= "+ listRichiesta);

	%>






	<c:choose>
	<c:when test="${!empty utente}">

	<%User utente = (User) request.getAttribute("utente"); %>

	<div class="background-title-box detail-page-item">
			<div class="ama-container-fluid">
				<div class="page-title-wrapper">
					<div class="title-wrapper-section"></div>
					<div class="ama-col-md-4 ama-col-xs-12">
					  <a href="${linkInterno}" title="${CTALabel}" class="button button-primary" target="_self">LINK
						<span class="icomoon-plus icon-beni"></span>
					  </a>
					</div>
				</div>
					   
				<h2 class="title">Titolo</h2>
					<p class="subtitle">Descrizione</p>
			</div>
	</div>

	<div class="ama-container-fluid">
		
		<portlet:actionURL name="salvaRimborso" var="salvaRimborsoURL" />

	<aui:container cssClass="container-esperienzaKA">

	  <h2 class="margin-bottom-20 titolo progetti-etwinning-title">
	   <liferay-ui:message key="esperienzaKA-title" />
	  </h2>
	  <aui:form action="${salvaEsperienzaKACandidaturaURL}" method="post" name="formRichiesta">
		<div class="ama-row">
			<div class="ama-col-xs-12">
			
			
				<div class="ama-row">
					<div class="ama-col-md-12">
						<div class="wrapper-title-small">
							<h2 class="title-box borders"><liferay-ui:message key="trasporti-richiesta-rimborso"/></h2>
						</div>
					</div>
				</div>

				<div class="ama-row">
					<div class="ama-col-xs-12">
						<span class="title-general-trasporti mb-40-xs"><liferay-ui:message key="trasporti-richiede-rimborso"/></span>
					</div>
				</div>
		 <aui:container cssClass="esperienzaKA1">
		  <c:forEach items="<%=listRichiesta %>" var="item" varStatus="counter">
		   <aui:row cssClass="block-item">
			<div class="wrapper-istanza-trasporti">
						<div class="box-gray no-margin">
							<div class="box-white box-gray-mobile">
								<p class="name-section"><liferay-ui:message key="trasporti-dati-rimborso"/></p>
								
								<%-- <aui:input type="hidden" name="NomeUtente" value="<%=utente.getFirstName()%>" />
								<aui:input type="hidden" name="CognomeUtente" value="<%=utente.getLastName()%>" />
								<aui:input type="hidden" name="CFUtente" value="<%=utente.getScreenName()%>" />
								<aui:input type="hidden" name="TelefonoUtente" value="<%=utente.getPhones()%>" /> --%>
								
									<div class="ama-row">
										
										<div class="ama-col-md-6 ama-col-xs-12">
											<label for="argument" class="label-form "><liferay-ui:message key="trasporti-nome-figlio"/>*</label>
											<input required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
											id="<portlet:namespace/>argumentNomeFiglio"  name="<portlet:namespace/>NomeFiglio[${counter.index}]" 
											class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key="trasporti-nome-figlio-placeholder"/>" value="">
										</div>
										
										<div class="ama-col-md-6 ama-col-xs-12">
											<label for="argument2" class="label-form "><liferay-ui:message key="trasporti-cognome-figlio"/>*</label>
											<input required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
											id="<portlet:namespace/>argumentCognomeFiglio" name="<portlet:namespace/>CognomeFiglio[${counter.index}]" 
											class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key="trasporti-cognome-figlio-placeholder"/>" value="${moduloRichiedente.getNomeFiglio()}">
										</div>
										
									</div>
		
									<div class="ama-row">
									
										<div class="ama-col-md-3 ama-col-xs-12">
											<label for="argument3" class="label-form margin-top "><liferay-ui:message key="trasporti-codice-fiscale-figlio"/>*</label>
											<input style="text-transform:uppercase" type="text" required="true" required-message="<liferay-ui:message key="error-mandatory"/>" 
											 pattern-message="<liferay-ui:message key="error-syntactic"/>"pattern="^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$"
											id="<portlet:namespace/>argumentCFfiglio"  name="<portlet:namespace/>CFFiglio[${counter.index}]" 
											class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key="trasporti-codice-fiscale-figlio-placeholder"/>" value="" >
										</div>
										
										
										<div class="ama-col-md-3 ama-col-xs-12">
											<label class="label-form margin-top"><liferay-ui:message key="trasporti-data-nascita-figlio"/>*</label>
											<input
											id="<portlet:namespace/>dataNascitaFiglio"
											required="true" required-message="<liferay-ui:message key="error-mandatory"/>"  
											name="<portlet:namespace/>DataNascitaFiglio[${counter.index}]"
											class="input-custom-light datepicker-custom removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-data-nascita'/>" 
											value="">
										</div>
										
										<div class="ama-col-md-6 ama-col-xs-12">
											<label for="<portlet:namespace/>LuogoNascitaFiglio" class="label-form margin-top"><liferay-ui:message key="trasporti-luogo-nascita-figlio"/>*</label>
											<input  
											 id="<portlet:namespace/>LuogoNascitaFiglio"
											 required="true" required-message='<liferay-ui:message key="error-mandatory"/>'  
											 name="<portlet:namespace/>LuogoNascitaFiglio[${counter.index}]" class="input-custom-light data-parsley-validated removeFieldFormTrasporti"  
											 value="" placeholder="<liferay-ui:message key="trasporti-luogo-nascita-figlio-placeholder"/>">
										</div>
						
									</div>
									
									
									<p class="name-section"><liferay-ui:message key="trasporti-dati-rimborso"/></p>
									
									<div class="ama-row">
									
										<div class="ama-col-md-6 ama-col-xs-12">
											<label for="argument6" class="label-form "><liferay-ui:message key="trasporti-iban"/>*
												<a  title='<liferay-ui:message key="trasporti-info-iban"/>' class="tooltip-field icon-information">
													<span class="icomoon-info ico-info-tooltip"></span>
												</a>
											</label>
											<input required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
											pattern="[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}"
											pattern-message="<liferay-ui:message key="error-syntactic"/>"
											id="<portlet:namespace/>argumentIbanFiglio" name="<portlet:namespace/>Iban[${counter.index}]" 
											class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-data-iban'/>"
											value="">
										</div>
										
										<div class="ama-col-md-6 ama-col-xs-12">
											<label for="argument7" class="label-form mt-25-xs mt-0-md"><liferay-ui:message key="trasporti-importo-rimborso-spese"/>*</label>
											<input required="true" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
											data-parsley-pattern="^[1-9][0-9]{0,2}(?:\.?[0-9]{3}){0,3}(,[0-9]{2})?$" 
											data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
											id="<portlet:namespace/>argumentImportoFiglio" name="<portlet:namespace/>Importo[${counter.index}]" 
											class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-import-figlio'/>"
											value="">
										</div>
										
									</div>
									
									<div class="ama-row"> 
										<div class="ama-col-md-12 ama-col-xs-12 data-parsley-validated">
											<div class="wrapper-content-textarea">
												<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="trasporti-descrizione"/></label>
												<textarea 
													data-parsley-maxlength="500" 
													data-parsley-minlength="10" 
													data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>" 
													data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
													data-parsley-validation-threshold="10"
													name="<portlet:namespace/>NoteRimborso[${counter.index}]"
													class="form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti" id="<portlet:namespace/>textarea-detail" 
													placeholder="<liferay-ui:message key='trasporti-insert-placeholder-descrizione'/>">
												</textarea>
													<div class="content-textarea" >
														0/<p class="color-gray">500</p>
													</div>
											</div>
										</div>
									</div>
										
									
									
									
									
									
								
								</div>
								<!-- bottone ADD  -->
								<aui:col md="1">        
								   <c:choose>
									 <c:when test="${counter.index == 0}">
										<aui:button-row cssClass="button-controls">
										 <aui:button value="Delete"cssClass="fa fa-redo btn-clean" title="Pulisci campi" onClick="formCandidatura.cleanContainer('esperienzaKA1', ${counter.index}, 'formRichiesta','listRichiesta')" />
										 <aui:button value="Add" cssClass="fa fa-plus btn-add-clone btn btn-success font-20" title="Aggiungi" onClick="cloneEsperienzaKA('esperienzaKA1','formRichiesta',5,'Superato il limite massimo di 2 progetti da aggiungere per cui ha partecipato nel periodo 2014-2020')" />
										</aui:button-row>
										</c:when>
										<c:otherwise>
											   <aui:button-row cssClass="button-controls">
												<aui:button cssClass="fa fa-trash-alt remove-clone btn btn-danger" title="Elimina" onClick="formCandidatura.removeBlockClone(this,'esperienzaKA1', event, true)" />
											   </aui:button-row>
										 </c:otherwise>
									</c:choose>
								 </aui:col>
								</div>	
								
		
							</div>
		   </aui:row>
		  </c:forEach>
		 </aui:container>

	   </div>
	   </div>
	  </aui:form>
	  </aui:container>
	  </div>
	</c:when>
	<c:otherwise>
		<h1>Utente non loggato</h1>
	</c:otherwise>
	</c:choose>
	  
	  
	<script>
	var cloneEsperienzaKA = function(containerCloneBlock, formId, maxElement,
			messagekey) {

		var cloneBlock = formCandidatura.cloneElementNew(containerCloneBlock,
				maxElement, '<portlet:namespace/>', formId);

		if (cloneBlock) {

			var indexNewBlock = formCandidatura
					.getIndexClone(containerCloneBlock);

			cloneBlock.find("input.input-ordine").val(indexNewBlock);
			$("." + containerCloneBlock).append(cloneBlock);

			//$("#panel-esperienzaKA1-container").addClass("changed-clone"); 

		} else {
			formCandidatura.alert(null, null, messagekey, null);
			
			
		}
	};
	</script>