<%@page import="javax.portlet.PortletSession"%>
<%@ include file="/init.jsp" %>
<%@page import="mef.richieste.badge.bean.Richiedente"%>
<%@page import="mef.richieste.badge.bean.ModuloRichiedente"%>
<%@page import="java.io.File"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="servizio.richieste.badge.mef.model.RichiestaBadge"%>
<%@page import="servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="servizio.richieste.badge.mef.service.StatoRichiestaLocalServiceUtil"%>
<%@page import="servizio.richieste.badge.mef.service.OggettoRichiestaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.intranet.mef.job.siap.model.OrganizationChart"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="servizio.richieste.badge.mef.model.StatoRichiesta"%>
<%@ page import="servizio.richieste.badge.mef.service.SediEsterneLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="servizio.richieste.badge.mef.model.OggettoRichiesta" %>
<%@ page import="servizio.richieste.badge.mef.model.SediEsterne" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<portlet:actionURL var="cercaUtentiDaAbilitareUrl" name="cercaUtentiDaAbilitare"/>
<portlet:actionURL var="cercaUtentiAbilitatiUrl" name="cercaUtentiAbilitati"/>

<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"/>
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
<portlet:actionURL var="vaiAGestioneUtenti" name="vaiAGestioneUtenti"/>
<portlet:actionURL var="vaiAProrogaBadge" name="vaiAProrogaBadge"/> 

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<%
Log _logRicerca =LogFactoryUtil.getLog("ricerca_richieste_jsp");



String daRicerca = "";
if(request.getAttribute("daRicerca")!=null && !("").equalsIgnoreCase((String) request.getAttribute("daRicerca"))){
	daRicerca = (String) request.getAttribute("daRicerca");
}

	boolean dirigente = (boolean)request.getAttribute("roleDirigente");
	boolean abilitatoBadge = (boolean)request.getAttribute("roleAbilitato");
	boolean delegatoBadge = (boolean)request.getAttribute("roleDelegato");
	boolean gestoreExt = (boolean)request.getAttribute("roleGestoreExt");
	boolean gestoreInt = (boolean)request.getAttribute("roleGestoreInt");

	List<StatoRichiesta> lista_stati = new ArrayList<>();
	lista_stati = StatoRichiestaLocalServiceUtil.getStatoRichiestas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	boolean mostraTab = false;
	List<RichiestaBadge> listaRichieste = null;
	
	List<RichiestaBadge> listaRichiesteExt = null;
	List<RichiestaBadge> listaRichiesteInt = null;

	List<RichiestaBadge> listaRichiesteExtDef = null;
	List<RichiestaBadge> listaRichiesteIntDef = null;

	List<RichiestaBadge> listaInterne = null;
	List<RichiestaBadge> listaEsterne = null;
	Integer pageNumber = 0;
	Integer pageNumberInterne = 0;
	Integer pageNumberEsterne = 0;
	
    String activetab = "";
    

	JSONArray jsonArrayExcel = null;
	if (request.getAttribute("jsonExcel") != null) {
		jsonArrayExcel = JSONFactoryUtil.createJSONArray((String) request.getAttribute("jsonExcel"));
	}

	if (gestoreExt && gestoreInt) {
		
		//richieste interne
		if (request.getAttribute("listaIntRicerca") != null 
				&& !((List<RichiestaBadge>) request.getAttribute("listaIntRicerca")).isEmpty()) {
			listaRichiesteInt = (List<RichiestaBadge>) request.getAttribute("listaIntRicerca");
			listaRichieste = listaRichiesteInt;

		} else {
			listaRichiesteIntDef = (List<RichiestaBadge>) request.getAttribute("listaRichiesteGestoreInt");
			if(listaRichieste == null)
				listaRichieste = listaRichiesteIntDef;
		}
		
		

		//richieste esterne
		if (request.getAttribute("listaExtRicerca") != null
				&& !((List<RichiestaBadge>) request.getAttribute("listaExtRicerca")).isEmpty()) {
			listaRichiesteExt = (List<RichiestaBadge>) request.getAttribute("listaExtRicerca");
		listaRichieste = listaRichiesteExt;
		} else {
			listaRichiesteExtDef = (List<RichiestaBadge>) request.getAttribute("listaRichiesteGestoreExt");
			if(listaRichieste == null)
				listaRichieste = listaRichiesteExtDef;
		}
		
		
	} else {
		if (request.getAttribute("risultato_ricerca") != null
				&& !((List<RichiestaBadge>) request.getAttribute("risultato_ricerca")).isEmpty()) {
			listaRichieste = (List<RichiestaBadge>) request.getAttribute("risultato_ricerca");
		} else {
			if (request.getAttribute("listaRichiesteGestoreExt") != null
					&& !((List<RichiestaBadge>) request.getAttribute("listaRichiesteGestoreExt")).isEmpty()) {
				listaRichieste = (List<RichiestaBadge>) request.getAttribute("listaRichiesteGestoreExt");
			} else if (request.getAttribute("listaRichiesteGestoreInt") != null
					&& !((List<RichiestaBadge>) request.getAttribute("listaRichiesteGestoreInt")).isEmpty()) {
				listaRichieste = (List<RichiestaBadge>) request.getAttribute("listaRichiesteGestoreInt");
			}

		}
	}

	if (listaRichiesteInt != null && !listaRichiesteInt.isEmpty()) {
		listaInterne = listaRichiesteInt;
	} else {
		listaInterne = listaRichiesteIntDef;
	}

	if (listaRichiesteExt != null && !listaRichiesteExt.isEmpty()) {
		listaEsterne = listaRichiesteExt;
	} else {
		listaEsterne = listaRichiesteExtDef;
	}

	
	
	if( (listaRichiesteExtDef!=null && !listaRichiesteExtDef.isEmpty() && listaRichiesteIntDef!=null && !listaRichiesteIntDef.isEmpty() 
			&& listaRichiesteExt!=null && !listaRichiesteExt.isEmpty() && listaRichiesteInt!=null
			&& !listaRichiesteInt.isEmpty()) ||
		(listaRichiesteExtDef!=null && !listaRichiesteExtDef.isEmpty() && listaRichiesteIntDef!=null && !listaRichiesteIntDef.isEmpty() && listaRichiesteExt==null && listaRichiesteInt==null) ||
		(listaRichiesteExtDef==null && listaRichiesteIntDef==null && (listaRichiesteExt!=null) && !listaRichiesteExt.isEmpty()&& (listaRichiesteInt!=null) && !listaRichiesteInt.isEmpty())
	  )
	{
		mostraTab = true; 
	} else{
		if( listaRichiesteExt != null && !listaRichiesteExt.isEmpty() ){
			mostraTab = true;
			activetab = "esterna";
		} else if (listaRichiesteInt != null && !listaRichiesteInt.isEmpty()) {
			mostraTab = true;
			activetab = "interna";
		} else {
			mostraTab = false;
		}
    }

	
	if(request.getAttribute("fromPage")!=null){
	 	   activetab = (String)request.getAttribute("fromPage");
	 	   
	    }
	
	
	
	String jsonInputRicerca = "";
	
	if(request.getAttribute("jsonInputRicerca")!=null) {
		jsonInputRicerca = (String) request.getAttribute("jsonInputRicerca");
	}
	
