<%@page import="service.intranet.mef.model.LogisticaRichieste"%>
<%@page import="service.intranet.mef.service.LogisticaRichiesteLocalServiceUtil"%>
<%@page import="com.intranet.mef.util.ServiziLogisticiDataUtil"%>
<%@page import="com.intranet.mef.bean.Richiedente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>

<%

String role = (String)request.getAttribute("role");
LogisticaRichieste richiesta = (LogisticaRichieste)request.getAttribute("richiesta"); 
if (richiesta == null){
	role="norole";
	String idRichiesta = (String)request.getParameter("richiestaId");
	richiesta = LogisticaRichiesteLocalServiceUtil.getLogisticaRichieste(Long.parseLong(idRichiesta));
	List<Role> listaRuoli=user.getRoles();
	
	for(Role ruolo: listaRuoli){
		if(ruolo.getName().equalsIgnoreCase("gestoredt") || ruolo.getName().equalsIgnoreCase("gestorergs") || ruolo.getName().equalsIgnoreCase("gestoredf") || ruolo.getName().equalsIgnoreCase("gestoredag")){
		     role="gestore";
	         break;
	}
	}
	
}

List<String> listaServizi =new ArrayList<String>(0);
Richiedente richiedente = new Richiedente(); 
String datarichiesta = new String();
Long idStato = 1L;
if (richiesta != null){
	 ServiziLogisticiDataUtil datautil = new ServiziLogisticiDataUtil();
	listaServizi = datautil.richiestaJsontoData(richiesta.getDettaglio_richieste());
	richiedente = datautil.richiedenteJsontoData(richiesta.getDettaglio_richiedente());	
	datarichiesta = new SimpleDateFormat("dd/MM/yyyy").format(richiesta.getData_richiesta());
	idStato = richiesta.getId_stato();
}


%>

<c:set value="<%=listaServizi%>" var="listaServizi"></c:set>
<c:set value="<%=richiedente%>" var="richiedente"></c:set>
<c:set value="<%=richiesta%>" var="richiesta"></c:set>
<c:set value="<%=datarichiesta%>" var="datarichiesta"></c:set>
<c:set value="<%=idStato%>" var="idStato"></c:set>
<c:set value="<%=role%>" var="role"></c:set>



<c:choose>	
		<c:when test='${role == "norole" }'>
		   <div class="ama-row">       
	           <div class="ama-col-md-3 ama-col-sm-6">
	               <p class="info"><liferay-ui:message key="servizi-logistici-forbidden" /></p>
	           </div>
  		   </div>
		</c:when>
<c:otherwise>
<portlet:actionURL name="gotoRichiesta" var="gotoRichiestaURL"/>

<portlet:actionURL name="gotoElenco" var="gotoElencoURL"/>

<portlet:actionURL name="accettaRifiutaRichiesta" var="accettaRifiutaRichiestaURL">
	<portlet:param name="richiestaId" value="${richiesta.getId()}" />
</portlet:actionURL>

<portlet:actionURL name="evadiValutaRichiesta" var="evadiValutaRichiestaURL">
    <portlet:param name="richiestaId" value="${richiesta.getId()}" />
