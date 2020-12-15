<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.mef.intranet.bean.Richiedente"%>
<%@page import="com.mef.intranet.bean.DatiRichiestaBean"%>
<%@page import="servizio.beni.facile.consumo.model.Periodicita"%>
<%@page import="servizio.beni.facile.consumo.model.Periodicita"%>
<%@page import="external.bfc.intranet.mef.model.SediBfc"%>
<%@page import="java.util.Arrays"%>
<%
String codiceGeco = "";
if (request.getAttribute("datiRichiestaBean")!=null) {
	codiceGeco = ((DatiRichiestaBean) request.getAttribute("datiRichiestaBean")).getCodiceGeco();
}
Richiedente richiedente = (Richiedente) request.getAttribute("richiedente");
DatiRichiestaBean datiRichiestaBean = (DatiRichiestaBean) request.getAttribute("datiRichiestaBean");
String dirigente = (String)request.getAttribute("dirigente");
String dataOra = datiRichiestaBean.getDataRichiesta();
String oggetto = datiRichiestaBean.getOggetto();
String validazioneRichiesta = null;
List<DatiRichiestaBean> datiSelezionatiStandard = new ArrayList<>(0);
List<DatiRichiestaBean> datiSelezionatiInformatica = new ArrayList<>(0);
List<SediBfc> listSede = new ArrayList<>(0);
String stato = null;
if (request.getAttribute("stato")!=null) 
	stato = (String) request.getAttribute("stato");
if(request.getAttribute("listGruppoStandard") != null)
                datiSelezionatiStandard = (List<DatiRichiestaBean>) request.getAttribute("listGruppoStandard");
if(request.getAttribute("listGruppoInformatica") != null)
                datiSelezionatiInformatica = (List<DatiRichiestaBean>) request.getAttribute("listGruppoInformatica");
if(request.getAttribute("validazioneRichiesta") != null)
	validazioneRichiesta =(String) request.getAttribute("validazioneRichiesta");
if(request.getAttribute("sediBfc") != null)
	listSede =(List<SediBfc>) request.getAttribute("sediBfc");
