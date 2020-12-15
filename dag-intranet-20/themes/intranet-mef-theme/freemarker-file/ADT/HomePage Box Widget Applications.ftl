<#assign journalContent = serviceLocator.findService("com.liferay.journal.util.JournalContent") />
<#assign appHomeItem = 8>
<#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#assign user = themeDisplay.getPermissionChecker().getUser()>
<#assign groupIdArticle = themeDisplay.getScopeGroupId()>
<#assign userId = user.getUserId()>
<#assign scrivaniaApplicationService = serviceLocator.findService("autorizzazione.dir.mef.service.ScrivaniaLocalService") />
<#assign listApplicazioniServiceHome = scrivaniaApplicationService.getHomeApps(userId?number)>
<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>

<#if !getterUtil.getBoolean(userInterno)>
    <#assign userInfo = "Esterno">
<#else>
    <#assign userInfo = "Interno">
</#if>

<#assign itemCountHP = 1>
<div class="box-scrivania-wrap">
        <div class="mobile-box-scrivania-header">
            <p class="box-scrivania-mobile-text">LA MIA SCRIVANIA</p>
            <button title="apri la tua scrivania" class="icomoon-vedi-dark box-scrivania-mobile-icon"></button>

        </div>
        <div class="mobile-box-scrivania-home">
            <ul>
                    <#list entries as appHP>
                      <#assign asset = appHP.getAssetRenderer() />
                      <#assign className = asset.getClassName() />
                        <#if className == "com.liferay.journal.model.JournalArticle" >
                            <#--
                                <#assign jsonString>
                                  <@renderWithTemplate article=asset.getAssetObject() template="AsJson" />
                                </#assign>

                                <#attempt>
                                  <#assign jsonApplication = jsonString?eval />
                                <#recover>
                                  <#assign jsonApplication = jsonFactoryUtil.createJSONObject() />
                                !-- web contente error:${asset.getAssetObject().getArticleId()}|${jsonString?html}--
                                </#attempt>
                            -->
                            <#assign journalArticle = asset.getArticle() />
                            <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                            <#assign rootElement = document.getRootElement() />
                            <#assign personalizzabileBoolean = document.valueOf("//dynamic-element[@name='Personalizzabile']/dynamic-content[@language-id='${locale}']/text()") />
                            <#--<#assign personalizzabileBoolean = getterUtil.getString(jsonApplication.Personalizzabile)/>-->

                            <#if ((personalizzabileBoolean == '["personalizzazione_no"]') || (id in listApplicazioniServiceHome)) && (itemCountHP lte appHomeItem)>
                              <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign linkInterno = document.valueOf("//dynamic-element[@name='LinkInterno']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign linkEsterno = document.valueOf("//dynamic-element[@name='LinkEsterno']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign UrlEsterno = document.valueOf("//dynamic-element[@name='URLEsternoMEF']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign targetPage = document.valueOf("//dynamic-element[@name='TargetPage']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign catalogoBoolean = document.valueOf("//dynamic-element[@name='Catalogo']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign scrivaniaBoolean = document.valueOf("//dynamic-element[@name='Scrivania']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign iconaApplicazione = document.valueOf("//dynamic-element[@name='IconaApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign privato = document.valueOf("//dynamic-element[@name='Privato']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign entryCauName = document.valueOf("//dynamic-element[@name='CauName']/dynamic-content[@language-id='${locale}']/text()") />
                              <#assign entryObjClassName = document.valueOf("//dynamic-element[@name='ObjClassName']/dynamic-content[@language-id='${locale}']/text()") />
                              <#--
                                  <#assign linkInterno = getterUtil.getString(jsonApplication.LinkInterno) />
                                  <#assign linkInternoUrl = getterUtil.getString(jsonApplication.LinkInternoURL) />
                                  <#assign titoloApplicazione = getterUtil.getString(jsonApplication.TitoloApplicazione) />
                                  <#assign linkEsterno = getterUtil.getString(jsonApplication.LinkEsterno) />
                                  <#assign UrlEsterno = getterUtil.getString(jsonApplication.URLEsternoMEF) />
                                  <#assign targetPage = getterUtil.getString(jsonApplication.TargetPage) />
                                  <#assign SeoTitleText = getterUtil.getString(jsonApplication.TitleSeoLink) />
                                  <#assign iconaApplicazione = getterUtil.getString(jsonApplication.IconaApplicazione) />
                                  <#assign privato = getterUtil.getBoolean(jsonApplication.Privato) />
                                  <#assign autorizzazioneDiretta = getterUtil.getBoolean(jsonApplication.AutorizzazioneDiretta) />
                                  <#assign entryCauName = getterUtil.getString(jsonApplication.CauName) />
                                  <#assign entryObjClassName = getterUtil.getString(jsonApplication.ObjClassName) />
                              -->
                              <#assign assetEntryPK = appHP.getClassPK()>
                              <#assign journalArticleId = JournalArticleLocalService.getLatestArticle(assetEntryPK)>
                              <#assign journalArticleIdFinal = journalArticleId.getArticleId()>
                              <#assign linkServicePage = "">
                              <#if linkInterno != "" >
                                  <#list linkInterno?split("@") as item>
                                  <#if item_index == 0>
                                      <#assign LayOutId = item?number>
                                  </#if>
                                  <#if item_index == 1>
                                      <#if item != "public">
                                      <#assign linkPrivate = true>
                                      <#else>
                                      <#assign linkPrivate = false>
                                      </#if>
                                  </#if>
                                  <#if item_index = 2>
                                      <#assign GroupId = item?number>
                                  </#if>
                                  </#list>
                                  <#assign pageLayout = layoutLocalService.getLayout(GroupId?number, linkPrivate, LayOutId?number) />
                                  <#assign linkServicePage = pageLayout.getFriendlyURL()?remove_beginning("/")>
                                  <#assign targetPage = "_self">
                              <#else>
                                  <#if userInfo == "Esterno">
                                      <#assign linkServicePage = UrlEsterno>
                                  <#else>
                                      <#assign linkServicePage = linkEsterno>
                                  </#if>
                              </#if>
                                <#assign itemCountHP = itemCountHP+1/>
                                <li>
                                    <a target="${targetPage}" href="${linkServicePage}" data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" class="widget-white widget-apps click-favourites-service">
                                        <span class="ico-scrivania icomoon-${iconaApplicazione}"></span>
                                        <span>${titoloApplicazione}</span>
                                    </a>
                                </li>
                            </#if>
                        </#if>
                    </#list>





                <#if listApplicazioniServiceHome?has_content>
                    <#list listApplicazioniServiceHome?split(";") as cur_Item_id>

                        <#attempt>
                            <#assign article = JournalArticleLocalService.fetchArticle(groupIdArticle?number,cur_Item_id) >
                        <#recover>
                            <#assign article = "">
                        </#attempt>
                        <#if article != "">
                        <#--
                          <#assign jsonString>
                            <@renderWithTemplate article=article template="AsJson" />
                          </#assign>

                          <#attempt>
                            <#assign jsonApplication = jsonString?eval />
                          <#recover>
                            <#assign jsonApplication = jsonFactoryUtil.createJSONObject() />
                                !-- web contente error:${asset.getAssetObject().getArticleId()}|${jsonString?html}--
                          </#attempt>
                      -->
                            <#assign document = saxReaderUtil.read(article.getContent()) />
                            <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign linkInterno = document.valueOf("//dynamic-element[@name='LinkInterno']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign linkEsterno = document.valueOf("//dynamic-element[@name='LinkEsterno']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign targetPage = document.valueOf("//dynamic-element[@name='TargetPage']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign iconaApplicazione = document.valueOf("//dynamic-element[@name='IconaApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign privato = document.valueOf("//dynamic-element[@name='Privato']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                            <#--
                                <#assign linkInterno = getterUtil.getString(jsonApplication.LinkInterno) />
                                <#assign linkInternoUrl = getterUtil.getString(jsonApplication.LinkInternoURL) />
                                <#assign titoloApplicazione = getterUtil.getString(jsonApplication.TitoloApplicazione) />
                                <#assign linkEsterno = getterUtil.getString(jsonApplication.LinkEsterno) />
                                <#assign targetPage = getterUtil.getString(jsonApplication.TargetPage) />
                                <#assign SeoTitleText = getterUtil.getString(jsonApplication.TitleSeoLink) />
                                <#assign iconaApplicazione = getterUtil.getString(jsonApplication.IconaApplicazione) />
                                <#assign privato = getterUtil.getBoolean(jsonApplication.Privato) />
                                <#assign autorizzazioneDiretta = getterUtil.getBoolean(jsonApplication.AutorizzazioneDiretta) />
                            -->

                            <#assign assetEntryPK = article.getClassPK()>
                            <#assign journalArticleIdFinal = cur_Item_id>
                            <#assign linkServicePage = "">
                              <#if linkInterno != "" >
                                  <#list linkInterno?split("@") as item>
                                  <#if item_index == 0>
                                      <#assign LayOutId = item?number>
                                  </#if>
                                  <#if item_index == 1>
                                      <#if item != "public">
                                      <#assign linkPrivate = true>
                                      <#else>
                                      <#assign linkPrivate = false>
                                      </#if>
                                  </#if>
                                  <#if item_index = 2>
                                      <#assign GroupId = item?number>
                                  </#if>
                                  </#list>
                                  <#assign pageLayout = layoutLocalService.getLayout(GroupId?number, linkPrivate, LayOutId?number) />
                                  <#assign linkServicePage = pageLayout.getFriendlyURL()?remove_beginning("/")>
                                  <#assign targetPage = "_self">
                              <#else>
                                  <#if userInfo == "Esterno">
                                      <#assign linkServicePage = UrlEsterno>
                                  <#else>
                                      <#assign linkServicePage = linkEsterno>
                                  </#if>
                              </#if>
                            <#if itemCountHP lte appHomeItem>
                                <#assign itemCountHP = itemCountHP+1/>
                                <li>
                                        <a target="${targetPage}" href="${linkServicePage}" data-userid="${userId}"  data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" class="widget-white widget-apps click-favourites-service">
                                        <span class="ico-scrivania icomoon-${iconaApplicazione}"></span>
                                        <span>${titoloApplicazione}</span>
                                    </a>
                                </li>
                            </#if>
                        </#if>
                    </#list>
                </#if>
                <li>
                    <a title="PERSONALIZZA" href="${gestioneScrivaniePage}">
                        <span class="ico-scrivania icomoon-settings"></span>
                        <span>PERSONALIZZA</span>
                    </a>
                </li>
            </ul>
            <div class="mobile-box-scrivania-footer">
                <button title="chiudi la tua scrivania" class="icomoon-chiudi-dark box-scrivania-mobile-icon-close"></button>
            </div>
        </div>
</div>
<#--
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
            !-- ${article.getArticleId()} render fallito --
        </#attempt>
    <#else>
        !-- ${article.getArticleId()}  senza template ${template} --
    </#if>
</#macro>
-->
