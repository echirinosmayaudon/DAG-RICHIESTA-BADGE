<%@page import="service.intranet.mef.model.StatoRichBeneInv"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="service.intranet.mef.service.StatoRichBeneInvLocalServiceUtil"%>
<%@page import="service.intranet.mef.model.StatoRichBeneInv"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>


<portlet:actionURL var="vaiANuovaRichiestaUrl" name="vaiANuovaRichiesta"/>
<portlet:actionURL var="vaiARicercaUrl" name="vaiARicerca"/>
       <form enctype="multipart/form-data" id="<portlet:namespace/>refreshPageRicerca" action="<%=vaiARicercaUrl%>" method="post">
                                    </form>
															
<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=beniInvRicercaTitle%></h2>
                             <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
                             <form action="<%=vaiANuovaRichiestaUrl%>" method="post" class="wrapper-icon-title-form">
                             
                             <c:if test="${richiedenteRole}">
                             
                                 <a href="<%=vaiANuovaRichiestaUrl%>">
                                 <button type="button" class="button-xs button button-primary mr-10-xs"><liferay-ui:message key="beni-inv-ricerca-nuova-rich"/>
                                     <span class="icomoon-plus icon-beni"></span>
                                 </button>
                                 </a>
                             
                             </c:if>
                             
                             </form>
                             
                              <%
    String elenco=null;                                    
   if((String) request.getAttribute("jsonRisultati")!=null) {
	   elenco=(String) request.getAttribute("jsonRisultati");
   }
   else{
	   elenco=(String) request.getAttribute("lista_default");   
   }

  JSONArray arrayRes=JSONFactoryUtil.createJSONArray(elenco);
%>
	      <portlet:resourceURL var="resourceURL">
			         		</portlet:resourceURL>
			         		
						<form action="<%=resourceURL%>" method="post" id="excelForm" enctype="multipart/form-data"> 
						
							 <input type="hidden" name="<portlet:namespace/>json" id="json" value="<%=HtmlUtil.escape(elenco)%>">
							 
                             </form> 
                              <button title="excel" class="button-ex icomoon-pdf-border" id="downloadexcel"></button> 
                          