String tipoBeni = (String) request.getAttribute("tipoBeni");
int beniConsumoStandardDivId = 1;
int beniConsumoInformaticaDivId = 1;
int counterBeniStandard = 1;
int counterBeniInformatica = 1;
%>
<portlet:actionURL name="riepilogoDati" var="riepilogoDatiUrl"></portlet:actionURL>
<c:set value="<%=datiSelezionatiStandard%>" var="datiSelezionatiStandard"></c:set>
<c:set value="<%=datiSelezionatiInformatica%>" var="datiSelezionatiInformatica"></c:set>
<c:set value="<%=listSede%>" var="listSede"></c:set>
<c:set value="<%=dataOra%>" var="dataOra"></c:set>
<c:set value="<%=validazioneRichiesta%>" var="validazioneRichiesta"></c:set>
<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12"> <div class="title-wrapper"> <h2 class="title"><%=formTitle%></h2><a href="#" title="star" class="icomoon-star title-star btn-star-bookmarks pl-0-xs pl-20-md"></a>
                             <div class="wrap-icon-title">
                                  <c:if test="${dirigenteRole}">
                                      <a href="<%=vaiAGestioneUtenti%>" title="<liferay-ui:message key="beni-facile-consumo-gestione-utenti-tooltip"/>"  class="icon icomoon-profile"></a>
                                  </c:if> 
                                  <a href="<%=getListaRichieste%>" title="<liferay-ui:message key="beni-facile-consumo-lista-richieste-tooltip"/>" class="icon icomoon-user2"></a>
                                  <c:if test="${delegatoRole || dirigenteRole}">
                                  	  <a href="<%=vaiARicerca%>" title="<liferay-ui:message key="beni-facile-consumo-ricerca-tooltip"/>" class="icon icomoon-search-richiesta "></a>
                                 </c:if>
                             </div><p class="subtitle dot-point dot-200"><%=formSubtitle%></p>
                     </div></div> </div></div></div>
    <div class="ama-container-fluid">
         <div id="mainContainer">
            <div class="ama-row">
            <c:if test="${catch-geco-error-label != null}"><liferay-ui:error key="catch-geco-error" message="<%=(String)request.getAttribute("catch-geco-error-label")%>"></liferay-ui:error></c:if>
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small"><h2 class="title-box borders"><liferay-ui:message key="beni-facili-consumo-dati-richiedente"/></h2></div> </div>  </div>
             <c:if test="${dirigente == 0}">
            <div class="ama-row">
                <form enctype="multipart/form-data" data-parsley-validate="true" id="<portlet:namespace/>beniFaciliConsumoInserimentoForm" action="<%=riepilogoDatiUrl%>" method="post">
					<div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
			            <label for="argument1" class="label-form"><liferay-ui:message key="beni-facili-consumo-organizzazione"/>*</label>
			            <c:if test="${richiedente.getOrganizzazione() != null}">
			            	<input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" id="<portlet:namespace/>organizzazione" name="<portlet:namespace/>organizzazione" type="text" class="input-custom-light data-parsley-validated" placeholder= "<liferay-ui:message key='placeholder-organizzazione-richiedente'/>" value="${richiedente.getOrganizzazione()}" readonly>
                    	</c:if>
                    	<c:if test="${richiedente.getOrganizzazione() == null}">
			            	<input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" id="<portlet:namespace/>organizzazione" name="<portlet:namespace/>organizzazione" type="text" class="input-custom-light data-parsley-validated" placeholder="NOME ORGANIZZAZIONE">
                    	</c:if></div>
                    <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                        <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-ufficio-richiedente"/>*</label>
                         <c:if test="${richiedente.getUfficioRichiedente() == null}">
                             <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>ufficioRichiedente" name="<portlet:namespace/>ufficioRichiedente" placeholder="<liferay-ui:message key='placeholder-ufficio'/>">
                        </c:if>
                        <c:if test="${richiedente.getUfficioRichiedente() != null}">
                             <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>ufficioRichiedente" name="<portlet:namespace/>ufficioRichiedente" placeholder="<liferay-ui:message key='placeholder-ufficio'/>" value="${richiedente.getUfficioRichiedente()}" readonly>
                        </c:if> </div>
                    <div class="ama-col-xs-12 mb-25-md">
                        <div class="ama-row">
                            <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-nome"/>*</label>
                                <c:if test="${richiedente.getNome() == null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>nome" name="<portlet:namespace/>nome" placeholder="<liferay-ui:message key='placeholder-nome'/>">
                                </c:if>
                                <c:if test="${richiedente.getNome() != null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>nome" name="<portlet:namespace/>nome" placeholder="<liferay-ui:message key='placeholder-nome'/>" value="${richiedente.getNome()}" readonly>
                                </c:if> </div>
                            <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-cognome"/>*</label>
                                <c:if test="${richiedente.getCognome() == null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>cognome" name="<portlet:namespace/>cognome" placeholder="<liferay-ui:message key='placeholder-cognome'/>">
                                </c:if>
                                <c:if test="${richiedente.getCognome() != null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>cognome" name="<portlet:namespace/>cognome" placeholder="<liferay-ui:message key='placeholder-cognome'/>" value="${richiedente.getCognome()}" readonly>
                                </c:if>    </div> </div> </div>
                    <div class="ama-col-xs-12 mb-25-md">
                        <div class="ama-row">
                            <div class="ama-col-sm-4 ama-col-xs-12">
                                             <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-ubicazione-attuale"/></label>
                                <c:if test="${richiedente.getUbicazione() == null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>ubicazione" name="<portlet:namespace/>ubicazione" placeholder="<liferay-ui:message key='placeholder-ubicazione'/>">
                                </c:if>
                                <c:if test="${richiedente.getUbicazione() != null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>ubicazione" name="<portlet:namespace/>ubicazione" placeholder="<liferay-ui:message key='placeholder-ubicazione'/>" value="${richiedente.getUbicazione()}">
                                </c:if></div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-palazzina"/></label>
                                <c:if test="${richiedente.getPalazzina() == null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>palazzina" name="<portlet:namespace/>palazzina" placeholder="<liferay-ui:message key='placeholder-palazzina'/>">
                                </c:if>
                                 <c:if test="${richiedente.getPalazzina() != null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>palazzina" name="<portlet:namespace/>palazzina" placeholder="<liferay-ui:message key='placeholder-palazzina'/>" value="${richiedente.getPalazzina()}">
                                </c:if> </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                            <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-piano"/></label>
                                            <c:if test="${richiedente.getPiano() == null}">
                                            <input type="text"  id="<portlet:namespace/>piano" name="<portlet:namespace/>piano" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-piano'/>">
                                </c:if>
                                <c:if test="${richiedente.getPiano() != null}">
                                            <input type="text" id="<portlet:namespace/>piano" name="<portlet:namespace/>piano" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-piano'/>" value="${richiedente.getPiano()}">
                                </c:if>  </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-scala"/></label>
                                <c:if test="${richiedente.getScala() == null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>scala" name="<portlet:namespace/>scala" placeholder="<liferay-ui:message key='placeholder-scala'/>">
                                </c:if>
                               <c:if test="${richiedente.getScala() != null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>scala" name="<portlet:namespace/>scala" placeholder="<liferay-ui:message key='placeholder-scala'/>" value="${richiedente.getScala()}">
                               </c:if> </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-stanza"/></label>
                               <c:if test="${richiedente.getStanza() == null}">
                                <input type="text" id="<portlet:namespace/>stanza" name="<portlet:namespace/>stanza" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-stanza'/>">
                               </c:if>
                               <c:if test="${richiedente.getStanza() != null}">
                                            <input type="text" id="<portlet:namespace/>stanza" name="<portlet:namespace/>stanza" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-stanza'/>" value="${richiedente.getStanza()}">
                               </c:if>
                            </div></div> </div>
                    <div class="ama-col-xs-12 mb-25-md">
                        <div class="ama-row">
                            <div class="ama-col-sm-6 ama-col--xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-telefono"/></label>
                                             <c:if test="${richiedente.getTelefono() == null}">
                                            <input  data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" id="<portlet:namespace/>telefono" name="<portlet:namespace/>telefono" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-telefono'/>">
                            </c:if>
                            <c:if test="${richiedente.getTelefono() != null}">
                                            <input  data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" id="<portlet:namespace/>telefono" name="<portlet:namespace/>telefono" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-telefono'/>" value="${richiedente.getTelefono()}">
                            </c:if>   
                            </div>
                             <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-email-richiedente"/>*</label>
                               <c:if test="${richiedente.getEmailDirigente() == null}">
                                 <input style="display:none" name="<portlet:namespace/>emailDirigente" value="${richiedente.getEmailDirigente()}" id="<portlet:namespace/>emailDirigente">
                                </c:if>
                                <c:if test="${richiedente.getEmailDirigente() != null}">
								
                                <input style="display:none" name="<portlet:namespace/>emailDirigente" value="${richiedente.getEmailDirigente()}" id="<portlet:namespace/>emailDirigente">
								
								    </c:if>
                               <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" name="<portlet:namespace/>emailRichiedente" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key='placeholder-email'/>" value="${richiedente.getEmailRichiedente()}" id="<portlet:namespace/>emailRichiedente">                 
                            </div>   </div>  </div>
                    <input type="hidden" name="<portlet:namespace/>json" id="<portlet:namespace/>json"/>
                    <input type="hidden" name="<portlet:namespace/>stato" id="<portlet:namespace/>stato"/>
                </form>  </div>   
            </c:if>   
              <c:if test="${dirigente == 1}">
              <div class="ama-row">
                <form enctype="multipart/form-data" data-parsley-validate="true" id="<portlet:namespace/>beniFaciliConsumoModificaForm" action="<%=riepilogoDatiUrl%>" method="post">
					<div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
			            <label for="argument1" class="label-form"><liferay-ui:message key="beni-facili-consumo-organizzazione"/>*</label>
			            <c:if test="${richiedente.getOrganizzazione() != null}">
			            	<input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" id="<portlet:namespace/>organizzazione" name="<portlet:namespace/>organizzazione" type="text" class="input-custom-light data-parsley-validated" placeholder= "<liferay-ui:message key='placeholder-organizzazione-richiedente'/>" value="${richiedente.getOrganizzazione()}" readonly>
                    	</c:if>
                    	<c:if test="${richiedente.getOrganizzazione() == null}">
			            	<input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" id="<portlet:namespace/>organizzazione" name="<portlet:namespace/>organizzazione" type="text" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key='placeholder-organizzazione-richiedente'/>">
                    	</c:if>
                    </div>
                    <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                        <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-ufficio-richiedente"/>*</label>
                         <c:if test="${richiedente.getUfficioRichiedente() == null}">
                             <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>ufficioRichiedente" name="<portlet:namespace/>ufficioRichiedente" placeholder="<liferay-ui:message key='placeholder-ufficio'/>">
                        </c:if>
                        <c:if test="${richiedente.getUfficioRichiedente() != null}">
                             <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>ufficioRichiedente" name="<portlet:namespace/>ufficioRichiedente" placeholder="<liferay-ui:message key='placeholder-ufficio'/>" value="${richiedente.getUfficioRichiedente()}" readonly>
                        </c:if>
                    </div>
                    <div class="ama-col-xs-12 mb-25-md">
                        <div class="ama-row">
                            <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-nome"/></label>
                                <c:if test="${richiedente.getNome() == null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="input-custom-light data-parsley-validated" id="<portlet:namespace/>nome" name="<portlet:namespace/>nome" placeholder="<liferay-ui:message key='placeholder-nome'/>" readonly>
                                </c:if>
                                <c:if test="${richiedente.getNome() != null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  class="input-custom-light data-parsley-validated" id="<portlet:namespace/>nome" name="<portlet:namespace/>nome" placeholder="<liferay-ui:message key='placeholder-nome'/>" value="${richiedente.getNome()}" readonly>
                                </c:if>
                            </div>
                            <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-cognome"/></label>
                                <c:if test="${richiedente.getCognome() == null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  class="input-custom-light data-parsley-validated" id="<portlet:namespace/>cognome" name="<portlet:namespace/>cognome" placeholder="<liferay-ui:message key='placeholder-cognome'/>" readonly>
                                </c:if>
                                <c:if test="${richiedente.getCognome() != null}">
                                            <input data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  class="input-custom-light data-parsley-validated" id="<portlet:namespace/>cognome" name="<portlet:namespace/>cognome" placeholder="<liferay-ui:message key='placeholder-cognome'/>" value="${richiedente.getCognome()}" readonly>
                                </c:if></div> </div> </div>
                    <div class="ama-col-xs-12 mb-25-md">
                        <div class="ama-row">
                            <div class="ama-col-sm-4 ama-col-xs-12">
                                             <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-ubicazione-attuale"/></label>
                                <c:if test="${richiedente.getUbicazione() == null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>ubicazione" name="<portlet:namespace/>ubicazione" placeholder="<liferay-ui:message key='placeholder-ubicazione'/>" readonly>
                                </c:if>
                                <c:if test="${richiedente.getUbicazione() != null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>ubicazione" name="<portlet:namespace/>ubicazione" placeholder="<liferay-ui:message key='placeholder-ubicazione'/>" value="${richiedente.getUbicazione()}" readonly>
                                </c:if>
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-palazzina"/></label>
                                <c:if test="${richiedente.getPalazzina() == null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>palazzina" name="<portlet:namespace/>palazzina" placeholder="<liferay-ui:message key='placeholder-palazzina'/>" readonly>
                                </c:if>
                                 <c:if test="${richiedente.getPalazzina() != null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>palazzina" name="<portlet:namespace/>palazzina" placeholder="<liferay-ui:message key='placeholder-palazzina'/>" value="${richiedente.getPalazzina()}" readonly>
                                </c:if>
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                            <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-piano"/></label>
                                            <c:if test="${richiedente.getPiano() == null}">
                                            <input type="text"  id="<portlet:namespace/>piano" name="<portlet:namespace/>piano" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-piano'/>" readonly>
                                </c:if>
                                <c:if test="${richiedente.getPiano() != null}">
                                            <input type="text" id="<portlet:namespace/>piano" name="<portlet:namespace/>piano" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-piano'/>" value="${richiedente.getPiano()}" readonly>
                                </c:if>
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-scala"/></label>
                                <c:if test="${richiedente.getScala() == null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>scala" name="<portlet:namespace/>scala" placeholder="<liferay-ui:message key='placeholder-scala'/>" readonly >
                                </c:if>
                               <c:if test="${richiedente.getScala() != null}">
                                            <input type="text" class="input-custom-light" id="<portlet:namespace/>scala" name="<portlet:namespace/>scala" placeholder="<liferay-ui:message key='placeholder-scala'/>" value="${richiedente.getScala()}" readonly>
                               </c:if>
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-stanza"/></label>
                               <c:if test="${richiedente.getStanza() == null}">
                                <input type="text" id="<portlet:namespace/>stanza" name="<portlet:namespace/>stanza" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-stanza'/>"readonly>
                               </c:if>
                               <c:if test="${richiedente.getStanza() != null}">
                                            <input type="text" id="<portlet:namespace/>stanza" name="<portlet:namespace/>stanza" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-stanza'/>" value="${richiedente.getStanza()}" readonly>
                               </c:if>
                            </div> </div>   </div>
                    <div class="ama-col-xs-12 mb-25-md "> 
                        <div class="ama-row">
                            <div class="ama-col-sm-6 ama-col--xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-telefono"/></label>
                                             <c:if test="${richiedente.getTelefono() == null}">
                                            <input  data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"  data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" id="<portlet:namespace/>telefono" name="<portlet:namespace/>telefono" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-telefono'/>" readonly>
                            </c:if>
                            <c:if test="${richiedente.getTelefono() != null}">
                                            <input  data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"  data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" id="<portlet:namespace/>telefono" name="<portlet:namespace/>telefono" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-telefono'/>" value="${richiedente.getTelefono()}" readonly>
                            </c:if>   
                            </div>
                           <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="beni-facile-consumo-email-richiedente"/>*</label>
                               <c:if test="${richiedente.getEmailDirigente() == null}">
                                 <input style="display:none" name="<portlet:namespace/>emailDirigente" value="${richiedente.getEmailDirigente()}" id="<portlet:namespace/>emailDirigente">
                                </c:if>
                                <c:if test="${richiedente.getEmailDirigente() != null}">
								<input style="display:none" name="<portlet:namespace/>emailDirigente" value="${richiedente.getEmailDirigente()}" id="<portlet:namespace/>emailDirigente">
								</c:if>                                                                                                                                                                                                                                
                                <input data-parsley-required="true"  data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"  name="<portlet:namespace/>emailRichiedente" class="input-custom-light data-parsley-validated"  placeholder="<liferay-ui:message key='placeholder-email'/>" value="${richiedente.getEmailRichiedente()}" id="<portlet:namespace/>emailRichiedente" readonly>   
                           <input type="hidden" value="${richiedente.getEmailRichiedente()}" name="<portlet:namespace/>richiedente"/>
                           </div> </div>  </div>
                     <input type="hidden" name="<portlet:namespace/>json" id="<portlet:namespace/>json"/>
               <input type="hidden" name="<portlet:namespace/>idRichiesta" id="<portlet:namespace/>idRichiesta" value="${idRichiesta}"/>
                <input type="hidden" name="<portlet:namespace/>stato" id="<portlet:namespace/>stato" value="${stato}"/>
                </form> </div> </c:if>
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="beni-facile-consumo-dati-richiesta"/></h2>
                    </div> </div> </div>
         <div class="ama-row">
             <div class="ama-col-xs-12">
                 <span class="tab-beni-consumo pb-30-xs"><liferay-ui:message key="beni-facile-consumo-si-richiede"/></span>
                 <div class="tab-filtri filtro-categoria collapse-group mobile-trasporti" id="tabs-profile">
                     <div class="filtro-tabs-wrapper mr-0-xs mt-0-xs ml-0-xs">
                         <a href="" title="BENI STANDARD" id="<portlet:namespace/>beniStandardTab" class="tab-title active" data-toggle="collapse" data-target="#standard" data-parent="#tabs-beni" onclick="return onChangeSedeSwitch();"><liferay-ui:message key="beni-facile-consumo-standard"/></a>
                         <a href="" title="BENI INFORMATICI" id="<portlet:namespace/>beniInformaticaTab" class="tab-title" data-toggle="collapse" data-target="#technology" data-parent="#tabs-beni" onclick="return onChangeSedeSwitch();"><liferay-ui:message key="beni-facile-consumo-informatici"/></a>
                     </div>
                     <div id="standard" class="collapse in">
                         <div class="wrapper-tab-beni-consumo ">
                             <div class="box-gray no-margin">
                                 <div class="box-white box-gray-mobile">
                                     <form enctype="multipart/form-data" action="" method="post">
								<div class="ama-row mb-30-xs">
						            <div class="ama-col-md-6 ama-col-xs-12">
						                <label for="sede" class="label-form margin-top"><liferay-ui:message key="beni-facili-consumo-sede"/>*</label>
						               <select data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="option-select selectSedeClass data-parsley-validated" id="<portlet:namespace/>selectSedeBeniStandard" onchange="onChangeSede()"> 
						                    <option value="" hidden=""><liferay-ui:message key="beni-facili-consumo-select-sede"/></option>
						                    <c:forEach items="${sediBfcBeniStandard}" var="itemsListSede">
						                    <c:choose>
						                    <c:when test="${itemsListSede.getId_sede_geco() == richiedente.getSede() && tipoBeni == 'beniStandard'}">
						                    <option selected value="${itemsListSede.getId_sede_geco()};${itemsListSede.getCodice_geco()}">${itemsListSede.getNomeLoc()}</option>
						                    </c:when>
						                    <c:otherwise>
						                    <option value="${itemsListSede.getId_sede_geco()};${itemsListSede.getCodice_geco()}">${itemsListSede.getNomeLoc()}</option>
						                    </c:otherwise>
						                    </c:choose>
						                    </c:forEach>
						                </select>
						            </div></div>
                                         <div class="ama-row">
                                             <div class="col-md-6">
                                                 <label for="<portlet:namespace/>oggettoBeniStandard" class="label-form "><liferay-ui:message key="beni-facile-consumo-oggetto-standard"/></label>
                                 <c:if test="${datiRichiestaBean.getOggetto() == null }">
                                                 <input id="<portlet:namespace/>oggettoBeniStandard" name="<portlet:namespace/>oggettoBeniStandard" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-oggetto-richiesta-standard '/>"  value="<%=oggettoBeniStandard%>" readonly>
                                            </c:if>
                                             <c:if test="${datiRichiestaBean.getOggetto() != null }">
                                                 <input id="<portlet:namespace/>oggettoBeniStandard" name="<portlet:namespace/>oggettoBeniStandard" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-oggetto-richiesta-standard '/>"  value="<%=oggettoBeniStandard%>" readonly>
                                            </c:if></div>
                                             <div class="col-md-3">
                                                 <label for="<portlet:namespace/>dateBeniStandard" class="label-form "><liferay-ui:message key="beni-facile-consumo-data-richiesta-standard"/></label>
                                           <input type="text" class="datepicker-custom input-custom-light" placeholder="DD/MM/AAAA" value="${dataDiOggi}" readonly>
                                                 <input id="<portlet:namespace/>dateBeniStandard" type="hidden" name="<portlet:namespace/>dateBeniStandard" placeholder="DD/MM/AAAA" value="${dataOra}">                                             </div>
                                             <div class="col-md-3">
                                                 <label for="<portlet:namespace/>periodicitaBeniStandard" class="label-form"><liferay-ui:message key="beni-facile-consumo-periodicita-standard"/>*</label>
                                                 <select data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" id="<portlet:namespace/>periodicitaBeniStandard" class="option-select-notice periodicitaBeniClassStandard data-parsley-validated"  name="<portlet:namespace/>periodicitaBeniStandard">
                                                         <option value="" hidden><liferay-ui:message key="scegli-periodicita-standard"/></option>
                                                     <c:forEach items="${periodicita}" var="listPeriodicita">
                                                      <c:if test="${listPeriodicita.getId() == datiRichiestaBean.getPeriodicita()}">
                                                       <option value="${listPeriodicita.getId()}" selected>${listPeriodicita.getDescrizione()}</option>
                                                      </c:if>
                                                      <c:if test="${listPeriodicita.getId() != datiRichiestaBean.getPeriodicita()}">
                                                       <option value="${listPeriodicita.getId()}">${listPeriodicita.getDescrizione()}</option>
                                                      </c:if> </c:forEach> </select> </div></div>
                                    <div class="beniConsumoStandardDesignClass divValStandard" id="beniConsumoStandardDesign">
                                                                                                                              <c:if test="${datiSelezionatiStandard == null || datiSelezionatiStandard.size() == 0 }">
                                                                                                                                              <div class ="beniConsumoStandardClass " id="beniConsumoStandard<%=beniConsumoStandardDivId%>">
                                        <div class="wrap-content-beni">
                                             <span class="number"><%=counterBeniStandard%></span>
                                             <div class="position-button">
                                                 <button onclick="removeItemBeniConsumoStandard('#beniConsumoStandard<%=beniConsumoStandardDivId%>')" type="button" class="mt-0-xs button button-primary removebtn">
                                                     <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-facile-consumo-rimuovi-standard"/></button>
                                             </div> </div>
                                          <div class="border">
                                             <div class="ama-row">
                                                 <div class="ama-col-md-3">
                                                     <label for="selectGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-gruppo-standard"/>*</label>
                                                     <select id="selectGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="checkValStandard option-select-notice selectGruppoClassBeniStandard data-parsley-validated" onchange="getSottoGruppo(this)" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" disabled>
                                                         <option value="" hidden><liferay-ui:message key="scegli-gruppo-standard"/></option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectSottoGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-sottogruppo-standard"/>*</label>
                                                     <select id="selectSottoGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="checkValStandard option-select-notice selectSottoGruppoClassBeniStandard data-parsley-validated" onchange="getMateriale(this)" disabled="true" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                         <option value="" hidden><liferay-ui:message key="scegli-sottogruppo-standard"/></option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectMaterialeBeniStandard<%=beniConsumoStandardDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-materiale-standard"/>*</label>
                                                     <select id="selectMaterialeBeniStandard<%=beniConsumoStandardDivId%>" class="checkValStandard option-select-notice selectMaterialeClassBeniStandard data-parsley-validated" disabled="true" data-parsley-required="true"  data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" onchange="searchMateriale(this)">
                                                         <option value="" hidden><liferay-ui:message key="scegli-materiale-standard"/></option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="argument6" class="label-form">QUANTIT&#192;&#42;</label>
                                                   <input type="number" id="inputQuantitaBeniStandard<%=beniConsumoStandardDivId%>" data-parsley-required="true" class="checkValStandard input-custom-light input-quant inputQuantitaClassBeniStandard data-parsley-validated" value="0" onchange="costo(this)" data-parsley-range="[1, 99999999]" data-parsley-range-message="<liferay-ui:message key="error-range-quantita"/>" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                 </div> </div>  </div>
                                     <div class="border wrapper-text">
                                         <p><liferay-ui:message key="beni-facile-consumo-costo-unitario-standard"/>:
                                             <span class="price priceClassStandard" id="priceStandard<%=beniConsumoStandardDivId%>"> 0.00&#x20AC; </span>
                                         </p>
                                          <input type="hidden" id="costoUnitarioBeniStandard<%=beniConsumoStandardDivId%>" class="costoUnitarioBeniClassStandard" value="0.00">
                                     </div>
                                    </div>
                                    </c:if>
                                    <c:if test="${datiSelezionatiStandard != null && datiSelezionatiStandard.size() > 0 }">
                                                                                                                                             <%counterBeniStandard = 0;%>
                                                                                                                                             <%beniConsumoStandardDivId = 0;%>
                                                                                                                                             <c:forEach items="${datiSelezionatiStandard}" var="listDatiSelezionatiStandard">
                                                                                                                                              <%counterBeniStandard++;%>
                                      <%beniConsumoStandardDivId++;%>
                                                                                                                                                <div class ="beniConsumoStandardClass" id="beniConsumoStandard<%=beniConsumoStandardDivId%>">
                                         <div class="wrap-content-beni">
                                             <span class="number"><%=counterBeniStandard%></span>
                                             <div class="position-button">
                                                 <button onclick="removeItemBeniConsumoStandard('#beniConsumoStandard<%=beniConsumoStandardDivId%>')" type="button" class="mt-0-xs button button-primary removebtn">
                                                     <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-facile-consumo-rimuovi-standard"/></button>
                                             </div>
                                         </div>
                                         <div class="border">
                                             <div class="ama-row">
                                                 <div class="ama-col-md-3">
                                                     <label for="selectGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-gruppo-standard"/>*</label>
                                                    <select id="selectGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="checkValStandard option-select-notice selectGruppoClassBeniStandard data-parsley-validated" onchange="getSottoGruppo(this)" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                    <c:forEach items="${servizioMateriale}" var="listServizioMateriale">
                                                     <c:if test="${listServizioMateriale.getGruppo() == listDatiSelezionatiStandard.getGruppo() }"><option value="${listServizioMateriale.getGruppo() }" selected hidden>${listServizioMateriale.getDescrizione()}</option></c:if></c:forEach></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectSottoGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-sottogruppo-standard"/>*</label>
                                                     <select id="selectSottoGruppoBeniStandard<%=beniConsumoStandardDivId%>" class="checkValStandard option-select-notice selectSottoGruppoClassBeniStandard data-parsley-validated" onchange="getMateriale(this)" disabled="true" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"><option value="${listDatiSelezionatiStandard.getSottoGruppo()}" selected hidden>${listDatiSelezionatiStandard.getSottoGruppoDescrizione()}</option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectMaterialeBeniStandard<%=beniConsumoStandardDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-materiale-standard"/>*</label>
                                                     <select id="selectMaterialeBeniStandard<%=beniConsumoStandardDivId%>" 
                                                         class="checkValStandard option-select-notice selectMaterialeClassBeniStandard data-parsley-validated" disabled="true" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" onchange="searchMateriale(this)"><option value="${listDatiSelezionatiStandard.getMateriale()}" selected hidden>${listDatiSelezionatiStandard.getMaterialeDescrizione()}</option> </select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="argument6" class="label-form">QUANTIT&#192;&#42;</label>
                                                   <input type="number" id="inputQuantitaBeniStandard<%=beniConsumoStandardDivId%>" class="checkValStandard input-custom-light input-quant inputQuantitaClassBeniStandard data-parsley-validated" data-parsley-required="true" value="${listDatiSelezionatiStandard.getQuantita()}" onchange="costo(this)" data-parsley-range="[1, 99999999]" data-parsley-range-message="<liferay-ui:message key="error-range-quantita"/>" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                 </div></div>
                                         </div>
                                     <div class="border wrapper-text">
                                         <p><liferay-ui:message key="beni-facile-consumo-costo-unitario-standard"/>:
                                             <span class="price priceClassStandard" id="priceStandard<%=beniConsumoStandardDivId%>"> ${listDatiSelezionatiStandard.getCostoUnitario()}&#x20AC; </span>
                                         </p>
                                          <input type="hidden" id="costoUnitarioBeniStandard<%=beniConsumoStandardDivId%>" class="costoUnitarioBeniClassStandard" value="${listDatiSelezionatiStandard.getCostoUnitario()}">
                                      <input type="hidden" id="prezzoStandard${listDatiSelezionatiStandard.getMateriale()}" class="prezzoStandardClass" value="${listDatiSelezionatiStandard.getInputValue()}">
                                   <input type="hidden" id="disponibilitaStandard${listDatiSelezionatiStandard.getMateriale()}" class="disponbilitaStandardClass" value="${listDatiSelezionatiStandard.getDisponibilita()}">
                                    <input type="hidden" name="<portlet:namespace/>inputPrezzoMedioHidden" id="inputPrezzoMedioHidden" class="inputPrezzoMedioHiddenClass" value="${listDatiSelezionatiStandard.getInputValue()}">
                                     </div>
                                    </div></c:forEach></c:if>
                                   </div>
                                    <div class="mt-30-xs mb-30-xs">
                                         <button type="button" class=" button button-primary" id="<portlet:namespace/>beniConsumoStandardAggiungiBtn"><liferay-ui:message key="beni-facile-consumo-aggiungi-bene-acquisto-standard"/><span class="icomoon-plus icon ml-10-xs"></span></button>
                                     </div>
                                     <c:if test="${datiSelezionatiStandard == null || datiSelezionatiStandard.size() == 0 }">
                                     <div class="border wrapper-text bc-color"><p><liferay-ui:message key="beni-facile-consumo-costo-totale-standard"/>:<span class="price priceTotaleStandard"> 0.00&#x20AC; </span> </p>
                             <input type="hidden" id="costoTotaleBeniStandard" name="<portlet:namespace/>costoTotaleBeniStandard" class="costoTotaleBeniClassStandard" value="0.00">
                                     </div></c:if>
                                     <c:if test="${datiSelezionatiStandard != null && datiSelezionatiStandard.size() > 0 }">
                                     <div class="border wrapper-text bc-color"><p><liferay-ui:message key="beni-facile-consumo-costo-totale-standard"/>:<span class="price priceTotaleStandard"> ${datiRichiestaBean.getCostoTotale()}&#x20AC; </span></p>
                             <input type="hidden" id="costoTotaleBeniStandard" name="<portlet:namespace/>costoTotaleBeniStandard" class="costoTotaleBeniClassStandard" value="${datiRichiestaBean.getCostoTotale()}">
                                     </div> </c:if>
                                     <c:if test="${datiSelezionatiStandard != null && datiSelezionatiStandard.size() > 0}">
                                        <div class="ama-row">
                                             <div class="ama-col-md-12 ama-col-xs-12">
                                                 <div class="wrapper-content-textarea mt-50-xs">
                                                     <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="beni-facile-consumo-descrizione-standard"/></label>
                                                     <textarea class="form-control textarea-custom-light" id="<portlet:namespace/>descrizioneBeniStandard" name="<portlet:namespace/>descrizioneBeniStandard" placeholder="<liferay-ui:message key='placeholder-descrizione'/>">${datiRichiestaBean.getDescrizione()}</textarea>
                                                     <div class="content-textarea">${datiRichiestaBean.getDescrizione().length()}/
                                                         <p class="color-gray">500</p>
                                                     </div>
                                                 </div></div></div></c:if>
                                         <c:if test="${datiSelezionatiStandard == null || datiSelezionatiStandard.size() == 0}">
                                        <div class="ama-row">
                                             <div class="ama-col-md-12 ama-col-xs-12">
                                                 <div class="wrapper-content-textarea mt-50-xs">
                                                     <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="beni-facile-consumo-descrizione-standard"/></label>
                                                     <textarea class="form-control textarea-custom-light" id="<portlet:namespace/>descrizioneBeniStandard" name="<portlet:namespace/>descrizioneBeniStandard" placeholder="<liferay-ui:message key='placeholder-descrizione'/>"></textarea>
                                                     <div class="content-textarea">0/
                                                         <p class="color-gray">500</p>
                                                     </div>
                                                 </div></div></div></c:if> </form></div></div></div>
                                   <form enctype="multipart/form-data"><input type="text" style="display:none" id="<portlet:namespace/>inputBeniRichiestaStandard" name="<portlet:namespace/>inputBeniRichiestaStandard" data-parsley-required="true" data-parsley-required-message="Inserire almeno un bene alla richiesta" class="data-parsley-validated" /> 
                      </form></div></div>
                    <div id="technology" class="collapse">
                         <div class="wrapper-tab-beni-consumo ">
                             <div class="box-gray no-margin">
                                 <div class="box-white box-gray-mobile">
                                     <form enctype="multipart/form-data">
								<div class="ama-row mb-30-xs">
						            <div class="ama-col-md-6 ama-col-xs-12">
						                <label for="sede" class="label-form margin-top"><liferay-ui:message key="beni-facili-consumo-sede"/>*</label>
						                <select data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" class="option-select selectSedeClass data-parsley-validated" id="<portlet:namespace/>selectSedeBeniInfo" onchange="onChangeSede()"> 
						                    <option value="" hidden=""><liferay-ui:message key="beni-facili-consumo-select-sede"/></option>
						                    <c:forEach items="${sediBfcBeniInformatici}" var="itemsListSede">
						                    <c:choose><c:when test="${itemsListSede.getId_sede_geco() == richiedente.getSede() && tipoBeni == 'beniInformatica'}">
						                    <option selected value="${itemsListSede.getId_sede_geco()};${itemsListSede.getCodice_geco()}">${itemsListSede.getNomeLoc()}</option>
						                    </c:when><c:otherwise><option value="${itemsListSede.getId_sede_geco()};${itemsListSede.getCodice_geco()}">${itemsListSede.getNomeLoc()}</option>
						                    </c:otherwise></c:choose>
						                    </c:forEach>
						                </select>
						            </div></div>
                                         <div class="ama-row">
                                             <div class="col-md-6">
                                                 <label for="<portlet:namespace/>oggettoBeniInformatica" class="label-form "><liferay-ui:message key="beni-facile-consumo-oggetto-informatica"/></label>
                                                 <input id="<portlet:namespace/>oggettoBeniInformatica" name="<portlet:namespace/>oggettoBeniInformatica" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-oggetto-richiesta-informatica'/>" value="<%=oggettoBeniInformatica%>">
                                             </div>
                                             <div class="col-md-3">
                                                 <label for="<portlet:namespace/>dateBeniInformatica" class="label-form "><liferay-ui:message key="beni-facile-consumo-data-richiesta-informatica"/></label>
                                                 <input type="text" class="datepicker-custom input-custom-light" placeholder="DD/MM/AAAA" value="${dataDiOggi}" readonly>
                                                <input type="hidden" id="<portlet:namespace/>dateBeniInformatica"  name="<portlet:namespace/>dateBeniInformatica" placeholder="DD/MM/AAAA" value="${dataOra}" readonly>
                                             </div>
                                             <c:if test="${datiSelezionatiInformatica == null || datiSelezionatiInformatica.size() == 0}">
                                             <div class="col-md-3">
                                                 <label for="<portlet:namespace/>numeroInventarioMacchina" class="label-form"><liferay-ui:message key="beni-facile-consumo-numero-macchina"/>*</label>
                                                <input id="<portlet:namespace/>numeroInventarioMacchina" type="text" name="<portlet:namespace/>numeroInventarioMacchina" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-beni-facile-consumo-numero-macchina'/>" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" >
                                             </div></c:if>
                                              <c:if test="${datiSelezionatiInformatica != null && datiSelezionatiInformatica.size() > 0}">
                                             <div class="col-md-3">
                                                 <label for="<portlet:namespace/>numeroInventarioMacchina" class="label-form"><liferay-ui:message key="beni-facile-consumo-numero-macchina"/>*</label>
                                                <input id="<portlet:namespace/>numeroInventarioMacchina" type="text" name="<portlet:namespace/>numeroInventarioMacchina" class="input-custom-light" placeholder="<liferay-ui:message key='placeholder-beni-facile-consumo-numero-macchina'/>" value="${datiRichiestaBean.getNumeroInventarioMacchina()}" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" >
                                             </div></c:if></div>
                                    <div class="beniConsumoInformaticaDesignClass divValInfo" id="beniConsumoInformaticaDesign">
                                                                                                                              <c:if test="${datiSelezionatiInformatica == null || datiSelezionatiInformatica.size() == 0}">
                                                                                                                                              <div class ="beniConsumoInformaticaClass" id="beniConsumoInformatica<%=beniConsumoInformaticaDivId%>">
                                         <div class="wrap-content-beni">
                                             <span class="number"><%=counterBeniInformatica%></span>
                                             <div class="position-button">
                                                 <button onclick="removeItemBeniConsumoInformatica('#beniConsumoInformatica<%=beniConsumoInformaticaDivId%>')" type="button" class="mt-0-xs button button-primary removebtn"><span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-facile-consumo-rimuovi-informatica"/></button>
                                             </div>
                                         </div>
                                         <div class="border">
                                             <div class="ama-row ">
                                                 <div class="ama-col-md-3">
                                                     <label for="selectGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-gruppo-informatica"/>*</label>
                                                     <select id="selectGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="option-select-notice selectGruppoClassBeniInformatica data-parsley-validated" onchange="getSottoGruppo(this)" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" disabled>
                                                         <option value="" hidden><liferay-ui:message key="scegli-gruppo-informatica"/></option>
                                                      </select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectSottoGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-sottogruppo-informatica"/>*</label>
                                                     <select id="selectSottoGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="checkValInfo option-select-notice selectSottoGruppoClassBeniInformatica data-parsley-validated" onchange="getMateriale(this)" disabled="true" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" ><option value="" hidden><liferay-ui:message key="scegli-sottogruppo-informatica"/></option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectMaterialeBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-materiale-informatica"/>*</label>
                                                     <select data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" id="selectMaterialeBeniInformatica<%=beniConsumoInformaticaDivId%>" class="checkValInfo option-select-notice selectMaterialeClassBeniInformatica data-parsley-validated" disabled="true" onchange="searchMateriale(this)"><option value="" hidden><liferay-ui:message key="scegli-materiale-informatica"/></option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectQuantitaBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form">QUANTIT&#192;&#42;</label>
                                                     <input type="number" id="inputQuantitaBeniInformatica<%=beniConsumoInformaticaDivId%>" class="checkValInfo input-custom-light input-quant inputQuantitaClassBeniInformatica data-parsley-validated" data-parsley-required="true" value="0" onchange="costo(this)" data-parsley-range="[1, 99999999]" data-parsley-range-message="<liferay-ui:message key="error-range-quantita"/>" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                </div></div></div>
                                     <div class="border wrapper-text">
                                         <p><liferay-ui:message key="beni-facile-consumo-costo-unitario-informatica"/>:
                                             <span class="price priceClassInformatica" id="priceInformatica<%=beniConsumoInformaticaDivId%>"> 0.00&#x20AC;</span>
                                         </p><input type="hidden" id="costoUnitarioBeniInformatica<%=beniConsumoInformaticaDivId%>" class="costoUnitarioBeniClassInformatica" value="0.00">
                                     </div></div></c:if>
                                                                                                                                              <c:if test="${datiSelezionatiInformatica != null && datiSelezionatiInformatica.size() > 0}">
                                    <%beniConsumoInformaticaDivId = 0;%>
                                    <%counterBeniInformatica = 0;%>
                                    <c:forEach items="${datiSelezionatiInformatica}" var="itemListGruppoInformatica">
                                                                                                                                             <%beniConsumoInformaticaDivId++;%>
                                    <%counterBeniInformatica++;%>
                                                                                                                                                <div class ="beniConsumoInformaticaClass" id="beniConsumoInformatica<%=beniConsumoInformaticaDivId%>">
                                         <div class="wrap-content-beni">
                                             <span class="number"><%=counterBeniInformatica%></span>
                                             <div class="position-button">
                                                 <button onclick="removeItemBeniConsumoInformatica('#beniConsumoInformatica<%=beniConsumoInformaticaDivId%>')" type="button" class="mt-0-xs button button-primary removebtn">
                                                     <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-facile-consumo-rimuovi-informatica"/></button></div></div>
                                         <div class="border">
                                             <div class="ama-row">
                                                 <div class="ama-col-md-3">
                                                     <label for="selectGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-gruppo-informatica"/>*</label>
                                                     <select id="selectGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="checkValInfo option-select-notice selectGruppoClassBeniInformatica data-parsley-validated" onchange="getSottoGruppo(this)" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                        <c:forEach items="${servizioMateriale}" var="listServizioMateriale"><c:if test="${listServizioMateriale.getGruppo() == itemListGruppoInformatica.getGruppo() }"><option value="${listServizioMateriale.getGruppo() }" selected hidden>${listServizioMateriale.getDescrizione()}</option>
                                                         </c:if></c:forEach></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectSottoGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-sottogruppo-informatica"/>*</label>
                                                     <select id="selectSottoGruppoBeniInformatica<%=beniConsumoInformaticaDivId%>" class="checkValInfo option-select-notice selectSottoGruppoClassBeniInformatica data-parsley-validated" onchange="getMateriale(this)" disabled="true" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                          <option value="${itemListGruppoInformatica.getSottoGruppo()}" selected hidden>${itemListGruppoInformatica.getSottoGruppoDescrizione()}</option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectMaterialeBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form"><liferay-ui:message key="beni-facile-consumo-materiale-informatica"/>*</label>
                                                     <select id="selectMaterialeBeniInformatica<%=beniConsumoInformaticaDivId%>" class="checkValInfo option-select-notice selectMaterialeClassBeniInformatica data-parsley-validated" disabled="true" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" onchange="searchMateriale(this)"><option value="${itemListGruppoInformatica.getMateriale()}" selected hidden>${itemListGruppoInformatica.getMaterialeDescrizione()}</option></select>
                                                 </div>
                                                 <div class="ama-col-md-3">
                                                     <label for="selectQuantitaBeniInformatica<%=beniConsumoInformaticaDivId%>" class="label-form">QUANTIT&#192;&#42;</label>
                                                     <input type="number" id="inputQuantitaBeniInformatica<%=beniConsumoInformaticaDivId%>" class="checkValInfo input-custom-light input-quant inputQuantitaClassBeniInformatica data-parsley-validated" data-parsley-required="true" value="${itemListGruppoInformatica.getQuantita()}" onchange="costo(this)" data-parsley-range="[1, 99999999]" data-parsley-range-message="<liferay-ui:message key="error-range-quantita"/>" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                </div></div></div>
                                     <div class="border wrapper-text">
                                         <p><liferay-ui:message key="beni-facile-consumo-costo-unitario-informatica"/>:<span class="price priceClassInformatica" id="priceInformatica<%=beniConsumoInformaticaDivId%>"> ${itemListGruppoInformatica.getCostoUnitario()}&#x20AC; </span></p>
                                         <input type="hidden" id="costoUnitarioBeniInformatica<%=beniConsumoInformaticaDivId%>" class="costoUnitarioBeniClassInformatica" value="${itemListGruppoInformatica.getCostoUnitario()}" >
                                     <input type="hidden" id="prezzoInformatica${itemListGruppoInformatica.getMateriale()}" value="${itemListGruppoInformatica.getInputValue()}" class="prezzoInformaticaClass">
                                    <input type="hidden" id="disponibilitaInformatica${itemListGruppoInformatica.getMateriale()}" value="${itemListGruppoInformatica.getDisponibilita()}" class="disponbilitaInformaticaClass">
                                    <input type="hidden" name="<portlet:namespace/>inputPrezzoMedioHidden" id="inputPrezzoMedioHidden" class="inputPrezzoMedioHiddenInformaticaClass" value="${itemListGruppoInformatica.getInputValue()}"></div>  
                                    </div></c:forEach></c:if></div> 
                                     <div class="mt-30-xs mb-30-xs">
                                         <button type="button" class=" button button-primary" id="<portlet:namespace/>beniConsumoInformaticaAggiungiBtn"><liferay-ui:message key="beni-facile-consumo-aggiungi-bene-acquisto-informatica"/><span class="icomoon-plus icon ml-10-xs"></span></button>
                                    </div>
                                    <c:if test="${listGruppoInformatica != null && listGruppoInformatica.size() > 0}"> 
                                     <div class="border wrapper-text bc-color">
                                         <p><liferay-ui:message key="beni-facile-consumo-costo-totale-informatica"/>: <span class="price priceTotaleInformatica"> ${datiRichiestaBean.getCostoTotale()}&#x20AC;</span></p><input type="hidden" id="costoTotaleBeniInformatica" name="<portlet:namespace/>costoTotaleBeniInformatica" class="costoTotaleBeniClassInformatica" value="${datiRichiestaBean.getCostoTotale()}">
                                     </div>
                                     </c:if>
                                     <c:if test="${listGruppoInformatica == null || listGruppoInformatica.size() == 0}">
                                     <div class="border wrapper-text bc-color"><p><liferay-ui:message key="beni-facile-consumo-costo-totale-informatica"/>:<span class="price priceTotaleInformatica"> 0.00&#x20AC;</span></p><input type="hidden" id="costoTotaleBeniInformatica" name="<portlet:namespace/>costoTotaleBeniInformatica" class="costoTotaleBeniClassInformatica" value="0.00">
                                     </div>
                                     </c:if>
                                     <c:if test="${empty listGruppoInformatica}">
                                        <div class="ama-row">
                                             <div class="ama-col-md-12 ama-col-xs-12">
                                                 <div class="wrapper-content-textarea mt-50-xs">
                                                     <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="beni-facile-consumo-descrizione-informatica"/></label>
                                                     <textarea class="form-control textarea-custom-light" name="<portlet:namespace/>descrizioneBeniInformatica" id="<portlet:namespace/>descrizioneBeniInformatica" placeholder="<liferay-ui:message key='placeholder-descrizione-informatica'/>"></textarea>
                                                     <div class="content-textarea">0/
                                                         <p class="color-gray">500</p>
                                                     </div> </div>  </div>   </div>
                                                     </c:if> <c:if test="${not empty listGruppoInformatica}">
                                         <div class="ama-row">
                                             <div class="ama-col-md-12 ama-col-xs-12">
                                                 <div class="wrapper-content-textarea mt-50-xs">
                                                     <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="beni-facile-consumo-descrizione-informatica"/></label>
                                                     <textarea class="form-control textarea-custom-light" name="<portlet:namespace/>descrizioneBeniInformatica" id="<portlet:namespace/>descrizioneBeniInformatica" placeholder="<liferay-ui:message key='placeholder-descrizione-informatica'/>">${datiRichiestaBean.getDescrizione()}</textarea>
                                                     <div class="content-textarea">${datiRichiestaBean.getDescrizione().length()}/
                                                         <p class="color-gray">500</p>
                                                     </div></div></div> </div></c:if></form></div></div></div>
                                                     <form enctype="multipart/form-data">
                                                     <input type="text" style="display:none" id="<portlet:namespace/>inputBeniRichiestaInfo" name="<portlet:namespace/>inputBeniRichiestaInfo" data-parsley-required="true" data-parsley-required-message="Inserire almeno un bene alla richiesta" class="data-parsley-validated" /> </form>
                                                  </div></div></div></div></div>
       <c:if test="${dirigente == 0}">
         <div class="ama-row">
             <div class="ama-col-xs-12 text-center mb-20-xs mb-100-sm mt-20-xs mt-50-sm">
                 <button id="proseguiBeniConsumoBtn" class="button button-primary buttonForm"><liferay-ui:message key="beni-facile-consumo-prosegui"/></button>
             </div> </div> </c:if><c:if test="${dirigente == 1}">
         <div class="ama-row">
             <div class="ama-col-xs-12 text-center mb-20-xs mb-100-sm mt-20-xs mt-50-sm">
                 <button id="modificaBeniConsumoBtn" class="button button-primary buttonForm"><liferay-ui:message key="beni-facile-consumo-prosegui"/></button>
             </div></div></c:if>     
