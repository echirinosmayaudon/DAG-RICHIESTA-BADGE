<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init_mef.jsp" %>

<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@ page import="com.liferay.asset.kernel.model.AssetLink"%>
<%@ page import="com.liferay.journal.model.JournalArticle"%>
<%@ page import="com.liferay.asset.kernel.service.AssetLinkLocalServiceUtil"%>
<%@ page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.asset.kernel.model.AssetVocabulary" %>
<%@page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%
final Log _logSearch_mef = LogFactoryUtil.getLog("search_mef_jsp");

Hits hits=null;
int contResults = 0;

String redirect = ParamUtil.getString(request, "redirect");

long groupId = ParamUtil.getLong(request, SearchPortletParameterNames.GROUP_ID);

String format = ParamUtil.getString(request, SearchPortletParameterNames.FORMAT);

String[] areeTematiche=(String [])request.getParameterValues("area");
String facetTagValue =(String)request.getParameter("selectedFacetTagName");

AssetVocabulary categoriaAreaTematica= null;
List<AssetVocabulary> allCategories = AssetVocabularyLocalServiceUtil.getAssetVocabularies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

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



%>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/search_mef.jsp" />
</liferay-portlet:renderURL>

<div class="ama-container-fluid">
<aui:form action="<%= searchURL %>" method="get" name="fm" id="idForm" data-parsley-validate="true">
	<liferay-portlet:renderURLParams varImpl="searchURL" />


	<aui:input
	name="<%= SearchContainer.DEFAULT_CUR_PARAM %>" type="hidden" value="<%= ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR) %>"/>
	<aui:input name="format" type="hidden" value="<%= format %>" />




	<aui:fieldset id='<%= renderResponse.getNamespace() + "searchContainer" %>'>

		<div class="ama-row">


<%@ include file="/facet_search.jspf" %>

				<aui:col id="facetNavigation" span="<%= 9 %>">

				<div class="wrapper-risultati-ricerca" >
				<div class="page-title-wrapper">
				<div class="title-wrapper">
					<h2 class="title">RISULTATI DI RICERCA</h2>

			</div>
