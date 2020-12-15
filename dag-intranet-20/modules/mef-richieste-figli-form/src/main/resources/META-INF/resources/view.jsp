
<%@page import="mef.richieste.figli.form.bean.UtenteRichiedente"%>
<%@page import="mef.richieste.figli.form.bean.ConfigurationBean"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="com.liferay.portal.kernel.model.Address"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ include file="/init.jsp"%>
<%@page import="java.io.File"%>


<%@page import="mef.richieste.figli.model.RICHIESTA_RIMBORSO"%>
<%@page import="mef.richieste.figli.form.bean.ModuloRichiedente"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="mef.richieste.figli.model.RICHIESTA_RIMBORSO"%>
<%@page import="mef.richieste.figli.form.bean.Richiedente"%>

<!-- <portlet:resourceURL var="MefRichiesteFigliFormPortlet"></portlet:resourceURL> -->
<%


Log _log = LogFactoryUtil.getLog("view.jsp");




Integer counterFigli = 1;
if(request.getAttribute("counterFigli")!=null){
	counterFigli = Integer.parseInt(request.getParameter("counterFigli"));
	_log.debug("*_*_*_*_*_*_*_*_*_*_*__* --> COUNTER FIGLI RECUPERATO : " + counterFigli );
	 
}



	String displayAllegato = "display:none";
	String displayNoAllegato = "display:block";
	
	_log.debug("sono dentro la view.jsp...");
	
	_log.debug("VIEW 1");

	String allegatoNome = (String) request.getAttribute("allegatoN");
	_log.debug("VIEW 3"+ allegatoNome);
	String Iban = (String) request.getAttribute("IbanF");
	_log.debug("VIEW 4");
	String NoteRimborso = (String) request.getAttribute("Note");
	_log.debug("VIEW 5");
	//String tipoContoCorrente = (String) request.getAttribute("tipoCC");
	_log.debug("VIEW 6");
	
	//_log.debug("conto corrente : "+tipoContoCorrente);
	
	_log.debug("VIEW 7");
	//String numContoCorrente = (String) request.getAttribute("numCC");
	
	_log.debug("VIEW 8");
    //Long fEntryID = (Long) request.getAttribute("fEntryID");
    String fEntryID = (String) request.getAttribute("fEntryID");
	
    _log.debug("VIEW 9");

    String dlURL =(String) request.getAttribute("dlURL");
    
   
    String dim = "";
    
    _log.debug("-------------dim-----"+ dim);
    
    
    if(request.getAttribute("dimensioneAllegato")!=null){
    	
    	dim = (String) request.getAttribute("dimensioneAllegato");
    	
    }else{
		dim = "3";
	}
    if(Validator.isNotNull(request.getAttribute("dimensioneAllegatoRiepilogo"))){
    	dim = (String) request.getAttribute("dimensioneAllegatoRiepilogo");
    	_log.debug("Recuperata dimensione dopo errore" + dim);
    }
    
    if(request.getAttribute("dimensioneModifica")!=null){
    	 dim = (String) request.getAttribute("dimensioneModifica");
    	 _log.debug("-------dentro------dim-----"+ dim);
    	 
    }
  
    
    _log.debug("dimensione allegato "+dim);
    
	if (allegatoNome == null && Iban == null && NoteRimborso == null  ) {
		
		allegatoNome = "";
		Iban = "";
		NoteRimborso ="";
		//tipoContoCorrente ="";
		//numContoCorrente = "";
		
	} 
	
	//UtenteRichiedente utenteRichiedente = (UtenteRichiedente) request.getAttribute("utenteRichiedente");
	Richiedente utenteRichiedente = (Richiedente) request.getAttribute("utenteRichiedente");
	_log.debug("*********** VIEW UTENTE " + utenteRichiedente);
	request.setAttribute("utenteRichiedente", utenteRichiedente);
	
	
	
	Richiedente richiedente = (Richiedente) request.getAttribute("richiedente");
	
	ModuloRichiedente moduloRichiedente = null;
	_log.debug("riga 102");
	File nomeFile =null;
	_log.debug("riga 104");
	List<ModuloRichiedente> moduliRichieste = (List<ModuloRichiedente>) request.getAttribute("moduliRichieste");

	_log.debug("riga 107: "+moduliRichieste);
	List<ModuloRichiedente> listaRichieste = new ArrayList<ModuloRichiedente>();
	_log.debug("riga 109");
	for(ModuloRichiedente modulo  : moduliRichieste) {
		_log.debug("riga 111");
		 _log.debug("lista moduli rihiesta "+modulo.getAllegato());
		if(modulo !=null ) {
			nomeFile = modulo.getAllegato();
			moduloRichiedente = modulo;
				if (moduloRichiedente != null && moduloRichiedente.getNomeFiglio() == null) {
					moduloRichiedente.setNomeFiglio("");	
				}
				if (moduloRichiedente != null && moduloRichiedente.getCognomeFiglio() == null) {
					moduloRichiedente.setCognomeFiglio("");
				}
				if (moduloRichiedente != null && moduloRichiedente.getCfFiglio() == null) {
					moduloRichiedente.setCfFiglio("");
				}
				if (moduloRichiedente != null && moduloRichiedente.getDataNascitaFiglio() == null) {
					moduloRichiedente.setDataNascitaFiglio("");
				}

				if (moduloRichiedente != null && moduloRichiedente.getIban() == null) {
					moduloRichiedente.setIban("");

				}
				if (moduloRichiedente != null && moduloRichiedente.getImporto() == null) {
					moduloRichiedente.setImporto("");

				}

				if (moduloRichiedente != null && moduloRichiedente.getDescrizione() == null) {
					moduloRichiedente.setDescrizione("");

				}

				if (moduloRichiedente != null && moduloRichiedente.getLuogoNascitaFiglio() == null) {

					moduloRichiedente.setLuogoNascitaFiglio("");
				}
			
				listaRichieste.remove(modulo);
				listaRichieste.add(moduloRichiedente);
			
			
		} else {

			moduloRichiedente = new ModuloRichiedente();
			moduloRichiedente.setIban("");
			moduloRichiedente.setImporto("");
			moduloRichiedente.setDescrizione("");
			moduloRichiedente.setNomeFiglio("");
			moduloRichiedente.setCognomeFiglio("");
			moduloRichiedente.setCfFiglio("");
			moduloRichiedente.setDataNascitaFiglio("");
			moduloRichiedente.setLuogoNascitaFiglio("");
			moduloRichiedente.setDescrizione("");
			}
	
		listaRichieste.remove(modulo);
		
		listaRichieste.add(moduloRichiedente);
	
	
	}
	
	

	String path = "";
