<#assign javascript_folder = themeDisplay.getPathThemeJavaScript()>
<#assign layoutService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#assign fURLService =  serviceLocator.findService("com.liferay.portal.kernel.service.LayoutFriendlyURLLocalService") />

    <#-- Category and Vovabolary services -->
<#assign catService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
<#assign vocService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
<#-- DLentries and folders services -->
<#assign DLfolderService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFolderLocalService")>
<#assign DLfileService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>

<#assign propCatService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService")>
<#assign queryUtil = staticUtil["com.liferay.portal.kernel.dao.orm.QueryUtil"]>
<#assign vocabulary = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Banca dati")>
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
 <div class="banche-dati-wrapper">
    <div class="ama-row">
        <div class="ama-col-xs-12">
            <div class="tab-filtri filtro-categoria">
                <div class="filtro-tabs-wrapper top-paginator-scroll">
                    <span class="tab-title active">ARCHIVIO BANCHE DATI</span>
                </div>
                <div id="filtro-news">
                    <div class="filtro-body-box">
                        <div class="show-filters-mobile-button visible-xs"><@liferay.language key="filter-title-mobile" />
                         <span class="bold">2</span></div>
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
                                <#list entries as entryBancheDati>
                                <#assign counterList = counterList +1>
                                </#list>
                                ${counterList}
                            </span>
                            banche dati
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
                                        <a href="" title="${categoryName}" class="filter-category-item-box" data-category-id="${categoryId}">
                                            <div class="category-item-icon">
                                                <#if categoryDescription == "">
                                                    <span class="icon-category icomoon-altro"></span>
                                                <#else>
                                                    <span class="icon-category icomoon-${categoryDescription}"></span>
                                                </#if>
                                            </div>
                                            <div class="category-item-text text-uppercase">${categoryName}</div>
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
                            <span class="labels-container-title text-uppercase"><@liferay.language key="key-filter-by" />:</span>
                         
                            <div class="filter-label-item btn-filter-reset">
                                <h2>RESET</h2><span class="icomoon-close-white"></span>
                            </div>
                        </div>
                            <span class="filtro-numbers filtro-numbers-mobile visible-xs"><span class="bold">
                                <#assign counterList = 0>
                                <#list entries as entryBancheDati>
                                <#assign counterList = counterList +1>
                                </#list>
                                ${counterList}
                            </span>
                            banche dati
                    </div>
                    
                    <div class="banche-dati-elenco-wrapper">
                        <div class="js-list-pagination">
                        <#if entries?has_content>
                            <#list entries as BancheDatiEntry>
                                <#assign docXml = saxReaderUtil.read(BancheDatiEntry.getAssetRenderer().getArticle().getContent()) />
                                <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign description = docXml.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
                                <#assign image = docXml.valueOf("//dynamic-element[@name='Image']/dynamic-content/text()") />
                                <#assign
                                    BancheDatiEntry = entry
                                    assetRenderer = BancheDatiEntry.getAssetRenderer()
                                    entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                                    viewURLBancheDati = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, BancheDatiEntry)
                                />

                                <#assign esternalLink = docXml.valueOf("//dynamic-element[@name='EsternalLink']/dynamic-content/text()") />
                                <#assign nameLinkEsternal = docXml.valueOf("//dynamic-element[@name='NameLink']/dynamic-content/text()") />

                                <#if assetLinkBehavior != "showFullContent">
                                    <#assign viewURLBancheDati = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, BancheDatiEntry, true) />
                                </#if>
                                <#assign viewURLBancheDati = viewURLBancheDati?split("&redirect")[0] />

                                <div class="banche-dati-elenco-item item-pagination animated fadeIn">
                                 <#if image!= ''>
                                    <div class="ama-col-xs-12 ama-col-sm-3 banche-item-image-box" style="background-image:url(${image})">
                                <#else>
                                    <div class="ama-col-xs-12 ama-col-sm-3 banche-item-image-box" style="background-image:url(/o/intranet-mef-theme/images/placeholder/placeholder-news.png)"> 
                                </#if>

                                    <#assign catCounter = 0/>
                                        <#list BancheDatiEntry.getCategories() as category>
                                            <#if catCounter lte 0 && category!= ''>
                                            <label class="category-name text-uppercase">
                                                <span>${category.name}</span>
                                            </label>
                                            </#if>
                                            <#assign catCounter = catCounter+1/>
                                        </#list>
                                    </div>
                                    <div class="ama-col-xs-12 ama-col-sm-9 banche-dati-item-text-box ">
                                
                                        <div class="ama-row pt-25-xs">
                                            <div class="ama-col-xs-12 ama-col-sm-12 text-center-mobile dot-point dot-40 dot-mobile">
                                            <#if title!= ''>
                                                <a href="${viewURLBancheDati}" class="title" title="${viewURLBancheDati}">${title}</a>
                                             </#if>
                                            </div>
                                        </div>
                                
                                        <div class="ama-row">
                                            <div class="ama-col-xs-12 text-center-mobile dot-point dot-66 dot-mobile">
                                            <#if description != ''>
                                                <span class="description">${description}</span>
                                            </#if>
                                            </div>
                                        </div>
                                
                                        <div class="ama-row tags-container no-pt-sm pt-0-md mb-30-xs mb-0-sm mb-0-md mb-100-xs">
                                            <div class="ama-col-xs-12 text-center-mobile">
                                            <#assign counter = 0 />
                                                <#list BancheDatiEntry.getTags() as tag>    
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
            
                                        <div class="ama-row row-mr-25">
                                            <div class="box-gray">
                                                 <a href="${esternalLink}" class="text-box" target="_blank" title="${esternalLink}">
                                                    <span class="icomoon-ico-a icon-box"></span>
                                                     ${nameLinkEsternal}
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                            <#else>
                                <div class="ama-row">
                                    <div class="ama-col-xs-12">
                                        <p class="copy-text wysiwyg-editor">non sono presenti banche dati per i filtri selezionati</p>
                                    </div>
                                </div>
                            </#if>

                        
                            <div class="ama-row">
                                <div class="ama-col-xs-12 text-align-center">
                                    <div data-totpage="10" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
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