<%@page import="java.util.List"%>
<%@page import="mef.richieste.interventi.beans.RichiestaInterventiBean"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
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
%>

<c:set value="<%=listAssetPc%>" var="listAssetPc"></c:set>
<c:set value="<%=listSoftware%>" var="listSoftware"></c:set>
<c:set value="<%=listHardware%>" var="listHardware"></c:set>
<c:set value="<%=listPostaElectronica%>" var="listPostaElectronica"></c:set>
<c:set value="<%=listCondivisioneStampanti%>"
	var="listCondivisioneStampanti"></c:set>
<c:set value="<%=listCondivisioneDati%>" var="listCondivisioneDati"></c:set>
<c:set value="<%=listAltro%>" var="listAltro"></c:set>
<c:set value="<%=listRichiesta%>" var="listRichiesta"></c:set>

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
	<portlet:param name="listAssetPc" value="${listAssetPc}" />
	<portlet:param name="listSoftware" value="${listSoftware}" />
	<portlet:param name="listHardware" value="${listHardware}" />
	<portlet:param name="listPostaElectronica"
		value="${listPostaElectronica}" />
	<portlet:param name="listCondivisioneStampanti"
		value="${listCondivisioneStampanti}" />
	<portlet:param name="listCondivisioneDati"
		value="${listCondivisioneDati}" />
	<portlet:param name="listAltro" value="${listAltro}" />
	<portlet:param name="listRichiesta" value="${listRichiesta}" />

</portlet:actionURL>

