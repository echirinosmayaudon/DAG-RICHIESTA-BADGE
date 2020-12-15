<!DOCTYPE html>

<#include init />
<#assign layout = themeDisplay.getLayout() />
<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Intranet MEF">
    <meta name="format-detection" content="telephone=no">
    <title>${the_title} - ${company_name}</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" >
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

	<#if custom_images_url !="">
		<#assign images_folder = custom_images_url />
	</#if>
	<#assign css_internal = css_folder/>
	<#if custom_css_url !="">
		<#assign css_folder = custom_css_url />
	</#if>
	<#--
		<link rel="stylesheet" href="${css_folder}/plugins.css" >
	-->
		<link rel="stylesheet" href="${css_internal}/font.css" >

	<link rel="stylesheet" href="${css_folder}/custom-ama.css" >

	<@liferay_util["include"] page=top_head_include />
	<#--
		<#if themeDisplay.isSignedIn()>
			<#include "${full_templates_path}/ga_analitycs.ftl" />
		</#if>
	-->
	<link rel="dns-prefetch" href="https://www.google-analytics.com">
    <link rel="dns-prefetch" href="https://fonts.googleapis.com">
    <script type="text/javascript">
	    (function() {
	    var ga = document.createElement('script');     ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:'   == document.location.protocol ? 'https://ssl'   : 'http://www') + '.google-analytics.com/analytics.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	    })();
	</script>
</head>

<#assign user = themeDisplay.getPermissionChecker().getUser()>
<#assign isAdminUser = false>
<#assign classNoControlMenu = "">
<#if themeDisplay.isSignedIn()>
	<#assign classNoControlMenu = "no-control-menu">
	<#if themeDisplay.getPermissionChecker().isCompanyAdmin()>
		<#assign isAdminUser = true>
		<#assign classNoControlMenu = "">
	</#if>
</#if>

<#assign isRedattoreUser = false>
<#assign usrRoles = user.getRoles()>
<#list usrRoles as usrRole>
    <#if usrRole.getName() == "redattore">
        <#assign isRedattoreUser = true>
        <#assign classNoControlMenu = "">
    </#if> 
</#list>

<body class="${classNoControlMenu} ${css_class} aui">
<#assign bookmarksLocalService = serviceLocator.findService("bookmarks.service.FavouritesLocalService")>
<#assign currentUserId = user.getUserId()>



<#--<#assign currentPageUrl = portalUtil.getCurrentCompleteURL(request)>-->
<#assign domainUrl = portalUtil.getPortalURL(request)>
<#assign bookmarkPageUrl = portalUtil.getCurrentURL(request)>
<#assign currentPageUrl = domainUrl+bookmarkPageUrl>
<#assign idBookmarkPage = bookmarksLocalService.getFavByUrl(currentUserId?number,currentPageUrl)>
<input type="hidden" id="currentId" value="${currentUserId}" />
<input type="hidden" id="bookmarkId" value="${idBookmarkPage}" />
<@liferay_util["include"] page=body_top_include />
<div class="opacity-layer"></div>

<#if isAdminUser || isRedattoreUser>
	<@liferay.control_menu />
</#if>
<#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
<#assign groupId = themeDisplay.getScopeGroupId()>
<#assign groupLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService")>
<#assign group = groupLocalServiceUtil.getGroup(groupId)>
<#assign publicPlid = group.getDefaultPublicPlid()>
<#assign layoutLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#assign homeLayout = layoutLocalServiceUtil.fetchLayout(publicPlid)!"">
<#assign homeUrl = "">
<#if homeLayout != "">
	<#assign homeUrl = homeLayout.getRegularURL(request)>
</#if>
<#assign homeMainPortalUrl = group.getExpandoBridge().getAttribute("home-main-portal-url",false)>
<#if homeMainPortalUrl != "">
	<#assign homeUrl = homeMainPortalUrl>
</#if>

<#assign hideHeder = "">
<#if layout.isPrivateLayout()>
	<#assign hideHeder = "hide">
</#if>
<#include "${full_templates_path}/header.ftl" />


<#if selectable>
	<@liferay_util["include"] page=content_include />
<#else>
	${portletDisplay.recycle()}

	${portletDisplay.setTitle(the_title)}

	<@liferay_theme["wrap-portlet"] page="portlet.ftl">
		<@liferay_util["include"] page=content_include />
	</@>
</#if>

<!-- Include footer start-->
<#include "${full_templates_path}/footer.ftl" />
<!-- Include footer end-->
<@liferay_util["include"] page=body_bottom_include />
<@liferay_util["include"] page=bottom_include />
<#if custom_js_url !="">
	<script type="text/javascript" src="${custom_js_url}custom-ama.js" ></script>
<#else>
	<script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/custom-ama.js")}" ></script>
</#if>

<script type="text/javascript">

var callbackSearch = function(e){
	e.preventDefault();

	var instance = $('#search_fm').parsley();
	instance.validate({force:true});
	if ((instance.isValid({force:true}))){
			$("#search_fm").submit();
	}else{
		$.each($('.parsley-error'),function(){
		    var n = 'parsley-id-' + $(this).attr('data-parsley-id');
		    $(this).attr('aria-invalid', true).attr('aria-describedby',n);
		    $('#'+n).attr('role','alert');
		});
	}
}

$("#buttonSearch").on('click', function(e){ callbackSearch(e);});
$("#cerca_nel_sito").keydown(function(e) {
	var keyCode = (e.keyCode) ? e.keyCode : e.which;
	if (keyCode == 13 || keyCode == 10){
		callbackSearch(e);
	}
 });

</script>

<!-- inject:js -->
<!-- endinject -->
</body>

</html>
