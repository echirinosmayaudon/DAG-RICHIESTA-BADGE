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
<%@page import ="bacheca.annunci.list.beans.AnnuncioBean"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.asset.kernel.model.AssetVocabulary"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>


<%

List<AnnuncioBean>annunciList=(List<AnnuncioBean>) request.getAttribute("advList");
AnnuncioBean ultimoAnnuncio =new AnnuncioBean();
List<String> listafoto = new ArrayList<String>(0);

if(!annunciList.isEmpty()){
	ultimoAnnuncio = annunciList.get(0);
	 listafoto= ultimoAnnuncio.getFoto();
}
%>

<c:if test="<%=annunciList.isEmpty()%>">
	
	<p> non hai annunci caricati </p>
	
	<portlet:actionURL name="addAnnuncio" var="addAnnuncio">

	</portlet:actionURL>
	<form id="form-modal" action="${addAnnuncio}"
				method="POST">
		<aui:button id="newAdv" type="submit" value="<%= LanguageUtil.get(themeDisplay.getLocale(), "add-annuncio")%>">
		</aui:button>
	</form>
	
</c:if>

<c:if test="${advList!=null}">
<c:if test="<%=!annunciList.isEmpty()%>">

<c:set value="<%=listafoto%>" var="listafoto"></c:set>


<div class="columns-2" id="content-wrapper">
    <table class="lfr-grid" id="layout-grid">
    <tr>
	    <td>
	    
	    
	      <c:forEach items="${listafoto}" var="fotoitem">                                                       
	      			 <img alt="foto item" src="${fotoitem}">	                                                                  
	     </c:forEach>
	      
	    </td>

   		<td>
	       <h2><%=ultimoAnnuncio.getTipologia() %></h2>
	       <br>
	       <p><%=ultimoAnnuncio.getDescrizione() %></p>
	    </td>
       </tr>
    </table>
</div>
<br>
<div class="columns-3" id="content-wrapper">
	<table class="lfr-grid" id="layout-grid">
	<tr>
		<td>
			<%=ultimoAnnuncio.getNomeUtente() %>
		</td>
		<td>
			<%=ultimoAnnuncio.getTelefono() %>
		</td>
		<td>
               <%=ultimoAnnuncio.getEmail() %>
		</td>
	</tr>
	</table>
</div>



<portlet:actionURL name="addAnnuncio" var="addAnnuncio">

</portlet:actionURL>
<form 
			id="form-modal" action="${addAnnuncio}"
			method="POST">
	<aui:button id="newAdv" type="submit" value="<%= LanguageUtil.get(themeDisplay.getLocale(), "add-annuncio")%>">
	</aui:button>
</form>
</c:if>
</c:if>