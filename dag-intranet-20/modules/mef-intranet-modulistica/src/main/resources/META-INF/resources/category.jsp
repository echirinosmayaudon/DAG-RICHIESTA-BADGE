<%@page import="java.util.Arrays"%>

<%@ page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil"%>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryMetadataLocalServiceUtil"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntryMetadata"%>
<%@ page import="com.liferay.dynamic.data.mapping.kernel.DDMFormValues"%>
<%@ page import="com.liferay.dynamic.data.mapping.kernel.StorageEngineManagerUtil"%>
<%@ page import="com.liferay.dynamic.data.mapping.storage.StorageEngine"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntryType"%>
<%@ page import="com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.model.Layout"%>
<%@ page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.model.LayoutTypePortlet"%>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@ page import="javax.portlet.PortletRequest" %>
<%
String categId="";
int itemsdelta=0;


List<DLFileEntry> list =new ArrayList<DLFileEntry>(0);
if(request.getParameter("catId")!=null){
	categId=request.getParameter("catId");	
	%>
	<c:set var="selectedCat" value="<%=categId%>"/>	
	<% 	

}

if (itemsPerPage.isEmpty()){
	itemsPerPage="5";
}
if (Integer.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta=Integer.valueOf(itemsPerPage);	
}
 
List <AssetCategory>categ=new ArrayList<AssetCategory>();
AssetVocabulary voc= (AssetVocabulary) request.getAttribute("category");
for(AssetCategory ac:voc.getCategories()){
	  if(ac.getParentCategoryId()== 0){
		  categ.add(ac);		  
	  }
}



