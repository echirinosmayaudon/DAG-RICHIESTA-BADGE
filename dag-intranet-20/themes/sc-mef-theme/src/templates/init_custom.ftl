<#assign ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !sign_out_url??>
	<#assign
		sign_out_text = languageUtil.get(locale, "sign-out")
		sign_out_url = ''
	/>
</#if>

<#assign show_target_navigation = is_company_supervisor || user_target_nav_items?has_content />
<#assign is_show_MenuToggler = getterUtil.getBoolean(sessionClicks.get(request, "sessionClickMenuToggler", "true")) />

<#if show_target_navigation>

	<#if is_show_MenuToggler>
		<#assign css_class = "${css_class} has-target-menu" />
	<#else>
		<#assign css_class = "${css_class} has-target-menu-closed" />
	</#if>
</#if>

<#if is_company_supervisor>
	<#assign css_class = "${css_class} supervisor-company" />
</#if>

<#if is_omni_admin>
	<#assign css_class = "${css_class} omny-admin" />
</#if>

<#assign is_show_control_menu = is_omni_admin />

<#if !is_show_control_menu>
	<#assign css_class = removeCssClass(css_class, "has-control-menu") />
	<#assign css_class = removeCssClass(css_class, "open") />
</#if>

<#function getLayoutIcon friendlyURL>
	<#assign layout_icon = "" />

	<#if friendlyURL == "/home">
		<#assign layout_icon = "home" />
	<#elseif friendlyURL == "/documents">
		<#assign layout_icon = "documenti" />
    <#elseif friendlyURL == "/activities">
        <#assign layout_icon = "to_do_list" />
    <#elseif friendlyURL == "/spaces_groups">
        <#assign layout_icon = "gruppi_di_lavoro" />
	<#elseif friendlyURL == "/spaces_personal">
		<#assign layout_icon = "spazi_personali" />
    <#elseif friendlyURL == "/spaces_community">
        <#assign layout_icon = "community" />
	<#elseif friendlyURL == "/contacts">
		<#assign layout_icon = "contatti" />
	<#elseif friendlyURL == "/notifications">
		<#assign layout_icon = "calendar" />
	<#elseif friendlyURL == "/calendar">
		<#assign layout_icon = "calendar" />
	</#if>

	<#return layout_icon />
</#function>

<#function isHomeLayout friendlyURL>
	<#return (friendlyURL == "/home") />
</#function>

<#function isDocumentsLayout friendlyURL>
	<#return (friendlyURL == "/documents") />
</#function>

<#function isWikiLayout friendlyURL>
	<#return (friendlyURL == "/wiki") />
</#function>

<#function isForumLayout friendlyURL>
	<#return (friendlyURL == "/forum") />
</#function>

<#function isTaskLayout friendlyURL>
	<#return (friendlyURL == "/task") />
</#function>

<#function isCalendarLayout friendlyURL>
	<#return (friendlyURL == "/calendar") />
</#function>

<#function isSurveyLayout friendlyURL>
	<#return (friendlyURL == "/survey") />
</#function>

<#function isMembersLayout friendlyURL>
	<#return (friendlyURL == "/member") />
</#function>

<#function isTrashLayout friendlyURL>
	<#return (friendlyURL == "/trash") || (friendlyURL == "/documents/trash") />
</#function>

<#function isSettingsLayout friendlyURL>
	<#return (friendlyURL == "/settings") />
</#function>

<#function isSocialSettingsLayout friendlyURL>
	<#return (friendlyURL == "/social-activity") />
</#function>

<#function isSharedDmlLayout friendlyURL>
	<#assign is_shared_dml_layout = (friendlyURL == "/documents/share") />

	<#return is_shared_dml_layout />
</#function>

<#function isExchangeLayout friendlyURL>
	<#assign is_exchange_layout = (friendlyURL == "/calendar/exchange") />

	<#return is_exchange_layout />
</#function>


<#function removeCssClass cssClass toRemove>
	<#-- Old School css class removal -->
	<#return ((" ${cssClass} ")?replace(" ${toRemove?trim} ", " "))?trim />
</#function>

<#assign
	user_logo=user.getPortraitURL(theme_display)
/>