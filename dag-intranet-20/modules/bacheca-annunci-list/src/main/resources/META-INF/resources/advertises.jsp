<%@page
	import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@page import="bacheca.annunci.list.beans.AnnuncioBean"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page
	import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page
	import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.asset.kernel.model.AssetVocabulary"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<!--<c:set var="annunciList" value="${advList}"/>  -->

<style>
#col1 {
	position: absolute;
	left: 5px;
	padding: 0px;
}

#col2 {
	position: absolute;
	margin-left: 100px;
	padding: 0px;
}

#col3 {
	margin-left: 200px;
	padding: 0px;
}
</style>





<%


boolean disablecheck=true;
String filter = (String) request.getAttribute("filter");
if(filter!=null && filter.equals("combine"))
	disablecheck=false;
String itemSelectorURL = GetterUtil.getString(request.getAttribute("itemSelectorURL"));

//pagination
int itemsdelta=0;


/*settare items per page da configuration guardare modulistica
if (itemsPerPage.isEmpty()){
	itemsPerPage="5";
}
if (Integer.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta=Integer.valueOf(itemsPerPage);	
}
*/

//filter init
String textSearch = request.getAttribute("textSearch") == null ? "" : (String) request.getAttribute("textSearch");
String[] categoryChoosen = (String[]) request.getAttribute("cat");
int numberFilterApplied = 0;
if(!textSearch.equals("")){
	numberFilterApplied++;
}
if(categoryChoosen != null){
	numberFilterApplied = categoryChoosen.length+numberFilterApplied;
}


List<AnnuncioBean>annunciList=(List<AnnuncioBean>) request.getAttribute("advList");
List<AnnuncioBean>myannunciList=(List<AnnuncioBean>) request.getAttribute("myadvList");
int annunciListsize = annunciList.size();
String[] zonalist=zona.split(",");

if (itemsPerPage.isEmpty()){
	itemsPerPage="5";
}
if (Integer.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta=Integer.valueOf(itemsPerPage);	
}
%>
<c:set value="<%=zona%>" var="zona"></c:set>
<c:set value="<%=zonalist%>" var="zonalist"></c:set>







<portlet:actionURL name="searchAdvCombine" var="searchAdvCombine">
	<portlet:param name="filter" value="combine" />
