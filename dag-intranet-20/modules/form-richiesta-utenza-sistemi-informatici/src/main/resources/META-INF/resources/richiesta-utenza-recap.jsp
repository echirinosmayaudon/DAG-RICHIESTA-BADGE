<c:if test="<%=request.getAttribute("sessionError")!=null && request.getAttribute("sessionError")=="inserimento"%>">
		<liferay-ui:error key="errore-durante-inserimento-richiesta"
			message="Inserimento non avvenuto"></liferay-ui:error>
</c:if>
 <c:if test="<%=request.getAttribute("sessionError")!=null && request.getAttribute("sessionError")=="email"%>">
		<liferay-ui:error key="errore-durante-invio-email"
			message="Inserire l'email del referente da configurazione"></liferay-ui:error>
</c:if>

<portlet:actionURL name="invioRichiestaUtenza" var="invioRichiestaUtenzaURL"></portlet:actionURL>

<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                    <h2 class="title">
       				<%=recapTitle%>
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
                <h2 class="title-box borders"><liferay-ui:message key="label-richesteutenza-dati-riepilogo-richiesta"/></h2>
            </div>
        </div>
    </div>
     <form action="<%=invioRichiestaUtenzaURL%>" method="post" id="<portlet:namespace/>formInvia" enctype="multipart/form-data">
    <div class="ama-row">
            <div class="ama-col-xs-12 mobile-no-padding">
                <div class="wrapper-istanza-trasporti mobile-no-padding">
                <div class="box-gray">
               
                    <div class=" box-white pb-0-xs">
                        <p class="name">${nome} ${cognome}</p>
                        <input type="hidden" name="<portlet:namespace/>nome" value="${nome}" /> 
					    <input type="hidden" name="<portlet:namespace/>cognome" value="${cognome}" /> 	
                        <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
    
                        <div id="collapse-trasporti" class="collapse1 in no-overflow">
                            <div class="ama-row border-section border-mobile">
                                <div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
                                    <span class="section-information"><liferay-ui:message key="label-richesteutenza-ufficio-richiedente"/>:</span>
                                    <p class="info">${ufficioRichiedente}</p>
                                    <input type="hidden" name="<portlet:namespace/>ufficioRichiedente" value="${ufficioRichiedente}" /> 
                                </div>
                            </div>
    
                            <div class="ama-row">
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richesteutenza-dati-ubicazione"/>:</span>
                                    <p class="info">${ubicazioneAttuale}</p>
                                    <input type="hidden" name="<portlet:namespace/>ubicazioneAttuale" value="${ubicazioneAttuale}" /> 
                                </div>
    
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-sm"><liferay-ui:message key="label-richesteutenza-dati-palazzina"/>:</span>
                                    <p class="info">${palazzina}</p>
                                     <input type="hidden" name="<portlet:namespace/>palazzina" value="${palazzina}" /> 
                                </div>
    
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md"><liferay-ui:message key="label-richesteutenza-dati-piano"/>:</span>
                                    <p class="info">${piano}</p>
                                    <input type="hidden" name="<portlet:namespace/>piano" value="${piano}" /> 
                                </div>
    
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md"><liferay-ui:message key="label-richesteutenza-dati-scala"/>:</span>
                                    <p class="info">${scala}</p>
                                      <input type="hidden" name="<portlet:namespace/>scala" value="${scala}" /> 
                                </div>
    
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information"><liferay-ui:message key="label-richesteutenza-dati-stanza"/>:</span>
                                    <p class="info">${stanza}</p>
                                     <input type="hidden" name="<portlet:namespace/>stanza" value="${stanza}" /> 
                                </div>
    
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information"><liferay-ui:message key="label-richesteutenza-dati-telefono"/>:</span>
                                    <p class="info">${telefono}</p>
                                     <input type="hidden" name="<portlet:namespace/>telefono" value="${telefono}" /> 
                                </div>
    
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information"><liferay-ui:message key="label-richesteutenza-dati-email-dirigente"/>:</span>
                                    <p class="info">${emailDirigente}</p>
                                    <input type="hidden" name="<portlet:namespace/>emailDirigente" value="${emailDirigente}" /> 
                                </div>
                            </div>
                        </div>
                    </div>
                  
                </div>
            </div>
        </div>
    </div>
    <div class="ama-row">
        <div class="ama-col-xs-12 mobile-no-padding">
            <div class="wrapper-istanza-trasporti">
                <div class="no-overflow">
                    <div class="box-gray padding-mobile-servizi">
                        <div class="box-white">
                            <div class="ama-row">
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richesteutenza-dati-nome-asset-pc"/></span>
                                    <p class="info">${assetPc}</p>
                                    <input type="hidden" name="<portlet:namespace/>assetPc" value="${assetPc}" /> 
                                </div>
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richesteutenza-dati-nome-applicazione"/></span>
                                    <p class="info">${applicazione}</p>
                                     <input type="hidden" name="<portlet:namespace/>applicazione" value="${applicazione}" /> 
                                </div>
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richesteutenza-dati-codice-fiscale"/></span>
                                    <p class="info">${codiceFiscale}</p>
                                     <input type="hidden" name="<portlet:namespace/>codiceFiscale" value="${codiceFiscale}" /> 
                                </div>
                                <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richesteutenza-dati-nuova-utenza"/></span>
                             		<p class="info">
	                                    <c:if test="${utenza == 1}">
	                                    	<liferay-ui:message key="label-richesteutenza-dati-utenza-nuova"/>
	                                    </c:if>
	                                    
	                                    <c:if test="${utenza == 2}">
	                                    	<liferay-ui:message key="label-richesteutenza-dati-utenza-disabilita"/>
	                                    </c:if>
                                    </p>
                                    <input type="hidden" name="<portlet:namespace/>utenza" value="${utenza}" /> 
                                </div>
                                
                                <div class="ama-col-md-6 ama-col-xs-12">
                    				<span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richesteutenza-dati-cambio-ufficio"/>:</span>
                        			<p class="info">${cambioUfficio}</p>
                         			<input type="hidden" name="<portlet:namespace/>cambioUfficio" value="${cambioUfficio}" />
                				</div>
				                <div class="ama-col-md-6 ama-col-xs-12">
				                     <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richesteutenza-dati-reset-password"/>:</span>
				                        <p class="info">${resetPassword}</p>
				                        <input type="hidden" name="<portlet:namespace/>resetPassword" value="${resetPassword}" />
				                </div>
				                </div>
                        </div>
                    </div>
                </div>
                  </form>
                <div class="text-center">
                	<portlet:actionURL name="gotoRichiestaUtenza" var="gotoRichiestaUtenzaURL" />
                     <div class="ama-col-md-4 ama-col-xs-12">
                     	<form action="<%=gotoRichiestaUtenzaURL%>" method="post" id="<portlet:namespace/>formNuovaRichiesta">
                        	<button href="#" type="button" id="<portlet:namespace/>newReq" class="button button-secondary mt-100-md mt-30-sm mb-100-md"><liferay-ui:message key="label-richesteutenza-option-nuovarichiesta"/>
                        	 </button>
                        </form>
                    </div>
						<portlet:actionURL name="gotoModifRichiesta" var="richUtenzaURL">
						<portlet:param name="nome" value="${nome}" />
						<portlet:param name="cognome" value="${cognome}" />
						<portlet:param name="ufficioRichiedente" value="${ufficioRichiedente}" />
						<portlet:param name="ubicazioneAttuale" value="${ubicazioneAttuale}" />
						<portlet:param name="palazzina" value="${palazzina}" />
						<portlet:param name="piano" value="${piano}" />
						<portlet:param name="scala" value="${scala}" />
						<portlet:param name="stanza" value="${stanza}" />
						<portlet:param name="telefono" value="${telefono}" />
						<portlet:param name="emailDirigente" value="${emailDirigente}" />
						<portlet:param name="assetPc" value="${assetPc}" />
						<portlet:param name="applicazione" value="${applicazione}" />
						<portlet:param name="codiceFiscale" value="${codiceFiscale}" />
						<portlet:param name="utenza" value="${utenza}" />
						<portlet:param name="cambioUfficio" value="${cambioUfficio}" />
						<portlet:param name="resetPassword" value="${resetPassword}" />
                   </portlet:actionURL>
                    <div class="ama-col-md-4 ama-col-xs-12">
                    	<form action="<%=richUtenzaURL%>" method="post" id="<portlet:namespace/>formModifica" enctype="multipart/form-data">
                        	<button href="#" type="button" id="<portlet:namespace/>modifica" class="button button-secondary mt-100-md mt-30-sm mb-100-md"><liferay-ui:message key="label-richesteutenza-option-modifica"/></button>
                         </form>
                    </div>
                   
                     
    			
                    <div class="ama-col-md-4 ama-col-xs-12">
                    
                        <button href="#" id="<portlet:namespace/>invia"  type="button" class="button button-primary mt-100-md mt-30-sm mb-100-md mb-40-xs"><liferay-ui:message key="label-richesteutenza-option-invia"/>
                        </button>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>

</div>


<script>
$("#<portlet:namespace/>invia").click("on",function(){
	$("#<portlet:namespace/>formInvia").submit();		
});
	
$("#<portlet:namespace/>modifica").click("on",function(){
	$("#<portlet:namespace/>formModifica").submit();	
});

$("#<portlet:namespace/>newReq").click("on",function(){
	$("#<portlet:namespace/>formNuovaRichiesta").submit();	
});
</script>
