<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>

<div class="ama-container-fluid">
    <div class="ama-row">
            <div class="ama-col-xs-12">
            <div class="carusel-events white-box box-big mb-30-xs">
                <article>
                <h1 class="dot-point dot-40 typo-box-title-small text-uppercase mb-15-md mb-25-xs"><@liferay.language key="news-ed-eventi-news-eventi" /></h1>
                <div class="carusel-events-container">
                    <#assign counterNews = 0>
                    <#list entries as entryNews>
                        <#assign docXml = saxReaderUtil.read(entryNews.getAssetRenderer().getArticle().getContent()) />
                        <#assign Titolo = docXml.valueOf("//dynamic-element[@name='Titolo']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign Data = docXml.valueOf("//dynamic-element[@name='Data']/dynamic-content/text()") />
                        <#assign InPrimoPiano = docXml.valueOf("//dynamic-element[@name='InPrimoPiano']/dynamic-content/text()") />
                        <#assign Abstract = docXml.valueOf("//dynamic-element[@name='Abstract']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign OrarioEvento = docXml.valueOf("//dynamic-element[@name='OrarioEvento']/dynamic-content/text()") />
                        <#assign ImmagineNews = docXml.valueOf("//dynamic-element[@name='ImmagineNews']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign AltImage = docXml.valueOf("//dynamic-element[@name='AltImmagineNews']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign
                            entryNews = entry

                            assetRenderer = entryNews.getAssetRenderer()

                            entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))

                            viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews)
                        />

                        <#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
                        <#assign urlTitle = entryNews.getAssetRenderer().getArticle().getUrlTitle()>
                        <#assign disaplyLayoutUuid = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),urlTitle, 0).getLayoutUuid()>

                        <#assign layoutLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
                        <#assign listAllPages = layoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false)>
                          <#list listAllPages as page>
                            <#if disaplyLayoutUuid = page.getUuid()>
                              ${page.getFriendlyURL()}
                            </#if>
                          </#list>

                        <#if assetLinkBehavior != "showFullContent">
                            <#assign viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews, true) />
                        </#if>

                        <#assign viewURLNews = viewURLNews?split("&redirect")[0] />
                        <#if InPrimoPiano =='true'>
                            <#assign counterNews = counterNews +1>
                            <#if counterNews lte 3>
                            <div class="news-evidenza-wrap">
                                    <#if ImmagineNews!= ''>
                                    <div class="image-container">
                                        <img alt="${AltImage?replace('"', "'")}" src="${ImmagineNews}" />
                                    <#else>
                                    <div class="image-container">
                                        <img alt="${AltImage?replace('"', "'")}" src="/o/noipa-theme/images/placeholder/img-box-news-eventi.png" />
                                    </#if>
                                </div>
                                <div class="mr-50-xs mr-0-md ml-50-xs ml-0-md">
                                    <p class="typo-date mt-20-xs mb-15-xs">
                                        <#if validator.isNotNull(Data)>
                                        <#assign Data_DateObj = dateUtil.parseDate("yyyy-MM-dd", Data, locale)>
                                        ${dateUtil.getDate(Data_DateObj, "dd MMM yyyy", locale)}
                                        </#if>
                                    </p>
                                    <h2 class="dot-point dot-25 typo-event-title mb-5-xs"><a title="${Titolo?replace('"', "'")}" href="${viewURLNews}">${Titolo}</a></h2>
                                    <p class="dot-point dot-60 copy-text">${Abstract}</p>
                                </div>
                            </div>
                            </#if>
                        </#if>
                    </#list>
                </div>
                </article>
            </div>

        </div>
    </div>
</div>
