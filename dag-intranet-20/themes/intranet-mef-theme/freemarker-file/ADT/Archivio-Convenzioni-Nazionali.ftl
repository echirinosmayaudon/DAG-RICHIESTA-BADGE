<#assign javascript_folder = themeDisplay.getPathThemeJavaScript()>
<#-- Category and Vovabolary services -->
<#assign catService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
<#assign vocService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
<#-- DLentries and folders services -->
<#assign DLfolderService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFolderLocalService")>
<#assign DLfileService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>

<#assign propCatService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService")>
<#assign queryUtil = staticUtil["com.liferay.portal.kernel.dao.orm.QueryUtil"]>
<#assign vocabulary = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Convenzioni")>
<#assign vocID = vocabulary.getVocabularyId()>
<#assign catEntries = catService.getVocabularyCategories(vocID,queryUtil.ALL_POS,queryUtil.ALL_POS,null)>
<#assign groupId = themeDisplay.getLayout().getGroupId()>
<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>
<#assign nFolders = DLfolderService.getDLFoldersCount()>
<#assign folder = DLfolderService.getDLFolders(1,nFolders) >
<div class="circolari-elenco-wrapper">
    <div class="js-list-pagination">
    <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="tab-filtri filtro-categoria">
                        <div class="filtro-tabs-wrapper top-paginator-scroll">
                           <span class="tab-title text-uppercase active">Convenzioni Nazionali</span>
                        </div>
                    <div id="filtro-circolari">

                        <div class="filtro-body-box">
                        <div class="show-filters-mobile-button visible-xs"><@liferay.language key="filter-title-mobile" /> <span class="bold">2</span></div>
                        <div class="text-search-wrap mobile-click-open"><input class="text-search" placeholder='<@liferay.language key="placeholder-keyword" />'>
                            <span class="icomoon-search"></span>
                        </div>
                        <button class="filtro-top-button open-tab mobile-click-open" data-toggle="collapse" data-target="#filtro-category">
                            <span class="button-label"><@liferay.language key="key-category" /></span>
                            <span class="icomoon-vedi-dark hidden-xs"></span><span class="icomoon-arrow-dx icon-arrow-mobile"></span>
                        </button>
                        <div class="hide-filters-mobile-button mobile-click-open">
                            <span class="icomoon-chiudi-dark"></span>
                        </div>
                        <span class="filtro-numbers hidden-xs">
                            <span class="bold">
                            <#assign counterList = 0>
                            <#list entries as entryConvenzioni>
                                                    <#assign docXml = saxReaderUtil.read(entryConvenzioni.getAssetRenderer().getArticle().getContent()) />
                        <#assign position = docXml.valueOf("//dynamic-element[@name='Position']/dynamic-content/text()") />
                            <#if position == "NAZIONALE">
                                <#assign counterList = counterList +1>
                            </#if>
                            </#list>
                            ${counterList}
                            </span> convenzioni
                        </span>
                        <div id="filtro-category" class="collapse">
                            <div class="filtro-content-box filtro-category">
                                    <#list catEntries as entry>
                                        <#assign categoryName = entry.getName()>
                                        <#assign categoryId = entry.getCategoryId()>
                                        <#assign nFolders = DLfolderService.getDLFoldersCount()>
                                        <#assign folder = DLfolderService.getDLFolders(1,nFolders) >
                                        <#assign propList = propCatService.getCategoryProperties(categoryId) >
                                        <#assign categoryDescription = entry.getDescription(locale)>
                                         <div class="ama-col-md-3 ama-col-sm-4 ama-col-xs-12 filter-category-item-wrap">
                                            <a href="" title="${categoryName}" class="filter-category-item-box mobile-benefits"  data-category-id="${categoryId}">
                                                <div class="benefits-item-icon">
                                                    <div class="box-convenzioni-icon">
                                                        <span class="icon-category icomoon-${categoryDescription}"></span>
                                                    </div>
                                                </div>
                                                <div class="benefits-item-text category-item-text">${categoryName}</div>
                                            </a>
                                        </div>
                                    </#list>
                                    <div class="buttons-wrapper ama-col-xs-12">
                                        <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                            <button class="button button-secondary button-cancel button-filtro">ANNULLA</button>
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
                        <span class="bold">
                        <#assign counterList = 0>
                        <#list entries as entryConvenzioni>
                        <#assign docXml = saxReaderUtil.read(entryConvenzioni.getAssetRenderer().getArticle().getContent()) />
                        <#assign position = docXml.valueOf("//dynamic-element[@name='Position']/dynamic-content/text()") />
                            <#if position == "NAZIONALE">
                                <#assign counterList = counterList +1>
                            </#if>
                        </#list>
                        ${counterList}
                        </span> convenzioni</span>
                    </div>

                    <div class="circolari-elenco-wrapper">
                        <div class="js-list-pagination">
                         <#if entries?has_content>
                            <#list entries as entryAgreement>
                                <#assign docXml = saxReaderUtil.read(entryAgreement.getAssetRenderer().getArticle().getContent()) />
                                <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign shortDescription = docXml.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign tipoConvenzioni = docXml.valueOf("//dynamic-element[@name='Position']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign
                                    entryAgreement = entry
                                    assetRenderer = entryAgreement.getAssetRenderer()
                                    entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                                    viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryAgreement)
                                />
                                <#if assetLinkBehavior != "showFullContent">
                                    <#assign viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryAgreement, true) />
                                </#if>
                                <#assign viewURLNews = viewURLNews?split("&redirect")[0] />
                                <#assign date = docXml.valueOf("//dynamic-element[@name='Data']/dynamic-content/text()") />
                                <#assign dateEnd = docXml.valueOf("//dynamic-element[@name='DateEnd']/dynamic-content/text()") />
                                <#assign position = docXml.valueOf("//dynamic-element[@name='Position']/dynamic-content/text()") />
                                <#assign description = docXml.valueOf("//dynamic-element[@name='Description']/dynamic-content/text()") />
                                <#assign dateObj = dateUtil.parseDate("yyyy-MM-dd",date, locale)>
                                <#assign dateEndObj = dateUtil.parseDate("yyyy-MM-dd",dateEnd, locale)>
                                <#if position == "NAZIONALE">
                                <div class="item-pagination animated fadeIn">
                                    <div class="benefits-page">
                                        <div class="ama-row">
                                            <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12">
                                                <div class="box-convenz-trasporto-park-filter image-convenzioni">
                                                <#assign catCounterDescription = 0/>
                                                    <#list entryAgreement.getCategories() as categoryDescription>
                                                    <#if catCounterDescription lte 0 && categoryDescription!= ''>
                                                    <#assign categoryDesc = categoryDescription.getDescription(locale)>
                                                    <span class="icon-category icomoon-${categoryDesc}"></span>
                                                    </#if>
                                                    <#assign catCounterDescription = catCounterDescription+1/>
                                                    </#list>
                                                    
                                                </div>
                                                    <#assign catCounter = 0/>
                                                    <#list entryAgreement.getCategories() as category>
                                                    <#if catCounter lte 0 && category!= ''>
                                                    <a href="${viewURLNews}" target="_self" title="${category.name}" aria-label="servizi" class="style-title dot-point dot-70">${category.name}</a>
                                                    </#if>
                                                    <#assign catCounter = catCounter+1/>
                                                    </#list>
                                            </div>
                                            <div class="ama-col-md-9 ama-col-sm-6 ama-col-xs-12 border-left">
                                                <div class="clearfix">
                                                    <div class="wrapper-content-title">
                                                          <a href="${viewURLNews}" title="${title}" aria-label="title" class="second-title dot-point dot-50">${title}</a>
                                                        <div class="wrapper-content">
                                                        <#if (dateUtil.compareTo(dateObj, dateEndObj)< 0 )>
                                                            <#assign dateS =dateUtil.getDate(dateObj, "dd.MM.yyyy", locale)>
                                                            <#assign dateE =dateUtil.getDate(dateEndObj, "dd.MM.yyyy", locale)>
                                                            <div class="date">
                                                                <span class="date-icon icomoon-calendar-date mr-10-xs"></span>
                                                                ${dateS}
                                                            </div>
                                                            <div class="date date-violet">
                                                                <span class="date-icon icomoon-calendar-scadenza mr-10-xs"></span>
                                                                ${dateE}
                                                            </div>
                                                        
                                                        <#else>
                                                            <div class="date">
                                                                <span class="date-icon icomoon-calendar-date mr-10-xs"></span>
                                                               <#assign dateS =dateUtil.getDate(dateObj, "dd.MM.yyyy", locale)>
                                                                ${dateS}
                                                            </div>
                                                        </#if>
                                                            
                                                        </div>
                                                    </div>
                                                    <div class="style-city  pl-10-xs mt-20-xs">${position}<span class="icomoon-pin ml-10-xs"></span></div>
                                                </div>
                                                    <div class="description pl-10-xs mt-10-xs dot-point dot-60">${description}</div>
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                                </#if>
                            </#list>
                            <#else>
                                <div class="ama-row">
                                    <div class="ama-col-xs-12">
                                        <p class="copy-text wysiwyg-editor">non sono presenti convenzioni nazionali per i filtri selezionati</p>
                                    </div>
                                </div>
                            </#if>
                        <div class="ama-row">
                            <div class="ama-col-xs-12 text-align-center">
                               <div data-totpage="5" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                                    <div class="btn-back-arrow disabled">
                                        <a href="#" title="Pagina precedente">
                                            <i class="icomoon-arrow"></i>
                                        </a>
                                    </div>
                                    <ul class="pagination-numbers">
                                        <li class="current-page"><a title="Vai a pagina" href="">1</a></li>
                                        <li><a title="Vai a pagina" href="">2</a></li>
                                    </ul>
                                    <div class="btn-forward-arrow">
                                        <a href="#" title="Pagina successiva">
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
    </div>
</div>
<script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/archive-search.js")}" ></script>