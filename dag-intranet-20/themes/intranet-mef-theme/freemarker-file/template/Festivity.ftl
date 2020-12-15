<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign user = serviceContext.getThemeDisplay().getPermissionChecker().getUser()>
<#assign personalId = user.getExpandoBridge().getAttribute("personalId")>
<#assign festivityLocalService = serviceLocator.findService("com.intranet.mef.job.siap.service.FestivityLocalService")>
<#assign festivity = festivityLocalService.fetchFestivity(personalId?number)!"">
<#assign FestSpettAnnoCorr = 0>
<#assign FestFruiteAnnoCorr = 0>
<#assign FestResidueAnno = 0>

<#if validator.isNotNull(festivity)>
  <#assign FestSpettAnnoCorr = festivity.getFestivityDueCurrYear()>
  <#assign FestFruiteAnnoCorr = festivity.getFestivitySpentCurrYear()>
  <#assign FestResidueAnno = festivity.getFestivityRemainCurrYear()>
</#if>
<div class="box-gray-color">
  <div class="ama-container-fluid">
    <div class="ama-row">
      <div class="ama-col-md-12 ama-col-xs-12">

        <div class="ama-row">
          <div class="ama-col-md-12">
            <div class="wrapper-title-small">
              <h2 class="title-box borders">${LabelFestivita1.getData()}</h2>
            </div>
          </div>
        </div>
        <div class="ama-row">
          <div class="ama-col-md-4 ama-col-sm-6">
            <div class="box-holiday">
              <p class="text-holiday dot-point dot-mobile dot-30">${LabelFestivita1.FestSpettAnnoCorr.getData()}</p>
              <span class="number-holiday">${FestSpettAnnoCorr}</span>
            </div>
          </div>

          <div class="ama-col-md-4 ama-col-sm-6">
            <div class="box-holiday">
              <p class="text-holiday dot-point dot-mobile dot-30">${LabelFestivita1.FestFruiteAnnoCorr.getData()}</p>
              <span class="number-holiday">${FestFruiteAnnoCorr}</span>
            </div>
          </div>

          <div class="ama-col-md-4 ama-col-sm-6">
            <div class="box-holiday">
              <p class="text-holiday dot-point dot-mobile dot-30">${LabelFestivita1.FestResidueAnno.getData()}</p>
              <span class="number-holiday">${FestResidueAnno}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
