<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.intranet.mef.util.BeanCreator"%>

<%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
BeanCreator _creatorBean = new BeanCreator();
String titoloPrincipaleconvocanti=ParamUtil.getString(request, "titleConvocantiRiunione");
String titoloconvocanti=ParamUtil.getString(request, "subTitleConvocantiRiunione");
if(titoloPrincipaleconvocanti.isEmpty() && titoloconvocanti.isEmpty()){
	titoloPrincipaleconvocanti=(String)request.getAttribute("titleConvocantiRiunione");
	titoloconvocanti=(String)request.getAttribute("subTitleConvocantiRiunione");
}



String idRiunione = ParamUtil.getString(request, "idRiunione");

String previousPage = ParamUtil.getString(request, "previousPage");
if(request.getAttribute("previousPage")!=null){
	previousPage = (request.getAttribute("previousPage")).toString();
}


List<AmministrazioneConvocante> amministrazioni = new ArrayList<AmministrazioneConvocante>(0);
boolean amministrazione_size = false;

if(request.getAttribute("risultatiAdm")!=null){
	amministrazioni = (List<AmministrazioneConvocante>)request.getAttribute("risultatiAdm");
	amministrazione_size = false;
  
}else {
	amministrazioni = _creatorBean.getAmministrazioniConvocantiList();
}

/*amministrazioni.addAll(amministrazioni_ord);
Collections.sort(amministrazioni, new Comparator<AmministrazioneConvocante>() {				
	@Override
	public int compare(AmministrazioneConvocante o1, AmministrazioneConvocante o2) {
		return (o1.getNome_amministrazione().trim().toUpperCase().compareTo(o2.getNome_amministrazione().trim().toUpperCase()));
	}
});
*/


//Pagination

int itemsdelta=0;

if (itemsPerPage.isEmpty()){
	itemsPerPage="5";
}
if (Integer.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta=Integer.valueOf(itemsPerPage);	
}
String keywordCercato = "";
if(request.getAttribute("keywordCercato")!=null)
{
keywordCercato = (String) request.getAttribute("keywordCercato");
}	
%>

<c:set value="<%=previousPage %>" var="previousPage"></c:set>
<c:set value="<%=idRiunione %>" var="idRiunione"></c:set>



<portlet:actionURL name="aggiungiConvocante" var="aggiungiConvocanteURL"></portlet:actionURL>


                            <portlet:actionURL name="rimuoviConvocante" var="rimuoviConvocanteUrl"></portlet:actionURL>

<div class="gestione-riunioni-title-box">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper">
                        <h2 class="title"><%=titoloPrincipaleconvocanti %></h2>
                        <p class="subtitle"><%=titoloconvocanti%></p>
                        <div class="wrapper-content-summoned">
						<form id="convocanteForm" class="form-add-field-gestione-riunioni" action="<%=aggiungiConvocanteURL%>" method="post" enctype="multipart/form-data" data-parsley-validate="true">
                            <input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}" />   
                            <input type="hidden" name="<portlet:namespace/>previousPage" value="${previousPage}" />  
                            <input data-parsley-required="true" data-parsley-maxlength="250"
							data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"250\"}%>"/>'

						data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
 							type="text" class="form-control input-summoned data-parsley-validated" id="text" placeholder="<liferay-ui:message key="gestione-riunione-convocanti-aggiungi-placeholder"/>" name="<portlet:namespace/>Convocante">
                            <button type="button" class="button-summoned" onclick="checkParsleyBeforeSubmit()">
                                <span class="icomoon-plus icon-plus" href="#"></span>
                            </button>
                        </form>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </div>    