</div>
					<div class="tab-filtri filtro-categoria">
						<div class="filtro-tabs-wrapper">
							<span class="tab-title active">ELENCO RISULTATI PER "<%=HtmlUtil.escapeAttribute(searchDisplayContext.getKeywords()).toLowerCase() %>"</span>
						</div>
						<div id="filtro-modulistica">
							<div class="filtro-body-box">
							
								<div class="ama-row">
                            		<div class="col-xs-12 pb-10-xs">
                            			<p class="copy-text blue-color">Per cercare una frase o una locuzione, inserire il testo tra doppi apici (")</p>
                            		</div>
                            	</div>
							
								<div class="show-filters-mobile-button visible-xs"><span class="bold">2</span></div>
								<div class="text-search-wrap mobile-click-open">


						   <input
						   data-parsley-minlength="3"
						   data-parsley-validation-threshold="3"
						   data-parsley-minlength-message="Inserire almeno 3 caratteri"

						   class="search-input text-search"
						   autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" inlineField="<%= true %>" label="" id="<portlet:namespace/>keywords" name="<portlet:namespace/>keywords" size="30" title="search" value="<%= HtmlUtil.escape(searchDisplayContext.getKeywords()) %>"  />
							<span id="<portlet:namespace/>lenteRicercaSearch" class="icomoon-search"></span>
						   <aui:input name="scope" type="hidden" value="<%= searchDisplayContext.getSearchScopeParameterString() %>" />




								</div>
								  <span class="filtro-numbers hidden-xs">
									<span id="resultNumber" class="bold"></span> risultati
								</span>

						 <c:if test="<%=categoriaAreaTematica!=null && categ!=null && categ.size()>0%>">

								   <%@ include file="/altri_filtri.jsp" %>
						  </c:if>

                          <c:if test="<%= (HtmlUtil.escape(searchDisplayContext.getKeywords())!=null && !("").equals(searchDisplayContext.getKeywords())) || (areeTematiche!=null && areeTematiche.length > 0 || (facetTagValue!=null && !("").equals(facetTagValue))) %>">
                          	<div class="labels-container mt-0-xs text-center-xs">
								<span class="labels-container-title mt-0-xs">FILTRATO PER:</span>
								<c:if test="<%= HtmlUtil.escape(searchDisplayContext.getKeywords())!=null && !("").equals(searchDisplayContext.getKeywords()) %>">
									<div class="filter-label-item mt-10-xs"> <h2><%= HtmlUtil.escape(searchDisplayContext.getKeywords()).toUpperCase() %></h2> </div>
								</c:if>
								<c:if test="<%= areeTematiche!=null && areeTematiche.length > 0 %>">
								<% for (int i=0; i<areeTematiche.length; i++) { 
								   		for (AssetCategory categoria:categ) {
											if (areeTematiche[i].equalsIgnoreCase(String.valueOf(categoria.getCategoryId()))) { %>
												<div class="filter-label-item mt-10-xs"> <h2><%= categoria.getName().toUpperCase() %></h2> </div>
								<% } } }%>
								</c:if>
								<c:if test="<%= facetTagValue!=null && !("null").equals(facetTagValue) && !("").equals(facetTagValue) %>">
									<div class="filter-label-item mt-10-xs"> <h2><%= facetTagValue.trim().toUpperCase() %></h2> </div>
								</c:if>
								<div class="filter-label-item mt-10-xs btn-filter-reset"> <h2>RESET</h2><span class="icomoon-close-white"></span> </div>
							</div>
                          </c:if>

						</div>
					</div>
				</div>

		<%@ include file="/main_search_mef.jspf"%>
		</div>
			</aui:col>
		</div>

		<aui:field-wrapper inlineField="<%= true %>">
		</aui:field-wrapper>
	</aui:fieldset>



	<input id="numResult" type="hidden" value="<%= searchDisplayContext.getHits().getLength() %>"></input>




	<c:if test="<%= searchDisplayContext.isDisplayOpenSearchResults() %>">
		<liferay-ui:panel collapsible="<%= true %>" cssClass="open-search-panel" extended="<%= true %>" id="searchOpenSearchPanelContainer" persistState="<%= true %>" title="open-search">
			<%@ include file="/open_search.jspf" %>
		</liferay-ui:panel>
	</c:if>
	
</aui:form>
</div>

<%-- <input id="numResultWithAreeTematiche" type="hidden" value="<%= contResults %>"></input> --%>

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
	
	$('#<portlet:namespace/>lenteRicercaSearch').on('click',function(){
		<portlet:namespace />search();
    });
</aui:script>

<aui:script>
$('.icomoon-close-white').on('click',function(){
	 window.location.href =  window.location.href.split('?')[0];
});

$('.icon-caret-left').addClass('icomoon-arrow').removeClass('icon-caret-left');
$('.icon-caret-right').addClass('icomoon-arrow').removeClass('icon-caret-right');

$('.pagination').children().first().find("a").addClass('rotate-arrrow');

document.getElementById('resultNumber').innerHTML = $("#numResult").val();


function <portlet:namespace />search() {
		var keywords = $("#<portlet:namespace />keywords").val();
		checkCategory();
		keywords = keywords.replace(/^\s+|\s+$/, '');
		if(keywords != "" ) {
		$(<portlet:namespace/>fm).parsley().validate();
		
			if($(<portlet:namespace/>fm).parsley().isValid()){
				$(<portlet:namespace/>fm).submit();
			}
			
		}
	}

	function <portlet:namespace />addSearchProvider() {
		<portlet:resourceURL var="openSearchDescriptionXMLURL">
			<portlet:param name="mvcPath" value="/open_search_description.jsp" />
			<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
		</portlet:resourceURL>

		window.external.AddSearchProvider('<%= openSearchDescriptionXMLURL.toString() %>');
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
		return arrayAreeTem;

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

<%
String pageSubtitle = LanguageUtil.get(request, "search-results");
String pageKeywords = LanguageUtil.get(request, "search");

if (Validator.isNotNull(searchDisplayContext.getKeywords())) {
	pageKeywords = searchDisplayContext.getKeywords();

	if (StringUtil.startsWith(pageKeywords, Field.ASSET_TAG_NAMES + StringPool.COLON)) {
		pageKeywords = StringUtil.replace(pageKeywords, Field.ASSET_TAG_NAMES + StringPool.COLON, StringPool.BLANK);
	}
}

PortalUtil.setPageSubtitle(pageSubtitle, request);
PortalUtil.setPageKeywords(pageKeywords, request);
%>