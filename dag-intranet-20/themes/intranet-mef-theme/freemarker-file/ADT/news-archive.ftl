<#assign javascript_folder = themeDisplay.getPathThemeJavaScript()>
<#-- Category and Vovabolary services -->
<#assign catService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
<#assign vocService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
<#-- DLentries and folders services -->
<#assign DLfolderService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFolderLocalService")>
<#assign DLfileService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>

<#assign propCatService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService")>
<#assign queryUtil = staticUtil["com.liferay.portal.kernel.dao.orm.QueryUtil"]>
<#assign vocabulary = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "News")>
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
<div class="news-wrapper">
    <div class="ama-row">
        <div class="ama-col-xs-12">

         <div class="tab-filtri filtro-categoria top-paginator-scroll">
            <div class="filtro-tabs-wrapper">
                <span class="tab-title active"><@liferay.language key="all-news" /></span>
            </div>
            <div id="filtro-news">

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
                            <#list entries as entryNews>
                            <#assign counterList = counterList +1>
                            </#list>
                            ${counterList}</span> news
                        </span>
                        <div id="filtro-category" class="collapse">
                            <div class="filtro-content-box filtro-category">
                                    <#list catEntries as entry>
                                        <#assign categoryName = stringUtil.toUpperCase(entry.getName())>
                                        <#assign categoryId = entry.getCategoryId()>
                                        <#assign nFolders = DLfolderService.getDLFoldersCount()>
                                        <#assign folder = DLfolderService.getDLFolders(1,nFolders) >
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
                        <span class="bold">
                        <#assign counterList = 0>
                            <#list entries as entryNews>
                            <#assign counterList = counterList +1>
                            </#list>
                            ${counterList}
                            </span> news</span>
                    </div>



                <div class="news-elenco-wrapper">
                    <div class="js-list-pagination">
                        <#if entries?has_content>
                            <#list entries as entryNews>
                            <#assign docXml = saxReaderUtil.read(entryNews.getAssetRenderer().getArticle().getContent()) />
                            <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign shortDescription = docXml.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />
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
                            <#assign Data = docXml.valueOf("//dynamic-element[@name='Date']/dynamic-content/text()") />
                            <#assign image = docXml.valueOf("//dynamic-element[@name='Image']/dynamic-content/text()") />
                            <div class="news-elenco-item item-pagination">
                            <#if image!= ''>
                            <div class="ama-col-xs-12 ama-col-sm-3 news-item-image-box" style="background-image:url(${image})">
                            <#else>
                                <div class="ama-col-xs-12 ama-col-sm-3 news-item-image-box" style="background-image:url(/o/intranet-mef-theme/images/placeholder/placeholder-news.png)">
                            </#if>
                                    <#assign catCounter = 0/>
                                    <#list entryNews.getCategories() as category>
                                    <#if catCounter lte 0 && category!= ''>
                                    <label class="category-name text-uppercase">
                                    <span>${category.name}</span>
                                    </label>
                                    </#if>
                                    <#assign catCounter = catCounter+1/>
                                    </#list>

                                </div>
                                <div class="ama-col-xs-12 ama-col-sm-9 news-item-text-box ">
                                    <div class="ama-row pt-35-md pt-25-xs">
                                        <div class="ama-col-xs-12 ama-col-sm-9 text-center-mobile dot-point dot-40 dot-mobile">
                                            <a href="${viewURLNews}" title="${title}" class="title">${title}</a>
                                        </div>
                                        <div class="ama-col-xs-12 ama-col-sm-3 text-center-mobile pt-10-xs pt-0-md mt-10-md">
                                            <span class="date">
                                            <#if validator.isNotNull(Data)>
                                                <#assign Data_DateObj = dateUtil.parseDate("yyyy-MM-dd", Data, locale)>
                                                ${dateUtil.getDate(Data_DateObj, "dd/MM/yyyy", locale)}
                                                </#if></span>
                                        </div>
                                    </div>
                                    <div class="ama-row pt-35-md pt-20-xs">
                                        <div class="ama-col-xs-12 text-center-mobile dot-point dot-66 dot-mobile">
                                            <span class="description">${shortDescription}</span>
                                        </div>
                                    </div>
                                    <div class="ama-row tags-container no-pt-sm pt-0-md pt-20-xs mb-30-xs mb-0-sm mb-0-md">
                                        <div class="ama-col-xs-12 text-center-mobile">
                                        <#assign counter = 0 />
                                        <#list entryNews.getTags() as tag>  
                                                <#if counter < 3 >
                                                    <#assign counter =  counter +1 />
                                                    <div class="tag">${stringUtil.toUpperCase(tag.name)}</div>
                                                <#else>
                                                    <#assign counter =  counter +1 />
                                                </#if>
                                        </#list>
                                        <#if ( counter > 3 ) > 
                                        <div class="tag">...</div>
                                        </#if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#list>
                        <#else>
                            <div class="ama-row">
                                <div class="ama-col-xs-12">
                                    <p class="copy-text wysiwyg-editor">non sono presenti news per i filtri selezionati</p>
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

        </div>
    </div>
</div>
    <script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/archive-search.js")}" ></script>