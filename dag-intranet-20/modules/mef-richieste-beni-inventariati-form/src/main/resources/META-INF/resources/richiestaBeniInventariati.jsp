<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mef.richieste.beni.inventariati.bean.ModuloBeneInv"%>
<%@page import="service.intranet.mef.service.BeneInvLocalServiceUtil"%>
<%@page import="service.intranet.mef.model.TipoBeneInv"%>
<%@page import="service.intranet.mef.model.BeneInv"%>
<%@page import="service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil"%>
<%@page import="service.intranet.mef.model.RichiestaBeneInv"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="mef.richieste.beni.inventariati.bean.Utente"%>
<%@page import="service.intranet.mef.model.BeneInvRichiesto"%>
<%@page import="service.intranet.mef.service.BeneInvRichiestoLocalServiceUtil"%>

<%
long id_richiesta_duplica = 0;
RichiestaBeneInv richiestaObjByDettaglio = null;
JSONObject jsonObjRichiedente = null;
JSONObject jsonObjBeneficiario = null;
List <BeneInvRichiesto> listBeniInElenco = new ArrayList<BeneInvRichiesto>();
List <BeneInvRichiesto> listBeniNonInElenco = new ArrayList<BeneInvRichiesto>();
if(request.getAttribute("idRichiestaDuplica")!=null) {
	id_richiesta_duplica=Long.parseLong((String)request.getAttribute("idRichiestaDuplica"));
	richiestaObjByDettaglio = RichiestaBeneInvLocalServiceUtil.getRichiestaBeneInv(id_richiesta_duplica);
	jsonObjRichiedente = JSONFactoryUtil.createJSONObject(richiestaObjByDettaglio.getDati_rich());
	jsonObjBeneficiario = JSONFactoryUtil.createJSONObject(richiestaObjByDettaglio.getBeneficiario());
	listBeniInElenco = BeneInvRichiestoLocalServiceUtil.getListBeniByIdRichiesta(id_richiesta_duplica, true);
	listBeniNonInElenco = BeneInvRichiestoLocalServiceUtil.getListBeniByIdRichiesta(id_richiesta_duplica, false);
}
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
Date today = Calendar.getInstance().getTime();
String reportDate = df.format(today);
int countBene=1;
List<TipoBeneInv> listTipoBeniInv = (List<TipoBeneInv>)  request.getAttribute("tipoBeneList");
List<ModuloBeneInv> listaRichiesteBeniInv = (List<ModuloBeneInv>)  request.getAttribute("listRichiesteBeniInv");
StringBuilder destinazioneBenePrecompilata = new StringBuilder();
destinazioneBenePrecompilata.append("Palazzina ");
if (utente.getPalazzina()!=null && !("").equals(utente.getPalazzina().trim())) {
	destinazioneBenePrecompilata.append(utente.getPalazzina().trim().toUpperCase());
} else {
	destinazioneBenePrecompilata.append("ND");
}
destinazioneBenePrecompilata.append(", Piano ");
if (utente.getPiano()!=null && !("").equals(utente.getPiano().trim())) {
	destinazioneBenePrecompilata.append(utente.getPiano().trim().toUpperCase());
}else {
	destinazioneBenePrecompilata.append("ND");
}
destinazioneBenePrecompilata.append(", Scala ");
if (utente.getScala()!=null && !("").equals(utente.getScala().trim())) {
	destinazioneBenePrecompilata.append(utente.getScala().trim().toUpperCase());
}else {
	destinazioneBenePrecompilata.append("ND");
}
destinazioneBenePrecompilata.append(", Stanza ");
if (utente.getStanza()!=null && !("").equals(utente.getStanza().trim())) {
	destinazioneBenePrecompilata.append(utente.getStanza().trim().toUpperCase());
}else {
	destinazioneBenePrecompilata.append("ND");
}
%>

<c:set value="<%=listaRichiesteBeniInv%>" var="listaRichiesteBeniInv"></c:set>

<portlet:actionURL name="riepilogoDati" var="riepilogoDati"></portlet:actionURL>
<portlet:actionURL var="vaiARicercaUrl" name="vaiARicerca"/>

