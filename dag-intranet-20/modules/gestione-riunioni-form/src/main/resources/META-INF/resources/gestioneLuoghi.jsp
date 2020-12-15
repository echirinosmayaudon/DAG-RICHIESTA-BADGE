<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Luogo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.intranet.mef.util.BeanCreator"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
BeanCreator _creatorBean = new BeanCreator();
String titoloPrincipaleluoghi=ParamUtil.getString(request, "titleLuoghiRiunione");
String titololuoghi=ParamUtil.getString(request, "subTitleLuoghiRiunione");
if(titoloPrincipaleluoghi.isEmpty() && titololuoghi.isEmpty()){
	titoloPrincipaleluoghi=(String)request.getAttribute("titleLuoghiRiunione");
	titololuoghi=(String)request.getAttribute("subTitleLuoghiRiunione");
}


String idRiunione = ParamUtil.getString(request, "idRiunione");

String previousPage = ParamUtil.getString(request, "previousPage");
if(request.getAttribute("previousPage")!=null){
	previousPage = (request.getAttribute("previousPage")).toString();
}

List<Luogo> luoghi = new ArrayList<Luogo>(0);
int luoghi_size = 0;

if(request.getAttribute("risultatiLuogo")!=null){
	luoghi=(List<Luogo>)request.getAttribute("risultatiLuogo");
	luoghi_size = luoghi.size(); 

}
else {
	luoghi = _creatorBean.getLuoghiList();
}

/*luoghi.addAll(luoghi_ord);
Collections.sort(luoghi, new Comparator<Luogo>() {				
	@Override
	public int compare(Luogo o1, Luogo o2) {
		return (o1.getNome().trim().toUpperCase().compareTo(o2.getNome().trim().toUpperCase()));
	}
});



/*int itemsdelta=0;
if (itemsPerPage.isEmpty()){
	itemsPerPage="5";
}
if (Integer.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta=Integer.valueOf(itemsPerPage);	
}*/

String keywordCercato = "";
if(request.getAttribute("keywordCercato") != null){
	keywordCercato = (String) request.getAttribute("keywordCercato");
}


%>

<c:set value="<%=previousPage %>" var="previousPage"></c:set>
<c:set value="<%=idRiunione %>" var="idRiunione"></c:set>

<!--<h1>GESTIONE LUOGHI</h1> <br>  -->


<portlet:actionURL name="aggiungiLuogo" var="aggiungiLuogoURL"></portlet:actionURL>