_log.debug("Modulo richiedente: "+moduloRichiedente.getAllegato());
	if (moduloRichiedente.getAllegato() != null) {
		path = moduloRichiedente.getAllegato().getAbsolutePath();
		displayAllegato = "display:block";
		displayNoAllegato = "display:none";//come se non esistesse
	}
	
	
	
	
	String dataConfig=null;
	if((String) request.getAttribute("dataRichiestaRimborso")==""){
	    dataConfig = (String) request.getAttribute("dataRichiestaRimborso2");
	}else{
	    dataConfig = (String) request.getAttribute("dataRichiestaRimborso");
	}
		
	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dataConfig);
	
	Calendar cal = Calendar.getInstance();
	
    cal.setTime(date1);
	cal.add(Calendar.YEAR, -15);
	Date dataMinCF = cal.getTime();
	cal.setTime(date1);
	cal.add(Calendar.YEAR, -5);
	cal.add(Calendar.DATE, 1);
	Date dataMaxCF = cal.getTime();

	cal.setTime(date1);
	cal.add(Calendar.YEAR, -15);
	cal.add(Calendar.DATE, 1);
	Date dataMin = cal.getTime();
	cal.setTime(date1);
	cal.add(Calendar.YEAR, -5);
	Date dataMax = cal.getTime();
	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
	String sMax = formatter.format(dataMax);
	String sMin = formatter.format(dataMin);
	




%>

<c:choose>
	<c:when test="${!empty utenteRichiedente}">
		
		
		
				
		
		
		
		<input type="hidden" id="dim" value="<%=dim %>" />

		<div class="ama-container-fluid">
			<c:choose>
			<c:when test="${viewDivError ==true}">
				<div class="ama-row">
					<div class="alert alert-danger fade in alert-dismissible">

						<c:if test="${cfError == true}">
							<liferay-ui:message key="error.mef.cf" />
						</c:if>

						<c:if test="${cfErrorUpload == true}">
							<liferay-ui:message key="error.upload" />
						</c:if>

						<c:if test="${cfErrorMail == true}">
							<liferay-ui:message key="error.mef.mail" />
						</c:if>

						<c:if test="${errorGeneral == true}">
							<liferay-ui:message key="error.mef" />
						</c:if>

						<c:if test="${errorNoFile == true}">
							<liferay-ui:message key="error.no.file" />
						</c:if>
						
						<c:if test="${dataFiglioError == true}">
							<liferay-ui:message key="error.mef.datafiglio" />
						</c:if>

					</div>
				</div>
			</c:when>
