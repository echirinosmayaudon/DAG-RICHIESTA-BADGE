<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="./init_mef.jsp" %>

<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>

<%
String[] areeTematiche = GetterUtil.getStringValues(request.getParameterValues("area"));

long groupId = ParamUtil.getLong(request, SearchPortletParameterNames.GROUP_ID);

boolean scopeEverything = (groupId == 0);

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/search_mef.jsp");
portletURL.setParameter("redirect", currentURL);
portletURL.setPortletMode(PortletMode.VIEW);
portletURL.setWindowState(WindowState.MAXIMIZED);

pageContext.setAttribute("portletURL", portletURL);

/*
AssetVocabulary categoriaAreaTematica= null;

//?? Perche' tutti i vocabolari di tutte le company?
// Perche' non stabilire un vacabolario certo?
List<AssetVocabulary> allCategories = AssetVocabularyLocalServiceUtil.getAssetVocabularies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

// La regola Liferay e' che i service non ritornino null, ma lista vuota
if(allCategories!=null && allCategories.size()>0){
	for (AssetVocabulary categoria : allCategories) {
		if (categoria.getName().equals("area tematica")) {
			categoriaAreaTematica = categoria;
		}
	}
}

List <AssetCategory> categ=new ArrayList<AssetCategory>();

if(categoriaAreaTematica!=null && categoriaAreaTematica.getCategories()!=null && categoriaAreaTematica.getCategories().size()>0){
	for(AssetCategory ac:categoriaAreaTematica.getCategories()){
		categ.add(ac);
	}
}
*/
//Ricerco il vocabolario tra quelli censiti nel sito e, se non lo torvo, nella global
AssetVocabulary areaTematicaVocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(
	themeDisplay.getScopeGroupId(), "area tematica");

if (areaTematicaVocabulary == null) {
	areaTematicaVocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(
		themeDisplay.getCompanyGroupId(), "area tematica");
}

List <AssetCategory> categ;

if (areaTematicaVocabulary != null) {
	categ = areaTematicaVocabulary.getCategories();
}
else {
	categ = new ArrayList<AssetCategory>();
}
%>

<div class="search-result">
<form action="<%= portletURL %>" method="get" name="fm" id="<portlet:namespace/>idForm" data-parsley-validate="true" >
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:fieldset>


	<div class="ama-container-fluid">
	<div class="ama-row">



				<div class="ama-col-xs-12">
					<div class="tab-filtri filtro-categoria">
						<div class="filtro-tabs-wrapper">
							<span class="tab-title active">RICERCA</span>
						</div>
						<div id="filtro-modulistica">
							<div class="filtro-body-box">

                            <div class="ama-row">
                            	<div class="col-xs-12 pb-10-xs">
                            		<p class="copy-text blue-color">Per cercare una frase o una locuzione, inserire il testo tra doppi apici (")</p>
                            	</div>
                            </div>

								<div class="text-search-wrap mobile-click-open" >
						<input
						data-parsley-minlength="3"
						data-parsley-validation-threshold="3"
						data-parsley-minlength-message="Inserire almeno 3 caratteri"

						class="search-input text-search"   inlineField="<%= true %>" label=""  id="<portlet:namespace/>keywords" name="<portlet:namespace/>keywords" placeholder="search" size="30" title="search" type="text" value=""

						/>
							<span id="<portlet:namespace/>lenteRicercaView" class="icomoon-search"></span>
								</div>
								<c:if test="<%= !categ.isEmpty() %>">
									<%@ include file="/altri_filtri.jsp" %>
								</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>

		<%
		String taglibOnClick = "Liferay.Util.focusFormField('#" + renderResponse.getNamespace() + "keywords');";
		%>

		<liferay-ui:quick-access-entry label="skip-to-search" onClick="<%= taglibOnClick %>" />

		<c:choose>
			<c:when test="<%= searchDisplayContext.isSearchScopePreferenceLetTheUserChoose() %>">
				<aui:select cssClass="search-select" inlineField="<%= true %>" label="" name="scope" title="scope">
					<c:if test="<%= searchDisplayContext.isSearchScopePreferenceEverythingAvailable() %>">
						<aui:option label="everything" selected="<%= scopeEverything %>" value="everything" />
					</c:if>

					<aui:option label="this-site" selected="<%= !scopeEverything %>" value="this-site" />
				</aui:select>
			</c:when>
			<c:otherwise>
				<aui:input name="scope" type="hidden" value="<%= searchDisplayContext.getSearchScopeParameterString() %>" />
			</c:otherwise>
		</c:choose>


	</aui:fieldset>
	</form>

<aui:script sandbox="<%= true %>">
	$('#<portlet:namespace />keywords').on(
		'keydown',
		function(event) {
			if (event.keyCode === 13) {
				<portlet:namespace />search();
				event.preventDefault();
			}
		}
	);
	
	$('#<portlet:namespace/>lenteRicercaView').on('click',function(){
		<portlet:namespace />search();
    });
</aui:script>

	<aui:script>
	function <portlet:namespace />search() {
		var keywords = $("#<portlet:namespace />keywords").val();
		checkCategory();
		keywords = keywords.replace(/^\s+|\s+$/, '');
		if(keywords != "" ) {
		$("#<portlet:namespace/>idForm").parsley().validate();
		
			if($("#<portlet:namespace/>idForm").parsley().isValid()){
				$("#<portlet:namespace/>idForm").submit();
			}
			
		}
	}


		var checkCategory = function(){
			resetFilterCategory();
			var arrayAreeTem = [];
			$(".filter-category-item-box").each(function() {
					if ($(this).is(".active")){
						var input = document.createElement("input");
						$(input).attr("type", 'hidden');
						$(input).attr("name", '<portlet:namespace/>area');
						$(input).val($(this).children("#idArea").first().val());
						$(this).append(input);
						arrayAreeTem.push($(this).children("#idArea").first().val());
				}
				});


		}

		function removeClassActive(){
			resetFilterCategory();
			$(".filter-category-item-box").each(function() {
					if ($(this).is(".active")){
						$(this).removeClass("active");
					}
				});

		}

		function resetFilterCategory(){

			$("input[name=<portlet:namespace/>area]").each(function() {
				$(this).remove();
			});
		}
	</aui:script>

</div>