<#assign javascript_folder = themeDisplay.getPathThemeJavaScript()>
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
<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
<#assign applicazioniServiziService = serviceLocator.findService("autorizzazione.dir.mef.service.AutorizzazioneDirLocalService") />
<#assign user = themeDisplay.getPermissionChecker().getUser()>
<#assign userId = user.getUserId()>

<#-- setting Autorizzazione Diretta fields-->
<#assign codiceFiscale = user.getScreenName()>
<#assign codiceFiscaleAuthorized = codiceFiscale?upper_case>
<#assign idOrgChart = user.getExpandoBridge().getAttribute("idOrgChart")>
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
<#--
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
-->
<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>
<#--
<#assign nFolders = DLfolderService.getDLFoldersCount()>
<#assign folder = DLfolderService.getDLFolders(1,nFolders) >
-->

<#if !getterUtil.getBoolean(userInterno)>
    <#assign userInfo = "Esterno">
<#else>
    <#assign userInfo = "Interno">
</#if>

<div class="wrapper-applications-mobile">
    <div class="ama-container-fluid">
        <div class="clearfix">
            <div class="tab-filtri filtro-categoria collapse-group" id="tabs-applicazione">
                <div class="filtro-tabs-wrapper top-paginator-scroll">
                    <a href="javascript:void(0);" title="LE MIE APPLICAZIONI" class="tab-title active my-applications" data-toggle="collapse" data-target="#mine-applications" data-parent="#tabs-applicazione">LE MIE APPLICAZIONI</a>
                    <a href="javascript:void(0);" title="IL CATALOGO APPLICAZIONI" class="tab-title all-applications" data-toggle="collapse" data-target="#catalogo-applications" data-parent="#tabs-applicazione">IL CATALOGO APPLICAZIONI</a>
                </div>
                <div class="filtro-body-box">
                    <div class="show-filters-mobile-button visible-xs">FILTRI <span class="bold">2</span></div>
                    <div class="text-search-wrap mobile-click-open"><input class="text-search" placeholder="PAROLA CHIAVE">
                        <span class="icomoon-search"></span>
                    </div>
                    <button class="filtro-top-button open-tab mobile-click-open" data-toggle="collapse" data-target="#filter-app-one">
                        <span class="button-label">CATEGORIA</span>
                        <span class="icomoon-vedi-dark hidden-xs"></span><span class="icomoon-arrow-dx icon-arrow-mobile"></span>
                    </button>
                    <div class="hide-filters-mobile-button mobile-click-open">
                        <span class="icomoon-chiudi-dark"></span>
                    </div>
                    <span class="filtro-numbers hidden-xs">
                        <span class="bold total-item-list"></span> applicazioni
                    </span>
                    <div id="filter-app-one" class="collapse">
                        <div class="filtro-content-box filtro-category">
                            <#list catEntries as entry>
                                <#assign categoryName = stringUtil.toUpperCase(entry.getName())>
                                <#assign categoryId = entry.getCategoryId()>
                                <#--
                                <#assign nFolders = DLfolderService.getDLFoldersCount()>
                                <#assign folder = DLfolderService.getDLFolders(1,nFolders) >
                                -->
                                <#assign categoryId = entry.getCategoryId()>
                                <#assign propertyCategoryList = propCatService.getCategoryProperties(categoryId) >
                                <#assign categoryDescription = entry.getDescription(locale)>
                                <div class="ama-col-md-3 ama-col-sm-4 ama-col-xs-12 filter-category-item-wrap">
                                    <a href="" title="${categoryName}" class="filter-category-item-box" data-category-id="${categoryId}">
                                        <div class="category-item-icon">
                                            <#if categoryDescription == "">
                                                <span class="icon-category icomoon-altro"></span>
                                            <#else>
                                                <span class="icon-category icomoon-${categoryDescription}"></span>
                                            </#if>
                                        </div>
                                        <div class="category-item-text">${categoryName}</div>
                                    </a>
                                </div>
                            </#list>
                            <div class="buttons-wrapper ama-col-xs-12">
                                <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                    <button class="button button-secondary button-cancel button-filtro">CANCELLA</button>
                                </div>
                                <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                    <button class="button button-primary">APPLICA</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="labels-container mobile-click-open">
                        <span class="labels-container-title"><@liferay.language key="key-filter-by" />:</span>
                        <div class="filter-label-item btn-filter-reset">
                            <h2>RESET</h2><span class="icomoon-close-white"></span>
                        </div>
                    </div>
                    <span class="filtro-numbers filtro-numbers-mobile visible-xs">
                        <span class="bold total-item-list"></span> applicazioni
                    </span>
                </div>
                <div id="mine-applications" class="collapse in">
                    <div class="js-list-pagination">
                        <div class="animated fadeIn">
                        <#if entries?has_content>
                            <div class="ama-row">
                                <#list entries as currentEntry>
                                    <#assign asset = currentEntry.getAssetRenderer() />
                                    <#assign className = asset.getClassName() />
                                    <#if className == "com.liferay.journal.model.JournalArticle" >
                                        <#assign journalArticle = asset.getArticle() />
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
                                        <#assign iconaApplicazione = document.valueOf("//dynamic-element[@name='IconaApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign entryCauName = document.valueOf("//dynamic-element[@name='CauName']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign entryObjClassName = document.valueOf("//dynamic-element[@name='ObjClassName']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign assetEntryPK = currentEntry.getClassPK()>
                                        <#assign journalArticleId = journalArticleLocalService.getLatestArticle(assetEntryPK)>
                                        <#assign journalArticleIdFinal = journalArticleId.getArticleId()>
                                        <#assign
                                            currentEntry = entry
                                            assetRenderer = currentEntry.getAssetRenderer()
                                            entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                                            viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry)
                                        />
                                        <#if assetLinkBehavior != "showFullContent">
                                            <#assign viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry, true) />
                                        </#if>
                                        <#assign viewURL = viewURL?split("&redirect")[0] />
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
                                        <#assign displayApp = "false">
                                        <#if catalogoBoolean == '["catalogo_si"]' && !getterUtil.getBoolean(privato)>
                                          <#assign displayApp = "true">
                                        <#elseif getterUtil.getBoolean(privato) && catalogoBoolean == '["catalogo_si"]'>
                                            <#assign cauName = user.getExpandoBridge().getAttribute("cau-name")>
                                            <#assign objectClassName = user.getExpandoBridge().getAttribute("obj-class-name")>
                                            <#if objectClassName!= ''>
                                                <#list objectClassName?split(":") as singleList>
                                                    <#assign singleResult = singleList?lower_case>
                                                    <#if (singleResult == entryObjClassName?lower_case)>
                                                        <#assign displayApp = "true">
                                                    </#if>
                                                </#list>
                                            </#if>
                                            <#if !getterUtil.getBoolean(displayApp)>
                                                <#if cauName!= ''>
                                                    <#list cauName?split(";") as singleList>
                                                        <#assign singleResult = singleList?lower_case>
                                                        <#if (singleResult == entryCauName?lower_case)>
                                                            <#assign displayApp = "true">
                                                        </#if>
                                                    </#list>
                                                </#if>
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
                                        <#if getterUtil.getBoolean(displayApp)>
                                            <div class=" application-item-wrapper ama-col-md-4 ama-col-sm-6 ama-col-xs-12 item-pagination">
                                                <div class="box-application">
                                                    <div class="header-application">
                                                        <span class="app-icon icomoon-${iconaApplicazione}"></span>
                                                        <#assign catCounter = 0/>
                                                        <#list currentEntry.getCategories() as category>
                                                            <#if catCounter lte 0 && category!= ''>
                                                                <span class="app-category text-uppercase">${category.name}</span>
                                                            </#if>
                                                            <#assign catCounter = catCounter+1/>
                                                        </#list>
                                                    </div>
                                                        <div class="app-title-container">
                                                            <a data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" target="${targetPage}" href="${linkServicePage}" class="app-title click-favourites-service" aria-label="vai all'applicazione - ${titoloApplicazione}">
                                                                <p class="dot-point dot-mobile dot-55">${titoloApplicazione}</p>
                                                            </a>
                                                        </div>
                                                    <div class="tags-container">
                                                        <div class="tags-for-modal">
                                                            <#assign tagCounter = 0 />
                                                            <#list currentEntry.getTags() as tag>
                                                                <#assign tagCounter =  tagCounter  +1 />
                                                                <#if ( tagCounter > 2)>
                                                                    <div class="tag hidden text-uppercase" data-tag-text="${tag.name}">${tag.name}</div>
                                                                <#else>
                                                                    <div class="tag js-length-check text-uppercase" data-tag-text="${tag.name}">${tag.name}</div>
                                                                </#if>
                                                            </#list>
                                                        </div>
                                                        <button type="button" title="Vedi altri tag" data-toggle="modal" data-target="#modal-application-tags" class="tag tags-more-modal hidden">...</button>
                                                    </div>
                                                    <div class="footer-app-detail">
                                                        <a title="${titoloApplicazione}" aria-label="vai alla scheda di dettaglio dell'applicazione - ${titoloApplicazione}" target="_self" href="${viewURL}" class="app-cta-detail">Scheda Applicazione <span class="icomoon-vai"></span></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </#if>
                                    </#if>
                                </#list>
                                </div>
                                <#else>
                                    <div class="ama-row">
                                        <div class="ama-col-xs-12">
                                            <p class="copy-text wysiwyg-editor">non sono presenti applicazioni e servizi per i filtri selezionati</p>
                                        </div>
                                    </div>
                                </#if>

                        </div>
                        <div class="ama-row">
                            <div class="ama-col-xs-12 text-align-center">
                                <div data-totpage="12" data-totpage-mobile="8" class="paginator-wrap-dark js-pagination paginator-wrap">
                                    <div class="btn-back-arrow disabled">
                                        <a href="" title="Pagina precedente">
                                            <i class="icomoon-arrow"></i>
                                        </a>
                                    </div>
                                    <ul class="pagination-numbers">
                                        <li class="current-page">
                                            <a title="Vai a pagina" href="">1</a>
                                        </li>
                                        <li>
                                            <a title="Vai a pagina" href="">2</a>
                                        </li>
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
                </div>
                <div id="catalogo-applications" class="collapse">
                    <div class="js-list-pagination">
                        <div class="animated fadeIn">
                            <div class="ama-row">
                                <#list entries as currentEntry>
                                    <#assign asset = currentEntry.getAssetRenderer() />
                                    <#assign className = asset.getClassName() />
                                    <#if className == "com.liferay.journal.model.JournalArticle" >
                                        <#assign journalArticle = asset.getArticle() />
                                        <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                                        <#assign rootElement = document.getRootElement() />
                                        <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign catalogoBoolean = document.valueOf("//dynamic-element[@name='Catalogo']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign
                                            currentEntry = entry
                                            assetRenderer = currentEntry.getAssetRenderer()
                                            entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                                            viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry)
                                        />
                                        <#if assetLinkBehavior != "showFullContent">
                                            <#assign viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry, true) />
                                        </#if>
                                        <#assign viewURL = viewURL?split("&redirect")[0] />
                                        <#assign iconaApplicazione = document.valueOf("//dynamic-element[@name='IconaApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                                        <#assign assetEntryPK = currentEntry.getClassPK()>
                                        <#assign journalArticleId = journalArticleLocalService.getLatestArticle(assetEntryPK)>
                                        <#assign journalArticleIdFinal = journalArticleId.getArticleId()>
                                        <#if catalogoBoolean == '["catalogo_si"]'>
                                            <div class="application-item-wrapper ama-col-md-4 ama-col-sm-6 ama-col-xs-12 item-pagination">
                                                <div class="box-application">
                                                    <div class="header-application">
                                                        <span class="app-icon icomoon-${iconaApplicazione}"></span>
                                                        <#assign catCounter = 0/>
                                                        <#list currentEntry.getCategories() as category>
                                                            <#if catCounter lte 0 && category!= ''>
                                                                <span class="app-category text-uppercase">${category.name}</span>
                                                            </#if>
                                                            <#assign catCounter = catCounter+1/>
                                                        </#list>
                                                    </div>
                                                        <div class="app-title-container">
                                                            <a data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" target="${targetPage}" href="${linkServicePage}" class="app-title click-favourites-service" aria-label="vai all'applicazione - ${titoloApplicazione}">
                                                                <p class="dot-point dot-mobile dot-55">${titoloApplicazione}</p>
                                                            </a>
                                                        </div>
                                                    <div class="tags-container">
                                                        <div class="tags-for-modal">
                                                            <#assign tagCounter = 0 />
                                                            <#list currentEntry.getTags() as tag>
                                                                <#assign tagCounter =  tagCounter  +1 />
                                                                <#if ( tagCounter > 2)>
                                                                    <div class="tag hidden text-uppercase" data-tag-text="${tag.name}">${tag.name}</div>
                                                                <#else>
                                                                    <div class="tag js-length-check text-uppercase" data-tag-text="${tag.name}">${tag.name}</div>
                                                                </#if>
                                                            </#list>
                                                        </div>
                                                        <button type="button" title="Vedi altri tag" data-toggle="modal" data-target="#modal-application-tags" class="tag tags-more-modal hidden">...</button>
                                                    </div>
                                                    <div class="footer-app-detail">
                                                        <a title="${titoloApplicazione}" aria-label="vai alla scheda di dettaglio dell'applicazione - ${titoloApplicazione}" target="_self" href="${viewURL}" class="app-cta-detail">Scheda Applicazione <span class="icomoon-vai"></span></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </#if>
                                    </#if>
                                </#list>
                            </div>
                        </div>
                        <div class="ama-row">
                            <div class="ama-col-xs-12 text-align-center">
                                <div data-totpage="12" data-totpage-mobile="8" class="paginator-wrap-dark js-pagination paginator-wrap">
                                    <div class="btn-back-arrow disabled">
                                        <a href="" title="Pagina precedente">
                                            <i class="icomoon-arrow"></i>
                                        </a>
                                    </div>
                                    <ul class="pagination-numbers">
                                        <li class="current-page">
                                            <a title="Vai a pagina" href="">1</a>
                                        </li>
                                        <li>
                                            <a title="Vai a pagina" href="">2</a>
                                        </li>
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
                </div>
            </div>
        </div>
    </div>
    <div id="modal-application-tags" class="modal modal-custom fade modal-application-tags" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="modal-title-box">
                        <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>

                        <div class="title-modal">
                            <h2 class="title">TAG</h2>
                        </div>
                    </div>
                    <div class="tags-container">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/archive-search.js")}" ></script>
<script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/applications.js")}" ></script>
<script>
    $(document).ready(function(){
        var mineApplication = $("#mine-applications .item-pagination").length;
        $(".total-item-list").text(mineApplication);
        $("#tabs-applicazione .my-applications").on("click",function(){
            var mineApplication = $("#mine-applications .item-pagination").length;
            $(".total-item-list").text(mineApplication);
        });
        $("#tabs-applicazione .all-applications").on("click",function(){
            var allApplication = $("#catalogo-applications .item-pagination").length;
            $(".total-item-list").text(allApplication);
        });
        applicationsInit();
    });
</script>
