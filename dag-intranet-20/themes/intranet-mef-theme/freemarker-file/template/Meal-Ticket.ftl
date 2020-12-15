<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<#assign user = serviceContext.getThemeDisplay().getPermissionChecker().getUser()>
<#assign personalId = user.getExpandoBridge().getAttribute("personalId")>
<#assign mealTicketLocalService = serviceLocator.findService("com.intranet.mef.job.siap.service.MealTicketLocalService")>
<#assign mealTickets = mealTicketLocalService.getMealTicketByPersonId(personalId?number)!"">

<#assign numberTickets = "0">
<#assign mounthTicket = "-">
<#assign formtaDateFrom = "MM">
<#setting locale="it_IT">
<#list mealTickets as mealTicket>
  <#assign numberTickets = mealTicket.getDueMeal()>
  <#assign mounthTicket = mealTicket.getMonth()?datetime("MM")?string('MMMM')>
</#list>
<div class="wrapper-image-buoni-pasto">
    <div class="ama-container-fluid">
        <div class="wrapper-title-small">
            <h2 class="title-box borders borders-white color-white">${LabelTitle.getData()}</h2>
        </div>

        <div class="container-buoni">
            <div class="container">
                <span class="icomoon-tickets ico-buoni"></span>
                <p class="text-buoni">
                    ${numberTickets}
                    <#if getterUtil.getNumber(numberTickets)==1>
                      ${LabelSingleItem.getData()}
                    <#else>
                      ${LabelMultiItem.getData()}
                    </#if>
                    <br>
                    <span class="month">${mounthTicket?upper_case}</span>
                </p>
            </div>
        </div>
    </div>
</div>
