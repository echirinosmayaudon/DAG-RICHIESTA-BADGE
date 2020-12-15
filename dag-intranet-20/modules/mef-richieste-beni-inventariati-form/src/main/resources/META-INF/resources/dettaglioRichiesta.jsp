<%@page import="service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil"%>
<%@page import="service.intranet.mef.service.TipoBeneInvLocalServiceUtil"%>
<%@page import="service.intranet.mef.service.BeneInvRichiestoLocalServiceUtil"%>
<%@page import="service.intranet.mef.service.StatoRichBeneInvLocalServiceUtil"%>
<%@page import="service.intranet.mef.model.RichiestaBeneInv"%>
<%@page import="service.intranet.mef.model.TipoBeneInv"%>
<%@page import="service.intranet.mef.model.BeneInvRichiesto"%>
<%@page import="service.intranet.mef.model.StatoRichBeneInv"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%
long id_richiesta =0;
if(request.getParameter("richiestaId")!=null){
	id_richiesta=Long.parseLong(request.getParameter("richiestaId"));
}
else if(request.getAttribute("richiestaId")!=null){
	id_richiesta=Long.parseLong((String)request.getAttribute("richiestaId"));
}
RichiestaBeneInv richiestaObjByEmail = RichiestaBeneInvLocalServiceUtil.getRichiestaBeneInv(id_richiesta);
String richiestaDateLabel = new SimpleDateFormat("dd.MM.yyyy").format(richiestaObjByEmail.getData());
String richiestaDateInfo = new SimpleDateFormat("dd/MM/yyyy").format(richiestaObjByEmail.getData());
JSONObject jsonObjRichiedente = JSONFactoryUtil.createJSONObject(richiestaObjByEmail.getDati_rich());
JSONObject jsonObjBeneficiario = JSONFactoryUtil.createJSONObject(richiestaObjByEmail.getBeneficiario());
List <BeneInvRichiesto> listBeniInElenco = BeneInvRichiestoLocalServiceUtil.getListBeniByIdRichiesta(id_richiesta, true);
List <BeneInvRichiesto> listBeniNonInElenco = BeneInvRichiestoLocalServiceUtil.getListBeniByIdRichiesta(id_richiesta, false);
%>

<portlet:actionURL var="cambiaStatoDettaglioURL" name="cambiaStatoDettaglio">
               <portlet:param name="idRichiesta" value="<%=String.valueOf(id_richiesta)%>"/>
</portlet:actionURL>

<portlet:actionURL var="duplicaRichiestaUrl" name="duplicaRichiesta">
               <portlet:param name="idRichiestaDuplica" value="<%=String.valueOf(id_richiesta)%>"/>
</portlet:actionURL>

<portlet:actionURL var="vaiANuovaRichiestaUrl" name="vaiANuovaRichiesta"/>
<portlet:actionURL var="vaiARicercaUrl" name="vaiARicerca"/>