%>
  <form action="<%=vaiAInserimento%>" id="<portlet:namespace/>NuovaRichiestaForm" method="post">
  </form>
<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                     <h2 class="title"><%=ricercaTitle%></h2>
                     <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
						<c:if test="<%=!gestoreExt && !gestoreInt%>">				
							<button href="#" type="button" class="button-xs button button-primary mr-10-xs" id="<portlet:namespace/>btnNuovaRichiesta">
								<liferay-ui:message key="badge-ricerca-bnt-nuova-richiesta"/>
								<span class="icomoon-plus icon-beni"></span>
							</button>						
						</c:if>
						<c:if test="<%=dirigente%>">
	                        <a href="<%=vaiAGestioneUtenti%>" title="Gestione Utenti"  class="icon icomoon-profile"></a>     
	                    </c:if>   
	                    <c:if test="<%=!gestoreExt && !gestoreInt%>">				
							<a href="<%=vaiAProrogaBadge%>" title="Proroga Badge" class="icon icomoon-time"></a>					
						</c:if>
						<c:if test="<%=jsonArrayExcel!=null%>">
							<form action="<%=resourceURL%>" method="post" id="<portlet:namespace/>excelForm" enctype="multipart/form-data"> 
							 	<input type="hidden" name="<portlet:namespace/>jsonExcel" id="json" value="<%=HtmlUtil.escape((String)request.getAttribute("jsonExcel"))%>">
                     		</form> 
	                     	<button title="excel" class="button-ex icomoon-pdf-border" id="<portlet:namespace/>downloadexcel"></button> 
						</c:if>
					  </div>
	               	  <p class="subtitle dot-point dot-200" style="word-wrap: break-word;"><%=ricercaSubtitle%></p>
	          	</div>
            </div>
        </div>
    </div>
</div>
     
