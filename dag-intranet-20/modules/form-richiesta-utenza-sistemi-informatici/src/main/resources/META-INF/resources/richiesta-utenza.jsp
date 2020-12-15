<%@page
	import="form.richiesta.utenza.sistemi.informatici.beans.RichiestaUtenzaBean"%>

<%

RichiestaUtenzaBean richiedente = new RichiestaUtenzaBean();

if(request.getAttribute("richiedente")!=null)
		richiedente = (RichiestaUtenzaBean)request.getAttribute("richiedente");
String utenza = (String)request.getAttribute("utenza");
String assetPc = (String)request.getAttribute("assetPc");
String applicazione = (String)request.getAttribute("applicazione");
String cambioUfficio = (String)request.getAttribute("cambioUfficio");
String resetPassword = (String)request.getAttribute("resetPassword");



%>


<c:set value="<%=richiedente%>" var="richiedente"></c:set>
<c:set value="<%=utenza%>" var="utenza"></c:set>
<c:set value="<%=applicazione%>" var="applicazione"></c:set>
<c:set value="<%=cambioUfficio%>" var="cambioUfficio"></c:set>
<c:set value="<%=resetPassword%>" var="resetPassword"></c:set>
<c:set value="<%=assetPc%>" var="assetPc"></c:set>

<div class="trasporti-header">
	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<div class="title-wrapper">
					<h2 class="title"><%=formTitle%>
					</h2>
					<p class="subtitle dot-point dot-200"><%=formSubtitle%></p>
				</div>
			</div>
		</div>
	</div>
</div>


<portlet:actionURL name="recapRichiestaUtenza"
	var="recapRichiestaUtenzaURL" />

