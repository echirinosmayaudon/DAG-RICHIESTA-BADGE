<%@ include file="./init.jsp" %>

<portlet:actionURL name="invokeJob" var="invokeJobURL" />

<h2 class="text-center">Configurazione Job</h2>
<div class="container">
	<aui:form action="<%=invokeJobURL.toString() %>">
		<strong> Creazione/Update Custom Fields <aui:input name="cf-enabled" label="" type="toggle-switch"></aui:input></strong>
			JSON dei valori 'custom_fields':[{'name':'nome_cf','type':'type_cf', 'defaultValue':'default_cf'}, {...} ...] <br>
			Type consentiti: "BOOLEAN","STRING","LONG","DATE"
			<aui:input label="" name="cf-json" type="textarea"></aui:input>
		<hr>
		<strong> Creazione/Update Team Sedi <aui:input label="" name="location-enabled" type="toggle-switch"></aui:input></strong>
		<hr>
		<strong> Creazione/Update Team Organigramma & Ruoli <aui:input label="" name="teamAndRoles-enabled" type="toggle-switch"></aui:input></strong>
		
		<aui:button cssClass="center-block" type="submit" name="start" value="Esegui Job"></aui:button>	 
	</aui:form>
</div>