</c:choose>







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
								<p class="name"><%= utenteRichiedente.getNome() + " "+ utenteRichiedente.getCognome() %> </p>
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
											<p class="info"><%=utenteRichiedente.getProvinciaNascita()%></p>
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
		
			
			
			
			<div class="ama-row">
				<div class="ama-col-md-12">
					<div class="wrapper-title-small">
						<h2 class="title-box borders">
							<liferay-ui:message key="rimborso-figli-richiesta-rimborso" />
						</h2>
					</div>
				</div>
			</div>
			<div class="ama-container-fluid">
				<portlet:actionURL name="goToServiziTrasportiRiepilogo" var="goToServiziTrasportiRiepilogoURL" />

				<aui:form name="fm22" id="fm22"
					action="${goToServiziTrasportiRiepilogoURL}" method="post"
					enctype="multipart/form-data">

					<aui:input type="hidden" name="fEntryID" value="<%=fEntryID%>" />
					<aui:input type="hidden" name="allegatoN" value="<%=allegatoNome%>" />
					<aui:input type="hidden" name="dlURL" value="<%=dlURL%>" />
					<input type="hidden" id="counterFigliID" name="<portlet:namespace />counterFigli" value="<%=counterFigli %>" />
					<div id="auto-fields-container">
						
						<% int index = 1; 
						for (ModuloRichiedente rich : listaRichieste) {%>
						<div class="lfr-form-row">
							<div class="  wrapper-istanza-trasporti">
								<div class=" box-gray no-margin">
									<div class=" box-white box-gray-mobile">


										<p class="name-section">
											<liferay-ui:message key="rimborso-figli-dati-rimborso" />
										</p>

										<div class="ama-row">

											<div class="ama-col-md-6 ama-col-xs-12">
												<label for="<portlet:namespace/>NomeFiglio<%=index %>"
													class="label-form "><liferay-ui:message
														key="rimborso-figli-nome-figlio" />*</label> 
														<input
														required="true"
													required-message="<liferay-ui:message key="error-mandatory"/>"
													pattern="[^0-9]{2,16}"
													pattern-message="<liferay-ui:message key="error-syntactic"/>"
													
													
													id="<portlet:namespace/>NomeFiglio<%=index %>"
													name="<portlet:namespace/>NomeFiglio<%=index %>"
													class="field input-custom-light data-parsley-validated removeFieldFormTrasporti"
													value="<%=rich.getNomeFiglio()%>"
													
													placeholder="<liferay-ui:message key="rimborso-figli-nome-figlio-placeholder"/>">
											</div>

											<div class="ama-col-md-6 ama-col-xs-12">
												<label for="<portlet:namespace/>CognomeFiglio<%=index %>"
													class="label-form "><liferay-ui:message
														key="rimborso-figli-cognome-figlio" />*</label> 
														<input 
													equired="true"
													required-message="<liferay-ui:message key="error-mandatory"/>"
													pattern="[^0-9]{2,16}"
													pattern-message="<liferay-ui:message key="error-syntactic"/>"
													
													id="<portlet:namespace/>CognomeFiglio<%=index %>"
													name="<portlet:namespace/>CognomeFiglio<%=index %>"
													value="<%=rich.getCognomeFiglio()%>"
													class="field input-custom-light data-parsley-validated removeFieldFormTrasporti"
													placeholder="<liferay-ui:message key="rimborso-figli-cognome-figlio-placeholder"/>">
											</div>

										</div>
										<div class="ama-row">

											<div class="ama-col-md-6 ama-col-xs-12">
												<label for="<portlet:namespace/>CFFiglio<%=index %>"
													class="label-form margin-top "><liferay-ui:message
														key="rimborso-figli-codice-fiscale-figlio" />*</label> <input
													style="text-transform: uppercase" type="text"
													required="true"
													required-message="<liferay-ui:message key="error-mandatory"/>"
													pattern-message="<liferay-ui:message key="error-syntactic"/>"
													pattern="^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$"
													id="<portlet:namespace/>CFFiglio<%=index %>"
													name="<portlet:namespace/>CFFiglio<%=index %>"
													value="<%=rich.getCfFiglio()%>"
													class="field input-custom-light data-parsley-validated removeFieldFormTrasporti"
													
													
													placeholder="<liferay-ui:message key="rimborso-figli-codice-fiscale-figlio-placeholder" />">
											</div>

												
											<div class="ama-col-md-6 ama-col-xs-12">
												<label class="label-form margin-top"><liferay-ui:message
														key="rimborso-figli-data-nascita-figlio" />*</label> 
														<input	id="<portlet:namespace/>DataNascitaFiglio<%=index %>" required="true"
																
																required-message="<liferay-ui:message key="error-mandatory"/>"
																data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/\d\d\d\d/"
																data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																name="<portlet:namespace/>DataNascitaFiglio<%=index %>"
																value="<%=rich.getDataNascitaFiglio()%>"
																class="field input-custom-light input-custom-light datepicker-custom removeFieldFormTrasporti"
																placeholder="<liferay-ui:message key='rimborso-figli-insert-placeholder-data-nascita'/>">
														
											</div>
										</div>

										<div class="ama-row">

											<div class="ama-col-md-6 ama-col-xs-12">
												<label for="<portlet:namespace/>LuogoNascitaFiglio<%=index %>"
													class="label-form margin-top"><liferay-ui:message
														key="rimborso-figli-luogo-nascita-figlio" />*</label> 
														<input
													id="<portlet:namespace/>LuogoNascitaFiglio<%=index %>"
													required="true"
													pattern="([a-zA-Z]{2,16})?$"
													required-message='<liferay-ui:message key="error-mandatory"/>'
													name="<portlet:namespace/>LuogoNascitaFiglio<%=index %>"
													class="field input-custom-light data-parsley-validated removeFieldFormTrasporti"
													value="<%=rich.getLuogoNascitaFiglio()%>"
													placeholder="<liferay-ui:message key="rimborso-figli-luogo-nascita-figlio-placeholder"/>">
											</div>


											<div class="ama-col-md-6 ama-col-xs-12">
												<label for="<portlet:namespace/>ImportoFiglio<%=index %>"
													class="label-form margin-top"><liferay-ui:message
														key="rimborso-figli-importo-rimborso-spese" />*
														
														<a
											title='<liferay-ui:message key="rimborso-figli-importo-info"/>'
											class="tooltip-field icon-information"> <span
												class="icomoon-info ico-info-tooltip"></span>
										</a> 		
														</label>
														 <input
													required="true" data-parsley-required="true"
													required-message="<liferay-ui:message key="error-mandatory"/>"
													pattern="^[1-9][0-9]{0,2}(?:\.?[0-9]{3}){0,3}(,[0-9]{2})?$"
													pattern-message="<liferay-ui:message key="error-syntactic"/>"
													id="<portlet:namespace/>ImportoFiglio<%=index %>"
													name="<portlet:namespace/>ImportoFiglio<%=index %>"
													class="field input-custom-light data-parsley-validated removeFieldFormTrasporti"
													value="<%=rich.getImporto()%>"
													placeholder="<liferay-ui:message key='rimborso-figli-insert-placeholder-import-figlio'/>">

											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
						<%
						index++; 
						} %>
					</div>

					<div class="  wrapper-istanza-trasporti">
						<div class=" box-gray no-margin">
							<div class=" box-white box-gray-mobile">
								<p class="name-section">
									<liferay-ui:message key="rimborso-figli-campo-iban" />
								</p>

								<div class="ama-row">

									<div class="ama-col-md-4 ama-col-xs-12">
										<label for="<portlet:namespace/>IbanFiglio"
											class="label-form "><liferay-ui:message
												key="rimborso-figli-iban" />* <a
											title='<liferay-ui:message key="rimborso-figli-info-iban"/>'
											class="tooltip-field icon-information"> <span
												class="icomoon-info ico-info-tooltip"></span>
										</a> </label> <input required="true"
											data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
											pattern="[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}"
											pattern-message="<liferay-ui:message key="error-syntactic"/>"
											id="<portlet:namespace/>IbanFiglio"
											name="<portlet:namespace/>IbanFiglio"
											class="field input-custom-light data-parsley-validated removeFieldFormTrasporti"
											value="<%=Iban%>"
											placeholder="<liferay-ui:message key='rimborso-figli-insert-placeholder-data-iban'/>">
									</div>
									

									<div class="ama-row">
										<div class="ama-col-md-12 ama-col-xs-12 ">
											<div class="wrapper-content-textarea">
												<label class="label-form margin-top"
													for="<portlet:namespace/>NoteRimborso"><liferay-ui:message
														key="rimborso-figli-descrizione" /></label>
												<textarea data-parsley-maxlength="500"
													data-parsley-minlength="10"
													data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>"
													data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
													data-parsley-validation-threshold="10"
													name="<portlet:namespace/>NoteRimborso"
													class="field form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti"
													id="<portlet:namespace/>NoteRimborso"
													placeholder="<liferay-ui:message key='rimborso-figli-insert-placeholder-descrizione'/>"><%=NoteRimborso%></textarea>
												<div class="content-textarea">
													0/
													<p class="color-gray">500</p>
												</div>
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
					</div>
					</br>

					<div class="wrapper-allegati-general">
						<div class="ama-row">
							<div class="ama-col-md-12">
								<div class="wrapper-title-general">
									<h2 class="title-box borders">
										<liferay-ui:message key="rimborso-figli-allegati" />
										*
									</h2>
									<a 
										title="<liferay-ui:message key="rimborso-figli-info-allegato1"/> <%=dim %>
										 <liferay-ui:message key="rimborso-figli-info-allegato2"/>"
										class="tooltip-field"> <span
										class=" field icomoon-info ico-attachments"></span>
									</a>
								</div>
							</div>
						</div>

						<%
						
						if(Validator.isNotNull(request.getAttribute("erroreAllegatoNoFile"))){
							displayAllegato = "display:none";
							displayNoAllegato = "display:block";
						}
						
						
						
						%>
						
						<div class="ama-row" style="<%=displayAllegato%>" id="<portlet:namespace/>fileAttachDivFiglio">
						<div class="ama-col-md-12 mobile-no-padding">
						<div class="wrapper-content">
								<div class="wrapper-white">
									<p class="text" id="<portlet:namespace/>fileNameFiglio"> <%=allegatoNome %></p>
										<a href="<%=dlURL%>" download>
								<liferay-ui:message key="download-file"/>
							</a>
							<aui:a href="<%=dlURL%>">
								<strong class="fas fa-download text-18p">		
									<span class="sr-only"><liferay-ui:message key="download-file"/></span>
								</strong>
							</aui:a>
									<a href="#" title="elimina file" id="<portlet:namespace/>removeFileFiglio"  onclick='removeAllegato("Figlio")' class="icomoon-close-white ico-delete"></a></p>
								</div>
									
						  
						
						</div>
						</div>
						</div>

					
						<div class="ama-col-md-12 mobile-no-padding">
							<div class="box-button" align="center"
								style="<%=displayNoAllegato%>"
								id="<portlet:namespace/>selectFileFiglio">
								
								<button  type="button" id="addAttachFileFiglio" class="button button-primary">SELEZIONA IL FILE</button>
									 <input align="center" type="file" class="field form-control"
									name="documento"  id="<portlet:namespace/>xfiles" onchange="fileValidation()"/>
									
								
				
									
								<div class="alert alert-danger hidden mt-2" role="alert"
									id="alert">
									<liferay-ui:message key="rimborso-figli-info-file" />
									<%=dim %> Mb
								</div>



							</div>
						</div>
						
						<div class="container-button-general-allegati">
							<div class="ama-row">
								
								<div class="ama-col-sm-12" align="center">
									<button type="submit" id="button" 
										class="field button button-primary margin-top" 
										
										value="Upload File">
										<liferay-ui:message key="rimborso-figli-prosegui" />
									</button>
								</div>

							</div>
						</div>
					</div>

					</br>
				</aui:form>

			</div>
		</div>
	</c:when>
	<c:otherwise>
		<h1>Utente non loggato</h1>
	</c:otherwise>
