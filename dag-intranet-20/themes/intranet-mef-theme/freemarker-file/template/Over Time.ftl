<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign user = serviceContext.getThemeDisplay().getPermissionChecker().getUser()>
<#assign personalId = user.getExpandoBridge().getAttribute("personalId")>


<#assign overtimePrevMonthPayOffLocalService  = serviceLocator.findService("com.intranet.mef.job.siap.service.OvertimePrevMonthPayOffLocalService")>
<#assign overtimeBalacePrevMonthLocalService = serviceLocator.findService("com.intranet.mef.job.siap.service.OvertimeBalacePrevMonthLocalService")>
<#assign overtimeBalanceLocalService = serviceLocator.findService("com.intranet.mef.job.siap.service.OvertimeBalanceLocalService")>
<#assign currentBalanceHoursLocalService = serviceLocator.findService("com.intranet.mef.job.siap.service.CurrentBalanceHoursLocalService")>

<#assign currentBalanceHours = currentBalanceHoursLocalService.fetchCurrentBalanceHours(personalId?number)!"">
<#assign overtimeBalacePrevMonth = overtimeBalacePrevMonthLocalService.fetchOvertimeBalacePrevMonth(personalId?number)!"">
<#assign overtimeBalace = overtimeBalanceLocalService.fetchOvertimeBalance(personalId?number)!"">
<#assign overtimePrevMonthPayOff = overtimePrevMonthPayOffLocalService.fetchOvertimePrevMonthPayOff(personalId?number)!"">

<#assign SaldoOreMeseCorr = 0>
<#assign SaldoOreMesePrec = 0>
<#assign OreMatureMeseCorr = 0>
<#assign OreLiquiMeseCorr = 0>
<#assign StraSaldoMeseCorrOre = 0>
<#--assign StraSaldoMeseCorrData = "--.--.----"-->
<#setting locale="it_IT">
<#setting date_format="dd.MM.yyyy">


<#if validator.isNotNull(overtimeBalace)>
  <#assign SaldoOreMeseCorr = overtimeBalace.getOvertimeBalHourCurMonth()>
  <#assign SaldoOreMesePrec = overtimeBalace.getOvertimeBalacePrevMonth()>
</#if>

<#if validator.isNotNull(currentBalanceHours)>
  <#assign StraSaldoMeseCorrOre = currentBalanceHours.getBalanceHours()>
  <#assign StraSaldoMeseCorrData = currentBalanceHours.getBalanceHoursCurDate()>
</#if>

<#if validator.isNotNull(overtimeBalacePrevMonth)>
  <#assign OreMatureMeseCorr = overtimeBalacePrevMonth.getOvertimeDueCurrMonth()>
</#if>

<#if validator.isNotNull(overtimePrevMonthPayOff)>
  <#assign OreLiquiMeseCorr = overtimePrevMonthPayOff.getOvertimeHoursCurrPayOff()>
</#if>



<div class="ama-container-fluid">
  <div class="ama-row">
    <div class="ama-col-md-12 ama-col-xs-12">

      <div class="ama-row">
        <div class="ama-col-md-12">
          <div class="wrapper-title-small">
            <h2 class="title-box borders">${LabelStraordinari.getData()}</h2>
          </div>
        </div>
      </div>
      <div class="ama-row">
        <div class="ama-col-md-3 ama-col-sm-6">
          <div class="box-over-time">
            <div class="wrapper-text">
              <p class="text-over-time dot-point max-dot-108 dot-mobile">
                ${LabelStraordinari.SaldoOreMesePrec.getData()}
              </p>
            </div>

            <div class="block-blue">
              <span class="icomoon-time ico-time"></span>
              <span class="text-time">
                ${((SaldoOreMesePrec?number) - (SaldoOreMesePrec?number)%60)/60}
                ore - ${((SaldoOreMesePrec?number)%60)?abs} minuti
              </span>
            </div>
          </div>
        </div>

        <div class="ama-col-md-3 ama-col-sm-6">
          <div class="box-over-time">
            <div class="wrapper-text">
              <p class="text-over-time dot-point max-dot-108 dot-mobile">
                ${LabelStraordinari.SaldoOreMeseCorr.getData()}
              </p>
            </div>

            <div class="block-blue">
              <span class="icomoon-time ico-time"></span>
              <span class="text-time">
                ${((SaldoOreMeseCorr?number) - (SaldoOreMeseCorr?number)%60)/60}
                ore - ${((SaldoOreMeseCorr?number)%60)?abs} minuti
                </span>
            </div>
          </div>
        </div>

        <div class="ama-col-md-3 ama-col-sm-6">
          <div class="box-over-time">
            <div class="wrapper-text">
              <p class="text-over-time dot-point max-dot-108 dot-mobile">
                ${LabelStraordinari.OreMatureMeseCorr.getData()}
              </p>
            </div>

            <div class="block-blue">
              <span class="icomoon-time ico-time"></span>
              <span class="text-time">
                ${((OreMatureMeseCorr?number) - (OreMatureMeseCorr?number)%60)/60}
                ore - ${((OreMatureMeseCorr?number)%60)?abs} minuti
              </span>
            </div>
          </div>
        </div>

        <div class="ama-col-md-3 ama-col-sm-6">
          <div class="box-over-time">
            <div class="wrapper-text">
              <p class="text-over-time dot-point max-dot-108 dot-mobile">
                ${LabelStraordinari.OreLiquiMeseCorr.getData()}
              </p>
            </div>

            <div class="block-blue">
              <span class="icomoon-time ico-time"></span>
              <span class="text-time">
                ${((OreLiquiMeseCorr?number) - (OreLiquiMeseCorr?number)%60)/60}
                ore - ${((OreLiquiMeseCorr?number)%60)?abs} minuti
              </span>
            </div>
          </div>
        </div>
        <div class="ama-col-md-12 ama-col-sm-12">
          <div class="box-over-time">
            <div class="wrapper-text">
              <p class="text-over-time dot-point max-dot-108 dot-mobile">
                ${LabelStraordinari.StraSaldoMeseCorr.getData()}
              </p>
              <div class="wrapper-content-date">
                <span class="icomoon-calendar-date ico-calendar"></span>
                <p class="date">
                  <#if validator.isNotNull(currentBalanceHours)>
                    ${StraSaldoMeseCorrData?date}
                  <#else>
                    --.--.----
                  </#if>

                </p>
              </div>
            </div>

            <div class="block-blue">
              <span class="icomoon-time ico-time"></span>
              <span class="text-time">
                ${((StraSaldoMeseCorrOre?number) - (StraSaldoMeseCorrOre?number)%60)/60}
                ore - ${((StraSaldoMeseCorrOre?number)%60)?abs} minuti
              </span>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</div>
