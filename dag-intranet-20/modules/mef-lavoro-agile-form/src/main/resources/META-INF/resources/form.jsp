
<%@ include file="/init.jsp" %>
<%@page import="com.accenture.mef.lavoro.agile.form.bean.OpzioniBean"%>
<%@ page import="com.accenture.mef.lavoro.agile.form.portlet.MefLavoroAgileConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.accenture.mef.lavoro.agile.form.bean.Richiedente" %>
<%@ page import="com.accenture.mef.lavoro.agile.form.bean.ModuloRichiesta" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%
	Log _log = LogFactoryUtil.getLog("form_jsp");

	OpzioniBean opzioneBean = null;
	if(request.getAttribute("opzioniBean")!=null) 
	opzioneBean = (OpzioniBean) request.getAttribute("opzioniBean");
	
	Richiedente richiedente = null;
	if(request.getAttribute("richiedente")!=null) 
		richiedente = (Richiedente) request.getAttribute("richiedente");
	
	ModuloRichiesta moduloRichiesta = null;
	if(request.getAttribute("moduloRichiesta")!=null) 
		moduloRichiesta = (ModuloRichiesta) request.getAttribute("moduloRichiesta");
	
	//attach display attribute
	String displaySelezionaFile = "display:block";
	String displaySummaryAttach = "display:none";
	String attachFileName = "";
	String attachFileRealName = "";
	String attachFilePath = "";
	String attachFileMimeType = "";
	boolean flagModifica = false;
	String figli_under13 = "0";
	String figli_over13 = "0";
	String familiari = "0";
	boolean flagOpzione1 = false;
	boolean flagOpzione2 = false;
	boolean flagOpzione3 = false;
	boolean flagOpzione4 = false;
	boolean flagOpzione5 = false;
	boolean flagOpzione6 = false;
	boolean flagOpzione7 = false;
	boolean flagOpzione8 = false;
	boolean flagOpzione8a = false;
	boolean flagOpzione8b = false;
	boolean flagOpzione8c = false;
	boolean flagOpzione9 = false;
	if(request.getAttribute("flagModifica")!=null) {
		flagModifica = (boolean) request.getAttribute("flagModifica");
		if( moduloRichiesta != null ){
			
			flagOpzione1 = moduloRichiesta.getOpzione1().getValore()[0].equals("true");
			flagOpzione2 = moduloRichiesta.getOpzione2().getValore()[0].equals("true");
			flagOpzione3 = moduloRichiesta.getOpzione3().getValore()[0].equals("true");
			flagOpzione4 = moduloRichiesta.getOpzione4().getValore()[0].equals("true");
			flagOpzione5 = moduloRichiesta.getOpzione5().getValore()[0].equals("true");
			flagOpzione6 = !moduloRichiesta.getOpzione6().getValore()[0].equals("false");
			if( flagOpzione6 ){
				figli_under13 = moduloRichiesta.getOpzione6().getValore()[0];
				figli_over13 = moduloRichiesta.getOpzione6().getValore()[1];	
			}
			flagOpzione7 = !moduloRichiesta.getOpzione7().getValore()[0].equals("false");
			if( flagOpzione7 ){
				familiari = moduloRichiesta.getOpzione7().getValore()[0];
			}
			flagOpzione8 = !moduloRichiesta.getOpzione8().getValore()[0].equals("false");
			if( flagOpzione8 ){
				flagOpzione8a = moduloRichiesta.getOpzione8().getId() == opzioneBean.getRadioAId();
				flagOpzione8b = moduloRichiesta.getOpzione8().getId() == opzioneBean.getRadioBId();
				flagOpzione8c = moduloRichiesta.getOpzione8().getId() == opzioneBean.getRadioCId();
			}
			flagOpzione9 = moduloRichiesta.getOpzione9().getValore()[0].equals("true");
			
			if (moduloRichiesta.getAllegato() != null) {
				displaySelezionaFile = "display:none";
				displaySummaryAttach = "display:block";
				attachFileName = (String) request.getAttribute("fileCustom");
				attachFileRealName = moduloRichiesta.getAllegato().getName();
				attachFilePath = moduloRichiesta.getAllegato().getAbsolutePath();
				attachFileMimeType = moduloRichiesta.getAllegatoMimeType();
			}
			
		}
	}

	boolean booleanSegreteriaLavAgile = false;
	if(request.getAttribute("booleanSegreteriaLavAgile")!=null) {
		booleanSegreteriaLavAgile = (boolean)request.getAttribute("booleanSegreteriaLavAgile");
	}
	
	// IMEF-1780
	boolean requestInsertConditionOK = false;
	if(request.getAttribute("requestInsertConditionOK")!=null) {
		requestInsertConditionOK = (boolean)request.getAttribute("requestInsertConditionOK");
	}
	// end IMEF-1780
