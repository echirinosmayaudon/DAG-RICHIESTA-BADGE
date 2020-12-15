<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.accenture.mef.lavoro.agile.form.bean.RisultatoRicerca"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ include file="/init.jsp" %>

<%
	Log _log = LogFactoryUtil.getLog("ricerca_jsp");


	PortletSession sessionJsp = renderRequest.getPortletSession();
	

// 	boolean booleanRichiedenteLavAgile = false;
// 	boolean booleanLayoutViewPermissionRichiedenteLavAgile = false;

	String order = StringPool.BLANK;
	String jsonString = StringPool.BLANK;
	String jsonCognome = "";

	if (request.getAttribute("jsonString") != null){
		jsonString = ((String) request.getAttribute("jsonString"));
		JSONObject json = JSONFactoryUtil.createJSONObject(jsonString);
		jsonCognome = HtmlUtil.escape(json.getString("cognome")).replace("amp;", "");
		json.put("cognome",jsonCognome);
		jsonString = json.toJSONString();
	}
// 	else if(sessionJsp.getAttribute("jsonString", sessionJsp.APPLICATION_SCOPE)!=null ){
// 		jsonString = ((String) sessionJsp.getAttribute("jsonString", sessionJsp.APPLICATION_SCOPE));
//	}


	if (request.getAttribute("radioOrder") != null)
		order = ((String) request.getAttribute("radioOrder"));
// 	else if(sessionJsp.getAttribute("radioOrder", sessionJsp.APPLICATION_SCOPE)!=null ){
// 		order = ((String) sessionJsp.getAttribute("radioOrder", sessionJsp.APPLICATION_SCOPE));
// 	}
	

	List<RisultatoRicerca> lista_richieste = (List<RisultatoRicerca>) request.getAttribute("defaultList");
	if (request.getAttribute("res") != null) {
		lista_richieste = (List<RisultatoRicerca>) request.getAttribute("res");
	}
	
	
	Integer dimensioneLista = 0;
	if (request.getAttribute("totalSize") != null)
		dimensioneLista = (Integer) request.getAttribute("totalSize");
	
	
// 	if (request.getAttribute("booleanRichiedenteLavAgile") != null) {
// 		booleanRichiedenteLavAgile = (boolean) request.getAttribute("booleanRichiedenteLavAgile");
// 	}
// 	if (request.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgile") != null) {
// 		booleanLayoutViewPermissionRichiedenteLavAgile = (boolean) request
// 				.getAttribute("booleanLayoutViewPermissionRichiedenteLavAgile");
// 	}

	JSONArray jsonArrayExcel = null;
	String jsonArrayExcelString = "";
	if (request.getAttribute("richiesta_lav_agile_excel_jsonarray_ricerca") != null) {
		jsonArrayExcel = JSONFactoryUtil
				.createJSONArray((String) request.getAttribute("richiesta_lav_agile_excel_jsonarray_ricerca"));
		jsonArrayExcelString = (String) request.getAttribute("richiesta_lav_agile_excel_jsonarray_ricerca");
	} else if (request.getAttribute("richiesta_lav_agile_excel_jsonarray_default") != null) {
		jsonArrayExcel = JSONFactoryUtil
				.createJSONArray((String) request.getAttribute("richiesta_lav_agile_excel_jsonarray_default"));
		jsonArrayExcelString = (String) request.getAttribute("richiesta_lav_agile_excel_jsonarray_default");
	}
	
	// IMEF-1780
	boolean requestInsertConditionOK = false;
	if(request.getAttribute("requestInsertConditionOK")!=null) {
		requestInsertConditionOK = (boolean)request.getAttribute("requestInsertConditionOK");
	}
	// end IMEF-1780
%>
<portlet:actionURL var="vaiAInserimento" name="vaiAInserimento"/> 
<portlet:actionURL var="ricerca" name="ricerca"/>
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<form enctype="multipart/form-data"
	id="<portlet:namespace/>refreshPageRicerca"
	action="<%=vaiARicerca%>" method="post"></form>
	
