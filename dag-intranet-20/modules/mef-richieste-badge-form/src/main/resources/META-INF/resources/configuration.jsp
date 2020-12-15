<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="mef.richieste.badge.portlet.MefRichiesteBadgeConfig"%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />
	<aui:fieldset>
	<liferay-ui:panel title="Configurazione Email Referente per le richieste badge">
				<aui:input type="text" name="emailReferente" label="indirizzo email referente badge" value="<%=emailReferente%>" />
	</liferay-ui:panel>
	</aui:fieldset>
	
	
	
	<aui:fieldset>
		<liferay-ui:panel title="Configurazione del testo per le intestazioni delle pagine">
			<aui:input type="text" label="Titolo form di inserimento" name="formTitle" value="<%=formTitle%>" />
			<aui:input type="textarea" label="Sottotitolo form di inserimento" rows="5" cols="30" name="formSubtitle" value="<%=formSubtitle%>" />
			
			<aui:input type="text" label="Titolo gestione utenti" name="gestioneUtentiTitle" value="<%=gestioneUtentiTitle%>" />
			<aui:input type="textarea" label="Sottotitolo gestione utenti" rows="5" cols="30" name="gestioneUtentiSubtitle" value="<%=gestioneUtentiSubtitle%>" />
			
			<aui:input type="text" label="Titolo form di ricerca" name="ricercaTitle" value="<%=ricercaTitle%>" />
			<aui:input type="textarea" label="Sottotitolo form di ricerca" rows="5" cols="30" name="ricercaSubtitle" value="<%=ricercaSubtitle%>" />
			
			<aui:input type="text" label="Titolo servizio proroga" name="servizioProrogaTitle" value="<%=servizioProrogaTitle%>" />
			<aui:input type="textarea" label="Sottotitolo servizio proroga" rows="5" cols="30" name="servizioProrogaSubtitle" value="<%=servizioProrogaSubtitle%>" />
			
			<aui:input type="text" label="Titolo riepilogo proroga" name="riepilogoProrogaTitle" value="<%=riepilogoProrogaTitle%>" />
			<aui:input type="textarea" label="Sottotitolo riepilogo proroga" rows="5" cols="30" name="riepilogoProrogaSubtitle" value="<%=riepilogoProrogaSubtitle%>" />
		</liferay-ui:panel>
		
		<liferay-ui:panel title="Configurazione del numero di elementi per pagina nella paginazione dei risultati della ricerca">
			<aui:input type="text" label="Numero elementi per pagina" name="itemsPerPage" value="<%=itemsPerPage%>" />	
		</liferay-ui:panel>
		
		<liferay-ui:panel title="Configurazione del numero di elementi per pagina nella paginazione della lista degli utenti in gestione utenti">
			<aui:input type="text" label="Numero elementi per pagina" name="itemsPerPageUtenti" value="<%=itemsPerPageUtenti%>" />	
		</liferay-ui:panel>
	
		<liferay-ui:panel title="Configurazione Oggetto Email per le nuove richieste badge">
			<aui:input type="text" name="subjectNuova" label="oggetto email" value="<%=subjectNuova%>" />
		</liferay-ui:panel>
		
		<liferay-ui:panel title="Configurazione Oggetto Email richiesta di modifica">
			<aui:input type="text" name="subjectRichiediModifica" label="oggetto email" value="<%=subjectRichiediModifica%>" />	
		</liferay-ui:panel>
		
		<liferay-ui:panel title="Configurazione Oggetto Email modifica">
			<aui:input type="text" name="subjectModifica" label="oggetto email" value="<%=subjectModifica%>" /> 		
		</liferay-ui:panel>
		
		<liferay-ui:panel title="Configurazione Oggetto Email approvazione">
			<aui:input type="text" name="subjectApprova" label="oggetto email" value="<%=subjectApprova%>" />  		
		</liferay-ui:panel>
		
		<liferay-ui:panel title="Configurazione Oggetto Email rifiuto">
			<aui:input type="text" name="subjectRifiuta" label="oggetto email" value="<%=subjectRifiuta%>" />		
		</liferay-ui:panel>
		
		<liferay-ui:panel title="Configurazione mittente, template">
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
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
		