<portlet:actionURL name="rimuoviLuogo" var="rimuoviLuogoUrl"></portlet:actionURL>

    <div class="gestione-riunioni-title-box">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper">
                     <h2 class="title"><%=titoloPrincipaleluoghi%></h2>
                        <p class="subtitle"><%=titololuoghi%></p>
                        <div class="wrapper-content-summoned">
                           <form id="luogoForm" class="form-add-field-gestione-riunioni" action="<%=aggiungiLuogoURL%>" method="post" data-parsley-validate="true" enctype="multipart/form-data">
								<input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}" />   
								<input type="hidden" name="<portlet:namespace/>previousPage" value="${previousPage}" />  
								<input data-parsley-required="true" data-parsley-maxlength="250"
								data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"250\"}%>"/>'
						data-parsley-required-message='<liferay-ui:message key="error-mandatory"/>'
									type="text" class="form-control input-summoned data-parsley-validated" id="text" 
									placeholder='<liferay-ui:message key="gestione-riunione-luoghi-aggiungi-placeholder"/>' 
									name="<portlet:namespace/>Luogo">
								<button class="button-summoned" type="button" onclick="checkParsleyBeforeSubmit()">
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
                    <div class="filtro-tabs-wrapper">
                     <c:if test="<%=luoghi!=null && luoghi.size()>0 && request.getAttribute("risultatiLuogo")==null%>">
                        <span class="tab-title active"><liferay-ui:message key="gestione-riunione-luoghi-tutti"/></span>
                    </c:if>
                    </div>
                    <div class="filtro-body-box">
                        <div class="tab-filtri filtro-categoria">
                            <div class="text-search-wrap">
						<portlet:actionURL name="ricercaLuogo" var="ricercaLuogoUrl"></portlet:actionURL>
						<form action="<%=ricercaLuogoUrl%>" id="ricercaLuogoForm" method="post" enctype="multipart/form-data">
							
							<input type="hidden" id ="chiave_hidden" value="<%=keywordCercato%>"/>  
							<input  type="text" id="parola_chiave" class="text-search" placeholder='<liferay-ui:message key="gestione-riunione-luoghi-parola-chiave-placeholder"/>' name="<portlet:namespace/>Keyword"/>  
                            <input type="hidden" name="<portlet:namespace/>previousPage" value="<%=previousPage%>"/>  
                            <input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}" />  
                                 <span class="icomoon-search" id="ricercaLuogoSpan"></span>
                            </form>
                            </div>
							
                        </div>
                    </div>
                    
                </div>

                <div class="js-list-pagination">
                
					<c:if test="<%=luoghi!=null %>">
                     <c:forEach items="<%=luoghi%>" var="luogoR">
                     <div class="wrapper-management-summoned">
                    <div class="div-container">
                        <div class="text-div text-label">
                            ${luogoR.getNome().toUpperCase()}
                        </div>
                        <div class="text-div text-number">
                            <p class="id-number"><liferay-ui:message key="gestione-riunione-luoghi-id"/>:</p>&nbsp;${luogoR.getId_luogo()}
                        </div>

									<div class="text-div delete-meeting">
										<a href="" title="elimina luogo"
											class="icomoon-trash1 meeting-icon" data-toggle="modal"
											data-target="#modal-elimina${luogoR.getId_luogo()}"
											aria-label="elimina luogo"></a>
									</div>

								</div>
                        </div>
                        
                        <form action="<%=rimuoviLuogoUrl%>" id="deleteLuogo${luogoR.getId_luogo()}" method="post" enctype="multipart/form-data">
							<input type="hidden" name="<portlet:namespace/>luogo" value="${luogoR.getId_luogo()}">
        					<input type="hidden" name="<portlet:namespace/>previousPage" value="<%=previousPage%>">
                            <input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}" />  
						</form>
						
						<div id="modal-elimina${luogoR.getId_luogo()}"
										class="modal modal-custom fade modal-elimina" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<div class="modal-title-box">
														<a href="#" class="icomoon-close-white"
															data-dismiss="modal"></a>
														<div class="title-modal">
															<h2 class="title">
																<liferay-ui:message	key="gestione-riunione-modale-elimina-luogo-title" />
															</h2>
														</div>
													</div>
													<span class="icomoon-trash"></span>
													<h2 class="riunione-name">${luogoR.getNome().toUpperCase()}</h2>
													<div class="ama-row mb-50-xs buttons-bottom">
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button class="button button-secondary"
																data-dismiss="modal">
																<liferay-ui:message
																	key="gestione-riunione-modale-annulla" />
															</button>
														</div>
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button id="elimina${luogoR.getId_luogo()}"
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
	        							$("#elimina"+${luogoR.getId_luogo()}).click(function(){
		        							$("#deleteLuogo"+${luogoR.getId_luogo()}).submit();
		        							$("#modal-elimina"+${luogoR.getId_luogo()}).modal("hide");
 										});
	        						</script>
                        
                         </c:forEach>
                       </c:if>
                  
 
                </div>
                <div class="style-button-management-summoned">
				 <portlet:actionURL name="paginaPrecedente" var="paginaPrecedenteUrl">
				 
				 </portlet:actionURL>

				<form action="<%=paginaPrecedenteUrl%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="<portlet:namespace/>idRiunione" value="${idRiunione}" />   
					<input type="hidden" name="<portlet:namespace/>previousPage" value="${previousPage}" /> 
                	<button class="button button-primary"><liferay-ui:message key="gestione-riunione-luoghi-pagina-precedente"/></button>
                <form>
				</div>
            </div>
        </div>
    </div>
</div>

	
	
<script type="text/javascript">

	var chiave = $('#chiave_hidden').val();
	if(chiave != null){
		$('#parola_chiave').val(chiave);	
	}	

	function checkParsleyBeforeSubmit(){
		$("#luogoForm").parsley().validate();
		if ($("#luogoForm").parsley().isValid()){
			$("#luogoForm").submit();
		}
		
	}

	$("#ricercaLuogoSpan").on("click", function() {
		$("#ricercaLuogoForm").submit();
	});
</script>