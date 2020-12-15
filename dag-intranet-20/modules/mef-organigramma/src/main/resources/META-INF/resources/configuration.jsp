<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="mef.organigramma.portlet.MefOrganigrammaConfig"%>

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
		<liferay-ui:panel title="Pagina di atterraggio per il dettaglio ufficio">
		<aui:select name="officeDetailUrl" label="pagine disponibili" value="<%= officeDetailUrl %>">>
			
				<c:forEach var="layout" items="${privateLayoutList }">
					<aui:option label="${layout[0] }" value="${layout[1] }"/>
				</c:forEach>
			</optgroup>
		</aui:select>
	</liferay-ui:panel>
	</aui:fieldset>


    <aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>