<#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
<#if !entries?has_content>
    <#if !themeDisplay.isSignedIn()>
        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
    </#if>
</#if>

<div class="primo-piano-wrap">
    <article>
        <div id="carousel">
            <#assign i = 0/>
            <#list entries as entryNews>
              <#if i lte 2>
                <#assign assetRenderer = entryNews.getAssetRenderer() />

                    <#assign docXml = saxReaderUtil.read(entryNews.getAssetRenderer().getArticle().getContent()) />
                    <#assign highlight = docXml.valueOf("//dynamic-element[@name='highlight']/dynamic-content/text()") />
                    <#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
                    <#assign shortDescription = docXml.valueOf("//dynamic-element[@name='ShortDescription']/dynamic-content[@language-id='${locale}']/text()") />

                    <#assign
                        entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
                        viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews)
                    />
                    <#if assetLinkBehavior != "showFullContent">
                        <#assign viewURLNews = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryNews, true) />
                    </#if>
                    <#assign viewURLNews = viewURLNews?split("&redirect")[0] />
                    <#assign image = docXml.valueOf("//dynamic-element[@name='Image']/dynamic-content/text()") />
                    <#assign bigImage = docXml.valueOf("//dynamic-element[@name='BigImage']/dynamic-content/text()") />
                        <div class="slide-primo-piano">
                            <div class="ama-container-fluid">
                                <div class="ama-row">
                                    <div class="ama-col-md-7 pt-50-md pt-30-xs">
                                        <#if title!= ''>
                                            <h1 class="mb-30-sm mb-20-xs dot-point max-dot-150 dot-mobile">${title}</h1>
                                        </#if>
                                        <#if shortDescription != ''>
                                            <h2 class="mb-30-sm mb-15-xs dot-point max-dot-150 dot-mobile">${shortDescription}</h2>
                                        </#if>
                                        <#if viewURLNews != ''>
                                            <a class="button-default" title="<@liferay.language key='find-out-more' />" href="${viewURLNews}"><@liferay.language key="find-out-more" /></a>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                            <#if bigImage != ''>
                                <div class="bg-image" style="background-image: url(${bigImage})"></div>
                            <#else>
                                <div class="bg-image" style="background-image: linear-gradient(279deg, #2b7f8e, #003896);"></div>
                            </#if>
                        </div>
                        <#assign i = i+1/>
                    </#if>
            </#list>
        </div>
        <div class="ama-container-fluid dots-primo-piano"></div>
    </article>
<#--assign VOID = freeMarkerPortletPreferences.setValue("displayStyleGroupId", themeDisplay.getCompanyGroupId()?string)>
    <#assign VOID = freeMarkerPortletPreferences.setValue("displayStyle", "ddmTemplate_105108")>

        <@liferay_portlet["runtime"]
          defaultPreferences="${freeMarkerPortletPreferences}"
          instanceId="scrivania-service-widget"
          portletProviderAction=portletProviderAction.VIEW
          portletProviderClassName="com.liferay.asset.kernel.model.AssetEntry"
        />
        <#assign VOID = freeMarkerPortletPreferences.reset()-->
</div>


<button class="button button-primary" id="createHtml">Create html</button>
      <textarea class="textarea-white" id="html-viewer" readonly style="display:none">
      </textarea>

<script>
function sethtmlConvenzioni(){
    $('#carousel').addClass('carousel-primo-piano');
    var htmlcode= $('article').parent().html();
      $('#html-viewer').text('');
      $('#html-viewer').text(htmlcode);
      $("#html-viewer").removeAttr("style");
}
$('#createHtml').click("on",function(){
    sethtmlConvenzioni();
});



</script>