</c:choose>



<script>
function fileValidation() { 
  
	var fileInput =  
        document.getElementById('<portlet:namespace/>xfiles'); 
    
    var filePath = fileInput.value; 
  
    // Allowing file type 
    var allowedExtensions =  
            /(\.jpg|\.jpeg|\.pdf|\.png|\bmp|\.)$/i; 
      
    if (!allowedExtensions.exec(filePath)) { 
    	alert('Formato file non valido');
        fileInput.value = ''; 
        $('#button').attr("disabled",false);
        $('#addAttachFileFiglio').css("display", "inline-block");
		$('#<portlet:namespace/>xfiles').css("display", "none");
        return false; 
    } 
    let dimAll = document.getElementById('dim').value; 
    console.log("DIMENSIONE FILE CONF " + dimAll);
     let fi = document.getElementById('<portlet:namespace/>xfiles'); 
     
     console.log(fi);
     
    // Check if any file is selected. 
    if (fi.files.length > 0) { 
        for (var i = 0; i <= fi.files.length - 1; i++) { 
        	console.log("dentro");
            let fsize = fi.files.item(i).size; 
            let file = Math.round((fsize / 1024)); 
            // The size of the file. 
            if (file >= (dimAll * 1024)) { 
            	$('#alert').removeClass("hidden");
            	$('#button').attr("disabled",true);
            } else { 
            	$('#alert').addClass("hidden");
            	$('#button').attr("disabled",false);
            
            } 
        } 
    } 
    

    
} 
</script>



