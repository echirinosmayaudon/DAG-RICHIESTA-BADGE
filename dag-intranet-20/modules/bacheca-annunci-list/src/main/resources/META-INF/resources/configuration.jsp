<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="bacheca.annunci.list.portlet.BachecaAnnunciListConfig"%>
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

		<aui:select name="viewTheme" label="View" value="<%= viewTheme %>">
			<aui:option value="grid">Grid</aui:option>
		    <aui:option value="list">List</aui:option>


			
		</aui:select>

	</aui:fieldset>
	
	
	<aui:fieldset>

		<aui:input type="text" name="zona" label="zona" value="<%=zona%>" />

	</aui:fieldset>
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
		
		<aui:fieldset>
		<liferay-ui:panel title="Pagina Bacheca">
		<aui:select name="bachecaPage" label="Site Pages" value="<%= bachecaPage %>">>
			
				<c:forEach var="layout" items="${privateLayoutList }">
					<aui:option label="${layout[0] }" value="${layout[1] }"/>
				</c:forEach>
			</optgroup>
		</aui:select>
	</liferay-ui:panel>
	</aui:fieldset>
	
	<aui:fieldset>
		<liferay-ui:panel title="Area Tematica">
		<aui:select name="metaAreaCategoria" label="area" value="<%= metaAreaCategoria %>">>
			
				<c:forEach var="layout" items="${categoryList}">
					<aui:option label="${layout[0] }" value="${layout[1] }"/>
				</c:forEach>
			</optgroup>
		</aui:select>
	</liferay-ui:panel>
	</aui:fieldset>
	
	<aui:fieldset>
		<liferay-ui:panel title="Configurazione Email inserimento annuncio">
			<aui:input type="text" name="sender" label="mittente" value="<%=sender%>" />
			<aui:input type="text" name="subject" label="oggetto email" value="<%=subject%>" />
			
			<liferay-ui:input-editor  name ='annuncioEditor' initMethod="inserisciannuncioEditor" height="50%"/>
	        <aui:input name="inserisciannuncioTmpl" type="hidden" value="" />
			
			
		</liferay-ui:panel>
	</aui:fieldset>	
		
	
		<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>
<script type="text/javascript">

            function <portlet:namespace />inserisciannuncioEditor() {
                 return "<%=inserisciannuncioTmpl%>";
            }
            
  
            
            function extractCodeFromEditor() {
                        var mod = document.<portlet:namespace />fm.<portlet:namespace />inserisciannuncioTmpl.value = window.<portlet:namespace />annuncioEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");        
            }
</script>