<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                    <h2 class="title"><%=formTitleSearch%></h2>
                    
                    <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
						<c:if test="<%=requestInsertConditionOK%>">
							<button href="#" type="button"
								class="button-xs button button-primary mr-10-xs"
								id="<portlet:namespace/>btnNuovaRichiestaRicerca">
									<liferay-ui:message key="btnNuovaRichiesta"/>
								<span class="icomoon-plus icon-beni"></span>
							</button>
						</c:if>
					</div>
		
					<form action="<%=vaiAInserimento%>"
						id="<portlet:namespace/>nuovaRichiestaFormRicerca" method="post">
					</form>
                    
                    <p class="subtitle dot-point dot-200"><%=formSubTitleSearch%></p>
                </div>
            </div>
        </div>
    </div>
</div>


    <!-- search -->
    <div class="ama-container-fluid">

        <div class="tab-filtri filtro-categoria">

            <div class="filtro-tabs-wrapper riunione-modifica-stato-tabs">
                <a href="" title="<liferay-ui:message key="ricerca-title"/>" class="tab-title active" data-toggle="collapse"
                    data-target="#CercaRichiesta"><liferay-ui:message key="cercaRichiesta"/></a>
            </div>

            <div id="CercaRichiesta" class="collapse in mobile-padding-none">

                <div class="form-request">

                    <div class="box-gray no-margin">

                        <div class="box-white box-gray-mobile">

                            <form action="<%=ricerca%>" id="<portlet:namespace/>searchFm" method="post">

                                <div class="ama-row">
                                <div class="ama-col-sm-4 ama-col-xs-12">
									<label for="<portlet:namespace/>codiceIstanza" class="label-form mt-10-sm">
										<liferay-ui:message key='codiceIstanza'/></label> <input id="<portlet:namespace/>codiceIstanza" name="<portlet:namespace/>codiceIstanza" 
										class="input-custom-light checkField"
										placeholder="<liferay-ui:message key='codiceIstanza-placeholder'/>"
										type="text"
										data-parsley-pattern="^[1-9][0-9]*$"
										data-parsley-pattern-message="<liferay-ui:message key="ricerca-codice-istanza-parsley"/>." 
										data-parsley-errors-container=".errorCodiceIstanza"
										onkeydown = "if (event.keyCode == 13) submitForm((document.getElementById('<portlet:namespace/>btnRicerca')).name)"
										/>
								</div>
                                   	<div class="ama-col-sm-8 ama-col-xs-12">
									<label for="<portlet:namespace/>cognome"
										class="label-form mt-10-sm"><liferay-ui:message key='cognome'/></label> <input
										id="<portlet:namespace/>cognome"
										name="<portlet:namespace/>cognome" class="input-custom-light checkField"
										placeholder="<liferay-ui:message key='cognome-placeholder'/>" 
										data-parsley-minlength="2"
										data-parsley-minlength-message="<liferay-ui:message key="ricerca-cognome-caratteri-parsley"/>"  
										data-parsley-pattern="^(?!\s*$).+"
										data-parsley-pattern-message="<liferay-ui:message key="ricerca-cognome-carattere-non-nullo"/>." 
										data-parsley-errors-container=".errorCognome"
										onkeydown = "if (event.keyCode == 13) submitForm((document.getElementById('<portlet:namespace/>btnRicerca')).name)"
										/>
								</div>
                                   <div class="ama-col-sm-4 ama-col-xs-12">
									<label for="<portlet:namespace/>dipartimento"
										class="label-form mt-10-sm"><liferay-ui:message key='label-dipartimento'/></label> <select
										id="<portlet:namespace/>dipartimento"
										name="<portlet:namespace/>dipartimento"
										class="option-select-notice checkField"
										onchange="getStruttureInterne(this.value, '<portlet:namespace/>direzione')"
										onkeydown = "if (event.keyCode == 13) submitForm((document.getElementById('<portlet:namespace/>btnRicerca')).name)">
										<option value="0">SCEGLI DALL'ELENCO</option>
									</select>
								</div>
                                    
                                    
                                  <div class="ama-col-sm-4 ama-col-xs-12">
									<label for="<portlet:namespace/>direzione"
										class="label-form mt-10-sm"><liferay-ui:message key='label-direzione'/></label> <select
										id="<portlet:namespace/>direzione" 
										name="<portlet:namespace/>direzione"
										class="option-select-notice checkField" disabled
										onchange="getStruttureInterne(this.value, '<portlet:namespace/>ufficio')"
										onkeydown = "if (event.keyCode == 13) submitForm((document.getElementById('<portlet:namespace/>btnRicerca')).name)">
										<option value="0" hidden>SCEGLI DALL'ELENCO</option>
									</select>
								</div>
                                    
                                    
                                   <div class="ama-col-sm-4 ama-col-xs-12">
									<label for="<portlet:namespace/>ufficio"
										class="label-form mt-10-sm"><liferay-ui:message key='label-ufficio'/></label> <select
										id="<portlet:namespace/>ufficio" 
										name="<portlet:namespace/>ufficio"
										class="option-select-notice checkField" disabled
										onkeydown = "if (event.keyCode == 13) submitForm((document.getElementById('<portlet:namespace/>btnRicerca')).name)">
										<option value="0" hidden>SCEGLI DALL'ELENCO</option>
									</select>
								</div>
                                </div>

							<input type="hidden" id="<portlet:namespace/>radioOrder"
								name="<portlet:namespace/>radioOrder" />
								<input type="hidden" id="<portlet:namespace/>jsonFiltri"
								name="<portlet:namespace/>jsonFiltri" />

							<div class="ama-row">
                                <div class="ama-col-sm-6 text-center mb-40-sm mb-0-xs mt-50-sm mt-0-xs">
                                   <button type="button" onclick="resetForm(event)" class="button button-secondary"><liferay-ui:message key='cancella-selezione'/></button>
                                </div>
        
                                <div class="ama-col-sm-6 text-center mb-40-sm mb-30-xs mt-50-sm mt-0-xs">
                                    <button type="button" onclick="submitForm(this.name)" name="<portlet:namespace/>btnRicerca" class="button button-primary" id="<portlet:namespace/>btnRicerca"><liferay-ui:message key='button-ricerca'/></button>
                                </div>
                            </div>

							<div class="errorCodiceIstanza"></div>
							<div class="errorCognome"></div>
							
							<input type="text"
							       style="display:none"
							       id="<portlet:namespace/>inputParsley"
							       name="<portlet:namespace/>inputParsley"
			                       class="data-parsley-validated"
			                       data-parsley-required="true"
								   data-parsley-required-message="<liferay-ui:message key="ricerca-valorizzare-un-campo"/>."
								   />   

                            </form>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-md-12 ama-col-xs-12">
                <div class="tab-filtri filtro-categoria">
                    <div class="filtro-tabs-wrapper">
                        <span class="tab-title active"><liferay-ui:message key='elenco-richieste-ricerca'/>
                        </span>
                    </div>
                    <div>
                   
                   <c:choose>
	                   	<c:when test="<%= request.getAttribute("filtriRicercaRichieste")!=null && !((List<String>) request.getAttribute("filtriRicercaRichieste")).isEmpty() %>">
	                   		<div class="filtro-body-box mb-15-sm mb-20-md">
	                            <div class="labels-container mt-0-xs text-center-xs">
	                                <span class="labels-container-title mt-0-xs"><liferay-ui:message key='filtrato-per'/>:</span>
	                                   <c:forEach items="<%=request.getAttribute("filtriRicercaRichieste")%>" var="filtro">
	                                   <div class="filter-label-item mt-10-xs">
	                                  <h2>${filtro.toUpperCase()}</h2>
	                                </div>
	                                   </c:forEach>
	                                <div class="filter-label-item mt-10-xs btn-filter-reset">
	                                    <h2><liferay-ui:message key='reset-ricerca'/></h2><span class="icomoon-close-white"></span>
	                                </div>
	                        
	                                <span class="filtro-numbers">
	                                    <span class="bold"><%=dimensioneLista%></span>
	                                     <liferay-ui:message key='richieste-trovate-ricerca'/>
	                                </span>
	                            </div>
	                        </div>
	                   	</c:when>
	                   	<c:otherwise>
	                   		<div>&nbsp;</div>
	                   	</c:otherwise>
                   </c:choose>
                        
                        <!-- radio to order results -->
                        <div class="ama-row">
                            <div class="ama-col-md-12 ama-col-xs-12">
                                <div class="form-request out-of-form mb-10-xs mt-20-xs mb-0-sm mt-0-sm">

                                    <label for="dotaz_inf" class="label-form pb-10-xs group-label-inline-sm ml-20-xs"><liferay-ui:message key='ordine-richieste-ricerca'/>:</label>
                                
                                    <div class="box-radio-custom pb-10-xs ml-20-xs">
                                        <input <%=((StringPool.BLANK).equalsIgnoreCase(order) ||("cognome").equalsIgnoreCase(order)) ? "checked" : "" %> id="<portlet:namespace/>orderCognome"
                                        name="<portlet:namespace/>order" 
                                        value="cognome" type="radio"
                                            class="radio-custom-dark"
                                            onchange="submitForm(this.name)" />
                                        <label for="<portlet:namespace/>orderCognome" class="custom-label">
                                            <span><liferay-ui:message key='cognome-nome-ordine-per-tabella-risultati-ricerca'/></span>
                                        </label>
                                    </div>
                                
                                    <div class="box-radio-custom pb-10-xs ml-20-xs">
                                        <input  <%=("punteggio").equalsIgnoreCase(order) ? "checked" : "" %> id="<portlet:namespace/>orderPunteggio" 
                                        name="<portlet:namespace/>order"
                                         value="punteggio" type="radio" class="radio-custom-dark"
                                          onchange="submitForm(this.name)">
                                        <label for="<portlet:namespace/>orderPunteggio" class="custom-label">
                                            <span><liferay-ui:message key='label-punteggio'/></span>
                                        </label>
                                    </div>
                                    <div class="box-radio-custom pb-10-xs ml-20-xs">
                                        <input <%=("priorita").equalsIgnoreCase(order) ? "checked" : "" %> id="<portlet:namespace/>orderPriorita" 
                                        name="<portlet:namespace/>order"
                                         value="priorita" type="radio" class="radio-custom-dark"
                                          onchange="submitForm(this.name)">
                                        <label for="<portlet:namespace/>orderPriorita" class="custom-label">
                                            <span><liferay-ui:message key='priorita-punteggio-ordine-per-risultati-tabella-ricerca'/></span>
                                        </label>
                                    </div>

                                </div>
                                
                            </div>

                        </div>
                        <!-- list of results -->
                         <div class="ama-row">
                            <div class="ama-col-xs-12">
                            
                                <div class="lavoro-agile-risultati-wrapper">
                                    <div class="agile-table mb-20-xs mt-10-sm">


									<div class="agile-row agile-row-head">
										<span class="agile-cell agile-num">#</span>
										
										<span class="agile-cell agile-id">
                                                <liferay-ui:message key='id-risultati-tabella-ricerca'/>
                                                <a title="Codice istanza" class="tooltip-field icon-information tool-res">
                                                    <span class="icomoon-info ico-info-tooltip"></span>
                                                </a>
                                            </span>
										 <span
											class="agile-cell agile-name"><liferay-ui:message key='cognome-nome-risultati-tabella-ricerca'/></span> <span
											class="agile-cell agile-dip"><liferay-ui:message key='dipartimento-risultati-tabella-ricerca'/>.<a
											title="Dipartimento" class="tooltip-field icon-information tool-res">
												<span class="icomoon-info ico-info-tooltip"></span>
										</a>
										</span> <span class="agile-cell agile-dir"><liferay-ui:message key='direzione-risultati-tabella-ricerca'/>.<a
											title="Direzione" class="tooltip-field icon-information tool-res">
												<span class="icomoon-info ico-info-tooltip"></span>
										</a>
										</span> <span class="agile-cell agile-pr"><liferay-ui:message key='priorita-risultati-tabella-ricerca'/>.<a
											title="Priorit&agrave;"
											class="tooltip-field icon-information tool-res"> <span
												class="icomoon-info ico-info-tooltip"></span>
										</a>
										</span> <span class="agile-cell agile-score"> <liferay-ui:message key='punteggio-risultati-tabella-ricerca'/>.<a
											title="Punteggio" class="tooltip-field icon-information tool-res">
												<span class="icomoon-info ico-info-tooltip"></span>
										</a>
										</span>

									</div>

									<c:forEach items="<%=lista_richieste%>" var="richiesta">

										<%
											RisultatoRicerca richiesta = (RisultatoRicerca) pageContext.getAttribute("richiesta");
											String nome = StringUtil.upperCaseFirstLetter(richiesta.getNome().toLowerCase());
											String cognome = StringUtil.upperCaseFirstLetter(richiesta.getCognome().toLowerCase());
										%> 
										
										<portlet:actionURL name="vaiADettaglio" var="vaiADettaglio">
											<portlet:param name="richiestaId"
												value="${richiesta.getId()}" />
												<portlet:param name="daListaRicerca"
												value="daListaRicerca" />
										</portlet:actionURL>
										
										<a href="<%=vaiADettaglio%>" class="agile-row agile-row-body"> <span
											class="agile-cell agile-num">${richiesta.getProgressivo()}</span>
											<span class="agile-cell agile-id">${richiesta.getId()}</span>
											<span class="agile-cell agile-name"><%=cognome%> <%=nome%></span> 
											<span class="agile-cell agile-dip">${richiesta.getDip()}</span>
											<span class="agile-cell agile-dir">${richiesta.getDir()}</span>

											<c:choose>
												<c:when test="${!richiesta.isPriorita()}">
													<span class="agile-cell agile-pr "></span>
												</c:when>
												<c:otherwise>
													<span class="agile-cell agile-pr agile-pr-true"></span>
												</c:otherwise>
											</c:choose> <span class="agile-cell agile-score">${richiesta.getPunteggio()}</span>
										</a>

									</c:forEach>
								</div>
                                </div>
                            </div>

						<%
						
							Integer pageCurrent = 1;
						if(request.getAttribute("page")!=null && ((Integer) request.getAttribute("page")!=0))
							pageCurrent = (Integer) request.getAttribute("page");
						
							Integer pageNumber = (Integer) request.getAttribute("numPage");
							
							
							
							String back_btn = pageCurrent == 1 ? "disabled" : "";
							String forward_btn = pageCurrent.equals(pageNumber) ? "disabled" : "";
						%>
						<portlet:actionURL var="paginaRes" name="paginaRes">
						</portlet:actionURL>
						<c:if test="<%=pageNumber > 1%>">


							<form style="display: none" id="<portlet:namespace/>formPagina"
								action="<%=paginaRes%>" method="POST"
								enctype="multipart/form-data">
								    <input type="hidden" name="<portlet:namespace/>numpage"
									id="<portlet:namespace/>numpageRichiesteRes"> 
									<input type="hidden"
									name="<portlet:namespace/>size" value="<%=dimensioneLista%>"
									id="<portlet:namespace/>sizeRichieste"> 
							</form>

							<div class="ama-col-xs-12 text-align-center">
								<div data-totpage-mobile=""
									class="paginator-wrap-dark paginator-wrap">

									<div class="btn-back-arrow <%=back_btn%>">
										<a href="javascript:showPagina(event, <%=pageCurrent - 1%>,'Res')"><em
											class="icomoon-arrow"></em></a>
									</div>
									<ul class="pagination-numbers">

										<%
											for (int i = 1; i < pageNumber +1; i++) {
												
													String currentPageClass = StringPool.BLANK;
													if (((Integer)i).equals(pageCurrent)){
														currentPageClass = "current-page";
													}
										%>


										<li id="pageClick<%=i%>" class="<%=currentPageClass%>">
										<a href="javascript:showPagina(event,<%=i%>,'Res')" ><%=i%></a></li>

										<%
											}
										%>


									</ul>
									<div class="btn-forward-arrow <%=forward_btn%>">
										<a href="javascript:showPagina(event,<%=pageCurrent + 1%>,'Res')" >
											<em class="icomoon-arrow"></em>
										</a>
									</div>
								</div>
							</div>

						</c:if>



						<c:if test="<%=!"".equals(jsonArrayExcelString) && lista_richieste != null && !lista_richieste.isEmpty()%>">
								<form action="<%=resourceURL%>" method="post" id="<portlet:namespace/>excelForm" enctype="multipart/form-data"> 
								 	<input type="hidden" name="<portlet:namespace/>jsonExcel" id="json" value="<%=HtmlUtil.escape(jsonArrayExcelString)%>">
	                     		</form> 
								<div class="ama-col-xs-12 text-center mt-20-sm mb-20-xs">
                                	<button class="button button-primary" id="<portlet:namespace/>downloadexcel"><liferay-ui:message key='file-excel-scaricabile'/></button>
                            	</div>
							</c:if>
                            
                        </div>
                            
                    </div>
                </div>
            </div>
        </div>
    </div>
    
     <!-- SPINNER -->    
