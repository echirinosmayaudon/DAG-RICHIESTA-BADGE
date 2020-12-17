<%@ include file="/init.jsp" %>

<%@ page import="mef.richieste.badge.bean.Richiedente"%>
<%@ page import="mef.richieste.badge.bean.ModuloRichiedente"%>
<%@ page import="java.util.List"%>
<%@ page import="servizio.richieste.badge.mef.model.OggettoRichiesta" %>
<%@ page import="servizio.richieste.badge.mef.model.SediEsterne" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%  boolean dirigente = (boolean)request.getAttribute("roleDirigente");
	boolean abilitatoBadge = (boolean)request.getAttribute("roleAbilitato");
	boolean delegatoBadge = (boolean)request.getAttribute("roleDelegato");
	boolean gestoreExt = (boolean)request.getAttribute("roleGestoreExt");
	boolean gestoreInt = (boolean)request.getAttribute("roleGestoreInt");
	
//	String listaSedi = (String)request.getAttribute("listaSedi");
//	String listaPianiSize = (String)request.getAttribute("listaPiani");
//	String listaCorridoiSize = (String)request.getAttribute("listaCorridoi");
//	String listaFuoriPorteSize = (String)request.getAttribute("listaFuoriPorta");
	
	
	Richiedente richiedente = new Richiedente();
	if(request.getAttribute("richiedente")!=null)
		richiedente = (Richiedente)request.getAttribute("richiedente");
	ModuloRichiedente moduloRichiedente = new ModuloRichiedente(); 
	if(request.getAttribute("moduloRichiedente")!=null)
		moduloRichiedente = (ModuloRichiedente)request.getAttribute("moduloRichiedente");
	String flagModificaPostSubmit = "";
	if(request.getAttribute("modificaRichiestaBadgePostSubmit")!=null)
		flagModificaPostSubmit = (String)request.getAttribute("modificaRichiestaBadgePostSubmit");

	String acceptFile = ".jpg,.jpeg" ;
	String acceptFileOptional = ".pdf";
	String internaTxt = "interna";
    String esternaTxt = "esterna";
	String dipartimento = "TUTTE"; 
	String direzione = "TUTTE"; 
    String ufficio = "TUTTE";
    if( moduloRichiedente.getDipartimento() != null ) 
    	dipartimento = moduloRichiedente.getDipartimento();
    if( moduloRichiedente.getDirezione() != null ) 
    	direzione = moduloRichiedente.getDirezione();
    if( moduloRichiedente.getUfficio() != null ) 
    	ufficio = moduloRichiedente.getUfficio();
    String allegatoPath = "";
    String allegatoOpzionalePath = "";
    String allegatoNome = "";
    String allegatoOpzionaleNome = "";
    if( moduloRichiedente.getAllegato() != null ){
		allegatoPath = moduloRichiedente.getAllegato().toString();
		allegatoNome = moduloRichiedente.getAllegatoNome();
    }
    if( moduloRichiedente.getAllegatoOpzionale() != null ){
		allegatoOpzionalePath = moduloRichiedente.getAllegatoOpzionale().toString(); 
		allegatoOpzionaleNome = moduloRichiedente.getAllegatoNomeOpzionale();
    }
    String idOrgChart = "";
	if(request.getAttribute("idOrgChart")!=null)
		idOrgChart = (String) request.getAttribute("idOrgChart");
	Long userId = new Long(0L);
	if(request.getAttribute("userId") != null)
		userId = (Long) request.getAttribute("userId");
%>

<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
<portlet:actionURL var="vaiAGestioneUtenti" name="vaiAGestioneUtenti"/>
<portlet:actionURL var="vaiAProrogaBadge" name="vaiAProrogaBadge"/>

<portlet:actionURL name="richiestaBadge" var="richiestaBadge" ></portlet:actionURL>  

<!-- HEADER -->
<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                     <h2 class="title"><%=formTitle%></h2>
                     <a title="Aggiungi ai preferiti" class="icomoon-star title-star btn-star-bookmarks pl-0-xs pl-20-md"></a>
                     <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
					 	  <c:if test="<%=dirigente%>">
	                          <a href="<%=vaiAGestioneUtenti%>" title="Gestione Utenti"  class="icon icomoon-profile"></a>     
	                      </c:if>              
	                      <a href="<%=vaiARicerca%>" title="Ricerca" class="icon icomoon-search-richiesta"></a>
	                      <a href="<%=vaiAProrogaBadge%>" title="Proroga Badge" class="icon icomoon-time"></a>
					 </div>
	               	 <p class="subtitle dot-point dot-200" style="word-wrap: break-word;"><%=formSubtitle%></p>
	          	</div>
            </div>
        </div>
    </div>
</div>


