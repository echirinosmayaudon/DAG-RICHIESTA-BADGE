<%@page import="com.mef.intranet.bean.RisultatoListaRichieste"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%List<RisultatoListaRichieste>  listaRichieste = (List<RisultatoListaRichieste>) request.getAttribute("listarichieste");
int itemsdelta=0;
if (Integer.valueOf(itemsPerPage) > 0 ) { itemsdelta=Integer.valueOf(itemsPerPage);}
%>
<c:set value="<%=listaRichieste%>" var="listaRichieste"></c:set>
<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=listaTitle%></h2>
                             <div class="wrap-icon-title mt-30-xs mt-0-md form-inline-wrap">
                                 <form action="<%=vaiAInserimento%>" method="post">
                                 <button href="<%=vaiAInserimento%>" type="button" class="button-xs button button-primary mr-10-xs" onclick="this.form.submit()">NUOVA RICHIESTA
                                     <span class="icomoon-plus icon-beni"></span>
                                 </button>
                                 </form>
                                 <c:if test="${dirigenteRole}">
                                      <a href="<%=vaiAGestioneUtenti%>" title="<liferay-ui:message key="beni-facile-consumo-gestione-utenti-tooltip"/>"  class="icon icomoon-profile"></a>
                                  </c:if> 
                                  <c:if test="${delegatoRole || dirigenteRole}">
                                  	  <a href="<%=vaiARicerca%>" title="<liferay-ui:message key="beni-facile-consumo-ricerca-tooltip"/>" class="icon icomoon-search-richiesta "></a>
                                 </c:if>
                             </div>
     
                         <p class="subtitle dot-point dot-200"><%=listaSubtitle%></p>
                     </div></div></div></div> </div>
     <div class="ama-container-fluid">
         
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders"><liferay-ui:message key="beni-facile-consumo-elenco-utente-richieste"/></h2>
                    </div>
                </div>
            </div>
         <div class="js-list-pagination">
            <div class="ama-row">
   <c:forEach items="${listarichieste}" var="richiesta"> 
			 <portlet:actionURL name="vaiADettaglio" var="vaiADettaglio">
                	<portlet:param name="richiestaId" value="${richiesta.getId()}" />	
                    <portlet:param name="statoRichiesta" value="${richiesta.getStato()}" />	
                </portlet:actionURL>
                 <div class="ama-col-lg-3 ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                     <div class="item-pagination">
                         <div class="wrappper-beni-consumo-component mb-30-xs">
                             <a href="<%=vaiADettaglio%>" title="" class="wrapper-box-beni">
                                 <div class="header-white">
                                   <p class="text-new mb-20-xs">
                                   <c:if test="${richiesta.getStato() ==  'in approvazione'}">
										  <span class="ico-new icomoon-in-approvazione"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'non approvata'}">
										  <span class="ico-new icomoon-non-approvata"></span>
									</c:if>
                                    <c:if test="${richiesta.getStato() ==  'nuova'}">
										  <span class="ico-new icomoon-file"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'accettata'}">
										<span class="ico-new icomoon-success-blu"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'rifiutata'}">
										  <span class="ico-new icomoon-cancel"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'evasa'}">
										 <span class="ico-new icomoon-cart"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'non evasa'}">
										  <span class="ico-new icomoon-cart-2"></span>
									</c:if>
									<c:if test="${richiesta.getStato() ==  'consegnata'}">
										 <span class="ico-new icomoon-cart-3"></span>
									</c:if>
									${richiesta.getStato().toUpperCase()}
                              </p>
                                <p class="name dot-point dot-60 dot-mobile name-new"> ${richiesta.getNome()} ${richiesta.getCognome()}</p>                 
                                 </div>
                                 <div class="footer-blue">
                                     <span class="icon-footer icomoon-calendar-date"></span>
                                     <p class="display-in-bl mr-30-xs"> <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${richiesta.getData()}" /></p>                     
                                     <span class="icon-footer icomoon-time"></span>
                                     <p class="display-in-bl"> <fmt:formatDate type = "time"  pattern="HH:mm"   value = "${richiesta.getData()}" /></p>   
                                 </div>
                             </a></div></div></div>
     </c:forEach>  
      </div>
             <div class="ama-row">
                 <div class="ama-col-xs-12 text-align-center">
                     <div data-totpage="<%=itemsdelta%>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                         <div class="btn-back-arrow disabled">
                             <a href="" title="Pagina precedente">
                                 <em class="icomoon-arrow"></em>
                             </a></div>
                         <ul class="pagination-numbers">
                             <li class="current-page"><a title="Vai a pagina" href="">1</a></li>
                             <li><a title="Vai a pagina" href="">2</a></li>
                         </ul>
                         <div class="btn-forward-arrow">
                             <a href="" title="Pagina successiva">
                                 <em class="icomoon-arrow">
                                     <span class=""></span>
                                 </em>
                             </a>
                         </div>
                     </div>
                 </div>
             </div> </div> </div>