<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=beniInvInserimentoTitle%></h2>
                         <a class="icomoon-star title-star btn-star-bookmarks star mr-20-xs">
                             <span class="sr-only"><liferay-ui:message key="beni-inv-richiesta-aggiungi-preferiti"/></span>
                         </a>
                         <form action="<%=vaiARicercaUrl%>" method="post" class="wrapper-form-search">
                             <div class="wrap-icon-title mt-5-md mobile-search">
                                 <a href="<%=vaiARicercaUrl%>" title="Ricerca" class="icon icomoon-search-richiesta"></a>
                             </div>
                         </form>
                         <p class="subtitle dot-point dot-200"><%=beniInvInserimentoTxt%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>

     <div id="TitoloContainer" class="ama-container-fluid TitoloContainer">
         
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay:ui-message key="beni-inv-richiesta-dati-richiedente"/></h2>
                 </div>
             </div>
         </div>
         <div class="ama-row">
             <form data-parsley-validate="true" action="<%=riepilogoDati%>" method="post" id="formBeniInv" enctype="multipart/form-data">
                 <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                     <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-ufficio-richiedente"/>*</label>
                     <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                     <input 
                     	data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                     	id="IntUfficioRichiedente" type="text" class="input-custom-light data-parsley-validated" value="<%=utente.getUfficioRichiedente().toUpperCase()%>" name="<portlet:namespace/>ufficioRichiedente">
                     </c:if>
                     <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                      <input 
                      	data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                      	id="IntUfficioRichiedente" type="text" class="input-custom-light data-parsley-validated" value="${richiedenteModifica.getUfficioRichiedente().toUpperCase()}" name="<portlet:namespace/>ufficioRichiedente">
                     </c:if>
                     <c:if test="<%=id_richiesta_duplica!=0%>">
                     <input 
                     	data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                     	id="IntUfficioRichiedente" type="text" class="input-custom-light data-parsley-validated" value="<%=HtmlUtil.escape(jsonObjRichiedente.getString("ufficioRichiedente")).toUpperCase()%>" name="<portlet:namespace/>ufficioRichiedente">
                     </c:if>
                 </div>
                 <div class="ama-col-xs-12 mb-25-md">
                     <div class="ama-row">
                         <div class="ama-col-sm-6 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-nome-richiedente"/>*</label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="IntNomeRich" type="text" class="input-custom-light data-parsley-validated" value="<%=utente.getNome().toUpperCase()%>" name="<portlet:namespace/>nome">
                         	 </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="IntNomeRich" type="text" class="input-custom-light data-parsley-validated" value="${richiedenteModifica.getNome().toUpperCase()}" name="<portlet:namespace/>nome">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="IntNomeRich" type="text" class="input-custom-light data-parsley-validated" value="<%=HtmlUtil.escape(richiestaObjByDettaglio.getNome_rich()).toUpperCase()%>" name="<portlet:namespace/>nome">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-6 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-cognome-richiedente"/>*</label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input 
                                data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"	
                             	id="IntCognomeRich" type="text" class="input-custom-light data-parsley-validated" value="<%=utente.getCognome().toUpperCase()%>" name="<portlet:namespace/>cognome">
                         	 </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="IntCognomeRich" type="text" class="input-custom-light data-parsley-validated" value="${richiedenteModifica.getCognome().toUpperCase()}" name="<portlet:namespace/>cognome">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="IntCognomeRich" type="text" class="input-custom-light data-parsley-validated" value="<%=HtmlUtil.escape(richiestaObjByDettaglio.getCogn_rich()).toUpperCase()%>" name="<portlet:namespace/>cognome">
                             </c:if>
                         </div>
                     </div>
                 </div>
                 <div class="ama-col-xs-12 mb-25-md">
                     <div class="ama-row">
                         <div class="ama-col-sm-4 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-ubicazione"/></label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input id="IntUbicazioneAttuale" type="text" class="input-custom-light" value="<%=utente.getUbicazione().toUpperCase()%>" name="<portlet:namespace/>ubicazione">
                         	 </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input id="IntUbicazioneAttuale" type="text" class="input-custom-light" value="${richiedenteModifica.getUbicazione().toUpperCase()}" name="<portlet:namespace/>ubicazione">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input id="IntUbicazioneAttuale" type="text" class="input-custom-light" value="<%=HtmlUtil.escape(jsonObjRichiedente.getString("ubicazione")).toUpperCase()%>" name="<portlet:namespace/>ubicazione">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-palazzina"/></label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input id="IntPalazzina" type="text" class="input-custom-light" value="<%=utente.getPalazzina().toUpperCase()%>" name="<portlet:namespace/>palazzina">
                         	 </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input id="IntPalazzina" type="text" class="input-custom-light" value="${richiedenteModifica.getPalazzina().toUpperCase()}" name="<portlet:namespace/>palazzina">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input id="IntPalazzina" type="text" class="input-custom-light" value="<%=HtmlUtil.escape(jsonObjRichiedente.getString("palazzina")).toUpperCase()%>" name="<portlet:namespace/>palazzina">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-piano"/></label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input id="IntPiano" type="text" class="input-custom-light" value="<%=utente.getPiano().toUpperCase()%>" name="<portlet:namespace/>piano">
                             </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input id="IntPiano" type="text" class="input-custom-light" value="${richiedenteModifica.getPiano().toUpperCase()}" name="<portlet:namespace/>piano">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input id="IntPiano" type="text" class="input-custom-light" value="<%=HtmlUtil.escape(jsonObjRichiedente.getString("piano")).toUpperCase()%>" name="<portlet:namespace/>piano">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-scala"/></label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input id="IntScala" type="text" class="input-custom-light" value="<%=utente.getScala().toUpperCase()%>" name="<portlet:namespace/>scala">
                             </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input id="IntScala" type="text" class="input-custom-light" value="${richiedenteModifica.getScala().toUpperCase()}" name="<portlet:namespace/>scala">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input id="IntScala" type="text" class="input-custom-light" value="<%=HtmlUtil.escape(jsonObjRichiedente.getString("scala")).toUpperCase()%>" name="<portlet:namespace/>scala">
                             </c:if>
                         </div>
                         <div class="ama-col-sm-2 ama-col-xs-6">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-stanza"/></label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input id="IntStanza" type="text" class="input-custom-light" value="<%=utente.getStanza().toUpperCase()%>" name="<portlet:namespace/>stanza">
                             </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input id="IntStanza" type="text" class="input-custom-light" value="${richiedenteModifica.getStanza().toUpperCase()}" name="<portlet:namespace/>stanza">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input id="IntStanza" type="text" class="input-custom-light" value="<%=HtmlUtil.escape(jsonObjRichiedente.getString("stanza")).toUpperCase()%>" name="<portlet:namespace/>stanza">
                             </c:if>
                         </div>
                     </div>
                 </div>
                 <div class="ama-col-xs-12">
                     <div class="ama-row">
                         <div class="ama-col-sm-6 ama-col--xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-richiesta-telefono"/></label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input                   
                             	data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                             	id="IntTelephone" type="text" class="input-custom-light data-parsley-validated" value="<%=utente.getTelefono()%>" name="<portlet:namespace/>telefono">
                         	 </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input
                             	data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
                             	id="IntTelephone" type="text" class="input-custom-light data-parsley-validated" value="${richiedenteModifica.getTelefono().toUpperCase()}" name="<portlet:namespace/>telefono">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input 
                             	data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                             	id="IntTelephone" type="text" class="input-custom-light data-parsley-validated" value="<%=jsonObjRichiedente.getString("telefono").toUpperCase()%>" name="<portlet:namespace/>telefono">
                         	 </c:if>
                         </div>
                         <div class="ama-col-sm-6 ama-col-xs-12">
                             <label for="argument" class="label-form"><liferay-ui:message key="beni-inv-email-dirigente"/>*</label>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")==null && id_richiesta_duplica==0%>">
                             <input 
                                data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"	
                             	data-parsley-type="email"
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                             	id="IntEmailDirigente" type="text" class="input-custom-light  data-parsley-validated" value="<%=utente.getEmailDirigente()%>" name="<portlet:namespace/>emailDirigente">
                             </c:if>
                             <c:if test="<%=request.getAttribute("richiedenteModifica")!=null%>">
                             <input
                                data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"	 
                                data-parsley-type="email"
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                             	id="IntEmailDirigente" type="text" class="input-custom-light data-parsley-validated" value="${richiedenteModifica.getEmailDirigente().toLowerCase()}" name="<portlet:namespace/>emailDirigente">
                             </c:if>
                             <c:if test="<%=id_richiesta_duplica!=0%>">
                             <input 
                               data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"	
                             	data-parsley-type="email"
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                             	id="IntEmailDirigente" type="text" class="input-custom-light  data-parsley-validated" value="<%=jsonObjRichiedente.getString("emailDirigente").toLowerCase()%>" name="<portlet:namespace/>emailDirigente">
                             </c:if>
                         </div>
                     </div>
                 </div>
                 <input type="hidden" id="listRichiestaBeniInv" name="<portlet:namespace/>saverichiesta">
                 <input type="hidden" name="<portlet:namespace/>dipRichiedente" value="<%=utente.getDipartimento()%>">
                 <input type="hidden" name="<portlet:namespace/>screenNameUtente" value="<%=user.getScreenName().toLowerCase()%>">
                 <c:if test="${idRichiesta != null}">
                 <input type="hidden" name="<portlet:namespace/>idRich" value="${idRichiesta}">
                 </c:if>
             </form>
         </div>                
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay-ui:message key="beni-inv-dati-richiesta"/></h2>
                 </div>
             </div>
         </div>
         <form>
         <div class="wrapper-beni-inventariati">
            
                 <div class="ama-row">
                     <div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12 mb-25-md">
                         <label for="argument" class="label-form "><liferay-ui:message key="beni-inv-richiesta-oggetto"/></label>
                         <c:if test="<%=request.getAttribute("oggetto")==null && id_richiesta_duplica==0%>">
                         <input id="IntOggetto" id="argument" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-oggetto-richiesta"/>" name="<portlet:namespace/>oggetto">
                         </c:if>
                         <c:if test="<%=request.getAttribute("oggetto")!=null%>">
                         <input id="IntOggetto" id="argument" class="input-custom-light" value="${oggetto.toUpperCase()}" name="<portlet:namespace/>oggetto">
                         </c:if>
                         <c:if test="<%=id_richiesta_duplica!=0%>">
                         <input id="IntOggetto" id="argument" class="input-custom-light" value="<%=HtmlUtil.escape(richiestaObjByDettaglio.getOggetto()).toUpperCase()%>" name="<portlet:namespace/>oggetto">
                         </c:if>
                     </div>
                     <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
                         <label for="date" class="label-form "><liferay-ui:message key="beni-inv-richiesta-data"/></label>
                         <input disabled id="IntData" type="text" name="date" class="datepicker-custom input-custom-light" value="<%=reportDate%>" name="<portlet:namespace/>data">
                     </div>
         
                 </div>
         
                 <p class="title-form mb-10-xs mt-20-xs"><liferay-ui:message key="beni-inv-richiesta-dati-beneficiario"/></p>
                
                 <div class="ama-row">
                     <div class="ama-col-md-4 ama-col-xs-12 mb-25-md">
                         <label for="argument" class="label-form "><liferay-ui:message key="beni-inv-richiesta-nome-beneficiario"/>*</label>
                         <c:if test="<%=request.getAttribute("nomeBenef")==null && id_richiesta_duplica==0%>">
                         <input 
							data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                         	id="IntNomeBenef" class="input-custom-light data-parsley-validated"
                         	value="<%=utente.getNome().toUpperCase()%>" type="text" name="<portlet:namespace/>nomeBenef">
                         </c:if>
                         <c:if test="<%=request.getAttribute("nomeBenef")!=null%>">
                         <input 
							data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"	
                         	id="IntNomeBenef" class="input-custom-light data-parsley-validated" value="${nomeBenef.toUpperCase()}" type="text" name="<portlet:namespace/>nomeBenef">
                         </c:if>
                         <c:if test="<%=id_richiesta_duplica!=0%>">
                         <input 
							data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"	
                         	id="IntNomeBenef" class="input-custom-light data-parsley-validated" value="<%=HtmlUtil.escape(jsonObjBeneficiario.getString("nomeBenef")).toUpperCase()%>" type="text" name="<portlet:namespace/>nomeBenef">
                         </c:if>
                     </div>
                     <div class="ama-col-md-4 ama-col-xs-12 mb-25-md">
                         <label for="argument2" class="label-form"><liferay-ui:message key="beni-inv-richiesta-cognome-beneficiario"/>*</label>
                          <c:if test="<%=request.getAttribute("cognomeBenef")==null && id_richiesta_duplica==0%>">
                         <input 
							data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                         	id="IntCognomeBenef" class="input-custom-light data-parsley-validated" value="<%=utente.getCognome().toUpperCase()%>" name="<portlet:namespace/>cognomeBenef">
                         </c:if>
                         <c:if test="<%=request.getAttribute("cognomeBenef")!=null%>">
                         <input 
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
                         	id="IntCognomeBenef" class="input-custom-light data-parsley-validated" value="${cognomeBenef.toUpperCase()}" name="<portlet:namespace/>cognomeBenef">
                         </c:if>
                         <c:if test="<%=id_richiesta_duplica!=0%>">
                         <input 
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
                         	id="IntCognomeBenef" class="input-custom-light data-parsley-validated" value="<%=HtmlUtil.escape(jsonObjBeneficiario.getString("cognomeBenef")).toUpperCase()%>" name="<portlet:namespace/>cognomeBenef">
                         </c:if>
                     </div>
                     <div class="ama-col-md-4 ama-col-xs-12 mb-25-md">
                         <label for="argument3" class="label-form "><liferay-ui:message key="beni-inv-richiesta-email"/>*</label>
                         <c:if test="<%=request.getAttribute("emailBenef")==null && id_richiesta_duplica==0%>">
                         <input 
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-type="email"
							data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                         	id="IntEmailBenef" class="input-custom-light data-parsley-validated" value="<%=utente.getEmailPersonale()%>" name="<portlet:namespace/>emailBenef">
                         </c:if>
                         <c:if test="<%=request.getAttribute("emailBenef")!=null%>">
                         <input 
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-type="email"
							data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                         	id="IntEmailBenef" class="input-custom-light data-parsley-validated" value="${emailBenef.toLowerCase()}" name="<portlet:namespace/>emailBenef">
                         </c:if>
                         <c:if test="<%=id_richiesta_duplica!=0%>">
                         <input 
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-type="email"
							data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                         	id="IntEmailBenef" class="input-custom-light data-parsley-validated" value="<%=jsonObjBeneficiario.getString("emailBenef").toLowerCase()%>" name="<portlet:namespace/>emailBenef">
                         </c:if>
                     </div>
                 </div>
			   <p class="title-form mb-10-xs mt-20-xs"><liferay-ui:message key="beni-inv-richiesta-destinazione-beni"/></p>
                 <div class="ama-row">
                     <div class="ama-col-md-12 ama-col-xs-12 mb-25-md">
                         <label for="argument1" class="label-form "><liferay-ui:message key="beni-inv-richiesta-bene-ubicazione"/>*</label>
                         <c:if test="<%=request.getAttribute("destinazione")==null && id_richiesta_duplica==0%>">
                         <input 
							data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"                         
                         	id="IntDestinazione" class="input-custom-light" value="<%=destinazioneBenePrecompilata.toString()%>" placeholder="<liferay-ui:message key="placeholder-indirizzo"/>" name="<portlet:namespace/>destinazione">
                         </c:if>
                         <c:if test="<%=request.getAttribute("destinazione")!=null%>">
                         <input 
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                         	id="IntDestinazione" class="input-custom-light" value="${destinazione.toUpperCase()}" name="<portlet:namespace/>destinazione">
                         </c:if>
                         <c:if test="<%=id_richiesta_duplica!=0%>">
                         <input 
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                         	id="IntDestinazione" class="input-custom-light" value="<%=HtmlUtil.escape(richiestaObjByDettaglio.getDestinazione()).toUpperCase()%>" name="<portlet:namespace/>destinazione">
                         </c:if>
                     </div>
                 </div>
            
         
                 <p class="title-form mb-10-xs mt-20-xs"><liferay-ui:message key="beni-inv-richiesta-beni-scelti"/></p>
                  <input type="text" style="display:none" id="<portlet:namespace/>inputBeni" name="<portlet:namespace/>inputBeni"
                        class="data-parsley-validated"
                        data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="beni-inv-nessun-bene-inserito"/>"/>
             <div id="designBene" > 
             
             <c:if test="<%=listBeniInElenco.size()>0%>">
              <% countBene = 0; %>
             
               <c:forEach items="<%=listBeniInElenco%>" var="beneInElenco">
               <%countBene++; %>            
              <div id="bene<%=countBene%>" class="designBeneClass clearfix mt-30-xs">
                 <div class="wrap-beni-inventariati mb-25-md">
                     <span class="number"><%=countBene%></span>
                    <div class="position-button">
                         <button href="#" type="button" class=" button button-primary mt-0-xs removebtn" onclick="removeItemBene($('#bene<%=countBene%>'))">
                             <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-inv-rimuovi"/></button>
                     </div>
                 </div>
                 <div class="ama-row">
                     <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                         <label for="argument5<%=countBene%>" class="label-form"><liferay-ui:message key="beni-inv-tipologia"/>*</label>
                         <select id="argument5<%=countBene%>" class="checkValid option-select-notice SelectTipo  data-parsley-validated" onchange="loadBeneInv(this.value, <%=countBene%>)"
                         	data-parsley-required="true"
						 	data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden><liferay-ui:message key="beni-inv-scelta-tipologia"/></option>
                             	<c:if test="<%=request.getAttribute("tipoBeneList")!=null%>">
                                        <c:forEach items="<%=request.getAttribute("tipoBeneList")%>" var="tipoBene">
                                        <c:if test="${tipoBene.getTipo().toUpperCase() == beneInElenco.getTipologia().toUpperCase()}">                       
										  		<option value="${tipoBene.getId()}" selected = "true">${tipoBene.getTipo().toUpperCase()}</option>
									   	</c:if>
									   	<c:if test="${tipoBene.getTipo().toUpperCase() != beneInElenco.getTipologia().toUpperCase()}">  
									   			<option value="${tipoBene.getId()}">${tipoBene.getTipo().toUpperCase()}</option>
									   	</c:if>
                                             
                                        </c:forEach>
                                </c:if>
                         </select>
                     </div>
                     <div class="ama-col-md-7 ama-col-xs-12 mb-25-md">
                         <label for="argument6<%=countBene%>" class="label-form"><liferay-ui:message key="beni-inv-bene"/>*</label>
                         <%
                         BeneInvRichiesto beneInvRichiesto =(BeneInvRichiesto) pageContext.getAttribute("beneInElenco");
                         long id_tipo = 0;
                         for (TipoBeneInv tipoBeneInv : listTipoBeniInv) {
                        	 if (tipoBeneInv.getTipo().equalsIgnoreCase(beneInvRichiesto.getTipologia())) {
                        		 id_tipo = tipoBeneInv.getPrimaryKey();
                        	 }
                         }
                         List <BeneInv> beniListByIdTipo = BeneInvLocalServiceUtil.getBeneInvByTipoBene(id_tipo);
                         %>
                         <select id="argument6<%=countBene%>" class="checkValid option-select-notice  SelectBene data-parsley-validated"
                         	data-parsley-required="true"
							data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden ><liferay-ui:message key="beni-inv-scegli-bene"/></option>
                              <c:forEach items="<%=beniListByIdTipo%>" var="beneInv">
                                        <c:if test="${beneInv.getBene().toUpperCase() == beneInElenco.getDescrizione().toUpperCase()}">
										  		<option value="${beneInv.getId()}" selected = "true">${beneInv.getBene().toUpperCase()}</option>
									   	</c:if>
									   	<c:if test="${beneInv.getBene().toUpperCase() != beneInElenco.getDescrizione().toUpperCase()}">
									   			<option value="${beneInv.getId()}">${beneInv.getBene().toUpperCase()}</option>
									   	</c:if>
                                        </c:forEach>
                         </select>
                     </div>
                     <div class="ama-col-md-2 ama-col-xs-12 mb-25-md">
                         <label for="argument7" class="label-form "><liferay-ui:message key="beni-inv-richiesta-quantita"/>*</label>
                         <input 
                          	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                          	data-parsley-type="number"
							data-parsley-type-message="<liferay-ui:message key="error-number-message"/>"
							data-parsley-min="1" 
							data-parsley-min-message="<liferay-ui:message key="error-min-message"/>" 
                         	id="argument7" class="checkValid input-custom-light InputQuantitaBeni data-parsley-validated" value="${beneInElenco.getQuantita()}">
                     </div>
                     <div class="ama-col-xs-12 mb-25-xs">
                         <label for="argument8" class="label-form "><liferay-ui:message key="beni-inv-richiesta-dettagli"/></label>
                         <input id="argument8" class="input-custom-light InputDettagli" value="<%=HtmlUtil.escape(beneInvRichiesto.getDettagli())%>">
                     </div>
                 </div>
        </div>             
                    </c:forEach>  
                              
              </c:if>
             
             <c:if test="${!empty listaRichiesteBeniInv}">
              <c:if test="<%=listBeniInElenco.size()==0%>">
              <% countBene = 0; %>
             
               <c:forEach items="${listaRichiesteBeniInv}" var="beneInvRichiesto">
               <%countBene++; 
               
               %>            
              <div id="bene<%=countBene%>" class="designBeneClass clearfix mt-30-xs">
                 <div class="wrap-beni-inventariati mb-25-md">
                     <span class="number"><%=countBene%></span>
                    <div class="position-button">
                         <button href="#" type="button" class=" button button-primary mt-0-xs removebtn" onclick="removeItemBene($('#bene<%=countBene%>'))">
                             <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-inv-rimuovi"/></button>
                     </div>
                 </div>
                 <div class="ama-row">
                     <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                         <label for="argument5<%=countBene%>" class="label-form"><liferay-ui:message key="beni-inv-tipologia"/>*</label>
                         <select id="argument5<%=countBene%>" class=" option-select-notice SelectTipo  data-parsley-validated" onchange="loadBeneInv(this.value, <%=countBene%>)"
                         	data-parsley-required="true"
						 	data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden><liferay-ui:message key="beni-inv-scelta-tipologia"/></option>
                             	<c:if test="<%=request.getAttribute("tipoBeneList")!=null%>">
                                        <c:forEach items="<%=request.getAttribute("tipoBeneList")%>" var="tipoBene">
                                        <c:if test="${tipoBene.getTipo().toUpperCase() == beneInvRichiesto.getTipologia()}">
										  		<option value="${tipoBene.getId()}" selected = "true">${tipoBene.getTipo().toUpperCase()}</option>
									   	</c:if>
									   	<c:if test="${tipoBene.getTipo().toUpperCase() != beneInvRichiesto.getTipologia()}">
									   			<option value="${tipoBene.getId()}">${tipoBene.getTipo().toUpperCase()}</option>
									   	</c:if>
                                             
                                        </c:forEach>
                                </c:if>
                         </select>
                     </div>
                     <div class="ama-col-md-7 ama-col-xs-12 mb-25-md">
                         <label for="argument6<%=countBene%>" class="label-form"><liferay-ui:message key="beni-inv-bene"/>*</label>
                         <%
                         ModuloBeneInv beneInvRichiesto =(ModuloBeneInv) pageContext.getAttribute("beneInvRichiesto");
                         long id_tipo = 0;
                         for (TipoBeneInv tipoBeneInv : listTipoBeniInv) {
                        	 if (tipoBeneInv.getTipo().equalsIgnoreCase(beneInvRichiesto.getTipologia())) {
                        		 id_tipo = tipoBeneInv.getPrimaryKey();
                        	 }
                         }
                         List <BeneInv> beniListByIdTipo = BeneInvLocalServiceUtil.getBeneInvByTipoBene(id_tipo);
                         %>
                         <select id="argument6<%=countBene%>" class=" option-select-notice SelectBene data-parsley-validated"
                         	data-parsley-required="true"
							data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden ><liferay-ui:message key="beni-inv-scegli-bene"/></option>
                              <c:forEach items="<%=beniListByIdTipo%>" var="beneInv">
                                        <c:if test="${beneInv.getBene().toUpperCase() == beneInvRichiesto.getBene().toUpperCase()}">
										  		<option value="${beneInv.getId()}" selected = "true">${beneInv.getBene().toUpperCase()}</option>
									   	</c:if>
									   	<c:if test="${beneInv.getBene().toUpperCase() != beneInvRichiesto.getBene().toUpperCase()}">
									   			<option value="${beneInv.getId()}">${beneInv.getBene().toUpperCase()}</option>
									   	</c:if>
                                        </c:forEach>
                         </select>
                     </div>
                     <div class="ama-col-md-2 ama-col-xs-12 mb-25-md">
                         <label for="argument7" class="label-form "><liferay-ui:message key="beni-inv-richiesta-quantita"/>*</label>
                         <input 
                          	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-type="number"
							data-parsley-type-message="<liferay-ui:message key="error-number-message"/>"
							data-parsley-min="1" 
							data-parsley-min-message="<liferay-ui:message key="error-min-message"/>" 
                         	id="argument7" class=" input-custom-light InputQuantitaBeni data-parsley-validated" value="${beneInvRichiesto.getQuantita()}">
                     </div>
                     <div class="ama-col-xs-12 mb-25-xs">
                         <label for="argument8" class="label-form "><liferay-ui:message key="beni-inv-richiesta-dettagli"/></label>
                         <input id="argument8" class="input-custom-light InputDettagli" value="<%= HtmlUtil.escape(beneInvRichiesto.getDettagli()) %>">
                     </div>
                 </div>
        </div>             
                    </c:forEach>  
                              
              </c:if>
              </c:if>
            
             <c:if test="${empty listaRichiesteBeniInv}">
             <c:if test="<%=listBeniInElenco.size()==0%>">
            <div id="bene<%=countBene%>" class="designBeneClass clearfix mt-30-xs">
             <form>
                 <div class="wrap-beni-inventariati mb-25-md">
                     <span class="number"><%=countBene%></span>
                    <div class="position-button">
                         <button href="#" type="button" class=" button button-primary mt-0-xs removebtn" onclick="removeItemBene($('#bene<%=countBene%>'))">
                             <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-inv-rimuovi"/></button>
                     </div>
                 </div>
                 <div class="ama-row">
                     <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                         <label for="argument5<%=countBene%>" class="label-form"><liferay-ui:message key="beni-inv-tipologia"/>*</label>
                         <select id="argument5<%=countBene%>" class="checkValid option-select-notice SelectTipo data-parsley-validated" onchange="loadBeneInv(this.value, <%=countBene%>)"
                         	data-parsley-required="true"
						 	data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden><liferay-ui:message key="beni-inv-scelta-tipologia"/></option>
                             	<c:if test="<%=request.getAttribute("tipoBeneList")!=null%>">
                                        <c:forEach items="<%=request.getAttribute("tipoBeneList")%>" var="tipoBene">
                                              <option value="${tipoBene.getId()}">${tipoBene.getTipo().toUpperCase()}</option>
                                        </c:forEach>
                                </c:if>
                         </select>
                     </div>
                     <div class="ama-col-md-7 ama-col-xs-12 mb-25-md">
                         <label for="argument6<%=countBene%>" class="label-form"><liferay-ui:message key="beni-inv-bene"/>*</label>
                         <select id="argument6<%=countBene%>" class="checkValid option-select-notice SelectBene" disabled
                         	data-parsley-required="true"
						 	data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden ><liferay-ui:message key="beni-inv-scegli-bene"/></option>
                         </select>
                     </div>
                     <div class="ama-col-md-2 ama-col-xs-12 mb-25-md">
                         <label for="argument7" class="label-form "><liferay-ui:message key="beni-inv-richiesta-quantita"/>*</label>
                         <input
                         	data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
							data-parsley-type="number"
							data-parsley-type-message="<liferay-ui:message key="error-number-message"/>"
							data-parsley-min="1" 
							data-parsley-min-message="<liferay-ui:message key="error-min-message"/>" 
                         	id="argument7" class="checkValid input-custom-light InputQuantitaBeni " placeholder="0">
                     </div>
                     <div class="ama-col-xs-12 mb-25-xs">
                         <label for="argument8" class="label-form "><liferay-ui:message key="beni-inv-richiesta-dettagli"/></label>
                         <input id="argument8" class="input-custom-light InputDettagli" placeholder='<liferay-ui:message key="placeholder-aggiungi-descrizione"/>'>
                     </div>
                 </div>
                </form>
        </div>
        </c:if>
        </c:if>
        </div>
         <div class="mt-30-xs mb-30-xs">
                    <button href="#" type="button" id="addNewRequest" class=" button button-primary">
                        <span class="icomoon-plus icon mr-10-xs"></span><liferay-ui:message key="beni-inv-aggiungi-richiesta"/>
                    </button>
          </div>
                     <p class="title-form mb-10-xs mt-20-xs"><liferay-ui:message key="beni-inv-non-elenco"/></p>
                     <div class="ama-row" id="divBeniNonInElenco" data-parsley-validate="true">
