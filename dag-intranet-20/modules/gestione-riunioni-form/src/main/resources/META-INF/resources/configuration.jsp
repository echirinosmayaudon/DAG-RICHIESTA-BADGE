<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.intranet.mef.portlet.GestioneRiunioniFormConfig"%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />

     <aui:fieldset>

		<aui:select name="itemsPerPage" label="Number of Documents"
			value="<%= itemsPerPage %>">
			<aui:option value="5">5</aui:option>
			<aui:option value="6">6</aui:option>
			<aui:option value="10">10</aui:option>
			<aui:option value="15">15</aui:option>
			<aui:option value="20">20</aui:option>
		</aui:select>

	</aui:fieldset>
	
<liferay-ui:panel title="testo intestazioni per le pagine">
<liferay-ui:tabs names="ricerca riunione, crea riunione, luoghi riunione, convocanti riunione, modifica riunione, stampa riunione, accetta riunione" refresh="false">
<liferay-ui:section>
  <aui:input type="text" label="Titolo Ricerca Riunione" name="ricercaRiunionetitle" value="<%=ricercaRiunionetitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Ricerca Riunione" rows="5" cols="30"  name="ricercaRiunionetxt" value="<%=ricercaRiunionetxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
  <aui:input type="text" label="Titolo Crea Riunione"  name="creaRiunionetitle" value="<%=creaRiunionetitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Crea Riunione" rows="5" cols="30"  name="creaRiunionetxt" value="<%=creaRiunionetxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
 <aui:input type="text" label="Titolo Luoghi Riunione"   name="luoghiRiunionetitle" value="<%=luoghiRiunionetitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Luoghi Riunione" rows="5" cols="30"  name="luoghiRiunionetxt" value="<%=luoghiRiunionetxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
 <aui:input type="text" label="Titolo Convocanti Riunione"  name="convocantiRiunionetitle" value="<%=convocantiRiunionetitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Convocanti Riunione" rows="5" cols="30"  name="convocantiRiunionetxt" value="<%=convocantiRiunionetxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
 <aui:input type="text" label="Titolo Modifica Riunione"   name="modificaRiunionetitle" value="<%=modificaRiunionetitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Modifica Riunione" rows="5" cols="30"  name="modificaRiunionetxt" value="<%=modificaRiunionetxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
 <aui:input type="text" label="Titolo Stampa Riunione"  name="stampaRiunionetitle" value="<%=stampaRiunionetitle%>"/>
 <aui:input type="textarea" label="Sottotitolo Stampa Riunione" rows="5" cols="30"  name="stampaRiunionetxt" value="<%=stampaRiunionetxt%>"/>
</liferay-ui:section>

<liferay-ui:section>
	<aui:input type="text" label="Titolo Accetta Rifiuta Riunione"   name="accettaRiunionetitle" value="<%=accettaRiunionetitle%>"/>
	<aui:input type="textarea" label="Sottotitolo Accetta Rifiuta Riunione" rows="5" cols="30"  name="accettaRiunionetxt" value="<%=accettaRiunionetxt%>"/>
</liferay-ui:section>



