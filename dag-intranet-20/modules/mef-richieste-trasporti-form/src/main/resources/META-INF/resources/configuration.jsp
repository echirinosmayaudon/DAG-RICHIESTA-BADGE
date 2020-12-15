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

    
	

	
	
	
	<liferay-ui:panel title="Template per body email">

	<liferay-ui:tabs names="Richiesta Rimborso" refresh="false">
	<liferay-ui:section>
	    <aui:input type="text" name="senderRichiestaRimborso" label="mittente" value="<%=senderRichiestaRimborso%>" />
		<aui:input type="text" name="subjectRichiestaRimborso" label="oggetto" value="<%=subjectRichiestaRimborso%>" />
		<aui:input type="text" name="emailReferente" label="email" value="<%=emailReferente%>" />
	     
		 <liferay-ui:input-editor  name ='richiestaRimborsoEditor' initMethod="initRichiestaRimborsoEditor" height="50%"/>
	    <aui:input name="richiestaRimborsoTmpl" type="hidden" value="" />
	</liferay-ui:section>

	
</liferay-ui:tabs>
			
</liferay-ui:panel>



	<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>

<script type="text/javascript">

            function <portlet:namespace />initRichiestaRimborsoEditor() {
                 return "<%=richiestaRimborsoTmpl%>";
            }
            
           
			
            
            function extractCodeFromEditor() {
                        var richiestaRimborso = document.<portlet:namespace />fm.<portlet:namespace />richiestaRimborsoTmpl.value = window.<portlet:namespace />richiestaRimborsoEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
            }
</script>

