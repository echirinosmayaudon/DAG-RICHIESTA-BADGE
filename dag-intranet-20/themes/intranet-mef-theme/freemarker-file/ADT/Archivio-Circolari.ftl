<#assign javascript_folder = themeDisplay.getPathThemeJavaScript()>
<#-- Get categories from Vocabulary -->
<#assign catService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
<#assign vocService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
<#assign queryUtil = staticUtil["com.liferay.portal.kernel.dao.orm.QueryUtil"]>
<#assign vocabulary = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Circolari")>
<#assign vocID = vocabulary.getVocabularyId()>
<#assign catEntries = catService.getVocabularyCategories(vocID,queryUtil.ALL_POS,queryUtil.ALL_POS,null)>
<#assign propCatService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService")>
<#assign fileService = (serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")) >

<#if entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="tab-filtri filtro-categoria">
                        <div class="filtro-tabs-wrapper top-paginator-scroll">
                            <span class="tab-title active text-uppercase">Tutte le circolari</span>
                        </div>
                        <div id="filtro-circolari">
                            <div class="filtro-body-box">
                                <div class="show-filters-mobile-button visible-xs"><@liferay.language key="filter-title-mobile" /> 
                                 <span class="bold">2</span></div>
                                <div class="text-search-wrap mobile-click-open"><input class="text-search" placeholder="PAROLA CHIAVE">
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
                                        ${counterList}
                                    </span> circolari
                                </span>
                                <div id="filtro-category" class="collapse">
                                    <div class="filtro-content-box filtro-category">
                                        <#list catEntries as entry> 
                                        <#assign cat = stringUtil.toUpperCase(entry.getName())>
                                        <#assign categoryId = entry.getCategoryId()>
                                        <#assign categoryId = entry.getCategoryId()>
                                        <#assign propertyCategoryList = propCatService.getCategoryProperties(categoryId) >
                                        <#assign categoryDescription = entry.getDescription(locale)>
                                            <div class="ama-col-md-3 ama-col-sm-4 ama-col-xs-12 filter-category-item-wrap">
                                                <a href="" title="${cat}" class="filter-category-item-box" data-category-id="${categoryId}">
                                                    <div class="category-item-icon">
                                                        <#if categoryDescription == "">
                                                            <span class="icon-category icomoon-altro"></span>
                                                        <#else>
                                                            <span class="icon-category icomoon-${categoryDescription}"></span>
                                                        </#if>
                                                    </div>
                                                    <div class="category-item-text">${cat}</div>
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
                                <span class="filtro-numbers filtro-numbers-mobile visible-xs"><span class="bold"><#assign counterList = 0>
                                        <#list entries as curEntry>
                                            <#assign counterList = counterList +1>
                                        </#list>
                                        ${counterList}</span> circolari</span>
                            </div>

                            
                            <div class="circolari-elenco-wrapper">
                                <div class="js-list-pagination">
                                <#if entries?has_content>
                                    <#list entries as curEntry>
                                        <#assign asset = curEntry.getAssetRenderer() />
                                        <#assign className = asset.getClassName() />
                                        <#if className == "com.liferay.journal.model.JournalArticle" >
                                            <#assign journalArticle = asset.getArticle() />
                                            <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                                            <#assign rootElement = document.getRootElement() />
                                            <#assign title = document.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                                            <#assign idCircolar = document.valueOf("//dynamic-element[@name='numeroProtocollo']/dynamic-content[@language-id='${locale}']/text()") />
                                            <#assign description = document.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
                                            <#assign Data = document.valueOf("//dynamic-element[@name='date']/dynamic-content/text()") />
                                            <#assign attachmentFiles = document.selectNodes("//dynamic-element[@name='AttachmentFile']") />

                                        <div class="circolari-elenco-item item-pagination">
                                        <div class="circolari-item animated fadeIn">
                                        <div class="container-circular">
                                        
                                           <div class="circular-box-header">
                                                <div class="ama-row circolari-head">
                                                    <div class="ama-col-xs-12 mobile-text-center">
                                                        <#list curEntry.getCategories() as category>
                                                            <span class="category text-uppercase">${category.name}</span>
                                                        </#list>
                                                    </div>
                                                </div>
                                                    
                                                <div class="ama-row mobile-text-center">
                                                    <div class="ama-col-xs-12 title-box dot-point dot-80 dot-mobile">
                                                        <span>
                                                            <#if title!= ''>
                                                                ${title} n° 
                                                            <#else>
                                                                Circolare n° 
                                                            </#if>
                                                            ${idCircolar} 
                                                            del <#if validator.isNotNull(Data)>
                                                                    <#assign Data_DateObj = dateUtil.parseDate("yyyy-MM-dd", Data, locale)>
                                                                ${dateUtil.getDate(Data_DateObj, "dd/MM/yyyy", locale)}
                                                            </#if>
                                                        </span>
                                                    </div>
                                                    <div class="ama-col-xs-12 description-box dot-point dot-80 dot-mobile">
                                                    <#if description!= ''>
                                                        <p>${description}</p>
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="circular-box-footer">
                                                <div class="circular-link">
                                                    <span class="link-icon icomoon-document-3"></span>
                                                    <span class="link-text">CIRCOLARE E ALLEGATI</span>
                                                    <a class="circular-container-icon icomoon-plus"></a>
                                                </div>
                                                <div class="circular-container-link">
                                                    <#assign listFileCounter = 0 />
                                                     <#list attachmentFiles.iterator() as this>
                                                     <#assign doc =this.valueOf( "dynamic-content" ) />
                                                     <#if listFileCounter lte 2>
                                                        <#assign counter = 0 >
                                                            <#list "${doc}"?split("/") as x>
                                                                <#if counter == 2>
                                                                    <#assign groupId = x?number >
                                                                </#if>
                                                                <#if counter == 5>
                                                                    <#assign uuId = x?split("?") >
                                                                    <#assign uuidSplit = uuId[0]>
                                                                    <#assign uuId = x >
                                                                </#if>
                                                                <#assign counter = counter+1 >
                                                            </#list>
                                                            <#assign fileEntry = (fileService.getDLFileEntryByUuidAndGroupId(uuidSplit,groupId)) >
                                                            <#assign fileExt = (fileEntry.getExtension())! "" >
                                                            <#assign fileTitle = (fileEntry.getTitle())! "" >
                                                            <#assign fileSize = (fileEntry.getSize()/ 1024) >
                                                            <#if fileExt == 'pdf'>
                                                                <#assign iconItem = 'icomoon-pdf'>
                                                            <#elseif (fileExt == 'xls') || (fileExt == 'xlsx') >
                                                                <#assign iconItem = 'icomoon-document-excel'>
                                                            <#elseif fileExt == 'ppt'>
                                                                <#assign iconItem = 'document-ppt'>
                                                            <#elseif (fileExt == 'png') || (fileExt == 'jpg')>
                                                                <#assign iconItem = 'icomoon-img'>
                                                            <#elseif (fileExt == 'doc') || (fileExt == 'docx')>
                                                                <#assign iconItem = 'icomoon-word'>
                                                            <#elseif (fileExt == 'mp3') || (fileExt == 'mp4')>
                                                                <#assign iconItem = 'icomoon-video'>
                                                            <#else>
                                                                <#assign iconItem = 'icomoon-altro2'>
                                                            </#if>
                          
                                                    <span class="container-link">
                                                        <span class="container-icon ${iconItem}"></span>
                                                        <span class="container-text-link ml-10-xs">${fileTitle}</span>
                                                        <div class="wrapper-content-dw">
                                                            <span class="text-pdf">${stringUtil.toUpperCase(fileExt)}  ${fileSize?round}Kb</span>
                                                            <a href="${doc}" download class="icomoon-download ico-dw"></a>
                                                        </div>
                                                    </span>
                                                    </#if>
                                                    <#assign listFileCounter = listFileCounter+1 />
                                                     </#list>
                                                </div>
                                            </div>
                                        </div>
                                        </div>
                                        </div>
                                        </#if>
                                    </#list> 
                                    <#else>
                                        <div class="ama-row">
                                            <div class="ama-col-xs-12">
                                                <p class="copy-text wysiwyg-editor">non sono presenti circolari per i filtri selezionati</p>
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
<script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/archive-search.js")}" ></script>
<script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/circolari.js")}" ></script>