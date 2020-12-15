<%@page import="java.util.List"%>
<%@page import="mef.richieste.interventi.beans.RichiestaInterventiBean"%>
<%@page import="service.intranet.mef.model.Asset"%>
<%@page import="service.intranet.mef.model.HardwareTecnici"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
	
	String json = (String) request.getAttribute("json");

	List<RichiestaInterventiBean> listAssetPc = (List<RichiestaInterventiBean>) request
			.getAttribute("listAssetPc");
	List<RichiestaInterventiBean> listSoftware = (List<RichiestaInterventiBean>) request
			.getAttribute("listSoftware");
	List<RichiestaInterventiBean> listHardware = (List<RichiestaInterventiBean>) request
			.getAttribute("listHardware");
	List<RichiestaInterventiBean> listPostaElectronica = (List<RichiestaInterventiBean>) request
			.getAttribute("listPostaElectronica");
	List<RichiestaInterventiBean> listCondivisioneStampanti = (List<RichiestaInterventiBean>) request
			.getAttribute("listCondivisioneStampanti");
	List<RichiestaInterventiBean> listCondivisioneDati = (List<RichiestaInterventiBean>) request
			.getAttribute("listCondivisioneDati");
	List<RichiestaInterventiBean> listAltro = (List<RichiestaInterventiBean>) request.getAttribute("listAltro");
	List<RichiestaInterventiBean> listRichiesta = (List<RichiestaInterventiBean>) request
			.getAttribute("listRichiesta");

	int countAssetPc = 0;
	int countSoftware = 0;
	int countHardware = 0;
	int countPostElectronica = 0;
	int condivisioneStampanti = 0;
	int condivisioneDati = 0;
	int altro = 0;
	int richiesta = 0;
	int descrizioneSoftware = 0;
	int descrizioneRichiesta = 0;
%>
<portlet:actionURL name="riepilogoDati" var="riepilogoDati"></portlet:actionURL>

<c:set value="<%=listAssetPc%>" var="listAssetPc"></c:set>
<c:set value="<%=listSoftware%>" var="listSoftware"></c:set>
<c:set value="<%=listHardware%>" var="listHardware"></c:set>
<c:set value="<%=listPostaElectronica%>" var="listPostaElectronica"></c:set>
<c:set value="<%=listCondivisioneStampanti%>"
	var="listCondivisioneStampanti"></c:set>
