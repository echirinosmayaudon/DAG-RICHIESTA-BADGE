<%@page import="java.util.List"%><%@page import="java.util.ArrayList"%>
<%@page import="com.mef.intranet.bean.DatiRichiestaBean"%>
<%@page import="com.mef.intranet.bean.Richiedente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalServiceUtil"%>
<%@page import="servizio.beni.facile.consumo.model.CambioStatoDirigente"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%String idRichiesta = null;String stato = null; if (request.getAttribute("idRichiesta")!=null) {idRichiesta = (String) request.getAttribute("idRichiesta");} if (request.getAttribute("stato")!=null) {stato = (String) request.getAttribute("stato"); }
List<DatiRichiestaBean>listBeniStandard = (List<DatiRichiestaBean>) request.getAttribute("listBeniStandard"); List<DatiRichiestaBean>listBeniInformatica = (List<DatiRichiestaBean>) request.getAttribute("listBeniInformatica");
DatiRichiestaBean datiDettaglioRichiestaBean = (DatiRichiestaBean) request.getAttribute("datiDettaglioRichiestaBean");
DatiRichiestaBean datiDellaRichiesta = (DatiRichiestaBean) request.getAttribute("datiDellaRichiesta"); Richiedente datiDettaglioRichiedenteBean = (Richiedente) request.getAttribute("datiDettaglioRichiedenteBean");
List<DatiRichiestaBean> beniStandardListDettaglio = (List<DatiRichiestaBean>) request.getAttribute("beniStandardListDettaglio"); List<DatiRichiestaBean> beniInformaticiListDettaglio = (List<DatiRichiestaBean>) request.getAttribute("beniInformaticiListDettaglio");
int counter = 0; String nomeDip = (String) request.getAttribute("dipartimentoUtente"); boolean approvazioneFlag = (nomeDip.equalsIgnoreCase("DIP. II - RGS") && approvazioneRGS.equalsIgnoreCase("NO")) ||(nomeDip.equalsIgnoreCase("DIP. I - TESORO") && approvazioneDT.equalsIgnoreCase("NO")) ||(nomeDip.equalsIgnoreCase("DIP. III - DIPARTIMENTO DELLE FINANZE") && approvazioneDF.equalsIgnoreCase("NO")) ||(nomeDip.equalsIgnoreCase("DIP. IV - AMM. GEN. PERSONALE") && approvazioneDAG.equalsIgnoreCase("NO"));%>
<c:set var="datiDellaRichiesta" value="<%=datiDellaRichiesta%>"></c:set>
<c:set var="listBeniStandard" value="<%=listBeniStandard%>"></c:set>
<c:set var="listBeniInformatica" value="<%=listBeniInformatica%>"></c:set>
<c:set var="datiDettaglioRichiestaBean" value="<%=datiDettaglioRichiestaBean%>"></c:set>
<c:set var="datiDettaglioRichiedenteBean" value="<%=datiDettaglioRichiedenteBean%>"></c:set>
<c:set var="beniStandardListDettaglio" value="<%=beniStandardListDettaglio%>"></c:set>
<c:set var="beniInformaticiListDettaglio" value="<%=beniInformaticiListDettaglio%>"></c:set>
<c:set var="idRichiesta" value="<%=idRichiesta%>"></c:set>
<portlet:actionURL name="insertRichiesta" var="insertRichiestaURL"></portlet:actionURL>
<portlet:actionURL name="modificaRichiesta" var="modificaRichiestaURL"></portlet:actionURL>
<portlet:actionURL name="vaiModificaRichiesta" var="vaiModificaRichiestaURL"></portlet:actionURL>
<portlet:actionURL name="approvaRifiutaRichiesta" var="approvaRifiutaRichiestaURL"></portlet:actionURL>
<portlet:actionURL name="setNoteConsegnatario" var="setNoteConsegnatarioURL"></portlet:actionURL>
<portlet:actionURL name="modificaRichiestaDirigente" var="modificaRichiestaDirigenteUrl"></portlet:actionURL>
<div class="trasporti-header"><div class="ama-container-fluid"><div class="ama-row"><div class="ama-col-xs-12">
            <c:choose>
            <c:when test="${dettaglio!=null}">
            			<div class="title-wrapper pl-0-xs">
                    		<h2 class="title-beni">${datiDettaglioRichiestaBean.getOggetto().toUpperCase()}</h2>
                        		<div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
                            		<form action="<%=vaiAInserimento%>" method="post" enctype="multipart/form-data" >
                                 <button href="<%=vaiAInserimento%>" type="button" class="button-xs button button-primary mr-10-xs" onclick="this.form.submit()"><liferay-ui:message key="beni-facile-consumo-nuova-richiesta"/><span class="icomoon-plus icon-beni"></span></button>
                             </form>
                             	<c:if test="${dirigenteRole}">
                                	<a href="<%=vaiAGestioneUtenti%>" title="search" class="icon icomoon-profile"></a>
                             	</c:if>
                             	<a href="<%=getListaRichieste%>" title="<liferay-ui:message key="beni-facile-consumo-lista-richieste-tooltip"/>" class="icon icomoon-user2"></a>
                               	<c:if test="${delegatoRole || dirigenteRole}">
                                  	<a href="<%=vaiARicerca%>" title="<liferay-ui:message key="beni-facile-consumo-ricerca-tooltip"/>" class="icon icomoon-search-richiesta "></a>
                                </c:if>
                            	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'evasa'}">
                            	    <a href="javascript:window.print()" title="profile" class=" mt-0-sm icon icomoon-print"></a>
                            	</c:if>
                        </div>
                        <div class="mt-50-xs display-responsive">
                    		<p class="text-icon"><span class="mr-10-xs icomoon-calendar-date icon-beni"></span><fmt:formatDate pattern = "dd/MM/yyyy"  value ="${dataRichiesta}"/></p><p class="text-icon"><span class="mr-10-xs icomoon-time icon-beni"></span><fmt:formatDate type="time" pattern = "HH:mm"  value ="${dataRichiesta}"/></p>
                		</div>
                		<div class="wrap-button-type">
                    		<a href="#" title="file" class="box-white-beni mt-50-md mt-30-sm mt-30-xs">
                        	<p class="text">
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'nuova'}"><span class="file icomoon-file"></span></c:if>
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'accettata'}"><span class="file icomoon-success-blu"></span></c:if>
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'rifiutata'}"><span class="file icomoon-cancel"></span></c:if>
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'evasa'}"><span class="file icomoon-cart"></span></c:if>
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'non evasa'}"><span class="file icomoon-cart-2"></span></c:if>
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'consegnata'}"><span class="file icomoon-cart-3"></span></c:if>
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'in approvazione'}"><span class="file icomoon-in-approvazione"></span></c:if>
                        	<c:if test="${datiDettaglioRichiestaBean.getStato() == 'non approvata'}"><span class="file icomoon-non-approvata"></span></c:if>${datiDettaglioRichiestaBean.getStato().toUpperCase()}</p></a></div></div>
					</c:when>
					<c:otherwise>
                <div class="title-wrapper"><h2 class="title"><%=riepilogoTitle%></h2><p class="subtitle dot-point dot-200"><%=riepilogoSubtitle%></p></div>
                </c:otherwise>
            </c:choose>
            </div></div></div></div>