<script type="text/javascript">
	
	
	var displayNoAllegato =  "<%=displayNoAllegato%>";

	var idAttachFileDiv = "#<portlet:namespace/>fileAttachDiv";

	var idButtonAddAttachFile = "#<portlet:namespace/>addAttachFile";
	var idFileAttachForm = "#<portlet:namespace/>fileAttachForm";
	var idFileAttach = "#<portlet:namespace/>fileAttach";

	var idSelectFile = "#<portlet:namespace/>selectFile";

	var idFlagTipoSpesaPersonale = "#<portlet:namespace/>FlagTipoSpesa";
	var idFlagTipoSpesaFiglio = "#<portlet:namespace/>FlagTipoSpesaFiglio";
	var idVecchioAllegato = "#<portlet:namespace/>vecchioAllegato";
	var idRemoveAllegato = "#<portlet:namespace/>removeFile";

	var idForm = "#<portlet:namespace/>richiestaRimborso";

	var idMensilePersonale = "<portlet:namespace/>mensilePersonale";
	var idAnnualePersonale = "<portlet:namespace/>annualePersonale";

	var idMensileFiglio = "<portlet:namespace/>mensileFiglio";
	var idAnnualeFiglio = "<portlet:namespace/>annualeFiglio";

	var idFileName = "#<portlet:namespace/>fileName";
	var mensileAnnualeFiglioDiv = "#<portlet:namespace/>mensileAnnualeFiglio";
	var mensileAnnualePersonaleDiv = "#<portlet:namespace/>mensileAnnualePersonale";

	if (displayNoAllegato == "display:block") {
		
		addParsleyFile("Figlio");
		addParsleyFile("Personale");
	}

	function addParsleyFile(tab) {

		$("#allegatoDiv" + tab).text("");
		var input = document.createElement("input");

		$(input).attr("id", "<portlet:namespace/>fileAttach" + tab);
		$(input).attr("name", "<portlet:namespace/>Allegato");
		$(input).attr("type", "file");
		$(input).css("display", "none");
		$(input).attr("accept", ".pdf,.jpg,.jepg,.png,.bmp");
		$(input).attr("data-parsley-filemaxmegabytes", "1");
		$(input).attr("data-parsley-trigger", "change");
		$(input).attr("data-parsley-required", "true");
		$(input).attr("data-parsley-required-message",
				"<liferay-ui:message key='error-mandatory'/>");
		$(input).attr("data-parsley-check-file-attach-extension",
				".jpeg,.png,.jpg,.bmp,.pdf");

		$(input).change(function() {
			changeDisplay(tab, this.value);
		});
		$("#allegatoDiv" + tab).append(input);

	}

	function resetForm() {
		$(idForm + "Figlio").find(".removeFieldFormTrasporti").each(function() {
			$(this).val("");
		});

		$(idForm + "Personale").find(".removeFieldFormTrasporti").each(
				function() {
					$(this).val("");
				});

		$(idForm + "Personale").find("textarea").each(function() {
			$(this).next().text("0/500");

		});
		$(idForm + "Figlio").find("textarea").each(function() {
			$(this).next().text("0/500");

		});

		resetAllegato("Personale");
		resetAllegato("Figlio");

	}

	function resetAllegato(tab) {
		$(idAttachFileDiv + tab).css("display", "none");
		$(idSelectFile + tab).css("display", "block");
		$(idVecchioAllegato + tab).val("");

	}

	function removeAllegato(tab) {
		event.preventDefault();
		event.stopPropagation();
		$(idFileAttach + tab).val("");
		resetAllegato(tab);
		if (displayNoAllegato == "display:none") {
			addParsleyFile("Figlio");
			addParsleyFile("Personale");
		}
	}

	function changeDisplay(tab, val) {

		$(idFileAttach + tab).parsley().validate();

		if (val != null && val != ""
				&& $(idFileAttach + tab).parsley().isValid()) {
			$(idFileAttach + tab).parsley().destroy();

			var index = val.lastIndexOf('\\');
			var value = val.substring(index + 1, val.length);
			$(idAttachFileDiv + tab).css("display", "block");
			var arrayFiles = [];
			var insideText = "<a href='#' title='elimina file' onclick='removeAllegato(";

			insideText = insideText.concat('"');
			insideText = insideText.concat(tab);
			insideText = insideText.concat('"');

			insideText = insideText
					.concat(");' class='icomoon-close-white ico-delete'></a>");

			$(idAttachFileDiv + tab).find(idFileName + tab).text(value);
			$(idAttachFileDiv + tab).find(idFileName + tab).append(insideText);
			$(idSelectFile + tab).css("display", "none");
			$(idVecchioAllegato + tab).val("");

		} else {
			if (!$(idFileAttach + tab).parsley().isValid())
				resetAllegato(tab);

		}

	}

	$(idButtonAddAttachFile + "Figlio").on('click', function(event) {

		addParsleyFile("Figlio");

		$(idFileAttach + "Figlio").click();
	});

	$(idButtonAddAttachFile + "Personale").on('click', function(event) {
		addParsleyFile("Personale");
		$(idFileAttach + "Personale").click();
	});

	function checkAnnualeMensile(idForm, idDiv, idMensile, idAnnuale) {
		if ($('input[name=<portlet:namespace/>TipoViaggio]:checked', idForm)
				.val() == "mensile") {

			var annuale = $(idDiv).find("#" + idAnnuale);
			$(annuale).css("display", "none");

			var mensile = $(idDiv).find("#" + idMensile);
			$(mensile).css("display", "block");

			$(idDiv)
					.find("label")
					.each(
							function() {
								$(this).attr("for", idMensile);
								$(this)
										.text(
												"<liferay-ui:message key='trasporti-numero-titoli-viaggi'/>*");
							});
		} else {
			if ($('input[name=<portlet:namespace/>TipoViaggio]:checked', idForm)
					.val() == "annuale") {

				var mensile = $(idDiv).find("#" + idMensile);
				$(mensile).css("display", "none");

				var annuale = $(idDiv).find("#" + idAnnuale);
				$(annuale).css("display", "block");

				$(idDiv)
						.find("label")
						.each(
								function() {
									$(this).attr("for", idMensile);
									$(this)
											.text(
													"<liferay-ui:message key='trasporti-data-acquisto-titolo-viaggio'/>*");
								});

			} else {
				$(idDiv).text("");
			}
		}
	}

	checkAnnualeMensile(idForm + "Personale", mensileAnnualePersonaleDiv,
			idMensilePersonale, idAnnualePersonale);
	refreshParsley(idForm + "Figlio", "#" + idMensileFiglio, "#"
			+ idAnnualeFiglio, "false");

	checkAnnualeMensile(idForm + "Figlio", mensileAnnualeFiglioDiv,
			idMensileFiglio, idAnnualeFiglio);
	refreshParsley(idForm + "Personale", "#" + idMensilePersonale, "#"
			+ idAnnualePersonale, "false");

	$(idForm + "Figlio" + ' input[name=<portlet:namespace/>TipoViaggio]').on(
			'change',
			function() {

				checkAnnualeMensile(idForm + "Figlio", mensileAnnualeFiglioDiv,
						idMensileFiglio, idAnnualeFiglio);
				refreshParsley(idForm + "Figlio", "#" + idMensileFiglio, "#"
						+ idAnnualeFiglio);
			});
	$(idForm + "Personale" + ' input[name=<portlet:namespace/>TipoViaggio]')
			.on(
					'change',
					function() {

						checkAnnualeMensile(idForm + "Personale",
								mensileAnnualePersonaleDiv, idMensilePersonale,
								idAnnualePersonale);
						refreshParsley(idForm + "Personale", "#"
								+ idMensilePersonale, "#" + idAnnualePersonale);
					});

	function refreshParsley(idForm, idMensile, idAnnuale, flagParsley) {
		if (flagParsley == null || flagParsley != "false")
			$(idForm).parsley().destroy();

		if (($(idMensile).css("display") == "block")) {
			$(idAnnuale).attr("data-parsley-required", "false");
			$(idAnnuale).removeAttr("data-parsley-required-message");
			$(idAnnuale).removeAttr("data-parsley-pattern");
			$(idAnnuale).removeAttr("data-parsley-pattern-message");
			$(idAnnuale).removeAttr("data-parsley-check-year-after-today");

			$(idMensile).attr("data-parsley-required", "true");
			$(idMensile).attr("data-parsley-required-message",
					'<liferay-ui:message key="error-mandatory"/>');

			if (idForm.indexOf("Figlio") > 0) {
				$(idMensile).attr("data-parsley-min", "9");
				$(idMensile)
						.attr("data-parsley-min-message",
								'<liferay-ui:message key="error-min-number-travels-childs"/>');
			} else {
				$(idMensile).attr("data-parsley-min", "11");
				$(idMensile).attr("data-parsley-min-message",
						'<liferay-ui:message key="error-min-number-travels"/>');
			}
		} else {
			$(idMensile).attr("data-parsley-required", "false");

			$(idMensile).removeAttr("data-parsley-required-message");
			$(idMensile).removeAttr("data-parsley-min");
			$(idMensile).removeAttr("data-parsley-min-messag");
			$(idAnnuale).attr("data-parsley-required", "true");
			$(idAnnuale).attr("data-parsley-check-year-after-today", "");

			$(idAnnuale).attr("data-parsley-required-message",
					'<liferay-ui:message key="error-mandatory"/>');
			$(idAnnuale).attr('data-parsley-pattern',
					/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)\d\d/);
			$(idAnnuale).attr("data-parsley-pattern-message",
					'<liferay-ui:message key="error-syntactic"/>');

		}
		if (flagParsley == null || flagParsley != "false")
			$(idForm).parsley();

	}

	function saveForm() {
		if ($("#for-itself").hasClass("collapse in")) {
			if ($(idFileAttach + "Personale").lenght == 0)
				addParsleyFile("Personale");
			refreshParsley(idForm + "Personale", "#" + idMensilePersonale, "#"
					+ idAnnualePersonale);
			$(idFlagTipoSpesaPersonale).val("personale");
			$(idForm + "Personale").submit();

		} else {
			if ($(idFileAttach + "Figlio").lenght == 0)
				addParsleyFile("Figlio");
			refreshParsley(idForm + "Figlio", "#" + idMensileFiglio, "#"
					+ idAnnualeFiglio);
			$(idFlagTipoSpesaFiglio).val("figli a carico");
			$(idForm + "Figlio").submit();
			console.log("*********");

		}

	}

	function saveForm2() {

		if ($(idFileAttach + "Figlio").lenght == 0) {
			addParsleyFile("Figlio");
			refreshParsley(idForm + "Figlio", "#" + idMensileFiglio, "#"
					+ idAnnualeFiglio);
			$(idFlagTipoSpesaFiglio).val("figli a carico");
			$(idForm + "Figlio").submit();

		}

	}