<c:set value="<%=listCondivisioneDati%>" var="listCondivisioneDati"></c:set>
<c:set value="<%=listAltro%>" var="listAltro"></c:set>
<c:set value="<%=listRichiesta%>" var="listRichiesta"></c:set>

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
<div id="MainContainer" class="ama-container-fluid">
	<div class="ama-row">
		<div class="ama-col-md-12">
			<div class="wrapper-title-small">
				<h2 class="title-box borders">
					<liferay-ui:message
						key="label-richeste-interventi-dati-richiedente" />
				</h2>
			</div>
		</div>
	</div>
	<div class="ama-row">
		<form action="${riepilogoDati}" method="post" id="formRiepilogoDati"
			data-parsley-validate="" enctype="multipart/form-data" >
			<div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
				<label for="argument" class="label-form"><liferay-ui:message
						key="label-richeste-interventi-dati-ufficio-richiedente" />*</label>
		
                    <c:if test="<%=richiedente.getUfficioRichiedente()!= null%>"> 
						<input type="text"
							class="input-custom-light data-parsley-validated"
							data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							id="ufficioRichiedente"
							name="<portlet:namespace/>ufficioRichiedente"
							value="<%=richiedente.getUfficioRichiedente()%>"
							placeholder="<liferay-ui:message key="label-placeholder-ufficio-richiedente"/>">
					</c:if>
					 <c:if test="<%=richiedente.getUfficioRichiedente()== null%>"> 
						<input type="text"
							class="input-custom-light data-parsley-validated"
							data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							id="ufficioRichiedente"
							name="<portlet:namespace/>ufficioRichiedente"						
							placeholder="<liferay-ui:message key="label-placeholder-ufficio-richiedente"/>">
					</c:if>
			</div>
			<div class="ama-col-xs-12 mb-25-xs">
				<div class="ama-row">
					<div class="ama-col-sm-6 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-nome" />*</label>
						    <c:if test="<%=richiedente.getNome()!= null%>"> 
								<input type="text" name="<portlet:namespace/>nome" id="nome"
									class="input-custom-light data-parsley-validated"
									data-parsley-required="true"
									data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									value="<%=richiedente.getNome()%>" placeholder="<liferay-ui:message key="label-placeholder-nome"/>">
						   </c:if>
						    <c:if test="<%=richiedente.getNome()== null%>"> 
								<input type="text" name="<portlet:namespace/>nome" id="nome"
									class="input-custom-light data-parsley-validated"
									data-parsley-required="true"
									data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									placeholder="<liferay-ui:message key="label-placeholder-nome"/>">
						   </c:if>
					</div>
					<div class="ama-col-sm-6 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-cognome" />*</label>
						<c:if test="<%=richiedente.getCognome()!= null%>"> 
							<input type="text" name="<portlet:namespace/>cognome"
								id="cognome" class="input-custom-light data-parsley-validated"
								data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								value="<%=richiedente.getCognome()%>"  placeholder="<liferay-ui:message key="label-placeholder-cognome"/>">
						</c:if>
						<c:if test="<%=richiedente.getCognome()== null%>"> 
							<input type="text" name="<portlet:namespace/>cognome"
								id="cognome" class="input-custom-light data-parsley-validated"
								data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								placeholder="<liferay-ui:message key="label-placeholder-cognome"/>">
						</c:if>
					</div>
				</div>
			</div>
			<div class="ama-col-xs-12 mb-25-xs">
				<div class="ama-row">
					<div class="ama-col-sm-4 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-ubicazione" /></label>
						<c:if test="<%=richiedente.getUbicazione()!= null%>">
							<input type="text" name="<portlet:namespace/>ubicazione"
								id="ubicazione" class="input-custom-light"
								value="<%=richiedente.getUbicazione()%>" placeholder="<liferay-ui:message key="label-placeholder-ubicazione"/>">
						</c:if>
						<c:if test="<%=richiedente.getUbicazione()== null%>">
							<input type="text" name="<portlet:namespace/>ubicazione"
								id="ubicazione" class="input-custom-light"
								placeholder="<liferay-ui:message key="label-placeholder-ubicazione"/>">
						</c:if>

					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-palazzina" /></label>
						<c:if test="<%=richiedente.getPalazzina()!= null%>">
							<input type="text" name="<portlet:namespace/>palazzina"
								id="palazzina" class="input-custom-light" 
								value="<%=richiedente.getPalazzina()%>"
								placeholder="<liferay-ui:message key="label-placeholder-palazzina"/>">
						</c:if>
						<c:if test="<%=richiedente.getPalazzina()== null%>">
							<input type="text" name="<portlet:namespace/>palazzina"
								id="palazzina" class="input-custom-light" 		
								placeholder="<liferay-ui:message key="label-placeholder-palazzina"/>">
						</c:if>
					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-piano" /></label>
		 			<c:if test="<%=richiedente.getPiano()!= null%>">
							<input type="text" name="<portlet:namespace/>piano" id="piano"
								class="input-custom-light" 
								value="<%=richiedente.getPiano()%>"
								placeholder="<liferay-ui:message key="label-placeholder-piano"/>">
					</c:if>
					<c:if test="<%=richiedente.getPiano()== null%>">
							<input type="text" name="<portlet:namespace/>piano" id="piano"
								class="input-custom-light" 
								placeholder="<liferay-ui:message key="label-placeholder-piano"/>">
					</c:if>
					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-scala" /></label>
					<c:if test="<%=richiedente.getScala()!= null%>">
							<input type="text" name="<portlet:namespace/>scala" id="scala"
								class="input-custom-light" 	
								value="<%=richiedente.getScala()%>"
								placeholder="<liferay-ui:message key="label-placeholder-scala"/>">
					</c:if>
					<c:if test="<%=richiedente.getScala()== null%>">
							<input type="text" name="<portlet:namespace/>scala" id="scala"
								class="input-custom-light" 	
								placeholder="<liferay-ui:message key="label-placeholder-scala"/>">
					</c:if>
					
					</div>
					<div class="ama-col-sm-2 ama-col-xs-6">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-stanza" /></label>
							<c:if test="<%=richiedente.getStanza()!= null%>">
								<input type="text" name="<portlet:namespace/>stanza" id="stanza"
									class="input-custom-light" 
									value="<%=richiedente.getStanza()%>"
									placeholder="<liferay-ui:message key="label-placeholder-stanza"/>">
							</c:if>
							<c:if test="<%=richiedente.getStanza()== null%>">
								<input type="text" name="<portlet:namespace/>stanza" id="stanza"
									class="input-custom-light" 
									placeholder="<liferay-ui:message key="label-placeholder-stanza"/>">
							</c:if>

					</div>
				</div>
			</div>
			<div class="ama-col-xs-12">
				<div class="ama-row">
					<div class="ama-col-sm-6 ama-col--xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-telefono" /></label>
						<c:if test="<%=richiedente.getTelefono()!= null%>">
							<input type="text" name="<portlet:namespace/>telefono"
								id="telefono" class="input-custom-light data-parsley-validated"
								data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
								data-parsley-maxlength="30"
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
								value="<%=richiedente.getTelefono()%>"
								placeholder="<liferay-ui:message key="label-placeholder-telefono"/>">
						</c:if>
						<c:if test="<%=richiedente.getTelefono()== null%>">
							<input type="text" name="<portlet:namespace/>telefono"
								id="telefono" class="input-custom-light data-parsley-validated"
								data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
								data-parsley-maxlength="30"
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
								placeholder="<liferay-ui:message key="label-placeholder-telefono"/>">
						</c:if>
					</div>
					<div class="ama-col-sm-6 ama-col-xs-12">
						<label for="argument" class="label-form"><liferay-ui:message
								key="label-richeste-interventi-dati-email-dirigente" />*</label>
						<c:if test="<%=richiedente.getEmailDirigente()!= null%>">
							<input data-parsley-type="email"
								name="<portlet:namespace/>emailDirigente" id="emailDirigente"
								class="input-custom-light data-parsley-validated"
								data-parsley-required="true"
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								value="<%=richiedente.getEmailDirigente()%>" placeholder="<liferay-ui:message key="label-placeholder-email"/>">
						</c:if>
						<c:if test="<%=richiedente.getEmailDirigente()== null%>">
							<input data-parsley-type="email"
								name="<portlet:namespace/>emailDirigente" id="emailDirigente"
								class="input-custom-light data-parsley-validated"
								data-parsley-required="true"
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								placeholder="<liferay-ui:message key="label-placeholder-email"/>">
						</c:if>
					</div>
				</div>
			</div>
			<input type="hidden" id="json" name="<portlet:namespace/>json">
		</form>
	</div>
	<div class="ama-row">
		<div class="ama-col-md-12">
			<div class="wrapper-title-small">
				<h2 class="title-box borders">
					<liferay-ui:message key="label-richeste-interventi-dati-richiesta-titolo" />
				</h2>
			</div>
		</div>
	</div>
	<div class="ama-row servizi-richiesta-wrapper">
		<div class="ama-col-xs-12 mb-10-xs mb-40-sm button-wrapper">
			<div class="ama-row">
				<div class="container-button">
					<button class="servizio-richiesta-button" id="showAssetPc"
						data-toggle="collapse" data-target="#demo1">

						<div class="icon-button">
							<c:if test="${itemsAssetPc == null || itemsAssetPc == 0}">
								<span class="icon-text icomoon-computer"></span>
							</c:if>
							<c:if test="${itemsAssetPc != null && itemsAssetPc != 0}">
								<span class="icon-text icomoon-computer"><span
									id="counter-AssetPc" class="counter-item">${itemsAssetPc}</span></span>
							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-asset" /></span>
						</div>
					</button>
				</div>

				<div class="container-button">
					<button id="showSoftware" class="servizio-richiesta-button"
						data-toggle="collapse" data-target="#demo2">
						<div class="icon-button">
							<c:if test="${itemsSoftware == null || itemsSoftware == 0}">
								<span class="icon-text icomoon-software"></span>
							</c:if>
							<c:if test="${itemsSoftware != null && itemsSoftware != 0}">
								<span class="icon-text icomoon-software"><span
									id="counter-software" class="counter-item">${itemsSoftware}</span></span>
							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-software" /></span>
						</div>
					</button>
				</div>

				<div class="container-button">
					<button id="showHardware" class="servizio-richiesta-button"
						data-toggle="collapse" data-target="#demo3">
						<div class="icon-button">
							<c:if test="${itemsHardware == null || itemsHardware == 0}">
								<span id="hardware-icon" class="icon-text icomoon-server"></span>
							</c:if>
							<c:if test="${itemsHardware != null && itemsHardware != 0}">
								<span id="hardware-icon" class="icon-text icomoon-server"><span
									id="counter-hardware" class="counter-item">${itemsHardware}</span></span>
							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-hardware" /></span>
						</div>
					</button>
				</div>

				<div class="container-button">
					<button id="showPostaElectronica" class="servizio-richiesta-button"
						data-toggle="collapse" data-target="#demo4">
						<div class="icon-button">
							<c:if
								test="${itemsPostaElectronica == null || itemsPostaElectronica == 0}">
								<span class="icon-text icomoon-email-servizi"></span>
							</c:if>
							<c:if
								test="${itemsPostaElectronica != null && itemsPostaElectronica != 0}">
								<span class="icon-text icomoon-email-servizi"><span
									id="counter-postaElectronica" class="counter-item">${itemsPostaElectronica}</span></span>
							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-posta-electronica" /></span>
						</div>
					</button>
				</div>
			</div>

		</div>

		<div class="ama-col-xs-12 mb-30-xs richiesta-collapse-wrap">
			<div id="demo1" class="ama-row collapse">
				<div id="designAsset">
					<c:if test="${!empty listAssetPc}">

						<c:forEach items="${listAssetPc}" var="listAsset">
							<form>
								<%
									countAssetPc++;
								%>
								<div id="assetPc<%=countAssetPc%>"
									class="designAssetClass richiesta-item  clearfix mt-30-xs">

									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-asset" /> <%=countAssetPc%></span>
											<div class="position-button">
												<button href="#"
													onclick="removeAssetPc('#assetPc<%=countAssetPc%>');"
													type="button"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>

									<div class="ama-col-sm-3 ama-col-xs-12">
										<label for="argument" class="label-form"><liferay-ui:message
												key="label-richeste-interventi-asset-pc" />*</label> <input
											id="inputAssetPc"
											class="input-custom-light input-quant assetPcInputClass data-parsley-validated"
											data-parsley-required="true"
											data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
											value="${listAsset.getAssetPc()}"
											placeholder="<liferay-ui:message key="label-placeholder-nome-asset"/>">
									</div>
									<div class="ama-col-sm-3 ama-col-xs-12">
										<label for="argument" class="label-form"><liferay-ui:message
												key="label-richeste-interventi-tipo-hardware" />*</label> <select
											id="argument" class="option-select selectedHardwareAssetPc">
											<c:forEach items="${assetSelectItemList}" var="assetList">
												<c:if
													test="${assetList.getDescrizione() ==  listAsset.getTipologiaHardware()}">
													<option value="${assetList.getDescrizione()}"
														selected="true">${assetList.getDescrizione().toUpperCase()}</option>
												</c:if>
												<c:if
													test="${assetList.getDescrizione() !=  listAsset.getTipologiaHardware()}">
													<option value="${assetList.getDescrizione()}">${assetList.getDescrizione().toUpperCase()}</option>
												</c:if>

											</c:forEach>
										</select>
									</div>
									<div class="ama-col-sm-3 ama-col-xs-12">
										<label for="argument" class="label-form"><liferay-ui:message
												key="label-richeste-interventi-marca" /></label> <input
											class="input-custom-light marcaAssetPc data-parsley-validated"
											data-parsley-required="false" value="${listAsset.getMarca()}"
											placeholder="<liferay-ui:message key="label-placeholder-nome-marca"/>">
									</div>
									<div class="ama-col-sm-3 ama-col-xs-12">
										<label for="argument" class="label-form"><liferay-ui:message
												key="label-richeste-interventi-modello" /></label> <input
											class="input-custom-light modelloAssetPc data-parsley-validated"
											data-parsley-required="false"
											value="${listAsset.getModello()}"
											placeholder="<liferay-ui:message key="label-placeholder-nome-modello"/>">
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo1">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-altro-pc" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>

			</div>
			<div id="demo2" class="ama-row collapse">
				<div id="designSoftware">
					<c:if test="${!empty listSoftware}">
						<c:forEach items="${listSoftware}" var="listaSoftware">
							<form>
								<%
									countSoftware++;
								%>

								<div id="software<%=countSoftware%>"
									class="designSoftwareClass richiesta-item  clearfix mt-30-xs">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-software" /> <%=countSoftware%></span>
											<div class="position-button">
												<button href="#" type="button"
													onclick="removeSoftware('#software<%=countSoftware%>');"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>

									<div class="ama-col-xs-12">
										<div class="wrapper-content-textarea">
											<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message
													key="label-richeste-interventi-la-tua-richiesta" /></label>
											<textarea
												class="form-control textarea-custom-light descrizioneRichiestaSoftware data-parsley-validated"
												data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
												data-parsley-maxlength="500"
												data-parsley-required="true"
												data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
												data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
												placeholder="<liferay-ui:message key="label-placeholder-richiesta-software"/>" 
												>${listaSoftware.getDescrizione()}</textarea>
											<div class="content-textarea">${listaSoftware.getDescrizione().length()}/
												<p class="color-gray">500</p>
											</div>
										</div>
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo2">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-altro-software" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>

			</div>
			<div id="demo3" class="ama-row collapse">
				<div id="designHardware">
					<c:if test="${!empty listHardware}">
						<c:forEach items="${listHardware}" var="listHardware">

							<%
								countHardware++;
							%>
							<form id="tipoAttivitaHardware<%=countHardware%>">
								<div id="hardware<%=countHardware%>"
									class="designHardwareClass richiesta-item  clearfix mt-30-xs">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-hardware" /> <%=countHardware%></span>
											<div class="position-button">
												<button href="#" type="button"
													onclick="removeHardware('#hardware<%=countHardware%>');"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>

									<div class="ama-col-sm-3 ama-col-xs-12">
										<label class="label-form"><liferay-ui:message
												key="label-richeste-interventi-tipo-attivita" /></label>
										<c:if
											test="${listHardware.getTipoAttivita() == 'Installazione'}">
											<div class="box-radio-custom mt-10-xs mt-0-md">

												<input checked=""
													id="checkedInstallazione<%=countHardware%>"
													value="Installazione"
													name="<portlet:namespace/>tipoAttivita" type="radio"
													class="radio-custom-dark checkedInstallazione"> <label
													for="checkedInstallazione<%=countHardware%>"
													class="radio-custom-desc checkedInstallazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-installazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom mt-10-xs mt-0-md">
												<input id="checkedDisinstallazione<%=countHardware%>"
													value="Disinstallazione" type="radio"
													name="<portlet:namespace/>tipoAttivita"
													class="radio-custom-dark checkedDisinstallazione">
												<label for="checkedDisinstallazione<%=countHardware%>"
													class="radio-custom-desc checkedDisinstallazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-disinstallazione" /></span>
												</label>
											</div>
										</c:if>
										<c:if
											test="${listHardware.getTipoAttivita() == 'Disinstallazione'}">
											<div class="box-radio-custom mt-10-xs mt-0-md">

												<input id="checkedInstallazione<%=countHardware%>"
													value="Installazione"
													name="<portlet:namespace/>tipoAttivita" type="radio"
													class="radio-custom-dark checkedInstallazione"> <label
													for="checkedInstallazione<%=countHardware%>"
													class="radio-custom-desc checkedInstallazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-installazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom mt-10-xs mt-0-md">
												<input checked=""
													id="checkedDisinstallazione<%=countHardware%>"
													value="Disinstallazione" type="radio"
													name="<portlet:namespace/>tipoAttivita"
													class="radio-custom-dark checkedDisinstallazione">
												<label for="checkedDisinstallazione<%=countHardware%>"
													class="radio-custom-desc checkedDisinstallazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-disinstallazione" /></span>
												</label>
											</div>
										</c:if>
									</div>

									<div class="ama-col-sm-3 ama-col-xs-12">
										<div class="ama-row">
											<div class="ama-col-xs-12">
												<label for="argument" class="label-form"><liferay-ui:message
														key="label-richeste-interventi-tipo-hardware-per-hardware" /></label> <select
													id="argument" class="option-select selectedTipoHardware" 
													data-parsley-required="true"
													data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
													
													<c:forEach items="${hardwareSelectItemList}"
														var="hardwareList">
														<c:if
															test="${hardwareList.getDescrizione() == listHardware.getTipologiaHardware()}">
															<option value="${hardwareList.getDescrizione()}"
																selected="true">${hardwareList.getDescrizione().toUpperCase()}</option>
														</c:if>
														<c:if
															test="${hardwareList.getDescrizione() != listHardware.getTipologiaHardware()}">
															<option value="${hardwareList.getDescrizione()}">${hardwareList.getDescrizione().toUpperCase()}</option>
														</c:if>

													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="ama-col-sm-6 ama-col-xs-12">
										<label for="argument" class="label-form"><liferay-ui:message
												key="label-richeste-interventi-marca-numero-serie" /></label> <input
											type="text"
											class="input-custom-light marcaModelloNumeroSerieHw"
											value="${listHardware.getMarcaModelloNumeroSerieHw()}"
											placeholder="<liferay-ui:message key="label-placeholder-marca-modello-numero-serie"/>">
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo3">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-altro-hardware" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>

			</div>
			<div id="demo4" class="ama-row collapse">
				<div id="designPostaElectronica">
					<c:if test="${!empty listPostaElectronica}">
						<c:forEach items="${listPostaElectronica}"
							var="listPostaElectronica">
							<%
								countPostElectronica++;
							%>
							<form id="tipoAttivitaPostaElectronica<%=countPostElectronica%>">
								<div id="postaElectronica<%=countPostElectronica%>"
									class="designPostaElectronicaClass richiesta-item  clearfix mt-30-xs">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-postaelettronica" /> <%=countPostElectronica%></span>
											<div class="position-button">
												<button href="#"
													onclick="removePostaElectronica('#postaElectronica<%=countPostElectronica%>');"
													type="button"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>
									<div class="ama-col-sm-12 ama-col-md-4 ama-col-xs-12">
										<label for="argument" class="label-form"><liferay-ui:message
												key="label-richeste-interventi-codice-fiscale" /></label> <input
												data-parsley-required="true"
												data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
											type="text"
											class="input-custom-light codiceFiscalePostaElectronica"
											value="${listPostaElectronica.getCodiceFiscale()}"
											placeholder="<liferay-ui:message key="label-placeholder-codice-fiscale"/>">
									</div>
									<div class="ama-col-sm-12 ama-col-md-8 ama-col-xs-12">
										<label class="label-form mt-10-sm mt-0-md"><liferay-ui:message
												key="label-richeste-interventi-tipo-attivita" /></label>
										<c:if
											test="${listPostaElectronica.getTipoAttivita() == 'Creazione e Configurazione'}">
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input checked=""
													id="checkedCreazioneConfigurazione<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Creazione e Configurazione" type="radio"
													class="radio-custom-dark checkedCreazioneConfigurazione">
												<label
													for="checkedCreazioneConfigurazione<%=countPostElectronica%>"
													class="radio-custom-desc checkedCreazioneConfigurazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-creazione-configurazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input
													id="checkedSoloConfigurazione<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Solo Configurazione" type="radio"
													class="radio-custom-dark checkedSoloConfigurazione">
												<label
													for="checkedSoloConfigurazione<%=countPostElectronica%>"
													class="radio-custom-desc checkedSoloConfigurazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-solo-configurazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input
													id="checkedSalvataggioMessaggi<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Salvataggio Messaggi" type="radio"
													class="radio-custom-dark checkedSalvataggioMessaggi">
												<label
													for="checkedSalvataggioMessaggi<%=countPostElectronica%>"
													class="radio-custom-desc checkedSalvataggioMessaggiLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-salvataggio-messaggi" /></span>
												</label>
											</div>
										</c:if>
										<c:if
											test="${listPostaElectronica.getTipoAttivita() == 'Solo Configurazione'}">
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input
													id="checkedCreazioneConfigurazione<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Creazione e Configurazione" type="radio"
													class="radio-custom-dark checkedCreazioneConfigurazione">
												<label
													for="checkedCreazioneConfigurazione<%=countPostElectronica%>"
													class="radio-custom-desc checkedCreazioneConfigurazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-creazione-configurazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input checked=""
													id="checkedSoloConfigurazione<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Solo Configurazione" type="radio"
													class="radio-custom-dark checkedSoloConfigurazione">
												<label
													for="checkedSoloConfigurazione<%=countPostElectronica%>"
													class="radio-custom-desc checkedSoloConfigurazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-solo-configurazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input
													id="checkedSalvataggioMessaggi<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Salvataggio Messaggi" type="radio"
													class="radio-custom-dark checkedSalvataggioMessaggi">
												<label
													for="checkedSalvataggioMessaggi<%=countPostElectronica%>"
													class="radio-custom-desc checkedSalvataggioMessaggiLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-salvataggio-messaggi" /></span>
												</label>
											</div>
										</c:if>
										<c:if
											test="${listPostaElectronica.getTipoAttivita() == 'Salvataggio Messaggi'}">
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input
													id="checkedCreazioneConfigurazione<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Creazione e Configurazione" type="radio"
													class="radio-custom-dark checkedCreazioneConfigurazione">
												<label
													for="checkedCreazioneConfigurazione<%=countPostElectronica%>"
													class="radio-custom-desc checkedCreazioneConfigurazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-creazione-configurazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input
													id="checkedSoloConfigurazione<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Solo Configurazione" type="radio"
													class="radio-custom-dark checkedSoloConfigurazione">
												<label
													for="checkedSoloConfigurazione<%=countPostElectronica%>"
													class="radio-custom-desc checkedSoloConfigurazioneLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-solo-configurazione" /></span>
												</label>
											</div>
											<div class="box-radio-custom ml-10-xs mt-5-xs">
												<input checked=""
													id="checkedSalvataggioMessaggi<%=countPostElectronica%>"
													name="<portlet:namespace/>tipoAttivitaPostaElectronica"
													value="Salvataggio Messaggi" type="radio"
													class="radio-custom-dark checkedSalvataggioMessaggi">
												<label
													for="checkedSalvataggioMessaggi<%=countPostElectronica%>"
													class="radio-custom-desc checkedSalvataggioMessaggiLabel">
													<span><liferay-ui:message
															key="label-richeste-interventi-salvataggio-messaggi" /></span>
												</label>
											</div>
										</c:if>
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo4">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-altro-posta-electronica" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>
			</div>
		</div>
		<div class="ama-col-xs-12 mb-10-xs mb-40-sm button-wrapper">
			<div class="ama-row">
				<div class="container-button">
					<button id="showCondivisioneStampanti"
						class="servizio-richiesta-button" data-toggle="collapse"
						data-target="#demo5">
						<div class="icon-button">
							<c:if
								test="${itemsCondivisioneStampanti == null || itemsCondivisioneStampanti == 0}">
								<span class="icon-text icomoon-condividi-stampanti"></span>
							</c:if>
							<c:if
								test="${itemsCondivisioneStampanti != null && itemsCondivisioneStampanti != 0}">
								<span class="icon-text icomoon-condividi-stampanti"><span
									id="counter-CondivisioneStampanti" class="counter-item">${itemsCondivisioneStampanti}</span></span>

							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-condivisione-stampanti" /></span>
						</div>
					</button>
				</div>

				<div class="container-button">
					<button id="showCondivisioneDati" class="servizio-richiesta-button"
						data-toggle="collapse" data-target="#demo6">
						<div class="icon-button">
							<c:if
								test="${itemsCondivisioneDati == null || itemsCondivisioneDati == 0}">
								<span class="icon-text icomoon-folder"></span>
							</c:if>
							<c:if
								test="${itemsCondivisioneDati != null && itemsCondivisioneDati != 0}">
								<span class="icon-text icomoon-folder"><span
									id="counter-CondivisionDati" class="counter-item">${itemsCondivisioneDati}</span></span>
							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-condivisione-dati" /></span>
						</div>
					</button>
				</div>

				<div class="container-button">
					<button id="showAltro" class="servizio-richiesta-button"
						data-toggle="collapse" data-target="#demo7">
						<div class="icon-button">
							<c:if test="${itemsAltro == null || itemsAltro == 0}">
								<span 
									class="icon-text icomoon-server icomoon-server-altro"></span>
							</c:if>
							<c:if test="${itemsAltro != null && itemsAltro != 0}">
								<span 
									class="icon-text icomoon-server icomoon-server-altro"><span
									id="counter-altro" class="counter-item">${itemsAltro}</span></span>

							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-altro" /></span>
						</div>
					</button>
				</div>

				<div class="container-button">
					<button id="showRichiesta" class="servizio-richiesta-button"
						data-toggle="collapse" data-target="#demo8">
						<div class="icon-button">
							<c:if test="${itemsRichiesta == null || itemsRichiesta == 0}">
								<span class="icon-text icomoon-discuss-issue"></span>
							</c:if>
							<c:if test="${itemsRichiesta != null && itemsRichiesta != 0}">
								<span class="icon-text icomoon-discuss-issue"><span
									id="counter-richiesta" class="counter-item">${itemsRichiesta}</span></span>
							</c:if>
						</div>
						<div class="text-button">
							<span class="text"><liferay-ui:message
									key="label-richeste-interventi-richiesta" /></span>
						</div>
					</button>
				</div>
			</div>
		</div>
		<div class="ama-col-xs-12 mb-30-xs richiesta-collapse-wrap">
			<div id="demo5" class="ama-row collapse">
				<div id="designCondivisioneStampanti">
					<c:if test="${!empty listCondivisioneStampanti}">
						<c:forEach items="${listCondivisioneStampanti}"
							var="listCondivisioneStampanti">
							<form>
								<%
									condivisioneStampanti++;
								%>
								<div id="condivisioneStampanti<%=condivisioneStampanti%>"
									class="designCondivisioneStampantiClass richiesta-item  clearfix mt-30-xs">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-stampanti" /> <%=condivisioneStampanti%></span>
											<div class="position-button">
												<button href="#"
													onclick="removeCondivisioneStampanti('#condivisioneStampanti<%=condivisioneStampanti%>');"
													type="button"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>
									<div class="validatorParsleyCustom" data-parsley-check-fields-or-validator="" data-parsley-validate-if-empty="">
										<div class="ama-col-sm-6 ama-col-xs-12">
											<label class="label-form parsley-or-validator-label"><liferay-ui:message
													key="label-richeste-interventi-rete-asset-stampante" /></label> <input
												type="text"
												class="input-custom-light condivisioneAssetStampante parsley-or-validator-field data-parsley-validated"
												value="${listCondivisioneStampanti.getDiReteAssetStampante()}"
												placeholder="<liferay-ui:message key="label-placeholder-inserisci-rete-asset"/>">
										</div>
										<div class="ama-col-sm-6 ama-col-xs-12">
											<label for="argument" class="label-form parsley-or-validator-label"><liferay-ui:message
													key="label-richeste-interventi-locale-asset-pc" /></label> <input
												type="text"
												class="input-custom-light condivisioneLocalAssetPc parsley-or-validator-field data-parsley-validated"
												value="${listCondivisioneStampanti.getLocalAssetPc()}"
												placeholder="<liferay-ui:message key="label-placeholder-inserisci-interventi-locale-asset-pc"/>">
										</div>
									</div>
									<div class="ama-col-sm-6 ama-col-xs-12">
										<label class="label-form mt-15-xs"><liferay-ui:message
												key="label-richeste-interventi-marca-numero-serie" /></label> <input
											type="text"
											class="input-custom-light condivisioneModelloNumeroDiSerie"
											value="${listCondivisioneStampanti.getMarcaModelloNumeroSerie()}"
											placeholder="<liferay-ui:message key="label-placeholder-marca-modello"/>">
									</div>
									<div class="ama-col-sm-6 ama-col-xs-12">
										<label for="argument" class="label-form mt-15-xs"><liferay-ui:message
												key="label-richeste-interventi-ubicazione" /></label> <input
											type="text"
											class="input-custom-light condivisioneUbicazioneStampante"
											value="${listCondivisioneStampanti.getUbicazione()}"
											placeholder="<liferay-ui:message key="label-placeholder-ubicazione-condivisione-stampanti"/>">
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo5">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-condivisione-stampanti" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>

			</div>
			<div id="demo6" class="ama-row collapse">
				<div id="designCondivisioneDati">
					<c:if test="${!empty listCondivisioneDati}">
						<c:forEach items="${listCondivisioneDati}"
							var="listCondivisioneDati">
							<form>
								<%
									condivisioneDati++;
								%>
								<div id="condivisioneDati<%=condivisioneDati%>"
									class="designCondivisioneDatiClass richiesta-item  clearfix mt-30-xs">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-dati" /> <%=condivisioneDati%></span>
											<div class="position-button">
												<button href="#"
													onclick="removeCondivisioneDati('#condivisioneDati<%=condivisioneDati%>');"
													type="button"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>
	<div class="validatorParsleyCustom data-parsley-validated" data-parsley-check-fields-or-validator="" data-parsley-validate-if-empty="">

									<div class="ama-col-sm-6 ama-col-xs-12">
										<label class="label-form parsley-or-validator-label"><liferay-ui:message
												key="label-richeste-interventi-creazione-cartella" /></label> <input
											type="text" class="input-custom-light creazioneCartella parsley-or-validator-field"
											value="${listCondivisioneDati.getCreazioneCartella()}"
											placeholder="<liferay-ui:message key="label-placeholder-creazione-cartella"/>">
									</div>
									<div class="ama-col-sm-6 ama-col-xs-12">
										<label for="argument " class="label-form parsley-or-validator-label"><liferay-ui:message
												key="label-richeste-interventi-condivisione-cartella" /></label> <input
											type="text" class="input-custom-light condivisioneCartella parsley-or-validator-field"
											value="${listCondivisioneDati.getCondivisioneCartella()}"
											placeholder="<liferay-ui:message key="label-placeholder-condivisione-cartella"/>">
									</div>
																		</div>

									<div class="ama-col-sm-6 ama-col-xs-12">
										<label class="label-form mt-15-xs"><liferay-ui:message
												key="label-richeste-interventi-utenti-lettura" /></label> <input
											type="text" class="input-custom-light utentiAbilitareLettura"
											value="${listCondivisioneDati.getAbilitareUtenteLettura()}"
											placeholder="<liferay-ui:message key="label-placeholder-utenti-lettura"/>">
									</div>
									<div class="ama-col-sm-6 ama-col-xs-12">
										<label for="argument" class="label-form mt-15-xs"><liferay-ui:message
												key="label-richeste-interventi-utenti-scrittura" /></label> <input
											type="text"
											class="input-custom-light utentiAbilitareScrittura"
											value="${listCondivisioneDati.getAbilitareUtenteScrittura()}"
											placeholder="<liferay-ui:message key="label-placeholder-utenti-scrittura"/>">
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo6">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-condivisione-dati" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>

			</div>
			<div id="demo7" class="ama-row collapse">
				<div id="designAltro">
					<c:if test="${!empty listAltro}">
						<c:forEach items="${listAltro}" var="listAltro">
							<form>
								<%
									altro++;
								%>

								<div id="altro<%=altro%>"
									class="designAltroClass richiesta-item  clearfix mt-30-xs">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-apparecch" /> <%=altro%></span>
											<div class="position-button">
												<button href="#" onclick="removeAltro('#altro<%=altro%>');"
													type="button"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>
								<div class="validatorParsleyCustom data-parsley-validated" data-parsley-check-fields-or-validator="" data-parsley-validate-if-empty="">

									<div class="ama-col-sm-6 ama-col-xs-12">
										<label class="label-form parsley-or-validator-label"><liferay-ui:message
												key="label-richeste-interventi-spostamento-apparecchiatura" /></label>
										<input type="text"
											class="input-custom-light spostamentoApparecchiatura parsley-or-validator-field data-parsley-validated"
											value="${listAltro.getSpostamentoApparecchiatura()}"
											placeholder="<liferay-ui:message key="label-placeholder-spostamento-apparecchiatura"/>">
									</div>
									<div class="ama-col-sm-6 ama-col-xs-12">
										<label for="argument" class="label-form parsley-or-validator-label"><liferay-ui:message
												key="label-richeste-interventi-ritiro-apparecchiatura" /></label> <input
											type="text" class="input-custom-light ritiroApparecchiatura parsley-or-validator-field data-parsley-validated"
											value="${listAltro.getRitiroApparecchiatura()}"
											placeholder="<liferay-ui:message key="label-placeholder-ritiro-apparecchiatura"/>">
									</div>
									<div class="ama-col-xs-12">
										<label class="label-form mt-15-xs parsley-or-validator-label"><liferay-ui:message
												key="label-richeste-interventi-abilitazione-presa-rete" /></label>
										<input type="text"
											class="input-custom-light abilitazionePresaRete parsley-or-validator-field data-parsley-validated"
											value="${listAltro.getAbilitazionePresaRete()}"
											placeholder="<liferay-ui:message key="label-placeholder-abilitazione-presa-rete"/>">
									</div>
								</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo7">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-altro" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>

			</div>
			<div id="demo8" class="ama-row collapse">
				<div id="designRichiesta">
					<c:if test="${!empty listRichiesta}">
						<c:forEach items="${listRichiesta}" var="listRichiesta">
							<form>
								<%
									richiesta++;
								%>
								<div id="richiesta<%=richiesta%>"
									class="designRichiestaClass richiesta-item clearfix mt-30-xs">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrap-content-delete">
											<span class="number"><liferay-ui:message
														key="label-numero-tecnici-altro" /> <%=richiesta%></span>
											<div class="position-button">
												<button href="#"
													onclick="removeRichiesta('#richiesta<%=richiesta%>');"
													type="button"
													class="mt-0-xs button button-primary removebtn">
													<span class="icon icomoon-trash1"></span>
													<liferay-ui:message
														key="label-richeste-interventi-option-rimuovi" />
												</button>
											</div>
										</div>
									</div>

									<div class="ama-col-xs-12">
										<div class="wrapper-content-textarea">
											<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message
													key="label-richeste-interventi-la-tua-richiesta" /></label>
											<textarea
												class="form-control textarea-custom-light descrizioneRichiesta data-parsley-validated"
												data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
												data-parsley-maxlength="500"
												data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
												data-parsley-required="true"
												data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
												placeholder="<liferay-ui:message key="label-placeholder-richiesta"/>" 
												onkeyup="textareaCounter(this)"
												>${listRichiesta.getDescrizione()}</textarea>
											<div class="content-textarea">${listRichiesta.getDescrizione().length()}/
												<p class="color-gray">500</p>
											</div>
										</div>
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="ama-col-xs-12">
					<button
						class="button button-primary button-servizi mt-40-xs button-add"
						id="button-demo8">
						<span><liferay-ui:message
								key="label-richeste-interventi-aggiungi-richiesta" /></span><span
							class="icon-btn icomoon-plus"></span>
					</button>
				</div>

			</div>
		</div>
		
		<form id="validateParsleyCustomForm" data-parsley-validate="">
		<input type="hidden"  class="data-parsley-validated" 
				data-parsley-required="true"
				data-parsley-required-message='<liferay-ui:message key="error-richieste-interventi-richiesta"/>'>
		</form>		
		<div class="ama-col-xs-12 text-center mb-30-xs">
			<button class="button button-primary" id="prosegui">
				<liferay-ui:message key="label-richeste-interventi-prosegui" />
			</button>
		</div>
	</div>
