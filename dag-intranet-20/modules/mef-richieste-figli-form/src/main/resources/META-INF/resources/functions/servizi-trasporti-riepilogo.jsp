<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="mef.richieste.figli.form.bean.Richiedente"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="mef.richieste.figli.form.bean.ModuloRichiedente"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="java.util.List"%>
<%@ include file="/init.jsp"%>


<% 
Log _log = LogFactoryUtil.getLog("servizi-trasporti-riepilogo.jsp");
_log.info("entra in servizi-trasporti-riepilogo.jsp...");

//ModuloRichiedente moduloRichiedente = (ModuloRichiedente) request.getAttribute("moduloRichiedente");
Richiedente richiedente = (Richiedente) request.getAttribute("richiedente");
String allegatoUuid = (String) request.getAttribute("allegatoUuid");
String dlURL = (String) request.getAttribute("dlURL");

//_log.info("modulo richidente nella pagina jsp:" + moduloRichiedente.getAllegato().getName());

User utente = (User) request.getAttribute("utente"); 

List<ModuloRichiedente> listRichieste = (List<ModuloRichiedente>)  request.getAttribute("listaModuliRichieste");
_log.info("lista richiestee :  "+listRichieste);





%>
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
    		<div class="box-gray">
    			<div class="box-white">
    				<p class="name name-box-first">:</p>
    				
    				<div class="no-overflow">
    					
    					<div class="ama-row border-section">
    						
    						<div class="ama-col-md-3 ama-col-sm-6">
                            	<span class="section-information"><liferay-ui:message key="trasporti-codice-fiscale"/>:</span>
                                	<p class="info"><%=richiedente.getCodiceFiscale() %></p>
                                </div>
            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="trasporti-provincia-nascita"/>:</span>
                                    <p class="info"></p>
                            </div>
            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="trasporti-data-nascita"/>:</span>
                                    <p class="info"></p>
                            </div>
            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="trasporti-luogo-nascita"/>:</span>
                                    <p class="info"></p>
                            </div>
    			    	</div>
    			    	
    			    	<p class="name-section"><liferay-ui:message key="trasporti-residenza"/></p>
    			    	
    			    	<div class="ama-row border-section">
                           
                            <div class="ama-col-md-3 ama-col-sm-6">
                            	<span class="section-information"><liferay-ui:message key="trasporti-indirizzo"/>:</span>
                                <p class="info"></p>
                            </div>
            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="trasporti-citta"/>:</span>
                                <p class="info"></p>
                            </div>
            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="trasporti-cap"/>:</span>
                                 <p class="info"></p>
                            </div>
            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="trasporti-provincia"/>:</span>
                                <p class="info"></p>
                            </div>
                                    
                        </div>
                        
                        <p class="name-section"><liferay-ui:message key="trasporti-assegnazione"/></p>
                        
                        <div class="ama-row">
                        	<div class="ama-col-md-3 ama-col-sm-6">
                        		<span class="section-information"><liferay-ui:message key="trasporti-dipartimento"/>:</span>
                        		<p class="info"></p>
                        	</div>
            				
            				<c:if test=''>
								<div class="ama-col-md-3 ama-col-sm-6">
								 	<span class="section-information"><liferay-ui:message key="trasporti-servizio-dal"/>:</span>
								 	<p class="info"></p>
								</div>
							</c:if>
                            
                                <div class="ama-col-md-3 ama-col-sm-6">
                                	<span class="section-information"><liferay-ui:message key="trasporti-fascia-economica"/>:</span>
                                    <p class="info"></p>
                                </div>
            
                                <div class="ama-col-md-3 ama-col-sm-6">
                                     <span class="section-information"><liferay-ui:message key="trasporti-mail"/>:</span>
                                     <p class="info"></p>
                                </div>
            
                                <div class="ama-col-md-3 ama-col-sm-6">
                                     <span class="section-information"><liferay-ui:message key="trasporti-dati-telefono"/>:</span>
                                     <p class="info"><%=richiedente.getTelefono()%></p>
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
    				<div class="box-gray">
    					<div class="box-white">
    						<div class="ama-row">
    							<div class="ama-col-md-12 ama-col-xs-12">
    								<span class="section-information"><liferay-ui:message key="trasporti-rimborso-upper"/>:</span>
    								<p class="info info-second-box">
											
												<liferay-ui:message key="trasporti-sezione-figli-carico"/>

											
											
												
											
									</p>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
       <%
                                    for (ModuloRichiedente rich : listRichieste) {
                                %>

    <div class="ama-row">
                <div class="ama-col-md-12 mobile-no-padding">
                    <div class="wrapper-istanza-trasporti">
                        <div class="box-gray margin-mob">
                            <div class="box-white ">
                                <div class="no-overflow">
								
                                <div class="ama-row border-section">
                                    <div class="ama-col-md-4 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-nome-figlio"/>:</span>
                                        <p class="info" ><%=rich.getNomeFiglio() %></p>
                                    </div>
                                    <div class="ama-col-md-4 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-cognome-figlio"/>:</span>
                                        <p class="info"><%=rich.getCognomeFiglio() %></p>
                                    </div>
            
                                    <div class="ama-col-md-4 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-codice-fiscale-figlio"/>:</span>
                                        <p class="info"><%=rich.getCfFiglio() %></p>
                                    </div>
            
                                    <div class="ama-col-md-4 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-data-nascita-figlio"/>:
										</span>
                                        <p class="info"><%=rich.getDataNascitaFiglio() %></p>
                                    </div>
									<div class="ama-col-md-4 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-luogo-nascita-figlio"/>:
										</span>
                                        <p class="info"><%=rich.getLuogoNascitaFiglio() %></p>
                                    </div>
                                </div>
							
                                <div class="ama-row mt-30-md mt-30-xs mt-30-sm">
                                    <div class="ama-col-md-4 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-iban"/>:</span>
                                        <p class="info"><%=rich.getIban() %></p>
                                    </div>
            
                                    <div class="ama-col-md-4 ama-col-sm-6">
                                        <span class="section-information"><liferay-ui:message key="trasporti-rimborso"/>:</span>
                                        <p class="info"><%=rich.getImporto() %></p>
                                    </div>
            
                                   <div class="ama-col-md-12 ama-col-xs-12">
                                        <span class="section-information"><liferay-ui:message key="trasporti-descrizione"/>:</span>
                                        <p class="info"><%=rich.getDescrizione() %>
                                        </p>
                                    </div>
                                </div>
                            </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
<%} %>

 			<div class="wrapper-allegati-general">
	<%--		
                <div class="ama-row">
                    <div class="ama-col-md-12">
                        <div class="wrapper-title-general">
                            <h2 class="title-box borders"><liferay-ui:message key="trasporti-allegati"/></h2>
                        </div>
                    </div>
                </div>
			
			
			
			<c:if test="<%= moduloRichiedente.getAllegatoNome()=="" %>">
                
			

                <div class="ama-row">
                    <div class="ama-col-md-12 mobile-no-padding">
                        <div class="wrapper-content">
								
							<div class="wrapper-white">
								<p class="text"><p>ALLEGATO NON PRESENTE</p>
								
							</div>
									
						  
						
						</div>
                    </div>
                </div>
            </c:if>
			
			
			<c:if test="<%=moduloRichiedente.getAllegatoNome()!="" %>">
			
			 <div class="ama-row">
                    <div class="ama-col-md-12 mobile-no-padding">
                        <div class="wrapper-content">
             
             				<div class="wrapper-white">
								
								<div class="text-truncate">
                                     
                                     	<p class="text"><%=moduloRichiedente.getAllegatoNome() %></p>
                                   
                                </div>   
                                
                                
                             <a href="<%=dlURL%>" download>
  								<liferay-ui:message key="download-file"/>
							</a>
                              
                                                    
                                                   
                           <aui:a href="<%=dlURL%>">
                             <strong class="fas fa-download text-18p">		
                            <span class="sr-only"><liferay-ui:message key="download-file"/></span></strong>
                         </aui:a>
                                
                     
							
							</div>
             
             
             
                        </div>
                    </div>
             </div>
			
			
			
			
			
			
			
			
			</c:if>
			
			
			
			
			
			
			
			
			
			<!--  
			

                <div class="ama-row">
                    <div class="ama-col-md-12 mobile-no-padding">
                        <div class="wrapper-content">
							
							
							
							
							
							
							
							
							
							<div class="wrapper-white">
								
								<div class="text-truncate">
                                     
                                  
                                   
                                </div>   
                                
                                
                                					<a href=" download>
  														<liferay-ui:message key="download-file"/>
														</a>
                              
                                                    
                                                   
                                                    <aui:a href="">
                                                        <strong class="fas fa-download text-18p">
                                                        <span class="sr-only"><liferay-ui:message key="download-file"/></span></strong>
                                                    </aui:a>
                                
                     
							
							</div>
							
							

												<div class="wrapper-white">
												
												<p>ALLEGATO NON PRESENTE</p>
												
												
												
												
												
												
												</div>
													



															
						  
						
						</div>
                    </div>
                </div>
                -->
                 --%>
   
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
 
 
 <%int contatore=0; 
 String i ="";%>
 <%
                                    for (ModuloRichiedente rich : listRichieste) {
                                    	_log.info("lista delle richieste : " + listRichieste);
                                    	contatore=contatore+1;
                                    	i = String.valueOf(contatore);
                                    	
                                %>
  
			<portlet:param name="argumentIbanFiglio + <%=i%>"  value="<%=rich.getIban() %>" />
			<portlet:param name="argumentImportoFiglio + <%=i%>"  value="<%=rich.getImporto()%>" />
			<portlet:param name="argumentNoteRimborso"  value="<%=rich.getDescrizione()%>" />
			<portlet:param name="argumentNomeFiglio" value="<%=rich.getNomeFiglio()%>" />
			<portlet:param name="argumentCognomeFiglio" value="<%=rich.getCognomeFiglio()%>" />
			<portlet:param name="argumentLuogoNascitaFiglio" value="<%=rich.getLuogoNascitaFiglio()%>" />
			<portlet:param name="argumentCFFiglio" value="<%=rich.getCfFiglio()%>" />
			<portlet:param name="argumentDataNascitaFiglio" value="<%=rich.getDataNascitaFiglio()%>" />
			<portlet:param name="lunghezzaListRichiesta" value="<%=String.valueOf(listRichieste.size())%>" />
			<portlet:param name="Allegato" value="<%=rich.getAllegato().getAbsolutePath()%>" />
			<portlet:param name="AllegatoMimeType" value="<%=rich.getAllegatoMimeType()%>" />
			<portlet:param name="AllegatoNome" value="<%=rich.getAllegatoNome()%>" />
			
			
			
			<portlet:param name="NomeUtente" value="<%=richiedente.getNome() %>" />
			<portlet:param name="CognomeUtente" value="<%=richiedente.getCognome() %>" />
			<portlet:param name="TelefonoUtente" value="<%=richiedente.getTelefono() %>" />
			<portlet:param name="CFUtente" value="<%=richiedente.getCodiceFiscale() %>" />
			<portlet:param name="AllegatoUuid" value="<%=allegatoUuid %>" />
		<%
		
		_log.info("argumentIbanFiglio: " + rich.getIban());
		_log.info("argumentIbanFiglio" + String.valueOf(contatore));
		 %>
		 <%} %>	
</portlet:actionURL>
 

 
 
 
 
 
 
 

		
			
			



		<form id="<portlet:namespace/>goBack" action="<%=eventoRichiestaRimborso%>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="<portlet:namespace/>evento" value="modifica">
		</form>
		
		

		<form id="<portlet:namespace/>inviaModuloRichiestaRimborso" action="<%=eventoRichiestaRimborso%>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="<portlet:namespace/>evento" value="invia">
		</form>



<script type="text/javascript">



function goBack(){
	$("#<portlet:namespace/>goBack").submit();
}


function inviaModulo(){
	
	//if( flagInvio ) {
		//flagInvio = false;
		$("#<portlet:namespace/>inviaModuloRichiestaRimborso").submit();
	//}
}



</script>
 