<!--                      <form id="formBeniNonInElenco" > -->
                         <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                             <label for="idTipoNonInElenco" class="label-form"><liferay-ui:message key="beni-inv-tipologia"/></label>
                             <c:if test="${tipoNonInElenco == null}">
                               <c:if test="<%=listBeniNonInElenco.size()==0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="idTipoNonInElenco" class="nonElenco input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-inserimento-tipologia"/>" name="<portlet:namespace/>tipoNonInElenco"
                             	onblur="checkValidNonElenco()"
                             	onkeyup="checkRequired()">
                               </c:if>
                             </c:if>
                             <c:if test="${tipoNonInElenco != null}">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="idTipoNonInElenco" class="nonElenco input-custom-light data-parsley-validated" value="${tipoNonInElenco.toUpperCase()}" name="<portlet:namespace/>tipoNonInElenco"
                             	onblur="checkValidNonElenco()"
                             	onkeyup="checkRequired()">
                             </c:if>
                             <c:if test="<%=listBeniNonInElenco.size()>0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="idTipoNonInElenco" class="nonElenco input-custom-light data-parsley-validated"  value="<%=HtmlUtil.escape(listBeniNonInElenco.get(0).getTipologia()).toUpperCase()%>" name="<portlet:namespace/>tipoNonInElenco"
                             	onblur="checkValidNonElenco()"
                             	onkeyup="checkRequired()">
                             </c:if>
                         </div>
                         <div class="ama-col-md-7 ama-col-xs-12 mb-25-md">
                             <label for="idDescNonInElenco" class="label-form"><liferay-ui:message key="beni-non-elenco-descrizione"/></label>
                             <c:if test="${descNonInElenco == null}">
                               <c:if test="<%=listBeniNonInElenco.size()==0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="idDescNonInElenco" class="nonElenco input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-inserimento-descrizione"/>" name="<portlet:namespace/>descNonInElenco"
                             	onblur="checkValidNonElenco()"
                             		onkeyup="checkRequired()">
                               </c:if>
                             </c:if>
                             <c:if test="${descNonInElenco != null}">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="idDescNonInElenco" class="nonElenco input-custom-light data-parsley-validated" value="${descNonInElenco.toUpperCase()}" name="<portlet:namespace/>descNonInElenco"
                             	onblur="checkValidNonElenco()"
                             		onkeyup="checkRequired()">
                             </c:if>
                             <c:if test="<%=listBeniNonInElenco.size()>0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                             	id="idDescNonInElenco" class="nonElenco input-custom-light data-parsley-validated" value="<%=HtmlUtil.escape(listBeniNonInElenco.get(0).getDescrizione()).toUpperCase()%>" name="<portlet:namespace/>descNonInElenco"
                             	onblur="checkValidNonElenco()"
                             		onkeyup="checkRequired()">
                             </c:if>
                         </div>
                         <div class="ama-col-md-2 ama-col-xs-12 mb-25-md">
                             <label for="idQuantitaNonInElenco" class="label-form "><liferay-ui:message key="beni-inv-richiesta-quantita"/></label>
                             <c:if test="${quantitaNonInElenco == null}">
                               <c:if test="<%=listBeniNonInElenco.size()==0%>">
                             <input 
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-type="number"
							    data-parsley-type-message="<liferay-ui:message key="error-number-message"/>"
								data-parsley-min="1" 
								data-parsley-min-message="<liferay-ui:message key="error-min-message"/>" 
                             	id="idQuantitaNonInElenco" class="nonElenco input-custom-light data-parsley-validated" placeholder="0" name="<portlet:namespace/>quantitaNonInElenco"
                             	onblur="checkValidNonElenco()"
                             		onkeyup="checkRequired()">
                               </c:if>
                             </c:if>
                             <c:if test="${quantitaNonInElenco != null}">
                             <input
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
								data-parsley-type="number"
							    data-parsley-type-message="<liferay-ui:message key="error-number-message"/>"
								data-parsley-min="1" 
								data-parsley-min-message="<liferay-ui:message key="error-min-message"/>" 
                             	id="idQuantitaNonInElenco" class="nonElenco input-custom-light data-parsley-validated" value="${quantitaNonInElenco.toUpperCase()}" name="<portlet:namespace/>quantitaNonInElenco"
                             	onblur="checkValidNonElenco()"
                             		onkeyup="checkRequired()">
                             </c:if>
                             <c:if test="<%=listBeniNonInElenco.size()>0%>">
                             <input
                             	data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
								data-parsley-type="number"
							    data-parsley-type-message="<liferay-ui:message key="error-number-message"/>"
								data-parsley-min="1" 
								data-parsley-min-message="<liferay-ui:message key="error-min-message"/>" 
                             	id="idQuantitaNonInElenco" class="nonElenco input-custom-light data-parsley-validated" value="<%=listBeniNonInElenco.get(0).getQuantita()%>" name="<portlet:namespace/>quantitaNonInElenco"
                             	onblur="checkValidNonElenco()"
                             		onkeyup="checkRequired()">
                             </c:if>
                         </div>
                         <div class="ama-col-xs-12 mb-25-md">
                             <label for="argument8" class="label-form "><liferay-ui:message key="beni-inv-richiesta-dettagli"/></label>
                             <c:if test="${dettagliNonInElenco == null}">  
                                <c:if test="<%=listBeniNonInElenco.size()==0%>">
                             <input id="idDettagliNonInElenco" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-aggiungi-descrizione"/>" name="<portlet:namespace/>dettagliNonInElenco">
                             	</c:if>
                             </c:if>
                             <c:if test="${dettagliNonInElenco != null}">
                             <input id="idDettagliNonInElenco" class="input-custom-light" value="${dettagliNonInElenco}" name="<portlet:namespace/>dettagliNonInElenco">
                             </c:if>
                             <c:if test="<%=listBeniNonInElenco.size()>0%>">
                             <input id="idDettagliNonInElenco" class="input-custom-light" value="<%=HtmlUtil.escape(listBeniNonInElenco.get(0).getDettagli())%>" name="<portlet:namespace/>dettagliNonInElenco">
                             </c:if>
                         </div>
