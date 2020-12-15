<%@page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<% 
	
	
String param_figlioClass ="collapse";
String param_personaleClass="collapse in";
String param_personaleClassActive="active";
String param_figlioClassActive="";

if (moduloRichiedente.getFlagTipoSpesa() != null && moduloRichiedente.getFlagTipoSpesa().equalsIgnoreCase("figli a carico")){
		param_personaleClass = "collapse";
		param_figlioClass="collapse in";
		param_figlioClassActive="active";
		param_personaleClassActive="";

}

String path="";


String displayAllegato ="display:none";
String displayNoAllegato="display:block";
if (moduloRichiedente.getAllegato()!=null){
	path=moduloRichiedente.getAllegato().getAbsolutePath();
	displayAllegato="display:block";
	displayNoAllegato="display:none";
}
%>
   

   <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="trasporti-dati-richiedente"/></h2>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                    <div class="ama-col-xs-12 mobile-no-padding">
                        <div class="wrapper-istanza-trasporti mobile-no-padding">
                        	<div class="box-gray">
	                            <div class=" box-white pb-0-xs">
	                                <p class="name"><%= richiedente.getNome()%> <%= richiedente.getCognome()%></p>
	                                <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
	                                <div id="collapse-trasporti" class="collapse1 in no-overflow">
	                                    <div class="ama-row border-section border-mobile">
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
            </div>
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
                    <div class="tab-filtri filtro-categoria collapse-group mobile-trasporti" id="tabs-profile">
                        <div class="filtro-tabs-wrapper mr-0-xs mt-0-xs ml-0-xs">
                            <a href="" title='<liferay-ui:message key="trasporti-richiede-per-se"/>' class="tab-title <%= param_personaleClassActive%>" data-toggle="collapse" data-target="#for-itself" data-parent="#tabs-profile" onclick="resetForm()"><liferay-ui:message key="trasporti-per-se"/></a>
                            <a href="" title='<liferay-ui:message key="trasporti-richiede-per-figlio"/>' class="tab-title <%= param_figlioClassActive%>" data-toggle="collapse" data-target="#for-child" data-parent="#tabs-profile" onclick="resetForm()"><liferay-ui:message key="trasporti-per-figli"/></a>
                        </div>
                        <portlet:actionURL name="richiestaRimborso" var="richiestaRimborso" >
							<portlet:param name="AllegatoNome" value="<%=moduloRichiedente.getAllegatoNome()%>" />
							<portlet:param name="AllegatoMimeType" value="<%=moduloRichiedente.getAllegatoMimeType()%>" />
						</portlet:actionURL> 
												
						
							<div id="for-itself" class="<%= param_personaleClass%>">
							<form data-parsley-validate="true"  id="<portlet:namespace/>richiestaRimborsoPersonale" action="<%=richiestaRimborso%>" method="post" enctype="multipart/form-data">

                            	<div class="wrapper-istanza-trasporti">
                                        <div class="box-gray no-margin">
                                            <div class="box-white box-gray-mobile">
                                                <p class="name-section"><liferay-ui:message key="trasporti-dati-rimborso"/></p>
												
												<input type="hidden" id="<portlet:namespace/>vecchioAllegatoPersonale" name="<portlet:namespace/>VecchioAllegato" class="removeFieldFormTrasporti" value="<%= path%>">		

												
												<input type="hidden" id="<portlet:namespace/>FlagTipoSpesa" name="<portlet:namespace/>FlagTipoSpesa" >		
												<div class="ama-row">
                                                	<div class="ama-col-md-6 ama-col-xs-12">
                                                     	<label for="argument" class="label-form "><liferay-ui:message key="trasporti-iban"/>*  <a href="#" title='<liferay-ui:message key="trasporti-info-iban"/>' class="tooltip-field icon-information">
                                                                    <span class="icomoon-info ico-info-tooltip"></span>
                                                                </a></label>
                                                		<input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
                                                		 	data-parsley-pattern="[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}"
                                                            data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                		 	id="<portlet:namespace/>argumentIbanPersonale" name="<portlet:namespace/>Iban" class="input-custom-light data-parsley-validated removeFieldFormTrasporti" 
															placeholder="<liferay-ui:message key="trasporti-iban-placeholder"/>" 
															value="<%= moduloRichiedente.getIban()%>">
                                                    </div>
                                                    <div class="ama-col-md-6 ama-col-xs-12">
                                                    	<label for="argument2" class="label-form mt-25-xs mt-0-md"><liferay-ui:message key="trasporti-importo-rimborso-spese"/>*</label>
                                                        <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
                                                        	data-parsley-pattern="^[1-9][0-9]{0,2}(?:\.?[0-9]{3}){0,3}(,[0-9]{2})?$" 
                                                            data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
														
                                                        	id="<portlet:namespace/>argumentImportoPersonale" name="<portlet:namespace/>Importo" class="input-custom-light data-parsley-validated removeFieldFormTrasporti" 
															placeholder="<liferay-ui:message key="trasporti-importo-rimborso-spese-placeholder"/>" value="<%= moduloRichiedente.getImporto()%>">
                                                    </div>
												</div>
												   <div class="ama-row">

													<div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
                                                            <label for="radio3" class="label-form margin-top"><liferay-ui:message key="trasporti-tipologia-viaggio"/>*</label>
																<c:if test="<%=moduloRichiedente.getTipoViaggio().equalsIgnoreCase("mensile")%>">
																	<div class="box-radio-custom">				
																		<input checked id="radio1" name="<portlet:namespace/>TipoViaggio" value="mensile" type="radio" class="radio-custom-dark">
																		<label for="radio1" class="radio-custom-desc">
																			<span><liferay-ui:message key="trasporti-mensile"/></span>
																		</label>
																	</div>
																	<div class="box-radio-custom">
																		<input id="radio2" name="<portlet:namespace/>TipoViaggio" value="annuale" type="radio" class="radio-custom-dark">
																		<label for="radio2" class="radio-custom-desc">
																			<span><liferay-ui:message key="trasporti-annuale"/></span>
																		</label>
																	</div>
																</c:if>
																 	<c:if test="<%=moduloRichiedente.getTipoViaggio().equalsIgnoreCase("annuale")%>">
																	<div class="box-radio-custom ">
																		<input id="radio1" name="<portlet:namespace/>TipoViaggio" value="mensile" type="radio" class="radio-custom-dark">
																		<label for="radio1" class="radio-custom-desc">
																			<span><liferay-ui:message key="trasporti-mensile"/></span>
																		</label>
																	</div>
																	<div class="box-radio-custom ">
																		<input checked id="radio2" name="<portlet:namespace/>TipoViaggio" value="annuale" type="radio" class="radio-custom-dark">
																		<label for="radio2" class="radio-custom-desc">
																			<span><liferay-ui:message key="trasporti-annuale"/></span>
																		</label>
																	</div>
																</c:if>
                                                        </div>
                                                       <div id="<portlet:namespace/>mensileAnnualePersonale" class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
																<label class='label-form margin-top'></label>

																<input id="<portlet:namespace/>annualePersonale" class="input-custom-light datepicker-custom removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-annuale-personale'/>"  
																	name="<portlet:namespace/>DataAcquistoViaggio" value="<%= moduloRichiedente.getDataAcquistoViaggio()%>">
																	
																<input id="<portlet:namespace/>mensilePersonale" name="<portlet:namespace/>NumeroViaggi" 
																class="input-custom-light removeFieldFormTrasporti" placeholder="<liferay-ui:message key="trasporti-numero-titoli-viaggi-placeholder"/>" value="<%= moduloRichiedente.getNumeroViaggi()%>"
																>	
															</div>	
														</div>	
												<div class="ama-row">														
                                                        <div class="ama-col-md-12 ama-col-xs-12">
                                                            <div class="wrapper-content-textarea">
                                                                <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="trasporti-descrizione"/></label>
                                                                <textarea  
                                                                	data-parsley-maxlength="500" 
                                                                	data-parsley-minlength="10" 
																	data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>" 
                                                					data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
                                                                	data-parsley-validation-threshold="10"
                                                                	name="<portlet:namespace/>Descrizione"
                                                                	class="form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti" 
                                                                	id="<portlet:namespace/>textarea-detail"  placeholder="<liferay-ui:message key="trasporti-descrizione-placeholder"/>" ><%= moduloRichiedente.getDescrizione()%></textarea>
                                                                <div class="content-textarea" >0/
                                                                    <p class="color-gray">500</p>
                                                                </div>
                                                            </div>
                                                        </div>
														</div>
														
                                                    </div>
                                            </div>
                                        </div>
										<div class="wrapper-allegati-general">
                <div class="ama-row">
                    <div class="ama-col-md-12">
                        <div class="wrapper-title-general">
                            <h2 class="title-box borders"><liferay-ui:message key="trasporti-allegati"/>*</h2>
							<a href="#" title='<liferay-ui:message key="trasporti-info-allegato"/>' class="tooltip-field">
								<span class="icomoon-info ico-attachments"></span>
							</a>
                        </div>
                    </div>
                </div>
				
						<div class="ama-row" style="<%=displayAllegato%>" id="<portlet:namespace/>fileAttachDivPersonale">

						<div class="ama-col-md-12 mobile-no-padding">
						<div class="wrapper-content">
								<div class="wrapper-white">
									<p class="text" id="<portlet:namespace/>fileNamePersonale"> <%= moduloRichiedente.getAllegatoNome()%>
									<a href="#" title="elimina file" id="<portlet:namespace/>removeFilePersonale"  onclick='removeAllegato("Personale")' class="icomoon-close-white ico-delete"></a></p>
								</div>
									
						  
						
						</div>
						</div>
						</div>
						
							 <div class="ama-row" style="<%=displayNoAllegato%>" id="<portlet:namespace/>selectFilePersonale">
								<div class="ama-col-md-12 mobile-no-padding">
									<div class="box-button">
									
										<button href="#" type="button" id="<portlet:namespace/>addAttachFilePersonale" class="button button-primary" ><liferay-ui:message key="trasporti-selezione-file"/></button>
									</div>
								</div>
							</div>
					<div id="allegatoDivPersonale">
									
					</div>
                    <div class="container-button-general-allegati">
                        <div class="ama-row">
                            <div class="ama-col-sm-12">
                                <button href="#" type="button" class="button button-primary margin-top" onclick="saveForm()" ><liferay-ui:message key="trasporti-prosegui"/></button>
                            </div>
                        </div>
                    </div>    
            </div> 
			</form>
										
										
										
                                    </div>
                       
                        <div id="for-child" class="<%= param_figlioClass%>">    
									<form data-parsley-validate="true"  id="<portlet:namespace/>richiestaRimborsoFiglio" action="<%=richiestaRimborso%>" method="post" enctype="multipart/form-data">

                                    <div class="wrapper-istanza-trasporti">
                                        <div class="box-gray no-margin">
                                            <div class="box-white box-gray-mobile">
                                                <p class="name-section"><liferay-ui:message key="trasporti-dati-personali-figlio"/></p>
												<input type="hidden" id="<portlet:namespace/>vecchioAllegatoFiglio" name="<portlet:namespace/>VecchioAllegato" class="removeFieldFormTrasporti" value="<%= path%>">		

												<input type="hidden" id="<portlet:namespace/>FlagTipoSpesaFiglio" name="<portlet:namespace/>FlagTipoSpesa" >			
                                                   
												   <div class="ama-row">	            
                                                        <div class="ama-col-md-6 ama-col-xs-12">
                                                            <label for="argument" class="label-form "><liferay-ui:message key="trasporti-nome-figlio"/>*</label>
                                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
                                                            	id="<portlet:namespace/>argumentNomeFiglio"  name="<portlet:namespace/>NomeFiglio" 
																class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key="trasporti-nome-figlio-placeholder"/>" value="<%= moduloRichiedente.getNomeFiglio()%>">
                                                        </div>
                                                         <div class="ama-col-md-6 ama-col-xs-12">
                                                            <label for="argument2" class="label-form mt-25-xs mt-0-md"><liferay-ui:message key="trasporti-cognome-figlio"/>*</label>
                                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
                                                            	id="<portlet:namespace/>argumentCognomeFiglio" name="<portlet:namespace/>CognomeFiglio" 
																class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key="trasporti-cognome-figlio-placeholder"/>" value="<%= moduloRichiedente.getCognomeFiglio()%>">
                                                        </div>
                                                        <div class="ama-col-md-3 ama-col-xs-12">
                                                            <label for="argument3" class="label-form margin-top"><liferay-ui:message key="trasporti-codice-fiscale-figlio"/>*</label>
                                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
                                                            	data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                            	id="<portlet:namespace/>argumentCFfiglio"  name="<portlet:namespace/>CFFiglio" 
																class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key="trasporti-codice-fiscale-figlio-placeholder"/>" value="<%= moduloRichiedente.getCfFiglio()%>">
                                                        </div>
                                                        <div class="ama-col-md-3 ama-col-xs-12">
                                                            <label class="label-form margin-top"><liferay-ui:message key="trasporti-data-nascita-figlio"/>*</label>
                                                            <input
																id="<portlet:namespace/>dataNascitaFiglio"
																data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  
                                                                data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/\d\d\d\d/"
                                                            	data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                             	name="<portlet:namespace/>DataNascitaFiglio"
																class="input-custom-light datepicker-custom removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-data-nascita'/>" 
																value="<%= moduloRichiedente.getDataNascitaFiglio()%>">
                                                        </div>
														 <div class="ama-col-md-6 ama-col-xs-12">
                                                            <label for="<portlet:namespace/>LuogoNascitaFiglio" class="label-form margin-top"><liferay-ui:message key="trasporti-luogo-nascita-figlio"/>*</label>
                                                              <input  
                                                             	id="<portlet:namespace/>LuogoNascitaFiglio"
																data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'  
																name="<portlet:namespace/>LuogoNascitaFiglio" class="input-custom-light data-parsley-validated removeFieldFormTrasporti"  
																value="<%= moduloRichiedente.getLuogoNascitaFiglio()%>" placeholder="<liferay-ui:message key="trasporti-luogo-nascita-figlio-placeholder"/>">
                                                        </div>
                                                    </div>
                                                    <p class="name-section"><liferay-ui:message key="trasporti-dati-rimborso"/></p>
                                                    <div class="ama-row">
                                                        <div class="ama-col-md-6 ama-col-xs-12">
                                                            <label for="argument6" class="label-form "><liferay-ui:message key="trasporti-iban"/>* 
															<a href="#" title='<liferay-ui:message key="trasporti-info-iban"/>' class="tooltip-field icon-information">
                                                                    <span class="icomoon-info ico-info-tooltip"></span>
                                                                </a></label>
                                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                                            	data-parsley-pattern="[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}"
                                                            	data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                            	id="<portlet:namespace/>argumentIbanFiglio" name="<portlet:namespace/>Iban" 
																class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-data-iban'/>"
																value="<%= moduloRichiedente.getIban()%>">
                                                        </div>
                                                        <div class="ama-col-md-6 ama-col-xs-12">
                                                            <label for="argument7" class="label-form mt-25-xs mt-0-md"><liferay-ui:message key="trasporti-importo-rimborso-spese"/>*</label>
                                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                                            	data-parsley-pattern="^[1-9][0-9]{0,2}(?:\.?[0-9]{3}){0,3}(,[0-9]{2})?$" 
                                                            	data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                            	id="<portlet:namespace/>argumentImportoFiglio" name="<portlet:namespace/>Importo" 
																class="input-custom-light data-parsley-validated removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-import-figlio'/>"
																value="<%= moduloRichiedente.getImporto()%>">
                                                        </div>
                                                    </div>
                                                    <div class="ama-row">
                                                        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
                                                            <label class="label-form margin-top"><liferay-ui:message key="trasporti-tipologia-viaggio"/>*</label>
															<c:if test="<%=moduloRichiedente.getTipoViaggio().equalsIgnoreCase("mensile")%>">
														   
															   <div class="box-radio-custom ">
																	<input id="radio3" checked="" name="<portlet:namespace/>TipoViaggio" value="mensile" type="radio" class="radio-custom-dark">
																	<label for="radio3" class="radio-custom-desc">
																		<span><liferay-ui:message key="trasporti-mensile"/></span>
																	</label>
																</div>
																<div class="box-radio-custom">
																	<input id="radio4" name="<portlet:namespace/>TipoViaggio" value="annuale" type="radio" class="radio-custom-dark">
																	<label for="radio4" class="radio-custom-desc">
																		<span><liferay-ui:message key="trasporti-annuale"/></span>
																	</label>
																</div>
															</c:if>
															<c:if test="<%=moduloRichiedente.getTipoViaggio().equalsIgnoreCase("annuale")%>">
														   
															   <div class="box-radio-custom ">
																	<input id="radio3"  name="<portlet:namespace/>TipoViaggio" value="mensile" type="radio" class="radio-custom-dark">
																	<label for="radio3" class="radio-custom-desc">
																		<span><liferay-ui:message key="trasporti-mensile"/></span>
																	</label>
																</div>
																<div class="box-radio-custom">
																	<input id="radio4" checked="" name="<portlet:namespace/>TipoViaggio" value="annuale" type="radio" class="radio-custom-dark">
																	<label for="radio4" class="radio-custom-desc">
																		<span><liferay-ui:message key="trasporti-annuale"/></span>
																	</label>
																</div>
															</c:if>
														</div>
															<div id="<portlet:namespace/>mensileAnnualeFiglio" class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
																<label class='label-form margin-top'></label>

																	<input id="<portlet:namespace/>annualeFiglio" class="input-custom-light datepicker-custom removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-annuale-figlio'/>" 
																	name="<portlet:namespace/>DataAcquistoViaggio" value="<%= moduloRichiedente.getDataAcquistoViaggio()%>">
																	
																<input id="<portlet:namespace/>mensileFiglio" name="<portlet:namespace/>NumeroViaggi" 
																class="input-custom-light removeFieldFormTrasporti" placeholder="<liferay-ui:message key='trasporti-insert-placeholder-mensile'/>" value="<%= moduloRichiedente.getNumeroViaggi()%>"
																>	
															
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
                                                                	name="<portlet:namespace/>Descrizione"
                                                                	class="form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti" id="<portlet:namespace/>textarea-detail" 
																	
																	placeholder="<liferay-ui:message key='trasporti-insert-placeholder-descrizione'/>"><%= moduloRichiedente.getDescrizione()%></textarea>
                                                                <div class="content-textarea" >
                                                                	0/
                                                                    <p class="color-gray">500</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

													
													
													

				
													

                                            </div>    
                                          </div>
                                        </div>
										
										
				<div class="wrapper-allegati-general">
                <div class="ama-row">
                    <div class="ama-col-md-12">
                        <div class="wrapper-title-general">
                            <h2 class="title-box borders"><liferay-ui:message key="trasporti-allegati"/>*</h2>
							<a href="#" title='<liferay-ui:message key="trasporti-info-allegato"/>' class="tooltip-field">
								<span class="icomoon-info ico-attachments"></span>
							</a>
                        </div>
                    </div>
                </div>
				
						<div class="ama-row" style="<%=displayAllegato%>" id="<portlet:namespace/>fileAttachDivFiglio">

						<div class="ama-col-md-12 mobile-no-padding">
						<div class="wrapper-content">
								<div class="wrapper-white">
									<p class="text" id="<portlet:namespace/>fileNameFiglio"> <%= moduloRichiedente.getAllegatoNome()%>
									<a href="#" title="elimina file" id="<portlet:namespace/>removeFileFiglio"  onclick='removeAllegato("Figlio")' class="icomoon-close-white ico-delete"></a></p>
								</div>
									
						  
						
						</div>
						</div>
						</div>
						
							 <div class="ama-row" style="<%=displayNoAllegato%>" id="<portlet:namespace/>selectFileFiglio">
								<div class="ama-col-md-12 mobile-no-padding">
									<div class="box-button">
									
										<button href="#" type="button" id="<portlet:namespace/>addAttachFileFiglio" class="button button-primary" ><liferay-ui:message key="trasporti-selezione-file"/></button>
									</div>
								</div>
							</div>
					<div id="allegatoDivFiglio">
									
						</div>
						<div class="container-button-general-allegati">
					
                        <div class="ama-row">
                            <div class="ama-col-sm-12">
                                <button href="#" type="button" class="button button-primary margin-top" onclick="saveForm()" ><liferay-ui:message key="trasporti-prosegui"/></button>
                            </div>
                        </div>
                    </div>    
            </div> 
										</form>
                        		</div>
                    </div>
                </div>	
            </div>
			</div>


