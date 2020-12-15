<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
  <#assign user = serviceContext.getThemeDisplay().getPermissionChecker().getUser()>
  <#assign personalId = user.getExpandoBridge().getAttribute("personalId")>

  <#setting locale="it_IT">
  <#setting date_format="MMM-yy">
  <#assign mounthRef = .now?date?string?upper_case>


  <div class="box-gray-color pb-50-xs profile-info-not-work ">
      <div class="ama-container-fluid">
          <div class="ama-row">
              <div class="ama-col-md-12 ama-col-xs-12">

                  <div class="ama-row">
                      <div class="ama-col-md-12">
                          <div class="wrapper-title-small">
                              <div class="ama-row">
                                  <div class="ama-col-md-9">
                                      <h2 class="title-box borders">${TitleAbsence.getData()}</h2>
                                  </div>

                                  <div class="ama-col-md-3 ama-col-sm-6">
                                    <#setting date_format="MM">
                                    <#assign refMonth = "${mounthRef?date('MMM-yy')?date}">
                                    <#setting date_format="yyyy">
                                    <#assign refYear = "${mounthRef?date('MMM-yy')?date}">
                                      <div class="box-calendar" data-current-month="${refMonth}"  data-current-year="${refYear}">
                                          <a href="javascript:void(0)" title="" class="icomoon-arrow arrow-sx"></a>
                                          <#setting date_format="MMMM yyyy">
                                          <p class="month">${mounthRef?date("MMM-yy")?date?upper_case}</p>
                                          <a href="javascript:void(0)" title="" class="icomoon-arrow arrow-dx"></a>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
                  <#assign visible = "">
                  <#assign personalAbsenceLocalService  = serviceLocator.findService("com.intranet.mef.job.siap.service.PersonalAbsenceLocalService")>
                  <#list [0,1,2,3] as n>
                    <#if n gt 0>
                      <#assign visible = "hide">
                    </#if>
                    <#setting date_format="MM">
                    <#assign actualMonth = (.now?date?number)-n>
                    <#setting date_format="yyyy">
                    <#assign actualYear = .now?date?number>

                    <#if actualMonth == 0>
                      <#assign actualMonth = 12>
                      <#assign actualYear = actualYear-1>
                    </#if>

                    <#setting date_format="MM-yy">
                    <#assign mounthRef = ("${actualMonth?string}-${actualYear?string}")?date("MM-yy")?date?string>

                    <div class="js-list-pagination ${visible}" data-event-month="${actualMonth}" data-event-year="${actualYear}">

                      <#assign personalAbsences = personalAbsenceLocalService.getByPersonIdAndRefMonth(personalId?number,mounthRef)!"">
                      <div class="ama-row" >

                        <#setting date_format="dd.MM.yyyy">
                        <#list personalAbsences as personalAbsence>

                          <div class="ama-col-lg-3 ama-col-md-4 ama-col-sm-6">

                              <div class="item-pagination">
                                  <div class="animated fadeIn box-no-work">
                                      <div class="wrapper-time-date">
                                          <span class="icomoon-calendar-date ico-date"></span>
                                              <p class="text">${personalAbsence.getAbsenceDate()?date}</p>

                                          <span class="icomoon-time ico-time"></span>
                                              <p class="text">
                                                <#if personalAbsence.getCompleteDay() == "S">
                                                  --:--
                                                <#else>
                                                  <#assign from = personalAbsence.getFrom()>
                                                  <#assign hour = (from - from%60)/60>
                                                  <#assign min = from%60>
                                                  <#if hour lt 10>0</#if>${hour}:<#if min lt 10>0</#if>${min}
                                                </#if>
                                              </p>

                                      </div>

                                      <div class="block-white">
                                          <p class="text-course dot-point dot-30 dot-mobile">${personalAbsence.getDescription()}</p>
                                          <p class="day">
                                              <#if personalAbsence.getCompleteDay() == "S">
                                                <span class="number">1</span>giorno
                                              <#else>
                                                <#assign minAbsence = personalAbsence.getHours()>
                                                ${((minAbsence?number) - (minAbsence?number)%60)/60}
                                                ore - ${((minAbsence?number)%60)?abs} minuti
                                              </#if>
                                          </p>
                                      </div>
                                  </div>
                              </div>
                          </div>
                        </#list>
                      </div>


                         <div class="ama-row">
                              <div class="ama-col-xs-12 text-align-center">
                                  <div data-totpage="8" data-totpage-mobile="4" class="paginator-wrap-dark js-pagination paginator-wrap">
                                      <div class="btn-back-arrow disabled">
                                          <a href="" title="Pagina precedente">
                                              <i class="icomoon-arrow"></i>
                                          </a>
                                      </div>
                                      <ul class="pagination-numbers">
                                          <li class="current-page"><a title="Vai a pagina" href="">1</a></li>
                                          <li><a title="Vai a pagina" href="">2</a></li>
                                      </ul>
                                      <div class="btn-forward-arrow">
                                          <a href="" title="Pagina successiva">
                                              <i class="icomoon-arrow">
                                                  <span class=""></span>
                                              </i>
                                          </a>
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