<div class="ama-container-fluid">
    
    <!-- DATI RICHIEDENTE HIDDEN -->     	
    <input id="idOrgChartId" type="hidden" value="<%=idOrgChart %>">
   	<input id="idUserId" type="hidden" value="<%=userId %>">
   	<input id="doAjaxCall" type="hidden" value="true">
   	<input id="namespace" type="hidden" value="<portlet:namespace/>">
    
    <!-- DATI RICHIEDENTE LABEL -->	
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-small">
                <h2 class="title-box borders"><liferay-ui:message key="badge-inserimento-dati-richiedente"/></h2>
            </div>
        </div>
    </div>
    
    <!-- DATI RICHIEDENTE -->	    
    <div class="ama-row">
        <div class="ama-col-xs-12">
            <div class="wrapper-badge-visitatore">
                <div class="box-gray no-margin">
                    <div class="box-white box-gray-mobile">
                        <div class="ama-row">
                            <div class="ama-col-xs-12">
                                <form method="post" id="<portlet:namespace/>forminserimentobadge" data-parsley-validate="true" enctype="multipart/form-data">
                                    <div class="ama-row">
                                        <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label class="label-form"><liferay-ui:message key="badge-inserimento-nome"/>*</label>
                                       		<input id="<portlet:namespace/>nomeRichiedente" class="input-custom-light data-parsley-validated" type="text" 
                                       			data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                       			value="<%=richiedente.getNome()%>" readonly>
                                        </div>
                                        <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label  class="label-form"><liferay-ui:message key="badge-inserimento-cognome"/>*</label>
                                       		<input id="<portlet:namespace/>cognomeRichiedente" type="text" class="input-custom-light data-parsley-validated" 
                                       			data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                       			value="<%=richiedente.getCognome()%>" readonly>
                                        </div>
                                        <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label  class="label-form"><liferay-ui:message key="badge-inserimento-dipartimento"/>*</label>
                                         	<input id="<portlet:namespace/>dipRichiedente" class="input-custom-light data-parsley-validated" type="text" 
												data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                         		value="<%=richiedente.getDipartimento()%>" readonly>
                                        </div>
                                        <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label  class="label-form"><liferay-ui:message key="badge-inserimento-direzione"/>*</label>
                                           	<input id="<portlet:namespace/>dirRichiedente" class="input-custom-light data-parsley-validated" type="text" 
                                           		data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                           		value="<%=richiedente.getDirezione()%>" readonly>
                                        </div>
                                        <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label  class="label-form"><liferay-ui:message key="badge-inserimento-ufficio-richiedente"/>*</label>
                                           	<input id="<portlet:namespace/>uffRichiedente" class="input-custom-light data-parsley-validated" type="text" 
                                           		data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                           		value="<%=richiedente.getUfficioRichiedente()%>" readonly>
                                        </div>
                                        <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label  class="label-form"><liferay-ui:message key="badge-inserimento-telefono"/>*</label>
                                            <c:choose>
                                            	<c:when test="<%=richiedente.getTelefono()!=null%>">
                                            		<input id="<portlet:namespace/>telRichiedente" class="input-custom-light data-parsley-validated" type="text" 
                                            			data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                            			data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
														data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>" 
                                            			value="<%=richiedente.getTelefono()%>" placeholder="<liferay-ui:message key="badge-inserimento-telefono"/>">
                                            	</c:when>
                                            	<c:otherwise>
                                            		<input id="<portlet:namespace/>telRichiedente" type="text" class="input-custom-light data-parsley-validated" 
                                            			data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                        				data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
														data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>" 
                                            			placeholder="<liferay-ui:message key="badge-inserimento-telefono"/>">
                                            	</c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label  class="label-form"><liferay-ui:message key="badge-inserimento-email-richiedente"/>*</label>
											<c:choose>
                                            	<c:when test="<%=richiedente.getEmail()!=null%>">
                                            		<input id="<portlet:namespace/>emailRichiedente" class="input-custom-light data-parsley-validated" type="text" 
                                            			data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                            			data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>" 
                                            			data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
                                            			value="<%=richiedente.getEmail()%>" placeholder="<liferay-ui:message key="badge-inserimento-email-richiedente"/>">
                                            	</c:when>
                                            	<c:otherwise>
                                            		<input id="<portlet:namespace/>emailRichiedente" class="input-custom-light data-parsley-validated" type="text" 
                                            			data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
                                            			data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
                                            			data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
                                            			placeholder="<liferay-ui:message key="badge-inserimento-email-richiedente"/>">
                                            	</c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
		
	<!-- RICHIESTA BADGE LABEL -->				 
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-md">
                <h2 class="title-box borders"><liferay-ui:message key="badge-inserimento-tipo-richiesta"/></h2>
            </div>
        </div>
    </div>       
        
    <!-- TIPO RICHIESTA -->	
    <div class="ama-row">
    
    
    
        <div class="ama-col-xs-12">

            <div class="tab-filtri filtro-categoria collapse-group mobile-trasporti" id="tabs-profile">
                <div class="filtro-tabs-wrapper mr-0-xs mt-0-xs ml-0-xs">
                    <!-- INTERNA TITLE-->
                    <a  title="INTERNA" class="tab-title active" id="<portlet:namespace/>Bnt<%=internaTxt%>" data-toggle="collapse" data-target="#<portlet:namespace/>interna" 
                       onclick="showInterna()" data-parent="#tabs-beni"><liferay-ui:message key="badge-inserimento-interna"/></a>
                    <!-- ESTERNA TITLE-->
                    <a  title="ESTERNA" class="tab-title" id="<portlet:namespace/>Bnt<%=esternaTxt%>" data-toggle="collapse" data-target="#<portlet:namespace/>esterna" 
                       onclick="showEsterna()"data-parent="#tabs-beni"><liferay-ui:message key="badge-inserimento-esterna"/></a>
	 		 	</div>
	 		 	
	 		 	<!-- INTERNA -->	
                <div id="<portlet:namespace/>interna" class="collapse in wrapper-border-grey">
	                <form id="<portlet:namespace/>form<%=internaTxt%>" data-parsley-validate="true"  method="post" enctype="multipart/form-data">    
				        <div class="ama-row">
				            <div class="ama-col-md-12">
				                <div class="heading-title-box">
				                    <h2 class="heading-title"><liferay-ui:message key="badge-inserimento-oggetto-richiesta"/></h2>
				                </div>
				            </div>
				        </div>
				        <div class="ama-row">
				            <div class="ama-col-xs-12">
				                <div class="wrapper-badge-visitatore">
				                    <div class="box-gray no-margin">
				                        <div class="box-white box-gray-mobile">
				                            <div class="ama-row">
				                                <div class="ama-col-xs-12">
				                                    <form id="<portlet:namespace/>form<%=internaTxt%>" data-parsley-validate="true" enctype="multipart/form-data">
				                                        <div class="ama-row">
			                                                <div class="ama-col-md-12 ama-col-xs-12">
			                                                    <p class="title-tab-component"><liferay-ui:message key="badge-inserimento-intestato-a"/></p>
			                                                </div>
			                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
			                                                    <label for="argument1" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-cognome"/>*</label>
								                                <c:choose>
					                                            	<c:when test="<%=moduloRichiedente.getCognome()!=null && ( moduloRichiedente.getTipo()==null || moduloRichiedente.getTipo() =="interna")%>">
					                                                    <input id="<portlet:namespace/>argument1<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	   data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
					                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' 
					                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-cognome"/>" value="<%=moduloRichiedente.getCognome()%>" 
					                                                    	   oninput="getSuggestions(this,event)" list="inserimentoInternaSuggestList">
					                                            	</c:when>
					                                            	<c:otherwise>
					                                                    <input id="<portlet:namespace/>argument1<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	   oninput="getSuggestions(this,event)" 
					                                                    	   data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
					                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' 
					                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-cognome"/>" list="inserimentoInternaSuggestList">
					                                            	</c:otherwise>
					                                            </c:choose>
			                                                    <dataList id="inserimentoInternaSuggestList"><dataList/>
			                                                </div>
			                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
			                                                    <label for="argument2" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-nome"/>*</label>
			                                                    <c:choose>
					                                            	<c:when test="<%=moduloRichiedente.getNome()!=null && ( moduloRichiedente.getTipo()==null || moduloRichiedente.getTipo() =="interna")%>">
					                                                    <input id="<portlet:namespace/>argument2<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	   data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
					                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
					                                                    	   value="<%=moduloRichiedente.getNome()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-nome"/>" >
			                                                    	</c:when>
			                                                    	<c:otherwise>
			                                                    		 <input id="<portlet:namespace/>argument2<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	    data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
					                                                    	    data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'  
					                                                    	    placeholder="<liferay-ui:message key="badge-inserimento-ph-nome"/>" >
					                                            	</c:otherwise>
					                                            </c:choose>			                                            	
			                                                </div>
			                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
			                                                    <label for="argument5" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-cf"/>*</label>
			                                                    <c:choose>
					                                            	<c:when test="<%=moduloRichiedente.getCodiceFiscale()!=null && ( moduloRichiedente.getTipo()==null || moduloRichiedente.getTipo() =="interna")%>">
					                                                    <input id="<portlet:namespace/>argument5<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
					                                                    	   data-parsley-maxlength="16" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"16\"}%>"/>"
					                                                           data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
																			   value="<%=moduloRichiedente.getCodiceFiscale()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-cf"/>" >
			                                                    	</c:when>
			                                                    	<c:otherwise>
			                                                    		<input id="<portlet:namespace/>argument5<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
					                                                    	   data-parsley-maxlength="16" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"16\"}%>"/>"
					                                                           data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
					                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-cf"/>" >				                                                    	 
					                                            	</c:otherwise>
					                                            </c:choose>	
			                                                </div>
			                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
			                                                    <label for="argument3" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-nato-a"/>*</label>
			                                                    <c:choose>
					                                            	<c:when test="<%=moduloRichiedente.getLuogoNascita()!=null && ( moduloRichiedente.getTipo()==null || moduloRichiedente.getTipo() =="interna")%>">
				                                                    	<input id="<portlet:namespace/>argument3<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
					                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
					                                                    	   value="<%=moduloRichiedente.getLuogoNascita()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-luogo-nascita"/>" >
			                                                    		</c:when>
			                                                    	<c:otherwise>
		                                                    			<input id="<portlet:namespace/>argument3<%=internaTxt%>" class="input-custom-light data-parsley-validated"
					                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
					                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>' 
					                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-luogo-nascita"/>" >
			                                                    	</c:otherwise>
					                                            </c:choose>	
			                                                </div>
			                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
			                                                    <label for="argument4" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-il"/>*</label>
			                                                    <c:choose>
					                                            	<c:when test="<%=moduloRichiedente.getDataNascita()!=null && ( moduloRichiedente.getTipo()==null || moduloRichiedente.getTipo() =="interna")%>">
					                                                    <input id="<portlet:namespace/>argument4<%=internaTxt%>" class="input-custom-light datepicker-custom data-parsley-validated" 
																			   data-parsley-check-birthday-child=""														
																			   data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  
																			   data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																			   data-parsley-check-date-before-today="#<portlet:namespace/>argument4<%=internaTxt%>"
																			   value="<%=moduloRichiedente.getDataNascita()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-data-nascita"/>" >
			                                                    	</c:when>
			                                                    	<c:otherwise>
			                                                    		<input id="<portlet:namespace/>argument4<%=internaTxt%>" class="input-custom-light datepicker-custom data-parsley-validated" 
																			   data-parsley-check-birthday-child=""														
																			   data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  
																			   data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
					                                                    	   data-parsley-check-date-before-today="#<portlet:namespace/>argument4<%=internaTxt%>"
					                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-data-nascita"/>" >
					                                               </c:otherwise>
					                                            </c:choose>
			                                                </div>
			                                                <div class="ama-col-md-12 pt-15-md pb-15-md hidden-sm hidden-xs">
			                                                    <div class="border-dashed"></div>
			                                                </div>
				                                        </div>
				                                    </form>
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                </div>
				            </div>
				        </div>
			        </form>
                </div>
                 
                <!-- ESTERNA -->	
                <div id="<portlet:namespace/>esterna" class="collapse wrapper-border-grey">
			        
			        	<!-- STRUTTURA RICHIEDENTE -->
			 			<div class="ama-row">
				            <div class="ama-col-xs-12">
				                <div class="wrapper-badge-visitatore">
				                    <div class="box-gray no-margin">
				                        <div class="box-white box-gray-mobile">
				                            <div class="ama-row">
				                                <div class="ama-col-xs-12">
				                                    <form id="<portlet:namespace/>formStruttura<%=esternaTxt%>" data-parsley-validate="true" method="post" enctype="multipart/form-data">
				                                        <div class="ama-row">

				                                                <div class="ama-col-md-12 ama-col-xs-12">
					                                        		<div class="heading-title-box">
													                    <h2 class="heading-title"><liferay-ui:message key="badge-inserimento-struttura-richiedente"/></h2>
													                </div>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="dipartimento" class="label-form margin-top"><liferay-ui:message key="badge-inserimento-dipartimento"/>*</label>
							                                        <select id="<portlet:namespace/>dipartimento" name="<portlet:namespace/>dipartimento" class="option-select data-parsley-validated"
				                                                    	 data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>"
							                                        	onchange="getStruttureInterne(this.value, '<portlet:namespace/>direzione');
							                                        			  clearStrutturaInterna('<portlet:namespace/>ufficio')">
							                                            <option value=""><liferay-ui:message key="badge-inserimento-tutte"/></option>
							                                        </select>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="direzione" class="label-form margin-top"><liferay-ui:message key="badge-inserimento-direzione"/></label>
							                                        <select id="<portlet:namespace/>direzione" disabled name="<portlet:namespace/>dipartimento" 
							                                        	onchange="getStruttureInterne(this.value, '<portlet:namespace/>ufficio')">
							                                            <option value="TUTTE"><liferay-ui:message key="badge-inserimento-tutte"/></option>
							                                        </select>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="ufficio" class="label-form margin-top"><liferay-ui:message key="badge-inserimento-ufficio"/></label>
							                                        <select id="<portlet:namespace/>ufficio" disabled name="<portlet:namespace/>dipartimento" >
							                                            <option value="TUTTE"><liferay-ui:message key="badge-inserimento-tutte"/></option>
							                                        </select>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-referente-mef"/>*</label>
					                                                <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getReferenteMef()!=null && moduloRichiedente.getTipo() =="esterna"%>">
						                                                    <input id="<portlet:namespace/>referenteMef" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   value="<%=moduloRichiedente.getReferenteMef()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-referente-mef"/>" >
				                                                    	</c:when>
				                                                    	<c:otherwise>
							                                                <input id="<portlet:namespace/>referenteMef" class="input-custom-light data-parsley-validated"
							                                                       data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
							                                                       data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
							                                                       placeholder="<liferay-ui:message key="badge-inserimento-ph-referente-mef"/>" >
						                                               </c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-telefono-referente"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getTelReferente()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
				                                                    	    <input id="<portlet:namespace/>telReferenteMef" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
																				   value="<%=moduloRichiedente.getTelReferente()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-telefono-referente"/>">
				                                                    	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>telReferenteMef" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-telefono-referente"/>">
				                                                   		</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="date-deadline" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-email-referente"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getEmailReferente()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>emailReferenteMef" type="text" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
																				   value="<%=moduloRichiedente.getEmailReferente()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-email-referente"/>" >
				                                                    	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>emailReferenteMef" type="text" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-email-referente"/>" >
				                                                   		</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                
				                                               
				                                                	        
				                                        </div>
				                                    </form>
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                </div>
				            </div>
			        	</div>
			        
			        	<!-- LABEL OGGETTO RICHIESTA -->
				        <div class="ama-row">
				            <div class="ama-col-md-12">
				                <div class="heading-title-box">
				                    <h2 class="heading-title"><liferay-ui:message key="badge-inserimento-oggetto-richiesta"/></h2>
				                </div>
				            </div>
				        </div>
			        	<!-- OGGETTO RICHIESTA -->
			        	<div class="ama-row">
				            <div class="ama-col-xs-12">
				                <div class="wrapper-badge-visitatore">
				                    <div class="box-gray no-margin">
				                        <div class="box-white box-gray-mobile">
				                            <div class="ama-row">
				                                <div class="ama-col-xs-12">
				                                    <form id="<portlet:namespace/>form<%=esternaTxt%>"  method="post" enctype="multipart/form-data">
				                                        <div class="ama-row">
				                                                <div class="ama-col-md-12 ama-col-xs-12">
				                                                    <p class="title-tab-component"><liferay-ui:message key="badge-inserimento-intestato-a"/></p>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-cognome"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getCognome()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
				                                                    	  	<input id="<portlet:namespace/>cognomeExt" class="input-custom-light data-parsley-validated"
						                                                    		data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    		data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    		value="<%=moduloRichiedente.getCognome()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-cognome"/>"
						                                                    		oninput="getSuggestionsExternal(this,event)" list="inserimentoEsternaSuggestList">
				                                                    	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>cognomeExt" class="input-custom-light data-parsley-validated" 
						                                                    		data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    		data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    		placeholder="<liferay-ui:message key="badge-inserimento-ph-cognome"/>"
						                                                    		oninput="getSuggestionsExternal(this,event)" list="inserimentoEsternaSuggestList">
				                                                   		</c:otherwise>
						                                            </c:choose>
				                                                    <dataList id="inserimentoEsternaSuggestList"><dataList/>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-nome"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getNome()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
				                                                    	  	<input id="<portlet:namespace/>nomeExt" class="input-custom-light data-parsley-validated"
						                                                    		data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    		data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    		value="<%=moduloRichiedente.getNome()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-nome"/>" >
				                                                    	</c:when>
				                                                    	<c:otherwise>
																			<input id="<portlet:namespace/>nomeExt" class="input-custom-light data-parsley-validated" 
						                                                    		data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    		data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    		placeholder="<liferay-ui:message key="badge-inserimento-ph-nome"/>" >
				                                                   		</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-codice-fiscale"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getCodiceFiscale()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>cfExt" class="input-custom-light data-parsley-validated" 
							                                                    	data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                        	data-parsley-maxlength="16" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"16\"}%>"/>"
						                                                        	data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
						                                                    		value="<%=moduloRichiedente.getCodiceFiscale()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-cf"/>" >
				                                                    	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>cfExt" class="input-custom-light data-parsley-validated" 
								                                                    data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
							                                                        data-parsley-maxlength="16" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"16\"}%>"/>"
							                                                        data-parsley-pattern="/^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}$/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
								                                                    placeholder="<liferay-ui:message key="badge-inserimento-ph-cf"/>" >
				                                                    	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-nato-a"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getLuogoNascita()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                   	<input id="<portlet:namespace/>luogoNascitaExt" class="input-custom-light data-parsley-validated"
						                                                    		data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    	    data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    		value="<%=moduloRichiedente.getLuogoNascita()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-luogo-nascita"/>" >
				                                                    	</c:when>
				                                                    	<c:otherwise>
					                                                    	<input id="<portlet:namespace/>luogoNascitaExt" class="input-custom-light data-parsley-validated"
							                                                    	data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
							                                                    	data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
							                                                    	placeholder="<liferay-ui:message key="badge-inserimento-ph-luogo-nascita"/>" >
																		</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument2" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-il"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getDataNascita()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
							                                              	<input id="<portlet:namespace/>dataNascitaExt" type="text" name="date-deadline" 
								                                              	    class="input-custom-light datepicker-custom data-parsley-validated"
							                                                        data-parsley-check-birthday-child=""														
																				    data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  
																				    data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				    data-parsley-check-date-before-today="#<portlet:namespace/>dataNascitaExt"
								                                              		value="<%=moduloRichiedente.getDataNascita()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-data-nascita"/>" >
						                                              	</c:when>
				                                                    	<c:otherwise>
				                                                    		<input id="<portlet:namespace/>dataNascitaExt" type="text" name="date-deadline" 
					                                                    			class="input-custom-light datepicker-custom data-parsley-validated" 
							                                                        data-parsley-check-birthday-child=""														
																				    data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"  
																				    data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				    data-parsley-check-date-before-today="#<portlet:namespace/>dataNascitaExt"
							                                                        placeholder="<liferay-ui:message key="badge-inserimento-ph-data-nascita"/>" >
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-dip-societa"/>*</label>
				                                                    <c:choose>
						                                            	<c:when test="<%=moduloRichiedente.getSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>dipSocietaExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   value="<%=moduloRichiedente.getSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-societa"/> ">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>dipSocietaExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-societa"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                
				                                                <div class="only-dsii-div" style="display:none">
				                                                
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-sede-legale"/></label>
				                                                    <c:choose>
				                                                    	<c:when test="<%=moduloRichiedente.getSedelegaleSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>sedeLegSocietaExt" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getSedelegaleSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-sede-legale"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>sedeLegSocietaExt" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-sede-legale"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-indirizzo"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getIndirizzoSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
																			<input id="<portlet:namespace/>indirizzoExt" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
																				   value="<%=moduloRichiedente.getIndirizzoSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-indirizzo-societa"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
																			<input id="<portlet:namespace/>indirizzoExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-indirizzo-societa"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-recapito-telefonico"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getTelSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
																			<input id="<portlet:namespace/>recapitoTelExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getTelSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-recapito-telefonico"/>" >
						                                              	</c:when>
				                                                    	<c:otherwise>
																			<input id="<portlet:namespace/>recapitoTelExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-recapito-telefonico"/>" >
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-fax"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getFaxSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>faxExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getFaxSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-fax"/>" >
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>faxExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-fax"/>" >
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-pec"/></label>
                                            						<c:choose>
																		<c:when test="<%=moduloRichiedente.getPecSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>pecExt" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
						                                                    	   value="<%=moduloRichiedente.getPecSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-pec"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>pecExt" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-pec"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-email"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getEmailSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>emailExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
						                                                    	   value="<%=moduloRichiedente.getEmailSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-email"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>emailExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-email"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-ref-societa"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getRefSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>refSocietaExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getRefSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-ref-societa"/> ">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>refSocietaExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-ref-societa"/> ">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-email-referente"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getEmailRefSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>emailRefSocietaExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
						                                                    	   value="<%=moduloRichiedente.getEmailRefSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-email-societa"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>emailRefSocietaExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   data-parsley-type="email" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>" 
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-email-societa"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-telefono-societa"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getTelUfficioRefSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>telUfficioExt" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getTelUfficioRefSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-telefono-societa"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>telUfficioExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-telefono-societa"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-cellulare"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getCellRefSocieta()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>cellulareExt" class="input-custom-light data-parsley-validated"
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getCellRefSocieta()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-cellulare"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>cellulareExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																				   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-cellulare"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-denominazione-contratto"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getContratto()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>contrattoExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getContratto()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-denominazione-contratto"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>contrattoExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-denominazione-contratto"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-denominazione-progetto"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getProgetto()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>progettoExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getProgetto()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-denominazione-progetto"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>progettoExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-denominazione-progetto"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>

				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-riga-piano"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getPiano()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>rigaPianoExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getPiano()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-riga-piano"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>rigaPianoExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-riga-piano"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-postazione-assegnata"/></label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getPostazione()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>postazioneExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   value="<%=moduloRichiedente.getPostazione()%>" placeholder="<liferay-ui:message key="badge-inserimento-ph-postazione-assegnata"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>postazioneExt" class="input-custom-light data-parsley-validated" 
						                                                    	   data-parsley-maxlength="30" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"30\"}%>"/>"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-postazione-assegnata"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                
				                                                </div>
				                                                
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-abilitato-per-le-sedi-di"/>*</label>
				                                                    <select id="<portlet:namespace/>sediAbilitateExt" class="init-multiselect multiselect-ui form-control data-parsley-validated" multiple="multiple" 
				                                                    	data-parsley-required-message="<liferay-ui:message key="badge-error-seleziona-sede"/>" >
				                                                   	<% for ( SediEsterne sediEsterne :(List<SediEsterne>)request.getAttribute("sediEsterneList")) {
				                                                   		if(sediEsterne.getId_sede_esterna()>0){
				                                                   		%>
 																			<option id="<portlet:namespace/><%=sediEsterne.getNome_sede_esterna().replace(" ", "_")%>" value="<%=sediEsterne.getNome_sede_esterna().replace(" ", "_")%>" >
 																					<%=sediEsterne.getNome_sede_esterna()%>
 																			</option>
 																	<% } 
				                                                   	}
 																	%>
				                                                    </select>
				                                                </div>
				                                                
				                                                
				                                                 <!-- modifica 2021 -->
     
     
     
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="sede" class="label-form margin-top"><liferay-ui:message key="badge-inserimento-sede"/>*</label>
							                                       <select id="<portlet:namespace/>sede" name="<portlet:namespace/>sede" class="option-select data-parsley-validated"
				                                                    	data-parsley-required="true" data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
							                                          
							                                        </select>
							                                       
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="piano" class="label-form margin-top"><liferay-ui:message key="badge-inserimento-piano"/></label>
							                                        <select id="<portlet:namespace/>piano" name="<portlet:namespace/>piano">
							                                          
							                                        </select>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="corridoio" class="label-form margin-top"><liferay-ui:message key="badge-inserimento-corridoio"/></label>
							                                        <select id="<portlet:namespace/>corridoio" name="<portlet:namespace/>corridoio">
							                                           
							                                        </select>
				                                                </div>
				                                                <div class="ama-col-md-6 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="fuoriPorta" class="label-form margin-top"><liferay-ui:message key="badge-inserimento-fuori-porta"/></label>
							                                        <select id="<portlet:namespace/>fuoriPorta" name="<portlet:namespace/>fuoriPorta">
							                                          
							                                        </select>
				                                                </div>
				                                                <!--  fine 2021 -->	
				                                                
				                                                
				                                                
				                                                
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-data-scadenza"/>*</label>
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getDataScadenza()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <input id="<portlet:namespace/>dataScadenzaBadgeExt" type="text" name="date" class="datepicker-custom input-custom-light data-parsley-validated" 		
																				   data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
						                                                    	   data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    	   data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   data-parsley-submission-date-check="#<portlet:namespace/>dataScadenzaBadgeExt"
						                                                    	   value="<%=moduloRichiedente.getDataScadenza()%>"	placeholder="<liferay-ui:message key="badge-inserimento-ph-data-scadenza"/>">
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <input id="<portlet:namespace/>dataScadenzaBadgeExt" type="text" name="date" class="datepicker-custom input-custom-light data-parsley-validated" 													
																				   data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
						                                                    	   data-parsley-maxlength="50" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"50\"}%>"/>"
						                                                    	   data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   data-parsley-submission-date-check="#<portlet:namespace/>dataScadenzaBadgeExt"
						                                                    	   placeholder="<liferay-ui:message key="badge-inserimento-ph-data-scadenza"/>">
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                </div>
				                                                <div class="ama-col-md-12 pt-15-md pb-15-md hidden-sm hidden-xs">
				                                                    <div class="border-dashed"></div>
				                                                </div>
				                                                <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs pt-20-md pb-20-md">
				                                                    <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="badge-inserimento-motivazione"/>*</label>
				                                                    <div class="wrapper-content-textarea">
				                                                    <c:choose>
																		<c:when test="<%=moduloRichiedente.getMotivazione()!=null && moduloRichiedente.getTipo() =="esterna"%>" >
						                                                    <textarea id="<portlet:namespace/>motivazioneExt" class="form-control textarea-custom-light data-parsley-validated" 
						                                                    	   	  data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   	  data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	      placeholder="<liferay-ui:message key="badge-inserimento-ph-motivazione"/>" ><%=moduloRichiedente.getMotivazione()%></textarea>
						                                                    <div class="content-textarea">0/100</div>
						                                              	</c:when>
				                                                    	<c:otherwise>
						                                                    <textarea id="<portlet:namespace/>motivazioneExt" class="form-control textarea-custom-light data-parsley-validated" 
						                                                    	   	  data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
						                                                    	   	  data-parsley-maxlength="100" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"100\"}%>"/>"
						                                                    	   	  placeholder="<liferay-ui:message key="badge-inserimento-ph-motivazione"/>"></textarea>
						                                                    <div class="content-textarea">0/100</div>
					                                                   	</c:otherwise>
						                                            </c:choose>
				                                                	</div>
				                                                </div>  
				                               	                            
					                                        </div>
					                                    </form>
					                                </div>
					                            </div>
					                        </div>
					                    </div>
					                </div>
					            </div>
				        </div>
				        
                 </div>
        	</div>
        </div>
    </div>
        		
    <!-- OGGETTO RICHIESTA -->
    <div class="ama-col-md-12 ama-col-xs-12 pt-10-md pt-20-xs">
        <form id="<portlet:namespace/>oggettoRichiesta" data-parsley-validate="true" enctype="multipart/form-data" >
       		<input id="<portlet:namespace/>checkObjectSelected" type="text" style="display:none"
                data-parsley-required = "true" data-parsley-required-message ="<liferay-ui:message key='error-mandatory'/>" >
       		<% for (OggettoRichiesta oggettoRichiesta :(List<OggettoRichiesta>)request.getAttribute("oggettoRichiestaList")) { %>
	            <div id="<portlet:namespace/>oggetto-richiesta<%=oggettoRichiesta.getId_oggetto()%>" class="ama-col-md-6 ama-col-xs-12 no-padding pb-10-md pb-10-xs pt-10-md pt-10-xs">
	                <div class="box-radio-custom">
	                    <input id="<portlet:namespace/>oggetto-richiesta-radio<%=oggettoRichiesta.getId_oggetto()%>" class="radio-custom-dark" type="radio" 
	                    	   value="<%=oggettoRichiesta.getId_oggetto()%>" data-parsley-required-message ="<liferay-ui:message key='error-mandatory'/>" name="<portlet:namespace/>checkOggetto">
	                	<label class="radio-custom-desc" for="<portlet:namespace/>oggetto-richiesta-radio<%=oggettoRichiesta.getId_oggetto()%>">
							<span><%=oggettoRichiesta.getDescrizione_oggetto()%></span>
						</label>
		                <c:if test="<%=( (oggettoRichiesta.getId_oggetto() == 2) || (oggettoRichiesta.getId_oggetto() == 4) || (oggettoRichiesta.getId_oggetto() == 5) )%>" >
		                	<input id="<portlet:namespace/>number-badge<%=oggettoRichiesta.getId_oggetto()%>" class="input-custom-number-badge data-parsley-validated" 
		                		   data-parsley-maxlength="10" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-length" arguments="<%=new String[]{\"10\"}%>"/>"
		                		   data-parsley-required-message ="<liferay-ui:message key='error-mandatory'/>" placeholder="<liferay-ui:message key="badge-inserimento-ph-numero-badge"/>" disabled> 
	                	</c:if>
	                </div>
	            </div>
            <% 	}  %>
    </form>
    
    </div>
		
	<!-- ALLEGATO -->    
	<div class="wrapper-allegati-general" id="<portlet:namespace/>wrapper-allegati-general" style="display:none" >
	 	<div class="ama-row">
		 	<div class="ama-col-md-12">
			 	<div class="wrapper-title-general">
				 	<h2 id="title-allegati" class="title-box borders"><liferay-ui:message key="badge-smarrimento-allegato"/>*</h2>
					<a id="tooltip-info-allegati" title='<liferay-ui:message key="badge-inserimento-allegato-info-foto"/>' class="tooltip-field">
						<span class="icomoon-info ico-attachments"></span>
					</a>
			 	</div>
		 	</div>
	 	</div>
	 	<form id="<portlet:namespace/>allegatoSelectedForm" data-parsley-validate="true" method="post" >
	 		<input id="<portlet:namespace/>allegatoSelected" type="text" data-parsley-required = "false" data-parsley-required-message ="<liferay-ui:message key='error-mandatory'/>" style="display:none">
	 	</form>
		<div class="ama-row">
			<div class="ama-col-md-12 mobile-no-padding">
				<div class="wrapper-content badge-attachment">
					<div class="wrapper-white" id="<portlet:namespace/>fileAttachDiv" style="display:none">
						<p class="text" id="<portlet:namespace/>fileName">
						 	<a href="" title="elimina file" onclick='' class="icomoon-close-white ico-delete"></a>
						</p>
					</div>
					<div class="wrapper-white" id="<portlet:namespace/>fileAttachDivOptional" style="display:none">
						<p class="text" id="<portlet:namespace/>fileNameOptional">
						 <a href="#" title="elimina file" onclick='' class="icomoon-close-white ico-delete"></a></p>
					</div>
				</div>
			</div>
		</div>
		<!-- SELEZIONA FILE -->
		<div class="ama-row" id="<portlet:namespace/>selectFile">
			<div class="ama-col-md-12 mobile-no-padding">
				<div class="box-button">
					<button href="#" type="button" id="<portlet:namespace/>addAttachFile" class="button button-primary" >
					<liferay-ui:message key="badge-inserimento-seleziona-allegato"/></button>
				</div>
			</div>
		</div>
	</div>    
		    
		    
	<!-- HIDDEN FORM RIEPILOGO -->
    <form id="<portlet:namespace/>proseguiRiepilogoBadge" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=richiestaBadge%>">
    	<input type="hidden" id="<portlet:namespace/>jsonRichiedente" name="<portlet:namespace/>jsonRichiedente">
        <input type="hidden" id="<portlet:namespace/>note" name="<portlet:namespace/>note">
    	<input type="hidden" id="<portlet:namespace/>jsonRichiestainterna" name="<portlet:namespace/>jsonRichiestainterna">
    	<input type="hidden" id="<portlet:namespace/>jsonRichiestaesterna" name="<portlet:namespace/>jsonRichiestaesterna">
        <div id="allegatoDiv"></div>
		<div id="allegatoDivOptional"></div>
		<input type="hidden" id="<portlet:namespace/>flagModificaPostSubmit" name="<portlet:namespace/>flagModificaPostSubmit">
    </form> 	    
		    
		    
		       
	<!-- NOTE -->	        
	<div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs pt-20-md pb-20-md">
       	<form>
       		<div class="wrapper-content-textarea textarea-badge">
                <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="badge-inserimento-note"/></label>
	   			<c:choose>
					<c:when test="<%=moduloRichiedente.getNote() != null%>" >
		                <textarea id="<portlet:namespace/>noteRichiestaBadge" class="form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti data-parsley-validated" 
		           				  data-parsley-minlength="10" data-parsley-minlength-message="<liferay-ui:message key="badge-error-min-textarea"/>" 
		           				  data-parsley-maxlength="500" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-textarea"/>" 
		           				  data-parsley-validation-threshold="10" name="<portlet:namespace/>_Descrizione"
		           				  placeholder="<liferay-ui:message key="badge-inserimento-aggiungi-descrizione"/>"><%=HtmlUtil.escape(moduloRichiedente.getNote())%></textarea>
		        		<div class="content-textarea">
	             			<p class="color-gray"><%=moduloRichiedente.getNote().length()%>/500</p>
	            		</div>
	                 	</c:when>
	                   <c:otherwise>
		                <textarea id="<portlet:namespace/>noteRichiestaBadge" class="form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti data-parsley-validated" 
			           			  data-parsley-minlength="10" data-parsley-minlength-message="<liferay-ui:message key="badge-error-min-textarea"/>" 
			           			  data-parsley-maxlength="500" data-parsley-maxlength-message="<liferay-ui:message key="badge-error-max-textarea"/>" 
			           			  data-parsley-validation-threshold="10" name="<portlet:namespace/>_Descrizione"
			           			  placeholder="<liferay-ui:message key="badge-inserimento-aggiungi-descrizione"/>"></textarea>
	                   <div class="content-textarea">
	             			<p class="color-gray">0/500</p>
	            		</div>
	                   </c:otherwise>
	            </c:choose>
            </div>
        </form>
    </div>
        

  
	<!-- PROSEGUI -->
    <div class="ama-row">
        <div class="ama-col-xs-12 text-center mb-20-xs mb-100-sm mt-20-xs mt-50-sm">
            <button class="button button-primary" id="<portlet:namespace/>proseguiRichiestaBadge"><liferay-ui:message key="badge-inserimento-prosegui"/></button>
        </div> 
    </div>
        
</div>
    
<!-- SPINNER -->    
<div id="idSpinner" class="spinner-wrap">
   <div class="spinner">
       <div class="bounce1"></div> <div class="bounce2"></div> <div class="bounce3"></div>
   </div>
</div>
    
<script>
	var idAttachFileDiv="#<portlet:namespace/>fileAttachDiv"; 
	var idFileAttach = "#<portlet:namespace/>fileAttach";
	var idSelectFile = "#<portlet:namespace/>selectFile";
	var idVecchioAllegato = "#<portlet:namespace/>vecchioAllegato";
	var idFileName= "#<portlet:namespace/>fileName";
	var acceptFile = ".jpg,.jpeg" ;
	var acceptFileOptional = ".pdf";
	var interna = "interna";
	var esterna = "esterna";
	var id_richiesta = <%=moduloRichiedente.getId_richiesta()%>;
	var tipoRichiesta = <%=moduloRichiedente.getTipo()%>;
	var oggRicheistaId = <%=moduloRichiedente.getOggettoRichiestaId()%>;
	var numBadge = "<%=moduloRichiedente.getNumeroBadge()%>";
	var sediString = "<%=moduloRichiedente.getSediAbilitate()%>";
	var dipartimento = "<%=dipartimento%>";
	var direzione = "<%=HtmlUtil.unescape(direzione)%>";
	var ufficio = "<%=HtmlUtil.unescape(ufficio)%>";
	var allegatoPath = "<%=allegatoPath%>";
	var allegatoOpzionalePath = "<%=allegatoOpzionalePath%>";
	var allegatoNome = "<%=allegatoNome%>";
	var allegatoOpzionaleNome = "<%=allegatoOpzionaleNome%>";
	var flagModificaPostRilascio = "<%=flagModificaPostSubmit%>";

	$("#<portlet:namespace/>oggetto-richiesta2").addClass('radio-box-badge');
	$("#<portlet:namespace/>oggetto-richiesta4").addClass('radio-box-badge');
	$("#<portlet:namespace/>oggetto-richiesta5").addClass('radio-box-badge');
	
	getStruttureInterne('847','<portlet:namespace/>dipartimento');
	hideSpinner();
	
	var isStruttureFlag = tipoRichiesta != null  && oggRicheistaId != null;
	if( tipoRichiesta != null  && oggRicheistaId != null )
		fromModificaRichiestaBadge ( tipoRichiesta, oggRicheistaId, numBadge, sediString, allegatoPath, allegatoOpzionalePath, allegatoNome, allegatoOpzionaleNome, flagModificaPostRilascio );
	else
		hideRadioInterna();
	
	function fromModificaRichiestaBadge ( is_internal, oggettoRichiestaId, numeroBadge, sedi, allegato, allegatoOpzionale, allegatoNomeMod, allegatoOpzionaleNomeMod, flagPostRilascio ){
		if( is_internal == null || is_internal == "interna" ){
			showInterna();
		} else {
			showEsterna();
			$("#<portlet:namespace/>Bntinterna").removeClass("active");
			$("#<portlet:namespace/>Bntesterna").addClass("active");
			$("#<portlet:namespace/>interna").removeClass("collapse in");
			$("#<portlet:namespace/>interna").addClass("collapse");
			$("#<portlet:namespace/>esterna").removeClass("collapse");
			$("#<portlet:namespace/>esterna").addClass("collapse in");
			if( sedi != null && sedi != "" ){
				var sediList = sedi.split(", ");
				for( var i=0; i<sediList.length; i++ )
					sediList[i] = sediList[i].replace(" ","_");
				for( var i=0; i<sediList.length; i++ )
					$("#<portlet:namespace/>"+sediList[i]).prop("selected", true);
			}
		}
		if( oggettoRichiestaId != null ) {
			$("#<portlet:namespace/>oggetto-richiesta-radio"+oggettoRichiestaId).prop("checked",true);
			onChangeCheckOggetto( true );
			if( oggettoRichiestaId == "2" || oggettoRichiestaId == "4" || oggettoRichiestaId == "5" ){
				$("#<portlet:namespace/>number-badge"+oggettoRichiestaId).val(numeroBadge);
				$("#<portlet:namespace/>number-badge"+oggettoRichiestaId).prop("disabled",false);

			}
		}
		if( allegato!=null && allegato!="" )
			changeDisplayFromModifica("", allegato, false, allegatoNomeMod);
		if( allegatoOpzionale!=null && allegatoOpzionale!="" )
			changeDisplayFromModifica("Optional", allegatoOpzionale, true, allegatoOpzionaleNomeMod );
		if( oggettoRichiestaId == "3" )
			if( allegato==null || allegato=="" || allegatoOpzionale==null || allegatoOpzionale=="" )
				$(idSelectFile).css("display","block");
		if( flagPostRilascio != null  && flagPostRilascio != "" ){
			$("#<portlet:namespace/>flagModificaPostSubmit").val(flagPostRilascio);
			for( var i=1; i<=5; i++)
				$("#<portlet:namespace/>oggetto-richiesta-radio"+i).attr('disabled', true);
			if( is_internal == "interna" )
				$("#<portlet:namespace/>Bntesterna").css("display","none");
			else 
				$("#<portlet:namespace/>Bntinterna").css("display","none");
		}
	}
	
    function changeDisplayFromModifica(addString, val, flagOptional, allegatoNome ){
        var input = document.createElement("input");
        var name = "<portlet:namespace/>allegato"+addString+"Hidden";
        $("#<portlet:namespace/>allegatoSelected").attr("data-parsley-required", "false");	
	    $(input).attr("id","<portlet:namespace/>fileAttach"+addString+"Hidden");
      	$(input).attr("type","hidden");
        $(input).attr("name",name);
        $(input).css("display","none");
        $(input).attr("value",val);
        $(input).attr("data-parsley-filemaxmegabytes","1");
        $(input).attr("data-parsley-trigger","change");
        $(input).attr("data-parsley-check-file-attach-extension",acceptFile);
        $("#allegatoDiv"+addString).append(input); 
        if (val!=null && val!="" ){
	          if( allegatoNome!= null && allegatoNome!="" ){
	        	  var value = allegatoNome;
	          } else {
	        	  var index = val.lastIndexOf('/');
		          var value = val.substring(index+1, val.length); 
	          }
              var input = document.createElement("input");
              $("#<portlet:namespace/>allegatoSelected").attr("data-parsley-required", "false");	
      	      $(input).attr("id","<portlet:namespace/>allegato"+"Nome"+addString);
              $(input).attr("type","hidden");
              $(input).attr("name","<portlet:namespace/>allegato"+"Nome"+addString);
              $(input).attr("value",value);
              $("#allegatoDiv"+addString).append(input); 
              
	          $(idAttachFileDiv+addString).css("display","block");
	          var insideText = "<a href='#' title='elimina file' onclick='removeAllegato(event,"; 
	          insideText = insideText.concat('"');
	          insideText = insideText.concat(addString+"Hidden");
	          insideText = insideText.concat('"');
	          insideText = insideText.concat(");' class='icomoon-close-white ico-delete'></a>");
			  $(idAttachFileDiv+addString).find(idFileName+addString).text(value);
			  $(idAttachFileDiv+addString).find(idFileName+addString).append(insideText);
	          if (flagOptional!=true){
	              var tabNoOptional = addString.replace("Optional", "");
	              $(idSelectFile+tabNoOptional).css("display","none");
	          }
	          $("#<portlet:namespace/>wrapper-allegati-general").css("display","block");          
	          $(idVecchioAllegato+addString).val("");
        }
    }
	
	function showInterna() {
		hideRadioInterna();
		$("#<portlet:namespace/>referenteMef").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>telReferenteMef").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>emailReferenteMef").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>nomeExt").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>cognomeExt").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>cfExt").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>luogoNascitaExt").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>dataNascitaExt").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>dipSocietaExt").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>sediAbilitateExt").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>dataScadenzaBadgeExt").attr("data-parsley-required", "false");
		
		$("#<portlet:namespace/>argument1interna").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>argument2interna").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>argument5interna").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>argument3interna").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>argument4interna").attr("data-parsley-required", "true");
	}
	
	function showEsterna() {
		showRadioEsterna();
		$("#<portlet:namespace/>argument1interna").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>argument2interna").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>argument5interna").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>argument3interna").attr("data-parsley-required", "false");
		$("#<portlet:namespace/>argument4interna").attr("data-parsley-required", "false");
		
		$("#<portlet:namespace/>referenteMef").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>telReferenteMef").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>emailReferenteMef").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>nomeExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>cognomeExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>cfExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>luogoNascitaExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>dataNascitaExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>dipSocietaExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>sediAbilitateExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>dataScadenzaBadgeExt").attr("data-parsley-required", "true");
		$("#<portlet:namespace/>motivazioneExt").attr("data-parsley-required", "true");
	}
	
	function hideSpinner(){ $('#idSpinner').removeClass('visible'); }
	function showSpinner(){ $('#idSpinner').addClass('visible'); }
	
	function hideRadioInterna(){
		$("#<portlet:namespace/>oggetto-richiesta4").css("display","none");
		$("#<portlet:namespace/>oggetto-richiesta5").css("display","none");
	}
	function showRadioEsterna(){
		$("#<portlet:namespace/>oggetto-richiesta4").css("display","block");
		$("#<portlet:namespace/>oggetto-richiesta5").css("display","block");
		$("#<portlet:namespace/>oggetto-richiesta4").checked = false;
		$("#<portlet:namespace/>oggetto-richiesta5").checked = false;
	}
	
	function getSuggestions(element,e){
		var doAjaxCall = $("#doAjaxCall").val();
		var namespace = $("#namespace").val();
		if(doAjaxCall == 'true'){
		    var inputValueId = "#" + element.id;
		    var inputElementName = element.name;
		    var isRilascio = true;
		    var inputValue = $(inputValueId).val();   
		    var idOrgChart = $("#idOrgChartId").val();
		    var userId = $("#idUserId").val();	 
			if(inputValue.length >= 3){
		    	document.getElementById('inserimentoInternaSuggestList').innerHTML = '';
		    	Liferay.Service(  '/mbadge.richiestabadge/find-suggestions-by-surname',
				    			  {
				    			    cognome: inputValue,
				    			    idOrgChart: idOrgChart,
				    			    userId: userId
				    			  },
				    			  function(obj) {
					    			    $("#doAjaxCall").val('false');
					    			    var label = "";
					    			    var valore = "";
					    				var options = '';
					    			    var index = 1;
					    			    $.each(obj,function(key, value){
					    			    	var objValue = value;
					    			    	$.each(objValue,function(key, valueJson){
						    			    	valore = valueJson.cognome + " | " + valueJson.nome + " | " + valueJson.codiceFisale + " | " + valueJson.luogoNascita + " | " + valueJson.dataNascita;
						    			    	options += '<option class="Option" id="option'+index+'"  value="'+valore+'"/>';
						    			    	index++;
					    			    	});
					                    });
					    			    if(isRilascio)
					    			    	document.getElementById('inserimentoInternaSuggestList').innerHTML = options;
					    			    $(inputValueId).trigger("focus");
				    			  });
		    } else {
		    	$("#doAjaxCall").val('true');
		    	if(isRilascio){
		        	if(document.getElementById('inserimentoInternaSuggestList').options.length>0){
		        		document.getElementById('inserimentoInternaSuggestList').innerHTML = '';
		        		$(inputValueId).trigger("blur");
		    	    	$(inputValueId).trigger("focus"); 
		        	}
		        }
		    }
		} else {	
			var inputValueId = "#" + element.id;
			var inputValue = $(inputValueId).val();
			if(inputValue.length < 3){
				$("#doAjaxCall").val('true');
			}else{
				var isInterna = true;
				var inputValueSplit = inputValue.split(" | ");
				if(isInterna){
					var idInputNomeRilascio = "#" + namespace + "argument2interna";
					var idInputCFRilascio = "#" + namespace + "argument5interna";
					var idInputLuogoNascitaRilascio = "#" + namespace + "argument3interna";
					var idInputDataNascitaRilascio = "#" + namespace + "argument4interna";
					if(inputValueSplit.length > 1){
						$(inputValueId).val(inputValueSplit[0]);
			        	$(idInputNomeRilascio).val(inputValueSplit[1]);
			        	$(idInputCFRilascio).val(inputValueSplit[2]);
			        	$(idInputLuogoNascitaRilascio).val(inputValueSplit[3]);
			        	$(idInputDataNascitaRilascio).val(inputValueSplit[4]);
			        	$(inputValueId).trigger("blur");
					}
		        }
			}
		}
	}
	
	function getSuggestionsExternal (element,e){
		var doAjaxCall = $("#doAjaxCall").val();
		var namespace = $("#namespace").val();
		if(doAjaxCall == 'true'){
		    var inputValueId = "#" + element.id;
		    var inputElementName = element.name;
		    var isRilascio = true;
		    var inputValue = $(inputValueId).val();    
			if(inputValue.length >= 3){
		    	document.getElementById('inserimentoEsternaSuggestList').innerHTML = '';
		    	Liferay.Service(  '/mbadge.anadipext/find-suggestions-ana-dip-ext-by-surname',
				    			  { cognome: inputValue },
				    			  function(obj) {
					    			$("#doAjaxCall").val('false');
				    			    var label = "";
				    			    var valore = "";
				    				var options = '';
				    			    var index = 1;
				    			    $.each(obj,function(key, value){
				    			    	var objValue = value;
				    			    	$.each(objValue,function(key, valueJson){
					    			    	valore = valueJson.cognome + " | " +  valueJson.nome + " | " + valueJson.codiceFiscale + " | "+ valueJson.luogoNascita + " | "+ valueJson.dataNascita;
					    			    	options += '<option class="Option" id="option'+index+'"  value="'+valore+'"/>';
					    			    	index++;
				    			    	});
				                    });
				    			    if(isRilascio)
				    			    	document.getElementById('inserimentoEsternaSuggestList').innerHTML = options;
				    			    $(inputValueId).trigger("focus");
				    			  });
		    } else {
		    	$("#doAjaxCall").val('true');
		    	if(isRilascio)
		        	if(document.getElementById('inserimentoEsternaSuggestList').options.length>0){
		        		document.getElementById('inserimentoEsternaSuggestList').innerHTML = '';
		        		$(inputValueId).trigger("blur");
		    	    	$(inputValueId).trigger("focus"); 
		        	}
		    }
		} else {	
			var inputValueId = "#" + element.id;
			var inputValue = $(inputValueId).val();
			if(inputValue.length < 3){
				$("#doAjaxCall").val('true');
			} else {
				var inputValueSplit = inputValue.split(" | ");
				var idInputNomeRilascio = "#" + namespace + "nomeExt";
				var idInputCFRilascio = "#" + namespace + "cfExt";
				var idInputLuogoNascitaRilascio = "#" + namespace + "luogoNascitaExt";
				var idInputDataNascitaRilascio = "#" + namespace + "dataNascitaExt";
				if(inputValueSplit.length > 1){
					$(inputValueId).val(inputValueSplit[0]);
		        	$(idInputNomeRilascio).val(inputValueSplit[1]);
		        	$(idInputCFRilascio).val(inputValueSplit[2]);
			        $(idInputLuogoNascitaRilascio).val(inputValueSplit[3]);
		        	$(idInputDataNascitaRilascio).val(inputValueSplit[4]);	
		        	$(inputValueId).trigger("blur");
				}
			}
		}
	}
	
	function getStruttureInterne (selectedVal, id) {
		clearStrutturaInterna(id);
		hideSpinner();
		showSpinner();
		if( selectedVal == '' ){
			document.getElementById(id).disabled = true;
			clearStrutturaInterna(id);
			hideSpinner();
		} else {
			Liferay.Service(  '/mefrubrica.searchdata/get-list-strutture-interne',
							  { idStruttura: selectedVal },
							  function(obj) {
								if( obj.length > 0 ){
									for (var i=0; i<obj.length; i++){
										var structureOption = document.createElement('option');
					       		    	structureOption.text = (obj[i].acronimo).value;
					       		    	structureOption.value = (obj[i].codStruttura).value;
					       		    	document.getElementById(id).appendChild(structureOption);
					       		    	if( id != '<portlet:namespace/>dipartimento'){
					       		    		getDettaglioUfficio( (obj[i].codStruttura).value, (i==(obj.length-1)) );
					       		    	} else {
					       	    			if( dipartimento!= null && dipartimento!="TUTTE" && dipartimento!='' )
					       	    				if( (obj[i].acronimo).value == dipartimento ){
					       	    					$('#<portlet:namespace/>dipartimento').val( (obj[i].codStruttura).value );
					       	    					getStruttureInterne ( (obj[i].codStruttura).value, '<portlet:namespace/>direzione' );
					       	    				}
					       		    	}
									}
								} else {
									hideSpinner();
								}
								document.getElementById(id).disabled = false;
								
								if( id == '<portlet:namespace/>ufficio' && selectedVal == 24741){
		       		    			$(".only-dsii-div").css("display","block");
		       		    			isStruttureFlag =false;
		       		    		} else {
		       		    			if(!isStruttureFlag){
		       		    				$('#<portlet:namespace/>sedeLegSocietaExt').val("");
			       		    			$('#<portlet:namespace/>indirizzoExt').val("");
			       		    			$('#<portlet:namespace/>recapitoTelExt').val("");
			       		    			$('#<portlet:namespace/>faxExt').val("");
			       		    			$('#<portlet:namespace/>pecExt').val("");
			       		    			$('#<portlet:namespace/>emailExt').val("");
			       		    			$('#<portlet:namespace/>refSocietaExt').val("");
			       		    			$('#<portlet:namespace/>emailRefSocietaExt').val("");
			       		    			$('#<portlet:namespace/>telUfficioExt').val("");
			       		    			$('#<portlet:namespace/>cellulareExt').val("");
			       		    			$('#<portlet:namespace/>contrattoExt').val("");
			       		    			$('#<portlet:namespace/>progettoExt').val("");
			       		    			$('#<portlet:namespace/>rigaPianoExt').val("");
			       		    			$('#<portlet:namespace/>postazioneExt').val("");
			       		    			$(".only-dsii-div").css("display","none");
		       		    			}
		       		    			
		       		    		}
								
							  });
		}
	}
	function clearStrutturaInterna ( id ){
	    var list = document.getElementById(id);
	    if (list!=null) {
		    while (list.hasChildNodes()) {
		      list.removeChild(list.childNodes[0]);
		    }
		    var structureOption = document.createElement('option');
	    	structureOption.text = 'TUTTE';
	    	structureOption.value = '';
	    	document.getElementById(id).appendChild(structureOption);
	    	document.getElementById(id).disabled = true;
	    }
	}
	function getDettaglioUfficio ( selectedVal , flagSpinner ) {
		Liferay.Service(  '/mefrubrica.searchdata/serv-dettagli-ufficio',
						  {
						    idUfficio: selectedVal
						  },
						  function(obj) {
							for (var i=0; i<obj.length; i++){
								$('option[value="'+selectedVal+'"]').text( (obj[i].descrizione).value );
			
								if( direzione!= null && direzione!="TUTTE" && direzione!='' )
					    			if( (obj[i].descrizione).value == direzione ){
					    				$('#<portlet:namespace/>direzione').val( selectedVal );
					    				getStruttureInterne ( selectedVal, '<portlet:namespace/>ufficio' );
					    			}
								if( ufficio!= null && ufficio!="TUTTE" && ufficio!='' )
					    			if( (obj[i].descrizione).value == ufficio )
					    				$('#<portlet:namespace/>ufficio').val( selectedVal );	
							}
			   		    	if( flagSpinner )
				    			hideSpinner();
						  });
	}	
	
    function selectAllegatoRichiestaBadge(event, accept, acceptOptional, required){
    	event.preventDefault();
		$('#<portlet:namespace/>forminterna').parsley().validate();
		$('#<portlet:namespace/>formesterna').parsley().validate();
		if( $('#<portlet:namespace/>forminterna').parsley().isValid() || $('#<portlet:namespace/>formesterna').parsley().isValid() ){
	        if (acceptOptional!=null && acceptOptional!=""){
	              if (($("#<portlet:namespace/>fileAttach").length>0 && $(idFileAttach).parsley().isValid()) || ($(idVecchioAllegato).length>0 && $(idVecchioAllegato).val()=="true" ) || ($("#<portlet:namespace/>fileAttachHidden").length>0 && ($("#<portlet:namespace/>fileAttachHidden").val()).length>0 ) ) {
	                 addParsleyFile(acceptOptional,false,required,"Optional");
	                 $(idFileAttach+"Optional").click();
	              } else {
	                 if ($("#<portlet:namespace/>fileAttachDivOptional").css("display")=="block")
	                    addParsleyFile(accept,false,required);
	                 else
	                    addParsleyFile(accept,true,required);
	                 $(idFileAttach).click();
	              }
	        } else {
	              addParsleyFile(accept,false,required);
	              $(idFileAttach).click();
	        }
		}
	}
	
    function addParsleyFile(accept, flagOptional,  required, addString, inputType){
        if (addString===undefined)
              addString="";
        $("#allegatoDiv"+addString).text("");
        var input = document.createElement("input");
  		$(input).attr("id","<portlet:namespace/>fileAttach"+addString);
        var name = "<portlet:namespace/>allegato";
        if (addString.indexOf('Optional')==0){
              name+= "Opzionale";
        }else{
            $(input).attr("data-parsley-required", required);
            $(input).attr("data-parsley-required-message","<liferay-ui:message key='error-mandatory'/>");
        }
        $(input).addClass('data-parsley-validated');
        $(input).css("display","none");
        $(input).attr("type","file");
        $(input).attr("name",name);
        $(input).attr("accept",accept);
        $(input).attr("data-parsley-filemaxmegabytes","1");
        $(input).attr("data-parsley-trigger","change");
        $(input).attr("data-parsley-check-file-attach-extension",accept);
        if( inputType != null && inputType != "")
        	$(input).attr("type",inputType);
        $(input).change(function() { changeDisplay(addString,this.value,flagOptional); });
        $("#allegatoDiv"+addString).append(input); 
  	}
	
    function changeDisplay(addString, val,flagOptional){
    	$(idFileAttach+addString).parsley().validate();
    	if (val!=null && val!="" && $(idFileAttach+addString).parsley().isValid()){
              $(idFileAttach+addString).parsley().destroy();
	      	  if( addString == "" )
	    			$("#<portlet:namespace/>allegatoSelected").attr("data-parsley-required", "false");
	      	  var value = "";
	          if( val.toLowerCase().indexOf(".jpg") != -1 || val.toLowerCase().indexOf(".jpeg") != -1 ){
	        	  if( $("#<portlet:namespace/>interna").hasClass("collapse in") )
	        	  	value = $("#<portlet:namespace/>argument1interna").val()+"."+$("#<portlet:namespace/>argument2interna").val()+".jpg";
	        	  else 
	        		value = $("#<portlet:namespace/>cognomeExt").val()+"."+$("#<portlet:namespace/>nomeExt").val()+".jpg";
	          } else {
		      	  var index = val.lastIndexOf('\\');
	        	  value = val.substring(index+1, val.length);
	          }
              $(idAttachFileDiv+addString).css("display","block");
              var insideText = "<a href='#' title='elimina file' onclick='removeAllegato(event,"; 
              insideText = insideText.concat('"');
              insideText = insideText.concat(addString);
              insideText = insideText.concat('"');
              insideText = insideText.concat(");' class='icomoon-close-white ico-delete'></a>");
		      $(idAttachFileDiv+addString).find(idFileName+addString).text(value);
		      $(idAttachFileDiv+addString).find(idFileName+addString).append(insideText);
              if (flagOptional!=true){
                    var tabNoOptional = addString.replace("Optional", "");
                    $(idSelectFile+tabNoOptional).css("display","none");
              }
              $(idVecchioAllegato+addString).val("");
        } else {
              if(!$(idFileAttach+addString).parsley().isValid())
                    resetAllegato(addString);
        }
    }
	
    function resetAllegato(addString){
        $(idAttachFileDiv+addString).css("display","none");
        $(idVecchioAllegato+addString).val("");
        var tabNoOptional = addString.replace("Optional", "");
        $(idSelectFile+tabNoOptional).css("display","block"); 
    }

    function removeAllegato(event,addString){
    	if( event != null ){
	        event.preventDefault();
    	    event.stopPropagation();	
    	}
   	  	if( addString == null || addString == "" || addString == "Hidden" )
 			$("#<portlet:namespace/>allegatoSelected").attr("data-parsley-required", "true");	
	   	if ( addString.match("Hidden") ) {
	        resetAllegato(addString.replace("Hidden",""));
	   	} else {
	        $(idFileAttach+addString).val("");
	        resetAllegato(addString);
	   	}
	    $(idFileAttach+addString).remove();
    }

	function onChangeCheckOggetto( flagModifica ) {
		var idOggetto = $("input[name=<portlet:namespace/>checkOggetto]:checked", "#<portlet:namespace/>oggettoRichiesta").val();
		removeAllegato(null,'Hidden');
		removeAllegato(null,'OptionalHidden');
		removeAllegato(null,'');
		removeAllegato(null,'Optional');
    	$("#<portlet:namespace/>number-badge2").attr("data-parsley-required", "false");
    	$("#<portlet:namespace/>number-badge4").attr("data-parsley-required", "false");
    	$("#<portlet:namespace/>number-badge5").attr("data-parsley-required", "false");
    	$("#<portlet:namespace/>checkObjectSelected").attr("data-parsley-required", "false");
    	$("#<portlet:namespace/>allegatoSelected").attr("data-parsley-required", "false");

		switch (idOggetto) {
	    case '1':
	    	$('#<portlet:namespace/>wrapper-allegati-general').css("display","block");
	    	$('#<portlet:namespace/>addAttachFile').attr('onclick',"selectAllegatoRichiestaBadge(event, '"+acceptFile+"', '', true )" );
	    	$("#tooltip-info-allegati").attr('title','<liferay-ui:message key="badge-inserimento-allegato-info-foto"/>');
	    	document.getElementById('title-allegati').innerHTML = '<liferay-ui:message key="badge-inserimento-allegato-opzionale"/>';
	    	if($("#<portlet:namespace/>esterna").hasClass("collapse in"))
	    		$('#<portlet:namespace/>wrapper-allegati-general').css("display","none");
			if( !flagModifica )
					addParsleyFile(acceptFile, false, false, '');
	        break;
	    case '2':
	    	$('#<portlet:namespace/>wrapper-allegati-general').css("display","block");
	    	$('#<portlet:namespace/>addAttachFile').attr('onclick',"selectAllegatoRichiestaBadge(event, '"+acceptFile+"', '', false )" );
	    	$("#<portlet:namespace/>number-badge2").attr("data-parsley-required", "true");
	    	$("#tooltip-info-allegati").attr('title','<liferay-ui:message key="badge-inserimento-allegato-info-foto"/>');
	    	document.getElementById('title-allegati').innerHTML = '<liferay-ui:message key="badge-inserimento-allegato-opzionale"/>';
	    	if($("#<portlet:namespace/>esterna").hasClass("collapse in"))
	    		$('#<portlet:namespace/>wrapper-allegati-general').css("display","none");
	    	if( !flagModifica )
	    		addParsleyFile(acceptFile, false,  false, '');
	        break;
	    case '3':
	    	$('#<portlet:namespace/>wrapper-allegati-general').css("display","block");
	    	$('#<portlet:namespace/>addAttachFile').attr('onclick',"selectAllegatoRichiestaBadge(event, '"+acceptFileOptional+"', '"+acceptFile+"', true )" );
	    	$("#<portlet:namespace/>allegatoSelected").attr("data-parsley-required", "true");
	    	$("#tooltip-info-allegati").attr('title','<liferay-ui:message key="badge-inserimento-allegato-info-doc"/>');
	    	document.getElementById('title-allegati').innerHTML = '<liferay-ui:message key="badge-inserimento-allegato"/>';
	    	if( !flagModifica )
	    		addParsleyFile(acceptFile, false,  true, "Optional");
	    	break;
	    case '4':
	    	$('#<portlet:namespace/>wrapper-allegati-general').css("display","none");
            $("#<portlet:namespace/>number-badge4").attr("data-parsley-required", "true");
	        break;
	    case '5':
	    	$('#<portlet:namespace/>wrapper-allegati-general').css("display","none");
            $("#<portlet:namespace/>number-badge5").attr("data-parsley-required", "true");
	        break;
	    default:
	    	break;
		}
	}
	
	$("input[name=<portlet:namespace/>checkOggetto]").change( function () { onChangeCheckOggetto(); });
	
	$("#<portlet:namespace/>proseguiRichiestaBadge").on('click', function(event){ 
		var isValidDatiRichiedente = $('#<portlet:namespace/>forminserimentobadge').parsley().isValid();
		$('#<portlet:namespace/>forminserimentobadge').parsley().validate(); 

		if( isValidDatiRichiedente ){
			var number_badge = "";
			var id_oggetto = $("input[name=<portlet:namespace/>checkOggetto]:checked", "#<portlet:namespace/>oggettoRichiesta").val();
			jsonRichiedente = {
									nomerichiedente : $("#<portlet:namespace/>nomeRichiedente").val(),
									cognomerichiedente : $("#<portlet:namespace/>cognomeRichiedente").val(),
									diprichiedente : $("#<portlet:namespace/>dipRichiedente").val(),
									dirrichiedente : $("#<portlet:namespace/>dirRichiedente").val(),
									uffrichiedente : $("#<portlet:namespace/>uffRichiedente").val(),
									telrichiedente : $("#<portlet:namespace/>telRichiedente").val(),
									emailrichiedente : $("#<portlet:namespace/>emailRichiedente").val()
							  };
			$('#<portlet:namespace/>jsonRichiedente').val(JSON.stringify(jsonRichiedente));
			
			var isValidTipoRichiesta = $("#<portlet:namespace/>oggettoRichiesta").parsley().isValid();
			$("#<portlet:namespace/>oggettoRichiesta").parsley().validate();
			
			if($("#<portlet:namespace/>interna").hasClass("collapse in")){
				var isValidOggettoRichiesta = $('#<portlet:namespace/>forminterna').parsley().isValid();
				$('#<portlet:namespace/>forminterna').parsley().validate();
				if( isValidOggettoRichiesta && isValidTipoRichiesta ){
					if( id_oggetto == 2 )
						number_badge = $("#<portlet:namespace/>number-badge"+id_oggetto).val();
					jsonRichiestaInterna = {
												id_richiesta : id_richiesta,
												cognomeint : $("#<portlet:namespace/>argument1interna").val(),
												nomeint : $("#<portlet:namespace/>argument2interna").val(),
												cfint : $("#<portlet:namespace/>argument5interna").val(),
												luogonascitaint: $("#<portlet:namespace/>argument3interna").val(),
												datanascitaint: $("#<portlet:namespace/>argument4interna").val(),
												oggetto : $("input[name=<portlet:namespace/>checkOggetto]:checked", "#<portlet:namespace/>oggettoRichiesta").val(),
												numbadge : number_badge
										   };
					$("#<portlet:namespace/>jsonRichiestainterna").val(JSON.stringify(jsonRichiestaInterna));						
				}	
			
			} else {
				var isValidStrutturaRichiesta = $('#<portlet:namespace/>formStrutturaesterna').parsley().isValid();
				$('#<portlet:namespace/>formStrutturaesterna').parsley().validate();
				var isValidOggettoRichiesta = $('#<portlet:namespace/>formesterna').parsley().isValid();
				$('#<portlet:namespace/>formesterna').parsley().validate();		
				
				isValidOggettoRichiesta = isValidOggettoRichiesta && isValidStrutturaRichiesta;
				if( isValidOggettoRichiesta ){
					if( (id_oggetto == 2) || (id_oggetto == 4) || (id_oggetto == 5) )
						number_badge = $("#<portlet:namespace/>number-badge"+id_oggetto).val();
						var sediList = $("#<portlet:namespace/>sediAbilitateExt").val();
						var sediString = "";
						if( sediList != null ){
							if( sediList.length > 0 ){
								sediList.forEach(function(element) { sediString = sediString.concat(element+", "); });
								sediString = sediString.substring(0, sediString.length-2);			
						}
					}
					
					jsonRichiestaEsterna = {
												id_richiesta : id_richiesta,
										        dipartimento: $("#<portlet:namespace/>dipartimento :selected").text(),
												direzione: $("#<portlet:namespace/>direzione :selected").text(),
												ufficio: $("#<portlet:namespace/>ufficio :selected").text(),
												referentemef: $("#<portlet:namespace/>referenteMef").val(),
												telreferentemef: $("#<portlet:namespace/>telReferenteMef").val(),
												emailreferentemef: $("#<portlet:namespace/>emailReferenteMef").val(),
												nomeest: $("#<portlet:namespace/>nomeExt").val(),
												cognomeest: $("#<portlet:namespace/>cognomeExt").val(),
												cfest: $("#<portlet:namespace/>cfExt").val(),
												luogonascitaest: $("#<portlet:namespace/>luogoNascitaExt").val(),
												datanascitaest: $("#<portlet:namespace/>dataNascitaExt").val(),
												societa: $("#<portlet:namespace/>dipSocietaExt").val(),
												sedesocieta: $("#<portlet:namespace/>sedeLegSocietaExt").val(),
												indirizzo: $("#<portlet:namespace/>indirizzoExt").val(),
												recapitotel: $("#<portlet:namespace/>recapitoTelExt").val(),
												fax: $("#<portlet:namespace/>faxExt").val(),
												pec: $("#<portlet:namespace/>pecExt").val(),
												email: $("#<portlet:namespace/>emailExt").val(),
												refsocieta: $("#<portlet:namespace/>refSocietaExt").val(),
												emailrefsocieta: $("#<portlet:namespace/>emailRefSocietaExt").val(),
												telufficio: $("#<portlet:namespace/>telUfficioExt").val(),
												cellulare: $("#<portlet:namespace/>cellulareExt").val(),
												contratto: $("#<portlet:namespace/>contrattoExt").val(),
												progetto: $("#<portlet:namespace/>progettoExt").val(),
												pianoext: $("#<portlet:namespace/>rigaPianoExt").val(),
												postazione: $("#<portlet:namespace/>postazioneExt").val(),
												sedi: sediString, 
												scadenza: $("#<portlet:namespace/>dataScadenzaBadgeExt").val(),
												motivazione: $("#<portlet:namespace/>motivazioneExt").val(),
												oggetto : $("input[name=<portlet:namespace/>checkOggetto]:checked", "#<portlet:namespace/>oggettoRichiesta").val(),
												numbadge : number_badge,
												sedepos : $("#<portlet:namespace/>sede").val(),
												pianopos : $("#<portlet:namespace/>piano").val(),
												corridoiopos : $("#<portlet:namespace/>corridoio").val(),
												fuoriportapos : $("#<portlet:namespace/>fuoriPorta").val()
										   };
					$("#<portlet:namespace/>jsonRichiestaesterna").val(JSON.stringify(jsonRichiestaEsterna));
				}
			}
			
			var isValidAllegati = $('#<portlet:namespace/>allegatoSelectedForm').parsley().isValid();
			$("#<portlet:namespace/>allegatoSelectedForm").parsley().validate();
			var isValidNote = $('#<portlet:namespace/>note').parsley().isValid();
			$('#<portlet:namespace/>note').parsley().validate();
			
			if( isValidDatiRichiedente && isValidOggettoRichiesta && isValidAllegati && isValidTipoRichiesta && isValidNote ){			
				$('#<portlet:namespace/>note').val($('#<portlet:namespace/>noteRichiestaBadge').val());
				$("#<portlet:namespace/>proseguiRiepilogoBadge").submit();
			}
		}
	});
	
	$('#<portlet:namespace/>oggetto-richiesta-radio1').click(function() {
		   if($('#<portlet:namespace/>oggetto-richiesta-radio1').is(':checked')) { 
			   $('#<portlet:namespace/>number-badge2').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge2').val("");
			   $('#<portlet:namespace/>number-badge4').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge4').val("");
			   $('#<portlet:namespace/>number-badge5').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge5').val("");

			   }
		});
	
	
	$('#<portlet:namespace/>oggetto-richiesta-radio3').click(function() {
		   if($('#<portlet:namespace/>oggetto-richiesta-radio3').is(':checked')) { 
			   $('#<portlet:namespace/>number-badge2').val("");
			   $('#<portlet:namespace/>number-badge2').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge4').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge4').val("");
			   $('#<portlet:namespace/>number-badge5').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge5').val("");

			   }
		});
	
	$('#<portlet:namespace/>oggetto-richiesta-radio2').click(function() {
		   if($('#<portlet:namespace/>oggetto-richiesta-radio2').is(':checked')) { 
			   $('#<portlet:namespace/>number-badge2').prop('disabled', false);
			   $('#<portlet:namespace/>number-badge4').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge4').val("");
			   $('#<portlet:namespace/>number-badge5').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge5').val("");

			   }
		});
	
	$('#<portlet:namespace/>oggetto-richiesta-radio4').click(function() {
		   if($('#<portlet:namespace/>oggetto-richiesta-radio4').is(':checked')) { 
			   $('#<portlet:namespace/>number-badge2').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge2').val("");
			   $('#<portlet:namespace/>number-badge4').prop('disabled', false);
			   $('#<portlet:namespace/>number-badge5').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge5').val("");

			   }
		});
	
	$('#<portlet:namespace/>oggetto-richiesta-radio5').click(function() {
		   if($('#<portlet:namespace/>oggetto-richiesta-radio5').is(':checked')) { 
			   $('#<portlet:namespace/>number-badge2').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge2').val("");
			   $('#<portlet:namespace/>number-badge4').prop('disabled', true);
			   $('#<portlet:namespace/>number-badge4').val("");
			   $('#<portlet:namespace/>number-badge5').prop('disabled', false);
			   }
		});
	
	
 </script> 
 <!--  modifica 2021 --> 
 

