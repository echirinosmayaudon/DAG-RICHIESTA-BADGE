<%@ include file="/init.jsp" %>

<%@ page import="com.accenture.mef.lavoro.agile.form.bean.OpzioniBean"%>
<%@ page import="com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalServiceUtil"%>
<%@ page import="com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.log.Log"%>
<%@ page import="com.accenture.mef.lavoro.agile.form.portlet.MefLavoroAgileConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile" %>
<%@ page import="com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalServiceUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="com.accenture.mef.lavoro.agile.form.bean.ModuloRichiesta" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	Log _log = LogFactoryUtil.getLog("recap_jsp");

	
String displaySelezionaFile = "display:block";
String displaySummaryAttach = "display:none";
String attachFileName = "";
String attachFileRealName = "";
String attachFilePath = "";



	String title = "Riepilogo";
	String fileNameCustom = null;
	String fileNameCustomNuovoAllegato = null;
	String dichiarazioneTmp = ""; 
	String dichiarazioneCur = "";
	
	OpzioniBean opzioneBean = null;
	if (request.getAttribute("opzioniBean") != null)
		opzioneBean = (OpzioniBean) request.getAttribute("opzioniBean");
	
	long richlavId = 0L;
	if( ParamUtil.getLong(request, "richlavId")!=0 ){
		richlavId = ParamUtil.getLong(request, "richlavId");
	} else if( request.getAttribute("richlavId") != null ) {
		richlavId = Long.parseLong(String.valueOf(request.getAttribute("richlavId")));
	}
	
	int pesoFigliOver13 = 0;
	int pesoFigliUnder13 = 0;
	int pesoFamiliari = 0;
	int punteggio = 0;			
			
	ModuloRichiesta moduloRichiesta = null;
	String dotazione_inform = null;
	List<String> dichiarazioni_list = null;
	String urlAllegato = null;
	String urlNuovoAllegato = null;
	RichLavAgile richiesta = null;
	
	// se la navigazione vale dettaglio ricaviamo dal db la richiesta mediante l'id in ingresso come parametro e settiamo gli oggetti necessari con i suoi valori
	if (richlavId != 0) {
		
		title = "Dettaglio";
		richiesta = RichLavAgileLocalServiceUtil.getRichLavAgile(richlavId);
		String richiestaJson = richiesta.getJson_richiesta();
		String richiedenteJson = richiesta.getJson_richiedente();
		//JSONObject json_object_richiesta = JSONFactoryUtil.createJSONObject(richiestaJson);
		JSONObject json_object_richiedente = JSONFactoryUtil.createJSONObject(richiedenteJson);
		//TODO: settare gli oggetti con i dati recuperati dai JSON 
		moduloRichiesta = new ModuloRichiesta();
		moduloRichiesta.setNome(richiesta.getNome());
		moduloRichiesta.setCognome(richiesta.getCognome());
		moduloRichiesta.setCodiceFiscale(richiesta.getScreename());
		moduloRichiesta.setDipartimento(json_object_richiedente.getString("dipartimento"));
		moduloRichiesta.setDirezione(json_object_richiedente.getString("direzione"));
		moduloRichiesta.setUfficio(json_object_richiedente.getString("ufficio"));
		moduloRichiesta.setEmail(json_object_richiedente.getString("email"));
		moduloRichiesta.setDataNascita(json_object_richiedente.getString("data_nascita"));
		moduloRichiesta.setLuogoNascita(json_object_richiedente.getString("luogo_nascita"));
		moduloRichiesta.setResidenzaCitta(json_object_richiedente.getString("residenza_citta"));
		moduloRichiesta.setResidenzaVia(json_object_richiedente.getString("residenza_indirizzo"));
		moduloRichiesta.setAreaAppartenenza(json_object_richiedente.getString("area"));
		moduloRichiesta.setFasciaRetributiva(json_object_richiedente.getString("fascia_retributiva"));
		
		//ricavo dal fileEntry il file mediante l'UUID ricavato dalla richiesta
		String uuidallegatoStr = richiesta.getAllegato();
		DLFileEntry dlFileEntryAllegato = DLFileEntryLocalServiceUtil
		.getFileEntryByUuidAndGroupId(uuidallegatoStr, themeDisplay.getLayout().getGroupId());
		urlAllegato = Long.toString(dlFileEntryAllegato.getFileEntryId());
		File fileTmp = DLFileEntryLocalServiceUtil.getFile(dlFileEntryAllegato.getFileEntryId(),
		dlFileEntryAllegato.getVersion(), false);
		moduloRichiesta.setAllegato(fileTmp);
		moduloRichiesta.setAllegatoMimeType(dlFileEntryAllegato.getMimeType());
		moduloRichiesta.setAllegatoNome(dlFileEntryAllegato.getFileName());
		
		long  fileSize = (dlFileEntryAllegato.getSize())/1024;
	    
		fileSize = Math.round((fileSize) ) ;
		String fileNameData = dlFileEntryAllegato.getFileName();
		StringBuilder sb = new StringBuilder();
		
		sb.append(fileNameData.substring(0, fileNameData.indexOf("(")));
		sb.append(fileNameData.substring((fileNameData.lastIndexOf(")")+1)));
		sb.append(" (");
		sb.append(String.valueOf(fileSize));
		sb.append(" KB)");
		
		fileNameCustom = sb.toString();
		
		//ricavo dal fileEntry il file pdf nuovo allegato(progetto+accordo) mediante l'UUID ricavato dalla richiesta
		String uuidNuovoAllegatoStr = richiesta.getPdf();
		if(uuidNuovoAllegatoStr != null && !("").equals(uuidNuovoAllegatoStr)){
			DLFileEntry dlFileEntryNuovoAllegato = DLFileEntryLocalServiceUtil
			.getFileEntryByUuidAndGroupId(uuidNuovoAllegatoStr, themeDisplay.getLayout().getGroupId());
			urlNuovoAllegato = Long.toString(dlFileEntryNuovoAllegato.getFileEntryId());
			File fileTmpNuovoAllegato = DLFileEntryLocalServiceUtil.getFile(dlFileEntryNuovoAllegato.getFileEntryId(),
			dlFileEntryNuovoAllegato.getVersion(), false);
			moduloRichiesta.setAllegato(fileTmpNuovoAllegato);
			moduloRichiesta.setAllegatoMimeType(dlFileEntryNuovoAllegato.getMimeType());
			moduloRichiesta.setAllegatoNome(dlFileEntryNuovoAllegato.getFileName());
			long  fileSizeNuovoAllegato = (dlFileEntryNuovoAllegato.getSize())/1024;
		    
			fileSizeNuovoAllegato = Math.round((fileSizeNuovoAllegato) ) ;
			String fileNameDataNuovoAllegato = dlFileEntryNuovoAllegato.getFileName();
			StringBuilder sbNuovoAllegato = new StringBuilder();
			
			sbNuovoAllegato.append(fileNameDataNuovoAllegato.substring(0, fileNameDataNuovoAllegato.indexOf("(")));
			sbNuovoAllegato.append(fileNameDataNuovoAllegato.substring((fileNameDataNuovoAllegato.lastIndexOf(")")+1)));
			sbNuovoAllegato.append(" (");
			sbNuovoAllegato.append(String.valueOf(fileSize));
			sbNuovoAllegato.append(" KB)");
			
			fileNameCustomNuovoAllegato = sbNuovoAllegato.toString();
			
			displaySelezionaFile = "display:none";
			displaySummaryAttach = "display:block";
		}

		
		if (richiesta != null) {
			JSONObject json_object_richiesta = JSONFactoryUtil.createJSONObject(richiestaJson);
			JSONArray json_array_richiesta = json_object_richiesta.getJSONArray("opzioni");
			
			dichiarazioni_list = new ArrayList<>();
			
			for (int i = 0; i < json_array_richiesta.length(); i++) {
				JSONObject json_object_opzione = json_array_richiesta.getJSONObject(i);
				// CASO: checkbox semplice
				if (("checkbox").equalsIgnoreCase((json_object_opzione).getString("type"))) {
					if ((json_object_opzione).getString("valore").contains("true")) {
						OpzioneRich opzione = OpzioneRichLocalServiceUtil
								.getOpzioneRich(Long.parseLong((json_object_opzione).getString("id")));
						String opzioneTxt = opzione.getTesto_opt();
						if (opzioneTxt.indexOf("<#link>") != -1) {
							opzioneTxt = opzioneTxt.replace("<#link>", "");
							opzioneTxt = opzioneTxt + "|regolamento|0";
						} else {
							if( i==2 || i==3 ){
								opzioneTxt = opzioneTxt + "|true|0";
							} else {
								opzioneTxt = opzioneTxt + "|false|" + opzione.getPeso_opt();
							}
						}
						dichiarazioni_list.add(opzioneTxt);
					}
				
				// CASO: radio
				} else if (("radio").equalsIgnoreCase((json_object_opzione).getString("type"))) {
					if ((json_object_opzione).getString("valore").contains("true")) {
						OpzioneRich opzioneDip = OpzioneRichLocalServiceUtil
								.getOpzioneRich(Long.parseLong((json_object_opzione).getString("id_dip")));
						OpzioneRich opzioneRadio = OpzioneRichLocalServiceUtil
								.getOpzioneRich(Long.parseLong((json_object_opzione).getString("id")));
						if (("dotazione informatica").equalsIgnoreCase(opzioneDip.getLabel_opt())) {
							dotazione_inform = opzioneRadio.getTesto_opt();
						} else {
							StringBuilder opzioneString = new StringBuilder();
							opzioneString.append(opzioneDip.getTesto_opt());
							opzioneString.append(" ");
							opzioneString.append(opzioneRadio.getTesto_opt());
							opzioneString.append("|false|"+opzioneRadio.getPeso_opt());
							dichiarazioni_list.add(opzioneString.toString());
						}
					}
					
				// CASO: checkbox con input
				} else if (("checkboxWithValue").equalsIgnoreCase((json_object_opzione).getString("type"))) {
					if (!(json_object_opzione).getString("valore").contains("false")) {
						OpzioneRich opzioneInput = OpzioneRichLocalServiceUtil
								.getOpzioneRich(Long.parseLong((json_object_opzione).getString("id")));
						String startInput = "<#input";
						String endInput = "#>";
						String[] arr = new String[json_object_opzione.getJSONArray("valore").length()];
						for (int k = 0; k < json_object_opzione.getJSONArray("valore").length(); k++) {
							arr[k] = json_object_opzione.getJSONArray("valore").getString(k);
						}
						
						// caso 2 input
						if (("esigenza cura figli").equalsIgnoreCase(opzioneInput.getLabel_opt())) {
							StringBuilder opzioneString = new StringBuilder();
							opzioneString.append(opzioneInput.getTesto_opt().substring(0,
									opzioneInput.getTesto_opt().indexOf(startInput)));
							opzioneString.append(arr[0]);
							opzioneString.append(opzioneInput.getTesto_opt().substring(
									(opzioneInput.getTesto_opt().indexOf(endInput) + endInput.length()),
									opzioneInput.getTesto_opt().lastIndexOf(startInput)));
							opzioneString.append(arr[1]);
							opzioneString.append(opzioneInput.getTesto_opt().substring(
									(opzioneInput.getTesto_opt().lastIndexOf(endInput) + endInput.length())));
							
							pesoFigliUnder13 = Integer.parseInt( opzioneInput.getTesto_opt().split("=")[1].substring(0, opzioneInput.getTesto_opt().split("=")[1].indexOf("#") ) );
							pesoFigliOver13 = Integer.parseInt( opzioneInput.getTesto_opt().split("=")[2].substring(0, opzioneInput.getTesto_opt().split("=")[2].indexOf("#") ) );
							punteggio = pesoFigliUnder13 * Integer.parseInt(arr[0]) + pesoFigliOver13 * Integer.parseInt(arr[1]);
							opzioneString.append("|false|"+punteggio);
							
							dichiarazioni_list.add(opzioneString.toString());
							// caso 1 input
						} else if (("assistenza familiari").equalsIgnoreCase(opzioneInput.getLabel_opt())) {
							StringBuilder opzioneString = new StringBuilder();
							opzioneString.append(opzioneInput.getTesto_opt().substring(0,
									opzioneInput.getTesto_opt().indexOf(startInput)));
							opzioneString.append((String) arr[0]);
							opzioneString.append(opzioneInput.getTesto_opt().substring(
									(opzioneInput.getTesto_opt().lastIndexOf(endInput) + endInput.length())));
							
							pesoFamiliari = Integer.parseInt( opzioneInput.getTesto_opt().split("=")[1].substring(0, opzioneInput.getTesto_opt().split("=")[1].indexOf("#") ) );
							punteggio = pesoFamiliari * Integer.parseInt(arr[0]);
							opzioneString.append("|false|"+punteggio);
							
							dichiarazioni_list.add(opzioneString.toString());
						}
					}
				}
			}
			
			moduloRichiesta.setNote(json_object_richiesta.getString("note"));
		}
		
	} else {
		if (request.getAttribute("moduloRichiesta") != null)
			moduloRichiesta = (ModuloRichiesta) request.getAttribute("moduloRichiesta");
		if (request.getAttribute("dotazione_inform") != null)
			dotazione_inform = (String) request.getAttribute("dotazione_inform");
		if (request.getAttribute("dichiarazioni_list") != null)
			dichiarazioni_list = (ArrayList<String>) request.getAttribute("dichiarazioni_list");
	}

	boolean booleanRichiedenteLavAgile = false;
	boolean booleanSegreteriaLavAgile = false;
	boolean booleanLayoutViewPermissionRichiedenteLavAgile = false;
	
	if(request.getAttribute("booleanRichiedenteLavAgile")!=null) {
		booleanRichiedenteLavAgile = (boolean)request.getAttribute("booleanRichiedenteLavAgile");
	}
	if(request.getAttribute("booleanSegreteriaLavAgile")!=null) {
		booleanSegreteriaLavAgile = (boolean)request.getAttribute("booleanSegreteriaLavAgile");
	}
	if(request.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgile")!=null) {
		booleanLayoutViewPermissionRichiedenteLavAgile = (boolean)request.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgile");
	}
	
	// IMEF-1780
	boolean requestInsertConditionOK = false;
	if(request.getAttribute("requestInsertConditionOK")!=null) {
		requestInsertConditionOK = (boolean)request.getAttribute("requestInsertConditionOK");
	}
	// end IMEF-1780
	
	//INIZIO SEZIONE ALLEGATO AGGIUNTIVO
	String resultVisibilitaAllegato = null;
	if(request.getAttribute("resultVisibilitaAllegato")!=null){
		resultVisibilitaAllegato = (String)request.getAttribute("resultVisibilitaAllegato");
	}
	boolean flagDisableUpdateNuovoAllegatoOORange = false;
	if(request.getAttribute("flagDisableUpdateNuovoAllegatoOORange")!=null) {
		flagDisableUpdateNuovoAllegatoOORange = (boolean)request.getAttribute("flagDisableUpdateNuovoAllegatoOORange");
	}
	// SEZIONE ALLEGATO AGGIUNTIVO
	
