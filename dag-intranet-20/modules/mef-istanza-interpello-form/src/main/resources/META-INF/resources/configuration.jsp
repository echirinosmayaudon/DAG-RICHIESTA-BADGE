<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />

	<liferay-ui:panel title="Impostazioni configurazione">

		<liferay-ui:tabs names="Configurazione" refresh="false">
		
			<liferay-ui:section>
			
			    <aui:input type="text" name="formTitle" label="TITOLO FORM" value="<%=formTitle%>" />
				
				<aui:input type="text" name="formSubTitle" label="SOTTOTITOLO FORM" value="<%=formSubTitle%>" />
				
				<aui:input type="text" name="formTitleRecap" label="TITOLO RECAP" value="<%=formTitleRecap%>" />
				
				<aui:input type="text" name="formSubTitleRecap" label="SOTTOTITOLO RECAP" value="<%=formSubTitleRecap%>" />
				
				<aui:input type="text" name="formTitleDettaglio" label="TITOLO DETTAGLIO" value="<%=formTitleDettaglio%>" />
				
				<aui:input type="text" name="formSubTitleDettaglio" label="SOTTOTITOLO DETTAGLIO" value="<%=formSubTitleDettaglio%>" />
				
				<aui:input type="text" name="sender" label="MITTENTE" value="<%=sender%>" />
				
				<aui:input type="text" name="emailSubject" label="OGGETTO EMAIL" value="<%=emailSubject%>" />
				
				<aui:input type="text" name="emailToDipDT" label="DESTINATARIO EMAIL DIP DT" value="<%=emailToDipDT%>" />
				
				<aui:input type="text" name="emailToDipRGS" label="DESTINATARIO EMAIL DIP RGS" value="<%=emailToDipRGS%>" />
				
				<aui:input type="text" name="emailToDipDF" label="DESTINATARIO EMAIL DIP DF" value="<%=emailToDipDF%>" />
			     
			    <aui:input type="text" name="emailToDipDAG" label="DESTINATARIO EMAIL DIP DAG" value="<%=emailToDipDAG%>" />
		
				<liferay-ui:input-editor  name ='emailBodyEditor' initMethod="initEmailBodyEditor" height="50%"/>
			    <aui:input name="emailBody" type="hidden" value="" />
			    
			</liferay-ui:section>

		</liferay-ui:tabs>
			
	</liferay-ui:panel>
	
	<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>

<script type="text/javascript">

	function <portlet:namespace />initEmailBodyEditor() {
	     return "<%=emailBody%>";
	}
	
	function extractCodeFromEditor() {
	            var bodyEmail = document.<portlet:namespace />fm.<portlet:namespace />emailBody.value = window.<portlet:namespace />emailBodyEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
	}
	
</script>