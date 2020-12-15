<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@ page import="com.liferay.asset.kernel.service.AssetLinkLocalServiceUtil"%>
<%@ page import="com.liferay.asset.kernel.model.AssetLink"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@ page import="com.liferay.journal.model.*"%>
<%@ page import="com.liferay.journal.service.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@ page import="org.xml.sax.InputSource"%>
<%@ page import="java.io.StringReader"%>
<%@ page import="org.w3c.dom.*"%>


<portlet:renderURL var="goBackURL">	
<portlet:param name="redirect" value="/documents.jsp"/>
</portlet:renderURL>

<button><a href="${goBackURL}">go back</a></button>

<%
String id = request.getParameter("doc"); 
DLFileEntry file = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(id));
AssetEntry assFile=AssetEntryLocalServiceUtil.getEntry(DLFileEntry.class.getName(),Long.parseLong(id));
List<AssetLink> relatedList=new ArrayList<AssetLink>();
relatedList=AssetLinkLocalServiceUtil.getDirectLinks(assFile.getEntryId());

for(AssetLink l:relatedList){	
	AssetEntry relAsset=AssetEntryLocalServiceUtil.getAssetEntry(l.getEntryId2());	
	DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    InputSource src = new InputSource();
    src.setCharacterStream(new StringReader(relAsset.getTitle()));
    Document doc = builder.parse(src);
    String title = doc.getElementsByTagName("Title").item(0).getTextContent();
    System.out.println("tit:"+title);
      
    JournalArticleResource cont= JournalArticleResourceLocalServiceUtil.getJournalArticleResource(relAsset.getClassPK());
    System.out.println("cont"+(JournalArticleLocalServiceUtil.getArticle(cont.getGroupId(), cont.getArticleId())).getContent());
    InputSource src1 = new InputSource();
    src1.setCharacterStream(new StringReader((JournalArticleLocalServiceUtil.getArticle(cont.getGroupId(), cont.getArticleId())).getContent()));
    Document doc2 = builder.parse(src1);
    String content = doc2.getElementsByTagName("dynamic-content").item(0).getTextContent();
    System.out.println("content:"+content);
    
	%>
	<h2><%=file.getTitle()%> </h2>
	
	<c:if test="<%=relatedList!=null%>">
	<div>Related Assets:</div>
	<liferay-ui:panel title="<%=title%>" collapsible="true" extended="true" id="relatedAsset">
        <p><%=content%></p>

    </liferay-ui:panel>
	</c:if>
	<%
	}
    %> 

<liferay-ui:tabs names="details" refresh="<%= false %>"
	type="dropdown">
	<liferay-ui:section>
		<div class="sidebar-body">
			<dl>
				<dt class="h5">
					<liferay-ui:message key="created by:" />
				</dt>
				<dd><%=assFile.getUserName()%> </dd>
				<dt class="h5">
					<liferay-ui:message key="description:" />
				</dt>
				<dd>
					<%=file.getDescription()%>
				</dd>
				<dt class="h5">
					<liferay-ui:message key="extension:" />
				</dt>
				<dd><%=file.getExtension()%> </dd>
				</dd>
				<dl class="h5">
					<liferay-ui:message key="size" />
				</dl>
				<dd><%=(file.getFileVersion().getSize())/1000%> KB </dd>			
			</dl>
		</div>
	</liferay-ui:section>

	
</liferay-ui:tabs>