<!--                          </form> -->
                     </div>
         </div>
         </form>
         <div class="ama-row">
             <div class="ama-col-xs-12 text-center mb-100-md mb-30-xs mt-30-sm mt-50-md mt-20-xs">
                 <button class="button button-primary" id="prosegui"><liferay-ui:message key="beni-inv-prosegui"/></button>
             </div>
         </div>
     </div>
     
       <div id="designBeneNone" style="display:none">
      <form>
              <div class="wrap-beni-inventariati mb-25-md">
                     <span class="number"><%=countBene%></span>
                     <div class="position-button">
                         <button href="#" type="button" class=" button button-primary mt-0-xs removebtn">
                             <span class="icon icomoon-trash1 mr-10-xs"></span><liferay-ui:message key="beni-inv-rimuovi"/></button>
                     </div>
                 </div>
                 <div class="ama-row">
                     <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                         <label id="labelTipo" for="argument5" class="label-form"><liferay-ui:message key="beni-inv-tipologia"/>*</label>
                         <select id="argument5" class="checkValid option-select-notice SelectTipo data-parsley-validated" 
                         	data-parsley-required="true"
						 	data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden><liferay-ui:message key="beni-inv-scelta-tipologia"/></option>
                             	<c:if test="<%=request.getAttribute("tipoBeneList")!=null%>">
                                        <c:forEach items="<%=request.getAttribute("tipoBeneList")%>" var="tipoBene">
                                              <option value="${tipoBene.getId()}">${tipoBene.getTipo().toUpperCase()}</option>
                                        </c:forEach>
                                </c:if>
                         </select>
                     </div>
                     <div class="ama-col-md-7 ama-col-xs-12 mb-25-md">
                         <label for="argument6" class="label-form"><liferay-ui:message key="beni-inv-bene"/>*</label>
                         <select id="argument6" class="checkValid option-select-notice SelectBene data-parsley-validated" disabled
                         	data-parsley-required="true"
						    data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                             <option value="" hidden><liferay-ui:message key="beni-inv-scegli-bene"/></option>
                         </select>
                     </div>
                     <div class="ama-col-md-2 ama-col-xs-12 mb-25-md">
                         <label for="argument7" class="label-form "><liferay-ui:message key="beni-inv-richiesta-quantita"/>*</label>
                         <input 
                            data-parsley-required="true"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							data-parsley-type="number"
							data-parsley-type-message="<liferay-ui:message key="error-number-message"/>"
							data-parsley-min="1" 
							data-parsley-min-message="<liferay-ui:message key="error-min-message"/>" 
                         	id="argument7" class="checkValid input-custom-light InputQuantitaBeni" placeholder="0">
                     </div>
                     <div class="ama-col-xs-12 mb-25-xs">
                         <label for="argument8" class="label-form "><liferay-ui:message key="beni-inv-richiesta-dettagli"/></label>
                         <input id="argument8" class="input-custom-light InputDettagli" placeholder='<liferay-ui:message key="placeholder-aggiungi-descrizione"/>'>

                     </div>
                 </div>
       </form>
       </div>
     
 <script>
 var designBeneNone = $("#designBeneNone").html();
 var countBene = <%=countBene%>;
 var countBeneId = <%=countBene%>;
 
 
