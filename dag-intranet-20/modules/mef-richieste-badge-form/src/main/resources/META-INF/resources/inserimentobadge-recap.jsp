
<%@page import="servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil"%>
<%@page import="servizio.richieste.badge.mef.model.RichiestaBadge"%>
<%@ include file="/init.jsp" %>

<%@page import="mef.richieste.badge.bean.Richiedente"%>
<%@page import="mef.richieste.badge.bean.ModuloRichiedente"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%

User userAuth = themeDisplay.getUser();

int countBtn = 0;
long id_richiesta = 0;
String scope = "riepilogo";

String urlFoto = null;
String urlModuloSostituzione = null;

boolean dirigente = (boolean)request.getAttribute("roleDirigente");
boolean abilitatoBadge = (boolean)request.getAttribute("roleAbilitato");
boolean delegatoBadge = (boolean)request.getAttribute("roleDelegato");
boolean gestoreExt = (boolean)request.getAttribute("roleGestoreExt");
boolean gestoreInt = (boolean)request.getAttribute("roleGestoreInt");


Richiedente richiedente = new Richiedente();
if(request.getAttribute("richiedente")!=null){
	richiedente = (Richiedente)request.getAttribute("richiedente");
}
ModuloRichiedente moduloRichiedente = new ModuloRichiedente(); 
if(request.getAttribute("moduloRichiedente")!=null){
	moduloRichiedente = (ModuloRichiedente)request.getAttribute("moduloRichiedente");
}
String flagModificaPostSubmit = "";
if(request.getAttribute("modificaRichiestaBadgePostSubmit")!=null){
	flagModificaPostSubmit = (String)request.getAttribute("modificaRichiestaBadgePostSubmit");
}
String pathFile = "";
if (moduloRichiedente.getAllegato() != null) 
	pathFile = moduloRichiedente.getAllegato().toString();
String pathFileOpzionale = "";
if (moduloRichiedente.getAllegatoOpzionale() != null) 
	pathFileOpzionale = moduloRichiedente.getAllegatoOpzionale().toString();




if(request.getParameter("richiestaId")!=null || (request.getAttribute("richiestaId")!=null && ("vaiADettaglio").equalsIgnoreCase((String)request.getAttribute("navigation"))) ||
 (request.getParameter("richiestaId")!=null && request.getParameter("navigation")!=null && ("vaiADettaglio").equalsIgnoreCase((String)request.getParameter("navigation"))) ||
 (request.getParameter("provenienza")!=null && (("daRichiediApprovaRifiuta").equalsIgnoreCase((String)(request.getParameter("provenienza")))))	
		){
	
	
	if ((request.getParameter("richiestaId") != null) || (request.getParameter("provenienza")!=null && (("daRichiediApprovaRifiuta").equalsIgnoreCase((String)(request.getParameter("provenienza"))))) ){
		id_richiesta = Long.parseLong(request.getParameter("richiestaId"));
	}
	else if ((request.getAttribute("richiestaId") != null && ((String) request.getAttribute("navigation")).equalsIgnoreCase("vaiADettaglio"))) {
		id_richiesta = Long.parseLong((String) request.getAttribute("richiestaId"));
	}
	else if( (request.getParameter("richiestaId")!=null && request.getParameter("navigation")!=null && ("vaiADettaglio").equalsIgnoreCase((String)request.getParameter("navigation")) && 
			request.getParameter("provenienza")!=null && (("daRichiediApprovaRifiuta").equalsIgnoreCase((String)(request.getParameter("provenienza"))))
			)){
		id_richiesta = Long.parseLong(request.getParameter("richiestaId"));
	}
	
	
	scope = "dettaglio";
	
	if ( request.getAttribute("urlFoto")!=null ) 
		urlFoto = (String)request.getAttribute("urlFoto");
	if ( request.getAttribute("urlModuloSostituzione")!=null ) 
		urlModuloSostituzione = (String)request.getAttribute("urlModuloSostituzione");
}

	String jsonInputRicerca = "";
	
	if(request.getAttribute("jsonInputRicerca")!=null) {
		jsonInputRicerca = (String) request.getAttribute("jsonInputRicerca");
	}
	if(request.getParameter("jsonInputRicerca")!=null) {
		jsonInputRicerca = (String) request.getParameter("jsonInputRicerca");
	}
%>

<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"/>

<portlet:actionURL var="vaiARicerca" name="vaiARicerca"></portlet:actionURL>

<portlet:actionURL var="ricercaRichieste" name="ricercaRichieste">
	<portlet:param name="jsonInputRicercaFromDettaglio" value="<%=jsonInputRicerca%>" />
</portlet:actionURL>

