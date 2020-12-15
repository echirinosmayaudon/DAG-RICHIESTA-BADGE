<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<aui:form action="<%= configurationActionURL %>" cssClass="container-fluid-1280" method="post" name="fm">

		<liferay-ui:panel title="Configurazione Portlet di My-Profile">
			<aui:input label="is-short-view" name="isShort" type="checkbox" value="<%= isShort %>" />
			<aui:select name="profileDetailLayoutId" label="Pagina di profilo estesa" value="<%= profileDetailLayoutId %>">>

					<c:forEach var="layout" items="${privateLayoutList }">
						<aui:option label="${layout[0] }" value="${layout[1] }"/>
					</c:forEach>
				</optgroup>
			</aui:select>
			<aui:input label="label-restore-default" name="labelRestoreDefault" type="text" value="<%= labelRestoreDefault %>" />
			<aui:input label="label-upload-image" name="labelUploadImage" type="text" value="<%= labelUploadImage %>" />
			<aui:input label="label-set-siap-image" name="labelSetSIAPImage" type="text" value="<%= labelSetSIAPImage %>" />
			<aui:input label="label-no-siap-image" name="labelNoSIAPImage" type="text" value="<%= labelNoSIAPImage %>" />
			<aui:input label="label-privacy-acceptance" name="labelPrivacyAcceptance" type="text" value="<%= labelPrivacyAcceptance %>" />
		</liferay-ui:panel>
	

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />
	</aui:button-row>
</aui:form>