<div class="ama-container-fluid"><c:if test="${datiDettaglioRichiestaBean.getStato() == 'nuova'}"><c:if test="<%=!approvazioneFlag && !CambioStatoDirigenteLocalServiceUtil.getCambioStatoDirigenteByIdRichiesta(Long.parseLong(idRichiesta)).isEmpty()%>"><div class="wrapper-beni-consumo mt-20-md">
                <div class="ama-row"><div class="ama-col-md-12"><div class="box-gray-beni ">
                            <p class="text-app"><liferay-ui:message key="beni-facile-consumo-esito-dirigente"/>
                            <span class="text-bold"><liferay-ui:message key="richiesta-beni-facili-consumo-riepilogo-approvata"/> </span> <liferay-ui:message key="beni-facile-consumo-da"/> <span class="text-bold"> <%=CambioStatoDirigenteLocalServiceUtil.getCambioStatoDirigenteByIdRichiesta(Long.parseLong(idRichiesta)).get(0).getUtente().toUpperCase()%>.</span>
                            </p>
                            <div class="wrapper-beni-app mt-10-sm">
                                <p class="text-icon"><span class="mr-10-xs icomoon-calendar-date icon-beni"></span><fmt:formatDate pattern = "dd/MM/yyyy"  value = "<%=CambioStatoDirigenteLocalServiceUtil.getCambioStatoDirigenteByIdRichiesta(Long.parseLong(idRichiesta)).get(0).getData()%>" /></p>
                                <p class="text-icon"><span class="mr-10-xs ml-20-xs icomoon-time icon-beni"></span><fmt:formatDate type = "time" pattern = "HH:mm" value = "<%=CambioStatoDirigenteLocalServiceUtil.getCambioStatoDirigenteByIdRichiesta(Long.parseLong(idRichiesta)).get(0).getData()%>"/></p>
                            </div></div></div></div></div></c:if></c:if>
