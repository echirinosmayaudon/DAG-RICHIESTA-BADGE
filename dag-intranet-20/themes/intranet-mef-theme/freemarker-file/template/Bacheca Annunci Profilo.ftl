<#assign PortletURLFactoryUtil = serviceLocator.findService("com.liferay.portal.kernel.portlet.PortletURLFactoryUtil")>
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign httpServletRequest = serviceContext.getRequest()>
<#assign layoutLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#assign friendlyUrlCreaNuovo = PaginaCreaNuovo.getFriendlyUrl()>

<#list friendlyUrlCreaNuovo?split("/") as singleList>
  <#assign friendlyUrl = "/"+singleList>
</#list>

<#assign layoutCreaNuovo = layoutLocalServiceUtil.getFriendlyURLLayout(serviceContext.getThemeDisplay().getScopeGroupId(), true, friendlyUrl)>
<#assign layoutHome = layoutLocalServiceUtil.getFriendlyURLLayout(serviceContext.getThemeDisplay().getScopeGroupId(), true, "/home")>
<#assign renderUrl = "#">
<#assign portletBachecaAnnunciName = "">
<#list layoutHome.getLayoutType().getPortletIds() as item>
  <#if item?contains("bacheca_annunci") >
    <#assign portletBachecaAnnunciName = item>
  </#if>
</#list>

<#list layoutCreaNuovo.getLayoutType().getPortletIds() as item>
  <#if item?contains("bacheca_annunci") >
    <#assign renderUrl = PortletURLFactoryUtil.create(httpServletRequest, item , layoutCreaNuovo.getPlid() , "RENDER_PHASE")>
    ${renderUrl.setParameter("navigation", "inserisciannuncio")}
    <#list renderUrl?split("?") as singleList>
      <#assign queryString = "?"+singleList>
    </#list>
    <#assign renderUrl = friendlyUrlCreaNuovo+queryString>
  </#if>
</#list>
<div class="box-gray-color pt-30-xs pb-50-xs">
  <@liferay_portlet["runtime"]
    portletProviderAction=portletProviderAction.VIEW
    instanceId="bacheca_annunci_profilo"
    portletName="bacheca_annunci_list_portlet_BachecaAnnunciListPortlet" />

  <div class="ama-container-fluid text-center">
        <a href="${renderUrl}"  class="button button-primary pl-30-xs pr-30-xs">${LabelTastoCreaNuovo.getData()}</a>
    </div>
</div>