</portlet:actionURL>

 <form action="<%=gotoRichiestaURL%>" method="post" id="<portlet:namespace/>formNuovaRichiesta" enctype="multipart/form-data" >
 </form>
 
    <div class="trasporti-header">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper pl-0-xs">
                        <h2 class="title-beni"><%=serviziLogisticiDettagliotitle%></h2>
                        <div class="wrap-icon-title mt-30-xs mt-0-md">
                        <c:if test='${role == "richiedente" }'>
	                        	 <button href="#" id="<portlet:namespace/>newReq" type="button" class="button button-primary mr-10-xs button-servizi-logistici"><liferay-ui:message key="servizi-logistici-dettaglio-nuova-richiesta"/>
	                                <span class="icomoon-plus icon-beni"></span>
	                            </button>	                        	                        	                        
                        </c:if>
                            
                            <a href="<%=gotoElencoURL%>" title="ritorna alla lista" class="icon icomoon-user2 mr-10-xs"></a>
                            
                            <a href="javascript:window.print()" title="stampa" class="icon icomoon-print"></a>
                        </div>
                    </div>
                    <div class="mt-50-xs display-responsive">
                        <p class="text-icon"><span class="mr-10-xs icomoon-calendar-date icon-beni"></span>${datarichiesta}</p>
                    </div>
    
                    <div class="display-responsive">
                        <div class="select-servizi">
                            <c:choose>
							<c:when	test='${idStato == 1}'>
								<a href="#" title="nuova"  class="box-white-beni back-image pr-100-md pl-20-md mt-30-xs mt-60-md ">
									<p class="current-selected text text-servizi">
										<span class="current-icon file icomoon-file mr-0-xs" ></span>
										<liferay-ui:message key="servizi-logistici-stato-nuova"/>
									</p>
								</a>
								<c:if test='${role == "gestore" }'>
								<div id="select" class="select-content animated fadeIn">
                                             <form action="<%=accettaRifiutaRichiestaURL%>" method="post" id="<portlet:namespace/>formAccettaRichiesta" enctype="multipart/form-data" >
                                             
                                               <input type="hidden" id="<portlet:namespace/>idstatoid" name="<portlet:namespace/>idstato">
                                             
                                             </form>
                                            
											<a href="#" id="<portlet:namespace/>idaccetta" class="element-select hide-box-giudizio" data-name="ACCETTATA" data-icon-image="icomoon-success-blu">
												<span class="cart icomoon-success-blu"></span>
												<liferay-ui:message key="servizi-logistici-stato-accettata"/>
											</a>
											<a href="#" id="<portlet:namespace/>idrifiuta" class="element-select hide-box-giudizio" data-name="RIFIUTATA" data-icon-image="icomoon-cart-2">
												<span class="cart icomoon-cancel"></span>
												 <liferay-ui:message key="servizi-logistici-stato-rifiutata"/>
											</a>										
											</div>
								</c:if>
								
		
							</c:when>
							
							<c:when	test='${idStato == 2}'>
								<a href="#" title="acettata"  class="box-white-beni back-image pr-100-md pl-20-md mt-30-xs mt-60-md ">
									<p class="current-selected text text-servizi">
										<span class="current-icon file icomoon-success-blu mr-0-xs" ></span>
										<liferay-ui:message key="servizi-logistici-stato-accettata"/>
									</p>
								</a>
									<c:if test='${role == "richiedente" }'>
									
									
									   <form action="<%=evadiValutaRichiestaURL%>" method="post" id="<portlet:namespace/>formEvadiRichiesta" enctype="multipart/form-data" >
                                             
                                               <input type="hidden" id="<portlet:namespace/>statoevasaid" name="<portlet:namespace/>idstato">
                                               <input type="hidden" id="<portlet:namespace/>valutazioneid" name="<portlet:namespace/>valutazione">
                                             
                                        </form>
									

										<div id="select" class="select-content animated fadeIn">

											<a href="#" id="<portlet:namespace/>idevasa" class="element-select cart box-giudizio"  data-name="EVASA" data-icon-image="icomoon-cart">
												<span class="cart icomoon-cart"></span>
												<liferay-ui:message key="servizi-logistici-stato-evasa"/>
											</a>
											<a href="#" id="<portlet:namespace/>idnonevasa" class="element-select hide-box-giudizio" data-name="NON EVASA" data-icon-image="icomoon-cart-2">
												<span class="cart icomoon-cart-2"></span>
												 <liferay-ui:message key="servizi-logistici-stato-non-evasa"/>
											</a>
											
										</div>
									</c:if>
							</c:when>
							
							<c:when	test='${idStato == 3}'>
								<a href="#" title="rifiutata"  class="box-white-beni back-image pr-100-md pl-20-md mt-30-xs mt-60-md ">
									<p class="current-selected text text-servizi">
										<span class="current-icon file icomoon-cancel mr-0-xs" ></span>
										<liferay-ui:message key="servizi-logistici-stato-rifiutata"/>
									</p>
								</a>
							</c:when>
						
							<c:when	test='${idStato == 4}'>
								<a href="#" title="evasa"  class="box-white-beni back-image pr-100-md pl-20-md mt-30-xs mt-60-md ">
									<p class="current-selected text text-servizi">
										<span class="current-icon file icomoon-cart mr-0-xs" ></span>
										<liferay-ui:message key="servizi-logistici-stato-evasa"/>
									</p>
								</a>
							</c:when>
							<c:when	test='${idStato == 5}'>
								<a href="#" title="non evasa"  class="box-white-beni back-image pr-100-md pl-20-md mt-30-xs mt-60-md ">
									<p class="current-selected text text-servizi">
										<span class="current-icon file icomoon-cart-2 mr-0-xs" ></span>
										<liferay-ui:message key="servizi-logistici-stato-non-evasa"/>
									</p>
								</a>
							</c:when>
							
							</c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="ama-container-fluid">
        <div class="wrapper-servizi-logistici wrap-giudizio">
            <div class="wrap-giudizio mt-60-xs">
                <div class="ama-row">
                    <div class="ama-col-lg-6 ama-col-md-5 ama-col-xs-12 border mb-20-xs mb-0-md">
                        <p class="title"><liferay-ui:message key="servizi-logistici-giudizio-servizio"/></p>
                    </div>
                    <div class="ama-col-lg-2 ama-col-md-2 ama-col-sm-4 ama-col-xs-12 border mb-20-xs mb-0-sm">
                        <a href="#" id="<portlet:namespace/>valutazbuono" title="buono" class="text"> <span class="ico-person icomoon-buono mr-20-sm"></span><liferay-ui:message key="servizi-logistici-buono"/></a>
                    </div>
                    <div class="ama-col-lg-2 ama-col-md-3 ama-col-sm-4 ama-col-xs-12 border mb-20-xs mb-0-sm">
                        <a href="#" id="<portlet:namespace/>valutazsufficiente" title="sufficente" class="text"><span class="ico-person icomoon-sufficente mr-20-sm"></span><liferay-ui:message key="servizi-logistici-sufficiente"/></a>
                    </div>
                    <div class="ama-col-lg-2 ama-col-md-2 ama-col-sm-4 ama-col-xs-12 mb-20-xs mb-0-sm">
                        <a href="#" id="<portlet:namespace/>valutazscarso" title="scarso" class="text"><span class="ico-person icomoon-scarso mr-20-sm"></span><liferay-ui:message key="servizi-logistici-scarso"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

        <div class="ama-container-fluid">

            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="servizi-logistici-riepilogo-richiesta"/></h2>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                    <div class="ama-col-xs-12 mobile-no-padding">
                        <div class="wrapper-istanza-trasporti mobile-no-padding">
                        <div class="box-gray">
                            <div class=" box-white pb-0-xs">
                                <p class="name">${richiedente.getNome()} ${richiedente.getCognome()}</p>
                                <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
            
                                <div id="collapse-trasporti" class="collapse1 in no-overflow">
									<div class="ama-row border-section border-mobile">
                                        <div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-organizzazione"/>:</span>
                                            <p class="info">${richiedente.getOrganizzazione().toUpperCase()}</p>
                                        </div>
                                    </div>
								
								
                                    <div class="ama-row border-section border-mobile">
                                        <div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-ufficio-richiedente"/>:</span>
                                            <p class="info">${richiedente.getUfficioRichiedente().toUpperCase()}</p>
                                        </div>
                                    </div>
            
                                    <div class="ama-row">
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="servizi-logistici-ubicazione-richiedente"/>:</span>
                                            <p class="info">${richiedente.getUbicazione().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md mt-30-sm"><liferay-ui:message key="servizi-logistici-palazzina"/>:</span>
                                            <p class="info">${richiedente.getPalazzina()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="servizi-logistici-piano"/>:</span>
                                            <p class="info">${richiedente.getPiano()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information mt-30-md"><liferay-ui:message key="servizi-logistici-scala"/>:</span>
                                            <p class="info">${richiedente.getScala().toUpperCase()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-stanza"/>:</span>
                                            <p class="info">${richiedente.getStanza()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-telefono"/>:</span>
                                            <p class="info">${richiedente.getTelefono()}</p>
                                        </div>
            
                                        <div class="ama-col-md-3 ama-col-sm-6">
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-email-richiedente"/>:</span>
                                            <p class="info">${richiedente.getEmailRichiedente()}</p>
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
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-dettaglio-id" /></span>
                                            <p class="info mb-20-xs">${richiesta.getId()}</p>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-dettaglio-oggetto" /></span>
                                            <p class="info mb-20-xs">${richiesta.getOggetto()}</p>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-xs-12">
                                            <span class="section-information"><liferay-ui:message key="servizi-logistici-data-richiesta" /></span>
                                            <p class="info">${datarichiesta}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
            
                        <p class="title-form mt-20-xs ml-20-xs ml-0-sm mb-10-xs mb-0-sm"> <liferay-ui:message key="servizi-logistici-dettaglio" />:</p>
                         <c:forEach items="${listaServizi}" var="servizio" varStatus="status"> 
                        <div class="no-overflow">
                            <div class="box-gray padding-mobile-servizi">
                                <div class="box-white">
                                    <div class="ama-row">
                                        <div class="ama-col-md-1 ama-col-sm-3 ama-col-xs-4 border">
                                            <span class="section-information width">${status.index +1}.</span>
                                        </div>
                                        <div class="ama-col-md-3 ama-col-sm-9 ama-col-xs-7 border">
                                            <span class="section-information width">${servizio}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            
		<c:if test="${not empty richiesta.getNote()}">
            <div class="wrapper-beni-inventariati">
                <p class="title-form mt-20-xs mb-5-xs"> <liferay-ui:message key="servizi-logistici-dettaglio-note" />: </p>
                <p class="mb-40-xs">${richiesta.getNote()}</p>
            </div>
        </c:if>  
            
        </div>
        	</c:otherwise>
	</c:choose>

<script>

$("#<portlet:namespace/>newReq").click("on",function(){
	$("#<portlet:namespace/>formNuovaRichiesta").submit();	
});


$("#<portlet:namespace/>idaccetta").click("on",function(){	
	$("#<portlet:namespace/>idstatoid").val("accetta");
	$("#<portlet:namespace/>formAccettaRichiesta").submit();	
});

$("#<portlet:namespace/>idrifiuta").click("on",function(){	
	$("#<portlet:namespace/>idstatoid").val("rifiuta");
	$("#<portlet:namespace/>formAccettaRichiesta").submit();	
});


$("#<portlet:namespace/>idevasa").click("on",function(){	
	$("#<portlet:namespace/>statoevasaid").val("evasa");
		
});

$("#<portlet:namespace/>idnonevasa").click("on",function(){	
	$("#<portlet:namespace/>statoevasaid").val("nonevasa");
	$("#<portlet:namespace/>formEvadiRichiesta").submit();	
});

$("#<portlet:namespace/>valutazbuono").click("on",function(){	
	$("#<portlet:namespace/>valutazioneid").val("buono");
	$("#<portlet:namespace/>formEvadiRichiesta").submit();	
});

$("#<portlet:namespace/>valutazsufficiente").click("on",function(){	
	$("#<portlet:namespace/>valutazioneid").val("sufficiente");
	$("#<portlet:namespace/>formEvadiRichiesta").submit();	
});

$("#<portlet:namespace/>valutazscarso").click("on",function(){	
	$("#<portlet:namespace/>valutazioneid").val("scarso");
	$("#<portlet:namespace/>formEvadiRichiesta").submit();	
});

</script>
