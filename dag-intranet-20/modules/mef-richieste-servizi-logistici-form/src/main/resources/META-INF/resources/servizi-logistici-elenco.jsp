<%@page import="service.intranet.mef.model.LogisticaRichieste"%>
<%@page import="service.intranet.mef.service.LogisticaRichiesteLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
 
<%
List<LogisticaRichieste> listaRichieste = (List<LogisticaRichieste>) request.getAttribute("listarichieste");
int itemsdelta=0;

if (Integer.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta=Integer.valueOf(itemsPerPage);	
}
%>

<c:set value="<%=listaRichieste%>" var="listaRichieste"></c:set>

     <div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=serviziLogisticiElencotitle%>
                         </h2>
                         <p class="subtitle dot-point dot-200"><%=serviziLogisticiElencotxt%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>
     <div class="ama-container-fluid">
         <div class="ama-row">
             <div class="ama-col-md-12">
                 <div class="wrapper-title-small">
                     <h2 class="title-box borders"><liferay-ui:message key="servizi-logistici-richieste-elenco" />
                         <div class="wrap-person-title-small">
                             <p class="span-person">
                                 <span class="bold-span"><%=listaRichieste.size()%></span>
                                 <liferay-ui:message key="servizi-logistici-richieste-risulanti" />
                             </p>
                         </div>
                     </h2>
                 </div>
             </div>
         </div>
  
         <div class="js-list-pagination">
         
             <div class="ama-row">
             
                <c:forEach items="${listarichieste}" var="richiesta"> 
                
                <portlet:actionURL name="detailRichiesta" var="detailRichiestaURL">
                	<portlet:param name="richiestaId" value="${richiesta.getId()}" />	
                </portlet:actionURL>
                
                 <div class="ama-col-lg-3 ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                     <div class="item-pagination animated fadeIn">
                         <div class="wrapper-servizi-logistici mb-30-xs">
                             <a href="<%=detailRichiestaURL%>" title="" class="wrapper-box-beni">
                                 <div class="header-white">
                                 <c:if test='${richiesta.getId_stato()== 1}'>
                                     <span class="icon-header mb-10-xs icomoon-file"></span>
                                 </c:if> 
                                  <c:if test='${richiesta.getId_stato()== 2}'>
                                     <span class="icon-header mb-10-xs icomoon-success-blu"></span>
                                 </c:if> 
                                  <c:if test='${richiesta.getId_stato()== 3}'>
                                     <span class="icon-header mb-10-xs icomoon-cancel"></span>
                                 </c:if>
                                  <c:if test='${richiesta.getId_stato()== 4}'>
                                     <span class="icon-header mb-10-xs icomoon-cart"></span>
                                 </c:if> 
                                  <c:if test='${richiesta.getId_stato()== 5}'>
                                     <span class="icon-header mb-10-xs icomoon-cart-2"></span>
                                 </c:if>     
                                     <p class="information"><liferay-ui:message key="servizi-logistici-dettaglio-id" />:
                                         <span class="number-id">${richiesta.getId()}</span>
                                     </p>
                                     <p class="information dot-point dot-40 dot-mobile">${richiesta.getOggetto()}</p>
                                 </div>
                                 <div class="footer-blue">
                                     <span class="icon-footer icomoon-calendar-date mr-10-xs"></span>
                                     <p class="display-in-bl"> <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${richiesta.getData_richiesta()}" /></p>
                                 </div>
                             </a>
                         </div>
                     </div>
                 </div>                                      
               </c:forEach>                    
                                            
             </div>

             <div class="ama-row">
                 <div class="ama-col-xs-12 text-align-center">
                     <div data-totpage="<%=itemsdelta%>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                         <div class="btn-back-arrow disabled">
                             <a href="" title="Pagina precedente">
                                 <em class="icomoon-arrow"></em>
                             </a>
                         </div>
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
             </div>         </div>

     </div>