%>
<portlet:actionURL var="vaiARiepilogo" name="vaiARiepilogo"/> 
<portlet:actionURL var="vaiARicerca" name="vaiARicerca"/> 
   
<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=formTitle%></h2>
                         
                         <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
							<c:if test="<%=booleanSegreteriaLavAgile%>">
								<a href="<%=vaiARicerca%>" title="<liferay-ui:message key="label-title-ricerca"/>" class="icon icomoon-search-richiesta"></a>
							</c:if>
						 </div>
                         
                         <p class="subtitle dot-point dot-200"><%=formSubTitle%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>
     <c:choose>
     <c:when test="<%=requestInsertConditionOK%>">
        <div class="ama-container-fluid">
		<form id="<portlet:namespace/>form1" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=vaiARiepilogo%>" >
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small title-data-agile">
                        <h2 class="title-box borders"><liferay-ui:message key='form-dati-richiedente'/></h2>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                <div class="ama-col-xs-12 mobile-no-padding">
                    <div class="form-request mobile-no-padding">
                        <div class="box-gray">
                            <div class=" box-white pb-0-xs">
                                
                                <p class="name"><%=richiedente.getNome()%> <%=richiedente.getCognome()%></p>
                                <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
                                <div id="collapse-trasporti" class="collapse1 in no-overflow">
                                <div class="ama-row border-section border-mobile">
                                      <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key='label-luogo-di-nascita-richiedente'/>:</span>
                                        <p class="info"><%=richiedente.getLuogoNascita()%></p>
                                    </div>
                                   <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key='label-data-di-nascita-richiedente'/>:</span>
                                        <p class="info"><%=richiedente.getDataNascita()%></p>
                                    </div>
                                   <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key='label-codice-fiscale-richiedente'/>:</span>
                                        <p class="info"><%=richiedente.getCodiceFiscale().toUpperCase()%></p>
                                    </div>
                                </div>
                                
                                <p class="name-section"><liferay-ui:message key='label-residenza-richiedente'/></p>
                                <div class="ama-row border-section">
                                     <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key='label-indirizzo-residenza-richiedente'/>:</span>
                                        <p class="info"><%=richiedente.getResidenzaIndirizzo()%></p>
                                    </div>
            
                                     <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key='label-citta-residenza-richiedente'/>:</span>
                                        <p class="info"><%=richiedente.getResidenzaCitta()%></p>
                                    </div>
                                </div>
            
            
                                <p class="name-section"><liferay-ui:message key='label-assegnazione-richiedente'/></p>
								<div class="ama-row">
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key='label-dipartimento'/>:</span>
										<p class="info"><%=richiedente.getDipartimento()%></p>
									</div>
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key='label-direzione'/>:</span>
										<p class="info"><%=richiedente.getDirezione()%></p>
									</div>
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key='label-ufficio'/>:</span>
										<p class="info"><%=richiedente.getUfficio()%></p>
									</div>
								</div>
								<div class="ama-row">
									 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key='label-assegnazione-email-richiedente'/>:</span>
										<p class="info"><%=richiedente.getMail()%></p>
									</div>
									 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key='label-assegnazione-area-richiedente'/>:</span>
										<p class="info"><%=richiedente.getArea()%></p>
									</div>
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key='label-assegnazione-fascia-retributiva-richiedente'/>:</span>
										<p class="info"><%=richiedente.getFasciaRetributiva()%></p>
									</div>
								</div>
							</div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
			
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small title-request-agile">
                        <h2 class="title-box borders"><liferay-ui:message key='form-richiesta-richiedente'/></h2>
                    </div>
                </div>
            </div>
			
			<div class="ama-row">
                <div class="ama-col-xs-12 mobile-no-padding">
                    <div class="form-request mobile-no-padding">
                        <div class="box-gray">
                            <div class=" box-white pb-0-xs">
								<p class="copy-text blue-color mb-20-xs"><strong>(*) <liferay-ui:message key='form-richiesta-campi-obbligatori'/></strong></p> 
                                <div>
                                    <p class="copy-text blue-color"><%=opzioneBean.getDichiarazione() %></p>
                                </div>
                                 <div class="mt-20-xs mb-20-xs text-center">
                                    <p class="copy-text blue-color"><strong><liferay-ui:message key='label-richiesta-chiede'/></strong></p>
                                </div>
                                
                                 <div class="mt-20-xs mb-20-xs">
                                    <p class="copy-text blue-color"><%=opzioneBean.getDotazioneInfo()%></p>
                                </div>
                                
                                    <div class="ama-row mb-20-xs">
                                        <div class="ama-col-xs-12">
                                            <div class="box-radio-custom pb-20-xs">
                                                <input id="amministrazione" name="<portlet:namespace/>dotaz_inf" 
                                                	   value="amministrazione" type="radio" class="radio-custom-dark" 
                                                	   <c:if test='<%=!flagModifica || ( flagModifica && moduloRichiesta.getDotazione().getId() == opzioneBean.getFornitaAmmId() )%>' >checked=""</c:if> />
                                                <label for="amministrazione" class="custom-label">
                                                    <span>
                                                        <%=opzioneBean.getFornitaAmm()%>
                                                    </span>
                                                </label>
                                            </div>
            
                                            <div class="box-radio-custom ">
                                                <input id="propria" name="<portlet:namespace/>dotaz_inf" 
                                                	   value="propria" type="radio" class="radio-custom-dark"
                                                	   <c:if test='<%=flagModifica && moduloRichiesta.getDotazione().getId() == opzioneBean.getPropriaSpettanzaId()%>' >checked=""</c:if> />
                                                <label for="propria" class="custom-label">
                                                    <span>
                                                        <%=opzioneBean.getPropriaSpettanza()%>
                                                    </span>
                                                </label>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    <div class="ama-row mb-20-xs">
                                        <div class="ama-col-xs-12">
                                            <p class="copy-text blue-color"><liferay-ui:message key='label-richiesta-pertanto'/></p>
                                        </div>
                                        <div class="ama-col-xs-12 text-center">
                                            <p class="copy-text blue-color"><strong><liferay-ui:message key='label-richiesta-dichiara'/></strong></p>
                                        </div>
                                    </div>
                                    <div class="ama-row">
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox"
                                                           id="dichiaraz1" 
                                                    	   name="<portlet:namespace/>dichiaraz-check1" 
                                                    	   <c:if test='<%=flagOpzione1%>' >checked</c:if> 
                                                    	   onclick="onCheckOptionInput(this.id)"
                                                    	   >
                                                    <label for="dichiaraz1"></label>
                                                </div>
										<%
											String opzioneRegolamento = opzioneBean.getRegolamento();
											String[] splitRegolamento = opzioneRegolamento.split("<#link>");
											String fileUrl = "#";
											String regolamentoAgile = null;
											if(request.getAttribute("regolamento")!=null && !("").equalsIgnoreCase((String)request.getAttribute("regolamento"))){
												regolamentoAgile = (String)request.getAttribute("regolamento");
											
											
											
											DLFileEntry regolamentoFile = DLFileEntryLocalServiceUtil.fetchFileEntry(themeDisplay.getScopeGroupId(), 0,
													regolamentoAgile);
											if (regolamentoFile != null) {
												fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
														+ themeDisplay.getScopeGroupId() + "/" + regolamentoFile.getFolderId() + "/"
														+ HttpUtil.encodeURL(HtmlUtil.unescape(regolamentoFile.getFileName())) + "/"
														+ HttpUtil.encodeURL(HtmlUtil.unescape(regolamentoFile.getUuid())) + "?download=true";
											}
											}
										%>
										  <div class="text-check ml-15-md ml-15-xs custom-label">
									
												<%=splitRegolamento[0] %>
												<a href="<%=fileUrl%>" class="link"><%=splitRegolamento[1]%></a>
                                                    <%=splitRegolamento[2] %>*
                                            	
                                            	<input style="display:none"
			                                               	   id="<portlet:namespace/>inputDichRegolamentoAgile"
			                                               	   class="data-parsley-validated" 
			                                               	   name="<portlet:namespace/>inputDichRegolamentoAgile"
			                                               	   <c:if test='<%=flagOpzione1%>' > data-parsley-required="false" </c:if> 
			                                               	   <c:if test='<%=!flagOpzione1%>' > data-parsley-required="true" </c:if> 
						                           		   data-parsley-required-message="<liferay-ui:message key="form-dichiarazione-parsley"/>." 
						                           			   >
                                            	
										</div>
									</div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox" id="dichiaraz2" 
                                                    	   name="<portlet:namespace/>dichiaraz-check2"
                                                    	   <c:if test='<%=flagOpzione2%>' >checked</c:if> >
                                                    <label for="dichiaraz2"></label>
                                                </div>
                                                <div class="text-check ml-15-md ml-15-xs custom-label"><%=opzioneBean.getLavoratore_padre_madre()%></div>
                                            </div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox" id="dichiaraz3" 
                                                    	   name="<portlet:namespace/>dichiaraz-check3"
                                                    	   <c:if test='<%=flagOpzione3%>' >checked</c:if> >
                                                    <label for="dichiaraz3"></label>
                                                </div>
                                                <div class="text-check ml-15-md ml-15-xs custom-label"><%=opzioneBean.getFigli_disabili() %></div>
                                            </div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox" id="dichiaraz4" 
                                                    	   name="<portlet:namespace/>dichiaraz-check4"
                                                    	   <c:if test='<%=flagOpzione4%>' >checked</c:if> >
                                                    <label for="dichiaraz4"></label>
                                                </div>
                                                <div class="text-check ml-15-md ml-15-xs custom-label"><%=opzioneBean.getDisabilita() %> </div>
                                            </div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox" id="dichiaraz5" 
                                                    	   name="<portlet:namespace/>dichiaraz-check5"
                                                    	   <c:if test='<%=flagOpzione5%>' >checked</c:if> >
                                                    <label for="dichiaraz5"></label>
                                                </div>
                                                <div class="text-check ml-15-md ml-15-xs custom-label"><%=opzioneBean.getMonogenitorialita() %></div>
                                            </div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox"
                                                           id="dichiaraz6" 
                                                    	   name="<portlet:namespace/>dichiaraz-check6"
                                                    	   <c:if test='<%=flagOpzione6%>' >checked</c:if> 
                                                    	   	onclick="onCheckOptionInput(this.id)"
                                                    	   >
                                                    <label for="dichiaraz6"></label>
                                                </div>
										<%
										
											String startInput = "<#input";
                                        	String endInput = "#>";
                                                    		
											String opzioneCuraFigli = opzioneBean.getCura_figli();
										%>
												<div class="text-check ml-15-md ml-15-xs custom-label">
													<%=opzioneCuraFigli.substring(0, opzioneCuraFigli.indexOf(startInput))%>
													<span>
														<input id="figli_under13"
														       name="<portlet:namespace/>figli_under13"
														       class="inline-input input-custom-number-badge"
														       type="number"
														       value="<%=figli_under13%>"
														       <c:if test='<%=!flagOpzione6%>' >disabled</c:if> 
														       >
													</span>
													<%=opzioneCuraFigli.substring((opzioneCuraFigli.indexOf(endInput)+endInput.length()),opzioneCuraFigli.lastIndexOf(startInput))%>
													<span> 
														<input id="figli_over13"
														       name="<portlet:namespace/>figli_over13"
														       class="inline-input input-custom-number-badge"
														       type="number"
														       value="<%=figli_over13%>"
														       <c:if test='<%=!flagOpzione6%>' >disabled</c:if> 
														       >
													</span>
													<%=opzioneCuraFigli.substring((opzioneCuraFigli.lastIndexOf(endInput)+endInput.length()))%>
													
													<input style="display:none"
			                                               	   id="<portlet:namespace/>inputNumFigliParsley"
			                                               	   class="data-parsley-validated" 
			                                               	   name="<portlet:namespace/>inputNumFigliParsley"
			                                               	   data-parsley-required="false" 
						                           			   data-parsley-required-message="<liferay-ui:message key="form-dichiarazione-figli-parsley"/>". 
						                           			   >
													
												</div>
												
											</div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox" 
                                                           id="dichiaraz7" 
                                                    	   name="<portlet:namespace/>dichiaraz-check7"
                                                    	   <c:if test='<%=flagOpzione7%>' >checked</c:if>
                                                    	   onclick="onCheckOptionInput(this.id)"
                                                    	   >
                                                    <label for="dichiaraz7"></label>
                                                </div>
										<%
											String opzioneAssFam = opzioneBean.getAssistenza_familiari();
										%>
										<div class="text-check ml-15-md ml-15-xs custom-label">
										
                                                  <%=opzioneAssFam.substring(0, opzioneAssFam.indexOf(startInput))%>
                                                    <span>
                                                          <input id="familiari" 
                                                                 name="<portlet:namespace/>familiari" 
                                                                 class="inline-input input-custom-number-badge" 
                                                                 type="number" 
                                                                 value="<%=familiari%>" 
                                                                 <c:if test='<%=!flagOpzione7%>' >disabled</c:if> 
                                                                 >
                                                    </span>
                                                    <%=opzioneAssFam.substring((opzioneAssFam.lastIndexOf(endInput)+endInput.length()))%>
                                                   
                                                    <input style="display:none"
			                                               	   id="<portlet:namespace/>inputNumFamiliariParsley"
			                                               	   class="data-parsley-validated" 
			                                               	   name="<portlet:namespace/>inputNumFamiliariParsley"
			                                               	   data-parsley-required="false" 
						                           			   data-parsley-required-message="<liferay-ui:message key="form-dichiarazione-familiari-parsley"/>". 
						                           			   >
                                                   
                                                </div>
            									
                                            </div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox"
                                                           id="dichiaraz8" 
                                                    	   name="<portlet:namespace/>dichiaraz-check8"
                                                    	   <c:if test='<%=flagOpzione8%>' >checked</c:if>
                                                    	   onclick="onCheckOptionInput(this.id)"
                                                    	   >
                                                    <label for="dichiaraz8"></label>
                                                </div>
                                                <div class="text-check ml-15-md ml-15-xs custom-label">
                                                <p><%=opzioneBean.getDistanza_domicilio() %><p>
                                                    <div class="radiobox-inside">
                                                    
                                                        <div class="box-radio-custom">
                                                            <input id="distance30" 
                                                                   name="<portlet:namespace/>distance" 
                                                            	   value="ai 30 km"
                                                            	   type="radio"
                                                            	   class="radio-custom-dark radio-distance" 
                                                            	   <c:if test='<%=flagOpzione8a%>' >checked</c:if> 
                                                            	   <c:if test='<%=!flagOpzione8%>' >disabled</c:if>
                                                            	   onchange="changeInputRadioDistance()"
                                                            	   />
                                                            <label for="distance30" class="custom-label">
                                                                <span><%=opzioneBean.getRadioA() %></span>
                                                            </label>
                                                        </div>
                                                        <div class="box-radio-custom">
                                                            <input id="distance50" 
                                                                   name="<portlet:namespace/>distance" 
                                                            	   value="ai 50 km" 
                                                            	   type="radio" 
                                                            	   class="radio-custom-dark radio-distance" 
                                                            	   <c:if test='<%=flagOpzione8b%>' >checked</c:if> 
                                                            	   <c:if test='<%=!flagOpzione8%>' >disabled</c:if>
                                                            	   onchange="changeInputRadioDistance()"
                                                            	   />
                                                            <label for="distance50" class="custom-label">
                                                              <span><%=opzioneBean.getRadioB() %></span>
                                                            </label>
                                                        </div>
                                                        <div class="box-radio-custom">
                                                            <input id="distance100" 
                                                                   name="<portlet:namespace/>distance" 
                                                            	   value="ai 100 km" 
                                                            	   type="radio" 
                                                            	   class="radio-custom-dark radio-distance" 
                                                            	   <c:if test='<%=flagOpzione8c%>' >checked</c:if>
                                                            	   <c:if test='<%=!flagOpzione8%>' >disabled</c:if>
                                                            	   onchange="changeInputRadioDistance()"
                                                            	   />
                                                            <label for="distance100" class="custom-label">
                                                                <span><%=opzioneBean.getRadioC() %></span>
                                                            </label>
                                                        </div>
                                                        
                                                        <input style="display:none"
			                                               	   id="<portlet:namespace/>radioBtnDistanzaParsley"
			                                               	   class="data-parsley-validated" 
			                                               	   name="<portlet:namespace/>radioBtnDistanzaParsley"
			                                               	   data-parsley-required="false" 
						                           			   data-parsley-required-message="<liferay-ui:message key="form-dichiarazione-distanza-km-parsley"/>". 
						                           			   >
                                                        
                                                    </div>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox" id="dichiaraz9" 
                                                    	   name="<portlet:namespace/>dichiaraz-check9"
                                                    	   <c:if test='<%=flagOpzione9%>' >checked</c:if> >
                                                    <label for="dichiaraz9"></label>
                                                </div>
                                                <div class="text-check ml-15-md ml-15-xs custom-label"><%=opzioneBean.getAgevolazioni()%></div>
                                            </div>
                                        </div>
                                    </div>
                                    
                            </div>
                        </div>
                    </div>
                </div>
            </div>        
                
            <div class="wrapper-allegati-general">
                <div class="ama-row">
                    <div class="ama-col-md-12">
                        <div class="wrapper-title-general title-attach-agile">
                            <h2 class="title-box borders"><liferay-ui:message key='label-richiesta-allegato'/>*</h2>
                            <a title="<liferay-ui:message key="form-allegato-dimensioni-pdf"/>." class="tooltip-field tool-res tool-attachments">
                                <span class="icomoon-info ico-attachments "></span>
                            </a>
            
                        </div>
                    </div>
                </div>
                
                <div class="ama-row" id="<portlet:namespace/>divSelezionaFile" style="<%=displaySelezionaFile%>">
                    <div class="ama-col-md-12 mobile-no-padding">
                        <div class="box-button">
                            <button href="#" type="button" id="<portlet:namespace/>selezionaProgIndividuale" class="button button-primary"><liferay-ui:message key='form-richiesta-seleziona-file-allegato'/></button>
                        </div>
                    </div>
                </div>
                
                <div class="ama-row" id="<portlet:namespace/>divSummaryAttach" style="<%=displaySummaryAttach%>">
                    <div class="ama-col-md-12 mobile-no-padding">
						<div class="wrapper-content">
							<div class="wrapper-white">
								<p class="subtitle-text" id="<portlet:namespace/>fileName"><%=attachFileName%>
									<a href="#" title="Elimina file" onclick="removeAttach()" class="icomoon-close-white ico-delete"></a>
								</p>
							</div>
						</div>
                	</div>
                </div>
                
                <input type="file" 
                       id="<portlet:namespace/>fileAttachProgIndividuale" 
                       name="<portlet:namespace/>ProgettoIndividuale" 
                       <c:if test='<%=moduloRichiesta != null && moduloRichiesta.getAllegato() != null%>' > data-parsley-required="false" </c:if> 
			           <c:if test='<%=moduloRichiesta == null || moduloRichiesta.getAllegato() == null%>' > data-parsley-required="true" </c:if> 
                       data-parsley-required-message="<liferay-ui:message key="form-allegato-obbligatorio-parsley"/>."
                       data-parsley-filemaxmegabytes="2"
                       data-parsley-filemaxmegabytes-message="<liferay-ui:message key="form-allegato-dimensioni-extra-pdf-parsley"/>."
                       data-parsley-check-file-attach-extension=".pdf"
                       data-parsley-check-file-attach-extension-message="<liferay-ui:message key="form-allegato-estensione-non-supportata-parsley"/>." 
                       style="display:none"/>
                     
                <input type="text" style="display:none" data-parsley-pattern="[a-zA-Z0-9 ._������]+" 
                       data-parsley-pattern-message="<liferay-ui:message key="form-allegato-nome-non-valido-parsley"/> _ ." 
                       data-parsley-maxlength="200" data-parsley-maxlength-message="<liferay-ui:message key="form-allegato-lunghezza-file-limite-caratteri-parsley"/>." 
                       id="<portlet:namespace/>attachRealName" name="<portlet:namespace/>attachRealName" value="<%=attachFileRealName%>"/>  
                       
                       
                <!-- NOTE -->
                <div class="ama-row">
                    <div class="ama-col-md-12">
                        <div class="wrapper-title-general title-note-agile">
                            <h2 class="title-box borders"><liferay-ui:message key='label-richiesta-note'/></h2>
                            <a title="<liferay-ui:message key="form-note-title"/>." class="tooltip-field tool-res tool-attachments">
                                <span class="icomoon-info ico-attachments"></span>
                            </a>
            
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
			                                <div class="ama-col-md-12 ama-col-xs-12 noteRecap">
										    	<div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs pt-20-md pb-20-md">
										       		<div class="wrapper-content-textarea textarea-badge">
								    		            
											            <c:choose>
															<c:when test="<%=flagModifica%>" >
																<textarea id="<portlet:namespace/>note"
													           			  name="<portlet:namespace/>note"
												                		  class="form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti data-parsley-validated" 
													           			  placeholder="<liferay-ui:message key='form-note-placeholder'/>"><%=moduloRichiesta.getNote()%></textarea>
										                 		<div class="content-textarea">
											             			<p class="color-gray"><%=moduloRichiesta.getNote().length()%>/500</p>
											            		</div>
										                 	</c:when>
										                    <c:otherwise>
															  	<textarea id="<portlet:namespace/>note"
													           			  name="<portlet:namespace/>note"
												                		  class="form-control textarea-custom-light data-parsley-validated removeFieldFormTrasporti data-parsley-validated" 
													           			  placeholder="<liferay-ui:message key='form-note-placeholder'/>"></textarea>
													            <div class="content-textarea">
									             					<p class="color-gray">0/500</p>
									            				</div>
										                    </c:otherwise>
											            </c:choose>              

											           			  

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
            
                <input id="<portlet:namespace/>checkProsegui" 
                       name="<portlet:namespace/>checkProsegui" 
                       data-parsley-required="false" 
                       data-parsley-required-message="<liferay-ui:message key="form-campi-obbligatori-non-valorizzati"/>."
                       type="text" 
                       style="display:none"/>
                       
                <div class="container-button-general-allegati">
                    <div class="ama-row">
                        <div class="ama-col-sm-12">
                            <button type="button" onclick="formSubmit()" class="button button-primary margin-top"><liferay-ui:message key='form-richiesta-prosegui'/></button>
                        </div>
                    </div>
                </div>
            
            </div>
                             
            <input type="hidden" id="<portlet:namespace/>vecchioAllegato" name="<portlet:namespace/>vecchioAllegato" value="<%=attachFilePath%>"/>                 
			<input type="hidden"  id="<portlet:namespace/>attachCustomName" name="<portlet:namespace/>attachCustomName" value="<%=attachFileName%>"/>
			<input type="hidden" id="<portlet:namespace/>vecchioAllegatoMimeType" name="<portlet:namespace/>vecchioAllegatoMimeType" value="<%=attachFileMimeType%>"/>
                   
        	</form>
        </div>
	</c:when>
	<c:otherwise>
	<div class="wrapper-added-notice">
  		<div class="clearfix">
			<div class="display-xs">
		      <div class="div-message-important color-violet">
		        <div class="icomoon-alert"></div>
		        <div class="message-important">
		        <%=msgTerminiScaduti%>
		        </div>
		      </div>
		    </div>
		</div>
	</div>
	</c:otherwise>