<form data-parsley-validate="true" id="<portlet:namespace/>utenzaForm"
	action="<%= recapRichiestaUtenzaURL %>" method="post" enctype="multipart/form-data">
	<div class="ama-container-fluid">

		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richesteutenza-dati-richiedente" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">

			<div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
				<label for="argument" class="label-form"><liferay-ui:message
						key="label-richesteutenza-ufficio-richiedente" />*</label>
					<c:if test="${richiedente.getUfficioRichiedente() != null}">	 
						<input data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						type="text" class="input-custom-light data-parsley-validated"
						placeholder="<liferay-ui:message key="label-richesteutenza-nome-ufficio-richiedente"/>"
						name="<portlet:namespace/>ufficioRichiedente"
						value="${richiedente.getUfficioRichiedente()}">
					</c:if>
					<c:if test="${richiedente.getUfficioRichiedente() == null}">	 
						<input data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						type="text" class="input-custom-light data-parsley-validated"
						placeholder="<liferay-ui:message key="label-richesteutenza-nome-ufficio-richiedente"/>"
						name="<portlet:namespace/>ufficioRichiedente">
					</c:if>
					
			</div>
			<div class="ama-col-xs-12 mb-25-xs">
				<div class="ama-row">
					<div class="ama-col-sm-6 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-nome" />*</label> 
							<c:if test="${richiedente.getNome() != null}">	
								<input 	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								type="text" class="input-custom-light data-parsley-validated"
								placeholder="<liferay-ui:message key="label-richesteutenza-dati-nome"/>"
								name="<portlet:namespace/>nome" value="${richiedente.getNome()}">
							</c:if>
							<c:if test="${richiedente.getNome() == null}">	
								<input 	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								type="text" class="input-custom-light data-parsley-validated"
								placeholder="<liferay-ui:message key="label-richesteutenza-dati-nome"/>"
								name="<portlet:namespace/>nome">
							</c:if>

					</div>
					<div class="ama-col-sm-6 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-cognome" />*</label>
								<c:if test="${richiedente.getCognome() != null}">	 
									<input 	data-parsley-required="true"
									data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									type="text" class="input-custom-light data-parsley-validated"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-cognome"/>"
									name="<portlet:namespace/>cognome"
									value="${richiedente.getCognome()}">
								</c:if>
								<c:if test="${richiedente.getCognome() == null}">	 
									<input 	data-parsley-required="true"
									data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									type="text" class="input-custom-light data-parsley-validated"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-cognome"/>"
									name="<portlet:namespace/>cognome">
								</c:if>
						
					</div>
				</div>
			</div>
			<div class="ama-col-xs-12 mb-25-xs">
				<div class="ama-row">
					<div class="ama-col-sm-4 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-ubicazione" /></label>
						<c:if test="${richiedente.getUbicazione() != null}">			
							<input type="text" class="input-custom-light "
							placeholder="<liferay-ui:message key="label-richesteutenza-dati-ubicazione"/>"
							name="<portlet:namespace/>ubicazioneAttuale"
							value="${richiedente.getUbicazione()}">
						</c:if>
						<c:if test="${richiedente.getUbicazione() == null}">			
							<input type="text" class="input-custom-light "
							placeholder="<liferay-ui:message key="label-richesteutenza-dati-ubicazione"/>"
							name="<portlet:namespace/>ubicazioneAttuale">
						</c:if>
					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-palazzina" /></label> 
								<c:if test="${richiedente.getPalazzina() != null}">
									<input type="text" class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-palazzina"/>"
									name="<portlet:namespace/>palazzina"
									value="${richiedente.getPalazzina()}">
								</c:if>
								<c:if test="${richiedente.getPalazzina() == null}">
									<input type="text" class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-palazzina"/>"
									name="<portlet:namespace/>palazzina">
								</c:if>
							
					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-piano" /></label> 
								<c:if test="${richiedente.getPiano() != null}">
									<input type="text" 		class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-piano"/>"
									name="<portlet:namespace/>piano"
									value="${richiedente.getPiano()}">
								</c:if>
								<c:if test="${richiedente.getPiano() == null}">
									<input type="text" 		class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-piano"/>"
									name="<portlet:namespace/>piano">
								</c:if>
					
					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-scala" /></label>
								<c:if test="${richiedente.getScala() != null}">
									<input type="text" class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-scala"/>"
									name="<portlet:namespace/>scala"
									value="${richiedente.getScala()}">
								</c:if>
								<c:if test="${richiedente.getScala() == null}">
									<input type="text" class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-scala"/>"
									name="<portlet:namespace/>scala">
								</c:if>
						
					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-stanza" /></label>
								<c:if test="${richiedente.getStanza() != null}">
									<input type="text" 	class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-stanza"/>"
									name="<portlet:namespace/>stanza"
									value="${richiedente.getStanza()}">
								</c:if>
								<c:if test="${richiedente.getStanza() == null}">
									<input type="text" 	class="input-custom-light"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-stanza"/>"
									name="<portlet:namespace/>stanza">
								</c:if>
						
					</div>
				</div>
			</div>
			<div class="ama-col-xs-12">
				<div class="ama-row">
					<div class="ama-col-sm-6 ama-col--xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-telefono" /></label> 
								<c:if test="${richiedente.getTelefono() != null}">
									<input type="text" class="input-custom-light data-parsley-validated"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-telefono"/>"
									data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
									data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
									name="<portlet:namespace/>telefono"
									value="${richiedente.getTelefono()}">
								</c:if>
								<c:if test="${richiedente.getTelefono() == null}">
									<input type="text" class="input-custom-light data-parsley-validated"
									placeholder="<liferay-ui:message key="label-richesteutenza-dati-telefono"/>"
									data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
									data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
									name="<portlet:namespace/>telefono">
								</c:if>
							
					</div>
					<div class="ama-col-sm-6 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-email-dirigente" />*</label>
							<c:if test="${richiedente.getEmailDirigente() != null}">	
								<input type="text" class="input-custom-light data-parsley-validated"
								placeholder="<liferay-ui:message key="label-richesteutenza-dati-email-dirigente"/>"
								name="<portlet:namespace/>emailDirigente" data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-type="email"
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
								value="${richiedente.getEmailDirigente()}">
							</c:if>
							<c:if test="${richiedente.getEmailDirigente() == null}">	
								<input type="text" class="input-custom-light data-parsley-validated"
								placeholder="<liferay-ui:message key="label-richesteutenza-dati-email-dirigente"/>"
								name="<portlet:namespace/>emailDirigente" data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-type="email"
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
								>
							</c:if>
							
					</div>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message
							key="label-richesteutenza-dati-richiesta-applicazioni" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 ama-col-md-3 mb-25-xs">
				<label class="label-form"><liferay-ui:message
						key="label-richesteutenza-dati-asset-pc" />*</label> <input
					data-parsley-required="true"
					data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					type="text" class="input-custom-light data-parsley-validated"
					placeholder="<liferay-ui:message key="label-richesteutenza-dati-inserisci-asset-pc"/>"
					name="<portlet:namespace/>assetPc" value="${assetPc}">
			</div>
			<div class="ama-col-xs-12 ama-col-md-3 mb-25-xs">
				<label class="label-form"><liferay-ui:message
						key="label-richesteutenza-dati-applicazione" />*</label> <input
					data-parsley-required="true"
					data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					type="text" class="input-custom-light data-parsley-validated"
					placeholder="<liferay-ui:message key="label-richesteutenza-dati-inserisci-applicazione"/>"
					name="<portlet:namespace/>applicazione" value="${applicazione}">
			</div>
			<div class="ama-col-xs-12 ama-col-md-3 mb-25-xs">
				<label class="label-form"><liferay-ui:message
						key="label-richesteutenza-dati-codice-fiscale" />*</label> <input
					data-parsley-required="true"
					data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/"
					data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
					type="text" class="input-custom-light data-parsley-validated"
					placeholder="<liferay-ui:message key="label-richesteutenza-dati-inserisci-codice-fiscale"/>"
					name="<portlet:namespace/>codiceFiscale"
					value="${richiedente.getCodFiscale()}">
			</div>
			<div class="ama-col-xs-12 ama-col-md-3 mb-25-xs">

				<c:if test="${utenza == 1}">
					<label class="label-form"><liferay-ui:message
							key="label-richesteutenza-dati-utenza" />*</label>
					<div class="box-radio-custom mt-10-xs mt-0-md">
						<input checked id="radio1" name="<portlet:namespace/>utenza"
							value="1" type="radio" class="radio-custom-dark"> <label
							for="radio1" class="radio-custom-desc"> <span><liferay-ui:message
									key="label-richesteutenza-dati-utenza-nuova" /></span>
						</label>
					</div>
					<div class="box-radio-custom mt-10-xs mt-0-md ml-10-xs">
						<input id="radio2" name="<portlet:namespace/>utenza" value="2"
							type="radio" class="radio-custom-dark"> <label
							for="radio2" class="radio-custom-desc"> <span><liferay-ui:message
									key="label-richesteutenza-dati-utenza-disabilita" /></span>
						</label>
					</div>
				</c:if>
				<c:if test="${utenza == 2}">
					<label class="label-form"><liferay-ui:message
							key="label-richesteutenza-dati-utenza" />*</label>
					<div class="box-radio-custom mt-10-xs mt-0-md">
						<input id="radio1" name="<portlet:namespace/>utenza" value="1"
							type="radio" class="radio-custom-dark"> <label
							for="radio1" class="radio-custom-desc"> <span><liferay-ui:message
									key="label-richesteutenza-dati-utenza-nuova" /></span>
						</label>
					</div>
					<div class="box-radio-custom mt-10-xs mt-0-md ml-10-xs">
						<input checked id="radio2" name="<portlet:namespace/>utenza"
							value="2" type="radio" class="radio-custom-dark"> <label
							for="radio2" class="radio-custom-desc"> <span><liferay-ui:message
									key="label-richesteutenza-dati-utenza-disabilita" /></span>
						</label>
					</div>
				</c:if>
			</div>
			<div class="ama-col-xs-12">
				<div class="ama-row">
					<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
						<label class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-cambio-ufficio" /></label> <input
							type="text" class="input-custom-light"
							placeholder="<liferay-ui:message key="label-richesteutenza-dati-inserisci-cambio-ufficio"/>"
							name="<portlet:namespace/>cambioUfficio" value="${cambioUfficio}">
					</div>
					<div class="ama-col-sm-6 ama-col-xs-12 mb-25-xs">
						<label class="label-form"><liferay-ui:message
								key="label-richesteutenza-dati-reset-password" /></label> <input
							type="text" class="input-custom-light"
							name="<portlet:namespace/>resetPassword" value="${resetPassword}">
					</div>
				</div>
			</div>

			<div class="ama-col-xs-12 text-center mb-100-xs mt-50-xs">
				<button class="button button-primary"
					id="<portlet:namespace/>prosegui">
					<liferay-ui:message key="label-richesteutenza-option-prosegui" />
				</button>
			</div>



		</div>
	</div>
</form>

<script>
 $("#<portlet:namespace/>prosegui").click("on",function(){
	 $("#<portlet:namespace/>utenzaForm").parsley().validate();
	 if ( $("#<portlet:namespace/>utenzaForm").parsley().isValid()){
	 	 $("#<portlet:namespace/>utenzaForm").submit();

	 }
 });
 
 </script>