<div class="beniConsumoStandardNone" style="display:none">
  <div class="wrap-content-beni">
   <span class="number"></span>
     <div class="position-button">
       <button type="button" class="mt-0-xs button button-primary removebtn">
         <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-facile-consumo-rimuovi-standard"/></button>
     </div> </div>
        <div class="border">
          <div class="ama-row">
            <div class="ama-col-md-3">
              <label for="selectGruppo" class="label-form"><liferay-ui:message key="beni-facile-consumo-gruppo-standard"/></label>
                <select class="checkValStandard option-select-notice selectGruppoClassBeniStandard data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"><option value="" hidden><liferay-ui:message key="scegli-gruppo-standard"/></option></select>
           </div>
             <div class="ama-col-md-3">
              <label for="selectSottoGruppo" class="label-form"><liferay-ui:message key="beni-facile-consumo-sottogruppo-standard"/>*</label>
               <select class="checkValStandard option-select-notice selectSottoGruppoClassBeniStandard data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" disabled><option value="" hidden><liferay-ui:message key="scegli-sottogruppo-standard"/></option></select>
            </div>
              <div class="ama-col-md-3">
               <label for="argument5" class="label-form"><liferay-ui:message key="beni-facile-consumo-materiale-standard"/>*</label>
                <select id="argument5" class="checkValStandard option-select-notice selectMaterialeClassBeniStandard data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" onchange="searchMateriale(this)" disabled><option value="" hidden><liferay-ui:message key="scegli-materiale-standard"/></option> </select>
               </div>
                 <div class="ama-col-md-3">
                  <label for="argument6" class="label-form">QUANTIT&#192;&#42;</label>
                   <input type="number" id="argument6" class="checkValStandard input-custom-light input-quant inputQuantitaClassBeniStandard data-parsley-validated" data-parsley-required="true" value="0" data-parsley-range="[1, 99999999]" data-parsley-range-message="<liferay-ui:message key="error-range-quantita"/>" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                </div> </div></div>
           <div class="border wrapper-text">
           <p><liferay-ui:message key="beni-facile-consumo-costo-unitario-standard"/>:<span class="price priceClassStandard"> 0.00&#x20AC;</span></p> <input type="hidden" id="argument6" class="input-custom-light input-quant  costoUnitarioBeniClassStandard" value="0.00"></div></div>     
  <div class="beniConsumoInformaticoNone" style="display:none" >
    <div class="wrap-content-beni">
      <span class="number"></span>
         <div class="position-button">
           <button type="button" class="mt-0-xs button button-primary removebtn"><span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-facile-consumo-rimuovi-informatica"/></button></div> </div>
                   <form enctype="multipart/form-data"><div class="border"><div class="ama-row">
                          <div class="ama-col-md-3"> 
                             <label for="argument3" class="label-form"><liferay-ui:message key="beni-facile-consumo-gruppo-informatica"/>*</label>
                                <select id="argument3" class="checkValInfo option-select-notice selectGruppoClassBeniInformatica data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"><option value="" hidden><liferay-ui:message key="scegli-gruppo-informatica"/></option></select></div><div class="ama-col-md-3">
                               <label for="argument4" class="label-form"><liferay-ui:message key="beni-facile-consumo-sottogruppo-informatica"/>*</label>
                                 <select id="argument4" class="checkValInfo option-select-notice selectSottoGruppoClassBeniInformatica data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" disabled><option value="" hidden><liferay-ui:message key="scegli-sottogruppo-informatica"/></option></select>
                              </div>
                                <div class="ama-col-md-3">
                                                                                                                               <label for="argument5" class="label-form"><liferay-ui:message key="beni-facile-consumo-materiale-informatica"/>*</label>
                                                                                                                                              <select id="argument5" class="checkValInfo option-select-notice selectMaterialeClassBeniInformatica data-parsley-validated"  data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" onchange="searchMateriale(this)" disabled><option value="" hidden><liferay-ui:message key="scegli-materiale-informatica"/></option></select>
                                                                                                                               </div>
                                                                                                                               <div class="ama-col-md-3">
                                                                                                                                             <label for="argument6" class="label-form">QUANTIT&#192;&#42;</label>
                                                                                                                                              <input type="number" id="argument6" class="checkValInfo input-custom-light input-quant inputQuantitaClassBeniInformatica data-parsley-validated" data-parsley-required="true" value="0" data-parsley-range="[1, 99999999]" data-parsley-range-message="<liferay-ui:message key="error-range-quantita"/>" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                                                                                               </div> </div> </div></form><div class="border wrapper-text">
                                                                                                               <p><liferay-ui:message key="beni-facile-consumo-costo-unitario-informatica"/>:
                                                                                                 <span class="price priceClassInformatica"> 0.00&#x20AC;</span> </p><input type="hidden" id="argument6" class="input-custom-light input-quant costoUnitarioBeniClassInformatica" value="0.00">
                                                                                                </div></div>
                                                                                                  <div id="modal-change-tab" class="modal modal-custom fade modal-icon-page" role="dialog"> 
								<div class="modal-dialog"><div class="modal-content"><div class="modal-body"><div class="modal-title-box"> 
								<a href="#" class="icomoon-close-white" data-dismiss="modal"></a><div class="title-modal"><h2 class="title titlePopUp"><liferay-ui:message key="beni-facili-consumi-modale-titolo"/></h2></div> 
								</div><h2 class="text textPopUp"><liferay-ui:message key="beni-facili-consumi-modale-sottitolo"/></h2><div class="ama-row mb-50-xs buttons-bottom"> 
							</div></div></div></div></div>
							
							<div id="modal-change-tab-Materiale" class="modal modal-custom fade modal-icon-page" role="dialog"> 
								<div class="modal-dialog"><div class="modal-content"><div class="modal-body"><div class="modal-title-box"> 
								<a href="#" class="icomoon-close-white" data-dismiss="modal"></a><div class="title-modal"><h2 class="title"><liferay-ui:message key="beni-facili-consumi-modale-titolo-materiale"/></h2></div> 
								</div><h2 class="text"><liferay-ui:message key="beni-facili-consumi-modale-sottitolo-materiale"/></h2><div class="ama-row mb-50-xs buttons-bottom"> 
							</div></div></div></div></div>
 <script type="text/javascript">
  	var countCheckValidStandard=0;
    var countCheckValidInfo=0;
    var disponibilitaMateriale;
                var beniConsumoStandardNoneDesign = $(".beniConsumoStandardNone").html();
                var beniConsumoInformaticoNoneDesign = $(".beniConsumoInformaticoNone").html();
                var beniConsumoStandardDivId = "<%=beniConsumoStandardDivId%>";
                var beniConsumoInformaticaDivId = "<%=beniConsumoInformaticaDivId%>";
                var beniConsumoStandardCounter = "<%=counterBeniStandard%>";
                var beniConsumoInformaticaCounter = "<%=counterBeniInformatica%>";
                var tipoBeni = "<%=tipoBeni%>";
                var dirigente = "<%=dirigente%>";
                var array = [];
                var itemBeniStandard = {};
                var itemBeniInformatica = {};
                jsonObj = {};
                var optionsInformatica  =  '';
                var optionsStandard =  '';
                var selectGruppoBeniStandardId;
                var selectGruppoBeniInformaticaId;
                var counterInformatica = beniConsumoInformaticaDivId;
                var counterStandard = 1;
                var codiceGruppo;
                var tipoMateriale = "0";
                var codiceUfficio = '<%=codiceGeco%>';
                var listCodes = '<%=listaUfficiGeco%>'; 
                var ambiente = '<%=ambienteGecoPigreco%>';
                var inputServizio = "pigreco";
                var arrayMateriale = [];
                var sommaCostoUnitario;
                var arrayDatiSelezionatiStandard =[];
                var arrayDatiSelezionatiInformatica=[];
                var selectSottoGruppoRest = null;
                var selectMaterialeReset = null; 
                var inputName = "";
                if(tipoBeni == "beniInformatica"){
                	$("#technology").attr("class","collapse in");
                	$("#<portlet:namespace/>beniInformaticaTab").attr("class","tab-title active");
                	$("#standard").attr("class","collapse");
                	$("#<portlet:namespace/>beniStandardTab").attr("class","tab-title collapsed");
                	tipoMateriale = "1";
                }
                $("#mainContainer").find(".beniConsumoInformaticaClass").each(function(key,value) {
                               var beniConsumoInformaticaClassThis = this;     
                               Liferay.Service(
                                                            '/mefbfc.serviziomateriale/get-gruppi-by-categoria',
                                                            {
                                                              categoria: 'bene informatico'
                                                            },  

                                                                 function(obj) {
                                                                                 $.each(obj,function(key, value){
                                                                                                var gruppo=value.gruppo;
                                                                                                var descizione = value.descrizione;
                                                                                                optionsInformatica += '<option value="'+gruppo+'">'+descizione+'</option>';       
                                                                                 });
                                                                                 $(beniConsumoInformaticaClassThis).find(".selectGruppoClassBeniInformatica").append(optionsInformatica);             
                                                                                 optionsInformatica='';     
                                                            });});
            $("#mainContainer").find(".beniConsumoStandardClass").each(function(key,value) {
                	var beniConsumoStandardClassThis = this;
                              Liferay.Service(
                                                                 '/mefbfc.serviziomateriale/get-gruppi-by-categoria',
                                                                 {
                                                                   categoria: 'altro' 
                                                                 },          
                                                               function(obj) {
                                                                               $.each(obj,function(key, value){
                                                                                              var gruppo=value.gruppo;
                                                                                              var descizione = value.descrizione;
                                                                                              optionsStandard += '<option value="'+gruppo+'">'+descizione+'</option>';});
                                                                               
                                                                               $(beniConsumoStandardClassThis).find(".selectGruppoClassBeniStandard").append(optionsStandard);
                                                                               optionsStandard =  '';
                                                                 });
                              
                                                               }); 
             function removeItemBeniConsumoStandard(itemId){    
                               var inputId = 1;
                               var costoTotaleInput = 0;
                               $(itemId).remove();
                               beniConsumoStandardCounter--;
                               var countNumber=1;    
                               $('div[id^="beniConsumoStandard"]').find('.number').each(function(key,value) {
                                                               $(this).html(countNumber);
                                                               countNumber++;});
                               $("#mainContainer").find(".beniConsumoStandardClass").each(function(key,value) {
                                               var costoUnitarioInput = parseFloat($(this).find('.costoUnitarioBeniClassStandard').val());
                                               costoTotaleInput = costoTotaleInput + costoUnitarioInput;  
                                               
                                });
                               costoTotaleInput = costoTotaleInput.toFixed(2);
                              $(".priceTotaleStandard").text(costoTotaleInput+"\u20AC");
                               $(".costoTotaleBeniClassStandard").val(costoTotaleInput);
                } 
             function showDialog(){
            	$('#modal-change-tab').modal('show');}
             function showDialogMateriale(){
             	$('#modal-change-tab-Materiale').modal('show');}
             $("#okBtn").click(function(){
             	$('#modal-change-tab').modal('hide');});
             function addNewItemBene(){
                               var beniConsumoStandardDesign = beniConsumoStandardNoneDesign;
                               var divMasterBeniConsumoStandard = document.createElement("div");
                               var options;
                               beniConsumoStandardDivId++;
                               beniConsumoStandardCounter++;
                               $(divMasterBeniConsumoStandard).attr("id","beniConsumoStandard" + beniConsumoStandardDivId);
                               $(divMasterBeniConsumoStandard).addClass("beniConsumoStandardClass");
                               $(divMasterBeniConsumoStandard).append(beniConsumoStandardDesign);
                       $(divMasterBeniConsumoStandard).find(".selectGruppoClassBeniStandard").attr("id","selectGruppoBeniStandard" + beniConsumoStandardDivId);
                $(divMasterBeniConsumoStandard).find(".selectGruppoClassBeniStandard").attr("onchange","getSottoGruppo(this)");
                               Liferay.Service(
                               '/mefbfc.serviziomateriale/get-gruppi-by-categoria',
                               {
                               categoria: 'altro' 
                               },
                               function(obj) {
                               $.each(obj,function(key, value){
                                               var gruppo=value.gruppo;
                                               var descizione = value.descrizione;
                                               options += '<option value="'+gruppo+'">'+descizione+'</option>'; });
                                               $(divMasterBeniConsumoStandard).find(".selectGruppoClassBeniStandard").append(options);    });
                               $(divMasterBeniConsumoStandard).find(".selectSottoGruppoClassBeniStandard").attr("id","selectSottoGruppoBeniStandard" + beniConsumoStandardDivId);
                               $(divMasterBeniConsumoStandard).find(".selectSottoGruppoClassBeniStandard").attr("onchange","getMateriale(this)");
                               $(divMasterBeniConsumoStandard).find(".selectMaterialeClassBeniStandard").attr("id","selectMaterialeBeniStandard" + beniConsumoStandardDivId);
                                   $(divMasterBeniConsumoStandard).find(".inputQuantitaClassBeniStandard").attr("id","inputQuantitaBeniStandard" + beniConsumoStandardDivId);
                                               $(divMasterBeniConsumoStandard).find(".inputQuantitaClassBeniStandard").attr("onchange","costo(this)");
                                               $(divMasterBeniConsumoStandard).find(".priceClassStandard").attr("id","priceStandard" + beniConsumoStandardDivId);
                                     $(divMasterBeniConsumoStandard).find(".costoUnitarioBeniClassStandard").attr("id","costoUnitarioBeniStandard" + beniConsumoStandardDivId);
                                               $(divMasterBeniConsumoStandard).find(".number").html(beniConsumoStandardCounter);
                                               var count = beniConsumoStandardDivId;
                                               $(divMasterBeniConsumoStandard).find(".removebtn").each(function(){
                                                               $(this).click(function (){                                
                                                               removeItemBeniConsumoStandard("#beniConsumoStandard"+count); }); 
                                               });
                                               $("#beniConsumoStandardDesign").append(divMasterBeniConsumoStandard);}
                                               $("#<portlet:namespace/>beniConsumoStandardAggiungiBtn").click("on",function(){
                                                               countCheckValidStandardLength = $('.divValStandard').find('.checkValStandard').length;
                                                              countCheckValidStandard=0;
                                                              $('.divValStandard').find('.checkValStandard').each(function(key,value) { 
                                                              if($(this).val()=="" || $(this).val()==0){
                                                                              countCheckValidStandard++;      
                                                              }});
                                                               if(countCheckValidStandard==0){
                                                                               addNewItemBene();
                                                               }else{
                                                                              $('.divValStandard').find('.checkValStandard').each(function(key,value) { 
                                                                                              $(this).parsley().validate(); 
                                                               });           }
                                               });
                function costo(quantita){
                               var prezzoMedio = 0;
                               var costoUnitario = 0;
                               var quantitaMateriale = 0;
                               var costoTotale = 0;       
                                var costoTotaleInformatica = 0;
                               var prezzo = 0;
                               var quantitaId = quantita.id;
                               var className;
                               if(quantita.id.indexOf("inputQuantitaBeniStandard")>= 0){
                                               $("#mainContainer").find(".beniConsumoStandardClass").each(function(key,value) { 
                                                               var id = $(this).find('.selectMaterialeClassBeniStandard :selected').val();
                                                               var inputPrezzoMedio = "#prezzoStandard" + id;
                                                               if($(this).find(inputPrezzoMedio)!=null && $(this).find(inputPrezzoMedio).val()!=null && $(this).find(inputPrezzoMedio).val()!="") 
                                                               		prezzoMedio = $(this).find(inputPrezzoMedio).val();
                                                               prezzoMedio = parseFloat(prezzoMedio);
                                                               quantitaMateriale = $(this).find(".inputQuantitaClassBeniStandard").val();
                                                               costoUnitario = prezzoMedio * quantitaMateriale;
                                                               prezzo = costoUnitario;
                                                               costoTotale = costoTotale+prezzo;
                                                               costoUnitario = costoUnitario.toFixed(2);
                                                               $(this).find(".costoUnitarioBeniClassStandard").val(costoUnitario);
                                                               $(this).find(".priceClassStandard").text(costoUnitario+"\u20AC");
                                                               className  = "inputPrezzoMedioHiddenClass";
                                                               $(this).find("."+className).remove();
                                                               inputPrezzoMedioHidden = '<input type="hidden" name="<portlet:namespace/>inputPrezzoMedioHidden" id="inputPrezzoMedioHidden" class="'+className+'" value="'+prezzoMedio+'">';
                                                               $(this).append(inputPrezzoMedioHidden); });
                              costoTotale = costoTotale.toFixed(2);
                              $(".priceTotaleStandard").text(costoTotale+"\u20AC");
                               $(".costoTotaleBeniClassStandard").val(costoTotale);}
                               if(quantitaId.indexOf("inputQuantitaBeniInformatica")>= 0){
                                               $("#mainContainer").find(".beniConsumoInformaticaClass").each(function(key,value) {
                                               var id = $(this).find('.selectMaterialeClassBeniInformatica :selected').val();
                                               var inputPrezzoMedio = "#prezzoInformatica" + id;
                                               if($(this).find(inputPrezzoMedio)!=null && $(this).find(inputPrezzoMedio).val()!=null && $(this).find(inputPrezzoMedio).val()!="") 
	                                               prezzoMedio = parseFloat($(this).find(inputPrezzoMedio).val());
                                               quantitaMateriale = $(this).find(".inputQuantitaClassBeniInformatica").val();
                                               costoUnitario = prezzoMedio * quantitaMateriale;
                                               prezzo = costoUnitario;
                                               costoTotaleInformatica = costoTotaleInformatica+prezzo;
                                               costoUnitario = costoUnitario.toFixed(2);
                                               $(this).find(".costoUnitarioBeniClassInformatica").val(costoUnitario);
                                               $(this).find(".priceClassInformatica").text(costoUnitario+"\u20AC");
                                               className  = "inputPrezzoMedioHiddenInformaticaClass";
                                              $(this).find("."+className).remove();
                                              inputPrezzoMedioHidden = '<input type="hidden" name="<portlet:namespace/>inputPrezzoMedioHidden" id="inputPrezzoMedioHidden" class="'+className+'" value="'+prezzoMedio+'">';
                                              $(this).append(inputPrezzoMedioHidden);
               });
               costoTotaleInformatica = costoTotaleInformatica.toFixed(2);
                $(".priceTotaleInformatica").text(costoTotaleInformatica+"\u20AC");
                $(".costoTotaleBeniClassInformatica").val(costoTotaleInformatica);}}
               function addNewItemInfo() {
                               var beniConsumoInformaticoDesign = beniConsumoInformaticoNoneDesign;
                               var divMasterBeniConsumoInformatica = document.createElement("div");
                               var options;
                               beniConsumoInformaticaDivId++;
                               beniConsumoInformaticaCounter++;
                               $(divMasterBeniConsumoInformatica).attr("id","beniConsumoInformatica" + beniConsumoInformaticaDivId);
                               $(divMasterBeniConsumoInformatica).addClass("beniConsumoInformaticaClass");
                               $(divMasterBeniConsumoInformatica).append(beniConsumoInformaticoDesign);
                $(divMasterBeniConsumoInformatica).find(".selectGruppoClassBeniInformatica").attr("id","selectGruppoBeniInformatica" + beniConsumoInformaticaDivId);
                $(divMasterBeniConsumoInformatica).find(".selectGruppoClassBeniInformatica").attr("onchange","getSottoGruppo(this)");
                               Liferay.Service(
                                                                          '/mefbfc.serviziomateriale/get-gruppi-by-categoria',    
                                                                          {     categoria: 'bene informatico'},
                                                                               function(obj) {
                                                                                                $.each(obj,function(key, value){
                                                                                                                var gruppo=value.gruppo;
                                                                                                                var descizione = value.descrizione;
                                                                                                    options += '<option value="'+gruppo+'">'+descizione+'</option>';       
                                                                                                });
                                                                                                $(divMasterBeniConsumoInformatica).find(".selectGruppoClassBeniInformatica").append(options);         });
                               $(divMasterBeniConsumoInformatica).find(".selectSottoGruppoClassBeniInformatica").attr("id","selectSottoGruppoBeniInformatica" + beniConsumoInformaticaDivId);
                               $(divMasterBeniConsumoInformatica).find(".selectSottoGruppoClassBeniInformatica").attr("onchange","getMateriale(this)");
                               $(divMasterBeniConsumoInformatica).find(".selectMaterialeClassBeniInformatica").attr("id","selectMaterialeBeniInformatica" + beniConsumoInformaticaDivId);                                          
                               $(divMasterBeniConsumoInformatica).find(".inputQuantitaClassBeniInformatica").attr("id","inputQuantitaBeniInformatica" + beniConsumoInformaticaDivId);
                                         $(divMasterBeniConsumoInformatica).find(".inputQuantitaClassBeniInformatica").attr("onchange","costo(this)");
                                               $(divMasterBeniConsumoInformatica).find(".priceClassInformatica").attr("id","priceInformatica" + beniConsumoInformaticaDivId);
                               $(divMasterBeniConsumoInformatica).find(".costoUnitarioBeniClassInformatica").attr("id","costoUnitarioBeniInformatica" + beniConsumoInformaticaDivId);
                                               $(divMasterBeniConsumoInformatica).find(".number").html(beniConsumoInformaticaCounter);
                                               var count = beniConsumoInformaticaDivId;
                                               $(divMasterBeniConsumoInformatica).find(".removebtn").each(function(){        
                                                               $(this).click(function (){                                                               
                                                                               removeItemBeniConsumoInformatica("#beniConsumoInformatica"+count);}); 
                                               });
                                               $("#beniConsumoInformaticaDesign").append(divMasterBeniConsumoInformatica);  }
                                              $("#<portlet:namespace/>beniConsumoInformaticaAggiungiBtn").click("on",function(){
                                               countCheckValidInfoLength = $('.divValInfo').find('.checkValInfo').length;
                                               countCheckValidInfo=0;
                                               $('.divValInfo').find('.checkValInfo').each(function(key,value) { 
                                                 if($(this).val()=="" || $(this).val()==0){
                                                              countCheckValidInfo++;}});
                                               if(countCheckValidInfo==0){
                                                               addNewItemInfo(); } else{
                                                               $('.divValInfo').find('.checkValInfo').each(function(key,value) { 
                                                                                              $(this).parsley().validate(); });    
                                                               }});
                                              function checkMateriale(nomeTipoBene,selectBoxChangedValue,idRow){
                                            	 var count = 0;
                                            	  var valueOfChangedMaterial = selectBoxChangedValue;
                                            	  var idRowSelectBox = idRow;
                                            	  var arrayMateriale = [];
                                            	  var jsonMateriale = {};
                                            	  var arraySelectBox = [];
                                            	  var jsonSelectBoxLastChanged = {
                                            			  gruppo: $("#selectGruppoBeni"+nomeTipoBene+idRowSelectBox+" option:selected").text(),
                                            	  		  sottoGruppo: $("#selectSottoGruppoBeni"+nomeTipoBene+idRowSelectBox+" option:selected").text(),
                                            	  		  materiale: $("#selectMaterialeBeni"+nomeTipoBene+idRowSelectBox+" option:selected").text()
                                            	  };
                                            	  arraySelectBox.push(jsonSelectBoxLastChanged);
                                            	  $("#mainContainer").find(".beniConsumo"+nomeTipoBene+"Class").each(function(key,value) {
                                              		jsonMateriale = {
                                              			gruppo:	$(this).find(".selectGruppoClassBeni"+nomeTipoBene+" option:selected").text(),
                                              			sottoGruppo:$(this).find(".selectSottoGruppoClassBeni"+nomeTipoBene+" option:selected").text(),
                                              			materiale:$(this).find(".selectMaterialeClassBeni"+nomeTipoBene+" option:selected").text()
                                              		};
                                              		  arrayMateriale.push(jsonMateriale);
                                            	  });
                                              	for(i = 0; i<arrayMateriale.length;i++){
                                              		for(j = 0;j<arraySelectBox.length;j++){
                                              		if(arraySelectBox[j].gruppo === arrayMateriale[i].gruppo && arraySelectBox[j].sottoGruppo === arrayMateriale[i].sottoGruppo
                                              		&& arraySelectBox[j].materiale === arrayMateriale[i].materiale){
                                              			count++;
                                              		}
                                              	  }
                                              	}		
                                              return count;
											}
                                              
                                              function searchMateriale(idMateriale){ 
                                              	var valueOfSelectBoxChanged = "";
                                              	var idNumero = "";
                                              	var idRow = 0;
                                              	if(idMateriale.id.indexOf("selectMaterialeBeniInformatica")>=0){
                                              	idNumero = idMateriale.id.split("selectMaterialeBeniInformatica").pop();
                                              	idRow =idNumero;
                                              	idNumero = "#beniConsumoInformatica"+idNumero;
                                              	valueOfSelectBoxChanged = $("#"+idMateriale.id+" option:selected").text();
                                              	var checkNumeroMaterialeInformatica = 0; 
                                                  checkNumeroMaterialeInformatica = checkMateriale("Informatica",valueOfSelectBoxChanged,idRow);
                                                  checkMaterialeDoppioni(checkNumeroMaterialeInformatica,idNumero);
                                                  }else{
                                                idNumero = idMateriale.id.split("selectMaterialeBeniStandard").pop();
                                                idRow =idNumero;
                                                idNumero = "#beniConsumoStandard"+idNumero;
                                                valueOfSelectBoxChanged = $("#"+idMateriale.id+" option:selected").text();
                                              	var checkNumeroMaterialeStandard = 0; 
                                                  checkNumeroMaterialeStandard = checkMateriale("Standard",valueOfSelectBoxChanged,idRow);
                                                  checkMaterialeDoppioni(checkNumeroMaterialeStandard,idNumero);
                                                  }
                                                  }
                                              
                                              
                                              function checkMaterialeDoppioni(resultCheckMateriale,nameRemoveDiv){
                                              	var checkNumeroMateriale = resultCheckMateriale;
                                              	var idDiv = nameRemoveDiv;
                                              	if(checkNumeroMateriale > 1){
                                              		if(idDiv.indexOf("beniConsumoStandard")>=0){
                                              		removeItemBeniConsumoStandard(idDiv);}
                                              		else{
                                              		removeItemBeniConsumoInformatica(idDiv);}
                                                  	showDialogMateriale();
                                                  }
                                              	
                                              }
                                               
