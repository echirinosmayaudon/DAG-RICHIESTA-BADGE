<%@page import="mef.richieste.beni.inventariati.bean.ModuloBeneInv"%>
<%@page import="mef.richieste.beni.inventariati.bean.Utente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.intranet.mef.model.RichiestaBeneInv"%>
<%@page import="service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil "%>

<%
List<ModuloBeneInv> listBeniInv  = (List<ModuloBeneInv>) request.getAttribute("listRichiesteBeniInv");
Utente richiedenteRiepilogo = (Utente) request.getAttribute("richiedenteRiepilogo");
%>

<c:set value="<%=listBeniInv%>" var="listBeniInv"></c:set>

<portlet:actionURL name="insertBeneInv" var="insertBeneInvURL"></portlet:actionURL>
<portlet:actionURL name="newRichiestaBeneInv" var="newRichiestaURL"></portlet:actionURL>

<portlet:actionURL name="modificaDati" var="modificaDatiURL">
	<portlet:param name="nome" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getNome())%>" />
	<portlet:param name="cognome" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getCognome())%>" />
	<portlet:param name="ufficioRichiedente" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getUfficioRichiedente())%>" />
	<portlet:param name="ubicazione" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getUbicazione())%>" />
	<portlet:param name="palazzina" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getPalazzina())%>" />
	<portlet:param name="piano" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getPiano())%>" />
	<portlet:param name="scala" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getScala())%>" />
	<portlet:param name="stanza" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getStanza())%>" />
	<portlet:param name="telefono" value="${richiedenteRiepilogo.getTelefono()}" />
	<portlet:param name="emailDirigente" value="${richiedenteRiepilogo.getEmailDirigente()}" />
	<portlet:param name="oggetto" value="<%=HtmlUtil.escape((String)request.getAttribute("oggetto"))%>" />
	<portlet:param name="data" value="${data}" />
	<portlet:param name="nomeBenef" value="<%=HtmlUtil.escape((String)request.getAttribute("nomeBenef"))%>" />
	<portlet:param name="cognomeBenef" value="<%=HtmlUtil.escape((String)request.getAttribute("cognomeBenef"))%>" />
	<portlet:param name="emailBenef" value="${emailBenef}" />
	<portlet:param name="destinazione" value="<%=HtmlUtil.escape((String)request.getAttribute("destinazione"))%>" />
	<portlet:param name="tipoNonInElenco" value="<%=HtmlUtil.escape((String)request.getAttribute("tipoNonInElenco"))%>" />
	<portlet:param name="descNonInElenco" value="<%=HtmlUtil.escape((String)request.getAttribute("descNonInElenco"))%>" />
	<portlet:param name="quantitaNonInElenco" value="<%=HtmlUtil.escape((String)request.getAttribute("quantitaNonInElenco"))%>" />
	<portlet:param name="dettagliNonInElenco" value="<%=HtmlUtil.escape((String)request.getAttribute("dettagliNonInElenco"))%>" />
</portlet:actionURL>


