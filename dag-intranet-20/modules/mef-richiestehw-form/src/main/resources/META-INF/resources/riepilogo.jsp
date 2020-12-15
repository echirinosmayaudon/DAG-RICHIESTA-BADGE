<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mef.richiestehw.beans.RichiestaHwBean"%>
<%

List<RichiestaHwBean> listComputer  = (List<RichiestaHwBean>) request.getAttribute("listComputer");
List<RichiestaHwBean>	listStampanti = (List<RichiestaHwBean>) request.getAttribute("listStampanti");
List<RichiestaHwBean> listAltrePeriferiche = (List<RichiestaHwBean>) request.getAttribute("listAltrePeriferiche");
List<RichiestaHwBean> listSoftware = (List<RichiestaHwBean>) request.getAttribute("listSoftware");

%>


<c:set value="<%=listComputer%>" var="listComputer"></c:set>
<c:set value="<%=listStampanti%>" var="listStampanti"></c:set>
<c:set value="<%=listAltrePeriferiche%>" var="listAltrePeriferiche"></c:set>
<c:set value="<%=listSoftware%>" var="listSoftware"></c:set>


<portlet:actionURL name="insertHardware" var="insertHardwareURL"></portlet:actionURL>
<portlet:actionURL name="newRichiesta" var="newRichiestaURL"></portlet:actionURL>

<portlet:actionURL name="modificaDati" var="modificaDati">
	<portlet:param name="nome" value="${nome}" />
	<portlet:param name="cognome" value="${cognome}" />
	<portlet:param name="ufficioRichiedente" value="${ufficioRichiedente}" />
	<portlet:param name="ubicazione" value="${ubicazione}" />
	<portlet:param name="palazzina" value="${palazzina}" />
	<portlet:param name="piano" value="${piano}" />
	<portlet:param name="scala" value="${scala}" />
	<portlet:param name="stanza" value="${stanza}" />
	<portlet:param name="telefono" value="${telefono}" />
	<portlet:param name="emailDirigente" value="${emailDirigente}" />
	<portlet:param name="listComputer" value="${listComputer}" />
	<portlet:param name="listStampanti" value="${listStampanti}" />
	<portlet:param name="listAltrePeriferiche"
		value="${listAltrePeriferiche}" />
	<portlet:param name="listSoftware" value="${listSoftware}" />
</portlet:actionURL>
 <c:if test="<%=request.getAttribute("sessionError")!=null && request.getAttribute("sessionError")=="inserimento"%>">
		<liferay-ui:error key="errore-durante-inserimento-richiesta"
			message="Inserimento non avvenuto"></liferay-ui:error>
</c:if>
 <c:if test="<%=request.getAttribute("sessionError")!=null && request.getAttribute("sessionError")=="email"%>">
		<liferay-ui:error key="errore-durante-invio-email"
			message="Inserire l'email del referente da configurazione"></liferay-ui:error>
