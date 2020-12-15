<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="mef.whistleblowing.form.portlet.MefWhistleBlowingConfig"%>
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
		<liferay-ui:panel title="Configurazione Email per le segnalazioni">
			<aui:input type="text" name="emailReferente" label="indirizzo email referente per la segnalazione" value="<%=emailReferente%>" />
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subject" label="oggetto email" value="<%=subject%>" />
			<liferay-ui:input-editor  name ='segnalazionetxtEditor' initMethod="segnalazioneEditor" height="50%"/>
	        <aui:input name="segnalazioneTmpl" type="hidden" value="" />
		</liferay-ui:panel>
	</aui:fieldset>	
	
	<liferay-ui:panel title="Configurazione salvataggio a DB">
	  	<aui:fieldset>

			<aui:select name="salvataggioDB" label="Prevedere salvataggio della segnalazione a DB"
				value="<%= salvataggioDB %>">
				<aui:option value="SI">SI</aui:option>
				<aui:option value="NO">NO</aui:option>
			</aui:select>
     
		</aui:fieldset>
	  
	</liferay-ui:panel>
		
	
		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>
<script type="text/javascript">

            function <portlet:namespace />segnalazioneEditor() {
                 return "<%=segnalazioneTmpl%>";
            }
            
  
            
            function extractCodeFromEditor() {
                 var mod = document.<portlet:namespace />fm.<portlet:namespace />segnalazioneTmpl.value = window.<portlet:namespace />segnalazionetxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");        
            }
</script>
