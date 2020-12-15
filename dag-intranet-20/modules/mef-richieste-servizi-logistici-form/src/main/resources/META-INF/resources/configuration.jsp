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

    
	
<liferay-ui:panel title="testo intestazioni per le pagine">
<liferay-ui:tabs names="servizi logistici, servizi logistici elenco, servizi logistici dettaglio" refresh="false">
<liferay-ui:section>
  <aui:input type="text" label="Titolo Servizi Logistici" name="serviziLogisticititle" value="<%=serviziLogisticititle%>"/>
 <aui:input type="textarea" label="Sottotitolo Servizi Logistici" rows="5" cols="30"  name="serviziLogisticitxt" value="<%=serviziLogisticitxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
  <aui:input type="text" label="Titolo Servizi Logistici Elenco"  name="serviziLogisticiElencotitle" value="<%=serviziLogisticiElencotitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Servizi Logistici Elenco" rows="5" cols="30"  name="serviziLogisticiElencotxt" value="<%=serviziLogisticiElencotxt%>"/>
</liferay-ui:section>
<liferay-ui:section>
  <aui:input type="text" label="Titolo Servizi Logistici Dettaglio"  name="serviziLogisticiDettagliotitle" value="<%=serviziLogisticiDettagliotitle%>"/>
</liferay-ui:section>

</liferay-ui:tabs>
</liferay-ui:panel>	
	
	
	
	

<aui:fieldset>
		<liferay-ui:panel title="Configurazione Email per le richieste servizi tecnici">
		
	<liferay-ui:tabs names="inserimento richiesta, cambio stato richiesta" refresh="false">
		
		<liferay-ui:section>		
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subject" label="oggetto email" value="<%=subject%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditor' initMethod="richiestaEditor" height="50%"/>
	        <aui:input name="richiestaTmpl" type="hidden" value="" />
	  </liferay-ui:section>	
	  <liferay-ui:section>
	  
	        <aui:input type="text" name="cambioStatosender" label="mittente" value="<%=cambioStatosender%>" />
			<aui:input type="text" name="cambioStatosubject" label="oggetto email" value="<%=cambioStatosubject%>" />

			<liferay-ui:input-editor  name ='cambioStatotxtEditor' initMethod="cambioStatoEditor" height="50%"/>
	        <aui:input name="cambioStatoTmpl" type="hidden" value="" />
	  
	  
	   </liferay-ui:section>	
			</liferay-ui:tabs>
		</liferay-ui:panel>
	</aui:fieldset>	
		
		<aui:fieldset>

			<aui:select name="itemsPerPage" label="Configurazione numero di richieste per pagina in elenco"
				value="<%= itemsPerPage %>">
				<aui:option value="2">2</aui:option>
				<aui:option value="5">5</aui:option>
				<aui:option value="6">6</aui:option>
				<aui:option value="10">10</aui:option>
				<aui:option value="15">15</aui:option>
				<aui:option value="20">20</aui:option>
			</aui:select>

		</aui:fieldset>
	
	
	
		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>
<script type="text/javascript">

            function <portlet:namespace />richiestaEditor() {
                 return "<%=richiestaTmpl%>";
            }
            
            function <portlet:namespace />cambioStatoEditor() {
                return "<%=cambioStatoTmpl%>";
           }
            
            function extractCodeFromEditor() {
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />richiestaTmpl.value = window.<portlet:namespace />richiestatxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");  
                        var cas = document.<portlet:namespace />fm.<portlet:namespace />cambioStatoTmpl.value = window.<portlet:namespace />cambioStatotxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'"); 
            }
</script>