<script>
	var sede="${moduloRichiedente.getSedePostazione()}";
	var piano="${moduloRichiedente.getPianoPostazione()}";
	var corridoio="${moduloRichiedente.getCorridoioPostazione()}";
	var fuoriPorta="${moduloRichiedente.getFuoriPortaPostazione()}";


function resetComboz(combos) {
	if (combos != null) {
    	for (var i = 0; i <= combos.length; i++) {
           if ($("#<portlet:namespace/>" + combos[i]).length) {
                $("#<portlet:namespace/>" + combos[i]).empty();
            }        
		}
	}
}

function checkValueComboz(idCombo,valueCombo,arrayCombo){
	//Vengo dal return la fail invio mail oppure modifica richiesta
		 if(valueCombo!=""){
				 $(idCombo).find('option[value="'+valueCombo+'"]').attr("selected","selected");
	        	 $(idCombo).trigger( "change" );
	      //Primo avvio della form 	
	     }else if(arrayCombo.length==1){
	    		$($(idCombo).find('option')[1]).attr("selected","selected");
	        	$(idCombo).trigger( "change" );
			// Se la combo ha già l'option seleziona...  	
	      } 
	}


function loadComboSede(listaSedi){	
		comboz = $("#<portlet:namespace/>sede");
		comboz.empty();
        comboz.append("<option/>");
         
        $.each(listaSedi, function(i, item) {  
        console.log("id pk = "+item.id_pk_sede);  
         console.log("id = "+item.id_sede); 
        	$option = $("<option/>").attr("value", item.id_pk_sede+"##"+item.desc).text(item.desc);
        	comboz.append($option);
        });
        
        checkValueComboz("#<portlet:namespace/>sede",sede,listaSedi);
}

