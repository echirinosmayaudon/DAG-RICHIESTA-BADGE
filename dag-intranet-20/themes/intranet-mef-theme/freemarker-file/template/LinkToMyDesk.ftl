<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign themeDisplay = serviceContext.getThemeDisplay() />

<div class="col-profile">
    <div class="header-profile">
        <div class="image-profile" style="background-image: url(${permissionChecker.getUser().getPortraitURL(themeDisplay)})"></div>
        <a href="${LinkMyDesk.getFriendlyUrl()}" class="btn-goto-profile">${LabelMyDesk.getData()}<span class="icomoon-vai"></span></a>
        <p class="name-profile">${permissionChecker.getUser().getFullName()}</p>
    </div>
</div>
