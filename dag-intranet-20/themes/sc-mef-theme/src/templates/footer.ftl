<#assign companyId = theme_display.getCompanyId()>
<#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
<#assign GroupLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService")!"">
<#assign group = GroupLocalService.fetchFriendlyURLGroup(companyId,"/global")>
<#assign globalGroupId = group.getGroupId()>
<!-- Footer Web Content include -->
<#assign nameFooterWC = "footer">
<#assign footerContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(globalGroupId,nameFooterWC, 0)!"">
<#if footerContent == "">
    <#assign nameFooterWC = "${nameFooterWC}-private">
    <#assign footerContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(globalGroupId,nameFooterWC, 0)!"">
</#if>
<#assign urlIntranteMefFooter = portalUtil.getHomeURL(request) ?split("#")[1] />
<#if footerContent != "">
	<input type="hidden" name="footer-input" id="footer-input" value="${urlIntranteMefFooter}">
	<#assign document = saxReaderUtil.read(footerContent.getContent()) />
	<#assign HTMLBoxFooter = document.valueOf("//dynamic-element[@name='HTMLaytq']/dynamic-content[@language-id='${locale}']/text()") />
	${HTMLBoxFooter}
	<#--    
	<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", footerContent.getArticleId() + "") />
	<@liferay_portlet["runtime"]
	    defaultPreferences="${freeMarkerPortletPreferences}"
	    portletProviderAction=portletProviderAction.VIEW
	    instanceId="footer"
	    portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
	    <#assign VOID = freeMarkerPortletPreferences.reset()>
	-->
</#if>