<div class="trasporti-header">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper">
                        <h2 class="title"><liferay-ui:message key="beni-inv-dettaglio-title"/>
                        </h2>
                        <p class="subtitle dot-point dot-200"><liferay-ui:message key="beni-inv-dettaglio-sub"/></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="beni-inv-dettaglio-ufficio-rich"/></h2>
                    </div>
                </div>
            </div>
            <form action="<%=insertBeneInvURL%>" method="post" id="formInvia" enctype="multipart/form-data">
            <div class="ama-row">
                    <div class="ama-col-xs-12 mobile-no-padding">
                        <div class="wrapper-istanza-trasporti mobile-no-padding">
                        <div class="box-gray">
                            <div class=" box-white pb-0-xs">	
                            <input type="hidden" name="<portlet:namespace/>nome" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getNome()).toUpperCase()%>" /> 
							<input type="hidden" name="<portlet:namespace/>cognome" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getCognome()).toUpperCase()%>" /> 											
							<input type="hidden" id="idJsonBeniInv" name="<portlet:namespace/>richiesteJson" value="" />
							<input type="hidden" name="<portlet:namespace/>dipRichiedente" value="${richiedenteRiepilogo.getDipartimento().toUpperCase()}">
				            <input type="hidden" name="<portlet:namespace/>screenNameUtente"  value="${userScreenName}">
                                <p class="name">${richiedenteRiepilogo.getNome().toUpperCase()} ${richiedenteRiepilogo.getCognome().toUpperCase()}</p>
                                <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
            
                                <div id="collapse-trasporti" class="collapse1 in no-overflow">
                                    <div class="ama-row border-section border-mobile">
                                        <div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-dettaglio-ufficio-rich"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>ufficioRichiedente" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getUfficioRichiedente()).toUpperCase()%>" />
                                            <p class="info">${richiedenteRiepilogo.getUfficioRichiedente().toUpperCase()}</p>
                                        </div>
                                    </div>
            
                                    <div class="ama-row">
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="beni-inv-riepilogo-ubicazione"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>ubicazione" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getUbicazione()).toUpperCase()%>" />
                                            <p class="info">${richiedenteRiepilogo.getUbicazione().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-sm"><liferay-ui:message key="beni-inv-riepilogo-palazzina"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>palazzina" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getPalazzina()).toUpperCase()%>" />
                                            <p class="info">${richiedenteRiepilogo.getPalazzina().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="beni-inv-riepilogo-piano"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>piano" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getPiano()).toUpperCase()%>" />
                                            <p class="info">${richiedenteRiepilogo.getPiano().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="beni-inv-riepilogo-scala"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>scala" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getScala()).toUpperCase()%>" />
                                            <p class="info">${richiedenteRiepilogo.getScala().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-riepilogo-stanza"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>stanza" value="<%=HtmlUtil.escape(richiedenteRiepilogo.getStanza()).toUpperCase()%>" />
                                            <p class="info">${richiedenteRiepilogo.getStanza().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-riepilogo-telefono"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>telefono" value="${richiedenteRiepilogo.getTelefono().toUpperCase()}" />
                                            <p class="info">${richiedenteRiepilogo.getTelefono().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-riepilogo-email-dir"/>:</span>
                                            <input type="hidden" name="<portlet:namespace/>emailDirigente" value="${richiedenteRiepilogo.getEmailDirigente()}" />
                                            <p class="info">${richiedenteRiepilogo.getEmailDirigente()}</p>
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
                                        <%
                                        //insert db richiesta beni inventariati
                                        RichiestaBeneInv richiestaBeneInv=null;
                                        RichiestaBeneInv richiestainserita=RichiestaBeneInvLocalServiceUtil.insertRichiestaBeneInv();
                                        if(richiestainserita!=null){
                                        	richiestaBeneInv=richiestainserita;
                                        }

                                        %>
                                            <span class="section-information">ID</span>
                                            <input type="hidden" name="<portlet:namespace/>idRichiesta" value="<%=richiestaBeneInv.getId_richiesta()%>" /> 
                                            <p class="info"><%=richiestaBeneInv.getId_richiesta()%></p>
                                        </div>
                                        
                                      
                                        <c:if test="<%= request.getAttribute("oggetto")!=null && !((String)request.getAttribute("oggetto")).equals("") %>">                
                                        <div class="ama-col-md-3 ama-col-xs-12 mt-20-xs mt-0-sm">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-riepilogo-oggetto"/></span>
                                            <p class="info">${oggetto.toUpperCase()}</p>
                                        </div>
                                       
                                        </c:if>
                                        <div class="ama-col-md-3 ama-col-xs-12 mt-20-xs mt-0-sm">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-riepilogo-data-richiesta"/></span>
                                            <p class="info">${data}</p>
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
                                            <span class="section-information"><liferay-ui:message key="beni-inv-riepilogo-beneficiario"/>:</span>
                                                <p class="information">${nomeBenef.toUpperCase()} ${cognomeBenef.toUpperCase()}</p>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-xs-12">
                                            <span class="section-information">EMAIL:</span>
                                                <p class="information">${emailBenef}</p>
                                        </div>
                                        <div class="ama-col-md-6 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="beni-inv-riepilogo-destinazione"/>:</span>
                                                <p class="information">${destinazione.toUpperCase()}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
            
            
                        <p class="title-form mt-20-xs ml-20-xs ml-0-sm mb-10-xs mb-0-sm"><liferay-ui:message key="beni-inv-riepilogo-richiesta-beni"/></p>
                        <div class="no-overflow">
                       
                        <c:forEach items="${listBeniInv}" var="beneInv">
							<div class="box-gray padding-mobile-servizi">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width">${listBeniInv.indexOf(beneInv)+1}.</span>
                                        </div>
                                        <div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width">${beneInv.getTipologia().toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width">${beneInv.getQuantita().toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width">${beneInv.getBene().toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-5 ama-col-sm-12 ama-col-xs-12 mt-10-xs mt-0-md">
                                            <span class="section-information width">${beneInv.getDettagli()}
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
						</c:forEach>
                        </div>
                        
                        
                        
                       
                        <c:if test="<%= request.getAttribute("tipoNonInElenco")!=null && !((String)request.getAttribute("tipoNonInElenco")).equals("")%>">
                        <p class="title-form mt-20-xs ml-20-xs ml-0-sm mb-10-xs mb-0-sm"><liferay-ui:message key="beni-inv-riepilogo-non-elenco"/></p>
                        <div class="no-overflow">
                            <div class="box-gray padding-mobile-servizi">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width">1.</span>
                                        </div>
                                        <div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width">${tipoNonInElenco.toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-1 ama-col-sm-6 ama-col-xs-6 border">
                                            <span class="section-information width">${quantitaNonInElenco.toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-6 border border-none">
                                            <span class="section-information width">${descNonInElenco.toUpperCase()}</span>
                                        </div>
                                        <div class="ama-col-md-5 ama-col-sm-12 ama-col-xs-12 mt-10-xs mt-0-md">
                                            <span class="section-information width">${dettagliNonInElenco}
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:if>
                    </div>
                </div>
            </div>
            </form>
            

            <div class="text-center">
                <div class="ama-col-md-4 ama-col-xs-12">
                <form action="<%=newRichiestaURL%>" method="post" id="formNuovaRichiesta">
                    <input type="hidden" name="<portlet:namespace/>idRichiesta" value="<%=richiestaBeneInv.getId_richiesta()%>" /> 
                    <button id="newReq" href="#" type="button" class="button button-secondary mt-100-md mt-30-sm mb-100-md"><liferay-ui:message key="beni-inv-riepilogo-annulla-richiesta"/></button>
                </form>	
                </div>
                <div class="ama-col-md-4 ama-col-xs-12">
                <form action="<%=modificaDatiURL%>" method="post" id="formModifica" enctype="multipart/form-data" >
                <input type="hidden" name="<portlet:namespace/>idRichiesta" value="<%=richiestaBeneInv.getId_richiesta()%>" /> 
                    <button id="modifica" href="#" type="button" class="button button-secondary mt-100-md mt-30-sm mb-100-md"><liferay-ui:message key="beni-inv-riepilogo-modifica"/></button>
                <input type="hidden" name="<portlet:namespace/>richiesteJson" id="richiesteBeniInvJson" value="">
                </form>
                </div>

                <div class="ama-col-md-4 ama-col-xs-12">
                    <button id="invia" href="#" type="button" class="button button-primary mt-100-md mt-30-sm mb-100-md mb-40-xs"><liferay-ui:message key="beni-inv-riepilogo-invia"/></button>
                </div>
            </div>

        </div>

<script>

$("#invia").click("on",function(){
$("#idJsonBeniInv").val(JSON.stringify(${listarichiesteJson}));	
console.log($("#idJsonBeniInv").val());
$("#formInvia").submit();	
});



$("#modifica").click("on",function(){

	$("#richiesteBeniInvJson").val(JSON.stringify(${listarichiesteJson}));
	
	$("#formModifica").submit();
	
});


$("#newReq").click("on",function(){
	
	$("#formNuovaRichiesta").submit();
	
});


</script>