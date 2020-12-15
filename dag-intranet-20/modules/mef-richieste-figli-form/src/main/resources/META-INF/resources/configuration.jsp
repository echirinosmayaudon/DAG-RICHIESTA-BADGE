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

	<aui:input name="redirect" type="hidden"value="<%= configurationRenderURL %>" />
	<aui:input name="type_config" type="hidden" value="configPrincipale" />
    
	
<%--
String richiestaRimborsoTmpl= (String) request.getAttribute("richiestaRimborsoTmpl"); 
String senderRichiestaRimborso= (String) request.getAttribute("senderRichiestaRimborso"); 
String emailReferente= (String) request.getAttribute("emailReferente"); 
String subjectRichiestaRimborso= (String) request.getAttribute("subjectRichiestaRimborso"); 
--%>
	
	
	
<liferay-ui:panel title="Template per body email">

	<liferay-ui:tabs names="Richiesta Rimborso,Data validità figlio, Dimensione allegato, PDF" refresh="false">
	<liferay-ui:section>
	    <aui:input type="text" name="senderRichiestaRimborso" label="mittente" value="<%=senderRichiestaRimborso%>" />
		<aui:input type="text" name="subjectRichiestaRimborso" label="oggetto" value="<%=subjectRichiestaRimborso%>" />
		<aui:input type="text" name="emailReferente" label="email" value="<%=emailReferente%>" />
		 <liferay-ui:input-editor  name ='richiestaRimborsoEditor' initMethod="initRichiestaRimborsoEditor" height="50%"/>
	    <aui:input name="richiestaRimborsoTmpl" type="hidden" value="" />
	    
	    
	</liferay-ui:section>
<liferay-ui:section>
	    <aui:input type="Date" name="dataRichiestaRimborso" label="Data" value="<%=dataRichiestaRimborso%>" />
		
	     

	</liferay-ui:section>
	<liferay-ui:section>
	
	    <aui:input type="number" name="dimensioneAllegato" label="Dimensione Allegato in MB: " value="<%=dimensioneAllegato%>" />
	
	</liferay-ui:section>
	<liferay-ui:section>
	    <aui:input type="text" name="oggettoPDF" label="Oggetto" value="<%=oggettoPDF%>" />
		<aui:input type="text" name="richiestaPDF" label="Richiesta" value="<%=richiestaPDF%>" />
	     <aui:input type="text" name="spesaSostenutaPDF" label="Spesa sostenuta" value="<%=spesaSostenutaPDF%>" />
	     
	     
	     
	
	     
  <aui:input type="textarea" name="eventualiNotePDF" label="Disclaimer Privacy" value="<%=eventualiNotePDF%>" /> 
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

