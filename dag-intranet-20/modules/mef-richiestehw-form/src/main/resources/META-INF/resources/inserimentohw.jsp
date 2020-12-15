 <%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mef.richiestehw.beans.RichiestaHwBean"%>
<%@page import="service.intranet.mef.model.TipologiaComputer"%> 
<%@page import="service.intranet.mef.model.TipologiaStampanti"%> 
<%@page import="service.intranet.mef.model.TipologiaDispositivi"%> 
<%@page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="mef.richiestehw.beans.Richiedente"%>
 <%
 
 Richiedente richiedente=new Richiedente();
 if(request.getAttribute("richiedente")!=null)
		richiedente = (Richiedente)request.getAttribute("richiedente");
 
 String json = (String)request.getAttribute("json");

 

List<RichiestaHwBean> listStampanti = (List<RichiestaHwBean>)  request.getAttribute("listStampanti");
List<RichiestaHwBean> listAltrePeriferiche = (List<RichiestaHwBean>)  request.getAttribute("listAltrePeriferiche");
List<RichiestaHwBean> listSoftware = (List<RichiestaHwBean>)  request.getAttribute("listSoftware");
List<RichiestaHwBean> listComputer = (List<RichiestaHwBean>)  request.getAttribute("listComputer");

int countComputer=0; //conta il numero dei computer richiesti
int countStampante=0;
int countPeriferiche=0; //conta il numero dei stampante richiesti
int countSoftware=0;
%>

 <c:set value="<%=richiedente%>" var="richiedente"></c:set>
 <c:set value="<%=listComputer%>" var="listComputer"></c:set>
 <c:set value="<%=listStampanti%>" var="listStampanti"></c:set>
 <c:set value="<%=listAltrePeriferiche%>" var="listAltrePeriferiche"></c:set>
 <c:set value="<%=listSoftware%>" var="listSoftware"></c:set>
 

 
 <portlet:actionURL name="riepilogoDati" var="riepilogoDati"></portlet:actionURL>
  <div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=formTitle%></h2>
                         <p class="subtitle dot-point dot-200"><%=formSubtitle%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>
      <div id="TitoloContainer" class="ama-container-fluid TitoloContainer">
           <div class="itemCountDemo1">
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="label-richestehw-dati-richiedente"/></h2>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                <form data-parsley-validate="" action="<%=riepilogoDati%>" method="post" id="formHardware" enctype="multipart/form-data">
                    <div class="ama-col-xs-12 mb-25-xs">
                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-ufficio-richiedente"/>*</label>
                        <c:if test="${richiedente.getUfficioRichiedente() == null}">
                        <input type="text" name="<portlet:namespace/>ufficioRichiedente" id="IntUfficioRichiedente" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-ufficio-richiedente"/>" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                        </c:if>
                        <c:if test="${richiedente.getUfficioRichiedente() != null}">
                        <input type="text" name="<portlet:namespace/>ufficioRichiedente" id="IntUfficioRichiedente" class="input-custom-light" value="${richiedente.getUfficioRichiedente()}" placeholder="<liferay-ui:message key="label-richestehw-ufficio-richiedente"/>" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                        </c:if>
                    </div>
                    <div class="ama-col-xs-12 mb-25-xs">
                        <div class="ama-row">
                            <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-nome"/>*</label>
                                 <c:if test="${richiedente.getNome() == null}">
                                <input type="text" name="<portlet:namespace/>nome" id="IntNome" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-dati-nome"/>" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                               </c:if>
                                <c:if test="${richiedente.getNome() != null}">
                             <input type="text" name="<portlet:namespace/>nome" id="IntNome" class="input-custom-light" value="${richiedente.getNome()}" placeholder="<liferay-ui:message key="label-richestehw-dati-nome"/>" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                            </c:if>
                            </div>
                            <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-cognome"/>*</label>
                                 <c:if test="${richiedente.getCognome() == null}">
                                <input type="text"  name="<portlet:namespace/>cognome" id="IntCognome" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-dati-cognome"/>" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                            </c:if>
                              <c:if test="${richiedente.getCognome() != null}">
                              <input type="text"  name="<portlet:namespace/>cognome" id="IntCognome" class="input-custom-light" value="${richiedente.getCognome()}" placeholder="<liferay-ui:message key="label-richestehw-dati-cognome"/>" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                          </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="ama-col-xs-12 mb-25-xs">
                        <div class="ama-row">
                            <div class="ama-col-sm-4 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-ubicazione"/></label>
                                <c:if test="${richiedente.getUbicazione() == null}">
                                <input type="text" name="<portlet:namespace/>ubicazione" id="IntUbicazioneAttuale" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-dati-ubicazione"/>">
                                </c:if>
                                <c:if test="${richiedente.getUbicazione() != null}">
                                <input type="text" name="<portlet:namespace/>ubicazione" id="IntUbicazioneAttuale" class="input-custom-light" value="${richiedente.getUbicazione()}" placeholder="<liferay-ui:message key="label-richestehw-dati-ubicazione"/>">
                                
                                </c:if>
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-palazzina"/></label>
                                <c:if test="${richiedente.getPalazzina() == null}">
                                <input type="text" name="<portlet:namespace/>palazzina" id="IntPalazzina" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-dati-palazzina"/>">
                                 </c:if>
                                 <c:if test="${richiedente.getPalazzina() != null}">
                                 <input type="text" name="<portlet:namespace/>palazzina" id="IntPalazzina" class="input-custom-light" value="${richiedente.getPalazzina()}" placeholder="<liferay-ui:message key="label-richestehw-dati-palazzina"/>">
                                </c:if>
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-piano"/></label>
                                 <c:if test="${richiedente.getPiano() == null}">
                                <input type="text" name="<portlet:namespace/>piano" id="IntPiano" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-dati-piano"/>">
                                </c:if>
                                  <c:if test="${richiedente.getPiano() != null}">
                                <input type="text" name="<portlet:namespace/>piano" id="IntPiano" class="input-custom-light" value="${richiedente.getPiano()}" placeholder="<liferay-ui:message key="label-richestehw-dati-piano"/>">
                                  
                                  </c:if>
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-scala"/></label>
                                 <c:if test="${richiedente.getScala() == null}">
                                  <input type="text" name="<portlet:namespace/>scala" id="IntScala" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-dati-scala"/>">
                                 </c:if>
                                  <c:if test="${richiedente.getScala() != null}">
                                   <input type="text" name="<portlet:namespace/>scala" id="IntScala" class="input-custom-light" value="${richiedente.getScala()}" placeholder="<liferay-ui:message key="label-richestehw-dati-scala"/>">
                                  </c:if>
                            
                            </div>
                            <div class="ama-col-sm-2 ama-col-xs-6">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-stanza"/></label>
                                <c:if test="${richiedente.getStanza() == null}">
                                <input type="text" name="<portlet:namespace/>stanza" id="IntStanza" class="input-custom-light" placeholder="<liferay-ui:message key="label-richestehw-dati-stanza"/>">
                           </c:if>
                           <c:if test="${richiedente.getStanza() != null}">
                                <input type="text" name="<portlet:namespace/>stanza" id="IntStanza" class="input-custom-light" value="${richiedente.getStanza()}" placeholder="<liferay-ui:message key="label-richestehw-dati-stanza"/>">
                           
                           </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="ama-col-xs-12">
                        <div class="ama-row">
                            <div class="ama-col-sm-6 ama-col--xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-telefono"/></label>
                                   <c:if test="${richiedente.getTelefono() == null}">
                                     <input type="text" 
                                   		data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                     name="<portlet:namespace/>telefono" id="IntTelephone" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="label-richestehw-dati-telefono"/>">
                                   </c:if>
                                   <c:if test="${richiedente.getTelefono() != null}">
                                     <input type="text" 
                                   		data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                     name="<portlet:namespace/>telefono" id="IntTelephone" class="input-custom-light data-parsley-validated" value="${richiedente.getTelefono()}" placeholder="<liferay-ui:message key="label-richestehw-dati-telefono"/>">
                                   </c:if>
                            
                            </div>
                            <div class="ama-col-sm-6 ama-col-xs-12">
                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-dati-email-dirigente"/>*</label>
                              <c:if test="${richiedente.getEmailDirigente() == null}">
                                <input type="text" 
                                data-parsley-required="true"
										data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
										data-parsley-type="email"
										data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"        
                                name="<portlet:namespace/>emailDirigente" id="IntEmailDirigente" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="label-richestehw-dati-email-dirigente"/>">
                            </c:if>
                              
                               <c:if test="${richiedente.getEmailDirigente() != null}">
                                <input type="text" 
                                data-parsley-required="true"
										data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
										data-parsley-type="email"
										data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                                name="<portlet:namespace/>emailDirigente" id="IntEmailDirigente" class="input-custom-light data-parsley-validated" value="${richiedente.getEmailDirigente()}" placeholder="<liferay-ui:message key="label-richestehw-dati-email-dirigente"/>">
                            </c:if>
                            </div>
                        </div>
                    </div>
                          <input type="hidden" id="listHardwareRichiesta" name="<portlet:namespace/>saverichiesta">
                    
                </form>
            </div>                
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="label-richestehw-richiesta"/></h2>
                    </div>
                </div>
            </div>
            
                <div class="ama-row servizi-richiesta-wrapper">
                    <div class="ama-col-xs-12 mb-40-xs button-wrapper">
                        <div class="ama-row">
                        <div class="container-button">
                            <button class="servizio-richiesta-button"  id="showComputers" data-toggle="collapse" data-target="#demo1">
                                <div class="icon-button">
                                    <c:if test="${itemsComputers == null || itemsComputers == 0}">
                                    	<span class="icon-text icomoon-computer"></span>
                                    </c:if>
                                    <c:if test="${itemsComputers != null && itemsComputers != 0 }">
                                    	<span class="icon-text icomoon-computer"><span id="counter-computer" class="counter-item">${itemsComputers}</span></span>
                                    </c:if>
                                </div>
                                <div class="text-button">
                                    <span class="text"><liferay-ui:message key="label-richestehw-richiesta-pc"/></span>
                                </div>
                            </button>
                        </div>
                       
                        <div class="container-button">
                            <button id="showStampanti"  class="servizio-richiesta-button" data-toggle="collapse" data-target="#demo2">
                                <div class="icon-button">
                                   <c:if test="${itemsStampanti == null || itemsStampanti == 0}">
                                    	<span class="icon-text icomoon-print2"></span>
                                    </c:if>
                                     <c:if test="${itemsStampanti != null && itemsStampanti !=0}">
                                    	<span class="icon-text icomoon-print2"><span id="counter-stampante" class="counter-item">${itemsStampanti}</span></span>
                                    </c:if>
                                </div>
                                <div class="text-button">
                                    <span class="text"><liferay-ui:message key="label-richestehw-richiesta-stampanti"/></span>
                                </div>
                            </button>
                        </div>
                       
                        <div class="container-button">
                            <button id="showPeriferiche" class="servizio-richiesta-button" data-toggle="collapse" data-target="#demo3">
                                <div class="icon-button">
                                     <c:if test="${itemsAltrePeriferiche == null || itemsAltrePeriferiche == 0}">
                                    	<span class="icon-text icomoon-server"></span>
                                    </c:if>
                                    <c:if test="${itemsAltrePeriferiche != null && itemsAltrePeriferiche !=0}">
                                    	<span class="icon-text icomoon-server"><span id="counter-periferiche" class="counter-item">${itemsAltrePeriferiche}</span></span>
                                    </c:if>
                                </div>
                                <div class="text-button">
                                    <span class="text"><liferay-ui:message key="label-richestehw-richiesta-periferiche"/></span>
                                </div>
                            </button>
                        </div>
                       
                        <div class="container-button">
                            <button id="showSoftware" class="servizio-richiesta-button" data-toggle="collapse" data-target="#demo4">
                                <div class="icon-button">
                                     <c:if test="${itemsSoftware == null || itemsSoftware == 0}">
                                    	<span class="icon-text icomoon-software"></span>
                                    </c:if>
                                     <c:if test="${itemsSoftware != null && itemsSoftware !=0}">
                                    	<span class="icon-text icomoon-software"><span id="counter-software" class="counter-item">${itemsSoftware}</span></span>
                                    </c:if>	
                                </div>
                                <div class="text-button">
                                    <span class="text"><liferay-ui:message key="label-richestehw-richiesta-software"/></span>
                                </div>
                            </button>
                        </div>
                        </div>
                    
                    </div>
            
                        <div class="ama-col-xs-12 mb-30-xs Tipolo" id="myrow">
                        
                            <div id="demo1" class="ama-row collapse">
                             <div id="designComputer">
                           
                           <c:if test="${!empty listComputer}">
   
                           <c:forEach items="${listComputer}" var="listpc">
						        <% countComputer++; %>                
						 <div id="computer<%=countComputer%>" class="designComputerClass richiesta-item clearfix mt-30-xs">