</c:if>
<div class="trasporti-header">
	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<div class="title-wrapper">
					<h2 class="title"><%=recapTitle%></h2>
					<p class="subtitle dot-point dot-200"><%=recapSubtitle%></p>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="ama-container-fluid">
	<div class="ama-row">
		<div class="ama-col-md-12">
			<div class="wrapper-title-small">
				<h2 class="title-box borders">
					<liferay-ui:message key="label-richestehw-richiesta-riepilogo" />
				</h2>
			</div>
		</div>
	</div>

	<div class="ama-row">
		<div class="ama-col-xs-12 mobile-no-padding">
			<div class="wrapper-istanza-trasporti mobile-no-padding">
				<div class="box-gray">
					<form action="<%=insertHardwareURL%>" method="post" id="formInvia" enctype="multipart/form-data">

						<div class=" box-white pb-0-xs">
							<input type="hidden" name="<portlet:namespace/>nome" value="${nome}" /> 
							<input type="hidden" name="<portlet:namespace/>cognome" value="${cognome}" /> 							
							<input type="hidden" id="listHardwareRichiesta" name="<portlet:namespace/>richiesteJson" value="" />
							<p class="name">${nome} ${cognome}</p>
							<span
								class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm"
								data-toggle="collapse" data-target="#collapse-trasporti"
								data-parent="#accordion"></span>

							<div id="collapse-trasporti" class="collapse1 in no-overflow">
								<div class="ama-row border-section border-mobile">
									<div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
										<span class="section-information"><liferay-ui:message
												key="label-richestehw-ufficio-richiedente" />:</span> 
												<input type="hidden" name="<portlet:namespace/>ufficioRichiedente" value="${ufficioRichiedente}" />
										<p class="info">${ufficioRichiedente}</p>
									</div>
								</div>

								<div class="ama-row">
									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md mt-30-xs"><liferay-ui:message
												key="label-richestehw-dati-ubicazione" />:</span> 
												<input type="hidden" name="<portlet:namespace/>ubicazione" value="${ubicazione}" />

										<p class="info">${ubicazione}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md mt-30-sm"><liferay-ui:message
												key="label-richestehw-dati-palazzina" />:</span>
												 <input type="hidden" name="<portlet:namespace/>palazzina" value="${palazzina}" />

										<p class="info">${palazzina}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md"><liferay-ui:message
												key="label-richestehw-dati-piano" />:</span> 
												<input type="hidden" name="<portlet:namespace/>piano" value="${piano}" />

										<p class="info">${piano}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md"><liferay-ui:message
												key="label-richestehw-dati-scala" />:</span> 
												<input type="hidden" name="<portlet:namespace/>scala" value="${scala}" />

										<p class="info">${scala}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information"><liferay-ui:message
												key="label-richestehw-dati-stanza" />:</span> 
												<input type="hidden" name="<portlet:namespace/>stanza" value="${stanza}" />

										<p class="info">${stanza}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information"><liferay-ui:message
												key="label-richestehw-dati-telefono" />:</span> 
												<input type="hidden" name="<portlet:namespace/>telefono" value="${telefono}" />

										<p class="info">${telefono}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information"><liferay-ui:message
												key="label-richestehw-dati-email-dirigente" />:</span> 
												<input type="hidden" name="<portlet:namespace/>emailDirigente" value="${emailDirigente}" />

										<p class="info">${emailDirigente}</p>
									</div>
								</div>
							</div>
						</div>
						</form>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${!empty listComputer}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richestehw-richiesta-pc" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listComputer}" var="listPc">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-12 ama-col-xs-12">
											<span class="section-information width">${listPc.getTipologia().toUpperCase()}</span>
											<p class="number section-information">${listPc.getQuantita()}</p>
											<div class="text">${listPc.getNote()}</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>


	<c:if test="${!empty listStampanti}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richestehw-richiesta-stampanti" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listStampanti}" var="listStampan">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-12 ama-col-xs-12">
											<span class="section-information width">${listStampan.getTipologia().toUpperCase()}</span>
											<p class="number section-information">${listStampan.getQuantita()}</p>
											<div class="text">${listStampan.getNote()}</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>





	<c:if test="${!empty listSoftware}">

		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richestehw-richiesta-software" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listSoftware}" var="listSoft">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-12 ama-col-xs-12">
											<span class="section-information width">${listSoft.getTipologia().toUpperCase()}</span>
											<p class="number section-information">${listSoft.getQuantita()}</p>
											<div class="text">${listSoft.getNote()}</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>




	<c:if test="${!empty listAltrePeriferiche}">

		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richestehw-richiesta-periferiche" />
					</h2>
				</div>
			</div>
		</div>
	</c:if>
	<div class="ama-row">
		<div class="ama-col-xs-12 mobile-no-padding">
			<div class="wrapper-istanza-trasporti">
				<div class="no-overflow">
					<c:if test="${!empty listAltrePeriferiche}">
						<c:forEach items="${listAltrePeriferiche}"
							var="listAltPeriferiche">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-12 ama-col-xs-12">
											<span class="section-information width">${listAltPeriferiche.getTipologia().toUpperCase()}</span>
											<p class="number section-information">${listAltPeriferiche.getQuantita()}</p>
											<div class="text">${listAltPeriferiche.getNote()}</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>


					<div class="text-center">

						<div class="ama-col-md-4 ama-col-xs-12">
							<form action="<%=newRichiestaURL%>" method="post" id="formNuovaRichiesta" enctype="multipart/form-data">
							    <button href="#" type="button" id="newReq"
										class="button button-secondary mt-100-md mt-30-sm mb-100-md">
										<liferay-ui:message
											key="label-richestehw-option-annulla" />
								</button> 
							</form>		
						</div>

						<div class="ama-col-md-4 ama-col-xs-12">
							<form action="<%=modificaDati%>" method="post" id="formModifica" enctype="multipart/form-data">
								<button href="#" type="button"
									class="button button-secondary mt-100-md mt-30-sm mb-100-md"
									id="modifica" name="<portlet:namespace/>modificabtn"
									value="modificadati">
									<liferay-ui:message key="label-richestehw-option-modifica" />
								</button>
								<input type="hidden" name="<portlet:namespace/>richiesteJson"
									id="richiestehw" value="">
							</form>

						</div>

						<div class="ama-col-md-4 ama-col-xs-12">
							<button href="#" type="button"
								class="button button-primary mt-100-md mt-30-sm mb-100-md mb-40-xs"
								id="invia">
								<liferay-ui:message key="label-richestehw-option-invia" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<script>

$("#invia").click("on",function(){
	
$("#listHardwareRichiesta").val(JSON.stringify(${listarichiesteJson}));	
$("#formInvia").submit();


	
	
});



$("#modifica").click("on",function(){
	
	$("#richiestehw").val(JSON.stringify(${listarichiesteJson}));
	
	$("#formModifica").submit();
	
});


$("#newReq").click("on",function(){
	
	$("#formNuovaRichiesta").submit();
	
});


</script>

