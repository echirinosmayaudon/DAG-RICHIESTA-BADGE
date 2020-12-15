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

<%@page import="com.intranet.mef.user.profile.configuration.MyProfileConfiguration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.document.library.kernel.exception.FileExtensionException" %><%@
page import="com.liferay.document.library.kernel.exception.FileSizeException" %><%@
page import="com.liferay.document.library.kernel.exception.NoSuchFileException" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.model.*" %><%@
page import="com.liferay.portal.kernel.model.impl.*" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.repository.model.FileEntry" %><%@
page import="com.liferay.portal.kernel.service.*" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.upload.UploadException" %><%@
page import="com.liferay.portal.kernel.upload.UploadRequestSizeException" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.HttpUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PropsKeys" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.TextFormatter" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.model.impl.*" %><%@
page import="com.liferay.portal.service.*" %><%@
page import="com.liferay.portal.util.PrefsPropsUtil" %><%@
page import="com.liferay.portal.util.PropsValues" %>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="java.text.DecimalFormatSymbols" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.portlet.WindowState" %>
<%@page import="java.sql.Blob" %>
<%@page import="com.intranet.mef.job.siap.service.ProfilePictureLocalServiceUtil" %>
<%@page import="com.intranet.mef.job.siap.model.ProfilePicture" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
// MyProfileConfiguration configuration = (MyProfileConfiguration) GetterUtil.getObject(
// 	    renderRequest.getAttribute("configuration"));

boolean isShort = GetterUtil.getBoolean(portletPreferences.getValue("isShort", Boolean.TRUE.toString()));
String profileDetailLayoutId = portletPreferences.getValue("profileDetailLayoutId", "0");
String labelRestoreDefault = portletPreferences.getValue("labelRestoreDefault", "");
String labelUploadImage = portletPreferences.getValue("labelUploadImage", "");
String labelSetSIAPImage = portletPreferences.getValue("labelSetSIAPImage", "");
String labelNoSIAPImage = portletPreferences.getValue("labelNoSIAPImage", "");
String labelPrivacyAcceptance = portletPreferences.getValue("labelPrivacyAcceptance", "");
List<String[]> privateLayoutList = (List<String[]>)request.getAttribute("privateLayoutList");
Layout profileDetailUrl= null;
try{
profileDetailUrl = LayoutLocalServiceUtil.fetchLayout(themeDisplay.getSiteGroupId(), true, Long.parseLong(profileDetailLayoutId));
}catch(Exception e){
	e.printStackTrace();
}
if (profileDetailUrl==null){
	profileDetailUrl = LayoutLocalServiceUtil.createLayout(0);
	profileDetailUrl.setFriendlyURL("/");
}
%>