<%@ include file="/init.jsp"%>
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
			<aui:fieldset>	
			<liferay-ui:panel title="Testo intestazione per Servizio Richiesta di Pubblicazione sui siti Internet Dipartimentali">
				<liferay-ui:tabs names="" refresh="false">
					<liferay-ui:section>
					 		<aui:input type="text" label="Titolo Pubblicazione Siti" name="serviziPubblicazioneSitiTitle" value="<%=serviziPubblicazioneSitiTitle%>"/>
							<aui:input type="text" label="Sottitolo Pubblicazione Siti" name="serviziPubblicazioneSitiSubTitle" value="<%=serviziPubblicazioneSitiSubTitle%>"/>
					</liferay-ui:section>
				</liferay-ui:tabs>
			</liferay-ui:panel>	
		</aui:fieldset>
		
		<liferay-ui:panel title="Link della pagina">
		<aui:select name="linkPaginaGuida" label="Site Pages" value="<%= linkPaginaGuida %>">
			
				<c:forEach var="layout" items="${privateLayoutList }">
					<aui:option label="${layout[0]}" value="${layout[1] }"/>
				</c:forEach>
		</aui:select>
	</liferay-ui:panel>
		<liferay-ui:panel title="Template per body email">
	    		<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
				<aui:input type="text" name="subject" label="oggetto" value="<%=subject%>" />
				<aui:input type="text" name="emailReferente" label="email" value="<%=emailReferente%>" />
		 
				<liferay-ui:input-editor  name ='pubblicazioneSitiEditor' initMethod="initPubblicazioneSitiEditor" height="50%"/>
	    		<aui:input name="pubblicazioneSitiTmpl" type="hidden" value="" />
	
		</liferay-ui:panel>
		
		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>
	</aui:form>
	
	<script type="text/javascript">
	
	 function <portlet:namespace />initPubblicazioneSitiEditor() {
         return "<%=pubblicazioneSitiTmpl%>";
    }
	 
	 function extractCodeFromEditor() {
     	var pubblicazioneSiti = document.<portlet:namespace />fm.<portlet:namespace />pubblicazioneSitiTmpl.value = window.<portlet:namespace />pubblicazioneSitiEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
     }
</script>