$('#<portlet:namespace/>sede').bind("change", function (event) { 
    	//console.log("on change sede");
    	_xval =  $(this).val();
    	
    	resetComboz(['piano','corridoio','fuoriPorta']);  
    	if(_xval){
        	sede = "";
        	loadComboPiano();     
        }
    	
});


function filterPiano(){
	  _sede = $("#<portlet:namespace/>sede").val().split("##")[0];
		_items = [];
		var listaPiani = ${listaPiani};
		$.each(listaPiani, function(i, item) {
		//console.log("item.id_sede = "+item.id_sede+"|| _sede = "+_sede);
			if(item.id_sede==_sede){
				if($.inArray(item,_items)< 0) {
				_items.push(item);
				}
			}
		});
		
		return _items;
	};

function loadComboPiano(){
		comboz = $("#<portlet:namespace/>piano");
		comboz.empty();
        comboz.append("<option/>");
        data = filterPiano();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item.id_pk_piano+"##"+item.desc).text(item.desc);
        	comboz.append($option);
        });	
        
        checkValueComboz("#<portlet:namespace/>piano",piano,data);
     }

$('#<portlet:namespace/>piano').bind("change", function (event) { 
        //console.log("on change piano");
       	_xval =  $(this).val();
       	resetComboz(['corridoio','fuoriPorta']);   
           
       	if(_xval){
           	piano = "";
           	loadComboCorridoio();        
           }	      	
    });

