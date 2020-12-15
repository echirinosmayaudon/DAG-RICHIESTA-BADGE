<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.accenture.istanza.interpello.model.TextRich" %>
<%@ page import="com.accenture.istanza.interpello.service.TextRichLocalServiceUtil" %>
<%@ page import="com.accenture.mef.istanza.interpello.form.bean.Opzione" %>
<%@ page import="com.accenture.istanza.interpello.service.RichInterpelloLocalServiceUtil" %>
<%@ page import="com.accenture.istanza.interpello.model.RichInterpello" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="com.accenture.mef.istanza.interpello.form.bean.ModuloRichiesta" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>

<%
	Log _log = LogFactoryUtil.getLog("recap_jsp");

	String title = "Riepilogo";
	
	long richIstInterpelloId = 0L;
	if(ParamUtil.getLong(request, "richIstInterpelloId")!=0){
		richIstInterpelloId = ParamUtil.getLong(request, "richIstInterpelloId");
	} else if( request.getAttribute("richIstInterpelloId") != null ) {
		richIstInterpelloId = Long.parseLong(String.valueOf(request.getAttribute("richIstInterpelloId")));
	}
			
	ModuloRichiesta moduloRichiesta = null;
	if(request.getAttribute("moduloRichiesta")!=null) {
		moduloRichiesta = (ModuloRichiesta)request.getAttribute("moduloRichiesta");
	}
	
	// se la navigazione vale dettaglio ricaviamo dal db la richiesta mediante l'id in ingresso come parametro e settiamo gli oggetti necessari con i suoi valori
	else if (richIstInterpelloId != 0) {
		
		title = "Dettaglio";
		
		RichInterpello richiesta = RichInterpelloLocalServiceUtil.getRichInterpello(richIstInterpelloId);
		
		String richiedenteJson = richiesta.getJson_richiedente();
		JSONObject json_object_richiedente = JSONFactoryUtil.createJSONObject(richiedenteJson);
		String richiestaJson = richiesta.getJson_richiesta();
		JSONObject json_object_richiesta = JSONFactoryUtil.createJSONObject(richiestaJson);
		
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
		
		Opzione testoConfig = new Opzione();
		TextRich textRich = TextRichLocalServiceUtil.getTextRich(Long.parseLong(json_object_richiesta.getString("id_conseguenzecivilipenali")));
		if(textRich != null){
			testoConfig.setId(textRich.getId_text());
			testoConfig.setTestoOpzione(textRich.getTesto_text());
		}
		moduloRichiesta.setConseguenzeCiviliPenali(testoConfig);
		
		testoConfig = new Opzione();
		textRich = TextRichLocalServiceUtil.getTextRich(Long.parseLong(json_object_richiesta.getString("id_dichiarazione")));
		if(textRich != null){
			testoConfig.setId(textRich.getId_text());
			testoConfig.setTestoOpzione(textRich.getTesto_text());
		}
		moduloRichiesta.setDichiarazione(testoConfig); 
		
		testoConfig = new Opzione();
		textRich = TextRichLocalServiceUtil.getTextRich(Long.parseLong(json_object_richiesta.getString("id_requisiti")));
		if(textRich != null){
			testoConfig.setId(textRich.getId_text());
			testoConfig.setTestoOpzione(textRich.getTesto_text());
		}
		moduloRichiesta.setRequisiti(testoConfig);
		
		testoConfig = new Opzione();
		textRich = TextRichLocalServiceUtil.getTextRich(Long.parseLong(json_object_richiesta.getString("id_funzionidirigenziali")));
		if(textRich != null){
			testoConfig.setId(textRich.getId_text());
			testoConfig.setTestoOpzione(textRich.getTesto_text());
		}
		moduloRichiesta.setFunzioniDirigenziali(testoConfig);
		
	}
%>

