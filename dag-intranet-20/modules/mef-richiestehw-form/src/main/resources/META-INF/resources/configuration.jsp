<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="mef.richiestehw.portlet.MefRichiestehwConfig"%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />

	<liferay-ui:panel title="testo intestazioni per le pagine">
		<liferay-ui:tabs names="form inserimento, riepilogo" refresh="false">
			<liferay-ui:section>
				<aui:input type="text" label="Titolo form di inserimento"
					name="formTitle" value="<%=formTitle%>" />
				<aui:input type="textarea" label="Sottotitolo form di inserimento"
					rows="5" cols="30" name="formSubtitle" value="<%=formSubtitle%>" />
			</liferay-ui:section>

			<liferay-ui:section>
				<aui:input type="text" label="Titolo riepilogo" name="recapTitle"
					value="<%=recapTitle%>" />
				<aui:input type="textarea" label="Sottotitolo riepilogo" rows="5"
					cols="30" name="recapSubtitle" value="<%=recapSubtitle%>" />
			</liferay-ui:section>
		</liferay-ui:tabs>
	</liferay-ui:panel>

	<aui:fieldset>
		<liferay-ui:panel title="Configurazione Email per le richieste Hardware e Software">
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subject" label="oggetto email" value="<%=subject%>" />
			<aui:input type="text" name="emailReferente" label="indirizzo email referente informatico" value="<%=emailReferente%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditor' initMethod="richiestaEditor" height="50%"/>
	        <aui:input name="richiestaTmpl" type="hidden" value="" />
			
			
		</liferay-ui:panel>
	</aui:fieldset>	
		
	
		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>
<script type="text/javascript">

            function <portlet:namespace />richiestaEditor() {
                 return "<%=richiestaTmpl%>";
            }
            
  
            
            function extractCodeFromEditor() {
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />richiestaTmpl.value = window.<portlet:namespace />richiestatxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");        
            }
</script>