<div class="ama-container-fluid">

	<div class="ama-row">
		<div class="ama-col-md-12">
			<div class="wrapper-title-small">
				<h2 class="title-box borders">
					<liferay-ui:message key="badge-ricerca-tl-cerca-richiesta" />
				</h2>
			</div>
		</div>
	</div>
	
	<div class="wrapper-tab-beni-consumo ">
        <portlet:actionURL var="ricercaRichieste" name="ricercaRichieste"></portlet:actionURL>
        <form id="<portlet:namespace/>formRicerca" method="post" action="<%=ricercaRichieste%>" enctype="multipart/form-data" >
          
             <div class="ama-row">
                <div class="col-md-4 mb-25-xs">
                    <label for="<portlet:namespace/>cogn_intest" class="label-form "><liferay-ui:message key="badge-ricerca-cognome-int"/></label>
                    <input onkeydown = "if (event.keyCode == 13) applicaRicerca()" id="<portlet:namespace/>cogn_intest" name="<portlet:namespace/>cogn_intest" class="checkField input-custom-light" placeholder="<liferay-ui:message key="badge-ricerca-ph-cognome-int"/>">
                </div>
                <div class="col-md-4 mb-25-xs">
                    <label for="<portlet:namespace/>nome_intest" class="label-form "><liferay-ui:message key="badge-ricerca-nome-int"/></label>
                    <input onkeydown = "if (event.keyCode == 13) applicaRicerca()" id="<portlet:namespace/>nome_intest" name="<portlet:namespace/>nome_intest" class="checkField input-custom-light" placeholder="<liferay-ui:message key="badge-ricerca-ph-nome-int"/>">
                </div>
                  <div class="col-md-4 mb-25-xs">
                    <label for="<portlet:namespace/>cf_intest" class="label-form "><liferay-ui:message key="badge-ricerca-cf"/></label>
                    <input onkeydown = "if (event.keyCode == 13) applicaRicerca()" id="<portlet:namespace/>cf_intest" name="<portlet:namespace/>cf_intest" class="checkField input-custom-light" placeholder="<liferay-ui:message key="badge-ricerca-ph-cf"/>">
                </div>                     
             </div>
             <div class="ama-row">
                <div class="col-md-4 mb-25-xs">
                	<label for="<portlet:namespace/>societa" class="label-form "><liferay-ui:message key="badge-ricerca-societa"/></label>
                    <input onkeydown = "if (event.keyCode == 13) applicaRicerca()" id="<portlet:namespace/>societa" name="<portlet:namespace/>societa" class="checkField input-custom-light" placeholder="<liferay-ui:message key="badge-ricerca-ph-societa"/>">
                </div>
                <div class="col-md-4 mb-25-xs">
                    <label for="<portlet:namespace/>ref_societa" class="label-form "><liferay-ui:message key="badge-ricerca-societa-ref"/></label>
                    <input onkeydown = "if (event.keyCode == 13) applicaRicerca()" id="<portlet:namespace/>ref_societa" name="<portlet:namespace/>ref_societa" class="checkField input-custom-light " placeholder="<liferay-ui:message key="badge-ricerca-ph-societa-ref"/>">
                </div>
                  <div class="col-md-4 mb-25-xs">
                    <label for="<portlet:namespace/>progetto" class="label-form "><liferay-ui:message key="badge-ricerca-progetto"/></label>
                    <input onkeydown = "if (event.keyCode == 13) applicaRicerca()" id="<portlet:namespace/>progetto" name="<portlet:namespace/>progetto" class="checkField input-custom-light " placeholder="<liferay-ui:message key="badge-ricerca-ph-progetto"/>">
                </div>                     
            </div>
            <div class="ama-row">
                <div class="col-md-4 mb-25-xs">
                	<label for="<portlet:namespace/>motivazione" class="label-form "><liferay-ui:message key="badge-ricerca-motivazione"/></label>
                    <input onkeydown = "if (event.keyCode == 13) applicaRicerca()" id="<portlet:namespace/>motivazione" name="<portlet:namespace/>motivazione" class="checkField input-custom-light " placeholder="<liferay-ui:message key="badge-ricerca-ph-motivazione"/>">
                </div> 
                 <div class="col-md-4 mb-25-xs">
					<label for="argument" class="label-form">STATO RICHIESTA</label> 
					<select onkeydown = "if (event.keyCode == 13) applicaRicerca()"
						id="<portlet:namespace/>statiRichiesta" name="<portlet:namespace/>statiRichiesta"
						class="checkField init-multiselect multiselect-ui form-control data-parsley-validated"
						multiple="multiple"
						data-parsley-required-message="<liferay-ui:message key="badge-error-seleziona-sede"/>">
						<c:forEach items="<%=lista_stati%>" var="statoRich">
						<option
							id="<portlet:namespace/>${statoRich.getId_stato()}"
							value="${statoRich.getId_stato()}">
							${statoRich.getDescrizione_stato()}
						</option>
						</c:forEach>
					</select> 
                </div> 
            </div> 
            
              <input type="text" style="display:none" id="<portlet:namespace/>inputParsley" name="<portlet:namespace/>inputParsley"
                        class="data-parsley-validated"
                        data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="badge-ricerca-no-parameters"/>"/>                     
            <div class="ama-row border-dotted-bt">
                <div class="ama-col-md-6 text-center mb-30-sm mb-30-xs mt-30-sm mt-0-xs">
                    <button class="button button-secondary" id="<portlet:namespace/>btnReset"><liferay-ui:message key="badge-ricerca-annulla"/></button>
                </div>
                <div class="ama-col-md-6 text-center mb-30-sm mb-30-xs mt-30-sm mt-0-xs">
                    <button type="button" onClick ="applicaRicerca()" class="button button-primary" id="<portlet:namespace/>btnApplica"><liferay-ui:message key="badge-ricerca-applica"/></button>
                </div>
            </div>

			<input type="hidden" id="<portlet:namespace/>jsonInputRicerca" name="<portlet:namespace/>jsonInputRicerca">
          
       </form>
    </div> 
      <% pageNumber = (Integer)request.getAttribute("numPageRichieste"); %>
  	<div class="ama-col-md-12 ama-col-xs-12 wrapper-richieste-badge" >
   		<div class="tab-filtri filtro-categoria">
            <c:if test="<%=request.getAttribute("filtriRicercaRichieste")!=null %>">
	               <div id="filtro-modulistica">
		               <div class="filtro-body-box">
		                   <div class="labels-container mt-0-xs text-center-xs">
		                       <span class="labels-container-title mt-0-xs"><liferay-ui:message key="beni-inv-ricerca-filtrato-per"/>: </span>
		                       <c:forEach items="<%=request.getAttribute("filtriRicercaRichieste")%>" var="filtro">
			                       <div class="filter-label-item mt-10-xs"> <h2>${filtro.toUpperCase()}</h2> </div>
		                       </c:forEach>
		                       <div class="filter-label-item mt-10-xs btn-filter-reset">
		                           <h2><liferay-ui:message key="beni-inv-ricerca-reset"/></h2><span class="icomoon-close-white"></span>
		                       </div>
		                       <span class="filtro-numbers"> <c:choose>
									<c:when test="<%=listaRichieste == null%>">
										<span class="bold">0</span>
									</c:when>
									<c:when test="<%=request.getAttribute("totalSize")!=null && 
									(Integer)request.getAttribute("totalSize")!=0%>">
										
										
										<span class="bold"><%=request.getAttribute("totalSize") %></span>
									</c:when>
									<c:otherwise>
										<span class="bold">non definito</span>
									</c:otherwise>
								</c:choose> <liferay-ui:message key="beni-inv-ricerca-richieste-risultato"/>
		                       </span>	
		                   </div>
	               	   </div>
	              
            </c:if>

	    <portlet:actionURL var="paginaRichiesteURL" name="paginaRichieste"/></portletactionURL>
            
		    <div class="js-list-pagination">
		      <div class="ama-row">
            <c:choose>
		      <c:when test="<%=mostraTab %>">

		         <div class="ama-col-xs-12">
               <div class="tab-filtri filtro-categoria collapse-group mobile-trasporti" id="tabs-profile">
		        <div class="filtro-tabs-wrapper mr-0-xs mt-0-xs ml-0-xs">
                   

                   
                   	<c:choose>
						<c:when test="<%="interna".equalsIgnoreCase(activetab) %>">
							<a href="" title="INTERNE" class="tab-title active" id="<portlet:namespace/>BntListaInt" data-toggle="collapse" data-target="#<portlet:namespace/>interne" 
                        	   data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-interni"/></a>
                  
                   			<c:if test="<%=!("").equalsIgnoreCase(daRicerca) && listaRichiesteExt != null && !listaRichiesteExt.isEmpty()%>" > 
	                    		 <a href="" title="ESTERNE" class="tab-title" id="<portlet:namespace/>BntListaExt" data-toggle="collapse" data-target="#<portlet:namespace/>esterne" 
	                        		data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-esterni"/></a>						
                   			</c:if> 
                   			<c:if test="<%=("").equalsIgnoreCase(daRicerca) && listaRichiesteExtDef != null && !listaRichiesteExtDef.isEmpty()%>" > 
	                    		 <a href="" title="ESTERNE" class="tab-title" id="<portlet:namespace/>BntListaExt" data-toggle="collapse" data-target="#<portlet:namespace/>esterne" 
	                        		data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-esterni"/></a>						
                   			</c:if> 
						</c:when>
						<c:when test="<%="esterna".equalsIgnoreCase(activetab) %>">
						
 							<c:if test="<%= !("").equalsIgnoreCase(daRicerca) && listaRichiesteInt!= null && !listaRichiesteInt.isEmpty()%>" > 
								<a href="" title="INTERNE" class="tab-title" id="<portlet:namespace/>BntListaInt" data-toggle="collapse" data-target="#<portlet:namespace/>interne" 
	                        	   data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-interni"/></a>
                  			</c:if> 
                  			<c:if test="<%= ("").equalsIgnoreCase(daRicerca) && listaRichiesteIntDef!= null && !listaRichiesteIntDef.isEmpty()%>" > 
								<a href="" title="INTERNE" class="tab-title" id="<portlet:namespace/>BntListaInt" data-toggle="collapse" data-target="#<portlet:namespace/>interne" 
	                        	   data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-interni"/></a>
                  			</c:if> 
                  	
                  		
                  			
                    		<a href="" title="ESTERNE" class="tab-title active"  id="<portlet:namespace/>BntListaExt" data-toggle="collapse" data-target="#<portlet:namespace/>esterne" 
                        	   data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-esterni"/></a>						
						</c:when>
						<c:otherwise>
							 <a href="" title="INTERNE" class="tab-title active" id="<portlet:namespace/>BntListaInt" data-toggle="collapse" data-target="#<portlet:namespace/>interne" 
                        		data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-interni"/></a>
                  
                    		 <a href="" title="ESTERNE" class="tab-title" id="<portlet:namespace/>BntListaExt" data-toggle="collapse" data-target="#<portlet:namespace/>esterne" 
                        		data-parent="#tabs-beni"><liferay-ui:message key="badge-ricerca-tab-richieste-esterni"/></a>
						</c:otherwise>
					</c:choose>
                   
                   
                   
	 		 	</div>


        	       <c:choose>
						<c:when test="<%="interna".equals(activetab) %>">
						     <div id="<portlet:namespace/>interne" class="collapse in">						
						</c:when>
						<c:when test="<%="esterna".equals(activetab) %>">
							     <div id="<portlet:namespace/>interne" class="collapse ">					
						</c:when>
						<c:otherwise>
							
						     <div id="<portlet:namespace/>interne" class="collapse in">
																		
						</c:otherwise>
					</c:choose>

 			
                     
	 		 	    <c:if test="<%=listaInterne != null && !listaInterne.isEmpty()%>">
	 		 	     	<c:forEach items="<%=listaInterne%>"   var="richiestaBadgeInt">
							<portlet:actionURL name="vaiADettaglio" var="vaiADettaglio">
								<portlet:param name="richiestaId" value="${richiestaBadgeInt.getId_pk()}" />
								<portlet:param name="jsonInputRicerca" value="<%=jsonInputRicerca%>" />
							</portlet:actionURL>
							
							
					<div class="search-item-badge ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
						<div class="item-pagination animated fadeIn">
							<div class="wrapper-badge-item mb-30-xs">
								<a href="<%=vaiADettaglio%>" title="" class="link-box-badge" >
								 <%  
			                                     String numeroBadge = "non disponibile";
			                                     String dataScadenzaND = "da definire";
			                                     RichiestaBadge richiestaBadgeInt= (RichiestaBadge) pageContext.getAttribute("richiestaBadgeInt");
			                                     if(richiestaBadgeInt.getNumero_badge()!=null && !("").equalsIgnoreCase(richiestaBadgeInt.getNumero_badge()))
			                                     numeroBadge = richiestaBadgeInt.getNumero_badge();

				                                     StatoRichiesta statorichiesta = null;
				                                     if(StatoRichiestaLocalServiceUtil.getStatoRichiesta(richiestaBadgeInt.getId_stato())!=null)
				                                    	  statorichiesta = StatoRichiestaLocalServiceUtil.getStatoRichiesta(richiestaBadgeInt.getId_stato());
			                                     %>
									<div class="badge-info-name">
										<span class="label-info">Intestatario:</span>
										<span class="text-info">${richiestaBadgeInt.getNome_intestatario().toUpperCase()} ${richiestaBadgeInt.getCognome_intestatario().toUpperCase()}</span>
									</div>
									<div class="approval-info">
										<p class="approval-data"><%=statorichiesta.getDescrizione_stato().toUpperCase()%></p>
									</div>
									<div class="badge-info-number">
										<span class="label-info">BADGE N°:</span>
										<span class="text-info"><%=numeroBadge%></span>
									</div>
								<% if(!(richiestaBadgeInt.getIs_internal())){%>	
									
									<div class="expiration-date">
										<span class="label-info">Scade il:</span>
										<span class="text-info">
										  <c:if test="${richiestaBadgeInt.getData_scadenza()!= null}">
										  <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${richiestaBadgeInt.getData_scadenza()}" /> 
										  </c:if>
									       <c:if test="${richiestaBadgeInt.getData_scadenza()==null}">
									       <%=dataScadenzaND%>
									       </c:if>
										</span>
									</div>
								<%} %>
								
								</a>
							</div>
						</div>
					</div>
		   		        
		   		        
		   		        </c:forEach> 
   		        
		   		               <%-- MODIFICA    --%>  
		 		 	     	<% 
							        Integer dimensioneListaInterne = (Integer)request.getAttribute("totalSize");
		 		 	     
									Integer pageCurrentInterne = (Integer)request.getAttribute("pageRichiesteInterne");
				 		 	     	pageNumberInterne = (Integer)request.getAttribute("numPageRichiesteInterne");
									String back_btn_interne = pageCurrentInterne==1 ? "disabled" : "";
									String forward_btn_interne = pageCurrentInterne==pageNumberInterne ? "disabled" : "";
									
		
							 %>
							<c:if test="<%= pageNumberInterne >1 %>">
							
		
		                    <form style="display:none" id="formPaginaRichiesteInterne" action="<%=paginaRichiesteURL%>" method="POST" enctype="multipart/form-data">					
								<input type="hidden" name="<portlet:namespace/>numpage" id="numpageRichiesteInterne">
								<input type="hidden" name="<portlet:namespace/>size" value="<%=dimensioneListaInterne%>" id="sizeRichiesteInterne">
								<input type="hidden" name="<portlet:namespace/>typeList" id="typeListRichiesteInterne">
							</form>
							

		                   	   <div class="ama-col-xs-12 text-align-center">
		                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
							
											<div class="btn-back-arrow <%= back_btn_interne %>">
		                                        <a href="#" onclick="showPagina(event, <%=pageCurrentInterne-1%>,'Interne')"><em class="icomoon-arrow"></em></a>
		                                        </div>
		                                        <ul class="pagination-numbers">
												
												<c:set var="currentPage" value="<%= pageCurrentInterne %>"/>
												<c:forEach var="tag" begin="1" end="<%=pageNumberInterne%>" >
													<c:choose>
													<c:when test="${tag==currentPage}">
														<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event,${tag},'Interne')" >${tag}</a></li>
													</c:when>
													<c:otherwise>
														<li id="pageClick${tag}"><a href="#" onclick="showPagina(event,${tag},'Interne')">${tag}</a></li>
													</c:otherwise>
													</c:choose>
												</c:forEach>
		                                        </ul>
		                                        <div class="btn-forward-arrow <%= forward_btn_interne %>">
		                                            <a href="#" onclick="showPagina(event,<%=pageCurrentInterne+1%>,'Interne')">
		                                                <em class="icomoon-arrow"></em>
		                                            </a>
		                                        </div>
		                                    </div>
		                      </div> 
		
							  </c:if>
							  
							  </c:if>

	 		 	     </div>
	 		 	     
	 		 	     
	 		 	      <c:choose>
						<c:when test="<%="interna".equals(activetab) %>">
				     	      	<div id="<portlet:namespace/>esterne" class="collapse">					
						</c:when>
						<c:when test="<%="esterna".equals(activetab) %>">
						    	<div id="<portlet:namespace/>esterne" class="collapse in">				
						</c:when>
						<c:otherwise>
							
					   	        <div id="<portlet:namespace/>esterne" class="collapse">
																		
						</c:otherwise>
					</c:choose>
	 		 	     
	 		 	     
	 		 	    
	 		 	  <c:if test="<%=listaEsterne!=null && !listaEsterne.isEmpty() %>">
	 		 
	 		 	     	<c:forEach items="<%=listaEsterne%>"   var="richiestaBadgeExt">
							<portlet:actionURL name="vaiADettaglio" var="vaiADettaglio">
								<portlet:param name="richiestaId" value="${richiestaBadgeExt.getId_pk()}" />
								<portlet:param name="jsonInputRicerca" value="<%=jsonInputRicerca%>" />
							</portlet:actionURL>
							
							
					<div class="search-item-badge ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
						<div class="item-pagination animated fadeIn">
							<div class="wrapper-badge-item mb-30-xs">
								<a href="<%=vaiADettaglio%>" title="" class="link-box-badge" >
								 <%  
			                                     String numeroBadge = "non disponibile";
			                                     String dataScadenzaND = "da definire";
			                                     RichiestaBadge richiestaBadgeExt= (RichiestaBadge) pageContext.getAttribute("richiestaBadgeExt");
			                                     if(richiestaBadgeExt.getNumero_badge()!=null && !("").equalsIgnoreCase(richiestaBadgeExt.getNumero_badge()))
			                                     numeroBadge = richiestaBadgeExt.getNumero_badge();

				                                     StatoRichiesta statorichiesta = null;
				                                     if(StatoRichiestaLocalServiceUtil.getStatoRichiesta(richiestaBadgeExt.getId_stato())!=null)
				                                    	  statorichiesta = StatoRichiestaLocalServiceUtil.getStatoRichiesta(richiestaBadgeExt.getId_stato());
			                                     %>
									<div class="badge-info-name">
										<span class="label-info">Intestatario:</span>
										<span class="text-info">${richiestaBadgeExt.getNome_intestatario().toUpperCase()} ${richiestaBadgeExt.getCognome_intestatario().toUpperCase()}</span>
									</div>
									<div class="approval-info">
										<p class="approval-data"><%=statorichiesta.getDescrizione_stato().toUpperCase()%></p>
									</div>
									<div class="badge-info-number">
										<span class="label-info">BADGE N°:</span>
										<span class="text-info"><%=numeroBadge%></span>
									</div>
								<%if(!(richiestaBadgeExt.getIs_internal())){ %>
									<div class="expiration-date">
										<span class="label-info">Scade il:</span>
										<span class="text-info">
										  <c:if test="${richiestaBadgeExt.getData_scadenza()!= null}">
										  <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${richiestaBadgeExt.getData_scadenza()}" />
										   </c:if>
									       <c:if test="${richiestaBadgeExt.getData_scadenza()==null}">
									       <%=dataScadenzaND%>
									       </c:if>
										</span>
									</div>
							<% }%>	
								</a>
							</div>
						</div>
					</div>
		   		        
		   		        
		   		        
		   		        
		   		        </c:forEach> 
        <%-- MODIFICA --%>  
		 		 	     	<% 
		 		 	                Integer dimensioneListaEsterne = (Integer)request.getAttribute("totalSize");
									Integer pageCurrentEsterne = (Integer)request.getAttribute("pageRichiesteEsterne");
				 		 	     	pageNumberEsterne = (Integer)request.getAttribute("numPageRichiesteEsterne");
									String back_btn_esterne = pageCurrentEsterne==1 ? "disabled" : "";
									String forward_btn_esterne = pageCurrentEsterne==pageNumberEsterne ? "disabled" : "";
		
							 %>
							<c:if test="<%= pageNumberEsterne >1 %>">
							
		
		                    <form style="display:none" id="formPaginaRichiesteEsterne" action="<%=paginaRichiesteURL%>" method="POST" enctype="multipart/form-data">					
								<input type="hidden" name="<portlet:namespace/>numpage" id="numpageRichiesteEsterne">
								<input type="hidden" name="<portlet:namespace/>size" value="<%=dimensioneListaEsterne%>" id="sizeRichiesteEsterne">
								<input type="hidden" name="<portlet:namespace/>typeList" id="typeListRichiesteEsterne">
							</form>
							

		                   	   <div class="ama-col-xs-12 text-align-center">
		                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
							
											<div class="btn-back-arrow <%= back_btn_esterne %>">
		                                        <a href="#" onclick="showPagina(event, <%=pageCurrentEsterne-1%>,'Esterne')"><em class="icomoon-arrow"></em></a>
		                                        </div>
		                                        <ul class="pagination-numbers">
												
												<c:set var="currentPage" value="<%= pageCurrentEsterne %>"/>
												<c:forEach var="tag" begin="1" end="<%=pageNumberEsterne%>" >
													<c:choose>
													<c:when test="${tag==currentPage}">
														<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event,${tag},'Esterne')" >${tag}</a></li>
													</c:when>
													<c:otherwise>
														<li id="pageClick${tag}"><a href="#" onclick="showPagina(event,${tag},'Esterne')">${tag}</a></li>
													</c:otherwise>
													</c:choose>
												</c:forEach>
		                                        </ul>
		                                        <div class="btn-forward-arrow <%= forward_btn_esterne %>">
		                                            <a href="#" onclick="showPagina(event,<%=pageCurrentEsterne+1%>,'Esterne')">
		                                                <em class="icomoon-arrow"></em>
		                                            </a>
		                                        </div>
		                                    </div>
		                      </div> 
		
							  </c:if>
							  
							  </c:if>
	 		 	     </div>
		    </div>
		    </div> 
		    </c:when>
		     <c:otherwise>
		     
		     	<c:forEach items="<%=listaRichieste%>" var="richiestaBadge">
							<portlet:actionURL name="vaiADettaglio" var="vaiADettaglio">
								<portlet:param name="richiestaId" value="${richiestaBadge.getId_pk()}" />
								<portlet:param name="jsonInputRicerca" value="<%=jsonInputRicerca%>" />
							</portlet:actionURL>
							
							
							<div class="search-item-badge ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
						<div class="item-pagination animated fadeIn">
							<div class="wrapper-badge-item mb-30-xs">
								<a href="<%=vaiADettaglio%>" title="" class="link-box-badge" >
								 <%  
			                                     String numeroBadge = "non disponibile";
			                                     String dataScadenzaND = "da definire";
			                                     RichiestaBadge richiestaBadge= (RichiestaBadge) pageContext.getAttribute("richiestaBadge");
			                                     if(richiestaBadge.getNumero_badge()!=null && !("").equalsIgnoreCase(richiestaBadge.getNumero_badge()))
			                                     numeroBadge = richiestaBadge.getNumero_badge();

				                                     StatoRichiesta statorichiesta = null;
				                                     if(StatoRichiestaLocalServiceUtil.getStatoRichiesta(richiestaBadge.getId_stato())!=null)
				                                    	  statorichiesta = StatoRichiestaLocalServiceUtil.getStatoRichiesta(richiestaBadge.getId_stato());
			                                     %>
									<div class="badge-info-name">
										<span class="label-info">Intestatario:</span>
										<span class="text-info">${richiestaBadge.getNome_intestatario().toUpperCase()} ${richiestaBadge.getCognome_intestatario().toUpperCase()}</span>
									</div>
									<div class="approval-info">
										<p class="approval-data"><%=statorichiesta.getDescrizione_stato().toUpperCase()%></p>
									</div>
									<div class="badge-info-number">
										<span class="label-info">BADGE N°:</span>
										<span class="text-info"><%=numeroBadge%></span>
									</div>
									<%if(!(richiestaBadge.getIs_internal())){ %>
													<div class="expiration-date">
														<span class="label-info">Scade il:</span>
														 <span class="text-info">
														  <c:if test="${richiestaBadge.getData_scadenza()!= null}">
																<fmt:formatDate pattern="dd/MM/yyyy" value="${richiestaBadge.getData_scadenza()}" />
															</c:if>
															 <c:if test="${richiestaBadge.getData_scadenza()==null}">
															 <%=dataScadenzaND%>
															 </c:if>
														</span>
													</div>
												<%} %>
											</a>
							</div>
						</div>
					</div>
		   		        
		   		        
		   		       </c:forEach>
		     
		       <%-- MODIFICA --%>  
		 		 	     	<% 
		 		 	                Integer dimensioneLista = (Integer)request.getAttribute("totalSize");
									Integer pageCurrent = (Integer)request.getAttribute("pageRichieste");				 		 	     
									String back_btn = pageCurrent==1 ? "disabled" : "";
									String forward_btn = pageCurrent==pageNumber ? "disabled" : "";
		
							 %>
							<c:if test="<%= pageNumber >1 %>">
							
		
		                    <form style="display:none" id="formPaginaRichiesteAll" action="<%=paginaRichiesteURL%>" method="POST" enctype="multipart/form-data">					
								<input type="hidden" name="<portlet:namespace/>numpage" id="numpageRichiesteAll">
								<input type="hidden" name="<portlet:namespace/>size" value="<%=dimensioneLista%>" id="sizeRichiesteAll">
								<input type="hidden" name="<portlet:namespace/>typeList" id="typeListRichiesteAll">
							</form>
							

		                   	   <div class="ama-col-xs-12 text-align-center">
		                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
							
											<div class="btn-back-arrow <%= back_btn %>">
		                                        <a href="#" onclick="showPagina(event, <%=pageCurrent-1%>,'All')"><em class="icomoon-arrow"></em></a>
		                                        </div>
		                                        <ul class="pagination-numbers">
												
												<c:set var="currentPage" value="<%= pageCurrent %>"/>
												<c:forEach var="tag" begin="1" end="<%=pageNumber%>" >
													<c:choose>
													<c:when test="${tag==currentPage}">
														<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event,${tag},'All')" >${tag}</a></li>
													</c:when>
													<c:otherwise>
														<li id="pageClick${tag}"><a href="#" onclick="showPagina(event,${tag},'All')">${tag}</a></li>
													</c:otherwise>
													</c:choose>
												</c:forEach>
		                                        </ul>
		                                        <div class="btn-forward-arrow <%= forward_btn %>">
		                                            <a href="#" onclick="showPagina(event,<%=pageCurrent+1%>,'All')">
		                                                <em class="icomoon-arrow"></em>
		                                            </a>
		                                        </div>
		                                    </div>
		                      </div> 
		
							  </c:if>
							  
							  <% 

		 		 	                Integer dimensioneListaEsterne = 0;
		 		 	                if(request.getAttribute("totalSize")!=null)
		 		 	                	dimensioneListaEsterne = (Integer)request.getAttribute("totalSize");
		 		 	                
		 		 	                
								    if(request.getAttribute("numPageRichiesteEsterne")!=null)
				 		 	     		pageNumberEsterne = (Integer)request.getAttribute("numPageRichiesteEsterne");
								    
				 		 	        Integer pageCurrentEsterne = 1;
				 		 	        String back_btn_esterne = "";
				 		 	        String forward_btn_esterne = "";
				 		 	        
				 		 	     	if(request.getAttribute("pageRichiesteEsterne")!=null){
					 		 	  	    pageCurrentEsterne = (Integer)request.getAttribute("pageRichiesteEsterne"); 
										back_btn_esterne = pageCurrentEsterne==1 ? "disabled" : "";
										forward_btn_esterne = pageCurrentEsterne==pageNumberEsterne ? "disabled" : "";
				 		 	     	}
		                           
							 %>
							<c:if test="<%= pageNumberEsterne >1 %>">
							
		
		                    <form style="display:none" id="formPaginaRichiesteEsterne" action="<%=paginaRichiesteURL%>" method="POST" enctype="multipart/form-data">					
								<input type="hidden" name="<portlet:namespace/>numpage" id="numpageRichiesteEsterne">
								<input type="hidden" name="<portlet:namespace/>size" value="<%=dimensioneListaEsterne%>" id="sizeRichiesteEsterne">
								<input type="hidden" name="<portlet:namespace/>typeList" id="typeListRichiesteEsterne">
							</form>
							

		                   	   <div class="ama-col-xs-12 text-align-center">
		                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
							
											<div class="btn-back-arrow <%= back_btn_esterne %>">
		                                        <a href="#" onclick="showPagina(event, <%=pageCurrentEsterne-1%>,'Esterne')"><em class="icomoon-arrow"></em></a>
		                                        </div>
		                                        <ul class="pagination-numbers">
												
												<c:set var="currentPage" value="<%= pageCurrentEsterne %>"/>
												<c:forEach var="tag" begin="1" end="<%=pageNumberEsterne%>" >
													<c:choose>
													<c:when test="${tag==currentPage}">
														<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event,${tag},'Esterne')" >${tag}</a></li>
													</c:when>
													<c:otherwise>
														<li id="pageClick${tag}"><a href="#" onclick="showPagina(event,${tag},'Esterne')">${tag}</a></li>
													</c:otherwise>
													</c:choose>
												</c:forEach>
		                                        </ul>
		                                        <div class="btn-forward-arrow <%= forward_btn_esterne %>">
		                                            <a href="#" onclick="showPagina(event,<%=pageCurrentEsterne+1%>,'Esterne')">
		                                                <em class="icomoon-arrow"></em>
		                                            </a>
		                                        </div>
		                                    </div>
		                      </div> 
		
							  </c:if>
							  
							  
							   	<% 
							    Integer dimensioneListaInterne = 0;
							    if(request.getAttribute("totalSize")!=null)
							        dimensioneListaInterne = (Integer)request.getAttribute("totalSize");
							    
							    Integer pageCurrentInterne = 1;
							    String back_btn_interne = "";
							    String forward_btn_interne = "";
							    
							    if(request.getAttribute("pageRichiesteInterne")!=null){
							    
									pageCurrentInterne = (Integer)request.getAttribute("pageRichiesteInterne");
				 		 	     	pageNumberInterne = (Integer)request.getAttribute("numPageRichiesteInterne");
								    back_btn_interne = pageCurrentInterne==1 ? "disabled" : "";
									forward_btn_interne = pageCurrentInterne==pageNumberInterne ? "disabled" : "";
							    }	
									
		
							 %>
							<c:if test="<%= pageNumberInterne >1 %>">
							
		
		                    <form style="display:none" id="formPaginaRichiesteInterne" action="<%=paginaRichiesteURL%>" method="POST" enctype="multipart/form-data">					
								<input type="hidden" name="<portlet:namespace/>numpage" id="numpageRichiesteInterne">
								<input type="hidden" name="<portlet:namespace/>size" value="<%=dimensioneListaInterne%>" id="sizeRichiesteInterne">
								<input type="hidden" name="<portlet:namespace/>typeList" id="typeListRichiesteInterne">
							</form>
							

		                   	   <div class="ama-col-xs-12 text-align-center">
		                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
							
											<div class="btn-back-arrow <%= back_btn_interne %>">
		                                        <a href="#" onclick="showPagina(event, <%=pageCurrentInterne-1%>,'Interne')"><em class="icomoon-arrow"></em></a>
		                                        </div>
		                                        <ul class="pagination-numbers">
												
												<c:set var="currentPage" value="<%= pageCurrentInterne %>"/>
												<c:forEach var="tag" begin="1" end="<%=pageNumberInterne%>" >
													<c:choose>
													<c:when test="${tag==currentPage}">
														<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event,${tag},'Interne')" >${tag}</a></li>
													</c:when>
													<c:otherwise>
														<li id="pageClick${tag}"><a href="#" onclick="showPagina(event,${tag},'Interne')">${tag}</a></li>
													</c:otherwise>
													</c:choose>
												</c:forEach>
		                                        </ul>
		                                        <div class="btn-forward-arrow <%= forward_btn_interne %>">
		                                            <a href="#" onclick="showPagina(event,<%=pageCurrentInterne+1%>,'Interne')">
		                                                <em class="icomoon-arrow"></em>
		                                            </a>
		                                        </div>
		                                    </div>
		                      </div> 
		
							  </c:if>
							  
							  
							  
							  
		     
		     </c:otherwise>          
		       
		       </c:choose>
		       </div>
		       
			 
    		
    		
    		
    		</div>
        
        </div>
    </div>