</portlet:actionURL>



            <div class="wrapper-added-notice">
             
            
            </div>
            <div class="padding-filtro-bacheca">
                <div class="tab-filtri filtro-categoria collapse-group" id="tabs-bacheca">
                    <div class="filtro-tabs-wrapper">
                        <span class="tab-title active" data-toggle="collapse" data-target="#filtro-bacheca" data-parent="#tabs-bacheca"><liferay-ui:message key="tutti-gli-annunci" /></span>
                        <span class="tab-title" data-toggle="collapse" data-target="#bacheca-tuoi-annunci" data-parent="#tabs-bacheca"><liferay-ui:message key="i-tuoi-annunci" /></span>
                    </div>
                    <div id="filtro-bacheca" class="collapse in">
                        <div class="filtro-body-box">
                            <div class="show-filters-mobile-button visible-xs"><liferay-ui:message key="filtri-label" /><span class="bold">&nbsp;<%=numberFilterApplied%></span></div>
                            
                            <form action="<%=searchAdvCombine%>" method="post" id="<portlet:namespace/>myForm" >
                            
                            <div class="text-search-wrap mobile-click-open">
                            <input class="text-search" value="<%=textSearch %>" name="<portlet:namespace/>textSearch" 
                            	placeholder='<liferay-ui:message key="placeholder-parola-chiave" />'
                            	onkeypress="if (event.keyCode==13){search();}"><span class="icomoon-search"></span></div>
                            <button  type="button" class="filtro-top-button open-tab mobile-click-open" data-toggle="collapse" data-target="#filtro-category"><span class="button-label"><liferay-ui:message key="categoria" /></span><span class="icomoon-vedi-dark hidden-xs"></span><span class="icomoon-arrow-dx icon-arrow-mobile"></span></button>
                            <div class="hide-filters-mobile-button mobile-click-open"><span class="icomoon-chiudi-dark"></span></div>
                         <c:if test="<%=annunciListsize==1%>">
                            <span class="filtro-numbers hidden-xs"><span class="bold"><%=annunciList.size() <= itemsdelta ? annunciList.size() : itemsdelta  %></span>&nbsp;<liferay-ui:message key="di-label" />&nbsp;<span class="bold"><%=annunciList.size()%></span> <liferay-ui:message key="annuncio-label" /></span>
                            </c:if>
                             <c:if test="<%=annunciListsize>1%>">
                            <span class="filtro-numbers hidden-xs"><span class="bold"><%=annunciList.size() <= itemsdelta ? annunciList.size() : itemsdelta  %></span>&nbsp;<liferay-ui:message key="di-label" />&nbsp;<span class="bold"><%=annunciList.size()%></span> <liferay-ui:message key="annunci-label" /></span>
                            </c:if>
                           <c:if test="<%=annunciListsize==0%>">
                            <span class="filtro-numbers hidden-xs"><span class="bold"><%=annunciList.size() <= itemsdelta ? annunciList.size() : itemsdelta  %></span>&nbsp;<liferay-ui:message key="di-label" />&nbsp;<span class="bold"><%=annunciList.size()%></span> <liferay-ui:message key="annunci-label" /></span>
                            </c:if>
                            <div id="filtro-category" class="collapse">
                                <div class="filtro-content-box filtro-category">
                                
                                
                               <c:if test="<%=request.getAttribute("category")!= null%>">
								<c:set value="<%=request.getAttribute("category")%>" var="catMod" />
				
										<c:forEach var="subCategory" items="${catMod.getCategories()}" varStatus="loop">
						                 <c:set var="currentCat" value="${subCategory.getName().toUpperCase()}"/>

		                                     <div class="ama-col-md-3 ama-col-sm-4 ama-col-xs-12 filter-category-item-wrap">
		                                           <a href="" title="${subCategory.getName().toUpperCase()}" class="filter-category-item-box <%= (categoryChoosen != null && Arrays.asList(categoryChoosen).contains((String)pageContext.getAttribute("currentCat"))) ? "active" : ""%>">
		                                              	<div class="category-item-icon"><span class="icon-category  icomoon-${subCategory.getDescriptionCurrentValue()}" ></span></div>
		                                                <div class="category-item-text">${subCategory.getName().toUpperCase()}</div>
		                                                <div class="category-item-id-hidden" style="display:none">${subCategory.getCategoryId()}</div>

		                                           </a>
		                                     </div> 
		
				                      	</c:forEach>
								
							</c:if>
                                                                       
                                         <div class="buttons-wrapper ama-col-xs-12">
                                            <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                                <button type="button" class="button button-secondary button-cancel button-filtro"><liferay-ui:message key="annulla-button" /></button>
                                            </div>
                                            <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                                <button  type="button" class="button button-primary" onclick="search()"><liferay-ui:message key="applica-button" /></button>
                                            </div>
                                        </div>
                                        
                            
                                </div>
                            </div>
                            </form>
                            
                            <%if((textSearch != null && !textSearch.equals("")) || (categoryChoosen != null && categoryChoosen.length>0) ) {%>
                            <div class="labels-container mobile-click-open">
                                <span class="labels-container-title"><liferay-ui:message key="filtro-per" />:</span>
                                 <%if(textSearch != null && !textSearch.equals("")) {%>
                                <div class="filter-label-item">
                                     <h2><%=textSearch.toUpperCase()%></h2>                                  
                                </div>
                                  <%} %>
								

                                    <c:forEach items="<%=categoryChoosen%>" var="catChooseen">
									<c:if test='${!catChooseen.equals("tutte")}'>
                                <div class="filter-label-item">
                                   <h2>${catChooseen}</h2>                                   
                                </div>
								</c:if>
                                 </c:forEach>
                                <div id="<portlet:namespace/>resetFilter" class="filter-label-item btn-filter-reset">
	                                        <h2><liferay-ui:message key="reset-button" /></h2>
	                                        <span class="icomoon-close-white"></span>
	                             </div>
                            </div>
                             <%} %>
                             
                             <c:if test="<%=annunciListsize==1%>">
                            <span class="filtro-numbers filtro-numbers-mobile visible-xs"><span class="bold"><%=annunciList.size() <= itemsdelta ? annunciList.size() : itemsdelta  %></span>&nbsp;<liferay-ui:message key="di-label" />&nbsp;<span class="bold"><%=annunciList.size()%></span> <liferay-ui:message key="annuncio-label" /></span>
                            </c:if>
                             <c:if test="<%=annunciListsize>1%>">
                            <span class="filtro-numbers filtro-numbers-mobile visible-xs"><span class="bold"><%=annunciList.size() <= itemsdelta ? annunciList.size() : itemsdelta  %></span>&nbsp;<liferay-ui:message key="di-label" />&nbsp;<span class="bold"><%=annunciList.size()%></span> <liferay-ui:message key="annunci-label" /></span>
                            </c:if>
                           <c:if test="<%=annunciListsize==0%>">
                            <span class="filtro-numbers filtro-numbers-mobile visible-xs"><span class="bold"><%=annunciList.size() <= itemsdelta ? annunciList.size() : itemsdelta  %></span>&nbsp;<liferay-ui:message key="di-label" />&nbsp;<span class="bold"><%=annunciList.size()%></span> <liferay-ui:message key="annunci-label" /></span>
                            </c:if>
                    </div>
                             
                        
                        <div class="js-list-pagination">
                            <div class="wrapper-notice-board tutti-annunci-elenco">
                                <div class="ama-row">
                            
                            
                            
                            
                           <c:choose> 
                    <c:when test="<%=annunciList!= null && annunciList.size()>0%>">
					    <c:set value="<%=annunciList%>" var="annunciList" />
					    		 
					    <c:forEach items="${annunciList}" var="annuncio"> 
					     	<%AnnuncioBean annuncio=(AnnuncioBean)pageContext.getAttribute("annuncio"); %>              
					                	<liferay-portlet:renderURL varImpl="rowURL">
											<portlet:param name="navigation" value="advdetail" />
											<portlet:param name="annuncioId" value="${annuncio.id}" />											
										</liferay-portlet:renderURL>   
					                   
					                                                           
                                    <div class="ama-col-md-12 ama-col-xs-12 item-pagination animated fadeIn">
                                        <a href="<%= rowURL %>" class="notice-board">
                                            <div class="ama-row">
                                                <div class="ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
													<div class="image-bacheca icomoon-${annuncio.getCategoriaDescrizione()}"></div>													
                                                    <p class="style-title">${annuncio.getCategoriaNome().toUpperCase()}</p>
                             
                                                </div>
                                                <div class="ama-col-md-8 ama-col-sm-6 ama-col-xs-12 border-left">
                                                    <div class="clearfix">
                                                      <c:if test = "${fn:contains(annuncio.getTipologia(), 'offresi')}">
                                                        <p class="second-title"><liferay-ui:message key="offerta-uppercase" /></p>
                                                      </c:if>
                                                       <c:if test = "${fn:contains(annuncio.getTipologia(), 'cercasi')}">
                                                        <p class="second-title"><liferay-ui:message key="richiesta-uppercase" /></p>
                                                      </c:if>
                                               	<c:if test='<%=annuncio.getZona()!=null && !annuncio.getZona().equalsIgnoreCase("")%>'>
                                                        <div class="wrapper-content">
                                                            <p class="style-city">${annuncio.getZona().toUpperCase()}</p>
                                                            <div class="icomoon-pin"></div>
                                                        </div>
                                                        </c:if>
                                                    </div>
                                                    <p class="description dot-point dot-130" style="word-wrap: break-word;">
                                                        ${annuncio.getDescrizione()}
                                                    </p>
                                                    <div class="wrapper-content-user">
                                                        <div class="icomoon-user"></div>
                                                        <div class="name">
                                                            <p>${annuncio.getNomeUtente()}</p>
															<p>${annuncio.getTelefono()}</p>
															<p>${annuncio.getEmail()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                           </c:forEach>
				    </c:when>
<c:otherwise>

	<div class="ama-col-md-12 ama-col-xs-12">

		<p class="copy-text wysiwyg-editor"><liferay-ui:message key="bacheca-annunci-nessun-risultato" /></p> 

	</div>

  </c:otherwise>
</c:choose>					
                                 
                               
                                   
                                
                            
                                </div>
                            </div>
                            <div class="ama-row">
                                <div class="ama-col-xs-12 text-align-center">
                                    <div data-totpage="<%=itemsdelta%>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                                        <div class="btn-back-arrow disabled">
                                            <a href="#">
                                                <em class="icomoon-arrow"></em>
                                            </a>
                                        </div>
                                        <ul class="pagination-numbers"><!-- <li class="current-page"><a href="#">1</a></li><li><a href="#">2</a></li> --></ul>
                                        <div class="btn-forward-arrow">
                                            <a href="#">
                                                <em class="icomoon-arrow"></em>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>                        </div>
                    </div>
                    <div id="bacheca-tuoi-annunci" class="collapse">
                        <div class="js-list-pagination">
                            <div class="wrapper-notice-board tuoi-annunci-elenco">
                                <div class="ama-row">
                            <c:choose>
                                    <c:when test="<%=myannunciList!= null%>">
									    <c:set value="<%=myannunciList%>" var="myannunciList" />
									    		 
									    <c:forEach items="${myannunciList}" var="myannuncio"> 
					                   	<%AnnuncioBean myannuncio=(AnnuncioBean)pageContext.getAttribute("myannuncio"); %>
					                   
					                	<liferay-portlet:renderURL varImpl="rowURL">
											<portlet:param name="navigation" value="advdetail" />
											<portlet:param name="annuncioId" value="${myannuncio.id}" />											
										</liferay-portlet:renderURL>   
					                   
					                                                           
                                    <div class="ama-col-md-12 ama-col-xs-12 item-pagination animated fadeIn">
                                        <a href="<%= rowURL %>" class="notice-board">
                                            <div class="ama-row">
                                                <div class="ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                                                    <div class="image-bacheca icomoon-${myannuncio.getCategoriaDescrizione()}"></div>													
                                                    <p class="style-title">${myannuncio.getCategoriaNome().toUpperCase()}</p>
                                    
                                                </div>
                                                <div class="ama-col-md-8 ama-col-sm-6 ama-col-xs-12 border-left">
                                                    <div class="clearfix">
                                                    
                                                    
                                                      <c:if test = "${fn:contains(myannuncio.getTipologia(), 'offresi')}">
                                                        <p class="second-title"><liferay-ui:message key="offerta-uppercase" /></p>
                                                      </c:if>
                                                       <c:if test = "${fn:contains(myannuncio.getTipologia(), 'cercasi')}">
                                                        <p class="second-title"><liferay-ui:message key="richiesta-uppercase" /></p>
                                                      </c:if>
                                                      	<c:if test='<%=myannuncio.getZona()!=null && !myannuncio.getZona().equalsIgnoreCase("")%>'>
                                                        <div class="wrapper-content">
                                                            <p class="style-city">${myannuncio.getZona().toUpperCase()}</p>
                                                            <div class="icomoon-pin"></div>
                                                        </div>
                                                        </c:if>
                                                    </div>
                                                    <p class="description dot-point dot-130" style="word-wrap: break-word;">
                                                        ${myannuncio.getDescrizione()}
                                                    </p>
                                                    <div class="wrapper-content-user">
                                                        <div class="icomoon-user"></div>
                                                        <div class="name">
                                                            <p>${myannuncio.getNomeUtente()}</p>
                        									<p>${myannuncio.getTelefono()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                           </c:forEach>
				    </c:when> 
					<c:otherwise>
					<div class="ama-col-md-12 ama-col-xs-12">

						<p class="copy-text wysiwyg-editor"><liferay-ui:message key="bacheca-annunci-nessun-annuncio-personale" /></p> 

					</div>
					</c:otherwise>
					</c:choose>
                            
                                </div>
                            </div>
                            <div class="ama-row">
                                <div class="ama-col-xs-12 text-align-center">
                                    <div data-totpage="<%=itemsdelta%>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap hide">
                                        <div class="btn-back-arrow disabled">
                                            <a href="#">
                                                <em class="icomoon-arrow"></em>
                                            </a>
                                        </div>
                                        <ul class="pagination-numbers">
                            
                                        </ul>
                                        <div class="btn-forward-arrow">
                                            <a href="#">
                                                <em class="icomoon-arrow"></em>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>                        </div>
                    </div>
                </div>
            </div>
      



<script>
function removeClassActive(){
	  resetFilterCategory();      
	  console.log("inside remove");
	  $(".filter-category-item-box").each(function() {
			console.log($(this));
			if ($(this).is(".active")){	
				 $(this).removeClass("active");
			}
	});
	
	

	  
	
	  if (($("input[name='<portlet:namespace/>textSearch']").val()!= null) || ($("input[name='<portlet:namespace/>textSearch']").val()!="")){
		 
		  	search();
	  }
	  else{
		  console.log("search2");
		  //console.log($("#<portlet:namespace/>resetFilter"));
		   //$(".btn-filter-reset").trigger("click");
		   //console.log("clicked");
		  // console.log((".btn-filter-reset").trigger("click"));

		  $("#<portlet:namespace/>resetFilter").trigger("click"); 


	  }


} 
      var search = function() {
			checkCategory();
			$("#<portlet:namespace/>myForm").submit();  
		}
      
    	var checkCategory = function(submit){
    		resetFilterCategory();
    		 $(".filter-category-item-box").each(function() {
 				console.log($(this));
 	     
 				if ($(this).is(".active")){	
 				
 					var input = document.createElement("input");				    
 				     $(input).attr("type", 'hidden');				  
 				     $(input).attr("name", '<portlet:namespace/>catgo');
 				     $(input).val($(this).children(".category-item-id-hidden").first().text());	
					  $(this).append(input);  

					 var inputText = document.createElement("input");				    
 				     $(inputText).attr("type", 'hidden');				  
 				     $(inputText).attr("name", '<portlet:namespace/>catgotext');
 				     $(inputText).val($(this).children(".category-item-text").first().text());	
					 
 				     $(this).append(inputText);  
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
		  $("input[name=<portlet:namespace/>catgotext]").each(function() {
			 $(this).remove();
		 });
	}
  
  	//Issue IMEF-658    
      $('.icomoon-search').on('click',function(){
	      if (($("input[name='<portlet:namespace/>textSearch']").val()!= null) || ($("input[name='<portlet:namespace/>textSearch']").val()!="")){
	 		 
			  	search();
		  }
      });
      
    $('.icomoon-close-white').on('click',function(){
    	 window.location.href =  window.location.href.split('?')[0];
    });
 /*   $(".phone").text(function(i, text) {
        text = text.replace(/(\d\d\d)(\d\d\d)(\d\d\d\d)/, "$1 $2 $3");
        return text;
    });*/
      
        </script>  