<%--                             <c:set value="${listComputer.getTipologia()}" var="TipologiaComputer"></c:set> --%>
									<form>
                                    <div class="ama-col-md-12 ama-col-xs-12">
                                    <div class="wrap-content-delete">
                                        <span class="number"><liferay-ui:message key="label-numero-computer"/> <%=countComputer%></span>
                                        <div class="position-button">
                                            <button href="#" onclick="removeItemComputer('#computer<%=countComputer%>')" type="button" class="mt-0-xs button button-primary removebtn" >
                                                <span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
                                        </div>
                                    </div>
                                     </div>
                                   
                                   
                                   <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
                                       
                                        <select id="argument" class="option-select data-parsley-validated SelectComputer" name="SelectComputer"
                                        	data-parsley-required="true"
											data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">

											<c:forEach items="${listaSelectComputer}" var="computerItem">
												<c:if
													test="${computerItem.getDescrizione() == listpc.getTipologia()}">
													<option value="${computerItem.getDescrizione()}" selected="true">${computerItem.getDescrizione()}</option>
												</c:if>
												<c:if
													test="${computerItem.getDescrizione() != listpc.getTipologia()}">
													<option value="${computerItem.getDescrizione()}">${computerItem.getDescrizione()}</option>
												</c:if>
											</c:forEach>


										</select>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <div class="ama-row">
                                            <div class="ama-col-xs-12">
                                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
                                               
                                                <input type="number"  data-parsley-required="true" 
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" min="1"  class="input-custom-light input-quant InputQuantitiComputer" value="${listpc.getQuantita()}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
                                        <input type="text" class="input-custom-light InputNoteComputer" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>" value="${listpc.getNote()}">
                                    </div>
                                    </form> 
                                    </div>

                                  </c:forEach>
                             
                                  </c:if>


                                
                                    </div>

                                    <div class="ama-col-xs-12">
                                        <button class="button button-primary button-servizi mt-40-xs button-add" id="button-demo1"><span><liferay-ui:message key="label-richestehw-option-addpc"/></span><span class="icon-btn icomoon-plus"></span></button>
                                    </div>  
                               
                            </div>
                            <div id="demo2" class="ama-row collapse">
                            <div id="designStampanti">
                               
                               <c:if test="${!empty listStampanti}">
                            
                           <c:forEach items="${listStampanti}" var="listStamp">
  								<% countStampante++; %>
							<div id="stampante<%=countStampante%>" class="designStampanteClass richiesta-item clearfix mt-30-xs">
							<form>
								<div class="ama-col-md-12 ama-col-xs-12">
								<div class="wrap-content-delete">
									<span class="number"><liferay-ui:message key="label-numero-stampante"/> <%=countStampante%></span>
									<div class="position-button">
										<button href="#" onclick="removeItemStampante('#stampante<%=countStampante%>')" type="button" class="mt-0-xs button button-primary removebtn">
											<span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
								</div>
							</div>
							 </div>
                         
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
                                        <select id="argument" class="option-select data-parsley-validated SelectStampanti"
                                        	data-parsley-required="true"
											data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                                            
                                              <c:forEach items="${listaSelectStampanti}" var="stampanteItem">
										  		<c:if test="${stampanteItem.getDescrizione() == listStamp.getTipologia()}">
										  		
										  		<option value="${stampanteItem.getDescrizione()}" selected = "true">${stampanteItem.getDescrizione()}</option>
									   	</c:if>
									   			<c:if test="${stampanteItem.getDescrizione() != listStamp.getTipologia()}">
										  		
										  		<option value="${stampanteItem.getDescrizione()}">${stampanteItem.getDescrizione()}</option>
									   	</c:if>
									   		  </c:forEach>
											
                                        </select>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <div class="ama-row">
                                            <div class="ama-col-xs-12">
                                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
                                                <input type="number"     data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>"
										 class="input-custom-light input-quant InputQuantitiStampante" min="1" value="${listStamp.getQuantita()}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
                                        <input type="text" class="input-custom-light InputNoteStampante" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>" value="${listStamp.getNote()}">
                                    </div>
                                    </form> 
                                   </div>
                                    </c:forEach>
                                    
                                    </c:if>
                                    
                                   
               
                                    </div>
                                    
                                    
                                    
                                    <div class="ama-col-xs-12">
                                        <button class="button button-primary button-servizi mt-40-xs button-add"  id="button-demo2"><span><liferay-ui:message key="label-richestehw-option-addstampante"/></span><span class="icon-btn icomoon-plus"></span></button>
                                    </div>  
                                
                            </div>
                            <div id="demo3" class="ama-row collapse">
                            <div id="designHardware">
                             
                               <c:if test="${!empty listAltrePeriferiche}">
                           
                           <c:forEach items="${listAltrePeriferiche}" var="listAtrePeri">
						   
							<%countPeriferiche++;%>
						   
                <div id="periferica<%=countPeriferiche%>" class="designHardwareClass richiesta-item clearfix mt-30-xs">
                         <form>
						   	<div class="ama-col-md-12 ama-col-xs-12">
							<div class="wrap-content-delete">
								<span class="number"><liferay-ui:message key="label-numero-periferica"/> <%=countPeriferiche%></span>
								<div class="position-button">
									<button href="#" onclick="removeItemPeriferica('#periferica<%=countPeriferiche%>')" type="button" class="mt-0-xs button button-primary removebtn">
										<span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
								</div>
							</div>
							 </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
                                        <select id="argument" class="option-select data-parsley-validated SelectHardware"
                                        	data-parsley-required="true"
											data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                                       
                                                <c:forEach items="${listaSelectDispositivi}" var="dispositivoItem">
										  		<c:if test="${dispositivoItem.getDescrizione() ==  listAtrePeri.getTipologia()}">
										  		<option value="${dispositivoItem.getDescrizione()}" selected="true">${dispositivoItem.getDescrizione()}</option>
									   		  </c:if>
									   		  <c:if test="${dispositivoItem.getDescrizione() !=  listAtrePeri.getTipologia()}">
										  		<option value="${dispositivoItem.getDescrizione()}">${dispositivoItem.getDescrizione()}</option>
									   		  </c:if>
									   		  </c:forEach>
											
                                        </select>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <div class="ama-row">
                                            <div class="ama-col-xs-12">
                                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
                                                <input type="number"     data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" min="1"   class="input-custom-light input-quant InputQuantitiHardware" value="${listAtrePeri.getQuantita()}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
                                        <input type="text" class="input-custom-light InputNoteHardware" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>" value="${listAtrePeri.getNote()}">
                                  
                                    </div>
                               </form>
                                     </div>
                                      </c:forEach> 
                                     
                                       </c:if>
                                       
                                    
                                     </div>
                                    <div class="ama-col-xs-12">
                                        <button class="button button-primary button-servizi mt-40-xs button-add" id="button-demo3"><span><liferay-ui:message key="label-richestehw-option-addperiferica"/></span><span class="icon-btn icomoon-plus"></span></button>
                                    </div>  
                             
                            </div>
                            <div id="demo4" class="ama-row collapse">
                                <div id="designSoftware">
                              
                               <c:if test="${!empty listSoftware}">
                               
                           <c:forEach items="${listSoftware}" var="listSoft">

  								<%countSoftware++;%>
                           <div id="software<%=countSoftware%>" class="designSoftwareClass richiesta-item clearfix mt-30-xs">
                           <form>
						   	<div class="ama-col-md-12 ama-col-xs-12">
							<div class="wrap-content-delete">
								<span class="number"><liferay-ui:message key="label-numero-software"/> <%=countSoftware%></span>
								<div class="position-button">
									<button href="#" onclick="removeItemSoftware('#software<%=countSoftware%>')" type="button" class="mt-0-xs button button-primary removebtn">
										<span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
								</div>
							</div>
							 </div>
						   
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
                                     <input type="text" class="input-custom-light data-parsley-validated input-quant SelectSoftware"
                                     data-parsley-required="true"
									 data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>"
                                      value="${listSoft.getTipologia()}">
                                          </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <div class="ama-row">
                                            <div class="ama-col-xs-12">
                                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
                                                <input type="number"     data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" min="1"  class="input-custom-light input-quant InputQuantitiSoftware" value="${listSoft.getQuantita()}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
                                        <input type="text" class="input-custom-light InputNoteSoftware" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>" value="${listSoft.getNote()}">
                                      </div>
                                      </form>
                                     </div>
                                      </c:forEach>
                                      </c:if>
                                              
                                </div>
                                    <div class="ama-col-xs-12">
                                        <button class="button button-primary button-servizi mt-40-xs button-add" id="button-demo4"><span><liferay-ui:message key="label-richestehw-option-addsoftware"/></span><span class="icon-btn icomoon-plus"></span></button>
                                    </div>  
                            
                            </div>
                         
                        </div>
            <form id="validateParsleyCustomForm" data-parsley-validate="">
				<input type="hidden" 
					class="data-parsley-validated" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key='error-richieste-hw-richiesta'/>" >
			</form>	
                    
                        <div class="ama-col-xs-12 text-center mb-30-xs">
                            <button type="button" class="button button-primary" id="prosegui"><liferay-ui:message key="label-richestehw-option-prosegui"/></button>
                        </div>
             
                </div>
                </div>    
     </div>
 
	 <div id="designComputerNone" style="display:none">
	<form>
	 <div class="ama-col-md-12 ama-col-xs-12">
                                    <div class="wrap-content-delete">
                                        <span class="number">1</span>
                                        <div class="position-button">
                                            <button href="#" type="button" class="mt-0-xs button button-primary removebtn">
                                                <span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
                                        </div>
                                    </div>
                                     </div>
                                  <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
                                       
                                        <select id="argument" class="option-select data-parsley-validated SelectComputer" name="SelectComputer"
                                        	data-parsley-required="true"
											data-parsley-error-message='<liferay-ui:message key="error-mandatory"/>'>
                                           
                                            <option value="" hidden=""><liferay-ui:message key="label-richestehw-richiesta-tipologiapc"/></option>

 									<c:forEach items="${listaSelectComputer}" var="computerItem"> 

 										<option value="${computerItem.getDescrizione()}">${computerItem.getDescrizione()}</option> 
 									</c:forEach> 
						
                                        </select> 
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <div class="ama-row">
                                            <div class="ama-col-xs-12">
                                                <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
                                               
                                                <input type="number"     data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" min="1"  class="input-custom-light input-quant InputQuantitiComputer" placeholder="0">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="ama-col-sm-4 ama-col-xs-12">
                                        <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
                                        <input type="text" class="input-custom-light InputNoteComputer" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>" >
                                    </div> 
	 </form>
	 </div>	 
	  <div id="designStampanteNone" style="display:none">
	   <form>
		   <div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number">1</span>
				<div class="position-button">
					<button href="#" type="button" class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
				</div>
			</div>
			 </div>
		<div class="ama-col-sm-4 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
			<select id="argument" class="option-select data-parsley-validated SelectStampanti"
				data-parsley-required="true"
				data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
				<option value="" hidden=""><liferay-ui:message key="label-richestehw-richiesta-tipologiastampante"/></option>
                                                <c:forEach items="${listaSelectStampanti}" var="stampanteItem"> 
 										  			<option value="${stampanteItem.getDescrizione()}">${stampanteItem.getDescrizione()}</option>  
  									   		   </c:forEach> 
			</select>
		</div>
		<div class="ama-col-sm-4 ama-col-xs-12">
			<div class="ama-row">
				<div class="ama-col-xs-12">
					<label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
					<input type="number"     data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" min="1" class="input-custom-light input-quant InputQuantitiStampante" placeholder="0">
				</div>
			</div>
		</div>
		<div class="ama-col-sm-4 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
			<input type="text" class="input-custom-light InputNoteStampante" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>">
		</div>
		</form> 
    </div>
                                   
	  <div id="designHardwareNone" style="display:none">
   <form>
		   <div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number">1</span>
				<div class="position-button">
					<button href="#" type="button" class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
				</div>
			</div>
			 </div>
		<div class="ama-col-sm-4 ama-col-xs-12">
		                   <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
                                        <select id="argument" class="option-select data-parsley-validated SelectHardware"
                                            data-parsley-required="true"
											data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                                            <option value="" hidden=""><liferay-ui:message key="label-richestehw-richiesta-tipologiahardware"/></option>
                                                 <c:forEach items="${listaSelectDispositivi}" var="dispositivoItem"> 
 										  		<option value="${dispositivoItem.getDescrizione()}">${dispositivoItem.getDescrizione()}</option> 
 									   		  </c:forEach> 
                                        </select>
		</div>
		<div class="ama-col-sm-4 ama-col-xs-12">
			<div class="ama-row">
				<div class="ama-col-xs-12">
					<label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
					<input type="number"      data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" min="1" class="input-custom-light input-quant InputQuantitiHardware"  placeholder="0">
				</div>
			</div>
		</div>
		<div class="ama-col-sm-4 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
			<input type="text" class="input-custom-light InputNoteHardware" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>" >
		</div>
		</form> 
    </div>	 


  <div id="designSoftwareNone" style="display:none">
   <form>
		   <div class="ama-col-md-12 ama-col-xs-12">
			<div class="wrap-content-delete">
				<span class="number">1</span>
				<div class="position-button">
					<button href="#" type="button" class="mt-0-xs button button-primary removebtn">
						<span class="icon icomoon-trash1"></span><liferay-ui:message key="label-richestehw-option-rimuovi"/></button>
				</div>
			</div>
			 </div>
		<div class="ama-col-sm-4 ama-col-xs-12">
		                   <label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-tipologia"/>*</label>
                                         <input type="text" class="input-custom-light data-parsley-validated input-quant SelectSoftware"
                                         data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
		</div>
		<div class="ama-col-sm-4 ama-col-xs-12">
			<div class="ama-row">
				<div class="ama-col-xs-12">
					<label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-quantita"/>*</label>
					<input type="number" data-parsley-required="true"
									     data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>"
										 min="1"  class="input-custom-light input-quant InputQuantitiSoftware" placeholder="0">
				</div>
			</div>
		</div>
		<div class="ama-col-sm-4 ama-col-xs-12">
			<label for="argument" class="label-form"><liferay-ui:message key="label-richestehw-richiesta-note"/></label>
			<input type="text" class="input-custom-light InputNoteSoftware" placeholder="<liferay-ui:message key="label-richestehw-richiesta-note-placeholder"/>" >
		</div> 
		</form>
    </div>	
	 
     <script>
	 
     

     var design;
     jsonObj = {};
     var itemComputer = {};
     var itemStampanti = {};
     var itemHardware = {};
     var itemSoftware = {};
     var array = [];
	 
	 
    
     
     
	 var designComputerNone = $("#designComputerNone").html();
	 var designStampanteNone = $("#designStampanteNone").html();
	 var designHardwareNone = $("#designHardwareNone").html();
     var designSoftwareNone = $("#designSoftwareNone").html();
	 
	 
	 
     var designComputer = $("#designComputerDiv").html();
     var designStampanti  = $("#designStampantiDiv").html();
     var designHardware = $("#designHardwareDiv").html();
     var designSoftware = $("#designSoftwareDiv").html();
     
     
     var idButtonDemo1 = "button-demo1";
     var idButtonDemo2 = "button-demo2";
     var idButtonDemo3 = "button-demo3";
     var idButtonDemo4 = "button-demo4"
    
	
	var listComputer = "${listComputer}";
	var listStampanti = "${listStampanti}";
	var listAltrePeriferiche = "${listAltrePeriferiche}";
	var listSoftware = "${listSoftware}";
	
	
	var countComputer = <%=countComputer%>;
	var countComputerId = countComputer;
	var countStampante = <%=countStampante%>;
	var countStampanteId = <%=countStampante%>;
	var countPeriferiche= <%=countPeriferiche%>;
	var countPerifericheId= <%=countPeriferiche%>;
	var countSoftware= <%=countSoftware%>;
	var countSoftwareId= <%=countSoftware%>;
	

	
          
     $("#prosegui").click("on",function(){
    	 
    	
    	 var validpc = true;
			$('div[id^="computer"]').find('select').each(function(key,value) {
				$(this).parsley().validate();
				if(!$(this).parsley().isValid()){
					$('#showComputers').attr("class","servizio-richiesta-button");
					$('#showComputers').attr("aria-expanded","true");
					$('#demo1').attr("class","ama-row collapse in");
					$('#demo1').attr("aria-expanded","true");
					validpc = false;
				}
			});
    	 $('div[id^="computer"]').find('input').each(function(key,value) {
				$(this).parsley().validate();
				if(!$(this).parsley().isValid()){
					$('#showComputers').attr("class","servizio-richiesta-button");
					$('#showComputers').attr("aria-expanded","true");
					$('#demo1').attr("class","ama-row collapse in");
					$('#demo1').attr("aria-expanded","true");
					validpc = false;
				}
			});
    	 
    	 var validprint = true;
			$('div[id^="stampante"]').find('select').each(function(key,value) {
				$(this).parsley().validate();
				if(!$(this).parsley().isValid()){
					$('#showStampanti').attr("class","servizio-richiesta-button");
					$('#showStampanti').attr("aria-expanded","true");
					$('#demo2').attr("class","ama-row collapse in");
					$('#demo2').attr("aria-expanded","true");
					validprint = false;
				}
			});
			$('div[id^="stampante"]').find('input').each(function(key,value) {
				$(this).parsley().validate();
				if(!$(this).parsley().isValid()){
					$('#showStampanti').attr("class","servizio-richiesta-button");
					$('#showStampanti').attr("aria-expanded","true");
					$('#demo2').attr("class","ama-row collapse in");
					$('#demo2').attr("aria-expanded","true");
					validprint = false;
				}
			});
			var validdisp = true;
			$('div[id^="periferica"]').find('select').each(function(key,value) {
				$(this).parsley().validate();
				if(!$(this).parsley().isValid()){
					$('#showPeriferiche').attr("class","servizio-richiesta-button");
					$('#showPeriferiche').attr("aria-expanded","true");
					$('#demo3').attr("class","ama-row collapse in");
					$('#demo3').attr("aria-expanded","true");
					validdisp = false;
				}
			});
			$('div[id^="periferica"]').find('input').each(function(key,value) {
				$(this).parsley().validate();
				if(!$(this).parsley().isValid()){
					$('#showPeriferiche').attr("class","servizio-richiesta-button");
					$('#showPeriferiche').attr("aria-expanded","true");
					$('#demo3').attr("class","ama-row collapse in");
					$('#demo3').attr("aria-expanded","true");
					validdisp = false;
				}
			});
			var validsoft = true;
			$('div[id^="software"]').find('input').each(function(key,value) {
				$(this).parsley().validate();
				if(!$(this).parsley().isValid()){
					$('#showSoftware').attr("class","servizio-richiesta-button");
					$('#showSoftware').attr("aria-expanded","true");
					$('#demo4').attr("class","ama-row collapse in");
					$('#demo4').attr("aria-expanded","true");
					validsoft = false;
				}
			});
			
			var ufficioRichiedenteInt = false;
			$("#IntUfficioRichiedente").parsley().validate();
			if($("#IntUfficioRichiedente").parsley().isValid())
				ufficioRichiedenteInt = true;
			
			var nomeInput = false;
			$("#IntNome").parsley().validate();
			if($("#IntNome").parsley().isValid())
				nomeInput = true;
			
			var cognomeInput = false;
			$("#IntCognome").parsley().validate();
			if($("#IntCognome").parsley().isValid())
				cognomeInput = true;
			
			var ubicazioneAttualeInput = false;
			$("#IntUbicazioneAttuale").parsley().validate();
			if($("#IntUbicazioneAttuale").parsley().isValid())
				ubicazioneAttualeInput = true;
		
			var palazzinaIntput = false;
			$("#IntPalazzina").parsley().validate();
			if($("#IntPalazzina").parsley().isValid())
				palazzinaIntput = true;
			
			var pianoInput = false;
			$("#IntPiano").parsley().validate();
			if($("#IntPiano").parsley().isValid())
				pianoInput = true;
			
			var scalaInput = false;
			$("#IntScala").parsley().validate();
			if($("#IntScala").parsley().isValid())
				scalaInput = true;
			
			var stanzaInput = false;
			$("#IntStanza").parsley().validate();
			if($("#IntStanza").parsley().isValid())
				stanzaInput = true;
			
			var telephoneInput = false;
			$("#IntTelephone").parsley().validate();
			if($("#IntTelephone").parsley().isValid())
				telephoneInput = true;
			
			var emailDirigenteInput = false;
			$("#IntEmailDirigente").parsley().validate();
			if($("#IntEmailDirigente").parsley().isValid())
				emailDirigenteInput = true;
			
 if(validpc && validprint && validdisp && validsoft && ufficioRichiedenteInt && nomeInput && cognomeInput && ubicazioneAttualeInput && palazzinaIntput && pianoInput && scalaInput && stanzaInput && telephoneInput && emailDirigenteInput ){
	 
			var validNumber=false;
		$(".counter-item").each(function(){
			if ($(this).text()!="")
					validNumber=true;
		});
		
		if (!validNumber)
			$("#validateParsleyCustomForm").find("input").val("");
		
		else{
			$("#validateParsleyCustomForm").find("input").val("valid");

		
	
	
	
var seleziona = "personalComputer";
    	 $("#TitoloContainer").find(".designComputerClass").each(function(key,value) {
    		 itemComputer ={
    				 seleziona : seleziona,
    				 tipologia:$(this).find(".SelectComputer")["0"].value,
				       quantita:$(this).find(".InputQuantitiComputer")["0"].value,
				       note:$(this).find(".InputNoteComputer")["0"].value};
					//$(this).find(".peshSelectComputer")["0"].value;
			array.push(itemComputer);
		
    	 });
    	 
    	 seleziona = "stampanti";
    	 $("#TitoloContainer").find(".designStampanteClass").each(function(key,value) {
    		 itemStampanti ={
    				 seleziona:seleziona,
    				 tipologia:$(this).find(".SelectStampanti")["0"].value,
				       quantita:$(this).find(".InputQuantitiStampante")["0"].value,
				       note:$(this).find(".InputNoteStampante")["0"].value};
				
			array.push(itemStampanti);
			
    	 });
    	 seleziona = "altrePeriferiche";
    	 $("#TitoloContainer").find(".designHardwareClass").each(function(key,value) {
    		 itemHardware ={
    				 seleziona:seleziona,
    				 tipologia:$(this).find(".SelectHardware")["0"].value,
				       quantita:$(this).find(".InputQuantitiHardware")["0"].value,
				       note:$(this).find(".InputNoteHardware")["0"].value};
					
					
			array.push(itemHardware);
			
    	 });
    	 seleziona = "software";
    	 $("#TitoloContainer").find(".designSoftwareClass").each(function(key,value) {
    		 itemSoftware ={
    				 seleziona:seleziona,
    				 tipologia:$(this).find(".SelectSoftware")["0"].value,
				       quantita:$(this).find(".InputQuantitiSoftware")["0"].value,
				       note:$(this).find(".InputNoteSoftware")["0"].value};
					
					
			array.push(itemSoftware);
		
    	 });
    	 
    	 
    	 
    	 
    	 var ufficioRichiedente = $("#IntUfficioRichiedente").val();
 		
 	 
 		 var nome = $("#IntNome").val();
 		
 		
 		var cognome = $("#IntCognome").val();
 		 				
 		var ubicazione = $("#IntUbicazioneAttuale").val();
 		 		
 		var palazzina = $("#IntPalazzina").val();
 		 		 		
 		var piano = $("#IntPiano").val();
 		 				
 		var scala = $("#IntScala").val();
 			
 		var stanza = $("#IntStanza").val();
 				
 		var  telefono = $("#IntTelephone").val()
 				
 		var email = $("#IntEmailDirigente").val();
 		
    	 
    	 jsonObj = {ufficioRichiedente : ufficioRichiedente,
				   nome: nome,
				   cognome : cognome,
				   ubicazione : ubicazione,
				   palazzina : palazzina,
				   piano : piano,
				   stanza : stanza,
				   teleFono : telefono,
				   email : email, 	
  	               richieste : array};
  	
    	 
    	 
  	
  	
  	$("#listHardwareRichiesta").val(JSON.stringify(jsonObj));
  	
  	$("#formHardware").submit();
 }
  $("#validateParsleyCustomForm").find("input").parsley().validate();

 }
 $('#formHardware').parsley().validate();


 
	 });
	 
	 
	 

     var htmlBadgeComputer="<span id='counter-computer' class='counter-item'></span>";
     var htmlBadgeStampanti="<span id='counter-stampante' class='counter-item'></span>";
     var htmlBadgePeriferiche="<span id='counter-periferiche' class='counter-item'></span>";
     var htmlBadgeSoftware="<span id='counter-software' class='counter-item'></span>";
     
	//add new item Computer 
	 function addNewItemComputer(){
		        if(countComputer == 0)
		        	$(".icomoon-computer").html(htmlBadgeComputer);	
				countComputer++;
				countComputerId++;				
				$("#counter-computer").html(countComputer);
				
				var htmlDesignComputer = designComputerNone;

				var divMasterComputer = document.createElement("div");
				$(divMasterComputer).attr("id","computer"+countComputerId);
				$(divMasterComputer).addClass("designComputerClass");
				$(divMasterComputer).addClass("richiesta-item clearfix mt-30-xs");
				$(divMasterComputer).append(htmlDesignComputer);
				$(divMasterComputer).find(".number").html('<liferay-ui:message key="label-numero-computer"/> '+countComputer);
		 		var count = countComputerId;
				$(divMasterComputer).find(".removebtn").each(function(){
					
					$(this).click(function (){						
						removeItemComputer("#computer"+count);
					});						
				});
				
				
				
				$("#designComputer").append(divMasterComputer);
	 
	 }
	 
	 
	 	//add new item Computer 
	 function addNewItemStampante(){
		 if(countStampante == 0)
				$(".icomoon-print2").html(htmlBadgeStampanti);	
		countStampante++;
		countStampanteId++;
		$("#counter-stampante").html(countStampante); 

		var htmlDesign = designStampanteNone;
		
		var divMaster = document.createElement("div");
		$(divMaster).attr("id","stampante"+countStampanteId);
		$(divMaster).addClass("designStampanteClass");
		$(divMaster).addClass("richiesta-item clearfix mt-30-xs");		
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-stampante"/> '+countStampante);
		var count = countStampanteId;
		$(divMaster).find(".removebtn").each(function(){
			$(this).click(function (){
				removeItemStampante("#stampante"+count);
			});						
		});
		
		$("#designStampanti").append(divMaster);
	 
	 }
	 
	 	 function addNewItemPeriferiche(){
	 		 if(countPeriferiche == 0)
					$(".icomoon-server").html(htmlBadgePeriferiche);	
		countPeriferiche++;
		countPerifericheId++;
		$("#counter-periferiche").html(countPeriferiche); 

		var htmlDesign = designHardwareNone;
		
		var divMaster = document.createElement("div");
		$(divMaster).attr("id","periferica"+countPerifericheId);
		$(divMaster).addClass("designHardwareClass");
		$(divMaster).addClass("richiesta-item clearfix mt-30-xs");	
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-periferica"/> '+countPeriferiche);
		var count = countPerifericheId;
		$(divMaster).find(".removebtn").each(function(){
			$(this).click(function (){
				removeItemPeriferica("#periferica"+count);
			});						
		});
		
		$("#designHardware").append(divMaster);
	 
	 }
	 
	 function addNewItemSoftware(){
		 if(countSoftware == 0)
				$(".icomoon-software").html(htmlBadgeSoftware);
		countSoftware++;
		countSoftwareId++;
		$("#counter-software").html(countSoftware); 

		var htmlDesign = designSoftwareNone;
		
		var divMaster = document.createElement("div");
		$(divMaster).attr("id","software"+countSoftwareId);
		$(divMaster).addClass("designSoftwareClass");
		$(divMaster).addClass("richiesta-item clearfix mt-30-xs");	
		$(divMaster).append(htmlDesign);
		$(divMaster).find(".number").html('<liferay-ui:message key="label-numero-software"/> '+countSoftware);
		var count = countSoftwareId;
		$(divMaster).find(".removebtn").each(function(){
			$(this).click(function (){
				removeItemSoftware("#software"+count);
			});						
		});
		
		$("#designSoftware").append(divMaster);
	 
	 }
	 
	$("#showComputers").click("on",function(){
		if($("#demo1").hasClass("collapse in")){			
		}else{
			$("#demo2").removeClass("collapse in");
			$("#demo2").addClass("collapse");
			$("#demo3").removeClass("collapse in");
			$("#demo3").addClass("collapse");
			$("#demo4").removeClass("collapse in");
			$("#demo4").addClass("collapse")
			//if (countComputer==0){				
			//	addNewItemComputer();
			//}
		}
	 });
	 
	 
	 	 
	$("#showStampanti").click("on",function(){
		if($("#demo2").hasClass("collapse in")){
		}else{
			$("#demo1").removeClass("collapse in");
			$("#demo1").addClass("collapse");
			$("#demo3").removeClass("collapse in");
			$("#demo3").addClass("collapse");
			$("#demo4").removeClass("collapse in");
			$("#demo4").addClass("collapse")
		}
	 });
	 
	 $("#showPeriferiche").click("on",function(){
		if($("#demo3").hasClass("collapse in")){
		}else{
			$("#demo2").removeClass("collapse in");
			$("#demo2").addClass("collapse");
			$("#demo1").removeClass("collapse in");
			$("#demo1").addClass("collapse");
			$("#demo4").removeClass("collapse in");
			$("#demo4").addClass("collapse")
		}
	 });
	 
	 
	 	 $("#showSoftware").click("on",function(){
		if($("#demo4").hasClass("collapse in")){
		}else{
			$("#demo2").removeClass("collapse in");
			$("#demo2").addClass("collapse");
			$("#demo3").removeClass("collapse in");
			$("#demo3").addClass("collapse");
			$("#demo1").removeClass("collapse in");
			$("#demo1").addClass("collapse")
		}
	 });
	 
	 $(".button-add").click("on",function(){
		 
		
		
		
		 switch(this.id){
			case idButtonDemo1:
				var valid = true;
				$('div[id^="computer"]').find('select').each(function(key,value) {
					$(this).parsley().validate();
					if(!$(this).parsley().isValid())
						valid = false;
				});
				$('div[id^="computer"]').find('input').each(function(key,value) {
					$(this).parsley().validate();
					if(!$(this).parsley().isValid())
						valid = false;
				});
				if(valid)
				addNewItemComputer();
			break;
			case idButtonDemo2:
				var valid = true;
				$('div[id^="stampante"]').find('select').each(function(key,value) {
					$(this).parsley().validate();
					if(!$(this).parsley().isValid())
						valid = false;
				});
				$('div[id^="stampante"]').find('input').each(function(key,value) {
					$(this).parsley().validate();
					if(!$(this).parsley().isValid())
						valid = false;
				});
				if(valid)
				addNewItemStampante();
				break;
			case idButtonDemo3:					
				var valid = true;
				$('div[id^="periferica"]').find('select').each(function(key,value) {
					$(this).parsley().validate();
					if(!$(this).parsley().isValid())
						valid = false;
				});
				$('div[id^="periferica"]').find('input').each(function(key,value) {
					$(this).parsley().validate();
					if(!$(this).parsley().isValid())
						valid = false;
				});
				if(valid)	
				addNewItemPeriferiche();
				break;
			case idButtonDemo4:
				var valid = true;
				$('div[id^="software"]').find('input').each(function(key,value) {
					$(this).parsley().validate();
					if(!$(this).parsley().isValid())
						valid = false;
				});
				if(valid)					
				addNewItemSoftware();
				break;
			default:
		 }
		if($("#validateParsleyCustomForm").find("input").parsley()!=null){
			$("#validateParsleyCustomForm").find("input").parsley().destroy();
			$("#validateParsleyCustomForm").find("input").attr("data-parsley-required","true");
			$("#validateParsleyCustomForm").find("input").attr("data-parsley-required-message",'<liferay-ui:message key="error-richieste-hw-richiesta"/>');	
		}
	
	 });
	 

	 	function removeItemSoftware(idItem){		 	

		 $(idItem).remove();
		 countSoftware--;
		 if (countSoftware<1){
			$(".icomoon-software").find("span").remove(); 
			$("#demo4").removeClass("collapse in");
			$("#demo4").addClass("collapse");
			listSoftware==null;
			countSoftware=0;
		 }else{
			$("#counter-software").html(countSoftware);
			var countnumber=1;
			$('div[id^="software"]').find('.number').each(function(key,value) {
				$(this).html('<liferay-ui:message key="label-numero-software"/> '+countnumber);
				countnumber++;
			});

		 }
		 
		 
	 }
	 

	function removeItemPeriferica(idItem){		 

		 $(idItem).remove();
		 countPeriferiche--;
		 if (countPeriferiche<1){
			$(".icomoon-server").find("span").remove();  
			$("#demo3").removeClass("collapse in");
			$("#demo3").addClass("collapse");
			listAltrePeriferiche==null;
			countPeriferiche=0;
		 }else{
			$("#counter-periferiche").html(countPeriferiche);
			var countnumber=1;
			$('div[id^="periferica"]').find('.number').each(function(key,value) {
				$(this).html('<liferay-ui:message key="label-numero-periferica"/> '+countnumber);
				countnumber++;
			});

		 }		
		 
		 
	 }
	
	 
	function removeItemStampante(idItem){	 	

		 $(idItem).remove();
		 countStampante--;
		 if (countStampante<1){			 
			$(".icomoon-print2").find("span").remove(); 
			$("#demo2").removeClass("collapse in");
			$("#demo2").addClass("collapse");
			listStampanti==null;
			countStampante=0;
		 }else{
			$("#counter-stampante").html(countStampante);
			var countnumber=1;
			$('div[id^="stampante"]').find('.number').each(function(key,value) {
				$(this).html('<liferay-ui:message key="label-numero-stampante"/> '+countnumber);
				countnumber++;
			});

		 }
		 		 
	 }
	
	 
	 function removeItemComputer(idItemComputer){
		 	
		 $(idItemComputer).remove();
		 countComputer--;
		 if (countComputer<1){
			$(".icomoon-computer").find("span").remove();
			$("#demo1").removeClass("collapse in");
			$("#demo1").addClass("collapse");
			listComputer==null;
			countComputer=0;
		 }else{
			$("#counter-computer").html(countComputer);
			var countnumber=1;
			$('div[id^="computer"]').find('.number').each(function(key,value) {
				$(this).html('<liferay-ui:message key="label-numero-computer"/> '+countnumber);
				countnumber++;
			});
		 }
				 
	 }
	
	
<%-- 	 var dataJson = '<%=arrayHardware%>'; --%>

	 

	 </script>