</div>
<div id="designAssetPcNone" style="display: none">
	<form>
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>
		<div class="ama-col-sm-3 ama-col-xs-12">

			<label for="argument" class="label-form"><liferay-ui:message
					key="label-richeste-interventi-asset-pc" />*</label> <input
				id="inputAssetPc"
				class="input-custom-light input-quant assetPcInputClass data-parsley-validated"
				data-parsley-required="true"
				data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
				placeholder="<liferay-ui:message key="label-placeholder-nome-asset"/>">


		</div>
		<div class="ama-col-sm-3 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message
					key="label-richeste-interventi-tipo-hardware" />*</label> <select
				id="argument" class="option-select selectedHardwareAssetPc">
				<c:forEach items="${assetSelectItemList}" var="assetList">
					<c:if
						test="${assetList.getDescrizione().toLowerCase() == 'pc desktop' }">
						<option value="${assetList.getDescrizione()}" selected="true">${assetList.getDescrizione().toUpperCase()}</option>
					</c:if>
					<c:if
						test="${assetList.getDescrizione().toLowerCase() != 'pc desktop' }">
						<option value="${assetList.getDescrizione()}">${assetList.getDescrizione().toUpperCase()}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="ama-col-sm-3 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message
					key="label-richeste-interventi-marca" /></label> <input
				class="input-custom-light marcaAssetPc data-parsley-validated"
				data-parsley-required="false"
				placeholder="<liferay-ui:message key="label-placeholder-nome-marca"/>">
		</div>
		<div class="ama-col-sm-3 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message
					key="label-richeste-interventi-modello" /></label> <input
				class="input-custom-light modelloAssetPc data-parsley-validated"
				data-parsley-required="false"
				placeholder="<liferay-ui:message key="label-placeholder-nome-modello"/>">
		</div>
	</form>

