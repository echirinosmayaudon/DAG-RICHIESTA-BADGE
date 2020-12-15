<#assign javascript_folder = themeDisplay.getPathThemeJavaScript()>
<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
<#assign tagsService = (serviceLocator.findService("com.liferay.asset.kernel.service.AssetTagLocalService")) >
<#assign journalArticleResourceService = (serviceLocator.findService("com.liferay.journal.service.JournalArticleResourceLocalService")) >
<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>
<div class="tab-filtri filtro-categoria collapse-group multimedia-service  animated fadeIn" id="tabs-multimedia">
    <div class="filtro-tabs-wrapper top-paginator-scroll">
        <a href="" title="LE FOTO GALLERY" class="first-tab-search tab-title gallery-item active" data-selected="" data-toggle="collapse" data-target="#multimedia-gallery" data-parent="#tabs-multimedia">LE FOTO GALLERY</a>
        <a href="" title="I VIDEO" class="second-tab-search tab-title video-item" data-selected="search" data-toggle="collapse" data-target="#multimedia-video" data-parent="#tabs-multimedia">I VIDEO</a>
    </div>
    <div class="filtro-body-box multimedia-archive">
        <div class="text-search-wrap "><input class="text-search" placeholder="PAROLA CHIAVE"><span class="icomoon-search"></span></div>
        <span class="filtro-numbers hidden-xs"><span class="bold total-item-list"></span> gallerie</span>
        
        <div class="labels-container mobile-click-open">
            <span class="labels-container-title">FILTRATO PER:</span>
            <div class="filter-label-item btn-filter-reset">
                <h2>RESET</h2><span class="icomoon-close-white"></span>
            </div>
        </div>
        <span class="filtro-numbers filtro-numbers-mobile visible-xs"><span class="bold total-item-list"></span> annunci</span>
    </div>
<#assign counterVideo = 0>
<#assign counterVideoOne = 0>
<#assign counterGallery = 0>
<#assign counterGalleryOne = 0>
<#list entries as currentEntry>
    <#assign asset = currentEntry.getAssetRenderer() />
    <#assign className = asset.getClassName() />
    <#if className == "com.liferay.journal.model.JournalArticle" >
        <#assign journalArticle = asset.getArticle() />
        <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
        <#assign videoOrFotogallery = document.valueOf("//dynamic-element[@name='VideoFotogallery']/dynamic-content[@language-id='${locale}']/text()") />
        <#if videoOrFotogallery != '["_video"]'>
            <#assign counterGallery = counterGallery+1>
            <#if counterGallery == 1>
                <div id="multimedia-gallery" class="first-tab-results collapse in">                
                    <div class="multimedia-elenco-wrapper">
                        <div class="js-list-pagination">
            </#if>
        </#if>
    </#if>
</#list>
<#list entries as currentEntry>
    <#assign asset = currentEntry.getAssetRenderer() />
    <#assign className = asset.getClassName() />
    <#if className == "com.liferay.journal.model.JournalArticle" >
        <#assign journalArticle = asset.getArticle() />
        <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
        <#assign rootElement = document.getRootElement() />
        <#assign titolo = document.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign descrizione = document.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign durataVideo = document.valueOf("//dynamic-element[@name='DurataVideo']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign relatoreVideo = document.valueOf("//dynamic-element[@name='RelatoreVideo']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign DataDiCompetenza_Data = document.valueOf("//dynamic-element[@name='DataDiCompetenza']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign immagineAnteprima = document.valueOf("//dynamic-element[@name='ImmagineDiAnteprima']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign videoOrFotogallery = document.valueOf("//dynamic-element[@name='VideoFotogallery']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign journalArticlePrimaryKey = currentEntry.getEntryId()>
        <#assign
            currentEntry = entry
            assetRenderer = currentEntry.getAssetRenderer()
            entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
            viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry)
        />
        <#if assetLinkBehavior != "showFullContent">
            <#assign viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry, true) />
        </#if>
        <#assign viewURL = viewURL?split("_redirect")[0] />
        <#if videoOrFotogallery != '["_video"]'>
            <div class="multimedia-service-count multimedia-elenco-item item-pagination">
                <div class="ama-col-xs-12 ama-col-sm-3 multimedia-item-image-box" style="background-image:url(${immagineAnteprima})">
                    <label class="category-name">
                        <span class="icomoon-camera-multim"></span>
                        <span data-service-it="${journalArticlePrimaryKey}" class="hit-multimedia multimedia-bold"></span>
                    </label>
                </div>
                <div class="ama-col-xs-12 ama-col-sm-9 multimedia-item-text-box ">
                    <div class="ama-row pt-35-md pt-25-xs">
                        <div class="ama-col-xs-12 ama-col-sm-9 text-center-mobile dot-point dot-40">
                            <a href="${viewURL}&entryId=${journalArticlePrimaryKey}" title="${titolo}" data-primarykey="${journalArticlePrimaryKey}" class="click-multimedia-service title">${titolo}</a>
                        </div>
                        <div class="ama-col-xs-12 ama-col-sm-3 text-center-mobile pt-10-xs pt-0-md mt-10-md">
                            <span class="date">
                                <#if validator.isNotNull(DataDiCompetenza_Data)>
                                    <#assign DataDiCompetenza_DateObj = dateUtil.parseDate("yyyy-MM-dd", DataDiCompetenza_Data, locale)>
                                    ${dateUtil.getDate(DataDiCompetenza_DateObj, "dd/MM/yyyy", locale)}
                                </#if>
                        </span>
                        </div>
                    </div>
                    <div class="ama-row pt-35-md pt-20-xs">
                        <div class="ama-col-xs-12 text-center-mobile dot-point dot-66">
                            <span class="description">${descrizione}</span>
                        </div>
                    </div>
                    <div class="ama-row tags-container no-pt-sm pt-0-md pt-20-xs mb-30-xs mb-0-sm mb-0-md">
                        <div class="ama-col-xs-12 text-center-mobile">
                            <#assign counter = 0 />
                            <#list currentEntry.getTags() as tag>  
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
        </#if>
    </#if>
