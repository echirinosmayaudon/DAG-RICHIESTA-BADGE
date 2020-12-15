<%@page import="com.liferay.portal.kernel.util.PrefsParamUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="modulistica.mef.portlet.ModulisticaMefConfig"%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />
<%   
renderRequest.setAttribute("redirectAfterCancelPage", portletPreferences.getValue("modulisticaPage", ""));
String redirectAfterCancelPage = PrefsParamUtil.getString(portletPreferences, request, "modulisticaPage");
%>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />

	<aui:fieldset>

			<aui:select name="folder" label="choose folder"
				value="<%= folder %>">
				<c:forEach items="${folders}" var="listItem">
				<c:if test='${!listItem.getMountPoint()=="0" }'>
						<aui:option value="">root</aui:option>
				</c:if>
				<c:if test='${listItem.getMountPoint()=="0" }'>
						<aui:option value="${listItem.getName()}">${listItem.getName()}</aui:option>
				</c:if>
				</c:forEach>
				
			
			</aui:select>

		</aui:fieldset>
	<aui:fieldset>

		<aui:select name="viewTheme" label="View" value="<%= viewTheme %>">
			<aui:option value="Classic">Classic</aui:option>
			<aui:option value="Categories">Categories</aui:option>

		</aui:select>

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

		<aui:select name="days" label="Most Downloaded in last days" value="<%= days %>">
		    <aui:option value="7">7</aui:option>
			<aui:option value="15">15</aui:option>
			<aui:option value="30">30</aui:option>

		</aui:select>

	</aui:fieldset>
	
	<aui:fieldset>
		<liferay-ui:panel title="Pagina Modulistica">
		<aui:select name="modulisticaPage" label="Site Pages" value="<%= modulisticaPage %>">>
			
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