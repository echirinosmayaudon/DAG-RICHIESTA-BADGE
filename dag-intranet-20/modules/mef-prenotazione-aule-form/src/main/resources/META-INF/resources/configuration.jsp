<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="mef.prenotazione.aule.portlet.MefPrenotazioneAuleConfig"%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />
<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />
	
	
	
	<liferay-ui:panel title="Testo intestazioni per le pagine">
		<liferay-ui:tabs names="ricerca aule, le tue prenotazioni , prenotazione aule, le tue prenotazioni approvatori " refresh="false">
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo di ricerca aule"
					name="formTitleRicercaAule" value="<%=formTitleRicercaAule%>" />
				<aui:input type="textarea" label="Sottotitolo di ricerca aule"
					rows="5" cols="30" name="formSubtitleRicercaAule" value="<%=formSubtitleRicercaAule%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo di le tue prenotazioni"
					name="formTitleLeTuePrenotazioni" value="<%=formTitleLeTuePrenotazioni%>" />
				<aui:input type="textarea" label="Sottotitolo di le tue prenotazioni"
					rows="5" cols="30" name="formSubtitleLeTuePrenotazioni" value="<%=formSubtitleLeTuePrenotazioni%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo di prenotazione aule"
					name="formTitleInsertPrenotazioni" value="<%=formTitleInsertPrenotazioni%>" />
				<aui:input type="textarea" label="Sottotitolo di prenotazione aule"
					rows="5" cols="30" name="formSubtitleInsertPrenotazioni" value="<%=formSubtitleInsertPrenotazioni%>"/>
			</liferay-ui:section>
			

		<liferay-ui:section>
				<aui:input type="text" label="Titolo di le tue prenotazioni per approvatore"
					name="formTitleRicercaAuleApprovatore" value="<%=formTitleRicercaAuleApprovatore%>" />
				<aui:input type="textarea" label="Sottotitolo di le tue prenotazioni approvatore"
					rows="5" cols="30" name="formSubtitleRicercaAuleApprovatore" value="<%=formSubtitleRicercaAuleApprovatore%>"/>
			</liferay-ui:section>
			
		
			</liferay-ui:tabs>
			
			
			
			</liferay-ui:panel>
	
	
	
	<aui:fieldset>
	
	
	
	
	
		<liferay-ui:panel title="Configurazione Email per prenotazione aule">
		
		<liferay-ui:tabs names="prenotazione senza approvazione, prenotazione con approvazione, prenotazione autorizzata, prenotazione rifiutata, prenotazione modificata, prenotazione eliminata" refresh="false">
		
		<liferay-ui:section>
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subjectNoApprovazione" label="oggetto email prenotazione senza approvazione" value="<%=subjectNoApprovazione%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorNoApprovazione' initMethod="richiestaEditorNoApprovazione" height="50%"/>
			<aui:input type="hidden" name="richiestaNoApprovazioneTmpl"  label="" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subjectApprovazione" label="oggetto email richiesta di prenotazione con approvazione" value="<%=subjectApprovazione%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorApprovazione' initMethod="richiestaEditorApprovazione" height="50%"/>
			<aui:input type="hidden" name="richiestaApprovazioneTmpl"  label="" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subjectPrenotazioneAutorizzata" label="oggetto email accettazione prenotazione aula" value="<%=subjectPrenotazioneAutorizzata%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorAccettazione' initMethod="richiestaEditorAccettazione" height="50%"/>
			<aui:input type="hidden" name="prenotazioneAutorizzataTmpl"  value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subjectPrenotazioneRifiutata" label="oggetto email rifiuto prenotazione aula" value="<%=subjectPrenotazioneRifiutata%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorRifiuto' initMethod="richiestaEditorRifiuto" height="50%"/>
			<aui:input type="hidden" name="prenotazioneRifiutataTmpl"  value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subjectPrenotazioneModificata" label="oggetto email prenotazione modificata" value="<%=subjectPrenotazioneModificata%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorModifica' initMethod="richiestaEditorModifica" height="50%"/>
			<aui:input type="hidden" name="prenotazioneModificataTmpl"  label="" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subjectPrenotazioneEliminata" label="oggetto email prenotazione eliminata" value="<%=subjectPrenotazioneEliminata%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorElimina' initMethod="richiestaEditorElimina" height="50%"/>
			<aui:input type="hidden" name="prenotazioneEliminataTmpl"  label="" value="" />
		</liferay-ui:section>
		
		</liferay-ui:tabs>
		
		</liferay-ui:panel>
		
	</aui:fieldset>	
		
	
		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>
	
</aui:form>
<script type="text/javascript">

            function <portlet:namespace />richiestaEditorNoApprovazione() {
                 return "<%=richiestaNoApprovazioneTmpl%>";
            }
            
            function <portlet:namespace />richiestaEditorApprovazione() {
                return "<%=richiestaApprovazioneTmpl%>";
            }
            
            function <portlet:namespace />richiestaEditorAccettazione() {
                return "<%=prenotazioneAutorizzataTmpl%>";
           	}
            
            function <portlet:namespace />richiestaEditorRifiuto() {
                return "<%=prenotazioneRifiutataTmpl%>";
           	}
            
            function <portlet:namespace />richiestaEditorModifica() {
                return "<%=prenotazioneModificataTmpl%>";
           	}
            
            function <portlet:namespace />richiestaEditorElimina() {
                return "<%=prenotazioneEliminataTmpl%>";
           	}
            
            function extractCodeFromEditor() {
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />richiestaNoApprovazioneTmpl.value = window.<portlet:namespace />richiestatxtEditorNoApprovazione.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />richiestaApprovazioneTmpl.value = window.<portlet:namespace />richiestatxtEditorApprovazione.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");   
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />prenotazioneAutorizzataTmpl.value = window.<portlet:namespace />richiestatxtEditorAccettazione.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");   
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />prenotazioneRifiutataTmpl.value = window.<portlet:namespace />richiestatxtEditorRifiuto.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");   
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />prenotazioneModificataTmpl.value = window.<portlet:namespace />richiestatxtEditorModifica.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");   
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />prenotazioneEliminataTmpl.value = window.<portlet:namespace />richiestatxtEditorElimina.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");   
            }
</script>
