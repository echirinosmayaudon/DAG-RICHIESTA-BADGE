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


<!--<c:set var="annunciList" value="${advList}"/>  -->


<%

ThemeDisplay tDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
String currentUrl=tDisplay.getURLCurrent();

List<AnnuncioBean>annunciList=(List<AnnuncioBean>) request.getAttribute("advList");

if(annunciList!=null && !annunciList.isEmpty())
annunciList = annunciList.subList(0, 4 > annunciList.size() ? annunciList.size() : 4);


%>



<c:if test="${advList!=null}">

	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title title-with-arrow">
					<h2 class="title-box borders"><liferay-ui:message key="bacheca-annunci" /></h2>
					<a href="${linkLayoutmyUrl}" class="icomoon-vai"></a>
				</div>
			</div>
		</div>
	</div>

	<div class="ama-container-fluid wrapper-notice-board pb-50-xs">
		<div class="ama-row carousel-notice-board">

			<c:if test="<%=annunciList!= null%>">
			<% int count=0; %>
				<c:set value="<%=annunciList%>" var="annunciList" />
				<c:forEach items="${annunciList}" var="annuncio">
				<%AnnuncioBean annuncio=(AnnuncioBean)pageContext.getAttribute("annuncio"); %>

					<c:set value="<%=annunciList%>" var="annunciList" />
					
					<div class="ama-col-md-6 ama-col-xs-12">
						
						
						
						<a  id="<portlet:namespace/>href<%=count%>" href="${linkLayoutmyUrl}&_${porletId_Bacheca}_annuncioId=${annuncio.getId()}&_${porletId_Bacheca}_navigation=advdetail"class="notice-board">
							<div class="ama-row">
								<div class="ama-col-sm-4 ama-col-xs-12">
									<div class="image-bacheca icomoon-${annuncio.getCategoriaDescrizione()}"></div>													
									<p class="style-title">${annuncio.getCategoriaNome()}</p>
								</div>
								<div class="ama-col-sm-8 ama-col-xs-12 border-left">
									<div class="clearfix">
										<c:if
											test="${fn:contains(annuncio.getTipologia(), 'offresi')}">
											<p class="second-title"><liferay-ui:message key="offerta-uppercase" /></p>
										</c:if>
										<c:if
											test="${fn:contains(annuncio.getTipologia(), 'cercasi')}">
											<p class="second-title"><liferay-ui:message key="richiesta-uppercase" /></p>
										</c:if>
										 	<c:if test='<%=annuncio.getZona()!=null && !annuncio.getZona().equalsIgnoreCase("")%>'>
										<div class="wrapper-content">
											<p class="style-city">${annuncio.getZona().toUpperCase()}</p>
											<div class="icomoon-pin"></div>
										</div>
										</c:if>
									</div>
									<p
										class="description dot-point dot-170 dot-mobile is-truncated"
										style="word-wrap: break-word;">
										${annuncio.getDescrizione()}</p>
									<div class="wrapper-content-user">
										<div class="icomoon-user"></div>
										<div class="name">
											<p>${annuncio.getNomeUtente()}</p>
											<p>${annuncio.getTelefono()}</p>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					<%
						count++;
					%>
				</c:forEach>
			</c:if>





		</div>
	</div>







</c:if>




