<#--assign journalContent = serviceLocator.findService("com.liferay.journal.util.JournalContent") /-->
<#assign groupId = themeDisplay.getScopeGroupId()>
<#assign layout = themeDisplay.getLayout()/>
<#assign groupLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService")>
<#assign group = groupLocalServiceUtil.getGroup(groupId)>
<#assign newsArchivePortalUrl = group.getExpandoBridge().getAttribute("url-archivio-news",false)>
<#if newsArchivePortalUrl != "">
    <#assign newsArchivelUrl = newsArchivePortalUrl>
</#if>
<div id="containerNews">
<div class="ama-container-fluid">
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-knowledge">

                <h2 class="title-box borders">
                <@liferay.language key="news-title" />
                </h2>

                 <a class="icomoon-vai icon-vai" title="Vai alla sezione" href="${newsArchivelUrl}">
                    <span class="sr-only">Vai alla sezione</span>
                </a>
            </div>
        </div>
    </div>
</div>
<div class="ama-container-fluid bg-news">
    <div class="ama-row">
        <#assign counterNews = 0>
        <#list entries as entryNews>

        <#--
            <#assign assetRenderer = entryNews.getAssetRenderer() />
            <#assign jsonString>
              <@renderWithTemplate article=assetRenderer.getAssetObject() template="AsJson" />
            </#assign>

            <#attempt>
              <#assign jsonNews = jsonString?eval />
            <#recover>
              <#assign jsonNews = jsonFactoryUtil.createJSONObject() />
            </#attempt>
          -->
            <#assign docXml = saxReaderUtil.read(entryNews.getAssetRenderer().getArticle().getContent()) />
            <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
            <#assign TitoloNewsInHome = docXml.valueOf("//dynamic-element[@name='TitoloNewsInHome']/dynamic-content[@language-id='${locale}']/text()") />
            <#assign shortDescription = docXml.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />
            <#assign image = docXml.valueOf("//dynamic-element[@name='Image']/dynamic-content[@language-id='${locale}']/text()") />

            <#--assign title = getterUtil.getString(jsonNews.Title) />
            <#assign shortDescription = getterUtil.getString(jsonNews.ShortDescription) />
            <#assign image = getterUtil.getString(jsonNews.Image) /-->

            <#assign
                entryNews = entry
                viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews)
            />
            <#if assetLinkBehavior != "showFullContent">
                <#assign viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews, true) />
            </#if>
            <#assign viewURLNews = viewURLNews?split("&redirect")[0] />
            <#if counterNews == 0>
                <div class="ama-col-md-8 ama-col-xs-12 style-mobile">
                    <a class="box box-xl" href="${viewURLNews}" title="${title}">
                    <#if image!= ''>
                        <div class="ama-col-sm-6 ama-col-sm-push-6 ama-col-xs-12 news-img" style="background-image:url(${image})"></div>
                    <#else>
                        <div class="ama-col-sm-6 ama-col-sm-push-6 ama-col-xs-12 news-img" style="background:linear-gradient(279deg, #2b7f8e, #003896) top center no-repeat;"></div>
                    </#if>
                  <div class="ama-col-sm-6 ama-col-sm-pull-6 ama-col-xs-12">
                <#if TitoloNewsInHome!= ''>
                    <h2 class="dot-point max-dot-130 dot-mobile">${TitoloNewsInHome}</h2>
                <#else>
                    <h2 class="dot-point max-dot-130 dot-mobile">${title}</h2>
                </#if>
                <#if shortDescription!= ''>
                    <p class="dot-point max-dot-150 dot-mobile">${shortDescription}</p>
                </#if>
              </div>
                    </a>
                </div>
            <#elseif (counterNews gte 1) && (counterNews lte 1)>
                 <div class="ama-col-md-4 ama-col-xs-12">
                    <div class="ama-row">

                        <div class="ama-col-xs-12">
                            <a class="second-news-box" href="${viewURLNews}" title="${title}">
                            <div class="news-item-wrap">
                            <#if TitoloNewsInHome!= ''>
                                <h2 class="item-h2 dot-point max-dot-95">${TitoloNewsInHome}</h2>
                                <#else>
                                <h2 class="item-h2 dot-point max-dot-95">${title}</h2>
                             </#if>
                             <#if shortDescription!= ''>
                                <p class="item-text dot-point dot-mobile max-dot-75">${shortDescription}</p>
                            </#if>
                            </div>
                            <img src="${image}" class="high-second-image" />
                            </a>
                        </div>
                    </div>
                </div>
            </#if>
            <#assign counterNews = counterNews + 1>
        </#list>
    </div>
