<%@page import="mef.richieste.figli.form.bean.UtenteRichiedente"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="mef.richieste.figli.form.bean.Richiedente"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="mef.richieste.figli.form.bean.ModuloRichiedente"%>
<%@ page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>

<%@ include file="/init.jsp"%>

<!-- <portlet:resourceURL var="MefRichiesteFigliFormPortlet"></portlet:resourceURL> -->
<% 
Log _log = LogFactoryUtil.getLog("servizi-trasporti-riepilogo.jsp");
_log.debug("entra in servizi-trasporti-riepilogo.jsp...");

//UtenteRichiedente utenteRichiedente = (UtenteRichiedente) request.getAttribute("utenteRichiedente");
Richiedente utenteRichiedente = (Richiedente) request.getAttribute("utenteRichiedente");
Integer counterFigli = 1;
if(request.getAttribute("counterFigli")!=null){
	counterFigli = (Integer) request.getAttribute("counterFigli");
	_log.debug("*_*_*_*_*_*_*_*_*_*_*__* --> COUNTER FIGLI RECUPERATO : " + counterFigli );
	 
}

String dim = (String) request.getAttribute("dimensioneAllegato");
_log.debug("1");
//String tipoCC = (String) request.getAttribute("tipoCC");

//Richiedente richiedente = (Richiedente) request.getAttribute("richiedente");
_log.debug("3");
String allegatoUuid = (String) request.getAttribute("allegatoUuid");
_log.debug("4");
String dlURL = (String) request.getAttribute("dlURL");
_log.debug("5");

//Long fEntryID = (Long) request.getAttribute("fEntryID");
String fEntryID = (String) request.getAttribute("fEntryID");
_log.debug("6");

//String numeroCC = (String) request.getAttribute("numeroCC");

User utente = PortalUtil.getUser(request);

_log.debug("7");
List<ModuloRichiedente> listRichieste = (List<ModuloRichiedente>)  request.getAttribute("listaModuliRichieste");

_log.debug("lista richiestee :  "+listRichieste);

String iban="";

String note="";

String allegatoNome="";



List<Phone> numeriTelefoniciUtente = utente.getPhones();


for(ModuloRichiedente modulo : listRichieste) {
	
	iban = modulo.getIban();
	
	note = modulo.getDescrizione();
	
	allegatoNome = modulo.getAllegatoNome();
	
	_log.debug("allegato nome: "+allegatoNome);
	
}


int contatore=0; 
String i ="";

String fEntryIDToString = fEntryID;

String noteRimborso ="";


%>

<% 

_log.debug("note nella jsp:  " + note);

//RECUPERO FOLDER ID
_log.debug("9");
Long folderId =  (Long) request.getAttribute("folderId");
request.setAttribute("folderId", folderId+"");


%>



