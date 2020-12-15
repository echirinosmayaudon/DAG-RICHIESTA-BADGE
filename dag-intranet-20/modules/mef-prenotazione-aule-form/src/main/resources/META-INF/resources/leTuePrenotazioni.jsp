<%@page import="mef.prenotazione.aule.bean.LaTuaPrenotazioneBean" %>
<%@page import="java.util.List"%>

<portlet:actionURL name="eliminaPrenotazione" var="eliminaPrenotazione"/>
<portlet:actionURL name="modificaPrenotazione" var="modificaPrenotazione"/>
<portlet:actionURL name="vaiPaginaRicerca" var="vaiPaginaRicerca" />
<portlet:actionURL name="vaiPaginaRicerca" var="vaiPaginadettaglio" />
<portlet:actionURL var="vaiALeTuePrenotazioniUrl" name="vaiALeTuePrenotazioni"/>
<portlet:actionURL var="requestForApprovalUrl" name="requestForApproval"/>
<%
List<LaTuaPrenotazioneBean> listLeTuePrenotazione = (List<LaTuaPrenotazioneBean>) request.getAttribute("listLeTuePrenotazione");
List<LaTuaPrenotazioneBean> listLePrenotazioniInAttessaApprovazione = (List<LaTuaPrenotazioneBean>) request.getAttribute("listLePrenotazioniInAttessaApprovazione");
%>

