<%@page import="com.liferay.portal.kernel.util.PrefsParamUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.mef.intranet.rubrica.portlet.portlet.MefRubricaFormConfig"%>
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

			<aui:select name="itemsPerPage" label="Number of Shown Results for Page"
				value="<%= itemsPerPage %>">
				<aui:option value="2">2</aui:option>
				<aui:option value="5">5</aui:option>
				<aui:option value="6">6</aui:option>
				<aui:option value="10">10</aui:option>
				<aui:option value="15">15</aui:option>
				<aui:option value="20">20</aui:option>
			</aui:select>

		</aui:fieldset>
		
		<aui:fieldset>

		<aui:select name="lastResearch" label="lastResearch" value="<%=lastResearch%>">
			<aui:option value="6">6</aui:option>
			<aui:option value="10">10</aui:option>

		</aui:select>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>