<c:if test="${datiDettaglioRichiestaBean.getStato() == 'non approvata'}"><c:if test="<%=!approvazioneFlag%>"><div class="wrapper-beni-consumo mt-20-md"><div class="ama-row"><div class="ama-col-md-12"><div class="box-gray-beni ">
                            <p class="text-app"><liferay-ui:message key="beni-facile-consumo-esito-dirigente"/>
                            <span class="text-bold">${datiDettaglioRichiestaBean.getStato().toUpperCase()} </span> <liferay-ui:message key="beni-facile-consumo-da"/> <span class="text-bold"> <%=CambioStatoDirigenteLocalServiceUtil.getCambioStatoDirigenteByIdRichiesta(Long.parseLong(idRichiesta)).get(0).getUtente().toUpperCase()%>.</span>
                            </p>
                            <div class="wrapper-beni-app mt-10-sm">
                                <p class="text-icon"><span class="mr-10-xs icomoon-calendar-date icon-beni"></span><fmt:formatDate pattern = "dd/MM/yyyy"  value = "<%=CambioStatoDirigenteLocalServiceUtil.getCambioStatoDirigenteByIdRichiesta(Long.parseLong(idRichiesta)).get(0).getData()%>"/></p>
                                <p class="text-icon"><span class="mr-10-xs ml-20-xs icomoon-time icon-beni"></span><fmt:formatDate type = "time"  pattern = "HH:mm" value = "<%=CambioStatoDirigenteLocalServiceUtil.getCambioStatoDirigenteByIdRichiesta(Long.parseLong(idRichiesta)).get(0).getData()%>"/></p>
                            </div></div></div></div></div>
            </c:if></c:if>
            <div class="ama-row"><div class="ama-col-md-12">
                    <div class="wrapper-title-small"><h2 class="title-box borders"><liferay-ui:message key="label-richiesta-beni-facili-consumo-riepilogo"/></h2></div></div> </div>
            <div class="ama-row">
               <form action="<%=insertRichiestaURL%>" method="post" enctype="multipart/form-data"  id="<portlet:namespace/>formInvia">
                   <input type="hidden" id="listjson" name="<portlet:namespace/>json" value="" />
                   <input type="hidden" name="<portlet:namespace/>nome" value="${nome}" />
                   <input type="hidden" name="<portlet:namespace/>cognome" value="${cognome}" />
                   <input type="hidden" name="<portlet:namespace/>ufficioRichiedente" value="${ufficioRichiedente}" />
                   <input type="hidden" name="<portlet:namespace/>organizzazione" value="${datiDellaRichiesta.getOrganizzazione()}" />
                   <input type="hidden" name="<portlet:namespace/>sede" value="${datiDellaRichiesta.getSede()}" />
                   <input type="hidden" name="<portlet:namespace/>sedeDescrizione" value="${datiDellaRichiesta.getSedeDescrizione()}" />
                   <input type="hidden" name="<portlet:namespace/>ubicazione" value="${ubicazione}" />
                   <input type="hidden" name="<portlet:namespace/>palazzina" value="${palazzina}" />
                   <input type="hidden" name="<portlet:namespace/>piano" value="${piano}" />
                   <input type="hidden" name="<portlet:namespace/>scala" value="${scala}" />
                   <input type="hidden" name="<portlet:namespace/>stanza" value="${stanza}" />
                   <input type="hidden" name="<portlet:namespace/>telefono" value="${telefono}" />
                   <input type="hidden" name="<portlet:namespace/>emailRichiedente" value="${emailRichiedente}" />
                   <input type="hidden" name="<portlet:namespace/>emailDirigente" value="${emailDirigente}" />
                   <input type="hidden" name="<portlet:namespace/>oggetto" value="${datiDellaRichiesta.getOggetto()}" />
                   <input type="hidden" name="<portlet:namespace/>datarichiesta" value="${datiDellaRichiesta.getDataRichiesta()}" />
                   <input type="hidden" name="<portlet:namespace/>periodicita" value="${datiDellaRichiesta.getPeriodicita()}" />
                   <input type="hidden" name="<portlet:namespace/>numeroInventarioMacchina" value="${datiDellaRichiesta.getNumeroInventarioMacchina()}" />
                   <input type="hidden" name="<portlet:namespace/>note" value="${datiDellaRichiesta.getDescrizione()}" />
                 </form>
                 <form action="<%=modificaRichiestaDirigenteUrl%>" method="post" enctype="multipart/form-data"  id="<portlet:namespace/>modificaRichiestaDirigente">
                   <input type="hidden" id="listjsonModificaDirigente" name="<portlet:namespace/>json" value="" />
                   <input type="hidden" id="idRichiesta" name="<portlet:namespace/>idRichiesta" value="${idRichiesta}" />
                   <input type="hidden" name="<portlet:namespace/>nome" value="${nome}" />
                    <input type="hidden" name="<portlet:namespace/>stato" value="${stato}" />
                   <input type="hidden" name="<portlet:namespace/>cognome" value="${cognome}" />
                   <input type="hidden" name="<portlet:namespace/>ufficioRichiedente" value="${ufficioRichiedente}" />
                   <input type="hidden" name="<portlet:namespace/>organizzazione" value="${datiDellaRichiesta.getOrganizzazione()}" />
                   <input type="hidden" name="<portlet:namespace/>sede" value="${datiDellaRichiesta.getSede()}" />
                   <input type="hidden" name="<portlet:namespace/>sedeDescrizione" value="${datiDellaRichiesta.getSedeDescrizione()}" />
                   <input type="hidden" name="<portlet:namespace/>ubicazione" value="${ubicazione}" />
                   <input type="hidden" name="<portlet:namespace/>palazzina" value="${palazzina}" />
                   <input type="hidden" name="<portlet:namespace/>piano" value="${piano}" />
                   <input type="hidden" name="<portlet:namespace/>scala" value="${scala}" />
                   <input type="hidden" name="<portlet:namespace/>stanza" value="${stanza}" />
                   <input type="hidden" name="<portlet:namespace/>telefono" value="${telefono}" />
                   <input type="hidden" name="<portlet:namespace/>emailRichiedente" value="${emailRichiedente}" />
                   <input type="hidden" name="<portlet:namespace/>emailDirigente" value="${emailDirigente}" />
                   <input type="hidden" name="<portlet:namespace/>oggetto" value="${datiDellaRichiesta.getOggetto()}" />
                   <input type="hidden" name="<portlet:namespace/>datarichiesta" value="${datiDellaRichiesta.getDataRichiesta()}" />
                   <input type="hidden" name="<portlet:namespace/>periodicita" value="${datiDellaRichiesta.getPeriodicita()}" />
                   <input type="hidden" name="<portlet:namespace/>numeroInventarioMacchina" value="${datiDellaRichiesta.getNumeroInventarioMacchina()}" />
                   <input type="hidden" name="<portlet:namespace/>note" value="${datiDellaRichiesta.getDescrizione()}" />
                 </form>
                 <form action="<%=modificaRichiestaURL%>" enctype="multipart/form-data"  method="post" id="<portlet:namespace/>formModifica">
                   <input type="hidden" id="listjsonModifica" name="<portlet:namespace/>json" value="" />
                   <input type="hidden" name="<portlet:namespace/>nome" value="${nome}" />
                   <input type="hidden" name="<portlet:namespace/>stato" value="${stato}" />
                   <input type="hidden" name="<portlet:namespace/>cognome" value="${cognome}" />
                   <input type="hidden" name="<portlet:namespace/>ufficioRichiedente" value="${ufficioRichiedente}" />
                   <input type="hidden" name="<portlet:namespace/>organizzazione" value="${datiDellaRichiesta.getOrganizzazione()}" />
                   <input type="hidden" name="<portlet:namespace/>sede" value="${datiDellaRichiesta.getSede()}" />
                   <input type="hidden" name="<portlet:namespace/>sedeDescrizione" value=" ${datiDellaRichiesta.getSedeDescrizione()}" />
                   <input type="hidden" name="<portlet:namespace/>ubicazione" value="${ubicazione}" />
                   <input type="hidden" name="<portlet:namespace/>palazzina" value="${palazzina}" />
                   <input type="hidden" name="<portlet:namespace/>piano" value="${piano}" />
                   <input type="hidden" name="<portlet:namespace/>scala" value="${scala}" />
                   <input type="hidden" name="<portlet:namespace/>stanza" value="${stanza}" />
                   <input type="hidden" name="<portlet:namespace/>telefono" value="${telefono}" />
                   <input type="hidden" name="<portlet:namespace/>emailRichiedente" value="${emailRichiedente}" />
                   <input type="hidden" name="<portlet:namespace/>emailDirigente" value="${emailDirigente}" />
                   <input type="hidden" name="<portlet:namespace/>oggetto" value="${datiDellaRichiesta.getOggetto()}" />
                   <input type="hidden" name="<portlet:namespace/>datarichiesta" value="${datiDellaRichiesta.getDataRichiesta()}" />
                   <input type="hidden" name="<portlet:namespace/>periodicita" value="${datiDellaRichiesta.getPeriodicita()}" />
                   <input type="hidden" name="<portlet:namespace/>numeroInventarioMacchina" value="${datiDellaRichiesta.getNumeroInventarioMacchina()}" />
                   <input type="hidden" name="<portlet:namespace/>note" value="${datiDellaRichiesta.getDescrizione()}" />
                   <input type="hidden" name="<portlet:namespace/>costoTotale" value="${datiDellaRichiesta.getCostoTotale()}" />
                 </form>
                 <form action="<%=vaiModificaRichiestaURL%>" method="post" enctype="multipart/form-data"  id="<portlet:namespace/>modificaRichiesta">
                  <input type="hidden" name="<portlet:namespace/>idRichiesta" id="<portlet:namespace/>idRichiesta" value="${idRichiesta}">
                  <input type="hidden" name="<portlet:namespace/>stato" id="<portlet:namespace/>stato" value="${stato}">
                 </form>
				  <div class="ama-col-xs-12 mobile-no-padding">
                        <div class="wrapper-istanza-trasporti mobile-no-padding"><div class="box-gray"><div class=" box-white pb-0-xs">
                                <c:choose>
            						<c:when test="${dettaglio!=null}"><p class="name">${datiDettaglioRichiedenteBean.getNome().toUpperCase()} ${datiDettaglioRichiedenteBean.getCognome().toUpperCase()}</p>
            						</c:when>
            						<c:otherwise><p class="name">${nome.toUpperCase()} ${cognome.toUpperCase()}</p></c:otherwise>
            					</c:choose>
                                <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
                                <div id="collapse-trasporti" class="collapse1 in no-overflow">
                                    <div class="ama-row border-section border-mobile"><div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-facili-consumo-organizzazione"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}"><p class="info">${datiDettaglioRichiedenteBean.getOrganizzazione().toUpperCase()}</p>
                                            	</c:when><c:otherwise><p class="info">${datiDellaRichiesta.getOrganizzazione().toUpperCase()}</p>
            									</c:otherwise></c:choose> </div>  </div>
                                    <div class="ama-row border-section border-mobile">
                                        <div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="label-richiesta-beni-facile-consumo-ufficio-richiedente-riepilogo"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getUfficioRichiedente().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
            										<p class="info">${ufficioRichiedente.toUpperCase()}</p>
            									</c:otherwise>
            								</c:choose> </div>  </div>
                                    <div class="ama-row">
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="label-richiesta-beni-facile-consumo-label-richiesta-beni-facile-consumo-ubicazione"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getUbicazione().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
            										<p class="info">${ubicazione.toUpperCase()}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-sm"> <liferay-ui:message key="label-richiesta-beni-facile-consumo-palazzina-riepilogo"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getPalazzina().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
                                            		<p class="info">${palazzina.toUpperCase()}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="label-richiesta-beni-facile-consumo-piano-riepilogo"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getPiano().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
                                            		<p class="info">${piano}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="label-richiesta-beni-facile-consumo-scala-riepilogo"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getScala().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
                                            		<p class="info">${scala.toUpperCase()}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="label-richiesta-beni-facile-consumo-stanza-riepilogo"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getStanza().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
                                            		<p class="info">${stanza.toUpperCase()}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="label-richiesta-beni-facile-consumo-telefono-riepilogo"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getTelefono().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
                                            		<p class="info">${telefono}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="label-richiesta-beni-facile-consumo-email-richiedente-riepilogo"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null && datiDettaglioRichiedenteBean.getEmailRichiedente()!=null}" >
                                            		<p class="info">${datiDettaglioRichiedenteBean.getEmailRichiedente()}</p>
                                            	</c:when>
                                            	<c:when test="${dettaglio!=null && datiDettaglioRichiedenteBean.getEmailRichiedente()==null}" >
                                            		<p class="info"></p>
                                            	</c:when>
            									<c:otherwise>
                                            		<p class="info">${emailRichiedente}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6"><span class="section-information"><liferay-ui:message key="beni-facili-consumo-sede"/>:</span>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}">
                                            		<p class="info">${datiDettaglioRichiedenteBean.getSedeDescrizione().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise>
            										<p class="info">${datiDellaRichiesta.getSedeDescrizione().toUpperCase()}</p>
            									</c:otherwise>
            								</c:choose>
                                        </div></div></div></div></div></div></div></div>
            <div class="ama-row"><div class="ama-col-xs-12 mobile-no-padding"><div class="wrapper-istanza-trasporti"><div class="no-overflow">
                            <div class="box-gray"><div class="box-white"><div class="ama-row">
                                        <div class="ama-col-md-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="label-richiesta-beni-facile-consumo-si-richiede"/>:</span>
                                            <c:choose><c:when test="${dettaglio!=null}"><p class="info info-second-box">${datiDettaglioRichiestaBean.getTipoBeni()}</p>
                                            	</c:when><c:otherwise><p class="info info-second-box">${datiDellaRichiesta.getTipoBeni()}</p>
            									</c:otherwise></c:choose>
                                        </div></div></div></div></div></div></div></div>
            <div class="ama-row">
                <div class="ama-col-xs-12 mobile-no-padding"><div class="wrapper-istanza-trasporti"><div class="no-overflow"><div class="box-gray padding-mobile-servizi">
                                <div class="box-white"><div class="ama-row"><div class="ama-col-md-3 ama-col-xs-12"> 
                                            <p class="section-information display"><liferay-ui:message key="label-richiesta-beni-facile-consumo-oggetto-riepilogo"/>:</p>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}"><p class="text display mb-20-xs mb-0-sm">${datiDettaglioRichiestaBean.getOggetto().toUpperCase()}</p>
                                            	</c:when>
            									<c:otherwise><p class="text display mb-20-xs mb-0-sm">${datiDellaRichiesta.getOggetto().toUpperCase()}</p></c:otherwise></c:choose> 
                                        </div>
                                        <div class="ama-col-md-3 ama-col-xs-12">
                                            <p class="section-information display"><liferay-ui:message key="label-richiesta-beni-facile-consumo-data-richiesta-riepilogo"/>:</p>
                                            <c:choose>
            									<c:when test="${dettaglio!=null}"><p class="text display mb-20-xs mb-0-sm">${datiDettaglioRichiestaBean.getDataRichiesta()}</p></c:when>
            									<c:otherwise><p class="text display mb-20-xs mb-0-sm">${dataDiOggi}</p></c:otherwise>
            								</c:choose>
                                        </div><c:if test="${beniStandardListDettaglio != null && beniStandardListDettaglioSize >0}">
                                        <div class="ama-col-md-6 ama-col-xs-12">
                                            <p class="section-information display"><liferay-ui:message key="label-richiesta-beni-facile-consumo-periodicita-riepilogo"/>:</p>
                                            <p class="text display mb-20-xs mb-0-sm">${datiDettaglioRichiestaBean.getPeriodicitaDescrizione().toUpperCase()}</p>
                                        </div></c:if>  <c:if test="${listBeniStandard != null && listBeniStandard.size() >0}">
                                        <div class="ama-col-md-6 ama-col-xs-12">
                                            <p class="section-information display"><liferay-ui:message key="label-richiesta-beni-facile-consumo-periodicita-riepilogo"/>:</p>
                                            <p class="text display mb-20-xs mb-0-sm">${datiDellaRichiesta.getPeriodicitaDescrizione()}</p>
                                        </div> </c:if>
                                        <c:if test="${beniInformaticiListDettaglio != null && beniInformaticiListDettaglioSize >0}">
                                        <div class="ama-col-md-6 ama-col-xs-12">
                                            <p class="section-information display"><liferay-ui:message key="beni-facile-consumo-numero-macchina"/>:</p>
                                            <p class="text display mb-20-xs mb-0-sm">${datiDettaglioRichiestaBean.getNumeroInventarioMacchina()}</p>
                                        </div>  </c:if>
                                       <c:if test="${listBeniInformatica != null && listBeniInformatica.size() > 0}">
                                        <div class="ama-col-md-6 ama-col-xs-12">
                                            <p class="section-information display"><liferay-ui:message key="beni-facile-consumo-numero-macchina"/>:</p>
                                            <p class="text display mb-20-xs mb-0-sm">${datiDellaRichiesta.getNumeroInventarioMacchina()}</p>
                                        </div></c:if> </div></div></div></div> </div> </div> </div>
