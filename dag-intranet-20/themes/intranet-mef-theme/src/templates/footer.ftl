<!-- Analytics Asset -->

<!-- Whistleblowing Web Content include -->
<#assign nameWhistleblowingWC = "whistleblowing">
<#assign whistleblowingContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameWhistleblowingWC, 0)!"">
<#if whistleblowingContent == "">
	<#assign nameWhistleblowingWC = "${nameWhistleblowingWC}-private">
	<#assign whistleblowingContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameWhistleblowingWC, 0)!"">
</#if>

<#if whistleblowingContent != "">
	<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", whistleblowingContent.getArticleId() + "") />

<@liferay_portlet["runtime"]
	defaultPreferences="${freeMarkerPortletPreferences}"
	portletProviderAction=portletProviderAction.VIEW
	instanceId="whistleblowing"
	portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
	<#assign VOID = freeMarkerPortletPreferences.reset()>
</#if>

<!-- Footer Web Content include -->
<#assign nameFooterWC = "footer">
<#assign footerContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameFooterWC, 0)!"">
<#if footerContent == "">
	<#assign nameFooterWC = "${nameFooterWC}-private">
	<#assign footerContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameFooterWC, 0)!"">
</#if>

<#if footerContent != "">
	<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", footerContent.getArticleId() + "") />

<@liferay_portlet["runtime"]
	defaultPreferences="${freeMarkerPortletPreferences}"
	portletProviderAction=portletProviderAction.VIEW
	instanceId="footer"
	portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
	<#assign VOID = freeMarkerPortletPreferences.reset()>
</#if>
<script type="text/javascript">
function closeCookieOverlay(){
 $('.js-cookie-overlay').addClass('bounceOutUp').removeClass('fadeInDown');
 $('.js-cookie-overlay').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
  $('.js-cookie-overlay').remove();
 });
}
//Test 
</script>
