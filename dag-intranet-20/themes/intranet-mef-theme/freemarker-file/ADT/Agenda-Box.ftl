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
<#assign counter= 0 />
<#assign styleCol="" />
<#assign entrato = false />
<#assign i = 0 />
<div class="conteiner-agenda">
    <div class="ama-container-fluid">
        <div class="ama-container-fluid wrapper-agenda">
            <div class="ama-col-md-6">
                <div class="ama-row">
                    <div class="wrapper-title-agenda">
                            <#list entries as entryEvents>
                            <#if counterList == 0>
                                <#assign urlTitle = entryEvents.getAssetRenderer().getArticle().getUrlTitle()>
                                <#assign disaplyLayoutUuid = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),urlTitle, 0).getLayoutUuid()>
                                <#assign layoutLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
                                <#assign listAllPages = layoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), true)>
                                <#list listAllPages as page>
                                    <#if disaplyLayoutUuid = page.getUuid()>

                                        <h2 class="title-box-white borders-white">AGENDA</h2>
                                        <a href="${LocationPortalUrl?trim}${page.getFriendlyURL()}" title="Vai alla sezione" class="icomoon-vai">
                                            <span class="sr-only"><@liferay.language key="go-to-section"/></span>
                                        </a>
                                    </#if>
                                </#list>
                                <#assign counterList = counterList+1 />
                            </#if>
                        </#list>
                    </div>
                </div>
              <#list entries as curEntry>
                    <#assign assetRenderer = curEntry.getAssetRenderer()/>
                    <#assign entryArchive = curEntry />
                    <#assign viewURLArchive = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryArchive) />

                    <#assign jsonString>
                      <@renderWithTemplate article=assetRenderer.getAssetObject() template="AsJson" />
                    </#assign>

                    <#attempt>
                      <#assign jsonAgenda = jsonString?eval />
                    <#recover>
                      <#assign jsonAgenda = jsonFactoryUtil.createJSONObject() />
                    </#attempt>

              <#if assetLinkBehavior != "showFullContent">
                <#assign viewURLArchive = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryArchive, true) />
              </#if>
              <#assign viewURLArchive = viewURLArchive?split("&redirect")[0] />

                <div class="link-agenda-big">


            <#--assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContent()) />
            <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
            <#assign description = docXml.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
            <#assign dateS = docXml.valueOf("//dynamic-element[@name='DateStart']/dynamic-content/text()")  />
            <#assign dateE = docXml.valueOf("//dynamic-element[@name='DateEnds']/dynamic-content/text()") />
            <#assign time = docXml.valueOf("//dynamic-element[@name='Orario']/dynamic-content/text()") />
            <#assign place = docXml.valueOf("//dynamic-element[@name='Place']/dynamic-content[@language-id='${locale}']/text()") />
            <#assign light = docXml.valueOf("//dynamic-element[@name='Highlight']/dynamic-content/text()") /-->

            <#assign title = getterUtil.getString(jsonAgenda.Title) />
            <#assign description = getterUtil.getString(jsonAgenda.Description)  />
            <#assign dateS = getterUtil.getString(jsonAgenda.DateStart) />
            <#assign dateE = getterUtil.getString(jsonAgenda.DateEnds) />
            <#assign time = getterUtil.getString(jsonAgenda.Orario) />
            <#assign place = getterUtil.getString(jsonAgenda.Place) />
            <#assign light = getterUtil.getString(jsonAgenda.Highlight) />


           <#assign dateSObj = dateUtil.parseDate("yyyy-MM-dd", dateS, locale)>
           <#assign dateEObj = dateUtil.parseDate("yyyy-MM-dd", dateE, locale)>

            <#assign daySNumber = (dateUtil.getDate(dateSObj, "dd", locale))>
            <#assign dayENumber = (dateUtil.getDate(dateEObj, "dd", locale))>

            <#assign daySName = (dateUtil.getDate(dateSObj, "EEEE", locale))>

            <#assign daySMonth = (dateUtil.getDate(dateSObj, "MMM yyyy", locale))>

             <#if (entrato == false ) && (light == "true")>
             <#assign entrato = true />
                <div class="ama-row">
                    <div class="ama-col-sm-6 pt-130">
                        <div class="ama-row container-left">
                            <div class="wrap">
                                <div class="wrapper-box-first">
                                    <span class="day">${stringUtil.toUpperCase(daySName)}</span>
                                    <span class="borders-white number">${daySNumber}</span>
                                    <span class="month">${stringUtil.toUpperCase(daySMonth)}</span>
                                </div>

                                <span class="icomoon-vai"></span>

                                <div class="wrapper-box-second">
                                <#if (dateS != dateE) &&  (dateUtil.compareTo(dateEObj, dateSObj)> 0 )>
                                    <#assign dayEName = (dateUtil.getDate(dateEObj, "EEEE", locale))>
                                    <span class="day">${stringUtil.toUpperCase(dayEName)}</span>
                                </#if>
                                <#if (dateS != dateE) &&  (dateUtil.compareTo(dateEObj, dateSObj)> 0 )>
                                    <#assign dayENumber = (dateUtil.getDate(dateEObj, "dd", locale))>
                                    <span class="number">${dayENumber}</span>
                                </#if>
                                <#if (dateS != dateE) &&  (dateUtil.compareTo(dateEObj, dateSObj)> 0 )>
                                <#assign dayEMonth = (dateUtil.getDate(dateEObj, "MMM yyyy", locale))>
                                    <span class="month">${stringUtil.toUpperCase(dayEMonth)}</span>
                                </#if>
                                </div>
                            </div>
                            <a href="${viewURLArchive}" class="title-event dot-point dot-130 dot-mobile">${title}</a>
                        </div>
                    </div>

                    <div class="ama-col-sm-6 gradient pt-130">
                        <p>
                            <span class="icomoon-time span-ora"></span><span
                                class="ora span-ora pl-20-xs">${time}</span>
                        </p>
                        <div class="par par-home-left pt-30 dot-point dot-mobile max-dot-260">
                        ${htmlUtil.unescape(description)}
                        </div>
                    </div>
                </div>
                </#if>
                </div>