if(request.getAttribute("lista_res")!=null){
	list=(List<DLFileEntry>) request.getAttribute("lista_res");
}
else{
	list=(List<DLFileEntry>) request.getAttribute("allDocuments");
}
String textSearch = request.getAttribute("textSearch") == null ? "" : (String) request.getAttribute("textSearch");
String[] categoryChoosen = (String[]) request.getAttribute("cat");
int numberFilterApplied = 0;
if(!textSearch.equals("")){
	numberFilterApplied++;
}
if(categoryChoosen != null){
	numberFilterApplied = categoryChoosen.length+numberFilterApplied;
}
%>

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="text" />
  
 
<portlet:actionURL var="combinedFiltersUrl" name="combinedFilters"></portlet:actionURL>
<div class="ama-container-fluid modulistica-wrapper">

    <div class="ama-row">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="tab-filtri filtro-categoria" id="tabs-modulistica">
                        <div class="filtro-tabs-wrapper modulistica-tabs top-paginator-scroll">
                            <span class="tab-title active" ><liferay-ui:message key="modulistica-tutti-moduli"/></span>
                        </div>
                         
                        <div id="filtro-modulistica" >
                            <div class="filtro-body-box">
                                <div class="show-filters-mobile-button visible-xs">FILTRI <span class="bold"><%=numberFilterApplied%></span></div>
                                 <form enctype="multipart/form-data" action="<%=combinedFiltersUrl%>" method="post" id="<portlet:namespace/>myForm" >
                                <div class="text-search-wrap mobile-click-open">
                                <input class="text-search" value="<%=textSearch %>" name="<portlet:namespace/>textSearch" placeholder="<liferay-ui:message key="modulistica-placeholder-chiave"/>" onkeypress="if (event.keyCode==13){search();}"   /><span id="<portlet:namespace/>lenteRicerca" class="icomoon-search"></span></div>
                                <button  type="button" class="filtro-top-button open-tab mobile-click-open collapsed" data-toggle="collapse" data-target="#filtro-category" aria-expanded="false"><span class="button-label"><liferay-ui:message key="modulistica-categoria"/></span><span class="icomoon-vedi-dark hidden-xs"></span><span class="icomoon-arrow-dx icon-arrow-mobile"></span></button>
                                <div class="hide-filters-mobile-button mobile-click-open"><span class="icomoon-chiudi-dark"></span></div>
                                
                                <span class="filtro-numbers hidden-xs"><span class="bold"><%=list.size() <= itemsdelta ? list.size() : itemsdelta  %></span> <liferay-ui:message key="modulistica-di"/>  <span class="bold"><%=list.size()%></span> <liferay-ui:message key="modulistica-moduli"/></span>
                                
                                    <div id="filtro-category" class="collapse" aria-expanded="false" style="height: 0px;">
                                    <div class="filtro-content-box filtro-category">
                                    
                                                                                    
                                    <c:forEach items="<%=categ%>" var="subCategory" varStatus="loop">
                                   			<c:set var="currentCat" value="${subCategory.getName().toUpperCase()}"/>
                                            <div class="ama-col-md-3 ama-col-sm-4 ama-col-xs-12 filter-category-item-wrap">
                                               
                                                <a href="" title="${subCategory.getName().toUpperCase()}" class="filter-category-item-box <%= (categoryChoosen != null && Arrays.asList(categoryChoosen).contains((String)pageContext.getAttribute("currentCat"))) ? "active" : ""%>">
                                                    <div class="category-item-icon"><span class="icomoon-categoria-generale"></span></div>
                                                    <div class="category-item-text">${subCategory.getName().toUpperCase()}</div>
                                                    <input type="hidden" id="<portlet:namespace/>categoriaId" value="${subCategory.getCategoryId()}"/>
                                                </a>
                                                
                                            </div>   
                                            </c:forEach>                              
                                                   <div class="buttons-wrapper ama-col-xs-12">
                                                <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                                    <button  type="button" class="button button-secondary button-cancel button-filtro" onclick="removeClassActive()"><liferay-ui:message key="modulistica-cancella"/></button>
                                                </div>
                                                <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                                    <button  type="button" class="button button-primary" onclick="search()" ><liferay-ui:message key="modulistica-applica"/></button>
                                                </div>
                                            </div>
                                            
                                
                                    </div>
                                </div>
                                  </form> 
                                   <%if((textSearch != null && !textSearch.equals("")) || (categoryChoosen != null && categoryChoosen.length>0) ) {%>
                                	<div class="labels-container mobile-click-open">
	                                   	 <span class="labels-container-title"><liferay-ui:message key="modulistica-filtrato-per"/>:</span>
	                                    <%if(textSearch != null && !textSearch.equals("")) {%>
	                                    <div class="filter-label-item">
	                                        <h2><%=textSearch.toUpperCase()%></h2>
	                                    </div>
	                                   <%} %>
	                                  <c:forEach items="<%=categoryChoosen%>" var="catChooseen">
	                                  	<div class="filter-label-item">
	                                        <h2>${catChooseen}</h2>
	                                    </div>
	                                  </c:forEach>
	                                  <div id="<portlet:namespace/>resetFilter" class="filter-label-item btn-filter-reset">
	                                        <h2><liferay-ui:message key="modulistica-reset"/></h2>
	                                        <span class="icomoon-close-white"></span>
	                                    </div>
                                	</div>
                                 <%} %>
                                <span class="filtro-numbers filtro-numbers-mobile visible-xs"><span class="bold"><%=list.size() <= itemsdelta ? list.size() : itemsdelta  %></span> di <span class="bold"><%=list.size() %></span> annunci</span>
                            </div>
                            
                            <div class="moduli-wrapper">
                                <div class="js-list-pagination">
                                
                                <c:if test="<%=request.getAttribute("lista_res")!=null &&  list.size()<1%>"> 
                                <div class="ama-row">
                                <div class="ama-col-xs-12">
                                    <p class="copy-text wysiwyg-editor"><liferay-ui:message key="modulistica-nessun-risultato"/></p>
                                </div>
                                </div>
                                </c:if>
                                   
                                     <c:if test="<%=list!= null%>">                                
           								<c:forEach items="<%=list%>" var="element" >                     
                             				<c:set var="el" value="${element}"/>   
	                               <%
	                               
	                                    DLFileEntry dl = (DLFileEntry) pageContext.getAttribute("el"); 
	                               
	                               
	                               //ottengo il link alla procedura, se esiste
	                                     String linkToProcedure=null;
								   	     PortletURL renderUrl =null;
	 	                                 long fileEntryTypeId = 0;
	 	                                 DLFileEntryType dLFileEntryType=null;
	 	                                 DLFileEntryMetadata  dlMeta=null;
	 	                                 DDMFormValues ddmFormValues=null;
	 	                                 List<DDMFormFieldValue> listDDMFormFieldVal=new ArrayList<>(0);
	 	                                 Layout layoutTo =null;
	 	                                 fileEntryTypeId= dl.getFileEntryTypeId();  
	 	                                	
	 	                       
	 	                                 if(fileEntryTypeId!=0){
	                                      dLFileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(fileEntryTypeId);
	 	                                }
	 	                               
	 	                                if(dLFileEntryType!=null &&  dLFileEntryType.getDDMStructures()!=null && dLFileEntryType.getDDMStructures().size()>0 && dl.getFileVersion()!=null && dl.getFileVersion().getFileVersionId()!=0){
	                                      dlMeta =DLFileEntryMetadataLocalServiceUtil.getFileEntryMetadata(dLFileEntryType.getDDMStructures().get(0).getStructureId() , dl.getFileVersion().getFileVersionId());
	 	                                }
	 	                            
	 	                                if( dlMeta!=null && dlMeta.getDDMStorageId()!=0){
	                                      ddmFormValues=StorageEngineManagerUtil.getDDMFormValues(dlMeta.getDDMStorageId());         
	 	                                }
	 	                            
	 	                               if(ddmFormValues!=null){
	 	                                listDDMFormFieldVal= ddmFormValues.getDDMFormFieldValues();
	 	                               }
	 	                                if(listDDMFormFieldVal!=null && listDDMFormFieldVal.size()>0){
	                                          
	 	                                     for(DDMFormFieldValue ddmFormFieldValue: listDDMFormFieldVal){
	 	                                    	if(ddmFormFieldValue.getName().equals("LinkToProcedurePage")){                     		
	 	                                        JSONObject jsonFormValues=JSONFactoryUtil.createJSONObject(ddmFormFieldValue.getValue().getString(Locale.getDefault()));   
	 	                                        linkToProcedure=jsonFormValues.getString("layoutId");
	 	                                    	}
                                              if(linkToProcedure!=null && linkToProcedure!=""){
	 	                                         layoutTo = LayoutLocalServiceUtil.getLayout(themeDisplay.getSiteGroupId(),themeDisplay.getLayout().isPrivateLayout(),Long.parseLong(linkToProcedure));
                                                }
                                              if(layoutTo!=null ){
	 	                                        renderUrl = PortletURLFactoryUtil.create(renderRequest,themeDisplay.getPortletDisplay().getId(), layoutTo, PortletRequest.RENDER_PHASE); 
                                              }
	 	                                    }
	                                      }

										 ThemeDisplay tDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);			 
										 String fileUrl = tDisplay.getPortalURL() + tDisplay.getPathContext() + "/documents/" + tDisplay.getScopeGroupId() + "/" + dl.getFolderId() +  "/" + HttpUtil.encodeURL(HtmlUtil.unescape(dl.getFileName()))+ "/" + HttpUtil.encodeURL(HtmlUtil.unescape(dl.getUuid()))+"?download=true";
										 List <AssetCategory> myACList =new ArrayList<AssetCategory>();
										 AssetVocabulary vocabularyMod=AssetVocabularyLocalServiceUtil.getGroupVocabulary(tDisplay.getLayout().getGroupId(),"modulistica");
										 for(AssetCategory category:AssetCategoryLocalServiceUtil.getCategories(DLFileEntry.class.getName(), dl.getFileEntryId())){
											 if(category.getVocabularyId()==vocabularyMod.getVocabularyId()){
												 myACList.add(category);
											 }
										 }
								
										 List<AssetCategory> myCat=	new ArrayList<AssetCategory>();
										
										 List<AssetCategory> mySubCat=new ArrayList<AssetCategory>();
										 List<String> myCatName=new ArrayList<String>();
										 List <String> mySubCatName = new ArrayList<String>();
										
										 for(AssetCategory sub:myACList){	
											 if(sub.getParentCategoryId()==0){
												 myCat.add(sub);					
											 }else
											 {
												 mySubCat.add(sub);					 
											 }
											}		 	
										 for(AssetCategory s:myCat){
											 myCatName.add(s.getName());				 
										 }
										 		 
										 for (AssetCategory j:mySubCat) {					 
											 mySubCatName.add(j.getName());		
										 }
										 
										 String listStringCat = "";			 
										 for (String j: myCatName) {
											 listStringCat += j + "\n";
										 }
										 
										 String listStringSubCat = "";
										 for (String j: mySubCatName) {
											 listStringSubCat += j + "\n";
										 }		 
										 %>	    
	                                    	<div class="modulistica-module item-pagination animated fadeIn ">
	                                        	<div class="module-information-box">
	                                        	<c:if test="<%=renderUrl!=null %>">
	                                            	<a class="tooltip-field" title="<liferay-ui:message key="modulistica-link-procedura"/>" href="<%=renderUrl%>" target="_self">
	                                               	 <span class="icomoon-info"></span>
	                                            	</a>
		                                            </c:if>
		                                             <c:forEach items="<%=myCat %>" var="categoria">
										                  <portlet:defineObjects />
										                  <portlet:actionURL  name="selectcategory" var="selectcategoryUrl">	                            	        
								                          <portlet:param name="catId" value="${categoria.getName().toUpperCase()}"/> 
								                          </portlet:actionURL>	   
				                                          <div class="button-wrap"><span class="module-information-button primary">${categoria.getName().toUpperCase()}</span></div>
				                                          <c:if test="<%=!listStringSubCat.equals("")%>">
				                                          	<div class="button-wrap"><span class="module-information-button secondary"><%=listStringSubCat%></span></div>
				                                          </c:if>
		                                             </c:forEach>
	                                           		<div class="module-information-text dot-point dot-mobile max-dot-70" style="word-wrap: break-word;">${element.getTitle()}</div>
	                                        	</div>
		                                        <div class="module-download-box">
		                                            <span class="icomoon-pdf"></span>
		                                            <span class="download-box-text dot-point max-dot-60 is-truncated" style="word-wrap: break-word;">${element.getTitle()}</span>
		                                            <span class="file-name">${element.getExtension().toUpperCase()} <fmt:formatNumber value="${element.getFileVersion().getSize()/1000}" type="number" pattern="#"/> Kb</span>
		                                            <a href="<%=fileUrl%>" title="Scarica il modulo" id="${element.getFileEntryId()}"class="icomoon-download" target="_blank" onclick="callServeResource(this.id)">
														<span class="sr-only"><liferay-ui:message key="modulistica-scarica-modulo"/></span> 
		                                            </a>
		                                        </div>
	                                        </div>
                                        
                                         </c:forEach>
                                       </c:if>
    
                                     <div class="ama-row">
                                        <div class="ama-col-xs-12 text-align-center">
                                            <div data-totpage="<%=itemsdelta %>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                                                <div class="btn-back-arrow disabled">
                                                    <a href="#">
                                                        <em class="icomoon-arrow"></em>
                                                    </a>
                                                </div>
                                                <ul class="pagination-numbers"></ul>
                                                <div class="btn-forward-arrow">
                                                    <a href="#">
                                                        <em class="icomoon-arrow"></em>
                                                    </a>
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
      </div>  
     </div>   
      <script>
      var search = function() {
			checkCategory();
			$("#<portlet:namespace/>myForm").submit();  
		}
      
    	var checkCategory = function(submit){
    		resetFilterCategory();
    		 $(".filter-category-item-box").each(function() {
 				if ($(this).is(".active")){	
 				
 					var input = document.createElement("input");				    
 				     $(input).attr("type", 'hidden');				  
 				     $(input).attr("name", '<portlet:namespace/>catgo');
 				     $(input).val($(this).children(".category-item-text").first().text());				  
 				     $(this).append(input); 
 				    var inputid = document.createElement("input");				    
				     $(inputid).attr("type", 'hidden');				  
				     $(inputid).attr("name", '<portlet:namespace/>catgoId');
				     $(inputid).val($(this).children()[2].value);				  
				     $(this).append(inputid); 
 	          }      
 	  		});
    	}
    	
    	$( document ).ready(function() {
    		checkCategory();
    	});
	     
      function resetFilterCategory(){
    	 
    	 $("input[name=<portlet:namespace/>catgo]").each(function() {
			 $(this).remove();
		 });
	}
      
      
      function removeClassActive(){
    	  resetFilterCategory();      
    	  console.log("inside remove");
    	  $(".filter-category-item-box").each(function() {
				if ($(this).is(".active")){	
					 $(this).removeClass("active");
				}
			});
		if (($("input[name='<portlet:namespace/>textSearch']").val()!= null) || ($("input[name='<portlet:namespace/>textSearch']").val()!=""))
			search();	 
		else
			$("#<portlet:namespace/>resetFilter").trigger("click"); 
  
      }
      
      
    $('.icomoon-close-white').on('click',function(){
    	 window.location.href =  window.location.href.split('?')[0];
    });
      
    
    
    $('#<portlet:namespace/>lenteRicerca').on('click',function(){	   
    	if (($("input[name='<portlet:namespace/>textSearch']").val()!= null) || ($("input[name='<portlet:namespace/>textSearch']").val()!="")){	 
    	search();	
    	}  
    	});
      
        </script>  
    