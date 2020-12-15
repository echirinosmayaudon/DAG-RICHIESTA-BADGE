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
<#assign scrivaniaApplicationService = serviceLocator.findService("autorizzazione.dir.mef.service.ScrivaniaLocalService") />
<#assign user = themeDisplay.getPermissionChecker().getUser()>
<#assign userId = user.getUserId()>
<#if !getterUtil.getBoolean(userInterno)>
    <#assign userInfo = "Esterno">
<#else>
    <#assign userInfo = "Interno">
</#if>
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


<#-- hit counter application -->
<#assign uaLocServ = serviceLocator.findService("autorizzazione.dir.mef.service.UtilizzoApplicazioniLocalService") />
<#-- hit counter application -->
<#assign listApplicazioniServiceHome = scrivaniaApplicationService.getHomeApps(userId?number)>
<#assign listApplicazioniServiceProfile = scrivaniaApplicationService.getProfileApps(userId?number)>
<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>
<#--
<#assign nFolders = DLfolderService.getDLFoldersCount()>
<#assign folder = DLfolderService.getDLFolders(1,nFolders) >
-->
<#--Counter Entry -->
<#assign counterEntry = 0>
<div class="ama-container-fluid">
    <div class="tab-filtri filtro-categoria">
        <div class="filtro-tabs-wrapper top-paginator-scroll">
            <span class="tab-title active">APPLICAZIONI E TOOLS</span>
        </div>

        <div id="modalErrorDesktop" class="modal modal-custom fade modal-icon-page" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container-close-error">
                        <a href="#" class="icomoon-close-white icomoon-close-error-descktop" data-dismiss="modal"></a>
                    </div>
                    <div class="modal-body">
                        <h2 class="text">Errore</h2>
                        <div class="ama-row mb-50-xs buttons-bottom">
                            <div class="ama-col-xs-12 text-center">
                                <button class="button button-primary btn-close">OK</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="wrapper-added-notice hidden error-fixed animated">
            <div class="div-message-important color-violet">
                <div class="icomoon-alert"></div>
                <div class="message-important">
                    &nbsp;
                </div>
                <button type="button" class="icon-close-error-fixed icomoon-close-white"></button>
            </div>
        </div>
        <div class="filtro-body-box">
            <div class="show-filters-mobile-button visible-xs">FILTRI <span class="bold">2</span></div>
            <div class="text-search-wrap mobile-click-open"><input class="text-search" placeholder="PAROLA CHIAVE">
                <span class="icomoon-search"></span>
            </div>
            <button class="filtro-top-button open-tab mobile-click-open" data-toggle="collapse" data-target="#filtro-category">
                <span class="button-label">CATEGORIA</span>
                <span class="icomoon-vedi-dark hidden-xs"></span><span class="icomoon-arrow-dx icon-arrow-mobile"></span>
            </button>
            <div class="hide-filters-mobile-button mobile-click-open">
                <span class="icomoon-chiudi-dark"></span>
            </div>
            <span class="filtro-numbers hidden-xs">
                <span class="bold total-item-list"></span> applicazioni
            </span>
            <div id="filtro-category" class="collapse">
                <div class="filtro-content-box filtro-category">
                    <#-- Category List -->
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
                    <#-- Category List -->
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
            <span class="bold total-item-list"></span> applicazioni</span>
        </div>
        <div class="scivania-wrapper" id="currentId" data-userid="${userId}">
            <div class="js-list-pagination">
                <div class="self-service-siap-container">
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
                                <#assign scrivaniaBoolean = document.valueOf("//dynamic-element[@name='Scrivania']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign personalizzabileBoolean = document.valueOf("//dynamic-element[@name='Personalizzabile']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign iconaApplicazione = document.valueOf("//dynamic-element[@name='IconaApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign privato = document.valueOf("//dynamic-element[@name='Privato']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign entryCauName = document.valueOf("//dynamic-element[@name='CauName']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign entryObjClassName = document.valueOf("//dynamic-element[@name='ObjClassName']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign assetEntryPK = currentEntry.getClassPK()>
                                <#assign journalArticleId = journalArticleLocalService.getLatestArticle(assetEntryPK)>
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
                                <#assign displayApp = "false">
                                <#if scrivaniaBoolean == '["scrivania_si"]' && !getterUtil.getBoolean(privato)>
                                    <#assign displayApp = "true">
                                <#elseif getterUtil.getBoolean(privato) && scrivaniaBoolean == '["scrivania_si"]'>
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
                                    <#assign disabled = "">
                                    <#assign removeFromHP = "">
                                    <#assign selectedClass = "">
                                    <#if personalizzabileBoolean == '["personalizzazione_no"]'>
                                        <#assign disabled = "disabled">
                                        <#assign removeFromHP = "remove-home-service">
                                        <#assign selectedClass = "selected">
                                    </#if>
                                    <div class="ama-col-sm-6 ama-col-md-4 ama-col-xs-12">
                                        <div class="scrivania-container item-pagination mt-0-sm mb-30-sm mt-30-xs mb-0-xs">
                                            <div class="header-container">
                                                <div class="scrivania-header-box">
                                                    <span class="icon-scrivania-header icomoon-${iconaApplicazione}"></span>
                                                    <#assign catCounter = 0>
                                                    <#list currentEntry.getCategories() as category>
                                                        <#if catCounter lte 0 && category!= ''>
                                                            <span class="scrivania-label text-uppercase">${category.name}</span>
                                                        </#if>
                                                        <#assign catCounter = catCounter+1/>
                                                    </#list>
                                                </div>
                                                <div class="text-container">
                                                    <a data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" target="${targetPage}" href="${linkServicePage}" class="click-favourites-service dot-point max-dot-100 dot-mobile text">
                                                        <span class="dot-point max-dot-100 dot-mobile text">${titoloApplicazione}</span>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="scrivania-bar-footer">
                                                <div class="scrivania-icon">
                                                    <button data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" ${disabled}  class="${removeFromHP} conteiner-icon-footer pull-right application-home-service">
                                                        <span class=" icomoon-plus icon-footer mr-5-xs ${selectedClass}"></span>
                                                        <span class="icomoon-home icon-footer"></span>
                                                    </button>
                                                </div>
                                                <div class="scrivania-icon">
                                                    <button data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" class="conteiner-icon-footer pull-left application-profile-service">
                                                        <span class=" icomoon-plus icon-footer mr-5-xs"></span>
                                                        <span class="icomoon-user icon-footer ml-5-xs"></span>
                                                    </button>
                                                </div>
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
                                <p class="copy-text wysiwyg-editor">non sono presenti applicazioni e tools per i filtri selezionati</p>
                            </div>
                        </div>
                    </#if>
                    <div class="ama-row">
                        <div class="ama-col-xs-12 text-align-center">
                            <div data-totpage="12" data-totpage-mobile="6" class="paginator-wrap-dark js-pagination paginator-wrap">
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
            </div>
        </div>
    </div>
</div>
<script>
$(document).ready(function(){
    var applicationList = $(".scivania-wrapper .item-pagination").length;
    $(".total-item-list").text(applicationList);
});
</script>
<script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/archive-search.js")}" ></script>