</div>
   
<portlet:actionURL var="vaiARicercaUrl" name="vaiARicerca"/>
<form id="<portlet:namespace/>formRefreshRicerca" method="post" action="<%=vaiARicercaUrl%>"></form>
   
<script>
function showPagina(event, id, tagId) {
	event.preventDefault();
	if(tagId === "Esterne")
		$("#typeListRichieste"+ tagId).val("listarichExt");
	if(tagId === "Interne")
		$("#typeListRichieste"+ tagId).val("listarichInt");
	if(tagId === "All")
		$("#typeListRichieste"+ tagId).val("listarich");
	
	$("#numpageRichieste" + tagId).val(id);
	$("#formPaginaRichieste" + tagId).submit();
}
changeFocusStatiRichiesta();
function changeFocusStatiRichiesta() {

    if (!$("#<portlet:namespace/>statiRichiesta").next().size()) {
      	setTimeout(changeFocusStatiRichiesta,200);
    }else {
    	$("#<portlet:namespace/>statiRichiesta").next().find("input[type='checkbox']").each(function(){

    	 $(this).click(
         	function() {
            	$( "#<portlet:namespace/>statiRichiesta" ).focus();
         });
    	
     });
  };

};



$('.icomoon-close-white').on('click',function(){  	
	$('#<portlet:namespace/>formRefreshRicerca').submit();
}); 