var countCheckValid = 0;
var countCheckValidLength = 0;
var checkNonElenco = true;


function checkRequired(){
	
	var inputNonInElenco=false;	
	
$('#divBeniNonInElenco').find('.nonElenco').each(function(key,value){	
		
		if(($(this).val()!="" ) ){
			inputNonInElenco=true;
		}
	});

$('#divBeniNonInElenco').find('.nonElenco').each(function(key,value){
	
	var label = $("label[for='"+$(this).attr('id')+"']");
	if(inputNonInElenco==true && !$(label).text().includes("*")){
		$(label).text($(label).text()+"*");
	}
	else if(inputNonInElenco==false && $(label).text().includes("*"))
	{
		$(label).text($(label).text().replace('*',''));
		$("#divBeniNonInElenco").parsley().destroy();
	}
});

}



function checkValidNonElenco(){
	
	if($("#idTipoNonInElenco").val()=="" && $("#idDescNonInElenco").val()=="" && $("#idQuantitaNonInElenco").val()=="")	{
	
	
	$("#idTipoNonInElenco").parsley().destroy();
	$("#idDescNonInElenco").parsley().destroy();
	$("#idQuantitaNonInElenco").parsley().destroy();
	}
}

 jsonObj = {};
 var itemRichiesta = {};

 function addNewItemBene(){
   
		countBeneId++;	
		countBene++;
		var htmlDesignBene = designBeneNone;

		var divMaster = document.createElement("div");
		$(divMaster).attr("id","bene"+countBeneId);
		$(divMaster).addClass("designBeneClass");
		$(divMaster).addClass("clearfix mt-30-xs");
		$(divMaster).append(htmlDesignBene);
		$(divMaster).find(".number").html(countBene);

		$(divMaster).find('#argument5').attr("id",'argument5' + countBeneId);
		$(divMaster).find('#labelTipo').attr("for",'argument5' + countBeneId);
		$(divMaster).find('#argument6').attr("id",'argument6' + countBeneId);
		

		
		var count = countBeneId;
		$(divMaster).find(".removebtn").each(function(){
			
			$(this).click(function (){						
				removeItemBene("#bene"+count);
			});						
		});
		$("#designBene").append(divMaster);
		$('#argument5'+ countBeneId).change(function(){
			loadBeneInv(this.value,countBeneId);
		});

}
 
 
 function removeItemBene(idItemBene){
	 	
	 $(idItemBene).remove();
	 countBene--;
	 
	 if (countBene<1){	
		countBene=0;
	 }else{
		var countnumber=1;
		$('div[id^="bene"]').find('.number').each(function(key,value) {
			$(this).html(countnumber);
			countnumber++;
		});
	 }
		 
 } 
 
 $("#addNewRequest").click("on",function(){
	 countCheckValidLength = $('#designBene').find('.checkValid').length;
	 countCheckValid = 0;
     $('#designBene').find('.checkValid').each(function(key,value) { 
   	  if($(this).val()==""){
   		  countCheckValid++;	  
   	  }
     });

	 if(countCheckValid==0){
	 addNewItemBene();
	 }
	 else{
 $('#designBene').find('.checkValid').each(function(key,value) { 
				$(this).parsley().validate(); 

			});	
	 }
 });
   
 function loadBeneInv(id,counter){
    		$('#argument6'+counter).find('option').remove().end().append('<option value="" hidden >SCEGLI IL BENE</option>').val('');
    	 	 $('#argument6'+counter).attr('disabled',false) ;
    		Liferay.Service(
    			  '/mform.beneinv/get-bene-inv-by-tipo-bene',
    			  {
    			    id_tipo:id
    			  },
    			  function(obj) { 				 
    				  $.each(obj, function(key, value) {
    					  var beneInv=value.bene;
     					  var idBeneInv=value.id;
    					  var beneOption = document.createElement("option");
    					  beneOption.text = beneInv.toUpperCase();
    					  beneOption.value = idBeneInv;				
    					  $('#argument6'+counter).append(beneOption); 
    				  }
    				  );
    			  }
    			);
    
     }
     
     $("#prosegui").click("on",function(){

    	 var array = [];
    	 var oggetto = $("#IntOggetto").val();
    	 var data = $("#IntData").val();
    	 var nomeBenef = $("#IntNomeBenef").val();
    	 var cognomeBenef = $("#IntCognomeBenef").val();
    	 var emailBenef = $("#IntEmailBenef").val();
    	 var destinazione = $("#IntDestinazione").val();
    	 var tipoNonInElenco = $("#idTipoNonInElenco").val();
    	 var descNonInElenco = $("#idDescNonInElenco").val();
    	 var quantitaNonInElenco = $("#idQuantitaNonInElenco").val();
    	 var dettagliNonInElenco = $("#idDettagliNonInElenco").val();
  		
  		$("#TitoloContainer").find(".designBeneClass").each(function(key,value) {
        
    		 itemRichiesta ={
    				 
      				 tipologia:$(this).find(".SelectTipo option:selected").text(),
      				 bene:$(this).find(".SelectBene option:selected").text(),
   				     quantita:$(this).find(".InputQuantitaBeni")["0"].value,
   				     dettagli:$(this).find(".InputDettagli")["0"].value
};
 				
 			array.push(itemRichiesta);
 		
    	 });
     	 
     	jsonObj = {
     			oggetto : oggetto,
     			data : data,
     			nomeBenef : nomeBenef,
     			cognomeBenef : cognomeBenef,
     			emailBenef : emailBenef,
     			destinazione : destinazione,
     			tipoNonInElenco : tipoNonInElenco,
     			descNonInElenco : descNonInElenco,
     			quantitaNonInElenco : quantitaNonInElenco,
     			dettagliNonInElenco : dettagliNonInElenco,
   	            richieste : array };
   	
   	$("#listRichiestaBeniInv").val(JSON.stringify(jsonObj));
	$("#IntUfficioRichiedente").parsley().validate();
	$("#IntNomeRich").parsley().validate();
	$("#IntCognomeRich").parsley().validate();
	$("#IntEmailDirigente").parsley().validate();
 	$("#IntDestinazione").parsley().validate();
 	$("#IntNomeBenef").parsley().validate();	
 	$("#IntCognomeBenef").parsley().validate();	
 	$("#IntEmailBenef").parsley().validate();
 	
 	var validbene = true;
 	var validNonInElenco = true;
 
 countCheckValid=0;
 countCheckValidLength = $('#designBene').find('.checkValid').length;
  
          $('#designBene').find('.checkValid').each(function(key,value) { 
        	  if($(this).val()==""){
        		  countCheckValid++;
        		  
        	  }
          });

			if((countCheckValid!=(countCheckValidLength) || $('.InputDettagli').val()!="") && ($("#idTipoNonInElenco").val()!="" || $("#idDescNonInElenco").val()!="" || $("#idQuantitaNonInElenco").val()!="" )){
				$('#<portlet:namespace/>inputBeni').val("tutte");	
				
			}
			else if((countCheckValid!=(countCheckValidLength) || $('.InputDettagli').val()!="" )  &&  (!$("#idTipoNonInElenco").val()!="" && !$("#idDescNonInElenco").val()!="" && !$("#idQuantitaNonInElenco").val()!="" || !$("#idDettagliNonInElenco").val()!="")){
				$('#<portlet:namespace/>inputBeni').val("beni in elenco");	
				
			}
			else if((countCheckValid==(countCheckValidLength) && $('.InputDettagli').val()=="" )  && ($("#idTipoNonInElenco").val()!="" || $("#idDescNonInElenco").val()!="" || $("#idQuantitaNonInElenco").val()!="" || $("#idDettagliNonInElenco").val()!="")){
				$('#<portlet:namespace/>inputBeni').val("beni non in elenco");	
				
			}
			

			$('#<portlet:namespace/>inputBeni').parsley().validate();			
			if($('#<portlet:namespace/>inputBeni').parsley().isValid()){
				
				var inputBeni=$('#<portlet:namespace/>inputBeni').val();
			
				
				if(inputBeni=="tutte"){
					  $('#designBene').find('.checkValid').each(function(key,value) { 
		 				$(this).parsley().validate(); 
		 				if(!$(this).parsley().isValid()){
	 					validbene = false;
	 				}
		 			
		 			});	
		 				

			  	 $("#divBeniNonInElenco").parsley().validate();
			  	
			  	 if(!$("#divBeniNonInElenco").parsley().isValid()){
					 validNonInElenco=false;
				 }

				}
				
				
				else if(inputBeni=="beni in elenco"){
					
					if($("#idTipoNonInElenco").val()=="" && $("#idDescNonInElenco").val()=="" && $("#idQuantitaNonInElenco").val()==""){
					
					$("#divBeniNonInElenco").parsley().destroy();
					
                      }

					  $('#designBene').find('.checkValid').each(function(key,value) { 
			 				$(this).parsley().validate(); 
			 				if(!$(this).parsley().isValid()){
		 					validbene = false;
		 				}
			 			
			 			});	

					
				}
				
				else if(inputBeni=="beni non in elenco"){					
                    $("#divBeniNonInElenco").parsley().validate();
                    
                    
                    $('#designBene').find('.checkValid').each(function(key,value) { 
		 				$(this).parsley().destroy(); 
		 			});	
                    
                    
               	 if(!$("#divBeniNonInElenco").parsley().isValid()){
						 validNonInElenco=false;
					 }

				}
			}
	
			   $("#formBeniInv").parsley().validate();
			
			   if($('#<portlet:namespace/>inputBeni').parsley().isValid() ){
			   if( $("#formBeniInv").parsley().isValid() && $("#IntDestinazione").parsley().isValid()&& $("#IntNomeBenef").parsley().isValid() && $("#IntCognomeBenef").parsley().isValid() && $("#IntEmailBenef").parsley().isValid() && validbene && validNonInElenco  ){	 
				   $("#formBeniInv").submit(); 	
			   }
			   }
			   $('#<portlet:namespace/>inputBeni').val("");
 });
 
 
 </script>    