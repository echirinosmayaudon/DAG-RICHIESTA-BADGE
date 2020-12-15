<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<div class="self-service-siap-wrapper top-paginator-scroll">
    <div class="ama-container-fluid">
        <div class="js-list-pagination">
            <div class="self-service-siap-container">
                <div class="ama-row">
                <#list entries as currentEntry>
                    <#assign asset = currentEntry.getAssetRenderer() />
                    <#assign className = asset.getClassName() />
                    <#if className == "com.liferay.journal.model.JournalArticle" >
                        <#assign journalArticle = asset.getArticle() />
                        <#assign document = saxReaderUtil.read(journalArticle.getContent()) />

                        <#assign rootElement = document.getRootElement() />
                        <#assign titolo = document.valueOf("//dynamic-element[@name='TitoloServizio']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign breveDescrizione = document.valueOf("//dynamic-element[@name='BreveDescrizione']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign testoLink = document.selectNodes("//dynamic-element[@name='TestoLink']")/>
                        <#assign email = document.valueOf("//dynamic-element[@name='Email']/dynamic-content[@language-id='${locale}']/text()")/>
                        <#assign telefono = document.valueOf("//dynamic-element[@name='Telefono']/dynamic-content[@language-id='${locale}']/text()")/>
                        <#assign nameEmail = document.valueOf("//dynamic-element[@name='TextEmail']/dynamic-content[@language-id='${locale}']/text()")/>
                        <#assign
                        siapEntry = currentEntry
                        assetRenderer = siapEntry.getAssetRenderer()
                        entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                        viewURLSiap = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, siapEntry)
                        />
                        <#if assetLinkBehavior != "showFullContent">
                            <#assign viewURLSiap = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, siapEntry, true) />
                        </#if>
                        <#assign viewURLSiap = viewURLSiap?split("&redirect")[0] />


                        <div class="ama-col-md-4 ama-col-sm-6 ama-col-xs-12">
                            <div class="self-service-siap-box item-pagination">
                                <div class="info-title">
                                    <a href="${viewURLSiap}"  class="tooltip-field self-service-tooltip" title="${titolo}"><span class="info-icon icomoon-info"></span></a>
                                </div>



                                <div class="container">
                                    <div class="self-service-siap-header">
                                        <div class="self-service-siap-title dot-point dot-60">
                                            <a href="${viewURLSiap}"  title="${titolo}">
                                                <span class="dot-point max-dot-100 dot-mobile title">${titolo}</span>
                                            </a>
                                        </div>

                                        <div class="self-service-siap-text">
                                            <span class="dot-point max-dot-100 dot-mobile text">${breveDescrizione}</span>
                                        </div>
                                    </div>
                                    <div class="self-service-siap-box-footer">
                                        <div class="self-service-siap-link">
                                            <span class="link-icon icomoon-link-utili"></span>
                                            <span class="link-text">LINK UTILI</span>
                                            <a class="self-service-container-icon icomoon-plus"></a>
                                        </div>
                                        <div class="self-service-siap-container-link">
                                            <#list testoLink.iterator() as this>
                                                <#assign extURL = this.valueOf( "dynamic-element[@name='linkAlSelfService']") />
                                                <#assign tValue = this.valueOf( "dynamic-element[@name='TargetLinkEsterno']") />
                                                <#assign nameURL =this.valueOf( "dynamic-content" ) />
                                                <a href="${extURL}" target="${tValue?trim}" class="container-link">
                                                    <span class="container-icon icomoon-link-button"></span>
                                                    <span class="container-text-link ml-10-xs">${nameURL}</span>
                                                </a>     
                                            </#list>
                                            
                                                <div class="ama-row container-contact">
                                                                <#if telefono != "">
                                                                <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                        <a href="callto:${telefono}">
                                                <span class="icon-contact icomoon-phone-call"></span><span class="text-contact bold">CHIAMA SIAP</span><span class="text-contact">${telefono}</span></a>
                                                                </div>
                                                                </#if>
                                                                <div class="ama-col-sm-6 ama-col-xs-12 text-center">
                                                                    <div class="ama-row">
                                                                        <#if email != ''>
                                                                            <a href="mailto:${email}" class="button button-primary button-contact"><span class="button-icon icomoon-send-mail"></span>
                                                                            <#if nameEmail != ''>
                                                                                ${nameEmail}</a>
                                                                            <#else>
                                                                                CONTATTA SIAP</a>
                                                                            </#if>
                                                                        </#if>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                
                                                
                                                
                                                
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#if>
                </#list>
                </div>
            </div>
            <div class="ama-row">
                <div class="ama-col-xs-12 text-align-center">
                    <div data-totpage="12" data-totpage-mobile="5" class="paginator-wrap-dark js-pagination paginator-wrap">
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