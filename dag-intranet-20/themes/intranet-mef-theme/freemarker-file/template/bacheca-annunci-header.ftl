<#assign PortletURLFactoryUtil = serviceLocator.findService("com.liferay.portal.kernel.portlet.PortletURLFactoryUtil")>
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign httpServletRequest = serviceContext.getRequest()>

<#assign themeDisplay = serviceContext.getThemeDisplay() />
<#assign renderUrl = "#"/>
<#list themeDisplay.getLayoutTypePortlet().getPortletIds() as item>
<#if item.contains("bacheca_annunci") >
  <#assign renderUrl = PortletURLFactoryUtil.create(httpServletRequest, item , themeDisplay.getPlid() , "RENDER_PHASE")>
  ${renderUrl.setParameter("navigation", "inserisciannuncio")}
</#if>

</#list>

<div id="header_bacheca_annunci">
<div class="wrapper-added-notice">
  <div class="clearfix">
    <div class="ama-col-md-8 ama-col-sm-7">
      <div class="title-wrapper">
        <h2 class="title">${title.getData()}</h2><a class="btn-star-bookmarks icomoon-star title-star" ></a>
      </div>
    </div>

    <div class="ama-col-md-4 ama-col-sm-5 hidden-xs">
      <a href="${renderUrl}" class="box-yellow-notice">
        <div class="div-added-notice">
          <span class="icomoon-plus"></span>
          <div class="added-notice">${labelAddAnnuncio.getData()}</div>
        </div>
      </a>
    </div>
  </div>

  <div class="clearfix">
   <div class="wysiwyg-editor">
    ${description.getData()}
    </div>
    <div class="display-xs">
      <div class="div-message-important color-violet">
        <div class="icomoon-alert"></div>
        <div class="message-important">
        ${messageAlertRules.getData()}
        </div>
      </div>
    </div>
    <div class="visible-xs">
      <a href="${renderUrl}" class="box-yellow-notice yellow-notice-mobile">
        <div class="div-added-notice text-center">
          <span class="icomoon-plus"></span>
          <div class="added-notice">${labelAddAnnuncio.getData()}</div>
        </div>
      </a>
    </div>
  </div>
</div>
