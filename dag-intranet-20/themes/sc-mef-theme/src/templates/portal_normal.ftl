<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<#assign titlePage = the_title?replace('(\\[+[0-9]+\\]+)', '', 'r') />

	<title>${titlePage} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<link rel="apple-touch-icon" sizes="57x57" href="${images_folder}/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="${images_folder}/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${images_folder}/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="${images_folder}/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="${images_folder}/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="${images_folder}/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="${images_folder}/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="${images_folder}/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${images_folder}/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192"  href="${images_folder}/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${images_folder}/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${images_folder}/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${images_folder}/favicon/favicon-16x16.png">

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class} bg-site">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<#if is_show_control_menu>
 	<@liferay.control_menu />
</#if>

<div id="wrapper">
	<#include "${full_templates_path}/sc_dockbar.ftl" />

	<div class="overlay-bg hide"></div>

	<header class="spaces-navigation">
		<div class="container-fluid-1280">

				<#if has_navigation && is_setup_complete>
					<#if is_user_target_site?has_content>
						<#if is_user_target_site == false >

						<div class="site-name-wrapper">
							<h1 class="site-name">
								<#if is_space_site?has_content>
									<#if is_space_site == true >
										<#assign space_site_name = theme_display.getScopeGroup().getExpandoBridge().getAttribute('site-title') />

                                        									<#if space_site_name == "">
                                        										<#assign space_site_name = theme_display.getScopeGroup().getDescriptiveName(locale) />
                                        									</#if>

                                        									<#assign is_site_project_or_community = scHelperLocalService.isSocialSpaceProjectSite(theme_display.getScopeGroup()) ||
                                        									scHelperLocalService.isSocialSpaceCommunitySite(theme_display.getScopeGroup()) />

                                        									<#if is_site_project_or_community>
                                        										<@liferay.language key="site" />:
                                        										<@liferay_portlet["runtime"]
                                        											portletName="it_smc_osportal_sc_dashboard_settings_web_portlet_DashboardTreeViewWebPortlet"
                                        										/>
                                        									<#else>
                                        										<@liferay.language key="space" />: ${space_site_name}
                                        									</#if>
									<#else>
										${site_name}
									</#if>
								</#if>
							</h1>

							<#list nav_items as nav_item>
								<#if isSettingsLayout(nav_item.getLayout().getFriendlyURL(locale)) >
									<#assign nav_item_layout = nav_item.getLayout()	/>

									<a aria-labelledby="layout_${nav_item.getLayoutId()}" href="${nav_item.getURL()}" ${nav_item.getTarget()} class="settings-site">
										<span>
											<@liferay_theme["layout-icon"] layout=nav_item_layout />
												<!-- <span class="icon-cog icon-2x"></span> -->
												${nav_item.getName()}
										</span>
									</a>
								</#if>
								<#if isMembersLayout(nav_item.getLayout().getFriendlyURL(locale)) >
								<#assign nav_item_layout = nav_item.getLayout()	/>

								<a aria-labelledby="layout_${nav_item.getLayoutId()}" href="${nav_item.getURL()}" ${nav_item.getTarget()} class="member-site" title="${nav_item.getName()}">
									<span>
										<@liferay_theme["layout-icon"] layout=nav_item_layout />
											<!-- <span class="icon-cog icon-2x"></span> -->
											${nav_item.getName()}
									</span>
								</a>
								</#if>
								
							</#list>
							
							<div id="portlet-repo-dml-wrapper">
								<#assign groupId = themeDisplay.getScopeGroupId()>
								<#assign groupLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService")>
								<#assign group = groupLocalServiceUtil.getGroup(groupId)>
								<#assign siteType = group.getExpandoBridge().getAttribute("site-type", false)>
								<#assign pageUrl = layout.getFriendlyURL()>
								<#if siteType?? && pageUrl?? && pageUrl=="/documents" && (siteType==2 || siteType==3)>
									<@liferay_portlet["runtime"]
											instanceId="repo_dml_socialcollab"
								    		portletName="it_smc_acn_intranet_mef_report_dml_web_ReportDmlPortlet" />
								</#if>
							</div>
								
							<p class="site-description">${theme_display.getScopeGroup().getDescription(locale)}</p>
						</div>

						<#else>
							<#assign nav_items = user_target_nav_items_children />
								<div class="site-name-wrapper">
									<h1 class="site-name">
											<#assign name_page_layout = layout.getName(locale) />
											${name_page_layout}
									</h1>
								</div>
						</#if>
					</#if>

					<#include "${full_templates_path}/navigation.ftl" />
				</#if>

		</div>
	</header>

	<div class="container-fluid">

		<#if show_target_navigation>
			<#include "${full_templates_path}/target_site_navigation.ftl" />
		</#if>

		<section id="content">
			<h1 class="hide-accessible">${the_title}</h1>

			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}

				${portletDisplay.setTitle(the_title)}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</section>

	</div>
</div>

<#include "${full_templates_path}/footer.ftl" />

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
<!-- endinject -->

</body>

</html>