<div id="idSpinner" class="spinner-wrap">
   <div class="spinner">
       <div class="bounce1"></div> <div class="bounce2"></div> <div class="bounce3"></div>
   </div>
</div>
    
<script type="text/javascript">

var dipartimento = "SCEGLI DALL'ELENCO";
var direzione = "SCEGLI DALL'ELENCO";
var ufficio = "SCEGLI DALL'ELENCO";

getStruttureInterne('847','<portlet:namespace/>dipartimento');
hideSpinner();

function hideSpinner(){ $('#idSpinner').removeClass('visible'); }
function showSpinner(){ $('#idSpinner').addClass('visible'); }

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
				       	    			if( dipartimento!= null && dipartimento!="SCEGLI DALL'ELENCO" && dipartimento!='' )
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
    	structureOption.text = "SCEGLI DALL'ELENCO";
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
							$('option[value="'+selectedVal+'"]').text( (obj[i].acronimo).value );
		
							if( direzione!= null && direzione!="SCEGLI DALL'ELENCO" && direzione!='' )
				    			if( (obj[i].acronimo).value == direzione ){
				    				$('#<portlet:namespace/>direzione').val( selectedVal );
				    				getStruttureInterne ( selectedVal, '<portlet:namespace/>ufficio' );
				    			}
							if( ufficio!= null && ufficio!="SCEGLI DALL'ELENCO" && ufficio!='' )
				    			if( (obj[i].descrizione).value == ufficio )
				    				$('#<portlet:namespace/>ufficio').val( selectedVal );	
						}
		   		    	if( flagSpinner )
			    			hideSpinner();
					  });
}


