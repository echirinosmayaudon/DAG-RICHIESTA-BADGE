<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign user = serviceContext.getThemeDisplay().getPermissionChecker().getUser()>
<#assign personalId = user.getExpandoBridge().getAttribute("personalId")>

<#assign vacationLocalService = serviceLocator.findService("com.intranet.mef.job.siap.service.VacationLocalService")>
<#assign vacation = vacationLocalService.fetchVacation(personalId?number)!"">
<#assign ResidueAnnoPrec = 0>
<#assign SpettAnnoCorr = 0>
<#assign FruiteAnnoCorr = 0>
<#assign ResidueAnno = 0>

<#if validator.isNotNull(vacation)>
  <#assign ResidueAnnoPrec = vacation.getVacationPrevYear()>
  <#assign SpettAnnoCorr = vacation.getVacationCurrYear()>
  <#assign FruiteAnnoCorr = vacation.getVacationSpent()>
  <#assign ResidueAnno = vacation.getVacationRemaining()>
</#if>

<div class="ama-container-fluid">
  <div class="ama-row">
    <div class="ama-col-md-12 ama-col-xs-12">

      <div class="ama-row">
        <div class="ama-col-md-12">
          <div class="wrapper-title-small">
            <h2 class="title-box borders">${LabelFerie.getData()}</h2>
          </div>
        </div>
      </div>
      <div class="ama-row">
        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
          <div class="box-holiday">
            <p class="text-holiday dot-point dot-mobile dot-30">${LabelFerie.ResidueAnnoPrec.getData()}</p>
            <span class="number-holiday">${ResidueAnnoPrec}</span>
          </div>
        </div>

        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
          <div class="box-holiday">
            <p class="text-holiday dot-point dot-mobile dot-30">${LabelFerie.SpettAnnoCorr.getData()}</p>
            <span class="number-holiday">${SpettAnnoCorr}</span>
          </div>
        </div>

        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
          <div class="box-holiday">
            <p class="text-holiday dot-point dot-mobile dot-30">${LabelFerie.FruiteAnnoCorr.getData()}</p>
            <span class="number-holiday">${FruiteAnnoCorr}</span>
          </div>
        </div>

        <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
          <div class="box-holiday">
            <p class="text-holiday dot-point dot-mobile dot-30">${LabelFerie.ResidueAnno.getData()}</p>
            <span class="number-holiday">${ResidueAnno}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