</c:choose>
        
        
        
<script type="text/javascript">
var idBtnSelezionaProgIndividuale = "#<portlet:namespace/>selezionaProgIndividuale";
var idInputFileAttachProgIndividuale = "#<portlet:namespace/>fileAttachProgIndividuale";
var idDivSummaryAttach = "#<portlet:namespace/>divSummaryAttach";
var idParagraphFileName = "#<portlet:namespace/>fileName";
var idDivSelezionaFile = "#<portlet:namespace/>divSelezionaFile";
$(idBtnSelezionaProgIndividuale).on('click', function(event){
	$(idInputFileAttachProgIndividuale).click();
});
$(idInputFileAttachProgIndividuale).change(function() {
	
	var fileAttachValue = this.value;
	
	if (fileAttachValue!=null && fileAttachValue!="") {
		
		var index = fileAttachValue.lastIndexOf('\\');
		var fileAttachName = fileAttachValue.substring(index+1, fileAttachValue.length);
		$("#<portlet:namespace/>attachRealName").val(fileAttachName);
		
		$("#<portlet:namespace/>fileAttachProgIndividuale").parsley().validate();
		$("#<portlet:namespace/>attachRealName").parsley().validate();
		if($("#<portlet:namespace/>fileAttachProgIndividuale").parsley().isValid() &&
				$("#<portlet:namespace/>attachRealName").parsley().isValid()){ 

			var inputFile = document.getElementById('<portlet:namespace/>fileAttachProgIndividuale');
			var inputFileSize = inputFile.files[0].size / 1024;
			inputFileSize = (Math.round(inputFileSize ));
			fileAttachName = fileAttachName.concat(" (" + inputFileSize + " KB)");
		
			var tagAInsideText = "<a href='#' title='Elimina file' onclick='removeAttach()' class='icomoon-close-white ico-delete'></a>";
			
			$(idParagraphFileName).text(fileAttachName);
			$(idParagraphFileName).append(tagAInsideText);
			
			$("#<portlet:namespace/>attachCustomName").val(fileAttachName);
			
			$(idDivSummaryAttach).css("display","block");
			$(idDivSelezionaFile).css("display","none");
		
			$("#<portlet:namespace/>fileAttachProgIndividuale").parsley().validate();		
			
			
		}
	}
	
});
function removeAttach(){
	event.preventDefault();
	event.stopPropagation();
	$(idInputFileAttachProgIndividuale).val("");
	$("#<portlet:namespace/>attachCustomName").val("");
	$("#<portlet:namespace/>attachRealName").val("");
	$("#<portlet:namespace/>fileAttachProgIndividuale").attr("data-parsley-required", true);
	$("#<portlet:namespace/>fileAttachProgIndividuale").parsley().validate();
	$("#<portlet:namespace/>attachRealName").parsley().validate();
	$(idDivSelezionaFile).css("display","block");
	$(idDivSummaryAttach).css("display","none");
}
function formSubmit (){
	
	console.log("attachRealName: "+$("#<portlet:namespace/>attachRealName").val() );
	
	 $("#<portlet:namespace/>checkProsegui").attr("data-parsley-required", false);
	 var isValidForm = $("#<portlet:namespace/>form1").parsley().isValid();
	 $("#<portlet:namespace/>checkProsegui").attr("data-parsley-required", !isValidForm);
	 
	 $("#<portlet:namespace/>form1").parsley().validate();
	
	 if(isValidForm) {
		$("#<portlet:namespace/>form1").submit();
	 }
}
var inputRadioDistance = document.getElementsByClassName('radio-distance');
function onCheckOptionInput(checkboxId) {
	
	if(checkboxId=="dichiaraz1") {
		if($("#dichiaraz1").is(":checked")){
			$("#<portlet:namespace/>inputDichRegolamentoAgile").attr("data-parsley-required", false);	
	   	}else{
	   		$("#<portlet:namespace/>inputDichRegolamentoAgile").attr("data-parsley-required", true);
		}
		$("#<portlet:namespace/>inputDichRegolamentoAgile").parsley().validate();
	}
	
	if(checkboxId=="dichiaraz6") {
		$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-dichiarazione-figli-parsley"/>.");
		if($("#dichiaraz6").is(":checked")){
			$("#figli_under13").prop("disabled", false);
			$("#figli_over13").prop("disabled", false);
			var parsleyNumFigliRequired = true;
			if($("#figli_under13").val()!="" && $("#figli_over13").val()!="" && (($("#figli_under13").val() + $("#figli_over13").val())>0) && $("#figli_under13").val()<100 && $("#figli_over13").val()<100){
				parsleyNumFigliRequired = false;
		    }
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", parsleyNumFigliRequired);
	   	}else{
	   		$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", false);
			$("#figli_under13").val("0");
			$("#figli_over13").val("0");
			$("#figli_under13").prop("disabled", true);
			$("#figli_over13").prop("disabled", true);
		}
		$("#<portlet:namespace/>inputNumFigliParsley").parsley().validate();
	}
	
	if(checkboxId=="dichiaraz7") {
		$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-dichiarazione-familiari-parsley"/>.");
		if($("#dichiaraz7").is(":checked")){
			$("#familiari").prop("disabled", false);
			var parsleyNumFamiliariRequired = true;
			if($("#familiari").val()!="" && $("#familiari").val()>0 && $("#familiari").val()<100){
				parsleyNumFamiliariRequired = false;
		    }
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required", parsleyNumFamiliariRequired);
	   	}else{
	   		$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required", false);
			$("#familiari").val("0");
			$("#familiari").prop("disabled", true);
		}
		$("#<portlet:namespace/>inputNumFamiliariParsley").parsley().validate();
	}
	
	if(checkboxId=="dichiaraz8") {
		var parsleyRadioRequired = true;
		if($("#dichiaraz8").is(":checked")){
			$(inputRadioDistance).attr("disabled", false);
			 for(var i=0; inputRadioDistance[i]; ++i){
		       if(inputRadioDistance[i].checked){
		    	   parsleyRadioRequired = false;
		    	   break;
		       }
			 }
			 $("#<portlet:namespace/>radioBtnDistanzaParsley").attr("data-parsley-required", parsleyRadioRequired);
		}else{
			$("#<portlet:namespace/>radioBtnDistanzaParsley").attr("data-parsley-required", false);
			$(inputRadioDistance).attr("checked", false); 
			$(inputRadioDistance).attr("disabled", true); 
		}
		$("#<portlet:namespace/>radioBtnDistanzaParsley").parsley().validate();
	}
	
}
$("#figli_under13").bind('keyup mouseup', function () {
	if($("#dichiaraz6").is(":checked")){
		if($("#figli_under13").val()!="" && $("#figli_over13").val()!="" && (($("#figli_under13").val() + $("#figli_over13").val())>0) && $("#figli_under13").val()<100 && $("#figli_over13").val()<100){
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", false);
		}else if($("#figli_under13").val()>99 || $("#figli_over13").val()>99){
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-javascript-valore-superiore-due-cifre"/>.");
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", true);
		}else if($("#figli_under13").val()<0 || $("#figli_over13").val()<0){
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-javascript-valore-negativo-non-valido"/>.");
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", true);
		}else{
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-dichiarazione-figli-parsley"/>.");
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", true);
		}
		$("#<portlet:namespace/>inputNumFigliParsley").parsley().validate();
	}
});
$("#figli_over13").bind('keyup mouseup', function () {
	if($("#dichiaraz6").is(":checked")){
		if($("#figli_under13").val()!="" && $("#figli_over13").val()!="" && (($("#figli_under13").val() + $("#figli_over13").val())>0) && $("#figli_under13").val()<100 && $("#figli_over13").val()<100){
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", false);
		}else if($("#figli_under13").val()>99 || $("#figli_over13").val()>99){
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-javascript-valore-superiore-due-cifre"/>.");
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", true);
		}else if($("#figli_under13").val()<0 || $("#figli_over13").val()<0){
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-javascript-valore-negativo-non-valido"/>.");
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", true);
		}else{
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-dichiarazione-figli-parsley"/>.");
			$("#<portlet:namespace/>inputNumFigliParsley").attr("data-parsley-required", true);
		}
		$("#<portlet:namespace/>inputNumFigliParsley").parsley().validate();
	}
});
$("#familiari").bind('keyup mouseup', function () {
	if($("#dichiaraz7").is(":checked")){
		if($("#familiari").val()!="" && $("#familiari").val()>0 && $("#familiari").val()<100){
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required", false);
		}else if($("#familiari").val()>99){
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-javascript-valore-superiore-due-cifre"/>.");
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required", true);
		}else if($("#familiari").val()<0){
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-javascript-valore-negativo-non-valido"/>.");
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required", true);
		}else{
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required-message","<liferay-ui:message key="form-dichiarazione-familiari-parsley"/>.");
			$("#<portlet:namespace/>inputNumFamiliariParsley").attr("data-parsley-required", true);
		}
		$("#<portlet:namespace/>inputNumFamiliariParsley").parsley().validate();
	}
});
function changeInputRadioDistance(){
	if($("#dichiaraz8").is(":checked")){
		for(var i=0; inputRadioDistance[i]; ++i){
	       if(inputRadioDistance[i].checked){
	    	   $("#<portlet:namespace/>radioBtnDistanzaParsley").attr("data-parsley-required", false);
	    	   break;
	       }
		}
		$("#<portlet:namespace/>radioBtnDistanzaParsley").parsley().validate();
	}
}
</script>