<portlet:actionURL var="vaiAdAnnulla" name="vaiAdAnnulla"/> 
<portlet:actionURL var="invia" name="invia"/> 

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
     <div class="ama-container-fluid">
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small title-data-agile">
                     <h2 class="title-box borders"><%=title%> <liferay-ui:message key="interpello-recap-della-richiesta"/></h2>
                 </div>
             </div>
         </div>
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
                                      <span class="section-information"><liferay-ui:message key="interpello-luogo-nascita"/>:</span>
                                      <p class="info"><%=moduloRichiesta.getLuogoNascita()%></p>
                                  </div>
                                   <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key="interpello-data-nascita"/>:</span>
                                      <p class="info"><%=moduloRichiesta.getDataNascita()%></p>
                                  </div>
                                  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key="interpello-codice-fiscale"/>:</span>
                                      <p class="info"><%=moduloRichiesta.getCodiceFiscale().toUpperCase()%></p>
                                  </div>
                              </div>
                              <p class="name-section"><liferay-ui:message key="interpello-residenza-section"/></p>
                              <div class="ama-row border-section">
                                 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key="interpello-indirizzo"/>:</span>
                                      <p class="info"><%=moduloRichiesta.getResidenzaVia()%></p>
                                  </div>
                                  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                      <span class="section-information"><liferay-ui:message key="interpello-citta"/>:</span>
                                      <p class="info"><%=moduloRichiesta.getResidenzaCitta()%></p>
                                  </div>
                              </div>
                              <p class="name-section"><liferay-ui:message key="interpello-assegnazione-section"/></p>
							<div class="ama-row">
								 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key="interpello-dipartimento"/>:</span>
									<p class="info"><%=moduloRichiesta.getDipartimento()%></p>
								</div>
								<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key="interpello-direzione"/>:</span>
									<p class="info"><%=moduloRichiesta.getDirezione()%></p>
								</div>
								  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key="interpello-ufficio"/>:</span>
									<p class="info"><%=moduloRichiesta.getUfficio()%></p>
								</div>
							</div>
							 <div class="ama-row border-section mb-30-xs">
								  <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key="interpello-email"/>:</span>
									<p class="info"><%=moduloRichiesta.getEmail()%></p>
								</div>
								 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key="interpello-area"/>:</span>
									<p class="info"><%=moduloRichiesta.getAreaAppartenenza()%></p>
								</div>
								 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
									<span class="section-information"><liferay-ui:message key="interpello-fascia-retributiva"/>:</span>
									<p class="info"><%=moduloRichiesta.getFasciaRetributiva()%></p>
								</div>
							</div>
						</div>
                         <div class="mb-10-xs">
							<p class="section-information"><%=moduloRichiesta.getConseguenzeCiviliPenali().getTestoOpzione()%></p>
								<div class="text-center">
									<p class="section-information"><strong><liferay-ui:message key="interpello-dichiara"/></strong></p>
								</div>
							<p class="section-information"><%=moduloRichiesta.getDichiarazione().getTestoOpzione()%></p>
							</br>
							<%
							String[] requisitiList = moduloRichiesta.getRequisiti().getTestoOpzione().split(Pattern.quote("|"));
							%>
							<c:forEach items="<%=requisitiList%>" var="requisito">
						        	${requisito}</br>
						    </c:forEach>
							</br></br>
							<p class="mb-25-xs pl-10-xs pr-10-xs"><em><%=moduloRichiesta.getFunzioniDirigenziali().getTestoOpzione()%></em></p>
						</div> 	
                         </div>
                     </div>
                 </div>
             </div>
         </div>
	<div class="wrapper-allegati-general">
		<div class="container-button-allegati">
			<c:if test="<%=richIstInterpelloId == 0%>">
				<div class="ama-row">
					<div class="ama-col-sm-6">
						<form id="<portlet:namespace/>formAnnulla"
							  method="post"
							  enctype="multipart/form-data"
							  action="<%=vaiAdAnnulla%>">
							<button type="reset" onclick="annulla()" class="button button-secondary"><liferay-ui:message key="interpello-recap-btn-annulla"/></button>
						</form>
					</div>
					<div class="ama-col-sm-6">
						<form id="<portlet:namespace/>formInvia"
							  method="post"
							  enctype="multipart/form-data"
							  action="<%=invia%>">
							<input name="<portlet:namespace/>jsonValues" type="hidden" value='<%=moduloRichiesta.toJSONOptions()%>' />
							<button type="button" onclick="invia()" class="button button-primary"><liferay-ui:message key="interpello-recap-btn-invia"/></button>
						</form>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
        
<script type="text/javascript">

function annulla() {
	$("#<portlet:namespace/>formAnnulla").submit();
}

function invia() {
	$("#<portlet:namespace/>formInvia").submit();
}

</script>