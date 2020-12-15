<#assign journalContent = serviceLocator.findService("com.liferay.journal.util.JournalContent") />
<#assign groupIdArticle = themeDisplay.getScopeGroupId()>
<#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
<#assign numItem = 11>
<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#-- Category and Vovabolary services -->
<#assign catService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
<#assign vocService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
<#-- DLentries and folders services -->
<#assign DLfolderService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFolderLocalService")>
<#assign DLfileService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>
<#assign propCatService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService")>
<#assign queryUtil = staticUtil["com.liferay.portal.kernel.dao.orm.QueryUtil"]>
<#assign vocabulary = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Applicazioni")>
<#assign vocID = vocabulary.getVocabularyId()>
<#assign catEntries = catService.getVocabularyCategories(vocID,queryUtil.ALL_POS,queryUtil.ALL_POS,null)>
<#assign groupId = themeDisplay.getLayout().getGroupId()>
<#assign applicazioniServiziService = serviceLocator.findService("autorizzazione.dir.mef.service.AutorizzazioneDirLocalService") />
<#-- hit counter application -->
<#assign uaLocServ = serviceLocator.findService("autorizzazione.dir.mef.service.UtilizzoApplicazioniLocalService") />
<#-- hit counter application -->
<#assign user = themeDisplay.getPermissionChecker().getUser()>
<#assign userId = user.getUserId()>
<#assign listHit = uaLocServ.fetchLastHitsByUserId(userId?number)>
<#-- setting Autorizzazione Diretta fields-->
<#assign codiceFiscale = user.getScreenName()>
<#assign codiceFiscaleAuthorized = codiceFiscale?upper_case>
<#assign idOrgChart = user.getExpandoBridge().getAttribute("idOrgChart", false)>
<#assign cauName = user.getExpandoBridge().getAttribute("cau-name", false)>
<#assign cauNames = stringUtil.split(cauName, ";") />
<#assign objectClassName = user.getExpandoBridge().getAttribute("obj-class-name", false)>
<#assign objectClassNames = stringUtil.split(objectClassName, ";") />
<#assign organizzazioneService = serviceLocator.findService("com.intranet.mef.job.siap.service.OrganizationChartLocalService")>
<#assign mefAuthorized = 0>
<#assign dipartimentoAuthorized = 0>
<#assign direzioneAuthorized = 0>
<#assign ufficioAuthorized = 0>
<#if idOrgChart !=''>
  <#assign Organizzazione = organizzazioneService.getOrganizationChart(idOrgChart?number)>
  <#assign mefAuthorized =  Organizzazione.getLevel1()>
  <#assign dipartimentoAuthorized =  Organizzazione.getLevel2()>
  <#assign direzioneAuthorized =  Organizzazione.getLevel3()>
  <#assign ufficioAuthorized =  Organizzazione.getLevel4()>
</#if>

<#if !getterUtil.getBoolean(userInterno)>
    <#assign userInfo = "Esterno">
<#else>
    <#assign userInfo = "Interno">