<div class="trasporti-header">
	<div class="ama-container-fluid">
    	<div class="ama-row">
        	<div class="ama-col-xs-12">
            	<div class="title-wrapper">
                	<c:if test="${listaPrenotazioni!=null}">
                    	<h2 class="title"><%=formTitleLeTuePrenotazioni%></h2>
                    </c:if>
					<c:if test="${listaApprovazioni!=null}">
                         <h2 class="title"><%=formTitleRicercaAuleApprovatore%></h2>
                    </c:if> 
                    <div class="wrap-icon-title mobile-search form-inline-wrap">
                    	<form action="<%=vaiPaginaRicerca%>" method="post">
                       		<button class="button-xs button button-primary mr-10-xs">
                       			<span class="icomoon-plus icon-beni"></span>
                       			<liferay-ui:message key="prenotazione-tue-prenotazione-prenota-sala"/>
                       		</button>
                       	</form>
						<c:if test="${listaPrenotazioni!=null && approvatore==true}">
                         	<form action="<%=requestForApprovalUrl%>" method="post">
	                         	<div class="wrap-icon-title mt-5-md">
	                            	<a href="<%=requestForApprovalUrl%>" title="Sale in attesa di approvazione" class="icon icomoon-prenota-approvata"></a>
	                         	</div>
                         	</form>
                        </c:if>
						<c:if test="${listaApprovazioni!=null}">
	                         <form action="<%=vaiALeTuePrenotazioniUrl%>" method="post">
		                         <div class="wrap-icon-title mt-5-md">
		                             <a href="<%=vaiALeTuePrenotazioniUrl%>" title="Sale Prenotate" class="icon icomoon-user2"></a>
		                         </div>
	                         </form>
                         </c:if>
                   	</div>
					<c:if test="${listaPrenotazioni!=null}">
                    	<p class="subtitle dot-point dot-200"><%=formSubtitleLeTuePrenotazioni%></p>
                     </c:if>
					 <c:if test="${listaApprovazioni!=null}">
                    	 <p class="subtitle dot-point dot-200"><%=formSubtitleRicercaAuleApprovatore%></p>
					 </c:if>
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
                    	<c:if test="${listaPrenotazioni!=null}">
                            <span class="tab-title active"><liferay-ui:message key="prenotazione-tue-prenotazione-elenco-sale-prenotate"/></span>
                        </c:if>
                        <c:if test="${listaApprovazioni!=null}">
                        	<span class="tab-title active"><liferay-ui:message key="prenotazione-tue-prenotazione-elenco-sale-da-approvare"/></span>
                        </c:if>
                     </div>
	                     <div id="filtro-modulistica">
	                     	<div class="filtro-body-box">
	                        	<div class="wrap-aule-filter">
	                            	<p class="filter-aule">
	                                	<c:if test="${listaPrenotazioni!=null}">
	                                         <span class="filter-bold">${listLeTuePrenotazioneSize}</span>
	                                     </c:if>
	                                     <c:if test="${listaApprovazioni!=null}">
	                                         <span class="filter-bold">${listSize}</span>
	                                     </c:if>
	                                     <liferay-ui:message key="prenotazione-tue-prenotazione-numero-sale"/>
	                                 </p>
	                             </div>
	                            </div>
	                            <c:choose>
	                            	<c:when test="${listaPrenotazioni!=null}">
	                              		<c:forEach items="${listLeTuePrenotazione}" var="listTuePrenotazione">
	                               			<form action="<%=modificaPrenotazione%>" id="formModifica${listTuePrenotazione.getIdPrenotazione()}" method="post">
	                              				<input type="hidden" value="${listTuePrenotazione.getIdPrenotazione()}" name="<portlet:namespace/>idPrenotazione"/>
	                               			</form>
				                            <form action="<%=eliminaPrenotazione%>" method="post" id="formElimina${listTuePrenotazione.getIdPrenotazione()}"> 
				                            	<input type="hidden" value="${listTuePrenotazione.getIdPrenotazione()}" name="<portlet:namespace/>idPrenotazione"/> 
				                            </form>
	                               			<div class="modulistica-wrapper">
	                                 			<div class="ama-row">
	                                     			<div class="ama-col-xs-12">
			                                        	<div class="wrapper-servizi-aule item-pagination">
			                                         		<form action="<%=vaiPaginadettaglio%>" method="post" id="<portlet:namespace/>formDettaglioPrenotazioni${listTuePrenotazione.getIdPrenotazione()}">
			                                         		<input type="hidden" value="${listTuePrenotazione.getIdPrenotazione()}" name="<portlet:namespace/>idPrenotazione"/>
			                                           		<input type="hidden" value="dettaglio" name="<portlet:namespace/>dettaglio"/>
	                                         				<div class="box-aule mt-30-xs text-center">
	                                                 			<div class="ama-row">
	                                                     			<div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-12 border-right">
	                                                         			<p class="reservations">
	                                                            			<span class="ico-reservations icomoon-calendar-date mr-10-xs"></span>
	                                                             				${listTuePrenotazione.getDataPrenotazione()}
	                                                         			</p>
	                                                     			</div>
	                                                     			<div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-12 mb-30-xs mb-0-md border-right">
	                                                        			<p class="reservations">
	                                                             		<span class="ico-reservations icomoon-time mr-10-xs"></span>
	                                                             			${listTuePrenotazione.getOrario()}
	                                                         			</p>
	                                                     			</div>
	                                                     			<div class="ama-col-md-5 ama-col-sm-12 ama-col-xs-12 border-right">
	                                                         			<div class="wrap-classrooms mb-30-xs mb-0-md">
				                                                             <a href="<%=vaiPaginadettaglio%>" title="vai a ${listTuePrenotazione.getNomeSalaRiunione()}" onclick="submitFormDettaglioPrenotazioni(event,${listTuePrenotazione.getIdPrenotazione()})">
					                                                             <p class="position-classrooms">${listTuePrenotazione.getNomeSalaRiunione().toUpperCase()}</p>
					                                                             <p class="text-box"><span class="ico icomoon-pin-white-bold"></span>${listTuePrenotazione.getIndirizzo().toUpperCase()}</p>
				                                                             </a>
	                                                         			</div>
	                                                     			</div>
	                                                     			<div class="ama-col-md-1 ama-col-xs-6 border-right">
		                                                        		<span class="icon icomoon-posti"></span>
		                                                         		<p class="number-posti">${listTuePrenotazione.getPostiInSala()}&nbsp;<liferay-ui:message key="prenotazione-tue-prenotazione-numero-posti"/></p>
	                                                     			</div>
	                                                     			<div class="ama-col-md-1 ama-col-xs-6">
				                                                        <c:if test='${listTuePrenotazione.getStato().equalsIgnoreCase("prenotata")}'>    
				                                                         	<span class="icon-violet icomoon-lock"></span>
				                                                        </c:if>
				                                                        <c:if test='${listTuePrenotazione.getStato().equalsIgnoreCase("da approvare")}'>
				                                 							<span class="icon-violet icomoon-hourglass"></span>
				                                         				</c:if>
				                                         				<c:if test='${listTuePrenotazione.getStato().equalsIgnoreCase("rifiutata")}'>
				                                 							<span class="icon-violet icomoon-cancel"></span>
				                                         				</c:if>
				                                                        <p class="type">${listTuePrenotazione.getStato().toUpperCase()}</p>
	                                                     			</div>
	                                                     			<c:if test='${!listTuePrenotazione.getStato().equalsIgnoreCase("rifiutata")}'>
																	<div class="ama-col-md-1 ama-col-xs-12 mt-20-xs mt-0-md">
								                                    	<c:if test="${listTuePrenotazione.getIdAutorizzazione() == 0}">
								                                       		<button name="edit" value="edit" type="button" class="icomoon-edi ico-tue-prenotazioni mr-20-xs mr-60-sm mr-0-md" id="btnModifica${listTuePrenotazione.getIdPrenotazione()}" onclick="vaiAModifica(event, this.id)"></button>
								                                        </c:if>
								                                        	<input type="hidden" value="${listTuePrenotazione.getIdPrenotazione()}" name="<portlet:namespace/>idPrenotazione"/>
								                                            <button name="close" value="close" type="button" class="icomoon-close-white ico-tue-prenotazioni" data-toggle="modal" data-target="#modal-delete-prenotazione-aule${listTuePrenotazione.getIdPrenotazione()}"></button>
	                                                   				</div>
	                                                   				</c:if>
	                                                 			</div>				                                         
																<div id="modal-delete-prenotazione-aule${listTuePrenotazione.getIdPrenotazione()}" class="modal modal-custom fade modal-icon-page" role="dialog"> 
	                                                 				<div class="modal-dialog"> 
				                                                     	<div class="modal-content"> 
				                                                        	<div class="modal-body"> 
				                                                            	<div class="modal-title-box"> 
				                                                                 	<a href="#" class="icomoon-close-white" data-dismiss="modal"></a> 
				             															<div class="title-modal"> 
				                                                                      		<h2 class="title"><liferay-ui:message key="prenotazione-tue-prenotazione-confermi-eliminare-prenotazione"/> </h2> 
				                                                                 		</div> 
				                                                             	 </div> 
																			    	<h2 class="text"><liferay-ui:message key="prenotazione-tue-prenotazione-non-visualizzare-prenotazione"/>  </h2> 
	                                             
	                                                              <div class="ama-row mb-50-xs buttons-bottom"> 
	                                                                  <div class="ama-col-xs-12 ama-col-sm-6"> 
	                                                                      <button class="button button-secondary" data-dismiss="modal"><liferay-ui:message key="prenotazione-tue-prenotazione-annulla"/></button> 
	                                                                 </div> 
	                                                                  <div class="ama-col-xs-12 ama-col-sm-6"> 
	                                                    				   <button type="button" class="button button-primary" name="<portlet:namespace/>buttonLeTuePrenotazione" id="btnElimina${listTuePrenotazione.getIdPrenotazione()}" onclick="eliminaPrenotazione(event, this.id)"><liferay-ui:message key="prenotazione-tue-prenotazione-eliminare-prenotazione"/> 
	
																		</button> 
	 																														   
	                                                                 </div>
	                                                              </div> 
	                                                          </div> 
	                                                     </div> 
	                                                  </div> 
	                                              </div>                                      
	                                      
	                                       </div>
	                                       </form>
	                                       </div>
	                                          </div>
	                                	 </div>
	                               </div>
	                     
	                          			</c:forEach>
	                          		</c:when>
	                          		<c:when test="${listaApprovazioni!=null}">
	                          			<c:forEach items="${listLePrenotazioniInAttessaApprovazione}" var="listInAttessaApprovazione">
	                          				<div class="modulistica-wrapper">
	                                 			<div class="ama-row">
	                                     			<div class="ama-col-xs-12">
	                                         			<div class="wrapper-servizi-aule item-pagination">
	                                             			<form action="<%=vaiPaginadettaglio%>" method="post" id="<portlet:namespace/>formDettaglio${listInAttessaApprovazione.getIdPrenotazione()}">
					                                             <input type="hidden" value="${listInAttessaApprovazione.getIdPrenotazione()}" name="<portlet:namespace/>idPrenotazione"/>
					                                             <input type="hidden" value="dettaglio" name="<portlet:namespace/>dettaglio"/>
					                                             <div class="box-aule mt-30-xs text-center">
	                                           						<div class="ama-row">
	                                                    				<div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-12 border-right">
					                                                         <p class="reservations">
					                                                             <span class="ico-reservations icomoon-calendar-date mr-10-xs"></span>
					                                                             ${listInAttessaApprovazione.getDataPrenotazione()}
					                                                         </p>
	                                                     				</div>
	                                                     				<div class="ama-col-md-2 ama-col-sm-6 ama-col-xs-12 mb-30-xs mb-0-md border-right">
					                                                         <p class="reservations">
					                                                             <span class="ico-reservations icomoon-time mr-10-xs"></span>
					                                                             ${listInAttessaApprovazione.getOrario()}
					                                                         </p>
	                                                     				</div>
					                                                     <div class="ama-col-md-5 ama-col-sm-12 ama-col-xs-12 border-right">
					                                                         <div class="wrap-classrooms mb-30-xs mb-0-md">
					                                                         <a href="<%=vaiPaginadettaglio%>" title="vai a ${listInAttessaApprovazione.getNomeSalaRiunione()}" onclick="submitFormDettaglio(event,${listInAttessaApprovazione.getIdPrenotazione()})">
					                                                             <p class="position-classrooms">${listInAttessaApprovazione.getNomeSalaRiunione().toUpperCase()}</p>
					                                                             <p class="text-box"><span class="ico icomoon-pin-white-bold"></span>${listInAttessaApprovazione.getIndirizzo().toUpperCase()}</p>
					                                                         </a>
					                                                         </div>
					                                                     </div>
					                                                     <div class="ama-col-md-1 ama-col-xs-6 border-right">
					                                                         <span class="icon icomoon-posti"></span>
					                                                         <p class="number-posti">${listInAttessaApprovazione.getPostiInSala()}&nbsp;<liferay-ui:message key="prenotazione-tue-prenotazione-numero-posti"/></p>
					                                                     </div>
					                                                     <div class="ama-col-md-1 ama-col-xs-6">
					                                                        
					                                 						<span class="icon-violet icomoon-hourglass"></span>
					                                         				  
					                                                         	<p class="type">${listInAttessaApprovazione.getStato().toUpperCase()}</p>
					                                                     </div>
	                                                 </div>
	                                                 </div>
	                                                 		</form>
	                                                	</div>
		                                     		</div>
	                                	 		</div>
	                               			</div>
	                        
	                          			</c:forEach>
	                          		</c:when>
	                          </c:choose>
	                          
	                          	<c:if test="${listSize == 0}">
	                          		<liferay-ui:message key="prenotazione-tue-prenotazione-nessuna-prenotazione-da-approvare"/>
	                          	</c:if>
	                          	<c:if test="${listLeTuePrenotazioneSize == 0}">
	                          		<liferay-ui:message key="prenotazione-tue-prenotazione-nessuna-prenotazione"/>
	                          </c:if>  
	                    </div>
                </div>
            </div>
        </div>
    </div>
         
<script>
	function vaiAModifica(event, elem) {
		event.preventDefault();
		event.stopPropagation();
	    var id = elem;
	    var numeroId = id.split("btnModifica").pop();
		$('#formModifica'+numeroId).submit();
	}
	
	function eliminaPrenotazione(event,elem){
		event.preventDefault();
		event.stopPropagation();
		var id = elem;
		var numeroId = id.split("btnElimina").pop();
		$('#formElimina'+numeroId).submit();
	}
	
	function submitFormDettaglio(event,index){
		event.preventDefault();
		$('#<portlet:namespace/>formDettaglio'+index).submit();	
	}
	
	function submitFormDettaglioPrenotazioni(event,index){
		event.preventDefault();
		$('#<portlet:namespace/>formDettaglioPrenotazioni'+index).submit();	
	}
</script>         
         