</liferay-ui:tabs>
</liferay-ui:panel>	
	
	
	
	<liferay-ui:panel title="Template per body email">

	<liferay-ui:tabs names="revoca invito riunione, invito riunione, riunione annullata, riunione modificata, riunione rinviata, riunione spostata, riunione precedentemente rinviata, modifica invitati riunioni, notifica nuovi invitati riunione, sollecito invitato in attesa, sollecito invitato accettato senza partecipanti" refresh="false">
	<liferay-ui:section>
	    <aui:input type="text" name="senderCancellaInvito" label="mittente" value="<%=senderCancellaInvito%>" />
		<aui:input type="text" name="subjectCancellaInvito" label="oggetto email" value="<%=subjectCancellaInvito%>" />
		
		<liferay-ui:input-editor  name ='cancellainvriunioneEditor' initMethod="initCancellaInvitoRiunioneEditor" height="50%"/>
	    <aui:input name="cancellainvitoriunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
	<liferay-ui:section>
	    <aui:input type="text" name="senderInvito" label="mittente" value="<%=senderInvito%>" />
		<aui:input type="text" name="subjectInvito" label="oggetto email" value="<%=subjectInvito%>" />
		<liferay-ui:input-editor  name ='invriunioneEditor' initMethod="initInvitoRiunioneEditor" height="50%"/>
	    <aui:input name="invitoriunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
	<liferay-ui:section>
	    <aui:input type="text" name="senderCambioStato" label="mittente" value="<%=senderCambioStato%>" />
		<aui:input type="text" name="subjectCambioStato" label="oggetto email" value="<%=subjectCambioStato%>" />
		
		<liferay-ui:input-editor  name ='stariunioneEditor' initMethod="initStatoRiunioneEditor" height="50%"/>
	    <aui:input name="cambiostatoriunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
		
	<liferay-ui:section>
	    <aui:input type="text" name="senderModifica" label="mittente" value="<%=senderModifica%>" />
		<aui:input type="text" name="subjectModifica" label="oggetto email" value="<%=subjectModifica%>" />
	     
		<liferay-ui:input-editor  name ='modriunioneEditor' initMethod="initModificaRiunioneEditor" height="50%"/>
	    <aui:input name="modificariunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
	<liferay-ui:section>
	    <aui:input type="text" name="senderRiunioneRinviata" label="mittente" value="<%=senderRiunioneRinviata%>" />
		<aui:input type="text" name="subjectRiunioneRinviata" label="oggetto email" value="<%=subjectRiunioneRinviata%>" />
	     
		<liferay-ui:input-editor  name ='rinriunioneEditor' initMethod="initRiunioneRinviataEditor" height="50%"/>
	    <aui:input name="riunionerinviataTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
	
	<liferay-ui:section>	
	    <aui:input type="text" name="senderSposta" label="mittente" value="<%=senderSposta%>" />
		<aui:input type="text" name="subjectSposta" label="oggetto email" value="<%=subjectSposta%>" />
		
		<liferay-ui:input-editor  name ='sporiunioneEditor' initMethod="initSpostaRiunioneEditor" height="50%"/>
	    <aui:input name="spostariunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
	<liferay-ui:section>
	    <aui:input type="text" name="senderStatoIndetta" label="mittente" value="<%=senderStatoIndetta%>" />
		<aui:input type="text" name="subjectStatoIndetta" label="oggetto email" value="<%=subjectStatoIndetta%>" />
		
		<liferay-ui:input-editor  name ='stariunioneindettaEditor' initMethod="initStatoRiunioneIndettaEditor" height="50%"/>
	    <aui:input name="cambiostatoriunioneindettaTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
	<liferay-ui:section>
	    <aui:input type="text" name="senderModificaInvitati" label="mittente" value="<%=senderModificaInvitati%>" />
		<aui:input type="text" name="subjectModificaInvitati" label="oggetto email" value="<%=subjectModificaInvitati%>" />
		
		<liferay-ui:input-editor  name ='modificainvitatiriunioneEditor' initMethod="initModificaInvitatiRiunioneEditor" height="50%"/>
	    <aui:input name="modificainvitatiriunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
		
	<liferay-ui:section>
	    <aui:input type="text" name="senderAggiuntaInvitati" label="mittente" value="<%=senderAggiuntaInvitati%>" />
		<aui:input type="text" name="subjectAggiuntaInvitati" label="oggetto email" value="<%=subjectAggiuntaInvitati%>" />
		
		<liferay-ui:input-editor  name ='aggiuntainvitatiriunioneEditor' initMethod="initAggiuntaInvitatiRiunioneEditor" height="50%"/>
	    <aui:input name="aggiuntainvitatiriunioneTmpl" type="hidden" value="" />
		
	</liferay-ui:section>
	
	
	<liferay-ui:section>
	    <aui:input type="text" name="senderSollecito" label="mittente" value="<%=senderSollecito%>" />
		<aui:input type="text" name="subjectSollecito" label="oggetto email" value="<%=subjectSollecito%>" />
		 
		<liferay-ui:input-editor  name ='solriunioneEditor' initMethod="initSollecitoRiunioneEditor" height="50%"/>
	    <aui:input name="sollecitoriunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
	
	<liferay-ui:section>
	    <aui:input type="text" name="senderSollecitoAccettata" label="mittente" value="<%=senderSollecitoAccettata%>" />
		<aui:input type="text" name="subjectSollecitoAccettata" label="oggetto email" value="<%=subjectSollecitoAccettata%>" />
		 
		<liferay-ui:input-editor  name ='solaccettatariunioneEditor' initMethod="initSollecitoAccettataRiunioneEditor" height="50%"/>
	    <aui:input name="sollecitoaccettatariunioneTmpl" type="hidden" value="" />
	</liferay-ui:section>
	


	
	
		