</div>
<div class="ama-container-fluid bg-news">
    <div class="ama-row">
       <div class="ama-col-md-4 ama-col-xs-12">
            <div class="ama-row carousel-knowledge">
                <#assign counterNews = 0>
                <#list entries as entryNews>
                    <#--assign assetRenderer = entryNews.getAssetRenderer() />
                    <#assign jsonString>
                      <@renderWithTemplate article=assetRenderer.getAssetObject() template="AsJson" />
                    </#assign>

                    <#attempt>
                      <#assign jsonNews = jsonString?eval />
                    <#recover>
                      <#assign jsonNews = jsonFactoryUtil.createJSONObject() />
                    </#attempt-->

                    <#assign docXml = saxReaderUtil.read(entryNews.getAssetRenderer().getArticle().getContent()) />
                    <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign shortDescription = docXml.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign TitoloNewsInHome = docXml.valueOf("//dynamic-element[@name='TitoloNewsInHome']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign image = docXml.valueOf("//dynamic-element[@name='Image']/dynamic-content[@language-id='${locale}']/text()") />

                    <#--assign title = getterUtil.getString(jsonNews.Title) />
                    <#assign shortDescription = getterUtil.getString(jsonNews.ShortDescription) />
                    <#assign image = getterUtil.getString(jsonNews.Image) /-->

                    <#assign
                        entryNews = entry
                        viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews)
                    />
                    <#if assetLinkBehavior != "showFullContent">
                    <#assign viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews, true) />
                    </#if>
                    <#assign viewURLNews = viewURLNews?split("&redirect")[0] />
                    <#if (counterNews gte 2) && (counterNews lte 4)>
                        <#if image!= ''>
                            <div class="ama-col-md-12 ama-col-sm-4 ama-col-xs-12">
                                <a class="box box-xs xs-l box-img" style="background-image: url(${image})" href="${viewURLNews}" title="${title}">
                        <#elseif (image== '' && counterNews == 3)>
                        <div class="ama-col-md-12 ama-col-sm-4 ama-col-xs-12">
                                <a class="box box-xs xs-l" href="${viewURLNews}" title="${title}">
                        <#elseif (image== '' && counterNews != 3)>
                            <div class="ama-col-md-12 ama-col-sm-4 ama-col-xs-12 bg-color">
                                <a class="box box-xs xs-l bg-color" href="${viewURLNews}" title="${title}">
                        </#if>
                            <#if TitoloNewsInHome!= ''>
                                <h2 class="dot-point dot-85 dot-mobile">${TitoloNewsInHome}</h2>
                            <#else>
                                <h2 class="dot-point dot-85 dot-mobile">${title}</h2>
                             </#if>
                             <#if shortDescription!= ''>
                                <p class="dot-point dot-75 dot-mobile">${shortDescription}</p>
                            </#if>
                            </a>
                        </div>
                     </#if>
                    <#assign counterNews = counterNews + 1>
                </#list>
            </div>
        </div>
        <div class="ama-col-md-8 ama-col-xs-12">
            <div class="ama-row carousel-knowledge">
                <#assign counterNews = 0>
                <#list entries as entryNews>

                    <#--assign assetRenderer = entryNews.getAssetRenderer() />
                    <#assign jsonString>
                      <@renderWithTemplate article=assetRenderer.getAssetObject() template="AsJson" />
                    </#assign>

                    <#attempt>
                      <#assign jsonNews = jsonString?eval />
                    <#recover>
                      <#assign jsonNews = jsonFactoryUtil.createJSONObject() />
                    </#attempt-->

                    <#assign docXml = saxReaderUtil.read(entryNews.getAssetRenderer().getArticle().getContent()) />
                    <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign TitoloNewsInHome = docXml.valueOf("//dynamic-element[@name='TitoloNewsInHome']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign shortDescription = docXml.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign image = docXml.valueOf("//dynamic-element[@name='Image']/dynamic-content[@language-id='${locale}']/text()") />

                    <#--assign title = getterUtil.getString(jsonNews.Title) />
                    <#assign shortDescription = getterUtil.getString(jsonNews.ShortDescription) />
                    <#assign image = getterUtil.getString(jsonNews.Image) /-->

                    <#assign
                        entryNews = entry
                        viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews)
                    />
                    <#if assetLinkBehavior != "showFullContent">
                        <#assign viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews, true) />
                    </#if>
                    <#assign viewURLNews = viewURLNews?split("&redirect")[0] />
                    <#--assign Data = docXml.valueOf("//dynamic-element[@name='Date']/dynamic-content/text()") /-->
                    
                    <#if (counterNews gte 5) && (counterNews lte 10)>
                        <#if (counterNews == 5) || (counterNews == 7) || (counterNews == 9)>
                            <div class="ama-col-xs-12">
                                <div class="div-pl">
                                    <#if TitoloNewsInHome!= ''>
                                        <a class="div-row" href="${viewURLNews}" title="${TitoloNewsInHome}">
                                            <p class="blue dot-point max-dot-85 dot-mobile">${TitoloNewsInHome}</p>
                                        </a>
                                    <#else>
                                        <a class="div-row" href="${viewURLNews}" title="${title}">
                                            <p class="blue dot-point max-dot-85 dot-mobile">${title}</p>
                                        </a>
                                    </#if>
                                </div>
                            </div>
                        <#elseif counterNews == 6>
                            <div class="ama-col-xs-12">
                                <div class="div-rt">
                                    <#if TitoloNewsInHome!= ''>
                                        <a class="div-row blue" href="${viewURLNews}" title="${TitoloNewsInHome}">
                                            <p class="white dot-point max-dot-85 dot-mobile">${TitoloNewsInHome}</p>
                                        </a>
                                    <#else>
                                        <a class="div-row blue" href="${viewURLNews}" title="${title}">
                                            <p class="white dot-point max-dot-85 dot-mobile">${title}</p>
                                        </a>
                                    </#if>
                                </div>
                            </div>
                        <#elseif counterNews == 8>
                            <div class="ama-col-xs-12">
                                <div class="div-rt">
                                    <#if TitoloNewsInHome!= ''>
                                        <a class="div-row green" href="${viewURLNews}" title="${TitoloNewsInHome}">
                                            <p class="white dot-point max-dot-85 dot-mobile">${TitoloNewsInHome}</p>
                                        </a>
                                    <#else>
                                        <a class="div-row green" href="${viewURLNews}" title="${title}">
                                            <p class="white dot-point max-dot-85 dot-mobile">${title}</p>
                                        </a>
                                    </#if>
                                </div>
                            </div>
                        <#elseif counterNews == 10>
                        <div class="ama-col-xs-12">
                            <div class="div-rt">
                                <#if TitoloNewsInHome!= ''>
                                    <a class="div-row gradient" href="${viewURLNews}" title="${TitoloNewsInHome}">
                                        <p class="white dot-point max-dot-85 dot-mobile">${TitoloNewsInHome}</p>
                                    </a>
                                <#else>
                                    <a class="div-row gradient" href="${viewURLNews}" title="${title}">
                                        <p class="white dot-point max-dot-85 dot-mobile">${title}</p>
                                    </a>
                                </#if>
                            </div>
                        </div>
                        </#if>
                    </#if>
                    <#assign counterNews = counterNews + 1>
                </#list>
            </div>
        </div>
    </div>