</script>


<script>
function checkCF(value,dataMax,dataMin,event){
    
    var data = prendiDataDaCF(value,event);
    console.log('data: '+data);
    var id = event.target.name
    console.log(event.target.id);
    dataMax= new Date(dataMax);
    dataMin= new Date(dataMin);
    if(data<dataMax && data>dataMin) {
        console.log("FIGLIO VALIDO");
    }else {
        console.log("FIGLIO NON VALIDO");
        alert("Codice Fiscale inserito non valido");
        document.getElementById(id).value = "";
        }
    }


 

function prendiDataDaCF(value,event){
	var id = event.target.name;
    var data_cf = value.substring(6,11);
    var anno = data_cf.substring(0,2);
    var mese = data_cf.substring(2,3);
    var giorno = data_cf.substring(3,5);    
    console.log('anno: '+anno);
    console.log('mese: '+mese);
    console.log('giorno: '+giorno);
    
    if(giorno>71){
        console.log('errore giorno');
        document.getElementById(id).value = "";
        alert("Giorno errato");
    }else{
        if(giorno>31 && giorno<41){
            console.log('errore giorno 2');
            document.getElementById(id).value = "";
            alert("Giorno errato");}
        else{
            if(giorno>40 && giorno<72){
                giorno = giorno-40;
            }
        }
    }
    
    mese = getMese(mese);
    if(mese<1){
        console.log('errore mese');
        document.getElementById(id).value = "";
        alert("Mese errato");
    }
    
    var annoM = "20"+anno;
    
    var data = new Date(annoM,mese-1,giorno);
    return data;
}

 

 