<script type="text/javascript">
	
	
	var displayNoAllegato =  "<%=displayNoAllegato%>";


	var idAttachFileDiv="#<portlet:namespace/>fileAttachDiv";
	
	var idButtonAddAttachFile = "#<portlet:namespace/>addAttachFile";
	var idFileAttachForm = "#<portlet:namespace/>fileAttachForm";
	var idFileAttach = "#<portlet:namespace/>fileAttach";

	var idSelectFile = "#<portlet:namespace/>selectFile";

	
	var idFlagTipoSpesaPersonale = "#<portlet:namespace/>FlagTipoSpesa";
	var idFlagTipoSpesaFiglio = "#<portlet:namespace/>FlagTipoSpesaFiglio";
	var idVecchioAllegato = "#<portlet:namespace/>vecchioAllegato";
	var idRemoveAllegato="#<portlet:namespace/>removeFile";
	
	
	var idForm = "#<portlet:namespace/>richiestaRimborso";

	var idMensilePersonale = "<portlet:namespace/>mensilePersonale";
	var idAnnualePersonale = "<portlet:namespace/>annualePersonale";

	var idMensileFiglio = "<portlet:namespace/>mensileFiglio";
	var idAnnualeFiglio = "<portlet:namespace/>annualeFiglio";
	
	var idFileName= "#<portlet:namespace/>fileName";
	var mensileAnnualeFiglioDiv = "#<portlet:namespace/>mensileAnnualeFiglio";
	var mensileAnnualePersonaleDiv = "#<portlet:namespace/>mensileAnnualePersonale";
	
	
	
	
	 
	
	if(displayNoAllegato == "display:block"){
		addParsleyFile("Figlio");
		addParsleyFile("Personale");
	}
	
	function addParsleyFile(tab){
		
		$("#allegatoDiv"+tab).text("");
		var input = document.createElement("input");
		
		$(input).attr("id","<portlet:namespace/>fileAttach"+tab);
		$(input).attr("name","<portlet:namespace/>Allegato");
		$(input).attr("type","file");
		$(input).css("display","none");
		$(input).attr("accept",".pdf,.jpg,.jepg,.png,.bmp");
		
		$(input).attr("data-parsley-filemaxmegabytes","1");
		$(input).attr("data-parsley-trigger","change");
		$(input).attr("data-parsley-required","true");
		$(input).attr("data-parsley-required-message","<liferay-ui:message key='error-mandatory'/>");
		$(input).attr("data-parsley-check-file-attach-extension",".jpeg,.png,.jpg,.bmp,.pdf");
		
		$(input).change(function() {
			changeDisplay(tab,this.value);
		});
		$("#allegatoDiv"+tab).append(input);
				
		
	}
	
	function resetForm(){
		$(idForm+"Figlio").find(".removeFieldFormTrasporti").each(function(){
				$(this).val("");
		});
		
	
		
		$(idForm+"Personale").find(".removeFieldFormTrasporti").each(function(){
			$(this).val("");
		});
		

		$(idForm+"Personale").find("textarea").each(function(){
		   $(this).next().text("0/500");
	
		});
		$(idForm+"Figlio").find("textarea").each(function(){
		   $(this).next().text("0/500");
	
		});
		
		resetAllegato("Personale");
		resetAllegato("Figlio");

		
		
	}
	
	function resetAllegato(tab){
		$(idAttachFileDiv+tab).css("display","none");
		$(idSelectFile+tab).css("display","block");	
		$(idVecchioAllegato+tab).val("");
		

	}
	
	function removeAllegato(tab){
		event.preventDefault();
		event.stopPropagation();
		$(idFileAttach+tab).val("");
		resetAllegato(tab);
		if(displayNoAllegato == "display:none"){
			addParsleyFile("Figlio");
			addParsleyFile("Personale");
		}
	}

	
	function changeDisplay(tab, val){

		$(idFileAttach+tab).parsley().validate();
		
		if (val!=null && val!="" && $(idFileAttach+tab).parsley().isValid()){
					$(idFileAttach+tab).parsley().destroy();

			var index = val.lastIndexOf('\\');
			var value= val.substring(index+1, val.length);
			$(idAttachFileDiv+tab).css("display","block");
			var arrayFiles=[];
			var insideText = "<a href='#' title='elimina file' onclick='removeAllegato("; 
			
			insideText = insideText.concat('"');
			insideText = insideText.concat(tab);
			insideText = insideText.concat('"');

			insideText = insideText.concat(");' class='icomoon-close-white ico-delete'></a>");
			
			$(idAttachFileDiv+tab).find(idFileName+tab).text(value);
			$(idAttachFileDiv+tab).find(idFileName+tab).append(insideText);
			$(idSelectFile+tab).css("display","none");
			$(idVecchioAllegato+tab).val("");

		}else{
			if(!$(idFileAttach+tab).parsley().isValid())
				resetAllegato(tab);
		
		}

	}
	
	

	
	
	$(idButtonAddAttachFile+"Figlio").on('click', function(event){

		addParsleyFile("Figlio");

		$(idFileAttach+"Figlio").click();
	});
	
	$(idButtonAddAttachFile+"Personale").on('click', function(event){
		addParsleyFile("Personale");
		$(idFileAttach+"Personale").click();
	});


	
	
	function checkAnnualeMensile(idForm, idDiv, idMensile, idAnnuale){
		if ($('input[name=<portlet:namespace/>TipoViaggio]:checked', idForm).val()=="mensile"){
				
				var annuale = $(idDiv).find("#"+idAnnuale);
				$(annuale).css("display","none");
				
				var mensile = $(idDiv).find("#"+idMensile); 
				$(mensile).css("display","block");

				$(idDiv).find("label").each(function(){
					$(this).attr("for", idMensile);
					$(this).text("<liferay-ui:message key='trasporti-numero-titoli-viaggi'/>*");
				}); 
		}else{
			if ($('input[name=<portlet:namespace/>TipoViaggio]:checked', idForm).val()=="annuale"){
			
				var mensile = $(idDiv).find("#"+idMensile); 
				$(mensile).css("display","none");

				var annuale = $(idDiv).find("#"+idAnnuale); 
				$(annuale).css("display","block");
		
				
				$(idDiv).find("label").each(function(){
					$(this).attr("for", idMensile);
					$(this).text("<liferay-ui:message key='trasporti-data-acquisto-titolo-viaggio'/>*");
				}); 
			                         
			
			}else{
				$(idDiv).text("");
			}
		}
	}
	
	checkAnnualeMensile(idForm+"Personale", mensileAnnualePersonaleDiv, idMensilePersonale, idAnnualePersonale);
	refreshParsley(idForm+"Figlio", "#"+idMensileFiglio, "#"+idAnnualeFiglio, "false");

	checkAnnualeMensile(idForm+"Figlio", mensileAnnualeFiglioDiv, idMensileFiglio, idAnnualeFiglio);
	refreshParsley(idForm+"Personale", "#"+idMensilePersonale, "#"+idAnnualePersonale, "false");		

	$(idForm+"Figlio" +' input[name=<portlet:namespace/>TipoViaggio]').on('change', function() {
	
		checkAnnualeMensile(idForm+"Figlio", mensileAnnualeFiglioDiv, idMensileFiglio, idAnnualeFiglio);
		refreshParsley(idForm+"Figlio", "#"+idMensileFiglio, "#"+idAnnualeFiglio);
	});
	$(idForm+"Personale"+' input[name=<portlet:namespace/>TipoViaggio]').on('change', function() {
	
		checkAnnualeMensile(idForm+"Personale", mensileAnnualePersonaleDiv, idMensilePersonale, idAnnualePersonale);
		refreshParsley(idForm+"Personale", "#"+idMensilePersonale, "#"+idAnnualePersonale);		
	});	

	function refreshParsley(idForm, idMensile, idAnnuale, flagParsley){
		if(flagParsley==null || flagParsley!="false")
			$(idForm).parsley().destroy();
		
			if(($(idMensile).css("display") == "block")) {
				$(idAnnuale).attr("data-parsley-required","false");	
				$(idAnnuale).removeAttr("data-parsley-required-message");
				$(idAnnuale).removeAttr("data-parsley-pattern");
				$(idAnnuale).removeAttr("data-parsley-pattern-message");
				$(idAnnuale).removeAttr("data-parsley-check-year-after-today");

				$(idMensile).attr("data-parsley-required","true");
				$(idMensile).attr("data-parsley-required-message",'<liferay-ui:message key="error-mandatory"/>');

				if(idForm.indexOf("Figlio")>0) {
					$(idMensile).attr("data-parsley-min","9");
					$(idMensile).attr("data-parsley-min-message", '<liferay-ui:message key="error-min-number-travels-childs"/>');
				}
				else {
					$(idMensile).attr("data-parsley-min","11");
					$(idMensile).attr("data-parsley-min-message", '<liferay-ui:message key="error-min-number-travels"/>');
				}
			}
			else { 
				$(idMensile).attr("data-parsley-required","false");
				
				$(idMensile).removeAttr("data-parsley-required-message");
				$(idMensile).removeAttr("data-parsley-min");
				$(idMensile).removeAttr("data-parsley-min-messag");
				$(idAnnuale).attr("data-parsley-required","true");	
				$(idAnnuale).attr("data-parsley-check-year-after-today","");

				$(idAnnuale).attr("data-parsley-required-message",'<liferay-ui:message key="error-mandatory"/>');
				$(idAnnuale).attr('data-parsley-pattern',/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)\d\d/);		
				$(idAnnuale).attr("data-parsley-pattern-message", '<liferay-ui:message key="error-syntactic"/>');

			}
			if(flagParsley==null || flagParsley!="false")
				$(idForm).parsley();
	
	}
	
	function saveForm(){
			if($("#for-itself").hasClass("collapse in")){
				if($(idFileAttach+"Personale").lenght==0)
					addParsleyFile("Personale");
				refreshParsley(idForm+"Personale", "#"+idMensilePersonale, "#"+idAnnualePersonale);
				$(idFlagTipoSpesaPersonale).val("personale");			
				$(idForm+"Personale").submit();

			} 
			else {
				if($(idFileAttach+"Figlio").lenght==0)
					addParsleyFile("Figlio");
				refreshParsley(idForm+"Figlio", "#"+idMensileFiglio, "#"+idAnnualeFiglio);
				$(idFlagTipoSpesaFiglio).val("figli a carico"); 
				$(idForm+"Figlio").submit();	
				
			}
		
	}
	


	
</script>