%>
<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"/> 
<portlet:actionURL var="vaiAModifica" name="vaiAModifica"/> 
<portlet:actionURL var="invia" name="invia"/> 
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
<portlet:actionURL var="ricerca" name="ricerca"/>
<portlet:actionURL var="invioAllegatoPlus" name="invioAllegatoPlus"/>
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>



     <div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                     
                     <c:choose>
                     	<c:when test="<%=!("recap").equalsIgnoreCase((String) request.getAttribute("navigation"))%>">
                     		<h2 class="title"><%=formTitleDettaglio%></h2>
                     	</c:when>
                     	<c:otherwise>
                     		<h2 class="title"><%=formTitleRecap%></h2>
                     	</c:otherwise>
                     </c:choose>
                   
					<div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
						<c:if test="<%=!("recap").equalsIgnoreCase((String) request.getAttribute("navigation")) && requestInsertConditionOK%>">
							<button href="#" type="button"
								class="button-xs button button-primary mr-10-xs"
								id="<portlet:namespace/>btnNuovaRichiesta">
								<liferay-ui:message key='btnNuovaRichiesta'/>  
								<span class="icomoon-plus icon-beni"></span>
							</button>
						</c:if>
						<c:if test="<%=booleanSegreteriaLavAgile%>">
						<c:choose>
						<c:when test="<%=request.getAttribute("listaDaRicerca")!=null && !("").equalsIgnoreCase((String)request.getAttribute("listaDaRicerca")) %>">
							<a href="<%=ricerca%>" title="<liferay-ui:message key="label-title-ricerca"/>" class="icon icomoon-search-richiesta"></a>
						</c:when>
						<c:otherwise>
							<a href="<%=vaiARicerca%>" title="<liferay-ui:message key="label-title-ricerca"/>" class="icon icomoon-search-richiesta"></a>
						</c:otherwise>
						</c:choose>
						
						</c:if>
					</div>
						<form action="<%=vaiAInserimento%>"
							id="<portlet:namespace/>nuovaRichiestaForm" method="post">
						</form>
                  
					 <c:choose>
                     	<c:when test="<%=!("recap").equalsIgnoreCase((String) request.getAttribute("navigation"))%>">
                     		<h2 class="subtitle dot-point dot-200"><%=formSubTitleDettaglio%></h2>
                     	</c:when>
                     	<c:otherwise>
                     		<h2 class="subtitle dot-point dot-200"><%=formSubTitleRecap%></h2>
                     	</c:otherwise>
                     </c:choose>
                     
                     </div>
                 </div>
             </div>
         </div>
     </div>
     <c:choose>
     <c:when test="<%=("recap").equalsIgnoreCase((String) request.getAttribute("navigation")) && !requestInsertConditionOK%>">
     <div class="wrapper-added-notice">
  		<div class="clearfix">
			<div class="display-xs">
		      <div class="div-message-important color-violet">
		        <div class="icomoon-alert"></div>
		        <div class="message-important">
		        <%=msgTerminiScaduti%>
		        </div>
		      </div>
		    </div>
		</div>
	</div>
    </c:when>
	<c:otherwise>
     <div class="ama-container-fluid">
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small title-data-agile">
                     <h2 class="title-box borders"><%=title%> <liferay-ui:message key='recap-dettaglio-richiesta'/></h2>
                 </div>
             </div>
         </div>
         
         <c:if test = "<%=!("recap").equalsIgnoreCase((String) request.getAttribute("navigation")) && resultVisibilitaAllegato !=null && (richiesta.getScreename()).equalsIgnoreCase(themeDisplay.getUser().getScreenName())%>" >
         
         <div class="wrapper-added-notice">
  		<div class="clearfix">
			<div class="display-xs">
		      <div class="div-message-important color-violet">
		        <div class="icomoon-alert"></div>
		        <div class="message-important">
		        <%=resultVisibilitaAllegato%>
		        </div>
		      </div>
		    </div>
		</div>
	</div>
         
         
          </c:if>
         <div class="ama-row">
             <div class="ama-col-xs-12 mobile-no-padding">
                 <div class="form-request mobile-no-padding">
                     <div class="box-gray">
                         <div class=" box-white pb-0-xs">
                             <p class="name"><%=moduloRichiesta.getNome()%> <%=moduloRichiesta.getCognome()%></p>
                             <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
                             <div id="collapse-trasporti" class="collapse1 in no-overflow">
                             
                              <div class="ama-row border-section border-mobile">
                                  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key='label-luogo-di-nascita-richiedente'/>:</span>
                                      <p class="info"><%=moduloRichiesta.getLuogoNascita()%></p>
                                  </div>
                                   <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key='label-data-di-nascita-richiedente'/>:</span>
                                      <p class="info"><%=moduloRichiesta.getDataNascita()%></p>
                                  </div>
                                  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key='label-codice-fiscale-richiedente'/>:</span>
                                      <p class="info"><%=moduloRichiesta.getCodiceFiscale().toUpperCase()%></p>
                                  </div>
                              </div>
                              
                              <p class="name-section"><liferay-ui:message key='label-residenza-richiedente'/></p>
                              <div class="ama-row border-section">
                                 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key='label-indirizzo-residenza-richiedente'/>:</span>
                                      <p class="info"><%=moduloRichiesta.getResidenzaVia()%></p>
                                  </div>
                                  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key='label-citta-residenza-richiedente'/>:</span>
                                      <p class="info"><%=moduloRichiesta.getResidenzaCitta()%></p>
                                  </div>
                              </div>
                              <p class="name-section"><liferay-ui:message key='label-assegnazione-richiedente'/></p>
							<div class="ama-row">
								 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key='label-dipartimento'/>:</span>
									<p class="info"><%=moduloRichiesta.getDipartimento()%></p>
								</div>
								<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key='label-direzione'/>:</span>
									<p class="info"><%=moduloRichiesta.getDirezione()%></p>
								</div>
								  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key='label-ufficio'/>:</span>
									<p class="info"><%=moduloRichiesta.getUfficio()%></p>
								</div>
							</div>
							 <div class="ama-row border-section mb-30-xs">
								  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key='label-assegnazione-email-richiedente'/>:</span>
									<p class="info"><%=moduloRichiesta.getEmail()%></p>
								</div>
								 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key='label-assegnazione-area-richiedente'/>:</span>
									<p class="info"><%=moduloRichiesta.getAreaAppartenenza()%></p>
								</div>
								 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key='label-assegnazione-fascia-retributiva-richiedente'/>:</span>
									<p class="info"><%=moduloRichiesta.getFasciaRetributiva()%></p>
								</div>
							</div>
						</div>
                         	
                          <div class="mb-10-xs">
                              <p class="section-information"><%=opzioneBean.getDichiarazione()%></p>
                               <div class="text-center">
                                        <p class="section-information"><strong><liferay-ui:message key='label-richiesta-chiede'/></strong></p>
                                    </div>
                              
                              <p class="section-information"><%=opzioneBean.getDotazioneInfo()%></p>
                          </div>
                          <div class="mb-20-xs style-list">
                              <ul>
                                  <li><%=dotazione_inform%></li>
                              </ul>
                              <div>
                                  <p class="section-information"><liferay-ui:message key='label-richiesta-pertanto'/></p>
                              </div>
                              <div class="text-center">
                                  <p class="section-information"><strong><liferay-ui:message key='label-richiesta-dichiara'/></strong></p>
                              </div>
                              
                              
                              
                              
                              <c:choose>
								<c:when test='<%=booleanSegreteriaLavAgile && ( ("dettaglio").equalsIgnoreCase((String)request.getAttribute("navigation")) || request.getAttribute("richlavId")!= null )%>'>
                                    <ul class="agile-detail__list">
                                    	<c:forEach items="<%=dichiarazioni_list%>" var="dichiarazione" >
                                    		<% 
                                    			dichiarazioneTmp = (String) pageContext.getAttribute("dichiarazione"); 
                                    			dichiarazioneCur = dichiarazioneTmp;
                                    		%>
					         				<c:choose>
												<c:when test='<%=("regolamento").equals(dichiarazioneCur.split(Pattern.quote("|"))[1])%>'>
													<li>
			                                            <div class="agile-detail__li-container">
			                                                <p class="agile-detail__li-text"><%=dichiarazioneCur.split(Pattern.quote("|"))[0]%></p>
			                                            </div>
			                                        </li>
												</c:when>	
												<c:when test='<%=Boolean.parseBoolean(dichiarazioneCur.split(Pattern.quote("|"))[1])%>'>
													<li>
				                                        <div class="agile-detail__li-container">
					                                        <p class="agile-detail__li-text"><%=dichiarazioneCur.split(Pattern.quote("|"))[0]%></p>
					                                        <span class="agile-detail__li-info"><liferay-ui:message key='label-priorita'/><span class="agile-detail__li-priority"></span></span>
				                                        </div>
				                                    </li>
												</c:when>	
												<c:otherwise>
													<li>
				                                        <div class="agile-detail__li-container">
					                                        <p class="agile-detail__li-text"><%=dichiarazioneCur.split(Pattern.quote("|"))[0]%></p>
					                                        <span class="agile-detail__li-info"><liferay-ui:message key='label-punteggio'/>: <span class="agile-detail__score"><%=dichiarazioneCur.split(Pattern.quote("|"))[2]%></span></span>
				                                        </div>
				                                    </li>
												</c:otherwise>
											</c:choose>
					    				</c:forEach>
                                    </ul>
								</c:when>	
								<c:otherwise>
									<ul>
										<c:forEach items="<%=dichiarazioni_list%>" var="dichiarazione" >
										    <% 
                                    			dichiarazioneTmp = (String) pageContext.getAttribute("dichiarazione"); 
                                    			dichiarazioneCur = dichiarazioneTmp;
                                    		%>
					         				<li><%=dichiarazioneCur.split(Pattern.quote("|"))[0]%></li>
					    				</c:forEach>
				    				</ul>
								</c:otherwise>
							  </c:choose>

			    	
                              
                          </div>
                          
                         </div>
                     </div>
                 </div>
             </div>
         </div>
         
	
	<div class="wrapper-allegati-general">
	
	<c:if test="<%=("recap").equalsIgnoreCase((String) request.getAttribute("navigation")) ||  ( richlavId!=0  && richiesta!=null && (richiesta.getPdf() == null || ("").equals(richiesta.getPdf())))%>">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-general title-attach-agile">
					<h2 class="title-box borders"><liferay-ui:message key='label-richiesta-allegato'/></h2>
				</div>
			</div>
		</div>
		<div class="ama-row">
			<div class="ama-col-md-12 mobile-no-padding">
				<div class="wrapper-content">
					<div class="wrapper-white">
						<c:choose>
							<c:when test="<%=richlavId != 0 && urlAllegato!= null%>">
								<form action="<%=resourceURL%>" method="post"
									id="<portlet:namespace/>moduloForm"
									enctype="multipart/form-data">
									<input type="hidden" name="<portlet:namespace/>idDownload"
										value="<%=urlAllegato%>">
								</form>
								<p class="text">
									<a href="javascript:submitModulo()"
									   title="download modulo Richiesta" target="_self"> <%=fileNameCustom%></a>
								</p>
							</c:when>
							<c:otherwise>
								<p class="subtitle-text"><%=(String)request.getAttribute("fileCustom")%></p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</c:if>
		
		
		
		<!-- NOTE -->
	    <c:if test="<%=moduloRichiesta.getNote() != null && !("").equalsIgnoreCase(moduloRichiesta.getNote()) %>">
	     <div class="ama-row">
                    <div class="ama-col-md-12">
                        <div class="wrapper-title-general title-note-agile">
                            <h2 class="title-box borders"><liferay-ui:message key='label-richiesta-note'/> </h2>
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
		                                <div class="ama-col-md-12 ama-col-xs-12 noteRecap">
		                                 	<form enctype="multipart/form-data"> 
												<textarea readonly class="form-control textarea-custom-light"><%=moduloRichiesta.getNote()%></textarea>
	                                    	</form>
										</div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
	    	</div>
    	</c:if>
    	
    			
		<c:if test = "<%=!("recap").equalsIgnoreCase((String) request.getAttribute("navigation")) && (((richiesta.getScreename()).equalsIgnoreCase(themeDisplay.getUser().getScreenName()) && (resultVisibilitaAllegato !=null || (richiesta!=null && richiesta.getPdf() != null && !("").equals(richiesta.getPdf())))) || (!(richiesta.getScreename()).equalsIgnoreCase(themeDisplay.getUser().getScreenName()) && richiesta!=null && richiesta.getPdf() != null && !("").equals(richiesta.getPdf())))%>" >
		
			<form action="<%=resourceURL%>" method="post"
				  id="<portlet:namespace/>moduloFormNuovoAllegato"
				  enctype="multipart/form-data">
				  <input type="hidden" name="<portlet:namespace/>idDownload" value="<%=urlNuovoAllegato%>">
			</form>
			
			<form action="<%=invioAllegatoPlus%>" id="<portlet:namespace/>nuovoAllegatoPlusForm" method="post" enctype="multipart/form-data">
						
			<div class="wrapper-allegati-general">
		                <div class="ama-row">
		                    <div class="ama-col-md-12">
		                        <div class="wrapper-title-general title-attach-agile">
		                            <h2 class="title-box borders">Allegato unico: accordo individuale e progetto individuale</h2>
		                            <a title="Caricare un allegato di dimensione non superiore a 2 MB, in formato pdf." class="tooltip-field tool-res tool-attachments">
		                                <span class="icomoon-info ico-attachments "></span>
		                            </a>
		            
		                        </div>
		                    </div>
		                </div>
		                
		                <div class="ama-row" id="<portlet:namespace/>divSelezionaFilePlus" style="<%=displaySelezionaFile%>">
		                    <div class="ama-col-md-12 mobile-no-padding">
		                        <div class="box-button">
		                            <button href="#" type="button" id="<portlet:namespace/>selezionaProgIndividualePlus" class="button button-primary"><liferay-ui:message key='form-richiesta-seleziona-file-allegato'/></button>
		                        </div>
		                    </div>
		                </div>
		                
		                <div class="ama-row" id="<portlet:namespace/>divSummaryAttachPlus" style="<%=displaySummaryAttach%>">
		                    <div class="ama-col-md-12 mobile-no-padding">
								<div class="wrapper-content">
									<div class="wrapper-white" id="<portlet:namespace/>fileNamePlus">
										<c:if test="<%=richlavId != 0 && urlNuovoAllegato!= null && !("recap").equalsIgnoreCase((String) request.getAttribute("navigation"))%>">
											<p class="text">
												<a href="javascript:submitModuloNuovoAllegato()"
												   title="download modulo Richiesta nuovo Allegato" target="_self"> <%=fileNameCustomNuovoAllegato%></a>
												 <c:if test="<%=!flagDisableUpdateNuovoAllegatoOORange && (richiesta.getScreename()).equalsIgnoreCase(themeDisplay.getUser().getScreenName())%>">
													<a href="#" title="Elimina file" onclick="removeAttach()" class="icomoon-close-white ico-delete"></a>
												</c:if>
											</p>
										</c:if>
									</div>
								</div>
		                	</div>
		                </div>
		                
		                <input type="file" 
		                       id="<portlet:namespace/>fileAttachProgIndividualePlus" 
		                       name="<portlet:namespace/>fileAttachProgIndividualePlus" 
		                       <c:if test='<%=moduloRichiesta != null && moduloRichiesta.getAllegato() != null%>' > data-parsley-required="false" </c:if> 
					           <c:if test='<%=moduloRichiesta == null || moduloRichiesta.getAllegato() == null%>' > data-parsley-required="true" </c:if> 
		                       data-parsley-required-message="Si richiede l'inserimento di un nuovo allegato."
		                       data-parsley-filemaxmegabytes="2"
		                       data-parsley-filemaxmegabytes-message="<liferay-ui:message key="form-allegato-dimensioni-extra-pdf-parsley"/>."
		                       data-parsley-check-file-attach-extension=".pdf"
		                       data-parsley-check-file-attach-extension-message="<liferay-ui:message key="form-allegato-estensione-non-supportata-parsley"/>." 
		                       style="display:none"/>
		                     
		                <input type="text" style="display:none" data-parsley-pattern="[a-zA-Z0-9 ._ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½]+" 
		                       data-parsley-pattern-message="<liferay-ui:message key="form-allegato-nome-non-valido-parsley"/> _ ." 
		                       data-parsley-maxlength="200" data-parsley-maxlength-message="<liferay-ui:message key="form-allegato-lunghezza-file-limite-caratteri-parsley"/>." 
		                       id="<portlet:namespace/>attachRealNamePlus" name="<portlet:namespace/>attachRealNamePlus" value="<%=attachFileRealName%>"/>  
		                       
		                       
		                       
		                <input type="text" style="display:none" 
		                       id="<portlet:namespace/>richiestaId" name="<portlet:namespace/>richiestaId" value="<%=richlavId%>"/> 
		                    
		                   <c:if test="<%=!flagDisableUpdateNuovoAllegatoOORange && (richiesta.getScreename()).equalsIgnoreCase(themeDisplay.getUser().getScreenName())%>">   
			                   <div class="ama-col-xs-12 text-center mt-20-sm mb-20-xs">    
							   		<button id="<portlet:namespace/>invioAllegatoPlus" 
							   				type="button" 
							   				onclick="salva()" 
							   				disabled="true" 
							   				<c:if test='<%=richiesta!=null && richiesta.getPdf() != null && !("").equals(richiesta.getPdf())%>' >style="display:none"</c:if>
							   				class="button button-primary">
							   					<liferay-ui:message key='recap-input-invia'/>
							   		</button>				
							   </div>
						   </c:if>
			</div>
			
			</form>
	
		</c:if>
    	
    	
		<div class="container-button-allegati">
			<c:if test="<%=richlavId == 0%>">
				<div class="ama-row">
					<div class="ama-col-sm-6">
						<form id="<portlet:namespace/>formModifica"
							data-parsley-validate="true" method="post"
							enctype="multipart/form-data" action="<%=vaiAModifica%>">
							<input name="<portlet:namespace/>jsonValues" type="hidden" value='<%=moduloRichiesta.toJSONOptions()%>' />
							<input name="<portlet:namespace/>Allegato" type="hidden" value='<%=moduloRichiesta.getAllegato().toString()%>' />
							<input name="<portlet:namespace/>AllegatoMimeType" type="hidden" value='<%=moduloRichiesta.getAllegatoMimeType()%>' />
							<input name="<portlet:namespace/>AllegatoRealeNome" type="hidden" value='<%=moduloRichiesta.getAllegatoNome()%>' />
							<input name="<portlet:namespace/>attachCustomName" type="hidden" value='<%=request.getAttribute("fileCustom")%>' />
							<input name="<portlet:namespace/>note" type="hidden" value='<%=HtmlUtil.escape(moduloRichiesta.getNote())%>' />
							<button type="reset" onclick="modifica()" class="button button-secondary"><liferay-ui:message key='recap-input-modifica'/></button>
						</form>
					</div>
					<div class="ama-col-sm-6">
						<form id="<portlet:namespace/>formInvia"
							data-parsley-validate="true" method="post"
							enctype="multipart/form-data" action="<%=invia%>">
							<input name="<portlet:namespace/>jsonValues" type="hidden" value='<%=moduloRichiesta.toJSONOptions()%>' />
							<input name="<portlet:namespace/>Allegato" type="hidden" value='<%=moduloRichiesta.getAllegato().toString()%>' />
							<input name="<portlet:namespace/>AllegatoMimeType" type="hidden" value='<%=moduloRichiesta.getAllegatoMimeType()%>' />
							<input name="<portlet:namespace/>AllegatoRealeNome" type="hidden" value='<%=moduloRichiesta.getAllegatoNome()%>' />
							<input name="<portlet:namespace/>attachCustomName" type="hidden" value='<%=request.getAttribute("fileCustom")%>' />
							<input name="<portlet:namespace/>note" type="hidden" value='<%=HtmlUtil.escape(moduloRichiesta.getNote())%>' />
							<button type="button" onclick="invia()" class="button button-primary"><liferay-ui:message key='recap-input-invia'/></button>
						</form>
					</div>
				</div>
			</c:if>
		</div>
	</div>



			
  </div>
    </c:otherwise>