<portlet:actionURL var="vaiAGestioneUtenti" name="vaiAGestioneUtenti"/>
<portlet:actionURL var="vaiAProrogaBadge" name="vaiAProrogaBadge"/>

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<!-- HEADER -->
<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                    <h2 class="title"><%=formTitle%></h2>
                    
                    <c:if test="<%=("dettaglio").equalsIgnoreCase(scope)%>">
                    	<div class="wrap-icon-title form-inline-wrap">
	                    	
	                    	<c:if test="<%=!gestoreExt && !gestoreInt%>">
		                    	<form enctype="multipart/form-data" action="<%=vaiAInserimento%>" method="post">
		                            <button href="<%=vaiAInserimento%>" type="button" class="button-xs button button-primary mr-10-xs" onclick="this.form.submit()">
		                                 <liferay-ui:message key="badge-gestione-utenti-bnt-nuova-richiesta"/>
		                                 <span class="icomoon-plus icon-beni"></span>
		                            </button>
	                            </form>
                          	</c:if>
                          
							<c:if test="<%=dirigente%>">
		                        <a href="<%=vaiAGestioneUtenti%>" title="Gestione Utenti"  class="icon icomoon-profile"></a>     
		                    </c:if>   
		                    
                    		<c:if test="<%=jsonInputRicerca==null || "".equals(jsonInputRicerca)%>">
								<a href="<%=vaiARicerca%>" title="Ricerca" class="icon icomoon-search-richiesta"></a>
							</c:if>
							<c:if test="<%=jsonInputRicerca!=null && !"".equals(jsonInputRicerca)%>">
								<a href="<%=ricercaRichieste%>" title="Ricerca" class="icon icomoon-search-richiesta"></a>
							</c:if>
							
		                    <c:if test="<%=!gestoreExt && !gestoreInt%>">				
								<a href="<%=vaiAProrogaBadge%>" title="Proroga Badge" class="icon icomoon-time"></a>					
							</c:if>
							
						</div>
					</c:if>
					
					<c:if test="<%=("riepilogo").equalsIgnoreCase(scope)%>">
                    	<div class="wrap-icon-title form-inline-wrap">
						  <c:if test="<%=dirigente%>">
	                          <a href="<%=vaiAGestioneUtenti%>" title="Gestione Utenti"  class="icon icomoon-profile"></a>     
	                      </c:if>              
	                      <a href="<%=vaiARicerca%>" title="Ricerca" class="icon icomoon-search-richiesta"></a>
	                      <a href="<%=vaiAProrogaBadge%>" title="Proroga Badge" class="icon icomoon-time"></a>
						</div>
					</c:if>
					
                    <p class="subtitle dot-point dot-200"><%=formSubtitle%></p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="ama-container-fluid">
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-small">           
               	<h2 class="title-box borders"><%=scope.toUpperCase()%> DELLA RICHIESTA</h2>
			</div>
        </div>
    </div>
    <div class="ama-row">
        <div class="ama-col-xs-12 mobile-no-padding">
            <div class="wrapper-istanza-trasporti mobile-no-padding">
                <div class="box-gray">
                    <div class=" box-white pb-0-xs">                         
                    	<p class="name"><%=richiedente.getNome()+" "+richiedente.getCognome()%></p>            		
                    	<span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>   
                        <div id="collapse-trasporti" class="collapse1 in no-overflow">                        
                        	<div class="ama-row">                       
                        		<div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="badge-recap-dipartimento"/>:</span>
                                    <p class="info"><%=richiedente.getDipartimento()%></p>
                                </div>  
                                 <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="badge-recap-direzione"/>:</span>
                                    <p class="info"><%=richiedente.getDirezione()%></p>
                                </div>                               
                                 <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="badge-recap-ufficio-richiedente"/>:</span>
                                    <p class="info"><%=richiedente.getUfficioRichiedente()%></p>
                                </div>  
                                 <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="badge-recap-telefono"/>:</span>
                                    <p class="info"><%=richiedente.getTelefono()%></p>
                                </div> 
                                 <div class="ama-col-md-3 ama-col-sm-6">
                                    <span class="section-information mt-30-md mt-30-xs"><liferay-ui:message key="badge-recap-email-richiedente"/>:</span>
                                    <p class="info"><%=richiedente.getEmail()%></p>
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
            <div class="wrapper-istanza-trasporti">
                <div class="no-overflow">
                    <div class="box-gray">
                        <div class="box-white">
                            <div class="ama-row">
                                <div class="ama-col-md-12 ama-col-xs-12">
                                    <span class="section-information"><liferay-ui:message key="badge-recap-tipo-richiesta"/>:</span>
                                    <p class="info info-second-box"><%=moduloRichiedente.getTipo()%></p>
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
            <div class="wrapper-istanza-trasporti">
                <div class="no-overflow">
                    <div class="box-gray">
                        <div class="box-white">
                            <div class="ama-row">
                                <div class="ama-col-md-12 ama-col-xs-12">
                                    <span class="section-information"><liferay-ui:message key="badge-recap-stato"/>:</span>
                                    <p class="info info-second-box"><%=moduloRichiedente.getStato()%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
    <!-- SOLO SE RICHIESTA ESTERNA -->
    <c:if test="<%=("esterna").equalsIgnoreCase(moduloRichiedente.getTipo())%>">
	   <div class="ama-row">
	        <div class="ama-col-md-12">
	            <div class="wrapper-title-small">
	                <h2 class="title-box borders"><liferay-ui:message key="badge-recap-tl-struttura-richiedente"/></h2>
	            </div>
	        </div>
	   </div>
       <div class="ama-row">
            <div class="ama-col-xs-12 mobile-no-padding">
                <div class="wrapper-istanza-trasporti mobile-no-padding">
	                <div class="box-gray">
	                    <div class=" box-white pb-0-xs">
	                        <div class="ama-row">
	                            <c:if test="<%=("riepilogo").equalsIgnoreCase(scope) || ("dettaglio").equalsIgnoreCase(scope) && ("esterna").equalsIgnoreCase(moduloRichiedente.getTipo())%>">
	                                <div class="ama-col-md-3 ama-col-sm-6">
	                                    <span class="section-information"><liferay-ui:message key="badge-recap-dipartimento"/>:</span>
	                                    <p class="info"><%=moduloRichiedente.getDipartimento()%></p>
	                                </div>
	                                <div class="ama-col-md-3 ama-col-sm-6">
	                                    <span class="section-information"><liferay-ui:message key="badge-recap-direzione"/>:</span>
	                                    <p class="info"><%=moduloRichiedente.getDirezione()%></p>
	                                </div>                                         
	                                <div class="ama-col-md-3 ama-col-sm-6">
	                                    <span class="section-information"><liferay-ui:message key="badge-recap-ufficio"/>:</span>
	                                    <p class="info"><%=moduloRichiedente.getUfficio()%></p>
	                                </div>
	                                <div class="ama-col-md-3 ama-col-sm-6">
	                                    <span class="section-information"><liferay-ui:message key="badge-recap-ref-mef"/>:</span>
	                                    <p class="info"><%=moduloRichiedente.getReferenteMef()%></p>
	                                </div>
	                                <div class="ama-col-md-3 ama-col-sm-6">
	                                    <span class="section-information"><liferay-ui:message key="badge-recap-ref-telefono"/>:</span>
	                                    <p class="info"><%=moduloRichiedente.getTelReferente()%></p>
	                                </div>
	                                 <div class="ama-col-md-3 ama-col-sm-6">
	                                    <span class="section-information"><liferay-ui:message key="badge-recap-ref-email"/>:</span>
	                                    <p class="info"><%=moduloRichiedente.getEmailReferente()%></p>
	                                </div>
	                            </c:if>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	   </div>
    </c:if>
    <!-- -->
    
    <div class="ama-row">
       <div class="ama-col-md-12">
           <div class="wrapper-title-small">
               <h2 class="title-box borders"><liferay-ui:message key="badge-recap-tl-oggetto-richiesta"/></h2>
           </div>
       </div>
    </div>
    <div class="ama-row">
        <div class="ama-col-xs-12 mobile-no-padding">
            <div class="wrapper-istanza-trasporti mobile-no-padding">
            	<div class="box-gray">
                	<div class=" box-white pb-0-xs">
                        <div class="ama-row">
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-nome-int"/>:</span>
                                <p class="info"><%=moduloRichiedente.getNome()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-cognome-int"/>:</span>
                                <p class="info"><%=moduloRichiedente.getCognome()%></p>   
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-cf-int"/>:</span>
                                 <p class="info"><%=moduloRichiedente.getCodiceFiscale()%></p>  
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-luogo-nascita-int"/>:</span>
                                <p class="info"><%=moduloRichiedente.getLuogoNascita()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-data-nascita-int"/>:</span>
                                <p class="info"><%=moduloRichiedente.getDataNascita()%></p>
                            </div>
                            
                       <c:if test="<%=("esterna").equalsIgnoreCase(moduloRichiedente.getTipo())%>">     
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-dip-societa"/>:</span>
                                <p class="info"><%=moduloRichiedente.getSocieta()%></p>
                            </div>
                            
                            <c:if test="<%="DIREZIONE CENTRALE DEI SISTEMI INFORMATIVI E DELL'INNOVAZIONE".equalsIgnoreCase(HtmlUtil.unescape(moduloRichiedente.getDirezione()))%>">
                            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-sede-legale-societa"/>:</span>
                                <p class="info"><%=moduloRichiedente.getSedelegaleSocieta()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-indirizzo"/>:</span>
                                <p class="info"><%=moduloRichiedente.getIndirizzoSocieta()%></p>
                            </div>
                             <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-recapito-telefonico"/>:</span>
                                <p class="info"><%=moduloRichiedente.getTelSocieta()%></p>
                            </div>
                             <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-fax"/>:</span>
                                <p class="info"><%=moduloRichiedente.getFaxSocieta()%></p>
                            </div>
                             <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-pec"/>:</span>
                                <p class="info"><%=moduloRichiedente.getPecSocieta()%></p>
                            </div>
                               <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-email"/>:</span>
                                <p class="info"><%=moduloRichiedente.getEmailSocieta()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-referente-societa"/>:</span>
                                <p class="info"><%=moduloRichiedente.getRefSocieta()%></p>
                            </div>
                             <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-email-societa"/>:</span>
                                <p class="info"><%=moduloRichiedente.getEmailRefSocieta()%></p>
                            </div>
                             <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-telefono-ufficio"/>:</span>
                                <p class="info"><%=moduloRichiedente.getTelUfficioRefSocieta()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-cellulare"/>:</span>
                                <p class="info"><%=moduloRichiedente.getCellRefSocieta()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-denominazione-contratto"/>:</span>
                                <p class="info"><%=moduloRichiedente.getContratto()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-denominazione-progetto"/>:</span>
                                <p class="info"><%=moduloRichiedente.getProgetto()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-riga-piano"/>:</span>
                                <p class="info"><%=moduloRichiedente.getPiano()%></p>
                            </div>
                             <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-postazione-lavoro"/>:</span>
                                <p class="info"><%=moduloRichiedente.getPostazione()%></p>
                            </div>
                            
                            </c:if>
                            
                            <div class="ama-col-md-3 ama-col-sm-6">
                                <span class="section-information"><liferay-ui:message key="badge-recap-abilitato-per-sedi"/>:</span>
                                <p class="info"><%=moduloRichiedente.getSediAbilitate()%></p>
                            </div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                               	<span class="section-information"><liferay-ui:message key="badge-recap-data-scadenza"/>:</span>
                             	<c:choose>
                             	
                             	   
                             	
                             	
									<c:when test="<%= ("dettaglio").equalsIgnoreCase(scope) && ((gestoreExt|| gestoreInt) && (("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato())))%>">
										<form id="<portlet:namespace/>formScadenzaGestore">
											<input id="<portlet:namespace/>data_scadenza" name="<portlet:namespace/>data_scadenza" type="text" name="date" class="datepicker-custom input-custom-light data-parsley-validated"  
												   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' value="<%=moduloRichiedente.getDataScadenza()%>">
										</form>
									</c:when>
									
									<c:otherwise>
										<p class="info"><%=moduloRichiedente.getDataScadenza()%></p>
									</c:otherwise>
								</c:choose>
                           	</div>
                            <div class="ama-col-md-3 ama-col-sm-6">
                              	<span class="section-information"><liferay-ui:message key="badge-recap-motivazione"/>:</span>
                              	<p class="info"><%=moduloRichiedente.getMotivazione()%></p>
                         	</div>
                       
                        </c:if>  
                        </div>
                        
                     
                             
                        <div class="ama-row">   
                           <div class="ama-col-md-3 ama-col-sm-6">
                               <span class="section-information"><liferay-ui:message key="badge-recap-oggetto-richiesta"/>:</span>
                               <p class="info"><%=moduloRichiedente.getOggettoRichiestaDescrizione()%></p>  
                           </div>
                           <!--SOLO SE SOSTITUZIONE PER DETERIORAMENTO, PROROGA, DISATTIVAZIONE o SE IL NUMERO E' STATO GIA' ASSEGNATO DALL'OPERATORE -->  
                           <div class="ama-col-md-3 ama-col-sm-6">
                               <span class="section-information"><liferay-ui:message key="badge-recap-number-badge"/>:</span>
							   <c:choose>
							   
							   
								   
                             	
                             	
									<c:when test="<%= ("dettaglio").equalsIgnoreCase(scope) && ((gestoreExt|| gestoreInt) && (("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato())))%>">							  
										<form id="<portlet:namespace/>formNBadgeGestore">
											<input id="<portlet:namespace/>num_badge" name="<portlet:namespace/>num_badge" type="text" class="input-custom-light data-parsley-validated"
											 	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' value="<%=moduloRichiedente.getNumeroBadge()%>">
										</form>
									</c:when>
									<c:otherwise>
										<p class="info"><%=moduloRichiedente.getNumeroBadge()%></p>
									</c:otherwise>
							   </c:choose>
		    			   </div>
                           <!--  -->   
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

	
	<div class="wrapper-allegati-general">
	    <c:if test="<%=moduloRichiedente.getAllegatoNome()!=null && !"".equalsIgnoreCase(moduloRichiedente.getAllegatoNome()) || 
				       moduloRichiedente.getAllegatoNomeOpzionale()!=null && !"".equalsIgnoreCase(moduloRichiedente.getAllegatoNomeOpzionale()) %>">
	        <div class="ama-row">
	            <div class="ama-col-md-12">
	                <div class="wrapper-title-general">
	                    <h2 class="title-box borders"><liferay-ui:message key="badge-recap-tl-allegati"/></h2>
	                </div>
	            </div>
	        </div>
	        <div class="ama-row">
	            <div class="ama-col-md-12 mobile-no-padding">
	                <div class="wrapper-content">
	                    <div class="wrapper-white">                        
		                    <c:if test="<%=("riepilogo").equalsIgnoreCase(scope)%>">
		                    	<c:if test="<%=moduloRichiedente.getAllegatoNome()!=null && !"".equalsIgnoreCase(moduloRichiedente.getAllegatoNome())%>">
		                        	<p class="info"><%=moduloRichiedente.getAllegatoNome()%></p>
		                        </c:if>
		                        <c:if test="<%=moduloRichiedente.getAllegatoNomeOpzionale()!=null && !"".equalsIgnoreCase(moduloRichiedente.getAllegatoNomeOpzionale())%>">
		                        	<p class="info"><%=moduloRichiedente.getAllegatoNomeOpzionale()%></p>
		                        </c:if>
		                    </c:if>                   
		                    <c:if test="<%=("dettaglio").equalsIgnoreCase(scope)%>">
		                    	<c:if test="<%=urlFoto!=null%>">
		                        		<form action="<%=resourceURL%>" method="post" id="<portlet:namespace/>fotoForm" enctype="multipart/form-data"> 
										 	<input type="hidden" name="<portlet:namespace/>idDownload"  value="<%=urlFoto%>">
			                     		</form> 

		                        	<p class="text mb-20-xs ">
		                        	    <a href="javascript:submitFoto()" title="download foto"  target="_self"> <%=moduloRichiedente.getAllegatoNome()%></a>		          
		                        	</p>
		                        </c:if>
		                        <c:if test="<%=urlModuloSostituzione!=null%>">
		                        	<form action="<%=resourceURL%>" method="post" id="<portlet:namespace/>moduloForm" enctype="multipart/form-data"> 
										 	<input type="hidden" name="<portlet:namespace/>idDownload"  value="<%=urlModuloSostituzione%>">
			                     	</form> 
		                        	<p class="text">
		                        	   <a href="javascript:submitModulo()" title="download modulo sostituzione"  target="_self"> <%=moduloRichiedente.getAllegatoNomeOpzionale()%></a>		                        	
		                        	</p>
		                        </c:if>
		                    </c:if>
	                    </div>
	                </div>
	            </div>
	        </div>
	        
	        
	        
		</c:if>
		
		<c:if test="<%=moduloRichiedente.getNote()!=null %>">  
			<div class="ama-row">
		        <div class="ama-col-xs-12 mobile-no-padding">
		            <div class="wrapper-istanza-trasporti">
		                <div class="no-overflow">
		                    <div class="box-gray">
		                        <div class="box-white">
		                            <div class="ama-row">
		                                <div class="ama-col-md-12 ama-col-xs-12 noteRecap">
		                                    <span class="section-information"><liferay-ui:message key="badge-recap-tl-note"/>:</span>
											<c:if test="<%=("riepilogo").equalsIgnoreCase(scope)%>">
											<form enctype="multipart/form-data"> 
												<textarea readonly class="form-control textarea-custom-light "><%=HtmlUtil.escape(moduloRichiedente.getNote())%></textarea> 
	                                    	</form>
	                                    	</c:if>
											<c:if test="<%=("dettaglio").equalsIgnoreCase(scope)%>">
												<c:choose>
													<c:when
														test="<%=((gestoreExt || gestoreInt) &&  (("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()))) || delegatoBadge || dirigente %>">
														<form id="<portlet:namespace/>note_badgeForm" enctype="multipart/form-data">
															<textarea id="<portlet:namespace/>note_badge"
																class="form-control textarea-custom-light removeFieldFormTrasporti data-parsley-validated"
																data-parsley-minlength="10"
																data-parsley-minlength-message="Inserire una descrizione non inferiore a 10 caratteri"
																data-parsley-maxlength="500"
																data-parsley-maxlength-message="Lunghezza massima superata"
																data-parsley-validation-threshold="10"
																name="<portlet:namespace/>note_badge"><%=HtmlUtil.escape(moduloRichiedente.getNote())%></textarea>
														</form>
													</c:when>
													<c:when
														test="<%=(gestoreExt || gestoreInt) && !("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()) %>">
														<form enctype="multipart/form-data">
															<textarea readonly
																class="form-control textarea-custom-light "><%=HtmlUtil.escape(moduloRichiedente.getNote())%></textarea>
														</form>
													</c:when>
													<c:otherwise>
														<form enctype="multipart/form-data">
															<textarea readonly
																class="form-control textarea-custom-light "><%=HtmlUtil.escape(moduloRichiedente.getNote())%></textarea>
														</form>
													</c:otherwise>
												</c:choose>
											</c:if>
										</div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
	    	</div>
		</c:if>

		<c:if test="<%=("riepilogo").equalsIgnoreCase(scope) %>">
	       	<div class="container-button-allegati">
	            <div class="ama-row">
	                <div class="ama-col-sm-6">
	                    <button href="#" type="reset" class="button button-secondary" id="<portlet:namespace/>modificaRichiestaBadge"><liferay-ui:message key="badge-recap-bnt-modifica"/></button>
	                </div>
	                <div class="ama-col-sm-6">
	                    <button href="#" type="button" class="button button-primary" id="<portlet:namespace/>inviaRichiestaBadge"><liferay-ui:message key="badge-recap-bnt-invia"/></button>
	                </div>
	            </div>
	        </div>
        </c:if>

		<c:if test="<%=("dettaglio").equalsIgnoreCase(scope)%>">
			<%
				//recupero screenName utente loggato
					String screenNameRichiedente = null;
					RichiestaBadge richiestaDett = RichiestaBadgeLocalServiceUtil.fetchRichiestaBadge(id_richiesta);
					if(richiestaDett!=null){
						screenNameRichiedente = richiestaDett.getScreename_richiedente();
					}
					
					int col_sm = 0;
					if ((dirigente || delegatoBadge)  && (("RICHIESTA DI PROROGA").equalsIgnoreCase(moduloRichiedente.getStato())||
							("NUOVA RICHIESTA").equalsIgnoreCase(moduloRichiedente.getStato()))){
							
						if((screenNameRichiedente!=null && !screenNameRichiedente.equalsIgnoreCase(userAuth.getScreenName()))){
							col_sm = 3;	
						}
						else{
							col_sm = 4;
						}
					}	

					else if(( ((dirigente || delegatoBadge)
							&& (("RIFIUTATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()) || ("RIFIUTATA DAL GESTORE").equalsIgnoreCase(moduloRichiedente.getStato())))) ||
							((gestoreExt || gestoreInt)
							&& ("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()))){
						col_sm = 6;
					
					}

					else if (abilitatoBadge && (("NUOVA RICHIESTA").equalsIgnoreCase(moduloRichiedente.getStato())
							|| ("RIFIUTATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()) || ("RIFIUTATA DAL GESTORE").equalsIgnoreCase(moduloRichiedente.getStato())))
					{
						col_sm = 12;
					}
			%> 
			<div class="container-button-allegati">
				<div class="ama-row">
					<c:if
						test="<%=(((("NUOVA RICHIESTA").equalsIgnoreCase(moduloRichiedente.getStato())
							|| ("RIFIUTATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()) || ("RIFIUTATA DAL GESTORE").equalsIgnoreCase(moduloRichiedente.getStato()) )
							&& (!gestoreExt && !gestoreInt))
							|| ((("RICHIESTA DI MODIFICA").equalsIgnoreCase(moduloRichiedente.getStato()))
									&& (abilitatoBadge && !delegatoBadge)) || ((delegatoBadge || dirigente) && ("RICHIESTA DI PROROGA").equalsIgnoreCase(moduloRichiedente.getStato())))%>">
						<%
							countBtn++;
						%>
						<div class="ama-col-sm-<%=col_sm%>">
							<button href="#" type="reset" class="button button-secondary "
								id="<portlet:namespace/>modificaRichiestaBadgePostSubmit">
								<liferay-ui:message key="badge-recap-bnt-modifica" />
							</button>
						</div>
					</c:if>
					<c:if
						test="<%=(         (dirigente || delegatoBadge)
								&& (
										
										("RICHIESTA DI PROROGA").equalsIgnoreCase(moduloRichiedente.getStato()) || 
										("RIFIUTATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()) ||
										("RIFIUTATA DAL GESTORE").equalsIgnoreCase(moduloRichiedente.getStato()) || 
										("NUOVA RICHIESTA").equalsIgnoreCase(moduloRichiedente.getStato()))
														&& (!screenNameRichiedente.equalsIgnoreCase(userAuth.getScreenName()))                   )%>">
						<%
							countBtn++;
						%>

						<div class="ama-col-sm-<%=col_sm%>">
							<button href="#" type="reset" class="button button-secondary "
								id="<portlet:namespace/>richiediModificaRichiestaBadge">
								<liferay-ui:message key="badge-recap-bnt-richiedi-modifica" />
							</button>
						</div>
					</c:if>

					<c:if
						test="<%=(  ((delegatoBadge || dirigente)
								&& (("NUOVA RICHIESTA").equalsIgnoreCase(moduloRichiedente.getStato()) ||
										("RICHIESTA DI PROROGA").equalsIgnoreCase(moduloRichiedente.getStato())))
										|| ((gestoreExt || gestoreInt)
												&& ("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato()))      )%>">
						<%
							countBtn++;
						%>
						<div class="ama-col-sm-<%=col_sm%>">
							<button href="#" type="button" class="button button-primary"
								id="<portlet:namespace/>rifiutaRichiestaBadge"
								onclick="approvaRifiutaRichiestaBadge(this.id)">
								<liferay-ui:message key="badge-recap-bnt-rifiuta" />
							</button>
						</div>
						<div class="ama-col-sm-<%=col_sm%>">
							<button href="#" type="button" class="button button-primary"
								id="<portlet:namespace/>approvaRichiestaBadge"
								onclick="approvaRifiutaRichiestaBadge(this.id)">
								<liferay-ui:message key="badge-recap-bnt-approva" />
							</button>
						</div>
					</c:if>
				</div>
			</div>	
		</c:if>

	</div>
    <portlet:actionURL name="eventoRichiestaBadge" var="eventoRichiestaBadge"></portlet:actionURL>
	<portlet:actionURL name="modificaRichiestaBadge" var="modificaRichiestaBadge"></portlet:actionURL>
	<portlet:actionURL name="modificaRichiestaBadgePostSubmit" var="modificaRichiestaBadgePostSubmit">
		<portlet:param name="idRichiesta" value="<%=String.valueOf(id_richiesta)%>"/>
	</portlet:actionURL>

	<form id="<portlet:namespace/>inviaRichiestaBadgeForm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=eventoRichiestaBadge%>">
		<input type="hidden" name="<portlet:namespace/>DatiRichiedenteSubmit" value="<%=HtmlUtil.escape((String)request.getAttribute("jsonRichiedente"))%>" >
    	<input type="hidden" name="<portlet:namespace/>TipoRichiesta" value="<%=moduloRichiedente.getTipo()%>" >
    	<input type="hidden" name="<portlet:namespace/>DatiRichiestaSubmit" value="<%=HtmlUtil.escape((String)request.getAttribute("jsonRichiesta"))%>" >
    	<input type="hidden" name="<portlet:namespace/>NoteRichiestaSubmit" value="<%=HtmlUtil.escape(moduloRichiedente.getNote())%>" >
    	<input type="hidden" name="<portlet:namespace/>AllegatoNome" value="<%=moduloRichiedente.getAllegatoNome()%>" >
		<input type="hidden" name="<portlet:namespace/>AllegatoMimeType" value="<%=moduloRichiedente.getAllegatoMimeType()%>" >
	    <input type="hidden" name="<portlet:namespace/>Allegato" value="<%=pathFile%>" >
		<input type="hidden" name="<portlet:namespace/>AllegatoOpzionaleNome" value="<%=moduloRichiedente.getAllegatoNomeOpzionale()%>" >
		<input type="hidden" name="<portlet:namespace/>AllegatoOpzionaleMimeType" value="<%=moduloRichiedente.getAllegatoMimeTypeOpzionale()%>" >
	    <input type="hidden" name="<portlet:namespace/>AllegatoOpzionale" value="<%=pathFileOpzionale%>" >
	</form>
	
	<form id="<portlet:namespace/>inviaRichiestaBadgeForm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=eventoRichiestaBadge%>"></form>

	<form id="<portlet:namespace/>modificaRichiestaBadgePostSubmitForm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=modificaRichiestaBadgePostSubmit%>"></form>
	 
	<portlet:actionURL name="richiediModificaRichiesta" var="richiediModificaRichiesta">
		<portlet:param name="idRichiesta" value="<%=String.valueOf(id_richiesta)%>" />
	</portlet:actionURL>

	<form id="<portlet:namespace/>richiediModificaRichiestaBadgeForm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=richiediModificaRichiesta%>">
		<textarea style="display:none;" id="<portlet:namespace/>noteBadgeRichiediHidden" name="<portlet:namespace/>noteBadgeRichiediHidden" ></textarea>
	</form>
	 
	<portlet:actionURL name="approvaRifiutaRichiesta" var="approvaRifiutaRichiesta">
		<portlet:param name="idRichiesta" value="<%=String.valueOf(id_richiesta)%>" />
		<portlet:param name="jsonInputRicerca" value="<%=jsonInputRicerca%>" />
	</portlet:actionURL>

	<form id="<portlet:namespace/>approvaRifiutaRichiestaBadgeForm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=approvaRifiutaRichiesta%>">
			<input type="hidden" id="<portlet:namespace/>approvazione" name="<portlet:namespace/>approvazione" value=""> 
			<input type="hidden" id="<portlet:namespace/>dataScadenzaHidden" name="<portlet:namespace/>dataScadenzaHidden" value=""> 
			<input type="hidden" id="<portlet:namespace/>numBadgeHidden" name="<portlet:namespace/>numBadgeHidden" value="">
			<textarea style="display:none;" id="<portlet:namespace/>noteBadgeHidden" name="<portlet:namespace/>noteBadgeHidden"></textarea>
	</form>
</div>

<script>
var  scope = '<%=scope%>';
var tipoRichiesta = '<%=moduloRichiedente.getTipo()%>';
var inviaRichiesta = true;
var flagApprova = true;
var richiediModifica = true;

if(<%=countBtn%> == 0 && (scope.toLowerCase() == ("dettaglio")) && <%=gestoreExt || gestoreInt  || dirigente || delegatoBadge%>){
	$('#<portlet:namespace/>note_badge').prop("disabled",true);
	
}


	function approvaRifiutaRichiestaBadge(id){
		
		
		//approva	
		if(id == "<portlet:namespace/>approvaRichiestaBadge"){	
			if(<%=  ((gestoreExt|| gestoreInt) && (("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato())))%>){
				$('#<portlet:namespace/>formNBadgeGestore').parsley().validate();
				if(tipoRichiesta.toLowerCase() == "esterna"){
				$('#<portlet:namespace/>formScadenzaGestore').parsley().validate();
				}
				$('#<portlet:namespace/>dataScadenzaHidden').val($('#<portlet:namespace/>data_scadenza').val());
				$('#<portlet:namespace/>numBadgeHidden').val($('#<portlet:namespace/>num_badge').val());			
			}  
			$('#<portlet:namespace/>noteBadgeHidden').val($('#<portlet:namespace/>note_badge').val());
			$('#<portlet:namespace/>approvazione').val("approvazione");

			
	if(<%= ((gestoreExt|| gestoreInt) && (("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(moduloRichiedente.getStato())))%>){
				
				if(tipoRichiesta.toLowerCase() == "esterna"){
					if(flagApprova && $('#<portlet:namespace/>formScadenzaGestore').parsley().isValid() && $('#<portlet:namespace/>formNBadgeGestore').parsley().isValid()){
						flagApprova= false;
						$("#<portlet:namespace/>approvaRifiutaRichiestaBadgeForm").submit();
					}
					}
				else{
					if(flagApprova && $('#<portlet:namespace/>formNBadgeGestore').parsley().isValid()){
						flagApprova= false;
						$("#<portlet:namespace/>approvaRifiutaRichiestaBadgeForm").submit();
					}
					}
				
	}
		  
			else{
				if(flagApprova){
				flagApprova= false;
				$("#<portlet:namespace/>approvaRifiutaRichiestaBadgeForm").submit();
				}
			}
			
			
		}
		
		//Rifiuta
		else{
			if(flagApprova){
			$('#<portlet:namespace/>approvazione').val("");
			$('#<portlet:namespace/>noteBadgeHidden').val($('#<portlet:namespace/>note_badge').val());
			flagApprova= false;
			$("#<portlet:namespace/>approvaRifiutaRichiestaBadgeForm").submit();
		}}
	} 
	
	
	
	$("#<portlet:namespace/>inviaRichiestaBadge").on('click', function(event){

		if(inviaRichiesta && $($("#<portlet:namespace/>inviaRichiestaBadge")).parsley().isValid()){
		
		
		  var input = document.createElement("input");
		  var form = $('#<portlet:namespace/>inviaRichiestaBadgeForm');
		  $(input).attr("type","hidden");
		  $(input).attr("name","<portlet:namespace/>flagModificaPostSubmit");
		  $(input).attr("id","<portlet:namespace/>flagModificaPostSubmit");
		  $(input).attr("value","<%=HtmlUtil.escape((String)request.getAttribute("modificaRichiestaBadgePostSubmit"))%>");
		  $(form).append(input); 
		  $(form).attr("action", "<%=eventoRichiestaBadge%>");
		  inviaRichiesta= false;
		$("#<portlet:namespace/>inviaRichiestaBadgeForm").submit();
	}});
	
	$("#<portlet:namespace/>modificaRichiestaBadge").on('click', function(event){
		
		
		var form = $('#<portlet:namespace/>inviaRichiestaBadgeForm');
		  $(form).attr("action", "<%=modificaRichiestaBadge%>");
			$('#<portlet:namespace/>inviaRichiestaBadgeForm').find('#<portlet:namespace/>flagModificaPostSubmit').remove();
			$("#<portlet:namespace/>inviaRichiestaBadgeForm").submit();
	});
	$("#<portlet:namespace/>modificaRichiestaBadgePostSubmit").on('click',function(event){ 
		if(richiediModifica && $($("#<portlet:namespace/>modificaRichiestaBadgePostSubmit")).parsley().isValid() ){
			richiediModifica = false;
		$("#<portlet:namespace/>modificaRichiestaBadgePostSubmitForm").submit(); 
	}});
	
	$("#<portlet:namespace/>richiediModificaRichiestaBadge").on('click',function(event) {
		if(flagApprova){
				$('#<portlet:namespace/>noteBadgeRichiediHidden').val($('#<portlet:namespace/>note_badge').val());
				flagApprova= false;
				$("#<portlet:namespace/>richiediModificaRichiestaBadgeForm").submit();
	}	});
	
	
	
	function submitFoto(){
		$('#<portlet:namespace/>fotoForm').submit();
	}
	
	function submitModulo(){
		$('#<portlet:namespace/>moduloForm').submit();
	}
	

	
</script>