<portlet:actionURL name="insertRichiesta" var="insertRichiestaURL">
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
					<h2 class="title"><%=recapTitle%>
					</h2>
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
					<liferay-ui:message
						key="label-richeste-interventi-dati-richiedente" />
				</h2>
			</div>
		</div>
	</div>
	<div class="ama-row">
		<div class="ama-col-xs-12 mobile-no-padding">
			<div class="wrapper-istanza-trasporti mobile-no-padding">
				<div class="box-gray">
					<form action="${insertRichiestaURL}" method="post"
						id="insertRichiesta" enctype="multipart/form-data" >
						<div class=" box-white pb-0-xs">

							<input type="hidden" name="<portlet:namespace/>nome"
								value="${nome}" /> <input type="hidden"
								name="<portlet:namespace/>cognome" value="${cognome}" /> <input
								type="hidden" id="listRichiesta"
								name="<portlet:namespace/>richiesteJson" value="">
							<p class="name">${nome} &nbsp; ${cognome}</p>
							<span
								class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm"
								data-toggle="collapse" data-target="#collapse-trasporti"
								data-parent="#accordion"></span>

							<div id="collapse-trasporti" class="collapse1 in no-overflow">
								<div class="ama-row border-section border-mobile">
									<div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
										<span class="section-information"><liferay-ui:message
												key="label-richeste-interventi-ufficio-richiedente" />:</span> <input
											type="hidden" name="<portlet:namespace/>ufficioRichiedente"
											value="${ufficioRichiedente}" />
										<p class="info">${ufficioRichiedente}</p>
									</div>
								</div>

								<div class="ama-row">
									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md mt-30-xs"><liferay-ui:message
												key="label-richeste-interventi-ubicazione-attuale" />:</span> <input
											type="hidden" name="<portlet:namespace/>ubicazione"
											value="${ubicazione}" />
										<p class="info">${ubicazione}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md mt-30-sm"><liferay-ui:message
												key="label-richeste-interventi-palazzina" />:</span> <input
											type="hidden" name="<portlet:namespace/>palazzina"
											value="${palazzina}" />
										<p class="info">${palazzina}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md"><liferay-ui:message
												key="label-richeste-interventi-piano" />:</span> <input
											type="hidden" name="<portlet:namespace/>piano"
											value="${piano}" />
										<p class="info">${piano}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information mt-30-md"><liferay-ui:message
												key="label-richeste-interventi-scala" />:</span> <input
											type="hidden" name="<portlet:namespace/>scala"
											value="${scala}" />
										<p class="info">${scala}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information"><liferay-ui:message
												key="label-richeste-interventi-stanza" />:</span> <input
											type="hidden" name="<portlet:namespace/>stanza"
											value="${stanza}" />
										<p class="info">${stanza}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information"><liferay-ui:message
												key="label-richeste-interventi-telefono" />:</span> <input
											type="hidden" name="<portlet:namespace/>telefono"
											value="${telefono}" />
										<p class="info">${telefono}</p>
									</div>

									<div class="ama-col-md-3 ama-col-sm-6">
										<span class="section-information"><liferay-ui:message
												key="label-richeste-interventi-email" />:</span> <input
											type="hidden" name="<portlet:namespace/>emailDirigente"
											value="${emailDirigente}" />
										<p class="info">${emailDirigente}</p>
									</div>
								</div>
							</div>

						</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${!empty listAssetPc}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richeste-interventi-assets" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listAssetPc}" var="listAsset">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-3 ama-col-xs-6">
											<span class="section-information width border">${listAsset.getAssetPc()}</span>
										</div>
										<div class="ama-col-md-3 ama-col-xs-6">
											<span class="section-information width border">${listAsset.getTipologiaHardware()}</span>
										</div>
										<c:if test="${listAsset.getMarca() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listAsset.getMarca()}</span>
											</div>
										</c:if>
										<c:if test="${listAsset.getModello() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border-mobile-app">${listAsset.getModello()}</span>
											</div>
										</c:if>
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
						<liferay-ui:message key="label-richeste-interventi-software" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listSoftware}" var="listSoftware">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-3 ama-col-xs-6">
											<span class="section-information width border">${listSoftware.getDescrizione()}</span>
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
	<c:if test="${!empty listHardware}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richeste-interventi-hardware" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listHardware}" var="listHardware">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-3 ama-col-xs-6">
											<span class="section-information width border">${listHardware.getTipoAttivita()}</span>
										</div>
										<div class="ama-col-md-3 ama-col-xs-6">
											<span class="section-information width border">${listHardware.getTipologiaHardware()}</span>
										</div>
										<c:if test="${listHardware.getMarcaModelloNumeroSerieHw() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listHardware.getMarcaModelloNumeroSerieHw()}</span>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>


	<c:if test="${!empty listPostaElectronica}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message
							key="label-richeste-interventi-posta-electronica" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listPostaElectronica}"
							var="listPostaElectronica">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<c:if
											test="${ listPostaElectronica.getTipoAttivita() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listPostaElectronica.getTipoAttivita()}</span>
											</div>
										</c:if>
										<c:if
											test="${listPostaElectronica.getCodiceFiscale() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listPostaElectronica.getCodiceFiscale()}</span>
											</div>
										</c:if>
										
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${!empty listCondivisioneStampanti}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message
							key="label-richeste-interventi-condivisione-stampanti" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listCondivisioneStampanti}"
							var="listCondivisioneStampanti">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<c:if
											test="${listCondivisioneStampanti.getDiReteAssetStampante() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listCondivisioneStampanti.getDiReteAssetStampante()}</span>
											</div>
										</c:if>
										<c:if
											test="${listCondivisioneStampanti.getLocalAssetPc() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listCondivisioneStampanti.getLocalAssetPc()}</span>
											</div>
										</c:if>
										<c:if
											test="${listCondivisioneStampanti.getMarcaModelloNumeroSerie() != null }">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listCondivisioneStampanti.getMarcaModelloNumeroSerie()}</span>
											</div>
										</c:if>
										<c:if
											test="${listCondivisioneStampanti.getUbicazione()!=null }">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border-mobile-app">${listCondivisioneStampanti.getUbicazione()}</span>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${!empty listCondivisioneDati}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message
							key="label-richeste-interventi-condivisione-dati" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listCondivisioneDati}"
							var="listCondivisioneDati">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<c:if
											test="${listCondivisioneDati.getCreazioneCartella() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listCondivisioneDati.getCreazioneCartella()}</span>
											</div>
										</c:if>
										<c:if
											test="${ listCondivisioneDati.getCondivisioneCartella() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listCondivisioneDati.getCondivisioneCartella()}</span>
											</div>
										</c:if>
										<c:if
											test="${listCondivisioneDati.getAbilitareUtenteLettura() !=null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listCondivisioneDati.getAbilitareUtenteLettura()}</span>
											</div>
										</c:if>
										<c:if
											test="${listCondivisioneDati.getAbilitareUtenteScrittura() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border-mobile-app">${listCondivisioneDati.getAbilitareUtenteScrittura()}</span>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${!empty listAltro}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richeste-interventi-altro" />
					</h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<c:forEach items="${listAltro}" var="listAltro">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<c:if
											test="${listAltro.getSpostamentoApparecchiatura() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listAltro.getSpostamentoApparecchiatura()}</span>
											</div>
										</c:if>
										<c:if test="${listAltro.getRitiroApparecchiatura() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listAltro.getRitiroApparecchiatura()}</span>
											</div>
										</c:if>
										<c:if test="${listAltro.getAbilitazionePresaRete() != null}">
											<div class="ama-col-md-3 ama-col-xs-6">
												<span class="section-information width border">${listAltro.getAbilitazionePresaRete()}</span>
											</div>
										</c:if>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${!empty listRichiesta}">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-small">
					<h2 class="title-box borders">
						<liferay-ui:message key="label-richeste-interventi-richiesta" />
					</h2>
				</div>
			</div>
		</div>
	</c:if>
	<div class="ama-row">
		<div class="ama-col-xs-12 mobile-no-padding">
			<div class="wrapper-istanza-trasporti">
				<div class="no-overflow">
					<c:if test="${!empty listRichiesta}">
						<c:forEach items="${listRichiesta}" var="listRichiesta">
							<div class="box-gray padding-mobile-servizi">
								<div class="box-white">
									<div class="ama-row">
										<div class="ama-col-md-12 ama-col-xs-12">
											<span class="section-information">
												${listRichiesta.getDescrizione()} </span>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
				</form>
				<div class="text-center">

					<div class="ama-col-md-4 ama-col-xs-12">
						<form action="<%=newRichiestaURL%>" method="post"
							id="formNuovaRichiesta" enctype="multipart/form-data" >
							<button href="#" type="button"
								class="button button-secondary mt-100-md mt-30-sm mb-100-md"
								id="newReq">
								<liferay-ui:message
									key="label-richeste-interventi-nuova-richiesta" />
							</button>
						</form>
					</div>


					<div class="ama-col-md-4 ama-col-xs-12">
						<form action="<%=modificaDati%>" method="post" id="formModifica" enctype="multipart/form-data" >
							<button href="#" type="button" id="modifica"
								class="button button-secondary mt-100-md mt-30-sm mb-100-md">
								<liferay-ui:message key="label-richeste-interventi-modifica" />
							</button>
							<input type="hidden" name="<portlet:namespace/>richiesteJson"
								id="richiesteInterventi" value="">

						</form>
					</div>

					<div class="ama-col-md-4 ama-col-xs-12">
						<button href="#" type="button"
							class="button button-primary mt-100-md mt-30-sm mb-100-md mb-40-xs"
							id="invia">
							<liferay-ui:message key="label-richeste-interventi-invia" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>

$("#invia").click("on",function(){
	
	$("#listRichiesta").val(JSON.stringify(${json}));	
	$("#insertRichiesta").submit();

});


$("#modifica").click("on",function(){
	
	$("#richiesteInterventi").val(JSON.stringify(${json}));
	
	$("#formModifica").submit();
	
});

$("#newReq").click("on",function(){
	
	$("#formNuovaRichiesta").submit();
	
});

</script>