</div>

<#--
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
            <!-- ${article.getArticleId()} render fallito >
        </#attempt>
    <#else>
        <!-- ${article.getArticleId()}  senza template ${template} >
    </#if>
</#macro> -->

</div>

<div id="modalNews" class="modal modal-custom fade modal-icon-page" role="dialog"> 
	<div class="modal-dialog"> 
	 <div class="modal-content"> 
	  <div class="modal-body"> 
		<div class="modal-title-box"> 
			<a href="#" class="icomoon-close-white" data-dismiss="modal"></a> 
			  <div class="title-modal"> 
				<h2 class="title">Esito Aggiornamento</h2> 
			  </div> 
		</div> 
			<h2 id="modaltxt" class="text"> </h2> 
	                                             
	   <div class="ama-row mb-50-xs buttons-bottom"> 
	    
	   </div> 
	  </div> 
	</div> 
  </div> 
</div>
<button class="button button-primary" id="refreshNews" data-toggle="modal" data-target="#modalNews" >Aggiorna</button>

<script>
$('#refreshNews').click("on",function(){
var htmlValue = $('#containerNews').html();
Liferay.Service(
  '/mefwcont.webcontentconfig/web-content-configurator',
    {
    groupid:${groupId},
	html:htmlValue,
	id:${layout.getExpandoBridge().getAttribute("idStaticHomeWebContent")}                                                        
    }, 
  function(obj) {
    $('#modaltxt').text("");
    if(obj == "OK")
      $('#modaltxt').text("aggiornamento effettuato correttamente");

    else
      $('#modaltxt').text("errore durante l'aggiornamento");
  }
);
});
</script>