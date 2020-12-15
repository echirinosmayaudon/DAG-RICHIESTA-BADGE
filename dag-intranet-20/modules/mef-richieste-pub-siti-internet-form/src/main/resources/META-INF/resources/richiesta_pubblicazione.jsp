<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="service.intranet.mef.model.PeriodicitaRichPubblic"%>
<%@page import="service.intranet.mef.model.TipologiaRichPubblic"%>
<%@page import="service.intranet.mef.service.PeriodicitaRichPubblicLocalServiceUtil"%>
<%@page import="service.intranet.mef.service.TipologiaRichPubblicLocalServiceUtil"%>
<%@page import="mef.richieste.pub.siti.internet.bean.Richiedente" %>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>


<%	
	Richiedente _richiedente = (Richiedente)request.getAttribute("richiedente");
	if(_richiedente!=null){
    int countTab=0; 
%>
<div class="trasporti-header servizi-header-sito-internet">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper">
                        <h2 class="title"><%=serviziPubblicazioneSitiTitle %></h2>
                        <a class="icomoon-star title-star btn-star-bookmarks star mr-20-xs">
                            <span class="sr-only"><liferay-ui:message key="pubblicazioni-sito-aggiungi-preferiti"/></span>
                        </a>
                            <div class="wrap-icon-title mt-5-md mobile-search">
                            	<a href="<%=linkPaginaGuida%>" title="vai alla guida" aria-label="vai alla guida" class="go-to-guide">
                                    <span class="icon icomoon-book"><span class="sr-only"><liferay-ui:message key="pubblicazione-sito-go-to-guide"/></span></span>
                                    <p class="go-to-guide-text"><liferay-ui:message key="pubblicazione-sito-guida"/></p>
                                </a>      
                            </div>
                        <p class="subtitle dot-point dot-155"><%=serviziPubblicazioneSitiSubTitle%></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
  
        <div class="gestione-riunioni-modifica-wrapper">
        <div class="ama-container-fluid">

            <div class="tab-negative-wrap internet">
                <ul class="nav nav-pills">
                    <li id="id1"  class="active"><a title="UFFICIO DI COMPETENZA" data-toggle="pill" href="#demo1" class="text-tab tab-internet">
                        <span class="ico-tab ico-tab-internet icomoon-uffici"></span><liferay-ui:message key="pubblicazioni-sito-ufficio-competenza"/></a>
                    </li>
                    <li id="id2"  ><a title="COLLOCAZIONE SUL SITO / DOCUMENT" data-toggle="pill" href="#demo2" class="text-tab tab-internet">
                        <span class="ico-tab ico-tab-internet icomoon-collocazione"></span><liferay-ui:message key="pubblicazioni-sito-collocazione-documenti"/></a>
                    </li>
                    <li id="id3"  ><a title="STAMPA, RICHIEDI PDF / CD" data-toggle="pill" href="#demo3" class="text-tab tab-internet">
                        <span class="ico-tab ico-tab-internet icomoon-stampa"></span><liferay-ui:message key="pubblicazioni-sito-stampa-pdf-cd"/></a>
                    </li>
                    <li id="id4" ><a title="AGGIUNGI ALLEGATI" data-toggle="pill" href="#demo4" class="text-tab tab-internet">
                        <span class="ico-tab ico-tab-internet icomoon-allegati"></span><liferay-ui:message key="pubblicazioni-sito-aggiungi-allegati"/></a>
                    </li>
                </ul>

                <div class="tab-content pt-0-xs pb-0-xs">
                    <div id="demo1" class="tab-pane fade in active">
                        <div class="ama-row">
                            <div class="ama-col-md-12">
                                <div class="wrapper-title-small">
                                    <h2 class="title-box borders"><liferay-ui:message key="pubblicazioni-sito-dati-richiedente"/></h2>
                                </div>
                            </div>
                        </div>
                        <form id="formTab1" data-parsley-validate="true" enctype="multipart/form-data" >
                            <div class="ama-row">
                                <div class="ama-col-xs-12 ama-col-md-6">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-ispettorato"/></label>
                                    <c:if test="<%=_richiedente.getIspettorato()!=null%>">
                                    	<input id="ispettoratoRichiedente"
                                    		data-parsley-required="true"
                                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                    		type="text" value="<%=_richiedente.getIspettorato()%>" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-sito-ispettorato"/>" readonly>
                                	</c:if>
                                	<c:if test="<%=_richiedente.getIspettorato()==null%>">
                                    	<input id="ispettoratoRichiedente"
                                    		data-parsley-required="true"
                                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                    		type="text" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-sito-ispettorato"/>" readonly>
                                	</c:if>
                                </div>
                                <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-ufficio"/></label>
                                    <c:if test="<%=_richiedente.getUfficio()!=null%>">	
                                    	<input id="ufficio" type="text" value="<%=_richiedente.getUfficio()%>" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-sito-ufficio"/>">
									</c:if>
									<c:if test="<%=_richiedente.getUfficio()==null%>">
									<input id="ufficio" type="text" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-sito-ufficio"/>">
									</c:if>
								</div>
                            </div>
                        
                            <div class="ama-row">
                                <div class="ama-col-xs-12 ama-col-md-6">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-primo-referente"/>*</label>
                                    <c:if test="<%=_richiedente.getNome()== null || _richiedente.getCognome()== null%>">
	                                    <input
	                                    	id="primoReferente" 
	                                    	data-parsley-required="true"
	                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
	                                    	type="text" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-referente"/>" readonly>
                                    </c:if>
                                     <c:if test="<%=_richiedente.getNome()!= null && _richiedente.getCognome()!= null%>">
	                                    <input
	                                    	id="primoReferente" 
	                                    	data-parsley-required="true"	                                    	
	                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
	                                    	value="<%=_richiedente.getNome()%> <%=_richiedente.getCognome()%>" 
	                                    	type="text" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-referente"/>" readonly>
                                    </c:if>
                                </div>
                                <div class=" ama-col-xs-12 ama-col-md-6 mb-25-md">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-secondo-referente"/>*</label>
                                    <c:if test="<%=_richiedente.getNomeDirigente()== null || _richiedente.getCognomeDirigente()== null%>">
	                                    <input
	                                    	id="secondoReferente" 
	                                    	data-parsley-required="true"
	                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
	                                    	type="text" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-referente"/>">
                                   </c:if>
                                   <c:if test="<%=_richiedente.getNomeDirigente()!= null && _richiedente.getCognomeDirigente()!= null%>">
	                                    <input
	                                    	id="secondoReferente" 
	                                    	data-parsley-required="true"
	                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
	                                    	value="<%=_richiedente.getNomeDirigente()%> <%=_richiedente.getCognomeDirigente()%>" 
	                                    	type="text" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-referente"/>">
                                   </c:if> 	
                                </div>
                            </div>
                        
                            <div class="ama-row">
                            	<div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                                    <label for="argument" class="label-form">
                                    <liferay-ui:message key="pubblicazioni-sito-email"/>*
                                    </label>
                                     <c:if test="<%=_richiedente.getEmail()== null%>">	
	                                    <input
	                                        data-parsley-required="true"
		                                    data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
	                                    	data-parsley-type="email"
											data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
	                                    	id="email"
	                                    	class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-email"/>">
                                    </c:if>
                                       <c:if test="<%=_richiedente.getEmail()!= null%>">	
	                                    <input
	                                        data-parsley-required="true"
		                                    data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
	                                    	data-parsley-type="email"
											data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
	                                    	id="email"
	                                    	value="<%=_richiedente.getEmail()%>" 
	                                    	class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-email"/>">
                                    </c:if>
                                </div>
                                <div class="ama-col-xs-12 ama-col-md-6">
                                 <label for="argument" class="label-form">
                                    <liferay-ui:message key="pubblicazioni-sito-email-dirigente"/>*
                                    </label>
                                      <c:if test="<%=_richiedente.getEmailDirigente()== null%>">	
	                                    <input
	                                        data-parsley-required="true"
	                                        data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
	                                    	data-parsley-type="email"
											data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
	                                    	id="emailDirigente"
	                                    	class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-email"/>">
                                      </c:if>
                                    
                                     <c:if test="<%=_richiedente.getEmailDirigente()!=null%>">	
	                                    <input 
	                                    	data-parsley-required="true"
	                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
	                                    	data-parsley-type="email"
											data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
	                                    	id="emailDirigente"
	                                    	value="<%=_richiedente.getEmailDirigente()%>" 
	                                    	class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-email"/>">
                                      </c:if>
                                </div>         
                            </div>
                            
                            <div class="ama-row">
                            	<div class="ama-col-xs-12 ama-col-md-6">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-telefono"/>*</label>
									<c:if test="<%=_richiedente.getTelefonoInterno() == null%>">
                                    <input
                                    	id="telefonoInterno" 
                                    	data-parsley-required="true"
                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                    	data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}|\d{3,3}"
										data-parsley-maxlength="30"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                    	class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-telefono"/>">
									</c:if>
                                    <c:if test="<%=_richiedente.getTelefonoInterno() != null%>">	
									<input
                                    	id="telefonoInterno" 
                                    	data-parsley-required="true"
                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                    	data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}|\d{3,3}"
										data-parsley-maxlength="30"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
										value="<%=_richiedente.getTelefonoInterno()%>"
                                    	class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-telefono"/>">
									</c:if>
                                </div>
                            </div>
                            
                            
                        
                            <div class="ama-col-xs-12 mt-60-xs mt-20-xs mb-60-xs">
                                <div class="buttons-wrapper text-center">
                                    <div class=" ama-col-xs-12 text-center">
                                     <%countTab++; %>
                                        <button  onclick="changeTab(<%=countTab%>, event)" class="button button-primary button-filtro"><liferay-ui:message key="pubblicazioni-sito-prosegui"/></button>
                                    </div>
                                </div>
                            </div>
                        </form>      
                    </div>

                    <div id="demo2" class="tab-pane fade">   
                        <div class="ama-row">
                            <div class="ama-col-md-12">
                                <div class="wrapper-title-small">
                                    <h2 class="title-box borders"><liferay-ui:message key="pubblicazioni-sito-documento"/></h2>
                                </div>
                            </div>
                        </div>
                         <form id="formTab2" data-parsley-validate="true" enctype="multipart/form-data" > 
                         	<div class="ama-row">
                                <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-tipologia"/>*</label>
                                    <select id="tipologia" class="option-select-notice" onchange="tipologiaLuogoMandatory()"
                                    	data-parsley-required="true"
						 				data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
                                    	<option value="" hidden><liferay-ui:message key="pubblicazioni-sito-scelta-servizio"/></option>
                                    	<c:if test="<%=request.getAttribute("lista_tipologia")!=null%>">
                                    		<c:forEach items="<%=request.getAttribute("lista_tipologia")%>" var="tipologiaItem">
									   				<option value="${tipologiaItem.getId()}">${tipologiaItem.getTipologia().toUpperCase()}</option>
									   		</c:forEach>
                                    	</c:if>
                                    </select>
                                </div>
                        
                                <div class="ama-col-xs-12 mb-25-md">
                                    <div class="wrapper-content-textarea">
                                        <label class="label-form margin-top" for="textarea-detail1"><liferay-ui:message key="pubblicazioni-sito-titolo"/>*</label>
                                        <textarea 
                                        	data-parsley-minlength="10" 
                                       		data-parsley-maxlength="255" 
                                       		data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>" 
                                        	data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
                                        	data-parsley-validation-threshold="10"
											data-parsley-required="true"
											data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                        	class="form-control textarea-custom-light textarea-small data-parsley-validated" id="textarea-detail1" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-titolo"/>"></textarea>
                                        <div class="content-textarea">0/
                                            <p class="color-gray">255</p>
                                        </div>
                                    </div>
                                </div>
                        
                                <div class="ama-col-xs-12 mb-25-md">
                                    <div class="wrapper-content-textarea">
                                        <label class="label-form margin-top" for="textarea-detail2"><liferay-ui:message key="pubblicazioni-sito-sottotitolo"/>*</label>
                                        <textarea 
                                            data-parsley-minlength="10" 
                                       		data-parsley-maxlength="255" 
                                       		data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>" 
                                        	data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
                                        	data-parsley-validation-threshold="10"
											data-parsley-required="true"
											data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                        	class="form-control textarea-custom-light textarea-small data-parsley-validated" id="textarea-detail2" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-sottotitolo"/>"></textarea>
                                        <div class="content-textarea">0/
                                            <p class="color-gray">255</p>
                                        </div>
                                    </div>
                                </div>
                        
                                <div class="ama-col-xs-12 mb-25-md">
	                                <div class="wrapper-content-textarea">
	                                        <label class="label-form margin-top" for="textarea-detail3"><liferay-ui:message key="pubblicazioni-sito-novita"/>*</label>
	                                        <textarea 
	                                        	data-parsley-minlength="10" 
                                       			data-parsley-maxlength="3500" 
                                       			data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>" 
                                        		data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
                                        		data-parsley-validation-threshold="10"
												data-parsley-required="true"
												data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
	                                        	class="form-control textarea-custom-light data-parsley-validated" id="textarea-detail3" placeholder="<liferay-ui:message key="placeholder-pubblicazione-descrizione"/>"></textarea>
	                                        <div class="content-textarea">0/
	                                            <p class="color-gray">3500</p>
	                                        </div>
	                                </div>
                                </div>

                            </div>
                            <div class="ama-row">
                                <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                                    <label for="argument1" class="label-form"><liferay-ui:message key="pubblicazioni-sito-collocazione-proposta"/>*</label>
                                    <input 
                                    	data-parsley-required="true"
										data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                    	id="collocazioneProposta" type="text" class="input-custom-light data-parsley-validated" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-inserisci"/>">
                                </div>
                                <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                                    <label for="argument3" class="label-form"><liferay-ui:message key="pubblicazioni-sito-periodicita"/>*</label>
                                    <select 
                                    	data-parsley-required="true"
						 				data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                    	id="periodicita" class="option-select option-select"><div class="icomoon-vedi-dark"></div>
                                   		<option value="" hidden><liferay-ui:message key="pubblicazioni-sito-seleziona"/></option>
                                    	<c:if test="<%=request.getAttribute("lista_periodicita")!=null%>">
                                    		<c:forEach items="<%=request.getAttribute("lista_periodicita")%>" var="periodicitaItem">
                                       			<option value="${periodicitaItem.getId()}">${periodicitaItem.getPeriodicita().toUpperCase()}</option>
									   		</c:forEach>
                                    	</c:if>
                                    </select>
                                </div>
                                <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-25-md">
                                    <label for="dateCompetenza" class="label-form margin-top"><liferay-ui:message key="pubblicazioni-sito-data-competenza"/>*</label>
                                    <input 	
                                    	data-parsley-required="true"
										data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                    	id="dateCompetenza" type="text" name="date" class="datepicker-custom input-custom-light data-parsley-validated" placeholder="DD/MM/AAAA">
                                </div>
                                <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-25-md">
                                    <label id="<portlet:namespace/>dateEventoLabel" for="<portlet:namespace/>dateEvento" class="label-form margin-top"><liferay-ui:message key="pubblicazioni-sito-data-evento"/></label>
                                    <input 
										data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                    	id="<portlet:namespace/>dateEvento" type="text" name="date" class="datepicker-custom input-custom-light data-parsley-validated" placeholder="DD/MM/AAAA">
                                </div>
                                <div class="ama-col-xs-12 ama-col-md-6 mb-25-md">
                                    <label id="<portlet:namespace/>luogoEventoLabel" for="<portlet:namespace/>luogoEvento" class="label-form"><liferay-ui:message key="pubblicazioni-sito-luogo-evento"/></label>
                                    <input 
                                    	id="<portlet:namespace/>luogoEvento" class="input-custom-light" type="text" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-inserisci"/>">
                                </div>
                        
                                <div class="ama-col-xs-12 mb-25-md">
                                    <div class="wrapper-content-textarea">
                                        <label class="label-form margin-top" for="textarea-detail3"><liferay-ui:message key="pubblicazioni-sito-riferimenti-note"/></label>
                                        <textarea
                                        	data-parsley-maxlength="2000" 
                                        	data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>" 
                                        	class="form-control textarea-custom-light" id="<portlet:namespace/>nota" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-inserimento-link"/>"></textarea>
                                        <div class="content-textarea">0/
                                            <p class="color-gray">2000</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="ama-col-xs-12 mt-60-xs mt-20-xs mb-60-xs">
                                    <div class="buttons-wrapper text-center">
                                        <div class=" ama-col-xs-12 text-center">
                                         <%countTab++; %>
                                            <button onclick="changeTab(<%=countTab%>, event)"  class="button button-primary button-filtro"><liferay-ui:message key="pubblicazioni-sito-prosegui"/></button>
                                        </div>
                                    </div>
                                </div>
                              </div>
                         </form>
                     
                    </div>
 
                    <div id="demo3" class="tab-pane fade">
                        <div class="ama-row">
                            <div class="ama-col-md-12">
                                <div class="wrapper-title-small">
                                    <h2 class="title-box borders"><liferay-ui:message key="pubblicazioni-sito-stampa-cartacea"/></h2>
                                </div>
                            </div>
                        </div>
                        <form id="formTab3" data-parsley-validate="true" enctype="multipart/form-data" >
						<div class="ama-row">
                                    <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                                        <label  class="label-form"><liferay-ui:message key="pubblicazioni-sito-stampa-cartacea"/></label>
                                        <input id="stampaCartacea" onkeyup="parsleyEstremiAutorizza('#stampaCartacea','#produzioneCd','#produzioneDvd')" type="text" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-pubblicazioni-copie"/>">
                                    </div>
                        
                                    <div id="radioId" class="ama-col-md-9 ama-col-sm-6 ama-col-xs-12 mb-25-md">
                                        <label  class="label-form"><liferay-ui:message key="pubblicazioni-sito-stampa-trattamento"/></label>
                                        <div class="box-radio-custom  mt-5-md">
                                            <input checked="" id="radio1" name="radioPureCSS" value="1" type="radio" class="radio-custom-dark">
                                            <label for="radio1" class="radio-custom-desc">
                                                <span>Brossuratrice</span>
                                            </label>
                                        </div>
                                        <div class="box-radio-custom mt-5-md ml-10-xs">
                                            <input id="radio2" name="radioPureCSS" value="2" type="radio" class="radio-custom-dark">
                                            <label for="radio2" class="radio-custom-desc">
                                                <span>Nastro</span>
                                            </label>
                                        </div>
                                        <div class="box-radio-custom mt-5-md mt-5-xs ml-0-xs ml-10-sm">
                                            <input id="radio3" name="radioPureCSS" value="3" type="radio" class="radio-custom-dark">
                                            <label for="radio3" class="radio-custom-desc">
                                                <span>Spillatura</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                        
                                <div class="ama-row">
                                    <div id="opzioneColori" class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12 mb-25-md">
                                        <label  class="label-form"><liferay-ui:message key="pubblicazioni-sito-opzioni-stampa"/></label>
                                        <div class="box-radio-custom mt-5-md">
                                            <input checked="" id="radio4" name="radioPureCSS1" value="1" type="radio" class="radio-custom-dark">
                                            <label for="radio4" class="radio-custom-desc">
                                                <span> B / N</span>
                                            </label>
                                        </div>
                                        <div class="box-radio-custom mt-5-md ml-10-xs">
                                            <input id="radio5" name="radioPureCSS1" value="2" type="radio" class="radio-custom-dark">
                                            <label for="radio5" class="radio-custom-desc">
                                                <span>Colori</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                                        <label  class="label-form"><liferay-ui:message key="pubblicazioni-sito-stampa-opzioni"/></label>
                                        <div  id="opzioniStampa" class="checkbox-blue mt-5-md mb-10-md">
                                            <div class="squaredOne">
                                                <input type="checkbox" value="fronte/retro" id="squaredTwo" name="check" checked="">
                                                <label for="squaredTwo"></label>
                                            </div>
                                            <p class="text-check ml-10-xs">Fronte / retro</p>
                                        </div>
                                    </div>
                                    <div class="ama-col-md-3 ama-col-xs-12 mb-25-md">
                                        <label  class="label-form"><liferay-ui:message key="pubblicazioni-sito-tot-fotocopie"/></label>
                                        <input id="totaleFotocopie" type="text" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-sito-numero-fotocopie"/>">
                                    </div>
                                </div>
                          
                        
                        <div class="ama-row">
                            <div class="ama-col-md-12">
                                <div class="wrapper-title-small">
                                    <h2 class="title-box borders"><liferay-ui:message key="pubblicazioni-sito-altro"/></h2>
                                </div>
                            </div>
                        </div>
                        <div class="ama-row">
                         
                                <div class="ama-col-md-3 mb-25-md">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-produzione-cd"/></label>
                                    <input id="produzioneCd" type="text" onkeyup="parsleyEstremiAutorizza('#stampaCartacea','#produzioneCd','#produzioneDvd')" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-sito-numero-cd"/>">
                                </div>
                                <div class="ama-col-md-3 mb-25-md">
                                    <label for="argument" class="label-form"><liferay-ui:message key="pubblicazioni-sito-produzione-dvd"/></label>
                                    <input id="produzioneDvd" type="text" onkeyup="parsleyEstremiAutorizza('#stampaCartacea','#produzioneCd','#produzioneDvd')" class="input-custom-light" placeholder="<liferay-ui:message key="placeholder-sito-numero-dvd"/>">
                                </div>
                                <div class="ama-col-md-6 mb-25-md">
                                    <label  class="label-form"><liferay-ui:message key="pubblicazioni-sito-prod-pdf"/></label>
                                    <div class="checkbox-blue mt-5-xs mb-10-md">
                                        <div id="produzionePdf"  class="squaredOne">
                                            <input type="checkbox" value="pdf" id="squaredOne" name="check">
                                            <label for="squaredOne"></label>
                                        </div>
                                        <p class="text-check ml-10-xs"><liferay-ui:message key="pubblicazioni-sito-richiesta-pdf"/></p>
                                    </div>
                                </div>
                     
                        </div>
                        
                        <div class="ama-row">
                            <div class="ama-col-md-12">
                                <div class="wrapper-title-small">
                                    <h2 class="title-box borders"><liferay-ui:message key="pubblicazioni-estremi-produzione-cartacea"/></h2>
                                </div>
                            </div>
                        </div>
                        <div class="ama-row">
                           
                                <div class="ama-col-md-3 mb-25-md">
                                    <label for="<portlet:namespace/>protocollo" id="<portlet:namespace/>protocolloLabel" class="label-form"><liferay-ui:message key="pubblicazioni-sito-protocollo"/></label>
                                    <input 
                                 		data-parsley-type="alphanum"
										data-parsley-maxlength="7" 
                                        data-parsley-maxlength-message="<liferay-ui:message key="pubblicazione-sito-error-maxlenght-message"/>" 
                                    	id="<portlet:namespace/>protocollo" class="input-custom-light data-parsley-validated" 
										placeholder="<liferay-ui:message key="placeholder-sito-inserimento-protocollo"/>">
                                </div>
                                <div class="ama-col-md-3 mb-25-md">
                                    <label for="<portlet:namespace/>date" id="<portlet:namespace/>dateLabel" class="label-form margin-top"><liferay-ui:message key="pubblicazioni-sito-data-label"/></label>
                                    <input 
                                    	data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
                                    	id="<portlet:namespace/>date" type="text" name="date" class="datepicker-custom input-custom-light data-parsley-validated" placeholder="DD/MM/AAAA">
                                </div>
                                <div class="ama-col-md-12 ama-col-xs-12">
                                    <div class="wrapper-content-textarea">
                                        <label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="pubblicazioni-sito-note-text"/></label>
                                        <textarea 
											class="form-control textarea-custom-light" id="textarea-detail" placeholder="<liferay-ui:message key="placeholder-sito-dettagli"/>"></textarea>
                                        <div class="content-textarea">0/
                                            <p class="color-gray">500</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="ama-col-xs-12 mt-60-xs mt-20-xs mb-60-xs">
                                    <div class="buttons-wrapper text-center">
                                        <div class=" ama-col-xs-12 text-center">
                                               <%countTab++; %>
                                            <button  onclick="changeTab(<%=countTab%>, event)"  class="button button-primary button-filtro"><liferay-ui:message key="pubblicazioni-sito-prosegui"/></button>
                                        </div>
                                    </div>
                                </div>
                       
                        </div>
                         </form>
                    </div>
                    <div id="demo4" class="tab-pane fade">
                        <div class="wrapper-allegati-general">
                            <div class="ama-row">
                                <div class="ama-col-md-12">
                                    <div class="wrapper-title-general">
                                        <h2 class="title-box borders"><liferay-ui:message key="pubblicazioni-sito-allegati"/></h2>
                                        <a href="#" title="<liferay-ui:message key="pubblicazione-sito-informations"/>" class="tooltip-field">
                                            <span class="icomoon-info ico-attachments"></span>
                                        </a>
                        
                                    </div>
                                </div>
                            </div>
							
                          
								
                                <div class="ama-row" id="<portlet:namespace/>btnAllega">
                                    <div class="ama-col-md-12 mobile-no-padding">
                                        <div class="box-button">
                                            <button href="#" type="button"  id="<portlet:namespace/>addAttachFile" class="button button-primary"><liferay-ui:message key="pubblicazioni-sito-seleziona-file"/></button>
                                        </div>
                                    </div>
                                </div>
                                
                              <portlet:actionURL name="addRichiestaAction" var="addRichiestaAction"/>
						        <form id="formHiddenSubmit"  method="post"  action="<%=addRichiestaAction%>" data-parsley-validate="true" enctype="multipart/form-data">
						        	<input type="hidden" id="countAllegati" name="<portlet:namespace/>countAllegati"> 
						        	<input type="hidden" id="jsonRichiesta" name="<portlet:namespace/>jsonRichiesta" class="jsonRichiestaHidden data-parsley-validated"> 
						       		<div id="divFiles"  data-parsley-check-total-megabyte="10" data-parsley-validate-if-empty="">
						       		
						       		</div>
						        </form> 
                                <div class="container-button-general-allegati">
                                    <div class="ama-row">
                                        <div class="ama-col-sm-12">
                                            <button onclick="inviaRichiesta()" class="button button-primary margin-top"><liferay-ui:message key="pubblicazioni-sito-invia-scheda"/></button>

                                        </div>
                                    </div>
                                </div>
                        </div>         
                    </div>
                </div>
            </div>
        </div>
		
			<div id="modal-change-tab" class="modal modal-custom fade modal-icon-page" role="dialog"> 
								<div class="modal-dialog"> 
									<div class="modal-content"> 
										<div class="modal-body"> 
											<div class="modal-title-box"> 
												<a href="#" class="icomoon-close-white" data-dismiss="modal"></a> 
													<div class="title-modal"> 
														<h2 class="title"><liferay-ui:message key="pub-sito-modale-allegati-titolo"/></h2> 
													</div> 
											 </div> 
												<h2 class="text"><liferay-ui:message key="pub-sito-modale-allegati-messaggio"/>?</h2> 
			 
							  <div class="ama-row mb-50-xs buttons-bottom"> 
								  <div class="ama-col-xs-12 ama-col-sm-6"> 
									  <button id="annullaModal" class="button button-secondary" data-dismiss="modal"><liferay-ui:message key="pub-sito-modale-no"/></button> 
								 </div> 
								  <div class="ama-col-xs-12 ama-col-sm-6"> 
									  <button id="salvaModal" onclick="inviaRichiestaNoAllegati()" type="button" class="button button-primary" 
									  name="<portlet:namespace/>btnSalvaModifiche"><liferay-ui:message key="pub-sito-modale-si"/></button> 									   
								 </div>
							  </div> 
						  </div> 
						</div> 
					</div> 
				</div>  
    <script>
    
    var countAllegati=0;
    var idAttachFileDiv="#<portlet:namespace/>fileAttachDiv";
    var idButtonAddAttachFile = "#<portlet:namespace/>addAttachFile";
    var idFileName= "#<portlet:namespace/>fileName";
    var idRemoveAllegato="#<portlet:namespace/>removeFile";
	var idFileAttachForm = "#formHiddenSubmit";

    
    $(idButtonAddAttachFile).on('click', function(event){  
    	$(".attachFileCustom").each(function(){
			if (this.value==null || this.value==""){
   				$(this).remove();
    		}
		});
    	var index =0;	
    	
		$(idFileAttachForm).parsley().validate();
		$("#divFiles").parsley().validate();

    	var flagP = true;
    	if(countAllegati > 0) {
			flagP = $(idFileAttachForm).parsley().isValid();
    	}
    	
    	if (flagP){
    		if($(".attachFileCustom").last().length>0){
    			var indexFinal = "<portlet:namespace/>fileAttach".length;
    			index = $(".attachFileCustom").last().attr('id').substring(indexFinal);
    		}
    		
    		countAllegati= parseInt(index)+1;
		
			var input = document.createElement("input");
			$(input).attr("id", '<portlet:namespace/>fileAttach'+countAllegati);
			$(input).attr("data-parsley-trigger", 'change');
			$(input).addClass('parsley-megabyte-total-validator');
			$(input).attr("data-parsley-filecheckwithoutextension", ".exe");
			$(input).attr("data-parsley-filemaxmegabytes", "4");		
			$(input).attr("type", 'file');
			$(input).addClass("attachFileCustom");
			$(input).css("display",'none');
			$(input).attr("name", '<portlet:namespace/>allegato'+countAllegati);
		
		$(idFileAttachForm).append(input);
		$("#divFiles").append(input);
		$("#divFiles").parsley().validate();
		
		$('#<portlet:namespace/>fileAttach'+countAllegati).change(function(){
			$(idFileAttachForm).parsley().validate();
			  $("#divFiles").parsley().validate();
				
				if (this.value!=null && this.value!="" && $("#divFiles").parsley().isValid() && $(idFileAttachForm).parsley().isValid()){
				  
					var divAma = document.createElement("div");
				  	$(divAma).addClass('ama-row');
				  	$(divAma).attr('id','<portlet:namespace/>fileAttachDiv'+countAllegati);
				  	var divColMd = document.createElement("div");
				  	$(divColMd).addClass('ama-col-md-12 mobile-no-padding');
				  	var divWrapperContent = document.createElement("div");
				  	$(divWrapperContent).addClass('wrapper-content');
				  	var divWrapperWhite = document.createElement("div");
				  	$(divWrapperWhite).addClass('wrapper-white name-file-attach');
				  	var pText = document.createElement("p");
				  	$(pText).addClass('text');
				  	$(pText).attr('id','<portlet:namespace/>fileName'+countAllegati);
					
				  	var index = this.value.lastIndexOf('\\');
					var textFile= this.value.substring(index+1, this.value.length); 
					var file=$(this)["0"].files;	
					var dimension= (file[0].size/1024).toFixed(0);	
  				  	$(pText).text(textFile+" ("+dimension+"kb) ");
  				    var aClose = document.createElement("a");
				  	$(aClose).attr('href','#');
				  	$(aClose).attr('title','elimina file');
				  	$(aClose).attr('id','<portlet:namespace/>removeFile'+countAllegati);
				  	$(aClose).addClass('icomoon-close-white ico-delete');
				  	$(aClose).click({count:countAllegati},function(event){
					 
						event.preventDefault();
						var countEvent = event.data.count;
						$('#<portlet:namespace/>fileAttach'+countEvent).remove();
						$('#<portlet:namespace/>fileAttachDiv'+countEvent).remove();
						$(idFileAttachForm).parsley().validate();
						$("#divFiles").parsley().validate();
				  });
				  
				  $(pText).append(aClose);
				  $(divWrapperWhite).append(pText);
				  $(divWrapperContent).append(divWrapperWhite);
				  $(divColMd).append(divWrapperContent);
				  $(divAma).append(divColMd);
				  $(divAma).insertBefore( "#<portlet:namespace/>btnAllega" ); 
		    	
			  }
			  else {
				 // if (!$("#divFiles").parsley().isValid())
					$(this).remove();
				}	
		    });
    	}
		$('#<portlet:namespace/>fileAttach'+countAllegati).click();
    });
    
    function changeTab(tab,event){
    	
    	event.preventDefault();

    	if($("#formTab"+tab).parsley()!= null)
    		$("#formTab"+tab).parsley().validate();

  			if($("#formTab"+tab).parsley().isValid()){
  		  		($('#id'+(tab))).removeClass('active');
  		  		($('#demo'+(tab))).removeClass('in active');
  		  		($('#id'+(++tab))).addClass('active');
  		  		($('#demo'+(tab))).addClass('in active');
						
				if ($(window).width() >= 992){
					$('html, body').animate({ scrollTop: $('.title-wrapper .title').offset().top -60}, 'slow');
				}
				else{
					$('html, body').animate({ scrollTop: $('.title-wrapper .title').offset().top +40}, 'slow');
				} 


  			}
  				
    }
    
    function tipologiaLuogoMandatory() {

		if($("#tipologia option:selected").text().toUpperCase() == "EVENTO/WORKSHOP/SEMINARIO") {
    		$("#<portlet:namespace/>luogoEvento").attr("data-parsley-required", "true");
    		$("#<portlet:namespace/>luogoEvento").attr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
    		$("#<portlet:namespace/>luogoEvento").addClass("data-parsley-validated");
			$("#<portlet:namespace/>luogoEventoLabel").text('<liferay-ui:message key="pubblicazioni-sito-luogo-evento"/>*');
			$("#<portlet:namespace/>dateEvento").attr("data-parsley-required", "true");
    		$("#<portlet:namespace/>dateEvento").attr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
    		$("#<portlet:namespace/>dateEvento").addClass("data-parsley-validated");
    		$("#<portlet:namespace/>dateEventoLabel").text('<liferay-ui:message key="pubblicazioni-sito-data-evento"/>*');
    	}
		else{
			$("#<portlet:namespace/>luogoEvento").removeAttr("data-parsley-required", "true");
			$("#<portlet:namespace/>luogoEvento").removeAttr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
			$("#<portlet:namespace/>luogoEvento").removeClass("data-parsley-validated");
			
    		$("#<portlet:namespace/>luogoEventoLabel").text('<liferay-ui:message key="pubblicazioni-sito-luogo-evento"/>');
			
			$("#<portlet:namespace/>dateEvento").removeAttr("data-parsley-required", "true");
			$("#<portlet:namespace/>dateEvento").removeAttr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
			$("#<portlet:namespace/>dateEvento").removeClass("data-parsley-validated");
			
    		$("#<portlet:namespace/>dateEventoLabel").text('<liferay-ui:message key="pubblicazioni-sito-data-evento"/>');

		}
    }
    	var flagEstremi = false;
		
	function parsleyEstremiAutorizza(idStampa,idCd,idDvd){
			if(!flagEstremi && ($(idStampa).val()!="" || $(idCd).val()!="" ||$(idDvd).val()!="")){
				flagEstremi = true;
				$("#<portlet:namespace/>protocollo").attr("data-parsley-required", "true");
				$("#<portlet:namespace/>protocollo").attr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
				$("#<portlet:namespace/>protocollo").addClass("data-parsley-validated");
				$("#<portlet:namespace/>protocolloLabel").text('<liferay-ui:message key="placeholder-sito-inserimento-protocollo"/>*');
				$("#<portlet:namespace/>date").attr("data-parsley-required", "true");
				$("#<portlet:namespace/>date").attr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
				$("#<portlet:namespace/>date").addClass("data-parsley-validated");
				$("#<portlet:namespace/>dateLabel").text('<liferay-ui:message key="pubblicazioni-sito-data-label"/>*');
			}
			else{
				if(($(idStampa).val()=="" && $(idCd).val()=="" && $(idDvd).val()=="")){
					flagEstremi = false;
					$("#<portlet:namespace/>protocollo").removeAttr("data-parsley-required", "true");
					$("#<portlet:namespace/>protocollo").removeAttr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
					$("#<portlet:namespace/>protocollo").removeClass("data-parsley-validated");
					$("#<portlet:namespace/>protocolloLabel").text('<liferay-ui:message key="placeholder-sito-inserimento-protocollo"/>');
					
					$("#<portlet:namespace/>date").removeAttr("data-parsley-required", "true");
					$("#<portlet:namespace/>date").removeAttr("data-parsley-required-message", '<liferay-ui:message key="error-mandatory"/>');
					$("#<portlet:namespace/>date").removeClass("data-parsley-validated");
					$("#<portlet:namespace/>dateLabel").text('<liferay-ui:message key="pubblicazioni-sito-data-label"/>');

				}
			}
			
		}
		
		function submitRichiesta(){
				
			if($(".attachFileCustom").last().length>0){
				var indexFinal = "<portlet:namespace/>fileAttach".length;
				$("#countAllegati").val($(".attachFileCustom").last().attr('id').substring(indexFinal));
			} else {
				$("#countAllegati").val("0");
			}
			
			var richiestaJsonObj = {
					ispettorato: $("#ispettoratoRichiedente").val(),
		 	 		ufficio: $("#ufficio").val(),
		 	 		primoReferente: $("#primoReferente").val(),
		 	 		secondoReferente: $("#secondoReferente").val(),
		 	 		telefonoInterno: $("#telefonoInterno").val(),
		 			email: $("#email").val(),
		 			emailDirigente: $("#emailDirigente").val(),
		 			tipologia: $("#tipologia option:selected").text(),
		 			titolo: $("#textarea-detail1").val(),
		 			sottotitolo: $("#textarea-detail2").val(),
					novita: $("#textarea-detail3").val(),
					collocazione: $("#collocazioneProposta").val(),
					periodicita: $("#periodicita option:selected").text(),
		 			dataCompetenza: $("#dateCompetenza").val(),
					dataEvento: $("#<portlet:namespace/>dateEvento").val(),
					luogoEvento: $("#<portlet:namespace/>luogoEvento").val(),
		 			nota: $("#<portlet:namespace/>nota").val(),
					stampaCartacea: $("#stampaCartacea").val(),
					trattamento: $("#radioId input:checked").next("label").find("span").text(),
					opzioneColori: $("#opzioneColori input:checked").next("label").find("span").text(),
					opzioniStampa: $("#opzioniStampa input:checked").val(),
					totaleFotocopie: $("#totaleFotocopie").val(),
					produzioneCd: $("#produzioneCd").val(),
					produzioneDvd: $("#produzioneDvd").val(),
					produzionePdf: $("#produzionePdf input:checked").val(),
					protocollo: $("#<portlet:namespace/>protocollo").val(),
					date: $("#<portlet:namespace/>date").val(),
					note: $("#textarea-detail").val()};
			
					$("#jsonRichiesta").val(JSON.stringify(richiestaJsonObj));
					
					$("#formHiddenSubmit").submit();	

		
			
		}
		
		function inviaRichiestaNoAllegati(){
			$('#modal-change-tab').modal('hide');
			submitRichiesta();

		};
		
    function inviaRichiesta() {

    	event.preventDefault();   	    	
		var flagValid = true;
		
		$("#formTab1").parsley().validate();
		$("#formTab2").parsley().validate();
		$("#formTab3").parsley().validate();
		
 		
		if(!($("#formTab1").parsley().isValid())) {
			flagValid = false;
			($('#id4')).removeClass('active');
	 		($('#demo4')).removeClass('in active'); 
		  	($('#id1')).addClass('active');
	 		($('#demo1')).addClass('in active'); 
		}
			
		if( flagValid && !($("#formTab2").parsley().isValid())) {
			flagValid=false;
			($('#id4')).removeClass('active');
	 		($('#demo4')).removeClass('in active'); 
		  	($('#id2')).addClass('active');
	 		($('#demo2')).addClass('in active'); 
			
		}
		if(flagValid && !($("#formTab3").parsley().isValid())) {
			($('#id4')).removeClass('active');
	 		($('#demo4')).removeClass('in active'); 
		  	($('#id3')).addClass('active');
	 		($('#demo3')).addClass('in active');
		}
		
		$("#formHiddenSubmit").parsley().validate();
		
		if(flagValid && $("#formHiddenSubmit").parsley().isValid()) {		
			if( $(".name-file-attach").length>0){
				submitRichiesta();
			}else{
				$('#modal-change-tab').modal('show');
			}
		}
		

    	
	}
    

    </script>
    
    <%}else{ %>
		<liferay-ui:message key="utente-non-abilitato-message"/>
    <%} %>
    
    