<!--                                  <a href="#" title="search" class="icon icomoon-pdf-border"></a> -->
                             </div>
                          <p class="subtitle dot-point dot-200"><%=beniInvRicercaTxt%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>
        <portlet:actionURL var="ricercaRichiesteUrl" name="ricercaRichieste"/>

            <div class="ama-container-fluid">
                <div class="tab-filtri filtro-categoria">
                    <div class="filtro-tabs-wrapper riunione-modifica-stato-tabs">
                        <a href="" title="CERCA PERSONE" class="tab-title active" data-toggle="collapse" data-target="#CercaRichiesta"><liferay-ui:message key="beni-inv-ricerca-richiesta-search"/></a>
                    </div>
                    <div id="CercaRichiesta" class="collapse in mobile-padding-none">
                        <div class="wrapper-tab-beni-consumo ">
                            <div class="box-gray no-margin">
                                <div class="box-white box-gray-mobile">
                                    <form action="<%=ricercaRichiesteUrl%>" method="post" id="ricercaForm" enctype="multipart/form-data">
                                    <div data-parsley-check-date-role="" data-parsley-validate-if-empty=""> 
                                        <div class="ama-row">
                                            <div class="ama-col-md-6">
                                                <div class="ama-row">
                                                    <div class="ama-col-md-6">
                                                        <label  class="label-form mt-10-sm"><liferay-ui:message key="beni-inv-ricerca-id"/></label>
                                                        <input 
                                                        	id="idRichiestaResearch" name="<portlet:namespace/>idRichiesta" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-beni-inv-inserimento-id"/>">
                                                    </div>
                                                    <div class="ama-col-md-6 border-after">
                                                        <label for="date-deadline" class="label-form mt-10-sm"><liferay-ui:message key="beni-inv-ricerca-richiesta-dati"/></label>
                                                        <input id="date-deadline" 
                                                        	data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
															data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                                        	name="<portlet:namespace/>date-deadline" class="input-custom-light datepicker-custom data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-beni-inv-ricerca-data"/>"
                                                        	>
                                                    </div>
                                                </div>
                                               <c:if test="${!richiedenteRole==true}">
                                                <div class="ama-row">
                                                    <div class="ama-col-md-6">
                                                        <label for="nomeRichiedente" class="label-form mt-10-sm"><liferay-ui:message key="beni-inv-ricerca-nome-rich"/></label>
                                                        <input id="nomeRichiedente"  
															name="<portlet:namespace/>nomeRichiedente" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-beni-inv-inserimento-nome"/>" >
                                                    </div>
                                                     <div class="ama-col-md-6 border-after">
                                                        <label for="cognomeRichiedente" class="label-form mt-10-sm"><liferay-ui:message key="beni-inv-ricerca-cognome-rich"/></label>
                                                        <input id="cognomeRichiedente"  
                                                        	name="<portlet:namespace/>cognomeRichiedente" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-beni-inv-inserimento-cognome"/>" >
                                                    </div>
                                                     </div>
                                                    </c:if>
                                                    
                                               
                                                <div class="ama-row">
                                                    <div class="ama-col-md-6">
                                                        <label for="tipologia" class="label-form mt-10-sm"><liferay-ui:message key="beni-inv-ricerca-tipologia"/></label>
                                                        <select id="tipologia" name="<portlet:namespace/>tipologia" class="option-select-notice">
                                                            <option value="" hidden><liferay-ui:message key="beni-inv-ricerca-scelta-tipologia"/></option>
                                                            <c:if test="<%=request.getAttribute("tipoBeneList")!=null%>">
                                                            <c:forEach items="<%=request.getAttribute("tipoBeneList")%>" var="tipoBene">
                                                            <option value="${tipoBene.getTipo()}">${tipoBene.getTipo().toUpperCase()}</option>
                                                            </c:forEach>
                                                            </c:if>
                                                        </select>
                                                    </div>
                                                   <c:if test="${responsabileCDCRole}">
                                                    <div class="ama-col-md-6 border-after">
                                                        <label for="dipartimento" class="label-form mt-10-sm"><liferay-ui:message key="beni-inv-ricerca-dipartimento"/></label>
                                                        <input 
                                                        	id="dipartimento"  name="<portlet:namespace/>dipartimento" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-inserimento-nome"/>" >
                                                    </div> 
                                                    </c:if>                               
                                                </div>
                      
                                                 <div class="ama-row">
                                                  <div class="ama-col-md-6 ">
                                                        <div class="checkbox-blue mt-40-xs mb-10-md">
                                                            <div class="squaredOne">
                                                                <input type="checkbox" value="None" id="squaredOne" name="<portlet:namespace/>check" onchange="changeFuoriElenco(this)"/>
                                                                <label for="squaredOne"></label>
                                                            </div>
                                                            <p class="text-check"><liferay-ui:message key="beni-inv-ricerca-fuori-contesto"/></p>
                                                        </div>      
                                                    </div>

                                                 </div>                                                         
                                            </div>
        
                                        <div class="ama-col-md-6">
                                                <label for="argument" class="label-form mt-10-sm"><liferay-ui:message key="beni-inv-ricerca-stato"/></label>
                                                <div class="ama-row" id="stato">
                                                <c:if test="<%=request.getAttribute("statoRichBeneList")!=null%>">
                                                <c:forEach items="<%=request.getAttribute("statoRichBeneList")%>" var="statoRichiesta">
                                                <%  
                                                StatoRichBeneInv statoImg=(StatoRichBeneInv) pageContext.getAttribute("statoRichiesta");
                                                String stato=statoImg.getStato();
                                                %>
                                                     
                                                       
             
                                                  <c:if test="${richiedenteRole || consegnatarioRole}">
                                                      <div class="ama-col-lg-4 ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
                                                        <button class="box-gray-beni box-beni-inventariati"  type="button"> 
                                                        <c:if test="<%=stato.equalsIgnoreCase("nuova") %>"> 
                                                            <span class="icon-tab icomoon-file"></span>                                                     
                                                             <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                              <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                            </c:if>
                                                             <c:if test="<%=stato.equalsIgnoreCase("accettata") %>"> 
                                                          <span class="icon-tab icomoon-success-blu"></span>
                                                           <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                             <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                            </c:if>
                                                             <c:if test="<%=stato.equalsIgnoreCase("rifiutata")%>"> 
                                                            <span class="icon-tab icomoon-cancel"></span>
                                                             <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                             <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                            </c:if>
                                                             <c:if test="<%=stato.equalsIgnoreCase("evasa")%>"> 
                                                              <span class="icon-tab icomoon-cart"></span>
                                                               <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                             <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                            </c:if>
                                                            <c:if test="<%=stato.equalsIgnoreCase("non evasa")%>"> 
                                                                <span class="icon-tab icomoon-cart-2"></span>
                                                                 <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                             <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                            </c:if>
                                                             <c:if test="<%=stato.equalsIgnoreCase("consegnata")%>"> 
                                                                <span class="icon-tab icomoon-cart-3"></span>
                                                                 <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                             <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                            </c:if>
                                                            <c:if test="<%=stato.equalsIgnoreCase("acquisto richiesto")%>"> 
                                                     
                                                                 <span class="icon-tab icomoon-question2"></span>
                                                                  <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                          <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                         </c:if>
                                                              <c:if test="<%=stato.equalsIgnoreCase("acquisto autorizzato")%>"> 
                                                             
                                                                  <span class="icon-tab icomoon-question1"></span>
                                                                   <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                  <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                 </c:if>
                                                             <c:if test="<%=stato.equalsIgnoreCase("acquisto respinto")%>">
                                                       
                                                                    <span class="icon-tab icomoon-question3"></span>
                                                                     <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                               <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                              </c:if>
                                                           
                                                             </button>
                                                            </div> 
                                                        </c:if>
                                                        
                                                     <c:if test="${responsabileCDCRole}">
                                                       <c:if test="<%=stato.equalsIgnoreCase("acquisto richiesto") || stato.equalsIgnoreCase("acquisto autorizzato") || stato.equalsIgnoreCase("acquisto respinto")%>">
                                                             <div class="ama-col-lg-4 ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
                                                        <button class="box-gray-beni box-beni-inventariati"  type="button"> 
                                                             <c:if test="<%=stato.equalsIgnoreCase("acquisto richiesto")%>"> 
                                                     
                                                                 <span class="icon-tab icomoon-question2"></span>
                                                                  <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                          <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                         </c:if>
                                                              <c:if test="<%=stato.equalsIgnoreCase("acquisto autorizzato")%>"> 
                                                             
                                                                  <span class="icon-tab icomoon-question1"></span>
                                                                   <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                                  <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                                 </c:if>
                                                             <c:if test="<%=stato.equalsIgnoreCase("acquisto respinto")%>">
                                                       
                                                                    <span class="icon-tab icomoon-question3"></span>
                                                                     <p class="text-tab dot-45 dot-point dot-mobile"> ${statoRichiesta.getStato().toUpperCase()}</p>
                                               <input type="hidden" value=" ${statoRichiesta.getId()}" name="<portlet:namespace/>idStato"/> 
                                              </c:if>
                                              </button>
                                              </div>
                                                 </c:if>
                                                         </c:if> 
                                                          
                                                        
                                                    </c:forEach>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                   
        </div>
                                <div class="ama-row">
                                    <div class="ama-col-md-6 text-center mb-40-sm mb-0-xs mt-50-sm mt-0-xs">
                                        <button onclick="resetForm(event)" class="button button-secondary"><liferay-ui:message key="beni-inv-ricerca-annulla"/></button>
                                    </div>
                                    <div class="ama-col-md-6 text-center mb-40-sm mb-30-xs mt-50-sm mt-0-xs">
                                        <button onclick="submitForm()" class="button button-primary"><liferay-ui:message key="beni-inv-ricerca-applica"/></button>
                                    </div>
                                </div>
                                
                                <input type="hidden" id="arrayLabelStati" name="<portlet:namespace/>arrayLabelStati"/>
                                 </form>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
           


     <c:if test="<%=elenco!=null %>">       
           
       <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-md-12 ama-col-xs-12">
                     <div class="tab-filtri filtro-categoria">
                     
                     <c:if test="<%= request.getAttribute("jsonRisultati")!=null%>">
                    
                         <div class="filtro-tabs-wrapper">
                            <span class="tab-title active"><liferay-ui:message key="beni-inv-ricerca-risultati-title"/>
                            </span>
                         </div>
                       </c:if>  
                         
                         <div id="filtro-modulistica">
                         
                             <c:if test="<%= request.getAttribute("jsonRisultati")!=null%>">
                          <c:if test="<%=request.getAttribute("filtriRicercaRichieste")!=null %>">
                             <div class="filtro-body-box">
                                 <div class="labels-container mt-0-xs text-center-xs">
                                     <span class="labels-container-title mt-0-xs"><liferay-ui:message key="beni-inv-ricerca-filtrato-per"/>: </span>
                                     <c:forEach items="<%=request.getAttribute("filtriRicercaRichieste")%>" var="filtro">
                                     <div class="filter-label-item mt-10-xs">
                                         <h2>${filtro.toUpperCase()}</h2>
                                     </div>
                                    </c:forEach>
                             
                                     <div class="filter-label-item mt-10-xs btn-filter-reset">
                                         <h2><liferay-ui:message key="beni-inv-ricerca-reset"/></h2><span class="icomoon-close-white"></span>
                                     </div>
                             
                                      <span class="filtro-numbers">
                                         <span class="bold"><%=arrayRes.length()%> 
                                         </span>
                                         <liferay-ui:message key="beni-inv-ricerca-richieste-risultato"/>
                                     </span>	

                                 </div>
                             </div>
                             </c:if>
                          </c:if>  
                         
                        
                      <portlet:actionURL var="vaiADettaglioUrl" name="vaiADettaglio"/>    
                             <div class="modulistica-wrapper">
                                 <div class="ama-row">
                                     <div class="ama-col-xs-12">
                                     
                                    <c:if test="<%= request.getAttribute("jsonRisultati") != null && arrayRes.length()<1%>"> 
                                      <p class="copy-text wysiwyg-editor"><liferay-ui:message key="beni-inv-nessun-risultato"/></p>
                                   </c:if>
                                   
                                 <% for(int i=0;i<arrayRes.length();i++) {
                         		JSONObject jsonRichiesta = JSONFactoryUtil.createJSONObject(arrayRes.get(i).toString());
                         		%>
                         		
                         		 <form action="<%=vaiADettaglioUrl%>" method="post" id="formDettaglio<%=i%>" enctype="multipart/form-data"> 
                         		   <input type="hidden" value="<%=jsonRichiesta.get("id_richiesta")%>" name="<portlet:namespace/>id_rich"/>
                                         <a href="<%=vaiADettaglioUrl%>" title="" class="box-white-beni wrapper-beni-inventariati-elenco" onclick="submitFormDettaglio(event,'<%=i%>')">
                                             <div class="ama-row">
                                                 <div class="ama-col-md-5 ama-col-xs-12 border-box display-none">
                                                     <div class="wrap-info">
                                                      <%
                                                         StatoRichBeneInv stato=StatoRichBeneInvLocalServiceUtil.getStatoRichBeneInv((jsonRichiesta.getLong("id_stato")));
                                                         %>  
                                                         
                                                            <c:if test="<%=stato.getStato().equalsIgnoreCase("nuova")%>">
                                                              <span class="ico icomoon-file mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             <c:if test="<%=stato.getStato().equalsIgnoreCase("accettata")%>">
                                                              <span class="ico icomoon-success-blu mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             <c:if test="<%=stato.getStato().equalsIgnoreCase("rifiutata")%>">
                                                              <span class="ico icomoon-cancel mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             <c:if test="<%=stato.getStato().equalsIgnoreCase("evasa")%>">
                                                              <span class="ico icomoon-cart mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             <c:if test="<%=stato.getStato().equalsIgnoreCase("non evasa")%>">
                                                              <span class="ico icomoon-cart-2 mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             <c:if test="<%=stato.getStato().equalsIgnoreCase("consegnata")%>">
                                                              <span class="ico icomoon-cart-3 mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             <c:if test="<%=stato.getStato().equalsIgnoreCase("acquisto richiesto")%>">
                                                              <span class="ico icomoon-question2 mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             <c:if test="<%=stato.getStato().equalsIgnoreCase("acquisto autorizzato")%>">
                                                              <span class="ico icomoon-question1 mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                              <c:if test="<%=stato.getStato().equalsIgnoreCase("acquisto respinto")%>">
                                                              <span class="ico icomoon-question3 mr-10-xs"></span>
                                                              <p class="file-text mr-30-xs"><%=stato.getStato().toUpperCase()%></p>
                                                             </c:if>
                                                             
                                                         <span class="title-id dot-point dot-mobile dot-35"><p class="id">ID:</p>
                                                          <%=jsonRichiesta.get("id_richiesta")%>
                                                          </span>
                                                       
                                                         <p class="title-beni title-bold dot-point dot-mobile dot-30 mt-5-xs display-block"><%=jsonRichiesta.get("oggetto")%></p>
                                                     </div>
                                                 </div>
                                         
                                         
                                                 <div class="ama-col-md-2 ama-col-xs-12 border-box display-none">
                                                     <p class="title-beni dot-mobile dot-66 dot-point text-align line-height"><%=jsonRichiesta.get("nome_rich")%>
                                                         <%=jsonRichiesta.get("cogn_rich")%>
                                                     </p>
                                                 </div>
                                                 <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12 border-box">
                                                     <p class="title-beni dot-point dot-mobile dot-66 title-bold mb-20-xs mb-0-sm line-height">  <%=jsonRichiesta.get("dip_dir").toString().toUpperCase()%></p>
                                                 </div>
                                                 <div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-12 text-center">
                                                     <span class="ico-date icomoon-calendar-date mr-10-md"></span>
  
                                                     <p class="date-format"><%=jsonRichiesta.getString("data")%></p>
                                                 </div>
                                             </div>
                                         </a>
                                        
                                        </form>
                                           <%} %>
     
                                     </div>
                                 </div>
                             </div>
                             
                        
                         </div>
                     </div>
                 </div>
             </div>
         </div>
         </c:if>
         <script>
         
         $('.icomoon-close-white').on('click',function(){  	
        	 $('#<portlet:namespace/>refreshPageRicerca').submit();
        }); 
         
         function changeFuoriElenco(cb){   	
        	 if(cb.checked) {  	
        		  $('#tipologia').prop('disabled', true);
    	    }
        	 else{
        		  $('#tipologia').prop('disabled', false);
        	 }
         }
         
         
         var checkCategory = function(){
        	 var arrayNomeStato=[];
        	 resetFilterCategory();
 			 $(".box-beni-inventariati").each(function() {		
 					if ($(this).is(".active")){
 						var input = document.createElement("input");				    
 					     $(input).attr("type", 'hidden');				  
 					     $(input).attr("name", '<portlet:namespace/>stato_richiesta');
				         $(input).val($(this).children()[2].value);				  
  					     $(this).append(input);
  					     arrayNomeStato.push($(this).children()[1].innerHTML);
 		          }      
 		  		}); 
 			 return arrayNomeStato;
 		}
         
         
         function removeClassActive(){
         	  resetFilterCategory();      
             	  $(".box-beni-inventariati").each(function() {
       				if ($(this).is(".active")){	
       					 $(this).removeClass("active");
       				}
       			});

           }
       	

        function resetFilterCategory(){
	    	 
	    	 $("input[name=<portlet:namespace/>stato_richiesta]").each(function() {
				 $(this).remove();
			 });
		}
        
        function submitFormDettaglio(event,index){
        	 event.preventDefault();
        	$('#formDettaglio'+index).submit();	
        }
        
        
        function submitForm(){
        	$("#arrayLabelStati").val(checkCategory());
        	$('#ricercaForm').submit();	
        }
 
         $("#downloadexcel").click("on",function(){
			 $("#excelForm").submit();
         });
         
         function resetForm(event){
        	 event.preventDefault();
        	 removeClassActive();
        		document.getElementById("ricercaForm").reset();
        		$('#tipologia').prop('disabled', false);
        		
         }
       
         </script>