<div class="gestione-riunioni-wrapper">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="tab-filtri filtro-categoria">
                    <div class="filtro-tabs-wrapper top-paginator-scroll">
                    <c:if test="<%=amministrazioni!=null && amministrazioni.size()>0 && request.getAttribute("risultatiAdm")==null%>">
                        <span class="tab-title active"><liferay-ui:message key="gestione-riunione-convocanti-tutti"/></span>
                    </c:if>
                    </div>
                    <div class="filtro-body-box">
                        <div class="tab-filtri filtro-categoria">
                            <div class="text-search-wrap">
                            <portlet:actionURL name="ricercaAmministrazioneConvocante" var="ricercaAmministrazioneConvocanteUrl"></portlet:actionURL>
							<form action="<%=ricercaAmministrazioneConvocanteUrl%>" id="ricercaConvocanteForm" method="post" enctype="multipart/form-data">
							     <input type="hidden" id="chiave_hidden" name="<portlet:namespace/>chiave_hidden" value="<%=keywordCercato%>" />  
                                 <input  type="text" id="parola_chiave" class="text-search" placeholder='<liferay-ui:message key="gestione-riunione-convocanti-parola-chiave-placeholder"/>' name="<portlet:namespace/>Keyword"/>  
                                 <input type="hidden" name="<portlet:namespace/>previousPage" value="<%=previousPage%>"/>  
                                 <input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}"/>  
                                 <span class="icomoon-search" id="ricercaConvocanteSpan"></span>
								 </form>
                            </div>
                        </div>
                    </div>
                    
                </div>

                <div class="js-list-pagination">
                
					<c:if test="<%=amministrazioni!=null %>">
                        <c:forEach items="<%=amministrazioni%>" var="amministrazioneC">
                        <div class="wrapper-management-summoned">
								<div class="div-container">
									<div class="text-div text-label">
										${amministrazioneC.getNome_amministrazione().toUpperCase()}</div>
									<div class="text-div text-number">
										<p class="id-number">
											<liferay-ui:message key="gestione-riunione-convocanti-id" />
											:
										</p>
										&nbsp;${amministrazioneC.getId_amministrazione_convocante()}
									</div>


									<div class="text-div delete-meeting">
										<a href="" title="elimina convocante"
											class="icomoon-trash1 meeting-icon" data-toggle="modal"
											data-target="#modal-elimina${amministrazioneC.getId_amministrazione_convocante()}"
											aria-label="elimina convocante"></a>
									</div>



								</div>
							</div>
					   <form action="<%=rimuoviConvocanteUrl%>" id="deleteConvocante${amministrazioneC.getId_amministrazione_convocante()}" method="post" enctype="multipart/form-data">
							<input type="hidden" name="<portlet:namespace/>convocante" value="${amministrazioneC.getId_amministrazione_convocante()}">
							<input type="hidden" name="<portlet:namespace/>previousPage" value="<%=previousPage%>">
							<input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}"/>  
						</form>
	
					   
					   <div id="modal-elimina${amministrazioneC.getId_amministrazione_convocante()}"
										class="modal modal-custom fade modal-elimina" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<div class="modal-title-box">
														<a href="#" class="icomoon-close-white"
															data-dismiss="modal"></a>
														<div class="title-modal">
															<h2 class="title">
																<liferay-ui:message	key="gestione-riunione-modale-elimina-ammconv-title" />
															</h2>
														</div>
													</div>
													<span class="icomoon-trash"></span>
													<h2 class="riunione-name">${amministrazioneC.getNome_amministrazione().toUpperCase()}</h2>
													<div class="ama-row mb-50-xs buttons-bottom">
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button class="button button-secondary"
																data-dismiss="modal">
																<liferay-ui:message
																	key="gestione-riunione-modale-annulla" />
															</button>
														</div>
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button id="elimina${amministrazioneC.getId_amministrazione_convocante()}"
																type="button" class="button button-primary">
																<liferay-ui:message
																	key="gestione-riunione-modale-elimina" />
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>	
					   <script>
	        							$("#elimina"+${amministrazioneC.getId_amministrazione_convocante()}).click(function(){
		        							$("#deleteConvocante"+${amministrazioneC.getId_amministrazione_convocante()}).submit();
		        							$("#modal-elimina"+${amministrazioneC.getId_amministrazione_convocante()}).modal("hide");
 										});
	        						</script>
					   
                       </c:forEach>
                
                       </c:if>

                   <div class="ama-row">
                        <div class="ama-col-xs-12 text-align-center">
                            <div data-totpage="<%=itemsdelta%>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                                <div class="btn-back-arrow disabled">
                                    <a href="#" title='<liferay-ui:message key="gestione-riunione-convocanti-pagina-precedente-title"/>'>
                                        <em class="icomoon-arrow"></em>
                                    </a>
                                </div>
                                <ul class="pagination-numbers">
                                    
                                </ul>
                                <div class="btn-forward-arrow">
                                    <a href="#" >
                                        <em class="icomoon-arrow">
                                        </em>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="style-button-management-summoned">
				<portlet:actionURL name="paginaPrecedente" var="paginaPrecedenteUrl">
				 
				 </portlet:actionURL>

				<form action="<%=paginaPrecedenteUrl%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}" />   
					<input type="hidden" name="<portlet:namespace/>previousPage" value="${previousPage}" /> 
                	<button class="button button-primary"><liferay-ui:message key="gestione-riunione-convocanti-pagina-precedente"/></button>
                <form>

                </div>
            </div>
        </div>
    </div>

	
	
</div>
<script type="text/javascript">




var chiave =$('#chiave_hidden').val();
if(chiave != null)
	{
	
	$('#parola_chiave').val(chiave);
	}
	
	
	function checkParsleyBeforeSubmit(){
		$("#convocanteForm").parsley().validate();
		if ($("#convocanteForm").parsley().isValid()){
			$("#convocanteForm").submit();
		}
		
	}
	$("#ricercaConvocanteSpan").on("click", function() {
		$("#ricercaConvocanteForm").submit();
	});
</script>