</liferay-ui:tabs>
			
</liferay-ui:panel>



	<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>

<script type="text/javascript">

            function <portlet:namespace />initRiunioneRinviataEditor() {
                 return "<%=riunionerinviataTmpl%>";
            }
            
               function <portlet:namespace />initModificaRiunioneEditor() {
                 return "<%=modificariunioneTmpl%>";
            }
            function <portlet:namespace />initSollecitoRiunioneEditor() {
                return "<%=sollecitoriunioneTmpl%>";
    		}
            
			 function <portlet:namespace />initSollecitoAccettataRiunioneEditor() {
                return "<%=sollecitoaccettatariunioneTmpl%>";
    		}
			
            function <portlet:namespace />initInvitoRiunioneEditor() {
                return "<%=invitoriunioneTmpl%>";
    		}
            
			function <portlet:namespace />initCancellaInvitoRiunioneEditor() {
                return "<%=cancellainvitoriunioneTmpl%>";
    		}
            function <portlet:namespace />initSpostaRiunioneEditor() {
                return "<%=spostariunioneTmpl%>";
    		}

            function <portlet:namespace />initStatoRiunioneEditor() {
                return "<%=cambiostatoriunioneTmpl%>";
    		}
			
			function <portlet:namespace />initStatoRiunioneIndettaEditor() {
                return "<%=cambiostatoriunioneindettaTmpl%>";
    		}
			
            
			function <portlet:namespace />initAggiuntaInvitatiRiunioneEditor() {
                return "<%=aggiuntainvitatiriunioneTmpl%>";
    		}
			function <portlet:namespace />initModificaInvitatiRiunioneEditor() {
                return "<%=modificainvitatiriunioneTmpl%>";
    		}
			
            function extractCodeFromEditor() {
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />modificariunioneTmpl.value = window.<portlet:namespace />modriunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var sol = document.<portlet:namespace />fm.<portlet:namespace />sollecitoriunioneTmpl.value = window.<portlet:namespace />solriunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var sac= document.<portlet:namespace />fm.<portlet:namespace />sollecitoaccettatariunioneTmpl.value = window.<portlet:namespace />solaccettatariunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");

						var inv = document.<portlet:namespace />fm.<portlet:namespace />invitoriunioneTmpl.value = window.<portlet:namespace />invriunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var can = document.<portlet:namespace />fm.<portlet:namespace />cancellainvitoriunioneTmpl.value = window.<portlet:namespace />cancellainvriunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");

                        var spo = document.<portlet:namespace />fm.<portlet:namespace />spostariunioneTmpl.value = window.<portlet:namespace />sporiunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
						var sta = document.<portlet:namespace />fm.<portlet:namespace />cambiostatoriunioneTmpl.value = window.<portlet:namespace />stariunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var ind = document.<portlet:namespace />fm.<portlet:namespace />cambiostatoriunioneindettaTmpl.value = window.<portlet:namespace />stariunioneindettaEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var min = document.<portlet:namespace />fm.<portlet:namespace />modificainvitatiriunioneTmpl.value = window.<portlet:namespace />modificainvitatiriunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var ain = document.<portlet:namespace />fm.<portlet:namespace />aggiuntainvitatiriunioneTmpl.value = window.<portlet:namespace />aggiuntainvitatiriunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
                        var rin = document.<portlet:namespace />fm.<portlet:namespace />riunionerinviataTmpl.value = window.<portlet:namespace />rinriunioneEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");

            }
</script>

