
	<div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="trasporti-riepilogo-richiesta"/></h2>
                    </div>
					<span class="title-general-trasporti mb-40-xs"><liferay-ui:message key="trasporti-riepilogo-info"/></span>
					
					</div>
            </div>
            <div class="ama-row">
                <div class="ama-col-md-12 mobile-no-padding">
                    <div class="wrapper-istanza-trasporti">
                        <div class="box-gray">
                            <div class="box-white">
                                <p class="name name-box-first"><%= richiedente.getNome()%> <%= richiedente.getCognome()%>:</p>
                                <div class="no-overflow">
                                    <div class="ama-row border-section">
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-codice-fiscale"/>:</span>
                                            <p class="info"><%= richiedente.getCodiceFiscale()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-provincia-nascita"/>:</span>
                                            <p class="info"><%= richiedente.getProvinciaNascita()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-data-nascita"/>:</span>
                                            <p class="info"><%= richiedente.getDataNascita()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-luogo-nascita"/>:</span>
                                            <p class="info"><%= richiedente.getLuogoNascita()%></p>
                                        </div>
                                    </div>
            
                                    <p class="name-section"><liferay-ui:message key="trasporti-residenza"/></p>
                                    <div class="ama-row border-section">
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-indirizzo"/>:</span>
                                            <p class="info"><%= richiedente.getIndirizzo()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-citta"/>:</span>
                                            <p class="info"><%= richiedente.getCitta()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-cap"/>:</span>
                                            <p class="info"><%= richiedente.getCap()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-provincia"/>:</span>
                                            <p class="info"><%= richiedente.getProvincia()%></p>
                                        </div>
                                    </div>
            
                                    <p class="name-section"><liferay-ui:message key="trasporti-assegnazione"/></p>
                                    <div class="ama-row">
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-dipartimento"/>:</span>
                                            <p class="info"><%= richiedente.getDipartimento()%></p>
                                        </div>
            							<c:if test='<%=richiedente.getComandato().equalsIgnoreCase("servizio")%>'>
											<div class="ama-col-md-3 ama-col-sm-6">
												<span class="section-information"><liferay-ui:message key="trasporti-servizio-dal"/>:</span>
												<p class="info"><%= richiedente.getServizioDal()%></p>
											</div>
										</c:if>
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-fascia-economica"/>:</span>
                                            <p class="info"><%= richiedente.getFasciaEconomica()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-mail"/>:</span>
                                            <p class="info"><%= richiedente.getMail()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="trasporti-dati-telefono"/>:</span>
                                            <p class="info"><%= richiedente.getTelefono()%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>            <div class="ama-row">
                <div class="ama-col-xs-12 mobile-no-padding">
                    <div class="wrapper-istanza-trasporti">
                        <div class="no-overflow">
                            <div class="box-gray">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="trasporti-rimborso-upper"/>:</span>
                                            <p class="info info-second-box">
											<c:if test="<%= !moduloRichiedente.getFlagTipoSpesa().equalsIgnoreCase("personale")%>">
												<liferay-ui:message key="trasporti-sezione-figli-carico"/>

											</c:if>
											<c:if test="<%= moduloRichiedente.getFlagTipoSpesa().equalsIgnoreCase("personale")%>">
												<liferay-ui:message key="trasporti-sezione-personale"/>
											</c:if>
											</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>            <div class="ama-row">
                <div class="ama-col-md-12 mobile-no-padding">
                    <div class="wrapper-istanza-trasporti">
                        <div class="box-gray margin-mob">
                            <div class="box-white ">
                                <div class="no-overflow">
								<c:if test="<%= !moduloRichiedente.getFlagTipoSpesa().equalsIgnoreCase("personale")%>">
                                <div class="ama-row border-section">
                                    <div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-nome-figlio"/>:</span>
                                        <p class="info"><%= moduloRichiedente.getNomeFiglio()%></p>
                                    </div>
                                    <div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-cognome-figlio"/>:</span>
                                        <p class="info"><%= moduloRichiedente.getCognomeFiglio()%></p>
                                    </div>
            
                                    <div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-codice-fiscale-figlio"/>:</span>
                                        <p class="info"><%= moduloRichiedente.getCfFiglio()%></p>
                                    </div>
            
                                    <div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-data-nascita-figlio"/>:
										</span>
                                        <p class="info"><%= moduloRichiedente.getDataNascitaFiglio()%></p>
                                    </div>
									<div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-luogo-nascita-figlio"/>:
										</span>
                                        <p class="info"><%= moduloRichiedente.getLuogoNascitaFiglio()%></p>
                                    </div>
                                </div>
							</c:if>
                                <div class="ama-row mt-30-md mt-30-xs mt-30-sm">
                                    <div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-iban"/>:</span>
                                        <p class="info"><%= moduloRichiedente.getIban()%></p>
                                    </div>
            
                                    <div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-rimborso"/>:</span>
                                        <p class="info"><%= moduloRichiedente.getImporto()%></p>
                                    </div>
            
                                    <div class="ama-col-md-3 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-viaggio"/>:</span>
                                        <p class="info"><%= moduloRichiedente.getTipoViaggio()%></p>
                                    </div>
            
                                    <div class="ama-col-md-3 ama-col-sm-6">
										<c:choose> 
										<c:when test='<%= moduloRichiedente.getTipoViaggio()!=null && moduloRichiedente.getTipoViaggio().equalsIgnoreCase("mensile")%>'>

											<span class="section-information"><liferay-ui:message key="trasporti-numero-titoli-viaggio"/>:</span>
											<p class="info">
												<%= moduloRichiedente.getNumeroViaggi()%>
											
											</p>
										</c:when>
										<c:otherwise>
											<span class="section-information"><liferay-ui:message key="trasporti-data-acquisto"/>:</span>
											<p class="info">
												<%= moduloRichiedente.getDataAcquistoViaggio()%>
											
											</p>
										</c:otherwise>
										</c:choose>
                                    </div>
            
                                    <div class="ama-col-md-12 ama-col-xs-12">
                                        <span class="section-information"><liferay-ui:message key="trasporti-descrizione"/>:</span>
                                        <p class="info"><%= moduloRichiedente.getDescrizione()%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper-allegati-general">
			<c:if test="<%= moduloRichiedente.getAllegato()!=null %>">
                <div class="ama-row">
                    <div class="ama-col-md-12">
                        <div class="wrapper-title-general">
                            <h2 class="title-box borders"><liferay-ui:message key="trasporti-allegati"/></h2>
                        </div>
                    </div>
                </div>
			

                <div class="ama-row">
                    <div class="ama-col-md-12 mobile-no-padding">
                        <div class="wrapper-content">
								
							<div class="wrapper-white">
								<p class="text"><%=moduloRichiedente.getAllegatoNome()%></p>
							</div>
									
						  
						
						</div>
                    </div>
                </div>
            </c:if>
            
                <div class="container-button-allegati">
                    <div class="ama-row">
                        <div class="ama-col-sm-6">
                            <button href="#" type="button" onclick="goBack()" class="button button-secondary"><liferay-ui:message key="trasporti-modifica"/></button>
                        </div>
                        <div class="ama-col-sm-6">
                            <button href="#" type="button" onclick="inviaModulo()" class="button button-primary"><liferay-ui:message key="trasporti-invia"/></button>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
		
		<portlet:actionURL name="eventoRichiestaRimborso" var="eventoRichiestaRimborso" >
			<portlet:param name="Iban" value="<%=moduloRichiedente.getIban()%>" />
			<portlet:param name="Importo" value="<%=moduloRichiedente.getImporto()%>" />
			<portlet:param name="TipoViaggio" value="<%=moduloRichiedente.getTipoViaggio()%>" />
			<portlet:param name="NumeroViaggi" value="<%=moduloRichiedente.getNumeroViaggi()%>" />
			<portlet:param name="DataAcquistoViaggio" value="<%=moduloRichiedente.getDataAcquistoViaggio()%>" />
			<portlet:param name="Descrizione" value="<%=moduloRichiedente.getDescrizione()%>" />
			<portlet:param name="FlagTipoSpesa" value="<%=moduloRichiedente.getFlagTipoSpesa()%>" />
			<portlet:param name="NomeFiglio" value="<%=moduloRichiedente.getNomeFiglio()%>" />
			<portlet:param name="CognomeFiglio" value="<%=moduloRichiedente.getCognomeFiglio()%>" />
			<portlet:param name="LuogoNascitaFiglio" value="<%=moduloRichiedente.getLuogoNascitaFiglio()%>" />
			<portlet:param name="CFFiglio" value="<%=moduloRichiedente.getCfFiglio()%>" />
			<portlet:param name="DataNascitaFiglio" value="<%=moduloRichiedente.getDataNascitaFiglio()%>" />
			<portlet:param name="AllegatoNome" value="<%=moduloRichiedente.getAllegatoNome()%>" />
			<portlet:param name="AllegatoMimeType" value="<%=moduloRichiedente.getAllegatoMimeType()%>" />
			<portlet:param name="Allegato" value="<%=moduloRichiedente.getAllegato().getAbsolutePath()%>" />


		</portlet:actionURL>
		<form id="<portlet:namespace/>goBack" action="<%=eventoRichiestaRimborso%>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="<portlet:namespace/>evento" value="modifica">
		</form>
		
		

		<form id="<portlet:namespace/>inviaModuloRichiestaRimborso" action="<%=eventoRichiestaRimborso%>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="<portlet:namespace/>evento" value="invia">
		</form>
		
<script type="text/javascript">

	var flagInvio = true;
	
	function goBack(){
		$("#<portlet:namespace/>goBack").submit();
	}

	function inviaModulo(){
		
		if( flagInvio ) {
			flagInvio = false;
			$("#<portlet:namespace/>inviaModuloRichiestaRimborso").submit();
		}
	}
	
</script>