function removeItemBeniConsumoInformatica(itemId){
                var inputId = 1;
                var costoTotaleInput = 0;
                $(itemId).remove();
                beniConsumoInformaticaCounter--;
                var countnumberInformatica=1;
                $('div[id^="beniConsumoInformatica"]').find('.number').each(function(key,value) {
                $(this).html(countnumberInformatica);
                countnumberInformatica++;});
                $("#mainContainer").find(".beniConsumoInformaticaClass").each(function(key,value) {
                var input = "#costoUnitarioBeniInformatica" + inputId; 
                var costoUnitarioInput = parseFloat($(this).find(".costoUnitarioBeniClassInformatica").val());
                costoTotaleInput = costoTotaleInput + costoUnitarioInput;});
                costoTotaleInput = costoTotaleInput.toFixed(2);
                $(".priceTotaleInformatica").text(costoTotaleInput+"\u20AC");
                $(".costoTotaleBeniClassInformatica").val(costoTotaleInput);}
                $("#<portlet:namespace/>beniStandardTab").click("on",function(){
                tipoMateriale = "0";}); 
                $("#<portlet:namespace/>beniInformaticaTab").click("on",function(){
                tipoMateriale = "1";});   
function getSottoGruppo(gruppo){
                var id;
                var selectSottoGruppo = null;
                var selectMaterialeRest;
                var selectQuantitaRest;
                var costoUnitarioRest;
                var costoTotaleRest;
                var costoTotale = 0.00;
                var gruppoId = gruppo.id;
                var costoUnitarioIndividuale;
                var costoTotaleIndividuale;
                var costoUnitarioIndividualeLabel;
                var costoTotaleIndividualeLabel;
                if(gruppoId.indexOf("selectGruppoBeniStandard")>= 0){
                id = gruppo.id.split("selectGruppoBeniStandard").pop();
                selectSottoGruppo = "#selectSottoGruppoBeniStandard" + id;
                selectMaterialeRest = "#selectMaterialeBeniStandard"+id;
                selectQuantitaRest  ="#inputQuantitaBeniStandard"+id;
                costoUnitarioRest  ="#costoUnitarioBeniStandard"+id;
                costoTotaleRest  ="#costoTotaleBeniStandard";
                costoUnitarioIndividualeLabel ="#priceStandard"+id;
                costoTotaleIndividualeLabel =".priceTotaleStandard";
                costoUnitarioIndividuale =  $(costoUnitarioRest).val();
                costoTotaleIndividuale = $(costoTotaleRest).val();
                costoTotale =  costoTotaleIndividuale - costoUnitarioIndividuale;
                costoTotale = costoTotale.toFixed(2);}
                if(gruppoId.indexOf("selectGruppoBeniInformatica")>= 0){
                id = gruppo.id.split("selectGruppoBeniInformatica").pop();
                selectSottoGruppo = "#selectSottoGruppoBeniInformatica" + id;
                selectMaterialeRest = "#selectMaterialeBeniInformatica"+id;
                selectQuantitaRest  ="#inputQuantitaBeniInformatica"+id;
                costoUnitarioRest  ="#costoUnitarioBeniInformatica"+id;
                costoTotaleRest  ="#costoTotaleBeniInformatica";
                costoUnitarioIndividualeLabel ="#priceInformatica"+id;
                costoTotaleIndividualeLabel =".priceTotaleInformatica";
                costoUnitarioIndividuale =  $(costoUnitarioRest).val();
                costoTotaleIndividuale = $(costoTotaleRest).val();
                costoTotale = costoTotaleIndividuale - costoUnitarioIndividuale;
                costoTotale = costoTotale.toFixed(2);}
                var origine = "2";
                codiceGruppo = gruppo.value;
                var tipoMaterialePerSottoGruppo = tipoMateriale;
                var optionsSottoGruppo  ='';
                if (listCodes.indexOf(codiceUfficio) !== -1) { inputServizio = "geco";}
                Liferay.Service(
                                                                 '/mefgeco.supportdata/get-list-sottogruppi',  
                                                                 { origine: origine, 
                                                                   tipoMateriale: tipoMaterialePerSottoGruppo, 
                                                                   codiceGruppo: codiceGruppo,
                                                                   codiceUfficio: codiceUfficio,
                                                                   servizio : inputServizio,
                                                                   ambiente : ambiente},                        
                                                                 function(obj) {
                                                                                              $(selectSottoGruppo).attr("disabled",true);
                                                                                              $(selectSottoGruppo).empty().append('<option selected hidden value="">SCEGLI UN SOTTOGRUPPO</option>');
                                                                                              $(selectMaterialeRest).attr("disabled",true);
                                                                                              $(selectMaterialeRest).empty().append('<option selected hidden value="">SCEGLI UN MATERIALE</option>');
                                                                                              $(selectQuantitaRest).val("0");  
                                                                                              $(costoUnitarioRest).val("0.00");  
                                                                                              $(costoTotaleRest).val(costoTotale);
                                                                                              $(selectSottoGruppo).attr("disabled",false);
                                                                                              $(costoUnitarioIndividualeLabel).text("0.00\u20AC");
                                                                                              $(costoTotaleIndividualeLabel).text(costoTotale+"\u20AC");
                                                                                              $.each(obj,function(key, value){
                                                                                                var codice=value.codice;
                                                                                                var descizione = value.descrizione;
                                                                                                optionsSottoGruppo += '<option value="'+codice+'">'+descizione+'</option>';});
                                                                                              $(selectSottoGruppo).append(optionsSottoGruppo);   });}
                function getMateriale(sottoGruppo){
                               var idPerSelectMateriale;
                               var selectSottoGruppo; 
                               var gruppoId = sottoGruppo.id;
                               var selectMateriale;
                               var inputQuantita;
                               var inputPrezzoMedio = '';
                               var inputDisponibilita = '';
                               var id;
                               var idDisponibilita;
                               var divId;
                               var className;
                               var disponibilitaClassName;
						       var costoUnitarioRest;
                               var costoTotaleRest;
                               var costoTotale = 0.00;
                               var costoUnitarioIndividuale;
                               var costoTotaleIndividuale;
                               var costoUnitarioIndividualeLabel;
                               var costoTotaleIndividualeLabel;             
                               if(gruppoId.indexOf("selectSottoGruppoBeniStandard")>= 0){
                                               idPerSelectMateriale = sottoGruppo.id.split("selectSottoGruppoBeniStandard").pop();
                                               selectMateriale = "#selectMaterialeBeniStandard" + idPerSelectMateriale;
                                               inputQuantita = "#inputQuantitaBeniStandard" + idPerSelectMateriale;
                                               className ="prezzoStandardClass";
                                               disponibilitaClassName = "disponbilitaStandardClass";
                                               divId = "#beniConsumoStandard"+idPerSelectMateriale;             
                                               id="prezzoStandard";
                                               idDisponibilita = "disponibilitaStandard";
            selectMaterialeRest = "#selectMaterialeBeniStandard"+idPerSelectMateriale;
                                   selectQuantitaRest  ="#inputQuantitaBeniStandard"+idPerSelectMateriale;
                                   costoUnitarioRest  ="#costoUnitarioBeniStandard"+idPerSelectMateriale;
                                   costoTotaleRest  ="#costoTotaleBeniStandard";
                                   costoUnitarioIndividualeLabel ="#priceStandard"+idPerSelectMateriale;
                                   costoTotaleIndividualeLabel =".priceTotaleStandard";
                                   costoUnitarioIndividuale =  $(costoUnitarioRest).val();
                                   costoTotaleIndividuale = $(costoTotaleRest).val(); 
                                   costoTotale =  costoTotaleIndividuale - costoUnitarioIndividuale;
                                   costoTotale = costoTotale.toFixed(2);}
                               if(gruppoId.indexOf("selectSottoGruppoBeniInformatica")>= 0){
                                              idPerSelectMateriale = sottoGruppo.id.split("selectSottoGruppoBeniInformatica").pop();
                                               selectMateriale = "#selectMaterialeBeniInformatica" + idPerSelectMateriale;
                                               inputQuantita = "#inputQuantitaBeniInformatica" + idPerSelectMateriale;
                                               id = "prezzoInformatica"; 
                                               idDisponibilita = "disponibilitaInformatica";
                                               className ="prezzoInformaticaClass";
                                               disponibilitaClassName = "disponbilitaInformaticaClass";
                                               divId = "#beniConsumoInformatica"+idPerSelectMateriale;
                                               selectMaterialeRest = "#selectMaterialeBeniInformatica"+idPerSelectMateriale;
                                               selectQuantitaRest  ="#inputQuantitaBeniInformatica"+idPerSelectMateriale;
                                               costoUnitarioRest  ="#costoUnitarioBeniInformatica"+idPerSelectMateriale;
                                               costoTotaleRest  ="#costoTotaleBeniInformatica";
                                               costoUnitarioIndividualeLabel ="#priceInformatica"+id;
                                               costoTotaleIndividualeLabel =".priceTotaleInformatica";
                                               costoUnitarioIndividuale =  $(costoUnitarioRest).val();
                                               costoTotaleIndividuale = $(costoTotaleRest).val();
                                               costoTotale = costoTotaleIndividuale - costoUnitarioIndividuale;
                                               costoTotale = costoTotale.toFixed(2);}
                                               var origine = "2";
                                               var codiceGruppoPerMateriale =  codiceGruppo;
                                               var tipoMaterialePerMateriale = tipoMateriale;
                                               var sottoGruppoId= sottoGruppo.value;
                                               var optionsMateriale  ='';
                                               var optionsQuantita;
                                               var disponibilita = false;
                                               Liferay.Service(
                                                                 '/mefgeco.supportdata/get-list-materiali',                 
                                                                 {  origine: origine,
                                                                   tipoMateriale: tipoMaterialePerMateriale,
                                                                              codiceGruppo: codiceGruppoPerMateriale,
                                                                              codiceSottogruppo: sottoGruppoId,
                                                                              codiceUfficio: codiceUfficio, 
                                                                              servizio : inputServizio,
                                                                              ambiente : ambiente},   
                                                                 function(obj) {
                                                                               $(selectMaterialeRest).attr("disabled",true);
                                                                               $(selectMaterialeRest).empty().append('<option selected hidden value="">SCEGLI UN MATERIALE</option>');
                                                                               $(selectQuantitaRest).val("0");  
                                                                               $(costoUnitarioRest).val("0.00");  
                                                                               $(costoTotaleRest).val(costoTotale);
                                                                               $(costoUnitarioIndividualeLabel).text("0.00"+"\u20AC");
                                                                               $(costoTotaleIndividualeLabel).text(costoTotale+"\u20AC");
                                                                               $(selectMaterialeRest).attr("disabled",false);
                                                                               $.each(obj,function(key, value){
                                                                               var codice=value.codice;
                                                                               var descizione = value.descrizione;
                                                                               disponibilita = value.disponibilita;
                                                                               optionsMateriale += '<option value="'+value.numeroScheda+'">'+descizione+'</option>';  
                                                                               value.prezzoMedio = value.prezzoMedio.replace(/[^a-zA-Z0-9]/g,'.');
                                                                               inputPrezzoMedio += '<input type="hidden" id="'+id+value.numeroScheda+'" value="'+value.prezzoMedio+'" class="'+className+'">';
                                                                               inputDisponibilita += '<input type="hidden" id="'+idDisponibilita+value.numeroScheda+'" value="'+disponibilita+'" class="'+disponibilitaClassName+'">';
                                                                               });
                                                                               $(selectMateriale).append(optionsMateriale);
                                                                               $("#mainContainer").find(divId).each(function(key,value) {
                                                                                              var classComplete = "."+className;
                                                                                              $(this).find(classComplete).remove();
                                                                                              var classCompleteDisponibilita = "."+disponibilitaClassName;
                                                                                              $(this).find(classCompleteDisponibilita).remove();});
                                                                               $(divId).append(inputPrezzoMedio);
                                                                               $(divId).append(inputDisponibilita);});}
                
                $(".buttonForm").click("on", function(){
                  $('#<portlet:namespace/>inputBeniRichiestaStandard').val("");
                                                                                             $('#<portlet:namespace/>inputBeniRichiestaInfo').val("");
                                                                                              var validJsonObject = false; 
                                                                                              var button = this;
                                                                                              var oggetto;
                                                                                              var dataDiOggi;
                                                                                              var descrizione;
                                                                                              var tipoBeni;
                                                                                              var periodicita;
                                                                                              var periodicitaDescrizione;
                                                                                              var numeroInventarioMacchina;
                                                                                              var prezzoMedioId;
                                                                                              var inputPrezzoMedioValue;
                                                                                              var materialeId;
                                                                                              var costoTotale;
				                                                                              var validbeneStandard = true;
				                                                                              var validbeneInfo = true;
				                                                                              countCheckValidStandard=0;
				                                                                              countCheckValidInfo=0;
				                                                                              countCheckValidStandardLength = $('.divValStandard').find('.checkValStandard').length;
				                                                                              countCheckValidInfoLength=$('.divValInfo').find('.checkValInfo').length;
                                                                              
                                                                              if ($('#standard').hasClass("collapse in")) {
                                                                                               $('#<portlet:namespace/>periodicitaBeniStandard').parsley().validate(); 
                                                                                               $('.divValStandard').find('.checkValStandard').each(function(key,value) { 
                                                             if($(this).val()=="" ||$(this).val()==0){
                                                                             countCheckValidStandard++;   } 
                                                             });
                                                                                              if(countCheckValidStandard!=(countCheckValidStandardLength)){
                                                                                                              $('#<portlet:namespace/>inputBeniRichiestaStandard').val("valore"); 
                                                                                              } 
                                                                               $('#<portlet:namespace/>inputBeniRichiestaStandard').parsley().validate();      
                                                               if($('#<portlet:namespace/>inputBeniRichiestaStandard').parsley().isValid()){
                                                                               $('.divValStandard').find('.checkValStandard').each(function(key,value) { 
                                                                                                             $(this).parsley().validate(); 
                                                                                                             if(!$(this).parsley().isValid()){
                                                                                                                             validbeneStandard=false;}          
                                                                                                             }); }}
                                                else if($('#technology').hasClass("collapse in") ) {
                                                                              $('#<portlet:namespace/>numeroInventarioMacchina').parsley().validate();
                                                                $('.divValInfo').find('.checkValInfo').each(function(key,value) {
                                if($(this).val()=="" ||$(this).val()==0){
                                              countCheckValidInfo++;  }});
                                                                if(countCheckValidInfo!=(countCheckValidInfoLength)){
                                                                              $('#<portlet:namespace/>inputBeniRichiestaInfo').val("valore");}
                                                                               $('#<portlet:namespace/>inputBeniRichiestaInfo').parsley().validate(); 
                                                               if($('#<portlet:namespace/>inputBeniRichiestaInfo').parsley().isValid()){
                                                                               $('.divValInfo').find('.checkValInfo').each(function(key,value) { 
                                                                                                             $(this).parsley().validate(); 
                                                                                                             if(!$(this).parsley().isValid()){
                                                                                                                             validbeneInfo=false;}}); }               }
                                                                              if(dirigente==0)
                                                                            	  $('#<portlet:namespace/>beniFaciliConsumoInserimentoForm').parsley().validate();
                                                                              if(dirigente==1)
                                                                            	  $('#<portlet:namespace/>beniFaciliConsumoModificaForm').parsley().validate();
                                                if ($('#standard').hasClass("collapse in")) {
                                                                if($('#<portlet:namespace/>inputBeniRichiestaStandard').parsley().isValid() ){
                                                                                              if( dirigente==0 && $('#<portlet:namespace/>beniFaciliConsumoInserimentoForm').parsley().isValid() && validbeneStandard && $('#<portlet:namespace/>periodicitaBeniStandard').parsley().isValid()){
                                                                                            	  validJsonObject=true;}
                                                                                              if( dirigente==1 && $('#<portlet:namespace/>beniFaciliConsumoModificaForm').parsley().isValid() && validbeneStandard && $('#<portlet:namespace/>periodicitaBeniStandard').parsley().isValid()){
                                                                                            	  validJsonObject=true;}}}
                                                else if($('#technology').hasClass("collapse in")) {
                                                                               if($('#<portlet:namespace/>inputBeniRichiestaInfo').parsley().isValid() ){
                                                                                              if( dirigente==0 && $('#<portlet:namespace/>beniFaciliConsumoInserimentoForm').parsley().isValid() && validbeneInfo && $('#<portlet:namespace/>numeroInventarioMacchina').parsley().isValid()){
                                                                                              validJsonObject=true;}
                                                                              if( dirigente==1 && $('#<portlet:namespace/>beniFaciliConsumoModificaForm').parsley().isValid() && validbeneInfo && $('#<portlet:namespace/>numeroInventarioMacchina').parsley().isValid()){
                                                                                                  validJsonObject=true;}}}  
                                                var itemsUnderRange = true;
                                                if(validJsonObject!=false) {
                                                   var json = "";
                                                   var maxItems = 15;
                                                    if($("#<portlet:namespace/>periodicitaBeniStandard").val() != null && $("#<portlet:namespace/>periodicitaBeniStandard").val() != ""){
                                                    	var beniStandardItems = $(".beniConsumoStandardClass").length;
                                                        if(beniStandardItems >maxItems)
                                                    	itemsUnderRange = false; }                                         	          
                                                    if($("#<portlet:namespace/>numeroInventarioMacchina").val() != null && $("#<portlet:namespace/>numeroInventarioMacchina").val() != ""){
                                                    	 var beniInformaticaItems = $(".beniConsumoInformaticaClass").length;
                                                         if(beniInformaticaItems>maxItems)
                                                    	itemsUnderRange = false; }
                                                        if(itemsUnderRange!=false){
                                                        	if($('#standard').hasClass("collapse in")){
                                                                oggetto = $("#<portlet:namespace/>oggettoBeniStandard").val();
                                                                periodicita = $("#<portlet:namespace/>periodicitaBeniStandard").val();
                                                                periodicitaDescrizione = $(".periodicitaBeniClassStandard :selected").text();
                                                                dataDiOggi = $("#<portlet:namespace/>dateBeniStandard").val();
                                                                descrizione = $("#<portlet:namespace/>descrizioneBeniStandard").val();
                                                                descrizione = descrizione.trim();
                                                                costoTotale = $("#costoTotaleBeniStandard").val();
                                                                tipoBeni = "beniStandard";
                                                                $("#mainContainer").find(".beniConsumoStandardClass").each(function(key,value) {
                                                                                itemBeniStandard = {
                                                                                                gruppo:$(this).find(".selectGruppoClassBeniStandard")["0"].value,
                                                                                                gruppoDescrizione : $(this).find(".selectGruppoClassBeniStandard :selected").text(),
                                                                                                sottoGruppo:$(this).find(".selectSottoGruppoClassBeniStandard")["0"].value,
                                                                                                sottoGruppoDescrizione :$(this).find(".selectSottoGruppoClassBeniStandard :selected").text(),
                                                                                                materiale:$(this).find(".selectMaterialeClassBeniStandard")["0"].value,
                                                                                                materialeDescrizione: $(this).find(".selectMaterialeClassBeniStandard :selected").text(),
                                                                                                prezzoMedioId : $(this).find(".selectMaterialeClassBeniStandard")["0"].value,
                                                                                                quantita:$(this).find(".inputQuantitaClassBeniStandard")["0"].value,
                                                                                                inputPrezzoMedioValue : $(this).find(".inputPrezzoMedioHiddenClass").val(),
                                                                                                disponibilita: $(this).find(".disponbilitaStandardClass").val(),
                                                                                                costoUnitario : $(this).find(".costoUnitarioBeniClassStandard").val() };
                                                                                                array.push(itemBeniStandard); });}
                                                        										else{
      				                                                                          oggetto =$("#<portlet:namespace/>oggettoBeniInformatica").val();
      				                                                                         numeroInventarioMacchina =$("#<portlet:namespace/>numeroInventarioMacchina").val();
      				                                                                          dataDiOggi =$("#<portlet:namespace/>dateBeniInformatica").val();
      				                                                                          descrizione = $("#<portlet:namespace/>descrizioneBeniInformatica").val();
      				                                                                          descrizione = descrizione.trim();
      				                                                                          costoTotale = $("#costoTotaleBeniInformatica").val();
      				                                                                         tipoBeni = "beniInformatica";
      				                                                                          $("#mainContainer").find(".beniConsumoInformaticaClass").each(function(key,value) {
                                                                                					itemBeniInformatica = {
                                                                                                gruppo:$(this).find(".selectGruppoClassBeniInformatica")["0"].value,
                                                                                               gruppoDescrizione : $(this).find(".selectGruppoClassBeniInformatica :selected").text(),
                                                                                                sottoGruppo:$(this).find(".selectSottoGruppoClassBeniInformatica")["0"].value,
                                                                                               sottoGruppoDescrizione :$(this).find(".selectSottoGruppoClassBeniInformatica :selected").text(),
                                                                                                  materiale:$(this).find(".selectMaterialeClassBeniInformatica")["0"].value,
                                                                                               materialeDescrizione: $(this).find(".selectMaterialeClassBeniInformatica :selected").text(),
                                                                                                quantita:$(this).find(".inputQuantitaClassBeniInformatica")["0"].value,
                                                                                               inputPrezzoMedioValue : $(this).find(".inputPrezzoMedioHiddenInformaticaClass").val(),
                                                                                               disponibilita: $(this).find(".disponbilitaInformaticaClass").val(), 
                                                                                               costoUnitario : $(this).find(".costoUnitarioBeniClassInformatica").val() };
                                                                                                array.push(itemBeniInformatica); });}
                                                                								var sede; var sedeDescrizione; var codiceGeco;
                                                                								if ($('#standard').hasClass("collapse in")) {
                                                                									sede = $("#<portlet:namespace/>selectSedeBeniStandard").val().split(';')[0].trim();
                                                                                                    sedeDescrizione = $("#<portlet:namespace/>selectSedeBeniStandard option:selected").text();
                                                                                                    codiceGeco = $('#<portlet:namespace/>selectSedeBeniStandard').val().split(';')[1].trim();
                                                                								}else {
                                                                									sede = $("#<portlet:namespace/>selectSedeBeniInfo").val().split(';')[0].trim();
                                                                                                    sedeDescrizione = $("#<portlet:namespace/>selectSedeBeniInfo option:selected").text();
                                                                                                    codiceGeco = $('#<portlet:namespace/>selectSedeBeniInfo').val().split(';')[1].trim();
                                                                                                    }
                                                                								 jsonObj = {ufficioRichiedente : $("#<portlet:namespace/>ufficioRichiedente").val(),
                                                                      organizzazione: $("#<portlet:namespace/>organizzazione").val(),
                                                                      nome: $("#<portlet:namespace/>nome").val(),
                                                                      cognome : $("#<portlet:namespace/>cognome").val(),
                                                                      ubicazione : $("#<portlet:namespace/>ubicazione").val(),
                                                                      palazzina : $("#<portlet:namespace/>palazzina").val(),
                                                                      piano : $("#<portlet:namespace/>piano").val(),
                                                                      stanza :$("#<portlet:namespace/>stanza").val(),
                                                                      scala : $("#<portlet:namespace/>scala").val(),
                                                                      telefono : $("#<portlet:namespace/>telefono").val(),
                                                                      email : $("#<portlet:namespace/>emailDirigente").val(),
                                                                      emailRichiedente : $("#<portlet:namespace/>emailRichiedente").val(),
                                                                      sede : sede,
                                                                      sedeDescrizione : sedeDescrizione,
                                                                      codiceGeco : codiceGeco,
                                                                      oggetto: oggetto,
                                                                      dataRichiesta : dataDiOggi,
                                                                      periodicita : periodicita,
                                                                      periodicitaDescrizione : periodicitaDescrizione,
                                                                      numeroInventarioMacchina : numeroInventarioMacchina,         
                                                                      descrizione : descrizione,
                                                                      tipoBeni : tipoBeni,
                                                                      costoTotale: costoTotale,
                                                                      datiRichieste : array};
                                                                      json = JSON.stringify(jsonObj);
                                                                     $("#<portlet:namespace/>json").val(JSON.stringify(jsonObj));}                                
                                                  if(button.id.indexOf("proseguiBeniConsumoBtn")>=0 && itemsUnderRange!=false){$("#<portlet:namespace/>beniFaciliConsumoInserimentoForm").submit();
                                                  }if(button.id.indexOf("modificaBeniConsumoBtn")>=0 && itemsUnderRange!=false){$("#<portlet:namespace/>beniFaciliConsumoModificaForm").submit();
                                                    }if(itemsUnderRange!=true)
                                                    	  showDialog();}});             
                function onChangeSede() {
                	if ($('#standard').hasClass("collapse in")) {
                	$(".selectGruppoClassBeniStandard").attr("disabled",false);
                		codiceUfficio= $('#<portlet:namespace/>selectSedeBeniStandard').val().split(';')[1].trim();
                		$('#<portlet:namespace/>idSede').val($('#<portlet:namespace/>selectSedeBeniStandard').val().split(';')[0].trim());}
                	else {$(".selectGruppoClassBeniInformatica").attr("disabled",false);
                		codiceUfficio = $('#<portlet:namespace/>selectSedeBeniInfo').val().split(';')[1].trim();
                		$('#<portlet:namespace/>idSede').val($('#<portlet:namespace/>selectSedeBeniInfo').val().split(';')[0].trim());}
                	if (listCodes.indexOf(codiceUfficio) !== -1) { inputServizio = "geco";}$('#<portlet:namespace/>codiceGeco').val(codiceUfficio);
                }         	
                function onChangeSedeSwitch() { 
                	if ($('#standard').hasClass("collapse in")) {
                		codiceUfficio = $('#<portlet:namespace/>selectSedeBeniInfo').val().split(';')[1].trim();
                		$('#<portlet:namespace/>idSede').val($('#<portlet:namespace/>selectSedeBeniInfo').val().split(';')[0].trim());}
                	else {
                		codiceUfficio= $('#<portlet:namespace/>selectSedeBeniStandard').val().split(';')[1].trim();
                		$('#<portlet:namespace/>idSede').val($('#<portlet:namespace/>selectSedeBeniStandard').val().split(';')[0].trim());}
                	if (listCodes.indexOf(codiceUfficio) !== -1) {inputServizio = "geco";}$('#<portlet:namespace/>codiceGeco').val(codiceUfficio);
             	    }
     </script>