var checkFieldParsley = false;

function applicaRicerca(){
	checkField();
	
	if(checkFieldParsley){
		$('#<portlet:namespace/>inputParsley').val("ok");
	}
		
	$('#<portlet:namespace/>inputParsley').parsley().validate();			
	if($('#<portlet:namespace/>inputParsley').parsley().isValid()){
		
		var statiList = $("#<portlet:namespace/>statiRichiesta").val();
		var statiJsonValue = "";
		
			if(statiList != null){
				if(statiList.length > 0 ){
					statiList.forEach(function(element) { statiJsonValue = statiJsonValue.concat(element+", "); });
					statiJsonValue = statiJsonValue.substring(0, statiJsonValue.length-2);			
				}
			}
			
		var jsonInputRicerca = {
				cognome_int: $("#<portlet:namespace/>cogn_intest").val(),
				nome_int: $("#<portlet:namespace/>nome_intest").val(),
				cf_int: $("#<portlet:namespace/>cf_intest").val(),
				societa: $("#<portlet:namespace/>societa").val(),
				ref_societa: $("#<portlet:namespace/>ref_societa").val(),
				progetto: $("#<portlet:namespace/>progetto").val(),
				motivazione: $("#<portlet:namespace/>motivazione").val(),
				stati: statiJsonValue
		 }
		
		$("#<portlet:namespace/>jsonInputRicerca").val(JSON.stringify(jsonInputRicerca));
		
		$('#<portlet:namespace/>formRicerca').submit();
	}
	
}
 
 
 

 
 function checkField(){
	 $(".checkField").each(function() {
			if ($(this).val()!="" && $(this).val()!= null){	
				checkFieldParsley = true;
				return false;
			}
		});
 }
 
 
 
$('#<portlet:namespace/>btnReset').click(function(event){
	event.preventDefault();
	document.getElementById("<portlet:namespace/>formRicerca").reset();
});

$('#<portlet:namespace/>downloadexcel').click("on",function(){
	$('#<portlet:namespace/>excelForm').submit();
}); 

$('#<portlet:namespace/>btnNuovaRichiesta').click("on",function(){
	$('#<portlet:namespace/>NuovaRichiestaForm').submit();
}); 

</script>