<div class="ama-container-fluid">
<div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="rimborso-figli-riepilogo-richiesta"/></h2>
                    </div>
					<span class="title-general-trasporti mb-40-xs"><liferay-ui:message key="rimborso-figli-riepilogo-info"/></span>
					
					</div>
		</div>
			<div class="ama-row">
				<div class="ama-col-md-12">
					<div class="wrapper-title-small">
						<h2 class="title-box borders">
							<liferay-ui:message key="rimborso-figli-dati-richiedente" />
						</h2>
					</div>
				</div>
			</div>
			<div class="ama-row">
				<div class="ama-col-xs-12 mobile-no-padding">
					<div class="wrapper-istanza-trasporti mobile-no-padding">
						<div class="box-gray">
							<div class="box-white">
								<p class="name"><%= utenteRichiedente.getNome() + " " + utenteRichiedente.getCognome()%> </p>
								</br>

								<div class="no-overflow">

									<div class="ama-row border-section">

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-codice-fiscale" />:</span>
											<p class="info uppercase"><%=utenteRichiedente.getCodiceFiscale() %></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-provincia-nascita" />:</span>
											<p class="info"><%=utenteRichiedente.getProvinciaNascita() %></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-data-nascita" />:</span>
											<p class="info"><%=utenteRichiedente.getDataNascita() %></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-luogo-nascita" />:</span>
											<p class="info"><%=utenteRichiedente.getLuogoNascita() %></p>
										</div>
									</div>

									<p class="name-section">
										<liferay-ui:message key="rimborso-figli-residenza" />
									</p>

									<div class="ama-row border-section">

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-indirizzo" />:</span>
											<p class="info"><%=utenteRichiedente.getIndirizzo() %></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-citta" />:</span>
											<p class="info"><%=utenteRichiedente.getCitta()%></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-cap" />:</span>
											<p class="info"><%=utenteRichiedente.getCap()%></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-provincia" />:</span>
											<p class="info"><%=utenteRichiedente.getProvincia()%></p>
										</div>

									</div>

									<p class="name-section">
										<liferay-ui:message key="rimborso-figli-assegnazione" />
									</p>

									<div class="ama-row">
										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-dipartimento" />:</span>
											<p class="info"><%=utenteRichiedente.getDipartimento()%></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-fascia-economica" />:</span>
											<p class="info"><%=utenteRichiedente.getFasciaEconomica()%></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-mail" />:</span>
											<p class="info"><%=utenteRichiedente.getMail()%></p>
										</div>

										<div class="ama-col-md-3 ama-col-sm-6">
											<span class="section-information"><liferay-ui:message
													key="rimborso-figli-dati-telefono" />:</span>

											<p class="info"><%=utenteRichiedente.getTelefono()%></p>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	<portlet:actionURL name="eventoRichiestaRimborso" var="eventoRichiestaRimborso" />
		
			<aui:form name="fm22" id="fm22" action="${eventoRichiestaRimborso}" method="post" enctype="multipart/form-data">	
	
				<aui:input type="hidden" name="Note" value="<%=note%>" />
					
 
		
		
		
		
		<div class="ama-row">
			<div class="ama-col-xs-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="no-overflow">
						<div class="box-gray">
							<div class="box-white">
								<div class="ama-row">
									<div class="ama-col-md-12 ama-col-xs-12">
										<span class="section-information"><liferay-ui:message key="rimborso-figli-rimborso-upper"/>:</span>
											<p class="info info-second-box"><liferay-ui:message key="rimborso-figli-sezione-figli-carico"/></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="ama-row">
			<div class="ama-col-md-12 mobile-no-padding">
				<div class="wrapper-istanza-trasporti">
					<div class="box-gray margin-mob">
						<div class="box-white ">
							<div class="no-overflow">
									
										<%
												for (ModuloRichiedente rich : listRichieste) {
										 %>
							
											<div class="ama-row border-section">
											 
													<div class="ama-col-md-4 ama-col-sm-6">
														<span class="section-information"><liferay-ui:message key="rimborso-figli-nome-figlio"/>:</span>
														<p class="info" ><%=rich.getNomeFiglio() %></p>
													</div>
                                    
													<div class="ama-col-md-4 ama-col-sm-6">
														<span class="section-information"><liferay-ui:message key="rimborso-figli-cognome-figlio"/>:</span>
														<p class="info"><%=rich.getCognomeFiglio() %></p>
													</div>
            
													<div class="ama-col-md-4 ama-col-sm-6">
														<span class="section-information"><liferay-ui:message key="rimborso-figli-codice-fiscale-figlio"/>:</span>
														<p class="info"><%=rich.getCfFiglio() %></p>
													</div>
            
													<div class="ama-col-md-4 ama-col-sm-6">
														<span class="section-information"><liferay-ui:message key="rimborso-figli-data-nascita-figlio"/>:
														</span>
														<p class="info"><%=rich.getDataNascitaFiglio() %></p>
													</div>
									
													<div class="ama-col-md-4 ama-col-sm-6">
														<span class="section-information"><liferay-ui:message key="rimborso-figli-luogo-nascita-figlio"/>:
														</span>
														<p class="info"><%=rich.getLuogoNascitaFiglio() %></p>
													</div>
													
													
													<div class="ama-col-md-4 ama-col-sm-6">
														<span class="section-information"><liferay-ui:message key="rimborso-figli-rimborso"/>:</span>
														<p class="info"><%=rich.getImporto() %></p>
													</div>
													
											</div>
									
										<% } %>
							
										<div class="ama-row mt-30-md mt-30-xs mt-30-sm">
												
												<div class="ama-col-md-4 ama-col-sm-6">
													<span class="section-information"><liferay-ui:message key="rimborso-figli-iban"/>:</span>
													<p class="info"><%=iban%></p>
												</div>
										 <div class="ama-col-md-12 ama-col-xs-12">
                                        	<span class="section-information"><liferay-ui:message key="rimborso-figli-descrizione"/>:</span>
                                        	<p class="info"><%=note %>
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
			<div class="ama-row">
				<div class="ama-col-md-12 mobile-no-padding">
					<div class="wrapper-content">
						<div class="wrapper-white">
							<div class="text-truncate">
                                 <p class="text"><%=allegatoNome %></p>
                            </div>
									
							<a href="<%=dlURL%>" download>
								<liferay-ui:message key="download-file"/>
							</a>
									
							<aui:a href="<%=dlURL%>">
								<strong class="fas fa-download text-18p">		
									<span class="sr-only"><liferay-ui:message key="download-file"/></span>
								</strong>
							</aui:a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<div class="container-button-allegati" align="center">
                    <div class="ama-row">
                        <div class="ama-col-sm-6">
                           <button href="#" type="button" id="indietro" class="button button-secondary"><liferay-ui:message key="rimborso-figli-modifica"/></button>
                       	</div>
                        <div class="ama-col-sm-6">
                          <button href="#" type="button" id="avanti" class="button button-primary"><liferay-ui:message key="rimborso-figli-invia"/></button>
                        </div>
                    </div>
         </div>
        
		
		
		
		
		
		

			
		<%
			for (ModuloRichiedente modulo : listRichieste) {
				
				contatore=contatore+1;
				
				i = String.valueOf(contatore);
					String NomeF = "NomeF" + i;
    				String IbanF = "IbanF";
    				String ImportoF = "ImportoF" + i;
    				String Note = "Note";
    				String CognomeF = "CognomeF" + i;
  					String LuogoNF = "LuogoNF" + i;
    				String CFF = "CFF" + i;
    				String DataNF = "DataNF" + i;
		
		%>        
		
				<aui:input type="hidden" name="counterFigli" value="<%=counterFigli%>"/>
				<aui:input type="hidden" name="<%=NomeF%>" value="<%=modulo.getNomeFiglio()%>"/>
				<aui:input type="hidden" name="<%=IbanF%>" value="<%=modulo.getIban() %>"/>
				<aui:input type="hidden" name="<%=ImportoF%>" value="<%=modulo.getImporto()%>" />
				<aui:input type="hidden" name="<%=Note%>"  value="<%=modulo.getDescrizione()%>" />
				<aui:input type="hidden" name="<%=CognomeF%>" value="<%=modulo.getCognomeFiglio()%>" />
				<aui:input type="hidden" name="<%=LuogoNF%>" value="<%=modulo.getLuogoNascitaFiglio()%>" />
				<aui:input type="hidden" name="<%=CFF%>" value="<%=modulo.getCfFiglio()%>" />
				<aui:input type="hidden" name="<%=DataNF%>" value="<%=modulo.getDataNascitaFiglio()%>" />
				
				
				<aui:input type="hidden" name="LListRich" value="<%=String.valueOf(listRichieste.size())%>" />
				<aui:input type="hidden" name="Allegato" value="<%=modulo.getAllegato().getAbsolutePath()%>" />
				<aui:input type="hidden" name="AllegatoMimeType" value="<%=modulo.getAllegatoMimeType()%>" />
				<aui:input type="hidden" name="allegatoN" value="<%=allegatoNome%>" />
				<aui:input type="hidden" name="dlURL" value="<%=dlURL%>" />
			
				<aui:input type="hidden" name="NomeU" value="<%=utenteRichiedente.getNome() %>" />
				<aui:input type="hidden" name="CognomeU" value="<%=utenteRichiedente.getCognome() %>" />
				<aui:input type="hidden" name="TeleU" value="<%=utenteRichiedente.getTelefono() %>" />
				<aui:input type="hidden" name="CFU" value="<%=utenteRichiedente.getCodiceFiscale() %>" />
				<aui:input type="hidden" name="AllegatoUuid" value="<%=allegatoUuid %>" />
			
				<aui:input type="hidden" name="fEntryID" value="<%=fEntryIDToString%>" />
				
				<aui:input type="hidden" name="IbanF" value="<%=utenteRichiedente.getIban() %>" />
			
				<aui:input type="hidden" name="dimensioneAllegato" value="<%=dim%>" />
				
		<% } %>
			
			
			
			
					<aui:input type="hidden" id="evento" name="evento"/>
				
