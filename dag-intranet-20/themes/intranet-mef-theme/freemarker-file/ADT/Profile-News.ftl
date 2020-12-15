<div class="ama-container-fluid">
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-knowledge">
                <h2 class="title-box borders text-uppercase">
                Le mie news
                </h2>
                <a class="icomoon-vai icon-vai" title="Vai alla sezione" href="/news">
                    <span class="sr-only">Vai alla sezione</span>
                </a>
            </div>
        </div>
    </div>
</div>
<#-- Get service news Profile -->
<#assign newsApplicazioniService = serviceLocator.findService("autorizzazione.dir.mef.service.AutorizzazioneDirLocalService") />
<#-- Get user Id -->
<#assign user = themeDisplay.getPermissionChecker().getUser()>
<#assign userId = user.getUserId()>

<#-- Get Codice Fiscale user-->
<#assign codiceFiscale = user.getScreenName()>
<#assign codiceFiscaleAuthorized = codiceFiscale?upper_case>
<#-- Get user informations -->
<#assign idOrgChart = user.getExpandoBridge().getAttribute("idOrgChart")>
<#assign organizzazioneService = serviceLocator.findService("com.intranet.mef.job.siap.service.OrganizationChartLocalService")>
<#if idOrgChart ==''>
    <#assign idOrgChart = 847>
</#if>
<#assign Organizzazione = organizzazioneService.getOrganizationChart(idOrgChart?number)>
<#assign levelUser = Organizzazione.getLevel()>
<#if levelUser == 1>
	<#assign mefAuthorized = Organizzazione.getIdOrgChart()>
	<#assign dipartimentoAuthorized = 0>
	<#assign direzioneAuthorized = 0>
	<#assign ufficioAuthorized = 0>
<#elseif levelUser == 2>
    <#assign mefOrg = Organizzazione.getIdParent()>
    <#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
    <#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
    <#assign dipartimentoAuthorized = Organizzazione.getIdOrgChart()>
    <#assign direzioneAuthorized = 0>
    <#assign ufficioAuthorized = 0>
<#elseif levelUser == 3>
    <#assign dipOrg = Organizzazione.getIdParent()>
    <#assign OrganizzazioneDip = organizzazioneService.getOrganizationChart(dipOrg?number)>
    <#assign mefOrg = OrganizzazioneDip.getIdParent()>
    <#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
    <#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
    <#assign dipartimentoAuthorized = OrganizzazioneDip.getIdOrgChart()>
    <#assign direzioneAuthorized = Organizzazione.getIdOrgChart()>
    <#assign ufficioAuthorized = 0>
<#elseif levelUser == 4>
    <#assign dirOrg = Organizzazione.getIdParent()>
    <#assign OrganizzazioneDir = organizzazioneService.getOrganizationChart(dirOrg?number)>
    <#assign dipOrg = OrganizzazioneDir.getIdParent()>
    <#assign OrganizzazioneDip = organizzazioneService.getOrganizationChart(dipOrg?number)>
    <#assign mefOrg = OrganizzazioneDip.getIdParent()>
    <#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
    <#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
    <#assign dipartimentoAuthorized = OrganizzazioneDip.getIdOrgChart()>
    <#assign direzioneAuthorized = OrganizzazioneDir.getIdOrgChart()>
    <#assign ufficioAuthorized = Organizzazione.getIdOrgChart()>
<#elseif levelUser == 5>
	<#assign ufficioAuthorized = Organizzazione.getIdParent()>
	<#assign ufficio = organizzazioneService.getOrganizationChart(ufficioAuthorized?number)>
	<#assign dirOrg = ufficio.getIdParent()>
	<#assign OrganizzazioneDir = organizzazioneService.getOrganizationChart(dirOrg?number)>
	<#assign dipOrg = OrganizzazioneDir.getIdParent()>
	<#assign OrganizzazioneDip = organizzazioneService.getOrganizationChart(dipOrg?number)>
	<#assign mefOrg = OrganizzazioneDip.getIdParent()>
	<#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
	<#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
	<#assign dipartimentoAuthorized = OrganizzazioneDip.getIdOrgChart()>
    <#assign direzioneAuthorized = OrganizzazioneDir.getIdOrgChart()>