</div>
<div id="designSoftwareNone" style="display: none">
	<form>
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>
		<div class="ama-col-xs-12">
			<div class="wrapper-content-textarea">
				<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message
						key="label-richeste-interventi-la-tua-richiesta" /></label>
				<textarea
					class="form-control textarea-custom-light descrizioneRichiestaSoftware data-parsley-validated"
					data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
					data-parsley-maxlength="500"
					data-parsley-required="true"
					data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
					placeholder="<liferay-ui:message key="label-placeholder-richiesta-software"/>"
					onkeyup="textareaCounter(this)"
					></textarea>
				<div class="content-textarea">
					0/
					<p class="color-gray">500</p>
				</div>
			</div>
		</div>
	</form>

</div>
<div id="designHardwareNone" style="display: none">
	<form class="tipoAttivitaHardwareClass">
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>
		<div class="ama-col-sm-3 ama-col-xs-12">
			<label class="label-form"><liferay-ui:message
					key="label-richeste-interventi-tipo-attivita" /></label>
			<div class="box-radio-custom mt-10-xs mt-0-md">
				<input checked="" value="Installazione"
					name="<portlet:namespace/>tipoAttivita" type="radio"
					class="radio-custom-dark checkedInstallazione"> <label
					class="radio-custom-desc checkedInstallazioneLabel"> <span><liferay-ui:message
							key="label-richeste-interventi-installazione" /></span>
				</label>
			</div>
			<div class="box-radio-custom mt-10-xs mt-0-md">
				<input value="Disinstallazione"
					name="<portlet:namespace/>tipoAttivita" type="radio"
					class="radio-custom-dark checkedDisinstallazione"><label
					class="radio-custom-desc checkedDisinstallazioneLabel"><span><liferay-ui:message
							key="label-richeste-interventi-disinstallazione" /></span> </label>
			</div>
		</div>
		<div class="ama-col-sm-3 ama-col-xs-12">
			<div class="ama-row">
				<div class="ama-col-xs-12">
					<label for="argument" class="label-form"><liferay-ui:message
							key="label-richeste-interventi-tipo-hardware-per-hardware" /></label> <select
						id="argument" class="option-select selectedTipoHardware"
						data-parsley-required="true"
					data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						>
						<option value="" hidden=""><liferay-ui:message
								key="label-richeste-interventi-scegli-hardware" /></option>
						<c:forEach items="${hardwareSelectItemList}" var="hardwareList">
							<option value="${hardwareList.getDescrizione()}">${hardwareList.getDescrizione().toUpperCase()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message key="label-richeste-interventi-marca-numero-serie" /></label> <input
				type="text" class="input-custom-light marcaModelloNumeroSerieHw"
				placeholder="<liferay-ui:message key="label-placeholder-marca-modello-numero-serie"/>">
		</div>

	</form>
</div>
<div id="designPostaElectronicNone" style="display: none">
	<form class="tipoAttivitaPostaElectronicaClass">
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>


		<div class="ama-col-sm-12 ama-col-md-4 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message
					key="label-richeste-interventi-codice-fiscale" /></label> <input
				data-parsley-required="true"
				data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"	
				type="text"
				class="input-custom-light codiceFiscalePostaElectronica data-parsley-validated"
				data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/"
				data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
				placeholder="<liferay-ui:message key="label-placeholder-codice-fiscale"/>">
		</div>


		<div class="ama-col-sm-12 ama-col-md-8 ama-col-xs-12">
			<label class="label-form mt-10-sm mt-0-md"><liferay-ui:message
					key="label-richeste-interventi-tipo-attivita" /></label>
			<div class="box-radio-custom ml-10-xs mt-5-xs">
				<input checked=""
					name="<portlet:namespace/>tipoAttivitaPostaElectronica"
					value="Creazione e Configurazione" type="radio"
					class="radio-custom-dark checkedCreazioneConfigurazione"> <label
					class="radio-custom-desc checkedCreazioneConfigurazioneLabel">
					<span><liferay-ui:message
							key="label-richeste-interventi-creazione-configurazione" /></span>
				</label>
			</div>
			<div class="box-radio-custom ml-10-xs mt-5-xs">
				<input name="<portlet:namespace/>tipoAttivitaPostaElectronica"
					value="Solo Configurazione" type="radio"
					class="radio-custom-dark checkedSoloConfigurazione"> <label
					class="radio-custom-desc checkedSoloConfigurazioneLabel"> <span><liferay-ui:message
							key="label-richeste-interventi-solo-configurazione" /></span>
				</label>
			</div>
			<div class="box-radio-custom ml-10-xs mt-5-xs">
				<input name="<portlet:namespace/>tipoAttivitaPostaElectronica"
					value="Salvataggio Messaggi" type="radio"
					class="radio-custom-dark checkedSalvataggioMessaggi"> <label
					class="radio-custom-desc checkedSalvataggioMessaggiLabel">
					<span><liferay-ui:message
							key="label-richeste-interventi-salvataggio-messaggi" /></span>
				</label>
			</div>
		</div>

	</form>

</div>

<div id="designCondivisioneStampanteNone" style="display: none">
	<form >
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>
		
			<div class="validatorParsleyCustom" data-parsley-check-fields-or-validator="" data-parsley-validate-if-empty="">
				<div class="ama-col-sm-6 ama-col-xs-12">
					<label class="label-form parsley-or-validator-label"><liferay-ui:message
							key="label-richeste-interventi-rete-asset-stampante" /></label> 
					<input type="text" class="input-custom-light condivisioneAssetStampante parsley-or-validator-field data-parsley-validated"
								placeholder="<liferay-ui:message key="label-placeholder-inserisci-rete-asset"/>">
				</div>
				<div class="ama-col-sm-6 ama-col-xs-12">
					<label for="argument" class="label-form parsley-or-validator-label"><liferay-ui:message
							key="label-richeste-interventi-locale-asset-pc" /></label> 
					<input type="text" class="input-custom-light condivisioneLocalAssetPc parsley-or-validator-field data-parsley-validated"
								placeholder="<liferay-ui:message key="label-placeholder-inserisci-interventi-locale-asset-pc"/>">
				</div>
			</div>
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label class="label-form mt-15-xs"><liferay-ui:message
					key="label-richeste-interventi-marca-numero-serie" /></label> <input
				type="text"
				class="input-custom-light condivisioneModelloNumeroDiSerie"
				placeholder="<liferay-ui:message key="label-placeholder-marca-modello"/>">
		</div>
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label for="argument" class="label-form mt-15-xs"><liferay-ui:message
					key="label-richeste-interventi-ubicazione" /></label> <input type="text"
				class="input-custom-light condivisioneUbicazioneStampante"
				placeholder="<liferay-ui:message key="label-placeholder-ubicazione-condivisione-stampanti"/>">
		</div>
		
	</form>
</div>

<div id="designCondivisioneDatiNone" style="display: none">
	<form>
	
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>
<div class="validatorParsleyCustom data-parsley-validated" data-parsley-check-fields-or-validator="" data-parsley-validate-if-empty="">
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label class="label-form parsley-or-validator-label"><liferay-ui:message
					key="label-richeste-interventi-creazione-cartella" /></label> <input
				type="text" class="input-custom-light creazioneCartella parsley-or-validator-field"
				placeholder="<liferay-ui:message key="label-placeholder-creazione-cartella"/>">
		</div>
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label for="argument" class="label-form parsley-or-validator-label"><liferay-ui:message
					key="label-richeste-interventi-condivisione-cartella" /></label> <input
				type="text" class="input-custom-light condivisioneCartella parsley-or-validator-field"
				placeholder="<liferay-ui:message key="label-placeholder-condivisione-cartella"/>">
		</div>
		
		</div>
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label class="label-form mt-15-xs"><liferay-ui:message
					key="label-richeste-interventi-utenti-lettura" /></label> <input
				type="text" class="input-custom-light utentiAbilitareLettura"
				placeholder="<liferay-ui:message key="label-placeholder-utenti-lettura"/>">
		</div>
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label for="argument" class="label-form mt-15-xs"><liferay-ui:message
					key="label-richeste-interventi-utenti-scrittura" /></label> <input
				type="text" class="input-custom-light utentiAbilitareScrittura"
				placeholder="<liferay-ui:message key="label-placeholder-utenti-scrittura"/>">
		</div>
		
	</form>

</div>

<div id="designAltroNone" style="display: none">

	<form>
<div class="validatorParsleyCustom data-parsley-validated" data-parsley-check-fields-or-validator="" data-parsley-validate-if-empty="">
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>


		<div class="ama-col-sm-6 ama-col-xs-12">
			<label class="label-form parsley-or-validator-label"><liferay-ui:message
					key="label-richeste-interventi-spostamento-apparecchiatura" /></label> <input
				type="text" class="input-custom-light spostamentoApparecchiatura parsley-or-validator-field data-parsley-validated"
				placeholder="<liferay-ui:message key="label-placeholder-spostamento-apparecchiatura"/>">
		</div>
		<div class="ama-col-sm-6 ama-col-xs-12">
			<label  class="label-form parsley-or-validator-label"><liferay-ui:message
					key="label-richeste-interventi-ritiro-apparecchiatura" /></label> <input
				type="text" class="input-custom-light ritiroApparecchiatura parsley-or-validator-field data-parsley-validated"
				placeholder="<liferay-ui:message key="label-placeholder-ritiro-apparecchiatura"/>">
		</div>
		<div class="ama-col-xs-12">
			<label class="label-form mt-15-xs parsley-or-validator-label"><liferay-ui:message
					key="label-richeste-interventi-abilitazione-presa-rete" /></label> <input
				type="text" class="input-custom-light abilitazionePresaRete parsley-or-validator-field data-parsley-validated"
				placeholder="<liferay-ui:message key="label-placeholder-abilitazione-presa-rete"/>">
		</div>
		</div>
	</form>
</div>

<div id="designRichiestaNone" style="display: none">
	<form>
		<div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number"></span>
				<div class="position-button">
					<button href="#" type="button"
						class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span>
						<liferay-ui:message key="label-richeste-interventi-option-rimuovi" />
					</button>
				</div>
			</div>
		</div>

		<div class="ama-col-xs-12">
			<div class="wrapper-content-textarea">
				<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message
						key="label-richeste-interventi-la-tua-richiesta" /></label>
				<textarea
					class="form-control textarea-custom-light descrizioneRichiesta data-parsley-validated"
					data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
					data-parsley-maxlength="500"
					data-parsley-required="true"
					data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
					placeholder="<liferay-ui:message key="label-placeholder-richiesta"/>"
					onkeyup="textareaCounter(this)"
					></textarea>
				<div class="content-textarea">
					0/
					<p class="color-gray">500</p>
				</div>
			</div>
		</div>
	</form>
</div>


<script>
	var itemAsset = {};
	var itemHardware = {};
	var itemSoftware = {};
	var itemPostaElectronica = {};
	var itemCondivisioneStampanti = {};
	var itemCondivisioneDati = {};
	var itemAltro = {};
	var itemAltro = {};
	var itemRichiesta = {};
	var array = [];
	jsonObj = {};

	var countAssetPc = <%=countAssetPc%>;
	var countAssetPcId = countAssetPc;
	var countSoftware = <%=countSoftware%>;;
	var countSoftwareId = countSoftware;
	var countHardware =<%=countHardware%>;
	var countHardwareId = countHardware;
	var countPostElectronica = <%=countPostElectronica%>;
	var countPostElectronicaId = countPostElectronica;
	var countCondivisioneStampanti = <%=condivisioneStampanti%>;
	var countCondivisioneStampantiId = countCondivisioneStampanti;
	var countCondivisioneDati = <%=condivisioneDati%> ;
	var countCondivisioneDatiId = countCondivisioneDati;
	var countAltro = <%=altro%>;
	var countAltroId = countAltro;
	var countRichiesta = <%=richiesta%>;
	var countRichiestaId = countRichiesta;

	var assetPcNone = $("#designAssetPcNone").html();
	var softwareNone = $("#designSoftwareNone").html();
	var hardwareNone = $("#designHardwareNone").html();
	var postaElectronicNone = $("#designPostaElectronicNone").html();
	var condivisioneStampanteNone = $("#designCondivisioneStampanteNone").html();
	var condivisioneDatiNone = $("#designCondivisioneDatiNone").html();
	var altroNone = $("#designAltroNone").html();
	var richiestaNone = $("#designRichiestaNone").html();

	var idButtonDemo1 = "button-demo1";
	var idButtonDemo2 = "button-demo2";
	var idButtonDemo3 = "button-demo3";
	var idButtonDemo4 = "button-demo4";
	var idButtonDemo5 = "button-demo5";
	var idButtonDemo6 = "button-demo6";
	var idButtonDemo7 = "button-demo7";
	var idButtonDemo8 = "button-demo8";

	var listComputer = "$listAssetPc}";
	var listSoftware = "${listSoftware}";
	var listHardware = "${listHardware}";
	var listPostaElectronica = "${listPostaElectronica}";
	var listCondivisioneStampanti = "${listCondivisioneStampanti}";
	var listCondivisioneDati = "${listCondivisioneDati}";
	var listAltro = "${listAltro}";
	var listRichiesta = "${listRichiesta}";

	var htmlBadgeAsset = "<span id='counter-AssetPc' class='counter-item'></span>";
	var htmlBadgeSoftware = "<span id='counter-software' class='counter-item'></span>";
	var htmlBadgeHardware = "<span id='counter-hardware' class='counter-item'></span>";
	var htmlBadgePostaElectronica = "<span id='counter-postaElectronica' class='counter-item'></span>";
	var htmlBadgeCondivisioneStampanti = "<span id='counter-CondivisioneStampanti' class='counter-item'></span>";
	var htmlBadgeCondivisioneDati = "<span id='counter-CondivisionDati' class='counter-item'></span>";
	var htmlBadgeAltro = "<span id='counter-altro' class='counter-item'></span>";
	var htmlBadgeRichiesta = "<span id='counter-richiesta' class='counter-item'></span>";

	
	function collapseWithout(index){
		for(var i=1; i<9; i++) {
			if (i!=index){
				$("#demo"+i).removeClass("collapse in");
				$("#demo"+i).addClass("collapse");
			}
		}
	}
	
	
	
	$(".servizio-richiesta-button").click("on", function() {
		switch (this.id) {
		case  "showAssetPc":
			collapseWithout(1);
			break;
		case "showSoftware":
			collapseWithout(2);
			break;
		case "showHardware":
			collapseWithout(3);
			break;
		case "showPostaElectronica":
			collapseWithout(4);
			break;
		case "showCondivisioneStampanti":
			collapseWithout(5);
			break;
		case "showCondivisioneDati":
			collapseWithout(6);
			break;
		case "showAltro":
			collapseWithout(7);
			break;
		case "showRichiesta":
			collapseWithout(8);
			break;
		default:

		}
			
			
			
		
	});
	
	
	function addNewAssetPc() {
		if (countAssetPc == 0)
			$(".icomoon-computer").html(htmlBadgeAsset);

		countAssetPc++;
		countAssetPcId++;

		$("#counter-AssetPc").html(countAssetPc);

		var htmlDesign = assetPcNone;
		var divMasterComputer = document.createElement("div");
		$(divMasterComputer).attr("id", "assetPc" + countAssetPcId);
		$(divMasterComputer).addClass("designAssetClass");
		$(divMasterComputer).addClass("richiesta-item  clearfix mt-30-xs");
		$(divMasterComputer).append(htmlDesign);
		$(divMasterComputer).find(".number").html('<liferay-ui:message key="label-numero-tecnici-asset" />'+countAssetPc);
		var count = countAssetPcId;
		$(divMasterComputer).find(".removebtn").each(function() {

			$(this).click(function() {

				removeAssetPc("#assetPc" + count);
			});
		});

		$("#designAsset").append(divMasterComputer);

	}

	function removeAssetPc(idItemComputer) {

		$(idItemComputer).remove();
		countAssetPc--;
		if (countAssetPc < 1) {
			$(".icomoon-computer").find("span").remove();
			$("#counter-AssetPc").html("");
			$("#demo1").removeClass("collapse in");
			$("#demo1").addClass("collapse");
			listComputer == null;
			countAssetPc = 0;
		} else {
			$("#counter-AssetPc").html(countAssetPc);

		}

	}

	function addNewSoftware() {
		if (countSoftware == 0)
			$(".icomoon-software").html(htmlBadgeSoftware);
		countSoftware++;
		countSoftwareId++;
		$("#counter-software").html(countSoftware);

		var htmlDesign = softwareNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id", "software" + countSoftwareId);
		$(divMaster).addClass("designSoftwareClass");
		$(divMaster).addClass("richiesta-item  clearfix mt-30-xs");
		
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-tecnici-software" />'+countSoftware);
	
		var count = countSoftwareId;
		$(divMaster).find(".removebtn").each(function() {
			$(this).click(function() {
				removeSoftware("#software" + count);
			});
		});

		$("#designSoftware").append(divMaster);
		

	}

	
	function removeSoftware(idItem) {

		$(idItem).remove();
		countSoftware--;
		if (countSoftware < 1) {
			$(".icomoon-software").find("span").remove();
			$("#counter-software").html("");
			$("#demo2").removeClass("collapse in");
			$("#demo2").addClass("collapse");
			listSoftware == null;
			countSoftware = 0;
		} else {
			$("#counter-software").html(countSoftware);

		}

	}

	function addNewHardware() {
		if (countHardware == 0)
			$("#hardware-icon").html(htmlBadgeHardware);

		countHardware++;
		countHardwareId++;
		$("#counter-hardware").html(countHardware);

		var htmlDesign = hardwareNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id", "hardware" + countHardwareId);
		$(divMaster).addClass("designHardwareClass");
		$(divMaster).addClass("richiesta-item  clearfix mt-30-xs");
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-tecnici-hardware" />'+countHardware);
		var count = countHardwareId;
		$(divMaster).find(".removebtn").each(function() {
			$(this).click(function() {
				removeHardware("#hardware" + count);
			});
		});
		$(divMaster).find(".tipoAttivitaHardwareClass").each(function() {
			$(this).attr("id", "tipoAttivitaHardware" + count);

			$(this).find(".checkedInstallazione").each(function() {
				$(this).attr("id", "checkedInstallazione" + count);

			});
			$(this).find(".checkedDisinstallazione").each(function() {
				var cd = $(this).attr("id", "checkedDisinstallazione" + count);

			});

			$(this).find(".checkedInstallazioneLabel").each(function() {
				$(this).attr("for", "checkedInstallazione" + count);

			});

			$(this).find(".checkedDisinstallazioneLabel").each(function() {
				$(this).attr("for", "checkedDisinstallazione" + count);

			});

		});

		$("#designHardware").append(divMaster);

	}

	

	function removeHardware(idItem) {

		$(idItem).remove();
		countHardware--;
		if (countHardware < 1) {
			$("#hardware-icon").find("span").remove();
			$("#counter-hardware").html("");
			$("#demo3").removeClass("collapse in");
			$("#demo3").addClass("collapse");
			listHardware == null;
			countHardware = 0;
		} else {
			$("#counter-hardware").html(countHardware);

		}

	}

	function addPostaElectronica() {

		if (countPostElectronica == 0)
			$(".icomoon-email-servizi").html(htmlBadgePostaElectronica);

		countPostElectronica++;
		countPostElectronicaId++;
		$("#counter-postaElectronica").html(countPostElectronica);

		var htmlDesign = postaElectronicNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id", "postaElectronica" + countPostElectronicaId);
		$(divMaster).addClass("designPostaElectronicaClass");
		$(divMaster).addClass("richiesta-item  clearfix mt-30-xs");
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-tecnici-postaelettronica" />'+countPostElectronica);
		var count = countPostElectronicaId;
		$(divMaster)
				.find(".removebtn")
				.each(
						function() {
							$(this)
									.click(
											function() {
												removePostaElectronica("#postaElectronica"	+ count);
											});

							$(divMaster)
									.find(".tipoAttivitaPostaElectronicaClass")
									.each(
											function() {

												$(this).attr(
														"id",
														"tipoAttivitaPostaElectronica"+ count);
												$(this)
														.find(
																".checkedCreazioneConfigurazione")
														.each(
																function() {
																	var countId = $(
																			this)
																			.attr(
																					"id",
																					"checkedCreazioneConfigurazione"
																							+ count);

																});
												$(this)
														.find(
																".checkedSoloConfigurazione")
														.each(
																function() {
																	$(this)
																			.attr(
																					"id",
																					"checkedSoloConfigurazione"
																							+ count);

																});

												$(this)
														.find(
																".checkedSalvataggioMessaggi")
														.each(
																function() {
																	$(this)
																			.attr(
																					"id",
																					"checkedSalvataggioMessaggi"
																							+ count);

																});

												$(this)
														.find(
																".checkedCreazioneConfigurazioneLabel")
														.each(
																function() {
																	$(this)
																			.attr(
																					"for",
																					"checkedCreazioneConfigurazione"
																							+ count);

																});

												$(this)
														.find(
																".checkedSoloConfigurazioneLabel")
														.each(
																function() {
																	$(this)
																			.attr(
																					"for",
																					"checkedSoloConfigurazione"
																							+ count);

																});

												$(this)
														.find(
																".checkedSalvataggioMessaggiLabel")
														.each(
																function() {
																	$(this)
																			.attr(
																					"for",
																					"checkedSalvataggioMessaggi"
																							+ count);

																});

											});

						});

		$("#designPostaElectronica").append(divMaster);

	}

	

	function removePostaElectronica(idItem) {

		$(idItem).remove();
		countPostElectronica--;
		if (countPostElectronica < 1) {
			$(".icomoon-email-servizi").find("span").remove();
			$("#counter-postaElectronica").html("");
			$("#demo4").removeClass("collapse in");
			$("#demo4").addClass("collapse");
			listPostaElectronica == null;
			countPostElectronica = 0;
		} else {
			$("#counter-postaElectronica").html(countPostElectronica);

		}

	}

	function addCondivisioneStampanti() {

		if (countCondivisioneStampanti == 0)
			$(".icomoon-condividi-stampanti").html(
					htmlBadgeCondivisioneStampanti);
		countCondivisioneStampanti++;
		countCondivisioneStampantiId++;
		$("#counter-CondivisioneStampanti").html(countCondivisioneStampanti);

		var htmlDesign = condivisioneStampanteNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id",
				"condivisioneStampanti" + countCondivisioneStampantiId);
		$(divMaster).addClass("designCondivisioneStampantiClass");
		$(divMaster).addClass("richiesta-item  clearfix mt-30-xs");
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-tecnici-stampanti" />'+countCondivisioneStampanti);
		
		var count = countCondivisioneStampantiId;
		$(divMaster).find(".removebtn").each(function() {
			$(this).click(function() {
				removeCondivisioneStampanti("#condivisioneStampanti" + count);
			});
		});

		$("#designCondivisioneStampanti").append(divMaster);

	}

	
	function removeCondivisioneStampanti(idItem) {

		$(idItem).remove();
		countCondivisioneStampanti--;
		if (countCondivisioneStampanti < 1) {

			$(".icomoon-condividi-stampanti").find("span").remove();
			$("#counter-CondivisioneStampanti").html("");
			$("#demo5").removeClass("collapse in");
			$("#demo5").addClass("collapse");
			listCondivisioneStampanti == null;
			countCondivisioneStampanti = 0;
		} else {
			$("#counter-CondivisioneStampanti")
					.html(countCondivisioneStampanti);

		}

	}

	function addCondivisioneDati() {

		if (countCondivisioneDati == 0)
			$(".icomoon-folder").html(htmlBadgeCondivisioneDati);

		countCondivisioneDati++;
		countCondivisioneDatiId++;
		$("#counter-CondivisionDati").html(countCondivisioneDati);

		var htmlDesign = condivisioneDatiNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id", "condivisioneDati" + countCondivisioneDatiId);
		$(divMaster).addClass("designCondivisioneDatiClass");
		$(divMaster).addClass("richiesta-item  clearfix mt-30-xs");
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-tecnici-dati" />'+countCondivisioneDati);
		var count = countCondivisioneDatiId;
		$(divMaster).find(".removebtn").each(function() {
			$(this).click(function() {
				removeCondivisioneDati("#condivisioneDati" + count);
			});
		});

		$("#designCondivisioneDati").append(divMaster);

	}


	function removeCondivisioneDati(idItem) {

		$(idItem).remove();
		countCondivisioneDati--;
		if (countCondivisioneDati < 1) {
			$(".icomoon-folder").find("span").remove();
			$("#counter-CondivisionDati").html("");
			$("#demo6").removeClass("collapse in");
			$("#demo6").addClass("collapse");
			listCondivisioneDati == null;
			countCondivisioneDati = 0;
		} else {
			$("#counter-CondivisionDati").html(countCondivisioneDati);

		}

	}

	function addAltro() {

		if (countAltro == 0)
			$(".icomoon-server-altro").html(htmlBadgeAltro);

		countAltro++;
		countAltroId++;
		$("#counter-altro").html(countAltro);

		var htmlDesign = altroNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id", "altro" + countAltroId);
		$(divMaster).addClass("designAltroClass");
		$(divMaster).addClass("richiesta-item  clearfix mt-30-xs");
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-tecnici-apparecch" />'+countAltro);
		
		var count = countAltroId;
		$(divMaster).find(".removebtn").each(function() {
			$(this).click(function() {
				removeAltro("#altro" + count);
			});
		});

		$("#designAltro").append(divMaster);

	}

	function removeAltro(idItem) {

		$(idItem).remove();
		countAltro--;
		if (countAltro < 1) {
			$(".icomoon-server-altro").find("span").remove();
			$("#counter-altro").html("");
			$("#demo7").removeClass("collapse in");
			$("#demo7").addClass("collapse");
			listAltro == null;
			countAltro = 0;
		} else {
			$("#counter-altro").html(countAltro);

		}

	}

	function addRichiesta() {

		if (countRichiesta == 0)
			$(".icomoon-discuss-issue").html(htmlBadgeRichiesta);

		countRichiesta++;
		countRichiestaId++;
		$("#counter-richiesta").html(countRichiesta);

		var htmlDesign = richiestaNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id", "richiesta" + countRichiestaId);
		$(divMaster).addClass("designRichiestaClass");
		$(divMaster).addClass("richiesta-item  clearfix mt-30-xs");
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-tecnici-altro" />'+countRichiesta);
		var count = countRichiestaId;
		$(divMaster).find(".removebtn").each(function() {
			$(this).click(function() {
				removeRichiesta("#richiesta" + count);
			});
		});

		$("#designRichiesta").append(divMaster);

	}

	function removeRichiesta(idItem) {

		$(idItem).remove();
		countRichiesta--;
		if (countRichiesta < 1) {
			$(".icomoon-discuss-issue").find("span").remove();
			$("#counter-richiesta").html("");
			$("#demo8").removeClass("collapse in");
			$("#demo8").addClass("collapse");
			listRichiesta == null;
			countRichiesta = 0;
		} else {
			$("#counter-richiesta").html(countRichiesta);

		}

	}

	var valid = true;
	function checkParsleyValidate(item,index,arr){
		var flagValid = true;
		$((this.htmlElement)+" "+item).each(function(key, value) {
			
			if ($(this).parsley()!=null){
				$(this).parsley().validate();
				if (!$(this).parsley().isValid()){
					valid = false;			
					flagValid = false;
				}
			}
			
		});
		
		if (!flagValid){
		$('#show' + this.name).attr("class", "servizio-richiesta-button");
		$('#show' + this.name).attr("aria-expanded","true");
		$('#demo'+ this.id).attr("class","ama-row collapse in");
		$('#demo'+ this.id).attr("aria-expanded","true");
			
		}

	};
	
	var validNumber=false;
	var arrayParsley =["input","textarea", "select", ".validatorParsleyCustom"];
	
	function validateAll(){
		
		$(".counter-item").each(function(){
			if ($(this).text()!="")
					validNumber=true;
		});
		
		if (validNumber)
			$("#validateParsleyCustomForm").find("input").val("valid");
		else
			$("#validateParsleyCustomForm").find("input").val("");
		$("#validateParsleyCustomForm").find("input").parsley().validate();
		
	}
	
	function placeholderIe(){
		if($("html").hasClass("ie10") || $("html").hasClass("ie11")){
			setTimeout(function(){
				$('[placeholder]').focus(function() {
					var input = $(this);
					if (input.val() == input.attr('placeholder')) {
						input.val('');
						input.removeClass('placeholder');
					}
				}).blur(function() {
					var input = $(this);
					if (input.val() == '' || input.val() == input.attr('placeholder')) {
						input.addClass('placeholder');
						input.val("");
					}
				}).blur();
			},300);
		}    
		

	}

	$(".button-add").click("on", function() {

		valid=true;
		switch (this.id) {
		case idButtonDemo1:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="assetPc"]',name: "AssetPc", id:1});
			if (valid)
				addNewAssetPc();
			break;
		case idButtonDemo2:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="software"]',name: "Software", id:2});
			if (valid)
				addNewSoftware();
			break;
		case idButtonDemo3:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="hardware"]',name: "Hardware", id:3});
			if (valid)
				addNewHardware();
			break;
		case idButtonDemo4:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="postaElectronica"]',name: "PostaElectronica", id:4});
			if (valid)
				addPostaElectronica();
			break;
		case idButtonDemo5:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="condivisioneStampanti"]',name: "CondivisioneStampanti", id:5});
			if (valid)
				addCondivisioneStampanti();
			break;
		case idButtonDemo6:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="condivisioneDati"]',name: "CondivisioneDati", id:6});
			if (valid)
				addCondivisioneDati();
			break;
		case idButtonDemo7:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="altro"]',name: "Altro", id:7});
			if (valid)
				addAltro();
			break;
		case idButtonDemo8:
			arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="richiesta"]',name: "Richiesta", id:8});
			if (valid)
				addRichiesta();
			break;
		default:

		}
		
		placeholderIe();
		if($("#validateParsleyCustomForm").find("input").parsley()!=null){
			$("#validateParsleyCustomForm").find("input").parsley().destroy();
			$("#validateParsleyCustomForm").find("input").attr("data-parsley-required","true");
			$("#validateParsleyCustomForm").find("input").attr("data-parsley-required-message",'<liferay-ui:message key="error-richieste-interventi-richiesta"/>');	
		}
	});

	$("#prosegui").click("on",function() {
						valid=true;
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="assetPc"]',name: "AssetPc", id:1});
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="software"]',name: "Software", id:2});
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="hardware"]',name: "Hardware", id:3});
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="postaElectronica"]',name: "PostaElectronica", id:4});
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="condivisioneStampanti"]',name: "CondivisioneStampanti", id:5});
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="condivisioneDati"]',name: "CondivisioneDati", id:6});
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="altro"]',name: "Altro", id:7});
						arrayParsley.forEach(checkParsleyValidate,{htmlElement: 'div[id^="richiesta"]',name: "Richiesta", id:8});
						validNumber=false;

						$("#formRiepilogoDati").parsley().validate;
						
						validateAll();

						if (valid && validNumber && $("#formRiepilogoDati").parsley().isValid) {
							array = [];
							var seleziona = "asset";
							$("#MainContainer")
									.find(".designAssetClass")
									.each(
											function(key, value) {
												itemAsset = {
													seleziona : seleziona,
													assetPc : $(this)
															.find(
																	".assetPcInputClass")["0"].value,
													tipologiaAssetHardware : $(
															this)
															.find(
																	".selectedHardwareAssetPc")["0"].value,
													marca : $(this).find(
															".marcaAssetPc")["0"].value,
													model : $(this).find(
															".modelloAssetPc")["0"].value
												};
												array.push(itemAsset);

											});

							seleziona = "software";
							$("#MainContainer")
									.find(".designSoftwareClass")
									.each(
											function(key, value) {
												itemSoftware = {
													seleziona : seleziona,
													descrizione : $(this)
															.find(
																	".descrizioneRichiestaSoftware")["0"].value
												};
												array.push(itemSoftware);
											});

							seleziona = "hardware";
							var idForm = "#tipoAttivitaHardware";
							$("#MainContainer")
									.find(".designHardwareClass")
									.each(
											function(key, value) {

												var stringHardware = $(this)
														.attr("id");
												var numeroId = stringHardware
														.split("hardware")
														.pop();

												itemHardware = {
													seleziona : seleziona,
													tipologiaHardware : $(this)
															.find(
																	".selectedTipoHardware")["0"].value,
													tipoAttivita : $(
															'input[name=<portlet:namespace/>tipoAttivita]:checked',
															idForm + numeroId)
															.val(),
													marcaModelloNumeroSerieHw : $(this).find(
															".marcaModelloNumeroSerieHw")["0"].value
												};
												array.push(itemHardware);

											});

							seleziona = "postaElectronica";
							idForm = "#tipoAttivitaPostaElectronica";
							$("#MainContainer")
									.find(".designPostaElectronicaClass")
									.each(
											function(key, value) {

												var stringHardware = $(this)
														.attr("id");
												var numeroId = stringHardware
														.split(
																"postaElectronica")
														.pop();

												itemPostaElectronica = {
													seleziona : seleziona,
													codiceFiscale : $(this)
															.find(
																	".codiceFiscalePostaElectronica")["0"].value,
													tipoAttivita : $(
															'input[name=<portlet:namespace/>tipoAttivitaPostaElectronica]:checked',
															idForm + numeroId)
															.val()
												};
												array
														.push(itemPostaElectronica);

											});

							seleziona = "condivisioneStampanti";
							$("#MainContainer")
									.find(".designCondivisioneStampantiClass")
									.each(
											function(key, value) {
												itemCondivisioneStampanti = {
													seleziona : seleziona,
													diReteAssetStampanti : $(
															this)
															.find(
																	".condivisioneAssetStampante")["0"].value,
													localAssetPc : $(this)
															.find(
																	".condivisioneLocalAssetPc")["0"].value,
													marcaModelloNumeroSerie : $(
															this)
															.find(
																	".condivisioneModelloNumeroDiSerie")["0"].value,
													ubicazione : $(this)
															.find(
																	".condivisioneUbicazioneStampante")["0"].value
												};
												array
														.push(itemCondivisioneStampanti);

											});

							seleziona = "condivisioneDati";
							$("#MainContainer")
									.find(".designCondivisioneDatiClass")
									.each(
											function(key, value) {
												itemCondivisioneDati = {
													seleziona : seleziona,
													creazioneCartella : $(this)
															.find(
																	".creazioneCartella")["0"].value,
													condivisioneCartella : $(
															this)
															.find(
																	".condivisioneCartella")["0"].value,
													utentiAbilitareLettura : $(
															this)
															.find(
																	".utentiAbilitareLettura")["0"].value,
													utentiAbilitareScrittura : $(
															this)
															.find(
																	".utentiAbilitareScrittura")["0"].value
												};
												array
														.push(itemCondivisioneDati);

											});

							seleziona = "altro";
							$("#MainContainer")
									.find(".designAltroClass")
									.each(
											function(key, value) {
												itemAltro = {
													seleziona : seleziona,
													spostamentoApparecchiatura : $(
															this)
															.find(
																	".spostamentoApparecchiatura")["0"].value,
													ritiroApparecchiatura : $(
															this)
															.find(
																	".ritiroApparecchiatura")["0"].value,
													abilitazionePresaRete : $(
															this)
															.find(
																	".abilitazionePresaRete")["0"].value
												};
												array.push(itemAltro);

											});

							seleziona = "richiesta";
							$("#MainContainer")
									.find(".designRichiestaClass")
									.each(
											function(key, value) {
												itemRichiesta = {
													seleziona : seleziona,
													descrizioneRichiesta : $(
															this)
															.find(
																	".descrizioneRichiesta")["0"].value
												};
												array.push(itemRichiesta);

											});

							var ufficioRichiedente = $("#ufficioRichiedente")
									.val();
							var nome = $("#nome").val();
							var cognome = $("#cognome").val();
							var ubicazione = $("#ubicazioneAttuale").val();
							var palazzina = $("#palazzina").val();
							var piano = $("#piano").val();
							var scala = $("#scala").val();
							var stanza = $("#stanza").val();
							var telefono = $("#telefono").val();
							var email = $("#emailDirigente").val();

							jsonObj = {
								ufficioRichiedente : ufficioRichiedente,
								nome : nome,
								cognome : cognome,
								ubicazione : ubicazione,
								palazzina : palazzina,
								piano : piano,
								stanza : stanza,
								teleFono : telefono,
								email : email,
								richieste : array
							};

							$("#json").val(JSON.stringify(jsonObj));
							$("#formRiepilogoDati").submit();
						} else {
							$("#formRiepilogoDati").parsley().validate();
						}

					});
					
function textareaCounter(element){           
	var len = 0;
   if (element.value != null)
			   len = element.value.length;
   else
			   len = element.length;
   if (len >= 500) {
			   element.value = element.value.substring(0, 500);
   } else {
			   $(element).next().text((len) + "/500");
   }
}
</script>