</aui:form>
</div>



<script type="text/javascript">

$("#indietro").click(function() {
AUI().use('node', function (A) {
A.one('#<portlet:namespace/>evento').set('value','modifica');
});

submitForm(document.<portlet:namespace />fm22);

});


</script>


<script type="text/javascript">

$("#avanti").click(function() {
AUI().use('node', function (A) {
A.one('#<portlet:namespace/>evento').set('value','invio');
});

submitForm(document.<portlet:namespace />fm22);

});

</script>




<!-- <script>
window.addEventListener("beforeunload", function(event) { 
	console.log("EVENTO SCATENATO IN RIEPILOGO :" + event)
	AUI().use('aui-io-request', function(A){
        A.io.request('${MefRichiesteFigliFormPortlet}', {
               method: 'post',
              on: {
                   	success: function() {
                        console.log("SUCCESSO AJAX RIEPILOGO")
                    }
              }
        });
    });
});

</script> -->





<script type="text/javascript">



function goBack(){
	$("#<portlet:namespace/>goBack").submit();
}


function inviaModulo(){
	$("#<portlet:namespace/>inviaModuloRichiestaRimborso").submit();
}



</script>




<style type="text/css">
p.uppercase {text-transform: uppercase}
.container-button-allegati{
	margin-top: 10px;
}

.container-button-allegati{    margin-top: 10px; margin-bottom: 10px;
}

</style>


