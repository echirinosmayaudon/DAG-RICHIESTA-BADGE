<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign user = serviceContext.getThemeDisplay().getPermissionChecker().getUser()>
<#assign personalId = user.getExpandoBridge().getAttribute("personalId")>

<#assign punchingLocalService  = serviceLocator.findService("com.intranet.mef.job.siap.service.PunchingLocalService")>
<#assign punchings = punchingLocalService.getPunchingByPersonId(personalId?number)!"">

<#assign dailyPunchingLocalService  = serviceLocator.findService("com.intranet.mef.daily.punching.service.DailyPunchingLocalService")>
<#assign punchingsDaily = dailyPunchingLocalService.getDailyPunchingsByPersonId(personalId?number)!"">


<#setting locale="it_IT">
<#setting date_format="dd.MM">

<div class="ama-container-fluid pb-30-xs">
    <div class="ama-row">
        <div class="ama-col-md-12 ama-col-xs-12">

            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small">
                        <h2 class="title-box borders">${TitlePunching.getData()}</h2>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="tab-filtri filtro-categoria collapse-group" id="tabs-profile">
                        <div class="filtro-tabs-wrapper">
                            <a href="" title="${FolderPunchingDaily.getData()}" class="tab-title active" data-toggle="collapse" data-target="#day" data-parent="#tabs-profile">${FolderPunchingDaily.getData()}</a>
                            <a href="" title="${PuchingDaysBefore.getData()}" class="tab-title" data-toggle="collapse" data-target="#before-day" data-parent="#tabs-profile">${PuchingDaysBefore.getData()}</a>
                        </div>
                        <div id="day" class="collapse in">
                            <div class="filtro-body-box">
                                <div class=" filtro-additional">
                                  <#list punchingsDaily as punchingDaily>
                                    <div class="ama-row">
                                        <div class="ama-col-md-12 ama-col-sm-12">
                                            <div class="wrapper-content-day">
                                                <div class="box-container">
                                                    <div class="ama-row">
                                                        <div class="ama-col-md-2 ama-col-xs-6 ama-col-sm-6">
                                                            <p class="text">
                                                              <#if punchingDaily.getDirection() == 'E'>
                                                                ENTRATA
                                                              <#else>
                                                                  USCITA
                                                              </#if>
                                                            </p>
                                                        </div>
                                                        <div class="ama-col-md-2 ama-col-xs-6 ama-col-sm-6 text-mobile">
                                                            <span class="icomoon-time icon-time"></span>
                                                            <p class="time-date">
                                                              <#assign hour = (punchingDaily.getPunchingId() - punchingDaily.getPunchingId()%60)/60>
                                                              <#assign min = punchingDaily.getPunchingId()%60>
                                                              <#if hour lt 10>0</#if>${hour}:<#if min lt 10>0</#if>${min}
                                                            </p>
                                                        </div>
                                                        <div class="ama-col-md-4 ama-col-xs-12 ama-col-sm-12 terminal-punching">
                                                            <span class="icomoon-group-7 icon-home"></span>
                                                            <p class="position-profile dot-point max-dot-50 dot-mobile">
                                                                  ${punchingDaily.getTerminal()}
                                                            </p>
                                                        </div>
                                                        <div class="ama-col-md-4 ama-col-xs-12 ama-col-sm-12">
                                                            <p class="description-profile dot-point dot-30 dot-mobile">${punchingDaily.getVoucher()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                  </#list>
                                </div>
                            </div>
                        </div>
                        <#setting date_format="dd MMM">
                        <div id="before-day" class="collapse">
                            <div class="filtro-body-box">
                                <div class=" filtro-additional">
                                  <#list punchings as punching>
                                    <div class="ama-row">
                                        <div class="ama-col-md-12 ama-col-sm-12">
                                            <div class="wrapper-content-day">
                                                <div class="box-container">
                                                    <div class="ama-row">
                                                        <div class="ama-col-md-2 ama-col-xs-6 ama-col-sm-6">
                                                            <p class="text">
                                                              <#if punching.getDirection() == 'E'>
                                                                ENTRATA
                                                              <#else>
                                                                  USCITA
                                                              </#if>
                                                            </p>
                                                        </div>
                                                        <div class="ama-col-md-2 ama-col-xs-6 ama-col-sm-6 text-mobile">
                                                            <#assign hour = (punching.getPunchingId() - punching.getPunchingId()%60)/60>
                                                            <#assign min = punching.getPunchingId()%60>
                                                            <p class="time-date">${punching.getPunchingDate()?date?upper_case}<span class="icomoon-time icon-time"></span> <#if hour lt 10>0</#if>${hour}:<#if min lt 10>0</#if>${min}</p>
                                                        </div>
                                                        <div class="ama-col-md-4 ama-col-xs-12 ama-col-sm-12 terminal-punching">
                                                            <span class="icomoon-group-7 icon-home"></span>
                                                            <p class="position-profile dot-point max-dot-50 dot-mobile">
                                                                ${punching.getTerminal()}
                                                            </p>
                                                        </div>
                                                        <div class="ama-col-md-4 ama-col-xs-12 ama-col-sm-12">
                                                            <p class="description-profile dot-point dot-30 dot-mobile">${punching.getVoucher()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