function filterCorridoio(){
	  _piano = $("#<portlet:namespace/>piano").val().split("##")[0];
		_items = [];
		var listaCorridoi = ${listaCorridoi};
		$.each(listaCorridoi, function(i, item) {
			if(item.id_piano==_piano){
				if($.inArray(item,_items)< 0) {
				_items.push(item);
				}
			}
		});
		
		return _items;
	};

function loadComboCorridoio(){
		comboz = $("#<portlet:namespace/>corridoio");
		comboz.empty();
        comboz.append("<option/>");
        data = filterCorridoio();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item.id_pk_corridoio+"##"+item.desc).text(item.desc);
        	comboz.append($option);
        });	
        
        checkValueComboz("#<portlet:namespace/>corridoio",corridoio,data);
        
	}
	
$('#<portlet:namespace/>corridoio').bind("change", function (event) { 
      //console.log("on change");        	
      	_xval =  $(this).val();    	
      	resetComboz(['fuoriPorta']);      
         
      	if(_xval){
          	corridoio = "";
          	loadComboFuoriPorta();         
          }	   		
    });
    
function filterFuoriPorta(){
	  _corridoio = $("#<portlet:namespace/>corridoio").val().split("##")[0];
		_items = [];
		var listaFuoriPorta = ${listaFuoriPorta};
		$.each(listaFuoriPorta, function(i, item) {
			if(item.id_corridoio==_corridoio){
				if($.inArray(item,_items)< 0) {
				_items.push(item);
				}
			}
		});
		
		return _items;
	};