</#list>


            </div>

            <div class="ama-row">
                <div class="ama-col-md-6 ">
                    <div class="ama-row carousel-agenda">
<#assign dateCur  = dateUtil.getCurrentDate("yyyy-MM-dd",locale) />
<#assign OggiParse = dateUtil.parseDate("yyyy-MM-dd", dateCur, locale)>


<#list entries as curEntry>

    <#assign assetRenderer = curEntry.getAssetRenderer()/>
    <#assign entryArchive = curEntry />
    <#assign viewURLArchive = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryArchive) />

    <#assign jsonString>
      <@renderWithTemplate article=assetRenderer.getAssetObject() template="AsJson" />
    </#assign>

    <#attempt>
      <#assign jsonAgenda = jsonString?eval />
    <#recover>
      <#assign jsonAgenda = jsonFactoryUtil.createJSONObject() />
    </#attempt>

    <#--assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContent()) />
    <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
    <#assign description = docXml.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
    <#assign dateS = docXml.valueOf("//dynamic-element[@name='DateStart']/dynamic-content/text()")  />
    <#assign dateE = docXml.valueOf("//dynamic-element[@name='DateEnds']/dynamic-content/text()") />
    <#assign time = docXml.valueOf("//dynamic-element[@name='Orario']/dynamic-content/text()") />
    <#assign place = docXml.valueOf("//dynamic-element[@name='Place']/dynamic-content[@language-id='${locale}']/text()") />
    <#assign light = docXml.valueOf("//dynamic-element[@name='Highlight']/dynamic-content/text()") /-->

    <#assign title = getterUtil.getString(jsonAgenda.Title) />
    <#assign description = getterUtil.getString(jsonAgenda.Description)  />
    <#assign dateS = getterUtil.getString(jsonAgenda.DateStart) />
    <#assign dateE = getterUtil.getString(jsonAgenda.DateEnds) />
    <#assign time = getterUtil.getString(jsonAgenda.Orario) />
    <#assign place = getterUtil.getString(jsonAgenda.Place) />
    <#assign light = getterUtil.getString(jsonAgenda.Highlight) />

    <#assign dateSObj = dateUtil.parseDate("yyyy-MM-dd", dateS, locale)>
    <#assign dateEObj = dateUtil.parseDate("yyyy-MM-dd", dateE, locale)>
    <#assign daySNumber = (dateUtil.getDate(dateSObj, "dd", locale))>
    <#assign daySName = (dateUtil.getDate(dateSObj, "EEEE", locale))>
    <#assign daySMonth = (dateUtil.getDate(dateSObj, "MMM yyyy", locale))>
    <#if assetLinkBehavior != "showFullContent">
        <#assign viewURLArchive = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryArchive, true) />
    </#if>
    <#assign viewURLArchive = viewURLArchive?split("&redirect")[0] />
    <#if (dateUtil.compareTo(dateSObj, OggiParse)>= 0 ) || (dateUtil.compareTo(dateEObj, OggiParse)>= 0 )>
    <#assign counter = counter +1 >
        <div class="ama-col-md-12">
            <#if (counter > 4)>
                <#break>
            </#if>
            <#if (light=="false") >
                <#assign i = i+1>
                <#if i%2 == 0 >
                    <#assign styleCol= "color1">
                    <#assign borderRightColor ="border-right-white">
                    <#assign borderColor ="borders-white">
                <#else>
                    <#assign styleCol= "white">
                    <#assign borderRightColor ="border-right-grey">
                    <#assign borderColor ="borders-blue">
                </#if>
                <#if (dateUtil.compareTo(dateEObj, dateSObj)> 0 )>

                    <div class="container ${styleCol}">
                        <div class="giorno ${borderRightColor}">
                            <#assign dayENumber =  (dateUtil.getDate(dateEObj, "dd", locale))>
                            <#assign dayEName = (dateUtil.getDate(dateEObj, "EEEE", locale))>
                            <#assign dayEMonth = (dateUtil.getDate(dateEObj, "MMM yyyy", locale))>
                            <div class="wrap">
                            <div class="wrapper-box-first">
                                <span class="day">${stringUtil.toUpperCase(daySName)}</span>
                                <span class="${borderColor} mobile-border number">${daySNumber}</span>
                                <span class="month">${stringUtil.toUpperCase(daySMonth)}</span>
                            </div>

                            <span class="icomoon-vai"></span>

                            <div class="wrapper-box-second">
                                <span class="day">${stringUtil.toUpperCase(dayEName)}</span>
                                <span class="number">${dayENumber}</span>
                                <span class="month">${stringUtil.toUpperCase(dayEMonth)}</span>
                            </div>
                        </div>
                        </div>
                        <div class="par">
                            <a href="${viewURLArchive}" class="link-detail-event p-right dot-point dot-50 dot-mobile">${title}</a>
                            <div class="p-small dot-point dot-50 dot-mobile">${htmlUtil.unescape(description)}</div>
                        </div>
                    </div>
                <#else>
                    <div class="container ${styleCol}" href="${viewURLArchive}">
                        <div class="giorno ${borderRightColor} text-center">
                            <p>
                                <span class="day">${stringUtil.toUpperCase(daySName)}</span>
                            </p>
                            <p>
                                <span class="wrapper-number-agenda">
                                    <span class="title-box-white ${borderColor} number">${daySNumber}</span>
                                </span>
                            </p>
                            <p class="pt-5">
                                <span class="month">${stringUtil.toUpperCase(daySMonth)}</span>
                            </p>
                        </div>
                        <div class="par">
                            <a href="${viewURLArchive}" class="link-detail-event p-right dot-point dot-50 dot-mobile">${title}</a>
                            <div class="p-small dot-point dot-50 dot-mobile">${htmlUtil.unescape(description)}</div>
                        </div>
                    </div>
                </#if>
            </#if>
        </div>
    </#if>
</#list>


                    </div>
                </div>
            </div>
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
