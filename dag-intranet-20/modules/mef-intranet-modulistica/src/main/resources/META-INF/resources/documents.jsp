
<%@page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import ="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import ="java.util.List"%>
<%@page import ="java.util.Set"%>
<%@page import ="java.util.ArrayList"%>
<%@page import ="java.util.HashSet"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.asset.kernel.model.AssetVocabulary"%>

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

<div class="ama-container-fluid wrapper-moduls">
	<div class="ama-row carousel-moduls" id="skills">

	<c:forEach items="${myList}" var="listItem">
	<c:set var="docum" value="${listItem}"/>
	
	<portlet:renderURL var="docDetailsURL">
				<portlet:param name="mvcPath" value="/document.jsp"/>
	            <portlet:param name="doc" value="${listItem.getFileEntryId()}"/>            
				</portlet:renderURL>
	<%
				 DLFileEntry dl = (DLFileEntry) pageContext.getAttribute("docum");	
	
	
	
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
				 long folderId = dl.getFolderId();
				 ThemeDisplay tDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);			 
				 String fileUrl = tDisplay.getPortalURL() + tDisplay.getPathContext() + "/documents/" + tDisplay.getScopeGroupId() + "/" + folderId +  "/" + HttpUtil.encodeURL(HtmlUtil.unescape(dl.getFileName()))+ "/" + HttpUtil.encodeURL(HtmlUtil.unescape(dl.getUuid()))+"?download=true";
				 
				 
				 List <AssetCategory> myACList =new ArrayList<AssetCategory>();
				 AssetVocabulary vocabularyMod=AssetVocabularyLocalServiceUtil.getGroupVocabulary(tDisplay.getLayout().getGroupId(),"modulistica");
				 for(AssetCategory category:AssetCategoryLocalServiceUtil.getCategories(DLFileEntry.class.getName(), dl.getFileEntryId())){
					 if(category.getVocabularyId()==vocabularyMod.getVocabularyId()){
						 myACList.add(category);
					 }
				 }
		
				 List<AssetCategory> myCat=new ArrayList<AssetCategory>();		 
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
				 
               	<div class="ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                   	<div class="bg-color-white">
                        <div class="ama-row">
                            <div class="ama-col-md-9 ama-col-xs-9">
                             <c:forEach items="<%=myCat %>" var="categoria" varStatus="stat">
                             	<c:set var="idCategory" value="${stat.first ? '' : idCategory}_${fn:replace(categoria.getCategoryId(),' ','_')}" />
                             	<c:set var="nameCategory" value="${stat.first ? '' : nameCategory} ${stat.index gt 0 ? '&' : ''} ${categoria.getName().toUpperCase()}"/>
 							</c:forEach>
 							<form id="goToCategory${idCategory}" name="goToCategory" method="post" action="${linkLayoutmyUrl}">
 								<c:forEach items="<%=myCat %>" var="categoria">
									<input type="hidden" value="${categoria.getName().toUpperCase()}" name="_${porletId_Modulistica}_catgo">
								    <input type="hidden" value="${categoria.getCategoryId()}" name="_${porletId_Modulistica}_catgoId"> 
								</c:forEach>
						    </form>
                            <a href="#goToCategory" data-idcat="${idCategory}" class="image-category" tabindex="0" >
                                <p class="font-size">VAI A ${nameCategory}</p>
                            </a>
                            </div>
                            <c:if test="<%=renderUrl!=null %>">
	                                            	<a class="tooltip-field" title="<liferay-ui:message key="modulistica-link-procedura"/>" href="<%=renderUrl%>" target="_self">
	                                               	 <span class="icomoon-info"></span>
	                                            	</a>
		                                            </c:if>
                        </div>

                        <div class="ama-row">
                            <div class="ama-col-md-12 ama-col-xs-12">
                                <p class="description-moduls dot-point dot-60">${listItem.getTitle()}
                                </p>
                            </div>
                        </div>

					<div class="ama-row">
						<div class="bg-color-blue">
							<div class="ama-col-md-7 ama-col-xs-8">
								<a href="<%=fileUrl%>" id="${listItem.getFileEntryId()}" title="Scarica il modulo" class="image-pdf" tabindex="0"  target="_blank" onclick="callServeResource(this.id)">
									<span class="icomoon-pdf"></span> 
									<p class="style-pdf"><%=dl.getExtension().toUpperCase()%> <%=((dl.getFileVersion().getSize())/1000)%> KB</p>
								</a>
							</div>
							
							<div class="ama-col-md-5 ama-col-xs-4 text-center">
								<a href="<%=fileUrl%>" id="${listItem.getFileEntryId()}" title="Scarica il modulo"
									onclick="callServeResource(this.id)" class="image-download"
									tabindex="0" target="_blank">
										<span class="icomoon-download"></span>
										<span class="sr-only"><liferay-ui:message key="modulistica-scarica-modulo"/></span>  
									</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<portlet:defineObjects />

<script type="text/javascript">
$('.image-category').on('click',function(e){
	e.stopPropagation();
	e.preventDefault();
	$('form#goToCategory'+$(this).data('idcat')).submit();
});

</script>