function getMese(mese) {
    /*
    Gennaio = A    Maggio = E    Settembre = P
            Febbraio = B    Giugno = H    Ottobre = R
            Marzo = C    Luglio = L    Novembre = S
            Aprile = D    Agosto = M    Dicembre = T
    */    
    var meseN = 0; 
    var mese = mese.toUpperCase();
    switch (mese) {
    case "A":
        meseN = 1;
        break;
    case "E":
        meseN = 5;
        break;
    case "P":
        meseN = 9;
        break;
    case "B":
        meseN = 2;
        break;
    case "H":
        meseN = 6;
        break;
    case "R":
        meseN = 10;
        break;
    case "C":
        meseN = 3;
        break;
    case "L":d
        meseN = 7;
        break;
    case "S":
        meseN = 11;
        break;
    case "D":
        meseN = 4;
        break;
    case "M":
        meseN = 8;
        break;
    case "T":
        meseN = 12;
        break;
    }        
    console.log("meseN: "+meseN);    
    return meseN;
    
}
</script>



<aui:script use="liferay-auto-fields">

new Liferay.AutoFields({
	contentBox: '#auto-fields-container',
	fieldIndexes: '<portlet:namespace />rowIndexes',
	
	on: {
		'clone': function(event) {
			console.log('Clone event');
			console.log(event);
 			
 			var dom = document.getElementById('counterFigliID');
 			var valueFiglio = parseInt(dom.value)
 			dom.value=valueFiglio+1
 			var counterIndex = event.guid;
 			var idNF = '<portlet:namespace />NomeFiglio'+counterIndex;
 			var idDF = '<portlet:namespace />DataNascitaFiglio'+counterIndex;
 			var idLDF = '<portlet:namespace />LuogoNascitaFiglio'+counterIndex;
 			var idLIF = '<portlet:namespace />ImportoFiglio'+counterIndex;
 			var idDFJQ = '#<portlet:namespace />DataNascitaFiglio'+counterIndex;
 			document.getElementById(idNF).value = "";
 			document.getElementById(idDF).value = "";
 			document.getElementById(idLDF).value = "";
 			document.getElementById(idLIF).value = "";
 			
 			$(idDFJQ).datetimepicker({
        		format: 'DD/MM/YYYY'
    		})
 			
 			
			console.log('Cloned node');
			console.log(event.row);
		},
		'delete': function(event) {
				console.log('Delete event');
			var ua = navigator.userAgent;
   			var is_ie = ua.indexOf("MSIE ") > -1 || ua.indexOf("Trident/") > -1;
   				console.log("IS IE " + is_ie);
			var listDel = document.getElementsByClassName("lfr-form-row hide");
			
			if(listDel != null && listDel.length>0){
			console.log("LIST DEL LENGTH " +  listDel.length);
			
			for (let i = 0; i < listDel.length; i++) {
				if(!is_ie){
					listDel[i].remove()
 				 	console.log("ELEMENTO RIMOSSO")
				}else{
					listDel[i].parentNode.removeChild(listDel[i]);
				}
 				 
 				 
			}
			
			}else{
			console.log("NON CI SONO ELEMENTI DA RIMUOVERE")
			}
			
			
			
		}
	},
	sortable: false,
	sortableHandle: '.lfr-form-row'
}).render();
</aui:script>