</#list>
<#list entries as currentEntry>
<#assign asset = currentEntry.getAssetRenderer() />
<#assign className = asset.getClassName() />
<#if className == "com.liferay.journal.model.JournalArticle" >
    <#assign journalArticle = asset.getArticle() />
    <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
    <#assign videoOrFotogallery = document.valueOf("//dynamic-element[@name='VideoFotogallery']/dynamic-content[@language-id='${locale}']/text()") />
    <#if videoOrFotogallery != '["_video"]'>
        <#assign counterGalleryOne = counterGalleryOne+1>
        <#if counterGalleryOne == 1>
            <div class="ama-row">
                    <div class="ama-col-xs-12 text-align-center">
                        <div data-totpage="10" data-totpage-mobile="5" class="paginator-wrap-dark js-pagination paginator-wrap">
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
        </#if>
    </#if>
</#if>
</#list>



<#list entries as currentEntry>
<#assign asset = currentEntry.getAssetRenderer() />
<#assign className = asset.getClassName() />
<#if className == "com.liferay.journal.model.JournalArticle" >
    <#assign journalArticle = asset.getArticle() />
    <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
    <#assign videoOrFotogallery = document.valueOf("//dynamic-element[@name='VideoFotogallery']/dynamic-content[@language-id='${locale}']/text()") />
    <#if videoOrFotogallery == '["_video"]'>
        <#assign counterVideo = counterVideo+1>
        <#if counterVideo == 1>
            <div id="multimedia-video" class="second-tab-results collapse">                
                <div class="multimedia-elenco-wrapper">
                    <div class="js-list-pagination">
        </#if>
    </#if>