<div class="wrapper-beni-consumo mt-20-xs">
                <div class="ama-row">
                <c:if test="${beniStandardListDettaglio != null && beniStandardListDettaglioSize >0}">
                 <c:forEach items="${beniStandardListDettaglio}" var="listStandard">
                    <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni ">
                            <div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2"><%counter++;%><span class="number"><%=counter%>.</span></div>
                            <div class="ama-col-md-2 ama-col-sm-10 ama-col-xs-10">
                                <span class="text mb-10-xs mb-0-sm">${listStandard.getGruppoDescrizione().toUpperCase()}</span>
                            </div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-10 ama-col-xs-10 border-mobile mb-10-xs mb-0-md">
                                <span class="text mb-10-xs mb-0-sm">${listStandard.getSottoGruppoDescrizione().toUpperCase()}</span>
                            </div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-5 ama-col-xs-5">
                                <span class="text align-center-text">${listStandard.getMaterialeDescrizione().toUpperCase()}</span>
                            </div>
                            <div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2">
                                <span class="text align-center-text">${listStandard.getQuantita()}</span>
                            </div>
                            <div class="ama-col-md-2 ama-col-sm-3 ama-col-xs-3 text-right"><span class="number">${listStandard.getCostoUnitario()}&euro;</span></div></div></div>
              </c:forEach>
              <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni">
                            <div class="ama-col-md-10 ama-col-md-offset-0 ama-col-xs-4 ama-col-xs-offset-2 text-right"><span class="text text-tot"><liferay-ui:message key="label-richiesta-beni-facile-consumo-costo-totale-riepilogo"/>:</span>
                            </div>
                            <div class="ama-col-md-2 ama-col-xs-6 text-right pr-0-xs pr-15-sm">
                                <span class="number medium-text">${datiDettaglioRichiestaBean.getCostoTotale()}&euro;</span>
                            </div></div></div></c:if>
                <c:if test="${listBeniStandard != null && listBeniStandard.size() >0}">
                 <c:forEach items="${listBeniStandard}" var="listStandard">
                    <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni "><div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2"><%counter++;%><span class="number"><%=counter%>.</span></div>
                            <div class="ama-col-md-2 ama-col-sm-10 ama-col-xs-10"><span class="text mb-10-xs mb-0-sm">${listStandard.getGruppoDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-10 ama-col-xs-10 border-mobile mb-10-xs mb-0-md"><span class="text mb-10-xs mb-0-sm">${listStandard.getSottoGruppoDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-5 ama-col-xs-5"> <span class="text align-center-text">${listStandard.getMaterialeDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2"><span class="text align-center-text">${listStandard.getQuantita()}</span></div>
                            <div class="ama-col-md-2 ama-col-sm-3 ama-col-xs-3 text-right">
                                <span class="number">${listStandard.getCostoUnitario()}&euro;</span>
                            </div></div></div>
              </c:forEach>
              <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni">
                            <div class="ama-col-md-10 ama-col-md-offset-0 ama-col-xs-4 ama-col-xs-offset-2 text-right"><span class="text text-tot"><liferay-ui:message key="label-richiesta-beni-facile-consumo-costo-totale-riepilogo"/>:</span>
                            </div>
                            <div class="ama-col-md-2 ama-col-xs-6 text-right pr-0-xs pr-15-sm"><span class="number medium-text">${datiDellaRichiesta.getCostoTotale()}&euro;</span> </div> </div> </div></c:if>
               <c:if test="${beniInformaticiListDettaglio != null && beniInformaticiListDettaglioSize >0}">
                 <c:forEach items="${beniInformaticiListDettaglio}" var="listInformatica">
                    <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni ">
                            <div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2"> <%counter++;%> <span class="number"><%=counter%>.</span></div>
                            <div class="ama-col-md-2 ama-col-sm-10 ama-col-xs-10"><span class="text mb-10-xs mb-0-sm">${listInformatica.getGruppoDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-10 ama-col-xs-10 border-mobile mb-10-xs mb-0-md"><span class="text mb-10-xs mb-0-sm">${listInformatica.getSottoGruppoDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-5 ama-col-xs-5"> <span class="text align-center-text">${listInformatica.getMaterialeDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2"> <span class="text align-center-text">${listInformatica.getQuantita()}</span></div>
                            <div class="ama-col-md-2 ama-col-sm-3 ama-col-xs-3 text-right"><span class="number">${listInformatica.getCostoUnitario()}&euro;</span></div></div></div>
                 </c:forEach>
                 <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni">
                            <div class="ama-col-md-10 ama-col-md-offset-0 ama-col-xs-4 ama-col-xs-offset-2 text-right"><span class="text text-tot"><liferay-ui:message key="label-richiesta-beni-facile-consumo-costo-totale-riepilogo"/>:</span></div>
                            <div class="ama-col-md-2 ama-col-xs-6 text-right pr-0-xs pr-15-sm">
                                <span class="number medium-text">${datiDettaglioRichiestaBean.getCostoTotale()}&euro;</span>
                            </div></div></div></c:if>
               <c:if test="${listBeniInformatica != null && listBeniInformatica.size() >0}">
                 <c:forEach items="${listBeniInformatica}" var="listInformatica">
                    <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni ">
                            <div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2"><%counter++;%><span class="number"><%=counter%>.</span></div>
                            <div class="ama-col-md-2 ama-col-sm-10 ama-col-xs-10"><span class="text mb-10-xs mb-0-sm">${listInformatica.getGruppoDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-10 ama-col-xs-10 border-mobile mb-10-xs mb-0-md"> <span class="text mb-10-xs mb-0-sm">${listInformatica.getSottoGruppoDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-md-2 ama-col-sm-5 ama-col-xs-5"><span class="text align-center-text">${listInformatica.getMaterialeDescrizione().toUpperCase()}</span></div>
                            <div class="ama-col-md-2 ama-col-sm-2 ama-col-xs-2"><span class="text align-center-text">${listInformatica.getQuantita()}</span></div>
                            <div class="ama-col-md-2 ama-col-sm-3 ama-col-xs-3 text-right"><span class="number">${listInformatica.getCostoUnitario()}&euro;</span>
                            </div></div></div>
                 </c:forEach>
                 <div class="ama-col-md-12 ama-col-xs-12">
                        <div class="box-gray-beni"> <div class="ama-col-md-10 ama-col-md-offset-0 ama-col-xs-4 ama-col-xs-offset-2 text-right"><span class="text text-tot"><liferay-ui:message key="label-richiesta-beni-facile-consumo-costo-totale-riepilogo"/>:</span></div>
                            <div class="ama-col-md-2 ama-col-xs-6 text-right pr-0-xs pr-15-sm"><span class="number medium-text">${datiDellaRichiesta.getCostoTotale()}&euro;</span>
                            </div></div></div></c:if></div></div>
 <c:if test="${not empty datiDettaglioRichiestaBean.getDescrizione() || not empty datiDellaRichiesta.getDescrizione()}">
  <div class="ama-row mb-30-xs"> <div class="ama-col-xs-12 mobile-no-padding"><div class="wrapper-istanza-trasporti"><div class="no-overflow">
                            <div class="box-gray padding-mobile-servizi"><div class="box-white"> <div class="ama-row"><div class="ama-col-xs-12">
                                            <c:if test="${dettaglio != null && not empty datiDettaglioRichiestaBean.getDescrizione()}">
            									<p class="section-information display"><liferay-ui:message key="label-richiesta-beni-facile-consumo-beni-descrizione-riepilogo"/>:</p>
                                            	<p class="text display no-width">${datiDettaglioRichiestaBean.getDescrizione()}</p>
                                            </c:if>
            								<c:if test="${not empty datiDellaRichiesta.getDescrizione()}">
            									<p class="section-information display"><liferay-ui:message key="label-richiesta-beni-facile-consumo-beni-descrizione-riepilogo"/>:</p>
                                            	<p class="text display no-width">${datiDellaRichiesta.getDescrizione()}</p>
            								</c:if>   </div> </div> </div> </div></div></div></div></div>   
            <c:if test="${consegnatarioRole==false && noteConsegnatario!=null}">
    <div class="wrapper-beni-inventariati">
                <p class="title-form mt-20-xs mb-5-xs"><liferay-ui:message key="beni-facile-consumo-note-consegnatario"/>:</p>
                <p class="mb-40-xs">${noteConsegnatario}</p> </div></c:if> </c:if> 
<c:if test="${dettaglio==null}">
    <div class="ama-row"><div class="ama-col-xs-12"><div class="wrapper-button mt-100-sm mb-100-sm mb-20-xs"><div class="ama-row"><div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 text-right"><button type="button" class="button button-secondary" id="<portlet:namespace/>modifica" ><liferay-ui:message key="label-richiesta-beni-facile-consumo-modifica-riepilogo"/></button>
                    </div><form action="<%=vaiAInserimento%>" enctype="multipart/form-data"  method="post"><div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 text-center">
                        <button class="button button-secondary"><liferay-ui:message key="label-richiesta-beni-facile-consumo-nuova-riepilogo"/></button>
                    </div>  </form>
                     <portlet:resourceURL var="resourceURL"></portlet:resourceURL>
                    <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 text-left">
                        <button type="button" class="button button-primary" id="<portlet:namespace/>invia"><liferay-ui:message key="label-richiesta-beni-facile-consumo-invia-riepilogo"/></button>
                    </div> </div></div> </div> </div></c:if>    
<c:if test="${(dirigenteRole==true || delegatoRole==true) && dettaglio!=null && datiDettaglioRichiestaBean.getStato() == 'in approvazione'}"><c:if test="<%=!approvazioneFlag%>">
   <div class="ama-row"><div class="ama-col-xs-12"><div class="wrapper-button mt-100-sm mb-100-sm mb-20-xs">
                <div class="ama-row">
                    <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 text-right">
                        <button type="button" class="button button-secondary" id="<portlet:namespace/>modificaRichiestaBtn"><liferay-ui:message key="beni-facile-consumo-modifica-riepilogo"/></button>
                    </div>
	                    <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 text-center">
	                        <button type="button" class="button button-secondary" onclick="openModal(event)"><liferay-ui:message key="beni-facile-consumo-respingi-riepilogo"/></button>
	                    </div>
                    <form action="<%=approvaRifiutaRichiestaURL%>" enctype="multipart/form-data"  method="post">
	                    <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 text-left">
	                    	<input type="hidden" name="<portlet:namespace/>action" value="approva" />
	                    	 <input type="hidden" name="<portlet:namespace/>idRichiesta" value="<%=idRichiesta%>">
	                        <button type="submit" class="button button-primary"><liferay-ui:message key="beni-facile-consumo-approva-riepilogo"/></button>
	                    </div></form> </div></div> </div></div>
    <div id="IDMODALE" class="modal modal-custom fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body"><div class="modal-title-box"><a href="#" class="icomoon-close-white" data-dismiss="modal"></a><div class="title-modal"> <h2 class="title"><liferay-ui:message key="beni-facile-consumo-respingi-richiesta"/></h2></div></div>
                <div class="p-30-xs"> <form id="<portlet:namespace/>rifiutaForm" class="m-0-xs ama-row" enctype="multipart/form-data"  data-parsley-validate data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" action="<%=approvaRifiutaRichiestaURL%>" method="post">
<div class="wrapper-content-textarea ama-col-xs-12">
                            <label class="label-form mt-0-xs" for="textarea-detail"><liferay-ui:message key="beni-facile-consumo-motivazione"/>*</label>
                            <textarea class="form-control textarea-custom-light data-parsley-validated" id="textarea-detail" placeholder="Aggiungi la motivazione" name="<portlet:namespace/>motivazioneRifiuto" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"></textarea>
                            <div class="content-textarea">0/
                                <p class="color-gray">500
                                </p></div> </div>
                        <div class="ama-col-xs-12 mt-35-xs buttons-bottom text-center">
                            <div class="ama-row"><div class="ama-col-xs-12 ama-col-sm-6"><button class="button button-secondary" data-dismiss="modal"><liferay-ui:message key="beni-facili-consumo-annulla"/></button></div>
                                <div class="ama-col-xs-12 ama-col-sm-6">
                                    <button type=button" class="button button-primary" onclick="respingiRichiesta(event)"><liferay-ui:message key="beni-facile-consumo-salva"/></button>
                                </div></div> </div>
                        <input type="hidden" name="<portlet:namespace/>action" value="rifiuta" />
                        <input type="hidden" name="<portlet:namespace/>idRichiesta" value="<%=idRichiesta%>"></form> </div> </div></div> </div></div></c:if></c:if>
<c:if test="${consegnatarioRole==true && dettaglio!=null  && (datiDettaglioRichiestaBean.getStato() == 'accettata' || datiDettaglioRichiestaBean.getStato() == 'rifiutata')}"> <c:if test="<%=!approvazioneFlag%>">
   <div class="wrapper-beni-inventariati wrapper-content-textarea">
                <p class="title-form mt-20-xs mb-5-xs">Note Consegnatario:</p>
                <form id="noteConsegnatarioForm" action="<%=setNoteConsegnatarioURL%>" enctype="multipart/form-data"  method="post">
                    <div class="ama-row"><div class="ama-col-md-12 ama-col-xs-12"><div class="wrapper-content-textarea">
                                <textarea class="form-control textarea-custom-light" id="textarea-detail" placeholder="Aggiungi le note ..." name="<portlet:namespace/>noteConsegnatario"><c:if test="${noteConsegnatario!=null}"><%=(String)request.getAttribute("noteConsegnatario").toString().trim()%></c:if></textarea>
                                <div class="content-textarea">0/
                                    <p class="color-gray">500</p>
                                </div></div></div></div>
                     <input type="hidden" name="<portlet:namespace/>idRichiesta" value="<%=idRichiesta%>"></form></div>
            <div class="ama-row">
                <div class="ama-col-md-6 ama-col-xs-12 text-center mb-100-md mb-30-sm mt-30-sm mt-50-md mt-20-xs">
                    <button type="button" class="button button-secondary" onclick="resetNoteConsegnatario(event)"><liferay-ui:message key="beni-facile-consumo-annulla"/></button>
                </div>
                <div class="ama-col-md-6 ama-col-xs-12 text-center mb-100-md mb-30-xs mt-30-sm mt-50-md mt-20-xs">
                    <button type="button" class="button button-primary" onclick="submitNoteConsegnatario(event)"><liferay-ui:message key="beni-facile-consumo-prosegui"/></button></div></div></c:if></c:if></div>
<script>
var idRichiesta = '<%=idRichiesta%>';
$("#<portlet:namespace/>invia").click("on",function(){	
	if (idRichiesta != "null") { $("#listjsonModificaDirigente").val(JSON.stringify(${json}));	
	    $("#<portlet:namespace/>modificaRichiestaDirigente").submit();}
	else { $("#listjson").val(JSON.stringify(${json}));	
		$("#<portlet:namespace/>formInvia").submit();}});	
$("#<portlet:namespace/>modifica").click("on",function(){	
	$("#listjsonModifica").val(JSON.stringify(${json}));	
	$("#<portlet:namespace/>formModifica").submit();});		
$("#<portlet:namespace/>modificaRichiestaBtn").click("on",function(){ 
	$("#<portlet:namespace/>modificaRichiesta").submit();});
function respingiRichiesta(event) {
	event.preventDefault();
 	$('#<portlet:namespace/>rifiutaForm').parsley().validate();
 	if ($('#<portlet:namespace/>rifiutaForm').parsley().isValid()) {
	$('#<portlet:namespace/>rifiutaForm').submit();	}}
function openModal(event) {
	event.preventDefault();
	$('#IDMODALE').modal('show');}
function resetNoteConsegnatario(event) {
	event.preventDefault();
	$('#textarea-detail').val("");}
function submitNoteConsegnatario(event) {
	event.preventDefault();
	$('#noteConsegnatarioForm').submit();}
</script>