<script>
$('#<portlet:namespace/>xfiles').on("change",function(){
	if($('#<portlet:namespace/>xfiles').val()!=""){
		$('#addAttachFileFiglio').css("display", "none");
		$('#<portlet:namespace/>xfiles').css("display", "block");
		}
})

$('#addAttachFileFiglio').on("click", function(){
	event.preventDefault();
	$('#<portlet:namespace/>xfiles').click();
	
	console.log("VALORE INPUT FILE :" + $('#<portlet:namespace/>xfiles').val());
})
</script>

<!-- <script>



window.addEventListener("beforeunload", function(event) {
	console.log("EVENTO SCATENATO IN VIEW :" + event)
	AUI().use('aui-io-request', function(A){
        A.io.request('${MefRichiesteFigliFormPortlet}', {
               method: 'post',
              on: {
                   	success: function() {
                        console.log("SUCCESSO AJAX VIEW")
                    }
              }
        });
    });
});
</script> -->







<style>
.lfr-form-row:hover {
	border-color: transparent !important;
	background-color: transparent !important;
}

.lfr-form-row {
	border-bottom-color: transparent !important;
}
.undomanager{
	display:none !important;
}
</style>


<style type="text/css">
p.uppercase {
	text-transform: uppercase
}
input[type="file"] {
    display: none;
}


</style>