function loadComboFuoriPorta(){
		comboz = $("#<portlet:namespace/>fuoriPorta");
		comboz.empty();
        comboz.append("<option/>");
        data = filterFuoriPorta();
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item.id_pk_fuoriPorta+"##"+item.desc).text(item.desc);
        	comboz.append($option);
        });	
        
        checkValueComboz("#<portlet:namespace/>fuoriPorta",fuoriPorta,data);
}
	
$('#<portlet:namespace/>fuoriPorta').bind("change", function (event) { 
	fuoriPorta="";
  });

</script>

<aui:script>
 AUI().ready(function(){ 
	var listaSedi = ${listaSedi};
	loadComboSede(listaSedi);
	//console.log("fine ready");
});

 </aui:script>
 
  <script>
 // mod temp auto riempimento campi form ext
 $(document).ready(function(){
	$("#<portlet:namespace/>telRichiedente").val(123456789);
	$("#<portlet:namespace/>referenteMef").val("Almaviva");
	$("#<portlet:namespace/>telReferenteMef").val(123456789);
	$("#<portlet:namespace/>emailReferenteMef").val("Almaviva@almaviva.it");
	$("#<portlet:namespace/>cognomeExt").val("Rossi"); 
	$("#<portlet:namespace/>nomeExt").val("Paolo");
	$("#<portlet:namespace/>cfExt").val("abcdef12g34h567i");
	$("#<portlet:namespace/>luogoNascitaExt").val("Roma");
	$("#<portlet:namespace/>dataNascitaExt").val("01/01/1990");
	$("#<portlet:namespace/>dipSocietaExt").val("Almaviva");
	$("#<portlet:namespace/>dataScadenzaBadgeExt").val("01/01/2021");
	$("#<portlet:namespace/>motivazioneExt").val("nuova richiesta badge esterno");
 });
 </script>