</#if>
<div class="ama-container-fluid bg-news">
    <div class="ama-row">
        <div class="carousel-knowledge">
                <#assign counter = 0>
                <#assign visibileInProfilo = 'false'>
                <#list entries as entryNews>
                    <#assign displayNews = "true">
                    <#assign asset = entryNews.getAssetRenderer() />
                    <#assign className = asset.getClassName() />
                    <#if className == "com.liferay.journal.model.JournalArticle" >
                        <#assign journalArticle = asset.getArticle() />
                        <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                        <#assign rootElement = document.getRootElement() />
                        <#assign title = document.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign shortDescription = document.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign image = document.valueOf("//dynamic-element[@name='Image']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign Data = document.valueOf("//dynamic-element[@name='Date']/dynamic-content/text()") />
                        <#assign
                            entryNews = entry
                            assetRenderer = entryNews.getAssetRenderer()
                            entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                            viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews)
                        />
                        <#if assetLinkBehavior != "showFullContent">
                            <#assign viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews, true) />
                        </#if>
                        <#assign viewURLNews = viewURLNews?split("&redirect")[0] />
                        <#assign visibileInProfilo = document.valueOf("//dynamic-element[@name='visibileInProfilo']/dynamic-content/text()") />
                            <#--
                                <#assign tagCount = 0>
                                
                                <#list entryNews.getTags() as tag>
                                    <#assign tagName = tag.getName()>
                                    <#if tagCount gte 1>
                                        <#assign isVisible = newsApplicazioniService.isNewsVisible(mefAuthorized?number,dipartimentoAuthorized?number,direzioneAuthorized?number,ufficioAuthorized?number,codiceFiscaleAuthorized,tagName)>
                                        ${isVisible?c}
                                    </#if>
                                    <#assign tagCount = tagCount+1>
                                </#list>
                            -->
                        <#assign tagListSize = entryNews.getTags()?size>
                        <#if tagListSize gt 0>
                            <#list entryNews.getTags() as tag>
                                <#assign tagName = tag.getName()>
                                <#assign isVisible = newsApplicazioniService.isNewsVisible(mefAuthorized?number,dipartimentoAuthorized?number,direzioneAuthorized?number,ufficioAuthorized?number,codiceFiscaleAuthorized,tagName)>
                                <#if !getterUtil.getBoolean(isVisible)>
                                    <#assign displayNews = "false">
                                </#if>
                            </#list>
                        </#if>
                        <#if visibileInProfilo == 'true' && displayNews == 'true'>
                            <#if image!= ''>
                                <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12">
                                    <a class="box box-xs xs-l box-img-profile" href="${viewURLNews}" target="_self" style="background-image:url(${image});" title="${title}">
                                        <span class="date color-date-w">
                            <#else>
                                <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 bg-color">
                                    <a class="box box-xs xs-l" href="${viewURLNews}" target="_self" title="${title}">
                                        <span class="date color-date-p">
                            </#if>
                                <#if validator.isNotNull(Data)>
                                    <#assign Data_DateObj = dateUtil.parseDate("yyyy-MM-dd", Data, locale)>
                                    ${dateUtil.getDate(Data_DateObj, "dd.MM.yyyy", locale)}
                                </#if>
                            </span>
                            <#if title!= ''>
                                <h2 class="dot-point dot-90">${title}</h2>
                            </#if>
                            <#if shortDescription!= ''>
                                <p class="dot-point dot-60">${shortDescription}</p>
                            </#if>
                                </a>
                            </div>
                        </#if>
                    </#if>
                </#list>
        </div>
    </div>
</div>