</c:choose>
        
<script type="text/javascript">
var flagProsegui = true;
	function modifica() {
		$("#<portlet:namespace/>formModifica").submit();
	}
	function invia() {
		if( flagProsegui && $($("#<portlet:namespace/>formInvia")).parsley().isValid() ){
			flagProsegui = false;
			$("#<portlet:namespace/>formInvia").submit();
		}
		
		
	}
	function submitModulo() {
		$('#<portlet:namespace/>moduloForm').submit();
	}
	function submitModuloNuovoAllegato() {
		$('#<portlet:namespace/>moduloFormNuovoAllegato').submit();
	}
	$('#<portlet:namespace/>btnNuovaRichiesta').click("on", function() {
		$('#<portlet:namespace/>nuovaRichiestaForm').submit();
	});
	
	
	
	var idBtnSelezionaProgIndividuale = "#<portlet:namespace/>selezionaProgIndividualePlus";
	var idInputFileAttachProgIndividuale = "#<portlet:namespace/>fileAttachProgIndividualePlus";
	var idDivSummaryAttach = "#<portlet:namespace/>divSummaryAttachPlus";
	var idParagraphFileName = "#<portlet:namespace/>fileNamePlus";
	var idDivSelezionaFile = "#<portlet:namespace/>divSelezionaFilePlus";
	$(idBtnSelezionaProgIndividuale).on('click', function(event){
		$(idInputFileAttachProgIndividuale).click();
	});
	$(idInputFileAttachProgIndividuale).change(function() {
		
		var fileAttachValue = this.value;
		
		if (fileAttachValue!=null && fileAttachValue!="") {
			
			var index = fileAttachValue.lastIndexOf('\\');
			var fileAttachName = fileAttachValue.substring(index+1, fileAttachValue.length);
			$("#<portlet:namespace/>attachRealNamePlus").val(fileAttachName);
			
			$("#<portlet:namespace/>fileAttachProgIndividualePlus").parsley().validate();
			$("#<portlet:namespace/>attachRealNamePlus").parsley().validate();
			if($("#<portlet:namespace/>fileAttachProgIndividualePlus").parsley().isValid() &&
					$("#<portlet:namespace/>attachRealNamePlus").parsley().isValid()){ 

				var inputFile = document.getElementById('<portlet:namespace/>fileAttachProgIndividualePlus');
				var inputFileSize = inputFile.files[0].size / 1024;
				inputFileSize = (Math.round(inputFileSize ));
				fileAttachName = fileAttachName.concat(" (" + inputFileSize + " KB)");
			
				var tagAInsideText = "<a href='#' title='Elimina file' onclick='removeAttach()' class='icomoon-close-white ico-delete'></a>";
				var classPItem = "<p class='text'>" + fileAttachName + tagAInsideText + "</p>";
				$(idParagraphFileName).html(classPItem);
				
				$("#<portlet:namespace/>attachCustomName").val(fileAttachName);
				
				$(idDivSummaryAttach).css("display","block");
				$(idDivSelezionaFile).css("display","none");
			
				$("#<portlet:namespace/>fileAttachProgIndividualePlus").parsley().validate();		
				
				$('#<portlet:namespace/>invioAllegatoPlus').removeAttr("disabled");
				
			} else {
				$("#<portlet:namespace/>invioAllegatoPlus").attr("disabled", true);		
			}
		}
		
	});
	
	
	
	function removeAttach(){
		event.preventDefault();
		event.stopPropagation();
		$(idInputFileAttachProgIndividuale).val("");
		$("#<portlet:namespace/>attachCustomName").val("");
		$("#<portlet:namespace/>attachRealNamePlus").val("");
		$("#<portlet:namespace/>fileAttachProgIndividualePlus").attr("data-parsley-required", true);
		$("#<portlet:namespace/>fileAttachProgIndividualePlus").parsley().validate();
		$("#<portlet:namespace/>attachRealNamePlus").parsley().validate();
		$("#<portlet:namespace/>invioAllegatoPlus").attr("disabled", true);
		$(idDivSelezionaFile).css("display","block");
		$(idDivSummaryAttach).css("display","none");
		$("#<portlet:namespace/>invioAllegatoPlus").show();
	}
	
	
	function salva() {
		if( flagProsegui && $($("#<portlet:namespace/>nuovoAllegatoPlusForm")).parsley().isValid() ){
			flagProsegui = false;
			$("#<portlet:namespace/>nuovoAllegatoPlusForm").submit();
		}
		
		
	}
	
	
	
	
	
	
	
</script>