</#if>
</#list>
<#if entries?has_content>
    <#list entries as currentEntry>
    <#assign asset = currentEntry.getAssetRenderer() />
    <#assign className = asset.getClassName() />
    <#if className == "com.liferay.journal.model.JournalArticle" >
        <#assign journalArticle = asset.getArticle() />
        <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
        <#assign rootElement = document.getRootElement() />
        <#assign titolo = document.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign descrizione = document.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign durataVideo = document.valueOf("//dynamic-element[@name='DurataVideo']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign relatoreVideo = document.valueOf("//dynamic-element[@name='RelatoreVideo']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign DataDiCompetenza_Data = document.valueOf("//dynamic-element[@name='DataDiCompetenza']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign immagineAnteprima = document.valueOf("//dynamic-element[@name='ImmagineDiAnteprima']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign videoOrFotogallery = document.valueOf("//dynamic-element[@name='VideoFotogallery']/dynamic-content[@language-id='${locale}']/text()") />
        <#assign journalArticlePrimaryKey = currentEntry.getEntryId()>
        <#assign
            currentEntry = entry
            assetRenderer = currentEntry.getAssetRenderer()
            entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
            viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry)
        />
        <#if assetLinkBehavior != "showFullContent">
            <#assign viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, currentEntry, true) />
        </#if>
        <#assign viewURL = viewURL?split("_redirect")[0] />
        <#if videoOrFotogallery == '["_video"]'>
            <div class="multimedia-service-count multimedia-elenco-item item-pagination">
                <div class="ama-col-xs-12 ama-col-sm-3 multimedia-item-image-box multimedia-img-video" style="background-image:url(${immagineAnteprima})">
                    <label class="category-name text-left text-center-mobile">
                        <span class="icomoon-video-multim"></span>
                        <span class="video-span">
                        <p><span class="multimedia-bold">${durataVideo}</span><span>min</span></p>
                        <p><span data-service-it="${journalArticlePrimaryKey}" class="hit-multimedia multimedia-bold"></span></p>
                        </span>
                    </label>
                </div>
                <div class="ama-col-xs-12 ama-col-sm-9 multimedia-item-text-box multimedia-item-text-box-video">
                    <div class="ama-row pt-35-md pt-25-xs">
                        <div class="ama-col-xs-12 ama-col-sm-9 text-center-mobile dot-point dot-40">
                            <a href="${viewURL}&entryId=${journalArticlePrimaryKey}" title="${titolo}" data-primarykey="${journalArticlePrimaryKey}" class="click-multimedia-service title">${titolo}</a>
                        </div>
                        <div class="ama-col-xs-12 ama-col-sm-3 text-center-mobile pt-10-xs pt-0-md mt-10-md">
                            <span class="date">
                                <#if validator.isNotNull(DataDiCompetenza_Data)>
                                    <#assign DataDiCompetenza_DateObj = dateUtil.parseDate("yyyy-MM-dd", DataDiCompetenza_Data, locale)>
                                    ${dateUtil.getDate(DataDiCompetenza_DateObj, "dd/MM/yyyy", locale)}
                                </#if>
                            </span>
                        </div>
                    </div>
                    <div class="ama-row pt-20-xs">
                        <div class="ama-col-xs-12 text-center-mobile dot-point dot-40">
                            <span class="description">${descrizione}</span>
                        </div>
                    </div>
                    <div class="ama-row tags-container no-pt-sm pt-20-xs mb-20-xs mb-0-sm mb-0-md">
                        <div class="ama-col-xs-12 text-center-mobile">
                                <#assign counter = 0 />
                                <#list currentEntry.getTags() as tag>  
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
                    <#if relatoreVideo != "">
                    <div class="video-avatar-wrapper pt-20-xs mb-20-xs text-center-mobile">
                        <span class="avatar-video">
                        </span><span class="avatar-name">${relatoreVideo}</span>
                    </div>
                    </#if>
                </div>
            </div>








        </#if>
    </#if>
</#list>
<#else>
    <div class="ama-row">
        <div class="ama-col-xs-12">
            <p class="copy-text wysiwyg-editor">non sono presenti multimedia per i filtri selezionati</p>
        </div>
    </div>
</#if>
<#list entries as currentEntry>
<#assign asset = currentEntry.getAssetRenderer() />
<#assign className = asset.getClassName() />
<#if className == "com.liferay.journal.model.JournalArticle" >
<#assign journalArticle = asset.getArticle() />
<#assign document = saxReaderUtil.read(journalArticle.getContent()) />
<#assign videoOrFotogallery = document.valueOf("//dynamic-element[@name='VideoFotogallery']/dynamic-content[@language-id='${locale}']/text()") />
<#if videoOrFotogallery == '["_video"]'>
    <#assign counterVideoOne = counterVideoOne+1>
    <#if counterVideoOne == 1>
        <div class="ama-row">
                <div class="ama-col-xs-12 text-align-center">
                    <div data-totpage="10" data-totpage-mobile="5" class="paginator-wrap-dark js-pagination paginator-wrap">
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
    </#if>
</#if>
</#if>
</#list>
    </div>
    <script type="text/javascript" src="${portalUtil.getStaticResourceURL(request, javascript_folder + "/archive-search.js")}" ></script>
<script>
    $(document).ready(function(){
        var galleryItem = $("#multimedia-gallery .item-pagination").length;
        $(".total-item-list").text(galleryItem);
        $("#tabs-multimedia .gallery-item").on("click",function(){
            var galleryItem = $("#multimedia-gallery .item-pagination").length;
            $(".total-item-list").text(galleryItem);
        });
        $("#tabs-multimedia .video-item").on("click",function(){
            var videoItem = $("#multimedia-video .item-pagination").length;
            $(".total-item-list").text(videoItem);
        });
    });
</script>