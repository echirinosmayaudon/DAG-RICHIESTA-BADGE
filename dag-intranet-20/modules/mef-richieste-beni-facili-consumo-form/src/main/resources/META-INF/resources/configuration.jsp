<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="mef.richieste.beni.facili.consumo.portlet.MefRichiesteBeniFaciliConsumiConfig"%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />
<aui:form enctype="multipart/form-data" action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />
	
	<liferay-ui:panel title="Testo intestazioni per le pagine">
		<liferay-ui:tabs names="oggetto beni standard, oggetto beni informatica, form inserimento, riepilogo, lista richieste, gestione utenti, cerca richiesta" refresh="false">
		
			<liferay-ui:section>
				<aui:input type="text" label="valore per il campo oggetto beni standard" name="oggettoBeniStandard"
					value="<%=oggettoBeniStandard%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="valore per il campo oggetto beni informatica" name="oggettoBeniInformatica"
					value="<%=oggettoBeniInformatica%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo form di inserimento"
					name="formTitle" value="<%=formTitle%>" />
					<aui:input type="textarea" label="Sottotitolo form di inserimento"
					rows="5" cols="30" name="formSubtitle" value="<%=formSubtitle%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo riepilogo"
					name="riepilogoTitle" value="<%=riepilogoTitle%>" />
					<aui:input type="textarea" label="Sottotitolo riepilogo"
					rows="5" cols="30" name="riepilogoSubtitle" value="<%=riepilogoSubtitle%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo pagina lista richieste"
					name="listaTitle" value="<%=listaTitle%>" />
					<aui:input type="textarea" label="Sottotitolo pagina lista richieste"
					rows="5" cols="30" name="listaSubtitle" value="<%=listaSubtitle%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo pagina gestione utenti"
					name="gestioneUtentiTitle" value="<%=gestioneUtentiTitle%>" />
					<aui:input type="textarea" label="Sottotitolo pagina gestione utenti"
					rows="5" cols="30" name="gestioneUtentiSubtitle" value="<%=gestioneUtentiSubtitle%>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<aui:input type="text" label="Titolo pagina gestione utenti"
					name="cercaRichiestaTitle" value="<%=cercaRichiestaTitle%>" />
					<aui:input type="textarea" label="Sottotitolo pagina cerca richiesta"
					rows="5" cols="30" name="cercaRichiestaSubtitle" value="<%=cercaRichiestaSubtitle%>" />
			</liferay-ui:section>
			
		</liferay-ui:tabs>
	</liferay-ui:panel>
	<aui:fieldset>
	
	<liferay-ui:panel title="Configurazione Email per richiesta beni facili consumo">
		
		<liferay-ui:tabs names="richiesta beni, richiesta autorizzata, richiesta rifiutata" refresh="false">
	
		<liferay-ui:section>
			<aui:input type="text" name="senderBeni" label="mittente" value="<%=senderBeni%>" />
			<aui:input type="text" name="subjectNuova" label="oggetto email" value="<%=subjectNuova%>" />
			<aui:input type="text" name="emailReferente" label="indirizzo email referente beni facili consumo" value="<%=emailReferente%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditor' initMethod="richiestaEditor" height="50%"/>
	        <aui:input name="richiestaBeniTmpl" type="hidden" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="senderBeni" label="mittente" value="<%=senderBeni%>" />
			<aui:input type="text" name="subjectApprovazione" label="oggetto email" value="<%=subjectApprovazione%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorApprovazione' initMethod="richiestaEditorApprovazione" height="50%"/>
	        <aui:input name="approvatoTmpl" type="hidden" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="senderBeni" label="mittente" value="<%=senderBeni%>" />
			<aui:input type="text" name="subjectRifiuta" label="oggetto email" value="<%=subjectRifiuta%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorRifiuta' initMethod="richiestaEditorRifiuta" height="50%"/>
	        <aui:input name="rifiutaTmpl" type="hidden" value="" />
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input type="text" name="senderBeni" label="mittente" value="<%=senderBeni%>" />
			<aui:input type="text" name="subjectAggiorna" label="oggetto email" value="<%=subjectAggiorna%>" />
			<liferay-ui:input-editor  name ='richiestatxtEditorModifica' initMethod="richiestaEditorModifica" height="50%"/>
	        <aui:input name="aggiornaTmpl" type="hidden" value="" />
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
				<aui:option value="12">12</aui:option>
				<aui:option value="15">15</aui:option>
				<aui:option value="20">20</aui:option>
			</aui:select>

     
		</aui:fieldset>
	
	<liferay-ui:panel title="Informazioni per il ritiro dei beni di facile consumo">
		<aui:fieldset>
				<aui:input type="text" name="orarioRitiro" label="orario ritiro beni di facile consumo" value="<%=orarioRitiro%>" />
		</aui:fieldset>
		
		<aui:fieldset>
				<aui:input type="text" name="orarioSostituzione" label="orario sostituzione beni di facile consumo" value="<%=orarioSostituzione%>" />
		</aui:fieldset>
		
		<aui:fieldset>
				<aui:input type="text" name="indirizzoMagazzino" label="indirizzo del magazzino consegnatario" value="<%=indirizzoMagazzino%>" />
		</aui:fieldset>
		<aui:fieldset>
				<aui:input type="text" name="ubicazioneMagazzino" label="ubicazione del magazzino consegnatario" value="<%=ubicazioneMagazzino%>" />
		</aui:fieldset>
	</liferay-ui:panel>
	
	
	<liferay-ui:panel title="Configurazione approvazione per i dipartimenti">
	  	<aui:fieldset>

			<aui:select name="approvazioneDT" label="Procedura di approvazione per dipartimento del tesoro"
				value="<%= approvazioneDT %>">
				<aui:option value="SI">SI</aui:option>
				<aui:option value="NO">NO</aui:option>
			</aui:select>
			
			<aui:select name="approvazioneRGS" label="Procedura di approvazione per dipartimento di ragioneria generale dello stato"
				value="<%= approvazioneRGS %>">
				<aui:option value="SI">SI</aui:option>
				<aui:option value="NO">NO</aui:option>
			</aui:select>
			
			<aui:select name="approvazioneDF" label="Procedura di approvazione per dipartimento delle finanze"
				value="<%= approvazioneDF %>">
				<aui:option value="SI">SI</aui:option>
				<aui:option value="NO">NO</aui:option>
			</aui:select>
			
			<aui:select name="approvazioneDAG" label="Procedura di approvazione per dipartimento di amministrazione generale del personale e dei servizi del tesoro"
				value="<%= approvazioneDAG %>">
				<aui:option value="SI">SI</aui:option>
				<aui:option value="NO">NO</aui:option>
			</aui:select>
     
		</aui:fieldset>
	  
	</liferay-ui:panel>
	
	<liferay-ui:panel title="Puntamenti GECO-PIGRECO">
	  	<aui:fieldset>
			<aui:select name="ambienteGecoPigreco" label="puntamenti ambiente GECO-PIGRECO"
				value="<%= ambienteGecoPigreco %>">
				<aui:option value="esercizio">esercizio</aui:option>
				<aui:option value="collaudo">collaudo</aui:option>
			</aui:select>			
		</aui:fieldset>
	  
	</liferay-ui:panel>
	
	<liferay-ui:panel title="configurazione GECO-PIGRECO">
		<aui:fieldset>
				<aui:input type="text" name="listaUfficiGeco" label="lista di uffici per i quali viene configurato il servizio GECO" value="<%=listaUfficiGeco%>" />
		</aui:fieldset>
	</liferay-ui:panel>
		
		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>	

</aui:form>

<script type="text/javascript">

            function <portlet:namespace />richiestaEditor() {
                 return "<%=richiestaBeniTmpl%>";
            }
            
            function <portlet:namespace />richiestaEditorApprovazione() {
                return "<%=approvatoTmpl%>";
           }
            
            function <portlet:namespace />richiestaEditorRifiuta() {
                return "<%=rifiutaTmpl%>";
           }
            
            function <portlet:namespace />richiestaEditorModifica() {
                return "<%=aggiornaTmpl%>";
           }
            
            function extractCodeFromEditor() {
                        var nuo = document.<portlet:namespace />fm.<portlet:namespace />richiestaBeniTmpl.value = window.<portlet:namespace />richiestatxtEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");        
                        var app = document.<portlet:namespace />fm.<portlet:namespace />approvatoTmpl.value = window.<portlet:namespace />richiestatxtEditorApprovazione.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var rif = document.<portlet:namespace />fm.<portlet:namespace />rifiutaTmpl.value = window.<portlet:namespace />richiestatxtEditorRifiuta.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");   
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />aggiornaTmpl.value = window.<portlet:namespace />richiestatxtEditorModifica.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");        
            }
</script>