</#if>
<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>
<#assign nFolders = DLfolderService.getDLFoldersCount()>
<#--<#assign folder = DLfolderService.getDLFolders(1,nFolders) > -->
<div id="overlayWidgetApps" class="overlay-widget animated fadeIn hide">
  <div class="ama-container-fluid">
    <div class="ama-row wrap-title-widget">
      <div class="ama-col-xs-12">
        <h3 class="title-overlay">Le mie applicazioni più utilizzate</h3>
      </div>
    </div>
    <div class="ama-row wrap-box-widget">
      <#if listHit == "">
            <#assign itemCount = 1>
          <#list entries?sort_by("title") as currentEntry>
              <#assign asset = currentEntry.getAssetRenderer() />
              <#assign className = asset.getClassName() />
              <#if className == "com.liferay.journal.model.JournalArticle" >

                <#assign jsonString>
                  <@renderWithTemplate article=asset.getAssetObject() template="AsJson" />
                </#assign>

                <#attempt>
                  <#assign jsonApplication = jsonString?eval />
                <#recover>
                  <#assign jsonApplication = jsonFactoryUtil.createJSONObject() />
                </#attempt>

                <#--assign journalArticle = asset.getArticle() />
                <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                <#assign rootElement = document.getRootElement() />
                <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign linkInterno = document.valueOf("//dynamic-element[@name='LinkInterno']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign linkEsterno = document.valueOf("//dynamic-element[@name='LinkEsterno']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign UrlEsterno = document.valueOf("//dynamic-element[@name='URLEsternoMEF']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign targetPage = document.valueOf("//dynamic-element[@name='TargetPage']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign catalogoBoolean = document.valueOf("//dynamic-element[@name='Catalogo']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign privato = document.valueOf("//dynamic-element[@name='Privato']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign entryCauName = document.valueOf("//dynamic-element[@name='CauName']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign entryObjClassName = document.valueOf("//dynamic-element[@name='ObjClassName']/dynamic-content[@language-id='${locale}']/text()") /-->


                <#assign linkInterno = getterUtil.getString(jsonApplication.LinkInterno) />
                <#assign linkInternoUrl = getterUtil.getString(jsonApplication.LinkInternoURL) />
                <#assign titoloApplicazione = getterUtil.getString(jsonApplication.TitoloApplicazione) />
                <#assign linkEsterno = getterUtil.getString(jsonApplication.LinkEsterno) />
                <#assign UrlEsterno = getterUtil.getString(jsonApplication.URLEsternoMEF) />
                <#assign targetPage = getterUtil.getString(jsonApplication.TargetPage) />
                <#assign SeoTitleText = getterUtil.getString(jsonApplication.TitleSeoLink) />
                <#assign catalogoBoolean = getterUtil.getString(jsonApplication.Catalogo) />
                <#assign privato = getterUtil.getBoolean(jsonApplication.Privato) />
                <#assign autorizzazioneDiretta = getterUtil.getBoolean(jsonApplication.AutorizzazioneDiretta) />
                <#assign entryCauName = getterUtil.getString(jsonApplication.CauName) />
                <#assign entryObjClassName = getterUtil.getString(jsonApplication.ObjClassName) />

                <#assign assetEntryPK = currentEntry.getClassPK()>
                <#assign journalArticleId = JournalArticleLocalService.getLatestArticle(assetEntryPK)>
                <#assign journalArticleIdFinal = journalArticleId.getArticleId()>
                <#assign linkServicePage = "">
                <#if linkInterno != "" >
                  <#--list linkInterno?split("@") as item>
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
                  <#assign linkServicePage = pageLayout.getFriendlyURL()?remove_beginning("/")-->
                  <#assign linkServicePage = linkInternoUrl>
                  <#assign targetPage = "_self">
                <#else>
                    <#if userInfo == "Esterno">
                        <#assign linkServicePage = UrlEsterno>
                    <#else>
                        <#assign linkServicePage = linkEsterno>
                    </#if>
                </#if>
                <#assign displayApp = "false">
                <#if catalogoBoolean == '["catalogo_si"]' && !privato>
                  <#assign displayApp = "true">
                <#elseif privato && catalogoBoolean == '["catalogo_si"]'>
                        <#list objectClassNames as singleList>
                            <#if (stringUtil.equalsIgnoreCase(singleList, entryObjClassName))>
                                <#assign displayApp = "true">
                            </#if>
                        </#list>
                    <#if !getterUtil.getBoolean(displayApp)>
                            <#list cauNames as singleList>
                                <#if (stringUtil.equalsIgnoreCase(singleList, entryCauName))>
                                    <#assign displayApp = "true">
                                </#if>
                            </#list>
                    </#if>
                    <#if !getterUtil.getBoolean(displayApp)>
                        <#if getterUtil.getBoolean(autorizzazioneDiretta)>
                            <#assign isVisible = applicazioniServiziService.isAuthorized(journalArticleIdFinal?number,mefAuthorized?number,dipartimentoAuthorized?number,direzioneAuthorized?number,ufficioAuthorized?number,codiceFiscaleAuthorized)>
                            <#if getterUtil.getBoolean(isVisible)>
                                <#assign displayApp = "true">
                            </#if>
                        </#if>
                    </#if>
                </#if>
                <#if getterUtil.getBoolean(displayApp) && itemCount lte numItem>

                  <#assign itemCount = itemCount+1/>
                  <div class="ama-col-md-3">
                      <a target="${targetPage}" href="${linkServicePage}" data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" class="widget-white widget-apps click-favourites-service">
                        <#assign catCounter = 0/>
                        <#list currentEntry.getCategories() as category>
                          <#if catCounter lte 0 && category!= ''>
                              <span class="widget-btn">${category.name}</span>
                          </#if>
                          <#assign catCounter = catCounter+1/>
                        </#list>
                        <p class="widget-title dot-point max-dot-60">${titoloApplicazione}</p>
                        <p class="hide">${currentEntry}</p>
                      </a>
                  </div>
                </#if>

            </#if>
          </#list>
      <#else>
            <#assign itemCount = 1>
            <#list listHit?split(";") as cur_Item_id>
                <#attempt>
                    <#assign article = JournalArticleLocalService.fetchArticle(groupIdArticle?number,cur_Item_id) >
                <#recover>
                    <#assign article = "">
                </#attempt>
                <#if article != "">
                  <#assign jsonString>
                    <@renderWithTemplate article=article template="AsJson" />
                  </#assign>

                  <#attempt>
                    <#assign jsonApplication = jsonString?eval />
                  <#recover>
                    <#assign jsonApplication = jsonFactoryUtil.createJSONObject() />
                  </#attempt>
                    <#--assign document = saxReaderUtil.read(article.getContent()) />
                    <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign linkInterno = document.valueOf("//dynamic-element[@name='LinkInterno']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign linkEsterno = document.valueOf("//dynamic-element[@name='LinkEsterno']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign UrlEsterno = document.valueOf("//dynamic-element[@name='URLEsternoMEF']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign targetPage = document.valueOf("//dynamic-element[@name='TargetPage']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign catalogoBoolean = document.valueOf("//dynamic-element[@name='Catalogo']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign privato = document.valueOf("//dynamic-element[@name='Privato']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign entryCauName = document.valueOf("//dynamic-element[@name='CauName']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign entryObjClassName = document.valueOf("//dynamic-element[@name='ObjClassName']/dynamic-content[@language-id='${locale}']/text()") /-->

                    <#assign linkInterno = getterUtil.getString(jsonApplication.LinkInterno) />
                    <#assign linkInternoUrl = getterUtil.getString(jsonApplication.LinkInternoURL) />
                    <#assign titoloApplicazione = getterUtil.getString(jsonApplication.TitoloApplicazione) />
                    <#assign linkEsterno = getterUtil.getString(jsonApplication.LinkEsterno) />
                    <#assign UrlEsterno = getterUtil.getString(jsonApplication.URLEsternoMEF) />
                    <#assign targetPage = getterUtil.getString(jsonApplication.TargetPage) />
                    <#assign SeoTitleText = getterUtil.getString(jsonApplication.TitleSeoLink) />
                    <#assign catalogoBoolean = getterUtil.getString(jsonApplication.Catalogo) />
                    <#assign privato = getterUtil.getBoolean(jsonApplication.Privato) />
                    <#assign autorizzazioneDiretta = getterUtil.getBoolean(jsonApplication.AutorizzazioneDiretta) />
                    <#assign entryCauName = getterUtil.getString(jsonApplication.CauName) />
                    <#assign entryObjClassName = getterUtil.getString(jsonApplication.ObjClassName) />

                    <#assign assetEntryPK = article.getClassPK()>
                    <#assign journalArticleIdFinal = cur_Item_id>
                    <#assign linkServicePage = "">
                    <#if linkInterno != "" >
                        <#--list linkInterno?split("@") as item>
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
                        <#assign linkServicePage = pageLayout.getFriendlyURL()?remove_beginning("/")-->
                        <#assign linkServicePage = linkInternoUrl>
                        <#assign targetPage = "_self">
                    <#else>
                        <#if userInfo == "Esterno">
                            <#assign linkServicePage = UrlEsterno>
                        <#else>
                            <#assign linkServicePage = linkEsterno>
                        </#if>
                    </#if>
                    <#assign displayApp = "false">
                    <#if catalogoBoolean == '["catalogo_si"]' && !privato>
                      <#assign displayApp = "true">
                    <#elseif privato && catalogoBoolean == '["catalogo_si"]'>
                            <#list objectClassNames as singleList>
                                <#if (stringUtil.equalsIgnoreCase(singleList, entryObjClassName))>
                                    <#assign displayApp = "true">
                                </#if>
                            </#list>
                        <#if !getterUtil.getBoolean(displayApp)>
                                <#list cauNames as singleList>
                                    <#if (stringUtil.equalsIgnoreCase(singleList, entryCauName))>
                                        <#assign displayApp = "true">
                                    </#if>
                                </#list>
                        </#if>
                        <#if !getterUtil.getBoolean(displayApp)>
                            <#if getterUtil.getBoolean(autorizzazioneDiretta)>
                                <#assign isVisible = applicazioniServiziService.isAuthorized(journalArticleIdFinal?number,mefAuthorized?number,dipartimentoAuthorized?number,direzioneAuthorized?number,ufficioAuthorized?number,codiceFiscaleAuthorized)>
                                <#if getterUtil.getBoolean(isVisible)>
                                    <#assign displayApp = "true">
                                </#if>
                            </#if>
                        </#if>
                    </#if>
                    <#if getterUtil.getBoolean(displayApp) && itemCount lte numItem>
                        <#assign itemCount = itemCount+1/>
                        <div class="ama-col-md-3">
                            <a target="${targetPage}" href="${linkServicePage}" data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" class="widget-white widget-apps click-favourites-service">
                                <#assign catCounter = 0/>
                                <#assign journalCategory = article.getResourcePrimKey()>
                                <#assign catEntries=catService.getCategories("com.liferay.journal.model.JournalArticle",journalCategory?number)/>
                                <#list catEntries as cat_entry>
                                    <#if catCounter lte 0 && cat_entry!= ''>
                                        <span class="widget-btn text-uppercase">${cat_entry.name}</span>
                                    </#if>
                                    <#assign catCounter = catCounter+1/>
                                </#list>
                                <p class="widget-title dot-point max-dot-60">${titoloApplicazione}</p>
                            </a>
                        </div>
                    </#if>
                </#if>
            </#list>
            <#if itemCount lte numItem>
                <#list entries?sort_by("title") as currentEntry>
                  <#assign asset = currentEntry.getAssetRenderer() />
                  <#assign className = asset.getClassName() />
                  <#if className == "com.liferay.journal.model.JournalArticle" >

                  <#assign jsonString>
                    <@renderWithTemplate article= asset.getArticle() template="AsJson" />
                  </#assign>

                  <#attempt>
                    <#assign jsonApplication = jsonString?eval />
                  <#recover>
                    <#assign jsonApplication = jsonFactoryUtil.createJSONObject() />
                  </#attempt>

                    <#--assign journalArticle = asset.getArticle() />
                    <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                    <#assign rootElement = document.getRootElement() />
                    <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign linkInterno = document.valueOf("//dynamic-element[@name='LinkInterno']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign linkEsterno = document.valueOf("//dynamic-element[@name='LinkEsterno']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign UrlEsterno = document.valueOf("//dynamic-element[@name='URLEsternoMEF']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign targetPage = document.valueOf("//dynamic-element[@name='TargetPage']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign catalogoBoolean = document.valueOf("//dynamic-element[@name='Catalogo']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign privato = document.valueOf("//dynamic-element[@name='Privato']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign entryCauName = document.valueOf("//dynamic-element[@name='CauName']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign entryObjClassName = document.valueOf("//dynamic-element[@name='ObjClassName']/dynamic-content[@language-id='${locale}']/text()") /-->

                    <#assign linkInterno = getterUtil.getString(jsonApplication.LinkInterno) />
                    <#assign linkInternoUrl = getterUtil.getString(jsonApplication.LinkInternoURL) />
                    <#assign titoloApplicazione = getterUtil.getString(jsonApplication.TitoloApplicazione) />
                    <#assign linkEsterno = getterUtil.getString(jsonApplication.LinkEsterno) />
                    <#assign UrlEsterno = getterUtil.getString(jsonApplication.URLEsternoMEF) />
                    <#assign targetPage = getterUtil.getString(jsonApplication.TargetPage) />
                    <#assign SeoTitleText = getterUtil.getString(jsonApplication.TitleSeoLink) />
                    <#assign catalogoBoolean = getterUtil.getString(jsonApplication.Catalogo) />
                    <#assign privato = getterUtil.getBoolean(jsonApplication.Privato) />
                    <#assign autorizzazioneDiretta = getterUtil.getBoolean(jsonApplication.AutorizzazioneDiretta) />
                    <#assign entryCauName = getterUtil.getString(jsonApplication.CauName) />
                    <#assign entryObjClassName = getterUtil.getString(jsonApplication.ObjClassName) />

                    <#assign assetEntryPK = currentEntry.getClassPK()>
                    <#assign journalArticleId = JournalArticleLocalService.getLatestArticle(assetEntryPK)>
                    <#assign journalArticleIdFinal = journalArticleId.getArticleId()>
                    <#assign linkServicePage = "">
                    <#if linkInterno != "" >
                      <#--list linkInterno?split("@") as item>
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
                      <#assign linkServicePage = pageLayout.getFriendlyURL()?remove_beginning("/")-->
                      <#assign linkServicePage = linkInternoUrl>
                      <#assign targetPage = "_self">
                    <#else>
                        <#if userInfo == "Esterno">
                            <#assign linkServicePage = UrlEsterno>
                        <#else>
                            <#assign linkServicePage = linkEsterno>
                        </#if>
                    </#if>
                    <#assign displayApp = "false">
                    <#if catalogoBoolean == '["catalogo_si"]' && !privato>
                      <#assign displayApp = "true">
                    <#elseif privato && catalogoBoolean == '["catalogo_si"]'>
                            <#list objectClassNames as singleList>
                                <#if (stringUtil.equalsIgnoreCase(singleList, entryObjClassName))>
                                    <#assign displayApp = "true">
                                </#if>
                            </#list>
                        <#if !getterUtil.getBoolean(displayApp)>
                                <#list cauNames as singleList>
                                    <#if (stringUtil.equalsIgnoreCase(singleList, entryCauName))>
                                        <#assign displayApp = "true">
                                    </#if>
                                </#list>
                        </#if>
                        <#if !getterUtil.getBoolean(displayApp)>
                            <#if getterUtil.getBoolean(autorizzazioneDiretta)>
                                <#assign isVisible = applicazioniServiziService.isAuthorized(journalArticleIdFinal?number,mefAuthorized?number,dipartimentoAuthorized?number,direzioneAuthorized?number,ufficioAuthorized?number,codiceFiscaleAuthorized)>
                                <#if getterUtil.getBoolean(isVisible)>
                                    <#assign displayApp = "true">
                                </#if>
                            </#if>
                        </#if>
                    </#if>
                    <#if getterUtil.getBoolean(displayApp) && itemCount lte numItem>
                        <#if listHit?contains(journalArticleIdFinal?string)>
                        <#else>
                      <#assign itemCount = itemCount+1/>
                      <div class="ama-col-md-3">
                          <a target="${targetPage}" href="${linkServicePage}" data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" class="widget-white widget-apps click-favourites-service">
                            <#assign catCounter = 0/>
                            <#list currentEntry.getCategories() as category>
                              <#if catCounter lte 0 && category!= ''>
                                  <span class="widget-btn">${category.name}</span>
                              </#if>
                              <#assign catCounter = catCounter+1/>
                            </#list>
                            <p class="widget-title dot-point max-dot-60">${titoloApplicazione}</p>
                            <p class="hide">${currentEntry}</p>
                          </a>
                      </div>
                    </#if>
                    </#if>
                </#if>
              </#list>
            </#if>
      </#if>
      <div class="ama-col-md-3">
        <a href="${applicationManagementPage}" class="widget-blue widget-apps">
            <p class="widget-title">VEDI TUTTO</p>
            <span class="ico-vai icomoon-vai"></span>
        </a>
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