$('#<portlet:namespace/>btnNuovaRichiestaRicerca').click("on", function() {
	$('#<portlet:namespace/>nuovaRichiestaFormRicerca').submit();
});

function submitForm(x) {
	
	var jsonFiltri = '<%=jsonString%>';
	var codiceIstanza = $('#<portlet:namespace/>codiceIstanza').val();
	var cognome = ($('#<portlet:namespace/>cognome').val()).replace("'", "&#39;");
	var dipartimento = $('#<portlet:namespace/>dipartimento').val();
	var direzione = $('#<portlet:namespace/>direzione').val();
	var ufficio = $('#<portlet:namespace/>ufficio').val();
			
		 	if(x == '<portlet:namespace/>btnRicerca'){
		 		
		 		var checkFieldParsley = false;
		 	
		 		$(".checkField").each(function() {
	 				if ($(this).val()!="" && $(this).val()!= null && $(this).val()!="0"){
	 					checkFieldParsley = true;
	 					return false;
	 				}
	 				
	 			});
		 		
		 		if(checkFieldParsley){
		 			$('#<portlet:namespace/>inputParsley').val("ok");
		 		}else {
		 			$('#<portlet:namespace/>inputParsley').val("");
		 		}
		 		
		 		$('#<portlet:namespace/>inputParsley').parsley().validate();	
		 		$('#<portlet:namespace/>codiceIstanza').parsley().validate();	
		 		$('#<portlet:namespace/>cognome').parsley().validate();	
		 		
			 		if($('#<portlet:namespace/>inputParsley').parsley().isValid() && $('#<portlet:namespace/>codiceIstanza').parsley().isValid() && $('#<portlet:namespace/>cognome').parsley().isValid()){
			 		
			 		$("input[name=<portlet:namespace/>order]").each(function() {
						
			 			if ((this.id) == '<portlet:namespace/>orderCognome') {
			 					$(this).prop("checked", true);
			 				} else {
			 					$(this).prop("checked", false);
			 				}
			 			});
			 		
			 		jsonFiltri = '';
			 		
			 		$("input[name=<portlet:namespace/>order]").each(function() {
						if ($(this).is(':checked')) {
							$('#<portlet:namespace/>radioOrder').val(this.value);
						}
					});
			 		
			 		if (jsonFiltri != null && jsonFiltri != "" && jsonFiltri!="null") {
						$("#<portlet:namespace/>jsonFiltri")
								.val((jsonFiltri));
					} else {
				
						jsonObj = {
							codiceIstanza : codiceIstanza,
							cognome : cognome,
							dipartimento : dipartimento,
							direzione : direzione,
							ufficio : ufficio
						};
						$('#<portlet:namespace/>jsonFiltri')
						.val(JSON.stringify(jsonObj));
					}
				
					$('#<portlet:namespace/>searchFm').submit();
			 		
			 		}
			 		
		 		} else {
		
				$("input[name=<portlet:namespace/>order]").each(function() {
					if ($(this).is(':checked')) {
						$('#<portlet:namespace/>radioOrder').val(this.value);
					}
				});
		
			
				if (jsonFiltri != null && jsonFiltri != "" && jsonFiltri!="null") {
						$("#<portlet:namespace/>jsonFiltri")
								.val((jsonFiltri));
					} else {
				
						jsonObj = {
							codiceIstanza : codiceIstanza,
							cognome : cognome,
							dipartimento : dipartimento,
							direzione : direzione,
							ufficio : ufficio
						};
						$('#<portlet:namespace/>jsonFiltri')
						.val(JSON.stringify(jsonObj));
					}
				
					$('#<portlet:namespace/>searchFm').submit();
	
		 		}
	
}


	$('.icomoon-close-white').on('click', function() {
		$('#<portlet:namespace/>refreshPageRicerca').submit();
	});

	function resetForm(event){
		//$('#<portlet:namespace/>refreshPageRicerca').submit();
		$('#<portlet:namespace/>searchFm')[0].reset();
	}
	
	$('#<portlet:namespace/>downloadexcel').click("on",function(){
		$('#<portlet:namespace/>excelForm').submit();
	});
	
	function showPagina(event,id,tagId) {
		$('#<portlet:namespace/>numpageRichieste'+tagId).val(id);
		console.log($('#<portlet:namespace/>numpageRichieste'+tagId).val());
		$('#<portlet:namespace/>formPagina').submit();
		}
	
</script>