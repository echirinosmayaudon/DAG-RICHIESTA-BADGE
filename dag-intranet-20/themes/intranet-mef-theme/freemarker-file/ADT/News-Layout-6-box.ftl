<div class="ama-container-fluid">
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-knowledge">
                <h2 class="title-box borders text-uppercase">
                Le mie news
                </h2>
                <a class="icomoon-vai icon-vai" title="Vai alla sezione" href="/news">
                    <span class="sr-only">Vai alla sezione</span>
                </a>
            </div>
        </div>
    </div>
</div>
<div class="ama-container-fluid bg-news">
    <div class="ama-row">
        <div class="carousel-knowledge">
            <#assign counterNews = 0>
            <#list entries as entryNews>
                <#assign docXml = saxReaderUtil.read(entryNews.getAssetRenderer().getArticle().getContent()) />
                <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign shortDescription = docXml.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign image = docXml.valueOf("//dynamic-element[@name='Image']/dynamic-content[@language-id='${locale}']/text()") />
                <#assign Data = docXml.valueOf("//dynamic-element[@name='Date']/dynamic-content/text()") />
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
                <#if counterNews lte 5>
                    <#if image!= ''>
                        <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12">
                            <a class="box box-xs xs-l box-img-profile" href="${viewURLNews}" target="_self" style="background-image:url(${image});" title="${title}">
                                <span class="date color-date-w">
                    <#else>
                        <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 bg-color">
                            <a class="box box-xs xs-l" href="${viewURLNews}" target="_self" title="${title}">
                                <span class="date color-date-p">
                    </#if>
                        <#if validator.isNotNull(Data)>
                            <#assign Data_DateObj = dateUtil.parseDate("yyyy-MM-dd", Data, locale)>
                            ${dateUtil.getDate(Data_DateObj, "dd.MM.yyyy", locale)}
                        </#if>
                    </span>
                    <#if title!= ''>
                        <h2 class="dot-point dot-90">${title}</h2>
                    </#if>
                    <#if shortDescription!= ''>
                        <p class="dot-point dot-60">${shortDescription}</p>
                    </#if>
                        </a>
                    </div>
                    <#assign counterNews = counterNews + 1>
                </#if>
            </#list>
        </div>
    </div>
</div>