<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.PrefsParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="mef.richieste.beni.inventariati.portlet.MefRichiesteBeniInventariatiConfig"%>
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
<liferay-ui:tabs names="beni inventariati ricerca, beni inventariati inserimento" refresh="false">
<liferay-ui:section>
  <aui:input type="text" label="Titolo Beni Inventariati Ricerca" name="beniInvRicercaTitle" value="<%=beniInvRicercaTitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Beni Inventariati Ricerca" rows="5" cols="30"  name="beniInvRicercaTxt" value="<%=beniInvRicercaTxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
  <aui:input type="text" label="Titolo Beni Inventariati Inserimento"  name="beniInvInserimentoTitle" value="<%=beniInvInserimentoTitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Beni Inventariati Inserimento" rows="5" cols="30"  name="beniInvInserimentoTxt" value="<%=beniInvInserimentoTxt%>"/>
</liferay-ui:section>

</liferay-ui:tabs>
</liferay-ui:panel>	
		
		
		
		<aui:fieldset>
		<liferay-ui:panel title="Configurazione Email per richieste di beni inventariati">
		
		<liferay-ui:tabs names="nuova richiesta, cambio stato (consegnatario), cambio stato(CDC)" refresh="false">
		
		<liferay-ui:section>
		<aui:input type="text" name="nuovaRichiestaSender" label="mittente" value="<%=nuovaRichiestaSender%>" />
			<aui:input type="text" name="nuovaRichiestaSubject" label="oggetto email" value="<%=nuovaRichiestaSubject%>" />
			<liferay-ui:input-editor  name ='nuovaRichiestatxtEditor' initMethod="nuovaRichiestaEditor" height="50%"/>
	        <aui:input name="nuovaRichiestaTmpl" type="hidden" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
		<aui:input type="text" name="cambioStatoConsegnatarioSender" label="mittente" value="<%=cambioStatoConsegnatarioSender%>" />
			<aui:input type="text" name="cambioStatoConsegnatarioSubject" label="oggetto email" value="<%=cambioStatoConsegnatarioSubject%>" />
			<liferay-ui:input-editor  name ='cambioStatoConsegnatariotxtEditor' initMethod="cambioStatoConsegnatarioEditor" height="50%"/>
	        <aui:input name="cambioStatoConsegnatarioTmpl" type="hidden" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
		<aui:input type="text" name="cambioStatoCDCSender" label="mittente" value="<%=cambioStatoCDCSender%>" />
			<aui:input type="text" name="cambioStatoCDCSubject" label="oggetto email" value="<%=cambioStatoCDCSubject%>" />
			<liferay-ui:input-editor  name ='cambioStatoCDCtxtEditor' initMethod="cambioStatoCDCEditor" height="50%"/>
	        <aui:input name="cambioStatoCDCTmpl" type="hidden" value="" />
		</liferay-ui:section>
			
			
			
		</liferay-ui:tabs>
		
		</liferay-ui:panel>
	</aui:fieldset>	


		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>
</aui:form>

<script type="text/javascript">

            function <portlet:namespace />nuovaRichiestaEditor() {
                 return "<%=nuovaRichiestaTmpl%>";
            }
            
            function <portlet:namespace />cambioStatoConsegnatarioEditor() {
                return "<%=cambioStatoConsegnatarioTmpl%>";
           }
            
            function <portlet:namespace />cambioStatoCDCEditor() {
                return "<%=cambioStatoCDCTmpl%>";
           }
            
            function extractCodeFromEditor() {
                        var nuovaRich = document.<portlet:namespace />fm.<portlet:namespace />nuovaRichiestaTmpl.value = window.<portlet:namespace />nuovaRichiestatxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");   
                        var cambioStatoCons = document.<portlet:namespace />fm.<portlet:namespace />cambioStatoConsegnatarioTmpl.value = window.<portlet:namespace />cambioStatoConsegnatariotxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");        
                        var cambioStatoCDC = document.<portlet:namespace />fm.<portlet:namespace />cambioStatoCDCTmpl.value = window.<portlet:namespace />cambioStatoCDCtxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");        
            }
</script>