<#assign journalContent = serviceLocator.findService("com.liferay.journal.util.JournalContent") />
<#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
<#assign groupId = themeDisplay.getScopeGroupId()>
<#assign groupLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService")>
<#assign group = groupLocalServiceUtil.getGroup(groupId)>
<#assign homeMainPortalUrl = group.getExpandoBridge().getAttribute("home-main-portal-url",false)>
<#if (homeMainPortalUrl == "/") || (homeMainPortalUrl == "")>
    <#assign homeMainPortalUrl = "" />
</#if>
<#assign LocationPortalUrl = themeDisplay.portalURL+homeMainPortalUrl?replace("/home","") />
<#assign counterList = 0 />
<#assign counterItem = 0 />
<#list entries as entryEvents>
    <#if counterList == 0>
        <#assign urlTitle = entryEvents.getAssetRenderer().getArticle().getUrlTitle()>
        <#assign disaplyLayoutUuid = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),urlTitle, 0).getLayoutUuid()>
        <#assign layoutLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
        <#assign listAllPages = layoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), true)>
        <#list listAllPages as page>
            <#if disaplyLayoutUuid = page.getUuid()>
                <div class="ama-container-fluid">
                    <div class="ama-row">
                        <div class="ama-col-md-12">
                            <div class="wrapper-title-photos">
                                <h2 class="title-box borders">MULTIMEDIA</h2>
                                <a href="${LocationPortalUrl?trim}${page.getFriendlyURL()}" title="Vai alla sezione" class="icomoon-vai">
                                    <span class="sr-only"><@liferay.language key="go-to-section"/></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </#if>
        </#list>
        <#assign counterList = counterList+1 />
    </#if>
</#list>
<div class="ama-container-fluid wrapper-photos">
    <div class="ama-row carousel-photos">
        <#list entries as currentEntry>
            <#assign asset = currentEntry.getAssetRenderer() />
            <#assign className = asset.getClassName() />
            <#if className == "com.liferay.journal.model.JournalArticle" >
                <#assign journalArticle = asset.getArticle() />

                <#assign jsonString>
                  <@renderWithTemplate article=asset.getAssetObject() template="AsJson" />
                </#assign>

                <#attempt>
                  <#assign jsonAgenda = jsonString?eval />
                <#recover>
                  <#assign jsonAgenda = jsonFactoryUtil.createJSONObject() />
                </#attempt>

                <#--assign document = saxReaderUtil.read(journalArticle.getContent()) />
                <#assign rootElement = document.getRootElement() />
                <#assign titolo = document.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign descrizione = document.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign immagine = document.valueOf("//dynamic-element[@name='ImmagineDiAnteprima']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign videoOrFotogallery = document.valueOf("//dynamic-element[@name='VideoFotogallery']/dynamic-content[@language-id='${locale}']/text()") /-->

                <#assign titolo = getterUtil.getString(jsonAgenda.Title) />
                <#assign description = getterUtil.getString(jsonAgenda.Description)  />
                <#assign immagine = getterUtil.getString(jsonAgenda.ImmagineDiAnteprima) />
                <#assign videoOrFotogallery = getterUtil.getString(jsonAgenda.VideoFotogallery) />

                <#assign assetEntryPK = currentEntry.getClassPK()>
                <#assign journalArticleIdPK = JournalArticleLocalService.getLatestArticle(assetEntryPK)>
                <#assign journalArticleId = journalArticleIdPK.getArticleId()>
                <#assign
                    currentEntry = entry
                    assetRenderer = currentEntry.getAssetRenderer()
                    entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                    viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry)
                    />
                <#if assetLinkBehavior != "showFullContent">
                    <#assign viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry, true) />
                </#if>
                <#assign viewURL = viewURL?split("_redirect")[0] />
                <#if counterList lte 3>
                    <#assign boxClass = "big-box">
                    <#if counterList == 2>
                        <#assign boxClass = "big-box-second">
                    <#elseif counterList == 3>
                        <#assign boxClass = "big-box-third">
                    </#if>
                    <#assign iconMultimedia = "camera">
                    <#if videoOrFotogallery == '["_video"]'>
                        <#assign iconMultimedia = "video">
                    </#if>
                    <div class="ama-col-md-4 ama-col-xs-12">
                        <#if immagine!= ''>
                        <div class="box-general multimedia-hp-bg ${boxClass}" style="background-image:url(${immagine});">
                        <#else>
                        <div class="box-general ${boxClass}">
                        </#if>
                            <div class="box ${iconMultimedia}">
                                <div class="text-photos">
                                    <div class="title dot-point max-dot-80 dot-mobile">
                                        <a href="${viewURL}" data-journalArticleId="${journalArticleId}" class="click-multimedia-service">${titolo}</a>
                                    </div>
                                    <div class="description dot-point max-dot-150 dot-mobile">
                                    ${htmlUtil.unescape(description)}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </#if>
                <#assign counterList = counterList+1 />
            </#if>
        </#list>
    </div>
</div>

<#macro getTemplateKey article name>
    <#assign structure = article.getDDMStructure() />
    <#list structure.getTemplates() as template>
        <#if stringUtil.equalsIgnoreCase(template.getName(locale), name)>
            ${template.getTemplateKey()}
        </#if>
    </#list>
</#macro>

<#macro renderWithTemplate article template>
    <#assign templateKey>
        <@getTemplateKey article=article name=template />
    </#assign>
    <#if validator.isNotNull(templateKey) && validator.isNotNull(article.getArticleId()) >
        <#attempt>
            ${journalContent.getContent(article.getGroupId(), article.getArticleId(), templateKey, "view", themeDisplay.getLanguageId(), themeDisplay)}
        <#recover>
            <!-- ${article.getArticleId()} render fallito -->
        </#attempt>
    <#else>
        <!-- ${article.getArticleId()}  senza template ${template} -->
    </#if>
</#macro>