<div class="trasporti-header">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper pl-0-xs">
                        <h2 class="title-beni"><%=richiestaObjByEmail.getOggetto().toUpperCase()%></h2>
                            <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
                                <c:if test="<%=(request.getAttribute("richiedenteRole") != null && ((Boolean) request.getAttribute("richiedenteRole") == true))%>">
                                <form action="<%=vaiANuovaRichiestaUrl%>" method="post" class="">
                                <a href="<%=vaiANuovaRichiestaUrl%>">
                                <button href="#" type="button" class="button button-servizi-logistici button-primary mr-10-xs">NUOVA RICHIESTA
                                    <span class="icomoon-plus icon-beni"></span>
                                </button>
                                </a>
                                </form>
                                <form action="<%=duplicaRichiestaUrl%>" method="post" class="wrapper-icon-title-form" enctype="multipart/form-data">
                                <a href="<%=duplicaRichiestaUrl%>" title="duplica" class=" mt-0-sm icon icomoon-add-documents mr-10-xs"></a>
                                </form>
                                </c:if>
                                <a href="javascript:window.print()" title="stampa" class="icon icomoon-print"></a>
                                <form action="<%=vaiARicercaUrl%>" method="post" class="wrapper-icon-title-form">
                                 <a href="<%=vaiARicercaUrl%>" title="Ricerca" class="icon icomoon-search-richiesta"></a>
                              </form>
                            </div>
    
                    </div>
                    <div class="mt-50-xs display-responsive">
                        <p class="text-icon"><span class="mr-10-xs icomoon-calendar-date icon-beni"></span><%=richiestaDateLabel%></p>
                    </div>
                    
                            <c:if test="<%=request.getAttribute("consegnatarioRole") != null && ((Boolean) request.getAttribute("consegnatarioRole") == false)%>">
                               <div class="wrap-button-type">
                                   <div class="box-white-beni box-white-beni-inventariati mt-60-xs">
                                      <p class="text"><span class="file icomoon-add-documents"></span><%=StatoRichBeneInvLocalServiceUtil.getStatoRichBeneInv(richiestaObjByEmail.getId_stato()).getStato().toUpperCase()%></p>
                               </div>
                            </div>
                            </c:if>
                            <c:if test="<%=request.getAttribute("consegnatarioRole") != null && ((Boolean) request.getAttribute("consegnatarioRole") == true)%>">
                            		<div class="display-responsive">
                        <div class="select-servizi">
                            <div class="box-white-beni back-image pr-100-md pl-20-md mt-30-xs mt-60-md ">
                                <p id="selectedStatus" class="current-selected text text-servizi">
                                    <span class="current-icon file icomoon-file mr-0-xs" ></span>
                                    <%=StatoRichBeneInvLocalServiceUtil.getStatoRichBeneInv(richiestaObjByEmail.getId_stato()).getStato().toUpperCase()%>
                                </p>
                            </div>
                            
                            
                            <%
                            List<String> statiDisponibili = new ArrayList<String>();
                            String statoCorrente = StatoRichBeneInvLocalServiceUtil.getStatoRichBeneInv(richiestaObjByEmail.getId_stato()).getStato();
                            if (statoCorrente.equalsIgnoreCase("nuova")) {
                            	statiDisponibili.add("ACCETTATA");
                            	statiDisponibili.add("RIFIUTATA");
                            }
                            if (statoCorrente.equalsIgnoreCase("accettata")) {
                            	statiDisponibili.add("EVASA");
                            	statiDisponibili.add("NON EVASA");
                            	statiDisponibili.add("ACQUISTO RICHIESTO");
                            }
                            if (statoCorrente.equalsIgnoreCase("acquisto autorizzato")) {
                            	statiDisponibili.add("EVASA");
                            	statiDisponibili.add("NON EVASA");
                            }
                            if (statoCorrente.equalsIgnoreCase("acquisto respinto")) {
                            	statiDisponibili.add("NON EVASA");
                            }
                            if (statoCorrente.equalsIgnoreCase("evasa")) {
                            	statiDisponibili.add("CONSEGNATA");
                            }
                            %>
                            <c:if test="<%=statiDisponibili.size()>0%>">
                            <div id="select" class="select-content animated fadeIn">
                               <c:forEach items="<%=statiDisponibili%>" var="statoDisponibile">
                               <%
                               String statoDisponibile =(String) pageContext.getAttribute("statoDisponibile");
                               %>
                                <c:if test="<%=statoDisponibile.equalsIgnoreCase("ACCETTATA") %>">
                                <a href="#" class="element-select cart"  data-name="ACCETTATA" data-icon-image="icomoon-success-blu">
                                    <span class="cart icomoon-success-blu"></span><%=statoDisponibile.toUpperCase()%></a>
                                </c:if>
                                <c:if test="<%=statoDisponibile.equalsIgnoreCase("RIFIUTATA")%>">
                                <a href="#" class="element-select" data-name="RIFIUTATA" data-icon-image="icomoon-cancel">
                                    <span class="cart icomoon-cancel"></span><%=statoDisponibile.toUpperCase()%></a>
                                 </c:if>
                                <c:if test="<%=statoDisponibile.equalsIgnoreCase("ACQUISTO RICHIESTO")%>">
                                <a href="#" class="element-select " data-name="ACQUISTO RICHIESTO" data-icon-image="icomoon-question2">
                                    <span class="cart icomoon-question2"></span><%=statoDisponibile.toUpperCase()%></a>
                                 </c:if>
                                <c:if test="<%=statoDisponibile.equalsIgnoreCase("EVASA")%>">
                                <a href="#" class="element-select " data-name="EVASA" data-icon-image="icomoon-cart">
                                    <span class="cart icomoon-cart"></span><%=statoDisponibile.toUpperCase()%>                          </a>
                                 </c:if>
                                <c:if test="<%=statoDisponibile.equalsIgnoreCase("CONSEGNATA")%>">
                                <a href="#" class="element-select " data-name="CONSEGNATA" data-icon-image="icomoon-cart-3">
                                    <span class="cart icomoon-cart-3"></span><%=statoDisponibile.toUpperCase()%></a>
                                 </c:if>
                                <c:if test="<%=statoDisponibile.equalsIgnoreCase("NON EVASA")%>">
                                <a href="#" class="element-select " data-name="NON EVASA" data-icon-image="icomoon-cart-2">
                                    <span class="cart icomoon-cart-2"></span>
                                    <%=statoDisponibile.toUpperCase()%>
                                </a>
                                 </c:if>
                                <c:if test="<%=statoDisponibile.equalsIgnoreCase("NUOVA")%>">
                                <a href="#" class="element-select hidden" data-name="NUOVA" data-icon-image="icomoon-file">
                                    <span class="cart icomoon-file"></span><%=statoDisponibile.toUpperCase()%></a>
                                 </c:if>
                                </c:forEach>
                            </div>
                            <input type="text" style="display:none" name="<portlet:namespace/>cambioStato" id="<portlet:namespace/>cambioStato"
                            	class="data-parsley-validated" 
                            	data-parsley-required="true"
                                data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                            />
                            </c:if>
                        </div>
                    </div>
                            </c:if>
                     
                </div>
            </div>
        </div>
    </div>
    <form action="<%=cambiaStatoDettaglioURL%>" method="POST" id="saveForm" data-parsley-validate="true" enctype="multipart/form-data">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="beni-inv-dettaglio-riepilogo"/></h2>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                    <div class="ama-col-xs-12 mobile-no-padding">
                        <div class="wrapper-istanza-trasporti mobile-no-padding">
                        <div class="box-gray">
                            <div class=" box-white pb-0-xs">
                                <p class="name"><%=richiestaObjByEmail.getNome_rich().toUpperCase()%> <%=richiestaObjByEmail.getCogn_rich().toUpperCase()%></p>
                                <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
            
                                <div id="collapse-trasporti" class="collapse1 in no-overflow">
                                    <div class="ama-row border-section border-mobile">
                                        <div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-dettaglio-ufficio-richiedente"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("ufficioRichiedente").toUpperCase()%></p>
                                        </div>
                                    </div>
            
                                    <div class="ama-row">
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="beni-inv-dettaglio-ubicazione"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("ubicazione").toUpperCase()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-sm"><liferay-ui:message key="beni-inv-dettaglio-palazzina"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("palazzina").toUpperCase()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="beni-inv-dettaglio-piano"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("piano").toUpperCase()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="beni-inv-dettaglio-scala"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("scala").toUpperCase()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-dettaglio-stanza"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("stanza").toUpperCase()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-dettaglio-telefono"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("telefono").toUpperCase()%></p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-email-dirigente"/>:</span>
                                            <p class="info"><%=jsonObjRichiedente.getString("emailDirigente")%></p>
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
                    <div class="wrapper-beni-inventariati">
                        <div class="no-overflow">
                            <div class="box-gray padding-mobile-servizi">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-3 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-dettaglio-richiesta"/></span>
                                            <p class="info"><%=richiestaObjByEmail.getPrimaryKey()%></p>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-xs-12 mt-20-xs mt-0-sm">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-richiesta-oggetto"/></span>
                                            <p class="info"><%=richiestaObjByEmail.getOggetto().toUpperCase()%></p>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-xs-12 mt-20-xs mt-0-sm">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-dati-richiesta"/></span>
                                            <p class="info"><%=richiestaDateInfo%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
            
                        <div class="no-overflow">
                            <div class="box-gray padding-mobile-servizi">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-3 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-beneficiario"/>:</span>
                                                <p class="information"><%=jsonObjBeneficiario.getString("nomeBenef").toUpperCase()%> <%=jsonObjBeneficiario.getString("cognomeBenef").toUpperCase()%></p>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-dettaglio-email"/>:</span>
                                                <p class="information"><%=jsonObjBeneficiario.getString("emailBenef")%></p>
                                        </div>
                                        <div class="ama-col-md-6 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-destinazione-dettaglio"/>:</span>
                                                <p class="information"><%=richiestaObjByEmail.getDestinazione().toUpperCase()%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
            
                        <c:if test="<%=listBeniInElenco.size()>0%>">
                        <%
                        int countBeneInElenco = 0;
                        %>
                        <p class="title-form mt-20-xs ml-20-xs ml-0-sm mb-10-xs mb-0-sm"><liferay-ui:message key="beni-inv-dettaglio-richiesti"/></p>
                        <c:forEach items="<%=listBeniInElenco%>" var="beneInElenco">
                        <%
                        countBeneInElenco++;
                        %>
                        <div class="no-overflow">
                            <div class="box-gray padding-mobile-servizi">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width"><%=countBeneInElenco%>.</span>
                                        </div>
                                        <div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width">${beneInElenco.getTipologia().toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width">${beneInElenco.getQuantita()}</span>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width">${beneInElenco.getDescrizione().toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-5 ama-col-sm-12 ama-col-xs-12 mt-10-xs mt-0-md">
                                            <span class="section-information width">${beneInElenco.getDettagli()}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                        </c:if>
            
                        <c:if test="<%=listBeniNonInElenco.size()>0%>">
                        <p class="title-form mt-20-xs ml-20-xs ml-0-sm mb-10-xs mb-0-sm"><liferay-ui:message key="beni-inv-non-elenco"/></p>
                        <div class="no-overflow">
                            <div class="box-gray padding-mobile-servizi">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width">1.</span>
                                        </div>
                                        <div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width"><%=listBeniNonInElenco.get(0).getTipologia().toUpperCase()%></span>
                                        </div>
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width"><%=listBeniNonInElenco.get(0).getQuantita()%></span>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width"><%=listBeniNonInElenco.get(0).getDescrizione().toUpperCase()%></span>
                                        </div>
                                        <div class="ama-col-md-5 ama-col-sm-12 ama-col-xs-12 mt-10-xs mt-0-md">
                                            <span class="section-information width"><%=listBeniNonInElenco.get(0).getDettagli()%></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:if>
                    </div>
                </div>
            </div>
            
            <c:if test="<%=request.getAttribute("consegnatarioRole") != null && ((Boolean) request.getAttribute("consegnatarioRole") == false)%>">
            <c:if test="<%=richiestaObjByEmail.getNote_consegn()!=null && !(richiestaObjByEmail.getNote_consegn().toString()).equals("") %>">
			<%
	 			String[] arraySplitTextOld=richiestaObjByEmail.getNote_consegn().split("\r\n");
	            StringBuilder noteConsegnatario = new StringBuilder();
	            
	            for(int j=0; j<arraySplitTextOld.length; j++){
	            	noteConsegnatario.append(arraySplitTextOld[j]);
	            	noteConsegnatario.append("<br>");
	            } 
			%>           
            <div class="wrapper-beni-inventariati">
                <p class="title-form mt-20-xs mb-5-xs"><liferay-ui:message key="beni-inv-note-consegnatario-dettaglio"/>:</p>
                <p class="mb-40-xs"><%=noteConsegnatario.toString()%></p>
            </div>
            </c:if>
             </c:if>
          
             <c:if test="<%=request.getAttribute("consegnatarioRole") != null && ((Boolean) request.getAttribute("consegnatarioRole") == true)%>">
               <div class="wrapper-beni-inventariati wrapper-content-textarea">
                <p class="title-form mt-20-xs mb-5-xs"><liferay-ui:message key="beni-inv-note-consegnatario-dettaglio"/>:</p>
                
                    <div class="ama-row">
                        <div class="ama-col-md-12 ama-col-xs-12">
                            <div class="wrapper-content-textarea">
                                <textarea class="form-control textarea-custom-light" id="textarea-detail" name="<portlet:namespace/>CommentiConsegnatario" placeholder="<liferay-ui:message key="placeholder-aggiunta-descrizione-dettaglio" />"	><%=richiestaObjByEmail.getNote_consegn()%></textarea>
                                <div class="content-textarea"><%=richiestaObjByEmail.getNote_consegn()!=null ? richiestaObjByEmail.getNote_consegn().length(): 0%>/
                                    <p class="color-gray">500</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="inputSelectedStatus" name="<portlet:namespace/>inputSelectedStatus" >
               
                </div>
                </c:if>
            
            <c:if test="<%=request.getAttribute("consegnatarioRole") != null && ((Boolean) request.getAttribute("consegnatarioRole") == true)%>">
             <div class="ama-row">
                <div class="ama-col-md-6 ama-col-xs-12 text-center mb-100-md mb-30-sm mt-30-sm mt-50-md mt-20-xs">
                    <button type="button" class="button button-secondary" onclick="resetform();"><liferay-ui:message key="beni-inv-button-annulla"/></button>
                </div>
                <div class="ama-col-md-6 ama-col-xs-12 text-center mb-100-md mb-30-xs mt-30-sm mt-50-md mt-20-xs">
                    <button type="button" class="button button-primary" onclick="subForm()"><liferay-ui:message key="beni-inv-button-procedi"/></button>
                </div>
            </div>
            </c:if>
            
            <c:if test="<%=request.getAttribute("responsabileCDCRole") != null && ((Boolean) request.getAttribute("responsabileCDCRole") == true) && (StatoRichBeneInvLocalServiceUtil.getStatoRichBeneInv(richiestaObjByEmail.getId_stato()).getStato().equalsIgnoreCase("acquisto richiesto"))%>">
            <div class="ama-row">
                <div class="ama-col-xs-12 ama-col-md-6 text-center mb-100-md mt-50-md">
                    <button id="acquisto respinto" class="button button-secondary" onclick="valInputCDC(this.id)"><liferay-ui:message key="beni-inv-button-rifiuta"/></button>
                </div>
                <div class="ama-col-xs-12 ama-col-md-6 text-center mb-100-md mb-30-xs mt-50-md">
                    <button id="acquisto autorizzato" class="button button-primary" onclick="valInputCDC(this.id)"><liferay-ui:message key="beni-inv-button-approva"/></button>
                </div>
                <input type="hidden" id="inputStatusCDC" name="<portlet:namespace/>inputStatusCDC" >
            </div>
            </c:if>
            
        </div>
</form>

<script>

var currentState='<%=StatoRichBeneInvLocalServiceUtil.getStatoRichBeneInv(richiestaObjByEmail.getId_stato()).getStato()%>';

function subForm() {

	var statoSelezionato = $("#selectedStatus").text();	
	if(currentState.toLowerCase().trim()!=statoSelezionato.toLowerCase().trim()){			
		$('#<portlet:namespace/>cambioStato').val("stato modificato");
	}	
	$('#saveForm').parsley().validate();
	if($('#saveForm').parsley().isValid()){	
		$("#inputSelectedStatus").val(statoSelezionato);
		$('#saveForm').submit();		
	}		
}

function valInputCDC(id) {
	$("#inputStatusCDC").val(id);	
}

function resetform() {
	$("#textarea-detail").val("");
}


</script>