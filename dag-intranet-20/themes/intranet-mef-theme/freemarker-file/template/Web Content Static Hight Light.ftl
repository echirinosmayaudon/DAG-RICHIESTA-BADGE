<div class="primo-piano-wrap">
${content.getData()}
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign groupId = serviceContext.getThemeDisplay().getCompanyGroupId()?string>
<#assign VOID = freeMarkerPortletPreferences.setValue("displayStyleGroupId", groupId)>
    <#assign VOID = freeMarkerPortletPreferences.setValue("displayStyle", "ddmTemplate_105108")>

        <@liferay_portlet["runtime"]
          defaultPreferences="${freeMarkerPortletPreferences}"
          instanceId="scrivania-service-widget"
          portletProviderAction=portletProviderAction.VIEW
          portletProviderClassName="com.liferay.asset.kernel.model.AssetEntry"
        />
        <#assign VOID = freeMarkerPortletPreferences.reset()>
</div>
